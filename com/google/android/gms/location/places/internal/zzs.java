package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class zzs
  extends zzu
  implements Place
{
  private final String zzaGt;
  private boolean zzaHu;
  private final zzp zzaHx;
  
  public zzs(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder, paramInt);
    if (paramContext != null) {}
    for (paramDataHolder = zzp.zzaF(paramContext);; paramDataHolder = null)
    {
      this.zzaHx = paramDataHolder;
      this.zzaHu = zzh("place_is_logging_enabled", false);
      this.zzaGt = zzF("place_id", "");
      return;
    }
  }
  
  private void zzdz(String paramString)
  {
    if ((this.zzaHu) && (this.zzaHx != null)) {
      this.zzaHx.zzE(this.zzaGt, paramString);
    }
  }
  
  public CharSequence getAddress()
  {
    zzdz("getAddress");
    return zzF("place_address", "");
  }
  
  public String getId()
  {
    zzdz("getId");
    return this.zzaGt;
  }
  
  public LatLng getLatLng()
  {
    zzdz("getLatLng");
    return (LatLng)zza("place_lat_lng", LatLng.CREATOR);
  }
  
  public Locale getLocale()
  {
    zzdz("getLocale");
    String str = zzF("place_locale", "");
    if (!TextUtils.isEmpty(str)) {
      return new Locale(str);
    }
    return Locale.getDefault();
  }
  
  public CharSequence getName()
  {
    zzdz("getName");
    return zzF("place_name", "");
  }
  
  public CharSequence getPhoneNumber()
  {
    zzdz("getPhoneNumber");
    return zzF("place_phone_number", "");
  }
  
  public List<Integer> getPlaceTypes()
  {
    zzdz("getPlaceTypes");
    return zza("place_types", Collections.emptyList());
  }
  
  public int getPriceLevel()
  {
    zzdz("getPriceLevel");
    return zzz("place_price_level", -1);
  }
  
  public float getRating()
  {
    zzdz("getRating");
    return zzb("place_rating", -1.0F);
  }
  
  public LatLngBounds getViewport()
  {
    zzdz("getViewport");
    return (LatLngBounds)zza("place_viewport", LatLngBounds.CREATOR);
  }
  
  public Uri getWebsiteUri()
  {
    zzdz("getWebsiteUri");
    String str = zzF("place_website_uri", null);
    if (str == null) {
      return null;
    }
    return Uri.parse(str);
  }
  
  public float zzxe()
  {
    zzdz("getLevelNumber");
    return zzb("place_level_number", 0.0F);
  }
  
  public boolean zzxh()
  {
    zzdz("isPermanentlyClosed");
    return zzh("place_is_permanently_closed", false);
  }
  
  public Place zzxm()
  {
    Object localObject = new PlaceImpl.zza().zzaj(this.zzaHu);
    this.zzaHu = false;
    localObject = ((PlaceImpl.zza)localObject).zzdC(getAddress().toString()).zzu(zzb("place_attributions", Collections.emptyList())).zzdA(getId()).zzai(zzxh()).zza(getLatLng()).zzf(zzxe()).zzdB(getName().toString()).zzdD(getPhoneNumber().toString()).zzhs(getPriceLevel()).zzg(getRating()).zzt(getPlaceTypes()).zza(getViewport()).zzl(getWebsiteUri()).zzxn();
    ((PlaceImpl)localObject).setLocale(getLocale());
    ((PlaceImpl)localObject).zza(this.zzaHx);
    return (Place)localObject;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */