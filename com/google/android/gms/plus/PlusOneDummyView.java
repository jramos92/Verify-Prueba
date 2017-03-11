package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class PlusOneDummyView
  extends FrameLayout
{
  public static final String TAG = "PlusOneDummyView";
  
  public PlusOneDummyView(Context paramContext, int paramInt)
  {
    super(paramContext);
    paramContext = new Button(paramContext);
    paramContext.setEnabled(false);
    paramContext.setBackgroundDrawable(zzBw().getDrawable(paramInt));
    Point localPoint = zziW(paramInt);
    addView(paramContext, new FrameLayout.LayoutParams(localPoint.x, localPoint.y, 17));
  }
  
  private zzd zzBw()
  {
    Object localObject2 = new zzb(getContext(), null);
    Object localObject1 = localObject2;
    if (!((zzd)localObject2).isValid()) {
      localObject1 = new zzc(getContext(), null);
    }
    localObject2 = localObject1;
    if (!((zzd)localObject1).isValid()) {
      localObject2 = new zza(getContext(), null);
    }
    return (zzd)localObject2;
  }
  
  private Point zziW(int paramInt)
  {
    int j = 24;
    int i = 20;
    Point localPoint = new Point();
    switch (paramInt)
    {
    default: 
      paramInt = 38;
      i = 24;
    }
    for (;;)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      float f1 = TypedValue.applyDimension(1, paramInt, localDisplayMetrics);
      float f2 = TypedValue.applyDimension(1, i, localDisplayMetrics);
      localPoint.x = ((int)(f1 + 0.5D));
      localPoint.y = ((int)(f2 + 0.5D));
      return localPoint;
      paramInt = 32;
      continue;
      i = 14;
      paramInt = j;
      continue;
      paramInt = 50;
    }
  }
  
  private static class zza
    implements PlusOneDummyView.zzd
  {
    private Context mContext;
    
    private zza(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public Drawable getDrawable(int paramInt)
    {
      return this.mContext.getResources().getDrawable(17301508);
    }
    
    public boolean isValid()
    {
      return true;
    }
  }
  
  private static class zzb
    implements PlusOneDummyView.zzd
  {
    private Context mContext;
    
    private zzb(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public Drawable getDrawable(int paramInt)
    {
      for (;;)
      {
        try
        {
          Resources localResources = this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
          switch (paramInt)
          {
          case 2: 
            return localResources.getDrawable(localResources.getIdentifier(str1, "drawable", "com.google.android.gms"));
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          String str1;
          return null;
        }
        str1 = "ic_plusone_tall";
        continue;
        String str2 = "ic_plusone_standard";
        continue;
        str2 = "ic_plusone_small";
        continue;
        str2 = "ic_plusone_medium";
      }
    }
    
    public boolean isValid()
    {
      try
      {
        this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
        return true;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      return false;
    }
  }
  
  private static class zzc
    implements PlusOneDummyView.zzd
  {
    private Context mContext;
    
    private zzc(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public Drawable getDrawable(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "ic_plusone_standard_off_client";
      }
      for (;;)
      {
        paramInt = this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName());
        return this.mContext.getResources().getDrawable(paramInt);
        str = "ic_plusone_small_off_client";
        continue;
        str = "ic_plusone_medium_off_client";
        continue;
        str = "ic_plusone_tall_off_client";
      }
    }
    
    public boolean isValid()
    {
      int i = this.mContext.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.mContext.getPackageName());
      int j = this.mContext.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.mContext.getPackageName());
      int k = this.mContext.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.mContext.getPackageName());
      int m = this.mContext.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.mContext.getPackageName());
      return (i != 0) && (j != 0) && (k != 0) && (m != 0);
    }
  }
  
  private static abstract interface zzd
  {
    public abstract Drawable getDrawable(int paramInt);
    
    public abstract boolean isValid();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\PlusOneDummyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */