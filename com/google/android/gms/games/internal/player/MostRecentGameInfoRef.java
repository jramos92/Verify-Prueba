package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class MostRecentGameInfoRef
  extends zzc
  implements MostRecentGameInfo
{
  private final PlayerColumnNames zzauo;
  
  public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, PlayerColumnNames paramPlayerColumnNames)
  {
    super(paramDataHolder, paramInt);
    this.zzauo = paramPlayerColumnNames;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return MostRecentGameInfoEntity.zza(this, paramObject);
  }
  
  public int hashCode()
  {
    return MostRecentGameInfoEntity.zza(this);
  }
  
  public String toString()
  {
    return MostRecentGameInfoEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MostRecentGameInfoEntity)zzvC()).writeToParcel(paramParcel, paramInt);
  }
  
  public Uri zzvA()
  {
    return zzcf(this.zzauo.zzazM);
  }
  
  public Uri zzvB()
  {
    return zzcf(this.zzauo.zzazN);
  }
  
  public MostRecentGameInfo zzvC()
  {
    return new MostRecentGameInfoEntity(this);
  }
  
  public String zzvw()
  {
    return getString(this.zzauo.zzazI);
  }
  
  public String zzvx()
  {
    return getString(this.zzauo.zzazJ);
  }
  
  public long zzvy()
  {
    return getLong(this.zzauo.zzazK);
  }
  
  public Uri zzvz()
  {
    return zzcf(this.zzauo.zzazL);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\player\MostRecentGameInfoRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */