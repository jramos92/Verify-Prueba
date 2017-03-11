package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();
  private final int mVersionCode;
  String name;
  String phoneNumber;
  String zzGw;
  String zzaDk;
  String zzaDl;
  String zzaDm;
  String zzaDn;
  String zzaDo;
  String zzaDp;
  String zzaDq;
  String zzaDr;
  String zzaDs;
  boolean zzaDt;
  String zzaDu;
  String zzaDv;
  
  UserAddress()
  {
    this.mVersionCode = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    this.mVersionCode = paramInt;
    this.name = paramString1;
    this.zzaDk = paramString2;
    this.zzaDl = paramString3;
    this.zzaDm = paramString4;
    this.zzaDn = paramString5;
    this.zzaDo = paramString6;
    this.zzaDp = paramString7;
    this.zzaDq = paramString8;
    this.zzGw = paramString9;
    this.zzaDr = paramString10;
    this.zzaDs = paramString11;
    this.phoneNumber = paramString12;
    this.zzaDt = paramBoolean;
    this.zzaDu = paramString13;
    this.zzaDv = paramString14;
  }
  
  public static UserAddress fromIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"))) {
      return null;
    }
    return (UserAddress)paramIntent.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS");
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
  
  public String getAddress4()
  {
    return this.zzaDn;
  }
  
  public String getAddress5()
  {
    return this.zzaDo;
  }
  
  public String getAdministrativeArea()
  {
    return this.zzaDp;
  }
  
  public String getCompanyName()
  {
    return this.zzaDu;
  }
  
  public String getCountryCode()
  {
    return this.zzGw;
  }
  
  public String getEmailAddress()
  {
    return this.zzaDv;
  }
  
  public String getLocality()
  {
    return this.zzaDq;
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
  
  public String getSortingCode()
  {
    return this.zzaDs;
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
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\identity\intents\model\UserAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */