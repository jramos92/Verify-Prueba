package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

public class GetServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzi();
  final int version;
  final int zzafq;
  int zzafr;
  String zzafs;
  IBinder zzaft;
  Scope[] zzafu;
  Bundle zzafv;
  Account zzafw;
  
  public GetServiceRequest(int paramInt)
  {
    this.version = 2;
    this.zzafr = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzafq = paramInt;
  }
  
  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount)
  {
    this.version = paramInt1;
    this.zzafq = paramInt2;
    this.zzafr = paramInt3;
    this.zzafs = paramString;
    if (paramInt1 < 2) {}
    for (this.zzafw = zzaG(paramIBinder);; this.zzafw = paramAccount)
    {
      this.zzafu = paramArrayOfScope;
      this.zzafv = paramBundle;
      return;
      this.zzaft = paramIBinder;
    }
  }
  
  private Account zzaG(IBinder paramIBinder)
  {
    Account localAccount = null;
    if (paramIBinder != null) {
      localAccount = zza.zzb(zzp.zza.zzaH(paramIBinder));
    }
    return localAccount;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public GetServiceRequest zzc(Account paramAccount)
  {
    this.zzafw = paramAccount;
    return this;
  }
  
  public GetServiceRequest zzc(zzp paramzzp)
  {
    if (paramzzp != null) {
      this.zzaft = paramzzp.asBinder();
    }
    return this;
  }
  
  public GetServiceRequest zzcl(String paramString)
  {
    this.zzafs = paramString;
    return this;
  }
  
  public GetServiceRequest zzd(Collection<Scope> paramCollection)
  {
    this.zzafu = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    return this;
  }
  
  public GetServiceRequest zzg(Bundle paramBundle)
  {
    this.zzafv = paramBundle;
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\internal\GetServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */