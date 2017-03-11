package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

public class EventParams
  implements SafeParcelable, Iterable<String>
{
  public static final zzi CREATOR = new zzi();
  public final int versionCode;
  private final Bundle zzaMh;
  
  EventParams(int paramInt, Bundle paramBundle)
  {
    this.versionCode = paramInt;
    this.zzaMh = paramBundle;
  }
  
  EventParams(Bundle paramBundle)
  {
    zzx.zzw(paramBundle);
    this.zzaMh = paramBundle;
    this.versionCode = 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  Object get(String paramString)
  {
    return this.zzaMh.get(paramString);
  }
  
  public Iterator iterator()
  {
    new Iterator()
    {
      Iterator<String> zzaMi = EventParams.zza(EventParams.this).keySet().iterator();
      
      public boolean hasNext()
      {
        return this.zzaMi.hasNext();
      }
      
      public String next()
      {
        return (String)this.zzaMi.next();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Remove not supported");
      }
    };
  }
  
  public int size()
  {
    return this.zzaMh.size();
  }
  
  public String toString()
  {
    return this.zzaMh.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzzB()
  {
    return new Bundle(this.zzaMh);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\EventParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */