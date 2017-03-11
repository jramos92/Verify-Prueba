package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class Credential
  implements SafeParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR = new zza();
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
  private final String mName;
  final int mVersionCode;
  private final Uri zzSh;
  private final List<IdToken> zzSi;
  private final String zzSj;
  private final String zzSk;
  private final String zzSl;
  private final String zzSm;
  private final String zzwN;
  
  Credential(int paramInt, String paramString1, String paramString2, Uri paramUri, List<IdToken> paramList, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.mVersionCode = paramInt;
    this.zzwN = ((String)zzx.zzw(paramString1));
    this.mName = paramString2;
    this.zzSh = paramUri;
    if (paramList == null) {}
    for (paramString1 = Collections.emptyList();; paramString1 = Collections.unmodifiableList(paramList))
    {
      this.zzSi = paramString1;
      this.zzSj = paramString3;
      this.zzSk = paramString4;
      this.zzSl = paramString5;
      this.zzSm = paramString6;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Credential)) {
        return false;
      }
      paramObject = (Credential)paramObject;
    } while ((TextUtils.equals(this.zzwN, ((Credential)paramObject).zzwN)) && (TextUtils.equals(this.mName, ((Credential)paramObject).mName)) && (zzw.equal(this.zzSh, ((Credential)paramObject).zzSh)) && (TextUtils.equals(this.zzSj, ((Credential)paramObject).zzSj)) && (TextUtils.equals(this.zzSk, ((Credential)paramObject).zzSk)) && (TextUtils.equals(this.zzSl, ((Credential)paramObject).zzSl)));
    return false;
  }
  
  public String getAccountType()
  {
    return this.zzSk;
  }
  
  public String getGeneratedPassword()
  {
    return this.zzSl;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public List<IdToken> getIdTokens()
  {
    return this.zzSi;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPassword()
  {
    return this.zzSj;
  }
  
  public Uri getProfilePictureUri()
  {
    return this.zzSh;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzwN, this.mName, this.zzSh, this.zzSj, this.zzSk, this.zzSl });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzlI()
  {
    return this.zzSm;
  }
  
  public static class Builder
  {
    private String mName;
    private Uri zzSh;
    private List<IdToken> zzSi;
    private String zzSj;
    private String zzSk;
    private String zzSl;
    private String zzSm;
    private final String zzwN;
    
    public Builder(Credential paramCredential)
    {
      this.zzwN = Credential.zza(paramCredential);
      this.mName = Credential.zzb(paramCredential);
      this.zzSh = Credential.zzc(paramCredential);
      this.zzSi = Credential.zzd(paramCredential);
      this.zzSj = Credential.zze(paramCredential);
      this.zzSk = Credential.zzf(paramCredential);
      this.zzSl = Credential.zzg(paramCredential);
      this.zzSm = Credential.zzh(paramCredential);
    }
    
    public Builder(String paramString)
    {
      this.zzwN = paramString;
    }
    
    public Credential build()
    {
      if ((!TextUtils.isEmpty(this.zzSj)) && (!TextUtils.isEmpty(this.zzSk))) {
        throw new IllegalStateException("Only one of password or accountType may be set");
      }
      return new Credential(3, this.zzwN, this.mName, this.zzSh, this.zzSi, this.zzSj, this.zzSk, this.zzSl, this.zzSm);
    }
    
    public Builder setAccountType(String paramString)
    {
      String str = Uri.parse(paramString).getScheme();
      if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str))) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzaa(bool);
        this.zzSk = paramString;
        return this;
      }
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setPassword(String paramString)
    {
      this.zzSj = paramString;
      return this;
    }
    
    public Builder setProfilePictureUri(Uri paramUri)
    {
      this.zzSh = paramUri;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\credentials\Credential.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */