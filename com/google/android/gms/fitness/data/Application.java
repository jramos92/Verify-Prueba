package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class Application
  implements SafeParcelable
{
  public static final Parcelable.Creator<Application> CREATOR = new zza();
  public static final Application zzapS = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
  private final int mVersionCode;
  private final String zzQe;
  private final String zzYk;
  private final String zzapT;
  
  Application(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.zzQe = ((String)zzx.zzw(paramString1));
    this.zzYk = "";
    this.zzapT = paramString3;
  }
  
  public Application(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, "", paramString3);
  }
  
  private boolean zza(Application paramApplication)
  {
    return (this.zzQe.equals(paramApplication.zzQe)) && (zzw.equal(this.zzYk, paramApplication.zzYk)) && (zzw.equal(this.zzapT, paramApplication.zzapT));
  }
  
  public static Application zzcP(String paramString)
  {
    return zze(paramString, null, null);
  }
  
  public static Application zze(String paramString1, String paramString2, String paramString3)
  {
    if ("com.google.android.gms".equals(paramString1)) {
      return zzapS;
    }
    return new Application(paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Application)) && (zza((Application)paramObject)));
  }
  
  public String getPackageName()
  {
    return this.zzQe;
  }
  
  public String getVersion()
  {
    return this.zzYk;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzQe, this.zzYk, this.zzapT });
  }
  
  public String toString()
  {
    return String.format("Application{%s:%s:%s}", new Object[] { this.zzQe, this.zzYk, this.zzapT });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzsf()
  {
    return this.zzapT;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\Application.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */