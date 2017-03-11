package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public final class SubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzp();
  final int mVersionCode;
  public final zzc zzaQG;
  public final Strategy zzaQZ;
  public final String zzaQe;
  public final boolean zzaQf;
  public final String zzaRa;
  public final zzb zzaRe;
  public final MessageFilter zzaRf;
  public final PendingIntent zzaRg;
  public final int zzaRh;
  public final byte[] zzaRi;
  public final zzg zzaRj;
  
  SubscribeRequest(int paramInt1, IBinder paramIBinder1, Strategy paramStrategy, IBinder paramIBinder2, MessageFilter paramMessageFilter, PendingIntent paramPendingIntent, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, IBinder paramIBinder3)
  {
    this.mVersionCode = paramInt1;
    this.zzaRe = zzb.zza.zzdk(paramIBinder1);
    this.zzaQZ = paramStrategy;
    this.zzaQG = zzc.zza.zzdl(paramIBinder2);
    this.zzaRf = paramMessageFilter;
    this.zzaRg = paramPendingIntent;
    this.zzaRh = paramInt2;
    this.zzaQe = paramString1;
    this.zzaRa = paramString2;
    this.zzaRi = paramArrayOfByte;
    this.zzaQf = paramBoolean;
    if (paramIBinder3 == null) {}
    for (paramIBinder1 = null;; paramIBinder1 = zzg.zza.zzdp(paramIBinder3))
    {
      this.zzaRj = paramIBinder1;
      return;
    }
  }
  
  public SubscribeRequest(IBinder paramIBinder1, Strategy paramStrategy, IBinder paramIBinder2, MessageFilter paramMessageFilter, PendingIntent paramPendingIntent, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, IBinder paramIBinder3)
  {
    this(3, paramIBinder1, paramStrategy, paramIBinder2, paramMessageFilter, paramPendingIntent, paramInt, paramString1, paramString2, paramArrayOfByte, paramBoolean, paramIBinder3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    if (this.zzaQG == null) {
      return null;
    }
    return this.zzaQG.asBinder();
  }
  
  IBinder zzBg()
  {
    if (this.zzaRe == null) {
      return null;
    }
    return this.zzaRe.asBinder();
  }
  
  IBinder zzBh()
  {
    if (this.zzaRj == null) {
      return null;
    }
    return this.zzaRj.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\SubscribeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */