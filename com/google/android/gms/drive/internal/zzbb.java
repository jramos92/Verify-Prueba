package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class zzbb
  implements Parcelable.Creator<OnEventResponse>
{
  static void zza(OnEventResponse paramOnEventResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnEventResponse.mVersionCode);
    zzb.zzc(paramParcel, 2, paramOnEventResponse.zzaho);
    zzb.zza(paramParcel, 3, paramOnEventResponse.zzame, paramInt, false);
    zzb.zza(paramParcel, 5, paramOnEventResponse.zzamf, paramInt, false);
    zzb.zza(paramParcel, 6, paramOnEventResponse.zzamg, paramInt, false);
    zzb.zza(paramParcel, 7, paramOnEventResponse.zzamh, paramInt, false);
    zzb.zza(paramParcel, 8, paramOnEventResponse.zzami, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnEventResponse zzbw(Parcel paramParcel)
  {
    int i = 0;
    ProgressEvent localProgressEvent = null;
    int k = zza.zzap(paramParcel);
    ChangesAvailableEvent localChangesAvailableEvent = null;
    QueryResultEventParcelable localQueryResultEventParcelable = null;
    CompletionEvent localCompletionEvent = null;
    ChangeEvent localChangeEvent = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      case 4: 
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localChangeEvent = (ChangeEvent)zza.zza(paramParcel, m, ChangeEvent.CREATOR);
        break;
      case 5: 
        localCompletionEvent = (CompletionEvent)zza.zza(paramParcel, m, CompletionEvent.CREATOR);
        break;
      case 6: 
        localQueryResultEventParcelable = (QueryResultEventParcelable)zza.zza(paramParcel, m, QueryResultEventParcelable.CREATOR);
        break;
      case 7: 
        localChangesAvailableEvent = (ChangesAvailableEvent)zza.zza(paramParcel, m, ChangesAvailableEvent.CREATOR);
        break;
      case 8: 
        localProgressEvent = (ProgressEvent)zza.zza(paramParcel, m, ProgressEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new OnEventResponse(j, i, localChangeEvent, localCompletionEvent, localQueryResultEventParcelable, localChangesAvailableEvent, localProgressEvent);
  }
  
  public OnEventResponse[] zzdi(int paramInt)
  {
    return new OnEventResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */