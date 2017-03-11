package com.veryfit.multi.util;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.project.library.database.AlarmNotify;
import com.project.library.database.AlarmNotifyDao;
import com.project.library.database.AlarmNotifyDao.Properties;
import com.project.library.database.DaoSession;
import com.project.library.database.Goal;
import com.project.library.database.GoalDao;
import com.project.library.database.GoalDao.Properties;
import com.project.library.database.HealthDataMax;
import com.project.library.database.HealthDataMaxDao;
import com.project.library.database.HeartRate;
import com.project.library.database.HeartRateDao;
import com.project.library.database.HeartRateDao.Properties;
import com.project.library.database.HeartRateTreshold;
import com.project.library.database.HeartRateTresholdDao;
import com.project.library.database.HeartRateTresholdDao.Properties;
import com.project.library.database.SleepDataDay;
import com.project.library.database.SleepDataDayDao;
import com.project.library.database.SleepDataDayDao.Properties;
import com.project.library.database.SleepDataItem;
import com.project.library.database.SleepDataItemDao;
import com.project.library.database.SleepDataItemDao.Properties;
import com.project.library.database.SportDataDay;
import com.project.library.database.SportDataDayDao;
import com.project.library.database.SportDataDayDao.Properties;
import com.project.library.database.SportDataItem;
import com.project.library.database.SportDataItemDao;
import com.project.library.database.SportDataItemDao.Properties;
import com.project.library.database.StatisticalData;
import com.project.library.database.StatisticalDataDao;
import com.project.library.database.StatisticalDataDao.Properties;
import com.project.library.database.StatisticalDataFactory;
import com.project.library.device.cmd.health.HealthDataDetailsCache;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import com.veryfit.multi.model.BtHealthDataMax;
import com.veryfit.multi.model.BtHeartRate;
import com.veryfit.multi.model.BtHeartRateThreshold;
import com.veryfit.multi.model.BtSleepDataDay;
import com.veryfit.multi.model.BtSleepDataItem;
import com.veryfit.multi.model.BtSportDataDay;
import com.veryfit.multi.model.BtSportDataItem;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.view.DetailChart.PageData;
import com.veryfit.multi.view.DetailChart.PageData.LineData;
import com.veryfit.multi.view.DetailChart.PageData.LineData.PointModel;
import com.veryfit.multi.vo.SleepData;
import com.veryfit.multi.vo.SleepItem;
import com.veryfit.multi.vo.SportData;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class TempUtil
{
  private static Context context;
  private static long currDate = ;
  
  public static void clearDataAfterUnbind()
  {
    DBTool.getInstance().getDaoSession().getAlarmNotifyDao().deleteAll();
    AppSharedPreferences.getInstance().clearData();
    LibSharedPreferences.getInstance().setRealStep(0);
  }
  
  public static void clearLocalBtData()
  {
    long l1 = System.currentTimeMillis();
    DaoSession localDaoSession = DBTool.getInstance().getDaoSession();
    localDaoSession.getHealthDataMaxDao().deleteAll();
    localDaoSession.getSleepDataDayDao().deleteAll();
    localDaoSession.getSleepDataItemDao().deleteAll();
    localDaoSession.getSportDataDayDao().deleteAll();
    localDaoSession.getSportDataItemDao().deleteAll();
    localDaoSession.getHeartRateDao().deleteAll();
    localDaoSession.getHeartRateTresholdDao().deleteAll();
    localDaoSession.getStatisticalDataDao().deleteAll();
    long l2 = System.currentTimeMillis();
    DebugLog.e("清空本地所有手环数据执行时长：" + (l2 - l1));
  }
  
  public static List<AlarmNotify> getAlarms()
  {
    AlarmNotifyDao localAlarmNotifyDao = DBTool.getInstance().getDaoSession().getAlarmNotifyDao();
    Object localObject = localAlarmNotifyDao.queryBuilder();
    ((QueryBuilder)localObject).orderAsc(new Property[] { AlarmNotifyDao.Properties.AlarmId });
    localObject = ((QueryBuilder)localObject).list();
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return (List<AlarmNotify>)localObject;
      }
      localAlarmNotifyDao.refresh((AlarmNotify)localIterator.next());
    }
  }
  
  public static List<Integer> getDayTotalSteps(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = HealthDataDetailsCache.getInstance();
    HashMap localHashMap;
    long l2;
    if (localObject != null)
    {
      localHashMap = ((HealthDataDetailsCache)localObject).getSportMap();
      l2 = ((HealthDataDetailsCache)localObject).getMinDate();
    }
    for (long l1 = LongDateUtil.Calendar2LongDate(Calendar.getInstance());; l1 = LongDateUtil.sub(l1, 1))
    {
      if (l1 < l2) {
        return localLinkedList;
      }
      localObject = Integer.valueOf(0);
      if (localHashMap.containsKey(Long.valueOf(l1))) {
        localObject = Integer.valueOf(((SportDataDay)localHashMap.get(Long.valueOf(l1))).getTotalstepCount());
      }
      localLinkedList.add(localObject);
    }
  }
  
  public static DetailChart.PageData getDetailChartPageData(int paramInt1, int paramInt2, int paramInt3)
  {
    DetailChart.PageData localPageData = new DetailChart.PageData();
    long l;
    switch (paramInt1)
    {
    default: 
      l = LongDateUtil.getFirstDayOfWeek(paramInt3);
      localPageData.goal = getGoal(LongDateUtil.add(l, 6))[paramInt2];
    }
    StatisticalData localStatisticalData;
    Resources localResources;
    int j;
    int i;
    for (;;)
    {
      localStatisticalData = StatisticalDataFactory.getData(paramInt1, paramInt2, l);
      localResources = context.getResources();
      localPageData.goalString = getGoalString(localResources, localPageData.goal, paramInt2);
      localPageData.tittle = localStatisticalData.getTitleString();
      j = AppSharedPreferences.getInstance().getUnitType();
      localPageData.dataShow0 = localStatisticalData.getPageType(paramInt2);
      localPageData.lines = new DetailChart.PageData.LineData[paramInt2 + 1];
      i = 0;
      if (i < localPageData.lines.length) {
        break;
      }
      return localPageData;
      l = LongDateUtil.getFirstDayOfWeek(paramInt3);
      localPageData.goal = getGoal(LongDateUtil.add(l, 6))[paramInt2];
      continue;
      l = LongDateUtil.getFirstDayOfMonth(paramInt3);
      localPageData.goal = getGoal(LongDateUtil.add(l, LongDateUtil.getMonthDay(LongDateUtil.getYear(l), LongDateUtil.getMonth(l)) - 1))[paramInt2];
      continue;
      l = LongDateUtil.getFirstDayOfYear(paramInt3);
      localPageData.goal = 0;
    }
    DebugLog.d("i=" + i + "  lines.length=" + localPageData.lines.length + " ");
    DetailChart.PageData.LineData localLineData = new DetailChart.PageData.LineData();
    switch (paramInt2)
    {
    }
    for (;;)
    {
      localPageData.lines[i] = localLineData;
      i += 1;
      break;
      if (i == 0)
      {
        localLineData.color = localResources.getColor(2131099670);
        localLineData.name = localResources.getString(2131296589);
      }
      for (;;)
      {
        localPageData.dataShow0 = getSleepPageShowData(localStatisticalData);
        localLineData.datas = getSleepPoints(paramInt1, i, paramInt3);
        break;
        if (i == 1)
        {
          localLineData.color = localResources.getColor(2131099669);
          localLineData.name = localResources.getString(2131296590);
        }
      }
      localPageData.dataShow0 = getSportPageShowData(localStatisticalData, j);
      localLineData.datas = getSportPoints(paramInt1, paramInt3);
      localLineData.color = localResources.getColor(2131099671);
    }
  }
  
  public static int[] getGoal(long paramLong)
  {
    Object localObject = DBTool.getInstance().getDaoSession().getGoalDao().queryBuilder();
    ((QueryBuilder)localObject).where(GoalDao.Properties.Date.le(Long.valueOf(paramLong)), new WhereCondition[0]);
    ((QueryBuilder)localObject).orderDesc(new Property[] { GoalDao.Properties.Date, GoalDao.Properties.Type });
    localObject = ((QueryBuilder)localObject).list();
    if (((List)localObject).isEmpty()) {
      return new int[] { 10000, 480 };
    }
    return new int[] { ((Goal)((List)localObject).get(1)).getGoal(), ((Goal)((List)localObject).get(0)).getGoal() };
  }
  
  public static List<Goal> getGoalData(long paramLong)
  {
    QueryBuilder localQueryBuilder = DBTool.getInstance().getDaoSession().getGoalDao().queryBuilder();
    localQueryBuilder.where(GoalDao.Properties.Date.le(Long.valueOf(paramLong)), new WhereCondition[0]);
    localQueryBuilder.orderDesc(new Property[] { GoalDao.Properties.Date, GoalDao.Properties.Type });
    return localQueryBuilder.list();
  }
  
  public static String getGoalString(Resources paramResources, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramInt1 + " " + paramResources.getString(2131296411);
    }
    return paramInt1 / 60 + paramResources.getString(2131296416) + paramInt1 % 60 + paramResources.getString(2131296417);
  }
  
  public static List<BtHealthDataMax> getHealthDataMaxList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = DBTool.getInstance().getDaoSession().getHealthDataMaxDao().loadAll().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      HealthDataMax localHealthDataMax = (HealthDataMax)localIterator.next();
      BtHealthDataMax localBtHealthDataMax = new BtHealthDataMax();
      localBtHealthDataMax.setSportMaxStepCount(localHealthDataMax.getSportMaxStepCount());
      localBtHealthDataMax.setSportMaxCalory(localHealthDataMax.getSportMaxCalory());
      localBtHealthDataMax.setSportMaxDistance(localHealthDataMax.getSportMaxDistance());
      localBtHealthDataMax.setSportMaxActiveTime(localHealthDataMax.getSportMaxActiveTime());
      localArrayList.add(localBtHealthDataMax);
    }
  }
  
  private static int getHealthMaxSize(int paramInt1, int paramInt2)
  {
    Object localObject = DBTool.getInstance().getDaoSession().getStatisticalDataDao().queryBuilder();
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.HealthType.eq(Integer.valueOf(paramInt1)), new WhereCondition[0]);
    ((QueryBuilder)localObject).where(StatisticalDataDao.Properties.Type.eq(Integer.valueOf(paramInt2)), new WhereCondition[0]);
    ((QueryBuilder)localObject).orderDesc(new Property[] { StatisticalDataDao.Properties.StopTime });
    localObject = ((QueryBuilder)localObject).list();
    paramInt1 = 1;
    long l1;
    long l2;
    if (!((List)localObject).isEmpty())
    {
      l1 = ((StatisticalData)((List)localObject).get(((List)localObject).size() - 1)).getStopTime();
      l2 = ((StatisticalData)((List)localObject).get(0)).getStopTime();
    }
    switch (paramInt2)
    {
    default: 
      paramInt1 = LongDateUtil.getWeeksBetweenDates(l1, l2);
      return paramInt1;
    case 1: 
      return LongDateUtil.getMonthsBetweenDates(l1, l2);
    }
    return LongDateUtil.getYearsBetweenDates(l1, l2);
  }
  
  public static List<HeartRate> getHeartRate(long paramLong)
  {
    HeartRateDao localHeartRateDao = DBTool.getInstance().getDaoSession().getHeartRateDao();
    Object localObject = localHeartRateDao.queryBuilder();
    ((QueryBuilder)localObject).where(HeartRateDao.Properties.Date.eq(Long.valueOf(paramLong)), new WhereCondition[] { HeartRateDao.Properties.Rate.gt(Integer.valueOf(30)) });
    ((QueryBuilder)localObject).orderAsc(new Property[] { HeartRateDao.Properties.Minute });
    localObject = ((QueryBuilder)localObject).list();
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return (List<HeartRate>)localObject;
      }
      localHeartRateDao.refresh((HeartRate)localIterator.next());
    }
  }
  
  public static List<BtHeartRate> getHeartRateList(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = DBTool.getInstance().getDaoSession().getHeartRateDao().loadAll().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      HeartRate localHeartRate = (HeartRate)localIterator.next();
      long l = localHeartRate.getDate();
      if (((paramLong <= l) && (l <= currDate)) || ((currDate <= l) && (l <= paramLong)))
      {
        BtHeartRate localBtHeartRate = new BtHeartRate();
        localBtHeartRate.setDate(Long.valueOf(l));
        localBtHeartRate.setMinute(localHeartRate.getMinute());
        localBtHeartRate.setRate(localHeartRate.getRate());
        localArrayList.add(localBtHeartRate);
      }
    }
  }
  
  public static List<BtHeartRateThreshold> getHeartRateThresholdList(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = DBTool.getInstance().getDaoSession().getHeartRateTresholdDao().loadAll().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      HeartRateTreshold localHeartRateTreshold = (HeartRateTreshold)localIterator.next();
      long l = localHeartRateTreshold.getDate();
      if (((paramLong <= l) && (l <= currDate)) || ((currDate <= l) && (l <= paramLong)))
      {
        BtHeartRateThreshold localBtHeartRateThreshold = new BtHeartRateThreshold();
        localBtHeartRateThreshold.setDate(Long.valueOf(l));
        localBtHeartRateThreshold.setMinThreshold(localHeartRateTreshold.getMinThreshold());
        localBtHeartRateThreshold.setMaxThreshold(localHeartRateTreshold.getMaxThreshold());
        localBtHeartRateThreshold.setBurnFatThreshold(localHeartRateTreshold.getBurnFatThreshold());
        localBtHeartRateThreshold.setBurnFatMins(localHeartRateTreshold.getBurnFatMins());
        localBtHeartRateThreshold.setAerobicThreshold(localHeartRateTreshold.getAerobicThreshold());
        localBtHeartRateThreshold.setAerobicMins(localHeartRateTreshold.getAerobicMins());
        localBtHeartRateThreshold.setLimitThreshold(localHeartRateTreshold.getLimitThreshold());
        localBtHeartRateThreshold.setLimitMins(localHeartRateTreshold.getLimitMins());
        localBtHeartRateThreshold.setSilentHeartRate(localHeartRateTreshold.getSilentHeartRate());
        localArrayList.add(localBtHeartRateThreshold);
      }
    }
  }
  
  public static HeartRateTreshold getHeartRateTreshold(long paramLong)
  {
    HeartRateTreshold localHeartRateTreshold = null;
    HeartRateTresholdDao localHeartRateTresholdDao = DBTool.getInstance().getDaoSession().getHeartRateTresholdDao();
    Object localObject = localHeartRateTresholdDao.queryBuilder();
    ((QueryBuilder)localObject).where(HeartRateTresholdDao.Properties.Date.eq(Long.valueOf(paramLong)), new WhereCondition[0]);
    localObject = ((QueryBuilder)localObject).list();
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (((List)localObject).size() != 0) {
          localHeartRateTreshold = (HeartRateTreshold)((List)localObject).get(0);
        }
        return localHeartRateTreshold;
      }
      localHeartRateTresholdDao.refresh((HeartRateTreshold)localIterator.next());
    }
  }
  
  public static List<Integer> getId(int paramInt, float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = DBTool.getInstance().getDaoSession().getSportDataItemDao().queryBuilder();
    ((QueryBuilder)localObject).where(SportDataItemDao.Properties.StepCount.eq(Integer.valueOf(paramInt)), new WhereCondition[0]);
    ((QueryBuilder)localObject).where(SportDataItemDao.Properties.Distance.eq(Float.valueOf(paramFloat1)), new WhereCondition[0]);
    ((QueryBuilder)localObject).where(SportDataItemDao.Properties.Calory.eq(Float.valueOf(paramFloat2)), new WhereCondition[0]);
    localObject = ((QueryBuilder)localObject).list();
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= ((List)localObject).size()) {
        return localArrayList;
      }
      localArrayList.add(Integer.valueOf((int)((SportDataItem)((List)localObject).get(paramInt)).getId().longValue()));
      paramInt += 1;
    }
  }
  
  public static List<HeartRate> getMaxHeartRate(long paramLong)
  {
    HeartRateDao localHeartRateDao = DBTool.getInstance().getDaoSession().getHeartRateDao();
    Object localObject = localHeartRateDao.queryBuilder();
    ((QueryBuilder)localObject).where(HeartRateDao.Properties.Date.eq(Long.valueOf(paramLong)), new WhereCondition[] { HeartRateDao.Properties.Rate.gt(Integer.valueOf(30)) });
    ((QueryBuilder)localObject).orderDesc(new Property[] { HeartRateDao.Properties.Rate });
    localObject = ((QueryBuilder)localObject).list();
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return (List<HeartRate>)localObject;
      }
      localHeartRateDao.refresh((HeartRate)localIterator.next());
    }
  }
  
  public static CopyOnWriteArrayList<DetailChart.PageData> getPageDatas(int paramInt1, int paramInt2, int paramInt3)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    localCopyOnWriteArrayList.add(getDetailChartPageData(paramInt1, paramInt2, paramInt3));
    return localCopyOnWriteArrayList;
  }
  
  public static CopyOnWriteArrayList<DetailChart.PageData> getPageLeftDatas(int paramInt1, int paramInt2, int paramInt3)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i = getHealthMaxSize(paramInt2, paramInt1);
    paramInt3 += 1;
    for (;;)
    {
      if (paramInt3 >= i) {
        return localCopyOnWriteArrayList;
      }
      localCopyOnWriteArrayList.add(getDetailChartPageData(paramInt1, paramInt2, paramInt3));
      paramInt3 += 1;
    }
  }
  
  public static CopyOnWriteArrayList<DetailChart.PageData> getPageMoreDatas(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramInt4 = Math.min(paramInt4 + 1, getHealthMaxSize(paramInt2, paramInt1) - paramInt4 * paramInt3);
    paramInt3 = 1;
    for (;;)
    {
      if (paramInt3 >= paramInt4) {
        return localCopyOnWriteArrayList;
      }
      localCopyOnWriteArrayList.add(getDetailChartPageData(paramInt1, paramInt2, paramInt3));
      paramInt3 += 1;
    }
  }
  
  public static SleepData getSleepByDate(Calendar paramCalendar, int paramInt)
  {
    SleepData localSleepData = new SleepData();
    long l = LongDateUtil.sub(LongDateUtil.Calendar2LongDate(paramCalendar), paramInt);
    localSleepData.date = LongDateUtil.LongDate2Calendar(l);
    paramCalendar = DBTool.getInstance().getDaoSession();
    Object localObject = paramCalendar.getSleepDataDayDao().queryBuilder();
    ((QueryBuilder)localObject).where(SleepDataDayDao.Properties.Date.eq(Long.valueOf(l)), new WhereCondition[0]);
    localObject = ((QueryBuilder)localObject).list();
    if (((List)localObject).isEmpty())
    {
      localSleepData.endTime = new int[2];
      paramCalendar = new ArrayList();
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= 5)
        {
          localSleepData.setItems(paramCalendar);
          return localSleepData;
        }
        paramCalendar.add(new SleepItem());
        paramInt += 1;
      }
    }
    localObject = (SleepDataDay)((List)localObject).get(0);
    localSleepData.endTime = new int[] { ((SleepDataDay)localObject).getEndTimeHour(), ((SleepDataDay)localObject).getEndTimeMinute() };
    localSleepData.durationMins = ((SleepDataDay)localObject).getTotalSleepMinutes();
    localSleepData.deepTotal = ((SleepDataDay)localObject).getDeepSleepMinutes();
    localSleepData.lightTotal = ((SleepDataDay)localObject).getLightSleepMinutes();
    localSleepData.awakeTotal = (localSleepData.durationMins - localSleepData.deepTotal - localSleepData.lightTotal);
    localObject = paramCalendar.getSleepDataItemDao().queryBuilder().where(SleepDataItemDao.Properties.Date.eq(Long.valueOf(l)), new WhereCondition[0]).list();
    paramCalendar = new ArrayList();
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        localSleepData.setItems(paramCalendar);
        return localSleepData;
      }
      SleepDataItem localSleepDataItem = (SleepDataItem)((Iterator)localObject).next();
      paramCalendar.add(new SleepItem(localSleepDataItem.getSleepStatus() - 1, localSleepDataItem.getSleepMinutes()));
    }
  }
  
  public static List<BtSleepDataDay> getSleepDataDayList(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = DBTool.getInstance().getDaoSession().getSleepDataDayDao().loadAll().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      SleepDataDay localSleepDataDay = (SleepDataDay)localIterator.next();
      long l = localSleepDataDay.getDate().longValue();
      if (((paramLong <= l) && (l <= currDate)) || ((currDate <= l) && (l <= paramLong)))
      {
        BtSleepDataDay localBtSleepDataDay = new BtSleepDataDay();
        localBtSleepDataDay.setDate(Long.valueOf(l));
        localBtSleepDataDay.setEndTimeHour(localSleepDataDay.getEndTimeHour());
        localBtSleepDataDay.setEndTimeMinute(localSleepDataDay.getEndTimeMinute());
        localBtSleepDataDay.setTotalSleepMinutes(localSleepDataDay.getTotalSleepMinutes());
        localBtSleepDataDay.setDeepSleepMinutes(localSleepDataDay.getDeepSleepMinutes());
        localBtSleepDataDay.setDeepSleepCount(localSleepDataDay.getDeepSleepCount());
        localBtSleepDataDay.setLightSleepMinutes(localSleepDataDay.getLightSleepMinutes());
        localBtSleepDataDay.setLightSleepCount(localSleepDataDay.getLightSleepCount());
        localBtSleepDataDay.setAwakeCount(localSleepDataDay.getAwakeCount());
        localArrayList.add(localBtSleepDataDay);
      }
    }
  }
  
  public static List<BtSleepDataItem> getSleepDataItemList(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = DBTool.getInstance().getDaoSession().getSleepDataItemDao().loadAll().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      SleepDataItem localSleepDataItem = (SleepDataItem)localIterator.next();
      long l = localSleepDataItem.getDate();
      if (((paramLong <= l) && (l <= currDate)) || ((currDate <= l) && (l <= paramLong)))
      {
        BtSleepDataItem localBtSleepDataItem = new BtSleepDataItem();
        localBtSleepDataItem.setDate(Long.valueOf(l));
        localBtSleepDataItem.setSleepMinutes(localSleepDataItem.getSleepMinutes());
        localBtSleepDataItem.setSleepStatus(localSleepDataItem.getSleepStatus());
        localArrayList.add(localBtSleepDataItem);
      }
    }
  }
  
  private static String[] getSleepPageShowData(StatisticalData paramStatisticalData)
  {
    long l6 = paramStatisticalData.getStartTime();
    long l7 = paramStatisticalData.getStopTime();
    int i = 0;
    long l5 = 0L;
    long l4 = 0L;
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    long l11 = 0L;
    Object localObject2 = DBTool.getInstance().getDaoSession().getSleepDataDayDao();
    paramStatisticalData = ((SleepDataDayDao)localObject2).getDatabase().rawQuery("select count() , sum(TOTAL_SLEEP_MINUTES) , sum(DEEP_SLEEP_MINUTES) , sum(LIGHT_SLEEP_MINUTES),sum((END_TIME_HOUR + 24) * 60 + END_TIME_MINUTE) , sum(TOTAL_SLEEP_MINUTES - DEEP_SLEEP_MINUTES - LIGHT_SLEEP_MINUTES) from SLEEP_DATA_DAY where DATE >= ? and DATE <= ? and END_TIME_HOUR < 12", new String[] { l6, l7 });
    Object localObject1 = ((SleepDataDayDao)localObject2).getDatabase().rawQuery("select count() , sum(TOTAL_SLEEP_MINUTES) , sum(DEEP_SLEEP_MINUTES) , sum(LIGHT_SLEEP_MINUTES),sum(END_TIME_HOUR * 60 + END_TIME_MINUTE) , sum(TOTAL_SLEEP_MINUTES - DEEP_SLEEP_MINUTES - LIGHT_SLEEP_MINUTES) from SLEEP_DATA_DAY where DATE >= ? and DATE <= ? and END_TIME_HOUR >= 12", new String[] { l6, l7 });
    localObject2 = ((SleepDataDayDao)localObject2).getDatabase().rawQuery("select sum(END_TIME_HOUR * 60 + END_TIME_MINUTE - TOTAL_SLEEP_MINUTES + 1440) from SLEEP_DATA_DAY where DATE >= ? and DATE <= ? ", new String[] { l6, l7 });
    if (paramStatisticalData.moveToNext())
    {
      i = paramStatisticalData.getInt(0);
      l5 = paramStatisticalData.getLong(1);
      l4 = paramStatisticalData.getLong(2);
      l3 = paramStatisticalData.getLong(3);
      l2 = paramStatisticalData.getLong(4);
      l1 = paramStatisticalData.getLong(5);
    }
    if (!paramStatisticalData.isClosed()) {
      paramStatisticalData.close();
    }
    int j = i;
    long l10 = l1;
    long l9 = l2;
    long l8 = l4;
    l7 = l3;
    l6 = l5;
    if (((Cursor)localObject1).moveToFirst())
    {
      j = i + ((Cursor)localObject1).getInt(0);
      l6 = l5 + ((Cursor)localObject1).getLong(1);
      l8 = l4 + ((Cursor)localObject1).getLong(2);
      l7 = l3 + ((Cursor)localObject1).getLong(3);
      l9 = l2 + ((Cursor)localObject1).getLong(4);
      l10 = l1 + ((Cursor)localObject1).getLong(5);
    }
    if (!((Cursor)localObject1).isClosed()) {
      ((Cursor)localObject1).close();
    }
    l1 = l11;
    if (((Cursor)localObject2).moveToFirst()) {
      l1 = 0L + ((Cursor)localObject2).getLong(0);
    }
    if (!((Cursor)localObject2).isClosed()) {
      ((Cursor)localObject2).close();
    }
    int n = Math.round((float)l6 * 1.0F / j);
    int i1 = Math.round((float)l8 * 1.0F / j);
    int i2 = Math.round((float)l7 * 1.0F / j);
    int m = (int)Math.round(l1 * 1.0D / j);
    int k = Math.round((float)l9 * 1.0F / j);
    int i3 = Math.round((float)l10 * 1.0F / j);
    if (m < 0)
    {
      i = m + 1440;
      if (k >= 0) {
        break label860;
      }
      j = k + 1440;
    }
    for (;;)
    {
      paramStatisticalData = context.getString(2131296416);
      localObject1 = context.getString(2131296417);
      boolean bool = AppSharedPreferences.getInstance().is24TimeMode();
      return new String[] { String.format("%d" + paramStatisticalData + "%d" + (String)localObject1, new Object[] { Integer.valueOf(n / 60), Integer.valueOf(n % 60) }), String.format("%d" + paramStatisticalData + "%d" + (String)localObject1, new Object[] { Integer.valueOf(i1 / 60), Integer.valueOf(i1 % 60) }), String.format("%d" + paramStatisticalData + "%d" + (String)localObject1, new Object[] { Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60) }), Util.timeFormatter(i, bool), Util.timeFormatter(j, bool), String.format("%d" + paramStatisticalData + "%d" + (String)localObject1, new Object[] { Integer.valueOf(i3 / 60), Integer.valueOf(i3 % 60) }) };
      i = m;
      if (m <= 1440) {
        break;
      }
      i = m - 1440;
      break;
      label860:
      j = k;
      if (k > 1440) {
        j = k - 1440;
      }
    }
  }
  
  public static ArrayList<DetailChart.PageData.LineData.PointModel> getSleepPoints(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 0: 
      return getSleepWeeksMonthsData(paramInt1, paramInt2, LongDateUtil.getFirstDayOfWeek(paramInt3), 7);
    case 1: 
      long l = LongDateUtil.getFirstDayOfMonth(paramInt3);
      return getSleepWeeksMonthsData(paramInt1, paramInt2, l, LongDateUtil.getMonthDay(LongDateUtil.getYear(l), LongDateUtil.getMonth(l)));
    }
    return getSleepYearData(paramInt2, paramInt3);
  }
  
  private static ArrayList<DetailChart.PageData.LineData.PointModel> getSleepWeeksMonthsData(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    String[] arrayOfString = context.getResources().getStringArray(2131361794);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = HealthDataDetailsCache.getInstance().getSleepMap();
    Resources localResources = context.getResources();
    int j = 0;
    if (j >= paramInt3) {
      return localArrayList;
    }
    DetailChart.PageData.LineData.PointModel localPointModel = new DetailChart.PageData.LineData.PointModel();
    SleepDataDay localSleepDataDay = (SleepDataDay)localHashMap.get(Long.valueOf(paramLong));
    int i;
    if (localSleepDataDay == null)
    {
      i = 0;
      label83:
      localPointModel.data = i;
      if (paramInt1 != 1) {
        break label287;
      }
      if (((j % 4 != 0) || (j > 25)) && (j != paramInt3 - 1)) {
        break label276;
      }
      localPointModel.dataName = (j + 1);
      label140:
      if (localSleepDataDay != null) {
        break label330;
      }
    }
    label276:
    label287:
    label330:
    for (localPointModel.dataLabel = new String[] { localResources.getString(2131296591, new Object[] { getGoalString(localResources, 0, 1) }), localResources.getString(2131296592, new Object[] { getGoalString(localResources, 0, 1) }), localResources.getString(2131296593, new Object[] { getGoalString(localResources, 0, 1) }) };; localPointModel.dataLabel = new String[] { localResources.getString(2131296591, new Object[] { getGoalString(localResources, localSleepDataDay.getTotalSleepMinutes(), 1) }), localResources.getString(2131296592, new Object[] { getGoalString(localResources, localSleepDataDay.getDeepSleepMinutes(), 1) }), localResources.getString(2131296593, new Object[] { getGoalString(localResources, localSleepDataDay.getLightSleepMinutes(), 1) }) })
    {
      localArrayList.add(localPointModel);
      paramLong = LongDateUtil.add(paramLong, 1);
      j += 1;
      break;
      if (paramInt2 == 0)
      {
        i = localSleepDataDay.getTotalSleepMinutes();
        break label83;
      }
      i = localSleepDataDay.getDeepSleepMinutes();
      break label83;
      localPointModel.dataName = "";
      break label140;
      if (paramInt1 == 0) {}
      for (String str = arrayOfString[j];; str = j + 1)
      {
        localPointModel.dataName = str;
        break;
      }
    }
  }
  
  private static ArrayList<DetailChart.PageData.LineData.PointModel> getSleepYearData(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    DetailChart.PageData.LineData.PointModel[] arrayOfPointModel = new DetailChart.PageData.LineData.PointModel[12];
    Resources localResources = context.getResources();
    HashMap localHashMap = HealthDataDetailsCache.getInstance().getSleepMap();
    Object localObject = localHashMap.keySet();
    int[] arrayOfInt1 = new int[12];
    int[] arrayOfInt2 = new int[12];
    int[] arrayOfInt3 = new int[12];
    int j = Calendar.getInstance().get(1);
    localObject = ((Set)localObject).iterator();
    if (!((Iterator)localObject).hasNext()) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 > 12)
      {
        return localArrayList;
        Long localLong = (Long)((Iterator)localObject).next();
        if (j - paramInt2 != LongDateUtil.getYear(localLong.longValue())) {
          break;
        }
        int k = LongDateUtil.getMonth(localLong.longValue());
        if (arrayOfPointModel[(k - 1)] == null)
        {
          arrayOfPointModel[(k - 1)] = new DetailChart.PageData.LineData.PointModel();
          arrayOfInt1[(k - 1)] = 0;
          arrayOfInt2[(k - 1)] = 0;
          arrayOfInt3[(k - 1)] = 0;
        }
        DetailChart.PageData.LineData.PointModel localPointModel = arrayOfPointModel[(k - 1)];
        int m = localPointModel.data;
        if (paramInt1 == 0) {}
        for (int i = ((SleepDataDay)localHashMap.get(localLong)).getTotalSleepMinutes();; i = ((SleepDataDay)localHashMap.get(localLong)).getDeepSleepMinutes())
        {
          localPointModel.data = (i + m);
          i = k - 1;
          m = arrayOfInt1[i];
          arrayOfInt1[i] = (((SleepDataDay)localHashMap.get(localLong)).getTotalSleepMinutes() + m);
          i = k - 1;
          m = arrayOfInt2[i];
          arrayOfInt2[i] = (((SleepDataDay)localHashMap.get(localLong)).getDeepSleepMinutes() + m);
          i = k - 1;
          k = arrayOfInt3[i];
          arrayOfInt3[i] = (((SleepDataDay)localHashMap.get(localLong)).getLightSleepMinutes() + k);
          break;
        }
      }
      if (arrayOfPointModel[(paramInt1 - 1)] == null)
      {
        arrayOfPointModel[(paramInt1 - 1)] = new DetailChart.PageData.LineData.PointModel();
        arrayOfPointModel[(paramInt1 - 1)].dataLabel = new String[] { localResources.getString(2131296591, new Object[] { getGoalString(localResources, 0, 1) }), localResources.getString(2131296592, new Object[] { getGoalString(localResources, 0, 1) }), localResources.getString(2131296593, new Object[] { getGoalString(localResources, 0, 1) }) };
      }
      arrayOfPointModel[(paramInt1 - 1)].dataLabel = new String[] { localResources.getString(2131296591, new Object[] { getGoalString(localResources, arrayOfInt1[(paramInt1 - 1)], 1) }), localResources.getString(2131296592, new Object[] { getGoalString(localResources, arrayOfInt2[(paramInt1 - 1)], 1) }), localResources.getString(2131296593, new Object[] { getGoalString(localResources, arrayOfInt3[(paramInt1 - 1)], 1) }) };
      arrayOfPointModel[(paramInt1 - 1)].dataName = String.format("%02d", new Object[] { Integer.valueOf(paramInt1) });
      localArrayList.add(arrayOfPointModel[(paramInt1 - 1)]);
      paramInt1 += 1;
    }
  }
  
  public static List<BtSportDataDay> getSportDataDayList(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = DBTool.getInstance().getDaoSession().getSportDataDayDao().loadAll().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      SportDataDay localSportDataDay = (SportDataDay)localIterator.next();
      long l = localSportDataDay.getDate().longValue();
      if (((paramLong <= l) && (l <= currDate)) || ((currDate <= l) && (l <= paramLong)))
      {
        BtSportDataDay localBtSportDataDay = new BtSportDataDay();
        localBtSportDataDay.setDate(Long.valueOf(l));
        localBtSportDataDay.setTotalCalory(localSportDataDay.getTotalCalory());
        localBtSportDataDay.setTotalDistance(localSportDataDay.getTotalDistance());
        localBtSportDataDay.setTotalstepCount(localSportDataDay.getTotalstepCount());
        localBtSportDataDay.setTotalActiveTime(localSportDataDay.getTotalActiveTime());
        localArrayList.add(localBtSportDataDay);
      }
    }
  }
  
  public static List<BtSportDataItem> getSportDataItemList(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = DBTool.getInstance().getDaoSession().getSportDataItemDao().loadAll().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      SportDataItem localSportDataItem = (SportDataItem)localIterator.next();
      long l = localSportDataItem.getDate();
      if (((paramLong <= l) && (l <= currDate)) || ((currDate <= l) && (l <= paramLong)))
      {
        BtSportDataItem localBtSportDataItem = new BtSportDataItem();
        localBtSportDataItem.setDate(l);
        localBtSportDataItem.setHour(localSportDataItem.getHour());
        localBtSportDataItem.setMinute(localSportDataItem.getMinute());
        localBtSportDataItem.setMode(localSportDataItem.getMode());
        localBtSportDataItem.setDistance(localSportDataItem.getDistance());
        localBtSportDataItem.setStepCount(localSportDataItem.getStepCount());
        localBtSportDataItem.setCalory(localSportDataItem.getCalory());
        localBtSportDataItem.setActiveTime(localSportDataItem.getActiveTime());
        localArrayList.add(localBtSportDataItem);
      }
    }
  }
  
  private static String[] getSportPageShowData(StatisticalData paramStatisticalData, int paramInt)
  {
    long l1 = paramStatisticalData.getStartTime();
    long l2 = paramStatisticalData.getStopTime();
    Object localObject = DBTool.getInstance().getDaoSession().getSportDataDayDao().getDatabase().rawQuery("select count() , sum(TOTAL_DISTANCE) , sum(TOTALSTEP_COUNT) , sum(TOTAL_CALORY) from SPORT_DATA_DAY where DATE >= ? and DATE <= ?", new String[] { l1, l2 });
    float f5;
    int i;
    String str1;
    String str2;
    if (!((Cursor)localObject).moveToNext())
    {
      if (!((Cursor)localObject).isClosed()) {
        ((Cursor)localObject).close();
      }
      f2 = paramStatisticalData.getTotalDistance() / 1000.0F;
      l1 = paramStatisticalData.getTotalStep();
      f5 = (float)paramStatisticalData.getTotalCalory();
      i = paramStatisticalData.getDayCount();
      localObject = context.getResources();
      paramStatisticalData = "";
      str1 = ((Resources)localObject).getString(2131296411);
      str2 = ((Resources)localObject).getString(2131296413);
      if (paramInt != 1) {
        break label511;
      }
    }
    try
    {
      localObject = ((Resources)localObject).getString(2131296412);
      paramStatisticalData = (StatisticalData)localObject;
      String str3 = String.format("%.3f", new Object[] { Float.valueOf(f2) }).replace(',', '.');
      paramStatisticalData = (StatisticalData)localObject;
      f1 = Float.parseFloat(str3.substring(0, str3.length() - 1));
      paramStatisticalData = (StatisticalData)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label226:
        label233:
        float f3;
        label241:
        float f4;
        label511:
        label544:
        label558:
        float f1 = f2;
      }
    }
    if (i == 0)
    {
      f2 = 0.0F;
      if (i != 0) {
        break label544;
      }
      f3 = 0.0F;
      if (i != 0) {
        break label558;
      }
    }
    for (f4 = 0.0F;; f4 = f5 / i)
    {
      return new String[] { String.format("%.2f", new Object[] { Float.valueOf(f1) }).replace(',', '.') + paramStatisticalData, l1 + str1, f5 + str2, String.format("%.2f", new Object[] { Float.valueOf(f2) }) + paramStatisticalData, String.format("%.0f", new Object[] { Float.valueOf(f3) }) + str1, String.format("%.1f", new Object[] { Float.valueOf(f4) }) + str2 };
      paramStatisticalData.setDayCount(((Cursor)localObject).getInt(0));
      paramStatisticalData.setTotalDistance(((Cursor)localObject).getFloat(1));
      paramStatisticalData.setTotalStep(((Cursor)localObject).getLong(2));
      paramStatisticalData.setTotalCalory(((Cursor)localObject).getLong(3));
      break;
      f1 = f2;
      if (paramInt != 2) {
        break label226;
      }
      paramStatisticalData = ((Resources)localObject).getString(2131296421);
      f1 = UnitFormat.km2mile(f2);
      break label226;
      f2 = f1 / i;
      break label233;
      f3 = (float)l1 * 1.0F / i;
      break label241;
    }
  }
  
  public static ArrayList<DetailChart.PageData.LineData.PointModel> getSportPoints(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 0: 
      return getSportWeeksMonthsData(paramInt1, LongDateUtil.getFirstDayOfWeek(paramInt2), 7);
    case 1: 
      long l = LongDateUtil.getFirstDayOfMonth(paramInt2);
      return getSportWeeksMonthsData(paramInt1, l, LongDateUtil.getMonthDay(LongDateUtil.getYear(l), LongDateUtil.getMonth(l)));
    }
    return getSportYearData(paramInt2);
  }
  
  private static ArrayList<DetailChart.PageData.LineData.PointModel> getSportWeeksMonthsData(int paramInt1, long paramLong, int paramInt2)
  {
    String[] arrayOfString = context.getResources().getStringArray(2131361794);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = HealthDataDetailsCache.getInstance().getSportMap();
    int i = 0;
    if (i >= paramInt2) {
      return localArrayList;
    }
    DetailChart.PageData.LineData.PointModel localPointModel = new DetailChart.PageData.LineData.PointModel();
    Object localObject = (SportDataDay)localHashMap.get(Long.valueOf(paramLong));
    int j;
    if (localObject == null)
    {
      j = 0;
      label74:
      localPointModel.data = j;
      if (paramInt1 != 1) {
        break label219;
      }
      if (((i % 4 != 0) || (i > 25)) && (i != paramInt2 - 1)) {
        break label208;
      }
    }
    label208:
    for (localPointModel.dataName = (i + 1);; localPointModel.dataName = "")
    {
      localPointModel.dataLabel = new String[] { j + " " + context.getString(2131296411) };
      localArrayList.add(localPointModel);
      paramLong = LongDateUtil.add(paramLong, 1);
      i += 1;
      break;
      j = ((SportDataDay)localObject).getTotalstepCount();
      break label74;
    }
    label219:
    if (paramInt1 == 0) {}
    for (localObject = arrayOfString[i];; localObject = i + 1)
    {
      localPointModel.dataName = ((String)localObject);
      break;
    }
  }
  
  public static ArrayList<DetailChart.PageData.LineData.PointModel> getSportYearData(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    DetailChart.PageData.LineData.PointModel[] arrayOfPointModel = new DetailChart.PageData.LineData.PointModel[12];
    HashMap localHashMap = HealthDataDetailsCache.getInstance().getSportMap();
    Object localObject = localHashMap.keySet();
    int i = Calendar.getInstance().get(1);
    localObject = ((Set)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        paramInt = 1;
        if (paramInt <= 12) {
          break;
        }
        return localArrayList;
      }
      Long localLong = (Long)((Iterator)localObject).next();
      if (i - paramInt == LongDateUtil.getYear(localLong.longValue()))
      {
        int j = LongDateUtil.getMonth(localLong.longValue());
        if (arrayOfPointModel[(j - 1)] == null) {
          arrayOfPointModel[(j - 1)] = new DetailChart.PageData.LineData.PointModel();
        }
        DetailChart.PageData.LineData.PointModel localPointModel = arrayOfPointModel[(j - 1)];
        j = localPointModel.data;
        localPointModel.data = (((SportDataDay)localHashMap.get(localLong)).getTotalstepCount() + j);
      }
    }
    if (arrayOfPointModel[(paramInt - 1)] == null) {
      arrayOfPointModel[(paramInt - 1)] = new DetailChart.PageData.LineData.PointModel();
    }
    for (arrayOfPointModel[(paramInt - 1)].dataLabel = new String[] { "0 " + context.getString(2131296411) };; arrayOfPointModel[(paramInt - 1)].dataLabel = new String[] { arrayOfPointModel[(paramInt - 1)].data + " " + context.getString(2131296411) })
    {
      arrayOfPointModel[(paramInt - 1)].dataName = String.format("%02d", new Object[] { Integer.valueOf(paramInt) });
      localArrayList.add(arrayOfPointModel[(paramInt - 1)]);
      paramInt += 1;
      break;
    }
  }
  
  public static SportData getSprotByDate(Calendar paramCalendar, int paramInt)
  {
    SportData localSportData = new SportData();
    long l = LongDateUtil.sub(LongDateUtil.Calendar2LongDate(paramCalendar), paramInt);
    localSportData.date = LongDateUtil.LongDate2Calendar(l);
    paramCalendar = DBTool.getInstance().getDaoSession();
    Object localObject = paramCalendar.getSportDataDayDao().queryBuilder();
    ((QueryBuilder)localObject).where(SportDataDayDao.Properties.Date.eq(Long.valueOf(l)), new WhereCondition[0]);
    localObject = ((QueryBuilder)localObject).list();
    if (((List)localObject).isEmpty())
    {
      localSportData.details = new ArrayList();
      paramInt = 0;
      if (paramInt < 96) {}
    }
    for (;;)
    {
      return localSportData;
      localSportData.details.add(Integer.valueOf(0));
      paramInt += 1;
      break;
      localObject = (SportDataDay)((List)localObject).get(0);
      localSportData.calorie = ((SportDataDay)localObject).getTotalCalory();
      localSportData.distance = (((SportDataDay)localObject).getTotalDistance() / 1000.0F);
      localSportData.steps = ((SportDataDay)localObject).getTotalstepCount();
      localSportData.activityTime = ((SportDataDay)localObject).getTotalActiveTime();
      paramCalendar = paramCalendar.getSportDataItemDao().queryBuilder().where(SportDataItemDao.Properties.Date.eq(Long.valueOf(l)), new WhereCondition[0]).orderAsc(new Property[] { SportDataItemDao.Properties.Date }).orderAsc(new Property[] { SportDataItemDao.Properties.Hour }).orderAsc(new Property[] { SportDataItemDao.Properties.Minute }).list();
      int i1 = paramCalendar.size();
      localSportData.details = new ArrayList();
      if (i1 < 96)
      {
        paramInt = 0;
        int m = 0;
        int j = i1 - 1;
        int i = 0;
        label291:
        int k;
        int n;
        if (i < 96)
        {
          k = m;
          n = paramInt;
          if (paramInt >= 60)
          {
            k = m + 1;
            n = 0;
          }
          if (j < 0) {
            break label436;
          }
          if ((k != ((SportDataItem)paramCalendar.get(i1 - j - 1)).getHour()) || (n != ((SportDataItem)paramCalendar.get(i1 - j - 1)).getMinute())) {
            break label420;
          }
          localSportData.details.add(Integer.valueOf(((SportDataItem)paramCalendar.get(i1 - j - 1)).getStepCount()));
          j -= 1;
        }
        for (;;)
        {
          paramInt = n + 15;
          i += 1;
          m = k;
          break label291;
          break;
          label420:
          localSportData.details.add(Integer.valueOf(0));
          continue;
          label436:
          localSportData.details.add(Integer.valueOf(0));
        }
      }
      paramInt = 0;
      while (paramInt < i1)
      {
        localSportData.details.add(Integer.valueOf(((SportDataItem)paramCalendar.get(paramInt)).getStepCount()));
        paramInt += 1;
      }
    }
  }
  
  public static List<Integer> getTotalSleep(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = HealthDataDetailsCache.getInstance();
    HashMap localHashMap = ((HealthDataDetailsCache)localObject).getSleepMap();
    long l2 = ((HealthDataDetailsCache)localObject).getMinDate();
    for (long l1 = LongDateUtil.Calendar2LongDate(Calendar.getInstance());; l1 = LongDateUtil.sub(l1, 1))
    {
      if (l1 < l2) {
        return localLinkedList;
      }
      localObject = Integer.valueOf(0);
      if (localHashMap.containsKey(Long.valueOf(l1))) {
        localObject = Integer.valueOf(((SleepDataDay)localHashMap.get(Long.valueOf(l1))).getTotalSleepMinutes());
      }
      localLinkedList.add(localObject);
    }
  }
  
  public static void init(Context paramContext)
  {
    context = paramContext;
  }
  
  public static void insertHealthDataMax(List<BtHealthDataMax> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      HealthDataMaxDao localHealthDataMaxDao = DBTool.getInstance().getDaoSession().getHealthDataMaxDao();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BtHealthDataMax localBtHealthDataMax = (BtHealthDataMax)paramList.next();
        HealthDataMax localHealthDataMax = new HealthDataMax();
        localHealthDataMax.setSportMaxActiveTime(localBtHealthDataMax.getSportMaxActiveTime());
        localHealthDataMax.setSportMaxCalory(localBtHealthDataMax.getSportMaxCalory());
        localHealthDataMax.setSportMaxDistance(localBtHealthDataMax.getSportMaxDistance());
        localHealthDataMax.setSportMaxStepCount(localBtHealthDataMax.getSportMaxStepCount());
        localHealthDataMaxDao.insertOrReplace(localHealthDataMax);
      }
    }
  }
  
  public static void insertHeartRate(List<BtHeartRate> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      HeartRateDao localHeartRateDao = DBTool.getInstance().getDaoSession().getHeartRateDao();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BtHeartRate localBtHeartRate = (BtHeartRate)paramList.next();
        HeartRate localHeartRate = new HeartRate();
        localHeartRate.setDate(localBtHeartRate.getDate().longValue());
        localHeartRate.setMinute(localBtHeartRate.getMinute());
        localHeartRate.setRate(localBtHeartRate.getRate());
        localHeartRateDao.insertOrReplace(localHeartRate);
      }
    }
  }
  
  public static void insertHeartRateThreshold(List<BtHeartRateThreshold> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      HeartRateTresholdDao localHeartRateTresholdDao = DBTool.getInstance().getDaoSession().getHeartRateTresholdDao();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BtHeartRateThreshold localBtHeartRateThreshold = (BtHeartRateThreshold)paramList.next();
        HeartRateTreshold localHeartRateTreshold = new HeartRateTreshold();
        localHeartRateTreshold.setDate(localBtHeartRateThreshold.getDate().longValue());
        localHeartRateTreshold.setMinThreshold(localBtHeartRateThreshold.getMinThreshold());
        localHeartRateTreshold.setMaxThreshold(localBtHeartRateThreshold.getMaxThreshold());
        localHeartRateTreshold.setBurnFatThreshold(localBtHeartRateThreshold.getBurnFatThreshold());
        localHeartRateTreshold.setBurnFatMins(localBtHeartRateThreshold.getBurnFatMins());
        localHeartRateTreshold.setAerobicThreshold(localBtHeartRateThreshold.getAerobicThreshold());
        localHeartRateTreshold.setAerobicMins(localBtHeartRateThreshold.getAerobicMins());
        localHeartRateTreshold.setLimitThreshold(localBtHeartRateThreshold.getLimitThreshold());
        localHeartRateTreshold.setLimitMins(localBtHeartRateThreshold.getLimitMins());
        localHeartRateTreshold.setSilentHeartRate(localBtHeartRateThreshold.getSilentHeartRate());
        localHeartRateTresholdDao.insertOrReplace(localHeartRateTreshold);
      }
    }
  }
  
  public static void insertSleepDataDay(List<BtSleepDataDay> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      SleepDataDayDao localSleepDataDayDao = DBTool.getInstance().getDaoSession().getSleepDataDayDao();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BtSleepDataDay localBtSleepDataDay = (BtSleepDataDay)paramList.next();
        SleepDataDay localSleepDataDay = new SleepDataDay();
        localSleepDataDay.setDate(localBtSleepDataDay.getDate());
        localSleepDataDay.setEndTimeHour(localBtSleepDataDay.getEndTimeHour());
        localSleepDataDay.setEndTimeMinute(localBtSleepDataDay.getEndTimeMinute());
        localSleepDataDay.setTotalSleepMinutes(localBtSleepDataDay.getTotalSleepMinutes());
        localSleepDataDay.setDeepSleepMinutes(localBtSleepDataDay.getDeepSleepMinutes());
        localSleepDataDay.setDeepSleepCount(localBtSleepDataDay.getDeepSleepCount());
        localSleepDataDay.setLightSleepMinutes(localBtSleepDataDay.getLightSleepMinutes());
        localSleepDataDay.setLightSleepCount(localBtSleepDataDay.getLightSleepCount());
        localSleepDataDay.setAwakeCount(localBtSleepDataDay.getAwakeCount());
        localSleepDataDayDao.insertOrReplace(localSleepDataDay);
      }
    }
  }
  
  public static void insertSleepDataItem(List<BtSleepDataItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      SleepDataItemDao localSleepDataItemDao = DBTool.getInstance().getDaoSession().getSleepDataItemDao();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BtSleepDataItem localBtSleepDataItem = (BtSleepDataItem)paramList.next();
        SleepDataItem localSleepDataItem = new SleepDataItem();
        localSleepDataItem.setDate(localBtSleepDataItem.getDate().longValue());
        localSleepDataItem.setSleepMinutes(localBtSleepDataItem.getSleepMinutes());
        localSleepDataItem.setSleepStatus(localBtSleepDataItem.getSleepStatus());
        localSleepDataItemDao.insertOrReplace(localSleepDataItem);
      }
    }
  }
  
  public static void insertSportDataDay(List<BtSportDataDay> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      SportDataDayDao localSportDataDayDao = DBTool.getInstance().getDaoSession().getSportDataDayDao();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BtSportDataDay localBtSportDataDay = (BtSportDataDay)paramList.next();
        SportDataDay localSportDataDay = new SportDataDay();
        localSportDataDay.setDate(localBtSportDataDay.getDate());
        localSportDataDay.setTotalCalory(localBtSportDataDay.getTotalCalory());
        localSportDataDay.setTotalDistance(localBtSportDataDay.getTotalDistance());
        localSportDataDay.setTotalstepCount(localBtSportDataDay.getTotalstepCount());
        localSportDataDay.setTotalActiveTime(localBtSportDataDay.getTotalActiveTime());
        localSportDataDayDao.insertOrReplace(localSportDataDay);
      }
    }
  }
  
  public static void insertSportDataItem(List<BtSportDataItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      SportDataItemDao localSportDataItemDao = DBTool.getInstance().getDaoSession().getSportDataItemDao();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BtSportDataItem localBtSportDataItem = (BtSportDataItem)paramList.next();
        SportDataItem localSportDataItem = new SportDataItem();
        localSportDataItem.setDate(localBtSportDataItem.getDate());
        localSportDataItem.setHour(localBtSportDataItem.getHour());
        localSportDataItem.setMinute(localBtSportDataItem.getMinute());
        localSportDataItem.setMode(localBtSportDataItem.getMode());
        localSportDataItem.setDistance(localBtSportDataItem.getDistance());
        localSportDataItem.setStepCount(localBtSportDataItem.getStepCount());
        localSportDataItem.setCalory(localBtSportDataItem.getCalory());
        localSportDataItem.setActiveTime(localBtSportDataItem.getActiveTime());
        localSportDataItemDao.insertOrReplace(localSportDataItem);
      }
    }
  }
  
  public static void saveGoal(Goal... paramVarArgs)
  {
    GoalDao localGoalDao = DBTool.getInstance().getDaoSession().getGoalDao();
    int j = paramVarArgs.length;
    int i = 0;
    if (i >= j) {
      return;
    }
    Goal localGoal = paramVarArgs[i];
    Object localObject = localGoalDao.queryBuilder();
    ((QueryBuilder)localObject).where(GoalDao.Properties.Date.eq(Long.valueOf(localGoal.getDate())), new WhereCondition[] { GoalDao.Properties.Type.eq(Integer.valueOf(localGoal.getType())) });
    localObject = ((QueryBuilder)localObject).list();
    if (((List)localObject).isEmpty()) {
      localGoalDao.insert(localGoal);
    }
    for (;;)
    {
      i += 1;
      break;
      ((Goal)((List)localObject).get(0)).setGoal(localGoal.getGoal());
      localGoalDao.update((Goal)((List)localObject).get(0));
    }
  }
  
  public static void saveHeartRate(List<HeartRate> paramList)
  {
    HeartRateDao localHeartRateDao = DBTool.getInstance().getDaoSession().getHeartRateDao();
    int i = 0;
    if (i >= paramList.size()) {
      return;
    }
    HeartRate localHeartRate = (HeartRate)paramList.get(i);
    int j = LibSharedPreferences.getInstance().getHeartRateMax();
    int k = LibSharedPreferences.getInstance().getHeartRateMin();
    Object localObject;
    if ((localHeartRate.getRate() <= j) && (localHeartRate.getRate() >= k) && (localHeartRate.getMinute() <= 1440))
    {
      localObject = localHeartRateDao.queryBuilder();
      ((QueryBuilder)localObject).where(HeartRateDao.Properties.Date.eq(Long.valueOf(localHeartRate.getDate())), new WhereCondition[] { HeartRateDao.Properties.Minute.eq(Integer.valueOf(localHeartRate.getMinute())) });
      localObject = ((QueryBuilder)localObject).list();
      if (!((List)localObject).isEmpty()) {
        break label159;
      }
      localHeartRateDao.insert(localHeartRate);
    }
    for (;;)
    {
      i += 1;
      break;
      label159:
      ((HeartRate)((List)localObject).get(0)).setRate(localHeartRate.getRate());
      localHeartRateDao.update((HeartRate)((List)localObject).get(0));
    }
  }
  
  public static void saveHeartRateTreshold(HeartRateTreshold paramHeartRateTreshold)
  {
    HeartRateTresholdDao localHeartRateTresholdDao = DBTool.getInstance().getDaoSession().getHeartRateTresholdDao();
    Object localObject = localHeartRateTresholdDao.queryBuilder();
    ((QueryBuilder)localObject).where(HeartRateTresholdDao.Properties.Date.eq(Long.valueOf(paramHeartRateTreshold.getDate())), new WhereCondition[0]);
    localObject = ((QueryBuilder)localObject).list();
    if (((List)localObject).isEmpty()) {
      localHeartRateTresholdDao.insert(paramHeartRateTreshold);
    }
    for (;;)
    {
      LibSharedPreferences.getInstance().setHeartRateMin(paramHeartRateTreshold.getMinThreshold());
      LibSharedPreferences.getInstance().setHeartRateMax(paramHeartRateTreshold.getMaxThreshold());
      return;
      ((HeartRateTreshold)((List)localObject).get(0)).setAerobicThreshold(paramHeartRateTreshold.getAerobicThreshold());
      ((HeartRateTreshold)((List)localObject).get(0)).setBurnFatThreshold(paramHeartRateTreshold.getBurnFatThreshold());
      ((HeartRateTreshold)((List)localObject).get(0)).setLimitThreshold(paramHeartRateTreshold.getLimitThreshold());
      ((HeartRateTreshold)((List)localObject).get(0)).setMinThreshold(paramHeartRateTreshold.getMinThreshold());
      ((HeartRateTreshold)((List)localObject).get(0)).setMaxThreshold(paramHeartRateTreshold.getMaxThreshold());
      ((HeartRateTreshold)((List)localObject).get(0)).setAerobicMins(paramHeartRateTreshold.getAerobicMins());
      ((HeartRateTreshold)((List)localObject).get(0)).setBurnFatMins(paramHeartRateTreshold.getBurnFatMins());
      ((HeartRateTreshold)((List)localObject).get(0)).setLimitMins(paramHeartRateTreshold.getLimitMins());
      ((HeartRateTreshold)((List)localObject).get(0)).setSilentHeartRate(paramHeartRateTreshold.getSilentHeartRate());
      localHeartRateTresholdDao.update((HeartRateTreshold)((List)localObject).get(0));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\TempUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */