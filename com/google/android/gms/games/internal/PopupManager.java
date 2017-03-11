package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.google.android.gms.internal.zzmx;
import java.lang.ref.WeakReference;

public class PopupManager
{
  protected GamesClientImpl zzawM;
  protected PopupLocationInfo zzawN;
  
  private PopupManager(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    this.zzawM = paramGamesClientImpl;
    zzfY(paramInt);
  }
  
  public static PopupManager zza(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    if (zzmx.zzqv()) {
      return new PopupManagerHCMR1(paramGamesClientImpl, paramInt);
    }
    return new PopupManager(paramGamesClientImpl, paramInt);
  }
  
  public void setGravity(int paramInt)
  {
    this.zzawN.gravity = paramInt;
  }
  
  protected void zzfY(int paramInt)
  {
    this.zzawN = new PopupLocationInfo(paramInt, new Binder(), null);
  }
  
  public void zzo(View paramView) {}
  
  public void zzvf()
  {
    this.zzawM.zza(this.zzawN.zzawO, this.zzawN.zzve());
  }
  
  public Bundle zzvg()
  {
    return this.zzawN.zzve();
  }
  
  public IBinder zzvh()
  {
    return this.zzawN.zzawO;
  }
  
  public PopupLocationInfo zzvi()
  {
    return this.zzawN;
  }
  
  public static final class PopupLocationInfo
  {
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    public IBinder zzawO;
    public int zzawP = -1;
    
    private PopupLocationInfo(int paramInt, IBinder paramIBinder)
    {
      this.gravity = paramInt;
      this.zzawO = paramIBinder;
    }
    
    public Bundle zzve()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("popupLocationInfo.gravity", this.gravity);
      localBundle.putInt("popupLocationInfo.displayId", this.zzawP);
      localBundle.putInt("popupLocationInfo.left", this.left);
      localBundle.putInt("popupLocationInfo.top", this.top);
      localBundle.putInt("popupLocationInfo.right", this.right);
      localBundle.putInt("popupLocationInfo.bottom", this.bottom);
      return localBundle;
    }
  }
  
  private static final class PopupManagerHCMR1
    extends PopupManager
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
  {
    private boolean zzavm = false;
    private WeakReference<View> zzawQ;
    
    protected PopupManagerHCMR1(GamesClientImpl paramGamesClientImpl, int paramInt)
    {
      super(paramInt, null);
    }
    
    private void zzp(View paramView)
    {
      int j = -1;
      int i = j;
      if (zzmx.zzqz())
      {
        localObject = paramView.getDisplay();
        i = j;
        if (localObject != null) {
          i = ((Display)localObject).getDisplayId();
        }
      }
      Object localObject = paramView.getWindowToken();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      j = paramView.getWidth();
      int k = paramView.getHeight();
      this.zzawN.zzawP = i;
      this.zzawN.zzawO = ((IBinder)localObject);
      this.zzawN.left = arrayOfInt[0];
      this.zzawN.top = arrayOfInt[1];
      this.zzawN.right = (arrayOfInt[0] + j);
      this.zzawN.bottom = (arrayOfInt[1] + k);
      if (this.zzavm)
      {
        zzvf();
        this.zzavm = false;
      }
    }
    
    public void onGlobalLayout()
    {
      if (this.zzawQ == null) {}
      View localView;
      do
      {
        return;
        localView = (View)this.zzawQ.get();
      } while (localView == null);
      zzp(localView);
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      zzp(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      this.zzawM.zzuT();
      paramView.removeOnAttachStateChangeListener(this);
    }
    
    protected void zzfY(int paramInt)
    {
      this.zzawN = new PopupManager.PopupLocationInfo(paramInt, null, null);
    }
    
    public void zzo(View paramView)
    {
      this.zzawM.zzuT();
      Object localObject2;
      Object localObject1;
      if (this.zzawQ != null)
      {
        localObject2 = (View)this.zzawQ.get();
        Context localContext = this.zzawM.getContext();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if ((localContext instanceof Activity)) {
            localObject1 = ((Activity)localContext).getWindow().getDecorView();
          }
        }
        if (localObject1 != null)
        {
          ((View)localObject1).removeOnAttachStateChangeListener(this);
          localObject1 = ((View)localObject1).getViewTreeObserver();
          if (!zzmx.zzqy()) {
            break label186;
          }
          ((ViewTreeObserver)localObject1).removeOnGlobalLayoutListener(this);
        }
      }
      for (;;)
      {
        this.zzawQ = null;
        localObject2 = this.zzawM.getContext();
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = paramView;
          if ((localObject2 instanceof Activity))
          {
            localObject1 = ((Activity)localObject2).findViewById(16908290);
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = ((Activity)localObject2).getWindow().getDecorView();
            }
            GamesLog.zzy("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
            localObject1 = paramView;
          }
        }
        if (localObject1 == null) {
          break;
        }
        zzp((View)localObject1);
        this.zzawQ = new WeakReference(localObject1);
        ((View)localObject1).addOnAttachStateChangeListener(this);
        ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        label186:
        ((ViewTreeObserver)localObject1).removeGlobalOnLayoutListener(this);
      }
      GamesLog.zzz("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }
    
    public void zzvf()
    {
      if (this.zzawN.zzawO != null)
      {
        super.zzvf();
        return;
      }
      if (this.zzawQ != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.zzavm = bool;
        return;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\PopupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */