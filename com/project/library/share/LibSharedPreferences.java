package com.project.library.share;

import android.content.Context;

public class LibSharedPreferences
  extends CommonPreferences
{
  private static final String DEBUG = "debug";
  private static final String DEVICE_ALARM_MAX_COUNT = "device_alarm_max_count";
  private static final String DEVICE_ENERGE = "device_energe";
  private static final String DEVICE_FIRM_WARE_VERSION = "device_firm_ware_version";
  private static final String DEVICE_FUN_ALARM_NOTIFY = "DEVICE_FUN_ALARM_NOTIFY";
  private static final String DEVICE_FUN_CALL_NOTIFY = "DEVICE_FUN_CALL_NOTIFY";
  private static final String DEVICE_FUN_CONTROL = "DEVICE_FUN_CONTROL";
  private static final String DEVICE_FUN_MAIN = "DEVICE_FUN_MAIN";
  private static final String DEVICE_FUN_MSG_NOTIFY = "DEVICE_FUN_MSG_NOTIFY";
  private static final String DEVICE_FUN_MSG_NOTIFY2 = "DEVICE_FUN_MSG_NOTIFY2";
  private static final String DEVICE_FUN_OTHER2_DISPLAYMODE = "DEVICE_FUN_OTHER2_DISPLAYMODE";
  private static final String DEVICE_FUN_OTHER2_DISTURBMODE = "DEVICE_FUN_OTHER2_DISTURBMODE";
  private static final String DEVICE_FUN_OTHER2_LEFTRIGHTMODE = "DEVICE_FUN_OTHER2_LEFTRIGHTMODE";
  private static final String DEVICE_FUN_OTHER2_STATICHEART = "DEVICE_FUN_OTHER2_STATICHEART";
  private static final String DEVICE_FUN_OTHER_NOTIFY = "DEVICE_FUN_OTHER_NOTIFY";
  private static final String DEVICE_FUN_TIP_INFO_NOTIFY = "DEVICE_FUN_TIP_INFO_NOTIFY";
  private static final String DEVICE_HEART_RATE = "device_heart_rate";
  private static final String DEVICE_ID = "device_id";
  private static final String DEVICE_REAL_TIME = "device_real_time";
  private static final String DEVICE_REBOOT = "device_reboot";
  private static final String DEVICE_SYNC_DATA = "device_need_sync_data";
  private static final String HEART_RATE = "heart_rate";
  private static final String HEART_RATE_MAX = "heart_rate_max";
  private static final String HEART_RATE_MIN = "heart_rate_min";
  private static final String IS_FIRWARE_UPGRADE = "IS_FIRWARE_UPGRADE";
  private static final String REAL_CALORIES = "real_calories";
  private static final String REAL_DISTANCES = "real_distances";
  private static final String REAL_STEP = "real_step";
  private static final String SET_MAIN_SYNC_DATA = "SET_MAIN_SYNC_DATA";
  private static final String SET_UNITS = "SET_UNITS";
  private static final String SP_NAME = "veryfit_multi_app_lib";
  private static final String SUPPORT_ALL_NOTIFY = "SUPPORT_ALL_NOTIFY";
  private static final String SUPPORT_ROTA = "SUPPORT_ROTA";
  private static LibSharedPreferences instance;
  
  public static final LibSharedPreferences getInstance()
  {
    if (instance == null) {
      instance = new LibSharedPreferences();
    }
    return instance;
  }
  
  public boolean getAllNotify()
  {
    return getValue("SUPPORT_ALL_NOTIFY", false);
  }
  
  public boolean getDebug()
  {
    return getValue("debug", false);
  }
  
  public int getDeviceAlarmMaxCount()
  {
    return getValue("device_alarm_max_count", -1);
  }
  
  public int getDeviceCallNotify()
  {
    return getValue("DEVICE_FUN_CALL_NOTIFY", -1);
  }
  
  public int getDeviceEnerge()
  {
    return getValue("device_energe", 0);
  }
  
  public int getDeviceFirmwareVersion()
  {
    return getValue("device_firm_ware_version", 0);
  }
  
  public int getDeviceFunAlarmNotify()
  {
    return getValue("DEVICE_FUN_ALARM_NOTIFY", -1);
  }
  
  public int getDeviceFunControl()
  {
    return getValue("DEVICE_FUN_CONTROL", -1);
  }
  
  public int getDeviceFunMain()
  {
    return getValue("DEVICE_FUN_MAIN", -1);
  }
  
  public int getDeviceFunMsgNotify()
  {
    return getValue("DEVICE_FUN_MSG_NOTIFY", -1);
  }
  
  public int getDeviceFunMsgNotify2()
  {
    return getValue("DEVICE_FUN_MSG_NOTIFY2", -1);
  }
  
  public boolean getDeviceFunOther2DisplayMode()
  {
    return getValue("DEVICE_FUN_OTHER2_DISPLAYMODE", false);
  }
  
  public boolean getDeviceFunOther2DisturbMode()
  {
    return getValue("DEVICE_FUN_OTHER2_DISTURBMODE", false);
  }
  
  public boolean getDeviceFunOther2LeftRightMode()
  {
    return getValue("DEVICE_FUN_OTHER2_LEFTRIGHTMODE", false);
  }
  
  public boolean getDeviceFunOther2Staticheart()
  {
    return getValue("DEVICE_FUN_OTHER2_STATICHEART", false);
  }
  
  public int getDeviceFunOtherNotify()
  {
    return getValue("DEVICE_FUN_OTHER_NOTIFY", -1);
  }
  
  public int getDeviceFunTipInfoNotify()
  {
    return getValue("DEVICE_FUN_TIP_INFO_NOTIFY", -1);
  }
  
  public boolean getDeviceHeartRate()
  {
    return getValue("device_heart_rate", false);
  }
  
  public int getDeviceId()
  {
    return getValue("device_id", 0);
  }
  
  public boolean getDeviceRealTime()
  {
    return getValue("device_real_time", false);
  }
  
  public int getHeartRate()
  {
    return getValue("heart_rate", 0);
  }
  
  public int getHeartRateMax()
  {
    return getValue("heart_rate_max", 255);
  }
  
  public int getHeartRateMin()
  {
    return getValue("heart_rate_min", 30);
  }
  
  public int getReBoot()
  {
    return getValue("device_reboot", 0);
  }
  
  public int getRealCalories()
  {
    return getValue("real_calories", 0);
  }
  
  public int getRealDistances()
  {
    return getValue("real_distances", 0);
  }
  
  public int getRealStep()
  {
    return getValue("real_step", 0);
  }
  
  public boolean getRota()
  {
    return getValue("SUPPORT_ROTA", false);
  }
  
  public boolean getUnits()
  {
    return getValue("SET_UNITS", false);
  }
  
  public void init(Context paramContext)
  {
    super.init(paramContext, "veryfit_multi_app_lib");
  }
  
  public boolean isFirwareUpgrade()
  {
    return getValue("IS_FIRWARE_UPGRADE", false);
  }
  
  public boolean isSyncData()
  {
    return getValue("device_need_sync_data", true);
  }
  
  public void setAllNotify(boolean paramBoolean)
  {
    setValue("SUPPORT_ALL_NOTIFY", paramBoolean);
  }
  
  public void setDebug(boolean paramBoolean)
  {
    setValue("debug", paramBoolean);
  }
  
  public void setDeviceAlarmMaxCount(int paramInt)
  {
    setValue("device_alarm_max_count", paramInt);
  }
  
  public void setDeviceEnerge(int paramInt)
  {
    setValue("device_energe", paramInt);
  }
  
  public void setDeviceFirmwareVersion(int paramInt)
  {
    setValue("device_firm_ware_version", paramInt);
  }
  
  public void setDeviceFunAlarmNotify(int paramInt)
  {
    setValue("DEVICE_FUN_ALARM_NOTIFY", paramInt);
  }
  
  public void setDeviceFunCallNotify(int paramInt)
  {
    setValue("DEVICE_FUN_CALL_NOTIFY", paramInt);
  }
  
  public void setDeviceFunControl(int paramInt)
  {
    setValue("DEVICE_FUN_CONTROL", paramInt);
  }
  
  public void setDeviceFunMain(int paramInt)
  {
    setValue("DEVICE_FUN_MAIN", paramInt);
  }
  
  public void setDeviceFunMsgNotify(int paramInt)
  {
    setValue("DEVICE_FUN_MSG_NOTIFY", paramInt);
  }
  
  public void setDeviceFunMsgNotify2(int paramInt)
  {
    setValue("DEVICE_FUN_MSG_NOTIFY2", paramInt);
  }
  
  public void setDeviceFunOther2DisplayMode(boolean paramBoolean)
  {
    setValue("DEVICE_FUN_OTHER2_DISPLAYMODE", paramBoolean);
  }
  
  public void setDeviceFunOther2DisturbMode(boolean paramBoolean)
  {
    setValue("DEVICE_FUN_OTHER2_DISTURBMODE", paramBoolean);
  }
  
  public void setDeviceFunOther2LeftRightMode(boolean paramBoolean)
  {
    setValue("DEVICE_FUN_OTHER2_LEFTRIGHTMODE", paramBoolean);
  }
  
  public void setDeviceFunOther2Staticheart(boolean paramBoolean)
  {
    setValue("DEVICE_FUN_OTHER2_STATICHEART", paramBoolean);
  }
  
  public void setDeviceFunOtherNotify(int paramInt)
  {
    setValue("DEVICE_FUN_OTHER_NOTIFY", paramInt);
  }
  
  public void setDeviceFunTipInfoNotify(int paramInt)
  {
    setValue("DEVICE_FUN_TIP_INFO_NOTIFY", paramInt);
  }
  
  public void setDeviceHeartRate(boolean paramBoolean)
  {
    setValue("device_heart_rate", paramBoolean);
  }
  
  public void setDeviceId(int paramInt)
  {
    setValue("device_id", paramInt);
  }
  
  public void setDeviceRealTime(boolean paramBoolean)
  {
    setValue("device_real_time", paramBoolean);
  }
  
  public void setHeartRate(int paramInt)
  {
    setValue("heart_rate", paramInt);
  }
  
  public void setHeartRateMax(int paramInt)
  {
    setValue("heart_rate_max", paramInt);
  }
  
  public void setHeartRateMin(int paramInt)
  {
    setValue("heart_rate_min", paramInt);
  }
  
  public void setIsFirwareUpgrade(boolean paramBoolean)
  {
    setValue("IS_FIRWARE_UPGRADE", paramBoolean);
  }
  
  public void setReBoot(int paramInt)
  {
    setValue("device_reboot", paramInt);
  }
  
  public void setRealCalories(int paramInt)
  {
    setValue("real_calories", paramInt);
  }
  
  public void setRealDistances(int paramInt)
  {
    setValue("real_distances", paramInt);
  }
  
  public void setRealStep(int paramInt)
  {
    setValue("real_step", paramInt);
  }
  
  public void setRota(boolean paramBoolean)
  {
    setValue("SUPPORT_ROTA", paramBoolean);
  }
  
  public void setSyncData(boolean paramBoolean)
  {
    setValue("device_need_sync_data", paramBoolean);
  }
  
  public void setUnits(boolean paramBoolean)
  {
    setValue("SET_UNITS", paramBoolean);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\share\LibSharedPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */