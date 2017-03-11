package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl
  implements SafeParcelable, Place
{
  public static final zzl CREATOR = new zzl();
  private final String mName;
  final int mVersionCode;
  private final LatLng zzaFS;
  private final List<Integer> zzaFT;
  private final String zzaFU;
  private final Uri zzaFV;
  private Locale zzaHc;
  private final Bundle zzaHi;
  @Deprecated
  private final PlaceLocalization zzaHj;
  private final float zzaHk;
  private final LatLngBounds zzaHl;
  private final String zzaHm;
  private final boolean zzaHn;
  private final float zzaHo;
  private final int zzaHp;
  private final long zzaHq;
  private final List<Integer> zzaHr;
  private final String zzaHs;
  private final List<String> zzaHt;
  final boolean zzaHu;
  private final Map<Integer, String> zzaHv;
  private final TimeZone zzaHw;
  private zzp zzaHx;
  private final String zzapU;
  private final String zzwN;
  
  PlaceImpl(int paramInt1, String paramString1, List<Integer> paramList1, List<Integer> paramList2, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, LatLng paramLatLng, float paramFloat1, LatLngBounds paramLatLngBounds, String paramString6, Uri paramUri, boolean paramBoolean1, float paramFloat2, int paramInt2, long paramLong, boolean paramBoolean2, PlaceLocalization paramPlaceLocalization)
  {
    this.mVersionCode = paramInt1;
    this.zzwN = paramString1;
    this.zzaFT = Collections.unmodifiableList(paramList1);
    this.zzaHr = paramList2;
    if (paramBundle != null)
    {
      this.zzaHi = paramBundle;
      this.mName = paramString2;
      this.zzapU = paramString3;
      this.zzaFU = paramString4;
      this.zzaHs = paramString5;
      if (paramList == null) {
        break label182;
      }
      label68:
      this.zzaHt = paramList;
      this.zzaFS = paramLatLng;
      this.zzaHk = paramFloat1;
      this.zzaHl = paramLatLngBounds;
      if (paramString6 == null) {
        break label190;
      }
    }
    for (;;)
    {
      this.zzaHm = paramString6;
      this.zzaFV = paramUri;
      this.zzaHn = paramBoolean1;
      this.zzaHo = paramFloat2;
      this.zzaHp = paramInt2;
      this.zzaHq = paramLong;
      this.zzaHv = Collections.unmodifiableMap(new HashMap());
      this.zzaHw = null;
      this.zzaHc = null;
      this.zzaHu = paramBoolean2;
      this.zzaHj = paramPlaceLocalization;
      return;
      paramBundle = new Bundle();
      break;
      label182:
      paramList = Collections.emptyList();
      break label68;
      label190:
      paramString6 = "UTC";
    }
  }
  
  private void zzdz(String paramString)
  {
    if ((this.zzaHu) && (this.zzaHx != null)) {
      this.zzaHx.zzE(this.zzwN, paramString);
    }
  }
  
  public int describeContents()
  {
    zzl localzzl = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceImpl)) {
        return false;
      }
      paramObject = (PlaceImpl)paramObject;
    } while ((this.zzwN.equals(((PlaceImpl)paramObject).zzwN)) && (zzw.equal(this.zzaHc, ((PlaceImpl)paramObject).zzaHc)) && (this.zzaHq == ((PlaceImpl)paramObject).zzaHq));
    return false;
  }
  
  public String getAddress()
  {
    zzdz("getAddress");
    return this.zzapU;
  }
  
  public String getId()
  {
    zzdz("getId");
    return this.zzwN;
  }
  
  public LatLng getLatLng()
  {
    zzdz("getLatLng");
    return this.zzaFS;
  }
  
  public Locale getLocale()
  {
    zzdz("getLocale");
    return this.zzaHc;
  }
  
  public String getName()
  {
    zzdz("getName");
    return this.mName;
  }
  
  public String getPhoneNumber()
  {
    zzdz("getPhoneNumber");
    return this.zzaFU;
  }
  
  public List<Integer> getPlaceTypes()
  {
    zzdz("getPlaceTypes");
    return this.zzaFT;
  }
  
  public int getPriceLevel()
  {
    zzdz("getPriceLevel");
    return this.zzaHp;
  }
  
  public float getRating()
  {
    zzdz("getRating");
    return this.zzaHo;
  }
  
  public LatLngBounds getViewport()
  {
    zzdz("getViewport");
    return this.zzaHl;
  }
  
  public Uri getWebsiteUri()
  {
    zzdz("getWebsiteUri");
    return this.zzaFV;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzwN, this.zzaHc, Long.valueOf(this.zzaHq) });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void setLocale(Locale paramLocale)
  {
    this.zzaHc = paramLocale;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("id", this.zzwN).zzg("placeTypes", this.zzaFT).zzg("locale", this.zzaHc).zzg("name", this.mName).zzg("address", this.zzapU).zzg("phoneNumber", this.zzaFU).zzg("latlng", this.zzaFS).zzg("viewport", this.zzaHl).zzg("websiteUri", this.zzaFV).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzaHn)).zzg("priceLevel", Integer.valueOf(this.zzaHp)).zzg("timestampSecs", Long.valueOf(this.zzaHq)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl localzzl = CREATOR;
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public void zza(zzp paramzzp)
  {
    this.zzaHx = paramzzp;
  }
  
  public List<Integer> zzxd()
  {
    zzdz("getTypesDeprecated");
    return this.zzaHr;
  }
  
  public float zzxe()
  {
    zzdz("getLevelNumber");
    return this.zzaHk;
  }
  
  public String zzxf()
  {
    zzdz("getRegularOpenHours");
    return this.zzaHs;
  }
  
  public List<String> zzxg()
  {
    zzdz("getAttributions");
    return this.zzaHt;
  }
  
  public boolean zzxh()
  {
    zzdz("isPermanentlyClosed");
    return this.zzaHn;
  }
  
  public long zzxi()
  {
    return this.zzaHq;
  }
  
  public Bundle zzxj()
  {
    return this.zzaHi;
  }
  
  public String zzxk()
  {
    return this.zzaHm;
  }
  
  @Deprecated
  public PlaceLocalization zzxl()
  {
    zzdz("getLocalization");
    return this.zzaHj;
  }
  
  public Place zzxm()
  {
    return this;
  }
  
  public static class zza
  {
    private String mName;
    private int mVersionCode = 0;
    private LatLng zzaFS;
    private String zzaFU;
    private Uri zzaFV;
    private float zzaHk;
    private LatLngBounds zzaHl;
    private String zzaHm;
    private boolean zzaHn;
    private float zzaHo;
    private int zzaHp;
    private long zzaHq;
    private String zzaHs;
    private List<String> zzaHt;
    private boolean zzaHu;
    private Bundle zzaHy;
    private List<Integer> zzaHz;
    private String zzapU;
    private String zzwN;
    
    public zza zza(LatLng paramLatLng)
    {
      this.zzaFS = paramLatLng;
      return this;
    }
    
    public zza zza(LatLngBounds paramLatLngBounds)
    {
      this.zzaHl = paramLatLngBounds;
      return this;
    }
    
    public zza zzai(boolean paramBoolean)
    {
      this.zzaHn = paramBoolean;
      return this;
    }
    
    public zza zzaj(boolean paramBoolean)
    {
      this.zzaHu = paramBoolean;
      return this;
    }
    
    public zza zzdA(String paramString)
    {
      this.zzwN = paramString;
      return this;
    }
    
    public zza zzdB(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public zza zzdC(String paramString)
    {
      this.zzapU = paramString;
      return this;
    }
    
    public zza zzdD(String paramString)
    {
      this.zzaFU = paramString;
      return this;
    }
    
    public zza zzf(float paramFloat)
    {
      this.zzaHk = paramFloat;
      return this;
    }
    
    public zza zzg(float paramFloat)
    {
      this.zzaHo = paramFloat;
      return this;
    }
    
    public zza zzhs(int paramInt)
    {
      this.zzaHp = paramInt;
      return this;
    }
    
    public zza zzl(Uri paramUri)
    {
      this.zzaFV = paramUri;
      return this;
    }
    
    public zza zzt(List<Integer> paramList)
    {
      this.zzaHz = paramList;
      return this;
    }
    
    public zza zzu(List<String> paramList)
    {
      this.zzaHt = paramList;
      return this;
    }
    
    public PlaceImpl zzxn()
    {
      return new PlaceImpl(this.mVersionCode, this.zzwN, this.zzaHz, Collections.emptyList(), this.zzaHy, this.mName, this.zzapU, this.zzaFU, this.zzaHs, this.zzaHt, this.zzaFS, this.zzaHk, this.zzaHl, this.zzaHm, this.zzaFV, this.zzaHn, this.zzaHo, this.zzaHp, this.zzaHq, this.zzaHu, PlaceLocalization.zza(this.mName, this.zzapU, this.zzaFU, this.zzaHs, this.zzaHt));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\PlaceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */