package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.zzmt;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotContentsEntity
  implements SafeParcelable, SnapshotContents
{
  public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();
  private static final Object zzaBE = new Object();
  private final int mVersionCode;
  private Contents zzakR;
  
  SnapshotContentsEntity(int paramInt, Contents paramContents)
  {
    this.mVersionCode = paramInt;
    this.zzakR = paramContents;
  }
  
  public SnapshotContentsEntity(Contents paramContents)
  {
    this(1, paramContents);
  }
  
  private boolean zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Must provide a previously opened SnapshotContents");
      synchronized (zzaBE)
      {
        Object localObject2 = new FileOutputStream(this.zzakR.getParcelFileDescriptor().getFileDescriptor());
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream((OutputStream)localObject2);
        try
        {
          localObject2 = ((FileOutputStream)localObject2).getChannel();
          ((FileChannel)localObject2).position(paramInt1);
          localBufferedOutputStream.write(paramArrayOfByte, paramInt2, paramInt3);
          if (paramBoolean) {
            ((FileChannel)localObject2).truncate(paramArrayOfByte.length);
          }
          localBufferedOutputStream.flush();
          return true;
        }
        catch (IOException paramArrayOfByte)
        {
          GamesLog.zza("SnapshotContentsEntity", "Failed to write snapshot data", paramArrayOfByte);
          return false;
        }
      }
    }
  }
  
  public void close()
  {
    this.zzakR = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (!isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Cannot mutate closed contents!");
      return this.zzakR.getParcelFileDescriptor();
    }
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean isClosed()
  {
    return this.zzakR == null;
  }
  
  public boolean modifyBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return zza(paramInt1, paramArrayOfByte, paramInt2, paramArrayOfByte.length, false);
  }
  
  public byte[] readFully()
    throws IOException
  {
    boolean bool = false;
    if (!isClosed()) {
      bool = true;
    }
    zzx.zza(bool, "Must provide a previously opened Snapshot");
    synchronized (zzaBE)
    {
      FileInputStream localFileInputStream = new FileInputStream(this.zzakR.getParcelFileDescriptor().getFileDescriptor());
      Object localObject3 = new BufferedInputStream(localFileInputStream);
      try
      {
        localFileInputStream.getChannel().position(0L);
        localObject3 = zzmt.zza((InputStream)localObject3, false);
        localFileInputStream.getChannel().position(0L);
        return (byte[])localObject3;
      }
      catch (IOException localIOException)
      {
        GamesLog.zzb("SnapshotContentsEntity", "Failed to read snapshot data", localIOException);
        throw localIOException;
      }
    }
  }
  
  public boolean writeBytes(byte[] paramArrayOfByte)
  {
    return zza(0, paramArrayOfByte, 0, paramArrayOfByte.length, true);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotContentsEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public Contents zzqO()
  {
    return this.zzakR;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\snapshot\SnapshotContentsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */