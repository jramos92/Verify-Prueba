package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;
import java.util.Collections;
import java.util.List;

@zzgr
public final class AdRequestInfoParcel
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final ApplicationInfo applicationInfo;
  public final int versionCode;
  public final String zzEA;
  public final long zzEB;
  public final String zzEC;
  public final List<String> zzED;
  public final List<String> zzEE;
  public final long zzEF;
  public final CapabilityParcel zzEG;
  public final String zzEH;
  public final Bundle zzEm;
  public final AdRequestParcel zzEn;
  public final PackageInfo zzEo;
  public final String zzEp;
  public final String zzEq;
  public final String zzEr;
  public final Bundle zzEs;
  public final int zzEt;
  public final Bundle zzEu;
  public final boolean zzEv;
  public final Messenger zzEw;
  public final int zzEx;
  public final int zzEy;
  public final float zzEz;
  public final NativeAdOptionsParcel zzqB;
  public final List<String> zzqD;
  public final String zzqg;
  public final String zzqh;
  public final VersionInfoParcel zzqj;
  public final AdSizeParcel zzqn;
  
  AdRequestInfoParcel(int paramInt1, Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt2, List<String> paramList1, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt3, int paramInt4, float paramFloat, String paramString5, long paramLong1, String paramString6, List<String> paramList2, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList3, long paramLong2, CapabilityParcel paramCapabilityParcel, String paramString8)
  {
    this.versionCode = paramInt1;
    this.zzEm = paramBundle1;
    this.zzEn = paramAdRequestParcel;
    this.zzqn = paramAdSizeParcel;
    this.zzqh = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.zzEo = paramPackageInfo;
    this.zzEp = paramString2;
    this.zzEq = paramString3;
    this.zzEr = paramString4;
    this.zzqj = paramVersionInfoParcel;
    this.zzEs = paramBundle2;
    this.zzEt = paramInt2;
    this.zzqD = paramList1;
    if (paramList3 == null)
    {
      paramBundle1 = Collections.emptyList();
      this.zzEE = paramBundle1;
      this.zzEu = paramBundle3;
      this.zzEv = paramBoolean;
      this.zzEw = paramMessenger;
      this.zzEx = paramInt3;
      this.zzEy = paramInt4;
      this.zzEz = paramFloat;
      this.zzEA = paramString5;
      this.zzEB = paramLong1;
      this.zzEC = paramString6;
      if (paramList2 != null) {
        break label207;
      }
    }
    label207:
    for (paramBundle1 = Collections.emptyList();; paramBundle1 = Collections.unmodifiableList(paramList2))
    {
      this.zzED = paramBundle1;
      this.zzqg = paramString7;
      this.zzqB = paramNativeAdOptionsParcel;
      this.zzEF = paramLong2;
      this.zzEG = paramCapabilityParcel;
      this.zzEH = paramString8;
      return;
      paramBundle1 = Collections.unmodifiableList(paramList3);
      break;
    }
  }
  
  public AdRequestInfoParcel(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt1, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt2, int paramInt3, float paramFloat, String paramString5, long paramLong1, String paramString6, List<String> paramList3, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, long paramLong2, CapabilityParcel paramCapabilityParcel, String paramString8)
  {
    this(12, paramBundle1, paramAdRequestParcel, paramAdSizeParcel, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramVersionInfoParcel, paramBundle2, paramInt1, paramList1, paramBundle3, paramBoolean, paramMessenger, paramInt2, paramInt3, paramFloat, paramString5, paramLong1, paramString6, paramList3, paramString7, paramNativeAdOptionsParcel, paramList2, paramLong2, paramCapabilityParcel, paramString8);
  }
  
  public AdRequestInfoParcel(zza paramzza, String paramString, long paramLong)
  {
    this(paramzza.zzEm, paramzza.zzEn, paramzza.zzqn, paramzza.zzqh, paramzza.applicationInfo, paramzza.zzEo, paramString, paramzza.zzEq, paramzza.zzEr, paramzza.zzqj, paramzza.zzEs, paramzza.zzEt, paramzza.zzqD, paramzza.zzEE, paramzza.zzEu, paramzza.zzEv, paramzza.zzEw, paramzza.zzEx, paramzza.zzEy, paramzza.zzEz, paramzza.zzEA, paramzza.zzEB, paramzza.zzEC, paramzza.zzED, paramzza.zzqg, paramzza.zzqB, paramLong, paramzza.zzEG, paramzza.zzEH);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  @zzgr
  public static final class zza
  {
    public final ApplicationInfo applicationInfo;
    public final String zzEA;
    public final long zzEB;
    public final String zzEC;
    public final List<String> zzED;
    public final List<String> zzEE;
    public final CapabilityParcel zzEG;
    public final String zzEH;
    public final Bundle zzEm;
    public final AdRequestParcel zzEn;
    public final PackageInfo zzEo;
    public final String zzEq;
    public final String zzEr;
    public final Bundle zzEs;
    public final int zzEt;
    public final Bundle zzEu;
    public final boolean zzEv;
    public final Messenger zzEw;
    public final int zzEx;
    public final int zzEy;
    public final float zzEz;
    public final NativeAdOptionsParcel zzqB;
    public final List<String> zzqD;
    public final String zzqg;
    public final String zzqh;
    public final VersionInfoParcel zzqj;
    public final AdSizeParcel zzqn;
    
    public zza(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt1, int paramInt2, float paramFloat, String paramString4, long paramLong, String paramString5, List<String> paramList3, String paramString6, NativeAdOptionsParcel paramNativeAdOptionsParcel, CapabilityParcel paramCapabilityParcel, String paramString7)
    {
      this.zzEm = paramBundle1;
      this.zzEn = paramAdRequestParcel;
      this.zzqn = paramAdSizeParcel;
      this.zzqh = paramString1;
      this.applicationInfo = paramApplicationInfo;
      this.zzEo = paramPackageInfo;
      this.zzEq = paramString2;
      this.zzEr = paramString3;
      this.zzqj = paramVersionInfoParcel;
      this.zzEs = paramBundle2;
      this.zzEv = paramBoolean;
      this.zzEw = paramMessenger;
      this.zzEx = paramInt1;
      this.zzEy = paramInt2;
      this.zzEz = paramFloat;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        this.zzEt = 3;
        this.zzqD = paramList1;
      }
      for (this.zzEE = paramList2;; this.zzEE = null)
      {
        this.zzEu = paramBundle3;
        this.zzEA = paramString4;
        this.zzEB = paramLong;
        this.zzEC = paramString5;
        this.zzED = paramList3;
        this.zzqg = paramString6;
        this.zzqB = paramNativeAdOptionsParcel;
        this.zzEG = paramCapabilityParcel;
        this.zzEH = paramString7;
        return;
        this.zzEt = 0;
        this.zzqD = null;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\request\AdRequestInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */