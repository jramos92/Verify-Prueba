package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class Strategy
  implements SafeParcelable
{
  public static final Strategy BLE_ONLY = new Builder().zziz(2).setTtlSeconds(Integer.MAX_VALUE).build();
  public static final Parcelable.Creator<Strategy> CREATOR = new zzd();
  public static final Strategy DEFAULT = new Builder().build();
  public static final int DISCOVERY_MODE_BROADCAST = 1;
  public static final int DISCOVERY_MODE_DEFAULT = 3;
  public static final int DISCOVERY_MODE_SCAN = 2;
  public static final int DISTANCE_TYPE_DEFAULT = 0;
  public static final int DISTANCE_TYPE_EARSHOT = 1;
  public static final int TTL_SECONDS_DEFAULT = 300;
  public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
  public static final int TTL_SECONDS_MAX = 86400;
  @Deprecated
  public static final Strategy zzaQi = BLE_ONLY;
  final int mVersionCode;
  @Deprecated
  final int zzaQj;
  final int zzaQk;
  final int zzaQl;
  @Deprecated
  final boolean zzaQm;
  final int zzaQn;
  final int zzaQo;
  
  Strategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    this.mVersionCode = paramInt1;
    this.zzaQj = paramInt2;
    if (paramInt2 == 0) {
      this.zzaQo = paramInt6;
    }
    for (;;)
    {
      this.zzaQl = paramInt4;
      this.zzaQm = paramBoolean;
      if (!paramBoolean) {
        break;
      }
      this.zzaQn = 2;
      this.zzaQk = Integer.MAX_VALUE;
      return;
      switch (paramInt2)
      {
      default: 
        this.zzaQo = 3;
        break;
      case 2: 
        this.zzaQo = 1;
        break;
      case 3: 
        this.zzaQo = 2;
      }
    }
    if (paramInt5 == 0)
    {
      this.zzaQn = 1;
      this.zzaQk = paramInt3;
      return;
    }
    this.zzaQn = paramInt5;
    this.zzaQk = paramInt3;
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
      if (!(paramObject instanceof Strategy)) {
        return false;
      }
      paramObject = (Strategy)paramObject;
    } while ((this.mVersionCode == ((Strategy)paramObject).mVersionCode) && (this.zzaQo == ((Strategy)paramObject).zzaQo) && (this.zzaQk == ((Strategy)paramObject).zzaQk) && (this.zzaQl == ((Strategy)paramObject).zzaQl) && (this.zzaQn == ((Strategy)paramObject).zzaQn));
    return false;
  }
  
  public int hashCode()
  {
    return (((this.mVersionCode * 31 + this.zzaQo) * 31 + this.zzaQk) * 31 + this.zzaQl) * 31 + this.zzaQn;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private int zzaQp = 3;
    private int zzaQq = 300;
    private int zzaQr = 0;
    private int zzaQs = 1;
    
    public Strategy build()
    {
      if (this.zzaQs == 2)
      {
        if (this.zzaQp != 3) {
          throw new IllegalStateException("Discovery mode must be DISCOVERY_MODE_DEFAULT.");
        }
        if (this.zzaQr == 1) {
          throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
        }
      }
      return new Strategy(2, 0, this.zzaQq, this.zzaQr, false, this.zzaQs, this.zzaQp);
    }
    
    public Builder setDiscoveryMode(int paramInt)
    {
      this.zzaQp = paramInt;
      return this;
    }
    
    public Builder setDistanceType(int paramInt)
    {
      this.zzaQr = paramInt;
      return this;
    }
    
    public Builder setTtlSeconds(int paramInt)
    {
      if ((paramInt == Integer.MAX_VALUE) || ((paramInt > 0) && (paramInt <= 86400))) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(86400) });
        this.zzaQq = paramInt;
        return this;
      }
    }
    
    public Builder zziz(int paramInt)
    {
      this.zzaQs = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\Strategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */