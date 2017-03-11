package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSignInConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<EmailSignInConfig> CREATOR = new zza();
  final int versionCode;
  private final Uri zzSU;
  private String zzSV;
  private Uri zzSW;
  
  EmailSignInConfig(int paramInt, Uri paramUri1, String paramString, Uri paramUri2)
  {
    zzx.zzb(paramUri1, "Server widget url cannot be null in order to use email/password sign in.");
    zzx.zzh(paramUri1.toString(), "Server widget url cannot be null in order to use email/password sign in.");
    zzx.zzb(Patterns.WEB_URL.matcher(paramUri1.toString()).matches(), "Invalid server widget url");
    this.versionCode = paramInt;
    this.zzSU = paramUri1;
    this.zzSV = paramString;
    this.zzSW = paramUri2;
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
        paramObject = (EmailSignInConfig)paramObject;
        if (this.zzSU.equals(((EmailSignInConfig)paramObject).zzlO())) {
          if (this.zzSW == null)
          {
            if (((EmailSignInConfig)paramObject).zzlP() != null) {}
          }
          else
          {
            for (;;)
            {
              if (!TextUtils.isEmpty(this.zzSV)) {
                break label79;
              }
              if (!TextUtils.isEmpty(((EmailSignInConfig)paramObject).zzlQ())) {
                break;
              }
              break label101;
              if (!this.zzSW.equals(((EmailSignInConfig)paramObject).zzlP())) {
                break;
              }
            }
            label79:
            boolean bool = this.zzSV.equals(((EmailSignInConfig)paramObject).zzlQ());
            if (!bool) {}
          }
        }
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
    }
    label101:
    return true;
  }
  
  public int hashCode()
  {
    return new zzc().zzl(this.zzSU).zzl(this.zzSW).zzl(this.zzSV).zzmd();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public Uri zzlO()
  {
    return this.zzSU;
  }
  
  public Uri zzlP()
  {
    return this.zzSW;
  }
  
  public String zzlQ()
  {
    return this.zzSV;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\signin\EmailSignInConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */