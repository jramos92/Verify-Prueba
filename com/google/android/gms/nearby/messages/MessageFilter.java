package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter
  implements SafeParcelable
{
  public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();
  public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
  final int mVersionCode;
  private final List<MessageType> zzaQa;
  private final List<NearbyDeviceFilter> zzaQb;
  private final boolean zzaQc;
  
  MessageFilter(int paramInt, List<MessageType> paramList, List<NearbyDeviceFilter> paramList1, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzaQa = Collections.unmodifiableList((List)zzx.zzw(paramList));
    this.zzaQc = paramBoolean;
    paramList = paramList1;
    if (paramList1 == null) {
      paramList = Collections.emptyList();
    }
    this.zzaQb = Collections.unmodifiableList(paramList);
  }
  
  private MessageFilter(List<MessageType> paramList, List<NearbyDeviceFilter> paramList1, boolean paramBoolean)
  {
    this(1, paramList, paramList1, paramBoolean);
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
      if (!(paramObject instanceof MessageFilter)) {
        return false;
      }
      paramObject = (MessageFilter)paramObject;
    } while ((this.zzaQc == ((MessageFilter)paramObject).zzaQc) && (zzw.equal(this.zzaQa, ((MessageFilter)paramObject).zzaQa)) && (zzw.equal(this.zzaQb, ((MessageFilter)paramObject).zzaQb)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaQa, this.zzaQb, Boolean.valueOf(this.zzaQc) });
  }
  
  public String toString()
  {
    return "MessageFilter{includeAllMyTypes=" + this.zzaQc + ", messageTypes=" + this.zzaQa + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  List<MessageType> zzAT()
  {
    return this.zzaQa;
  }
  
  boolean zzAU()
  {
    return this.zzaQc;
  }
  
  List<NearbyDeviceFilter> zzAV()
  {
    return this.zzaQb;
  }
  
  public static final class Builder
  {
    private final List<NearbyDeviceFilter> zzaQb = new ArrayList();
    private boolean zzaQc;
    private final List<MessageType> zzaQd = new ArrayList();
    
    private Builder zzL(String paramString1, String paramString2)
    {
      this.zzaQd.add(new MessageType(paramString1, paramString2));
      return this;
    }
    
    public MessageFilter build()
    {
      if ((this.zzaQc) || (!this.zzaQd.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "At least one of the include methods must be called.");
        return new MessageFilter(this.zzaQd, this.zzaQb, this.zzaQc, null);
      }
    }
    
    public Builder includeAllMyTypes()
    {
      this.zzaQc = true;
      return this;
    }
    
    public Builder includeFilter(MessageFilter paramMessageFilter)
    {
      this.zzaQd.addAll(paramMessageFilter.zzAT());
      this.zzaQb.addAll(paramMessageFilter.zzAV());
      this.zzaQc |= paramMessageFilter.zzAU();
      return this;
    }
    
    public Builder includeNamespacedType(String paramString1, String paramString2)
    {
      return zzL(paramString1, paramString2);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\MessageFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */