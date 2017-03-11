package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzbk
  extends Thread
{
  private boolean mStarted = false;
  private boolean zzam = false;
  private final Object zzpd;
  private final int zzrN;
  private final int zzrP;
  private boolean zzrZ = false;
  private final zzbj zzsa;
  private final zzbi zzsb;
  private final zzgq zzsc;
  private final int zzsd;
  private final int zzse;
  private final int zzsf;
  
  public zzbk(zzbj paramzzbj, zzbi paramzzbi, zzgq paramzzgq)
  {
    this.zzsa = paramzzbj;
    this.zzsb = paramzzbi;
    this.zzsc = paramzzgq;
    this.zzpd = new Object();
    this.zzrN = ((Integer)zzby.zzuU.get()).intValue();
    this.zzse = ((Integer)zzby.zzuV.get()).intValue();
    this.zzrP = ((Integer)zzby.zzuW.get()).intValue();
    this.zzsf = ((Integer)zzby.zzuX.get()).intValue();
    this.zzsd = ((Integer)zzby.zzuY.get()).intValue();
    setName("ContentFetchTask");
  }
  
  public void run()
  {
    while (!this.zzam) {
      try
      {
        if (zzcu())
        {
          Activity localActivity = this.zzsa.getActivity();
          if (localActivity == null) {
            zzb.zzaF("ContentFetchThread: no activity");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        zzb.zzb("Error in ContentFetchTask", localThrowable);
        this.zzsc.zza(localThrowable, true);
        synchronized (this.zzpd)
        {
          for (;;)
          {
            boolean bool = this.zzrZ;
            if (!bool) {
              break;
            }
            try
            {
              zzb.zzaF("ContentFetchTask: waiting");
              this.zzpd.wait();
            }
            catch (InterruptedException localInterruptedException) {}
          }
          zza((Activity)???);
          for (;;)
          {
            Thread.sleep(this.zzsd * 1000);
            break;
            zzb.zzaF("ContentFetchTask: sleeping");
            zzcw();
          }
        }
      }
    }
  }
  
  public void wakeup()
  {
    synchronized (this.zzpd)
    {
      this.zzrZ = false;
      this.zzpd.notifyAll();
      zzb.zzaF("ContentFetchThread: wakeup");
      return;
    }
  }
  
  zza zza(View paramView, zzbh paramzzbh)
  {
    int i = 0;
    if (paramView == null) {
      return new zza(0, 0);
    }
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      paramView = ((TextView)paramView).getText();
      if (!TextUtils.isEmpty(paramView))
      {
        paramzzbh.zzw(paramView.toString());
        return new zza(1, 0);
      }
      return new zza(0, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof zziz)))
    {
      paramzzbh.zzcp();
      if (zza((WebView)paramView, paramzzbh)) {
        return new zza(0, 1);
      }
      return new zza(0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = 0;
      int k = 0;
      while (i < paramView.getChildCount())
      {
        zza localzza = zza(paramView.getChildAt(i), paramzzbh);
        k += localzza.zzsm;
        j += localzza.zzsn;
        i += 1;
      }
      return new zza(k, j);
    }
    return new zza(0, 0);
  }
  
  void zza(Activity paramActivity)
  {
    if (paramActivity == null) {}
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramActivity.getWindow() != null)
      {
        localObject1 = localObject2;
        if (paramActivity.getWindow().getDecorView() != null) {
          localObject1 = paramActivity.getWindow().getDecorView().findViewById(16908290);
        }
      }
    } while (localObject1 == null);
    zzf((View)localObject1);
  }
  
  void zza(zzbh paramzzbh, WebView paramWebView, String paramString)
  {
    paramzzbh.zzco();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString).optString("text");
        if (TextUtils.isEmpty(paramWebView.getTitle())) {
          break label83;
        }
        paramzzbh.zzv(paramWebView.getTitle() + "\n" + paramString);
      }
      while (paramzzbh.zzcl())
      {
        this.zzsb.zzb(paramzzbh);
        return;
        label83:
        paramzzbh.zzv(paramString);
      }
      return;
    }
    catch (JSONException paramzzbh)
    {
      zzb.zzaF("Json string may be malformed.");
      return;
    }
    catch (Throwable paramzzbh)
    {
      zzb.zza("Failed to get webview content.", paramzzbh);
      this.zzsc.zza(paramzzbh, true);
    }
  }
  
  boolean zza(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    return paramRunningAppProcessInfo.importance == 100;
  }
  
  boolean zza(final WebView paramWebView, final zzbh paramzzbh)
  {
    if (!zzmx.zzqB()) {
      return false;
    }
    paramzzbh.zzcp();
    paramWebView.post(new Runnable()
    {
      ValueCallback<String> zzsi = new ValueCallback()
      {
        public void zzy(String paramAnonymous2String)
        {
          zzbk.this.zza(zzbk.2.this.zzsj, zzbk.2.this.zzsk, paramAnonymous2String);
        }
      };
      
      public void run()
      {
        if (paramWebView.getSettings().getJavaScriptEnabled()) {}
        try
        {
          paramWebView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzsi);
          return;
        }
        catch (Throwable localThrowable)
        {
          this.zzsi.onReceiveValue("");
        }
      }
    });
    return true;
  }
  
  public void zzct()
  {
    synchronized (this.zzpd)
    {
      if (this.mStarted)
      {
        zzb.zzaF("Content hash thread already started, quiting...");
        return;
      }
      this.mStarted = true;
      start();
      return;
    }
  }
  
  boolean zzcu()
  {
    try
    {
      Context localContext = this.zzsa.getContext();
      if (localContext == null) {
        return false;
      }
      Object localObject = (ActivityManager)localContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
      if ((localObject != null) && (localKeyguardManager != null))
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if (localObject == null) {
          return false;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (Process.myPid() == localRunningAppProcessInfo.pid) {
            if ((zza(localRunningAppProcessInfo)) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = zzr(localContext);
              if (bool) {
                return true;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }
  
  public zzbh zzcv()
  {
    return this.zzsb.zzcs();
  }
  
  public void zzcw()
  {
    synchronized (this.zzpd)
    {
      this.zzrZ = true;
      zzb.zzaF("ContentFetchThread: paused, mPause = " + this.zzrZ);
      return;
    }
  }
  
  public boolean zzcx()
  {
    return this.zzrZ;
  }
  
  boolean zzf(final View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView.post(new Runnable()
    {
      public void run()
      {
        zzbk.this.zzg(paramView);
      }
    });
    return true;
  }
  
  void zzg(View paramView)
  {
    try
    {
      zzbh localzzbh = new zzbh(this.zzrN, this.zzse, this.zzrP, this.zzsf);
      paramView = zza(paramView, localzzbh);
      localzzbh.zzcq();
      if ((paramView.zzsm == 0) && (paramView.zzsn == 0)) {
        return;
      }
      if (((paramView.zzsn != 0) || (localzzbh.zzcr() != 0)) && ((paramView.zzsn != 0) || (!this.zzsb.zza(localzzbh))))
      {
        this.zzsb.zzc(localzzbh);
        return;
      }
    }
    catch (Exception paramView)
    {
      zzb.zzb("Exception in fetchContentOnUIThread", paramView);
      this.zzsc.zza(paramView, true);
    }
  }
  
  boolean zzr(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (paramContext == null) {
      return false;
    }
    return paramContext.isScreenOn();
  }
  
  @zzgr
  class zza
  {
    final int zzsm;
    final int zzsn;
    
    zza(int paramInt1, int paramInt2)
    {
      this.zzsm = paramInt1;
      this.zzsn = paramInt2;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */