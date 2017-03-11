package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.NodeApi.zza;
import java.util.ArrayList;
import java.util.List;

public final class zzbb
  implements NodeApi
{
  private static final zzb.zza<NodeApi.NodeListener> zzbfD = new zzb.zza()
  {
    public void zza(zzbo paramAnonymouszzbo, zzlb.zzb<Status> paramAnonymouszzb, NodeApi.NodeListener paramAnonymousNodeListener, zzlm<NodeApi.NodeListener> paramAnonymouszzlm)
      throws RemoteException
    {
      paramAnonymouszzbo.zza(paramAnonymouszzb, paramAnonymousNodeListener, paramAnonymouszzlm);
    }
  };
  private static final zzb.zza<NodeApi.zza> zzbgU = new zzb.zza()
  {
    public void zza(zzbo paramAnonymouszzbo, zzlb.zzb<Status> paramAnonymouszzb, NodeApi.zza paramAnonymouszza, zzlm<NodeApi.zza> paramAnonymouszzlm)
      throws RemoteException
    {
      paramAnonymouszzbo.zza(paramAnonymouszzb, paramAnonymouszza, paramAnonymouszzlm);
    }
  };
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, NodeApi.NodeListener paramNodeListener)
  {
    return zzb.zza(paramGoogleApiClient, zzbfD, paramNodeListener);
  }
  
  public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzo(this);
      }
      
      protected NodeApi.GetConnectedNodesResult zzbt(Status paramAnonymousStatus)
      {
        return new zzbb.zza(paramAnonymousStatus, new ArrayList());
      }
    });
  }
  
  public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zzn(this);
      }
      
      protected NodeApi.GetLocalNodeResult zzbs(Status paramAnonymousStatus)
      {
        return new zzbb.zzb(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final NodeApi.NodeListener paramNodeListener)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramNodeListener);
      }
      
      public Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public static class zza
    implements NodeApi.GetConnectedNodesResult
  {
    private final Status zzSC;
    private final List<Node> zzbgX;
    
    public zza(Status paramStatus, List<Node> paramList)
    {
      this.zzSC = paramStatus;
      this.zzbgX = paramList;
    }
    
    public List<Node> getNodes()
    {
      return this.zzbgX;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  public static class zzb
    implements NodeApi.GetLocalNodeResult
  {
    private final Status zzSC;
    private final Node zzbgY;
    
    public zzb(Status paramStatus, Node paramNode)
    {
      this.zzSC = paramStatus;
      this.zzbgY = paramNode;
    }
    
    public Node getNode()
    {
      return this.zzbgY;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */