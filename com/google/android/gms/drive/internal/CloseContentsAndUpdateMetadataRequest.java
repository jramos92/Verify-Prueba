package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzh();
  final int mVersionCode;
  final String zzaiX;
  final boolean zzaiY;
  final DriveId zzakc;
  final MetadataBundle zzakd;
  final Contents zzake;
  final int zzakf;
  final int zzakg;
  final boolean zzakh;
  
  CloseContentsAndUpdateMetadataRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, boolean paramBoolean1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt1;
    this.zzakc = paramDriveId;
    this.zzakd = paramMetadataBundle;
    this.zzake = paramContents;
    this.zzaiY = paramBoolean1;
    this.zzaiX = paramString;
    this.zzakf = paramInt2;
    this.zzakg = paramInt3;
    this.zzakh = paramBoolean2;
  }
  
  public CloseContentsAndUpdateMetadataRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, int paramInt, boolean paramBoolean, ExecutionOptions paramExecutionOptions)
  {
    this(1, paramDriveId, paramMetadataBundle, null, paramExecutionOptions.zzqT(), paramExecutionOptions.zzqS(), paramExecutionOptions.zzqU(), paramInt, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\CloseContentsAndUpdateMetadataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */