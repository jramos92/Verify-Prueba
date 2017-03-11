package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zzb;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.NodeApi.zza;
import com.google.android.gms.wearable.zza.zza;
import com.google.android.gms.wearable.zzc.zza;
import java.util.List;

final class zzbp<T>
  extends zzaw.zza
{
  private zzlm<MessageApi.MessageListener> zzaPA;
  private final String zzbfS;
  private final IntentFilter[] zzbgT;
  private zzlm<zza.zza> zzbhq;
  private zzlm<zzc.zza> zzbhr;
  private zzlm<DataApi.DataListener> zzbhs;
  private zzlm<NodeApi.NodeListener> zzbht;
  private zzlm<NodeApi.zza> zzbhu;
  private zzlm<ChannelApi.ChannelListener> zzbhv;
  private zzlm<CapabilityApi.CapabilityListener> zzbhw;
  private final String zzbhx;
  
  private zzbp(IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    this.zzbgT = paramArrayOfIntentFilter;
    this.zzbhx = paramString1;
    this.zzbfS = paramString2;
  }
  
  private static zzlm.zzb<NodeApi.zza> zzD(List<NodeParcelable> paramList)
  {
    new zzlm.zzb()
    {
      public void zza(NodeApi.zza paramAnonymouszza)
      {
        paramAnonymouszza.onConnectedNodes(this.zzbfs);
      }
      
      public void zznN() {}
    };
  }
  
  public static zzbp<DataApi.DataListener> zza(zzlm<DataApi.DataListener> paramzzlm, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzbp(paramArrayOfIntentFilter, null, null);
    paramArrayOfIntentFilter.zzbhs = ((zzlm)zzx.zzw(paramzzlm));
    return paramArrayOfIntentFilter;
  }
  
  private static zzlm.zzb<DataApi.DataListener> zzah(DataHolder paramDataHolder)
  {
    new zzlm.zzb()
    {
      public void zza(DataApi.DataListener paramAnonymousDataListener)
      {
        try
        {
          paramAnonymousDataListener.onDataChanged(new DataEventBuffer(this.zzbfo));
          return;
        }
        finally
        {
          this.zzbfo.close();
        }
      }
      
      public void zznN()
      {
        this.zzbfo.close();
      }
    };
  }
  
  private static zzlm.zzb<zza.zza> zzb(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
  {
    new zzlm.zzb()
    {
      public void zza(zza.zza paramAnonymouszza)
      {
        paramAnonymouszza.zza(this.zzbfw);
      }
      
      public void zznN() {}
    };
  }
  
  private static zzlm.zzb<zzc.zza> zzb(AncsNotificationParcelable paramAncsNotificationParcelable)
  {
    new zzlm.zzb()
    {
      public void zza(zzc.zza paramAnonymouszza)
      {
        paramAnonymouszza.zza(this.zzbfv);
      }
      
      public void zznN() {}
    };
  }
  
  private static zzlm.zzb<CapabilityApi.CapabilityListener> zzb(CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    new zzlm.zzb()
    {
      public void zza(CapabilityApi.CapabilityListener paramAnonymousCapabilityListener)
      {
        paramAnonymousCapabilityListener.onCapabilityChanged(this.zzbhy);
      }
      
      public void zznN() {}
    };
  }
  
  private static zzlm.zzb<ChannelApi.ChannelListener> zzb(ChannelEventParcelable paramChannelEventParcelable)
  {
    new zzlm.zzb()
    {
      public void zzb(ChannelApi.ChannelListener paramAnonymousChannelListener)
      {
        this.zzbfx.zza(paramAnonymousChannelListener);
      }
      
      public void zznN() {}
    };
  }
  
  private static zzlm.zzb<MessageApi.MessageListener> zzb(MessageEventParcelable paramMessageEventParcelable)
  {
    new zzlm.zzb()
    {
      public void zza(MessageApi.MessageListener paramAnonymousMessageListener)
      {
        paramAnonymousMessageListener.onMessageReceived(this.zzbfq);
      }
      
      public void zznN() {}
    };
  }
  
  public static zzbp<ChannelApi.ChannelListener> zzb(zzlm<ChannelApi.ChannelListener> paramzzlm, String paramString)
  {
    paramString = new zzbp(null, (String)zzx.zzw(paramString), null);
    paramString.zzbhv = ((zzlm)zzx.zzw(paramzzlm));
    return paramString;
  }
  
  public static zzbp<MessageApi.MessageListener> zzb(zzlm<MessageApi.MessageListener> paramzzlm, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzbp(paramArrayOfIntentFilter, null, null);
    paramArrayOfIntentFilter.zzaPA = ((zzlm)zzx.zzw(paramzzlm));
    return paramArrayOfIntentFilter;
  }
  
  private static zzlm.zzb<NodeApi.NodeListener> zzc(NodeParcelable paramNodeParcelable)
  {
    new zzlm.zzb()
    {
      public void zza(NodeApi.NodeListener paramAnonymousNodeListener)
      {
        paramAnonymousNodeListener.onPeerConnected(this.zzbfr);
      }
      
      public void zznN() {}
    };
  }
  
  public static zzbp<CapabilityApi.CapabilityListener> zzc(zzlm<CapabilityApi.CapabilityListener> paramzzlm, String paramString)
  {
    paramString = new zzbp(null, null, paramString);
    paramString.zzbhw = ((zzlm)zzx.zzw(paramzzlm));
    return paramString;
  }
  
  private static zzlm.zzb<NodeApi.NodeListener> zzd(NodeParcelable paramNodeParcelable)
  {
    new zzlm.zzb()
    {
      public void zza(NodeApi.NodeListener paramAnonymousNodeListener)
      {
        paramAnonymousNodeListener.onPeerDisconnected(this.zzbfr);
      }
      
      public void zznN() {}
    };
  }
  
  public static zzbp<zza.zza> zze(zzlm<zza.zza> paramzzlm)
  {
    zzbp localzzbp = new zzbp(null, null, null);
    localzzbp.zzbhq = ((zzlm)zzx.zzw(paramzzlm));
    return localzzbp;
  }
  
  public static zzbp<zzc.zza> zzf(zzlm<zzc.zza> paramzzlm)
  {
    zzbp localzzbp = new zzbp(null, null, null);
    localzzbp.zzbhr = ((zzlm)zzx.zzw(paramzzlm));
    return localzzbp;
  }
  
  public static zzbp<NodeApi.NodeListener> zzg(zzlm<NodeApi.NodeListener> paramzzlm)
  {
    zzbp localzzbp = new zzbp(null, null, null);
    localzzbp.zzbht = ((zzlm)zzx.zzw(paramzzlm));
    return localzzbp;
  }
  
  public static zzbp<NodeApi.zza> zzh(zzlm<NodeApi.zza> paramzzlm)
  {
    zzbp localzzbp = new zzbp(null, null, null);
    localzzbp.zzbhu = ((zzlm)zzx.zzw(paramzzlm));
    return localzzbp;
  }
  
  public static zzbp<ChannelApi.ChannelListener> zzi(zzlm<ChannelApi.ChannelListener> paramzzlm)
  {
    zzbp localzzbp = new zzbp(null, null, null);
    localzzbp.zzbhv = ((zzlm)zzx.zzw(paramzzlm));
    return localzzbp;
  }
  
  private static void zzj(zzlm<?> paramzzlm)
  {
    if (paramzzlm != null) {
      paramzzlm.clear();
    }
  }
  
  public void clear()
  {
    zzj(this.zzbhq);
    this.zzbhq = null;
    zzj(this.zzbhr);
    this.zzbhr = null;
    zzj(this.zzbhs);
    this.zzbhs = null;
    zzj(this.zzaPA);
    this.zzaPA = null;
    zzj(this.zzbht);
    this.zzbht = null;
    zzj(this.zzbhu);
    this.zzbhu = null;
    zzj(this.zzbhv);
    this.zzbhv = null;
    zzj(this.zzbhw);
    this.zzbhw = null;
  }
  
  public void onConnectedNodes(List<NodeParcelable> paramList)
  {
    if (this.zzbhu != null) {
      this.zzbhu.zza(zzD(paramList));
    }
  }
  
  public IntentFilter[] zzFe()
  {
    return this.zzbgT;
  }
  
  public String zzFf()
  {
    return this.zzbhx;
  }
  
  public String zzFg()
  {
    return this.zzbfS;
  }
  
  public void zza(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
  {
    if (this.zzbhq != null) {
      this.zzbhq.zza(zzb(paramAmsEntityUpdateParcelable));
    }
  }
  
  public void zza(AncsNotificationParcelable paramAncsNotificationParcelable)
  {
    if (this.zzbhr != null) {
      this.zzbhr.zza(zzb(paramAncsNotificationParcelable));
    }
  }
  
  public void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    if (this.zzbhw != null) {
      this.zzbhw.zza(zzb(paramCapabilityInfoParcelable));
    }
  }
  
  public void zza(ChannelEventParcelable paramChannelEventParcelable)
  {
    if (this.zzbhv != null) {
      this.zzbhv.zza(zzb(paramChannelEventParcelable));
    }
  }
  
  public void zza(MessageEventParcelable paramMessageEventParcelable)
  {
    if (this.zzaPA != null) {
      this.zzaPA.zza(zzb(paramMessageEventParcelable));
    }
  }
  
  public void zza(NodeParcelable paramNodeParcelable)
  {
    if (this.zzbht != null) {
      this.zzbht.zza(zzc(paramNodeParcelable));
    }
  }
  
  public void zzaf(DataHolder paramDataHolder)
  {
    if (this.zzbhs != null)
    {
      this.zzbhs.zza(zzah(paramDataHolder));
      return;
    }
    paramDataHolder.close();
  }
  
  public void zzb(NodeParcelable paramNodeParcelable)
  {
    if (this.zzbht != null) {
      this.zzbht.zza(zzd(paramNodeParcelable));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */