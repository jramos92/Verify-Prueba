package com.veryfit.multi.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.notify.IncomingMessage;
import com.project.library.device.cmd.notify.NotifyCmd;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.BleScanTool;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.MainActivity;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class IntelligentNotificationService
  extends NotificationListenerService
{
  protected APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected() {}
    
    public void onBLEDisConnected(String paramAnonymousString)
    {
      IntelligentNotificationService.this.mSmsMessage = null;
      if ((!TextUtils.isEmpty(paramAnonymousString)) && (BleScanTool.getInstance().isNeedScanDevice())) {
        IntelligentNotificationService.this.mCore.connect(paramAnonymousString);
      }
      super.onBLEDisConnected(paramAnonymousString);
    }
    
    public void onOtherDataReceive(byte[] paramAnonymousArrayOfByte)
    {
      if ((paramAnonymousArrayOfByte[0] != 5) || (paramAnonymousArrayOfByte[1] != 3) || (IntelligentNotificationService.this.mSmsMessage == null)) {}
      do
      {
        return;
        if (IntelligentNotificationService.this.mSmsMessage.serial == paramAnonymousArrayOfByte[3])
        {
          IntelligentNotificationService.this.sendIncomingMessagePacket();
          return;
        }
        IntelligentNotificationService.this.mSmsMessage = null;
      } while ((paramAnonymousArrayOfByte[2] == 0) || (paramAnonymousArrayOfByte[3] == 0));
      IntelligentNotificationService.this.getSmsFromPhone();
    }
  };
  CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private byte[] mSmsContent = null;
  private IncomingMessage mSmsMessage = null;
  private String mText = null;
  private String mTitle = null;
  private byte mType;
  private AppSharedPreferences share = AppSharedPreferences.getInstance();
  private int smsIndex = 0;
  private int smsModLen = 0;
  
  private void sendIncomingMessagePacket()
  {
    if ((this.mSmsMessage != null) && (this.mSmsMessage.totalPacket > this.mSmsMessage.serial))
    {
      Object localObject = this.mSmsMessage;
      ((IncomingMessage)localObject).serial += 1;
      if (this.smsModLen - 16 > 0) {
        this.smsModLen -= 16;
      }
      for (int i = 16;; i = this.smsModLen)
      {
        localObject = new byte[i];
        ByteDataConvertUtil.BinnCat(this.mSmsContent, (byte[])localObject, this.smsIndex, i);
        this.mSmsMessage.smsContent = ((byte[])localObject);
        this.mCore.writeForce(NotifyCmd.getInstance().getIncomingMessageCmd(this.mSmsMessage));
        this.smsIndex += i;
        return;
      }
    }
    this.mSmsMessage = null;
  }
  
  @SuppressLint({"NewApi"})
  private void sendText(Notification paramNotification, byte paramByte)
  {
    if (this.mSmsMessage != null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT <= 18) {
          continue;
        }
        localObject1 = paramNotification.extras;
        localObject3 = ((Bundle)localObject1).getString("android.title");
        localObject1 = ((Bundle)localObject1).getString("android.text");
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = paramNotification.tickerText.toString();
        }
        paramNotification = (Notification)localObject2;
        localObject1 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if ((!((String)localObject2).contains(":")) || (paramByte != 3)) {
            continue;
          }
          paramNotification = localObject2.split(":")[1].trim();
          localObject1 = localObject3;
        }
      }
      catch (Exception paramNotification)
      {
        Object localObject3;
        Object localObject2;
        Object localObject1 = null;
        paramNotification = null;
        continue;
      }
      this.mTitle = ((String)localObject1);
      this.mText = paramNotification;
      this.mType = paramByte;
      getSmsFromPhone();
      return;
      paramNotification = (Notification)localObject2;
      localObject1 = localObject3;
      if (((String)localObject2).contains("]"))
      {
        paramNotification = ((String)localObject2).substring(((String)localObject2).indexOf("]") + 1);
        localObject1 = localObject3;
      }
    }
    localObject3 = null;
    if (TextUtils.isEmpty(paramNotification.tickerText)) {}
    for (localObject2 = null;; localObject2 = paramNotification.tickerText.toString())
    {
      paramNotification = (Notification)localObject2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      paramNotification = (Notification)localObject2;
      localObject1 = localObject3;
      if (!((String)localObject2).contains(":")) {
        break;
      }
      paramNotification = (Notification)localObject2;
      localObject1 = localObject3;
      if (paramByte != 3) {
        break;
      }
      localObject3 = ((String)localObject2).split(":");
      localObject1 = localObject3[0];
      localObject2 = localObject3[1];
      paramNotification = (Notification)localObject2;
      if (!localObject3[0].contains("]")) {
        break;
      }
      localObject1 = localObject3[0].substring(localObject3[0].indexOf("]") + 1);
      paramNotification = (Notification)localObject2;
      break;
    }
  }
  
  public void getSmsFromPhone()
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int i;
      try
      {
        localObject1 = this.mSmsMessage;
        if (localObject1 != null) {
          return;
        }
        localObject2 = this.mTitle;
        localObject1 = this.mText;
        j = LibSharedPreferences.getInstance().getDeviceFunTipInfoNotify();
        if ((j & 0x1) != 1) {
          break label350;
        }
        i = 1;
      }
      finally {}
      this.mSmsMessage = new IncomingMessage();
      this.mSmsMessage.serial = 1;
      this.mSmsMessage.type = this.mType;
      this.mSmsContent = null;
      this.mSmsMessage.numberLength = 0;
      if ((localObject2 != null) && (i != 0))
      {
        try
        {
          localObject2 = ((String)localObject2).getBytes("UTF-8");
          if (this.mSmsContent == null) {
            break label360;
          }
          this.mSmsContent = ByteDataConvertUtil.byteMerger(this.mSmsContent, (byte[])localObject2);
          label128:
          this.mSmsMessage.contactLength = localObject2.length;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          label138:
          boolean bool;
          localUnsupportedEncodingException2.printStackTrace();
          continue;
        }
        if (j == 0) {
          break label409;
        }
        bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (bool) {
          break label409;
        }
      }
      try
      {
        localObject1 = ((String)localObject1).getBytes("UTF-8");
        if (this.mSmsContent == null) {
          break label390;
        }
        this.mSmsContent = ByteDataConvertUtil.byteMerger(this.mSmsContent, (byte[])localObject1);
        label181:
        this.mSmsMessage.contentLength = localObject1.length;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        label191:
        localUnsupportedEncodingException1.printStackTrace();
        continue;
      }
      if ((this.mSmsContent != null) && (this.mSmsContent.length > 64))
      {
        this.mSmsContent = Arrays.copyOf(this.mSmsContent, 64);
        this.mSmsMessage.contentLength = this.mSmsContent.length;
      }
      if (this.mSmsContent != null)
      {
        this.smsModLen = (this.mSmsContent.length - 12);
        this.smsIndex = 12;
        if (this.mSmsContent.length - 12 > 0)
        {
          this.mSmsMessage.totalPacket = ((int)Math.ceil((this.mSmsContent.length - 12) / 16.0D) + 1);
          localObject1 = new byte[12];
          ByteDataConvertUtil.BinnCat(this.mSmsContent, (byte[])localObject1, 0, 12);
          this.mSmsMessage.smsContent = ((byte[])localObject1);
          label322:
          this.mCore.writeForce(NotifyCmd.getInstance().getMessageCmd(this.mSmsMessage));
          continue;
          label350:
          i = 0;
        }
      }
      label360:
      label390:
      label409:
      while ((j & 0x4) >> 2 != 1)
      {
        j = 0;
        break;
        this.mSmsContent = ((byte[])localObject2);
        break label128;
        this.mSmsMessage.contactLength = 0;
        break label138;
        this.mSmsContent = arrayOfByte1;
        break label181;
        this.mSmsMessage.contentLength = 0;
        break label191;
        this.mSmsMessage.totalPacket = 1;
        byte[] arrayOfByte2 = new byte[this.mSmsContent.length];
        ByteDataConvertUtil.BinnCat(this.mSmsContent, arrayOfByte2, 0, this.mSmsContent.length);
        this.mSmsMessage.smsContent = arrayOfByte2;
        break label322;
        this.mSmsMessage.totalPacket = 1;
        break label322;
      }
      int j = 1;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    DebugLog.e("IntelligentNotificationService:onBind");
    return super.onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    DebugLog.e("IntelligentNotificationService:onCreate");
    this.mCore.addListener(this.mAppListener);
    Notification localNotification = new Notification(2130837588, "Foreground Service Started.", System.currentTimeMillis());
    localNotification.setLatestEventInfo(this, "Foreground Service", "Foreground Service Started.", PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0));
    startForeground(0, localNotification);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    stopForeground(true);
  }
  
  public void onNotificationPosted(StatusBarNotification paramStatusBarNotification)
  {
    if (LibSharedPreferences.getInstance().isSyncData()) {}
    Notification localNotification;
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while ((AppSharedPreferences.getInstance().getIsRealTime()) || (!this.mCore.isDeviceConnected()));
        localNotification = paramStatusBarNotification.getNotification();
      } while (localNotification == null);
      paramStatusBarNotification = paramStatusBarNotification.getPackageName();
      DebugLog.e("p:" + paramStatusBarNotification + ",t:" + localNotification.tickerText);
      str = this.share.getIntelligentRemindSwitch();
      if (("com.tencent.mm".equals(paramStatusBarNotification)) && (str.contains("2")))
      {
        sendText(localNotification, (byte)3);
        return;
      }
      if (("com.tencent.mobileqq".equals(paramStatusBarNotification)) && (str.contains("3")))
      {
        sendText(localNotification, (byte)4);
        return;
      }
      if (("com.facebook.katana".equals(paramStatusBarNotification)) && (str.contains("1")))
      {
        sendText(localNotification, (byte)6);
        return;
      }
      if (("com.twitter.android".equals(paramStatusBarNotification)) && (str.contains("4")))
      {
        sendText(localNotification, (byte)7);
        return;
      }
      if (("com.whatsapp".equals(paramStatusBarNotification)) && (str.contains("5")))
      {
        sendText(localNotification, (byte)8);
        return;
      }
      if (("com.linkedin.android".equals(paramStatusBarNotification)) && (str.contains("7")))
      {
        sendText(localNotification, (byte)11);
        return;
      }
      if (("com.instagram.android".equals(paramStatusBarNotification)) && (str.contains("6")))
      {
        sendText(localNotification, (byte)10);
        return;
      }
    } while ((!"com.facebook.orca".equals(paramStatusBarNotification)) || (!str.contains("8")));
    sendText(localNotification, (byte)9);
  }
  
  public void onNotificationRemoved(StatusBarNotification paramStatusBarNotification) {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\service\IntelligentNotificationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */