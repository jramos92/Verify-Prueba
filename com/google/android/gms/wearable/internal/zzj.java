package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

public class zzj
  implements CapabilityApi
{
  private static zzb.zza<CapabilityApi.CapabilityListener> zzfx(String paramString)
  {
    new zzb.zza()
    {
      public void zza(zzbo paramAnonymouszzbo, zzlb.zzb<Status> paramAnonymouszzb, CapabilityApi.CapabilityListener paramAnonymousCapabilityListener, zzlm<CapabilityApi.CapabilityListener> paramAnonymouszzlm)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(paramAnonymouszzb, paramAnonymousCapabilityListener, paramAnonymouszzlm, this.zzbfL);
      }
    };
  }
  
  public PendingResult<Status> addCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    return zzb.zza(paramGoogleApiClient, zzfx(paramString), paramCapabilityListener);
  }
  
  public PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzr(this, paramString);
      }
      
      protected CapabilityApi.AddLocalCapabilityResult zzbi(Status paramAnonymousStatus)
      {
        return new zzj.zza(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzb(this, paramInt);
      }
      
      protected CapabilityApi.GetAllCapabilitiesResult zzbh(Status paramAnonymousStatus)
      {
        return new zzj.zzc(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzg(this, paramString, paramInt);
      }
      
      protected CapabilityApi.GetCapabilityResult zzbg(Status paramAnonymousStatus)
      {
        return new zzj.zzd(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    return paramGoogleApiClient.zza(new zze(paramGoogleApiClient, paramCapabilityListener, paramString, null));
  }
  
  public PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzs(this, paramString);
      }
      
      protected CapabilityApi.RemoveLocalCapabilityResult zzbj(Status paramAnonymousStatus)
      {
        return new zzj.zza(paramAnonymousStatus);
      }
    });
  }
  
  public static class zza
    implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult
  {
    private final Status zzSC;
    
    public zza(Status paramStatus)
    {
      this.zzSC = paramStatus;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  public static class zzb
    implements CapabilityInfo
  {
    private final String mName;
    private final Set<Node> zzbfO;
    
    public zzb(CapabilityInfo paramCapabilityInfo)
    {
      this(paramCapabilityInfo.getName(), paramCapabilityInfo.getNodes());
    }
    
    public zzb(String paramString, Set<Node> paramSet)
    {
      this.mName = paramString;
      this.zzbfO = paramSet;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public Set<Node> getNodes()
    {
      return this.zzbfO;
    }
  }
  
  public static class zzc
    implements CapabilityApi.GetAllCapabilitiesResult
  {
    private final Status zzSC;
    private final Map<String, CapabilityInfo> zzbfP;
    
    public zzc(Status paramStatus, Map<String, CapabilityInfo> paramMap)
    {
      this.zzSC = paramStatus;
      this.zzbfP = paramMap;
    }
    
    public Map<String, CapabilityInfo> getAllCapabilities()
    {
      return this.zzbfP;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  public static class zzd
    implements CapabilityApi.GetCapabilityResult
  {
    private final Status zzSC;
    private final CapabilityInfo zzbfQ;
    
    public zzd(Status paramStatus, CapabilityInfo paramCapabilityInfo)
    {
      this.zzSC = paramStatus;
      this.zzbfQ = paramCapabilityInfo;
    }
    
    public CapabilityInfo getCapability()
    {
      return this.zzbfQ;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class zze
    extends zzi<Status>
  {
    private CapabilityApi.CapabilityListener zzbfR;
    private String zzbfS;
    
    private zze(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
    {
      super();
      this.zzbfR = paramCapabilityListener;
      this.zzbfS = paramString;
    }
    
    protected void zza(zzbo paramzzbo)
      throws RemoteException
    {
      paramzzbo.zza(this, this.zzbfR, this.zzbfS);
      this.zzbfR = null;
      this.zzbfS = null;
    }
    
    public Status zzd(Status paramStatus)
    {
      this.zzbfR = null;
      this.zzbfS = null;
      return paramStatus;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */