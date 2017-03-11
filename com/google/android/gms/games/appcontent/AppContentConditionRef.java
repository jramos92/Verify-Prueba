package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentConditionRef
  extends MultiDataBufferRef
  implements AppContentCondition
{
  AppContentConditionRef(ArrayList<DataHolder> paramArrayList, int paramInt)
  {
    super(paramArrayList, 4, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentConditionEntity.zza(this, paramObject);
  }
  
  public int hashCode()
  {
    return AppContentConditionEntity.zza(this);
  }
  
  public String toString()
  {
    return AppContentConditionEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentConditionEntity)zzuj()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zzuf()
  {
    return getString("condition_default_value");
  }
  
  public String zzug()
  {
    return getString("condition_expected_value");
  }
  
  public String zzuh()
  {
    return getString("condition_predicate");
  }
  
  public Bundle zzui()
  {
    return AppContentUtils.zzd(this.zzabq, this.zzauU, "condition_predicate_parameters", this.zzadl);
  }
  
  public AppContentCondition zzuj()
  {
    return new AppContentConditionEntity(this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentConditionRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */