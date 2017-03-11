package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SnapshotMetadataChangeEntity
  extends SnapshotMetadataChange
  implements SafeParcelable
{
  public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
  private final int mVersionCode;
  private final Long zzaBI;
  private final Uri zzaBK;
  private final Long zzaBL;
  private BitmapTeleporter zzaBM;
  private final String zzaqZ;
  
  SnapshotMetadataChangeEntity()
  {
    this(5, null, null, null, null, null);
  }
  
  SnapshotMetadataChangeEntity(int paramInt, String paramString, Long paramLong1, BitmapTeleporter paramBitmapTeleporter, Uri paramUri, Long paramLong2)
  {
    this.mVersionCode = paramInt;
    this.zzaqZ = paramString;
    this.zzaBL = paramLong1;
    this.zzaBM = paramBitmapTeleporter;
    this.zzaBK = paramUri;
    this.zzaBI = paramLong2;
    if (this.zzaBM != null) {
      if (this.zzaBK == null) {
        zzx.zza(bool1, "Cannot set both a URI and an image");
      }
    }
    while (this.zzaBK == null) {
      for (;;)
      {
        return;
        bool1 = false;
      }
    }
    if (this.zzaBM == null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      zzx.zza(bool1, "Cannot set both a URI and an image");
      return;
    }
  }
  
  SnapshotMetadataChangeEntity(String paramString, Long paramLong1, BitmapTeleporter paramBitmapTeleporter, Uri paramUri, Long paramLong2)
  {
    this(5, paramString, paramLong1, paramBitmapTeleporter, paramUri, paramLong2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getCoverImage()
  {
    if (this.zzaBM == null) {
      return null;
    }
    return this.zzaBM.zzos();
  }
  
  public Uri getCoverImageUri()
  {
    return this.zzaBK;
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public Long getPlayedTimeMillis()
  {
    return this.zzaBL;
  }
  
  public Long getProgressValue()
  {
    return this.zzaBI;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotMetadataChangeCreator.zza(this, paramParcel, paramInt);
  }
  
  public BitmapTeleporter zzvS()
  {
    return this.zzaBM;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\snapshot\SnapshotMetadataChangeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */