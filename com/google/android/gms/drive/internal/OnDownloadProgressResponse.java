package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import java.util.ArrayList;
import java.util.List;

public class OnDownloadProgressResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new zzay();
  private static final List<DriveFileRange> zzalZ = new ArrayList();
  final int mVersionCode;
  final long zzama;
  final long zzamb;
  final List<DriveFileRange> zzamc;
  final int zzys;
  
  OnDownloadProgressResponse(int paramInt1, long paramLong1, long paramLong2, int paramInt2, List<DriveFileRange> paramList)
  {
    this.mVersionCode = paramInt1;
    this.zzama = paramLong1;
    this.zzamb = paramLong2;
    this.zzys = paramInt2;
    this.zzamc = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzay.zza(this, paramParcel, paramInt);
  }
  
  public long zzry()
  {
    return this.zzama;
  }
  
  public long zzrz()
  {
    return this.zzamb;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\OnDownloadProgressResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */