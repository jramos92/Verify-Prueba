package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

public class OnChangesResponse
  extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnChangesResponse> CREATOR = new zzav();
  final int mVersionCode;
  final DataHolder zzalT;
  final List<DriveId> zzalU;
  final ChangeSequenceNumber zzalV;
  final boolean zzalW;
  
  OnChangesResponse(int paramInt, DataHolder paramDataHolder, List<DriveId> paramList, ChangeSequenceNumber paramChangeSequenceNumber, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzalT = paramDataHolder;
    this.zzalU = paramList;
    this.zzalV = paramChangeSequenceNumber;
    this.zzalW = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void zzJ(Parcel paramParcel, int paramInt)
  {
    zzav.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\OnChangesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */