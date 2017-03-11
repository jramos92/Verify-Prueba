package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public abstract class SnapshotMetadataChange
{
  public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();
  
  public abstract Bitmap getCoverImage();
  
  public abstract String getDescription();
  
  public abstract Long getPlayedTimeMillis();
  
  public abstract Long getProgressValue();
  
  public abstract BitmapTeleporter zzvS();
  
  public static final class Builder
  {
    private Long zzaBH;
    private Long zzaBI;
    private BitmapTeleporter zzaBJ;
    private Uri zzaBK;
    private String zzaqZ;
    
    public SnapshotMetadataChange build()
    {
      return new SnapshotMetadataChangeEntity(this.zzaqZ, this.zzaBH, this.zzaBJ, this.zzaBK, this.zzaBI);
    }
    
    public Builder fromMetadata(SnapshotMetadata paramSnapshotMetadata)
    {
      this.zzaqZ = paramSnapshotMetadata.getDescription();
      this.zzaBH = Long.valueOf(paramSnapshotMetadata.getPlayedTime());
      this.zzaBI = Long.valueOf(paramSnapshotMetadata.getProgressValue());
      if (this.zzaBH.longValue() == -1L) {
        this.zzaBH = null;
      }
      this.zzaBK = paramSnapshotMetadata.getCoverImageUri();
      if (this.zzaBK != null) {
        this.zzaBJ = null;
      }
      return this;
    }
    
    public Builder setCoverImage(Bitmap paramBitmap)
    {
      this.zzaBJ = new BitmapTeleporter(paramBitmap);
      this.zzaBK = null;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.zzaqZ = paramString;
      return this;
    }
    
    public Builder setPlayedTimeMillis(long paramLong)
    {
      this.zzaBH = Long.valueOf(paramLong);
      return this;
    }
    
    public Builder setProgressValue(long paramLong)
    {
      this.zzaBI = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\snapshot\SnapshotMetadataChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */