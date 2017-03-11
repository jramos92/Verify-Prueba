package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Set;

public class AuthAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzc();
  final int mVersionCode;
  final IBinder zzaeH;
  final Scope[] zzaeI;
  
  AuthAccountRequest(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope)
  {
    this.mVersionCode = paramInt;
    this.zzaeH = paramIBinder;
    this.zzaeI = paramArrayOfScope;
  }
  
  public AuthAccountRequest(zzp paramzzp, Set<Scope> paramSet)
  {
    this(1, paramzzp.asBinder(), (Scope[])paramSet.toArray(new Scope[paramSet.size()]));
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\internal\AuthAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */