package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzx;

public final class SubscribeOptions
{
  public static final SubscribeOptions DEFAULT = new Builder().build();
  private final Strategy zzaQg;
  private final MessageFilter zzaQt;
  private final SubscribeCallback zzaQu;
  
  private SubscribeOptions(Strategy paramStrategy, MessageFilter paramMessageFilter, SubscribeCallback paramSubscribeCallback)
  {
    this.zzaQg = paramStrategy;
    this.zzaQt = paramMessageFilter;
    this.zzaQu = paramSubscribeCallback;
  }
  
  public SubscribeCallback getCallback()
  {
    return this.zzaQu;
  }
  
  public MessageFilter getFilter()
  {
    return this.zzaQt;
  }
  
  public Strategy getStrategy()
  {
    return this.zzaQg;
  }
  
  public static class Builder
  {
    private Strategy zzaQg = Strategy.DEFAULT;
    private MessageFilter zzaQt = MessageFilter.INCLUDE_ALL_MY_TYPES;
    private SubscribeCallback zzaQu;
    
    public SubscribeOptions build()
    {
      return new SubscribeOptions(this.zzaQg, this.zzaQt, this.zzaQu, null);
    }
    
    public Builder setCallback(SubscribeCallback paramSubscribeCallback)
    {
      this.zzaQu = ((SubscribeCallback)zzx.zzw(paramSubscribeCallback));
      return this;
    }
    
    public Builder setFilter(MessageFilter paramMessageFilter)
    {
      this.zzaQt = paramMessageFilter;
      return this;
    }
    
    public Builder setStrategy(Strategy paramStrategy)
    {
      this.zzaQg = paramStrategy;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\SubscribeOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */