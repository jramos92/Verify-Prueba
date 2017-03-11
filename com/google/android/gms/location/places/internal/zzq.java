package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zza;

public class zzq
  implements PlacePhotoMetadata
{
  private int mIndex;
  private final int zzAG;
  private final int zzAH;
  private final String zzaHL;
  private final CharSequence zzaHM;
  
  public zzq(String paramString, int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    this.zzaHL = paramString;
    this.zzAG = paramInt1;
    this.zzAH = paramInt2;
    this.zzaHM = paramCharSequence;
    this.mIndex = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzq)) {
        return false;
      }
      paramObject = (zzq)paramObject;
    } while ((((zzq)paramObject).zzAG == this.zzAG) && (((zzq)paramObject).zzAH == this.zzAH) && (zzw.equal(((zzq)paramObject).zzaHL, this.zzaHL)) && (zzw.equal(((zzq)paramObject).zzaHM, this.zzaHM)));
    return false;
  }
  
  public CharSequence getAttributions()
  {
    return this.zzaHM;
  }
  
  public int getMaxHeight()
  {
    return this.zzAH;
  }
  
  public int getMaxWidth()
  {
    return this.zzAG;
  }
  
  public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient paramGoogleApiClient)
  {
    return getScaledPhoto(paramGoogleApiClient, getMaxWidth(), getMaxHeight());
  }
  
  public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient paramGoogleApiClient, final int paramInt1, final int paramInt2)
  {
    paramGoogleApiClient.zza(new zzf.zza(Places.zzaGz, paramGoogleApiClient)
    {
      protected void zza(zze paramAnonymouszze)
        throws RemoteException
      {
        paramAnonymouszze.zza(new zzf(this), zzq.zza(zzq.this), paramInt1, paramInt2, zzq.zzb(zzq.this));
      }
    });
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzAG), Integer.valueOf(this.zzAH), this.zzaHL, this.zzaHM });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public PlacePhotoMetadata zzxp()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */