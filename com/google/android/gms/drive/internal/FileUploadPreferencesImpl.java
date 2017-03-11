package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

public final class FileUploadPreferencesImpl
  implements SafeParcelable, FileUploadPreferences
{
  public static final Parcelable.Creator<FileUploadPreferencesImpl> CREATOR = new zzag();
  final int mVersionCode;
  int zzalx;
  int zzaly;
  boolean zzalz;
  
  FileUploadPreferencesImpl(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzalx = paramInt2;
    this.zzaly = paramInt3;
    this.zzalz = paramBoolean;
  }
  
  public static boolean zzcS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzcT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getBatteryUsagePreference()
  {
    if (!zzcT(this.zzaly)) {
      return 0;
    }
    return this.zzaly;
  }
  
  public int getNetworkTypePreference()
  {
    if (!zzcS(this.zzalx)) {
      return 0;
    }
    return this.zzalx;
  }
  
  public boolean isRoamingAllowed()
  {
    return this.zzalz;
  }
  
  public void setBatteryUsagePreference(int paramInt)
  {
    if (!zzcT(paramInt)) {
      throw new IllegalArgumentException("Invalid battery usage preference value.");
    }
    this.zzaly = paramInt;
  }
  
  public void setNetworkTypePreference(int paramInt)
  {
    if (!zzcS(paramInt)) {
      throw new IllegalArgumentException("Invalid data connection preference value.");
    }
    this.zzalx = paramInt;
  }
  
  public void setRoamingAllowed(boolean paramBoolean)
  {
    this.zzalz = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzag.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\FileUploadPreferencesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */