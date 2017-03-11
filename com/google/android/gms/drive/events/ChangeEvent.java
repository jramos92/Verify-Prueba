package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<ChangeEvent> CREATOR = new zza();
  final int mVersionCode;
  final DriveId zzaiA;
  final int zzajw;
  
  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzaiA = paramDriveId;
    this.zzajw = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.zzaiA;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public boolean hasBeenDeleted()
  {
    return (this.zzajw & 0x4) != 0;
  }
  
  public boolean hasContentChanged()
  {
    return (this.zzajw & 0x2) != 0;
  }
  
  public boolean hasMetadataChanged()
  {
    return (this.zzajw & 0x1) != 0;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[] { this.zzaiA, Integer.valueOf(this.zzajw) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\ChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */