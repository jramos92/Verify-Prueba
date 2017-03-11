package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Arrays;

public class PlusSession
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  private final int mVersionCode;
  private final String zzRs;
  private final String zzYi;
  private final String zzaSA;
  private final String zzaSB;
  private final String zzaSC;
  private final PlusCommonExtras zzaSD;
  private final String[] zzaSx;
  private final String[] zzaSy;
  private final String[] zzaSz;
  
  PlusSession(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.mVersionCode = paramInt;
    this.zzRs = paramString1;
    this.zzaSx = paramArrayOfString1;
    this.zzaSy = paramArrayOfString2;
    this.zzaSz = paramArrayOfString3;
    this.zzaSA = paramString2;
    this.zzaSB = paramString3;
    this.zzYi = paramString4;
    this.zzaSC = paramString5;
    this.zzaSD = paramPlusCommonExtras;
  }
  
  public PlusSession(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras)
  {
    this.mVersionCode = 1;
    this.zzRs = paramString1;
    this.zzaSx = paramArrayOfString1;
    this.zzaSy = paramArrayOfString2;
    this.zzaSz = paramArrayOfString3;
    this.zzaSA = paramString2;
    this.zzaSB = paramString3;
    this.zzYi = paramString4;
    this.zzaSC = null;
    this.zzaSD = paramPlusCommonExtras;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusSession)) {}
    do
    {
      return false;
      paramObject = (PlusSession)paramObject;
    } while ((this.mVersionCode != ((PlusSession)paramObject).mVersionCode) || (!zzw.equal(this.zzRs, ((PlusSession)paramObject).zzRs)) || (!Arrays.equals(this.zzaSx, ((PlusSession)paramObject).zzaSx)) || (!Arrays.equals(this.zzaSy, ((PlusSession)paramObject).zzaSy)) || (!Arrays.equals(this.zzaSz, ((PlusSession)paramObject).zzaSz)) || (!zzw.equal(this.zzaSA, ((PlusSession)paramObject).zzaSA)) || (!zzw.equal(this.zzaSB, ((PlusSession)paramObject).zzaSB)) || (!zzw.equal(this.zzYi, ((PlusSession)paramObject).zzYi)) || (!zzw.equal(this.zzaSC, ((PlusSession)paramObject).zzaSC)) || (!zzw.equal(this.zzaSD, ((PlusSession)paramObject).zzaSD)));
    return true;
  }
  
  public String getAccountName()
  {
    return this.zzRs;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.zzRs, this.zzaSx, this.zzaSy, this.zzaSz, this.zzaSA, this.zzaSB, this.zzYi, this.zzaSC, this.zzaSD });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("accountName", this.zzRs).zzg("requestedScopes", this.zzaSx).zzg("visibleActivities", this.zzaSy).zzg("requiredFeatures", this.zzaSz).zzg("packageNameForAuth", this.zzaSA).zzg("callingPackageName", this.zzaSB).zzg("applicationName", this.zzYi).zzg("extra", this.zzaSD.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String[] zzBC()
  {
    return this.zzaSx;
  }
  
  public String[] zzBD()
  {
    return this.zzaSy;
  }
  
  public String[] zzBE()
  {
    return this.zzaSz;
  }
  
  public String zzBF()
  {
    return this.zzaSA;
  }
  
  public String zzBG()
  {
    return this.zzaSB;
  }
  
  public String zzBH()
  {
    return this.zzaSC;
  }
  
  public PlusCommonExtras zzBI()
  {
    return this.zzaSD;
  }
  
  public Bundle zzBJ()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
    this.zzaSD.zzB(localBundle);
    return localBundle;
  }
  
  public String zzmH()
  {
    return this.zzYi;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\PlusSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */