package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public final class LoyaltyWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new zzj();
  private final int mVersionCode;
  int state;
  String zzaHT;
  String zzbcP;
  String zzbcQ;
  String zzbcR;
  String zzbcS;
  String zzbcT;
  String zzbcU;
  String zzbcV;
  String zzbcW;
  ArrayList<WalletObjectMessage> zzbcX;
  TimeInterval zzbcY;
  ArrayList<LatLng> zzbcZ;
  String zzbda;
  String zzbdb;
  ArrayList<LabelValueRow> zzbdc;
  boolean zzbdd;
  ArrayList<UriData> zzbde;
  ArrayList<TextModuleData> zzbdf;
  ArrayList<UriData> zzbdg;
  LoyaltyPoints zzbdh;
  String zzhL;
  
  LoyaltyWalletObject()
  {
    this.mVersionCode = 4;
    this.zzbcX = zzmj.zzqs();
    this.zzbcZ = zzmj.zzqs();
    this.zzbdc = zzmj.zzqs();
    this.zzbde = zzmj.zzqs();
    this.zzbdf = zzmj.zzqs();
    this.zzbdg = zzmj.zzqs();
  }
  
  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<WalletObjectMessage> paramArrayList, TimeInterval paramTimeInterval, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<LabelValueRow> paramArrayList2, boolean paramBoolean, ArrayList<UriData> paramArrayList3, ArrayList<TextModuleData> paramArrayList4, ArrayList<UriData> paramArrayList5, LoyaltyPoints paramLoyaltyPoints)
  {
    this.mVersionCode = paramInt1;
    this.zzhL = paramString1;
    this.zzbcP = paramString2;
    this.zzbcQ = paramString3;
    this.zzbcR = paramString4;
    this.zzaHT = paramString5;
    this.zzbcS = paramString6;
    this.zzbcT = paramString7;
    this.zzbcU = paramString8;
    this.zzbcV = paramString9;
    this.zzbcW = paramString10;
    this.state = paramInt2;
    this.zzbcX = paramArrayList;
    this.zzbcY = paramTimeInterval;
    this.zzbcZ = paramArrayList1;
    this.zzbda = paramString11;
    this.zzbdb = paramString12;
    this.zzbdc = paramArrayList2;
    this.zzbdd = paramBoolean;
    this.zzbde = paramArrayList3;
    this.zzbdf = paramArrayList4;
    this.zzbdg = paramArrayList5;
    this.zzbdh = paramLoyaltyPoints;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountId()
  {
    return this.zzbcP;
  }
  
  public String getAccountName()
  {
    return this.zzaHT;
  }
  
  public String getBarcodeAlternateText()
  {
    return this.zzbcS;
  }
  
  public String getBarcodeType()
  {
    return this.zzbcT;
  }
  
  public String getBarcodeValue()
  {
    return this.zzbcU;
  }
  
  public String getId()
  {
    return this.zzhL;
  }
  
  public String getIssuerName()
  {
    return this.zzbcQ;
  }
  
  public String getProgramName()
  {
    return this.zzbcR;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */