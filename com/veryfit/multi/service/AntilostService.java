package com.veryfit.multi.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.project.library.core.CoreServiceProxy;
import com.project.library.util.BleScanTool;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.MainActivity;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class AntilostService
  extends Service
{
  boolean blueTooth;
  private Timer blueToothtimer;
  int count = 1;
  private boolean isSendNotification = false;
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private BleScanTool sTool = BleScanTool.getInstance();
  
  private void blueToothTimer()
  {
    if (this.blueToothtimer != null)
    {
      this.blueToothtimer.cancel();
      this.blueToothtimer = null;
    }
    this.blueToothtimer = new Timer();
    TimerTask local1 = new TimerTask()
    {
      public void run()
      {
        boolean bool1 = AntilostService.this.mCore.isDeviceConnected();
        boolean bool2 = AntilostService.this.sTool.isBluetoothOpen();
        AntilostService localAntilostService;
        if ((!bool1) && (bool2))
        {
          localAntilostService = AntilostService.this;
          localAntilostService.count += 1;
        }
        for (;;)
        {
          DebugLog.d("========" + String.valueOf(AntilostService.this.count));
          if (AntilostService.this.count == 30)
          {
            DebugLog.d("==========isSendNotification***" + String.valueOf(AntilostService.this.isSendNotification));
            if ((AppSharedPreferences.getInstance().getAntilost() == 1) && (!bool1))
            {
              if (bool2) {
                break;
              }
              AntilostService.this.notifyBlueTooth(1);
            }
          }
          return;
          if (!bool2)
          {
            localAntilostService = AntilostService.this;
            localAntilostService.count += 1;
          }
          else if (bool1)
          {
            AntilostService.this.count = 1;
          }
        }
        AntilostService.this.notifyBlueTooth(2);
      }
    };
    this.blueToothtimer.schedule(local1, 0L, 1000L);
    DebugLog.d("============开启蓝牙计时器");
  }
  
  public void notifyBlueTooth(int paramInt)
  {
    int i = Calendar.getInstance().get(11);
    if ((i >= 23) || (i <= 7)) {
      return;
    }
    NotificationManager localNotificationManager = null;
    if (0 == 0) {
      localNotificationManager = (NotificationManager)getSystemService("notification");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.isSendNotification = true;
      return;
      DebugLog.d("============发送通知1");
      Object localObject = new Intent(this, MainActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("id", "1");
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).setFlags(536870912);
      localObject = PendingIntent.getActivity(this, 1001, (Intent)localObject, 134217728);
      localNotificationManager.notify(1, new NotificationCompat.Builder(this).setSmallIcon(2130837588).setTicker(getResources().getString(2131296734)).setContentTitle(getResources().getString(2131296735)).setContentText(getResources().getString(2131296736)).setAutoCancel(true).setSound(Uri.parse("android.resource://" + getPackageName() + "/" + 2131034112)).setContentIntent((PendingIntent)localObject).build());
      continue;
      DebugLog.d("============发送通知2");
      localObject = new Intent(this, MainActivity.class);
      localBundle = new Bundle();
      localBundle.putString("id", "2");
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).setFlags(536870912);
      localObject = PendingIntent.getActivity(this, 1002, (Intent)localObject, 134217728);
      localNotificationManager.notify(1, new NotificationCompat.Builder(this).setSmallIcon(2130837588).setTicker(getResources().getString(2131296737)).setContentTitle(getResources().getString(2131296738)).setContentText(getResources().getString(2131296739)).setAutoCancel(true).setSound(Uri.parse("android.resource://" + getPackageName() + "/" + 2131034112)).setContentIntent((PendingIntent)localObject).build());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    DebugLog.d("============打开防丢提醒service");
    blueToothTimer();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.blueToothtimer != null) {
      this.blueToothtimer.cancel();
    }
    DebugLog.d("============关闭防丢提醒service");
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\service\AntilostService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */