package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class JoinOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<JoinOptions> CREATOR = new zzc();
  private final int mVersionCode;
  private int zzVR;
  
  public JoinOptions()
  {
    this(1, 0);
  }
  
  JoinOptions(int paramInt1, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzVR = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof JoinOptions)) {
        return false;
      }
      paramObject = (JoinOptions)paramObject;
    } while (this.zzVR == ((JoinOptions)paramObject).zzVR);
    return false;
  }
  
  public int getConnectionType()
  {
    return this.zzVR;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzVR) });
  }
  
  public String toString()
  {
    String str;
    switch (this.zzVR)
    {
    case 1: 
    default: 
      str = "UNKNOWN";
    }
    for (;;)
    {
      return String.format("joinOptions(connectionType=%s)", new Object[] { str });
      str = "STRONG";
      continue;
      str = "INVISIBLE";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\JoinOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */