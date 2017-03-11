package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MomentEntity
  extends FastSafeParcelableJsonResponse
  implements Moment
{
  public static final zzb CREATOR = new zzb();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
  final int mVersionCode;
  String zzGq;
  final Set<Integer> zzaST;
  String zzaTG;
  ItemScopeEntity zzaTO;
  ItemScopeEntity zzaTP;
  String zzwN;
  
  static
  {
    zzaSS.put("id", FastJsonResponse.Field.zzm("id", 2));
    zzaSS.put("result", FastJsonResponse.Field.zza("result", 4, ItemScopeEntity.class));
    zzaSS.put("startDate", FastJsonResponse.Field.zzm("startDate", 5));
    zzaSS.put("target", FastJsonResponse.Field.zza("target", 6, ItemScopeEntity.class));
    zzaSS.put("type", FastJsonResponse.Field.zzm("type", 7));
  }
  
  public MomentEntity()
  {
    this.mVersionCode = 1;
    this.zzaST = new HashSet();
  }
  
  MomentEntity(Set<Integer> paramSet, int paramInt, String paramString1, ItemScopeEntity paramItemScopeEntity1, String paramString2, ItemScopeEntity paramItemScopeEntity2, String paramString3)
  {
    this.zzaST = paramSet;
    this.mVersionCode = paramInt;
    this.zzwN = paramString1;
    this.zzaTO = paramItemScopeEntity1;
    this.zzaTG = paramString2;
    this.zzaTP = paramItemScopeEntity2;
    this.zzGq = paramString3;
  }
  
  public MomentEntity(Set<Integer> paramSet, String paramString1, ItemScopeEntity paramItemScopeEntity1, String paramString2, ItemScopeEntity paramItemScopeEntity2, String paramString3)
  {
    this.zzaST = paramSet;
    this.mVersionCode = 1;
    this.zzwN = paramString1;
    this.zzaTO = paramItemScopeEntity1;
    this.zzaTG = paramString2;
    this.zzaTP = paramItemScopeEntity2;
    this.zzGq = paramString3;
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MomentEntity)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (MomentEntity)paramObject;
    Iterator localIterator = zzaSS.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (zza(localField))
      {
        if (((MomentEntity)paramObject).zza(localField))
        {
          if (!zzb(localField).equals(((MomentEntity)paramObject).zzb(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((MomentEntity)paramObject).zza(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public ItemScope getResult()
  {
    return this.zzaTO;
  }
  
  public String getStartDate()
  {
    return this.zzaTG;
  }
  
  public ItemScope getTarget()
  {
    return this.zzaTP;
  }
  
  public String getType()
  {
    return this.zzGq;
  }
  
  public boolean hasId()
  {
    return this.zzaST.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.zzaST.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.zzaST.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.zzaST.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
  {
    return this.zzaST.contains(Integer.valueOf(7));
  }
  
  public int hashCode()
  {
    Iterator localIterator = zzaSS.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!zza(localField)) {
        break label68;
      }
      int j = localField.zzpK();
      i = zzb(localField).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
  {
    return zzaSS;
  }
  
  public MomentEntity zzBM()
  {
    return this;
  }
  
  protected boolean zza(FastJsonResponse.Field paramField)
  {
    return this.zzaST.contains(Integer.valueOf(paramField.zzpK()));
  }
  
  protected Object zzb(FastJsonResponse.Field paramField)
  {
    switch (paramField.zzpK())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
    case 2: 
      return this.zzwN;
    case 4: 
      return this.zzaTO;
    case 5: 
      return this.zzaTG;
    case 6: 
      return this.zzaTP;
    }
    return this.zzGq;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\model\moments\MomentEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */