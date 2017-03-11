package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  static final List<ClientIdentity> zzaFD = ;
  String mTag;
  private final int mVersionCode;
  boolean zzaFE;
  boolean zzaFF;
  boolean zzaFG;
  List<ClientIdentity> zzaFH;
  boolean zzaFI;
  LocationRequest zzasN;
  
  LocationRequestInternal(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ClientIdentity> paramList, String paramString, boolean paramBoolean4)
  {
    this.mVersionCode = paramInt;
    this.zzasN = paramLocationRequest;
    this.zzaFE = paramBoolean1;
    this.zzaFF = paramBoolean2;
    this.zzaFG = paramBoolean3;
    this.zzaFH = paramList;
    this.mTag = paramString;
    this.zzaFI = paramBoolean4;
  }
  
  public static LocationRequestInternal zza(String paramString, LocationRequest paramLocationRequest)
  {
    return new LocationRequestInternal(1, paramLocationRequest, false, true, true, zzaFD, paramString, false);
  }
  
  @Deprecated
  public static LocationRequestInternal zzb(LocationRequest paramLocationRequest)
  {
    return zza(null, paramLocationRequest);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationRequestInternal)) {}
    do
    {
      return false;
      paramObject = (LocationRequestInternal)paramObject;
    } while ((!zzw.equal(this.zzasN, ((LocationRequestInternal)paramObject).zzasN)) || (this.zzaFE != ((LocationRequestInternal)paramObject).zzaFE) || (this.zzaFF != ((LocationRequestInternal)paramObject).zzaFF) || (this.zzaFG != ((LocationRequestInternal)paramObject).zzaFG) || (this.zzaFI != ((LocationRequestInternal)paramObject).zzaFI) || (!zzw.equal(this.zzaFH, ((LocationRequestInternal)paramObject).zzaFH)));
    return true;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return this.zzasN.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.zzasN.toString());
    if (this.mTag != null) {
      localStringBuilder.append(" tag=").append(this.mTag);
    }
    localStringBuilder.append(" nlpDebug=").append(this.zzaFE);
    localStringBuilder.append(" trigger=").append(this.zzaFG);
    localStringBuilder.append(" restorePIListeners=").append(this.zzaFF);
    localStringBuilder.append(" hideAppOps=").append(this.zzaFI);
    localStringBuilder.append(" clients=").append(this.zzaFH);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\internal\LocationRequestInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */