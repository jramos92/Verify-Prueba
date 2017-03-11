package com.project.library.device.cmd.health;

import com.project.library.database.DaoSession;
import com.project.library.database.SleepDataDay;
import com.project.library.database.SleepDataDayDao;
import com.project.library.database.SleepDataDayDao.Properties;
import com.project.library.database.SleepDataItem;
import com.project.library.database.SleepDataItemDao;
import com.project.library.database.SleepDataItemDao.Properties;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import com.project.library.util.UartLogUtil;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Sleep
  extends HealthDataCmd
{
  private static final int HEADER_LEN = 16;
  private static final int SLEEP_ITEM_DATA_LEN = 2;
  private static final int TOTAL_HEADER_COUNT = 2;
  private static Sleep mInstance = null;
  private int awakeCount = 0;
  private long date = -1L;
  private int day = 10;
  private int deepSleepCount = 0;
  private int deepSleepMinutes = 0;
  private boolean headerWithoutData = false;
  private int lightSleepCount = 0;
  private int lightSleepMinutes = 0;
  private HashMap<Integer, byte[]> mDataHashMap = new HashMap();
  private int month = 6;
  private int receivedPacketCount = 0;
  private int sleepEndedTimeH = 0;
  private int sleepEndedTimeM = 0;
  private int sleepItemCount = 0;
  private int totalPacket = 0;
  private int totalSleepMinutes = 0;
  private int year = 2015;
  
  private void clearData()
  {
    this.date = -1L;
    this.totalPacket = 0;
    this.receivedPacketCount = 0;
    this.mDataHashMap.clear();
  }
  
  public static Sleep getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new Sleep();
      }
      Sleep localSleep = mInstance;
      return localSleep;
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
    if (paramInt3 > 0)
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
      if (i > this.totalPacket - 3) {
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
    byte[] arrayOfByte = createCmd((byte)4, (byte)2);
    UartLogUtil.recordWrite("发送结束同步当天睡眠 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncDetailsResend(byte paramByte)
  {
    return createCmd((byte)4, new byte[] { 3, paramByte });
  }
  
  public byte[] getSyncDetailsStart()
  {
    byte[] arrayOfByte = createCmd((byte)4, (byte)1);
    UartLogUtil.recordWrite("发送开始同步当天睡眠 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncHistoryDetailsEnd()
  {
    byte[] arrayOfByte = createCmd((byte)6, (byte)2);
    UartLogUtil.recordWrite("发送结束同步历史睡眠 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncHistoryDetailsResend(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)6, new byte[] { 3, paramByte });
    UartLogUtil.recordWrite("历史数据漏包重发指令", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncHistoryDetailsStart()
  {
    byte[] arrayOfByte = createCmd((byte)6, (byte)1);
    UartLogUtil.recordWrite("发送开始同步历史睡眠 ", arrayOfByte);
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
    SleepDataItemDao localSleepDataItemDao;
    List localList;
    int k;
    int m;
    label119:
    int j;
    ArrayList localArrayList;
    int i;
    int n;
    label135:
    label181:
    Object localObject1;
    boolean bool;
    if ((this.date > 0L) && (this.totalPacket > 2) && (!this.mDataHashMap.isEmpty()))
    {
      DebugLog.e("睡眠数据item总个数: " + this.sleepItemCount);
      localObject2 = DBTool.getInstance().getDaoSession();
      localSleepDataItemDao = ((DaoSession)localObject2).getSleepDataItemDao();
      localList = localSleepDataItemDao.queryBuilder().where(SleepDataItemDao.Properties.Date.eq(Long.valueOf(this.date)), new WhereCondition[0]).list();
      if (localList.isEmpty())
      {
        k = 0;
        if (k == 0) {
          break label469;
        }
        m = localList.size();
        j = 0;
        localArrayList = new ArrayList();
        i = 0;
        n = 1;
        if (n <= this.totalPacket) {
          break label475;
        }
        if ((localList != null) && (!localList.isEmpty()))
        {
          if (k == 0) {
            break label725;
          }
          localSleepDataItemDao.updateInTx(localList);
          if (i != 0) {
            localSleepDataItemDao.insertInTx(localArrayList);
          }
          localObject2 = ((DaoSession)localObject2).getSleepDataDayDao();
          localObject1 = ((SleepDataDayDao)localObject2).queryBuilder();
          ((QueryBuilder)localObject1).where(SleepDataDayDao.Properties.Date.eq(Long.valueOf(this.date)), new WhereCondition[0]);
          localObject1 = ((QueryBuilder)localObject1).list();
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break label735;
          }
          bool = true;
          label243:
          if (!bool) {
            break label741;
          }
          localObject1 = (SleepDataDay)((List)localObject1).get(0);
          label261:
          long l = LongDateUtil.Calendar2LongDate(Calendar.getInstance());
          if (this.date != l) {
            break label753;
          }
          makeUpdateSleepStatisticalDatas(bool, this.date, this.totalSleepMinutes - ((SleepDataDay)localObject1).getTotalSleepMinutes(), this.deepSleepMinutes - ((SleepDataDay)localObject1).getDeepSleepMinutes(), this.lightSleepMinutes - ((SleepDataDay)localObject1).getLightSleepMinutes(), 0L, 0L, 0L);
          label325:
          ((SleepDataDay)localObject1).setDate(Long.valueOf(this.date));
          ((SleepDataDay)localObject1).setEndTimeHour(this.sleepEndedTimeH);
          ((SleepDataDay)localObject1).setEndTimeMinute(this.sleepEndedTimeM);
          ((SleepDataDay)localObject1).setTotalSleepMinutes(this.totalSleepMinutes);
          ((SleepDataDay)localObject1).setLightSleepCount(this.lightSleepCount);
          ((SleepDataDay)localObject1).setDeepSleepCount(this.deepSleepCount);
          ((SleepDataDay)localObject1).setAwakeCount(this.awakeCount);
          ((SleepDataDay)localObject1).setLightSleepMinutes(this.lightSleepMinutes);
          ((SleepDataDay)localObject1).setDeepSleepMinutes(this.deepSleepMinutes);
          if (!bool) {
            break label784;
          }
          ((SleepDataDayDao)localObject2).update(localObject1);
          label421:
          HealthDataDetailsCache.getInstance().updateHealthDataDay(this.date, (SleepDataDay)localObject1);
        }
      }
    }
    for (;;)
    {
      DebugLog.e(this.date + ">>>睡眠数据解析完成");
      clearData();
      return;
      k = 1;
      break;
      label469:
      m = 0;
      break label119;
      label475:
      byte[] arrayOfByte = (byte[])this.mDataHashMap.get(Integer.valueOf(n));
      int i2 = i;
      int i1 = j;
      if (arrayOfByte != null)
      {
        i2 = arrayOfByte.length;
        i1 = 0;
        if (i1 > i2 - 2)
        {
          i1 = j;
          i2 = i;
        }
      }
      else
      {
        n += 1;
        i = i2;
        j = i1;
        break label135;
      }
      localObject1 = new byte[2];
      ByteDataConvertUtil.BinnCat(arrayOfByte, (byte[])localObject1, i1, 2);
      int i3 = ByteDataConvertUtil.Byte2Int(localObject1[0]);
      int i4 = ByteDataConvertUtil.Byte2Int(localObject1[1]);
      if (j < m)
      {
        localObject1 = (SleepDataItem)localList.get(j);
        label593:
        DebugLog.d("i=" + i1 + ",sleepStatus:" + i3);
        ((SleepDataItem)localObject1).setDate(this.date);
        ((SleepDataItem)localObject1).setSleepStatus(i3);
        ((SleepDataItem)localObject1).setSleepMinutes(i4);
        if (k == 0) {
          break label712;
        }
        if (i == 0) {
          break label698;
        }
        localArrayList.add(localObject1);
      }
      for (;;)
      {
        j += 1;
        i1 += 2;
        break;
        if (m > 0) {
          i = 1;
        }
        localObject1 = new SleepDataItem();
        break label593;
        label698:
        localList.set(j, localObject1);
        continue;
        label712:
        localList.add(localObject1);
      }
      label725:
      localSleepDataItemDao.insertInTx(localList);
      break label181;
      label735:
      bool = false;
      break label243;
      label741:
      localObject1 = new SleepDataDay();
      break label261;
      label753:
      makeUpdateSleepStatisticalDatas(bool, this.date, this.totalSleepMinutes, this.deepSleepMinutes, this.lightSleepMinutes, 0L, 0L, 0L);
      break label325;
      label784:
      ((SleepDataDayDao)localObject2).insert(localObject1);
      break label421;
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
        break label173;
      }
      clearData();
      this.year = ByteDataConvertUtil.toRevInt(arrayOfByte, 0, 2);
      this.month = ByteDataConvertUtil.Byte2Int(arrayOfByte[2]);
      this.day = ByteDataConvertUtil.Byte2Int(arrayOfByte[3]);
      this.sleepEndedTimeH = ByteDataConvertUtil.Byte2Int(arrayOfByte[4]);
      this.sleepEndedTimeM = ByteDataConvertUtil.Byte2Int(arrayOfByte[5]);
      this.totalSleepMinutes = ByteDataConvertUtil.toRevInt(arrayOfByte, 6, 2);
      this.sleepItemCount = ByteDataConvertUtil.Byte2Int(arrayOfByte[8]);
      this.totalPacket = (ByteDataConvertUtil.Byte2Int(arrayOfByte[9]) + 3);
      this.date = (this.year * 10000 + this.month * 100 + this.day);
      this.receivedPacketCount = 1;
      this.headerWithoutData = checkHeaderWithoutData(paramArrayOfByte);
    }
    for (;;)
    {
      save(ByteDataConvertUtil.Byte2Int(getSerialNumber(paramArrayOfByte)), null);
      return;
      label173:
      if (getSerialNumber(paramArrayOfByte) == 2)
      {
        this.lightSleepCount = ByteDataConvertUtil.Byte2Int(arrayOfByte[0]);
        this.deepSleepCount = ByteDataConvertUtil.Byte2Int(arrayOfByte[1]);
        this.awakeCount = ByteDataConvertUtil.Byte2Int(arrayOfByte[2]);
        this.lightSleepMinutes = ByteDataConvertUtil.toRevInt(arrayOfByte, 3, 2);
        this.deepSleepMinutes = ByteDataConvertUtil.toRevInt(arrayOfByte, 5, 2);
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
    int j = paramArrayOfByte[3];
    if (!isHeader(paramArrayOfByte)) {
      save(paramArrayOfByte, i, 4, j);
    }
    if (this.receivedPacketCount > this.totalPacket) {
      this.receivedPacketCount = this.totalPacket;
    }
    return (int)(this.receivedPacketCount / this.totalPacket * 100.0F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\Sleep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */