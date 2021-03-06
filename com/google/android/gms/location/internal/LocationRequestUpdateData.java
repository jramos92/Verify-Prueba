package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzc.zza;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;

public class LocationRequestUpdateData
  implements SafeParcelable
{
  public static final zzn CREATOR = new zzn();
  PendingIntent mPendingIntent;
  private final int mVersionCode;
  int zzaFJ;
  LocationRequestInternal zzaFK;
  zzd zzaFL;
  zzc zzaFM;
  zzg zzaFN;
  
  LocationRequestUpdateData(int paramInt1, int paramInt2, LocationRequestInternal paramLocationRequestInternal, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    this.mVersionCode = paramInt1;
    this.zzaFJ = paramInt2;
    this.zzaFK = paramLocationRequestInternal;
    if (paramIBinder1 == null)
    {
      paramLocationRequestInternal = null;
      this.zzaFL = paramLocationRequestInternal;
      this.mPendingIntent = paramPendingIntent;
      if (paramIBinder2 != null) {
        break label75;
      }
      paramLocationRequestInternal = null;
      label47:
      this.zzaFM = paramLocationRequestInternal;
      if (paramIBinder3 != null) {
        break label84;
      }
    }
    label75:
    label84:
    for (paramLocationRequestInternal = (LocationRequestInternal)localObject;; paramLocationRequestInternal = zzg.zza.zzbZ(paramIBinder3))
    {
      this.zzaFN = paramLocationRequestInternal;
      return;
      paramLocationRequestInternal = zzd.zza.zzbX(paramIBinder1);
      break;
      paramLocationRequestInternal = zzc.zza.zzbW(paramIBinder2);
      break label47;
    }
  }
  
  public static LocationRequestUpdateData zza(LocationRequestInternal paramLocationRequestInternal, PendingIntent paramPendingIntent, zzg paramzzg)
  {
    if (paramzzg != null) {}
    for (paramzzg = paramzzg.asBinder();; paramzzg = null) {
      return new LocationRequestUpdateData(1, 1, paramLocationRequestInternal, null, paramPendingIntent, null, paramzzg);
    }
  }
  
  public static LocationRequestUpdateData zza(LocationRequestInternal paramLocationRequestInternal, zzc paramzzc, zzg paramzzg)
  {
    IBinder localIBinder = paramzzc.asBinder();
    if (paramzzg != null) {}
    for (paramzzc = paramzzg.asBinder();; paramzzc = null) {
      return new LocationRequestUpdateData(1, 1, paramLocationRequestInternal, null, null, localIBinder, paramzzc);
    }
  }
  
  public static LocationRequestUpdateData zza(LocationRequestInternal paramLocationRequestInternal, zzd paramzzd, zzg paramzzg)
  {
    IBinder localIBinder = paramzzd.asBinder();
    if (paramzzg != null) {}
    for (paramzzd = paramzzg.asBinder();; paramzzd = null) {
      return new LocationRequestUpdateData(1, 1, paramLocationRequestInternal, localIBinder, null, null, paramzzd);
    }
  }
  
  public static LocationRequestUpdateData zza(zzc paramzzc, zzg paramzzg)
  {
    IBinder localIBinder = paramzzc.asBinder();
    if (paramzzg != null) {}
    for (paramzzc = paramzzg.asBinder();; paramzzc = null) {
      return new LocationRequestUpdateData(1, 2, null, null, null, localIBinder, paramzzc);
    }
  }
  
  public static LocationRequestUpdateData zza(zzd paramzzd, zzg paramzzg)
  {
    IBinder localIBinder = paramzzd.asBinder();
    if (paramzzg != null) {}
    for (paramzzd = paramzzg.asBinder();; paramzzd = null) {
      return new LocationRequestUpdateData(1, 2, null, localIBinder, null, null, paramzzd);
    }
  }
  
  public static LocationRequestUpdateData zzb(PendingIntent paramPendingIntent, zzg paramzzg)
  {
    if (paramzzg != null) {}
    for (paramzzg = paramzzg.asBinder();; paramzzg = null) {
      return new LocationRequestUpdateData(1, 2, null, null, paramPendingIntent, null, paramzzg);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzwF()
  {
    if (this.zzaFL == null) {
      return null;
    }
    return this.zzaFL.asBinder();
  }
  
  IBinder zzwG()
  {
    if (this.zzaFM == null) {
      return null;
    }
    return this.zzaFM.asBinder();
  }
  
  IBinder zzwH()
  {
    if (this.zzaFN == null) {
      return null;
    }
    return this.zzaFN.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\internal\LocationRequestUpdateData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */