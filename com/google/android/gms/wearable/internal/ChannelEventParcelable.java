package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class ChannelEventParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChannelEventParcelable> CREATOR = new zzn();
  final int mVersionCode;
  final int type;
  final int zzbfY;
  final int zzbfZ;
  final ChannelImpl zzbga;
  
  ChannelEventParcelable(int paramInt1, ChannelImpl paramChannelImpl, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzbga = paramChannelImpl;
    this.type = paramInt2;
    this.zzbfY = paramInt3;
    this.zzbfZ = paramInt4;
  }
  
  private static String zzkS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 1: 
      return "CHANNEL_OPENED";
    case 2: 
      return "CHANNEL_CLOSED";
    case 4: 
      return "OUTPUT_CLOSED";
    }
    return "INPUT_CLOSED";
  }
  
  private static String zzkT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 1: 
      return "CLOSE_REASON_DISCONNECTED";
    case 2: 
      return "CLOSE_REASON_REMOTE_CLOSE";
    case 3: 
      return "CLOSE_REASON_LOCAL_CLOSE";
    }
    return "CLOSE_REASON_NORMAL";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ChannelEventParcelable[versionCode=" + this.mVersionCode + ", channel=" + this.zzbga + ", type=" + zzkS(this.type) + ", closeReason=" + zzkT(this.zzbfY) + ", appErrorCode=" + this.zzbfZ + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  public void zza(ChannelApi.ChannelListener paramChannelListener)
  {
    switch (this.type)
    {
    default: 
      Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
      return;
    case 1: 
      paramChannelListener.onChannelOpened(this.zzbga);
      return;
    case 2: 
      paramChannelListener.onChannelClosed(this.zzbga, this.zzbfY, this.zzbfZ);
      return;
    case 3: 
      paramChannelListener.onInputClosed(this.zzbga, this.zzbfY, this.zzbfZ);
      return;
    }
    paramChannelListener.onOutputClosed(this.zzbga, this.zzbfY, this.zzbfZ);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\ChannelEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */