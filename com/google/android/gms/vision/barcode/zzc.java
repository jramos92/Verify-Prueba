package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<Barcode.CalendarDateTime>
{
  static void zza(Barcode.CalendarDateTime paramCalendarDateTime, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCalendarDateTime.versionCode);
    zzb.zzc(paramParcel, 2, paramCalendarDateTime.year);
    zzb.zzc(paramParcel, 3, paramCalendarDateTime.month);
    zzb.zzc(paramParcel, 4, paramCalendarDateTime.day);
    zzb.zzc(paramParcel, 5, paramCalendarDateTime.hours);
    zzb.zzc(paramParcel, 6, paramCalendarDateTime.minutes);
    zzb.zzc(paramParcel, 7, paramCalendarDateTime.seconds);
    zzb.zza(paramParcel, 8, paramCalendarDateTime.isUtc);
    zzb.zza(paramParcel, 9, paramCalendarDateTime.rawValue, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Barcode.CalendarDateTime zzgG(Parcel paramParcel)
  {
    boolean bool = false;
    int i3 = zza.zzap(paramParcel);
    String str = null;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    while (paramParcel.dataPosition() < i3)
    {
      int i4 = zza.zzao(paramParcel);
      switch (zza.zzbM(i4))
      {
      default: 
        zza.zzb(paramParcel, i4);
        break;
      case 1: 
        i2 = zza.zzg(paramParcel, i4);
        break;
      case 2: 
        i1 = zza.zzg(paramParcel, i4);
        break;
      case 3: 
        n = zza.zzg(paramParcel, i4);
        break;
      case 4: 
        m = zza.zzg(paramParcel, i4);
        break;
      case 5: 
        k = zza.zzg(paramParcel, i4);
        break;
      case 6: 
        j = zza.zzg(paramParcel, i4);
        break;
      case 7: 
        i = zza.zzg(paramParcel, i4);
        break;
      case 8: 
        bool = zza.zzc(paramParcel, i4);
        break;
      case 9: 
        str = zza.zzp(paramParcel, i4);
      }
    }
    if (paramParcel.dataPosition() != i3) {
      throw new zza.zza("Overread allowed size end=" + i3, paramParcel);
    }
    return new Barcode.CalendarDateTime(i2, i1, n, m, k, j, i, bool, str);
  }
  
  public Barcode.CalendarDateTime[] zzjI(int paramInt)
  {
    return new Barcode.CalendarDateTime[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\barcode\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */