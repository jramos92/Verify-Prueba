package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager zzaZr;
  private final Context mContext;
  private final DataLayer zzaVR;
  private final zzs zzaYl;
  private final zza zzaZo;
  private final zzct zzaZp;
  private final ConcurrentMap<zzo, Boolean> zzaZq;
  
  TagManager(Context paramContext, zza paramzza, DataLayer paramDataLayer, zzct paramzzct)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.zzaZp = paramzzct;
    this.zzaZo = paramzza;
    this.zzaZq = new ConcurrentHashMap();
    this.zzaVR = paramDataLayer;
    this.zzaVR.zza(new DataLayer.zzb()
    {
      public void zzJ(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          TagManager.zza(TagManager.this, paramAnonymousMap.toString());
        }
      }
    });
    this.zzaVR.zza(new zzd(this.mContext));
    this.zzaYl = new zzs();
    zzDL();
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (zzaZr != null) {
        break label68;
      }
      if (paramContext == null)
      {
        zzbg.e("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    zzaZr = new TagManager(paramContext, new zza()new DataLayernew zzw
    {
      public zzp zza(Context paramAnonymousContext, TagManager paramAnonymousTagManager, Looper paramAnonymousLooper, String paramAnonymousString, int paramAnonymousInt, zzs paramAnonymouszzs)
      {
        return new zzp(paramAnonymousContext, paramAnonymousTagManager, paramAnonymousLooper, paramAnonymousString, paramAnonymousInt, paramAnonymouszzs);
      }
    }, new DataLayer(new zzw(paramContext)), zzcu.zzDG());
    label68:
    paramContext = zzaZr;
    return paramContext;
  }
  
  private void zzDL()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.mContext.registerComponentCallbacks(new ComponentCallbacks2()
      {
        public void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
        
        public void onLowMemory() {}
        
        public void onTrimMemory(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 20) {
            TagManager.this.dispatch();
          }
        }
      });
    }
  }
  
  private void zzfa(String paramString)
  {
    Iterator localIterator = this.zzaZq.keySet().iterator();
    while (localIterator.hasNext()) {
      ((zzo)localIterator.next()).zzeC(paramString);
    }
  }
  
  public void dispatch()
  {
    this.zzaZp.dispatch();
  }
  
  public DataLayer getDataLayer()
  {
    return this.zzaVR;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt)
  {
    paramString = this.zzaZo.zza(this.mContext, this, null, paramString, paramInt, this.zzaYl);
    paramString.zzCy();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzaZo.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzaYl);
    paramString.zzCy();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    paramString = this.zzaZo.zza(this.mContext, this, null, paramString, paramInt, this.zzaYl);
    paramString.zzCA();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzaZo.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzaYl);
    paramString.zzCA();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    paramString = this.zzaZo.zza(this.mContext, this, null, paramString, paramInt, this.zzaYl);
    paramString.zzCz();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.zzaZo.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzaYl);
    paramString.zzCz();
    return paramString;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      zzbg.setLogLevel(i);
      return;
    }
  }
  
  void zza(zzo paramzzo)
  {
    this.zzaZq.put(paramzzo, Boolean.valueOf(true));
  }
  
  boolean zzb(zzo paramzzo)
  {
    return this.zzaZq.remove(paramzzo) != null;
  }
  
  boolean zzm(Uri paramUri)
  {
    for (;;)
    {
      boolean bool;
      Object localObject2;
      try
      {
        localObject1 = zzcb.zzDm();
        if (!((zzcb)localObject1).zzm(paramUri)) {
          break label229;
        }
        paramUri = ((zzcb)localObject1).getContainerId();
        int i = 4.zzaZt[localObject1.zzDn().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Object localObject1 = this.zzaZq.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzo)((Iterator)localObject1).next();
        if (((zzo)localObject2).getContainerId().equals(paramUri))
        {
          ((zzo)localObject2).zzeE(null);
          ((zzo)localObject2).refresh();
        }
      }
      else
      {
        continue;
        localObject2 = this.zzaZq.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          zzo localzzo = (zzo)((Iterator)localObject2).next();
          if (localzzo.getContainerId().equals(paramUri))
          {
            localzzo.zzeE(((zzcb)localObject1).zzDo());
            localzzo.refresh();
          }
          else if (localzzo.zzCv() != null)
          {
            localzzo.zzeE(null);
            localzzo.refresh();
          }
        }
        continue;
        label229:
        bool = false;
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract zzp zza(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzs paramzzs);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */