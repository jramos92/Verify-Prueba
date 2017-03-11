package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R.style;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class WalletFragmentStyle
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new zzc();
  final int mVersionCode;
  Bundle zzbes;
  int zzbet;
  
  public WalletFragmentStyle()
  {
    this.mVersionCode = 1;
    this.zzbes = new Bundle();
  }
  
  WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzbes = paramBundle;
    this.zzbet = paramInt2;
  }
  
  private static int zza(long paramLong, DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    switch (i)
    {
    default: 
      throw new IllegalStateException("Unexpected unit or type: " + i);
    case 129: 
      return j;
    case 128: 
      return TypedValue.complexToDimensionPixelSize(j, paramDisplayMetrics);
    case 0: 
      i = 0;
    }
    for (;;)
    {
      return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(j), paramDisplayMetrics));
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  private static long zza(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unrecognized unit: " + paramInt);
    }
    return zzt(paramInt, Float.floatToIntBits(paramFloat));
  }
  
  private static long zza(TypedValue paramTypedValue)
  {
    switch (paramTypedValue.type)
    {
    default: 
      throw new IllegalArgumentException("Unexpected dimension type: " + paramTypedValue.type);
    case 16: 
      return zzkx(paramTypedValue.data);
    }
    return zzt(128, paramTypedValue.data);
  }
  
  private void zza(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (this.zzbes.containsKey(paramString)) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    this.zzbes.putLong(paramString, zza(paramTypedArray));
  }
  
  private void zza(TypedArray paramTypedArray, int paramInt, String paramString1, String paramString2)
  {
    if ((this.zzbes.containsKey(paramString1)) || (this.zzbes.containsKey(paramString2))) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    if ((paramTypedArray.type >= 28) && (paramTypedArray.type <= 31))
    {
      this.zzbes.putInt(paramString1, paramTypedArray.data);
      return;
    }
    this.zzbes.putInt(paramString2, paramTypedArray.resourceId);
  }
  
  private void zzb(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (this.zzbes.containsKey(paramString)) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    this.zzbes.putInt(paramString, paramTypedArray.data);
  }
  
  private static long zzkx(int paramInt)
  {
    if (paramInt < 0)
    {
      if ((paramInt == -1) || (paramInt == -2)) {
        return zzt(129, paramInt);
      }
      throw new IllegalArgumentException("Unexpected dimension value: " + paramInt);
    }
    return zza(0, paramInt);
  }
  
  private static long zzt(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2 & 0xFFFFFFFF;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public WalletFragmentStyle setBuyButtonAppearance(int paramInt)
  {
    this.zzbes.putInt("buyButtonAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonHeight(int paramInt)
  {
    this.zzbes.putLong("buyButtonHeight", zzkx(paramInt));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonHeight(int paramInt, float paramFloat)
  {
    this.zzbes.putLong("buyButtonHeight", zza(paramInt, paramFloat));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonText(int paramInt)
  {
    this.zzbes.putInt("buyButtonText", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonWidth(int paramInt)
  {
    this.zzbes.putLong("buyButtonWidth", zzkx(paramInt));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonWidth(int paramInt, float paramFloat)
  {
    this.zzbes.putLong("buyButtonWidth", zza(paramInt, paramFloat));
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int paramInt)
  {
    this.zzbes.remove("maskedWalletDetailsBackgroundResource");
    this.zzbes.putInt("maskedWalletDetailsBackgroundColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int paramInt)
  {
    this.zzbes.remove("maskedWalletDetailsBackgroundColor");
    this.zzbes.putInt("maskedWalletDetailsBackgroundResource", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int paramInt)
  {
    this.zzbes.remove("maskedWalletDetailsButtonBackgroundResource");
    this.zzbes.putInt("maskedWalletDetailsButtonBackgroundColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int paramInt)
  {
    this.zzbes.remove("maskedWalletDetailsButtonBackgroundColor");
    this.zzbes.putInt("maskedWalletDetailsButtonBackgroundResource", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int paramInt)
  {
    this.zzbes.putInt("maskedWalletDetailsButtonTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int paramInt)
  {
    this.zzbes.putInt("maskedWalletDetailsHeaderTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int paramInt)
  {
    this.zzbes.putInt("maskedWalletDetailsLogoImageType", paramInt);
    return this;
  }
  
  @Deprecated
  public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int paramInt)
  {
    this.zzbes.putInt("maskedWalletDetailsLogoTextColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int paramInt)
  {
    this.zzbes.putInt("maskedWalletDetailsTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setStyleResourceId(int paramInt)
  {
    this.zzbet = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public int zza(String paramString, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    if (this.zzbes.containsKey(paramString)) {
      paramInt = zza(this.zzbes.getLong(paramString), paramDisplayMetrics);
    }
    return paramInt;
  }
  
  public void zzaT(Context paramContext)
  {
    if (this.zzbet <= 0) {}
    for (int i = R.style.WalletFragmentDefaultStyle;; i = this.zzbet)
    {
      paramContext = paramContext.obtainStyledAttributes(i, R.styleable.WalletFragmentStyle);
      zza(paramContext, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
      zza(paramContext, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
      zzb(paramContext, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
      zzb(paramContext, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
      zza(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
      zza(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
      paramContext.recycle();
      return;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BuyButtonAppearance
  {
    public static final int GOOGLE_WALLET_CLASSIC = 1;
    public static final int GOOGLE_WALLET_GRAYSCALE = 2;
    public static final int GOOGLE_WALLET_MONOCHROME = 3;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BuyButtonText
  {
    public static final int BUY_WITH = 5;
    public static final int DONATE_WITH = 7;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Dimension
  {
    public static final int MATCH_PARENT = -1;
    public static final int UNIT_DIP = 1;
    public static final int UNIT_IN = 4;
    public static final int UNIT_MM = 5;
    public static final int UNIT_PT = 3;
    public static final int UNIT_PX = 0;
    public static final int UNIT_SP = 2;
    public static final int WRAP_CONTENT = -2;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LogoImageType
  {
    public static final int GOOGLE_WALLET_CLASSIC = 1;
    public static final int GOOGLE_WALLET_MONOCHROME = 2;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\fragment\WalletFragmentStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */