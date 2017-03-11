package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<ParcelableEvent>
{
  static void zza(ParcelableEvent paramParcelableEvent, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableEvent.mVersionCode);
    zzb.zza(paramParcel, 2, paramParcelableEvent.zzHP, false);
    zzb.zza(paramParcel, 3, paramParcelableEvent.zzGY, false);
    zzb.zzb(paramParcel, 4, paramParcelableEvent.zzaoH, false);
    zzb.zza(paramParcel, 5, paramParcelableEvent.zzaoI);
    zzb.zza(paramParcel, 6, paramParcelableEvent.zzaoB, false);
    zzb.zza(paramParcel, 7, paramParcelableEvent.zzaoL, false);
    zzb.zza(paramParcel, 8, paramParcelableEvent.zzaoM, paramInt, false);
    zzb.zza(paramParcel, 9, paramParcelableEvent.zzaoN, paramInt, false);
    zzb.zza(paramParcel, 10, paramParcelableEvent.zzaoO, paramInt, false);
    zzb.zza(paramParcel, 11, paramParcelableEvent.zzaoP, paramInt, false);
    zzb.zza(paramParcel, 12, paramParcelableEvent.zzaoQ, paramInt, false);
    zzb.zza(paramParcel, 13, paramParcelableEvent.zzaoR, paramInt, false);
    zzb.zza(paramParcel, 14, paramParcelableEvent.zzaoS, paramInt, false);
    zzb.zza(paramParcel, 15, paramParcelableEvent.zzaoT, paramInt, false);
    zzb.zza(paramParcel, 17, paramParcelableEvent.zzaoK);
    zzb.zza(paramParcel, 16, paramParcelableEvent.zzaoJ);
    zzb.zza(paramParcel, 18, paramParcelableEvent.zzaoU, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ParcelableEvent zzcv(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str4 = null;
    String str3 = null;
    ArrayList localArrayList = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    String str2 = null;
    String str1 = null;
    TextInsertedDetails localTextInsertedDetails = null;
    TextDeletedDetails localTextDeletedDetails = null;
    ValuesAddedDetails localValuesAddedDetails = null;
    ValuesRemovedDetails localValuesRemovedDetails = null;
    ValuesSetDetails localValuesSetDetails = null;
    ValueChangedDetails localValueChangedDetails = null;
    ReferenceShiftedDetails localReferenceShiftedDetails = null;
    ObjectChangedDetails localObjectChangedDetails = null;
    FieldChangedDetails localFieldChangedDetails = null;
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
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localArrayList = zza.zzD(paramParcel, k);
        break;
      case 5: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        localTextInsertedDetails = (TextInsertedDetails)zza.zza(paramParcel, k, TextInsertedDetails.CREATOR);
        break;
      case 9: 
        localTextDeletedDetails = (TextDeletedDetails)zza.zza(paramParcel, k, TextDeletedDetails.CREATOR);
        break;
      case 10: 
        localValuesAddedDetails = (ValuesAddedDetails)zza.zza(paramParcel, k, ValuesAddedDetails.CREATOR);
        break;
      case 11: 
        localValuesRemovedDetails = (ValuesRemovedDetails)zza.zza(paramParcel, k, ValuesRemovedDetails.CREATOR);
        break;
      case 12: 
        localValuesSetDetails = (ValuesSetDetails)zza.zza(paramParcel, k, ValuesSetDetails.CREATOR);
        break;
      case 13: 
        localValueChangedDetails = (ValueChangedDetails)zza.zza(paramParcel, k, ValueChangedDetails.CREATOR);
        break;
      case 14: 
        localReferenceShiftedDetails = (ReferenceShiftedDetails)zza.zza(paramParcel, k, ReferenceShiftedDetails.CREATOR);
        break;
      case 15: 
        localObjectChangedDetails = (ObjectChangedDetails)zza.zza(paramParcel, k, ObjectChangedDetails.CREATOR);
        break;
      case 17: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 16: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 18: 
        localFieldChangedDetails = (FieldChangedDetails)zza.zza(paramParcel, k, FieldChangedDetails.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableEvent(i, str4, str3, localArrayList, bool3, bool2, bool1, str2, str1, localTextInsertedDetails, localTextDeletedDetails, localValuesAddedDetails, localValuesRemovedDetails, localValuesSetDetails, localValueChangedDetails, localReferenceShiftedDetails, localObjectChangedDetails, localFieldChangedDetails);
  }
  
  public ParcelableEvent[] zzei(int paramInt)
  {
    return new ParcelableEvent[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */