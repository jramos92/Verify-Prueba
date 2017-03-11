package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj
  extends zzdd
{
  private static final String ID = zzad.zzco.toString();
  private static final String URL = zzae.zzhx.toString();
  private static final String zzaVJ = zzae.zzdn.toString();
  private static final String zzaVK = zzae.zzhw.toString();
  static final String zzaVL = "gtm_" + ID + "_unrepeatable";
  private static final Set<String> zzaVM = new HashSet();
  private final Context mContext;
  private final zza zzaVN;
  
  public zzj(Context paramContext)
  {
    this(paramContext, new zza()
    {
      public zzar zzCp()
      {
        return zzz.zzaO(zzj.this);
      }
    });
  }
  
  zzj(Context paramContext, zza paramzza)
  {
    super(ID, new String[] { URL });
    this.zzaVN = paramzza;
    this.mContext = paramContext;
  }
  
  private boolean zzew(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = zzey(paramString);
        if (bool2) {
          return bool1;
        }
        if (zzex(paramString)) {
          zzaVM.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public void zzK(Map<String, zzag.zza> paramMap)
  {
    String str;
    if (paramMap.get(zzaVK) != null)
    {
      str = zzdf.zzg((zzag.zza)paramMap.get(zzaVK));
      if ((str == null) || (!zzew(str))) {
        break label46;
      }
    }
    label46:
    do
    {
      return;
      str = null;
      break;
      Uri.Builder localBuilder = Uri.parse(zzdf.zzg((zzag.zza)paramMap.get(URL))).buildUpon();
      paramMap = (zzag.zza)paramMap.get(zzaVJ);
      if (paramMap != null)
      {
        paramMap = zzdf.zzl(paramMap);
        if (!(paramMap instanceof List))
        {
          zzbg.e("ArbitraryPixel: additional params not a list: not sending partial hit: " + localBuilder.build().toString());
          return;
        }
        paramMap = ((List)paramMap).iterator();
        while (paramMap.hasNext())
        {
          Object localObject = paramMap.next();
          if (!(localObject instanceof Map))
          {
            zzbg.e("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + localBuilder.build().toString());
            return;
          }
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            localBuilder.appendQueryParameter(localEntry.getKey().toString(), localEntry.getValue().toString());
          }
        }
      }
      paramMap = localBuilder.build().toString();
      this.zzaVN.zzCp().zzeN(paramMap);
      zzbg.v("ArbitraryPixel: url = " + paramMap);
    } while (str == null);
    try
    {
      zzaVM.add(str);
      zzcv.zzb(this.mContext, zzaVL, str, "true");
      return;
    }
    finally {}
  }
  
  boolean zzex(String paramString)
  {
    return this.mContext.getSharedPreferences(zzaVL, 0).contains(paramString);
  }
  
  boolean zzey(String paramString)
  {
    return zzaVM.contains(paramString);
  }
  
  public static abstract interface zza
  {
    public abstract zzar zzCp();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */