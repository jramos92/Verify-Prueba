package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;

public class Subscription
  implements SafeParcelable
{
  public static final Parcelable.Creator<Subscription> CREATOR = new zzr();
  private final int mVersionCode;
  private final DataType zzapL;
  private final DataSource zzapM;
  private final long zzarc;
  private final int zzard;
  
  Subscription(int paramInt1, DataSource paramDataSource, DataType paramDataType, long paramLong, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzapM = paramDataSource;
    this.zzapL = paramDataType;
    this.zzarc = paramLong;
    this.zzard = paramInt2;
  }
  
  private Subscription(zza paramzza)
  {
    this.mVersionCode = 1;
    this.zzapL = zza.zza(paramzza);
    this.zzapM = zza.zzb(paramzza);
    this.zzarc = zza.zzc(paramzza);
    this.zzard = zza.zzd(paramzza);
  }
  
  private boolean zza(Subscription paramSubscription)
  {
    return (zzw.equal(this.zzapM, paramSubscription.zzapM)) && (zzw.equal(this.zzapL, paramSubscription.zzapL)) && (this.zzarc == paramSubscription.zzarc) && (this.zzard == paramSubscription.zzard);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Subscription)) && (zza((Subscription)paramObject)));
  }
  
  public int getAccuracyMode()
  {
    return this.zzard;
  }
  
  public DataSource getDataSource()
  {
    return this.zzapM;
  }
  
  public DataType getDataType()
  {
    return this.zzapL;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapM, this.zzapM, Long.valueOf(this.zzarc), Integer.valueOf(this.zzard) });
  }
  
  public String toDebugString()
  {
    if (this.zzapM == null) {}
    for (String str = this.zzapL.getName();; str = this.zzapM.toDebugString()) {
      return String.format("Subscription{%s}", new Object[] { str });
    }
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("dataSource", this.zzapM).zzg("dataType", this.zzapL).zzg("samplingIntervalMicros", Long.valueOf(this.zzarc)).zzg("accuracyMode", Integer.valueOf(this.zzard)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
  
  public long zzsB()
  {
    return this.zzarc;
  }
  
  public DataType zzsC()
  {
    if (this.zzapL == null) {
      return this.zzapM.getDataType();
    }
    return this.zzapL;
  }
  
  public static class zza
  {
    private DataType zzapL;
    private DataSource zzapM;
    private long zzarc = -1L;
    private int zzard = 2;
    
    public zza zzb(DataSource paramDataSource)
    {
      this.zzapM = paramDataSource;
      return this;
    }
    
    public zza zzb(DataType paramDataType)
    {
      this.zzapL = paramDataType;
      return this;
    }
    
    public Subscription zzsD()
    {
      boolean bool2 = false;
      if ((this.zzapM != null) || (this.zzapL != null)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        zzx.zza(bool1, "Must call setDataSource() or setDataType()");
        if ((this.zzapL != null) && (this.zzapM != null))
        {
          bool1 = bool2;
          if (!this.zzapL.equals(this.zzapM.getDataType())) {}
        }
        else
        {
          bool1 = true;
        }
        zzx.zza(bool1, "Specified data type is incompatible with specified data source");
        return new Subscription(this, null);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\Subscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */