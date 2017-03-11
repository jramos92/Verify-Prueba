package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzsd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzu
  extends com.google.android.gms.common.data.zzc
{
  private final String TAG = "SafeDataBufferRef";
  
  public zzu(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  protected String zzF(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (zzce(paramString1))
    {
      str = paramString2;
      if (!zzcg(paramString1)) {
        str = getString(paramString1);
      }
    }
    return str;
  }
  
  protected <E extends SafeParcelable> E zza(String paramString, Parcelable.Creator<E> paramCreator)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {
      return null;
    }
    return com.google.android.gms.common.internal.safeparcel.zzc.zza(paramString, paramCreator);
  }
  
  protected <E extends SafeParcelable> List<E> zza(String paramString, Parcelable.Creator<E> paramCreator, List<E> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          Object localObject = zzru.zzz(paramString);
          if (((zzru)localObject).zzbhW != null)
          {
            paramString = new ArrayList(((zzru)localObject).zzbhW.length);
            localObject = ((zzru)localObject).zzbhW;
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              paramString.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(localObject[i], paramCreator));
              i += 1;
            }
            return paramString;
          }
        }
        catch (zzsd paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected List<Integer> zza(String paramString, List<Integer> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          paramString = zzru.zzz(paramString);
          if (paramString.zzbhV != null)
          {
            ArrayList localArrayList = new ArrayList(paramString.zzbhV.length);
            int i = 0;
            while (i < paramString.zzbhV.length)
            {
              localArrayList.add(Integer.valueOf(paramString.zzbhV[i]));
              i += 1;
            }
            return localArrayList;
          }
        }
        catch (zzsd paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected float zzb(String paramString, float paramFloat)
  {
    float f = paramFloat;
    if (zzce(paramString))
    {
      f = paramFloat;
      if (!zzcg(paramString)) {
        f = getFloat(paramString);
      }
    }
    return f;
  }
  
  protected List<String> zzb(String paramString, List<String> paramList)
  {
    paramString = zzc(paramString, null);
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return paramList;
        try
        {
          paramString = zzru.zzz(paramString);
          if (paramString.zzbhU != null)
          {
            paramString = Arrays.asList(paramString.zzbhU);
            return paramString;
          }
        }
        catch (zzsd paramString) {}
      }
    } while (!Log.isLoggable("SafeDataBufferRef", 6));
    Log.e("SafeDataBufferRef", "Cannot parse byte[]", paramString);
    return paramList;
  }
  
  protected byte[] zzc(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (zzce(paramString))
    {
      arrayOfByte = paramArrayOfByte;
      if (!zzcg(paramString)) {
        arrayOfByte = getByteArray(paramString);
      }
    }
    return arrayOfByte;
  }
  
  protected boolean zzh(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (zzce(paramString))
    {
      bool = paramBoolean;
      if (!zzcg(paramString)) {
        bool = getBoolean(paramString);
      }
    }
    return bool;
  }
  
  protected int zzz(String paramString, int paramInt)
  {
    int i = paramInt;
    if (zzce(paramString))
    {
      i = paramInt;
      if (!zzcg(paramString)) {
        i = getInteger(paramString);
      }
    }
    return i;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */