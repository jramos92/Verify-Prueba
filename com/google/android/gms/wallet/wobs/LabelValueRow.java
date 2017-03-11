package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
import java.util.ArrayList;

public final class LabelValueRow
  implements SafeParcelable
{
  public static final Parcelable.Creator<LabelValueRow> CREATOR = new zzc();
  private final int mVersionCode;
  String zzbeD;
  String zzbeE;
  ArrayList<LabelValue> zzbeF;
  
  LabelValueRow()
  {
    this.mVersionCode = 1;
    this.zzbeF = zzmj.zzqs();
  }
  
  LabelValueRow(int paramInt, String paramString1, String paramString2, ArrayList<LabelValue> paramArrayList)
  {
    this.mVersionCode = paramInt;
    this.zzbeD = paramString1;
    this.zzbeE = paramString2;
    this.zzbeF = paramArrayList;
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
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\LabelValueRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */