package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

public final class ProvideContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProvideContentRequest> CREATOR = new zzf();
  final int versionCode;
  public IBinder zzaRq;
  public zzb zzaRr;
  @Deprecated
  public List<SharedContent> zzaRs;
  public long zzaRt;
  public zzc zzaRu;
  
  ProvideContentRequest()
  {
    this.versionCode = 1;
  }
  
  ProvideContentRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, List<SharedContent> paramList, long paramLong, IBinder paramIBinder3)
  {
    this.versionCode = paramInt;
    this.zzaRq = paramIBinder1;
    this.zzaRr = zzb.zza.zzds(paramIBinder2);
    this.zzaRs = paramList;
    this.zzaRt = paramLong;
    this.zzaRu = zzc.zza.zzdt(paramIBinder3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaRu.asBinder();
  }
  
  IBinder zzBo()
  {
    if (this.zzaRr == null) {
      return null;
    }
    return this.zzaRr.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\ProvideContentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */