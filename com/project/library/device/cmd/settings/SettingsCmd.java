package com.project.library.device.cmd.settings;

import com.project.library.database.AlarmNotify;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.UartLogUtil;
import java.util.GregorianCalendar;

public class SettingsCmd
  extends DeviceBaseCommand
{
  public static final byte KEY_ALARM_CLOCK_SETTINGS = 2;
  public static final byte KEY_ANTILOST_SETTINGS = 33;
  public static final byte KEY_FINDPHONE_SETTINGS = 38;
  public static final byte KEY_HAND_SETTINGS = 34;
  public static final byte KEY_HEART_MODE_SETTINGS = 37;
  public static final byte KEY_HEART_RANGE_SETTINGS = 36;
  public static final byte KEY_INCOMING_TELEGRAM_SETTINGS = 48;
  public static final byte KEY_MESSAGE_SETTINGS = 49;
  public static final byte KEY_MULTI_TARGET_SETTINGS = 3;
  public static final byte KEY_MUSICCONTRL_SETTINGS = 42;
  public static final byte KEY_ONEKEY_RESTORE_SETTINGS = 39;
  public static final byte KEY_OS_SETTINGS = 35;
  public static final byte KEY_SEDENTARINESS_SETTINGS = 32;
  public static final byte KEY_TIME_SETTINGS = 1;
  public static final byte KEY_UNIT_SETTINGS = 17;
  public static final byte KEY_USER_INFOS_SETTINGS = 16;
  public static final byte KEY_WRIST_DISTURB_MODE_SETTINGS = 41;
  public static final byte KEY_WRIST_GESTURE_SETTINGS = 40;
  public static final byte KEY_WRIST_HV_MODE_SETTINGS = 43;
  private static final byte SETTINGS_SUCCESS = 0;
  public static final byte[] VALUE = new byte[18];
  private static SettingsCmd mInstance = null;
  
  private int getAlarmTypes(int paramInt)
  {
    int i3 = 1;
    Object localObject2 = "";
    int i4 = LibSharedPreferences.getInstance().getDeviceFunAlarmNotify();
    int i;
    int j;
    label37:
    int k;
    label50:
    int m;
    label64:
    int n;
    label78:
    int i1;
    label92:
    int i2;
    if ((i4 & 0x1) == 1)
    {
      i = 1;
      if ((i4 & 0x2) >> 1 != 1) {
        break label391;
      }
      j = 1;
      if ((i4 & 0x4) >> 2 != 1) {
        break label396;
      }
      k = 1;
      if ((i4 & 0x8) >> 3 != 1) {
        break label402;
      }
      m = 1;
      if ((i4 & 0x10) >> 4 != 1) {
        break label408;
      }
      n = 1;
      if ((i4 & 0x20) >> 5 != 1) {
        break label414;
      }
      i1 = 1;
      if ((i4 & 0x40) >> 6 != 1) {
        break label420;
      }
      i2 = 1;
      label107:
      if ((i4 & 0x80) >> 7 != 1) {
        break label426;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localObject2 = "" + "0,";
      }
      Object localObject1 = localObject2;
      if (j != 0) {
        localObject1 = localObject2 + "1,";
      }
      localObject2 = localObject1;
      if (k != 0) {
        localObject2 = localObject1 + "2,";
      }
      localObject1 = localObject2;
      if (m != 0) {
        localObject1 = localObject2 + "3,";
      }
      localObject2 = localObject1;
      if (n != 0) {
        localObject2 = localObject1 + "4,";
      }
      localObject1 = localObject2;
      if (i1 != 0) {
        localObject1 = localObject2 + "5,";
      }
      localObject2 = localObject1;
      if (i2 != 0) {
        localObject2 = localObject1 + "6,";
      }
      localObject1 = localObject2;
      if (i3 != 0) {
        localObject1 = localObject2 + "7,";
      }
      return Integer.parseInt(localObject1.substring(0, localObject1.length() - 1).split(",")[paramInt]);
      i = 0;
      break;
      label391:
      j = 0;
      break label37;
      label396:
      k = 0;
      break label50;
      label402:
      m = 0;
      break label64;
      label408:
      n = 0;
      break label78;
      label414:
      i1 = 0;
      break label92;
      label420:
      i2 = 0;
      break label107;
      label426:
      i3 = 0;
    }
  }
  
  public static SettingsCmd getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new SettingsCmd();
      }
      SettingsCmd localSettingsCmd = mInstance;
      return localSettingsCmd;
    }
    finally {}
  }
  
  public byte[] getAlarmClockSettingsCmd(AlarmNotify paramAlarmNotify)
  {
    paramAlarmNotify = createCmd((byte)3, (byte)2, new byte[] { ByteDataConvertUtil.Int2Byte((int)paramAlarmNotify.getAlarmId()), ByteDataConvertUtil.Int2Byte(paramAlarmNotify.getAlarmStatus()), ByteDataConvertUtil.Int2Byte(getAlarmTypes(paramAlarmNotify.getAlarmType())), ByteDataConvertUtil.Int2Byte(paramAlarmNotify.getAlarmHour()), ByteDataConvertUtil.Int2Byte(paramAlarmNotify.getAlarmMinute()), ByteDataConvertUtil.Int2Byte(paramAlarmNotify.getAlarmRepetitions()), ByteDataConvertUtil.Int2Byte(paramAlarmNotify.getAlarmSnoozeDuration()) });
    UartLogUtil.recordWrite("发送闹钟提醒设置命令", paramAlarmNotify);
    return paramAlarmNotify;
  }
  
  public byte[] getAntilostSettingsCmd(AntilostInfos paramAntilostInfos)
  {
    byte[] arrayOfByte = new byte[7];
    arrayOfByte[0] = ((byte)paramAntilostInfos.mode);
    paramAntilostInfos = createCmd((byte)3, (byte)33, arrayOfByte);
    UartLogUtil.recordWrite("发送防丢设置命令 ", paramAntilostInfos);
    return paramAntilostInfos;
  }
  
  public byte[] getFindPhoneCmd(boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[7];
    if (paramBoolean) {
      arrayOfByte[0] = -86;
    }
    for (;;)
    {
      arrayOfByte = createCmd((byte)3, (byte)38, arrayOfByte);
      UartLogUtil.recordWrite("发送寻找手机设置命令 ", arrayOfByte);
      return arrayOfByte;
      arrayOfByte[0] = 85;
    }
  }
  
  public byte[] getHVSettingsCmd(byte paramByte)
  {
    byte[] arrayOfByte = new byte[7];
    arrayOfByte[0] = paramByte;
    arrayOfByte = createCmd((byte)3, (byte)43, arrayOfByte);
    UartLogUtil.recordWrite("发送横竖屏设置命令 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getHVSettingsCmd(boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[7];
    if (paramBoolean) {
      arrayOfByte[0] = 1;
    }
    for (;;)
    {
      arrayOfByte = createCmd((byte)3, (byte)43, arrayOfByte);
      UartLogUtil.recordWrite("发送横竖屏设置命令 ", arrayOfByte);
      return arrayOfByte;
      arrayOfByte[0] = 2;
    }
  }
  
  public byte[] getHandSettingsCmd()
  {
    byte[] arrayOfByte = createCmd((byte)3, (byte)34, new byte[7]);
    UartLogUtil.recordWrite("发送左右手佩戴设置命令 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getHeartModeCmd(int paramInt)
  {
    byte[] arrayOfByte = new byte[7];
    switch (paramInt)
    {
    default: 
      arrayOfByte[0] = -120;
    }
    for (;;)
    {
      arrayOfByte = createCmd((byte)3, (byte)37, arrayOfByte);
      UartLogUtil.recordWrite("心率监测模式设置", arrayOfByte);
      return arrayOfByte;
      arrayOfByte[0] = -86;
      continue;
      arrayOfByte[0] = 85;
      continue;
      arrayOfByte[0] = -120;
    }
  }
  
  public byte[] getHeartRangeCmd(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[7];
    arrayOfByte[0] = ((byte)paramInt1);
    arrayOfByte[1] = ((byte)paramInt2);
    arrayOfByte[2] = ((byte)paramInt3);
    arrayOfByte = createCmd((byte)3, (byte)36, arrayOfByte);
    UartLogUtil.recordWrite("心心率区间设置", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getIncomingCallSettingsCmd()
  {
    byte[] arrayOfByte = createCmd((byte)3, (byte)48, new byte[7]);
    UartLogUtil.recordWrite("发送来电通知开关设置命令 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getMessageSettingsCmd()
  {
    byte[] arrayOfByte = createCmd((byte)3, (byte)49, new byte[7]);
    UartLogUtil.recordWrite("发送信息通知开关设置命令 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getMultiTargetSettingsCmd(MultiTarget paramMultiTarget)
  {
    int i = paramMultiTarget.sportType;
    byte[] arrayOfByte = ByteDataConvertUtil.IntToBin(paramMultiTarget.sportTarget, 4);
    paramMultiTarget = createCmd((byte)3, (byte)3, new byte[] { i, arrayOfByte[3], arrayOfByte[2], arrayOfByte[1], arrayOfByte[0], paramMultiTarget.sleepFlag, ByteDataConvertUtil.Int2Byte(paramMultiTarget.sleepHour), ByteDataConvertUtil.Int2Byte(paramMultiTarget.sleepMinute) });
    UartLogUtil.recordWrite("发送运动目标、睡眠目标等设置命令", paramMultiTarget);
    return paramMultiTarget;
  }
  
  public byte[] getMusicContrlCmd(boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[7];
    if (paramBoolean) {
      arrayOfByte[0] = -86;
    }
    for (;;)
    {
      arrayOfByte = createCmd((byte)3, (byte)42, arrayOfByte);
      UartLogUtil.recordWrite("发送音乐开关设置命令 ", arrayOfByte);
      return arrayOfByte;
      arrayOfByte[0] = 85;
    }
  }
  
  public byte[] getOSSettingsCmd()
  {
    byte[] arrayOfByte = createCmd((byte)3, (byte)35, new byte[7]);
    UartLogUtil.recordWrite("发送手机操作系统设置命令 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getOneKeyRestoreCmd()
  {
    byte[] arrayOfByte = new byte[7];
    arrayOfByte[0] = 85;
    arrayOfByte[1] = -86;
    arrayOfByte[2] = 85;
    arrayOfByte[3] = -86;
    arrayOfByte = createCmd((byte)3, (byte)39, arrayOfByte);
    UartLogUtil.recordWrite("发送一键还原默认设置命令 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSedentarinessSettingsCmd(Sedentariness paramSedentariness)
  {
    int i = ByteDataConvertUtil.Int2Byte(paramSedentariness.startHour);
    int j = ByteDataConvertUtil.Int2Byte(paramSedentariness.startMinute);
    int k = ByteDataConvertUtil.Int2Byte(paramSedentariness.endHour);
    int m = ByteDataConvertUtil.Int2Byte(paramSedentariness.endMinute);
    byte[] arrayOfByte = ByteDataConvertUtil.IntToBin(paramSedentariness.interval, 2);
    paramSedentariness = createCmd((byte)3, (byte)32, new byte[] { i, j, k, m, arrayOfByte[1], arrayOfByte[0], ByteDataConvertUtil.Int2Byte(paramSedentariness.repetitions) });
    UartLogUtil.recordWrite("发送久坐提醒设置命令 ", paramSedentariness);
    return paramSedentariness;
  }
  
  public byte[] getTimeSettingsCmd()
  {
    Object localObject = new GregorianCalendar();
    ((GregorianCalendar)localObject).setTimeInMillis(System.currentTimeMillis());
    int k = ((GregorianCalendar)localObject).get(1);
    int m = ((GregorianCalendar)localObject).get(2);
    int n = ((GregorianCalendar)localObject).get(5);
    int i1 = ((GregorianCalendar)localObject).get(11);
    int i2 = ((GregorianCalendar)localObject).get(12);
    int i3 = ((GregorianCalendar)localObject).get(13);
    int j = ((GregorianCalendar)localObject).get(7) - 2;
    int i = j;
    if (j < 0) {
      i = 6;
    }
    localObject = ByteDataConvertUtil.IntToBin(k, 2);
    localObject = createCmd((byte)3, (byte)1, new byte[] { localObject[1], localObject[0], (byte)(m + 1), (byte)n, (byte)i1, (byte)i2, (byte)i3, (byte)i });
    UartLogUtil.recordWrite("发送时间设置命令 ", (byte[])localObject);
    return (byte[])localObject;
  }
  
  public byte[] getUnitSettingsCmd(Units paramUnits)
  {
    paramUnits = createCmd((byte)3, (byte)17, new byte[] { ByteDataConvertUtil.Int2Byte(paramUnits.dist), ByteDataConvertUtil.Int2Byte(paramUnits.weight), ByteDataConvertUtil.Int2Byte(paramUnits.temp), ByteDataConvertUtil.Int2Byte(paramUnits.stride), ByteDataConvertUtil.Int2Byte(paramUnits.language), ByteDataConvertUtil.Int2Byte(paramUnits.timeMode) });
    UartLogUtil.recordWrite("发送单位设置命令 ", paramUnits);
    return paramUnits;
  }
  
  public byte[] getUserinfosSettingsCmd(Userinfos paramUserinfos)
  {
    int i = ByteDataConvertUtil.Int2Byte(paramUserinfos.height);
    byte[] arrayOfByte = ByteDataConvertUtil.IntToBin(paramUserinfos.weight * 100, 2);
    int j = arrayOfByte[1];
    int k = arrayOfByte[0];
    int m = ByteDataConvertUtil.Int2Byte(paramUserinfos.gender);
    arrayOfByte = ByteDataConvertUtil.IntToBin(paramUserinfos.year, 2);
    paramUserinfos = createCmd((byte)3, (byte)16, new byte[] { i, j, k, m, arrayOfByte[1], arrayOfByte[0], ByteDataConvertUtil.Int2Byte(paramUserinfos.month), ByteDataConvertUtil.Int2Byte(paramUserinfos.day) });
    UartLogUtil.recordWrite("发送用户信息设置命令 ", paramUserinfos);
    return paramUserinfos;
  }
  
  public byte[] getWristDisturbModeCmd(boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[7];
    if (paramBoolean) {
      arrayOfByte[0] = -86;
    }
    for (;;)
    {
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      arrayOfByte[3] = 35;
      arrayOfByte[4] = 89;
      arrayOfByte = createCmd((byte)3, (byte)41, arrayOfByte);
      UartLogUtil.recordWrite("发送抬腕手势开关设置命令 ", arrayOfByte);
      return arrayOfByte;
      arrayOfByte[0] = 85;
    }
  }
  
  public byte[] getWristDisturbModeCmd(boolean paramBoolean, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    byte[] arrayOfByte = new byte[7];
    if (paramBoolean) {
      arrayOfByte[0] = -86;
    }
    for (;;)
    {
      arrayOfByte[1] = paramByte1;
      arrayOfByte[2] = paramByte2;
      arrayOfByte[3] = paramByte3;
      arrayOfByte[4] = paramByte4;
      arrayOfByte = createCmd((byte)3, (byte)41, arrayOfByte);
      UartLogUtil.recordWrite("发送抬腕手势开关设置命令 ", arrayOfByte);
      return arrayOfByte;
      arrayOfByte[0] = 85;
    }
  }
  
  public byte[] getWristGestureCmd(boolean paramBoolean, int paramInt)
  {
    byte[] arrayOfByte = new byte[7];
    if (paramBoolean) {
      arrayOfByte[0] = -86;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 2) {
        i = 3;
      }
      paramInt = i;
      if (i > 7) {
        paramInt = 7;
      }
      arrayOfByte[1] = ByteDataConvertUtil.Int2Byte(paramInt);
      arrayOfByte = createCmd((byte)3, (byte)40, arrayOfByte);
      UartLogUtil.recordWrite("发送抬腕手势开关设置命令 ", arrayOfByte);
      return arrayOfByte;
      arrayOfByte[0] = 85;
    }
  }
  
  public boolean parse(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[2] == 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\settings\SettingsCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */