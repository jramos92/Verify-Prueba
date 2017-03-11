package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  private final int mVersionCode;
  private float zzaJS;
  private boolean zzaJT = true;
  private zzi zzaKA;
  private TileProvider zzaKB;
  private boolean zzaKC = true;
  
  public TileOverlayOptions()
  {
    this.mVersionCode = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzaKA = zzi.zza.zzcY(paramIBinder);
    if (this.zzaKA == null) {}
    for (paramIBinder = null;; paramIBinder = new TileProvider()
        {
          private final zzi zzaKD = TileOverlayOptions.zza(TileOverlayOptions.this);
          
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            try
            {
              Tile localTile = this.zzaKD.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
              return localTile;
            }
            catch (RemoteException localRemoteException) {}
            return null;
          }
        })
    {
      this.zzaKB = paramIBinder;
      this.zzaJT = paramBoolean1;
      this.zzaJS = paramFloat;
      this.zzaKC = paramBoolean2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.zzaKC = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return this.zzaKC;
  }
  
  public TileProvider getTileProvider()
  {
    return this.zzaKB;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public float getZIndex()
  {
    return this.zzaJS;
  }
  
  public boolean isVisible()
  {
    return this.zzaJT;
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.zzaKB = paramTileProvider;
    if (this.zzaKB == null) {}
    for (paramTileProvider = null;; paramTileProvider = new zzi.zza()
        {
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
        })
    {
      this.zzaKA = paramTileProvider;
      return this;
    }
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.zzaJT = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.zzaJS = paramFloat;
    return this;
  }
  
  IBinder zzyb()
  {
    return this.zzaKA.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */