package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzam;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzg;

public class OpenFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private String zzajf;
  private String[] zzajg;
  private Filter zzajh;
  private DriveId zzaji;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    zzx.zza(paramGoogleApiClient.isConnected(), "Client must be connected");
    if (this.zzajg == null) {
      this.zzajg = new String[0];
    }
    if ((this.zzajg.length > 0) && (this.zzajh != null)) {
      throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }
    if (this.zzajh == null) {}
    for (FilterHolder localFilterHolder = null;; localFilterHolder = new FilterHolder(this.zzajh)) {
      try
      {
        paramGoogleApiClient = ((zzu)paramGoogleApiClient.zza(Drive.zzRk)).zzrm().zza(new OpenFileIntentSenderRequest(this.zzajf, this.zzajg, this.zzaji, localFilterHolder));
        return paramGoogleApiClient;
      }
      catch (RemoteException paramGoogleApiClient)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
      }
    }
  }
  
  public OpenFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.zzaji = ((DriveId)zzx.zzw(paramDriveId));
    return this;
  }
  
  public OpenFileActivityBuilder setActivityTitle(String paramString)
  {
    this.zzajf = ((String)zzx.zzw(paramString));
    return this;
  }
  
  public OpenFileActivityBuilder setMimeType(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "mimeTypes may not be null");
      this.zzajg = paramArrayOfString;
      return this;
    }
  }
  
  public OpenFileActivityBuilder setSelectionFilter(Filter paramFilter)
  {
    boolean bool2 = true;
    if (paramFilter != null)
    {
      bool1 = true;
      zzx.zzb(bool1, "filter may not be null");
      if (zzg.zza(paramFilter)) {
        break label41;
      }
    }
    label41:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "FullTextSearchFilter cannot be used as a selection filter");
      this.zzajh = paramFilter;
      return this;
      bool1 = false;
      break;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\OpenFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */