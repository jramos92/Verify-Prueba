package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents.zza;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.UsageInfo.zza;
import com.google.android.gms.appindexing.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zzjt
{
  private static DocumentSection zza(String paramString, zzox.zzc paramzzc)
  {
    paramString = new RegisterSectionInfo.zza(paramString).zzM(true).zzbB(paramString).zzbA("blob").zzlt();
    return new DocumentSection(zzse.zzf(paramzzc), paramString);
  }
  
  public static UsageInfo zza(Action paramAction, long paramLong, String paramString, int paramInt)
  {
    boolean bool = false;
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramAction.zzlx());
    Object localObject = localBundle.getBundle("object");
    int i;
    if (((Bundle)localObject).containsKey("id"))
    {
      paramAction = Uri.parse(((Bundle)localObject).getString("id"));
      String str1 = ((Bundle)localObject).getString("name");
      String str2 = ((Bundle)localObject).getString("type");
      localObject = zzju.zza(paramString, Uri.parse(((Bundle)localObject).getString("url")));
      paramAction = UsageInfo.zza((Intent)localObject, str1, paramAction, str2, null);
      if (localBundle.containsKey(".private:ssbContext"))
      {
        paramAction.zza(DocumentSection.zzh(localBundle.getByteArray(".private:ssbContext")));
        localBundle.remove(".private:ssbContext");
      }
      if (localBundle.containsKey(".private:accountName"))
      {
        paramAction.zzb(new Account(localBundle.getString(".private:accountName"), "com.google"));
        localBundle.remove(".private:accountName");
      }
      if ((!localBundle.containsKey(".private:isContextOnly")) || (!localBundle.getBoolean(".private:isContextOnly"))) {
        break label290;
      }
      i = 4;
      localBundle.remove(".private:isContextOnly");
    }
    for (;;)
    {
      if (localBundle.containsKey(".private:isDeviceOnly"))
      {
        bool = localBundle.getBoolean(".private:isDeviceOnly", false);
        localBundle.remove(".private:isDeviceOnly");
      }
      paramAction.zza(zza(".private:action", zzf(localBundle)));
      return new UsageInfo.zza().zza(UsageInfo.zza(paramString, (Intent)localObject)).zzw(paramLong).zzan(i).zza(paramAction.zzlo()).zzO(bool).zzao(paramInt).zzlv();
      paramAction = null;
      break;
      label290:
      i = 0;
    }
  }
  
  static zzox.zzc zzf(Bundle paramBundle)
  {
    zzox.zzc localzzc = new zzox.zzc();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      zzox.zzb localzzb = new zzox.zzb();
      localzzb.name = str;
      localzzb.zzaCZ = new zzox.zzd();
      if ((localObject instanceof String)) {
        localzzb.zzaCZ.zzagS = ((String)localObject);
      }
      for (;;)
      {
        localArrayList.add(localzzb);
        break;
        if ((localObject instanceof Bundle)) {
          localzzb.zzaCZ.zzaDe = zzf((Bundle)localObject);
        } else {
          Log.e("SearchIndex", "Unsupported value: " + localObject);
        }
      }
    }
    if (paramBundle.containsKey("type")) {
      localzzc.type = paramBundle.getString("type");
    }
    localzzc.zzaDa = ((zzox.zzb[])localArrayList.toArray(new zzox.zzb[localArrayList.size()]));
    return localzzc;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */