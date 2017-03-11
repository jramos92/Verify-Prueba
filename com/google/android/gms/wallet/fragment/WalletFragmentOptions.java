package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new zzb();
  private int mTheme;
  final int mVersionCode;
  private int zzaiz;
  private int zzbdL;
  private WalletFragmentStyle zzbeq;
  
  private WalletFragmentOptions()
  {
    this.mVersionCode = 1;
  }
  
  WalletFragmentOptions(int paramInt1, int paramInt2, int paramInt3, WalletFragmentStyle paramWalletFragmentStyle, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzbdL = paramInt2;
    this.mTheme = paramInt3;
    this.zzbeq = paramWalletFragmentStyle;
    this.zzaiz = paramInt4;
  }
  
  public static Builder newBuilder()
  {
    WalletFragmentOptions localWalletFragmentOptions = new WalletFragmentOptions();
    localWalletFragmentOptions.getClass();
    return new Builder(null);
  }
  
  public static WalletFragmentOptions zza(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WalletFragmentOptions);
    int i = paramAttributeSet.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
    int j = paramAttributeSet.getInt(R.styleable.WalletFragmentOptions_environment, 1);
    int k = paramAttributeSet.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
    int m = paramAttributeSet.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
    paramAttributeSet.recycle();
    paramAttributeSet = new WalletFragmentOptions();
    paramAttributeSet.mTheme = i;
    paramAttributeSet.zzbdL = j;
    paramAttributeSet.zzbeq = new WalletFragmentStyle().setStyleResourceId(k);
    paramAttributeSet.zzbeq.zzaT(paramContext);
    paramAttributeSet.zzaiz = m;
    return paramAttributeSet;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEnvironment()
  {
    return this.zzbdL;
  }
  
  public WalletFragmentStyle getFragmentStyle()
  {
    return this.zzbeq;
  }
  
  public int getMode()
  {
    return this.zzaiz;
  }
  
  public int getTheme()
  {
    return this.mTheme;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public void zzaT(Context paramContext)
  {
    if (this.zzbeq != null) {
      this.zzbeq.zzaT(paramContext);
    }
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public WalletFragmentOptions build()
    {
      return WalletFragmentOptions.this;
    }
    
    public Builder setEnvironment(int paramInt)
    {
      WalletFragmentOptions.zza(WalletFragmentOptions.this, paramInt);
      return this;
    }
    
    public Builder setFragmentStyle(int paramInt)
    {
      WalletFragmentOptions.zza(WalletFragmentOptions.this, new WalletFragmentStyle().setStyleResourceId(paramInt));
      return this;
    }
    
    public Builder setFragmentStyle(WalletFragmentStyle paramWalletFragmentStyle)
    {
      WalletFragmentOptions.zza(WalletFragmentOptions.this, paramWalletFragmentStyle);
      return this;
    }
    
    public Builder setMode(int paramInt)
    {
      WalletFragmentOptions.zzc(WalletFragmentOptions.this, paramInt);
      return this;
    }
    
    public Builder setTheme(int paramInt)
    {
      WalletFragmentOptions.zzb(WalletFragmentOptions.this, paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\fragment\WalletFragmentOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */