package com.veryfit.multi.ui.fragment.main;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.BindUnbindCmd;
import com.project.library.device.cmd.appcontrol.AppControlCmd;
import com.project.library.device.cmd.getinfo.BatteryInfos;
import com.project.library.device.cmd.getinfo.GetInfoCmd;
import com.project.library.device.cmd.settings.AntilostInfos;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DebugLog;
import com.veryfit.multi.VeryFitApplication;
import com.veryfit.multi.base.BaseFragment;
import com.veryfit.multi.service.AntilostService;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.MainActivity;
import com.veryfit.multi.ui.activity.device.AddDeviceActivity;
import com.veryfit.multi.ui.activity.device.CameraActivity;
import com.veryfit.multi.ui.activity.device.DeviceUpdateActivity;
import com.veryfit.multi.util.HttpUtil;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.view.CustomRadioGroup;
import com.veryfit.multi.view.DialogUtil;
import com.veryfit.multi.view.DialogUtil.OnUnBoundDeviceListener;
import com.veryfit.multi.view.group.ItemLableValue;
import com.veryfit.multi.view.group.ItemToggleLayout;
import com.veryfit.multi.view.group.ItemToggleLayout.OnToggleListener;
import com.veryfit.multi.vo.json.DeviceUpdateInfo;
import com.veryfit.multi.vo.json.DeviceUpdateList;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.List;
import java.util.Locale;

public class DeviceFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private static final int REQUEST_BIND_DEVICE = 2;
  private static final int REQUEST_CLOSE_TACKEMODE = 3;
  private static final int REQUEST_UPDATE_DEVICE = 1;
  protected static final long delayMillis = 3000L;
  private TextView app_version;
  private TextView battery;
  private TextView deviceName;
  private TextView deviceVersion;
  private ItemLableValue device_update;
  private Dialog dialog;
  private ItemToggleLayout found_phone;
  private Handler handler = new Handler();
  private ItemLableValue intelligent_remind;
  private boolean isPrepared = false;
  private boolean isReStart = false;
  private long lastClickUnbindTime = 0L;
  private MainActivity mActivity;
  private AntiLossRunnable mAntiLossRunnable = null;
  protected APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected() {}
    
    public void onBLEDisConnected(String paramAnonymousString) {}
    
    public void onBindUnbind(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 18)
      {
        DebugLog.e("绑定成功");
        DeviceFragment.this.getDeviceUpdateInfo();
      }
      for (;;)
      {
        DeviceFragment.this.updateBindTextInfo();
        return;
        if (paramAnonymousByte == 20)
        {
          DebugLog.e("解绑成功");
          DeviceFragment.this.mCore.removeListener(this);
          TempUtil.clearDataAfterUnbind();
          AppSharedPreferences.getInstance().setBindDeviceAddr("");
          Toast.makeText(DeviceFragment.this.getActivity(), 2131296439, 0).show();
          DeviceFragment.this.startActivityForResult(new Intent(DeviceFragment.this.getActivity(), AddDeviceActivity.class), 2);
        }
      }
    }
    
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte) {}
    
    public void onGetInfo(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 1) {
        DeviceFragment.this.updateTitle();
      }
      do
      {
        do
        {
          return;
        } while ((paramAnonymousByte != 2) || (!DeviceFragment.this.isReStart));
        DeviceFragment.this.isReStart = false;
      } while ((MainActivity)DeviceFragment.this.getActivity() == null);
      ((MainActivity)DeviceFragment.this.getActivity()).onDeviceNeedInit();
      ((MainActivity)DeviceFragment.this.getActivity()).mTabGroup.check(2131231104);
      ((MainActivity)DeviceFragment.this.getActivity()).onCheckedChanged(((MainActivity)DeviceFragment.this.getActivity()).mTabGroup, 2131231104);
    }
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      Intent localIntent;
      if (paramAnonymousByte == 33) {
        if (paramAnonymousBoolean)
        {
          if (DeviceFragment.this.mAntiLossRunnable != null) {
            DeviceFragment.this.handler.removeCallbacks(DeviceFragment.this.mAntiLossRunnable);
          }
          if (DeviceFragment.this.toggle_Antilost.isOpen())
          {
            localIntent = new Intent(DeviceFragment.this.getActivity(), AntilostService.class);
            DeviceFragment.this.getActivity().startService(localIntent);
            DeviceFragment.this.toggle_Antilost.cancelProgressBar();
          }
        }
      }
      do
      {
        return;
        localIntent = new Intent(DeviceFragment.this.getActivity(), AntilostService.class);
        DeviceFragment.this.getActivity().stopService(localIntent);
        break;
        AppSharedPreferences.getInstance().setAntilost(0);
        DeviceFragment.this.toggle_Antilost.setOpen(false);
        break;
        if (paramAnonymousByte == 38)
        {
          if (paramAnonymousBoolean) {
            if (DeviceFragment.this.mFindPhoneRunnable != null) {
              DeviceFragment.this.handler.removeCallbacks(DeviceFragment.this.mFindPhoneRunnable);
            }
          }
          for (;;)
          {
            DeviceFragment.this.found_phone.cancelProgressBar();
            return;
            AppSharedPreferences.getInstance().setDeviceFoundPhoneSwitch(false);
            DeviceFragment.this.found_phone.setOpen(false);
          }
        }
      } while (paramAnonymousByte != 40);
      if (paramAnonymousBoolean) {
        if (DeviceFragment.this.mLiftWristRunnable != null) {
          DeviceFragment.this.handler.removeCallbacks(DeviceFragment.this.mLiftWristRunnable);
        }
      }
      for (;;)
      {
        DeviceFragment.this.notice_lift_wrist.cancelProgressBar();
        return;
        AppSharedPreferences.getInstance().setLiftWristSwitch(false);
        DeviceFragment.this.notice_lift_wrist.setOpen(false);
      }
    }
  };
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private FindPhoneRunnable mFindPhoneRunnable = null;
  private LiftWristRunnable mLiftWristRunnable = null;
  private View mRootView = null;
  private int mVersion;
  private ItemToggleLayout notice_lift_wrist;
  private ItemLableValue remind_alarm;
  private ItemLableValue remind_phone;
  private ItemLableValue remind_sport;
  private AppSharedPreferences share = AppSharedPreferences.getInstance();
  private TextView syncTime;
  private ItemToggleLayout toggle_Antilost;
  private ItemToggleLayout toggle_msg;
  private TextView unbind;
  private DeviceUpdateInfo updateInfo;
  
  private void getBaseDeviceInfo()
  {
    if (this.mCore.isDeviceConnected()) {
      this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
    }
    do
    {
      return;
      this.isReStart = false;
    } while ((MainActivity)getActivity() == null);
    ((MainActivity)getActivity()).onDeviceNeedInit();
    ((MainActivity)getActivity()).mTabGroup.check(2131231104);
    ((MainActivity)getActivity()).onCheckedChanged(((MainActivity)getActivity()).mTabGroup, 2131231104);
  }
  
  private void getDeviceUpdateInfo()
  {
    if (getActivity() != null)
    {
      if ((!HttpUtil.isNetworkConnected(getActivity())) || (this.share.getBindDeviceAddr().equals(""))) {
        break label45;
      }
      new Thread()
      {
        public void run()
        {
          String str = HttpUtil.get("http://www.youduoyun.com/apps/firmwares/firmware.json", null);
          Object localObject1 = "";
          try
          {
            localObject3 = URLDecoder.decode(str, "UTF-8");
            localObject1 = localObject3;
          }
          catch (Exception localException2)
          {
            try
            {
              Object localObject3 = new TypeToken() {}.getType();
              localObject1 = (DeviceUpdateList)new Gson().fromJson((String)localObject1, (Type)localObject3);
              if ((localObject1 == null) || (((DeviceUpdateList)localObject1).firmwareInfo.isEmpty())) {
                break label218;
              }
              DeviceFragment.this.updateInfo = ((DeviceUpdateList)localObject1).getMyDevice(LibSharedPreferences.getInstance().getDeviceId());
              if (DeviceFragment.this.updateInfo == null) {
                break label218;
              }
              DeviceFragment.this.mVersion = DeviceFragment.this.updateInfo.version;
              DebugLog.e("LibSharedPreferences.getInstance().getDeviceFirmwareVersion():--" + LibSharedPreferences.getInstance().getDeviceFirmwareVersion());
              DebugLog.e("updateInfo.version:--" + DeviceFragment.this.updateInfo.version);
              DebugLog.e("getDeviceId:--" + LibSharedPreferences.getInstance().getDeviceId());
              int i = LibSharedPreferences.getInstance().getDeviceFirmwareVersion();
              if (DeviceFragment.this.updateInfo.version <= i) {
                break label237;
              }
              DeviceFragment.this.openDeviceUpdate();
              label218:
              return;
              localException2 = localException2;
              localException2.printStackTrace();
            }
            catch (Exception localException1)
            {
              label237:
              do
              {
                for (;;)
                {
                  localException1.printStackTrace();
                  Object localObject2 = null;
                }
              } while (DeviceFragment.this.getActivity() == null);
              DeviceFragment.this.getActivity().runOnUiThread(new Runnable()
              {
                public void run()
                {
                  if (DeviceFragment.this.device_update != null)
                  {
                    if (DeviceFragment.this.getResources().getConfiguration().locale.getCountry().equals("PL")) {
                      DeviceFragment.this.device_update.setValueState(false, "V: " + DeviceFragment.this.mVersion);
                    }
                  }
                  else {
                    return;
                  }
                  DeviceFragment.this.device_update.setValueState(false, String.format(VeryFitApplication.getInstance().getString(2131296432), new Object[] { Integer.valueOf(DeviceFragment.this.mVersion) }));
                }
              });
            }
          }
          if (str != null) {}
        }
      }.start();
    }
    label45:
    while (getActivity() == null) {
      return;
    }
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (DeviceFragment.this.device_update != null)
        {
          if (DeviceFragment.this.getResources().getConfiguration().locale.getCountry().equals("PL")) {
            DeviceFragment.this.device_update.setValueState(false, "V: " + LibSharedPreferences.getInstance().getDeviceFirmwareVersion());
          }
        }
        else {
          return;
        }
        DeviceFragment.this.device_update.setValueState(false, String.format(VeryFitApplication.getInstance().getString(2131296432), new Object[] { Integer.valueOf(LibSharedPreferences.getInstance().getDeviceFirmwareVersion()) }));
      }
    });
  }
  
  private void initFun()
  {
    int i = LibSharedPreferences.getInstance().getDeviceFunControl();
    if (i == -1) {
      this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
    }
    Object localObject = this.mRootView.findViewById(2131230992);
    if ((i & 0x1) == 1)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      ((View)localObject).setOnClickListener(this);
      i = LibSharedPreferences.getInstance().getDeviceCallNotify();
      localObject = this.remind_phone;
      if ((i & 0x1) != 1) {
        break label333;
      }
      i = 0;
      label82:
      ((ItemLableValue)localObject).setVisibility(i);
      int j = LibSharedPreferences.getInstance().getDeviceFunOtherNotify();
      localObject = this.remind_sport;
      if ((j & 0x1) != 1) {
        break label339;
      }
      i = 0;
      label110:
      ((ItemLableValue)localObject).setVisibility(i);
      localObject = this.toggle_Antilost;
      if ((j >> 1 & 0x1) != 1) {
        break label345;
      }
      i = 0;
      label133:
      ((ItemToggleLayout)localObject).setVisibility(i);
      i = LibSharedPreferences.getInstance().getDeviceFunMain();
      localObject = this.device_update;
      if ((i >> 4 & 0x1) != 1) {
        break label351;
      }
      i = 0;
      label163:
      ((ItemLableValue)localObject).setVisibility(i);
      i = LibSharedPreferences.getInstance().getDeviceAlarmMaxCount();
      if (i != 0) {
        break label357;
      }
      this.remind_alarm.setVisibility(8);
      label189:
      int k = LibSharedPreferences.getInstance().getDeviceFunMsgNotify();
      localObject = this.toggle_msg;
      if ((k & 0x1) != 1) {
        break label380;
      }
      i = 0;
      label211:
      ((ItemToggleLayout)localObject).setVisibility(i);
      localObject = this.found_phone;
      if ((j & 0x8) >> 3 != 1) {
        break label386;
      }
      i = 0;
      label235:
      ((ItemToggleLayout)localObject).setVisibility(i);
      localObject = this.notice_lift_wrist;
      if ((j & 0x40) >> 6 != 1) {
        break label392;
      }
      i = 0;
      label260:
      ((ItemToggleLayout)localObject).setVisibility(i);
      i = LibSharedPreferences.getInstance().getDeviceFunMsgNotify2();
      if (((k & 0xFE) <= 0) || (i <= 0)) {
        break label398;
      }
      this.intelligent_remind.setVisibility(0);
      label293:
      localObject = this.mRootView.findViewById(2131230997);
      if (!LibSharedPreferences.getInstance().getDeviceFunOther2LeftRightMode()) {
        break label410;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      DebugLog.d("已经刷新了功能表");
      return;
      i = 8;
      break;
      label333:
      i = 8;
      break label82;
      label339:
      i = 8;
      break label110;
      label345:
      i = 8;
      break label133;
      label351:
      i = 8;
      break label163;
      label357:
      if (i != -1) {
        break label189;
      }
      this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
      break label189;
      label380:
      i = 8;
      break label211;
      label386:
      i = 8;
      break label235;
      label392:
      i = 8;
      break label260;
      label398:
      this.intelligent_remind.setVisibility(8);
      break label293;
      label410:
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void initView()
  {
    this.remind_phone = ((ItemLableValue)this.mRootView.findViewById(2131230981));
    this.remind_alarm = ((ItemLableValue)this.mRootView.findViewById(2131230983));
    this.remind_sport = ((ItemLableValue)this.mRootView.findViewById(2131230982));
    this.toggle_Antilost = ((ItemToggleLayout)this.mRootView.findViewById(2131230995));
    this.toggle_msg = ((ItemToggleLayout)this.mRootView.findViewById(2131230984));
    this.found_phone = ((ItemToggleLayout)this.mRootView.findViewById(2131230996));
    this.notice_lift_wrist = ((ItemToggleLayout)this.mRootView.findViewById(2131230994));
    this.deviceName = ((TextView)this.mRootView.findViewById(2131230919));
    this.syncTime = ((TextView)this.mRootView.findViewById(2131230920));
    this.deviceVersion = ((TextView)this.mRootView.findViewById(2131230921));
    this.battery = ((TextView)this.mRootView.findViewById(2131230922));
    this.app_version = ((TextView)this.mRootView.findViewById(2131230733));
    this.intelligent_remind = ((ItemLableValue)this.mRootView.findViewById(2131230991));
    if (getResources().getConfiguration().locale.getCountry().equals("PL"))
    {
      this.app_version.setVisibility(8);
      this.device_update = ((ItemLableValue)this.mRootView.findViewById(2131230898));
      this.unbind = ((TextView)this.mRootView.findViewById(2131230998));
      this.unbind.setOnClickListener(this);
      initFun();
      if (1 != AppSharedPreferences.getInstance().getAntilost()) {
        break label405;
      }
      this.toggle_Antilost.setOpen(true);
      label316:
      this.toggle_Antilost.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          DeviceFragment.this.setAntiLossAlert(paramAnonymousBoolean);
        }
      });
      if (!AppSharedPreferences.getInstance().getDeviceMsgNoticeSwitch()) {
        break label416;
      }
      this.toggle_msg.setOpen(true);
    }
    for (;;)
    {
      this.toggle_msg.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            AppSharedPreferences.getInstance().setDeviceMsgNoticeSwitch(true);
            return;
          }
          AppSharedPreferences.getInstance().setDeviceMsgNoticeSwitch(false);
        }
      });
      this.found_phone.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          DeviceFragment.this.setFindPhone(paramAnonymousBoolean);
        }
      });
      this.notice_lift_wrist.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          DeviceFragment.this.setLiftWrist(paramAnonymousBoolean);
        }
      });
      return;
      this.app_version.setVisibility(0);
      break;
      label405:
      this.toggle_Antilost.setOpen(false);
      break label316;
      label416:
      this.toggle_msg.setOpen(false);
    }
  }
  
  private void jumpToMain()
  {
    if ((MainActivity)getActivity() != null)
    {
      ((MainActivity)getActivity()).onDeviceNeedInit();
      if (((MainActivity)getActivity()).mTabGroup != null)
      {
        ((MainActivity)getActivity()).mTabGroup.check(2131231104);
        ((MainActivity)getActivity()).onCheckedChanged(((MainActivity)getActivity()).mTabGroup, 2131231104);
      }
    }
  }
  
  private void onUnbindTextClick()
  {
    if (this.mCore.isAvailable())
    {
      if (this.share.getBindDeviceAddr().equals(""))
      {
        AppSharedPreferences.getInstance().setBindDeviceName("");
        startActivityForResult(new Intent(getActivity(), AddDeviceActivity.class), 2);
      }
    }
    else {
      return;
    }
    if (this.mCore.isDeviceConnected())
    {
      this.mCore.writeForce(BindUnbindCmd.getInstance().getUnbindCmd());
      return;
    }
    DialogUtil.showForceUnbindDialog(getActivity(), this);
  }
  
  private void openDeviceUpdate()
  {
    if (getActivity() != null) {
      getActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          DeviceFragment.this.device_update.setOnClickListener(DeviceFragment.this);
          DeviceFragment.this.device_update.setValueState(true, VeryFitApplication.getInstance().getString(2131296451));
        }
      });
    }
  }
  
  private void setAntiLossAlert(final boolean paramBoolean)
  {
    int j = 1;
    if (this.mCore.isDeviceConnected())
    {
      AntilostInfos localAntilostInfos = new AntilostInfos();
      AppSharedPreferences localAppSharedPreferences;
      if (paramBoolean)
      {
        i = 1;
        localAntilostInfos.mode = i;
        localAppSharedPreferences = AppSharedPreferences.getInstance();
        if (!paramBoolean) {
          break label119;
        }
      }
      label119:
      for (int i = j;; i = 0)
      {
        localAppSharedPreferences.setAntilost(i);
        if (this.mCore.writeForce(SettingsCmd.getInstance().getAntilostSettingsCmd(localAntilostInfos))) {
          this.toggle_Antilost.showProgressBar();
        }
        this.mAntiLossRunnable = new AntiLossRunnable(paramBoolean);
        this.handler.postDelayed(this.mAntiLossRunnable, 3000L);
        if (!paramBoolean) {
          break label124;
        }
        DebugLog.e("------------防丢打开------------");
        return;
        i = 0;
        break;
      }
      label124:
      DebugLog.e("------------防丢关闭------------");
      return;
    }
    this.handler.postDelayed(new Runnable()
    {
      public void run()
      {
        if (paramBoolean) {
          DeviceFragment.this.toggle_Antilost.setOpen(false);
        }
        for (;;)
        {
          DeviceFragment.this.toggle_Antilost.cancelProgressBar();
          return;
          DeviceFragment.this.toggle_Antilost.setOpen(true);
        }
      }
    }, 500L);
  }
  
  private void setFindPhone(final boolean paramBoolean)
  {
    if (this.mCore.isDeviceConnected())
    {
      AppSharedPreferences.getInstance().setDeviceFoundPhoneSwitch(paramBoolean);
      this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(paramBoolean));
      this.found_phone.showProgressBar();
      this.mFindPhoneRunnable = new FindPhoneRunnable(paramBoolean);
      this.handler.postDelayed(this.mFindPhoneRunnable, 3000L);
      if (paramBoolean)
      {
        DebugLog.e("------------寻找手机打开------------");
        return;
      }
      DebugLog.e("------------寻找手机关闭------------");
      return;
    }
    this.handler.postDelayed(new Runnable()
    {
      public void run()
      {
        if (paramBoolean) {
          DeviceFragment.this.found_phone.setOpen(false);
        }
        for (;;)
        {
          DeviceFragment.this.found_phone.cancelProgressBar();
          return;
          DeviceFragment.this.found_phone.setOpen(true);
        }
      }
    }, 500L);
  }
  
  private void setLiftWrist(final boolean paramBoolean)
  {
    if (this.mCore.isDeviceConnected())
    {
      AppSharedPreferences.getInstance().setLiftWristSwitch(paramBoolean);
      this.mCore.writeForce(SettingsCmd.getInstance().getWristGestureCmd(paramBoolean, 3));
      this.notice_lift_wrist.showProgressBar();
      this.mLiftWristRunnable = new LiftWristRunnable(paramBoolean);
      this.handler.postDelayed(this.mLiftWristRunnable, 3000L);
      if (paramBoolean)
      {
        DebugLog.e("------------抬腕识别打开------------");
        return;
      }
      DebugLog.e("------------抬腕识别关闭------------");
      return;
    }
    this.handler.postDelayed(new Runnable()
    {
      public void run()
      {
        if (paramBoolean) {
          DeviceFragment.this.notice_lift_wrist.setOpen(false);
        }
        for (;;)
        {
          DeviceFragment.this.notice_lift_wrist.cancelProgressBar();
          return;
          DeviceFragment.this.notice_lift_wrist.setOpen(true);
        }
      }
    }, 500L);
  }
  
  private void showDialog()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      return;
    }
    this.dialog = DialogUtil.showUnbindDialog(getActivity(), new DialogUtil.OnUnBoundDeviceListener()
    {
      public void onUnBoundDevice()
      {
        DeviceFragment.this.onUnbindTextClick();
      }
    });
  }
  
  private void updateTitle()
  {
    Object localObject = AppSharedPreferences.getInstance().getBindDeviceName();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.deviceName.setText((CharSequence)localObject);
    }
    Object[] arrayOfObject = AppSharedPreferences.getInstance().getDeviceSyncEndTime();
    int i;
    if (TextUtils.isEmpty((String)arrayOfObject[0]))
    {
      this.syncTime.setText(getString(2131296431));
      this.deviceVersion.setText(String.format(getString(2131296432), new Object[] { Integer.valueOf(LibSharedPreferences.getInstance().getDeviceFirmwareVersion()) }));
      i = LibSharedPreferences.getInstance().getDeviceEnerge();
      if (GetInfoCmd.info != null) {
        i = GetInfoCmd.info.level;
      }
      if ((i >= 14) && (i != 14)) {
        break label445;
      }
      i = 1;
    }
    for (;;)
    {
      this.battery.setText(String.format(getString(2131296433), new Object[] { Integer.valueOf(i) }));
      localObject = getActivity().getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(getActivity().getPackageName(), 0).versionName;
        this.app_version.setText(getActivity().getResources().getString(2131296441) + " " + (String)localObject);
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        boolean bool;
        String str1;
        String str2;
        String str3;
        localNameNotFoundException.printStackTrace();
      }
      bool = AppSharedPreferences.getInstance().is24TimeMode();
      str1 = ((String)arrayOfObject[0]).substring(0, 2);
      str2 = ((String)arrayOfObject[0]).substring(3, 5);
      str3 = ((String)arrayOfObject[0]).substring(6, 8);
      localObject = (String)arrayOfObject[0] + Util.timeFormatter(((Integer)arrayOfObject[1]).intValue(), bool);
      if (getResources().getConfiguration().locale.getCountry().equals("DE")) {
        localObject = str3 + "/" + str2 + "/" + str1 + " " + Util.timeFormatter(((Integer)arrayOfObject[1]).intValue(), bool);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = VeryFitApplication.getInstance().getString(2131296430, new Object[] { localObject });
        this.syncTime.setText((CharSequence)localObject);
        break;
      }
      this.syncTime.setText(getString(2131296431));
      break;
      switch (i)
      {
      default: 
        break;
      case 15: 
        i = 2;
        break;
      case 16: 
        i = 5;
        break;
      case 17: 
        i = 6;
        break;
      case 18: 
        i = 8;
        break;
      case 19: 
        i = 9;
        break;
      case 20: 
        i = 10;
        break;
      case 21: 
        i = 12;
        break;
      case 22: 
        i = 15;
        break;
      case 23: 
        i = 17;
        break;
      case 24: 
        i = 18;
        break;
      case 25: 
        i = 20;
        break;
      case 26: 
        i = 23;
        break;
      case 27: 
        i = 25;
        break;
      case 28: 
        i = 27;
        break;
      case 29: 
        label445:
        i = 28;
      }
    }
  }
  
  protected void lazyLoad()
  {
    int i = 0;
    if ((!this.isPrepared) || (!getUserVisibleHint())) {
      return;
    }
    int j = LibSharedPreferences.getInstance().getDeviceFunMain();
    if (j == -1) {
      this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
    }
    this.mCore.addListener(this.mAppListener);
    this.remind_phone.setOpen(this.share.getDeviceRemindPhoneSwitch());
    Object localObject = this.remind_sport;
    boolean bool;
    label165:
    label197:
    label215:
    label247:
    int k;
    if ((this.share.getDeviceRemindSportRepetitions() & 0x1) == 1)
    {
      bool = true;
      ((ItemLableValue)localObject).setOpen(bool);
      this.found_phone.setOpen(this.share.getDeviceFoundPhoneSwitch());
      this.notice_lift_wrist.setOpen(this.share.getLiftWristSwitch());
      localObject = TempUtil.getAlarms();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label410;
      }
      this.remind_alarm.setOpen(true);
      this.remind_alarm.setValueState(true, 2131296440);
      if (TextUtils.isEmpty(this.share.getIntelligentRemindSwitch())) {
        break label432;
      }
      this.intelligent_remind.setOpen(true);
      this.intelligent_remind.setValueState(true, 2131296437);
      if (1 != AppSharedPreferences.getInstance().getAntilost()) {
        break label454;
      }
      this.toggle_Antilost.setOpen(true);
      this.toggle_Antilost.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          DeviceFragment.this.setAntiLossAlert(paramAnonymousBoolean);
        }
      });
      if (!AppSharedPreferences.getInstance().getDeviceMsgNoticeSwitch()) {
        break label465;
      }
      this.toggle_msg.setOpen(true);
      this.toggle_msg.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            AppSharedPreferences.getInstance().setDeviceMsgNoticeSwitch(true);
            return;
          }
          AppSharedPreferences.getInstance().setDeviceMsgNoticeSwitch(false);
        }
      });
      this.found_phone.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          DeviceFragment.this.setFindPhone(paramAnonymousBoolean);
        }
      });
      this.notice_lift_wrist.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          DeviceFragment.this.setLiftWrist(paramAnonymousBoolean);
        }
      });
      k = LibSharedPreferences.getInstance().getDeviceAlarmMaxCount();
      if (k != 0) {
        break label476;
      }
      this.remind_alarm.setVisibility(8);
      label312:
      k = LibSharedPreferences.getInstance().getDeviceFunMsgNotify();
      localObject = this.toggle_msg;
      if ((k & 0x1) != 1) {
        break label510;
      }
    }
    for (;;)
    {
      ((ItemToggleLayout)localObject).setVisibility(i);
      if ((j >> 4 & 0x1) == 1) {
        getDeviceUpdateInfo();
      }
      if ((this.mCore.isDeviceConnected()) && (!this.mActivity.isHealthDataSyncing()) && (!LibSharedPreferences.getInstance().isSyncData())) {
        this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
      }
      updateTitle();
      updateBindTextInfo();
      return;
      bool = false;
      break;
      label410:
      this.remind_alarm.setValueState(true, 2131296438);
      this.remind_alarm.setOpen(false);
      break label165;
      label432:
      this.intelligent_remind.setValueState(true, 2131296438);
      this.intelligent_remind.setOpen(false);
      break label197;
      label454:
      this.toggle_Antilost.setOpen(false);
      break label215;
      label465:
      this.toggle_msg.setOpen(false);
      break label247;
      label476:
      if (k == -1)
      {
        this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
        break label312;
      }
      this.remind_alarm.setVisibility(0);
      break label312;
      label510:
      i = 8;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0)) {
      if (getActivity() != null)
      {
        getActivity().runOnUiThread(new Runnable()
        {
          public void run()
          {
            DeviceFragment.this.device_update.setValueState(false, VeryFitApplication.getInstance().getString(2131296483));
          }
        });
        this.handler.postDelayed(new Runnable()
        {
          public void run()
          {
            DeviceFragment.this.jumpToMain();
          }
        }, 2000L);
      }
    }
    do
    {
      return;
      if ((paramInt1 == 2) && (paramInt1 != 0))
      {
        if ((this.dialog != null) && (this.dialog.isShowing())) {
          this.dialog.dismiss();
        }
        this.isReStart = true;
        initFun();
        jumpToMain();
        return;
      }
    } while ((paramInt1 != 3) || (paramInt1 == 0) || (!this.mCore.isDeviceConnected()));
    this.mCore.write(AppControlCmd.getInstance().getCameraCmd((byte)1));
  }
  
  public void onClick(View paramView)
  {
    DebugLog.e("onclick");
    switch (paramView.getId())
    {
    default: 
    case 2131230998: 
      do
      {
        return;
        if ((this.mActivity.isHealthDataSyncing()) && (this.mCore.isDeviceConnected()))
        {
          Util.showToast(getActivity(), 2131296676, 0);
          return;
        }
      } while (System.currentTimeMillis() - this.lastClickUnbindTime < 1000L);
      if (this.unbind.getText().toString().contains(getResources().getString(2131296442))) {
        showDialog();
      }
      for (;;)
      {
        this.lastClickUnbindTime = System.currentTimeMillis();
        return;
        if ((this.mCore.isAvailable()) && (this.share.getBindDeviceAddr().equals("")))
        {
          AppSharedPreferences.getInstance().setBindDeviceName("");
          startActivityForResult(new Intent(getActivity(), AddDeviceActivity.class), 2);
        }
      }
    case 2131230898: 
      DebugLog.e("onclickupdate");
      if (!this.mCore.isDeviceConnected())
      {
        Util.showToast(getActivity(), 2131296616, 0);
        return;
      }
      if (this.mActivity.isHealthDataSyncing())
      {
        Util.showToast(getActivity(), 2131296676, 0);
        return;
      }
      paramView = new Intent(getActivity(), DeviceUpdateActivity.class);
      paramView.putExtra("updateInfo", this.updateInfo);
      startActivityForResult(paramView, 1);
      return;
    }
    if (!this.mCore.isDeviceConnected())
    {
      Util.showToast(getActivity(), 2131296616, 0);
      return;
    }
    if (this.mActivity.isHealthDataSyncing())
    {
      Util.showToast(getActivity(), 2131296676, 0);
      return;
    }
    startActivityForResult(new Intent(getActivity(), CameraActivity.class), 3);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity = ((MainActivity)getActivity());
    if (this.mRootView != null)
    {
      paramLayoutInflater = (ViewGroup)this.mRootView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.mRootView);
      }
    }
    for (;;)
    {
      return this.mRootView;
      this.mRootView = paramLayoutInflater.inflate(2130903095, paramViewGroup, false);
      this.mCore.addListener(this.mAppListener);
      initView();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onInVisible()
  {
    super.onInVisible();
    if (this.mCore != null) {
      this.mCore.removeListener(this.mAppListener);
    }
  }
  
  public void onPause()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onThemeChanged()
  {
    DebugLog.e("设备收到主题切换的通知");
  }
  
  public void updateBindTextInfo()
  {
    if (this.mCore.isAvailable())
    {
      if (this.share.getBindDeviceAddr().equals(""))
      {
        this.unbind.setText(getString(2131296443));
        String str = getString(2131296433);
        this.battery.setText(str.substring(0, str.indexOf("%")) + "--");
        this.device_update.setValueState(false, 2131296483);
        this.mCore.disconnect();
      }
    }
    else {
      return;
    }
    this.unbind.setText(getString(2131296442));
  }
  
  class AntiLossRunnable
    implements Runnable
  {
    boolean isSwitchOn;
    
    public AntiLossRunnable(boolean paramBoolean)
    {
      this.isSwitchOn = paramBoolean;
    }
    
    public void run()
    {
      if (DeviceFragment.this.mCore.isDeviceConnected())
      {
        if (!this.isSwitchOn) {
          break label49;
        }
        AppSharedPreferences.getInstance().setAntilost(0);
        DeviceFragment.this.toggle_Antilost.setOpen(false);
      }
      for (;;)
      {
        DeviceFragment.this.toggle_Antilost.cancelProgressBar();
        return;
        label49:
        AppSharedPreferences.getInstance().setAntilost(1);
        DeviceFragment.this.toggle_Antilost.setOpen(true);
      }
    }
  }
  
  class FindPhoneRunnable
    implements Runnable
  {
    boolean isSwitchOn;
    
    public FindPhoneRunnable(boolean paramBoolean)
    {
      this.isSwitchOn = paramBoolean;
    }
    
    public void run()
    {
      if (!DeviceFragment.this.mCore.isDeviceConnected())
      {
        if (!this.isSwitchOn) {
          break label49;
        }
        AppSharedPreferences.getInstance().setDeviceFoundPhoneSwitch(false);
        DeviceFragment.this.found_phone.setOpen(false);
      }
      for (;;)
      {
        DeviceFragment.this.found_phone.cancelProgressBar();
        return;
        label49:
        AppSharedPreferences.getInstance().setDeviceFoundPhoneSwitch(true);
        DeviceFragment.this.found_phone.setOpen(true);
      }
    }
  }
  
  class LiftWristRunnable
    implements Runnable
  {
    boolean isSwitchOn;
    
    public LiftWristRunnable(boolean paramBoolean)
    {
      this.isSwitchOn = paramBoolean;
    }
    
    public void run()
    {
      if (!DeviceFragment.this.mCore.isDeviceConnected())
      {
        if (!this.isSwitchOn) {
          break label49;
        }
        AppSharedPreferences.getInstance().setLiftWristSwitch(false);
        DeviceFragment.this.notice_lift_wrist.setOpen(false);
      }
      for (;;)
      {
        DeviceFragment.this.notice_lift_wrist.cancelProgressBar();
        return;
        label49:
        AppSharedPreferences.getInstance().setLiftWristSwitch(true);
        DeviceFragment.this.notice_lift_wrist.setOpen(true);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\main\DeviceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */