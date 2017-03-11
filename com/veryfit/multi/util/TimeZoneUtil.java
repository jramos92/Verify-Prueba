package com.veryfit.multi.util;

import java.util.TimeZone;

public class TimeZoneUtil
{
  private static void appendNumber(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    String str = Integer.toString(paramInt2);
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 >= paramInt1 - str.length())
      {
        paramStringBuilder.append(str);
        return;
      }
      paramStringBuilder.append('0');
      paramInt2 += 1;
    }
  }
  
  public static String createGmtOffsetString(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = paramInt / 60000;
    char c = '+';
    paramInt = i;
    if (i < 0)
    {
      c = '-';
      paramInt = -i;
    }
    StringBuilder localStringBuilder = new StringBuilder(9);
    if (paramBoolean1) {
      localStringBuilder.append("GMT");
    }
    localStringBuilder.append(c);
    appendNumber(localStringBuilder, 2, paramInt / 60);
    if (paramBoolean2) {
      localStringBuilder.append(':');
    }
    appendNumber(localStringBuilder, 2, paramInt % 60);
    return localStringBuilder.toString();
  }
  
  public static String getCurrentTimeZone()
  {
    return createGmtOffsetString(true, true, TimeZone.getDefault().getRawOffset());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\TimeZoneUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */