package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;

@zzgr
public final class AdOverlayInfoParcel
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final int orientation;
  public final String url;
  public final int versionCode;
  public final AdLauncherIntentInfoParcel zzBA;
  public final zza zzBB;
  public final zzg zzBC;
  public final zziz zzBD;
  public final zzdg zzBE;
  public final String zzBF;
  public final boolean zzBG;
  public final String zzBH;
  public final zzn zzBI;
  public final int zzBJ;
  public final zzdm zzBK;
  public final String zzBL;
  public final InterstitialAdParameterParcel zzBM;
  public final VersionInfoParcel zzqj;
  
  AdOverlayInfoParcel(int paramInt1, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, VersionInfoParcel paramVersionInfoParcel, IBinder paramIBinder6, String paramString4, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    this.versionCode = paramInt1;
    this.zzBA = paramAdLauncherIntentInfoParcel;
    this.zzBB = ((zza)zze.zzp(zzd.zza.zzbk(paramIBinder1)));
    this.zzBC = ((zzg)zze.zzp(zzd.zza.zzbk(paramIBinder2)));
    this.zzBD = ((zziz)zze.zzp(zzd.zza.zzbk(paramIBinder3)));
    this.zzBE = ((zzdg)zze.zzp(zzd.zza.zzbk(paramIBinder4)));
    this.zzBF = paramString1;
    this.zzBG = paramBoolean;
    this.zzBH = paramString2;
    this.zzBI = ((zzn)zze.zzp(zzd.zza.zzbk(paramIBinder5)));
    this.orientation = paramInt2;
    this.zzBJ = paramInt3;
    this.url = paramString3;
    this.zzqj = paramVersionInfoParcel;
    this.zzBK = ((zzdm)zze.zzp(zzd.zza.zzbk(paramIBinder6)));
    this.zzBL = paramString4;
    this.zzBM = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzn paramzzn, zziz paramzziz, int paramInt, VersionInfoParcel paramVersionInfoParcel, String paramString, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    this.versionCode = 4;
    this.zzBA = null;
    this.zzBB = paramzza;
    this.zzBC = paramzzg;
    this.zzBD = paramzziz;
    this.zzBE = null;
    this.zzBF = null;
    this.zzBG = false;
    this.zzBH = null;
    this.zzBI = paramzzn;
    this.orientation = paramInt;
    this.zzBJ = 1;
    this.url = null;
    this.zzqj = paramVersionInfoParcel;
    this.zzBK = null;
    this.zzBL = paramString;
    this.zzBM = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzn paramzzn, zziz paramzziz, boolean paramBoolean, int paramInt, VersionInfoParcel paramVersionInfoParcel)
  {
    this.versionCode = 4;
    this.zzBA = null;
    this.zzBB = paramzza;
    this.zzBC = paramzzg;
    this.zzBD = paramzziz;
    this.zzBE = null;
    this.zzBF = null;
    this.zzBG = paramBoolean;
    this.zzBH = null;
    this.zzBI = paramzzn;
    this.orientation = paramInt;
    this.zzBJ = 2;
    this.url = null;
    this.zzqj = paramVersionInfoParcel;
    this.zzBK = null;
    this.zzBL = null;
    this.zzBM = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzdg paramzzdg, zzn paramzzn, zziz paramzziz, boolean paramBoolean, int paramInt, String paramString, VersionInfoParcel paramVersionInfoParcel, zzdm paramzzdm)
  {
    this.versionCode = 4;
    this.zzBA = null;
    this.zzBB = paramzza;
    this.zzBC = paramzzg;
    this.zzBD = paramzziz;
    this.zzBE = paramzzdg;
    this.zzBF = null;
    this.zzBG = paramBoolean;
    this.zzBH = null;
    this.zzBI = paramzzn;
    this.orientation = paramInt;
    this.zzBJ = 3;
    this.url = paramString;
    this.zzqj = paramVersionInfoParcel;
    this.zzBK = paramzzdm;
    this.zzBL = null;
    this.zzBM = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzdg paramzzdg, zzn paramzzn, zziz paramzziz, boolean paramBoolean, int paramInt, String paramString1, String paramString2, VersionInfoParcel paramVersionInfoParcel, zzdm paramzzdm)
  {
    this.versionCode = 4;
    this.zzBA = null;
    this.zzBB = paramzza;
    this.zzBC = paramzzg;
    this.zzBD = paramzziz;
    this.zzBE = paramzzdg;
    this.zzBF = paramString2;
    this.zzBG = paramBoolean;
    this.zzBH = paramString1;
    this.zzBI = paramzzn;
    this.orientation = paramInt;
    this.zzBJ = 3;
    this.url = null;
    this.zzqj = paramVersionInfoParcel;
    this.zzBK = paramzzdm;
    this.zzBL = null;
    this.zzBM = null;
  }
  
  public AdOverlayInfoParcel(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, zza paramzza, zzg paramzzg, zzn paramzzn, VersionInfoParcel paramVersionInfoParcel)
  {
    this.versionCode = 4;
    this.zzBA = paramAdLauncherIntentInfoParcel;
    this.zzBB = paramzza;
    this.zzBC = paramzzg;
    this.zzBD = null;
    this.zzBE = null;
    this.zzBF = null;
    this.zzBG = false;
    this.zzBH = null;
    this.zzBI = paramzzn;
    this.orientation = -1;
    this.zzBJ = 4;
    this.url = null;
    this.zzqj = paramVersionInfoParcel;
    this.zzBK = null;
    this.zzBL = null;
    this.zzBM = null;
  }
  
  public static void zza(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public static AdOverlayInfoParcel zzb(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      paramIntent = (AdOverlayInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzeK()
  {
    return zze.zzy(this.zzBB).asBinder();
  }
  
  IBinder zzeL()
  {
    return zze.zzy(this.zzBC).asBinder();
  }
  
  IBinder zzeM()
  {
    return zze.zzy(this.zzBD).asBinder();
  }
  
  IBinder zzeN()
  {
    return zze.zzy(this.zzBE).asBinder();
  }
  
  IBinder zzeO()
  {
    return zze.zzy(this.zzBK).asBinder();
  }
  
  IBinder zzeP()
  {
    return zze.zzy(this.zzBI).asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\AdOverlayInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */