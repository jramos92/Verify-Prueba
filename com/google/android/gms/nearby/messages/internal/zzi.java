package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Message;

public class zzi
  implements Parcelable.Creator<MessageWrapper>
{
  static void zza(MessageWrapper paramMessageWrapper, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramMessageWrapper.zzaQH, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramMessageWrapper.mVersionCode);
    zzb.zzI(paramParcel, i);
  }
  
  public MessageWrapper zzfU(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    Message localMessage = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localMessage = (Message)zza.zza(paramParcel, k, Message.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new MessageWrapper(i, localMessage);
  }
  
  public MessageWrapper[] zziG(int paramInt)
  {
    return new MessageWrapper[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */