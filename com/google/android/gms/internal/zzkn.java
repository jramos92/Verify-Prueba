package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzkn
  implements ProxyApi.ProxyResult
{
  private Status zzSC;
  private ProxyResponse zzST;
  
  public zzkn(ProxyResponse paramProxyResponse)
  {
    this.zzST = paramProxyResponse;
    this.zzSC = Status.zzabb;
  }
  
  public zzkn(Status paramStatus)
  {
    this.zzSC = paramStatus;
  }
  
  public ProxyResponse getResponse()
  {
    return this.zzST;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */