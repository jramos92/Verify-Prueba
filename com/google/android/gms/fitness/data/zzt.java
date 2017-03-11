package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt
  implements Parcelable.Creator<Value>
{
  static void zza(Value paramValue, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramValue.getFormat());
    zzb.zzc(paramParcel, 1000, paramValue.getVersionCode());
    zzb.zza(paramParcel, 2, paramValue.isSet());
    zzb.zza(paramParcel, 3, paramValue.zzsy());
    zzb.zza(paramParcel, 4, paramValue.zzsG(), false);
    zzb.zza(paramParcel, 5, paramValue.zzsH(), false);
    zzb.zza(paramParcel, 6, paramValue.zzsI(), false);
    zzb.zza(paramParcel, 7, paramValue.zzsJ(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Value zzcU(Parcel paramParcel)
  {
    boolean bool = false;
    float[] arrayOfFloat = null;
    int k = zza.zzap(paramParcel);
    float f = 0.0F;
    int[] arrayOfInt = null;
    Bundle localBundle = null;
    String str = null;
    int i = 0;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        bool = zza.zzc(paramParcel, m);
        break;
      case 3: 
        f = zza.zzl(paramParcel, m);
        break;
      case 4: 
        str = zza.zzp(paramParcel, m);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, m);
        break;
      case 6: 
        arrayOfInt = zza.zzv(paramParcel, m);
        break;
      case 7: 
        arrayOfFloat = zza.zzy(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Value(j, i, bool, f, str, localBundle, arrayOfInt, arrayOfFloat);
  }
  
  public Value[] zzeL(int paramInt)
  {
    return new Value[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */