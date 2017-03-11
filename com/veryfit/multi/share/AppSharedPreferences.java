package com.veryfit.multi.share;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.project.library.share.CommonPreferences;
import com.veryfit.multi.util.TempUtil;
import java.util.Calendar;

public class AppSharedPreferences
  extends CommonPreferences
{
  private static final String APP_THEME_PACKAGE = "app_theme_package";
  private static final String APP_VERSION_NAME = "APP_VERSION_NAME";
  private static final String BIND_DEVICE_ADDR = "bind_device_addr";
  private static final String BIND_DEVICE_NAME = "bind_device_name";
  private static String DATA_BACKUP_TIME;
  private static final String DEVICE_ANTILOST_MODE = "DEVICE_ANTILOST_MODE";
  private static String DEVICE_BELL_VIBRATE_SWITCH = "DEVICE_BELL_VIBRATE_SWITCH";
  private static String DEVICE_FOUND_PHONE_SWITCH;
  private static String DEVICE_HEART_RATE_AUTO_DETECT_VALUE = "DEVICE_HEART_RATE_AUTO_DETECT_VALUE";
  private static final String DEVICE_MSG_NOTICE_SWITCH = "device_msg_notice_switch";
  private static String DEVICE_MUTE_VIBRATE_SWITCH;
  private static final String DEVICE_REMIND_PHONE_DELAY = "DEVICE_REMIND_PHONE_DELAY";
  private static final String DEVICE_REMIND_PHONE_SWITCH = "device_remind_phone_switch";
  private static final String DEVICE_REMIND_SPORT_END_HOUR = "DEVICE_REMIND_SPORT_END_HOUR";
  private static final String DEVICE_REMIND_SPORT_END_MIN = "DEVICE_REMIND_SPORT_END_MIN";
  private static final String DEVICE_REMIND_SPORT_INTERVAL = "DEVICE_REMIND_SPORT_INTERVAL";
  private static final String DEVICE_REMIND_SPORT_REPETITIONS = "DEVICE_REMIND_SPORT_REPETITIONS";
  private static final String DEVICE_REMIND_SPORT_START_HOUR = "DEVICE_REMIND_SPORT_START_HOUR";
  private static final String DEVICE_REMIND_SPORT_START_MIN = "DEVICE_REMIND_SPORT_START_MIN";
  private static final String DEVICE_SYNC_END_TIME = "device_sync_end_time";
  private static final String DEVICE_SYNC_END_TIME_MINS = "DEVICE_SYNC_END_TIME_MINS";
  private static final String DEVICE_UPDATE_AUTO = "DEVICE_UPDATE_AUTO";
  private static final String DEVICE_UPDATE_PRESS = "device_update_press";
  private static final String FIRST_START_APP = "first_start_app";
  private static final String FIRST_UPDATE_APP = "first_update_app";
  private static final String FLAG_DEVICE_REMIND_SPORT_CHANGE = "FLAG_DEVICE_REMIND_SPORT_CHANGE";
  private static final String FLAG_GOAL_CHANGE = "FLAG_GOAL_CHANGE";
  private static String GOOGLE_FIT_MODE;
  private static String HAS_DELETE_BTDATA;
  private static String INTELLIGENT_REMIND_SWITCH;
  private static final String IS_REAL_TIME = "IS_REAL_TIME";
  private static String LAST_STEP_CAL;
  private static String LAST_STEP_COUNT;
  private static String LAST_STEP_DISTANCE;
  private static String LAST_STEP_ITEM;
  private static String LAST_SYNC_TIME;
  private static String LIFT_WRIST_SWITCH;
  private static final String OPEN_TEST = "OPEN_TEST";
  private static String RINGTONE_INDEX = "RINGTONE_INDEX";
  private static String RINGTONE_NAME = "RINGTONE_NAME";
  private static String RINGTONE_URL = "RINGTONE_URL";
  private static String SCREEN_RAW_HEIGHT;
  private static String SEND_LOG;
  private static final String SET_MAIN_SYNC_DATA = "SET_MAIN_SYNC_DATA";
  private static final String SP_NAME = "veryfit_multi_app";
  private static final String SYNC_HEALTHDATA_MODE_SAFE = "sync_healthdata_mode_safe";
  private static String SYNC_SUCCESS_TIME;
  private static final String TIME_MODE = "TIME_MODE";
  private static String TIME_ZONE;
  private static final String UNIT_TYPE = "UNIT_TYPE";
  private static final String USER_BIRTHDAY_DAY = "USER_BIRTHDAY_DAY";
  private static final String USER_BIRTHDAY_MONTH = "USER_BIRTHDAY_MONTH";
  private static final String USER_BIRTHDAY_YEAR = "USER_BIRTHDAY_YEAR";
  private static final String USER_HEIGHT = "USER_HEIGHT";
  private static String USER_LOGINNAME;
  private static String USER_LOGINTYPE;
  private static String USER_LOGIN_ALREADY;
  private static final String USER_NICK_NAME = "USER_NICK_NAME";
  private static String USER_PASSWORD;
  private static String USER_REMEBER_PWD;
  private static final String USER_SEX = "USER_SEX";
  private static final String USER_WEIGHT = "USER_WEIGHT";
  private static AppSharedPreferences instance;
  private static final String updateFailed = "updateFailed";
  
  static
  {
    DEVICE_FOUND_PHONE_SWITCH = "DEVICE_FOUND_PHONE_SWITCH";
    SCREEN_RAW_HEIGHT = "SCREEN_RAW_HEIGHT";
    USER_LOGINNAME = "USER_LOGINNAME";
    USER_PASSWORD = "USER_PASSWORD";
    USER_REMEBER_PWD = "USER_REMEBER_PWD";
    USER_LOGIN_ALREADY = "USER_LOGIN_ALREADY";
    USER_LOGINTYPE = "USER_LOGIN_TYPE";
    DATA_BACKUP_TIME = "DATA_BACKUP_TIME";
    HAS_DELETE_BTDATA = "HAS_DELETE_BTDATA";
    LAST_SYNC_TIME = "LAST_SYNC_TIME";
    GOOGLE_FIT_MODE = "GOOGLE_FIT_MODE";
    SYNC_SUCCESS_TIME = "SYNC_SUCCESS_TIME";
    LAST_STEP_COUNT = "LAST_STEP_COUNT";
    LAST_STEP_DISTANCE = "LAST_STEP_DISTANCE";
    LAST_STEP_CAL = "LAST_STEP_CAL";
    LAST_STEP_ITEM = "LAST_STEP_ITEM";
    INTELLIGENT_REMIND_SWITCH = "INTELLIGENT_REMIND_SWITCH";
    LIFT_WRIST_SWITCH = "LIFT_WRIST_SWITCH";
    TIME_ZONE = "TIME_ZONE";
    SEND_LOG = "SEND_LOG";
    DEVICE_MUTE_VIBRATE_SWITCH = "DEVICE_MUTE_VIBRATE_SWITCH";
  }
  
  public static final AppSharedPreferences getInstance()
  {
    if (instance == null) {
      instance = new AppSharedPreferences();
    }
    return instance;
  }
  
  public void clearData()
  {
    float f = getScreenRawHeight();
    boolean bool = isFirstStartApp();
    String str1 = getAppThemePackage();
    String str2 = getValue("device_sync_end_time", "");
    int i = getValue("DEVICE_SYNC_END_TIME_MINS", 0);
    int j = getInstance().getUnitType();
    this.mSharePre.edit().clear().commit();
    setUnitType(j);
    setScreenRawHeight(f);
    setFirstStartApp(bool);
    setAppThemePackage(str1);
    setValue("device_sync_end_time", str2);
    setValue("DEVICE_SYNC_END_TIME_MINS", i);
  }
  
  public void exitLogin()
  {
    if (!isRememberPwd())
    {
      remove(USER_LOGINNAME);
      remove(USER_PASSWORD);
      remove(USER_LOGINTYPE);
      remove(DATA_BACKUP_TIME);
    }
    setLoginState(false);
    TempUtil.clearLocalBtData();
    setDeleteBtData(true);
  }
  
  public int getAntilost()
  {
    return getValue("DEVICE_ANTILOST_MODE", 0);
  }
  
  public String getAppThemePackage()
  {
    return getValue("app_theme_package", "");
  }
  
  public String getAppVersionName()
  {
    return getValue("APP_VERSION_NAME", "");
  }
  
  public String getBindDeviceAddr()
  {
    return getValue("bind_device_addr", "");
  }
  
  public String getBindDeviceName()
  {
    return getValue("bind_device_name", "");
  }
  
  public String getDataBackupTime()
  {
    return getValue(DATA_BACKUP_TIME, "");
  }
  
  public boolean getDeviceBellVibrateSwitch()
  {
    return getValue(DEVICE_BELL_VIBRATE_SWITCH, false);
  }
  
  public boolean getDeviceFoundPhoneSwitch()
  {
    return getValue(DEVICE_FOUND_PHONE_SWITCH, false);
  }
  
  public int getDeviceHeartRateAutoDetectValue()
  {
    return getValue(DEVICE_HEART_RATE_AUTO_DETECT_VALUE, 0);
  }
  
  public boolean getDeviceMsgNoticeSwitch()
  {
    return getValue("device_msg_notice_switch", false);
  }
  
  public boolean getDeviceMuteVibrateSwitch()
  {
    return getValue(DEVICE_MUTE_VIBRATE_SWITCH, false);
  }
  
  public int getDeviceRemindPhoneDelay()
  {
    return getValue("DEVICE_REMIND_PHONE_DELAY", 8);
  }
  
  public boolean getDeviceRemindPhoneSwitch()
  {
    return getValue("device_remind_phone_switch", false);
  }
  
  public int getDeviceRemindSportEndHour()
  {
    return getValue("DEVICE_REMIND_SPORT_END_HOUR", 18);
  }
  
  public int getDeviceRemindSportEndMin()
  {
    return getValue("DEVICE_REMIND_SPORT_END_MIN", 0);
  }
  
  public int getDeviceRemindSportInterval()
  {
    return getValue("DEVICE_REMIND_SPORT_INTERVAL", 30);
  }
  
  public int getDeviceRemindSportRepetitions()
  {
    return getValue("DEVICE_REMIND_SPORT_REPETITIONS", 62);
  }
  
  public int getDeviceRemindSportStartHour()
  {
    return getValue("DEVICE_REMIND_SPORT_START_HOUR", 8);
  }
  
  public int getDeviceRemindSportStartMin()
  {
    return getValue("DEVICE_REMIND_SPORT_START_MIN", 0);
  }
  
  public Object[] getDeviceSyncEndTime()
  {
    return new Object[] { getValue("device_sync_end_time", ""), Integer.valueOf(getValue("DEVICE_SYNC_END_TIME_MINS", 0)) };
  }
  
  public boolean getDeviceUpdateAuto()
  {
    return getValue("DEVICE_UPDATE_AUTO", false);
  }
  
  public int getDeviceUpdatePress()
  {
    return getValue("device_update_press", 0);
  }
  
  public boolean getFirstupdateApp()
  {
    return getValue("first_update_app", false);
  }
  
  public boolean getFlagDeviceRemindSportChane()
  {
    return getValue("FLAG_DEVICE_REMIND_SPORT_CHANGE", false);
  }
  
  public boolean getFlagGoalChange()
  {
    return getValue("FLAG_GOAL_CHANGE", false);
  }
  
  public int getGoogleFit()
  {
    return getValue(GOOGLE_FIT_MODE, 0);
  }
  
  public String getIntelligentRemindSwitch()
  {
    return getValue(INTELLIGENT_REMIND_SWITCH, "");
  }
  
  public boolean getIsRealTime()
  {
    return getValue("IS_REAL_TIME", false);
  }
  
  public float getLastStepCal()
  {
    return getValue(LAST_STEP_CAL, 0.0F);
  }
  
  public int getLastStepCount()
  {
    return getValue(LAST_STEP_COUNT, 0);
  }
  
  public float getLastStepDistance()
  {
    return getValue(LAST_STEP_DISTANCE, 0.0F);
  }
  
  public int getLastStepItem()
  {
    return getValue(LAST_STEP_ITEM, 0);
  }
  
  public long getLastSyncTime()
  {
    return getValue(LAST_SYNC_TIME, 0L);
  }
  
  public boolean getLiftWristSwitch()
  {
    return getValue(LIFT_WRIST_SWITCH, false);
  }
  
  public String getLoginName()
  {
    return getValue(USER_LOGINNAME, "");
  }
  
  public int getRingtoneIndex()
  {
    return getValue(RINGTONE_INDEX, -1);
  }
  
  public String getRingtoneName()
  {
    return getValue(RINGTONE_NAME, "");
  }
  
  public String getRingtoneUrl()
  {
    return getValue(RINGTONE_URL, "");
  }
  
  public float getScreenRawHeight()
  {
    return getValue(SCREEN_RAW_HEIGHT, 0.0F);
  }
  
  public boolean getSendLog()
  {
    return getValue(SEND_LOG, true);
  }
  
  public boolean getSyncHealdataMode()
  {
    return getValue("sync_healthdata_mode_safe", false);
  }
  
  public long getSyncSuccessTime()
  {
    return getValue(SYNC_SUCCESS_TIME, 0L);
  }
  
  public String getTimeZone()
  {
    return getValue(TIME_ZONE, "");
  }
  
  public int getUnitType()
  {
    return getValue("UNIT_TYPE", 1);
  }
  
  public int getUpdateFaild()
  {
    return getValue("updateFailed", 0);
  }
  
  public int getUserBirthdayDay()
  {
    return getValue("USER_BIRTHDAY_DAY", 1);
  }
  
  public int getUserBirthdayMonth()
  {
    return getValue("USER_BIRTHDAY_MONTH", 1);
  }
  
  public int getUserBirthdayYear()
  {
    return getValue("USER_BIRTHDAY_YEAR", 1990);
  }
  
  public int getUserHeight()
  {
    return getValue("USER_HEIGHT", 175);
  }
  
  public int getUserLoginType()
  {
    return getValue(USER_LOGINTYPE, 0);
  }
  
  public String getUserName()
  {
    return getValue("USER_NICK_NAME", "");
  }
  
  public String getUserPassword()
  {
    return getValue(USER_PASSWORD, "");
  }
  
  public boolean getUserSex()
  {
    return getValue("USER_SEX", true);
  }
  
  public int getUserWeight()
  {
    return getValue("USER_WEIGHT", 65);
  }
  
  public boolean hasDeleteBtData()
  {
    return getValue(HAS_DELETE_BTDATA, false);
  }
  
  public void init(Context paramContext)
  {
    super.init(paramContext, "veryfit_multi_app");
  }
  
  public boolean is24TimeMode()
  {
    return getValue("TIME_MODE", true);
  }
  
  public boolean isFirstStartApp()
  {
    return getValue("first_start_app", true);
  }
  
  public boolean isLogined()
  {
    return getValue(USER_LOGIN_ALREADY, false);
  }
  
  public boolean isOpenTest()
  {
    return getValue("OPEN_TEST", false);
  }
  
  public boolean isRememberPwd()
  {
    return getValue(USER_REMEBER_PWD, true);
  }
  
  public void setAntilost(int paramInt)
  {
    setValue("DEVICE_ANTILOST_MODE", paramInt);
  }
  
  public void setAppThemePackage(String paramString)
  {
    setValue("app_theme_package", paramString);
  }
  
  public void setAppVersionName(String paramString)
  {
    setValue("APP_VERSION_NAME", paramString);
  }
  
  public void setBindDeviceAddr(String paramString)
  {
    setValue("bind_device_addr", paramString);
  }
  
  public void setBindDeviceName(String paramString)
  {
    setValue("bind_device_name", paramString);
  }
  
  public void setDataBackupTime(String paramString)
  {
    setValue(DATA_BACKUP_TIME, paramString);
  }
  
  public void setDeleteBtData(boolean paramBoolean)
  {
    setValue(HAS_DELETE_BTDATA, paramBoolean);
  }
  
  public void setDeviceBellVibrateSwitch(boolean paramBoolean)
  {
    setValue(DEVICE_BELL_VIBRATE_SWITCH, paramBoolean);
  }
  
  public void setDeviceFoundPhoneSwitch(boolean paramBoolean)
  {
    setValue(DEVICE_FOUND_PHONE_SWITCH, paramBoolean);
  }
  
  public void setDeviceHeartRateAutoDetectValue(int paramInt)
  {
    setValue(DEVICE_HEART_RATE_AUTO_DETECT_VALUE, paramInt);
  }
  
  public void setDeviceMsgNoticeSwitch(boolean paramBoolean)
  {
    setValue("device_msg_notice_switch", paramBoolean);
  }
  
  public void setDeviceMuteVibrateSwitch(boolean paramBoolean)
  {
    setValue(DEVICE_MUTE_VIBRATE_SWITCH, paramBoolean);
  }
  
  public void setDeviceRemindPhoneDelay(int paramInt)
  {
    setValue("DEVICE_REMIND_PHONE_DELAY", paramInt);
  }
  
  public void setDeviceRemindPhoneSwitch(boolean paramBoolean)
  {
    setValue("device_remind_phone_switch", paramBoolean);
  }
  
  public void setDeviceRemindSportEndHour(int paramInt)
  {
    setValue("DEVICE_REMIND_SPORT_END_HOUR", paramInt);
  }
  
  public void setDeviceRemindSportEndMin(int paramInt)
  {
    setValue("DEVICE_REMIND_SPORT_END_MIN", paramInt);
  }
  
  public void setDeviceRemindSportInterval(int paramInt)
  {
    setValue("DEVICE_REMIND_SPORT_INTERVAL", paramInt);
  }
  
  public void setDeviceRemindSportRepetitions(int paramInt)
  {
    setValue("DEVICE_REMIND_SPORT_REPETITIONS", paramInt);
  }
  
  public void setDeviceRemindSportStartHour(int paramInt)
  {
    setValue("DEVICE_REMIND_SPORT_START_HOUR", paramInt);
  }
  
  public void setDeviceRemindSportStartMin(int paramInt)
  {
    setValue("DEVICE_REMIND_SPORT_START_MIN", paramInt);
  }
  
  public void setDeviceSyncEndTime(Calendar paramCalendar)
  {
    setValue("DEVICE_SYNC_END_TIME_MINS", paramCalendar.get(12) + paramCalendar.get(11) * 60);
    setValue("device_sync_end_time", String.format("%02d/%02d/%02d ", new Object[] { Integer.valueOf(paramCalendar.get(1) % 1000), Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
  }
  
  public void setDeviceUpdateAuto(boolean paramBoolean)
  {
    setValue("DEVICE_UPDATE_AUTO", paramBoolean);
  }
  
  public void setDeviceUpdatePress(int paramInt)
  {
    setValue("device_update_press", paramInt);
  }
  
  public void setFirstStartApp(boolean paramBoolean)
  {
    setValue("first_start_app", paramBoolean);
  }
  
  public void setFirstUpdateApp(boolean paramBoolean)
  {
    setValue("first_update_app", paramBoolean);
  }
  
  public void setFlagDeviceRemindSportChange(boolean paramBoolean)
  {
    setValue("FLAG_DEVICE_REMIND_SPORT_CHANGE", paramBoolean);
  }
  
  public void setFlagGoalChange(boolean paramBoolean)
  {
    setValue("FLAG_GOAL_CHANGE", paramBoolean);
  }
  
  public void setGoogleFit(int paramInt)
  {
    setValue(GOOGLE_FIT_MODE, paramInt);
  }
  
  public void setIntelligentRemindSwitch(String paramString)
  {
    setValue(INTELLIGENT_REMIND_SWITCH, paramString);
  }
  
  public void setIsRealTime(boolean paramBoolean)
  {
    setValue("IS_REAL_TIME", paramBoolean);
  }
  
  public void setLastStepCal(float paramFloat)
  {
    setValue(LAST_STEP_CAL, paramFloat);
  }
  
  public void setLastStepCount(int paramInt)
  {
    setValue(LAST_STEP_COUNT, paramInt);
  }
  
  public void setLastStepDistance(float paramFloat)
  {
    setValue(LAST_STEP_DISTANCE, paramFloat);
  }
  
  public void setLastStepItem(int paramInt)
  {
    setValue(LAST_STEP_ITEM, paramInt);
  }
  
  public void setLastSyncTime(long paramLong)
  {
    setValue(LAST_SYNC_TIME, paramLong);
  }
  
  public void setLiftWristSwitch(boolean paramBoolean)
  {
    setValue(LIFT_WRIST_SWITCH, paramBoolean);
  }
  
  public void setLoginName(String paramString)
  {
    setValue(USER_LOGINNAME, paramString);
  }
  
  public void setLoginState(boolean paramBoolean)
  {
    setValue(USER_LOGIN_ALREADY, paramBoolean);
  }
  
  public void setMainSyncData(boolean paramBoolean)
  {
    setValue("SET_MAIN_SYNC_DATA", paramBoolean);
  }
  
  public void setOpenTest(boolean paramBoolean)
  {
    setValue("OPEN_TEST", paramBoolean);
  }
  
  public void setRememberPwd(boolean paramBoolean)
  {
    setValue(USER_REMEBER_PWD, paramBoolean);
  }
  
  public void setRingtoneIndex(int paramInt)
  {
    setValue(RINGTONE_INDEX, paramInt);
  }
  
  public void setRingtoneName(String paramString)
  {
    setValue(RINGTONE_NAME, paramString);
  }
  
  public void setRingtoneUrl(String paramString)
  {
    setValue(RINGTONE_URL, paramString);
  }
  
  public void setScreenRawHeight(float paramFloat)
  {
    setValue(SCREEN_RAW_HEIGHT, paramFloat);
  }
  
  public void setSendLog(boolean paramBoolean)
  {
    setValue(SEND_LOG, paramBoolean);
  }
  
  public void setSyncHealdataMode(boolean paramBoolean)
  {
    setValue("sync_healthdata_mode_safe", paramBoolean);
  }
  
  public void setSyncSuccessTime(long paramLong)
  {
    setValue(SYNC_SUCCESS_TIME, paramLong);
  }
  
  public void setTimeMode(boolean paramBoolean)
  {
    setValue("TIME_MODE", paramBoolean);
  }
  
  public void setTimeZone(String paramString)
  {
    setValue(TIME_ZONE, paramString);
  }
  
  public void setUnitType(int paramInt)
  {
    setValue("UNIT_TYPE", paramInt);
  }
  
  public void setUpdateFaild(int paramInt)
  {
    setValue("updateFailed", paramInt);
  }
  
  public void setUserBirthdayDay(int paramInt)
  {
    setValue("USER_BIRTHDAY_DAY", paramInt);
  }
  
  public void setUserBirthdayMonth(int paramInt)
  {
    setValue("USER_BIRTHDAY_MONTH", paramInt);
  }
  
  public void setUserBirthdayYear(int paramInt)
  {
    setValue("USER_BIRTHDAY_YEAR", paramInt);
  }
  
  public void setUserHeight(int paramInt)
  {
    setValue("USER_HEIGHT", paramInt);
  }
  
  public void setUserLoginType(int paramInt)
  {
    setValue(USER_LOGINTYPE, paramInt);
  }
  
  public void setUserName(String paramString)
  {
    setValue("USER_NICK_NAME", paramString);
  }
  
  public void setUserPassword(String paramString)
  {
    setValue(USER_PASSWORD, paramString);
  }
  
  public void setUserSex(boolean paramBoolean)
  {
    setValue("USER_SEX", paramBoolean);
  }
  
  public void setUserWeight(int paramInt)
  {
    setValue("USER_WEIGHT", paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\share\AppSharedPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */