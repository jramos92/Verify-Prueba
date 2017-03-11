package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzqx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzf
{
  private final Account zzQd;
  private final String zzRq;
  private final Set<Scope> zzaaF;
  private final int zzaaG;
  private final View zzaaH;
  private final String zzaaI;
  private final zzqx zzaaT;
  private final Set<Scope> zzafh;
  private final Map<Api<?>, zza> zzafi;
  private Integer zzafj;
  
  public zzf(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzqx paramzzqx)
  {
    this.zzQd = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      this.zzaaF = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      this.zzafi = paramAccount;
      this.zzaaH = paramView;
      this.zzaaG = paramInt;
      this.zzRq = paramString1;
      this.zzaaI = paramString2;
      this.zzaaT = paramzzqx;
      paramAccount = new HashSet(this.zzaaF);
      paramSet = this.zzafi.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(((zza)paramSet.next()).zzTm);
      }
    }
    this.zzafh = Collections.unmodifiableSet(paramAccount);
  }
  
  public static zzf zzak(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).zznB();
  }
  
  public Account getAccount()
  {
    return this.zzQd;
  }
  
  @Deprecated
  public String getAccountName()
  {
    if (this.zzQd != null) {
      return this.zzQd.name;
    }
    return null;
  }
  
  public void zza(Integer paramInteger)
  {
    this.zzafj = paramInteger;
  }
  
  public Set<Scope> zzb(Api<?> paramApi)
  {
    paramApi = (zza)this.zzafi.get(paramApi);
    if ((paramApi == null) || (paramApi.zzTm.isEmpty())) {
      return this.zzaaF;
    }
    HashSet localHashSet = new HashSet(this.zzaaF);
    localHashSet.addAll(paramApi.zzTm);
    return localHashSet;
  }
  
  public Account zzoI()
  {
    if (this.zzQd != null) {
      return this.zzQd;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public int zzoJ()
  {
    return this.zzaaG;
  }
  
  public Set<Scope> zzoK()
  {
    return this.zzaaF;
  }
  
  public Set<Scope> zzoL()
  {
    return this.zzafh;
  }
  
  public Map<Api<?>, zza> zzoM()
  {
    return this.zzafi;
  }
  
  public String zzoN()
  {
    return this.zzRq;
  }
  
  public String zzoO()
  {
    return this.zzaaI;
  }
  
  public View zzoP()
  {
    return this.zzaaH;
  }
  
  public zzqx zzoQ()
  {
    return this.zzaaT;
  }
  
  public Integer zzoR()
  {
    return this.zzafj;
  }
  
  public static final class zza
  {
    public final Set<Scope> zzTm;
    public final boolean zzafk;
    
    public zza(Set<Scope> paramSet, boolean paramBoolean)
    {
      zzx.zzw(paramSet);
      this.zzTm = Collections.unmodifiableSet(paramSet);
      this.zzafk = paramBoolean;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */