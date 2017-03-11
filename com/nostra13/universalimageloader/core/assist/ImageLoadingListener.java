package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface ImageLoadingListener
{
  public abstract void onLoadingCancelled(String paramString, View paramView);
  
  public abstract void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap);
  
  public abstract void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason);
  
  public abstract void onLoadingStarted(String paramString, View paramView);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\assist\ImageLoadingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */