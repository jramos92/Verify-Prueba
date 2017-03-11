package com.veryfit.multi.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.vpeffect.DefaultTransformer;
import java.util.ArrayList;
import java.util.List;

public class GuideActivity
  extends BaseActivity
{
  private static Guide guide = Guide.App;
  private List<ImageView> mImageViews = new ArrayList();
  private int[] mImgIds;
  private ViewPager mViewPager;
  private TextView title;
  private ImageView toBack;
  
  private void initImageDatas(Guide paramGuide)
  {
    int i = 0;
    int j;
    switch (paramGuide)
    {
    default: 
      paramGuide = this.mImgIds;
      j = paramGuide.length;
    }
    for (;;)
    {
      if (i >= j)
      {
        return;
        this.title.setText(2131296516);
        this.mImgIds = new int[] { 2130837512 };
        break;
        this.title.setText(2131296515);
        this.mImgIds = new int[] { 2130837512 };
        break;
      }
      int k = paramGuide[i];
      ImageView localImageView = new ImageView(getApplicationContext());
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageResource(k);
      this.mImageViews.add(localImageView);
      i += 1;
    }
  }
  
  public static void startActivity(Context paramContext, Guide paramGuide)
  {
    guide = paramGuide;
    paramContext.startActivity(new Intent(paramContext, GuideActivity.class));
  }
  
  protected void initData()
  {
    super.initData();
    initImageDatas(guide);
  }
  
  protected void initEvent()
  {
    super.initEvent();
    this.toBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        GuideActivity.this.finish();
      }
    });
    initImageDatas(guide);
    this.mViewPager.setPageTransformer(true, new DefaultTransformer());
    this.mViewPager.setAdapter(new PagerAdapter()
    {
      public void destroyItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt, Object paramAnonymousObject)
      {
        paramAnonymousViewGroup.removeView((View)GuideActivity.this.mImageViews.get(paramAnonymousInt));
      }
      
      public int getCount()
      {
        return GuideActivity.this.mImgIds.length;
      }
      
      public Object instantiateItem(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        paramAnonymousViewGroup.addView((View)GuideActivity.this.mImageViews.get(paramAnonymousInt));
        return GuideActivity.this.mImageViews.get(paramAnonymousInt);
      }
      
      public boolean isViewFromObject(View paramAnonymousView, Object paramAnonymousObject)
      {
        return paramAnonymousView == paramAnonymousObject;
      }
    });
  }
  
  protected void initFirst()
  {
    super.initFirst();
  }
  
  protected void initView()
  {
    super.initView();
    this.title = ((TextView)findViewById(2131230730));
    this.toBack = ((ImageView)findViewById(2131230729));
    this.mViewPager = ((ViewPager)findViewById(2131230776));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903053);
    super.onCreate(paramBundle);
  }
  
  protected void onThemeChanged() {}
  
  public static enum Guide
  {
    App,  Function;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\GuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */