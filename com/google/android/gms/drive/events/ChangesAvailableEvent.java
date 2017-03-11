package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public final class ChangesAvailableEvent
  implements SafeParcelable, DriveEvent
{
  public static final Parcelable.Creator<ChangesAvailableEvent> CREATOR = new zzb();
  final int mVersionCode;
  final String zzRs;
  final ChangesAvailableOptions zzajx;
  
  ChangesAvailableEvent(int paramInt, String paramString, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    this.mVersionCode = paramInt;
    this.zzRs = paramString;
    this.zzajx = paramChangesAvailableOptions;
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
      paramObject = (ChangesAvailableEvent)paramObject;
      if (!zzw.equal(this.zzajx, ((ChangesAvailableEvent)paramObject).zzajx)) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(this.zzRs, ((ChangesAvailableEvent)paramObject).zzRs));
    return false;
  }
  
  public int getType()
  {
    return 4;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzajx, this.zzRs });
  }
  
  public String toString()
  {
    return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[] { this.zzajx });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\ChangesAvailableEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */