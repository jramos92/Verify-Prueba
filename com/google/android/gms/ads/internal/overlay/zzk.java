package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;
import java.util.HashMap;

@zzgr
public class zzk
  extends FrameLayout
  implements zzh
{
  private final FrameLayout zzBN;
  private final zzq zzBO;
  private zzi zzBP;
  private boolean zzBQ;
  private boolean zzBR;
  private TextView zzBS;
  private long zzBT;
  private long zzBU;
  private String zzBV;
  private final zziz zzoM;
  private String zzxZ;
  
  public zzk(Context paramContext, zziz paramzziz, int paramInt, zzcg paramzzcg, zzce paramzzce)
  {
    super(paramContext);
    this.zzoM = paramzziz;
    this.zzBN = new FrameLayout(paramContext);
    addView(this.zzBN, new FrameLayout.LayoutParams(-1, -1));
    zzb.zzs(paramzziz.zzhb());
    this.zzBP = paramzziz.zzhb().zzoH.zza(paramContext, paramzziz, paramInt, paramzzcg, paramzzce);
    if (this.zzBP != null) {
      this.zzBN.addView(this.zzBP, new FrameLayout.LayoutParams(-1, -1, 17));
    }
    this.zzBS = new TextView(paramContext);
    this.zzBS.setBackgroundColor(-16777216);
    zzeY();
    this.zzBO = new zzq(this);
    this.zzBO.zzfg();
    if (this.zzBP != null) {
      this.zzBP.zza(this);
    }
    if (this.zzBP == null) {
      zzh("AdVideoUnderlay Error", "Allocating player failed.");
    }
  }
  
  private void zza(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int j = paramVarArgs.length;
    int i = 0;
    paramString = null;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (paramString == null) {}
      for (paramString = str;; paramString = null)
      {
        i += 1;
        break;
        localHashMap.put(paramString, str);
      }
    }
    this.zzoM.zzb("onVideoEvent", localHashMap);
  }
  
  public static void zzd(zziz paramzziz)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "no_video_view");
    paramzziz.zzb("onVideoEvent", localHashMap);
  }
  
  private void zzeY()
  {
    if (!zzfa())
    {
      this.zzBN.addView(this.zzBS, new FrameLayout.LayoutParams(-1, -1));
      this.zzBN.bringChildToFront(this.zzBS);
    }
  }
  
  private void zzeZ()
  {
    if (zzfa()) {
      this.zzBN.removeView(this.zzBS);
    }
  }
  
  private boolean zzfa()
  {
    return this.zzBS.getParent() != null;
  }
  
  private void zzfb()
  {
    if (this.zzoM.zzgZ() == null) {
      break label12;
    }
    label12:
    while (this.zzBQ) {
      return;
    }
    if ((this.zzoM.zzgZ().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzBR = bool;
      if (this.zzBR) {
        break;
      }
      this.zzoM.zzgZ().getWindow().addFlags(128);
      this.zzBQ = true;
      return;
    }
  }
  
  private void zzfc()
  {
    if (this.zzoM.zzgZ() == null) {}
    while ((!this.zzBQ) || (this.zzBR)) {
      return;
    }
    this.zzoM.zzgZ().getWindow().clearFlags(128);
    this.zzBQ = false;
  }
  
  public void destroy()
  {
    this.zzBO.cancel();
    if (this.zzBP != null) {
      this.zzBP.stop();
    }
    zzfc();
  }
  
  public void onPaused()
  {
    zza("pause", new String[0]);
    zzfc();
  }
  
  public void pause()
  {
    if (this.zzBP == null) {
      return;
    }
    this.zzBP.pause();
  }
  
  public void play()
  {
    if (this.zzBP == null) {
      return;
    }
    this.zzBP.play();
  }
  
  public void seekTo(int paramInt)
  {
    if (this.zzBP == null) {
      return;
    }
    this.zzBP.seekTo(paramInt);
  }
  
  public void setMimeType(String paramString)
  {
    this.zzBV = paramString;
  }
  
  public void zza(float paramFloat)
  {
    if (this.zzBP == null) {
      return;
    }
    this.zzBP.zza(paramFloat);
  }
  
  public void zzan(String paramString)
  {
    this.zzxZ = paramString;
  }
  
  public void zzd(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3 + 2, paramInt4 + 2);
    localLayoutParams.setMargins(paramInt1 - 1, paramInt2 - 1, 0, 0);
    this.zzBN.setLayoutParams(localLayoutParams);
    requestLayout();
  }
  
  public void zzd(MotionEvent paramMotionEvent)
  {
    if (this.zzBP == null) {
      return;
    }
    this.zzBP.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void zzeQ() {}
  
  public void zzeR()
  {
    if (this.zzBP == null) {}
    while (this.zzBU != 0L) {
      return;
    }
    zza("canplaythrough", new String[] { "duration", String.valueOf(this.zzBP.getDuration() / 1000.0F), "videoWidth", String.valueOf(this.zzBP.getVideoWidth()), "videoHeight", String.valueOf(this.zzBP.getVideoHeight()) });
  }
  
  public void zzeS()
  {
    zzfb();
  }
  
  public void zzeT()
  {
    zza("ended", new String[0]);
    zzfc();
  }
  
  public void zzeU()
  {
    zzeY();
    this.zzBU = this.zzBT;
  }
  
  public void zzeV()
  {
    if (this.zzBP == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.zzxZ))
    {
      this.zzBP.setMimeType(this.zzBV);
      this.zzBP.setVideoPath(this.zzxZ);
      return;
    }
    zza("no_src", new String[0]);
  }
  
  public void zzeW()
  {
    if (this.zzBP == null) {
      return;
    }
    TextView localTextView = new TextView(this.zzBP.getContext());
    localTextView.setText("AdMob - " + this.zzBP.zzer());
    localTextView.setTextColor(-65536);
    localTextView.setBackgroundColor(65280);
    this.zzBN.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
    this.zzBN.bringChildToFront(localTextView);
  }
  
  void zzeX()
  {
    if (this.zzBP == null) {}
    long l;
    do
    {
      return;
      l = this.zzBP.getCurrentPosition();
    } while ((this.zzBT == l) || (l <= 0L));
    zzeZ();
    zza("timeupdate", new String[] { "time", String.valueOf((float)l / 1000.0F) });
    this.zzBT = l;
  }
  
  public void zzex()
  {
    if (this.zzBP == null) {
      return;
    }
    this.zzBP.zzex();
  }
  
  public void zzey()
  {
    if (this.zzBP == null) {
      return;
    }
    this.zzBP.zzey();
  }
  
  public void zzh(String paramString1, String paramString2)
  {
    zza("error", new String[] { "what", paramString1, "extra", paramString2 });
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */