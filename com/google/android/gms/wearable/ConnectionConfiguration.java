package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ConnectionConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzg();
  private final String mName;
  final int mVersionCode;
  private boolean zzPw;
  private final int zzWJ;
  private final int zzajn;
  private final String zzapU;
  private final boolean zzbeW;
  private String zzbeX;
  private boolean zzbeY;
  private String zzbeZ;
  
  ConnectionConfiguration(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    this.mVersionCode = paramInt1;
    this.mName = paramString1;
    this.zzapU = paramString2;
    this.zzWJ = paramInt2;
    this.zzajn = paramInt3;
    this.zzbeW = paramBoolean1;
    this.zzPw = paramBoolean2;
    this.zzbeX = paramString3;
    this.zzbeY = paramBoolean3;
    this.zzbeZ = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration)) {}
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    } while ((!zzw.equal(Integer.valueOf(this.mVersionCode), Integer.valueOf(((ConnectionConfiguration)paramObject).mVersionCode))) || (!zzw.equal(this.mName, ((ConnectionConfiguration)paramObject).mName)) || (!zzw.equal(this.zzapU, ((ConnectionConfiguration)paramObject).zzapU)) || (!zzw.equal(Integer.valueOf(this.zzWJ), Integer.valueOf(((ConnectionConfiguration)paramObject).zzWJ))) || (!zzw.equal(Integer.valueOf(this.zzajn), Integer.valueOf(((ConnectionConfiguration)paramObject).zzajn))) || (!zzw.equal(Boolean.valueOf(this.zzbeW), Boolean.valueOf(((ConnectionConfiguration)paramObject).zzbeW))) || (!zzw.equal(Boolean.valueOf(this.zzbeY), Boolean.valueOf(((ConnectionConfiguration)paramObject).zzbeY))));
    return true;
  }
  
  public String getAddress()
  {
    return this.zzapU;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getNodeId()
  {
    return this.zzbeZ;
  }
  
  public int getRole()
  {
    return this.zzajn;
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.mName, this.zzapU, Integer.valueOf(this.zzWJ), Integer.valueOf(this.zzajn), Boolean.valueOf(this.zzbeW), Boolean.valueOf(this.zzbeY) });
  }
  
  public boolean isConnected()
  {
    return this.zzPw;
  }
  
  public boolean isEnabled()
  {
    return this.zzbeW;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.mName);
    localStringBuilder.append(", mAddress=" + this.zzapU);
    localStringBuilder.append(", mType=" + this.zzWJ);
    localStringBuilder.append(", mRole=" + this.zzajn);
    localStringBuilder.append(", mEnabled=" + this.zzbeW);
    localStringBuilder.append(", mIsConnected=" + this.zzPw);
    localStringBuilder.append(", mPeerNodeId=" + this.zzbeX);
    localStringBuilder.append(", mBtlePriority=" + this.zzbeY);
    localStringBuilder.append(", mNodeId=" + this.zzbeZ);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public String zzEK()
  {
    return this.zzbeX;
  }
  
  public boolean zzEL()
  {
    return this.zzbeY;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\ConnectionConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */