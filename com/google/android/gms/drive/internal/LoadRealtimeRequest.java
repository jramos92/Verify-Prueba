package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new zzar();
  final int mVersionCode;
  final DriveId zzaiA;
  final boolean zzalI;
  final List<String> zzalJ;
  final boolean zzalK;
  final DataHolder zzalL;
  final String zzalM;
  
  LoadRealtimeRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, DataHolder paramDataHolder, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaiA = paramDriveId;
    this.zzalI = paramBoolean1;
    this.zzalJ = paramList;
    this.zzalK = paramBoolean2;
    this.zzalL = paramDataHolder;
    this.zzalM = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzar.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\LoadRealtimeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */