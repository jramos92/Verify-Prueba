package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new zzm();
  final int mVersionCode;
  final int zzaiy;
  final String zzajf;
  final DriveId zzaji;
  final MetadataBundle zzako;
  final Integer zzakp;
  
  CreateFileIntentSenderRequest(int paramInt1, MetadataBundle paramMetadataBundle, int paramInt2, String paramString, DriveId paramDriveId, Integer paramInteger)
  {
    this.mVersionCode = paramInt1;
    this.zzako = paramMetadataBundle;
    this.zzaiy = paramInt2;
    this.zzajf = paramString;
    this.zzaji = paramDriveId;
    this.zzakp = paramInteger;
  }
  
  public CreateFileIntentSenderRequest(MetadataBundle paramMetadataBundle, int paramInt1, String paramString, DriveId paramDriveId, int paramInt2)
  {
    this(1, paramMetadataBundle, paramInt1, paramString, paramDriveId, Integer.valueOf(paramInt2));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\CreateFileIntentSenderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */