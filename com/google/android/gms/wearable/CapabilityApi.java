package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Map;

public abstract interface CapabilityApi
{
  public static final int FILTER_ALL = 0;
  public static final int FILTER_REACHABLE = 1;
  
  public abstract PendingResult<Status> addCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityListener paramCapabilityListener, String paramString);
  
  public abstract PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract PendingResult<GetCapabilityResult> getCapability(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt);
  
  public abstract PendingResult<Status> removeCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityListener paramCapabilityListener, String paramString);
  
  public abstract PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public static abstract interface AddLocalCapabilityResult
    extends Result
  {}
  
  public static abstract interface CapabilityListener
  {
    public abstract void onCapabilityChanged(CapabilityInfo paramCapabilityInfo);
  }
  
  public static abstract interface GetAllCapabilitiesResult
    extends Result
  {
    public abstract Map<String, CapabilityInfo> getAllCapabilities();
  }
  
  public static abstract interface GetCapabilityResult
    extends Result
  {
    public abstract CapabilityInfo getCapability();
  }
  
  public static abstract interface RemoveLocalCapabilityResult
    extends Result
  {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\CapabilityApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */