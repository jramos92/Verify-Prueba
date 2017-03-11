package com.project.library.device.cmd.getinfo;

import android.util.Log;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;
import com.project.library.util.UartLogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GetInfoCmd
  extends DeviceBaseCommand
{
  public static final byte KEY_BASIC = 1;
  public static final byte KEY_BATTERY = 5;
  public static final byte KEY_FUNCTION = 2;
  public static final byte KEY_MAC = 4;
  public static final byte KEY_REAL_TIME = -96;
  public static final byte KEY_TIME = 3;
  public static final byte[] VALUE = new byte[18];
  public static BatteryInfos info;
  private static GetInfoCmd mInstance = null;
  
  public static GetInfoCmd getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GetInfoCmd();
      }
      GetInfoCmd localGetInfoCmd = mInstance;
      return localGetInfoCmd;
    }
    finally {}
  }
  
  private void parseBasicInfos(byte[] paramArrayOfByte)
  {
    BasicInfos localBasicInfos = new BasicInfos();
    localBasicInfos.deivceId = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 0, 2);
    localBasicInfos.firmwareVersion = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[2]);
    localBasicInfos.mode = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[3]);
    localBasicInfos.battStatus = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[4]);
    localBasicInfos.energe = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[5]);
    localBasicInfos.pairFlag = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[6]);
    localBasicInfos.reboot = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[7]);
    LibSharedPreferences.getInstance().setDeviceId(localBasicInfos.deivceId);
    LibSharedPreferences.getInstance().setDeviceFirmwareVersion(localBasicInfos.firmwareVersion);
    LibSharedPreferences.getInstance().setDeviceEnerge(localBasicInfos.energe);
    LibSharedPreferences.getInstance().setReBoot(localBasicInfos.reboot);
    DebugLog.d("设备Id：" + localBasicInfos.deivceId);
    DebugLog.d("固件版本号：" + localBasicInfos.firmwareVersion);
    DebugLog.d("电池电量：" + localBasicInfos.energe);
    DebugLog.d("重启标志：" + localBasicInfos.reboot);
  }
  
  private void parseBatteryInfos(byte[] paramArrayOfByte)
  {
    info = new BatteryInfos();
    info.type = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[0]);
    info.voltage = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 1, 2);
    info.status = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[3]);
    info.level = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[4]);
    info.cur_use_time = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 5, 4);
    info.total_use_time = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 9, 4);
    StringBuilder localStringBuilder = new StringBuilder("电池信息：");
    if (info.type == 0) {}
    for (paramArrayOfByte = "锂电池";; paramArrayOfByte = "纽扣电池")
    {
      DebugLog.d(paramArrayOfByte);
      return;
    }
  }
  
  private void parseFunctionInfos(byte[] paramArrayOfByte)
  {
    FunctionInfos localFunctionInfos = new FunctionInfos();
    if ((paramArrayOfByte[0] & 0x1) == 1)
    {
      bool = true;
      localFunctionInfos.stepCalculation = bool;
      if ((paramArrayOfByte[0] & 0x2) >> 1 != 1) {
        break label1111;
      }
      bool = true;
      label37:
      localFunctionInfos.sleepMonitor = bool;
      if ((paramArrayOfByte[0] & 0x4) >> 2 != 1) {
        break label1116;
      }
      bool = true;
      label55:
      localFunctionInfos.singleSport = bool;
      if ((paramArrayOfByte[0] & 0x8) >> 3 != 1) {
        break label1121;
      }
      bool = true;
      label74:
      localFunctionInfos.realtimeData = bool;
      if ((paramArrayOfByte[0] & 0x10) >> 4 != 1) {
        break label1126;
      }
      bool = true;
      label93:
      localFunctionInfos.deviceUpdate = bool;
      if ((paramArrayOfByte[0] & 0x20) >> 5 != 1) {
        break label1131;
      }
      bool = true;
      label112:
      localFunctionInfos.heartRate = bool;
      if ((paramArrayOfByte[0] & 0x40) >> 6 != 1) {
        break label1136;
      }
      bool = true;
      label132:
      localFunctionInfos.notificationCenter = bool;
      localFunctionInfos.alarmCount = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[1]);
      if ((paramArrayOfByte[2] & 0x1) != 1) {
        break label1141;
      }
      bool = true;
      label158:
      localFunctionInfos.wakeUp = bool;
      if ((paramArrayOfByte[2] & 0x2) >> 1 != 1) {
        break label1146;
      }
      bool = true;
      label176:
      localFunctionInfos.sleep = bool;
      if ((paramArrayOfByte[2] & 0x4) >> 2 != 1) {
        break label1151;
      }
      bool = true;
      label194:
      localFunctionInfos.sport = bool;
      if ((paramArrayOfByte[2] & 0x8) >> 3 != 1) {
        break label1156;
      }
      bool = true;
      label213:
      localFunctionInfos.medicine = bool;
      if ((paramArrayOfByte[2] & 0x10) >> 4 != 1) {
        break label1161;
      }
      bool = true;
      label232:
      localFunctionInfos.dating = bool;
      if ((paramArrayOfByte[2] & 0x20) >> 5 != 1) {
        break label1166;
      }
      bool = true;
      label251:
      localFunctionInfos.party = bool;
      if ((paramArrayOfByte[2] & 0x40) >> 6 != 1) {
        break label1171;
      }
      bool = true;
      label271:
      localFunctionInfos.metting = bool;
      if ((paramArrayOfByte[2] & 0x80) >> 7 != 1) {
        break label1176;
      }
      bool = true;
      label292:
      localFunctionInfos.custom = bool;
      if ((paramArrayOfByte[3] & 0x1) != 1) {
        break label1181;
      }
      bool = true;
      label308:
      localFunctionInfos.takePhoto = bool;
      if ((paramArrayOfByte[3] & 0x2) >> 1 != 1) {
        break label1186;
      }
      bool = true;
      label326:
      localFunctionInfos.music = bool;
      if ((paramArrayOfByte[4] & 0x1) != 1) {
        break label1191;
      }
      bool = true;
      label342:
      localFunctionInfos.calling = bool;
      if ((paramArrayOfByte[4] & 0x2) >> 1 != 1) {
        break label1196;
      }
      bool = true;
      label360:
      localFunctionInfos.callingContact = bool;
      if ((paramArrayOfByte[4] & 0x4) >> 2 != 1) {
        break label1201;
      }
      bool = true;
      label378:
      localFunctionInfos.callingNum = bool;
      if ((paramArrayOfByte[5] & 0x1) != 1) {
        break label1206;
      }
      bool = true;
      label394:
      localFunctionInfos.message = bool;
      if ((paramArrayOfByte[5] & 0x2) >> 1 != 1) {
        break label1211;
      }
      bool = true;
      label412:
      localFunctionInfos.email = bool;
      if ((paramArrayOfByte[5] & 0x4) >> 2 != 1) {
        break label1216;
      }
      bool = true;
      label430:
      localFunctionInfos.qq = bool;
      if ((paramArrayOfByte[5] & 0x8) >> 3 != 1) {
        break label1221;
      }
      bool = true;
      label449:
      localFunctionInfos.weixin = bool;
      if ((paramArrayOfByte[5] & 0x10) >> 4 != 1) {
        break label1226;
      }
      bool = true;
      label468:
      localFunctionInfos.sinaWeibo = bool;
      if ((paramArrayOfByte[5] & 0x20) >> 5 != 1) {
        break label1231;
      }
      bool = true;
      label487:
      localFunctionInfos.facebook = bool;
      if ((paramArrayOfByte[5] & 0x40) >> 6 != 1) {
        break label1236;
      }
      bool = true;
      label507:
      localFunctionInfos.twitter = bool;
      if ((paramArrayOfByte[6] & 0x1) != 1) {
        break label1241;
      }
      bool = true;
      label524:
      localFunctionInfos.sedentariness = bool;
      if ((paramArrayOfByte[6] & 0x2) >> 1 != 1) {
        break label1246;
      }
      bool = true;
      label543:
      localFunctionInfos.antilost = bool;
      if ((paramArrayOfByte[6] & 0x4) >> 2 != 1) {
        break label1251;
      }
      bool = true;
      label562:
      localFunctionInfos.onetouchCalling = bool;
      if ((paramArrayOfByte[6] & 0x8) >> 3 != 1) {
        break label1256;
      }
      bool = true;
      label582:
      localFunctionInfos.findPhone = bool;
      if ((paramArrayOfByte[6] & 0x10) >> 4 != 1) {
        break label1261;
      }
      bool = true;
      label602:
      localFunctionInfos.findDevice = bool;
      if ((paramArrayOfByte[6] & 0x20) >> 5 != 1) {
        break label1266;
      }
      bool = true;
      label622:
      localFunctionInfos.oneKeyRestore = bool;
      if ((paramArrayOfByte[6] & 0x40) >> 6 != 1) {
        break label1271;
      }
      bool = true;
      label643:
      localFunctionInfos.liftwrist = bool;
      if ((paramArrayOfByte[7] & 0x1) != 1) {
        break label1276;
      }
      bool = true;
      label660:
      localFunctionInfos.tipInfoContact = bool;
      if ((paramArrayOfByte[7] & 0x2) >> 1 != 1) {
        break label1281;
      }
      bool = true;
      label679:
      localFunctionInfos.tipInfoNum = bool;
      if ((paramArrayOfByte[7] & 0x4) >> 2 != 1) {
        break label1286;
      }
      bool = true;
      label698:
      localFunctionInfos.tipInfoContent = bool;
      if ((paramArrayOfByte[8] & 0x1) != 1) {
        break label1291;
      }
      bool = true;
      label715:
      localFunctionInfos.whatsapp = bool;
      if ((paramArrayOfByte[8] & 0x2) >> 1 != 1) {
        break label1296;
      }
      bool = true;
      label734:
      localFunctionInfos.messenger = bool;
      if ((paramArrayOfByte[8] & 0x4) >> 2 != 1) {
        break label1301;
      }
      bool = true;
      label753:
      localFunctionInfos.instagram = bool;
      if ((paramArrayOfByte[8] & 0x8) >> 3 != 1) {
        break label1306;
      }
      bool = true;
      label773:
      localFunctionInfos.linkedin = bool;
      if ((paramArrayOfByte[9] & 0x1) != 1) {
        break label1311;
      }
      bool = true;
      label790:
      localFunctionInfos.staticHeart = bool;
      if ((paramArrayOfByte[9] & 0x2) >> 1 != 1) {
        break label1316;
      }
      bool = true;
      label809:
      localFunctionInfos.disturbMode = bool;
      if ((paramArrayOfByte[9] & 0x4) >> 2 != 1) {
        break label1321;
      }
      bool = true;
      label828:
      localFunctionInfos.displayMode = bool;
      if ((paramArrayOfByte[9] & 0x8) >> 3 != 1) {
        break label1326;
      }
      bool = true;
      label848:
      localFunctionInfos.LeftRightMode = bool;
      if ((paramArrayOfByte[9] & 0x20) >> 5 != 1) {
        break label1331;
      }
      bool = true;
      label868:
      LibSharedPreferences.getInstance().setAllNotify(bool);
      if ((paramArrayOfByte[9] & 0x40) >> 6 != 1) {
        break label1336;
      }
    }
    label1111:
    label1116:
    label1121:
    label1126:
    label1131:
    label1136:
    label1141:
    label1146:
    label1151:
    label1156:
    label1161:
    label1166:
    label1171:
    label1176:
    label1181:
    label1186:
    label1191:
    label1196:
    label1201:
    label1206:
    label1211:
    label1216:
    label1221:
    label1226:
    label1231:
    label1236:
    label1241:
    label1246:
    label1251:
    label1256:
    label1261:
    label1266:
    label1271:
    label1276:
    label1281:
    label1286:
    label1291:
    label1296:
    label1301:
    label1306:
    label1311:
    label1316:
    label1321:
    label1326:
    label1331:
    label1336:
    for (boolean bool = true;; bool = false)
    {
      LibSharedPreferences.getInstance().setRota(bool);
      LibSharedPreferences.getInstance().setDeviceAlarmMaxCount(localFunctionInfos.alarmCount);
      LibSharedPreferences.getInstance().setDeviceFunMain(paramArrayOfByte[0]);
      LibSharedPreferences.getInstance().setDeviceFunAlarmNotify(paramArrayOfByte[2]);
      LibSharedPreferences.getInstance().setDeviceFunControl(paramArrayOfByte[3]);
      LibSharedPreferences.getInstance().setDeviceFunCallNotify(paramArrayOfByte[4]);
      LibSharedPreferences.getInstance().setDeviceFunMsgNotify(paramArrayOfByte[5]);
      LibSharedPreferences.getInstance().setDeviceFunOtherNotify(paramArrayOfByte[6]);
      LibSharedPreferences.getInstance().setDeviceFunTipInfoNotify(paramArrayOfByte[7]);
      LibSharedPreferences.getInstance().setDeviceFunMsgNotify2(paramArrayOfByte[8]);
      LibSharedPreferences.getInstance().setDeviceHeartRate(localFunctionInfos.heartRate);
      LibSharedPreferences.getInstance().setDeviceRealTime(localFunctionInfos.realtimeData);
      LibSharedPreferences.getInstance().setDeviceFunOther2Staticheart(localFunctionInfos.staticHeart);
      LibSharedPreferences.getInstance().setDeviceFunOther2DisturbMode(localFunctionInfos.disturbMode);
      LibSharedPreferences.getInstance().setDeviceFunOther2DisplayMode(localFunctionInfos.displayMode);
      LibSharedPreferences.getInstance().setDeviceFunOther2LeftRightMode(localFunctionInfos.LeftRightMode);
      DebugLog.d("支持动态心率(flase为动态)：" + localFunctionInfos.staticHeart + ":" + localFunctionInfos.disturbMode + ":" + localFunctionInfos.displayMode + ":" + localFunctionInfos.LeftRightMode);
      return;
      bool = false;
      break;
      bool = false;
      break label37;
      bool = false;
      break label55;
      bool = false;
      break label74;
      bool = false;
      break label93;
      bool = false;
      break label112;
      bool = false;
      break label132;
      bool = false;
      break label158;
      bool = false;
      break label176;
      bool = false;
      break label194;
      bool = false;
      break label213;
      bool = false;
      break label232;
      bool = false;
      break label251;
      bool = false;
      break label271;
      bool = false;
      break label292;
      bool = false;
      break label308;
      bool = false;
      break label326;
      bool = false;
      break label342;
      bool = false;
      break label360;
      bool = false;
      break label378;
      bool = false;
      break label394;
      bool = false;
      break label412;
      bool = false;
      break label430;
      bool = false;
      break label449;
      bool = false;
      break label468;
      bool = false;
      break label487;
      bool = false;
      break label507;
      bool = false;
      break label524;
      bool = false;
      break label543;
      bool = false;
      break label562;
      bool = false;
      break label582;
      bool = false;
      break label602;
      bool = false;
      break label622;
      bool = false;
      break label643;
      bool = false;
      break label660;
      bool = false;
      break label679;
      bool = false;
      break label698;
      bool = false;
      break label715;
      bool = false;
      break label734;
      bool = false;
      break label753;
      bool = false;
      break label773;
      bool = false;
      break label790;
      bool = false;
      break label809;
      bool = false;
      break label828;
      bool = false;
      break label848;
      bool = false;
      break label868;
    }
  }
  
  private void parseMacInfos(byte[] paramArrayOfByte)
  {
    MacAddressInfos localMacAddressInfos = new MacAddressInfos();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[5]) }));
    localStringBuilder.append(":");
    localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[4]) }));
    localStringBuilder.append(":");
    localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[3]) }));
    localStringBuilder.append(":");
    localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[2]) }));
    localStringBuilder.append(":");
    localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[1]) }));
    localStringBuilder.append(":");
    localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[0]) }));
    localMacAddressInfos.mac = localStringBuilder.toString();
    DebugLog.d("设备地址:" + localMacAddressInfos.mac);
  }
  
  private void parseRealTimeInfo(byte[] paramArrayOfByte)
  {
    RealTimeInfo localRealTimeInfo = new RealTimeInfo();
    localRealTimeInfo.totalStep = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 0, 4);
    localRealTimeInfo.totalCalories = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 4, 4);
    localRealTimeInfo.totalDistances = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 8, 4);
    localRealTimeInfo.totalActiveTime = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 12, 4);
    localRealTimeInfo.heartRate = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[16]);
    LibSharedPreferences.getInstance().setHeartRate(localRealTimeInfo.heartRate);
    LibSharedPreferences.getInstance().setRealStep(localRealTimeInfo.totalStep);
    LibSharedPreferences.getInstance().setRealDistances(localRealTimeInfo.totalDistances);
    LibSharedPreferences.getInstance().setRealCalories(localRealTimeInfo.totalCalories);
    Log.e("gch", "rate = " + localRealTimeInfo.heartRate);
    Log.e("gch", "totalDistances = " + localRealTimeInfo.totalDistances);
  }
  
  private void parseTimeInfos(byte[] paramArrayOfByte)
  {
    TimeInfos localTimeInfos = new TimeInfos();
    localTimeInfos.year = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 0, 2);
    localTimeInfos.month = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[2]);
    localTimeInfos.day = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[3]);
    localTimeInfos.hour = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[4]);
    localTimeInfos.minute = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[5]);
    localTimeInfos.second = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[6]);
    localTimeInfos.weekday = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[7]);
    DebugLog.d("设备时间：" + localTimeInfos.year + localTimeInfos.month + localTimeInfos.day + " " + localTimeInfos.hour + ":" + localTimeInfos.minute + ":" + localTimeInfos.second + "星期:" + (localTimeInfos.weekday + 1));
  }
  
  public byte[] getGetInfoCmd(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)2, paramByte, VALUE);
    if (paramByte == -96)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss|SSS", Locale.CHINESE);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localSimpleDateFormat.format(new Date())).append(" : write > ").append("[" + ByteDataConvertUtil.bytesToHexString(arrayOfByte) + "]").append("\r\n");
      UartLogUtil.recordRealTime(localStringBuilder.toString());
      return arrayOfByte;
    }
    UartLogUtil.recordWrite("获取信息", arrayOfByte);
    return arrayOfByte;
  }
  
  public void parse(byte[] paramArrayOfByte)
  {
    int i = getCmdKey(paramArrayOfByte);
    byte[] arrayOfByte = new byte[18];
    ByteDataConvertUtil.BinnCat(paramArrayOfByte, arrayOfByte, 2, 18);
    switch (i)
    {
    default: 
      return;
    case 1: 
      parseBasicInfos(arrayOfByte);
      return;
    case 2: 
      parseFunctionInfos(arrayOfByte);
      return;
    case 3: 
      parseTimeInfos(arrayOfByte);
      return;
    case 4: 
      parseMacInfos(arrayOfByte);
      return;
    case 5: 
      parseBatteryInfos(arrayOfByte);
      return;
    }
    parseRealTimeInfo(arrayOfByte);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\getinfo\GetInfoCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */