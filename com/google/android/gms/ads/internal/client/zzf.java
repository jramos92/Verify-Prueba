package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.zzgr;
import java.util.ArrayList;
import java.util.List;

@zzgr
public final class zzf
{
  private Bundle mExtras;
  private Location zzaX;
  private boolean zzoN;
  private long zzsQ;
  private int zzsR;
  private List<String> zzsS;
  private boolean zzsT;
  private int zzsU;
  private String zzsV;
  private SearchAdRequestParcel zzsW;
  private String zzsX;
  private Bundle zzsY;
  private Bundle zzsZ;
  private List<String> zzta;
  private String zztb;
  private String zztc;
  
  public zzf()
  {
    this.zzsQ = -1L;
    this.mExtras = new Bundle();
    this.zzsR = -1;
    this.zzsS = new ArrayList();
    this.zzsT = false;
    this.zzsU = -1;
    this.zzoN = false;
    this.zzsV = null;
    this.zzsW = null;
    this.zzaX = null;
    this.zzsX = null;
    this.zzsY = new Bundle();
    this.zzsZ = new Bundle();
    this.zzta = new ArrayList();
    this.zztb = null;
    this.zztc = null;
  }
  
  public zzf(AdRequestParcel paramAdRequestParcel)
  {
    this.zzsQ = paramAdRequestParcel.zzsB;
    this.mExtras = paramAdRequestParcel.extras;
    this.zzsR = paramAdRequestParcel.zzsC;
    this.zzsS = paramAdRequestParcel.zzsD;
    this.zzsT = paramAdRequestParcel.zzsE;
    this.zzsU = paramAdRequestParcel.zzsF;
    this.zzoN = paramAdRequestParcel.zzsG;
    this.zzsV = paramAdRequestParcel.zzsH;
    this.zzsW = paramAdRequestParcel.zzsI;
    this.zzaX = paramAdRequestParcel.zzsJ;
    this.zzsX = paramAdRequestParcel.zzsK;
    this.zzsY = paramAdRequestParcel.zzsL;
    this.zzsZ = paramAdRequestParcel.zzsM;
    this.zzta = paramAdRequestParcel.zzsN;
    this.zztb = paramAdRequestParcel.zzsO;
    this.zztc = paramAdRequestParcel.zzsP;
  }
  
  public zzf zza(Location paramLocation)
  {
    this.zzaX = paramLocation;
    return this;
  }
  
  public AdRequestParcel zzcA()
  {
    return new AdRequestParcel(6, this.zzsQ, this.mExtras, this.zzsR, this.zzsS, this.zzsT, this.zzsU, this.zzoN, this.zzsV, this.zzsW, this.zzaX, this.zzsX, this.zzsY, this.zzsZ, this.zzta, this.zztb, this.zztc);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */