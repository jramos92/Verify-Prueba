package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;
import java.util.Set;

public class GetChangesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetChangesRequest> CREATOR = new zzah();
  final int mVersionCode;
  final List<DriveSpace> zzajA;
  private final Set<DriveSpace> zzajB;
  final ChangeSequenceNumber zzalA;
  final int zzalB;
  final boolean zzalC;
  
  private GetChangesRequest(int paramInt1, ChangeSequenceNumber paramChangeSequenceNumber, int paramInt2, List<DriveSpace> paramList, Set<DriveSpace> paramSet, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzalA = paramChangeSequenceNumber;
    this.zzalB = paramInt2;
    this.zzajA = paramList;
    this.zzajB = paramSet;
    this.zzalC = paramBoolean;
  }
  
  GetChangesRequest(int paramInt1, ChangeSequenceNumber paramChangeSequenceNumber, int paramInt2, List<DriveSpace> paramList, boolean paramBoolean) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzah.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\GetChangesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */