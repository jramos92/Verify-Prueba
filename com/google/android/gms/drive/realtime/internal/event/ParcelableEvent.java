package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEvent> CREATOR = new zzc();
  final int mVersionCode;
  final String zzGY;
  final String zzHP;
  final String zzaoB;
  final List<String> zzaoH;
  final boolean zzaoI;
  final boolean zzaoJ;
  final boolean zzaoK;
  final String zzaoL;
  final TextInsertedDetails zzaoM;
  final TextDeletedDetails zzaoN;
  final ValuesAddedDetails zzaoO;
  final ValuesRemovedDetails zzaoP;
  final ValuesSetDetails zzaoQ;
  final ValueChangedDetails zzaoR;
  final ReferenceShiftedDetails zzaoS;
  final ObjectChangedDetails zzaoT;
  final FieldChangedDetails zzaoU;
  
  ParcelableEvent(int paramInt, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails, ObjectChangedDetails paramObjectChangedDetails, FieldChangedDetails paramFieldChangedDetails)
  {
    this.mVersionCode = paramInt;
    this.zzHP = paramString1;
    this.zzGY = paramString2;
    this.zzaoH = paramList;
    this.zzaoI = paramBoolean1;
    this.zzaoJ = paramBoolean2;
    this.zzaoK = paramBoolean3;
    this.zzaoB = paramString3;
    this.zzaoL = paramString4;
    this.zzaoM = paramTextInsertedDetails;
    this.zzaoN = paramTextDeletedDetails;
    this.zzaoO = paramValuesAddedDetails;
    this.zzaoP = paramValuesRemovedDetails;
    this.zzaoQ = paramValuesSetDetails;
    this.zzaoR = paramValueChangedDetails;
    this.zzaoS = paramReferenceShiftedDetails;
    this.zzaoT = paramObjectChangedDetails;
    this.zzaoU = paramFieldChangedDetails;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\ParcelableEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */