package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.internal.zzlb.zzb;
import java.util.List;

public class zzs
  implements DriveApi
{
  public PendingResult<Status> cancelPendingActions(GoogleApiClient paramGoogleApiClient, List<String> paramList)
  {
    return ((zzu)paramGoogleApiClient.zza(Drive.zzRk)).cancelPendingActions(paramGoogleApiClient, paramList);
  }
  
  public PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zze(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new GetMetadataRequest(DriveId.zzcB(paramString), false), new zzs.zzc(this));
      }
    });
  }
  
  public DriveFolder getAppFolder(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = (zzu)paramGoogleApiClient.zza(Drive.zzRk);
    if (!paramGoogleApiClient.zzrp()) {
      throw new IllegalStateException("Client is not yet connected");
    }
    paramGoogleApiClient = paramGoogleApiClient.zzro();
    if (paramGoogleApiClient != null) {
      return new zzy(paramGoogleApiClient);
    }
    return null;
  }
  
  public DriveFile getFile(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    if (paramDriveId == null) {
      throw new IllegalArgumentException("Id must be provided.");
    }
    if (!paramGoogleApiClient.isConnected()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new zzw(paramDriveId);
  }
  
  public DriveFolder getFolder(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    if (paramDriveId == null) {
      throw new IllegalArgumentException("Id must be provided.");
    }
    if (!paramGoogleApiClient.isConnected()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new zzy(paramDriveId);
  }
  
  public DriveFolder getRootFolder(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = (zzu)paramGoogleApiClient.zza(Drive.zzRk);
    if (!paramGoogleApiClient.zzrp()) {
      throw new IllegalStateException("Client is not yet connected");
    }
    return new zzy(paramGoogleApiClient.zzrn());
  }
  
  public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzt(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zze(new zzd()
        {
          public void zzab(boolean paramAnonymous2Boolean)
          {
            jdField_this.zzb(new BooleanResult(Status.zzabb, paramAnonymous2Boolean));
          }
        });
      }
      
      protected BooleanResult zzz(Status paramAnonymousStatus)
      {
        return new BooleanResult(paramAnonymousStatus, false);
      }
    });
  }
  
  public CreateFileActivityBuilder newCreateFileActivityBuilder()
  {
    return new CreateFileActivityBuilder();
  }
  
  public PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient paramGoogleApiClient)
  {
    return zza(paramGoogleApiClient, 536870912);
  }
  
  public OpenFileActivityBuilder newOpenFileActivityBuilder()
  {
    return new OpenFileActivityBuilder();
  }
  
  public PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient paramGoogleApiClient, final Query paramQuery)
  {
    if (paramQuery == null) {
      throw new IllegalArgumentException("Query must be provided.");
    }
    paramGoogleApiClient.zza(new zzg(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new QueryRequest(paramQuery), new zzs.zzi(this));
      }
    });
  }
  
  public PendingResult<Status> requestSync(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new zzbt(this));
      }
    });
  }
  
  public PendingResult<DriveApi.DriveContentsResult> zza(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new zzb(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new CreateContentsRequest(paramInt), new zzs.zzh(this));
      }
    });
  }
  
  static class zza
    implements Releasable, DriveApi.DriveContentsResult
  {
    private final Status zzSC;
    private final DriveContents zzaiD;
    
    public zza(Status paramStatus, DriveContents paramDriveContents)
    {
      this.zzSC = paramStatus;
      this.zzaiD = paramDriveContents;
    }
    
    public DriveContents getDriveContents()
    {
      return this.zzaiD;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public void release()
    {
      if (this.zzaiD != null) {
        this.zzaiD.zzqP();
      }
    }
  }
  
  static abstract class zzb
    extends zzt<DriveApi.DriveContentsResult>
  {
    zzb(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.DriveContentsResult zzA(Status paramStatus)
    {
      return new zzs.zza(paramStatus, null);
    }
  }
  
  static class zzc
    extends zzd
  {
    private final zzlb.zzb<DriveApi.DriveIdResult> zzagy;
    
    public zzc(zzlb.zzb<DriveApi.DriveIdResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(OnDriveIdResponse paramOnDriveIdResponse)
      throws RemoteException
    {
      this.zzagy.zzp(new zzs.zzd(Status.zzabb, paramOnDriveIdResponse.getDriveId()));
    }
    
    public void zza(OnMetadataResponse paramOnMetadataResponse)
      throws RemoteException
    {
      this.zzagy.zzp(new zzs.zzd(Status.zzabb, new zzp(paramOnMetadataResponse.zzrE()).getDriveId()));
    }
    
    public void zzy(Status paramStatus)
      throws RemoteException
    {
      this.zzagy.zzp(new zzs.zzd(paramStatus, null));
    }
  }
  
  private static class zzd
    implements DriveApi.DriveIdResult
  {
    private final Status zzSC;
    private final DriveId zzaiA;
    
    public zzd(Status paramStatus, DriveId paramDriveId)
    {
      this.zzSC = paramStatus;
      this.zzaiA = paramDriveId;
    }
    
    public DriveId getDriveId()
    {
      return this.zzaiA;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  static abstract class zze
    extends zzt<DriveApi.DriveIdResult>
  {
    zze(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.DriveIdResult zzB(Status paramStatus)
    {
      return new zzs.zzd(paramStatus, null);
    }
  }
  
  static class zzf
    implements DriveApi.MetadataBufferResult
  {
    private final Status zzSC;
    private final MetadataBuffer zzakA;
    private final boolean zzakB;
    
    public zzf(Status paramStatus, MetadataBuffer paramMetadataBuffer, boolean paramBoolean)
    {
      this.zzSC = paramStatus;
      this.zzakA = paramMetadataBuffer;
      this.zzakB = paramBoolean;
    }
    
    public MetadataBuffer getMetadataBuffer()
    {
      return this.zzakA;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public void release()
    {
      if (this.zzakA != null) {
        this.zzakA.release();
      }
    }
  }
  
  static abstract class zzg
    extends zzt<DriveApi.MetadataBufferResult>
  {
    zzg(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.MetadataBufferResult zzC(Status paramStatus)
    {
      return new zzs.zzf(paramStatus, null, false);
    }
  }
  
  private static class zzh
    extends zzd
  {
    private final zzlb.zzb<DriveApi.DriveContentsResult> zzagy;
    
    public zzh(zzlb.zzb<DriveApi.DriveContentsResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(OnContentsResponse paramOnContentsResponse)
      throws RemoteException
    {
      this.zzagy.zzp(new zzs.zza(Status.zzabb, new zzv(paramOnContentsResponse.zzrv())));
    }
    
    public void zzy(Status paramStatus)
      throws RemoteException
    {
      this.zzagy.zzp(new zzs.zza(paramStatus, null));
    }
  }
  
  private static class zzi
    extends zzd
  {
    private final zzlb.zzb<DriveApi.MetadataBufferResult> zzagy;
    
    public zzi(zzlb.zzb<DriveApi.MetadataBufferResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(OnListEntriesResponse paramOnListEntriesResponse)
      throws RemoteException
    {
      MetadataBuffer localMetadataBuffer = new MetadataBuffer(paramOnListEntriesResponse.zzrB());
      this.zzagy.zzp(new zzs.zzf(Status.zzabb, localMetadataBuffer, paramOnListEntriesResponse.zzrC()));
    }
    
    public void zzy(Status paramStatus)
      throws RemoteException
    {
      this.zzagy.zzp(new zzs.zzf(paramStatus, null, false));
    }
  }
  
  static class zzj
    extends zzt.zza
  {
    zzj(GoogleApiClient paramGoogleApiClient, Status paramStatus)
    {
      super();
      zzb(paramStatus);
    }
    
    protected void zza(zzu paramzzu) {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */