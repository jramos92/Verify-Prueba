package com.umeng.analytics;

import java.util.Locale;
import u.aly.aw;

public enum Gender
{
  public int value;
  
  private Gender(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Gender getGender(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Unknown;
    case 1: 
      return Male;
    }
    return Female;
  }
  
  public static aw transGender(Gender paramGender)
  {
    switch (4.a[paramGender.ordinal()])
    {
    default: 
      return aw.c;
    case 1: 
      return aw.a;
    }
    return aw.b;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\umeng\analytics\Gender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */