package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem
  implements SafeParcelable
{
  public static final Parcelable.Creator<LineItem> CREATOR = new zzi();
  String description;
  private final int mVersionCode;
  String zzbcL;
  String zzbcM;
  int zzbcN;
  String zzbci;
  String zzbcj;
  
  LineItem()
  {
    this.mVersionCode = 1;
    this.zzbcN = 0;
  }
  
  LineItem(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    this.mVersionCode = paramInt1;
    this.description = paramString1;
    this.zzbcL = paramString2;
    this.zzbcM = paramString3;
    this.zzbci = paramString4;
    this.zzbcN = paramInt2;
    this.zzbcj = paramString5;
  }
  
  public static Builder newBuilder()
  {
    LineItem localLineItem = new LineItem();
    localLineItem.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCurrencyCode()
  {
    return this.zzbcj;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getQuantity()
  {
    return this.zzbcL;
  }
  
  public int getRole()
  {
    return this.zzbcN;
  }
  
  public String getTotalPrice()
  {
    return this.zzbci;
  }
  
  public String getUnitPrice()
  {
    return this.zzbcM;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public LineItem build()
    {
      return LineItem.this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      LineItem.this.zzbcj = paramString;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      LineItem.this.description = paramString;
      return this;
    }
    
    public Builder setQuantity(String paramString)
    {
      LineItem.this.zzbcL = paramString;
      return this;
    }
    
    public Builder setRole(int paramInt)
    {
      LineItem.this.zzbcN = paramInt;
      return this;
    }
    
    public Builder setTotalPrice(String paramString)
    {
      LineItem.this.zzbci = paramString;
      return this;
    }
    
    public Builder setUnitPrice(String paramString)
    {
      LineItem.this.zzbcM = paramString;
      return this;
    }
  }
  
  public static abstract interface Role
  {
    public static final int REGULAR = 0;
    public static final int SHIPPING = 2;
    public static final int TAX = 1;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\LineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */