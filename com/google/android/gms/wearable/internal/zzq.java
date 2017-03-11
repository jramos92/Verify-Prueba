package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzq
  extends OutputStream
{
  private volatile zzm zzbgj;
  private final OutputStream zzbgl;
  
  public zzq(OutputStream paramOutputStream)
  {
    this.zzbgl = ((OutputStream)zzx.zzw(paramOutputStream));
  }
  
  private IOException zza(IOException paramIOException)
  {
    zzm localzzm = this.zzbgj;
    Object localObject = paramIOException;
    if (localzzm != null)
    {
      if (Log.isLoggable("ChannelOutputStream", 2)) {
        Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", paramIOException);
      }
      localObject = new ChannelIOException("Channel closed unexpectedly before stream was finished", localzzm.zzbfY, localzzm.zzbfZ);
    }
    return (IOException)localObject;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.zzbgl.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      this.zzbgl.flush();
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      this.zzbgl.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      this.zzbgl.write(paramArrayOfByte);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw zza(paramArrayOfByte);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.zzbgl.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw zza(paramArrayOfByte);
    }
  }
  
  zzu zzEY()
  {
    new zzu()
    {
      public void zzb(zzm paramAnonymouszzm)
      {
        zzq.this.zzc(paramAnonymouszzm);
      }
    };
  }
  
  void zzc(zzm paramzzm)
  {
    this.zzbgj = paramzzm;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */