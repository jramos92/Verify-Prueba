package com.google.android.gms.ads.formats;

public final class NativeAdOptions
{
  public static final int ORIENTATION_ANY = 0;
  public static final int ORIENTATION_LANDSCAPE = 2;
  public static final int ORIENTATION_PORTRAIT = 1;
  private final boolean zznW;
  private final int zznX;
  private final boolean zznY;
  
  private NativeAdOptions(Builder paramBuilder)
  {
    this.zznW = Builder.zza(paramBuilder);
    this.zznX = Builder.zzb(paramBuilder);
    this.zznY = Builder.zzc(paramBuilder);
  }
  
  public int getImageOrientation()
  {
    return this.zznX;
  }
  
  public boolean shouldRequestMultipleImages()
  {
    return this.zznY;
  }
  
  public boolean shouldReturnUrlsForImageAssets()
  {
    return this.zznW;
  }
  
  public static final class Builder
  {
    private boolean zznW = false;
    private int zznX = 0;
    private boolean zznY = false;
    
    public NativeAdOptions build()
    {
      return new NativeAdOptions(this, null);
    }
    
    public Builder setImageOrientation(int paramInt)
    {
      this.zznX = paramInt;
      return this;
    }
    
    public Builder setRequestMultipleImages(boolean paramBoolean)
    {
      this.zznY = paramBoolean;
      return this;
    }
    
    public Builder setReturnUrlsForImageAssets(boolean paramBoolean)
    {
      this.zznW = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\formats\NativeAdOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */