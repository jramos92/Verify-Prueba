package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class WriteAwareParcelable
  implements Parcelable
{
  private volatile transient boolean zzajv = false;
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!zzrd()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzZ(bool);
      this.zzajv = true;
      zzJ(paramParcel, paramInt);
      return;
    }
  }
  
  protected abstract void zzJ(Parcel paramParcel, int paramInt);
  
  public final boolean zzrd()
  {
    return this.zzajv;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\WriteAwareParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */