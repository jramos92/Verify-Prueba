package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

public final class DisplayImageOptions
{
  private final boolean cacheInMemory;
  private final boolean cacheOnDisc;
  private final BitmapFactory.Options decodingOptions;
  private final int delayBeforeLoading;
  private final BitmapDisplayer displayer;
  private final Object extraForDownloader;
  private final Handler handler;
  private final int imageForEmptyUri;
  private final int imageOnFail;
  private final ImageScaleType imageScaleType;
  private final BitmapProcessor postProcessor;
  private final BitmapProcessor preProcessor;
  private final boolean resetViewBeforeLoading;
  private final int stubImage;
  
  private DisplayImageOptions(Builder paramBuilder)
  {
    this.stubImage = paramBuilder.stubImage;
    this.imageForEmptyUri = paramBuilder.imageForEmptyUri;
    this.imageOnFail = paramBuilder.imageOnFail;
    this.resetViewBeforeLoading = paramBuilder.resetViewBeforeLoading;
    this.cacheInMemory = paramBuilder.cacheInMemory;
    this.cacheOnDisc = paramBuilder.cacheOnDisc;
    this.imageScaleType = paramBuilder.imageScaleType;
    this.decodingOptions = paramBuilder.decodingOptions;
    this.delayBeforeLoading = paramBuilder.delayBeforeLoading;
    this.extraForDownloader = paramBuilder.extraForDownloader;
    this.preProcessor = paramBuilder.preProcessor;
    this.postProcessor = paramBuilder.postProcessor;
    this.displayer = paramBuilder.displayer;
    this.handler = paramBuilder.handler;
  }
  
  public static DisplayImageOptions createSimple()
  {
    return new Builder().build();
  }
  
  public BitmapFactory.Options getDecodingOptions()
  {
    return this.decodingOptions;
  }
  
  public int getDelayBeforeLoading()
  {
    return this.delayBeforeLoading;
  }
  
  public BitmapDisplayer getDisplayer()
  {
    return this.displayer;
  }
  
  public Object getExtraForDownloader()
  {
    return this.extraForDownloader;
  }
  
  public Handler getHandler()
  {
    if (this.handler == null) {
      return new Handler();
    }
    return this.handler;
  }
  
  public int getImageForEmptyUri()
  {
    return this.imageForEmptyUri;
  }
  
  public int getImageOnFail()
  {
    return this.imageOnFail;
  }
  
  public ImageScaleType getImageScaleType()
  {
    return this.imageScaleType;
  }
  
  public BitmapProcessor getPostProcessor()
  {
    return this.postProcessor;
  }
  
  public BitmapProcessor getPreProcessor()
  {
    return this.preProcessor;
  }
  
  public int getStubImage()
  {
    return this.stubImage;
  }
  
  public boolean isCacheInMemory()
  {
    return this.cacheInMemory;
  }
  
  public boolean isCacheOnDisc()
  {
    return this.cacheOnDisc;
  }
  
  public boolean isResetViewBeforeLoading()
  {
    return this.resetViewBeforeLoading;
  }
  
  public boolean shouldDelayBeforeLoading()
  {
    return this.delayBeforeLoading > 0;
  }
  
  public boolean shouldPostProcess()
  {
    return this.postProcessor != null;
  }
  
  public boolean shouldPreProcess()
  {
    return this.preProcessor != null;
  }
  
  public boolean shouldShowImageForEmptyUri()
  {
    return this.imageForEmptyUri != 0;
  }
  
  public boolean shouldShowImageOnFail()
  {
    return this.imageOnFail != 0;
  }
  
  public boolean shouldShowStubImage()
  {
    return this.stubImage != 0;
  }
  
  public static class Builder
  {
    private boolean cacheInMemory = false;
    private boolean cacheOnDisc = false;
    private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
    private int delayBeforeLoading = 0;
    private BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
    private Object extraForDownloader = null;
    private Handler handler = null;
    private int imageForEmptyUri = 0;
    private int imageOnFail = 0;
    private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
    private BitmapProcessor postProcessor = null;
    private BitmapProcessor preProcessor = null;
    private boolean resetViewBeforeLoading = false;
    private int stubImage = 0;
    
    public Builder()
    {
      this.decodingOptions.inPurgeable = true;
      this.decodingOptions.inInputShareable = true;
    }
    
    public Builder bitmapConfig(Bitmap.Config paramConfig)
    {
      this.decodingOptions.inPreferredConfig = paramConfig;
      return this;
    }
    
    public DisplayImageOptions build()
    {
      return new DisplayImageOptions(this, null);
    }
    
    public Builder cacheInMemory()
    {
      this.cacheInMemory = true;
      return this;
    }
    
    public Builder cacheOnDisc()
    {
      this.cacheOnDisc = true;
      return this;
    }
    
    public Builder cloneFrom(DisplayImageOptions paramDisplayImageOptions)
    {
      this.stubImage = paramDisplayImageOptions.stubImage;
      this.imageForEmptyUri = paramDisplayImageOptions.imageForEmptyUri;
      this.imageOnFail = paramDisplayImageOptions.imageOnFail;
      this.resetViewBeforeLoading = paramDisplayImageOptions.resetViewBeforeLoading;
      this.cacheInMemory = paramDisplayImageOptions.cacheInMemory;
      this.cacheOnDisc = paramDisplayImageOptions.cacheOnDisc;
      this.imageScaleType = paramDisplayImageOptions.imageScaleType;
      this.decodingOptions = paramDisplayImageOptions.decodingOptions;
      this.delayBeforeLoading = paramDisplayImageOptions.delayBeforeLoading;
      this.extraForDownloader = paramDisplayImageOptions.extraForDownloader;
      this.preProcessor = paramDisplayImageOptions.preProcessor;
      this.postProcessor = paramDisplayImageOptions.postProcessor;
      this.displayer = paramDisplayImageOptions.displayer;
      this.handler = paramDisplayImageOptions.handler;
      return this;
    }
    
    public Builder decodingOptions(BitmapFactory.Options paramOptions)
    {
      this.decodingOptions = paramOptions;
      return this;
    }
    
    public Builder delayBeforeLoading(int paramInt)
    {
      this.delayBeforeLoading = paramInt;
      return this;
    }
    
    public Builder displayer(BitmapDisplayer paramBitmapDisplayer)
    {
      this.displayer = paramBitmapDisplayer;
      return this;
    }
    
    public Builder extraForDownloader(Object paramObject)
    {
      this.extraForDownloader = paramObject;
      return this;
    }
    
    public Builder handler(Handler paramHandler)
    {
      this.handler = paramHandler;
      return this;
    }
    
    public Builder imageScaleType(ImageScaleType paramImageScaleType)
    {
      this.imageScaleType = paramImageScaleType;
      return this;
    }
    
    public Builder postProcessor(BitmapProcessor paramBitmapProcessor)
    {
      this.postProcessor = paramBitmapProcessor;
      return this;
    }
    
    public Builder preProcessor(BitmapProcessor paramBitmapProcessor)
    {
      this.preProcessor = paramBitmapProcessor;
      return this;
    }
    
    public Builder resetViewBeforeLoading()
    {
      this.resetViewBeforeLoading = true;
      return this;
    }
    
    public Builder showImageForEmptyUri(int paramInt)
    {
      this.imageForEmptyUri = paramInt;
      return this;
    }
    
    public Builder showImageOnFail(int paramInt)
    {
      this.imageOnFail = paramInt;
      return this;
    }
    
    public Builder showStubImage(int paramInt)
    {
      this.stubImage = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\DisplayImageOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */