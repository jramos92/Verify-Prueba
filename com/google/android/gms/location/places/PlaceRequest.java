package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzk();
  static final long zzaGv = TimeUnit.HOURS.toMillis(1L);
  private final int mPriority;
  final int mVersionCode;
  private final long zzaEE;
  private final long zzaEj;
  private final PlaceFilter zzaGw;
  
  public PlaceRequest(int paramInt1, PlaceFilter paramPlaceFilter, long paramLong1, int paramInt2, long paramLong2)
  {
    this.mVersionCode = paramInt1;
    this.zzaGw = paramPlaceFilter;
    this.zzaEE = paramLong1;
    this.mPriority = paramInt2;
    this.zzaEj = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceRequest)) {
        return false;
      }
      paramObject = (PlaceRequest)paramObject;
    } while ((zzw.equal(this.zzaGw, ((PlaceRequest)paramObject).zzaGw)) && (this.zzaEE == ((PlaceRequest)paramObject).zzaEE) && (this.mPriority == ((PlaceRequest)paramObject).mPriority) && (this.zzaEj == ((PlaceRequest)paramObject).zzaEj));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.zzaEj;
  }
  
  public long getInterval()
  {
    return this.zzaEE;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaGw, Long.valueOf(this.zzaEE), Integer.valueOf(this.mPriority), Long.valueOf(this.zzaEj) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("filter", this.zzaGw).zzg("interval", Long.valueOf(this.zzaEE)).zzg("priority", Integer.valueOf(this.mPriority)).zzg("expireAt", Long.valueOf(this.zzaEj)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public PlaceFilter zzwO()
  {
    return this.zzaGw;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\PlaceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */