package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import java.util.Set;

public class LogEvent
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final String tag;
  public final int versionCode;
  public final long zzaRG;
  public final long zzaRH;
  public final byte[] zzaRI;
  public final Bundle zzaRJ;
  
  LogEvent(int paramInt, long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.versionCode = paramInt;
    this.zzaRG = paramLong1;
    this.zzaRH = paramLong2;
    this.tag = paramString;
    this.zzaRI = paramArrayOfByte;
    this.zzaRJ = paramBundle;
  }
  
  public LogEvent(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    this.versionCode = 1;
    this.zzaRG = paramLong1;
    this.zzaRH = paramLong2;
    this.tag = paramString;
    this.zzaRI = paramArrayOfByte;
    this.zzaRJ = zzd(paramVarArgs);
  }
  
  private static Bundle zzd(String... paramVarArgs)
  {
    Object localObject = null;
    if (paramVarArgs == null) {}
    int j;
    do
    {
      return (Bundle)localObject;
      if (paramVarArgs.length % 2 != 0) {
        throw new IllegalArgumentException("extras must have an even number of elements");
      }
      j = paramVarArgs.length / 2;
    } while (j == 0);
    Bundle localBundle = new Bundle(j);
    int i = 0;
    for (;;)
    {
      localObject = localBundle;
      if (i >= j) {
        break;
      }
      localBundle.putString(paramVarArgs[(i * 2)], paramVarArgs[(i * 2 + 1)]);
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag=").append(this.tag).append(",");
    localStringBuilder.append("eventTime=").append(this.zzaRG).append(",");
    localStringBuilder.append("eventUptime=").append(this.zzaRH).append(",");
    if ((this.zzaRJ != null) && (!this.zzaRJ.isEmpty()))
    {
      localStringBuilder.append("keyValues=");
      Iterator localIterator = this.zzaRJ.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("(").append(str).append(",");
        localStringBuilder.append(this.zzaRJ.getString(str)).append(")");
        localStringBuilder.append(" ");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\playlog\internal\LogEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */