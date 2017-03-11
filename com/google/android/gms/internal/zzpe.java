package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.measurement.zze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzpe
  extends zze<zzpe>
{
  private ProductAction zzLI;
  private final Map<String, List<Product>> zzLJ = new HashMap();
  private final List<Promotion> zzLK = new ArrayList();
  private final List<Product> zzLL = new ArrayList();
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    if (!this.zzLL.isEmpty()) {
      localHashMap.put("products", this.zzLL);
    }
    if (!this.zzLK.isEmpty()) {
      localHashMap.put("promotions", this.zzLK);
    }
    if (!this.zzLJ.isEmpty()) {
      localHashMap.put("impressions", this.zzLJ);
    }
    localHashMap.put("productAction", this.zzLI);
    return zzB(localHashMap);
  }
  
  public void zza(Product paramProduct, String paramString)
  {
    if (paramProduct == null) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (!this.zzLJ.containsKey(str)) {
      this.zzLJ.put(str, new ArrayList());
    }
    ((List)this.zzLJ.get(str)).add(paramProduct);
  }
  
  public void zza(zzpe paramzzpe)
  {
    paramzzpe.zzLL.addAll(this.zzLL);
    paramzzpe.zzLK.addAll(this.zzLK);
    Iterator localIterator = this.zzLJ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramzzpe.zza((Product)((Iterator)localObject).next(), str);
      }
    }
    if (this.zzLI != null) {
      paramzzpe.zzLI = this.zzLI;
    }
  }
  
  public ProductAction zzyF()
  {
    return this.zzLI;
  }
  
  public List<Product> zzyG()
  {
    return Collections.unmodifiableList(this.zzLL);
  }
  
  public Map<String, List<Product>> zzyH()
  {
    return this.zzLJ;
  }
  
  public List<Promotion> zzyI()
  {
    return Collections.unmodifiableList(this.zzLK);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */