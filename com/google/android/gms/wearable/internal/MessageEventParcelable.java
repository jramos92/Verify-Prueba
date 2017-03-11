package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable
  implements SafeParcelable, MessageEvent
{
  public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new zzba();
  private final String mPath;
  final int mVersionCode;
  private final byte[] zzaBg;
  private final String zzaGu;
  private final int zzaiy;
  
  MessageEventParcelable(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.zzaiy = paramInt2;
    this.mPath = paramString1;
    this.zzaBg = paramArrayOfByte;
    this.zzaGu = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getData()
  {
    return this.zzaBg;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public int getRequestId()
  {
    return this.zzaiy;
  }
  
  public String getSourceNodeId()
  {
    return this.zzaGu;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(this.zzaiy).append(",").append(this.mPath).append(", size=");
    if (this.zzaBg == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.zzaBg.length)) {
      return localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzba.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\MessageEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */