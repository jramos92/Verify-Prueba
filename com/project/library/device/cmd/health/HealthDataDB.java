package com.project.library.device.cmd.health;

import com.project.library.database.DaoSession;
import com.project.library.database.SleepDataDay;
import com.project.library.database.SleepDataDayDao;
import com.project.library.database.SleepDataItem;
import com.project.library.database.SleepDataItemDao;
import com.project.library.database.SportDataDay;
import com.project.library.database.SportDataDayDao;
import com.project.library.database.SportDataItem;
import com.project.library.database.SportDataItemDao;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import java.util.ArrayList;
import java.util.List;

public class HealthDataDB
{
  private void addSleepDB(long paramLong)
  {
    Object localObject1 = DBTool.getInstance().getDaoSession();
    Object localObject2 = ((DaoSession)localObject1).getSleepDataItemDao();
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    for (;;)
    {
      if (i > 24)
      {
        ((SleepDataItemDao)localObject2).insertInTx(localArrayList);
        localObject1 = ((DaoSession)localObject1).getSleepDataDayDao();
        localObject2 = new SleepDataDay();
        ((SleepDataDay)localObject2).setDate(Long.valueOf(paramLong));
        ((SleepDataDay)localObject2).setEndTimeHour(1);
        ((SleepDataDay)localObject2).setEndTimeMinute(2);
        ((SleepDataDay)localObject2).setTotalSleepMinutes(3);
        ((SleepDataDay)localObject2).setLightSleepCount(4);
        ((SleepDataDay)localObject2).setDeepSleepCount(5);
        ((SleepDataDay)localObject2).setAwakeCount(6);
        ((SleepDataDay)localObject2).setLightSleepMinutes(7);
        ((SleepDataDay)localObject2).setDeepSleepMinutes(8);
        ((SleepDataDayDao)localObject1).insert(localObject2);
        return;
      }
      SleepDataItem localSleepDataItem = new SleepDataItem();
      localSleepDataItem.setDate(paramLong);
      localSleepDataItem.setSleepStatus(1);
      localSleepDataItem.setSleepMinutes(2);
      localArrayList.add(localSleepDataItem);
      i += 1;
    }
  }
  
  private void addSportDB(long paramLong)
  {
    Object localObject1 = DBTool.getInstance().getDaoSession();
    Object localObject2 = ((DaoSession)localObject1).getSportDataItemDao();
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int i = 0;
    int j = 1;
    for (;;)
    {
      if (j > 96)
      {
        ((SportDataItemDao)localObject2).insertInTx(localArrayList);
        localObject1 = ((DaoSession)localObject1).getSportDataDayDao();
        localObject2 = new SportDataDay();
        ((SportDataDay)localObject2).setDate(Long.valueOf(paramLong));
        ((SportDataDay)localObject2).setTotalstepCount(111);
        ((SportDataDay)localObject2).setTotalCalory(111);
        ((SportDataDay)localObject2).setTotalDistance(111);
        ((SportDataDay)localObject2).setTotalActiveTime(111);
        ((SportDataDayDao)localObject1).insert(localObject2);
        return;
      }
      int m = k;
      int n = i;
      if (i >= 60)
      {
        m = k + 1;
        n = 0;
      }
      SportDataItem localSportDataItem = new SportDataItem();
      localSportDataItem.setDate(paramLong);
      localSportDataItem.setHour(m);
      localSportDataItem.setMinute(n);
      localSportDataItem.setMode(1);
      localSportDataItem.setStepCount(11);
      localSportDataItem.setActiveTime(11);
      localSportDataItem.setCalory(11);
      localSportDataItem.setDistance(11);
      localArrayList.add(localSportDataItem);
      i = n + 15;
      j += 1;
      k = m;
    }
  }
  
  public void addHealthDBs()
  {
    int i = 0;
    for (;;)
    {
      if (i >= 366)
      {
        DebugLog.e("数据添加完成");
        return;
      }
      long l = LongDateUtil.sub(20150728L, i);
      addSportDB(l);
      addSleepDB(l);
      i += 1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\HealthDataDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */