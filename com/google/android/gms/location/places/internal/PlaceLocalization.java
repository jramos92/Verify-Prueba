package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.List;

@Deprecated
public final class PlaceLocalization
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  public final String address;
  public final String name;
  public final int versionCode;
  public final String zzaHC;
  public final String zzaHD;
  public final List<String> zzaHE;
  
  public PlaceLocalization(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.address = paramString2;
    this.zzaHC = paramString3;
    this.zzaHD = paramString4;
    this.zzaHE = paramList;
  }
  
  public static PlaceLocalization zza(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    return new PlaceLocalization(0, paramString1, paramString2, paramString3, paramString4, paramList);
  }
  
  public int describeContents()
  {
    zzo localzzo = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceLocalization)) {
        return false;
      }
      paramObject = (PlaceLocalization)paramObject;
    } while ((zzw.equal(this.name, ((PlaceLocalization)paramObject).name)) && (zzw.equal(this.address, ((PlaceLocalization)paramObject).address)) && (zzw.equal(this.zzaHC, ((PlaceLocalization)paramObject).zzaHC)) && (zzw.equal(this.zzaHD, ((PlaceLocalization)paramObject).zzaHD)) && (zzw.equal(this.zzaHE, ((PlaceLocalization)paramObject).zzaHE)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.name, this.address, this.zzaHC, this.zzaHD });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("name", this.name).zzg("address", this.address).zzg("internationalPhoneNumber", this.zzaHC).zzg("regularOpenHours", this.zzaHD).zzg("attributions", this.zzaHE).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\PlaceLocalization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */