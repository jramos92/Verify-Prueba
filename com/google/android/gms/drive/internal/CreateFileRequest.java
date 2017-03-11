package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileRequest> CREATOR = new zzn();
  final int mVersionCode;
  final String zzaiX;
  final boolean zzajW;
  final Contents zzake;
  final MetadataBundle zzako;
  final Integer zzakp;
  final DriveId zzakq;
  final int zzakr;
  final int zzaks;
  
  CreateFileRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString, int paramInt2, int paramInt3)
  {
    if ((paramContents != null) && (paramInt3 != 0)) {
      if (paramContents.getRequestId() != paramInt3) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "inconsistent contents reference");
      if (((paramInteger != null) && (paramInteger.intValue() != 0)) || (paramContents != null) || (paramInt3 != 0)) {
        break;
      }
      throw new IllegalArgumentException("Need a valid contents");
    }
    this.mVersionCode = paramInt1;
    this.zzakq = ((DriveId)zzx.zzw(paramDriveId));
    this.zzako = ((MetadataBundle)zzx.zzw(paramMetadataBundle));
    this.zzake = paramContents;
    this.zzakp = paramInteger;
    this.zzaiX = paramString;
    this.zzakr = paramInt2;
    this.zzajW = paramBoolean;
    this.zzaks = paramInt3;
  }
  
  public CreateFileRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2, ExecutionOptions paramExecutionOptions)
  {
    this(2, paramDriveId, paramMetadataBundle, null, Integer.valueOf(paramInt2), paramExecutionOptions.zzqT(), paramExecutionOptions.zzqS(), paramExecutionOptions.zzqU(), paramInt1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\CreateFileRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */