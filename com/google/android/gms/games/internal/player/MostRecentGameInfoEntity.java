package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
  private final int mVersionCode;
  private final String zzazk;
  private final String zzazl;
  private final long zzazm;
  private final Uri zzazn;
  private final Uri zzazo;
  private final Uri zzazp;
  
  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.mVersionCode = paramInt;
    this.zzazk = paramString1;
    this.zzazl = paramString2;
    this.zzazm = paramLong;
    this.zzazn = paramUri1;
    this.zzazo = paramUri2;
    this.zzazp = paramUri3;
  }
  
  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.mVersionCode = 2;
    this.zzazk = paramMostRecentGameInfo.zzvw();
    this.zzazl = paramMostRecentGameInfo.zzvx();
    this.zzazm = paramMostRecentGameInfo.zzvy();
    this.zzazn = paramMostRecentGameInfo.zzvz();
    this.zzazo = paramMostRecentGameInfo.zzvA();
    this.zzazp = paramMostRecentGameInfo.zzvB();
  }
  
  static int zza(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return zzw.hashCode(new Object[] { paramMostRecentGameInfo.zzvw(), paramMostRecentGameInfo.zzvx(), Long.valueOf(paramMostRecentGameInfo.zzvy()), paramMostRecentGameInfo.zzvz(), paramMostRecentGameInfo.zzvA(), paramMostRecentGameInfo.zzvB() });
  }
  
  static boolean zza(MostRecentGameInfo paramMostRecentGameInfo, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof MostRecentGameInfo)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramMostRecentGameInfo == paramObject);
      paramObject = (MostRecentGameInfo)paramObject;
      if ((!zzw.equal(((MostRecentGameInfo)paramObject).zzvw(), paramMostRecentGameInfo.zzvw())) || (!zzw.equal(((MostRecentGameInfo)paramObject).zzvx(), paramMostRecentGameInfo.zzvx())) || (!zzw.equal(Long.valueOf(((MostRecentGameInfo)paramObject).zzvy()), Long.valueOf(paramMostRecentGameInfo.zzvy()))) || (!zzw.equal(((MostRecentGameInfo)paramObject).zzvz(), paramMostRecentGameInfo.zzvz())) || (!zzw.equal(((MostRecentGameInfo)paramObject).zzvA(), paramMostRecentGameInfo.zzvA()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((MostRecentGameInfo)paramObject).zzvB(), paramMostRecentGameInfo.zzvB()));
    return false;
  }
  
  static String zzb(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return zzw.zzv(paramMostRecentGameInfo).zzg("GameId", paramMostRecentGameInfo.zzvw()).zzg("GameName", paramMostRecentGameInfo.zzvx()).zzg("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.zzvy())).zzg("GameIconUri", paramMostRecentGameInfo.zzvz()).zzg("GameHiResUri", paramMostRecentGameInfo.zzvA()).zzg("GameFeaturedUri", paramMostRecentGameInfo.zzvB()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    MostRecentGameInfoEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public Uri zzvA()
  {
    return this.zzazo;
  }
  
  public Uri zzvB()
  {
    return this.zzazp;
  }
  
  public MostRecentGameInfo zzvC()
  {
    return this;
  }
  
  public String zzvw()
  {
    return this.zzazk;
  }
  
  public String zzvx()
  {
    return this.zzazl;
  }
  
  public long zzvy()
  {
    return this.zzazm;
  }
  
  public Uri zzvz()
  {
    return this.zzazn;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\player\MostRecentGameInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */