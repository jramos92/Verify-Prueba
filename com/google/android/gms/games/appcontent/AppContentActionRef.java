package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef
  extends MultiDataBufferRef
  implements AppContentAction
{
  AppContentActionRef(ArrayList<DataHolder> paramArrayList, int paramInt)
  {
    super(paramArrayList, 1, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentActionEntity.zza(this, paramObject);
  }
  
  public Bundle getExtras()
  {
    return AppContentUtils.zzd(this.zzabq, this.zzauU, "action_data", this.zzadl);
  }
  
  public String getId()
  {
    return getString("action_id");
  }
  
  public String getType()
  {
    return getString("action_type");
  }
  
  public int hashCode()
  {
    return AppContentActionEntity.zza(this);
  }
  
  public String toString()
  {
    return AppContentActionEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentActionEntity)zztS()).writeToParcel(paramParcel, paramInt);
  }
  
  public AppContentAnnotation zztO()
  {
    ArrayList localArrayList = AppContentUtils.zzb(this.zzabq, this.zzauU, "action_annotation", this.zzadl);
    if (localArrayList.size() == 1) {
      return (AppContentAnnotation)localArrayList.get(0);
    }
    return null;
  }
  
  public List<AppContentCondition> zztP()
  {
    return AppContentUtils.zzc(this.zzabq, this.zzauU, "action_conditions", this.zzadl);
  }
  
  public String zztQ()
  {
    return getString("action_content_description");
  }
  
  public String zztR()
  {
    return getString("overflow_text");
  }
  
  public AppContentAction zztS()
  {
    return new AppContentActionEntity(this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentActionRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */