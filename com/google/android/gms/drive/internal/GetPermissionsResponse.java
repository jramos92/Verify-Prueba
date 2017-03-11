package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import java.util.List;

public class GetPermissionsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetPermissionsResponse> CREATOR = new zzal();
  final int mVersionCode;
  final List<Permission> zzalG;
  final int zzxM;
  
  GetPermissionsResponse(int paramInt1, List<Permission> paramList, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzalG = paramList;
    this.zzxM = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzal.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\GetPermissionsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */