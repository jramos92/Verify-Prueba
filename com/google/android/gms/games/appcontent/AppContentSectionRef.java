package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentSectionRef
  extends MultiDataBufferRef
  implements AppContentSection
{
  private final int zzauX;
  
  AppContentSectionRef(ArrayList<DataHolder> paramArrayList, int paramInt1, int paramInt2)
  {
    super(paramArrayList, 0, paramInt1);
    this.zzauX = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentSectionEntity.zza(this, paramObject);
  }
  
  public Bundle getExtras()
  {
    return AppContentUtils.zzd(this.zzabq, this.zzauU, "section_data", this.zzadl);
  }
  
  public String getId()
  {
    return getString("section_id");
  }
  
  public String getTitle()
  {
    return getString("section_title");
  }
  
  public String getType()
  {
    return getString("section_type");
  }
  
  public int hashCode()
  {
    return AppContentSectionEntity.zza(this);
  }
  
  public String toString()
  {
    return AppContentSectionEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentSectionEntity)zzum()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zztQ()
  {
    return getString("section_content_description");
  }
  
  public String zzuc()
  {
    return getString("section_subtitle");
  }
  
  public String zzul()
  {
    return getString("section_card_type");
  }
  
  public AppContentSection zzum()
  {
    return new AppContentSectionEntity(this);
  }
  
  public ArrayList<AppContentAction> zzun()
  {
    return AppContentUtils.zza(this.zzabq, this.zzauU, "section_actions", this.zzadl);
  }
  
  public ArrayList<AppContentAnnotation> zzuo()
  {
    return AppContentUtils.zzb(this.zzabq, this.zzauU, "section_annotations", this.zzadl);
  }
  
  public ArrayList<AppContentCard> zzup()
  {
    ArrayList localArrayList = new ArrayList(this.zzauX);
    int i = 0;
    while (i < this.zzauX)
    {
      localArrayList.add(new AppContentCardRef(this.zzauU, this.zzadl + i));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentSectionRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */