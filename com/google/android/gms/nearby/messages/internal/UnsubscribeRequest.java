package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UnsubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzr();
  final int mVersionCode;
  public final zzc zzaQG;
  public final String zzaQe;
  public final String zzaRa;
  public final zzb zzaRe;
  public final PendingIntent zzaRg;
  public final int zzaRh;
  
  UnsubscribeRequest(int paramInt1, IBinder paramIBinder1, IBinder paramIBinder2, PendingIntent paramPendingIntent, int paramInt2, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.zzaRe = zzb.zza.zzdk(paramIBinder1);
    this.zzaQG = zzc.zza.zzdl(paramIBinder2);
    this.zzaRg = paramPendingIntent;
    this.zzaRh = paramInt2;
    this.zzaQe = paramString1;
    this.zzaRa = paramString2;
  }
  
  UnsubscribeRequest(IBinder paramIBinder1, IBinder paramIBinder2, PendingIntent paramPendingIntent, int paramInt, String paramString1, String paramString2)
  {
    this(1, paramIBinder1, paramIBinder2, paramPendingIntent, paramInt, paramString1, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaQG.asBinder();
  }
  
  IBinder zzBg()
  {
    if (this.zzaRe == null) {
      return null;
    }
    return this.zzaRe.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\UnsubscribeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */