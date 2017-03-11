package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<CommonWalletObject> CREATOR = new zza();
  private final int mVersionCode;
  String name;
  int state;
  String zzbcQ;
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
  String zzhL;
  
  CommonWalletObject()
  {
    this.mVersionCode = 1;
    this.zzbcX = zzmj.zzqs();
    this.zzbcZ = zzmj.zzqs();
    this.zzbdc = zzmj.zzqs();
    this.zzbde = zzmj.zzqs();
    this.zzbdf = zzmj.zzqs();
    this.zzbdg = zzmj.zzqs();
  }
  
  CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList<WalletObjectMessage> paramArrayList, TimeInterval paramTimeInterval, ArrayList<LatLng> paramArrayList1, String paramString9, String paramString10, ArrayList<LabelValueRow> paramArrayList2, boolean paramBoolean, ArrayList<UriData> paramArrayList3, ArrayList<TextModuleData> paramArrayList4, ArrayList<UriData> paramArrayList5)
  {
    this.mVersionCode = paramInt1;
    this.zzhL = paramString1;
    this.zzbcW = paramString2;
    this.name = paramString3;
    this.zzbcQ = paramString4;
    this.zzbcS = paramString5;
    this.zzbcT = paramString6;
    this.zzbcU = paramString7;
    this.zzbcV = paramString8;
    this.state = paramInt2;
    this.zzbcX = paramArrayList;
    this.zzbcY = paramTimeInterval;
    this.zzbcZ = paramArrayList1;
    this.zzbda = paramString9;
    this.zzbdb = paramString10;
    this.zzbdc = paramArrayList2;
    this.zzbdd = paramBoolean;
    this.zzbde = paramArrayList3;
    this.zzbdf = paramArrayList4;
    this.zzbdg = paramArrayList5;
  }
  
  public static zza zzEI()
  {
    CommonWalletObject localCommonWalletObject = new CommonWalletObject();
    localCommonWalletObject.getClass();
    return new zza(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzhL;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public final class zza
  {
    private zza() {}
    
    public CommonWalletObject zzEJ()
    {
      return CommonWalletObject.this;
    }
    
    public zza zzfv(String paramString)
    {
      CommonWalletObject.this.zzhL = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\CommonWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */