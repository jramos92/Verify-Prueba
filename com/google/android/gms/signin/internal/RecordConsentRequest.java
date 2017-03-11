package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzg();
  final int mVersionCode;
  private final Account zzQd;
  private final String zzTl;
  private final Scope[] zzaVk;
  
  RecordConsentRequest(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzQd = paramAccount;
    this.zzaVk = paramArrayOfScope;
    this.zzTl = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return this.zzQd;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public Scope[] zzCj()
  {
    return this.zzaVk;
  }
  
  public String zzmb()
  {
    return this.zzTl;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\signin\internal\RecordConsentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */