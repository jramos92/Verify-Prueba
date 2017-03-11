package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzl
{
  private String zzajf;
  private DriveId zzaji;
  protected MetadataChangeSet zzakl;
  private Integer zzakm;
  private final int zzakn;
  
  public zzl(int paramInt)
  {
    this.zzakn = paramInt;
  }
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(this.zzakl, "Must provide initial metadata to CreateFileActivityBuilder.");
    zzx.zza(paramGoogleApiClient.isConnected(), "Client must be connected");
    paramGoogleApiClient = (zzu)paramGoogleApiClient.zza(Drive.zzRk);
    this.zzakl.zzqW().setContext(paramGoogleApiClient.getContext());
    if (this.zzakm == null) {}
    for (int i = 0;; i = this.zzakm.intValue()) {
      try
      {
        paramGoogleApiClient = paramGoogleApiClient.zzrm().zza(new CreateFileIntentSenderRequest(this.zzakl.zzqW(), i, this.zzajf, this.zzaji, this.zzakn));
        return paramGoogleApiClient;
      }
      catch (RemoteException paramGoogleApiClient)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
      }
    }
  }
  
  public void zza(DriveId paramDriveId)
  {
    this.zzaji = ((DriveId)zzx.zzw(paramDriveId));
  }
  
  public void zza(MetadataChangeSet paramMetadataChangeSet)
  {
    this.zzakl = ((MetadataChangeSet)zzx.zzw(paramMetadataChangeSet));
  }
  
  public void zzcE(String paramString)
  {
    this.zzajf = ((String)zzx.zzw(paramString));
  }
  
  public void zzcI(int paramInt)
  {
    this.zzakm = Integer.valueOf(paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */