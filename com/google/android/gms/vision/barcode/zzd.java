package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<Barcode.CalendarEvent>
{
  static void zza(Barcode.CalendarEvent paramCalendarEvent, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCalendarEvent.versionCode);
    zzb.zza(paramParcel, 2, paramCalendarEvent.summary, false);
    zzb.zza(paramParcel, 3, paramCalendarEvent.description, false);
    zzb.zza(paramParcel, 4, paramCalendarEvent.location, false);
    zzb.zza(paramParcel, 5, paramCalendarEvent.organizer, false);
    zzb.zza(paramParcel, 6, paramCalendarEvent.status, false);
    zzb.zza(paramParcel, 7, paramCalendarEvent.start, paramInt, false);
    zzb.zza(paramParcel, 8, paramCalendarEvent.end, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public Barcode.CalendarEvent zzgH(Parcel paramParcel)
  {
    Barcode.CalendarDateTime localCalendarDateTime1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Barcode.CalendarDateTime localCalendarDateTime2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        localCalendarDateTime2 = (Barcode.CalendarDateTime)zza.zza(paramParcel, k, Barcode.CalendarDateTime.CREATOR);
        break;
      case 8: 
        localCalendarDateTime1 = (Barcode.CalendarDateTime)zza.zza(paramParcel, k, Barcode.CalendarDateTime.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new Barcode.CalendarEvent(i, str5, str4, str3, str2, str1, localCalendarDateTime2, localCalendarDateTime1);
  }
  
  public Barcode.CalendarEvent[] zzjJ(int paramInt)
  {
    return new Barcode.CalendarEvent[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\barcode\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */