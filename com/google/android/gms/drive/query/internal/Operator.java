package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator<Operator> CREATOR = new zzn();
  public static final Operator zzaom = new Operator("=");
  public static final Operator zzaon = new Operator("<");
  public static final Operator zzaoo = new Operator("<=");
  public static final Operator zzaop = new Operator(">");
  public static final Operator zzaoq = new Operator(">=");
  public static final Operator zzaor = new Operator("and");
  public static final Operator zzaos = new Operator("or");
  public static final Operator zzaot = new Operator("not");
  public static final Operator zzaou = new Operator("contains");
  final String mTag;
  final int mVersionCode;
  
  Operator(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.mTag = paramString;
  }
  
  private Operator(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Operator)paramObject;
        if (this.mTag != null) {
          break;
        }
      } while (((Operator)paramObject).mTag == null);
      return false;
    } while (this.mTag.equals(((Operator)paramObject).mTag));
    return false;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    if (this.mTag == null) {}
    for (int i = 0;; i = this.mTag.hashCode()) {
      return i + 31;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\Operator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */