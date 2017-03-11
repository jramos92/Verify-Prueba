package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.List;

public class PlaceUserData
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  final int mVersionCode;
  private final String zzRs;
  private final String zzaGt;
  private final List<TestDataImpl> zzaIb;
  private final List<PlaceAlias> zzaIc;
  private final List<HereContent> zzaId;
  
  PlaceUserData(int paramInt, String paramString1, String paramString2, List<TestDataImpl> paramList, List<PlaceAlias> paramList1, List<HereContent> paramList2)
  {
    this.mVersionCode = paramInt;
    this.zzRs = paramString1;
    this.zzaGt = paramString2;
    this.zzaIb = paramList;
    this.zzaIc = paramList1;
    this.zzaId = paramList2;
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceUserData)) {
        return false;
      }
      paramObject = (PlaceUserData)paramObject;
    } while ((this.zzRs.equals(((PlaceUserData)paramObject).zzRs)) && (this.zzaGt.equals(((PlaceUserData)paramObject).zzaGt)) && (this.zzaIb.equals(((PlaceUserData)paramObject).zzaIb)) && (this.zzaIc.equals(((PlaceUserData)paramObject).zzaIc)) && (this.zzaId.equals(((PlaceUserData)paramObject).zzaId)));
    return false;
  }
  
  public String getPlaceId()
  {
    return this.zzaGt;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzRs, this.zzaGt, this.zzaIb, this.zzaIc, this.zzaId });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("accountName", this.zzRs).zzg("placeId", this.zzaGt).zzg("testDataImpls", this.zzaIb).zzg("placeAliases", this.zzaIc).zzg("hereContents", this.zzaId).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
  
  public String zzxr()
  {
    return this.zzRs;
  }
  
  public List<PlaceAlias> zzxs()
  {
    return this.zzaIc;
  }
  
  public List<HereContent> zzxt()
  {
    return this.zzaId;
  }
  
  public List<TestDataImpl> zzxu()
  {
    return this.zzaIb;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\personalized\PlaceUserData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */