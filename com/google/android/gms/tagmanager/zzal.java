package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import java.io.File;

class zzal
{
  public static int version()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzbg.e("Invalid version number: " + Build.VERSION.SDK);
    }
    return 0;
  }
  
  static boolean zzbl(String paramString)
  {
    if (version() < 9) {
      return false;
    }
    paramString = new File(paramString);
    paramString.setReadable(false, false);
    paramString.setWritable(false, false);
    paramString.setReadable(true, true);
    paramString.setWritable(true, true);
    return true;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */