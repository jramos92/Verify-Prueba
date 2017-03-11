package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzu;

public final class ExecutionOptions
{
  public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
  public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
  public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
  private final String zzaiX;
  private final boolean zzaiY;
  private final int zzaiZ;
  
  public ExecutionOptions(String paramString, boolean paramBoolean, int paramInt)
  {
    this.zzaiX = paramString;
    this.zzaiY = paramBoolean;
    this.zzaiZ = paramInt;
  }
  
  public static void zza(GoogleApiClient paramGoogleApiClient, ExecutionOptions paramExecutionOptions)
  {
    paramGoogleApiClient = (zzu)paramGoogleApiClient.zza(Drive.zzRk);
    if ((paramExecutionOptions.zzqT()) && (!paramGoogleApiClient.zzrq())) {
      throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
    }
  }
  
  public static boolean zzcC(String paramString)
  {
    return (paramString != null) && (!paramString.isEmpty()) && (paramString.length() <= 65536);
  }
  
  public static boolean zzck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzcl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (ExecutionOptions)paramObject;
      if ((!zzw.equal(this.zzaiX, ((ExecutionOptions)paramObject).zzaiX)) || (this.zzaiZ != ((ExecutionOptions)paramObject).zzaiZ)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzaiY == ((ExecutionOptions)paramObject).zzaiY);
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaiX, Integer.valueOf(this.zzaiZ), Boolean.valueOf(this.zzaiY) });
  }
  
  public String zzqS()
  {
    return this.zzaiX;
  }
  
  public boolean zzqT()
  {
    return this.zzaiY;
  }
  
  public int zzqU()
  {
    return this.zzaiZ;
  }
  
  public static final class Builder
  {
    private String zzaiX;
    private boolean zzaiY;
    private int zzaiZ = 0;
    
    public ExecutionOptions build()
    {
      if ((this.zzaiZ == 1) && (!this.zzaiY)) {
        throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
      }
      return new ExecutionOptions(this.zzaiX, this.zzaiY, this.zzaiZ);
    }
    
    public Builder setConflictStrategy(int paramInt)
    {
      if (!ExecutionOptions.zzcl(paramInt)) {
        throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + paramInt);
      }
      this.zzaiZ = paramInt;
      return this;
    }
    
    public Builder setNotifyOnCompletion(boolean paramBoolean)
    {
      this.zzaiY = paramBoolean;
      return this;
    }
    
    public Builder setTrackingTag(String paramString)
    {
      if (!ExecutionOptions.zzcC(paramString)) {
        throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[] { Integer.valueOf(65536) }));
      }
      this.zzaiX = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\ExecutionOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */