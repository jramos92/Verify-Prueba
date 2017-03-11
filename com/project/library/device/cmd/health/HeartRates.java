package com.project.library.device.cmd.health;

import com.project.library.database.DaoSession;
import com.project.library.database.HeartRate;
import com.project.library.database.HeartRateDao;
import com.project.library.database.HeartRateDao.Properties;
import com.project.library.database.HeartRateTreshold;
import com.project.library.database.HeartRateTresholdDao;
import com.project.library.database.SportDataDayDao.Properties;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.project.library.util.UartLogUtil;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HeartRates
  extends HealthDataCmd
{
  private static final int HEADER_LEN = 16;
  private static final int HEARTRATE_ITEM_DATA_LEN = 2;
  private static final int TOTAL_HEADER_COUNT = 2;
  private static HeartRates mInstance = null;
  private int aerobic_mins = 0;
  private int aerobic_threshold = 0;
  private int burn_fat_mins = 0;
  private int burn_fat_threshold = 0;
  private long date = -1L;
  private int day = 10;
  private boolean headerWithoutData = false;
  private int itemCount = 0;
  private int limit_mins = 0;
  private int limit_threshold = 0;
  private HashMap<Integer, byte[]> mDataHashMap = new HashMap();
  private int month = 6;
  private int receivedPacketCount = 0;
  private int silentHeart = 0;
  private int startTime = 0;
  private int totalPacket = 0;
  private int year = 2015;
  
  private void clearData()
  {
    this.date = -1L;
    this.totalPacket = 0;
    this.receivedPacketCount = 0;
    this.mDataHashMap.clear();
  }
  
  public static HeartRates getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new HeartRates();
      }
      HeartRates localHeartRates = mInstance;
      return localHeartRates;
    }
    finally {}
  }
  
  private byte getSerialNumber(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[2];
  }
  
  private void save(int paramInt, byte[] paramArrayOfByte)
  {
    this.receivedPacketCount += 1;
    this.mDataHashMap.put(Integer.valueOf(paramInt), paramArrayOfByte);
  }
  
  private void save(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) || ((paramInt3 == 0) && (paramArrayOfByte[1] != 238)))
    {
      arrayOfByte = new byte[paramInt3];
      ByteDataConvertUtil.BinnCat(paramArrayOfByte, arrayOfByte, paramInt2, paramInt3);
      save(paramInt1, arrayOfByte);
    }
    while (paramArrayOfByte[1] != 238)
    {
      byte[] arrayOfByte;
      return;
    }
    this.receivedPacketCount += 1;
  }
  
  public int checkDataSuccess()
  {
    int i;
    if ((this.mDataHashMap != null) && (!this.mDataHashMap.isEmpty()) && (this.mDataHashMap.size() > 2)) {
      i = 1;
    }
    for (;;)
    {
      int j;
      if (i > this.totalPacket) {
        j = 0;
      }
      do
      {
        return j;
        j = i;
      } while (!this.mDataHashMap.containsKey(Integer.valueOf(i)));
      i += 1;
    }
  }
  
  public int getHeaderLen()
  {
    return 16;
  }
  
  public byte[] getSyncDetailsEnd()
  {
    byte[] arrayOfByte = createCmd((byte)7, (byte)2);
    UartLogUtil.recordWrite("发送结束同步当天心率", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncDetailsResend(byte paramByte)
  {
    return createCmd((byte)7, new byte[] { 3, paramByte });
  }
  
  public byte[] getSyncDetailsStart()
  {
    UartLogUtil.recordWrite("发送开始同步当天心率", createCmd((byte)7, (byte)1));
    return createCmd((byte)7, (byte)1);
  }
  
  public byte[] getSyncHistoryDetailsEnd()
  {
    byte[] arrayOfByte = createCmd((byte)8, (byte)2);
    UartLogUtil.recordWrite("发送结束同步历史心率", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncHistoryDetailsResend(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)8, new byte[] { 3, paramByte });
    UartLogUtil.recordWrite("历史心率数据漏包重发指令", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncHistoryDetailsStart()
  {
    byte[] arrayOfByte = createCmd((byte)8, (byte)1);
    UartLogUtil.recordWrite("发送开始同步历史心率", arrayOfByte);
    return arrayOfByte;
  }
  
  public boolean headerWithoutData()
  {
    return this.headerWithoutData;
  }
  
  public boolean isHeadReceived()
  {
    return (this.mDataHashMap.containsKey(Integer.valueOf(1))) && (this.mDataHashMap.containsKey(Integer.valueOf(2)));
  }
  
  public boolean isHeader(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (getSerialNumber(paramArrayOfByte) != 1)
    {
      bool1 = bool2;
      if (getSerialNumber(paramArrayOfByte) != 2) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void parse()
  {
    Object localObject2;
    HeartRateDao localHeartRateDao;
    int k;
    Object localObject1;
    List localList;
    int m;
    label136:
    int n;
    label150:
    int j;
    ArrayList localArrayList;
    int i;
    int i1;
    if ((this.date > 0L) && (this.totalPacket > 2) && (!this.mDataHashMap.isEmpty()))
    {
      DebugLog.e("心率数据item总个数: " + this.itemCount);
      localObject2 = DBTool.getInstance().getDaoSession();
      localHeartRateDao = ((DaoSession)localObject2).getHeartRateDao();
      k = this.startTime;
      localObject1 = localHeartRateDao.queryBuilder();
      if (k > 0)
      {
        ((QueryBuilder)localObject1).where(HeartRateDao.Properties.Date.ge(Long.valueOf(this.date)), new WhereCondition[] { HeartRateDao.Properties.Minute.ge(Integer.valueOf(k)) });
        localList = ((QueryBuilder)localObject1).list();
        if (!localList.isEmpty()) {
          break label457;
        }
        m = 0;
        if (m == 0) {
          break label463;
        }
        n = localList.size();
        j = 0;
        localArrayList = new ArrayList();
        i = 0;
        i1 = 1;
        label166:
        if (i1 <= this.totalPacket) {
          break label469;
        }
        if ((localList != null) && (!localList.isEmpty()))
        {
          if (m == 0) {
            break label702;
          }
          localHeartRateDao.updateInTx(localList);
          if (i != 0) {
            localHeartRateDao.insertInTx(localArrayList);
          }
          label213:
          localObject2 = ((DaoSession)localObject2).getHeartRateTresholdDao();
          localObject1 = ((HeartRateTresholdDao)localObject2).queryBuilder();
          ((QueryBuilder)localObject1).where(SportDataDayDao.Properties.Date.eq(Long.valueOf(this.date)), new WhereCondition[0]);
          localObject1 = ((QueryBuilder)localObject1).list();
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break label712;
          }
          i = 1;
          label274:
          if (i == 0) {
            break label717;
          }
          localObject1 = (HeartRateTreshold)((List)localObject1).get(0);
          label291:
          ((HeartRateTreshold)localObject1).setDate(this.date);
          ((HeartRateTreshold)localObject1).setSilentHeartRate(this.silentHeart);
          ((HeartRateTreshold)localObject1).setMinThreshold(0);
          ((HeartRateTreshold)localObject1).setMaxThreshold(220);
          ((HeartRateTreshold)localObject1).setBurnFatThreshold(this.burn_fat_threshold);
          ((HeartRateTreshold)localObject1).setAerobicThreshold(this.aerobic_threshold);
          ((HeartRateTreshold)localObject1).setLimitThreshold(this.limit_threshold);
          ((HeartRateTreshold)localObject1).setBurnFatMins(this.burn_fat_mins);
          ((HeartRateTreshold)localObject1).setAerobicMins(this.aerobic_mins);
          ((HeartRateTreshold)localObject1).setLimitMins(this.limit_mins);
          if (i == 0) {
            break label729;
          }
          ((HeartRateTresholdDao)localObject2).update(localObject1);
          label388:
          HealthDataDetailsCache.getInstance().updateHeartRateDataDay(this.date, (HeartRateTreshold)localObject1);
        }
      }
    }
    for (;;)
    {
      DebugLog.e(this.date + ">>>心率数据解析完成");
      clearData();
      return;
      ((QueryBuilder)localObject1).where(HeartRateDao.Properties.Date.eq(Long.valueOf(this.date)), new WhereCondition[0]);
      break;
      label457:
      m = 1;
      break label136;
      label463:
      n = 0;
      break label150;
      label469:
      byte[] arrayOfByte = (byte[])this.mDataHashMap.get(Integer.valueOf(i1));
      int i4 = i;
      int i3 = j;
      int i2 = k;
      if (arrayOfByte != null)
      {
        i4 = arrayOfByte.length;
        i2 = 0;
        if (i2 > i4 - 2)
        {
          i2 = k;
          i3 = j;
          i4 = i;
        }
      }
      else
      {
        i1 += 1;
        i = i4;
        j = i3;
        k = i2;
        break label166;
      }
      localObject1 = new byte[2];
      ByteDataConvertUtil.BinnCat(arrayOfByte, (byte[])localObject1, i2, 2);
      i3 = ByteDataConvertUtil.Byte2Int(localObject1[0]) + k;
      k = i3;
      int i5 = ByteDataConvertUtil.Byte2Int(localObject1[1]);
      if (j < n)
      {
        localObject1 = (HeartRate)localList.get(j);
        label601:
        ((HeartRate)localObject1).setDate(this.date);
        ((HeartRate)localObject1).setMinute(i3);
        ((HeartRate)localObject1).setRate(i5);
        if (m == 0) {
          break label689;
        }
        if (i == 0) {
          break label675;
        }
        localArrayList.add(localObject1);
      }
      for (;;)
      {
        j += 1;
        i2 += 2;
        break;
        if (n > 0) {
          i = 1;
        }
        localObject1 = new HeartRate();
        break label601;
        label675:
        localList.set(j, localObject1);
        continue;
        label689:
        localList.add(localObject1);
      }
      label702:
      localHeartRateDao.insertInTx(localList);
      break label213;
      label712:
      i = 0;
      break label274;
      label717:
      localObject1 = new HeartRateTreshold();
      break label291;
      label729:
      ((HeartRateTresholdDao)localObject2).insert(localObject1);
      break label388;
      this.headerWithoutData = true;
    }
  }
  
  public void parseHeader(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if (isHeader(paramArrayOfByte))
    {
      arrayOfByte = new byte[16];
      ByteDataConvertUtil.BinnCat(paramArrayOfByte, arrayOfByte, 4, 16);
      if (getSerialNumber(paramArrayOfByte) != 1) {
        break label161;
      }
      clearData();
      this.year = ByteDataConvertUtil.toRevInt(arrayOfByte, 0, 2);
      this.month = ByteDataConvertUtil.Byte2Int(arrayOfByte[2]);
      this.day = ByteDataConvertUtil.Byte2Int(arrayOfByte[3]);
      this.startTime = ByteDataConvertUtil.toRevInt(arrayOfByte, 4, 2);
      this.silentHeart = ByteDataConvertUtil.Byte2Int(arrayOfByte[6]);
      this.itemCount = ByteDataConvertUtil.toRevInt(arrayOfByte, 7, 2);
      this.totalPacket = ByteDataConvertUtil.Byte2Int(arrayOfByte[9]);
      this.date = (this.year * 10000 + this.month * 100 + this.day);
      this.receivedPacketCount = 0;
      this.headerWithoutData = checkHeaderWithoutData(paramArrayOfByte);
    }
    for (;;)
    {
      save(ByteDataConvertUtil.Byte2Int(getSerialNumber(paramArrayOfByte)), null);
      return;
      label161:
      if (getSerialNumber(paramArrayOfByte) == 2)
      {
        this.burn_fat_threshold = ByteDataConvertUtil.Byte2Int(arrayOfByte[0]);
        if (this.burn_fat_threshold == 0) {
          this.burn_fat_threshold = 90;
        }
        this.aerobic_threshold = ByteDataConvertUtil.Byte2Int(arrayOfByte[1]);
        if (this.aerobic_threshold == 0) {
          this.aerobic_threshold = 60;
        }
        this.limit_threshold = ByteDataConvertUtil.Byte2Int(arrayOfByte[2]);
        if (this.limit_threshold == 0) {
          this.limit_threshold = 120;
        }
        this.burn_fat_mins = ByteDataConvertUtil.toRevInt(arrayOfByte, 3, 2);
        this.aerobic_mins = ByteDataConvertUtil.toRevInt(arrayOfByte, 5, 2);
        this.limit_mins = ByteDataConvertUtil.toRevInt(arrayOfByte, 7, 2);
      }
    }
  }
  
  public int percentAddOne()
  {
    int i = this.receivedPacketCount + 1;
    this.receivedPacketCount = i;
    if (i > this.totalPacket) {
      this.receivedPacketCount = this.totalPacket;
    }
    return (int)(this.receivedPacketCount / this.totalPacket * 100.0F);
  }
  
  public int receiveHealthData(byte[] paramArrayOfByte)
  {
    int i = ByteDataConvertUtil.Byte2Int(getSerialNumber(paramArrayOfByte));
    int j = ByteDataConvertUtil.Byte2Int(paramArrayOfByte[3]);
    if (!isHeader(paramArrayOfByte)) {
      save(paramArrayOfByte, i, 4, j);
    }
    if (this.receivedPacketCount > this.totalPacket) {
      this.receivedPacketCount = this.totalPacket;
    }
    DebugLog.d("receivedPacketCount = " + this.receivedPacketCount + " totalPacket = " + this.totalPacket);
    return (int)(this.receivedPacketCount / this.totalPacket * 100.0F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\HeartRates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */