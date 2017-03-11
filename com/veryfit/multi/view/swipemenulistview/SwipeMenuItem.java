package com.veryfit.multi.view.swipemenulistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class SwipeMenuItem
{
  private Drawable background;
  private Drawable icon;
  private int id;
  private Context mContext;
  private String title;
  private int titleColor;
  private int titleSize;
  private int width;
  
  public SwipeMenuItem(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public Drawable getBackground()
  {
    return this.background;
  }
  
  public Drawable getIcon()
  {
    return this.icon;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getTitleColor()
  {
    return this.titleColor;
  }
  
  public int getTitleSize()
  {
    return this.titleSize;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setBackground(int paramInt)
  {
    this.background = this.mContext.getResources().getDrawable(paramInt);
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    this.background = paramDrawable;
  }
  
  public void setIcon(int paramInt)
  {
    this.icon = this.mContext.getResources().getDrawable(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.icon = paramDrawable;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setTitleColor(int paramInt)
  {
    this.titleColor = paramInt;
  }
  
  public void setTitleSize(int paramInt)
  {
    this.titleSize = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\swipemenulistview\SwipeMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */