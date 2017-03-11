package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzbj
  implements ChannelApi.ChannelListener
{
  private final String zzRz;
  private final ChannelApi.ChannelListener zzbhc;
  
  zzbj(String paramString, ChannelApi.ChannelListener paramChannelListener)
  {
    this.zzRz = ((String)zzx.zzw(paramString));
    this.zzbhc = ((ChannelApi.ChannelListener)zzx.zzw(paramChannelListener));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzbj)) {
        return false;
      }
      paramObject = (zzbj)paramObject;
    } while ((this.zzbhc.equals(((zzbj)paramObject).zzbhc)) && (this.zzRz.equals(((zzbj)paramObject).zzRz)));
    return false;
  }
  
  public int hashCode()
  {
    return this.zzRz.hashCode() * 31 + this.zzbhc.hashCode();
  }
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzbhc.onChannelClosed(paramChannel, paramInt1, paramInt2);
  }
  
  public void onChannelOpened(Channel paramChannel)
  {
    this.zzbhc.onChannelOpened(paramChannel);
  }
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzbhc.onInputClosed(paramChannel, paramInt1, paramInt2);
  }
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzbhc.onOutputClosed(paramChannel, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */