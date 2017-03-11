package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PopupLocationInfoParcelable
  implements SafeParcelable
{
  public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
  private final int mVersionCode;
  private final Bundle zzawK;
  private final IBinder zzawL;
  
  PopupLocationInfoParcelable(int paramInt, Bundle paramBundle, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzawK = paramBundle;
    this.zzawL = paramIBinder;
  }
  
  public PopupLocationInfoParcelable(PopupManager.PopupLocationInfo paramPopupLocationInfo)
  {
    this.mVersionCode = 1;
    this.zzawK = paramPopupLocationInfo.zzve();
    this.zzawL = paramPopupLocationInfo.zzawO;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public IBinder getWindowToken()
  {
    return this.zzawL;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PopupLocationInfoParcelableCreator.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzve()
  {
    return this.zzawK;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\PopupLocationInfoParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */