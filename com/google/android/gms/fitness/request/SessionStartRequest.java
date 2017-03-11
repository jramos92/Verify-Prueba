package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class SessionStartRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionStartRequest> CREATOR = new zzx();
  private final int mVersionCode;
  private final Session zzapP;
  private final zzoj zzasb;
  
  SessionStartRequest(int paramInt, Session paramSession, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzapP = paramSession;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public SessionStartRequest(Session paramSession, zzoj paramzzoj)
  {
    com.google.android.gms.common.internal.zzx.zzb(paramSession.isOngoing(), "Cannot start a session which has already ended");
    this.mVersionCode = 3;
    this.zzapP = paramSession;
    this.zzasb = paramzzoj;
  }
  
  private boolean zzb(SessionStartRequest paramSessionStartRequest)
  {
    return zzw.equal(this.zzapP, paramSessionStartRequest.zzapP);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionStartRequest)) && (zzb((SessionStartRequest)paramObject)));
  }
  
  public Session getSession()
  {
    return this.zzapP;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapP });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("session", this.zzapP).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzx.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SessionStartRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */