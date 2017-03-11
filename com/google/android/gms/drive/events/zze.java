package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class zze
  implements Parcelable.Creator<CompletionEvent>
{
  static void zza(CompletionEvent paramCompletionEvent, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCompletionEvent.mVersionCode);
    zzb.zza(paramParcel, 2, paramCompletionEvent.zzaiA, paramInt, false);
    zzb.zza(paramParcel, 3, paramCompletionEvent.zzRs, false);
    zzb.zza(paramParcel, 4, paramCompletionEvent.zzajC, paramInt, false);
    zzb.zza(paramParcel, 5, paramCompletionEvent.zzajD, paramInt, false);
    zzb.zza(paramParcel, 6, paramCompletionEvent.zzajE, paramInt, false);
    zzb.zzb(paramParcel, 7, paramCompletionEvent.zzajF, false);
    zzb.zzc(paramParcel, 8, paramCompletionEvent.zzys);
    zzb.zza(paramParcel, 9, paramCompletionEvent.zzajG, false);
    zzb.zzI(paramParcel, i);
  }
  
  public CompletionEvent zzaO(Parcel paramParcel)
  {
    int i = 0;
    IBinder localIBinder = null;
    int k = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
    MetadataBundle localMetadataBundle = null;
    ParcelFileDescriptor localParcelFileDescriptor1 = null;
    ParcelFileDescriptor localParcelFileDescriptor2 = null;
    String str = null;
    DriveId localDriveId = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        localDriveId = (DriveId)zza.zza(paramParcel, m, DriveId.CREATOR);
        break;
      case 3: 
        str = zza.zzp(paramParcel, m);
        break;
      case 4: 
        localParcelFileDescriptor2 = (ParcelFileDescriptor)zza.zza(paramParcel, m, ParcelFileDescriptor.CREATOR);
        break;
      case 5: 
        localParcelFileDescriptor1 = (ParcelFileDescriptor)zza.zza(paramParcel, m, ParcelFileDescriptor.CREATOR);
        break;
      case 6: 
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, m, MetadataBundle.CREATOR);
        break;
      case 7: 
        localArrayList = zza.zzD(paramParcel, m);
        break;
      case 8: 
        i = zza.zzg(paramParcel, m);
        break;
      case 9: 
        localIBinder = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CompletionEvent(j, localDriveId, str, localParcelFileDescriptor2, localParcelFileDescriptor1, localMetadataBundle, localArrayList, i, localIBinder);
  }
  
  public CompletionEvent[] zzcu(int paramInt)
  {
    return new CompletionEvent[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */