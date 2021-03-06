package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.Iterator;
import java.util.List;

public class zzc
  implements zzf<String>
{
  public <T> String zza(zzb<T> paramzzb, T paramT)
  {
    return String.format("contains(%s,%s)", new Object[] { paramzzb.getName(), paramT });
  }
  
  public <T> String zza(Operator paramOperator, MetadataField<T> paramMetadataField, T paramT)
  {
    return String.format("cmp(%s,%s,%s)", new Object[] { paramOperator.getTag(), paramMetadataField.getName(), paramT });
  }
  
  public String zza(Operator paramOperator, List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramOperator.getTag() + "(");
    paramList = paramList.iterator();
    for (paramOperator = ""; paramList.hasNext(); paramOperator = ",")
    {
      String str = (String)paramList.next();
      localStringBuilder.append(paramOperator);
      localStringBuilder.append(str);
    }
    return ")";
  }
  
  public <T> String zzc(MetadataField<T> paramMetadataField, T paramT)
  {
    return String.format("has(%s,%s)", new Object[] { paramMetadataField.getName(), paramT });
  }
  
  public String zzcJ(String paramString)
  {
    return String.format("not(%s)", new Object[] { paramString });
  }
  
  public String zzcK(String paramString)
  {
    return String.format("fullTextSearch(%s)", new Object[] { paramString });
  }
  
  public String zzd(MetadataField<?> paramMetadataField)
  {
    return String.format("fieldOnly(%s)", new Object[] { paramMetadataField.getName() });
  }
  
  public String zzrS()
  {
    return "all()";
  }
  
  public String zzrT()
  {
    return "ownedByMe()";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */