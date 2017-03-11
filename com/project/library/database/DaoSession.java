package com.project.library.database;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

public class DaoSession
  extends AbstractDaoSession
{
  private final AlarmNotifyDao alarmNotifyDao;
  private final DaoConfig alarmNotifyDaoConfig;
  private final GoalDao goalDao;
  private final DaoConfig goalDaoConfig;
  private final HealthDataMaxDao healthDataMaxDao;
  private final DaoConfig healthDataMaxDaoConfig;
  private final HeartRateDao heartRateDao;
  private final DaoConfig heartRateDaoConfig;
  private final HeartRateTresholdDao heartRateTresholdDao;
  private final DaoConfig heartRateTresholdDaoConfig;
  private final SleepDataDayDao sleepDataDayDao;
  private final DaoConfig sleepDataDayDaoConfig;
  private final SleepDataItemDao sleepDataItemDao;
  private final DaoConfig sleepDataItemDaoConfig;
  private final SportDataDayDao sportDataDayDao;
  private final DaoConfig sportDataDayDaoConfig;
  private final SportDataItemDao sportDataItemDao;
  private final DaoConfig sportDataItemDaoConfig;
  private final StatisticalDataDao statisticalDataDao;
  private final DaoConfig statisticalDataDaoConfig;
  
  public DaoSession(SQLiteDatabase paramSQLiteDatabase, IdentityScopeType paramIdentityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> paramMap)
  {
    super(paramSQLiteDatabase);
    this.sportDataDayDaoConfig = ((DaoConfig)paramMap.get(SportDataDayDao.class)).clone();
    this.sportDataDayDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.sportDataItemDaoConfig = ((DaoConfig)paramMap.get(SportDataItemDao.class)).clone();
    this.sportDataItemDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.sleepDataDayDaoConfig = ((DaoConfig)paramMap.get(SleepDataDayDao.class)).clone();
    this.sleepDataDayDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.sleepDataItemDaoConfig = ((DaoConfig)paramMap.get(SleepDataItemDao.class)).clone();
    this.sleepDataItemDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.alarmNotifyDaoConfig = ((DaoConfig)paramMap.get(AlarmNotifyDao.class)).clone();
    this.alarmNotifyDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.healthDataMaxDaoConfig = ((DaoConfig)paramMap.get(HealthDataMaxDao.class)).clone();
    this.healthDataMaxDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.goalDaoConfig = ((DaoConfig)paramMap.get(GoalDao.class)).clone();
    this.goalDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.statisticalDataDaoConfig = ((DaoConfig)paramMap.get(StatisticalDataDao.class)).clone();
    this.statisticalDataDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.heartRateDaoConfig = ((DaoConfig)paramMap.get(HeartRateDao.class)).clone();
    this.heartRateDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.heartRateTresholdDaoConfig = ((DaoConfig)paramMap.get(HeartRateTresholdDao.class)).clone();
    this.heartRateTresholdDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.sportDataDayDao = new SportDataDayDao(this.sportDataDayDaoConfig, this);
    this.sportDataItemDao = new SportDataItemDao(this.sportDataItemDaoConfig, this);
    this.sleepDataDayDao = new SleepDataDayDao(this.sleepDataDayDaoConfig, this);
    this.sleepDataItemDao = new SleepDataItemDao(this.sleepDataItemDaoConfig, this);
    this.alarmNotifyDao = new AlarmNotifyDao(this.alarmNotifyDaoConfig, this);
    this.healthDataMaxDao = new HealthDataMaxDao(this.healthDataMaxDaoConfig, this);
    this.goalDao = new GoalDao(this.goalDaoConfig, this);
    this.statisticalDataDao = new StatisticalDataDao(this.statisticalDataDaoConfig, this);
    this.heartRateDao = new HeartRateDao(this.heartRateDaoConfig, this);
    this.heartRateTresholdDao = new HeartRateTresholdDao(this.heartRateTresholdDaoConfig, this);
    registerDao(SportDataDay.class, this.sportDataDayDao);
    registerDao(SportDataItem.class, this.sportDataItemDao);
    registerDao(SleepDataDay.class, this.sleepDataDayDao);
    registerDao(SleepDataItem.class, this.sleepDataItemDao);
    registerDao(AlarmNotify.class, this.alarmNotifyDao);
    registerDao(HealthDataMax.class, this.healthDataMaxDao);
    registerDao(Goal.class, this.goalDao);
    registerDao(StatisticalData.class, this.statisticalDataDao);
    registerDao(HeartRate.class, this.heartRateDao);
    registerDao(HeartRateTreshold.class, this.heartRateTresholdDao);
  }
  
  public void clear()
  {
    this.sportDataDayDaoConfig.getIdentityScope().clear();
    this.sportDataItemDaoConfig.getIdentityScope().clear();
    this.sleepDataDayDaoConfig.getIdentityScope().clear();
    this.sleepDataItemDaoConfig.getIdentityScope().clear();
    this.alarmNotifyDaoConfig.getIdentityScope().clear();
    this.healthDataMaxDaoConfig.getIdentityScope().clear();
    this.goalDaoConfig.getIdentityScope().clear();
    this.statisticalDataDaoConfig.getIdentityScope().clear();
    this.heartRateDaoConfig.getIdentityScope().clear();
    this.heartRateTresholdDaoConfig.getIdentityScope().clear();
  }
  
  public AlarmNotifyDao getAlarmNotifyDao()
  {
    return this.alarmNotifyDao;
  }
  
  public GoalDao getGoalDao()
  {
    return this.goalDao;
  }
  
  public HealthDataMaxDao getHealthDataMaxDao()
  {
    return this.healthDataMaxDao;
  }
  
  public HeartRateDao getHeartRateDao()
  {
    return this.heartRateDao;
  }
  
  public HeartRateTresholdDao getHeartRateTresholdDao()
  {
    return this.heartRateTresholdDao;
  }
  
  public SleepDataDayDao getSleepDataDayDao()
  {
    return this.sleepDataDayDao;
  }
  
  public SleepDataItemDao getSleepDataItemDao()
  {
    return this.sleepDataItemDao;
  }
  
  public SportDataDayDao getSportDataDayDao()
  {
    return this.sportDataDayDao;
  }
  
  public SportDataItemDao getSportDataItemDao()
  {
    return this.sportDataItemDao;
  }
  
  public StatisticalDataDao getStatisticalDataDao()
  {
    return this.statisticalDataDao;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\DaoSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */