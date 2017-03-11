package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

public final class ProgressEvent
  implements DriveEvent
{
  public static final Parcelable.Creator<ProgressEvent> CREATOR = new zzh();
  final int mVersionCode;
  final int zzWJ;
  final DriveId zzaiA;
  final long zzajP;
  final long zzajQ;
  final int zzys;
  
  ProgressEvent(int paramInt1, DriveId paramDriveId, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzaiA = paramDriveId;
    this.zzys = paramInt2;
    this.zzajP = paramLong1;
    this.zzajQ = paramLong2;
    this.zzWJ = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (ProgressEvent)paramObject;
      if ((!zzw.equal(this.zzaiA, ((ProgressEvent)paramObject).zzaiA)) || (this.zzys != ((ProgressEvent)paramObject).zzys) || (this.zzajP != ((ProgressEvent)paramObject).zzajP)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzajQ == ((ProgressEvent)paramObject).zzajQ);
    return false;
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaiA, Integer.valueOf(this.zzys), Long.valueOf(this.zzajP), Long.valueOf(this.zzajQ) });
  }
  
  public String toString()
  {
    return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[] { this.zzaiA, Integer.valueOf(this.zzys), Long.valueOf(this.zzajP), Long.valueOf(this.zzajQ) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\ProgressEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */