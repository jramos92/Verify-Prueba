package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzf();
  private final int mVersionCode;
  private final boolean zzaEL;
  private final boolean zzaEM;
  private final boolean zzaEN;
  private final List<LocationRequest> zzasK;
  
  LocationSettingsRequest(int paramInt, List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mVersionCode = paramInt;
    this.zzasK = paramList;
    this.zzaEL = paramBoolean1;
    this.zzaEM = paramBoolean2;
    this.zzaEN = paramBoolean3;
  }
  
  private LocationSettingsRequest(List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public List<LocationRequest> zztd()
  {
    return Collections.unmodifiableList(this.zzasK);
  }
  
  public boolean zzwx()
  {
    return this.zzaEL;
  }
  
  public boolean zzwy()
  {
    return this.zzaEM;
  }
  
  public boolean zzwz()
  {
    return this.zzaEN;
  }
  
  public static final class Builder
  {
    private boolean zzaEL = false;
    private boolean zzaEM = false;
    private boolean zzaEN = false;
    private final ArrayList<LocationRequest> zzaEO = new ArrayList();
    
    public Builder addAllLocationRequests(Collection<LocationRequest> paramCollection)
    {
      this.zzaEO.addAll(paramCollection);
      return this;
    }
    
    public Builder addLocationRequest(LocationRequest paramLocationRequest)
    {
      this.zzaEO.add(paramLocationRequest);
      return this;
    }
    
    public LocationSettingsRequest build()
    {
      return new LocationSettingsRequest(this.zzaEO, this.zzaEL, this.zzaEM, this.zzaEN, null);
    }
    
    public Builder setAlwaysShow(boolean paramBoolean)
    {
      this.zzaEL = paramBoolean;
      return this;
    }
    
    public Builder setNeedBle(boolean paramBoolean)
    {
      this.zzaEM = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\LocationSettingsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */