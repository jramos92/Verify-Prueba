package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zzse;

public class ChangeSequenceNumber
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangeSequenceNumber> CREATOR = new zza();
  final int mVersionCode;
  final long zzaiu;
  final long zzaiv;
  final long zzaiw;
  private volatile String zzaix = null;
  
  ChangeSequenceNumber(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != -1L)
    {
      bool1 = true;
      zzx.zzaa(bool1);
      if (paramLong2 == -1L) {
        break label92;
      }
      bool1 = true;
      label40:
      zzx.zzaa(bool1);
      if (paramLong3 == -1L) {
        break label98;
      }
    }
    label92:
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzaa(bool1);
      this.mVersionCode = paramInt;
      this.zzaiu = paramLong1;
      this.zzaiv = paramLong2;
      this.zzaiw = paramLong3;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label40;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.zzaix == null)
    {
      String str = Base64.encodeToString(zzqL(), 10);
      this.zzaix = ("ChangeSequenceNumber:" + str);
    }
    return this.zzaix;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ChangeSequenceNumber)) {}
    do
    {
      return false;
      paramObject = (ChangeSequenceNumber)paramObject;
    } while ((((ChangeSequenceNumber)paramObject).zzaiv != this.zzaiv) || (((ChangeSequenceNumber)paramObject).zzaiw != this.zzaiw) || (((ChangeSequenceNumber)paramObject).zzaiu != this.zzaiu));
    return true;
  }
  
  public int hashCode()
  {
    return (String.valueOf(this.zzaiu) + String.valueOf(this.zzaiv) + String.valueOf(this.zzaiw)).hashCode();
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  final byte[] zzqL()
  {
    zzas localzzas = new zzas();
    localzzas.versionCode = this.mVersionCode;
    localzzas.zzalN = this.zzaiu;
    localzzas.zzalO = this.zzaiv;
    localzzas.zzalP = this.zzaiw;
    return zzse.zzf(localzzas);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\ChangeSequenceNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */