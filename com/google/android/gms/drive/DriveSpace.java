package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveSpace> CREATOR = new zzh();
  public static final DriveSpace zzaiR = new DriveSpace("DRIVE");
  public static final DriveSpace zzaiS = new DriveSpace("APP_DATA_FOLDER");
  public static final DriveSpace zzaiT = new DriveSpace("PHOTOS");
  public static final Set<DriveSpace> zzaiU = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[] { zzaiR, zzaiS, zzaiT })));
  public static final String zzaiV = TextUtils.join(",", zzaiU.toArray());
  private static final Pattern zzaiW = Pattern.compile("[A-Z0-9_]*");
  private final String mName;
  final int mVersionCode;
  
  DriveSpace(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.mName = ((String)zzx.zzw(paramString));
  }
  
  private DriveSpace(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != DriveSpace.class)) {
      return false;
    }
    return this.mName.equals(((DriveSpace)paramObject).mName);
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int hashCode()
  {
    return 0x4A54C0DE ^ this.mName.hashCode();
  }
  
  public String toString()
  {
    return this.mName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\DriveSpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */