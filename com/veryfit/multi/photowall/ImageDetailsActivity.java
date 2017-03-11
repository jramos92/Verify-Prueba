package com.veryfit.multi.photowall;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.veryfit.multi.camera.SDCardImageLoader;
import com.veryfit.multi.util.Util;
import java.io.File;
import java.util.List;

public class ImageDetailsActivity
  extends Activity
  implements ViewPager.OnPageChangeListener
{
  private TextView pageText;
  private TextView tv_cancel;
  private ViewPager viewPager;
  
  private String getImagePath(String paramString)
  {
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
    String str = Environment.getExternalStorageDirectory().getPath() + "/PhotoWallFalls/";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903065);
    int i = getIntent().getIntExtra("image_position", 0);
    this.pageText = ((TextView)findViewById(2131230863));
    this.viewPager = ((ViewPager)findViewById(2131230861));
    this.tv_cancel = ((TextView)findViewById(2131230862));
    Images.getImages();
    paramBundle = new ViewPagerAdapter();
    this.viewPager.setAdapter(paramBundle);
    this.viewPager.setCurrentItem(i);
    this.viewPager.setOnPageChangeListener(this);
    this.viewPager.setEnabled(false);
    this.pageText.setText(i + 1 + "/" + Images.mCameraImgs.size());
    this.tv_cancel.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ImageDetailsActivity.this.finish();
      }
    });
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.pageText.setText(paramInt + 1 + "/" + Images.mCameraImgs.size());
  }
  
  protected void onResume()
  {
    super.onResume();
    List localList = Images.getImages();
    if ((localList == null) || (localList.size() <= 0))
    {
      Util.showToast(this, 2131296621, 0);
      finish();
    }
  }
  
  class ViewPagerAdapter
    extends PagerAdapter
  {
    ViewPagerAdapter() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      if (Images.mCameraImgs != null) {
        return Images.mCameraImgs.size();
      }
      return 0;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject1 = (String)Images.mCameraImgs.get(paramInt);
      Object localObject2 = SDCardImageLoader.getInstance().compressBitmap((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = BitmapFactory.decodeResource(ImageDetailsActivity.this.getResources(), 2130837559);
      }
      localObject2 = LayoutInflater.from(ImageDetailsActivity.this).inflate(2130903066, null);
      ((ZoomImageView)((View)localObject2).findViewById(2131230864)).setImageBitmap((Bitmap)localObject1);
      paramViewGroup.addView((View)localObject2);
      return localObject2;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\photowall\ImageDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */