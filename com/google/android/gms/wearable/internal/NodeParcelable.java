package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable
  implements SafeParcelable, Node
{
  public static final Parcelable.Creator<NodeParcelable> CREATOR = new zzbc();
  final int mVersionCode;
  private final String zzTa;
  private final int zzbgZ;
  private final boolean zzbha;
  private final String zzwN;
  
  NodeParcelable(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzwN = paramString1;
    this.zzTa = paramString2;
    this.zzbgZ = paramInt2;
    this.zzbha = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NodeParcelable)) {
      return false;
    }
    return ((NodeParcelable)paramObject).zzwN.equals(this.zzwN);
  }
  
  public String getDisplayName()
  {
    return this.zzTa;
  }
  
  public int getHopCount()
  {
    return this.zzbgZ;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public int hashCode()
  {
    return this.zzwN.hashCode();
  }
  
  public boolean isNearby()
  {
    return this.zzbha;
  }
  
  public String toString()
  {
    return "Node{" + this.zzTa + ", id=" + this.zzwN + ", hops=" + this.zzbgZ + ", isNearby=" + this.zzbha + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\NodeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */