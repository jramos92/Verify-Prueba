package cn.sharesdk.framework.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.PrintStream;

public class ShareSDKR
{
  public static int getAnimRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "anim", paramString);
  }
  
  public static int getBitmapRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "drawable", paramString);
  }
  
  public static int getColorRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "color", paramString);
  }
  
  public static int getIdRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "id", paramString);
  }
  
  public static int getLayoutRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "layout", paramString);
  }
  
  public static int getPluralsRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "plurals", paramString);
  }
  
  public static int getRawRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "raw", paramString);
  }
  
  public static int getResId(Context paramContext, String paramString1, String paramString2)
  {
    int j = 0;
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          break label32;
        }
        i = j;
      }
    }
    label32:
    do
    {
      String str;
      do
      {
        return i;
        str = paramContext.getPackageName();
        i = j;
      } while (TextUtils.isEmpty(str));
      i = paramContext.getResources().getIdentifier(paramString2, paramString1, str);
      j = i;
      if (i <= 0) {
        j = paramContext.getResources().getIdentifier(paramString2.toLowerCase(), paramString1, str);
      }
      i = j;
      if (j <= 0)
      {
        j = paramContext.getResources().getIdentifier("ssdk_" + paramString2, paramString1, str);
        i = j;
        if (j <= 0) {
          i = paramContext.getResources().getIdentifier("ssdk_" + paramString2.toLowerCase(), paramString1, str);
        }
      }
      j = i;
      if (i <= 0)
      {
        i = paramContext.getResources().getIdentifier("ssdk_oks_" + paramString2, paramString1, str);
        j = i;
        if (i <= 0) {
          j = paramContext.getResources().getIdentifier("ssdk_oks_" + paramString2.toLowerCase(), paramString1, str);
        }
      }
      i = j;
    } while (j > 0);
    System.err.println("failed to parse " + paramString1 + " resource \"" + paramString2 + "\"");
    return j;
  }
  
  public static int getStringArrayRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "array", paramString);
  }
  
  public static int getStringRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "string", paramString);
  }
  
  public static int getStyleRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "style", paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\utils\ShareSDKR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */