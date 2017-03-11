package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzl;
import com.google.android.gms.drive.internal.zzv;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private final zzl zzaiC = new zzl(0);
  private DriveContents zzaiD;
  private boolean zzaiE;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(Boolean.valueOf(this.zzaiE), "Must call setInitialDriveContents to CreateFileActivityBuilder.");
    zzx.zza(paramGoogleApiClient.isConnected(), "Client must be connected");
    if (this.zzaiD != null) {
      this.zzaiD.zzqP();
    }
    return this.zzaiC.build(paramGoogleApiClient);
  }
  
  public CreateFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.zzaiC.zza(paramDriveId);
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.zzaiC.zzcE(paramString);
    return this;
  }
  
  public CreateFileActivityBuilder setInitialDriveContents(DriveContents paramDriveContents)
  {
    if (paramDriveContents != null)
    {
      if (!(paramDriveContents instanceof zzv)) {
        throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
      }
      if (paramDriveContents.getDriveId() != null) {
        throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
      }
      if (paramDriveContents.zzqQ()) {
        throw new IllegalArgumentException("DriveContents are already closed.");
      }
      this.zzaiC.zzcI(paramDriveContents.zzqO().getRequestId());
      this.zzaiD = paramDriveContents;
    }
    for (;;)
    {
      this.zzaiE = true;
      return this;
      this.zzaiC.zzcI(1);
    }
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.zzaiC.zza(paramMetadataChangeSet);
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\CreateFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */