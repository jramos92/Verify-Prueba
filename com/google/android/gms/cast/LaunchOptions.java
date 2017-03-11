package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class LaunchOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzd();
  private final int mVersionCode;
  private boolean zzVS;
  private String zzVT;
  
  public LaunchOptions()
  {
    this(1, false, zzf.zzb(Locale.getDefault()));
  }
  
  LaunchOptions(int paramInt, boolean paramBoolean, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzVS = paramBoolean;
    this.zzVT = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof LaunchOptions)) {
        return false;
      }
      paramObject = (LaunchOptions)paramObject;
    } while ((this.zzVS == ((LaunchOptions)paramObject).zzVS) && (zzf.zza(this.zzVT, ((LaunchOptions)paramObject).zzVT)));
    return false;
  }
  
  public String getLanguage()
  {
    return this.zzVT;
  }
  
  public boolean getRelaunchIfRunning()
  {
    return this.zzVS;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Boolean.valueOf(this.zzVS), this.zzVT });
  }
  
  public void setLanguage(String paramString)
  {
    this.zzVT = paramString;
  }
  
  public void setRelaunchIfRunning(boolean paramBoolean)
  {
    this.zzVS = paramBoolean;
  }
  
  public String toString()
  {
    return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[] { Boolean.valueOf(this.zzVS), this.zzVT });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private LaunchOptions zzVU = new LaunchOptions();
    
    public LaunchOptions build()
    {
      return this.zzVU;
    }
    
    public Builder setLocale(Locale paramLocale)
    {
      this.zzVU.setLanguage(zzf.zzb(paramLocale));
      return this;
    }
    
    public Builder setRelaunchIfRunning(boolean paramBoolean)
    {
      this.zzVU.setRelaunchIfRunning(paramBoolean);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\LaunchOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */