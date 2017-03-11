package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Locale;

public class PlacesParams
  implements SafeParcelable
{
  public static final zzt CREATOR = new zzt();
  public static final PlacesParams zzaHQ = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
  public final int versionCode;
  public final String zzaGG;
  public final String zzaHR;
  public final String zzaHS;
  public final String zzaHT;
  public final String zzaHU;
  public final int zzaHV;
  
  public PlacesParams(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    this.versionCode = paramInt1;
    this.zzaHR = paramString1;
    this.zzaHS = paramString2;
    this.zzaHT = paramString3;
    this.zzaGG = paramString4;
    this.zzaHU = paramString5;
    this.zzaHV = paramInt2;
  }
  
  public PlacesParams(String paramString1, Locale paramLocale, String paramString2)
  {
    this(1, paramString1, paramLocale.toString(), paramString2, null, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  public PlacesParams(String paramString1, Locale paramLocale, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramLocale.toString(), paramString2, paramString3, paramString4, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  public int describeContents()
  {
    zzt localzzt = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof PlacesParams))) {
        return false;
      }
      paramObject = (PlacesParams)paramObject;
    } while ((this.zzaHS.equals(((PlacesParams)paramObject).zzaHS)) && (this.zzaHR.equals(((PlacesParams)paramObject).zzaHR)) && (zzw.equal(this.zzaHT, ((PlacesParams)paramObject).zzaHT)) && (zzw.equal(this.zzaGG, ((PlacesParams)paramObject).zzaGG)) && (zzw.equal(this.zzaHU, ((PlacesParams)paramObject).zzaHU)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaHR, this.zzaHS, this.zzaHT, this.zzaGG, this.zzaHU });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("clientPackageName", this.zzaHR).zzg("locale", this.zzaHS).zzg("accountName", this.zzaHT).zzg("gCoreClientName", this.zzaGG).zzg("chargedPackageName", this.zzaHU).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt localzzt = CREATOR;
    zzt.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\PlacesParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */