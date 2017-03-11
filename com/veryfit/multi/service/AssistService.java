package com.veryfit.multi.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.device.cmd.notify.IncomingCall;
import com.project.library.device.cmd.notify.IncomingMessage;
import com.project.library.device.cmd.notify.NotifyCmd;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.device.cmd.settings.Units;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.BleScanTool;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.SMSPhoneUtil;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class AssistService
  extends Service
{
  private static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
  private static final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
  private Uri SMS_INBOX = Uri.parse("content://sms/inbox");
  private Uri SMS_URI = Uri.parse("content://sms/");
  private byte[] byteName;
  private long exitTime = 0L;
  private Handler handler = new Handler();
  private boolean hasFirstReigsterPhone;
  private int index = 0;
  private boolean isRingOrVibrate = true;
  protected APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected() {}
    
    public void onBLEDisConnected(String paramAnonymousString)
    {
      if ((!TextUtils.isEmpty(paramAnonymousString)) && (BleScanTool.getInstance().isNeedScanDevice())) {
        AssistService.this.mCore.connect(paramAnonymousString);
      }
      super.onBLEDisConnected(paramAnonymousString);
    }
    
    public void onOtherDataReceive(byte[] paramAnonymousArrayOfByte)
    {
      if ((paramAnonymousArrayOfByte[0] == 5) && (paramAnonymousArrayOfByte[1] == 1)) {
        if (AssistService.this.message.serial == paramAnonymousArrayOfByte[3]) {
          AssistService.this.sendIncomingCallPacket();
        }
      }
      for (;;)
      {
        int i = DeviceBaseCommand.getCmdKey(AssistService.this.mLastCommand);
        if ((paramAnonymousArrayOfByte[0] == 5) && ((paramAnonymousArrayOfByte[1] == 1) || (paramAnonymousArrayOfByte[1] == 2)) && (i != paramAnonymousArrayOfByte[1]) && (AssistService.this.mLastCommand != null))
        {
          AssistService.this.mCore.writeForce(AssistService.this.mLastCommand);
          DebugLog.e("AssistService命令重发:" + ByteDataConvertUtil.bytesToHexString(AssistService.this.mLastCommand));
        }
        return;
        if ((paramAnonymousArrayOfByte[2] != 0) && (paramAnonymousArrayOfByte[3] != 0) && (AssistService.class != null))
        {
          AssistService.this.getIncomingCall();
          continue;
          if ((paramAnonymousArrayOfByte[0] == 5) && (paramAnonymousArrayOfByte[1] == 3))
          {
            if (AssistService.this.mSmsMessage == null) {
              break;
            }
            if (AssistService.this.mSmsMessage.serial == paramAnonymousArrayOfByte[3])
            {
              AssistService.this.sendIncomingMessagePacket();
              continue;
            }
            AssistService.this.mSmsMessage = null;
            if ((paramAnonymousArrayOfByte[2] == 0) || (paramAnonymousArrayOfByte[3] == 0)) {
              continue;
            }
            AssistService.this.getSmsFromPhone();
            continue;
          }
          if ((paramAnonymousArrayOfByte[0] == 7) && (paramAnonymousArrayOfByte[1] == 2) && (AssistService.this.mAppSharedPreferences.getDeviceFoundPhoneSwitch()))
          {
            AssistService.this.isRingOrVibrate = true;
            AssistService.this.playRingtone(true);
          }
        }
      }
    }
  };
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  byte[] mLastCommand = null;
  private MediaPlayer mMediaPlayer;
  private byte[] mSmsContent = null;
  private IncomingMessage mSmsMessage = null;
  Vibrator mVib;
  private IncomingCall message;
  private int modLen = 0;
  private String phoneNumber = "";
  private BroadcastReceiver receiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("android.intent.action.TIME_SET".equals(paramAnonymousIntent.getAction()))
      {
        AssistService.this.initTimeMode();
        if (AssistService.this.mCore.isDeviceConnected()) {
          AssistService.this.sendUnitSet();
        }
      }
      for (;;)
      {
        return;
        if (paramAnonymousIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION"))
        {
          AssistService.this.isRingOrVibrate = false;
          try
          {
            if ((AssistService.this.mMediaPlayer != null) && (AssistService.this.mMediaPlayer.isPlaying()))
            {
              AssistService.this.mMediaPlayer.stop();
              AssistService.this.mMediaPlayer.release();
              AssistService.this.mMediaPlayer = null;
            }
            if ((AssistService.this.mVib != null) && (AssistService.this.mVib.hasVibrator()))
            {
              AssistService.this.mVib.cancel();
              AssistService.this.mVib = null;
              return;
            }
          }
          catch (Exception paramAnonymousContext) {}
        }
      }
    }
  };
  private int smsIndex = 0;
  private int smsModLen = 0;
  private SmsObserver smsObserver;
  Runnable vibrateAndMediaRunnable = new Runnable()
  {
    public void run()
    {
      if (AssistService.this.isRingOrVibrate)
      {
        if (System.currentTimeMillis() - AssistService.this.exitTime >= 30000L)
        {
          if ((AssistService.this.mMediaPlayer != null) && (AssistService.this.mMediaPlayer.isPlaying()))
          {
            AssistService.this.mMediaPlayer.stop();
            AssistService.this.mMediaPlayer.release();
            AssistService.this.mMediaPlayer = null;
          }
          if (AssistService.this.mVib != null)
          {
            AssistService.this.mVib.cancel();
            AssistService.this.mVib = null;
          }
        }
        AssistService.this.handler.postDelayed(this, 1000L);
        return;
      }
      AssistService.this.handler.removeCallbacks(this);
    }
  };
  
  private boolean checkPhonebookPermission()
  {
    return getPackageManager().checkPermission("android.permission.READ_CONTACTS", getPackageName()) == 0;
  }
  
  private void d(String paramString)
  {
    Log.d(getClass().getSimpleName(), "----------->" + paramString);
  }
  
  private void getIncomingCall()
  {
    Object localObject = null;
    int j = LibSharedPreferences.getInstance().getDeviceCallNotify();
    int i;
    label32:
    byte[] arrayOfByte2;
    char[] arrayOfChar;
    int k;
    if ((j & 0x2) >> 1 == 1)
    {
      i = 1;
      if ((j & 0x4) >> 2 != 1) {
        break label303;
      }
      j = 1;
      this.message = new IncomingCall();
      this.message.serial = 1;
      if ((this.phoneNumber == null) || (j == 0)) {
        break label332;
      }
      int m = this.phoneNumber.length();
      arrayOfByte2 = new byte[m];
      arrayOfChar = this.phoneNumber.toCharArray();
      int n = arrayOfChar.length;
      k = 0;
      j = 0;
      label95:
      if (k < n) {
        break label308;
      }
      this.byteName = arrayOfByte2;
      this.message.numberLength = m;
      label116:
      if (checkPhonebookPermission()) {
        localObject = SMSPhoneUtil.getContactNameFromPhoneBook(this, this.phoneNumber);
      }
      if ((localObject == null) || (i == 0)) {
        break label367;
      }
    }
    try
    {
      localObject = ((String)localObject).getBytes("UTF-8");
      if (this.byteName == null) {
        break label348;
      }
      this.byteName = ByteDataConvertUtil.byteMerger(this.byteName, (byte[])localObject);
      label172:
      this.message.contactLength = localObject.length;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        label182:
        label303:
        label308:
        label332:
        label348:
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    if (this.byteName != null)
    {
      this.modLen = (this.byteName.length - 14);
      this.index = 14;
      if (this.byteName.length - 14 > 0)
      {
        this.message.totalPacket = ((int)Math.ceil((this.byteName.length - 14) / 16.0D) + 1);
        localObject = new byte[14];
        ByteDataConvertUtil.BinnCat(this.byteName, (byte[])localObject, 0, 14);
        this.message.nameContent = ((byte[])localObject);
      }
    }
    for (;;)
    {
      this.mLastCommand = NotifyCmd.getInstance().getIncomingCallCmd(this.message);
      this.mCore.writeForce(this.mLastCommand);
      return;
      i = 0;
      break;
      j = 0;
      break label32;
      arrayOfByte2[j] = ((byte)(arrayOfChar[k] & 0xFF));
      k += 1;
      j += 1;
      break label95;
      this.byteName = null;
      this.message.numberLength = 0;
      break label116;
      this.byteName = ((byte[])localObject);
      break label172;
      label367:
      this.message.contactLength = 0;
      break label182;
      this.message.totalPacket = 1;
      byte[] arrayOfByte1 = new byte[this.byteName.length];
      ByteDataConvertUtil.BinnCat(this.byteName, arrayOfByte1, 0, this.byteName.length);
      this.message.nameContent = arrayOfByte1;
      continue;
      this.message.totalPacket = 1;
    }
  }
  
  private Uri getSystemDefultRingtoneUri()
  {
    return RingtoneManager.getActualDefaultRingtoneUri(this, 1);
  }
  
  private void initTimeMode()
  {
    String str = Settings.System.getString(getContentResolver(), "time_12_24");
    if ("24".equals(str)) {
      AppSharedPreferences.getInstance().setTimeMode(true);
    }
    while (!"12".equals(str)) {
      return;
    }
    AppSharedPreferences.getInstance().setTimeMode(false);
  }
  
  private void playRingtone(boolean paramBoolean)
  {
    this.handler.removeCallbacks(this.vibrateAndMediaRunnable);
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    if ((this.mVib == null) && (paramBoolean)) {
      this.mVib = ((Vibrator)getSystemService("vibrator"));
    }
    int i = 0;
    try
    {
      boolean bool = this.mMediaPlayer.isPlaying();
      i = bool;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Uri localUri = getSystemDefultRingtoneUri();
          this.mMediaPlayer.setDataSource(this, localUri);
          this.mMediaPlayer.setLooping(true);
          this.mMediaPlayer.prepare();
          this.exitTime = System.currentTimeMillis();
          this.mMediaPlayer.start();
          if (paramBoolean) {
            this.mVib.vibrate(new long[] { 500L, 2000L }, 0);
          }
          this.handler.postDelayed(this.vibrateAndMediaRunnable, 0L);
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localException1 = localException1;
        this.mMediaPlayer = null;
        this.mMediaPlayer = new MediaPlayer();
      }
    }
    if (i != 0)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mMediaPlayer = new MediaPlayer();
    }
  }
  
  private void registerPhoneListener()
  {
    ((TelephonyManager)getSystemService("phone")).listen(new PhoneStateListener()
    {
      boolean hasSend;
      private Runnable sendCallComing = new Runnable()
      {
        public void run()
        {
          if (AssistService.this.mCore.isDeviceConnected())
          {
            AssistService.this.getIncomingCall();
            AssistService.4.this.hasSend = true;
          }
        }
      };
      
      public void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        DebugLog.d("TelephonyManager   state = " + paramAnonymousInt + " ---incomingNumber" + paramAnonymousString);
        if (!AssistService.this.hasFirstReigsterPhone) {
          AssistService.this.hasFirstReigsterPhone = true;
        }
        while (!AppSharedPreferences.getInstance().getDeviceRemindPhoneSwitch()) {
          return;
        }
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          if (this.hasSend)
          {
            AssistService.this.mLastCommand = NotifyCmd.getInstance().getIncomingCallStatusCmd((byte)2);
            AssistService.this.mCore.writeForce(AssistService.this.mLastCommand);
            this.hasSend = false;
            try
            {
              Thread.sleep(1000L);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              return;
            }
          }
          AssistService.this.handler.removeCallbacks(this.sendCallComing);
          return;
        case 1: 
          AssistService.this.phoneNumber = paramAnonymousString;
          if (!AssistService.this.mCore.isDeviceConnected()) {
            AssistService.this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
          }
          AssistService.this.handler.postDelayed(this.sendCallComing, AppSharedPreferences.getInstance().getDeviceRemindPhoneDelay() * 1000L);
          return;
        }
        if (this.hasSend)
        {
          AssistService.this.mLastCommand = NotifyCmd.getInstance().getIncomingCallStatusCmd((byte)1);
          AssistService.this.mCore.writeForce(AssistService.this.mLastCommand);
          this.hasSend = false;
          try
          {
            Thread.sleep(1000L);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            return;
          }
        }
        AssistService.this.handler.removeCallbacks(this.sendCallComing);
      }
    }, 32);
  }
  
  private void sendIncomingCallPacket()
  {
    if ((this.message != null) && (this.message.totalPacket > this.message.serial))
    {
      Object localObject = this.message;
      ((IncomingCall)localObject).serial += 1;
      if (this.modLen - 16 > 0) {
        this.modLen -= 16;
      }
      for (int i = 16;; i = this.modLen)
      {
        localObject = new byte[i];
        ByteDataConvertUtil.BinnCat(this.byteName, (byte[])localObject, this.index, i);
        this.message.nameContent = ((byte[])localObject);
        this.mCore.writeForce(NotifyCmd.getInstance().getIncomingCallCmd(this.message));
        this.index += i;
        return;
      }
    }
    this.byteName = null;
    this.phoneNumber = null;
  }
  
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
  
  private void sendUnitSet()
  {
    int i = 1;
    Units localUnits = new Units();
    localUnits.setMode(AppSharedPreferences.getInstance().getUnitType());
    String str = getResources().getConfiguration().locale.toString();
    if (str.contains("zh"))
    {
      localUnits.language = 1;
      if (!AppSharedPreferences.getInstance().is24TimeMode()) {
        break label97;
      }
    }
    for (;;)
    {
      localUnits.timeMode = i;
      this.mCore.write(SettingsCmd.getInstance().getUnitSettingsCmd(localUnits));
      return;
      if (!str.contains("en")) {
        break;
      }
      localUnits.language = 2;
      break;
      label97:
      i = 2;
    }
  }
  
  public void getSmsFromPhone()
  {
    if (this.mSmsMessage != null) {}
    StringBuffer localStringBuffer;
    String str;
    Object localObject1;
    long l1;
    long l2;
    Object localObject2;
    do
    {
      do
      {
        return;
        localStringBuffer = new StringBuffer();
        str = null;
        localObject1 = null;
        l1 = 0L;
        l2 = System.currentTimeMillis();
        localObject2 = getContentResolver().query(this.SMS_INBOX, new String[] { "body", "address", "person", "read", "date" }, "read=? and type=?", new String[] { "0", "1" }, "date desc limit 1");
      } while (localObject2 == null);
      if (((Cursor)localObject2).moveToNext()) {
        break;
      }
      ((Cursor)localObject2).close();
    } while ((l2 - l1) / 1000L > 5L);
    int j = LibSharedPreferences.getInstance().getDeviceFunTipInfoNotify();
    int i;
    label154:
    int k;
    label165:
    label176:
    char[] arrayOfChar;
    int m;
    if ((j & 0x1) == 1)
    {
      i = 1;
      if ((j & 0x2) >> 1 != 1) {
        break label581;
      }
      k = 1;
      if ((j & 0x4) >> 2 != 1) {
        break label586;
      }
      j = 1;
      this.mSmsMessage = new IncomingMessage();
      this.mSmsMessage.serial = 1;
      if ((str == null) || (k == 0)) {
        break label618;
      }
      int n = str.length();
      localObject2 = new byte[n];
      arrayOfChar = str.toCharArray();
      int i1 = arrayOfChar.length;
      m = 0;
      k = 0;
      label234:
      if (m < i1) {
        break label591;
      }
      this.mSmsContent = ((byte[])localObject2);
      this.mSmsMessage.numberLength = n;
      label256:
      if (checkPhonebookPermission()) {
        localObject1 = SMSPhoneUtil.getContactNameFromPhoneBook(this, str);
      }
      if ((localObject1 == null) || (i == 0)) {
        break label653;
      }
    }
    try
    {
      localObject1 = ((String)localObject1).getBytes("UTF-8");
      if (this.mSmsContent == null) {
        break label634;
      }
      this.mSmsContent = ByteDataConvertUtil.byteMerger(this.mSmsContent, (byte[])localObject1);
      label310:
      this.mSmsMessage.contactLength = localObject1.length;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      for (;;)
      {
        label320:
        label357:
        label367:
        label581:
        label586:
        label591:
        label618:
        label634:
        localUnsupportedEncodingException1.printStackTrace();
      }
    }
    if (j != 0)
    {
      try
      {
        localObject1 = localStringBuffer.toString().getBytes("UTF-8");
        if (this.mSmsContent == null) {
          break label664;
        }
        this.mSmsContent = ByteDataConvertUtil.byteMerger(this.mSmsContent, (byte[])localObject1);
        this.mSmsMessage.contentLength = localObject1.length;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          localUnsupportedEncodingException2.printStackTrace();
        }
      }
      if (this.mSmsContent == null) {
        break label738;
      }
      this.smsModLen = (this.mSmsContent.length - 12);
      this.smsIndex = 12;
      if (this.mSmsContent.length - 12 <= 0) {
        break label694;
      }
      this.mSmsMessage.totalPacket = ((int)Math.ceil((this.mSmsContent.length - 12) / 16.0D) + 1);
      localObject1 = new byte[12];
      ByteDataConvertUtil.BinnCat(this.mSmsContent, (byte[])localObject1, 0, 12);
      this.mSmsMessage.smsContent = ((byte[])localObject1);
    }
    for (;;)
    {
      this.mCore.writeForce(NotifyCmd.getInstance().getIncomingMessageCmd(this.mSmsMessage));
      return;
      str = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("address"));
      localObject1 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("person"));
      localStringBuffer.append(((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("body")));
      l1 = ((Cursor)localObject2).getLong(((Cursor)localObject2).getColumnIndex("date"));
      ((Cursor)localObject2).getInt(((Cursor)localObject2).getColumnIndex("read"));
      break;
      i = 0;
      break label154;
      k = 0;
      break label165;
      j = 0;
      break label176;
      localObject2[k] = ((byte)(arrayOfChar[m] & 0xFF));
      m += 1;
      k += 1;
      break label234;
      this.mSmsContent = null;
      this.mSmsMessage.numberLength = 0;
      break label256;
      this.mSmsContent = ((byte[])localObject1);
      break label310;
      label653:
      this.mSmsMessage.contactLength = 0;
      break label320;
      label664:
      this.mSmsContent = localUnsupportedEncodingException1;
      break label357;
      this.mSmsMessage.contentLength = 0;
      break label367;
      label694:
      this.mSmsMessage.totalPacket = 1;
      byte[] arrayOfByte = new byte[this.mSmsContent.length];
      ByteDataConvertUtil.BinnCat(this.mSmsContent, arrayOfByte, 0, this.mSmsContent.length);
      this.mSmsMessage.smsContent = arrayOfByte;
      continue;
      label738:
      this.mSmsMessage.totalPacket = 1;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    DebugLog.d("onCreate ");
    this.mCore.addListener(this.mAppListener);
    registerPhoneListener();
    initTimeMode();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    registerReceiver(this.receiver, localIntentFilter);
    this.smsObserver = new SmsObserver(this, this.handler);
    getContentResolver().registerContentObserver(this.SMS_URI, true, this.smsObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.receiver);
  }
  
  class SmsObserver
    extends ContentObserver
  {
    public SmsObserver(Context paramContext, Handler paramHandler)
    {
      super();
    }
    
    public boolean deliverSelfNotifications()
    {
      return super.deliverSelfNotifications();
    }
    
    public void onChange(boolean paramBoolean)
    {
      AssistService.this.d("onChange selfChange:" + paramBoolean);
      if (AppSharedPreferences.getInstance().getDeviceMsgNoticeSwitch()) {
        AssistService.this.handler.postDelayed(new Runnable()
        {
          public void run()
          {
            AssistService.this.getSmsFromPhone();
          }
        }, 3000L);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\service\AssistService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */