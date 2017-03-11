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
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;
import java.util.Arrays;
import java.util.List;

public class DataSourcesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzh();
  private final int mVersionCode;
  private final List<DataType> zzapW;
  private final List<Integer> zzast;
  private final boolean zzasu;
  private final zznv zzasv;
  
  DataSourcesRequest(int paramInt, List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzapW = paramList;
    this.zzast = paramList1;
    this.zzasu = paramBoolean;
    this.zzasv = zznv.zza.zzbv(paramIBinder);
  }
  
  private DataSourcesRequest(Builder paramBuilder)
  {
    this(zzmj.zzb(Builder.zza(paramBuilder)), Arrays.asList(zzmj.zza(Builder.zzb(paramBuilder))), Builder.zzc(paramBuilder), null);
  }
  
  public DataSourcesRequest(DataSourcesRequest paramDataSourcesRequest, zznv paramzznv)
  {
    this(paramDataSourcesRequest.zzapW, paramDataSourcesRequest.zzast, paramDataSourcesRequest.zzasu, paramzznv);
  }
  
  public DataSourcesRequest(List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean, zznv paramzznv)
  {
    this.mVersionCode = 4;
    this.zzapW = paramList;
    this.zzast = paramList1;
    this.zzasu = paramBoolean;
    this.zzasv = paramzznv;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzapW;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzv(this).zzg("dataTypes", this.zzapW).zzg("sourceTypes", this.zzast);
    if (this.zzasu) {
      localzza.zzg("includeDbOnlySources", "true");
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasv == null) {
      return null;
    }
    return this.zzasv.asBinder();
  }
  
  public List<Integer> zzsX()
  {
    return this.zzast;
  }
  
  public boolean zzsY()
  {
    return this.zzasu;
  }
  
  public static class Builder
  {
    private boolean zzasu = false;
    private DataType[] zzasw = new DataType[0];
    private int[] zzasx = { 0, 1 };
    
    public DataSourcesRequest build()
    {
      boolean bool2 = true;
      if (this.zzasw.length > 0)
      {
        bool1 = true;
        zzx.zza(bool1, "Must add at least one data type");
        if (this.zzasx.length <= 0) {
          break label49;
        }
      }
      label49:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must add at least one data source type");
        return new DataSourcesRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setDataSourceTypes(int... paramVarArgs)
    {
      this.zzasx = paramVarArgs;
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.zzasw = paramVarArgs;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DataSourcesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */