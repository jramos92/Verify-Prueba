package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzp
  extends zzj<UserMetadata>
{
  public zzp(String paramString, int paramInt)
  {
    super(paramString, zzcI(paramString), Collections.emptyList(), paramInt);
  }
  
  private static String zzA(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2;
  }
  
  private String zzcH(String paramString)
  {
    return zzA(getName(), paramString);
  }
  
  private static Collection<String> zzcI(String paramString)
  {
    return Arrays.asList(new String[] { zzA(paramString, "permissionId"), zzA(paramString, "displayName"), zzA(paramString, "picture"), zzA(paramString, "isAuthenticatedUser"), zzA(paramString, "emailAddress") });
  }
  
  protected boolean zzb(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return (paramDataHolder.zzce(zzcH("permissionId"))) && (!paramDataHolder.zzi(zzcH("permissionId"), paramInt1, paramInt2));
  }
  
  protected UserMetadata zzj(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    String str1 = paramDataHolder.zzd(zzcH("permissionId"), paramInt1, paramInt2);
    if (str1 != null)
    {
      String str2 = paramDataHolder.zzd(zzcH("displayName"), paramInt1, paramInt2);
      String str3 = paramDataHolder.zzd(zzcH("picture"), paramInt1, paramInt2);
      boolean bool = paramDataHolder.zze(zzcH("isAuthenticatedUser"), paramInt1, paramInt2);
      paramDataHolder = paramDataHolder.zzd(zzcH("emailAddress"), paramInt1, paramInt2);
      return new UserMetadata(str1, str2, str3, Boolean.valueOf(bool).booleanValue(), paramDataHolder);
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */