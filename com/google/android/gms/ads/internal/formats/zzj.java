package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzco.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zziz;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class zzj
  extends zzco.zza
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private final FrameLayout zznZ;
  private final Object zzpd = new Object();
  private final FrameLayout zzwU;
  private final Map<String, WeakReference<View>> zzwV = new HashMap();
  private zzb zzwW;
  boolean zzwX = false;
  int zzwY;
  int zzwZ;
  private zzh zzwx;
  
  public zzj(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    this.zzwU = paramFrameLayout1;
    this.zznZ = paramFrameLayout2;
    zziu.zza(this.zzwU, this);
    zziu.zza(this.zzwU, this);
    this.zzwU.setOnTouchListener(this);
  }
  
  int getMeasuredHeight()
  {
    return this.zzwU.getMeasuredHeight();
  }
  
  int getMeasuredWidth()
  {
    return this.zzwU.getMeasuredWidth();
  }
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject1;
    synchronized (this.zzpd)
    {
      if (this.zzwx == null) {
        return;
      }
      localJSONObject1 = new JSONObject();
      localObject2 = this.zzwV.entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          View localView = (View)((WeakReference)localEntry.getValue()).get();
          Point localPoint = zzj(localView);
          JSONObject localJSONObject2 = new JSONObject();
          try
          {
            localJSONObject2.put("width", zzp(localView.getWidth()));
            localJSONObject2.put("height", zzp(localView.getHeight()));
            localJSONObject2.put("x", zzp(localPoint.x));
            localJSONObject2.put("y", zzp(localPoint.y));
            localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
          }
          catch (JSONException localJSONException2)
          {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get view rectangle for view " + (String)localEntry.getKey());
          }
        }
      }
    }
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("x", zzp(this.zzwY));
      ((JSONObject)localObject2).put("y", zzp(this.zzwZ));
      if ((this.zzwW != null) && (this.zzwW.zzdu().equals(paramView)))
      {
        this.zzwx.zza("1007", localJSONObject1, (JSONObject)localObject2);
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get click location");
        continue;
        this.zzwx.zza(paramView, this.zzwV, localJSONObject1, (JSONObject)localObject2);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    synchronized (this.zzpd)
    {
      if (this.zzwX)
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((i != 0) && (j != 0))
        {
          this.zznZ.setLayoutParams(new FrameLayout.LayoutParams(i, j));
          this.zzwX = false;
        }
      }
      if (this.zzwx != null) {
        this.zzwx.zzi(this.zzwU);
      }
      return;
    }
  }
  
  public void onScrollChanged()
  {
    synchronized (this.zzpd)
    {
      if (this.zzwx != null) {
        this.zzwx.zzi(this.zzwU);
      }
      return;
    }
  }
  
  public boolean onTouch(View arg1, MotionEvent paramMotionEvent)
  {
    synchronized (this.zzpd)
    {
      if (this.zzwx == null) {
        return false;
      }
      Point localPoint = zzc(paramMotionEvent);
      this.zzwY = localPoint.x;
      this.zzwZ = localPoint.y;
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setLocation(localPoint.x, localPoint.y);
      this.zzwx.zzb(paramMotionEvent);
      paramMotionEvent.recycle();
      return false;
    }
  }
  
  public zzd zzW(String paramString)
  {
    synchronized (this.zzpd)
    {
      paramString = (WeakReference)this.zzwV.get(paramString);
      if (paramString == null)
      {
        paramString = null;
        paramString = zze.zzy(paramString);
        return paramString;
      }
      paramString = (View)paramString.get();
    }
  }
  
  public void zza(String paramString, zzd paramzzd)
  {
    View localView = (View)zze.zzp(paramzzd);
    paramzzd = this.zzpd;
    if (localView == null) {}
    for (;;)
    {
      try
      {
        this.zzwV.remove(paramString);
        return;
      }
      finally {}
      this.zzwV.put(paramString, new WeakReference(localView));
      localView.setOnTouchListener(this);
      localView.setOnClickListener(this);
    }
  }
  
  public void zzb(final zzd paramzzd)
  {
    synchronized (this.zzpd)
    {
      this.zzwX = true;
      paramzzd = (zzh)zze.zzp(paramzzd);
      if (((this.zzwx instanceof zzg)) && (((zzg)this.zzwx).zzdB())) {
        ((zzg)this.zzwx).zzb(paramzzd);
      }
      do
      {
        this.zznZ.removeAllViews();
        this.zzwW = zzf(paramzzd);
        if (this.zzwW != null)
        {
          this.zzwV.put("1007", new WeakReference(this.zzwW.zzdu()));
          this.zznZ.addView(this.zzwW);
        }
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zziz localzziz = paramzzd.zzdC();
            if (localzziz != null) {
              zzj.zza(zzj.this).addView(localzziz.getView());
            }
          }
        });
        paramzzd.zzh(this.zzwU);
        return;
        this.zzwx = paramzzd;
      } while (!(this.zzwx instanceof zzg));
      ((zzg)this.zzwx).zzb(null);
    }
  }
  
  Point zzc(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    this.zzwU.getLocationOnScreen(arrayOfInt);
    float f1 = paramMotionEvent.getRawX();
    float f2 = arrayOfInt[0];
    float f3 = paramMotionEvent.getRawY();
    float f4 = arrayOfInt[1];
    return new Point((int)(f1 - f2), (int)(f3 - f4));
  }
  
  zzb zzf(zzh paramzzh)
  {
    return paramzzh.zza(this);
  }
  
  Point zzj(View paramView)
  {
    if ((this.zzwW != null) && (this.zzwW.zzdu().equals(paramView)))
    {
      localPoint1 = new Point();
      this.zzwU.getGlobalVisibleRect(new Rect(), localPoint1);
      Point localPoint2 = new Point();
      paramView.getGlobalVisibleRect(new Rect(), localPoint2);
      return new Point(localPoint2.x - localPoint1.x, localPoint2.y - localPoint1.y);
    }
    Point localPoint1 = new Point();
    paramView.getGlobalVisibleRect(new Rect(), localPoint1);
    return localPoint1;
  }
  
  int zzp(int paramInt)
  {
    return zzl.zzcF().zzc(this.zzwx.getContext(), paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */