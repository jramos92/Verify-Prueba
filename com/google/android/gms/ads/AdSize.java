package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;

public final class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
  public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
  public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
  public static final int FULL_WIDTH = -1;
  public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
  public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
  public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
  public static final AdSize SMART_BANNER;
  public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
  private final int zznQ;
  private final int zznR;
  private final String zznS;
  
  static
  {
    SMART_BANNER = new AdSize(-1, -2, "smart_banner");
  }
  
  public AdSize(int paramInt1, int paramInt2) {}
  
  AdSize(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1) && (paramInt1 != -3)) {
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2) && (paramInt2 != -4)) {
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    this.zznQ = paramInt1;
    this.zznR = paramInt2;
    this.zznS = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AdSize)) {
        return false;
      }
      paramObject = (AdSize)paramObject;
    } while ((this.zznQ == ((AdSize)paramObject).zznQ) && (this.zznR == ((AdSize)paramObject).zznR) && (this.zznS.equals(((AdSize)paramObject).zznS)));
    return false;
  }
  
  public int getHeight()
  {
    return this.zznR;
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    switch (this.zznR)
    {
    default: 
      return zzl.zzcF().zzb(paramContext, this.zznR);
    case -2: 
      return AdSizeParcel.zzb(paramContext.getResources().getDisplayMetrics());
    }
    return -1;
  }
  
  public int getWidth()
  {
    return this.zznQ;
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    switch (this.zznQ)
    {
    case -2: 
    default: 
      return zzl.zzcF().zzb(paramContext, this.zznQ);
    case -1: 
      return AdSizeParcel.zza(paramContext.getResources().getDisplayMetrics());
    }
    return -1;
  }
  
  public int hashCode()
  {
    return this.zznS.hashCode();
  }
  
  public boolean isAutoHeight()
  {
    return this.zznR == -2;
  }
  
  public boolean isFluid()
  {
    return (this.zznQ == -3) && (this.zznR == -4);
  }
  
  public boolean isFullWidth()
  {
    return this.zznQ == -1;
  }
  
  public String toString()
  {
    return this.zznS;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\AdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */