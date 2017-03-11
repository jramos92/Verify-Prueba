package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final int zzKS;
  private final int zzKT;
  private final int zzKU;
  private final int zzKV;
  private final int zzKW;
  private final int zzKX;
  private final int zzKY;
  private final String zzKZ;
  private final int zzLa;
  private final String zzLb;
  private final int zzLc;
  private final int zzLd;
  private final String zzLe;
  private final zzy zznO;
  private final int zzwg;
  
  private SearchAdRequest(Builder paramBuilder)
  {
    this.zzKS = Builder.zza(paramBuilder);
    this.zzwg = Builder.zzb(paramBuilder);
    this.zzKT = Builder.zzc(paramBuilder);
    this.zzKU = Builder.zzd(paramBuilder);
    this.zzKV = Builder.zze(paramBuilder);
    this.zzKW = Builder.zzf(paramBuilder);
    this.zzKX = Builder.zzg(paramBuilder);
    this.zzKY = Builder.zzh(paramBuilder);
    this.zzKZ = Builder.zzi(paramBuilder);
    this.zzLa = Builder.zzj(paramBuilder);
    this.zzLb = Builder.zzk(paramBuilder);
    this.zzLc = Builder.zzl(paramBuilder);
    this.zzLd = Builder.zzm(paramBuilder);
    this.zzLe = Builder.zzn(paramBuilder);
    this.zznO = new zzy(Builder.zzo(paramBuilder), this);
  }
  
  public int getAnchorTextColor()
  {
    return this.zzKS;
  }
  
  public int getBackgroundColor()
  {
    return this.zzwg;
  }
  
  public int getBackgroundGradientBottom()
  {
    return this.zzKT;
  }
  
  public int getBackgroundGradientTop()
  {
    return this.zzKU;
  }
  
  public int getBorderColor()
  {
    return this.zzKV;
  }
  
  public int getBorderThickness()
  {
    return this.zzKW;
  }
  
  public int getBorderType()
  {
    return this.zzKX;
  }
  
  public int getCallButtonColor()
  {
    return this.zzKY;
  }
  
  public String getCustomChannels()
  {
    return this.zzKZ;
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.zznO.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getDescriptionTextColor()
  {
    return this.zzLa;
  }
  
  public String getFontFace()
  {
    return this.zzLb;
  }
  
  public int getHeaderTextColor()
  {
    return this.zzLc;
  }
  
  public int getHeaderTextSize()
  {
    return this.zzLd;
  }
  
  public Location getLocation()
  {
    return this.zznO.getLocation();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.zznO.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.zznO.getNetworkExtrasBundle(paramClass);
  }
  
  public String getQuery()
  {
    return this.zzLe;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.zznO.isTestDevice(paramContext);
  }
  
  zzy zzaF()
  {
    return this.zznO;
  }
  
  public static final class Builder
  {
    private int zzKS;
    private int zzKT;
    private int zzKU;
    private int zzKV;
    private int zzKW;
    private int zzKX = 0;
    private int zzKY;
    private String zzKZ;
    private int zzLa;
    private String zzLb;
    private int zzLc;
    private int zzLd;
    private String zzLe;
    private final zzy.zza zznP = new zzy.zza();
    private int zzwg;
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.zznP.zzb(paramClass, paramBundle);
      return this;
    }
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.zznP.zza(paramNetworkExtras);
      return this;
    }
    
    public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.zznP.zza(paramClass, paramBundle);
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      this.zznP.zzG(paramString);
      return this;
    }
    
    public SearchAdRequest build()
    {
      return new SearchAdRequest(this, null);
    }
    
    public Builder setAnchorTextColor(int paramInt)
    {
      this.zzKS = paramInt;
      return this;
    }
    
    public Builder setBackgroundColor(int paramInt)
    {
      this.zzwg = paramInt;
      this.zzKT = Color.argb(0, 0, 0, 0);
      this.zzKU = Color.argb(0, 0, 0, 0);
      return this;
    }
    
    public Builder setBackgroundGradient(int paramInt1, int paramInt2)
    {
      this.zzwg = Color.argb(0, 0, 0, 0);
      this.zzKT = paramInt2;
      this.zzKU = paramInt1;
      return this;
    }
    
    public Builder setBorderColor(int paramInt)
    {
      this.zzKV = paramInt;
      return this;
    }
    
    public Builder setBorderThickness(int paramInt)
    {
      this.zzKW = paramInt;
      return this;
    }
    
    public Builder setBorderType(int paramInt)
    {
      this.zzKX = paramInt;
      return this;
    }
    
    public Builder setCallButtonColor(int paramInt)
    {
      this.zzKY = paramInt;
      return this;
    }
    
    public Builder setCustomChannels(String paramString)
    {
      this.zzKZ = paramString;
      return this;
    }
    
    public Builder setDescriptionTextColor(int paramInt)
    {
      this.zzLa = paramInt;
      return this;
    }
    
    public Builder setFontFace(String paramString)
    {
      this.zzLb = paramString;
      return this;
    }
    
    public Builder setHeaderTextColor(int paramInt)
    {
      this.zzLc = paramInt;
      return this;
    }
    
    public Builder setHeaderTextSize(int paramInt)
    {
      this.zzLd = paramInt;
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.zznP.zzb(paramLocation);
      return this;
    }
    
    public Builder setQuery(String paramString)
    {
      this.zzLe = paramString;
      return this;
    }
    
    public Builder setRequestAgent(String paramString)
    {
      this.zznP.zzK(paramString);
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.zznP.zzj(paramBoolean);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\search\SearchAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */