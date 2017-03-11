package com.veryfit.multi.util;

import android.os.Environment;
import java.io.File;

public class Constant
{
  public static final String ACTION_THEME_CHANGED = "com.veryfit.multi.action_theme_changed";
  public static final String API_KEY = "9b44ae9714f8";
  public static final String APK_PATH = FILE_PATH + "VeryFitMulti.apk";
  public static final String APP_NAME = "VeryFitMulti.apk";
  public static final String APP_ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/veryfit2";
  public static final int DETAIL_CHART_TYPE_MONRH = 1;
  public static final int DETAIL_CHART_TYPE_WEEK = 0;
  public static final int DETAIL_CHART_TYPE_YEAR = 2;
  public static final int DETAIL_PAGE_TYPE_SLEEP = 1;
  public static final int DETAIL_PAGE_TYPE_SPORT = 0;
  public static final String DEVICE_NAME = "YDY_NRF_PROTOCOL";
  public static final String DEVICE_NAME1 = "YDY_NRF_GD100";
  public static final String DEVICE_NAME2 = "YDY_NRF_P102";
  public static final String DEVICE_NAME3 = "YDY_P101";
  public static final String DEVICE_NAME4 = "GUODOO A1";
  public static final String DEVICE_NAME5 = "Rego";
  public static final String DEVICE_NAME6 = "WO_SMART";
  public static final String DEVICE_NAME7 = "YDY_P101gt";
  public static final String DEVICE_NAME8 = "YDY_NRF_P102gt";
  public static final String FACEBOOK = "1";
  public static final String FILE_PATH;
  public static final String FIRM_WARE_UPDATE_URL = "http://www.youduoyun.com/apps/firmwares/firmware.json";
  public static final int GOAL_SLEEP = 480;
  public static final int GOAL_SPORT = 10000;
  public static final String INSTAGRAM = "6";
  public static final String LINKEDIN = "7";
  public static final String LOG_PATH = APP_ROOT_PATH + "/log";
  public static final String MESSENGER = "8";
  public static final String PIC_PATH = APP_ROOT_PATH + "/pic";
  public static final String QQ = "3";
  public static final int RESULT_CODE_RESTART_DEVICE = 1;
  public static final String TWITTER = "4";
  public static final String WECHAT = "2";
  public static final String WHATSAPP = "5";
  public static final String imageDir;
  
  static
  {
    FILE_PATH = APP_ROOT_PATH + "/file/";
    imageDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/" + "VeryfitPhoto/";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\Constant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */