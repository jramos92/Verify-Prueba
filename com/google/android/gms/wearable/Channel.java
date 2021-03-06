package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface Channel
  extends Parcelable
{
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener);
  
  public abstract PendingResult<Status> close(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> close(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient paramGoogleApiClient);
  
  public abstract String getNodeId();
  
  public abstract PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient paramGoogleApiClient);
  
  public abstract String getPath();
  
  public abstract PendingResult<Status> receiveFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, boolean paramBoolean);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener);
  
  public abstract PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, long paramLong1, long paramLong2);
  
  public static abstract interface GetInputStreamResult
    extends Releasable, Result
  {
    public abstract InputStream getInputStream();
  }
  
  public static abstract interface GetOutputStreamResult
    extends Releasable, Result
  {
    public abstract OutputStream getOutputStream();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\Channel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */