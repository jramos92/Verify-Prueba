package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangesAvailableOptions> CREATOR = new zzd();
  final int mVersionCode;
  final List<DriveSpace> zzajA;
  private final Set<DriveSpace> zzajB;
  final int zzajy;
  final boolean zzajz;
  
  ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List<DriveSpace> paramList) {}
  
  private ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List<DriveSpace> paramList, Set<DriveSpace> paramSet)
  {
    this.mVersionCode = paramInt1;
    this.zzajy = paramInt2;
    this.zzajz = paramBoolean;
    this.zzajA = paramList;
    this.zzajB = paramSet;
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
      paramObject = (ChangesAvailableOptions)paramObject;
      if ((!zzw.equal(this.zzajB, ((ChangesAvailableOptions)paramObject).zzajB)) || (this.zzajy != ((ChangesAvailableOptions)paramObject).zzajy)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzajz == ((ChangesAvailableOptions)paramObject).zzajz);
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzajB, Integer.valueOf(this.zzajy), Boolean.valueOf(this.zzajz) });
  }
  
  public String toString()
  {
    return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[] { Integer.valueOf(this.zzajy), Boolean.valueOf(this.zzajz), this.zzajA });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\ChangesAvailableOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */