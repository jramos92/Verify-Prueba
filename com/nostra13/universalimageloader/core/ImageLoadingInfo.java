package com.nostra13.universalimageloader.core;

import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import java.util.concurrent.locks.ReentrantLock;

final class ImageLoadingInfo
{
  final ImageView imageView;
  final ImageLoadingListener listener;
  final ReentrantLock loadFromUriLock;
  final String memoryCacheKey;
  final DisplayImageOptions options;
  final ImageSize targetSize;
  final String uri;
  
  public ImageLoadingInfo(String paramString1, ImageView paramImageView, ImageSize paramImageSize, String paramString2, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ReentrantLock paramReentrantLock)
  {
    this.uri = paramString1;
    this.imageView = paramImageView;
    this.targetSize = paramImageSize;
    this.options = paramDisplayImageOptions;
    this.listener = paramImageLoadingListener;
    this.loadFromUriLock = paramReentrantLock;
    this.memoryCacheKey = paramString2;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\ImageLoadingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */