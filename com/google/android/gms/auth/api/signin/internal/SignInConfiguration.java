package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SignInConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzh();
  private static int zzTr = 31;
  final int versionCode;
  private String zzTl;
  private final String zzTs;
  private EmailSignInConfig zzTt;
  private GoogleSignInConfig zzTu;
  private FacebookSignInConfig zzTv;
  private String zzTw;
  
  SignInConfiguration(int paramInt, String paramString1, String paramString2, EmailSignInConfig paramEmailSignInConfig, GoogleSignInConfig paramGoogleSignInConfig, FacebookSignInConfig paramFacebookSignInConfig, String paramString3)
  {
    this.versionCode = paramInt;
    this.zzTs = zzx.zzcr(paramString1);
    this.zzTl = paramString2;
    this.zzTt = paramEmailSignInConfig;
    this.zzTu = paramGoogleSignInConfig;
    this.zzTv = paramFacebookSignInConfig;
    this.zzTw = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (SignInConfiguration)paramObject;
        if (this.zzTs.equals(((SignInConfiguration)paramObject).zzme()))
        {
          if (TextUtils.isEmpty(this.zzTl))
          {
            if (!TextUtils.isEmpty(((SignInConfiguration)paramObject).zzmb())) {
              continue;
            }
            label45:
            if (!TextUtils.isEmpty(this.zzTw)) {
              break label127;
            }
            if (!TextUtils.isEmpty(((SignInConfiguration)paramObject).zzmi())) {
              continue;
            }
            label65:
            if (this.zzTt != null) {
              break label144;
            }
            if (((SignInConfiguration)paramObject).zzmf() != null) {
              continue;
            }
            label79:
            if (this.zzTv != null) {
              break label161;
            }
            if (((SignInConfiguration)paramObject).zzmh() != null) {
              continue;
            }
          }
          for (;;)
          {
            if (this.zzTu != null) {
              break label178;
            }
            if (((SignInConfiguration)paramObject).zzmg() != null) {
              break;
            }
            break label200;
            if (!this.zzTl.equals(((SignInConfiguration)paramObject).zzmb())) {
              break;
            }
            break label45;
            label127:
            if (!this.zzTw.equals(((SignInConfiguration)paramObject).zzmi())) {
              break;
            }
            break label65;
            label144:
            if (!this.zzTt.equals(((SignInConfiguration)paramObject).zzmf())) {
              break;
            }
            break label79;
            label161:
            if (!this.zzTv.equals(((SignInConfiguration)paramObject).zzmh())) {
              break;
            }
          }
          label178:
          boolean bool = this.zzTu.equals(((SignInConfiguration)paramObject).zzmg());
          if (!bool) {}
        }
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
    }
    label200:
    return true;
  }
  
  public int hashCode()
  {
    return new zzc().zzl(this.zzTs).zzl(this.zzTl).zzl(this.zzTw).zzl(this.zzTt).zzl(this.zzTu).zzl(this.zzTv).zzmd();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzmb()
  {
    return this.zzTl;
  }
  
  public String zzme()
  {
    return this.zzTs;
  }
  
  public EmailSignInConfig zzmf()
  {
    return this.zzTt;
  }
  
  public GoogleSignInConfig zzmg()
  {
    return this.zzTu;
  }
  
  public FacebookSignInConfig zzmh()
  {
    return this.zzTv;
  }
  
  public String zzmi()
  {
    return this.zzTw;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\SignInConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */