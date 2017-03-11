package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class InterstitialAdParameterParcel
  implements SafeParcelable
{
  public static final zzl CREATOR = new zzl();
  public final int versionCode;
  public final boolean zzpt;
  public final boolean zzpu;
  public final String zzpv;
  public final boolean zzpw;
  public final float zzpx;
  
  InterstitialAdParameterParcel(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat)
  {
    this.versionCode = paramInt;
    this.zzpt = paramBoolean1;
    this.zzpu = paramBoolean2;
    this.zzpv = paramString;
    this.zzpw = paramBoolean3;
    this.zzpx = paramFloat;
  }
  
  public InterstitialAdParameterParcel(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat)
  {
    this(2, paramBoolean1, paramBoolean2, paramString, paramBoolean3, paramFloat);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\InterstitialAdParameterParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */