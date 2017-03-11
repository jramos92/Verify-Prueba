package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public class zzp
  implements Parcelable.Creator<SubscribeRequest>
{
  static void zza(SubscribeRequest paramSubscribeRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramSubscribeRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramSubscribeRequest.zzBg(), false);
    zzb.zza(paramParcel, 3, paramSubscribeRequest.zzaQZ, paramInt, false);
    zzb.zza(paramParcel, 4, paramSubscribeRequest.zzBd(), false);
    zzb.zza(paramParcel, 5, paramSubscribeRequest.zzaRf, paramInt, false);
    zzb.zza(paramParcel, 6, paramSubscribeRequest.zzaRg, paramInt, false);
    zzb.zzc(paramParcel, 7, paramSubscribeRequest.zzaRh);
    zzb.zza(paramParcel, 8, paramSubscribeRequest.zzaQe, false);
    zzb.zza(paramParcel, 9, paramSubscribeRequest.zzaRa, false);
    zzb.zza(paramParcel, 10, paramSubscribeRequest.zzaRi, false);
    zzb.zza(paramParcel, 11, paramSubscribeRequest.zzaQf);
    zzb.zza(paramParcel, 12, paramSubscribeRequest.zzBh(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SubscribeRequest zzfX(Parcel paramParcel)
  {
    int k = zza.zzap(paramParcel);
    int j = 0;
    IBinder localIBinder3 = null;
    Strategy localStrategy = null;
    IBinder localIBinder2 = null;
    MessageFilter localMessageFilter = null;
    PendingIntent localPendingIntent = null;
    int i = 0;
    String str2 = null;
    String str1 = null;
    byte[] arrayOfByte = null;
    boolean bool = false;
    IBinder localIBinder1 = null;
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
        localIBinder3 = zza.zzq(paramParcel, m);
        break;
      case 3: 
        localStrategy = (Strategy)zza.zza(paramParcel, m, Strategy.CREATOR);
        break;
      case 4: 
        localIBinder2 = zza.zzq(paramParcel, m);
        break;
      case 5: 
        localMessageFilter = (MessageFilter)zza.zza(paramParcel, m, MessageFilter.CREATOR);
        break;
      case 6: 
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 7: 
        i = zza.zzg(paramParcel, m);
        break;
      case 8: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 9: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 10: 
        arrayOfByte = zza.zzs(paramParcel, m);
        break;
      case 11: 
        bool = zza.zzc(paramParcel, m);
        break;
      case 12: 
        localIBinder1 = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new SubscribeRequest(j, localIBinder3, localStrategy, localIBinder2, localMessageFilter, localPendingIntent, i, str2, str1, arrayOfByte, bool, localIBinder1);
  }
  
  public SubscribeRequest[] zziJ(int paramInt)
  {
    return new SubscribeRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */