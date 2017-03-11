package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity
  implements SafeParcelable, AppContentAction
{
  public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
  private final Bundle mExtras;
  private final int mVersionCode;
  private final String zzGq;
  private final ArrayList<AppContentConditionEntity> zzauC;
  private final String zzauD;
  private final AppContentAnnotationEntity zzauE;
  private final String zzauF;
  private final String zzwN;
  
  AppContentActionEntity(int paramInt, ArrayList<AppContentConditionEntity> paramArrayList, String paramString1, Bundle paramBundle, String paramString2, String paramString3, AppContentAnnotationEntity paramAppContentAnnotationEntity, String paramString4)
  {
    this.mVersionCode = paramInt;
    this.zzauE = paramAppContentAnnotationEntity;
    this.zzauC = paramArrayList;
    this.zzauD = paramString1;
    this.mExtras = paramBundle;
    this.zzwN = paramString3;
    this.zzauF = paramString4;
    this.zzGq = paramString2;
  }
  
  public AppContentActionEntity(AppContentAction paramAppContentAction)
  {
    this.mVersionCode = 5;
    this.zzauE = ((AppContentAnnotationEntity)paramAppContentAction.zztO().freeze());
    this.zzauD = paramAppContentAction.zztQ();
    this.mExtras = paramAppContentAction.getExtras();
    this.zzwN = paramAppContentAction.getId();
    this.zzauF = paramAppContentAction.zztR();
    this.zzGq = paramAppContentAction.getType();
    paramAppContentAction = paramAppContentAction.zztP();
    int j = paramAppContentAction.size();
    this.zzauC = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.zzauC.add((AppContentConditionEntity)((AppContentCondition)paramAppContentAction.get(i)).freeze());
      i += 1;
    }
  }
  
  static int zza(AppContentAction paramAppContentAction)
  {
    return zzw.hashCode(new Object[] { paramAppContentAction.zztO(), paramAppContentAction.zztP(), paramAppContentAction.zztQ(), paramAppContentAction.getExtras(), paramAppContentAction.getId(), paramAppContentAction.zztR(), paramAppContentAction.getType() });
  }
  
  static boolean zza(AppContentAction paramAppContentAction, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentAction)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentAction == paramObject);
      paramObject = (AppContentAction)paramObject;
      if ((!zzw.equal(((AppContentAction)paramObject).zztO(), paramAppContentAction.zztO())) || (!zzw.equal(((AppContentAction)paramObject).zztP(), paramAppContentAction.zztP())) || (!zzw.equal(((AppContentAction)paramObject).zztQ(), paramAppContentAction.zztQ())) || (!zzw.equal(((AppContentAction)paramObject).getExtras(), paramAppContentAction.getExtras())) || (!zzw.equal(((AppContentAction)paramObject).getId(), paramAppContentAction.getId())) || (!zzw.equal(((AppContentAction)paramObject).zztR(), paramAppContentAction.zztR()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentAction)paramObject).getType(), paramAppContentAction.getType()));
    return false;
  }
  
  static String zzb(AppContentAction paramAppContentAction)
  {
    return zzw.zzv(paramAppContentAction).zzg("Annotation", paramAppContentAction.zztO()).zzg("Conditions", paramAppContentAction.zztP()).zzg("ContentDescription", paramAppContentAction.zztQ()).zzg("Extras", paramAppContentAction.getExtras()).zzg("Id", paramAppContentAction.getId()).zzg("OverflowText", paramAppContentAction.zztR()).zzg("Type", paramAppContentAction.getType()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public String getType()
  {
    return this.zzGq;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppContentActionEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public AppContentAnnotation zztO()
  {
    return this.zzauE;
  }
  
  public List<AppContentCondition> zztP()
  {
    return new ArrayList(this.zzauC);
  }
  
  public String zztQ()
  {
    return this.zzauD;
  }
  
  public String zztR()
  {
    return this.zzauF;
  }
  
  public AppContentAction zztS()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentActionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */