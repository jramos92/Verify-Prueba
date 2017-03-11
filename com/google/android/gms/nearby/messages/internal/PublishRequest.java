package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;

public final class PublishRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PublishRequest> CREATOR = new zzn();
  final int mVersionCode;
  public final zzc zzaQG;
  public final MessageWrapper zzaQY;
  public final Strategy zzaQZ;
  public final String zzaQe;
  public final boolean zzaQf;
  public final String zzaRa;
  public final zze zzaRb;
  
  PublishRequest(int paramInt, MessageWrapper paramMessageWrapper, Strategy paramStrategy, IBinder paramIBinder1, String paramString1, String paramString2, boolean paramBoolean, IBinder paramIBinder2)
  {
    this.mVersionCode = paramInt;
    this.zzaQY = paramMessageWrapper;
    this.zzaQZ = paramStrategy;
    this.zzaQG = zzc.zza.zzdl(paramIBinder1);
    this.zzaQe = paramString1;
    this.zzaRa = paramString2;
    this.zzaQf = paramBoolean;
    if (paramIBinder2 == null) {}
    for (paramMessageWrapper = null;; paramMessageWrapper = zze.zza.zzdn(paramIBinder2))
    {
      this.zzaRb = paramMessageWrapper;
      return;
    }
  }
  
  PublishRequest(MessageWrapper paramMessageWrapper, Strategy paramStrategy, IBinder paramIBinder1, String paramString1, String paramString2, boolean paramBoolean, IBinder paramIBinder2)
  {
    this(2, paramMessageWrapper, paramStrategy, paramIBinder1, paramString1, paramString2, paramBoolean, paramIBinder2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaQG.asBinder();
  }
  
  IBinder zzBe()
  {
    if (this.zzaRb == null) {
      return null;
    }
    return this.zzaRb.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\PublishRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */