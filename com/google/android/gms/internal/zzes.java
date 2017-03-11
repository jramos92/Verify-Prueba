package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzgr
public final class zzes
  implements MediationAdRequest
{
  private final Date zzaT;
  private final Set<String> zzaV;
  private final boolean zzaW;
  private final Location zzaX;
  private final int zzsR;
  private final int zzzI;
  
  public zzes(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean, int paramInt2)
  {
    this.zzaT = paramDate;
    this.zzsR = paramInt1;
    this.zzaV = paramSet;
    this.zzaX = paramLocation;
    this.zzaW = paramBoolean;
    this.zzzI = paramInt2;
  }
  
  public Date getBirthday()
  {
    return this.zzaT;
  }
  
  public int getGender()
  {
    return this.zzsR;
  }
  
  public Set<String> getKeywords()
  {
    return this.zzaV;
  }
  
  public Location getLocation()
  {
    return this.zzaX;
  }
  
  public boolean isTesting()
  {
    return this.zzaW;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return this.zzzI;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */