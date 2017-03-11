package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class OpenFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new zzbm();
  final int mVersionCode;
  final String zzajf;
  final String[] zzajg;
  final DriveId zzaji;
  final FilterHolder zzamq;
  
  OpenFileIntentSenderRequest(int paramInt, String paramString, String[] paramArrayOfString, DriveId paramDriveId, FilterHolder paramFilterHolder)
  {
    this.mVersionCode = paramInt;
    this.zzajf = paramString;
    this.zzajg = paramArrayOfString;
    this.zzaji = paramDriveId;
    this.zzamq = paramFilterHolder;
  }
  
  public OpenFileIntentSenderRequest(String paramString, String[] paramArrayOfString, DriveId paramDriveId, FilterHolder paramFilterHolder)
  {
    this(1, paramString, paramArrayOfString, paramDriveId, paramFilterHolder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbm.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\OpenFileIntentSenderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */