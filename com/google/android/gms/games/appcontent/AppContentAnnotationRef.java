package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef
  extends MultiDataBufferRef
  implements AppContentAnnotation
{
  AppContentAnnotationRef(ArrayList<DataHolder> paramArrayList, int paramInt)
  {
    super(paramArrayList, 2, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentAnnotationEntity.zza(this, paramObject);
  }
  
  public String getDescription()
  {
    return getString("annotation_description");
  }
  
  public String getId()
  {
    return getString("annotation_id");
  }
  
  public String getTitle()
  {
    return getString("annotation_title");
  }
  
  public int hashCode()
  {
    return AppContentAnnotationEntity.zza(this);
  }
  
  public String toString()
  {
    return AppContentAnnotationEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentAnnotationEntity)zztZ()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zztT()
  {
    return getString("annotation_image_default_id");
  }
  
  public int zztU()
  {
    return getInteger("annotation_image_height");
  }
  
  public Uri zztV()
  {
    return zzcf("annotation_image_uri");
  }
  
  public Bundle zztW()
  {
    return AppContentUtils.zzd(this.zzabq, this.zzauU, "annotation_modifiers", this.zzadl);
  }
  
  public int zztX()
  {
    return getInteger("annotation_image_width");
  }
  
  public String zztY()
  {
    return getString("annotation_layout_slot");
  }
  
  public AppContentAnnotation zztZ()
  {
    return new AppContentAnnotationEntity(this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentAnnotationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */