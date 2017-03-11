package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper
  extends NativeAdMapper
{
  private NativeAd.Image zzKJ;
  private String zzwo;
  private List<NativeAd.Image> zzwp;
  private String zzwq;
  private String zzws;
  private double zzwt;
  private String zzwu;
  private String zzwv;
  
  public final String getBody()
  {
    return this.zzwq;
  }
  
  public final String getCallToAction()
  {
    return this.zzws;
  }
  
  public final String getHeadline()
  {
    return this.zzwo;
  }
  
  public final NativeAd.Image getIcon()
  {
    return this.zzKJ;
  }
  
  public final List<NativeAd.Image> getImages()
  {
    return this.zzwp;
  }
  
  public final String getPrice()
  {
    return this.zzwv;
  }
  
  public final double getStarRating()
  {
    return this.zzwt;
  }
  
  public final String getStore()
  {
    return this.zzwu;
  }
  
  public final void setBody(String paramString)
  {
    this.zzwq = paramString;
  }
  
  public final void setCallToAction(String paramString)
  {
    this.zzws = paramString;
  }
  
  public final void setHeadline(String paramString)
  {
    this.zzwo = paramString;
  }
  
  public final void setIcon(NativeAd.Image paramImage)
  {
    this.zzKJ = paramImage;
  }
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    this.zzwp = paramList;
  }
  
  public final void setPrice(String paramString)
  {
    this.zzwv = paramString;
  }
  
  public final void setStarRating(double paramDouble)
  {
    this.zzwt = paramDouble;
  }
  
  public final void setStore(String paramString)
  {
    this.zzwu = paramString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\mediation\NativeAppInstallAdMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */