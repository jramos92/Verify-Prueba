package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgr
public class zzgj
  extends zzgi
{
  private Object zzDw = new Object();
  private PopupWindow zzDx;
  private boolean zzDy = false;
  
  zzgj(Context paramContext, zzhs.zza paramzza, zziz paramzziz, zzgg.zza paramzza1)
  {
    super(paramContext, paramzza, paramzziz, paramzza1);
  }
  
  private void zzfA()
  {
    synchronized (this.zzDw)
    {
      this.zzDy = true;
      if (((this.mContext instanceof Activity)) && (((Activity)this.mContext).isDestroyed())) {
        this.zzDx = null;
      }
      if (this.zzDx != null)
      {
        if (this.zzDx.isShowing()) {
          this.zzDx.dismiss();
        }
        this.zzDx = null;
      }
      return;
    }
  }
  
  public void cancel()
  {
    zzfA();
    super.cancel();
  }
  
  protected void zzfz()
  {
    if ((this.mContext instanceof Activity)) {}
    Object localObject2;
    for (Window localWindow = ((Activity)this.mContext).getWindow();; localObject2 = null)
    {
      if ((localWindow == null) || (localWindow.getDecorView() == null)) {}
      while (((Activity)this.mContext).isDestroyed()) {
        return;
      }
      FrameLayout localFrameLayout = new FrameLayout(this.mContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.addView(this.zzoM.getView(), -1, -1);
      synchronized (this.zzDw)
      {
        if (this.zzDy) {
          return;
        }
      }
      this.zzDx = new PopupWindow(localFrameLayout, 1, 1, false);
      this.zzDx.setOutsideTouchable(true);
      this.zzDx.setClippingEnabled(false);
      zzb.zzaF("Displaying the 1x1 popup off the screen.");
      try
      {
        this.zzDx.showAtLocation(((Window)localObject1).getDecorView(), 0, -1, -1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.zzDx = null;
        }
      }
    }
  }
  
  protected void zzz(int paramInt)
  {
    zzfA();
    super.zzz(paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */