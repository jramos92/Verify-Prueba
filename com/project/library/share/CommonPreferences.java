package com.project.library.share;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.util.Set;

public class CommonPreferences
{
  protected SharedPreferences mSharePre;
  
  protected float getValue(String paramString, float paramFloat)
  {
    return this.mSharePre.getFloat(paramString, paramFloat);
  }
  
  protected int getValue(String paramString, int paramInt)
  {
    return this.mSharePre.getInt(paramString, paramInt);
  }
  
  protected long getValue(String paramString, long paramLong)
  {
    return this.mSharePre.getLong(paramString, paramLong);
  }
  
  protected String getValue(String paramString1, String paramString2)
  {
    return this.mSharePre.getString(paramString1, paramString2);
  }
  
  protected Set<String> getValue(String paramString, Set<String> paramSet)
  {
    return this.mSharePre.getStringSet(paramString, paramSet);
  }
  
  protected boolean getValue(String paramString, boolean paramBoolean)
  {
    return this.mSharePre.getBoolean(paramString, paramBoolean);
  }
  
  public void init(Context paramContext, String paramString)
  {
    Log.i("CommonPreferences", "context  = :" + paramContext + "   spName : " + paramString);
    this.mSharePre = paramContext.getSharedPreferences(paramString, 0);
  }
  
  public boolean remove(String paramString)
  {
    return this.mSharePre.edit().remove(paramString).commit();
  }
  
  protected void setValue(String paramString, float paramFloat)
  {
    this.mSharePre.edit().putFloat(paramString, paramFloat).commit();
  }
  
  protected void setValue(String paramString, int paramInt)
  {
    this.mSharePre.edit().putInt(paramString, paramInt).commit();
  }
  
  protected void setValue(String paramString, long paramLong)
  {
    this.mSharePre.edit().putLong(paramString, paramLong).commit();
  }
  
  protected void setValue(String paramString1, String paramString2)
  {
    this.mSharePre.edit().putString(paramString1, paramString2).commit();
  }
  
  protected void setValue(String paramString, Set<String> paramSet)
  {
    this.mSharePre.edit().putStringSet(paramString, paramSet).commit();
  }
  
  protected void setValue(String paramString, boolean paramBoolean)
  {
    this.mSharePre.edit().putBoolean(paramString, paramBoolean).commit();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\share\CommonPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */