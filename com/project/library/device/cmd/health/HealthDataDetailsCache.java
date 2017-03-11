package com.project.library.device.cmd.health;

import android.os.Handler;
import android.os.HandlerThread;
import com.project.library.database.DaoSession;
import com.project.library.database.HeartRateTreshold;
import com.project.library.database.HeartRateTresholdDao;
import com.project.library.database.HeartRateTresholdDao.Properties;
import com.project.library.database.SleepDataDay;
import com.project.library.database.SleepDataDayDao;
import com.project.library.database.SleepDataDayDao.Properties;
import com.project.library.database.SportDataDay;
import com.project.library.database.SportDataDayDao;
import com.project.library.database.SportDataDayDao.Properties;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HealthDataDetailsCache
{
  private static HealthDataDetailsCache mInstance = null;
  private Handler mHandler = null;
  private HandlerThread mHandlerThread = null;
  private HashMap<Long, HeartRateTreshold> mRateMap = new HashMap();
  private Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      HealthDataDetailsCache.this.get();
    }
  };
  private HashMap<Long, SleepDataDay> mSleepMap = new HashMap();
  private HashMap<Long, SportDataDay> mSportMap = new HashMap();
  private long minDate = LongDateUtil.Calendar2LongDate(Calendar.getInstance());
  
  private HealthDataDetailsCache()
  {
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.mHandler.post(this.mRunnable);
  }
  
  private void get()
  {
    Iterator localIterator = getSportDataDayAllList().iterator();
    if (!localIterator.hasNext())
    {
      localIterator = getSleepDataDayAllList().iterator();
      label29:
      if (localIterator.hasNext()) {
        break label88;
      }
      localIterator = getHeartRateDataDayAllList().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        DebugLog.e("全部数据缓存完毕");
        return;
        localObject = (SportDataDay)localIterator.next();
        updateHealthDataDay(((SportDataDay)localObject).getDate().longValue(), (SportDataDay)localObject);
        break;
        label88:
        localObject = (SleepDataDay)localIterator.next();
        updateHealthDataDay(((SleepDataDay)localObject).getDate().longValue(), (SleepDataDay)localObject);
        break label29;
      }
      Object localObject = (HeartRateTreshold)localIterator.next();
      updateHeartRateDataDay(((HeartRateTreshold)localObject).getDate(), (HeartRateTreshold)localObject);
    }
  }
  
  private List<HeartRateTreshold> getHeartRateDataDayAllList()
  {
    QueryBuilder localQueryBuilder = DBTool.getInstance().getDaoSession().getHeartRateTresholdDao().queryBuilder();
    localQueryBuilder.orderDesc(new Property[] { HeartRateTresholdDao.Properties.Date });
    return localQueryBuilder.list();
  }
  
  public static HealthDataDetailsCache getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new HealthDataDetailsCache();
      }
      HealthDataDetailsCache localHealthDataDetailsCache = mInstance;
      return localHealthDataDetailsCache;
    }
    finally {}
  }
  
  private List<SleepDataDay> getSleepDataDayAllList()
  {
    QueryBuilder localQueryBuilder = DBTool.getInstance().getDaoSession().getSleepDataDayDao().queryBuilder();
    localQueryBuilder.orderDesc(new Property[] { SleepDataDayDao.Properties.Date });
    return localQueryBuilder.list();
  }
  
  private List<SportDataDay> getSportDataDayAllList()
  {
    QueryBuilder localQueryBuilder = DBTool.getInstance().getDaoSession().getSportDataDayDao().queryBuilder();
    localQueryBuilder.orderDesc(new Property[] { SportDataDayDao.Properties.Date });
    return localQueryBuilder.list();
  }
  
  private void updateMinDate(long paramLong)
  {
    this.minDate = Math.min(this.minDate, paramLong);
  }
  
  public long getMinDate()
  {
    return this.minDate;
  }
  
  public HashMap<Long, HeartRateTreshold> getRateMap()
  {
    return this.mRateMap;
  }
  
  public HashMap<Long, SleepDataDay> getSleepMap()
  {
    return this.mSleepMap;
  }
  
  public HashMap<Long, SportDataDay> getSportMap()
  {
    return this.mSportMap;
  }
  
  public void loadData()
  {
    this.mHandler.post(this.mRunnable);
  }
  
  public void setMinDate(long paramLong)
  {
    this.minDate = paramLong;
  }
  
  public void updateHealthDataDay(long paramLong, SleepDataDay paramSleepDataDay)
  {
    updateMinDate(paramLong);
    this.mSleepMap.put(Long.valueOf(paramLong), paramSleepDataDay);
  }
  
  public void updateHealthDataDay(long paramLong, SportDataDay paramSportDataDay)
  {
    updateMinDate(paramLong);
    this.mSportMap.put(Long.valueOf(paramLong), paramSportDataDay);
  }
  
  public void updateHeartRateDataDay(long paramLong, HeartRateTreshold paramHeartRateTreshold)
  {
    updateMinDate(paramLong);
    this.mRateMap.put(Long.valueOf(paramLong), paramHeartRateTreshold);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\HealthDataDetailsCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */