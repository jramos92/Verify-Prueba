package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  String description;
  final int version;
  String zzTH;
  String zzTI;
  String zzTJ;
  String zzTK;
  List<String> zzTL;
  public FACLData zzTM;
  
  ScopeDetail(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, FACLData paramFACLData)
  {
    this.version = paramInt;
    this.description = paramString1;
    this.zzTH = paramString2;
    this.zzTI = paramString3;
    this.zzTJ = paramString4;
    this.zzTK = paramString5;
    this.zzTL = paramList;
    this.zzTM = paramFACLData;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\firstparty\shared\ScopeDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */