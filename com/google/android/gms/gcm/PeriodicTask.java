package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask
  extends Task
{
  public static final Parcelable.Creator<PeriodicTask> CREATOR = new Parcelable.Creator()
  {
    public PeriodicTask zzeu(Parcel paramAnonymousParcel)
    {
      return new PeriodicTask(paramAnonymousParcel, null);
    }
    
    public PeriodicTask[] zzgE(int paramAnonymousInt)
    {
      return new PeriodicTask[paramAnonymousInt];
    }
  };
  protected long mFlexInSeconds = -1L;
  protected long mIntervalInSeconds = -1L;
  
  @Deprecated
  private PeriodicTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.mIntervalInSeconds = paramParcel.readLong();
    this.mFlexInSeconds = paramParcel.readLong();
  }
  
  private PeriodicTask(Builder paramBuilder)
  {
    super(paramBuilder);
    this.mIntervalInSeconds = Builder.zza(paramBuilder);
    this.mFlexInSeconds = Builder.zzb(paramBuilder);
  }
  
  public long getFlex()
  {
    return this.mFlexInSeconds;
  }
  
  public long getPeriod()
  {
    return this.mIntervalInSeconds;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("period", this.mIntervalInSeconds);
    paramBundle.putLong("period_flex", this.mFlexInSeconds);
  }
  
  public String toString()
  {
    return super.toString() + " " + "period=" + getPeriod() + " " + "flex=" + getFlex();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mIntervalInSeconds);
    paramParcel.writeLong(this.mFlexInSeconds);
  }
  
  public static class Builder
    extends Task.Builder
  {
    private long zzaCG = -1L;
    private long zzaCH = -1L;
    
    public Builder()
    {
      this.isPersisted = true;
    }
    
    public PeriodicTask build()
    {
      checkConditions();
      return new PeriodicTask(this, null);
    }
    
    protected void checkConditions()
    {
      super.checkConditions();
      if (this.zzaCG == -1L) {
        throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
      }
      if (this.zzaCH == -1L) {
        this.zzaCH = (((float)this.zzaCG * 0.1F));
      }
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.extras = paramBundle;
      return this;
    }
    
    public Builder setFlex(long paramLong)
    {
      this.zzaCH = paramLong;
      return this;
    }
    
    public Builder setPeriod(long paramLong)
    {
      this.zzaCG = paramLong;
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\gcm\PeriodicTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */