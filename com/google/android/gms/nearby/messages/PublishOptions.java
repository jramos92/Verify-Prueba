package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzx;

public final class PublishOptions
{
  public static final PublishOptions DEFAULT = new Builder().build();
  private final Strategy zzaQg;
  private final PublishCallback zzaQh;
  
  private PublishOptions(Strategy paramStrategy, PublishCallback paramPublishCallback)
  {
    this.zzaQg = paramStrategy;
    this.zzaQh = paramPublishCallback;
  }
  
  public PublishCallback getCallback()
  {
    return this.zzaQh;
  }
  
  public Strategy getStrategy()
  {
    return this.zzaQg;
  }
  
  public static class Builder
  {
    private Strategy zzaQg = Strategy.DEFAULT;
    private PublishCallback zzaQh;
    
    public PublishOptions build()
    {
      return new PublishOptions(this.zzaQg, this.zzaQh, null);
    }
    
    public Builder setCallback(PublishCallback paramPublishCallback)
    {
      this.zzaQh = ((PublishCallback)zzx.zzw(paramPublishCallback));
      return this;
    }
    
    public Builder setStrategy(Strategy paramStrategy)
    {
      this.zzaQg = ((Strategy)zzx.zzw(paramStrategy));
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\PublishOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */