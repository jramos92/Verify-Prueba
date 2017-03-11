package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzmi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@zzgr
public final class zzq
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  public final Context context;
  boolean zzpt = false;
  zzmi<String, zzcz> zzqA;
  NativeAdOptionsParcel zzqB;
  zzck zzqC;
  List<String> zzqD;
  zzk zzqE;
  public zzhx zzqF = null;
  View zzqG = null;
  public int zzqH = 0;
  boolean zzqI = false;
  private HashSet<zzht> zzqJ = null;
  private int zzqK = -1;
  private int zzqL = -1;
  private zzik zzqM;
  private boolean zzqN = true;
  private boolean zzqO = true;
  private boolean zzqP = false;
  final String zzqg;
  public String zzqh;
  final zzan zzqi;
  public final VersionInfoParcel zzqj;
  zza zzqk;
  public zzhz zzql;
  public zzgh zzqm;
  public AdSizeParcel zzqn;
  public zzhs zzqo;
  public zzhs.zza zzqp;
  public zzht zzqq;
  zzn zzqr;
  zzo zzqs;
  zzu zzqt;
  zzv zzqu;
  zzfs zzqv;
  zzfw zzqw;
  zzcw zzqx;
  zzcx zzqy;
  zzmi<String, zzcy> zzqz;
  
  public zzq(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel)
  {
    this(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel, null);
  }
  
  zzq(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel, zzan paramzzan)
  {
    zzby.initialize(paramContext);
    if (zzp.zzby().zzgo() != null)
    {
      List localList = zzby.zzdf();
      if (paramVersionInfoParcel.zzJv != 0) {
        localList.add(Integer.toString(paramVersionInfoParcel.zzJv));
      }
      zzp.zzby().zzgo().zzb(localList);
    }
    this.zzqg = UUID.randomUUID().toString();
    if ((paramAdSizeParcel.zztf) || (paramAdSizeParcel.zzth))
    {
      this.zzqk = null;
      this.zzqn = paramAdSizeParcel;
      this.zzqh = paramString;
      this.context = paramContext;
      this.zzqj = paramVersionInfoParcel;
      if (paramzzan == null) {
        break label246;
      }
    }
    for (;;)
    {
      this.zzqi = paramzzan;
      this.zzqM = new zzik(200L);
      this.zzqA = new zzmi();
      return;
      this.zzqk = new zza(paramContext, this, this);
      this.zzqk.setMinimumWidth(paramAdSizeParcel.widthPixels);
      this.zzqk.setMinimumHeight(paramAdSizeParcel.heightPixels);
      this.zzqk.setVisibility(4);
      break;
      label246:
      paramzzan = new zzan(new zzh(this));
    }
  }
  
  private void zzbQ()
  {
    View localView = this.zzqk.getRootView().findViewById(16908290);
    if (localView == null) {}
    Rect localRect1;
    Rect localRect2;
    do
    {
      return;
      localRect1 = new Rect();
      localRect2 = new Rect();
      this.zzqk.getGlobalVisibleRect(localRect1);
      localView.getGlobalVisibleRect(localRect2);
      if (localRect1.top != localRect2.top) {
        this.zzqN = false;
      }
    } while (localRect1.bottom == localRect2.bottom);
    this.zzqO = false;
  }
  
  private void zze(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.zzqk == null) || (this.zzqo == null) || (this.zzqo.zzBD == null)) {}
    while ((paramBoolean) && (!this.zzqM.tryAcquire())) {
      return;
    }
    Object localObject;
    int i;
    int j;
    if (this.zzqo.zzBD.zzhe().zzbY())
    {
      localObject = new int[2];
      this.zzqk.getLocationOnScreen((int[])localObject);
      i = zzl.zzcF().zzc(this.context, localObject[0]);
      j = zzl.zzcF().zzc(this.context, localObject[1]);
      if ((i != this.zzqK) || (j != this.zzqL))
      {
        this.zzqK = i;
        this.zzqL = j;
        localObject = this.zzqo.zzBD.zzhe();
        i = this.zzqK;
        j = this.zzqL;
        if (paramBoolean) {
          break label174;
        }
      }
    }
    label174:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((zzja)localObject).zza(i, j, paramBoolean);
      zzbQ();
      return;
    }
  }
  
  public void destroy()
  {
    zzbP();
    this.zzqs = null;
    this.zzqt = null;
    this.zzqw = null;
    this.zzqv = null;
    this.zzqC = null;
    this.zzqu = null;
    zzf(false);
    if (this.zzqk != null) {
      this.zzqk.removeAllViews();
    }
    zzbK();
    zzbM();
    this.zzqo = null;
  }
  
  public void onGlobalLayout()
  {
    zze(false);
  }
  
  public void onScrollChanged()
  {
    zze(true);
    this.zzqP = true;
  }
  
  public void zza(HashSet<zzht> paramHashSet)
  {
    this.zzqJ = paramHashSet;
  }
  
  public HashSet<zzht> zzbJ()
  {
    return this.zzqJ;
  }
  
  public void zzbK()
  {
    if ((this.zzqo != null) && (this.zzqo.zzBD != null)) {
      this.zzqo.zzBD.destroy();
    }
  }
  
  public void zzbL()
  {
    if ((this.zzqo != null) && (this.zzqo.zzBD != null)) {
      this.zzqo.zzBD.stopLoading();
    }
  }
  
  public void zzbM()
  {
    if ((this.zzqo != null) && (this.zzqo.zzzv != null)) {}
    try
    {
      this.zzqo.zzzv.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzaH("Could not destroy mediation adapter.");
    }
  }
  
  public boolean zzbN()
  {
    return this.zzqH == 0;
  }
  
  public boolean zzbO()
  {
    return this.zzqH == 1;
  }
  
  public void zzbP()
  {
    if (this.zzqk != null) {
      this.zzqk.zzbP();
    }
  }
  
  public String zzbR()
  {
    if ((this.zzqN) && (this.zzqO)) {
      return "";
    }
    if (this.zzqN)
    {
      if (this.zzqP) {
        return "top-scrollable";
      }
      return "top-locked";
    }
    if (this.zzqO)
    {
      if (this.zzqP) {
        return "bottom-scrollable";
      }
      return "bottom-locked";
    }
    return "";
  }
  
  public void zzbS()
  {
    this.zzqq.zzl(this.zzqo.zzHz);
    this.zzqq.zzm(this.zzqo.zzHA);
    this.zzqq.zzy(this.zzqn.zztf);
    this.zzqq.zzz(this.zzqo.zzEK);
  }
  
  public void zzf(boolean paramBoolean)
  {
    if (this.zzqH == 0) {
      zzbL();
    }
    if (this.zzql != null) {
      this.zzql.cancel();
    }
    if (this.zzqm != null) {
      this.zzqm.cancel();
    }
    if (paramBoolean) {
      this.zzqo = null;
    }
  }
  
  public static class zza
    extends ViewSwitcher
  {
    private final zzif zzqQ;
    private final zzim zzqR;
    
    public zza(Context paramContext, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
    {
      super();
      this.zzqQ = new zzif(paramContext);
      if ((paramContext instanceof Activity))
      {
        this.zzqR = new zzim((Activity)paramContext, paramOnGlobalLayoutListener, paramOnScrollChangedListener);
        this.zzqR.zzgO();
        return;
      }
      this.zzqR = null;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (this.zzqR != null) {
        this.zzqR.onAttachedToWindow();
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (this.zzqR != null) {
        this.zzqR.onDetachedFromWindow();
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.zzqQ.zze(paramMotionEvent);
      return false;
    }
    
    public void removeAllViews()
    {
      Object localObject = new ArrayList();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView != null) && ((localView instanceof zziz))) {
          ((List)localObject).add((zziz)localView);
        }
        i += 1;
      }
      super.removeAllViews();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zziz)((Iterator)localObject).next()).destroy();
      }
    }
    
    public void zzbP()
    {
      zzb.v("Disable position monitoring on adFrame.");
      if (this.zzqR != null) {
        this.zzqR.zzgP();
      }
    }
    
    public zzif zzbT()
    {
      return this.zzqQ;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */