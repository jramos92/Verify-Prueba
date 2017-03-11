package com.mob.tools.log;

public abstract interface LogCollector
{
  public static final int LEVEL_CRASH = 1;
  public static final int LEVEL_NATIVE = 2;
  public static final int LEVEL_NORMAL = 0;
  
  public abstract void log(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\log\LogCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */