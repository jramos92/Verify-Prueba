package com.project.library.database;

import com.project.library.util.DBTool;
import com.project.library.util.LongDateUtil;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.Iterator;
import java.util.List;

public class StatisticalDataFactory
{
  public static StatisticalData createData(long paramLong, int paramInt)
  {
    long l2 = 0L;
    long l1 = 0L;
    switch (paramInt)
    {
    default: 
      paramLong = l2;
    }
    for (;;)
    {
      return new StatisticalData(paramLong, l1, paramInt);
      paramLong = LongDateUtil.getFirstDayOfWeek(paramLong);
      l1 = LongDateUtil.add(paramLong, 6);
      continue;
      l1 = LongDateUtil.getFirstDayOfMonth(paramLong);
      l2 = LongDateUtil.add(l1, LongDateUtil.getMonthDay(LongDateUtil.getYear(paramLong), LongDateUtil.getMonth(paramLong)) - 1);
      paramLong = l1;
      l1 = l2;
      continue;
      l1 = LongDateUtil.getFirstDayOfYear(paramLong);
      l2 = LongDateUtil.getLongDate(LongDateUtil.getYear(paramLong), 12, 31);
      paramLong = l1;
      l1 = l2;
    }
  }
  
  public static StatisticalData getData(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = DBTool.getInstance().getDaoSession().getStatisticalDataDao().queryBuilder();
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.HealthType.eq(Integer.valueOf(paramInt2)), new WhereCondition[0]);
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.Type.eq(Integer.valueOf(paramInt1)), new WhereCondition[0]);
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.StopTime.ge(Long.valueOf(paramLong)), new WhereCondition[0]);
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.StartTime.le(Long.valueOf(paramLong)), new WhereCondition[0]);
    localObject = ((QueryBuilder)localObject).list();
    if (((List)localObject).isEmpty()) {
      return createData(paramLong, paramInt1);
    }
    return (StatisticalData)((List)localObject).get(0);
  }
  
  public static List<StatisticalData> getDatas()
  {
    return DBTool.getInstance().getDaoSession().getStatisticalDataDao().queryBuilder().list();
  }
  
  public static void update(boolean paramBoolean, long paramLong, int paramInt, List<StatisticalData> paramList)
  {
    StatisticalDataDao localStatisticalDataDao = DBTool.getInstance().getDaoSession().getStatisticalDataDao();
    Object localObject = localStatisticalDataDao.queryBuilder();
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.HealthType.eq(Integer.valueOf(paramInt)), new WhereCondition[0]);
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.StopTime.ge(Long.valueOf(paramLong)), new WhereCondition[0]);
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.StartTime.le(Long.valueOf(paramLong)), new WhereCondition[0]);
    ((QueryBuilder)localObject).orderAsc(new Property[] { StatisticalDataDao.Properties.Type });
    localObject = ((QueryBuilder)localObject).list();
    if (((List)localObject).isEmpty())
    {
      localObject = paramList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          localStatisticalDataDao.insertInTx(paramList);
          return;
        }
        ((StatisticalData)((Iterator)localObject).next()).setDayCount(1);
      }
    }
    int[] arrayOfInt = new int[3];
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= ((List)localObject).size())
      {
        paramInt = 0;
        while (paramInt < arrayOfInt.length)
        {
          if (arrayOfInt[paramInt] == 0) {
            localStatisticalDataDao.insert((StatisticalData)paramList.get(paramInt));
          }
          paramInt += 1;
        }
        break;
      }
      StatisticalData localStatisticalData = (StatisticalData)((List)localObject).get(paramInt);
      int i = localStatisticalData.getType();
      localStatisticalData.update(paramBoolean, (StatisticalData)paramList.get(i));
      localStatisticalDataDao.update(localStatisticalData);
      arrayOfInt[i] = 1;
      paramInt += 1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\StatisticalDataFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */