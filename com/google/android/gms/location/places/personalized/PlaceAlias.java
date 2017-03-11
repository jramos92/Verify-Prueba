package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class PlaceAlias
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public static final PlaceAlias zzaHY = new PlaceAlias(0, "Home");
  public static final PlaceAlias zzaHZ = new PlaceAlias(0, "Work");
  final int mVersionCode;
  private final String zzaIa;
  
  PlaceAlias(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaIa = paramString;
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof PlaceAlias)) {
      return false;
    }
    paramObject = (PlaceAlias)paramObject;
    return zzw.equal(this.zzaIa, ((PlaceAlias)paramObject).zzaIa);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaIa });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("alias", this.zzaIa).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public String zzxq()
  {
    return this.zzaIa;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\personalized\PlaceAlias.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */