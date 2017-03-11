package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class SessionRegistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionRegistrationRequest> CREATOR = new zzw();
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final int zzasW;
  private final zzoj zzasb;
  
  SessionRegistrationRequest(int paramInt1, PendingIntent paramPendingIntent, IBinder paramIBinder, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.mPendingIntent = paramPendingIntent;
    if (paramIBinder == null) {}
    for (paramPendingIntent = null;; paramPendingIntent = zzoj.zza.zzbJ(paramIBinder))
    {
      this.zzasb = paramPendingIntent;
      this.zzasW = paramInt2;
      return;
    }
  }
  
  public SessionRegistrationRequest(PendingIntent paramPendingIntent, zzoj paramzzoj, int paramInt)
  {
    this.mVersionCode = 6;
    this.mPendingIntent = paramPendingIntent;
    this.zzasb = paramzzoj;
    this.zzasW = paramInt;
  }
  
  private boolean zzb(SessionRegistrationRequest paramSessionRegistrationRequest)
  {
    return (this.zzasW == paramSessionRegistrationRequest.zzasW) && (com.google.android.gms.common.internal.zzw.equal(this.mPendingIntent, paramSessionRegistrationRequest.mPendingIntent));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionRegistrationRequest)) && (zzb((SessionRegistrationRequest)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return com.google.android.gms.common.internal.zzw.hashCode(new Object[] { this.mPendingIntent, Integer.valueOf(this.zzasW) });
  }
  
  public String toString()
  {
    return com.google.android.gms.common.internal.zzw.zzv(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzasW)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzw.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public PendingIntent zzta()
  {
    return this.mPendingIntent;
  }
  
  public int zztj()
  {
    return this.zzasW;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SessionRegistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */