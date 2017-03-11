package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();
  private final boolean mShowCancelButton;
  final int mVersionCode;
  private final boolean zzSn;
  
  CredentialPickerConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzSn = paramBoolean1;
    this.mShowCancelButton = paramBoolean2;
  }
  
  private CredentialPickerConfig(Builder paramBuilder)
  {
    this(1, Builder.zza(paramBuilder), Builder.zzb(paramBuilder));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean shouldShowAddAccountButton()
  {
    return this.zzSn;
  }
  
  public boolean shouldShowCancelButton()
  {
    return this.mShowCancelButton;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private boolean mShowCancelButton = true;
    private boolean zzSn = false;
    
    public CredentialPickerConfig build()
    {
      return new CredentialPickerConfig(this, null);
    }
    
    public Builder setShowAddAccountButton(boolean paramBoolean)
    {
      this.zzSn = paramBoolean;
      return this;
    }
    
    public Builder setShowCancelButton(boolean paramBoolean)
    {
      this.mShowCancelButton = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\credentials\CredentialPickerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */