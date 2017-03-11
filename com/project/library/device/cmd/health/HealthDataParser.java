package com.project.library.device.cmd.health;

import com.project.library.share.LibSharedPreferences;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;

public class HealthDataParser
{
  public int activeDays = 0;
  public int heartRateDays = 0;
  private boolean isPrepared = false;
  private HealthDataCmd mHealthDataCmd = HealthDataCmd.getInstance(3);
  private byte mKey = -1;
  private int mPercent = 0;
  private int packageAllTotal = 0;
  public int sleepDays = 0;
  
  public void changeParser(byte paramByte)
  {
    if ((this.mKey != paramByte) && ((paramByte == 3) || (paramByte == 5) || (paramByte == 4) || (paramByte == 6) || (paramByte == 7) || (paramByte == 8)))
    {
      this.mHealthDataCmd = HealthDataCmd.getInstance(paramByte);
      this.mKey = paramByte;
    }
  }
  
  public int checkDataSuccess()
  {
    if (this.mHealthDataCmd != null) {
      return this.mHealthDataCmd.checkDataSuccess();
    }
    return 0;
  }
  
  public boolean checkHeaderWithoutData(byte[] paramArrayOfByte)
  {
    if (this.mHealthDataCmd != null) {
      return this.mHealthDataCmd.checkHeaderWithoutData(paramArrayOfByte);
    }
    return false;
  }
  
  public void clear()
  {
    this.mKey = -1;
    this.isPrepared = false;
    this.activeDays = 0;
    this.sleepDays = 0;
    this.heartRateDays = 0;
    this.mPercent = 0;
  }
  
  public boolean headerWithoutData()
  {
    if (this.mHealthDataCmd != null) {
      return this.mHealthDataCmd.headerWithoutData();
    }
    return false;
  }
  
  public boolean isHeadReceived()
  {
    return this.mHealthDataCmd.isHeadReceived();
  }
  
  public boolean isHeader(byte[] paramArrayOfByte)
  {
    return this.mHealthDataCmd.isHeader(paramArrayOfByte);
  }
  
  public boolean isPrepared()
  {
    return this.isPrepared;
  }
  
  public void parse()
  {
    if (this.mHealthDataCmd != null) {
      this.mHealthDataCmd.parse();
    }
  }
  
  public void parseHeader(byte[] paramArrayOfByte)
  {
    this.mHealthDataCmd.parseHeader(paramArrayOfByte);
  }
  
  public void parseStartData(byte[] paramArrayOfByte)
  {
    this.packageAllTotal = ByteDataConvertUtil.toRevInt(paramArrayOfByte, 2, 2);
    this.activeDays = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[4]);
    this.sleepDays = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[5]);
    this.heartRateDays = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[6]);
    this.isPrepared = true;
  }
  
  public int percentAddOne(int paramInt)
  {
    int i = this.mHealthDataCmd.percentAddOne();
    float f2 = this.activeDays + 1 + (this.sleepDays + 1);
    float f1 = f2;
    if (LibSharedPreferences.getInstance().getDeviceHeartRate()) {
      f1 = f2 + (this.heartRateDays + 1);
    }
    DebugLog.d("total = " + f1 + " serialDay = " + paramInt + " percent = " + i);
    return (int)(98.0F / f1 * paramInt + 98.0F / f1 * i / 100.0F);
  }
  
  public int receiveHealthData(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.isPrepared) {
      return 0;
    }
    int i = this.mHealthDataCmd.receiveHealthData(paramArrayOfByte);
    float f2 = this.activeDays + 1 + (this.sleepDays + 1);
    float f1 = f2;
    if (LibSharedPreferences.getInstance().getDeviceHeartRate()) {
      f1 = f2 + (this.heartRateDays + 1);
    }
    DebugLog.d("total = " + f1 + " serialDay = " + paramInt + " percent = " + i);
    return (int)(98.0F / f1 * paramInt + 98.0F / f1 * i / 100.0F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\HealthDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */