package com.project.library.ble;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.BleScanTool;
import com.project.library.util.DebugLog;
import java.util.UUID;

public class BleConnectService
  extends Service
{
  public static final UUID RX_SERVICE_UUID = UUID.fromString("00000af0-0000-1000-8000-00805f9b34fb");
  private Handler handler = new Handler();
  private BroadcastReceiver mBluetoothStatusReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i;
      if (paramAnonymousIntent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED"))
      {
        i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        if (i != 10) {
          break label49;
        }
        if (BleConnectService.this.mCore != null) {
          BleConnectService.this.mCore.notifyBluetoothStateChanged(false);
        }
      }
      for (;;)
      {
        return;
        label49:
        if ((i != 12) || (LibSharedPreferences.getInstance().isFirwareUpgrade())) {
          continue;
        }
        if (BleConnectService.this.mCore != null) {
          BleConnectService.this.mCore.notifyBluetoothStateChanged(true);
        }
        try
        {
          Thread.sleep(1000L);
          boolean bool = BleScanTool.getInstance().isNeedScanDevice();
          if (BleConnectService.this.mCore == null) {
            continue;
          }
          BleConnectService.this.mCore.autoConnect(bool);
          return;
        }
        catch (InterruptedException paramAnonymousContext)
        {
          for (;;) {}
        }
      }
    }
  };
  private CoreServiceImpl mCore;
  public BleScanTool sTool = BleScanTool.getInstance();
  
  private int checkBluethoothConection()
  {
    if (!this.sTool.isBluetoothOpen()) {
      return 1;
    }
    if (!this.sTool.isSupportBLE()) {
      return 2;
    }
    return 0;
  }
  
  private void close()
  {
    if (this.mCore != null)
    {
      this.mCore.close();
      this.mCore = null;
    }
  }
  
  private void scanDevice(boolean paramBoolean)
  {
    this.sTool.scanLeDeviceByService(paramBoolean, RX_SERVICE_UUID);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mCore;
  }
  
  public void onCreate()
  {
    DebugLog.e("onCreate");
    this.mCore = new CoreServiceImpl(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    registerReceiver(this.mBluetoothStatusReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    DebugLog.e("onDestroy");
    close();
    unregisterReceiver(this.mBluetoothStatusReceiver);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    close();
    return false;
  }
  
  public int scanDevices()
  {
    if (checkBluethoothConection() == 0)
    {
      this.handler.post(new Runnable()
      {
        public void run()
        {
          BleConnectService.this.scanDevice(false);
          if (!BleConnectService.this.sTool.isScanning()) {
            BleConnectService.this.handler.postDelayed(new Runnable()
            {
              public void run()
              {
                BleConnectService.this.scanDevice(true);
              }
            }, 5000L);
          }
        }
      });
      return 0;
    }
    return checkBluethoothConection();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\ble\BleConnectService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */