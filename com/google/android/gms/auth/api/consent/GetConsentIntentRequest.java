package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class GetConsentIntentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetConsentIntentRequest> CREATOR = new zzb();
  private final int mVersionCode;
  private final Account zzQd;
  private final String zzSb;
  private final int zzSc;
  private final String zzSd;
  final ScopeDetail[] zzSe;
  private final boolean zzSf;
  private final int zzSg;
  
  GetConsentIntentRequest(int paramInt1, String paramString1, int paramInt2, String paramString2, Account paramAccount, ScopeDetail[] paramArrayOfScopeDetail, boolean paramBoolean, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzSb = paramString1;
    this.zzSc = paramInt2;
    this.zzSd = paramString2;
    this.zzQd = ((Account)zzx.zzw(paramAccount));
    this.zzSe = paramArrayOfScopeDetail;
    this.zzSf = paramBoolean;
    this.zzSg = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return this.zzQd;
  }
  
  public String getCallingPackage()
  {
    return this.zzSb;
  }
  
  public int getCallingUid()
  {
    return this.zzSc;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzlF()
  {
    return this.zzSd;
  }
  
  public boolean zzlG()
  {
    return this.zzSf;
  }
  
  public int zzlH()
  {
    return this.zzSg;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\consent\GetConsentIntentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */