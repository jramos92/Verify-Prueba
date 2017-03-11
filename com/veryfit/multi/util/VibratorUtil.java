package com.veryfit.multi.util;

import android.app.Activity;
import android.os.Vibrator;

public class VibratorUtil
{
  public static void Vibrate(Activity paramActivity, long paramLong)
  {
    ((Vibrator)paramActivity.getSystemService("vibrator")).vibrate(paramLong);
  }
  
  public static void Vibrate(Activity paramActivity, long[] paramArrayOfLong, boolean paramBoolean)
  {
    paramActivity = (Vibrator)paramActivity.getSystemService("vibrator");
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      paramActivity.vibrate(paramArrayOfLong, i);
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\VibratorUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */