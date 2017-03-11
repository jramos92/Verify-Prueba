package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgr
public class zzfc
  extends zzfh
{
  static final Set<String> zzAb = new HashSet(Arrays.asList(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" }));
  private String zzAc = "top-right";
  private boolean zzAd = true;
  private int zzAe = 0;
  private int zzAf = 0;
  private int zzAg = 0;
  private int zzAh = 0;
  private final Activity zzAi;
  private ImageView zzAj;
  private LinearLayout zzAk;
  private zzfi zzAl;
  private PopupWindow zzAm;
  private RelativeLayout zzAn;
  private ViewGroup zzAo;
  private int zznQ = -1;
  private int zznR = -1;
  private final zziz zzoM;
  private final Object zzpd = new Object();
  private AdSizeParcel zzzm;
  
  public zzfc(zziz paramzziz, zzfi paramzzfi)
  {
    super(paramzziz, "resize");
    this.zzoM = paramzziz;
    this.zzAi = paramzziz.zzgZ();
    this.zzAl = paramzzfi;
  }
  
  private int[] zzee()
  {
    if (!zzeg()) {
      return null;
    }
    if (this.zzAd) {
      return new int[] { this.zzAe + this.zzAg, this.zzAf + this.zzAh };
    }
    int[] arrayOfInt1 = zzp.zzbv().zzh(this.zzAi);
    int[] arrayOfInt2 = zzp.zzbv().zzj(this.zzAi);
    int m = arrayOfInt1[0];
    int j = this.zzAe + this.zzAg;
    int k = this.zzAf + this.zzAh;
    int i;
    if (j < 0)
    {
      i = 0;
      if (k >= arrayOfInt2[0]) {
        break label149;
      }
      j = arrayOfInt2[0];
    }
    for (;;)
    {
      return new int[] { i, j };
      i = j;
      if (this.zznQ + j <= m) {
        break;
      }
      i = m - this.zznQ;
      break;
      label149:
      j = k;
      if (this.zznR + k > arrayOfInt2[1]) {
        j = arrayOfInt2[1] - this.zznR;
      }
    }
  }
  
  private void zzf(Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("width"))) {
      this.zznQ = zzp.zzbv().zzaA((String)paramMap.get("width"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("height"))) {
      this.zznR = zzp.zzbv().zzaA((String)paramMap.get("height"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetX"))) {
      this.zzAg = zzp.zzbv().zzaA((String)paramMap.get("offsetX"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetY"))) {
      this.zzAh = zzp.zzbv().zzaA((String)paramMap.get("offsetY"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("allowOffscreen"))) {
      this.zzAd = Boolean.parseBoolean((String)paramMap.get("allowOffscreen"));
    }
    paramMap = (String)paramMap.get("customClosePosition");
    if (!TextUtils.isEmpty(paramMap)) {
      this.zzAc = paramMap;
    }
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      this.zzAe = paramInt1;
      this.zzAf = paramInt2;
      if ((this.zzAm != null) && (paramBoolean))
      {
        int[] arrayOfInt = zzee();
        if (arrayOfInt != null)
        {
          this.zzAm.update(zzl.zzcF().zzb(this.zzAi, arrayOfInt[0]), zzl.zzcF().zzb(this.zzAi, arrayOfInt[1]), this.zzAm.getWidth(), this.zzAm.getHeight());
          zzc(arrayOfInt[0], arrayOfInt[1]);
        }
      }
      else
      {
        return;
      }
      zzn(true);
    }
  }
  
  void zzb(int paramInt1, int paramInt2)
  {
    if (this.zzAl != null) {
      this.zzAl.zza(paramInt1, paramInt2, this.zznQ, this.zznR);
    }
  }
  
  void zzc(int paramInt1, int paramInt2)
  {
    zzb(paramInt1, paramInt2 - zzp.zzbv().zzj(this.zzAi)[0], this.zznQ, this.zznR);
  }
  
  public void zzd(int paramInt1, int paramInt2)
  {
    this.zzAe = paramInt1;
    this.zzAf = paramInt2;
  }
  
  boolean zzed()
  {
    return (this.zznQ > -1) && (this.zznR > -1);
  }
  
  public boolean zzef()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzAm != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  boolean zzeg()
  {
    Object localObject = zzp.zzbv().zzh(this.zzAi);
    int[] arrayOfInt = zzp.zzbv().zzj(this.zzAi);
    int k = localObject[0];
    int i = localObject[1];
    if ((this.zznQ < 50) || (this.zznQ > k))
    {
      zzb.zzaH("Width is too small or too large.");
      return false;
    }
    if ((this.zznR < 50) || (this.zznR > i))
    {
      zzb.zzaH("Height is too small or too large.");
      return false;
    }
    if ((this.zznR == i) && (this.zznQ == k))
    {
      zzb.zzaH("Cannot resize to a full-screen ad.");
      return false;
    }
    label184:
    int j;
    if (this.zzAd)
    {
      localObject = this.zzAc;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          j = this.zzAe + this.zzAg + this.zznQ - 50;
          i = this.zzAf + this.zzAh;
        }
        break;
      }
    }
    while ((j >= 0) && (j + 50 <= k) && (i >= arrayOfInt[0]) && (i + 50 <= arrayOfInt[1]))
    {
      return true;
      if (!((String)localObject).equals("top-left")) {
        break label184;
      }
      i = 0;
      break label184;
      if (!((String)localObject).equals("top-center")) {
        break label184;
      }
      i = 1;
      break label184;
      if (!((String)localObject).equals("center")) {
        break label184;
      }
      i = 2;
      break label184;
      if (!((String)localObject).equals("bottom-left")) {
        break label184;
      }
      i = 3;
      break label184;
      if (!((String)localObject).equals("bottom-center")) {
        break label184;
      }
      i = 4;
      break label184;
      if (!((String)localObject).equals("bottom-right")) {
        break label184;
      }
      i = 5;
      break label184;
      i = this.zzAe;
      j = this.zzAg + i;
      i = this.zzAf + this.zzAh;
      continue;
      j = this.zzAe + this.zzAg + this.zznQ / 2 - 25;
      i = this.zzAf + this.zzAh;
      continue;
      j = this.zzAe + this.zzAg + this.zznQ / 2 - 25;
      i = this.zzAf + this.zzAh + this.zznR / 2 - 25;
      continue;
      i = this.zzAe;
      j = this.zzAg + i;
      i = this.zzAf + this.zzAh + this.zznR - 50;
      continue;
      j = this.zzAe + this.zzAg + this.zznQ / 2 - 25;
      i = this.zzAf + this.zzAh + this.zznR - 50;
      continue;
      j = this.zzAe + this.zzAg + this.zznQ - 50;
      i = this.zzAf + this.zzAh + this.zznR - 50;
    }
  }
  
  public void zzg(Map<String, String> paramMap)
  {
    synchronized (this.zzpd)
    {
      if (this.zzAi == null)
      {
        zzak("Not an activity context. Cannot resize.");
        return;
      }
      if (this.zzoM.zzaN() == null)
      {
        zzak("Webview is not yet available, size is not set.");
        return;
      }
    }
    if (this.zzoM.zzaN().zztf)
    {
      zzak("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (this.zzoM.zzhi())
    {
      zzak("Cannot resize an expanded banner.");
      return;
    }
    zzf(paramMap);
    if (!zzed())
    {
      zzak("Invalid width and height options. Cannot resize.");
      return;
    }
    paramMap = this.zzAi.getWindow();
    if ((paramMap == null) || (paramMap.getDecorView() == null))
    {
      zzak("Activity context is not ready, cannot get window or decor view.");
      return;
    }
    int[] arrayOfInt = zzee();
    if (arrayOfInt == null)
    {
      zzak("Resize location out of screen or close button is not visible.");
      return;
    }
    int i = zzl.zzcF().zzb(this.zzAi, this.zznQ);
    int j = zzl.zzcF().zzb(this.zzAi, this.zznR);
    Object localObject2 = this.zzoM.getView().getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup)))
    {
      ((ViewGroup)localObject2).removeView(this.zzoM.getView());
      if (this.zzAm == null)
      {
        this.zzAo = ((ViewGroup)localObject2);
        localObject2 = zzp.zzbv().zzk(this.zzoM.getView());
        this.zzAj = new ImageView(this.zzAi);
        this.zzAj.setImageBitmap((Bitmap)localObject2);
        this.zzzm = this.zzoM.zzaN();
        this.zzAo.addView(this.zzAj);
        this.zzAn = new RelativeLayout(this.zzAi);
        this.zzAn.setBackgroundColor(0);
        this.zzAn.setLayoutParams(new ViewGroup.LayoutParams(i, j));
        this.zzAm = zzp.zzbv().zza(this.zzAn, i, j, false);
        this.zzAm.setOutsideTouchable(true);
        this.zzAm.setTouchable(true);
        localObject2 = this.zzAm;
        if (this.zzAd) {
          break label1071;
        }
      }
    }
    label1023:
    label1027:
    label1029:
    label1071:
    for (boolean bool = true;; bool = false)
    {
      ((PopupWindow)localObject2).setClippingEnabled(bool);
      this.zzAn.addView(this.zzoM.getView(), -1, -1);
      this.zzAk = new LinearLayout(this.zzAi);
      localObject2 = new RelativeLayout.LayoutParams(zzl.zzcF().zzb(this.zzAi, 50), zzl.zzcF().zzb(this.zzAi, 50));
      String str = this.zzAc;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        for (;;)
        {
          this.zzAk.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              zzfc.this.zzn(true);
            }
          });
          this.zzAk.setContentDescription("Close button");
          this.zzAn.addView(this.zzAk, (ViewGroup.LayoutParams)localObject2);
          try
          {
            this.zzAm.showAtLocation(paramMap.getDecorView(), 0, zzl.zzcF().zzb(this.zzAi, arrayOfInt[0]), zzl.zzcF().zzb(this.zzAi, arrayOfInt[1]));
            zzb(arrayOfInt[0], arrayOfInt[1]);
            this.zzoM.zza(new AdSizeParcel(this.zzAi, new AdSize(this.zznQ, this.zznR)));
            zzc(arrayOfInt[0], arrayOfInt[1]);
            zzam("resized");
            return;
          }
          catch (RuntimeException paramMap)
          {
            zzak("Cannot show popup window: " + paramMap.getMessage());
            this.zzAn.removeView(this.zzoM.getView());
            if (this.zzAo == null) {
              break label1023;
            }
            this.zzAo.removeView(this.zzAj);
            this.zzAo.addView(this.zzoM.getView());
            this.zzoM.zza(this.zzzm);
            return;
          }
          this.zzAm.dismiss();
          break;
          zzak("Webview is detached, probably in the middle of a resize or expand.");
          return;
          if (!str.equals("top-left")) {
            break label1027;
          }
          i = 0;
          break label1029;
          if (!str.equals("top-center")) {
            break label1027;
          }
          i = 1;
          break label1029;
          if (!str.equals("center")) {
            break label1027;
          }
          i = 2;
          break label1029;
          if (!str.equals("bottom-left")) {
            break label1027;
          }
          i = 3;
          break label1029;
          if (!str.equals("bottom-center")) {
            break label1027;
          }
          i = 4;
          break label1029;
          if (!str.equals("bottom-right")) {
            break label1027;
          }
          i = 5;
          break label1029;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(13);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        }
        i = -1;
        switch (i)
        {
        }
      }
    }
  }
  
  public void zzn(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      if (this.zzAm != null)
      {
        this.zzAm.dismiss();
        this.zzAn.removeView(this.zzoM.getView());
        if (this.zzAo != null)
        {
          this.zzAo.removeView(this.zzAj);
          this.zzAo.addView(this.zzoM.getView());
          this.zzoM.zza(this.zzzm);
        }
        if (paramBoolean)
        {
          zzam("default");
          if (this.zzAl != null) {
            this.zzAl.zzbc();
          }
        }
        this.zzAm = null;
        this.zzAn = null;
        this.zzAo = null;
        this.zzAk = null;
      }
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */