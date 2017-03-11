package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
public final class AdRequestParcel
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public final Bundle extras;
  public final int versionCode;
  public final long zzsB;
  public final int zzsC;
  public final List<String> zzsD;
  public final boolean zzsE;
  public final int zzsF;
  public final boolean zzsG;
  public final String zzsH;
  public final SearchAdRequestParcel zzsI;
  public final Location zzsJ;
  public final String zzsK;
  public final Bundle zzsL;
  public final Bundle zzsM;
  public final List<String> zzsN;
  public final String zzsO;
  public final String zzsP;
  
  public AdRequestParcel(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, SearchAdRequestParcel paramSearchAdRequestParcel, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List<String> paramList2, String paramString3, String paramString4)
  {
    this.versionCode = paramInt1;
    this.zzsB = paramLong;
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    this.extras = localBundle;
    this.zzsC = paramInt2;
    this.zzsD = paramList1;
    this.zzsE = paramBoolean1;
    this.zzsF = paramInt3;
    this.zzsG = paramBoolean2;
    this.zzsH = paramString1;
    this.zzsI = paramSearchAdRequestParcel;
    this.zzsJ = paramLocation;
    this.zzsK = paramString2;
    this.zzsL = paramBundle2;
    this.zzsM = paramBundle3;
    this.zzsN = paramList2;
    this.zzsO = paramString3;
    this.zzsP = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdRequestParcel)) {}
    do
    {
      return false;
      paramObject = (AdRequestParcel)paramObject;
    } while ((this.versionCode != ((AdRequestParcel)paramObject).versionCode) || (this.zzsB != ((AdRequestParcel)paramObject).zzsB) || (!zzw.equal(this.extras, ((AdRequestParcel)paramObject).extras)) || (this.zzsC != ((AdRequestParcel)paramObject).zzsC) || (!zzw.equal(this.zzsD, ((AdRequestParcel)paramObject).zzsD)) || (this.zzsE != ((AdRequestParcel)paramObject).zzsE) || (this.zzsF != ((AdRequestParcel)paramObject).zzsF) || (this.zzsG != ((AdRequestParcel)paramObject).zzsG) || (!zzw.equal(this.zzsH, ((AdRequestParcel)paramObject).zzsH)) || (!zzw.equal(this.zzsI, ((AdRequestParcel)paramObject).zzsI)) || (!zzw.equal(this.zzsJ, ((AdRequestParcel)paramObject).zzsJ)) || (!zzw.equal(this.zzsK, ((AdRequestParcel)paramObject).zzsK)) || (!zzw.equal(this.zzsL, ((AdRequestParcel)paramObject).zzsL)) || (!zzw.equal(this.zzsM, ((AdRequestParcel)paramObject).zzsM)) || (!zzw.equal(this.zzsN, ((AdRequestParcel)paramObject).zzsN)) || (!zzw.equal(this.zzsO, ((AdRequestParcel)paramObject).zzsO)) || (!zzw.equal(this.zzsP, ((AdRequestParcel)paramObject).zzsP)));
    return true;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.versionCode), Long.valueOf(this.zzsB), this.extras, Integer.valueOf(this.zzsC), this.zzsD, Boolean.valueOf(this.zzsE), Integer.valueOf(this.zzsF), Boolean.valueOf(this.zzsG), this.zzsH, this.zzsI, this.zzsJ, this.zzsK, this.zzsL, this.zzsM, this.zzsN, this.zzsO, this.zzsP });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\AdRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */