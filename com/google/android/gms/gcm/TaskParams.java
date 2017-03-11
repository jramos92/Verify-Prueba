package com.google.android.gms.gcm;

import android.os.Bundle;

public class TaskParams
{
  private final Bundle extras;
  private final String tag;
  
  public TaskParams(String paramString)
  {
    this(paramString, null);
  }
  
  public TaskParams(String paramString, Bundle paramBundle)
  {
    this.tag = paramString;
    this.extras = paramBundle;
  }
  
  public Bundle getExtras()
  {
    return this.extras;
  }
  
  public String getTag()
  {
    return this.tag;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\gcm\TaskParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */