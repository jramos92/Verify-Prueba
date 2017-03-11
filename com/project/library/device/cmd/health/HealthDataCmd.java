package com.project.library.device.cmd.health;

import com.project.library.database.StatisticalData;
import com.project.library.database.StatisticalDataFactory;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.util.ByteDataConvertUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class HealthDataCmd
  extends DeviceBaseCommand
{
  public static final byte FLAG_BACKGROUND = 2;
  public static final byte FLAG_FOREGROUND = 1;
  public static final byte KEY_DATA_SEND_FINISHED = -18;
  public static final byte KEY_ERROR = -1;
  public static final byte KEY_SYNC_HEARTRATE_DETAILS_HISTORY = 8;
  public static final byte KEY_SYNC_HEARTRATE_DETAILS_TODAY = 7;
  public static final byte KEY_SYNC_REQUEST = 1;
  public static final byte KEY_SYNC_SLEEP_DETAILS_HISTORY = 6;
  public static final byte KEY_SYNC_SLEEP_DETAILS_TODAY = 4;
  public static final byte KEY_SYNC_SPORTS_DETAILS_HISTORY = 5;
  public static final byte KEY_SYNC_SPORTS_DETAILS_TODAY = 3;
  public static final byte KEY_SYNC_SUCCESS = 2;
  public static final byte MODE_OTHER = 0;
  public static final byte MODE_SAFE = 1;
  public static final byte SYNC_STATUS_END = 2;
  public static final byte SYNC_STATUS_RESEND = 3;
  public static final byte SYNC_STATUS_START = 1;
  
  public static HealthDataCmd getInstance(int paramInt)
  {
    if ((paramInt == 3) || (paramInt == 5)) {
      return Sports.getInstance();
    }
    if ((paramInt == 4) || (paramInt == 6)) {
      return Sleep.getInstance();
    }
    if ((paramInt == 7) || (paramInt == 8)) {
      return HeartRates.getInstance();
    }
    return null;
  }
  
  public int checkDataSuccess()
  {
    return 0;
  }
  
  public boolean checkHeaderWithoutData(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    int i = getHeaderLen();
    byte[] arrayOfByte = new byte[i];
    ByteDataConvertUtil.BinnCat(paramArrayOfByte, arrayOfByte, 4, i);
    int j = arrayOfByte.length;
    i = 0;
    for (;;)
    {
      boolean bool1;
      if (i >= j) {
        bool1 = true;
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (arrayOfByte[i] != 0);
      i += 1;
    }
  }
  
  protected byte[] createCmd(byte paramByte1, byte paramByte2)
  {
    return createCmd((byte)8, paramByte1, paramByte2);
  }
  
  protected byte[] createCmd(byte paramByte, byte[] paramArrayOfByte)
  {
    return createCmd((byte)8, paramByte, paramArrayOfByte);
  }
  
  public int getHeaderLen()
  {
    return 0;
  }
  
  public boolean headerWithoutData()
  {
    return true;
  }
  
  public boolean isHeadReceived()
  {
    return false;
  }
  
  public boolean isHeader(byte[] paramArrayOfByte)
  {
    return false;
  }
  
  protected void makeUpdateSleepStatisticalDatas(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i >= 3)
      {
        StatisticalDataFactory.update(paramBoolean, paramLong1, 1, localArrayList);
        return;
      }
      StatisticalData localStatisticalData = StatisticalDataFactory.createData(paramLong1, i);
      localStatisticalData.setHealthType(1);
      localStatisticalData.setTotalSleep(paramLong2);
      localStatisticalData.setTotalDeepSleep(paramLong3);
      localStatisticalData.setTotalLightSleep(paramLong4);
      localStatisticalData.setTotalFallSleep(paramLong5);
      localStatisticalData.setTotalAwakeTime(paramLong6);
      localStatisticalData.setTotalAwakeDuration(paramLong7);
      localArrayList.add(localStatisticalData);
      i += 1;
    }
  }
  
  protected void makeUpdateSportStatisticalDatas(boolean paramBoolean, long paramLong1, float paramFloat, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i >= 3)
      {
        StatisticalDataFactory.update(paramBoolean, paramLong1, 0, localArrayList);
        return;
      }
      StatisticalData localStatisticalData = StatisticalDataFactory.createData(paramLong1, i);
      localStatisticalData.setHealthType(0);
      localStatisticalData.setTotalDistance(paramFloat);
      localStatisticalData.setTotalStep(paramLong2);
      localStatisticalData.setTotalCalory(paramLong3);
      localArrayList.add(localStatisticalData);
      i += 1;
    }
  }
  
  public void parse() {}
  
  public void parseHeader(byte[] paramArrayOfByte) {}
  
  public int percentAddOne()
  {
    return 0;
  }
  
  public int receiveHealthData(byte[] paramArrayOfByte)
  {
    return 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\HealthDataCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */