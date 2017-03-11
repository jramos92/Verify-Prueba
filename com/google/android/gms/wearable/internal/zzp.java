package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzp
  extends InputStream
{
  private final InputStream zzbgi;
  private volatile zzm zzbgj;
  
  public zzp(InputStream paramInputStream)
  {
    this.zzbgi = ((InputStream)zzx.zzw(paramInputStream));
  }
  
  private int zzkW(int paramInt)
    throws ChannelIOException
  {
    if (paramInt == -1)
    {
      zzm localzzm = this.zzbgj;
      if (localzzm != null) {
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", localzzm.zzbfY, localzzm.zzbfZ);
      }
    }
    return paramInt;
  }
  
  public int available()
    throws IOException
  {
    return this.zzbgi.available();
  }
  
  public void close()
    throws IOException
  {
    this.zzbgi.close();
  }
  
  public void mark(int paramInt)
  {
    this.zzbgi.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.zzbgi.markSupported();
  }
  
  public int read()
    throws IOException
  {
    return zzkW(this.zzbgi.read());
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return zzkW(this.zzbgi.read(paramArrayOfByte));
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return zzkW(this.zzbgi.read(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public void reset()
    throws IOException
  {
    this.zzbgi.reset();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.zzbgi.skip(paramLong);
  }
  
  zzu zzEY()
  {
    new zzu()
    {
      public void zzb(zzm paramAnonymouszzm)
      {
        zzp.this.zza(paramAnonymouszzm);
      }
    };
  }
  
  void zza(zzm paramzzm)
  {
    this.zzbgj = ((zzm)zzx.zzw(paramzzm));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */