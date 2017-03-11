package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new zzi();
  final int mVersionCode;
  final Contents zzake;
  final int zzakg;
  final Boolean zzaki;
  
  CloseContentsRequest(int paramInt1, Contents paramContents, Boolean paramBoolean, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzake = paramContents;
    this.zzaki = paramBoolean;
    this.zzakg = paramInt2;
  }
  
  public CloseContentsRequest(int paramInt, boolean paramBoolean)
  {
    this(1, null, Boolean.valueOf(paramBoolean), paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\CloseContentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */