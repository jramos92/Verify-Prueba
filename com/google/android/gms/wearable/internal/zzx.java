package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzx
  implements DataApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return zzb.zza(paramGoogleApiClient, zza(paramArrayOfIntentFilter), paramDataListener);
  }
  
  private static zzb.zza<DataApi.DataListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    new zzb.zza()
    {
      public void zza(zzbo paramAnonymouszzbo, zzlb.zzb<Status> paramAnonymouszzb, DataApi.DataListener paramAnonymousDataListener, zzlm<DataApi.DataListener> paramAnonymouszzlm)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(paramAnonymouszzb, paramAnonymousDataListener, paramAnonymouszzlm, this.zzbgt);
      }
    };
  }
  
  private void zza(Asset paramAsset)
  {
    if (paramAsset == null) {
      throw new IllegalArgumentException("asset is null");
    }
    if (paramAsset.getDigest() == null) {
      throw new IllegalArgumentException("invalid asset");
    }
    if (paramAsset.getData() != null) {
      throw new IllegalArgumentException("invalid asset");
    }
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    return zza(paramGoogleApiClient, paramDataListener, null);
  }
  
  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return deleteDataItems(paramGoogleApiClient, paramUri, 0);
  }
  
  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final int paramInt)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzb(this, paramUri, paramInt);
      }
      
      protected DataApi.DeleteDataItemsResult zzbp(Status paramAnonymousStatus)
      {
        return new zzx.zzb(paramAnonymousStatus, 0);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramUri);
      }
      
      protected DataApi.DataItemResult zzbn(Status paramAnonymousStatus)
      {
        return new zzx.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzm(this);
      }
      
      protected DataItemBuffer zzbo(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.zzbu(paramAnonymousStatus.getStatusCode()));
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return getDataItems(paramGoogleApiClient, paramUri, 0);
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final int paramInt)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramUri, paramInt);
      }
      
      protected DataItemBuffer zzbo(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.zzbu(paramAnonymousStatus.getStatusCode()));
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final Asset paramAsset)
  {
    zza(paramAsset);
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramAsset);
      }
      
      protected DataApi.GetFdForAssetResult zzbq(Status paramAnonymousStatus)
      {
        return new zzx.zzc(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final DataItemAsset paramDataItemAsset)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramDataItemAsset);
      }
      
      protected DataApi.GetFdForAssetResult zzbq(Status paramAnonymousStatus)
      {
        return new zzx.zzc(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, final PutDataRequest paramPutDataRequest)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramPutDataRequest);
      }
      
      public DataApi.DataItemResult zzbn(Status paramAnonymousStatus)
      {
        return new zzx.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final DataApi.DataListener paramDataListener)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramDataListener);
      }
      
      public Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public static class zza
    implements DataApi.DataItemResult
  {
    private final Status zzSC;
    private final DataItem zzbgv;
    
    public zza(Status paramStatus, DataItem paramDataItem)
    {
      this.zzSC = paramStatus;
      this.zzbgv = paramDataItem;
    }
    
    public DataItem getDataItem()
    {
      return this.zzbgv;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  public static class zzb
    implements DataApi.DeleteDataItemsResult
  {
    private final Status zzSC;
    private final int zzbgw;
    
    public zzb(Status paramStatus, int paramInt)
    {
      this.zzSC = paramStatus;
      this.zzbgw = paramInt;
    }
    
    public int getNumDeleted()
    {
      return this.zzbgw;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  public static class zzc
    implements DataApi.GetFdForAssetResult
  {
    private volatile boolean mClosed = false;
    private final Status zzSC;
    private volatile InputStream zzbgg;
    private volatile ParcelFileDescriptor zzbgx;
    
    public zzc(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.zzSC = paramStatus;
      this.zzbgx = paramParcelFileDescriptor;
    }
    
    public ParcelFileDescriptor getFd()
    {
      if (this.mClosed) {
        throw new IllegalStateException("Cannot access the file descriptor after release().");
      }
      return this.zzbgx;
    }
    
    public InputStream getInputStream()
    {
      if (this.mClosed) {
        throw new IllegalStateException("Cannot access the input stream after release().");
      }
      if (this.zzbgx == null) {
        return null;
      }
      if (this.zzbgg == null) {
        this.zzbgg = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbgx);
      }
      return this.zzbgg;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public void release()
    {
      if (this.zzbgx == null) {
        return;
      }
      if (this.mClosed) {
        throw new IllegalStateException("releasing an already released result.");
      }
      try
      {
        if (this.zzbgg != null) {
          this.zzbgg.close();
        }
        for (;;)
        {
          this.mClosed = true;
          this.zzbgx = null;
          this.zzbgg = null;
          return;
          this.zzbgx.close();
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */