package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
  private static final String[] zzazR = { "requestId", "outcome" };
  private final int zzYm;
  private final HashMap<String, Integer> zzazS;
  
  private RequestUpdateOutcomes(int paramInt, HashMap<String, Integer> paramHashMap)
  {
    this.zzYm = paramInt;
    this.zzazS = paramHashMap;
  }
  
  public static RequestUpdateOutcomes zzaa(DataHolder paramDataHolder)
  {
    Builder localBuilder = new Builder();
    localBuilder.zzgj(paramDataHolder.getStatusCode());
    int j = paramDataHolder.getCount();
    int i = 0;
    while (i < j)
    {
      int k = paramDataHolder.zzbt(i);
      localBuilder.zzx(paramDataHolder.zzd("requestId", i, k), paramDataHolder.zzc("outcome", i, k));
      i += 1;
    }
    return localBuilder.zzvF();
  }
  
  public Set<String> getRequestIds()
  {
    return this.zzazS.keySet();
  }
  
  public int getRequestOutcome(String paramString)
  {
    zzx.zzb(this.zzazS.containsKey(paramString), "Request " + paramString + " was not part of the update operation!");
    return ((Integer)this.zzazS.get(paramString)).intValue();
  }
  
  public static final class Builder
  {
    private int zzYm = 0;
    private HashMap<String, Integer> zzazS = new HashMap();
    
    public Builder zzgj(int paramInt)
    {
      this.zzYm = paramInt;
      return this;
    }
    
    public RequestUpdateOutcomes zzvF()
    {
      return new RequestUpdateOutcomes(this.zzYm, this.zzazS, null);
    }
    
    public Builder zzx(String paramString, int paramInt)
    {
      if (RequestUpdateResultOutcome.isValid(paramInt)) {
        this.zzazS.put(paramString, Integer.valueOf(paramInt));
      }
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\request\RequestUpdateOutcomes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */