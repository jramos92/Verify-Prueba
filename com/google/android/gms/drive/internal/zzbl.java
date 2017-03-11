package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.internal.zzlb.zzb;

class zzbl
  extends zzd
{
  private final zzlb.zzb<DriveApi.DriveContentsResult> zzagy;
  private final DriveFile.DownloadProgressListener zzamp;
  
  zzbl(zzlb.zzb<DriveApi.DriveContentsResult> paramzzb, DriveFile.DownloadProgressListener paramDownloadProgressListener)
  {
    this.zzagy = paramzzb;
    this.zzamp = paramDownloadProgressListener;
  }
  
  public void zza(OnContentsResponse paramOnContentsResponse)
    throws RemoteException
  {
    if (paramOnContentsResponse.zzrw()) {}
    for (Status localStatus = new Status(-1);; localStatus = Status.zzabb)
    {
      this.zzagy.zzp(new zzs.zza(localStatus, new zzv(paramOnContentsResponse.zzrv())));
      return;
    }
  }
  
  public void zza(OnDownloadProgressResponse paramOnDownloadProgressResponse)
    throws RemoteException
  {
    if (this.zzamp != null) {
      this.zzamp.onProgress(paramOnDownloadProgressResponse.zzry(), paramOnDownloadProgressResponse.zzrz());
    }
  }
  
  public void zzy(Status paramStatus)
    throws RemoteException
  {
    this.zzagy.zzp(new zzs.zza(paramStatus, null));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */