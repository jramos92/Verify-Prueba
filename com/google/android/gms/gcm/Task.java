package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

public abstract class Task
  implements Parcelable
{
  public static final int EXTRAS_LIMIT_BYTES = 10240;
  public static final int NETWORK_STATE_ANY = 2;
  public static final int NETWORK_STATE_CONNECTED = 0;
  public static final int NETWORK_STATE_UNMETERED = 1;
  protected static final long UNINITIALIZED = -1L;
  private final Bundle mExtras;
  private final String mTag;
  private final String zzaCN;
  private final boolean zzaCO;
  private final boolean zzaCP;
  private final int zzaCQ;
  private final boolean zzaCR;
  private final zzc zzaCS;
  
  @Deprecated
  Task(Parcel paramParcel)
  {
    Log.e("Task", "Constructing a Task object using a parcel.");
    this.zzaCN = paramParcel.readString();
    this.mTag = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.zzaCO = bool1;
      if (paramParcel.readInt() != 1) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zzaCP = bool1;
      this.zzaCQ = 2;
      this.zzaCR = false;
      this.zzaCS = zzc.zzaCI;
      this.mExtras = null;
      return;
      bool1 = false;
      break;
    }
  }
  
  Task(Builder paramBuilder)
  {
    this.zzaCN = paramBuilder.gcmTaskService;
    this.mTag = paramBuilder.tag;
    this.zzaCO = paramBuilder.updateCurrent;
    this.zzaCP = paramBuilder.isPersisted;
    this.zzaCQ = paramBuilder.requiredNetworkState;
    this.zzaCR = paramBuilder.requiresCharging;
    this.zzaCS = paramBuilder.zzaCT;
    this.mExtras = paramBuilder.extras;
  }
  
  public static void zzA(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = Parcel.obtain();
      paramBundle.writeToParcel((Parcel)localObject, 0);
      int i = ((Parcel)localObject).dataSize();
      if (i > 10240)
      {
        ((Parcel)localObject).recycle();
        throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + i);
      }
      ((Parcel)localObject).recycle();
      localObject = paramBundle.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!zzz(paramBundle.get((String)((Iterator)localObject).next()))) {
          throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
        }
      }
    }
  }
  
  public static void zza(zzc paramzzc)
  {
    if (paramzzc != null)
    {
      int i = paramzzc.zzvZ();
      if ((i != 1) && (i != 0)) {
        throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + i);
      }
      int j = paramzzc.zzwa();
      int k = paramzzc.zzwb();
      if ((i == 0) && (j < 0)) {
        throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + j);
      }
      if ((i == 1) && (j < 10)) {
        throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
      }
      if (k < j) {
        throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + paramzzc.zzwb());
      }
    }
  }
  
  private static boolean zzz(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Double)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public int getRequiredNetwork()
  {
    return this.zzaCQ;
  }
  
  public boolean getRequiresCharging()
  {
    return this.zzaCR;
  }
  
  public String getServiceName()
  {
    return this.zzaCN;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public boolean isPersisted()
  {
    return this.zzaCP;
  }
  
  public boolean isUpdateCurrent()
  {
    return this.zzaCO;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("tag", this.mTag);
    paramBundle.putBoolean("update_current", this.zzaCO);
    paramBundle.putBoolean("persisted", this.zzaCP);
    paramBundle.putString("service", this.zzaCN);
    paramBundle.putInt("requiredNetwork", this.zzaCQ);
    paramBundle.putBoolean("requiresCharging", this.zzaCR);
    paramBundle.putBundle("retryStrategy", this.zzaCS.zzz(new Bundle()));
    paramBundle.putBundle("extras", this.mExtras);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.zzaCN);
    paramParcel.writeString(this.mTag);
    if (this.zzaCO)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.zzaCP) {
        break label52;
      }
    }
    label52:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static abstract class Builder
  {
    protected Bundle extras;
    protected String gcmTaskService;
    protected boolean isPersisted;
    protected int requiredNetworkState;
    protected boolean requiresCharging;
    protected String tag;
    protected boolean updateCurrent;
    protected zzc zzaCT = zzc.zzaCI;
    
    public abstract Task build();
    
    protected void checkConditions()
    {
      if (this.gcmTaskService != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
        GcmNetworkManager.zzdh(this.tag);
        Task.zza(this.zzaCT);
        if (this.isPersisted) {
          Task.zzA(this.extras);
        }
        return;
      }
    }
    
    public abstract Builder setExtras(Bundle paramBundle);
    
    public abstract Builder setPersisted(boolean paramBoolean);
    
    public abstract Builder setRequiredNetwork(int paramInt);
    
    public abstract Builder setRequiresCharging(boolean paramBoolean);
    
    public abstract Builder setService(Class<? extends GcmTaskService> paramClass);
    
    public abstract Builder setTag(String paramString);
    
    public abstract Builder setUpdateCurrent(boolean paramBoolean);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\gcm\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */