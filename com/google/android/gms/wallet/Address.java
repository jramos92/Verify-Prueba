package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address
  implements SafeParcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new zza();
  private final int mVersionCode;
  String name;
  String phoneNumber;
  String zzGw;
  String zzaDk;
  String zzaDl;
  String zzaDm;
  String zzaDr;
  boolean zzaDt;
  String zzaDu;
  String zzbcg;
  String zzbch;
  
  Address()
  {
    this.mVersionCode = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    this.mVersionCode = paramInt;
    this.name = paramString1;
    this.zzaDk = paramString2;
    this.zzaDl = paramString3;
    this.zzaDm = paramString4;
    this.zzGw = paramString5;
    this.zzbcg = paramString6;
    this.zzbch = paramString7;
    this.zzaDr = paramString8;
    this.phoneNumber = paramString9;
    this.zzaDt = paramBoolean;
    this.zzaDu = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress1()
  {
    return this.zzaDk;
  }
  
  public String getAddress2()
  {
    return this.zzaDl;
  }
  
  public String getAddress3()
  {
    return this.zzaDm;
  }
  
  public String getCity()
  {
    return this.zzbcg;
  }
  
  public String getCompanyName()
  {
    return this.zzaDu;
  }
  
  public String getCountryCode()
  {
    return this.zzGw;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }
  
  public String getPostalCode()
  {
    return this.zzaDr;
  }
  
  public String getState()
  {
    return this.zzbch;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean isPostBox()
  {
    return this.zzaDt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */