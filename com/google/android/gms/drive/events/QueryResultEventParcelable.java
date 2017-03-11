package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable
  extends WriteAwareParcelable
  implements DriveEvent
{
  public static final zzk CREATOR = new zzk();
  final int mVersionCode;
  final DataHolder zzabq;
  final boolean zzajR;
  final int zzajS;
  
  QueryResultEventParcelable(int paramInt1, DataHolder paramDataHolder, boolean paramBoolean, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzabq = paramDataHolder;
    this.zzajR = paramBoolean;
    this.zzajS = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void zzJ(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public DataHolder zzrh()
  {
    return this.zzabq;
  }
  
  public boolean zzri()
  {
    return this.zzajR;
  }
  
  public int zzrj()
  {
    return this.zzajS;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\QueryResultEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */