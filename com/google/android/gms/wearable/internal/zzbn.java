package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzbn
{
  private static Map<String, CapabilityInfo> zzB(List<CapabilityInfoParcelable> paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size() * 2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CapabilityInfoParcelable localCapabilityInfoParcelable = (CapabilityInfoParcelable)paramList.next();
      localHashMap.put(localCapabilityInfoParcelable.getName(), new zzj.zzb(localCapabilityInfoParcelable));
    }
    return localHashMap;
  }
  
  static final class zza
    extends zzbn.zzb<CapabilityApi.AddLocalCapabilityResult>
  {
    public zza(zzlb.zzb<CapabilityApi.AddLocalCapabilityResult> paramzzb)
    {
      super();
    }
    
    public void zza(AddLocalCapabilityResponse paramAddLocalCapabilityResponse)
    {
      zzW(new zzj.zza(zzbk.zzfG(paramAddLocalCapabilityResponse.statusCode)));
    }
  }
  
  static abstract class zzb<T>
    extends zza
  {
    private zzlb.zzb<T> zzRb;
    
    public zzb(zzlb.zzb<T> paramzzb)
    {
      this.zzRb = paramzzb;
    }
    
    public void zzW(T paramT)
    {
      zzlb.zzb localzzb = this.zzRb;
      if (localzzb != null)
      {
        localzzb.zzp(paramT);
        this.zzRb = null;
      }
    }
  }
  
  static final class zzc
    extends zzbn.zzb<Status>
  {
    public zzc(zzlb.zzb<Status> paramzzb)
    {
      super();
    }
    
    public void zza(CloseChannelResponse paramCloseChannelResponse)
    {
      zzW(new Status(paramCloseChannelResponse.statusCode));
    }
  }
  
  static final class zzd
    extends zzbn.zzb<Status>
  {
    public zzd(zzlb.zzb<Status> paramzzb)
    {
      super();
    }
    
    public void zzb(CloseChannelResponse paramCloseChannelResponse)
    {
      zzW(new Status(paramCloseChannelResponse.statusCode));
    }
  }
  
  static final class zze
    extends zzbn.zzb<DataApi.DeleteDataItemsResult>
  {
    public zze(zzlb.zzb<DataApi.DeleteDataItemsResult> paramzzb)
    {
      super();
    }
    
    public void zza(DeleteDataItemsResponse paramDeleteDataItemsResponse)
    {
      zzW(new zzx.zzb(zzbk.zzfG(paramDeleteDataItemsResponse.statusCode), paramDeleteDataItemsResponse.zzbgz));
    }
  }
  
  static final class zzf
    extends zzbn.zzb<CapabilityApi.GetAllCapabilitiesResult>
  {
    public zzf(zzlb.zzb<CapabilityApi.GetAllCapabilitiesResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetAllCapabilitiesResponse paramGetAllCapabilitiesResponse)
    {
      zzW(new zzj.zzc(zzbk.zzfG(paramGetAllCapabilitiesResponse.statusCode), zzbn.zzC(paramGetAllCapabilitiesResponse.zzbgA)));
    }
  }
  
  static final class zzg
    extends zzbn.zzb<CapabilityApi.GetCapabilityResult>
  {
    public zzg(zzlb.zzb<CapabilityApi.GetCapabilityResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetCapabilityResponse paramGetCapabilityResponse)
    {
      zzW(new zzj.zzd(zzbk.zzfG(paramGetCapabilityResponse.statusCode), new zzj.zzb(paramGetCapabilityResponse.zzbgB)));
    }
  }
  
  static final class zzh
    extends zzbn.zzb<Channel.GetInputStreamResult>
  {
    private final zzt zzbhe;
    
    public zzh(zzlb.zzb<Channel.GetInputStreamResult> paramzzb, zzt paramzzt)
    {
      super();
      this.zzbhe = ((zzt)zzx.zzw(paramzzt));
    }
    
    public void zza(GetChannelInputStreamResponse paramGetChannelInputStreamResponse)
    {
      zzp localzzp = null;
      if (paramGetChannelInputStreamResponse.zzbgC != null)
      {
        localzzp = new zzp(new ParcelFileDescriptor.AutoCloseInputStream(paramGetChannelInputStreamResponse.zzbgC));
        this.zzbhe.zza(localzzp.zzEY());
      }
      zzW(new ChannelImpl.zza(new Status(paramGetChannelInputStreamResponse.statusCode), localzzp));
    }
  }
  
  static final class zzi
    extends zzbn.zzb<Channel.GetOutputStreamResult>
  {
    private final zzt zzbhe;
    
    public zzi(zzlb.zzb<Channel.GetOutputStreamResult> paramzzb, zzt paramzzt)
    {
      super();
      this.zzbhe = ((zzt)zzx.zzw(paramzzt));
    }
    
    public void zza(GetChannelOutputStreamResponse paramGetChannelOutputStreamResponse)
    {
      zzq localzzq = null;
      if (paramGetChannelOutputStreamResponse.zzbgC != null)
      {
        localzzq = new zzq(new ParcelFileDescriptor.AutoCloseOutputStream(paramGetChannelOutputStreamResponse.zzbgC));
        this.zzbhe.zza(localzzq.zzEY());
      }
      zzW(new ChannelImpl.zzb(new Status(paramGetChannelOutputStreamResponse.statusCode), localzzq));
    }
  }
  
  static final class zzj
    extends zzbn.zzb<NodeApi.GetConnectedNodesResult>
  {
    public zzj(zzlb.zzb<NodeApi.GetConnectedNodesResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetConnectedNodesResponse paramGetConnectedNodesResponse)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramGetConnectedNodesResponse.zzbgI);
      zzW(new zzbb.zza(zzbk.zzfG(paramGetConnectedNodesResponse.statusCode), localArrayList));
    }
  }
  
  static final class zzk
    extends zzbn.zzb<DataApi.DataItemResult>
  {
    public zzk(zzlb.zzb<DataApi.DataItemResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetDataItemResponse paramGetDataItemResponse)
    {
      zzW(new zzx.zza(zzbk.zzfG(paramGetDataItemResponse.statusCode), paramGetDataItemResponse.zzbgJ));
    }
  }
  
  static final class zzl
    extends zzbn.zzb<DataItemBuffer>
  {
    public zzl(zzlb.zzb<DataItemBuffer> paramzzb)
    {
      super();
    }
    
    public void zzag(DataHolder paramDataHolder)
    {
      zzW(new DataItemBuffer(paramDataHolder));
    }
  }
  
  static final class zzm
    extends zzbn.zzb<DataApi.GetFdForAssetResult>
  {
    public zzm(zzlb.zzb<DataApi.GetFdForAssetResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetFdForAssetResponse paramGetFdForAssetResponse)
    {
      zzW(new zzx.zzc(zzbk.zzfG(paramGetFdForAssetResponse.statusCode), paramGetFdForAssetResponse.zzbgK));
    }
  }
  
  static final class zzn
    extends zzbn.zzb<NodeApi.GetLocalNodeResult>
  {
    public zzn(zzlb.zzb<NodeApi.GetLocalNodeResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetLocalNodeResponse paramGetLocalNodeResponse)
    {
      zzW(new zzbb.zzb(zzbk.zzfG(paramGetLocalNodeResponse.statusCode), paramGetLocalNodeResponse.zzbgL));
    }
  }
  
  static final class zzo
    extends zza
  {
    public void zzc(Status paramStatus) {}
  }
  
  static final class zzp
    extends zzbn.zzb<ChannelApi.OpenChannelResult>
  {
    public zzp(zzlb.zzb<ChannelApi.OpenChannelResult> paramzzb)
    {
      super();
    }
    
    public void zza(OpenChannelResponse paramOpenChannelResponse)
    {
      zzW(new zzl.zza(zzbk.zzfG(paramOpenChannelResponse.statusCode), paramOpenChannelResponse.zzbga));
    }
  }
  
  static final class zzq
    extends zzbn.zzb<DataApi.DataItemResult>
  {
    private final List<FutureTask<Boolean>> zzyb;
    
    zzq(zzlb.zzb<DataApi.DataItemResult> paramzzb, List<FutureTask<Boolean>> paramList)
    {
      super();
      this.zzyb = paramList;
    }
    
    public void zza(PutDataResponse paramPutDataResponse)
    {
      zzW(new zzx.zza(zzbk.zzfG(paramPutDataResponse.statusCode), paramPutDataResponse.zzbgJ));
      if (paramPutDataResponse.statusCode != 0)
      {
        paramPutDataResponse = this.zzyb.iterator();
        while (paramPutDataResponse.hasNext()) {
          ((FutureTask)paramPutDataResponse.next()).cancel(true);
        }
      }
    }
  }
  
  static final class zzr
    extends zzbn.zzb<Status>
  {
    public zzr(zzlb.zzb<Status> paramzzb)
    {
      super();
    }
    
    public void zza(ChannelSendFileResponse paramChannelSendFileResponse)
    {
      zzW(new Status(paramChannelSendFileResponse.statusCode));
    }
  }
  
  static final class zzs
    extends zzbn.zzb<CapabilityApi.RemoveLocalCapabilityResult>
  {
    public zzs(zzlb.zzb<CapabilityApi.RemoveLocalCapabilityResult> paramzzb)
    {
      super();
    }
    
    public void zza(RemoveLocalCapabilityResponse paramRemoveLocalCapabilityResponse)
    {
      zzW(new zzj.zza(zzbk.zzfG(paramRemoveLocalCapabilityResponse.statusCode)));
    }
  }
  
  static final class zzt
    extends zzbn.zzb<MessageApi.SendMessageResult>
  {
    public zzt(zzlb.zzb<MessageApi.SendMessageResult> paramzzb)
    {
      super();
    }
    
    public void zza(SendMessageResponse paramSendMessageResponse)
    {
      zzW(new zzaz.zzb(zzbk.zzfG(paramSendMessageResponse.statusCode), paramSendMessageResponse.zzaDQ));
    }
  }
  
  static final class zzu
    extends zzbn.zzb<Status>
  {
    public zzu(zzlb.zzb<Status> paramzzb)
    {
      super();
    }
    
    public void zza(ChannelReceiveFileResponse paramChannelReceiveFileResponse)
    {
      zzW(new Status(paramChannelReceiveFileResponse.statusCode));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */