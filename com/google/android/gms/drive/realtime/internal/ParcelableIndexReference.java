package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new zzr();
  final int mIndex;
  final int mVersionCode;
  final String zzaoB;
  final boolean zzaoC;
  final int zzaoD;
  
  ParcelableIndexReference(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzaoB = paramString;
    this.mIndex = paramInt2;
    this.zzaoC = paramBoolean;
    this.zzaoD = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\ParcelableIndexReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */