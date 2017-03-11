package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class PlacesOptions
  implements Api.ApiOptions.Optional
{
  public final String zzaGG;
  
  private PlacesOptions(Builder paramBuilder)
  {
    this.zzaGG = Builder.zza(paramBuilder);
  }
  
  public static class Builder
  {
    private String zzaGH;
    
    public PlacesOptions build()
    {
      return new PlacesOptions(this, null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\PlacesOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */