package com.veryfit.multi.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageBuilder
{
  private ImageEngine mImageEngine;
  private DisplayImageOptions mImageOptions;
  private List<String> mUrls = new ArrayList();
  
  ImageBuilder(DisplayImageOptions paramDisplayImageOptions, ImageEngine paramImageEngine)
  {
    this.mImageOptions = paramDisplayImageOptions;
    this.mImageEngine = paramImageEngine;
  }
  
  public File getImageFile(String paramString)
  {
    return this.mImageEngine.getImageLoager().getDiscCache().get(paramString);
  }
  
  DisplayImageOptions getOption()
  {
    return this.mImageOptions;
  }
  
  public void release()
  {
    MemoryCacheAware localMemoryCacheAware = this.mImageEngine.getImageLoager().getMemoryCache();
    Iterator localIterator = this.mUrls.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.mUrls.clear();
        return;
      }
      Bitmap localBitmap = (Bitmap)localMemoryCacheAware.get((String)localIterator.next());
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
  }
  
  public void showImageView(ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramImageView.setImageResource(this.mImageOptions.getImageForEmptyUri());
      return;
    }
    if (!this.mUrls.contains(paramString)) {
      this.mUrls.add(paramString);
    }
    Bitmap localBitmap = (Bitmap)this.mImageEngine.getImageLoager().getMemoryCache().get(paramString);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      return;
    }
    this.mImageEngine.displayImage(paramString, paramImageView, this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\ImageBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */