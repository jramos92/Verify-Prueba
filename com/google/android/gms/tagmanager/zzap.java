package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzap
  extends zzak
{
  private static final String ID = zzad.zzbN.toString();
  private static final String zzaWU = zzae.zzdz.toString();
  private static final String zzaWW = zzae.zzft.toString();
  private static final String zzaXa = zzae.zzdq.toString();
  
  public zzap()
  {
    super(ID, new String[] { zzaWU });
  }
  
  private byte[] zzd(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public boolean zzCo()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = (zzag.zza)paramMap.get(zzaWU);
    if ((localObject == null) || (localObject == zzdf.zzDX())) {
      return zzdf.zzDX();
    }
    String str = zzdf.zzg((zzag.zza)localObject);
    localObject = (zzag.zza)paramMap.get(zzaXa);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (zzag.zza)paramMap.get(zzaWW);
      if (paramMap != null) {
        break label110;
      }
      paramMap = "text";
      label73:
      if (!"text".equals(paramMap)) {
        break label118;
      }
      paramMap = str.getBytes();
    }
    for (;;)
    {
      try
      {
        paramMap = zzdf.zzQ(zzk.zzi(zzd((String)localObject, paramMap)));
        return paramMap;
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label110:
        label118:
        zzbg.e("Hash: unknown algorithm: " + (String)localObject);
      }
      localObject = zzdf.zzg((zzag.zza)localObject);
      break;
      paramMap = zzdf.zzg(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = zzk.zzez(str);
      }
      else
      {
        zzbg.e("Hash: unknown input format: " + paramMap);
        return zzdf.zzDX();
      }
    }
    return zzdf.zzDX();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */