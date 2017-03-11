package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zzb;

public class zzw
  extends zzab
  implements DriveFile
{
  public zzw(DriveId paramDriveId)
  {
    super(paramDriveId);
  }
  
  private static DriveFile.DownloadProgressListener zza(GoogleApiClient paramGoogleApiClient, DriveFile.DownloadProgressListener paramDownloadProgressListener)
  {
    if (paramDownloadProgressListener == null) {
      return null;
    }
    return new zza(paramGoogleApiClient.zzo(paramDownloadProgressListener));
  }
  
  public PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient paramGoogleApiClient, final int paramInt, DriveFile.DownloadProgressListener paramDownloadProgressListener)
  {
    if ((paramInt != 268435456) && (paramInt != 536870912) && (paramInt != 805306368)) {
      throw new IllegalArgumentException("Invalid mode provided.");
    }
    paramGoogleApiClient.zza(new zzs.zzb(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        zza(paramAnonymouszzu.zzrm().zza(new OpenContentsRequest(zzw.this.getDriveId(), paramInt, 0), new zzbl(this, this.zzakX)).zzrr());
      }
    });
  }
  
  private static class zza
    implements DriveFile.DownloadProgressListener
  {
    private final zzlm<DriveFile.DownloadProgressListener> zzakZ;
    
    public zza(zzlm<DriveFile.DownloadProgressListener> paramzzlm)
    {
      this.zzakZ = paramzzlm;
    }
    
    public void onProgress(final long paramLong1, long paramLong2)
    {
      this.zzakZ.zza(new zzlm.zzb()
      {
        public void zza(DriveFile.DownloadProgressListener paramAnonymousDownloadProgressListener)
        {
          paramAnonymousDownloadProgressListener.onProgress(paramLong1, this.zzalb);
        }
        
        public void zznN() {}
      });
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */