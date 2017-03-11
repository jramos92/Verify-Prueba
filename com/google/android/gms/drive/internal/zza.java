package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class zza
  implements Parcelable.Creator<AddEventListenerRequest>
{
  static void zza(AddEventListenerRequest paramAddEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramAddEventListenerRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramAddEventListenerRequest.zzaiA, paramInt, false);
    zzb.zzc(paramParcel, 3, paramAddEventListenerRequest.zzaho);
    zzb.zza(paramParcel, 4, paramAddEventListenerRequest.zzajx, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AddEventListenerRequest zzaR(Parcel paramParcel)
  {
    ChangesAvailableOptions localChangesAvailableOptions = null;
    int j = 0;
    int m = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    DriveId localDriveId = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, DriveId.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localChangesAvailableOptions = (ChangesAvailableOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, ChangesAvailableOptions.CREATOR);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new AddEventListenerRequest(i, localDriveId, j, localChangesAvailableOptions);
  }
  
  public AddEventListenerRequest[] zzcy(int paramInt)
  {
    return new AddEventListenerRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */