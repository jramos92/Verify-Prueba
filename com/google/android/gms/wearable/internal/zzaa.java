package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzaa
  implements DataItemAsset
{
  private final String zzue;
  private final String zzwN;
  
  public zzaa(DataItemAsset paramDataItemAsset)
  {
    this.zzwN = paramDataItemAsset.getId();
    this.zzue = paramDataItemAsset.getDataItemKey();
  }
  
  public String getDataItemKey()
  {
    return this.zzue;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zzwN == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.zzue);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.zzwN);
    }
  }
  
  public DataItemAsset zzFa()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */