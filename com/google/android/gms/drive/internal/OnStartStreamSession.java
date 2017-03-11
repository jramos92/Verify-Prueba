package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnStartStreamSession
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnStartStreamSession> CREATOR = new zzbi();
  final int mVersionCode;
  final ParcelFileDescriptor zzamm;
  final IBinder zzamn;
  final String zzrW;
  
  OnStartStreamSession(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, IBinder paramIBinder, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzamm = paramParcelFileDescriptor;
    this.zzamn = paramIBinder;
    this.zzrW = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbi.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\OnStartStreamSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */