package com.veryfit.multi.util;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActivityCollector
{
  public static List<Activity> activities = new ArrayList();
  
  public static void addActivity(Activity paramActivity)
  {
    activities.add(paramActivity);
  }
  
  public static void finishAll()
  {
    Iterator localIterator = activities.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Activity localActivity = (Activity)localIterator.next();
      if (!localActivity.isFinishing()) {
        localActivity.finish();
      }
    }
  }
  
  public static void removeActivity(Activity paramActivity)
  {
    activities.remove(paramActivity);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\ActivityCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */