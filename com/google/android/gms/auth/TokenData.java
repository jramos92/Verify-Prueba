package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int mVersionCode;
  private final Long zzRA;
  private final boolean zzRB;
  private final boolean zzRC;
  private final List<String> zzRD;
  private final String zzRz;
  
  TokenData(int paramInt, String paramString, Long paramLong, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzRz = zzx.zzcr(paramString);
    this.zzRA = paramLong;
    this.zzRB = paramBoolean1;
    this.zzRC = paramBoolean2;
    this.zzRD = paramList;
  }
  
  public static TokenData zza(Bundle paramBundle, String paramString)
  {
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    paramBundle = paramBundle.getBundle(paramString);
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    return (TokenData)paramBundle.getParcelable("TokenData");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TokenData)) {}
    do
    {
      return false;
      paramObject = (TokenData)paramObject;
    } while ((!TextUtils.equals(this.zzRz, ((TokenData)paramObject).zzRz)) || (!zzw.equal(this.zzRA, ((TokenData)paramObject).zzRA)) || (this.zzRB != ((TokenData)paramObject).zzRB) || (this.zzRC != ((TokenData)paramObject).zzRC) || (!zzw.equal(this.zzRD, ((TokenData)paramObject).zzRD)));
    return true;
  }
  
  public String getToken()
  {
    return this.zzRz;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzRz, this.zzRA, Boolean.valueOf(this.zzRB), Boolean.valueOf(this.zzRC), this.zzRD });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public Long zzlA()
  {
    return this.zzRA;
  }
  
  public boolean zzlB()
  {
    return this.zzRB;
  }
  
  public boolean zzlC()
  {
    return this.zzRC;
  }
  
  public List<String> zzlD()
  {
    return this.zzRD;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\TokenData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */