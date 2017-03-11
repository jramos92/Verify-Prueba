package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzaa();
  private final int mVersionCode;
  private final List<DataType> zzapW;
  private final zzn zzasY;
  private final int zzasZ;
  private final zzoj zzasb;
  
  StartBleScanRequest(int paramInt1, List<DataType> paramList, IBinder paramIBinder1, int paramInt2, IBinder paramIBinder2)
  {
    this.mVersionCode = paramInt1;
    this.zzapW = paramList;
    this.zzasY = zzn.zza.zzbM(paramIBinder1);
    this.zzasZ = paramInt2;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder2);
  }
  
  private StartBleScanRequest(Builder paramBuilder)
  {
    this(zzmj.zzb(Builder.zza(paramBuilder)), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), null);
  }
  
  public StartBleScanRequest(StartBleScanRequest paramStartBleScanRequest, zzoj paramzzoj)
  {
    this(paramStartBleScanRequest.zzapW, paramStartBleScanRequest.zzasY, paramStartBleScanRequest.zzasZ, paramzzoj);
  }
  
  public StartBleScanRequest(List<DataType> paramList, zzn paramzzn, int paramInt, zzoj paramzzoj)
  {
    this.mVersionCode = 4;
    this.zzapW = paramList;
    this.zzasY = paramzzn;
    this.zzasZ = paramInt;
    this.zzasb = paramzzoj;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.zzapW);
  }
  
  public int getTimeoutSecs()
  {
    return this.zzasZ;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("dataTypes", this.zzapW).zzg("timeoutSecs", Integer.valueOf(this.zzasZ)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaa.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public IBinder zztk()
  {
    return this.zzasY.asBinder();
  }
  
  public static class Builder
  {
    private zzn zzasY;
    private int zzasZ = 10;
    private DataType[] zzasw = new DataType[0];
    
    public StartBleScanRequest build()
    {
      if (this.zzasY != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Must set BleScanCallback");
        return new StartBleScanRequest(this, null);
      }
    }
    
    public Builder setBleScanCallback(BleScanCallback paramBleScanCallback)
    {
      zza(zza.zza.zzsM().zza(paramBleScanCallback));
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.zzasw = paramVarArgs;
      return this;
    }
    
    public Builder setTimeoutSecs(int paramInt)
    {
      boolean bool2 = true;
      if (paramInt > 0)
      {
        bool1 = true;
        zzx.zzb(bool1, "Stop time must be greater than zero");
        if (paramInt > 60) {
          break label40;
        }
      }
      label40:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Stop time must be less than 1 minute");
        this.zzasZ = paramInt;
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder zza(zzn paramzzn)
    {
      this.zzasY = paramzzn;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\StartBleScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */