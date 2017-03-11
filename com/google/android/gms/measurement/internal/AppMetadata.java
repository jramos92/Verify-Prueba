package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class AppMetadata
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final String packageName;
  public final int versionCode;
  public final String zzaDC;
  public final String zzaLP;
  public final String zzaLQ;
  public final long zzaLR;
  public final long zzaLS;
  
  AppMetadata(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.versionCode = paramInt;
    this.packageName = paramString1;
    this.zzaLP = paramString2;
    this.zzaDC = paramString3;
    this.zzaLQ = paramString4;
    this.zzaLR = paramLong1;
    this.zzaLS = paramLong2;
  }
  
  AppMetadata(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    zzx.zzcr(paramString1);
    this.versionCode = 1;
    this.packageName = paramString1;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    }
    this.zzaLP = paramString1;
    this.zzaDC = paramString3;
    this.zzaLQ = paramString4;
    this.zzaLR = paramLong1;
    this.zzaLS = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\AppMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */