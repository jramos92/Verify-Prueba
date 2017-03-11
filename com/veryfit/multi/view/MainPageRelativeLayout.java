package com.veryfit.multi.view;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.AlarmNotify;
import com.project.library.device.cmd.getinfo.GetInfoCmd;
import com.project.library.device.cmd.health.HealthSyncRequest;
import com.project.library.device.cmd.settings.AntilostInfos;
import com.project.library.device.cmd.settings.MultiTarget;
import com.project.library.device.cmd.settings.Sedentariness;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.device.cmd.settings.Units;
import com.project.library.device.cmd.settings.Userinfos;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.MainActivity;
import com.veryfit.multi.ui.activity.device.AddDeviceActivity;
import com.veryfit.multi.ui.fragment.inter.NotifyParentFragment;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.group.FreshView;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainPageRelativeLayout
  extends RelativeLayout
{
  private static final int DURATION = 500;
  private static final int MIN_SCROLL = 100;
  final BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
  private int freshHeight;
  private FreshView freshView;
  public boolean hasSync = false;
  private boolean isHealthDataSyncing = false;
  private boolean isIntercept;
  private boolean isOff = true;
  private boolean isReconnection = false;
  private boolean isUp = true;
  private ImageButton link_state;
  private ConcurrentLinkedQueue<AlarmNotify> mAlarmList = new ConcurrentLinkedQueue();
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  private CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private APPCoreServiceListener mCoreServiceListener = new APPCoreServiceListener()
  {
    public void onBLEConnected()
    {
      MainPageRelativeLayout.this.isReconnection = true;
      MainPageRelativeLayout.this.link_state.setImageResource(2130837627);
      MainPageRelativeLayout.this.isOff = false;
      if (((!MainPageRelativeLayout.this.hasSync) || (MainPageRelativeLayout.this.getPaddingTop() == 0)) && (!"".equals(AppSharedPreferences.getInstance().getBindDeviceAddr())))
      {
        LibSharedPreferences.getInstance().setSyncData(true);
        if ((!MainPageRelativeLayout.this.mCore.writeForce(SettingsCmd.getInstance().getTimeSettingsCmd())) && (!MainPageRelativeLayout.this.mCore.writeForce(SettingsCmd.getInstance().getTimeSettingsCmd()))) {
          MainPageRelativeLayout.this.mCore.writeForce(SettingsCmd.getInstance().getTimeSettingsCmd());
        }
      }
    }
    
    public void onBLEConnecting() {}
    
    public void onBLEDisConnected(String paramAnonymousString)
    {
      MainPageRelativeLayout.this.isReconnection = false;
      MainPageRelativeLayout.this.link_state.setImageResource(2130837725);
      DebugLog.d("isHealthDataSyncing =" + MainPageRelativeLayout.this.isHealthDataSyncing);
      MainPageRelativeLayout.this.isOff = true;
      if (MainPageRelativeLayout.this.isHealthDataSyncing)
      {
        MainPageRelativeLayout.this.onFinishUpdate(false);
        MainPageRelativeLayout.this.isHealthDataSyncing = false;
      }
      MainPageRelativeLayout.this.hasSync = false;
      if (LibSharedPreferences.getInstance().isSyncData()) {
        LibSharedPreferences.getInstance().setSyncData(false);
      }
    }
    
    public void onBindUnbind(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 20)
      {
        LibSharedPreferences.getInstance().setSyncData(false);
        if (MainPageRelativeLayout.this.isHealthDataSyncing)
        {
          MainPageRelativeLayout.this.onFinishUpdate(false);
          MainPageRelativeLayout.this.isHealthDataSyncing = false;
        }
        MainPageRelativeLayout.this.link_state.setImageResource(2130837725);
      }
      do
      {
        do
        {
          return;
        } while (paramAnonymousByte != 18);
        MainPageRelativeLayout.this.mAppSharedPreferences.setLiftWristSwitch(true);
      } while (MainPageRelativeLayout.this.getPaddingTop() != 0);
      MainPageRelativeLayout.this.stopAnim();
    }
    
    public void onBlueToothError(int paramAnonymousInt)
    {
      if (paramAnonymousInt == -66) {
        MainPageRelativeLayout.this.initBlue();
      }
      while ((paramAnonymousInt != -55) || (MainPageRelativeLayout.this.getPaddingTop() != 0)) {
        return;
      }
      MainPageRelativeLayout.this.freshView.setState(5);
      MainPageRelativeLayout.this.stopAnim();
    }
    
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte)
    {
      DebugLog.e("超时。。");
      if ((MainPageRelativeLayout.this.getPaddingTop() == 0) && (MainPageRelativeLayout.this.getPaddingTop() == 0))
      {
        MainPageRelativeLayout.this.freshView.setState(5);
        MainPageRelativeLayout.this.stopAnim();
      }
    }
    
    public void onGetInfo(byte paramAnonymousByte)
    {
      DebugLog.i("---------isReconnection：" + MainPageRelativeLayout.this.isReconnection);
      if (MainPageRelativeLayout.this.isReconnection)
      {
        MainPageRelativeLayout.this.isReconnection = false;
        if (paramAnonymousByte == 2) {
          MainPageRelativeLayout.this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
        }
        if (paramAnonymousByte == 1)
        {
          if (LibSharedPreferences.getInstance().getReBoot() != 1) {
            break label94;
          }
          DebugLog.i(">>获取设备信息成功,需要初始化设置值，正在发送个人信息设置");
          MainPageRelativeLayout.this.sendUnitSet();
        }
      }
      return;
      label94:
      MainPageRelativeLayout.this.onStartUpdate();
    }
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        switch (paramAnonymousByte)
        {
        default: 
        case 1: 
          do
          {
            return;
          } while (!MainPageRelativeLayout.this.isReconnection);
          DebugLog.i(">>时间设置成功,获取设备信息");
          MainPageRelativeLayout.this.sendGetDeviceFun();
          return;
        case 2: 
          DebugLog.i(">>闹钟设置成功");
          MainPageRelativeLayout.this.onReciveSettingAlarm();
          return;
        case 32: 
          DebugLog.i(">>久坐设置成功");
          MainPageRelativeLayout.this.onReviceSettingRemindSport();
          return;
        case 33: 
          DebugLog.i(">>防丢设置成功");
          MainPageRelativeLayout.this.onReciveLost();
          return;
        case 16: 
          DebugLog.i(">>用户信息设置成功");
          MainPageRelativeLayout.this.onReciveUserInfo();
          return;
        case 3: 
          DebugLog.i(">>运动目标设置成功");
          MainPageRelativeLayout.this.onReciveMultiTarget();
          return;
        case 17: 
          DebugLog.i(">>单位设置成功");
          MainPageRelativeLayout.this.onRecivesendUnit();
          return;
        }
        DebugLog.i(">>寻找手机设置成功");
        MainPageRelativeLayout.this.onReciveFindPhone();
        return;
      }
      DebugLog.e("设置失败： " + paramAnonymousByte);
    }
  };
  private FindPhoneRunnable mFindPhoneRunnable = null;
  private Handler mHandle = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      MainPageRelativeLayout.this.mHandle.post(new Runnable()
      {
        public void run()
        {
          if (MainPageRelativeLayout.this.isHealthDataSyncing)
          {
            MainPageRelativeLayout localMainPageRelativeLayout = MainPageRelativeLayout.this;
            localMainPageRelativeLayout.mProcess += 1;
            if (MainPageRelativeLayout.this.mProcess > 97)
            {
              MainPageRelativeLayout.this.mProcess = 98;
              MainPageRelativeLayout.this.isUp = false;
            }
            DebugLog.d("mProcess--" + MainPageRelativeLayout.this.mProcess);
            MainPageRelativeLayout.this.freshView.setState(3);
            MainPageRelativeLayout.this.freshView.setState(3, MainPageRelativeLayout.this.mProcess);
            if (MainPageRelativeLayout.this.isUp) {
              MainPageRelativeLayout.this.mHandle.sendEmptyMessageDelayed(1, 100L);
            }
          }
        }
      });
    }
  };
  private NotifyParentFragment mHealthDataChangedListener = null;
  private int mProcess = 0;
  private float startY;
  
  public MainPageRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void initBlue()
  {
    if ((this.mCore.isAvailable()) && (!this.mCore.isDeviceConnected()) && (this.mCore.initBLE((byte)0)))
    {
      String str = AppSharedPreferences.getInstance().getBindDeviceAddr();
      if (!TextUtils.isEmpty(str))
      {
        Log.e("debug", "蓝牙测试555555N_。。。" + str);
        this.mCore.connect(str);
      }
    }
  }
  
  private void initTimeMode()
  {
    String str = Settings.System.getString(getContext().getContentResolver(), "time_12_24");
    if ("24".equals(str)) {
      AppSharedPreferences.getInstance().setTimeMode(true);
    }
    while (!"12".equals(str)) {
      return;
    }
    AppSharedPreferences.getInstance().setTimeMode(false);
  }
  
  private void onReciveSettingAlarm()
  {
    if (this.mAlarmList.size() > 0) {
      this.mAlarmList.poll();
    }
    AlarmNotify localAlarmNotify = (AlarmNotify)this.mAlarmList.peek();
    if (localAlarmNotify == null)
    {
      DebugLog.d(">>闹钟发送完毕,发送防丢");
      sendLost();
    }
    while (localAlarmNotify == null) {
      return;
    }
    this.mCore.write(SettingsCmd.getInstance().getAlarmClockSettingsCmd(localAlarmNotify));
  }
  
  private void sendAlarms()
  {
    this.mAlarmList.clear();
    Iterator localIterator = TempUtil.getAlarms().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (!this.mAlarmList.isEmpty()) {
          break;
        }
        DebugLog.d(">>闹钟发送完毕,发送防丢");
        sendLost();
        return;
      }
      AlarmNotify localAlarmNotify = (AlarmNotify)localIterator.next();
      this.mAlarmList.add(localAlarmNotify);
    }
    this.mCore.write(SettingsCmd.getInstance().getAlarmClockSettingsCmd((AlarmNotify)this.mAlarmList.peek()));
  }
  
  private void sendFindPhone()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() & 0x8) >> 3 == 1)
    {
      boolean bool = this.mAppSharedPreferences.getDeviceFoundPhoneSwitch();
      if (bool)
      {
        if ((!this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool))) && (!this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool)))) {
          this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool));
        }
        AppSharedPreferences.getInstance().setDeviceFoundPhoneSwitch(bool);
        this.mFindPhoneRunnable = new FindPhoneRunnable();
        this.mHandle.postDelayed(this.mFindPhoneRunnable, 3000L);
        return;
      }
      DebugLog.d(">>寻找手机发送成功，发送完毕");
      synce();
      return;
    }
    DebugLog.d(">>不支持寻找手机，发送完毕");
    synce();
  }
  
  private void sendLost()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() >> 1 & 0x1) == 1)
    {
      if (1 == AppSharedPreferences.getInstance().getAntilost())
      {
        localAntilostInfos = new AntilostInfos();
        localAntilostInfos.mode = 1;
        this.mCore.write(SettingsCmd.getInstance().getAntilostSettingsCmd(localAntilostInfos));
        return;
      }
      AntilostInfos localAntilostInfos = new AntilostInfos();
      localAntilostInfos.mode = 0;
      this.mCore.write(SettingsCmd.getInstance().getAntilostSettingsCmd(localAntilostInfos));
      return;
    }
    DebugLog.d(">>不支持防丢，发送久坐");
    sendRemindSport();
  }
  
  private void sendRemindSport()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() & 0x1) == 1)
    {
      Sedentariness localSedentariness = new Sedentariness();
      AppSharedPreferences localAppSharedPreferences = AppSharedPreferences.getInstance();
      localSedentariness.repetitions = localAppSharedPreferences.getDeviceRemindSportRepetitions();
      localSedentariness.startHour = localAppSharedPreferences.getDeviceRemindSportStartHour();
      localSedentariness.startMinute = localAppSharedPreferences.getDeviceRemindSportStartMin();
      localSedentariness.endHour = localAppSharedPreferences.getDeviceRemindSportEndHour();
      localSedentariness.endMinute = localAppSharedPreferences.getDeviceRemindSportEndMin();
      localSedentariness.interval = localAppSharedPreferences.getDeviceRemindSportInterval();
      this.mCore.write(SettingsCmd.getInstance().getSedentarinessSettingsCmd(localSedentariness));
      return;
    }
    DebugLog.d(">>不支持久坐，发送寻找手机");
    sendFindPhone();
  }
  
  private void sendUnitSet()
  {
    int i = 1;
    initTimeMode();
    DebugLog.i(">>设置单位");
    Units localUnits = new Units();
    localUnits.setMode(AppSharedPreferences.getInstance().getUnitType());
    String str = getResources().getConfiguration().locale.toString();
    if (str.contains("zh"))
    {
      localUnits.language = 1;
      if (!this.mAppSharedPreferences.getUserSex()) {
        break label134;
      }
      localUnits.stride = ((int)(this.mAppSharedPreferences.getUserHeight() * 0.415D));
      label86:
      if (!AppSharedPreferences.getInstance().is24TimeMode()) {
        break label154;
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
      label134:
      localUnits.stride = ((int)(this.mAppSharedPreferences.getUserHeight() * 0.413D));
      break label86;
      label154:
      i = 2;
    }
  }
  
  private void stopAnim()
  {
    postDelayed(new Runnable()
    {
      public void run()
      {
        if (MainPageRelativeLayout.this.getPaddingTop() == 0) {
          ObjectAnimator.ofInt(MainPageRelativeLayout.this, "paddingTop", new int[] { 0, -MainPageRelativeLayout.this.getFreshViewHeight() }).setDuration(500L).start();
        }
      }
    }, 1000L);
  }
  
  private void synce()
  {
    this.isHealthDataSyncing = true;
    LibSharedPreferences.getInstance().setSyncData(true);
    if (AppSharedPreferences.getInstance().getSyncHealdataMode()) {}
    for (byte b = 1;; b = 0)
    {
      this.mCore.writeForce(HealthSyncRequest.getInstance().getHealthSyncRequestCmd((byte)1, b));
      return;
    }
  }
  
  public void addAppListener()
  {
    this.mCore.addListener(this.mCoreServiceListener);
  }
  
  public int getFreshViewHeight()
  {
    if (this.freshHeight == 0) {
      this.freshHeight = this.freshView.getMeasuredHeight();
    }
    return this.freshHeight;
  }
  
  public void init(NotifyParentFragment paramNotifyParentFragment)
  {
    this.hasSync = false;
    this.mHealthDataChangedListener = paramNotifyParentFragment;
    this.mCore.addListener(this.mCoreServiceListener);
    this.freshView = ((FreshView)findViewById(2131231000));
    this.link_state = ((ImageButton)findViewById(2131231003));
    if (this.mCore.isDeviceConnected()) {
      this.link_state.setImageResource(2130837627);
    }
    for (;;)
    {
      getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          MainPageRelativeLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
          MainPageRelativeLayout.this.setPaddingTop(-MainPageRelativeLayout.this.getFreshViewHeight());
          if ((!MainPageRelativeLayout.this.hasSync) && (MainPageRelativeLayout.this.mCore.isDeviceConnected()) && (!AppSharedPreferences.getInstance().isFirstStartApp())) {
            MainPageRelativeLayout.this.onStartUpdate();
          }
          return false;
        }
      });
      return;
      this.link_state.setImageResource(2130837725);
    }
  }
  
  public boolean isHealthDataSyncing()
  {
    return LibSharedPreferences.getInstance().isSyncData();
  }
  
  public void onFinishUpdate(boolean paramBoolean)
  {
    this.isHealthDataSyncing = false;
    this.isUp = true;
    if (paramBoolean) {
      this.freshView.setState(4);
    }
    for (;;)
    {
      if ((this.mHealthDataChangedListener != null) && (paramBoolean)) {
        this.mHealthDataChangedListener.onHealthDataChanged();
      }
      if (paramBoolean) {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            LibSharedPreferences.getInstance().setSyncData(false);
          }
        }, 1000L);
      }
      stopAnim();
      return;
      this.freshView.setState(5);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return this.isIntercept;
      if ((paramMotionEvent.getY() - this.startY > 100.0F) && (getPaddingTop() == -getFreshViewHeight()))
      {
        this.isIntercept = true;
        continue;
        this.startY = paramMotionEvent.getY();
        this.isIntercept = false;
        continue;
        this.startY = 0.0F;
        this.isIntercept = false;
      }
    }
  }
  
  protected void onReciveFindPhone()
  {
    if (this.mFindPhoneRunnable != null) {
      this.mHandle.removeCallbacks(this.mFindPhoneRunnable);
    }
    DebugLog.d(">>寻找手机发送成功，发送完毕");
    synce();
  }
  
  protected void onReciveLost()
  {
    DebugLog.d(">>防丢发送成功，发送久坐");
    sendRemindSport();
  }
  
  protected void onReciveMultiTarget()
  {
    DebugLog.i(">>设置运动目标信息成功，设置闹钟");
    sendAlarms();
  }
  
  protected void onReciveUserInfo()
  {
    DebugLog.i(">>设置用户信息成功，设置运动目标信息");
    setMultiTarget();
  }
  
  protected void onRecivesendUnit()
  {
    DebugLog.i(">>设置单位成功，设置时间、。");
    setUserInfo();
  }
  
  protected void onReviceSettingRemindSport()
  {
    DebugLog.d(">>久坐发送成功，发送寻找手机");
    sendFindPhone();
  }
  
  public void onStartUpdate()
  {
    long l1 = AppSharedPreferences.getInstance().getLastSyncTime();
    long l2 = System.currentTimeMillis();
    if ((l1 == 0L) || ((l2 - l1) / 1000L / 60L >= 15L))
    {
      AppSharedPreferences.getInstance().setLastSyncTime(l2);
      if (!AppSharedPreferences.getInstance().getFirstupdateApp()) {
        onStartUpdate2();
      }
      return;
    }
    if ((this.mCore.isDeviceConnected()) && (this.freshView.getState() == 7))
    {
      AppSharedPreferences.getInstance().setLastSyncTime(l2);
      onStartUpdate2();
      return;
    }
    LibSharedPreferences.getInstance().setSyncData(false);
    DebugLog.e("***********************15分钟之内不进行自动同步***********************");
  }
  
  public void onStartUpdate2()
  {
    int i;
    if (this.mCore.isDeviceConnected())
    {
      if ((!this.hasSync) && (getPaddingTop() == -getFreshViewHeight()))
      {
        ObjectAnimator.ofInt(this, "paddingTop", new int[] { -getFreshViewHeight(), 0 }).setDuration(500L).start();
        this.freshView.setState(3);
      }
      DebugLog.i(">>开始设置时间，接下来开始同步数据");
      MainActivity.cancelTimer();
      i = 0;
      if (!this.mCore.writeForce(SettingsCmd.getInstance().getTimeSettingsCmd())) {}
    }
    do
    {
      this.mHandle.postDelayed(new Runnable()
      {
        public void run()
        {
          MainPageRelativeLayout.this.synce();
        }
      }, 1000L);
      do
      {
        return;
      } while (i > 3);
      i += 1;
      break;
      DebugLog.d("设备未连接");
      if ((this.mCore != null) && (AppSharedPreferences.getInstance().getBindDeviceAddr() != null)) {
        this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
      }
    } while (getPaddingTop() != 0);
    stopAnim();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (this.freshView.getState() == 3) {
      return false;
    }
    int i = getPaddingTop();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      setPaddingTop(Math.max(-getFreshViewHeight(), Math.min(0, (int)(paramMotionEvent.getY() - this.startY) - getFreshViewHeight() - 100)));
      if (i < 0)
      {
        this.freshView.setState(1);
      }
      else if (i >= 0)
      {
        this.freshView.setState(2);
        continue;
        if ((i < 0) && (i > -getFreshViewHeight())) {
          ObjectAnimator.ofInt(this, "paddingTop", new int[] { i, -getFreshViewHeight() }).setDuration((500.0F / getFreshViewHeight() * -i)).start();
        } else if (i >= 0) {
          if ("".equals(AppSharedPreferences.getInstance().getBindDeviceAddr()))
          {
            showBoundBleDialog(getContext());
          }
          else if (!this.adapter.isEnabled())
          {
            this.freshView.setState(9);
            if (this.adapter.enable())
            {
              initBlue();
              this.freshView.setState(7);
              this.mHandle.postDelayed(new Runnable()
              {
                public void run()
                {
                  MainPageRelativeLayout.this.stopAnim();
                }
              }, 1000L);
            }
            else
            {
              this.freshView.setState(5);
              stopAnim();
            }
          }
          else if ((this.adapter.isEnabled()) && (!this.mCore.isDeviceConnected()))
          {
            paramMotionEvent = AppSharedPreferences.getInstance().getBindDeviceAddr();
            if (!TextUtils.isEmpty(paramMotionEvent))
            {
              Log.d("debug", "连接设备_。。。" + paramMotionEvent);
              this.mCore.connect(paramMotionEvent);
            }
            this.freshView.setState(7);
          }
          else if (!this.isOff)
          {
            this.freshView.setState(3);
            onStartUpdate2();
          }
          else
          {
            this.freshView.setText(getResources().getString(2131296568));
            onStartUpdate2();
          }
        }
      }
    }
  }
  
  public void removeAppListener()
  {
    this.mCore.removeListener(this.mCoreServiceListener);
  }
  
  protected void sendGetDeviceFun()
  {
    if (LibSharedPreferences.getInstance().getDeviceFunMain() == -1)
    {
      DebugLog.d(">>获取功能表");
      this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
      return;
    }
    DebugLog.d(">>功能表已获取，获取设备信息");
    this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
  }
  
  public void setLinkState()
  {
    if ((this.mCore != null) && (this.mCore.isDeviceConnected()))
    {
      this.link_state.setImageResource(2130837627);
      return;
    }
    this.link_state.setImageResource(2130837725);
  }
  
  public void setMultiTarget()
  {
    int[] arrayOfInt = TempUtil.getGoal(LongDateUtil.Calendar2LongDate(Calendar.getInstance()));
    MultiTarget localMultiTarget = new MultiTarget();
    localMultiTarget.sportType = 0;
    localMultiTarget.sportTarget = arrayOfInt[0];
    localMultiTarget.sleepFlag = 0;
    localMultiTarget.sleepHour = (arrayOfInt[1] / 60);
    localMultiTarget.sleepMinute = (arrayOfInt[1] % 60);
    this.mCore.writeForce(SettingsCmd.getInstance().getMultiTargetSettingsCmd(localMultiTarget));
  }
  
  public void setPaddingTop(int paramInt)
  {
    setPadding(getPaddingRight(), paramInt, getPaddingRight(), getPaddingBottom());
    invalidate();
  }
  
  protected void setUserInfo()
  {
    Userinfos localUserinfos = new Userinfos();
    localUserinfos.height = this.mAppSharedPreferences.getUserHeight();
    localUserinfos.weight = this.mAppSharedPreferences.getUserWeight();
    if (this.mAppSharedPreferences.getUserSex()) {}
    for (int i = 0;; i = 1)
    {
      localUserinfos.gender = i;
      localUserinfos.year = this.mAppSharedPreferences.getUserBirthdayYear();
      localUserinfos.month = this.mAppSharedPreferences.getUserBirthdayMonth();
      localUserinfos.day = this.mAppSharedPreferences.getUserBirthdayDay();
      this.mCore.write(SettingsCmd.getInstance().getUserinfosSettingsCmd(localUserinfos));
      return;
    }
  }
  
  public void showBoundBleDialog(final Context paramContext)
  {
    final Dialog localDialog = new Dialog(paramContext, 2131427337);
    localDialog.setContentView(2130903078);
    localDialog.getWindow().setGravity(17);
    localDialog.setCancelable(false);
    ((TextView)localDialog.findViewById(2131230923)).setText(paramContext.getResources().getString(2131296654));
    Button localButton1 = (Button)localDialog.findViewById(2131230925);
    Button localButton2 = (Button)localDialog.findViewById(2131230926);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        MainPageRelativeLayout.this.freshView.setState(5);
        MainPageRelativeLayout.this.stopAnim();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        if (MainPageRelativeLayout.this.getPaddingTop() == 0) {
          MainPageRelativeLayout.this.stopAnim();
        }
        paramContext.startActivity(new Intent(paramContext, AddDeviceActivity.class));
      }
    });
    localDialog.show();
  }
  
  public void startSyncAnim() {}
  
  public void syncData(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 100) {
      i = 100;
    }
    if (getPaddingTop() == -getFreshViewHeight())
    {
      this.isHealthDataSyncing = true;
      ObjectAnimator.ofInt(this, "paddingTop", new int[] { -getFreshViewHeight(), 0 }).setDuration(500L).start();
      this.freshView.setState(3);
      this.freshView.setState(3, i);
    }
    this.freshView.setState(3, i);
    if (i == 100)
    {
      AppSharedPreferences.getInstance().setDeviceSyncEndTime(Calendar.getInstance());
      onFinishUpdate(true);
      this.hasSync = true;
      this.isHealthDataSyncing = false;
    }
  }
  
  class FindPhoneRunnable
    implements Runnable
  {
    FindPhoneRunnable() {}
    
    public void run()
    {
      MainPageRelativeLayout.this.synce();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\MainPageRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */