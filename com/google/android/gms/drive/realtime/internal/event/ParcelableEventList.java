package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class ParcelableEventList
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEventList> CREATOR = new zzd();
  final int mVersionCode;
  final DataHolder zzaoV;
  final boolean zzaoW;
  final List<String> zzaoX;
  final ParcelableChangeInfo zzaoY;
  final List<ParcelableEvent> zzoQ;
  
  ParcelableEventList(int paramInt, List<ParcelableEvent> paramList, DataHolder paramDataHolder, boolean paramBoolean, List<String> paramList1, ParcelableChangeInfo paramParcelableChangeInfo)
  {
    this.mVersionCode = paramInt;
    this.zzoQ = paramList;
    this.zzaoV = paramDataHolder;
    this.zzaoW = paramBoolean;
    this.zzaoX = paramList1;
    this.zzaoY = paramParcelableChangeInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\ParcelableEventList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */