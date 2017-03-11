package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl
  implements SafeParcelable, Channel
{
  public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzo();
  private final String mPath;
  final int mVersionCode;
  private final String zzRz;
  private final String zzbeZ;
  
  ChannelImpl(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.zzRz = ((String)zzx.zzw(paramString1));
    this.zzbeZ = ((String)zzx.zzw(paramString2));
    this.mPath = ((String)zzx.zzw(paramString3));
  }
  
  private static zzb.zza<ChannelApi.ChannelListener> zzfx(String paramString)
  {
    new zzb.zza()
    {
      public void zza(zzbo paramAnonymouszzbo, zzlb.zzb<Status> paramAnonymouszzb, ChannelApi.ChannelListener paramAnonymousChannelListener, zzlm<ChannelApi.ChannelListener> paramAnonymouszzlm)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(paramAnonymouszzb, paramAnonymousChannelListener, paramAnonymouszzlm, this.zzbgf);
      }
    };
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    return zzb.zza(paramGoogleApiClient, zzfx(this.zzRz), paramChannelListener);
  }
  
  public PendingResult<Status> close(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzt(this, ChannelImpl.zza(ChannelImpl.this));
      }
      
      protected Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> close(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zzb(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzh(this, ChannelImpl.zza(ChannelImpl.this), paramInt);
      }
      
      protected Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ChannelImpl)) {
        return false;
      }
      paramObject = (ChannelImpl)paramObject;
    } while ((this.zzRz.equals(((ChannelImpl)paramObject).zzRz)) && (zzw.equal(((ChannelImpl)paramObject).zzbeZ, this.zzbeZ)) && (zzw.equal(((ChannelImpl)paramObject).mPath, this.mPath)) && (((ChannelImpl)paramObject).mVersionCode == this.mVersionCode));
    return false;
  }
  
  public PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzu(this, ChannelImpl.zza(ChannelImpl.this));
      }
      
      public Channel.GetInputStreamResult zzbl(Status paramAnonymousStatus)
      {
        return new ChannelImpl.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public String getNodeId()
  {
    return this.zzbeZ;
  }
  
  public PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzv(this, ChannelImpl.zza(ChannelImpl.this));
      }
      
      public Channel.GetOutputStreamResult zzbm(Status paramAnonymousStatus)
      {
        return new ChannelImpl.zzb(paramAnonymousStatus, null);
      }
    });
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public String getToken()
  {
    return this.zzRz;
  }
  
  public int hashCode()
  {
    return this.zzRz.hashCode();
  }
  
  public PendingResult<Status> receiveFile(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final boolean paramBoolean)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramUri, "uri is null");
    paramGoogleApiClient.zzb(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, ChannelImpl.zza(ChannelImpl.this), paramUri, paramBoolean);
      }
      
      public Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramChannelListener, "listener is null");
    return paramGoogleApiClient.zza(new zzl.zzb(paramGoogleApiClient, paramChannelListener, this.zzRz));
  }
  
  public PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return sendFile(paramGoogleApiClient, paramUri, 0L, -1L);
  }
  
  public PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final long paramLong1, long paramLong2)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(this.zzRz, "token is null");
    zzx.zzb(paramUri, "uri is null");
    if (paramLong1 >= 0L)
    {
      bool = true;
      zzx.zzb(bool, "startOffset is negative: %s", new Object[] { Long.valueOf(paramLong1) });
      if ((paramLong2 < 0L) && (paramLong2 != -1L)) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "invalid length: %s", new Object[] { Long.valueOf(paramLong2) });
      paramGoogleApiClient.zzb(new zzi(paramGoogleApiClient)
      {
        protected void zza(zzbo paramAnonymouszzbo)
          throws RemoteException
        {
          paramAnonymouszzbo.zza(this, ChannelImpl.zza(ChannelImpl.this), paramUri, paramLong1, this.zzbge);
        }
        
        public Status zzd(Status paramAnonymousStatus)
        {
          return paramAnonymousStatus;
        }
      });
      bool = false;
      break;
    }
  }
  
  public String toString()
  {
    return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzRz + '\'' + ", nodeId='" + this.zzbeZ + '\'' + ", path='" + this.mPath + '\'' + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  static final class zza
    implements Channel.GetInputStreamResult
  {
    private final Status zzSC;
    private final InputStream zzbgg;
    
    zza(Status paramStatus, InputStream paramInputStream)
    {
      this.zzSC = ((Status)zzx.zzw(paramStatus));
      this.zzbgg = paramInputStream;
    }
    
    public InputStream getInputStream()
    {
      return this.zzbgg;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public void release()
    {
      if (this.zzbgg != null) {}
      try
      {
        this.zzbgg.close();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  static final class zzb
    implements Channel.GetOutputStreamResult
  {
    private final Status zzSC;
    private final OutputStream zzbgh;
    
    zzb(Status paramStatus, OutputStream paramOutputStream)
    {
      this.zzSC = ((Status)zzx.zzw(paramStatus));
      this.zzbgh = paramOutputStream;
    }
    
    public OutputStream getOutputStream()
    {
      return this.zzbgh;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public void release()
    {
      if (this.zzbgh != null) {}
      try
      {
        this.zzbgh.close();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\ChannelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */