package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzmt;
import java.io.InputStream;
import java.io.OutputStream;

public class zzv
  implements DriveContents
{
  private boolean mClosed = false;
  private final Contents zzakR;
  private boolean zzakS = false;
  private boolean zzakT = false;
  
  public zzv(Contents paramContents)
  {
    this.zzakR = ((Contents)zzx.zzw(paramContents));
  }
  
  public PendingResult<Status> commit(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet)
  {
    return commit(paramGoogleApiClient, paramMetadataChangeSet, null);
  }
  
  public PendingResult<Status> commit(GoogleApiClient paramGoogleApiClient, final MetadataChangeSet paramMetadataChangeSet, ExecutionOptions paramExecutionOptions)
  {
    final ExecutionOptions localExecutionOptions = paramExecutionOptions;
    if (paramExecutionOptions == null) {
      localExecutionOptions = new ExecutionOptions.Builder().build();
    }
    if (this.zzakR.getMode() == 268435456) {
      throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
    }
    if ((ExecutionOptions.zzck(localExecutionOptions.zzqU())) && (!this.zzakR.zzqM())) {
      throw new IllegalStateException("DriveContents must be valid for conflict detection.");
    }
    ExecutionOptions.zza(paramGoogleApiClient, localExecutionOptions);
    if (zzqQ()) {
      throw new IllegalStateException("DriveContents already closed.");
    }
    if (getDriveId() == null) {
      throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
    }
    if (paramMetadataChangeSet != null) {}
    for (;;)
    {
      zzqP();
      paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
      {
        protected void zza(zzu paramAnonymouszzu)
          throws RemoteException
        {
          paramMetadataChangeSet.zzqW().setContext(paramAnonymouszzu.getContext());
          paramAnonymouszzu.zzrm().zza(new CloseContentsAndUpdateMetadataRequest(zzv.zza(zzv.this).getDriveId(), paramMetadataChangeSet.zzqW(), zzv.zza(zzv.this).getRequestId(), zzv.zza(zzv.this).zzqM(), localExecutionOptions), new zzbt(this));
        }
      });
      paramMetadataChangeSet = MetadataChangeSet.zzajc;
    }
  }
  
  public void discard(GoogleApiClient paramGoogleApiClient)
  {
    if (zzqQ()) {
      throw new IllegalStateException("DriveContents already closed.");
    }
    zzqP();
    ((4)paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new CloseContentsRequest(zzv.zza(zzv.this).getRequestId(), false), new zzbt(this));
      }
    })).setResultCallback(new ResultCallback()
    {
      public void zzo(Status paramAnonymousStatus)
      {
        if (!paramAnonymousStatus.isSuccess())
        {
          zzz.zzz("DriveContentsImpl", "Error discarding contents");
          return;
        }
        zzz.zzx("DriveContentsImpl", "Contents discarded");
      }
    });
  }
  
  public DriveId getDriveId()
  {
    return this.zzakR.getDriveId();
  }
  
  public InputStream getInputStream()
  {
    if (zzqQ()) {
      throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
    }
    if (this.zzakR.getMode() != 268435456) {
      throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
    }
    if (this.zzakS) {
      throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
    }
    this.zzakS = true;
    return this.zzakR.getInputStream();
  }
  
  public int getMode()
  {
    return this.zzakR.getMode();
  }
  
  public OutputStream getOutputStream()
  {
    if (zzqQ()) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    if (this.zzakR.getMode() != 536870912) {
      throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
    }
    if (this.zzakT) {
      throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
    }
    this.zzakT = true;
    return this.zzakR.getOutputStream();
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (zzqQ()) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    return this.zzakR.getParcelFileDescriptor();
  }
  
  public PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient paramGoogleApiClient)
  {
    if (zzqQ()) {
      throw new IllegalStateException("DriveContents already closed.");
    }
    if (this.zzakR.getMode() != 268435456) {
      throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
    }
    zzqP();
    paramGoogleApiClient.zza(new zzs.zzb(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new OpenContentsRequest(zzv.this.getDriveId(), 536870912, zzv.zza(zzv.this).getRequestId()), new zzbl(this, null));
      }
    });
  }
  
  public Contents zzqO()
  {
    return this.zzakR;
  }
  
  public void zzqP()
  {
    zzmt.zza(this.zzakR.getParcelFileDescriptor());
    this.mClosed = true;
  }
  
  public boolean zzqQ()
  {
    return this.mClosed;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */