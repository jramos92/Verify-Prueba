package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UnpublishRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnpublishRequest> CREATOR = new zzq();
  final int mVersionCode;
  public final zzc zzaQG;
  public final MessageWrapper zzaQY;
  public final String zzaQe;
  public final String zzaRa;
  
  UnpublishRequest(int paramInt, MessageWrapper paramMessageWrapper, IBinder paramIBinder, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzaQY = paramMessageWrapper;
    this.zzaQG = zzc.zza.zzdl(paramIBinder);
    this.zzaQe = paramString1;
    this.zzaRa = paramString2;
  }
  
  UnpublishRequest(MessageWrapper paramMessageWrapper, IBinder paramIBinder, String paramString1, String paramString2)
  {
    this(1, paramMessageWrapper, paramIBinder, paramString1, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaQG.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\UnpublishRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */