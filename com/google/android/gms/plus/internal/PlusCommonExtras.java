package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private final int mVersionCode;
  private String zzaSu;
  private String zzaSv;
  
  public PlusCommonExtras()
  {
    this.mVersionCode = 1;
    this.zzaSu = "";
    this.zzaSv = "";
  }
  
  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzaSu = paramString1;
    this.zzaSv = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusCommonExtras)) {}
    do
    {
      return false;
      paramObject = (PlusCommonExtras)paramObject;
    } while ((this.mVersionCode != ((PlusCommonExtras)paramObject).mVersionCode) || (!zzw.equal(this.zzaSu, ((PlusCommonExtras)paramObject).zzaSu)) || (!zzw.equal(this.zzaSv, ((PlusCommonExtras)paramObject).zzaSv)));
    return true;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.zzaSu, this.zzaSv });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("Gpsrc", this.zzaSu).zzg("ClientCallingPackage", this.zzaSv).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public void zzB(Bundle paramBundle)
  {
    paramBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", zzc.zza(this));
  }
  
  public String zzBA()
  {
    return this.zzaSu;
  }
  
  public String zzBB()
  {
    return this.zzaSv;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\PlusCommonExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */