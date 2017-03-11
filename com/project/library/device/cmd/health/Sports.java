package com.project.library.device.cmd.health;

import com.project.library.database.DaoSession;
import com.project.library.database.HealthDataMax;
import com.project.library.database.HealthDataMaxDao;
import com.project.library.database.SportDataDay;
import com.project.library.database.SportDataDayDao;
import com.project.library.database.SportDataDayDao.Properties;
import com.project.library.database.SportDataItem;
import com.project.library.database.SportDataItemDao;
import com.project.library.database.SportDataItemDao.Properties;
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

public class Sports
  extends HealthDataCmd
{
  private static final int HEADER_LEN = 16;
  private static final int SPORT_ITEM_DATA_LEN = 5;
  private static final int TOTAL_HEADER_COUNT = 2;
  private static Sports mInstance = null;
  private long date = -1L;
  private int day = 10;
  private boolean headerWithoutData = false;
  private HashMap<Integer, byte[]> mDataHashMap = new HashMap();
  private int month = 6;
  private int receivedPacketCount = 0;
  private int sportItemCount = 0;
  private int startTime = 0;
  private int timeSpace = 15;
  private int totalActiveTime = 0;
  private int totalCalory = 0;
  private int totalDistance = 0;
  private int totalPacket = 0;
  private int totalStepCount = 0;
  private int year = 2015;
  
  private void clearData()
  {
    this.date = -1L;
    this.totalPacket = 0;
    this.receivedPacketCount = 0;
    this.mDataHashMap.clear();
  }
  
  public static Sports getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new Sports();
      }
      Sports localSports = mInstance;
      return localSports;
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
      if (paramInt3 <= 15)
      {
        i = paramInt3;
        if (paramInt3 != 0) {}
      }
      else
      {
        i = 15;
      }
      arrayOfByte = new byte[i];
      ByteDataConvertUtil.BinnCat(paramArrayOfByte, arrayOfByte, paramInt2, i);
      save(paramInt1, arrayOfByte);
    }
    while (paramArrayOfByte[1] != 238)
    {
      int i;
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
    byte[] arrayOfByte = createCmd((byte)3, (byte)2);
    UartLogUtil.recordWrite("发送结束同步当天运动", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncDetailsResend(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)3, new byte[] { 3, paramByte });
    UartLogUtil.recordWrite("当天数据漏包重发指令", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncDetailsStart()
  {
    byte[] arrayOfByte = createCmd((byte)3, (byte)1);
    UartLogUtil.recordWrite("发送开始同步当天运动  ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncHistoryDetailsEnd()
  {
    byte[] arrayOfByte = createCmd((byte)5, (byte)2);
    UartLogUtil.recordWrite("发送结束同步历史运动", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncHistoryDetailsResend(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)5, new byte[] { 3, paramByte });
    UartLogUtil.recordWrite("历史数据漏包重发指令", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSyncHistoryDetailsStart()
  {
    byte[] arrayOfByte = createCmd((byte)5, (byte)1);
    UartLogUtil.recordWrite("发送开始同步历史运动", arrayOfByte);
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
    Object localObject3;
    int m;
    int j;
    Object localObject1;
    List localList;
    int n;
    label157:
    int i1;
    label171:
    int k;
    ArrayList localArrayList;
    int i;
    int i2;
    label187:
    label234:
    boolean bool;
    if ((this.date > 0L) && (this.totalPacket > 2) && (!this.mDataHashMap.isEmpty()))
    {
      DebugLog.e("运动数据item总个数: " + this.sportItemCount);
      localObject2 = DBTool.getInstance().getDaoSession();
      localObject3 = ((DaoSession)localObject2).getSportDataItemDao();
      m = this.startTime;
      if (this.startTime > 0) {
        m = this.startTime / 60;
      }
      j = 0;
      localObject1 = ((SportDataItemDao)localObject3).queryBuilder();
      if (m > 0)
      {
        ((QueryBuilder)localObject1).where(SportDataItemDao.Properties.Date.ge(Long.valueOf(this.date)), new WhereCondition[] { SportDataItemDao.Properties.Hour.ge(Integer.valueOf(m)) });
        localList = ((QueryBuilder)localObject1).list();
        if (!localList.isEmpty()) {
          break label646;
        }
        n = 0;
        if (n == 0) {
          break label652;
        }
        i1 = localList.size();
        k = 0;
        localArrayList = new ArrayList();
        i = 0;
        i2 = 1;
        if (i2 <= this.totalPacket) {
          break label658;
        }
        if ((localList != null) && (!localList.isEmpty()))
        {
          if (n == 0) {
            break label1062;
          }
          ((SportDataItemDao)localObject3).updateInTx(localList);
          if (i != 0) {
            ((SportDataItemDao)localObject3).insertInTx(localArrayList);
          }
          localObject3 = ((DaoSession)localObject2).getSportDataDayDao();
          localObject1 = ((SportDataDayDao)localObject3).queryBuilder();
          ((QueryBuilder)localObject1).where(SportDataDayDao.Properties.Date.eq(Long.valueOf(this.date)), new WhereCondition[0]);
          localObject1 = ((QueryBuilder)localObject1).list();
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break label1072;
          }
          bool = true;
          label296:
          if (!bool) {
            break label1078;
          }
          localObject1 = (SportDataDay)((List)localObject1).get(0);
          label314:
          long l = LongDateUtil.Calendar2LongDate(Calendar.getInstance());
          if (this.date != l) {
            break label1090;
          }
          makeUpdateSportStatisticalDatas(bool, this.date, this.totalDistance - ((SportDataDay)localObject1).getTotalDistance(), this.totalStepCount - ((SportDataDay)localObject1).getTotalstepCount(), this.totalCalory - ((SportDataDay)localObject1).getTotalCalory());
          label375:
          ((SportDataDay)localObject1).setDate(Long.valueOf(this.date));
          ((SportDataDay)localObject1).setTotalstepCount(this.totalStepCount);
          ((SportDataDay)localObject1).setTotalCalory(this.totalCalory);
          ((SportDataDay)localObject1).setTotalDistance(this.totalDistance);
          ((SportDataDay)localObject1).setTotalActiveTime(this.totalActiveTime);
          if (!bool) {
            break label1118;
          }
          ((SportDataDayDao)localObject3).update(localObject1);
          label435:
          HealthDataDetailsCache.getInstance().updateHealthDataDay(this.date, (SportDataDay)localObject1);
          localObject2 = ((DaoSession)localObject2).getHealthDataMaxDao();
          localObject1 = ((HealthDataMaxDao)localObject2).queryBuilder().list();
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break label1129;
          }
          i = 1;
          label481:
          if (i == 0) {
            break label1134;
          }
          localObject1 = (HealthDataMax)((List)localObject1).get(0);
          label498:
          j = ((HealthDataMax)localObject1).getSportMaxStepCount();
          if (j <= this.totalStepCount) {
            break label1146;
          }
          label512:
          ((HealthDataMax)localObject1).setSportMaxStepCount(j);
          j = ((HealthDataMax)localObject1).getSportMaxCalory();
          if (j <= this.totalCalory) {
            break label1154;
          }
          label532:
          ((HealthDataMax)localObject1).setSportMaxCalory(j);
          j = ((HealthDataMax)localObject1).getSportMaxDistance();
          if (j <= this.totalDistance) {
            break label1162;
          }
          label552:
          ((HealthDataMax)localObject1).setSportMaxDistance(j);
          j = ((HealthDataMax)localObject1).getSportMaxActiveTime();
          if (j <= this.totalActiveTime) {
            break label1170;
          }
          label572:
          ((HealthDataMax)localObject1).setSportMaxActiveTime(j);
          if (i == 0) {
            break label1178;
          }
          ((HealthDataMaxDao)localObject2).update(localObject1);
        }
      }
    }
    for (;;)
    {
      DebugLog.e(this.date + ">>>运动数据解析完成");
      clearData();
      return;
      ((QueryBuilder)localObject1).where(SportDataItemDao.Properties.Date.eq(Long.valueOf(this.date)), new WhereCondition[0]);
      break;
      label646:
      n = 1;
      break label157;
      label652:
      i1 = 0;
      break label171;
      label658:
      byte[] arrayOfByte = (byte[])this.mDataHashMap.get(Integer.valueOf(i2));
      int i6 = i;
      int i5 = m;
      int i4 = j;
      int i3 = k;
      if (arrayOfByte != null)
      {
        i6 = arrayOfByte.length;
        i3 = 0;
        if (i3 > i6 - 5)
        {
          i3 = k;
          i4 = j;
          i5 = m;
          i6 = i;
        }
      }
      else
      {
        i2 += 1;
        i = i6;
        m = i5;
        j = i4;
        k = i3;
        break label187;
      }
      localObject1 = new byte[5];
      ByteDataConvertUtil.BinnCat(arrayOfByte, (byte[])localObject1, i3, 5);
      i4 = m;
      i5 = j;
      if (j >= 60)
      {
        i4 = m + 1;
        i5 = 0;
      }
      j = localObject1[0];
      m = localObject1[0];
      int i7 = localObject1[1];
      int i8 = localObject1[1];
      int i9 = localObject1[2];
      int i10 = localObject1[2];
      int i11 = localObject1[3];
      int i12 = localObject1[3];
      int i13 = localObject1[4];
      if (k < i1)
      {
        localObject1 = (SportDataItem)localList.get(k);
        label854:
        ((SportDataItem)localObject1).setDate(this.date);
        ((SportDataItem)localObject1).setHour(i4);
        ((SportDataItem)localObject1).setMinute(i5);
        ((SportDataItem)localObject1).setMode(j & 0x3);
        ((SportDataItem)localObject1).setStepCount(((m & 0xFC) >> 2) + ((i7 & 0x3F) << 6));
        ((SportDataItem)localObject1).setActiveTime(((i8 & 0xC0) >> 6) + ((i9 & 0x3) << 2));
        ((SportDataItem)localObject1).setCalory(((i10 & 0xFC) >> 2) + ((i11 & 0xF) << 6));
        ((SportDataItem)localObject1).setDistance(((i12 & 0xF0) >> 4) + ((i13 & 0xFF) << 4));
        if (n == 0) {
          break label1049;
        }
        if (i == 0) {
          break label1035;
        }
        localArrayList.add(localObject1);
      }
      for (;;)
      {
        j = i5 + this.timeSpace;
        k += 1;
        i3 += 5;
        m = i4;
        break;
        if (i1 > 0) {
          i = 1;
        }
        localObject1 = new SportDataItem();
        break label854;
        label1035:
        localList.set(k, localObject1);
        continue;
        label1049:
        localList.add(localObject1);
      }
      label1062:
      ((SportDataItemDao)localObject3).insertInTx(localList);
      break label234;
      label1072:
      bool = false;
      break label296;
      label1078:
      localObject1 = new SportDataDay();
      break label314;
      label1090:
      makeUpdateSportStatisticalDatas(bool, this.date, this.totalDistance, this.totalStepCount, this.totalCalory);
      break label375;
      label1118:
      ((SportDataDayDao)localObject3).insert(localObject1);
      break label435;
      label1129:
      i = 0;
      break label481;
      label1134:
      localObject1 = new HealthDataMax();
      break label498;
      label1146:
      j = this.totalStepCount;
      break label512;
      label1154:
      j = this.totalCalory;
      break label532;
      label1162:
      j = this.totalDistance;
      break label552;
      label1170:
      j = this.totalActiveTime;
      break label572;
      label1178:
      ((HealthDataMaxDao)localObject2).insert(localObject1);
      continue;
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
      this.timeSpace = ByteDataConvertUtil.Byte2Int(arrayOfByte[6]);
      this.sportItemCount = ByteDataConvertUtil.Byte2Int(arrayOfByte[7]);
      this.totalPacket = ByteDataConvertUtil.Byte2Int(arrayOfByte[8]);
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
        this.totalStepCount = ByteDataConvertUtil.toRevInt(arrayOfByte, 0, 4);
        this.totalCalory = ByteDataConvertUtil.toRevInt(arrayOfByte, 4, 4);
        this.totalDistance = ByteDataConvertUtil.toRevInt(arrayOfByte, 8, 4);
        this.totalActiveTime = ByteDataConvertUtil.toRevInt(arrayOfByte, 12, 4);
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\Sports.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */