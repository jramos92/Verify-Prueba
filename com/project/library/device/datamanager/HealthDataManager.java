package com.project.library.device.datamanager;

import android.os.Handler;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.device.cmd.health.HealthDataParser;
import com.project.library.device.cmd.health.HealthSyncSuccess;
import com.project.library.device.cmd.health.HeartRates;
import com.project.library.device.cmd.health.Sleep;
import com.project.library.device.cmd.health.Sports;
import com.project.library.protocol.AppBleNotifyListener;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;

public class HealthDataManager
  extends BaseDataManager
{
  private boolean isDataFinished = false;
  private HealthDataParser mHealthDataParser = new HealthDataParser();
  private int mKey = -1;
  private int serialDays;
  
  private void checkAndNext()
  {
    int i = this.mHealthDataParser.checkDataSuccess();
    if (i > 0)
    {
      DebugLog.d("漏包：" + i);
      if (this.mKey == 3) {
        writeForce(Sports.getInstance().getSyncDetailsResend((byte)i));
      }
    }
    do
    {
      do
      {
        return;
        if (this.mKey == 5)
        {
          writeForce(Sports.getInstance().getSyncHistoryDetailsResend((byte)i));
          return;
        }
        if (this.mKey == 4)
        {
          writeForce(Sleep.getInstance().getSyncDetailsResend((byte)i));
          return;
        }
        if (this.mKey == 6)
        {
          writeForce(Sleep.getInstance().getSyncHistoryDetailsResend((byte)i));
          return;
        }
        if (this.mKey == 7)
        {
          writeForce(HeartRates.getInstance().getSyncDetailsResend((byte)i));
          return;
        }
      } while (this.mKey != 8);
      writeForce(HeartRates.getInstance().getSyncHistoryDetailsResend((byte)i));
      return;
      this.serialDays += 1;
      this.isDataFinished = true;
      DebugLog.d("数据完整");
      this.mHealthDataParser.parse();
      if (this.mKey == 3)
      {
        writeForce(Sports.getInstance().getSyncDetailsEnd());
        return;
      }
      if (this.mKey == 5)
      {
        writeForce(Sports.getInstance().getSyncHistoryDetailsEnd());
        return;
      }
      if (this.mKey == 4)
      {
        writeForce(Sleep.getInstance().getSyncDetailsEnd());
        return;
      }
      if (this.mKey == 6)
      {
        writeForce(Sleep.getInstance().getSyncHistoryDetailsEnd());
        return;
      }
      if (this.mKey == 7)
      {
        writeForce(HeartRates.getInstance().getSyncDetailsEnd());
        return;
      }
    } while (this.mKey != 8);
    writeForce(HeartRates.getInstance().getSyncHistoryDetailsEnd());
  }
  
  private void dealHealth(final byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      this.mReceiveHandler.post(new Runnable()
      {
        public void run()
        {
          String str = ByteDataConvertUtil.bytesToHexString(paramArrayOfByte);
          DebugLog.e("收到健康数据\n" + str);
          int i = DeviceBaseCommand.getCmdId(paramArrayOfByte);
          byte b = DeviceBaseCommand.getCmdKey(paramArrayOfByte);
          if (DeviceBaseCommand.getCmdId(HealthDataManager.this.mLastCommand) == i) {
            HealthDataManager.this.mWriteHandler.removeCallbacks(HealthDataManager.this.mWriteRunnable);
          }
          if ((DeviceBaseCommand.getCmdKey(HealthDataManager.this.mLastCommand) != b) && (b != -18))
          {
            HealthDataManager.this.writeForce(HealthDataManager.this.mLastCommand);
            DebugLog.e("收到健康数据--重发mLastCommand:" + ByteDataConvertUtil.bytesToHexString(HealthDataManager.this.mLastCommand));
            return;
          }
          HealthDataManager.this.mHealthDataParser.changeParser(b);
          HealthDataManager.this.receivedHealthData(b, paramArrayOfByte);
          DebugLog.e("收到健康数据mLastCommand:" + ByteDataConvertUtil.bytesToHexString(HealthDataManager.this.mLastCommand));
        }
      });
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  private void healthDataParser(byte paramByte, byte[] paramArrayOfByte)
  {
    if (this.mHealthDataParser.isHeader(paramArrayOfByte))
    {
      this.isDataFinished = false;
      this.mHealthDataParser.parseHeader(paramArrayOfByte);
      paramByte = this.mHealthDataParser.percentAddOne(this.serialDays);
      if (this.mAppBleNotifyListener != null) {
        this.mAppBleNotifyListener.onSyncData(paramByte);
      }
    }
    do
    {
      return;
      if (!this.mHealthDataParser.isHeadReceived()) {
        break;
      }
      paramByte = this.mHealthDataParser.receiveHealthData(paramArrayOfByte, this.serialDays);
    } while (this.mAppBleNotifyListener == null);
    this.mAppBleNotifyListener.onSyncData(paramByte);
    return;
    writeForce(this.mLastCommand);
  }
  
  private void receivedHealthData(byte paramByte, byte[] paramArrayOfByte)
  {
    switch (paramByte)
    {
    }
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.serialDays = 0;
                this.mWriteHandler.removeCallbacksAndMessages(null);
                this.mHealthDataParser.clear();
                this.mHealthDataParser.parseStartData(paramArrayOfByte);
              } while (!LibSharedPreferences.getInstance().isSyncData());
              writeForce(Sports.getInstance().getSyncDetailsStart());
              return;
              this.mWriteHandler.removeCallbacksAndMessages(null);
              this.canWriteNext = true;
              DebugLog.e("数据全部同步完成了。这里要通知app。");
            } while (this.mAppBleNotifyListener == null);
            this.mAppBleNotifyListener.onSyncData(100);
            this.serialDays = 0;
            return;
            this.mKey = paramByte;
            this.mWriteHandler.removeCallbacksAndMessages(null);
            if (!this.isDataFinished) {
              break;
            }
            this.isDataFinished = false;
            if (this.mKey == 3)
            {
              DebugLog.d("当天运动同步完成，之后同步睡眠............");
              writeForce(Sleep.getInstance().getSyncDetailsStart());
              return;
            }
            if (this.mKey == 4)
            {
              if (LibSharedPreferences.getInstance().getDeviceHeartRate())
              {
                DebugLog.d("当天睡眠同步完成之后，同步心率............");
                writeForce(HeartRates.getInstance().getSyncDetailsStart());
                return;
              }
              DebugLog.d("当天睡眠同步完成之后，同步历史运动数据............");
              startSyncSportHistory();
              return;
            }
            if (this.mKey == 7)
            {
              DebugLog.d("当天心率同步完成之后，同步历史运动数据............");
              startSyncSportHistory();
              return;
            }
            if (this.mKey == 5)
            {
              if (this.mHealthDataParser.headerWithoutData())
              {
                if (LibSharedPreferences.getInstance().getDeviceHeartRate())
                {
                  startSyncSleepHistory2();
                  return;
                }
                startSyncSleepHistory();
                return;
              }
              writeForce(Sports.getInstance().getSyncHistoryDetailsStart());
              return;
            }
            if (this.mKey == 6)
            {
              if (this.mHealthDataParser.headerWithoutData())
              {
                startSyncHeartRateHistory();
                return;
              }
              writeForce(Sleep.getInstance().getSyncHistoryDetailsStart());
              return;
            }
          } while (this.mKey != 8);
          if (this.mHealthDataParser.headerWithoutData())
          {
            writeForce(HealthSyncSuccess.getInstance().getHealthSyncSuccessCmd((byte)1, (byte)1));
            return;
          }
          writeForce(HeartRates.getInstance().getSyncHistoryDetailsStart());
          return;
        } while (!this.mHealthDataParser.isPrepared());
        healthDataParser(paramByte, paramArrayOfByte);
        return;
        if ((!this.mHealthDataParser.isPrepared()) || (!this.mHealthDataParser.isHeadReceived())) {
          break;
        }
        writeForce(paramArrayOfByte);
        i = this.mHealthDataParser.percentAddOne(this.serialDays);
      } while (this.mAppBleNotifyListener == null);
      this.mAppBleNotifyListener.onSyncData(i);
      return;
      clear();
      this.mWriteHandler.removeCallbacksAndMessages(null);
      this.canWriteNext = true;
    } while (this.mAppBleNotifyListener == null);
    this.mAppBleNotifyListener.onSyncData(100);
    this.serialDays = 0;
  }
  
  private void startSyncHeartRateHistory()
  {
    if (this.mHealthDataParser.heartRateDays != 0)
    {
      DebugLog.d("有历史心率mHealthDataParser.heartRateDays != 0...........");
      writeForce(HeartRates.getInstance().getSyncHistoryDetailsStart());
      return;
    }
    DebugLog.d("没有历史心率mHealthDataParser.heartRateDays = 0...........");
    writeForce(HealthSyncSuccess.getInstance().getHealthSyncSuccessCmd((byte)1, (byte)1));
  }
  
  private void startSyncSleepHistory()
  {
    if (this.mHealthDataParser.sleepDays != 0)
    {
      DebugLog.d("有历史睡眠mHealthDataParser.sleepDays != 0...........");
      writeForce(Sleep.getInstance().getSyncHistoryDetailsStart());
      return;
    }
    DebugLog.d("没有历史睡眠mHealthDataParser.sleepDays = 0...........");
    writeForce(HealthSyncSuccess.getInstance().getHealthSyncSuccessCmd((byte)1, (byte)1));
  }
  
  private void startSyncSleepHistory2()
  {
    if (this.mHealthDataParser.sleepDays != 0)
    {
      DebugLog.d("有历史睡眠mHealthDataParser.sleepDays != 0...........");
      writeForce(Sleep.getInstance().getSyncHistoryDetailsStart());
      return;
    }
    DebugLog.d("没有历史睡眠mHealthDataParser.sleepDays = 0...........");
    startSyncHeartRateHistory();
  }
  
  private void startSyncSportHistory()
  {
    if (this.mHealthDataParser.activeDays != 0)
    {
      DebugLog.d("有运动数据  mHealthDataParser.activeDays != 0............");
      writeForce(Sports.getInstance().getSyncHistoryDetailsStart());
      return;
    }
    DebugLog.d("没有运动数据mHealthDataParser.activeDays=0...........");
    if (LibSharedPreferences.getInstance().getDeviceHeartRate())
    {
      startSyncSleepHistory2();
      return;
    }
    startSyncSleepHistory();
  }
  
  public void clear()
  {
    super.clear();
    this.isDataFinished = false;
    if (this.mHealthDataParser != null) {
      this.mHealthDataParser.clear();
    }
  }
  
  public boolean isNeedReply(byte[] paramArrayOfByte)
  {
    return DeviceBaseCommand.getCmdKey(paramArrayOfByte) != -18;
  }
  
  public void onCommandWriteSuccess(byte[] paramArrayOfByte)
  {
    super.onCommandWriteSuccess(paramArrayOfByte);
    int i = DeviceBaseCommand.getCmdId(paramArrayOfByte);
    int j = DeviceBaseCommand.getCmdKey(paramArrayOfByte);
    DebugLog.d("cmdId = " + i + "------key = " + j);
    if ((i == 8) && (j == -18)) {
      checkAndNext();
    }
  }
  
  public void receive(byte[] paramArrayOfByte, String paramString)
  {
    dealHealth(paramArrayOfByte, paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\datamanager\HealthDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */