package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LabelValue
  implements SafeParcelable
{
  public static final Parcelable.Creator<LabelValue> CREATOR = new zzb();
  String label;
  private final int mVersionCode;
  String value;
  
  LabelValue()
  {
    this.mVersionCode = 1;
  }
  
  LabelValue(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.label = paramString1;
    this.value = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\LabelValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */