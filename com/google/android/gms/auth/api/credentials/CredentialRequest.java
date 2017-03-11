package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzc();
  final int mVersionCode;
  private final boolean zzSo;
  private final String[] zzSp;
  private final CredentialPickerConfig zzSq;
  private final CredentialPickerConfig zzSr;
  
  CredentialRequest(int paramInt, boolean paramBoolean, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2)
  {
    this.mVersionCode = paramInt;
    this.zzSo = paramBoolean;
    this.zzSp = ((String[])zzx.zzw(paramArrayOfString));
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    this.zzSq = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    this.zzSr = paramArrayOfString;
  }
  
  private CredentialRequest(Builder paramBuilder)
  {
    this(2, Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String[] getAccountTypes()
  {
    return this.zzSp;
  }
  
  public CredentialPickerConfig getCredentialHintPickerConfig()
  {
    return this.zzSr;
  }
  
  public CredentialPickerConfig getCredentialPickerConfig()
  {
    return this.zzSq;
  }
  
  public boolean getSupportsPasswordLogin()
  {
    return this.zzSo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private boolean zzSo;
    private String[] zzSp;
    private CredentialPickerConfig zzSq;
    private CredentialPickerConfig zzSr;
    
    public CredentialRequest build()
    {
      if (this.zzSp == null) {
        this.zzSp = new String[0];
      }
      if ((!this.zzSo) && (this.zzSp.length == 0)) {
        throw new IllegalStateException("At least one authentication method must be specified");
      }
      return new CredentialRequest(this, null);
    }
    
    public Builder setAccountTypes(String... paramVarArgs)
    {
      this.zzSp = paramVarArgs;
      return this;
    }
    
    public Builder setCredentialHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzSr = paramCredentialPickerConfig;
      return this;
    }
    
    public Builder setCredentialPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzSq = paramCredentialPickerConfig;
      return this;
    }
    
    public Builder setSupportsPasswordLogin(boolean paramBoolean)
    {
      this.zzSo = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\credentials\CredentialRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */