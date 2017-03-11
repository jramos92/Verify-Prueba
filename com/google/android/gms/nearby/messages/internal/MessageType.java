package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class MessageType
  implements SafeParcelable
{
  public static final Parcelable.Creator<MessageType> CREATOR = new zzh();
  final int mVersionCode;
  public final String type;
  public final String zzagM;
  
  MessageType(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzagM = paramString1;
    this.type = paramString2;
  }
  
  public MessageType(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MessageType)) {
        return false;
      }
      paramObject = (MessageType)paramObject;
    } while ((zzw.equal(this.zzagM, ((MessageType)paramObject).zzagM)) && (zzw.equal(this.type, ((MessageType)paramObject).type)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzagM, this.type });
  }
  
  public String toString()
  {
    return "namespace=" + this.zzagM + ", type=" + this.type;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\MessageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */