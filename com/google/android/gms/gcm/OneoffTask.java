package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask
  extends Task
{
  public static final Parcelable.Creator<OneoffTask> CREATOR = new Parcelable.Creator()
  {
    public OneoffTask zzes(Parcel paramAnonymousParcel)
    {
      return new OneoffTask(paramAnonymousParcel, null);
    }
    
    public OneoffTask[] zzgC(int paramAnonymousInt)
    {
      return new OneoffTask[paramAnonymousInt];
    }
  };
  private final long zzaCC;
  private final long zzaCD;
  
  @Deprecated
  private OneoffTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.zzaCC = paramParcel.readLong();
    this.zzaCD = paramParcel.readLong();
  }
  
  private OneoffTask(Builder paramBuilder)
  {
    super(paramBuilder);
    this.zzaCC = Builder.zza(paramBuilder);
    this.zzaCD = Builder.zzb(paramBuilder);
  }
  
  public long getWindowEnd()
  {
    return this.zzaCD;
  }
  
  public long getWindowStart()
  {
    return this.zzaCC;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("window_start", this.zzaCC);
    paramBundle.putLong("window_end", this.zzaCD);
  }
  
  public String toString()
  {
    return super.toString() + " " + "windowStart=" + getWindowStart() + " " + "windowEnd=" + getWindowEnd();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.zzaCC);
    paramParcel.writeLong(this.zzaCD);
  }
  
  public static class Builder
    extends Task.Builder
  {
    private long zzaCE = -1L;
    private long zzaCF = -1L;
    
    public Builder()
    {
      this.isPersisted = false;
    }
    
    public OneoffTask build()
    {
      checkConditions();
      return new OneoffTask(this, null);
    }
    
    protected void checkConditions()
    {
      super.checkConditions();
      if ((this.zzaCE == -1L) || (this.zzaCF == -1L)) {
        throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
      }
      if (this.zzaCE >= this.zzaCF) {
        throw new IllegalArgumentException("Window start must be shorter than window end.");
      }
    }
    
    public Builder setExecutionWindow(long paramLong1, long paramLong2)
    {
      this.zzaCE = paramLong1;
      this.zzaCF = paramLong2;
      return this;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.extras = paramBundle;
      return this;
    }
    
    public Builder setPersisted(boolean paramBoolean)
    {
      this.isPersisted = paramBoolean;
      return this;
    }
    
    public Builder setRequiredNetwork(int paramInt)
    {
      this.requiredNetworkState = paramInt;
      return this;
    }
    
    public Builder setRequiresCharging(boolean paramBoolean)
    {
      this.requiresCharging = paramBoolean;
      return this;
    }
    
    public Builder setService(Class<? extends GcmTaskService> paramClass)
    {
      this.gcmTaskService = paramClass.getName();
      return this;
    }
    
    public Builder setTag(String paramString)
    {
      this.tag = paramString;
      return this;
    }
    
    public Builder setUpdateCurrent(boolean paramBoolean)
    {
      this.updateCurrent = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\gcm\OneoffTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */