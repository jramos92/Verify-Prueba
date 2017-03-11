package com.veryfit.multi.ui.fragment.firstbound;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.BindUnbindCmd;
import com.project.library.device.cmd.health.HealthSyncRequest;
import com.project.library.entity.BleDevice;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.BleScanTool;
import com.project.library.util.BleScanTool.ScanDeviceListener;
import com.project.library.util.DebugLog;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.HttpUtil;
import com.veryfit.multi.vo.json.DeviceUpdateInfo;
import com.veryfit.multi.vo.json.DeviceUpdateList;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuService;

public class DfuActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final UUID DFU_SERVICE_UUID = new UUID(23296205844446L, 1523193452336828707L);
  private static final int REUPDATEE_MAX_COUNT = 7;
  public static final UUID RX_SERVICE_UUID = UUID.fromString("00000af0-0000-1000-8000-00805f9b34fb");
  private static final int UPDATE_CMD_FAILED = 11;
  private static final int UPDATE_CMD_RESULT = 10;
  private static final int UPDATE_FAILED = 12;
  private static int mProcess;
  private static boolean updating;
  private Dialog bleEnabledialog;
  private TextView currentVersion;
  private String deviceAddr;
  private int deviceId;
  private String deviceName;
  private int device_id;
  private int device_version;
  private JsonObject errorJson;
  private int failed_code;
  private int failed_count;
  private int failed_reason;
  private String filePath;
  private final UpdateHandler handler = new UpdateHandler(this);
  private int i = 0;
  private boolean isStartWareUpdateService = false;
  private boolean isUpdate = true;
  private boolean isUpdateComplete = false;
  private boolean isUpdateSuccess = false;
  private boolean isupdat = false;
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected()
    {
      DfuActivity.d("onBLEConnected");
      Log.d("mAppListener", "onBLEConnected执行了。。。。。");
      DfuActivity.this.mCore.writeForce(BindUnbindCmd.getInstance().getBindCmd());
    }
    
    public void onBLEDisConnected(String paramAnonymousString)
    {
      Log.d("mAppListener", "onBLEDisConnected执行了。。。。。");
      DfuActivity.d("onBLEDisConnected");
      DfuActivity.this.isupdat = true;
      DfuActivity.this.mPb_updown.setProgress(0);
      DfuActivity.this.progressView.setText(2131296493);
      DfuActivity.this.update.setEnabled(true);
    }
    
    public void onBindUnbind(byte paramAnonymousByte)
    {
      DfuActivity.d("onBindUnbind");
      if (paramAnonymousByte == 18)
      {
        Log.e("mAppListener", "STATUS_BIND_SUCCESS。。。。。");
        AppSharedPreferences.getInstance().setBindDeviceAddr(DfuActivity.this.deviceAddr);
        AppSharedPreferences.getInstance().setBindDeviceName(DfuActivity.this.deviceName);
        DfuActivity.this.setResult(101);
        DfuActivity.this.finish();
      }
    }
    
    public void onWareUpdate(byte paramAnonymousByte)
    {
      DfuActivity.d("onWareUpdate");
      Log.d("mAppListener", "onWareUpdate执行了。。。。。");
    }
  };
  private AppSharedPreferences mAppSharePreFerences = AppSharedPreferences.getInstance();
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  private CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private final BroadcastReceiver mDfuUpdateReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      DebugLog.d("*****" + paramAnonymousContext);
      if ("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS".equals(paramAnonymousContext))
      {
        int i = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0);
        int j = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 1);
        int k = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 1);
        DfuActivity.this.updateProgressBar(i, j, k, false, false);
      }
      do
      {
        return;
        if ("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR".equals(paramAnonymousContext))
        {
          DfuActivity.this.isUpdate = false;
          DfuActivity.this.showUpdateFaildTip(paramAnonymousIntent);
          DfuActivity.this.updateFaild();
          return;
        }
      } while (!"com.veryfit.multi.ACTION_SINGLE_BANK_WARE_UPDATE".equals(paramAnonymousContext));
      DfuActivity.this.showUpdateFaildTip(paramAnonymousIntent);
      DfuActivity.this.updateFaild();
    }
  };
  private Handler mHandler = new Handler();
  private ProgressBar mPb_updown;
  private BleScanTool.ScanDeviceListener mScanDeviceListener = new BleScanTool.ScanDeviceListener()
  {
    private void close()
    {
      if (DfuActivity.this.sTool.isScanning()) {
        DfuActivity.this.sTool.scanLeDeviceDFU(false);
      }
    }
    
    public void onFind(BleDevice paramAnonymousBleDevice)
    {
      DfuActivity.d("onFind....device.mDeviceAddress:" + paramAnonymousBleDevice.mDeviceAddress);
      DebugLog.d("onFind----->addr:" + AppSharedPreferences.getInstance().getBindDeviceAddr());
      DebugLog.d("onFind----->deviceAddr:" + DfuActivity.this.deviceAddr);
      if ((paramAnonymousBleDevice.mId == 10) && (paramAnonymousBleDevice.mIs == 240) && (paramAnonymousBleDevice.mLen == 13) && (!TextUtils.isEmpty(DfuActivity.this.deviceAddr)) && (paramAnonymousBleDevice.mDeviceAddress.equals(DfuActivity.this.deviceAddr)))
      {
        DebugLog.d("-----------------------扫描成功 -----------------------");
        DfuActivity.this.startDfuService();
        close();
      }
    }
    
    public void onFinish()
    {
      DebugLog.d("onFinish----->startDfuService");
      DfuActivity.this.startDfuService();
    }
  };
  private TextView newVersion;
  private TextView progressView;
  private boolean restarUpdate = false;
  private BleScanTool sTool = BleScanTool.getInstance();
  public Timer timerListenerBlueeth;
  private Button update;
  private int updateCount = 0;
  private TextView updateDetail;
  private DeviceUpdateInfo updateInfo;
  
  private static void d(String paramString)
  {
    DebugLog.d("----------->" + paramString);
  }
  
  private void downFile()
  {
    File localFile = new File(Constant.FILE_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!new File(this.filePath).exists())
    {
      new Thread()
      {
        public void run()
        {
          HttpUtil.downLoad(DfuActivity.this.handler, DfuActivity.this.filePath, DfuActivity.this.updateInfo.file);
        }
      }.start();
      return;
    }
    startWareUpdateService();
  }
  
  private void getDeviceUpdateInfo()
  {
    if (HttpUtil.isNetworkConnected(this)) {
      new Thread(new Runnable()
      {
        public void run()
        {
          Object localObject2 = HttpUtil.get("http://www.youduoyun.com/apps/firmwares/firmware.json", null);
          try
          {
            Object localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
            if (localObject2 != null)
            {
              localObject2 = new TypeToken() {}.getType();
              localObject1 = (DeviceUpdateList)new Gson().fromJson((String)localObject1, (Type)localObject2);
              if ((localObject1 != null) && (!((DeviceUpdateList)localObject1).firmwareInfo.isEmpty()))
              {
                Log.d("deviceId", DfuActivity.this.deviceId);
                DfuActivity.this.updateInfo = ((DeviceUpdateList)localObject1).getMyDevice(DfuActivity.this.deviceId);
                if (DfuActivity.this.updateInfo != null)
                {
                  DfuActivity.this.device_id = DfuActivity.this.updateInfo.device_id;
                  DfuActivity.this.device_version = DfuActivity.this.updateInfo.version;
                  DfuActivity.this.runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      int j = LibSharedPreferences.getInstance().getDeviceFirmwareVersion();
                      int i = j;
                      if (j == 0) {
                        i = 1;
                      }
                      DfuActivity.this.currentVersion.setText(i);
                      DfuActivity.this.newVersion.setText(DfuActivity.this.updateInfo.version);
                      TextView localTextView = DfuActivity.this.updateDetail;
                      DfuActivity localDfuActivity = DfuActivity.this;
                      if (DfuActivity.this.getResources().getConfiguration().locale.toString().contains("zh")) {}
                      for (String str = DfuActivity.this.updateInfo.info_ch;; str = DfuActivity.this.updateInfo.info_en)
                      {
                        localTextView.setText(localDfuActivity.getString(2131296484, new Object[] { str }));
                        return;
                      }
                    }
                  });
                }
              }
            }
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }).start();
    }
  }
  
  private void judgeService()
  {
    d("judgeService");
    if (!BleScanTool.getInstance().isBluetoothOpen())
    {
      d("isBluetoothOpen false");
      showBleEnableDialog();
    }
    do
    {
      return;
      d("scanLeDeviceByService true");
      this.sTool.scanLeDeviceDFU(false);
    } while (this.sTool.isScanning());
    this.sTool.scanLeDeviceDFU(true);
    this.sTool.scanLeDeviceByService(true, DFU_SERVICE_UUID);
  }
  
  private IntentFilter makeDfuUpdateIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
    localIntentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
    localIntentFilter.addAction("com.veryfit.multi.ACTION_SINGLE_BANK_WARE_UPDATE");
    return localIntentFilter;
  }
  
  private void scanDevice(boolean paramBoolean)
  {
    this.sTool.scanLeDeviceByService(paramBoolean, RX_SERVICE_UUID);
  }
  
  private void showUpdateFaildTip(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", -1);
    int k = paramIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", -1);
    DebugLog.d("*****EXTRA_DATA:" + paramIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", -1));
    DebugLog.d("*****EXTRA_ERROR_TYPE:" + paramIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", -1));
    DebugLog.d("*****EXTRA_DEVICE_ADDRESS:" + paramIntent.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS"));
    this.failed_code = k;
    this.failed_reason = j;
    d("showUpdateFaildTip  data:" + j);
  }
  
  private void startDfuService()
  {
    d("startDfuService");
    Intent localIntent = new Intent(this, DfuService.class);
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.deviceAddr);
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", "DfuTarg");
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH", this.filePath);
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
    startService(localIntent);
  }
  
  private void startWareUpdateService()
  {
    if (!BleScanTool.getInstance().isBluetoothOpen())
    {
      d("isBluetoothOpen:false");
      this.update.setEnabled(true);
      this.progressView.setText(2131296574);
      showBleEnableDialog();
      return;
    }
    d("isBluetoothOpen:true");
    d("mCore.isDeviceConnected():" + this.mCore.isDeviceConnected());
    if (TextUtils.isEmpty(this.deviceAddr))
    {
      DebugLog.e("设备都没有，不升级");
      return;
    }
    DebugLog.e("开始升级");
    startDfuService();
  }
  
  private void toast(String paramString)
  {
    Toast.makeText(this, paramString, 0).show();
  }
  
  private void updateFaild()
  {
    byte b = 0;
    if (this.isUpdateSuccess) {}
    do
    {
      return;
      d("升级失败次数:" + this.updateCount);
      this.updateCount += 1;
      this.mPb_updown.setProgress(0);
      this.progressView.setText(2131296488);
      if (this.updateCount <= 7) {
        break;
      }
      this.progressView.setText(2131296493);
      this.update.setEnabled(true);
    } while (this.failed_reason == 4106);
    toast("升级失败");
    HttpUtil.postUpdateNote(this, this.device_id, this.device_version, this.updateCount, this.failed_code, this.failed_reason);
    return;
    if (this.failed_reason == 4102)
    {
      if (this.mCore.isDeviceConnected())
      {
        LibSharedPreferences.getInstance().setSyncData(true);
        if (AppSharedPreferences.getInstance().getSyncHealdataMode()) {
          b = 1;
        }
        this.mCore.writeForce(HealthSyncRequest.getInstance().getHealthSyncRequestCmd((byte)1, b));
        return;
      }
      DebugLog.d("设备未连接");
      this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
      return;
    }
    judgeService();
  }
  
  private void updateProgressBar(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    default: 
      if (!paramBoolean1)
      {
        this.update.setEnabled(false);
        this.progressView.setText(getString(2131296486, new Object[] { Integer.valueOf(paramInt1) }));
        this.mPb_updown.setProgress(paramInt1);
      }
    case -7: 
    case -4: 
    case -3: 
      return;
    case -1: 
      this.isUpdate = true;
      this.progressView.setText(2131296488);
      this.restarUpdate = true;
      this.isUpdateComplete = false;
      this.handler.removeMessages(12);
      return;
    case -2: 
      this.progressView.setText(2131296487);
      this.mPb_updown.setProgress(0);
      return;
    case -5: 
      d("PROGRESS_DISCONNECTING");
      this.progressView.setText(2131296488);
      this.mPb_updown.setProgress(0);
      return;
    }
    this.handler.removeMessages(12);
    this.isUpdateSuccess = true;
    this.isUpdate = false;
    updating = false;
    this.progressView.setText(2131296490);
    stopService(new Intent(this, DfuService.class));
    Object localObject = getSharedPreferences("veryfit_multi_app", 0);
    paramInt1 = ((SharedPreferences)localObject).getInt("ota_repeat_count", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("ota_repeat_count", paramInt1 + 1);
    ((SharedPreferences.Editor)localObject).commit();
    HttpUtil.postUpdateNote(getApplicationContext(), this.device_id, this.device_version, this.updateCount, 0, 0);
    this.mPb_updown.setProgress(100);
    this.update.setVisibility(0);
    this.isUpdateComplete = true;
    new File(this.filePath).delete();
    LibSharedPreferences.getInstance().setDeviceFirmwareVersion(this.updateInfo.version);
    setResult(101);
    finish();
  }
  
  protected void initView()
  {
    this.progressView = ((TextView)findViewById(2131230757));
    this.update = ((Button)findViewById(2131230755));
    this.currentVersion = ((TextView)findViewById(2131230749));
    this.newVersion = ((TextView)findViewById(2131230751));
    this.updateDetail = ((TextView)findViewById(2131230752));
    this.mPb_updown = ((ProgressBar)findViewById(2131230756));
    this.update.setOnClickListener(this);
    getDeviceUpdateInfo();
    LocalBroadcastManager localLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
    this.mCore.addListener(this.mAppListener);
    localLocalBroadcastManager.registerReceiver(this.mDfuUpdateReceiver, makeDfuUpdateIntentFilter());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131230729: 
    default: 
      return;
    }
    updating = true;
    this.updateCount = 0;
    this.update.setEnabled(false);
    this.isUpdateSuccess = false;
    this.updateCount = 1;
    this.mPb_updown.setProgress(0);
    downFile();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903047);
    super.onCreate(paramBundle);
    this.sTool.addScanDeviceListener(this.mScanDeviceListener);
    paramBundle = getIntent().getExtras();
    this.deviceId = paramBundle.getInt("deviceId");
    this.deviceAddr = paramBundle.getString("deviceAddr");
    this.deviceName = paramBundle.getString("deviceName");
    this.filePath = (Constant.FILE_PATH + "update_" + this.deviceId + ".zip");
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDfuUpdateReceiver);
    this.mCore.removeListener(this.mAppListener);
    this.sTool.removeScanDeviceListener(this.mScanDeviceListener);
    DebugLog.e("关闭升级模式。。");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!this.isUpdate) {
        finish();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onThemeChanged() {}
  
  public void showBleEnableDialog()
  {
    if (this.bleEnabledialog == null)
    {
      this.bleEnabledialog = new Dialog(this, 2131427337);
      this.bleEnabledialog.setContentView(2130903079);
      this.bleEnabledialog.getWindow().setGravity(17);
      this.bleEnabledialog.setCancelable(false);
    }
    if (this.bleEnabledialog.isShowing()) {
      return;
    }
    Button localButton1 = (Button)this.bleEnabledialog.findViewById(2131230927);
    Button localButton2 = (Button)this.bleEnabledialog.findViewById(2131230928);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DfuActivity.this.mPb_updown.setProgress(0);
        DfuActivity.this.progressView.setText("");
        DfuActivity.this.update.setEnabled(true);
        DfuActivity.this.bleEnabledialog.dismiss();
      }
    });
    localButton2.setOnClickListener(new OpenBluetoothListener(null));
    this.bleEnabledialog.show();
  }
  
  private class BlueToothTask
    extends TimerTask
  {
    private BlueToothTask() {}
    
    public void run()
    {
      if (BleScanTool.getInstance().isBluetoothOpen())
      {
        DfuActivity.d("BlueToothTask bluetooth is open");
        DfuActivity.this.timerListenerBlueeth.cancel();
        DfuActivity.this.timerListenerBlueeth = null;
        DfuActivity.this.judgeService();
      }
    }
  }
  
  private class OpenBluetoothListener
    implements View.OnClickListener
  {
    private OpenBluetoothListener() {}
    
    public void onClick(View paramView)
    {
      DfuActivity.this.bleEnabledialog.dismiss();
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.enable()))
      {
        DfuActivity.d("onClick BleScanTool.getInstance().isBluetoothOpen():" + BleScanTool.getInstance().isBluetoothOpen());
        DfuActivity.this.timerListenerBlueeth = new Timer();
        paramView = new DfuActivity.BlueToothTask(DfuActivity.this, null);
        DfuActivity.this.timerListenerBlueeth.schedule(paramView, 0L, 100L);
        DfuActivity.this.updateCount = 1;
        return;
      }
      Toast.makeText(DfuActivity.this, 2131296523, 1).show();
    }
  }
  
  private static class UpdateHandler
    extends Handler
  {
    WeakReference<DfuActivity> weak;
    
    public UpdateHandler(DfuActivity paramDfuActivity)
    {
      this.weak = new WeakReference(paramDfuActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      DfuActivity localDfuActivity = (DfuActivity)this.weak.get();
      if (localDfuActivity == null) {}
      for (;;)
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          int i = ((Integer)paramMessage.obj).intValue();
          DfuActivity.mProcess = i;
          localDfuActivity.progressView.setText(localDfuActivity.getString(2131296485, new Object[] { Integer.valueOf(i) }));
          localDfuActivity.mPb_updown.setProgress(i);
          if (i == 100) {
            try
            {
              Thread.sleep(1000L);
              if (!localDfuActivity.isStartWareUpdateService)
              {
                localDfuActivity.startWareUpdateService();
                localDfuActivity.isStartWareUpdateService = true;
                return;
              }
            }
            catch (InterruptedException paramMessage)
            {
              paramMessage.printStackTrace();
              return;
            }
          }
          break;
        }
      }
      localDfuActivity.update.setEnabled(true);
      DfuActivity.updating = false;
      Toast.makeText(localDfuActivity, 2131296402, 0).show();
      return;
      localDfuActivity.update.setEnabled(true);
      DfuActivity.updating = false;
      return;
      localDfuActivity.update.setVisibility(0);
      localDfuActivity.stopService(new Intent(localDfuActivity, DfuService.class));
      new File(localDfuActivity.filePath).delete();
      localDfuActivity.update.setEnabled(true);
      DfuActivity.updating = false;
      localDfuActivity.mPb_updown.setProgress(0);
      return;
      switch (((Byte)paramMessage.obj).byteValue())
      {
      default: 
        return;
      case 0: 
        DebugLog.e("准备升级喽");
        Log.d("DfeActivity", "准备升级喽");
        return;
      case 1: 
        localDfuActivity.update.setEnabled(true);
        DfuActivity.updating = false;
        return;
      }
      localDfuActivity.update.setEnabled(true);
      DfuActivity.updating = false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\DfuActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */