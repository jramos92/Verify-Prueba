package com.project.library.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.util.Calendar;

public class Util
{
  public static int format12To24(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt == 12) {
        return 0;
      }
      return paramInt;
    }
    if (paramInt == 12) {
      return 12;
    }
    return paramInt + 12;
  }
  
  public static int format24To12(int paramInt)
  {
    int i = paramInt % 12;
    paramInt = i;
    if (i == 0) {
      paramInt = 12;
    }
    return paramInt;
  }
  
  public static String formatTime(int paramInt1, int paramInt2)
  {
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static String formatToMonthAndDate(Calendar paramCalendar)
  {
    return paramCalendar.get(2) + 1 + "/" + paramCalendar.get(5);
  }
  
  public static String formatToMonthAndDate(Calendar paramCalendar, int paramInt)
  {
    paramCalendar.add(5, paramInt);
    String str = paramCalendar.get(2) + 1 + "/" + paramCalendar.get(5);
    paramCalendar.add(5, -paramInt);
    return str;
  }
  
  public static Bitmap geByFilePath(String paramString)
  {
    return BitmapFactory.decodeFile(paramString);
  }
  
  public static int getCurrentMinute(Calendar paramCalendar)
  {
    return paramCalendar.get(10) * 60 + paramCalendar.get(12);
  }
  
  public static long getCurrentTime(Calendar paramCalendar)
  {
    return paramCalendar.get(1) * 10000 + (paramCalendar.get(2) + 1) * 100 + paramCalendar.get(5);
  }
  
  public static int[] getHourAndMin(int paramInt, boolean paramBoolean)
  {
    int j = paramInt / 60;
    int i;
    if (paramBoolean) {
      i = j;
    }
    for (;;)
    {
      return new int[] { i, paramInt % 60 };
      if (j % 12 == 0)
      {
        i = 12;
      }
      else
      {
        i = j;
        if (j > 12) {
          i = j - 12;
        }
      }
    }
  }
  
  public static String getMaxLenthString(String[] paramArrayOfString)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    int i;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      i = 0;
      if (i >= j) {
        localObject2 = localObject1;
      }
    }
    else
    {
      return (String)localObject2;
    }
    String str = paramArrayOfString[i];
    localObject2 = localObject1;
    if (str != null) {
      if (((String)localObject1).length() <= str.length()) {
        break label64;
      }
    }
    label64:
    for (localObject2 = localObject1;; localObject2 = str)
    {
      i += 1;
      localObject1 = localObject2;
      break;
    }
  }
  
  public static String getSyncTimeStr(Calendar paramCalendar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("%02d/%02d/%02d ", new Object[] { Integer.valueOf(paramCalendar.get(1) % 1000), Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
    localStringBuilder.append(String.format("%02d:%02d", new Object[] { Integer.valueOf(paramCalendar.get(11)), Integer.valueOf(paramCalendar.get(12)) }));
    return localStringBuilder.toString();
  }
  
  public static String getTimeStr(int[] paramArrayOfInt)
  {
    return String.format("%1$02d : %2$02d", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]) });
  }
  
  public static boolean isAM(int paramInt)
  {
    return paramInt < 12;
  }
  
  public static boolean isSameDay(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    return (paramCalendar1.get(1) == paramCalendar2.get(1)) && (paramCalendar1.get(2) == paramCalendar2.get(2)) && (paramCalendar1.get(5) == paramCalendar2.get(5));
  }
  
  public static String ss(Calendar paramCalendar)
  {
    return paramCalendar.get(1) + "/" + (paramCalendar.get(2) + 1) + "/" + paramCalendar.get(5);
  }
  
  public static String timeFormatter(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < 1440))
    {
      int i = getHourAndMin(paramInt, paramBoolean)[0];
      int j = paramInt % 60;
      if (paramBoolean)
      {
        paramInt = i;
        if (i == 24) {
          paramInt = 0;
        }
        return String.format("%1$02d:%2$02d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j) });
      }
      if (paramInt < 720) {}
      for (String str = " am";; str = " pm")
      {
        paramInt = i;
        if (i == 24) {
          paramInt = 0;
        }
        return String.format("%1$02d:%2$02d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j) }) + str;
      }
    }
    Log.e("Util", "timeFormatter Error : mins is out of range [0 , 1440).");
    return "--:--";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */