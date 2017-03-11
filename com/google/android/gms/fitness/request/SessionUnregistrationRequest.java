package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class SessionUnregistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionUnregistrationRequest> CREATOR = new zzz();
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final zzoj zzasb;
  
  SessionUnregistrationRequest(int paramInt, PendingIntent paramPendingIntent, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.mPendingIntent = paramPendingIntent;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public SessionUnregistrationRequest(PendingIntent paramPendingIntent, zzoj paramzzoj)
  {
    this.mVersionCode = 5;
    this.mPendingIntent = paramPendingIntent;
    this.zzasb = paramzzoj;
  }
  
  private boolean zzb(SessionUnregistrationRequest paramSessionUnregistrationRequest)
  {
    return zzw.equal(this.mPendingIntent, paramSessionUnregistrationRequest.mPendingIntent);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionUnregistrationRequest)) && (zzb((SessionUnregistrationRequest)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mPendingIntent });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("pendingIntent", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzz.zza(this, paramParcel, paramInt);
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
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SessionUnregistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */