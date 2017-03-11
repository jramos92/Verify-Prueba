package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzba
  implements Parcelable.Creator<MessageEventParcelable>
{
  static void zza(MessageEventParcelable paramMessageEventParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramMessageEventParcelable.mVersionCode);
    zzb.zzc(paramParcel, 2, paramMessageEventParcelable.getRequestId());
    zzb.zza(paramParcel, 3, paramMessageEventParcelable.getPath(), false);
    zzb.zza(paramParcel, 4, paramMessageEventParcelable.getData(), false);
    zzb.zza(paramParcel, 5, paramMessageEventParcelable.getSourceNodeId(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public MessageEventParcelable zzih(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzap(paramParcel);
    byte[] arrayOfByte = null;
    String str2 = null;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = zza.zzs(paramParcel, m);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new MessageEventParcelable(j, i, str2, arrayOfByte, str1);
  }
  
  public MessageEventParcelable[] zzlq(int paramInt)
  {
    return new MessageEventParcelable[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */