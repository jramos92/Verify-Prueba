package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReferenceShiftedDetails> CREATOR = new zze();
  final int mVersionCode;
  final String zzaoZ;
  final String zzapa;
  final int zzapb;
  final int zzapc;
  
  ReferenceShiftedDetails(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzaoZ = paramString1;
    this.zzapa = paramString2;
    this.zzapb = paramInt2;
    this.zzapc = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\ReferenceShiftedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */