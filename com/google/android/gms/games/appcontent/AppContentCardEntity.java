package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity
  implements SafeParcelable, AppContentCard
{
  public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
  private final ArrayList<AppContentActionEntity> mActions;
  private final Bundle mExtras;
  private final int mVersionCode;
  private final String zzGq;
  private final String zzajf;
  private final String zzaqZ;
  private final ArrayList<AppContentConditionEntity> zzauC;
  private final String zzauD;
  private final ArrayList<AppContentAnnotationEntity> zzauM;
  private final int zzauN;
  private final String zzauO;
  private final int zzauP;
  private final String zzwN;
  
  AppContentCardEntity(int paramInt1, ArrayList<AppContentActionEntity> paramArrayList, ArrayList<AppContentAnnotationEntity> paramArrayList1, ArrayList<AppContentConditionEntity> paramArrayList2, String paramString1, int paramInt2, String paramString2, Bundle paramBundle, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    this.mVersionCode = paramInt1;
    this.mActions = paramArrayList;
    this.zzauM = paramArrayList1;
    this.zzauC = paramArrayList2;
    this.zzauD = paramString1;
    this.zzauN = paramInt2;
    this.zzaqZ = paramString2;
    this.mExtras = paramBundle;
    this.zzwN = paramString6;
    this.zzauO = paramString3;
    this.zzajf = paramString4;
    this.zzauP = paramInt3;
    this.zzGq = paramString5;
  }
  
  public AppContentCardEntity(AppContentCard paramAppContentCard)
  {
    this.mVersionCode = 4;
    this.zzauD = paramAppContentCard.zztQ();
    this.zzauN = paramAppContentCard.zzub();
    this.zzaqZ = paramAppContentCard.getDescription();
    this.mExtras = paramAppContentCard.getExtras();
    this.zzwN = paramAppContentCard.getId();
    this.zzajf = paramAppContentCard.getTitle();
    this.zzauO = paramAppContentCard.zzuc();
    this.zzauP = paramAppContentCard.zzud();
    this.zzGq = paramAppContentCard.getType();
    List localList = paramAppContentCard.getActions();
    int k = localList.size();
    this.mActions = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      this.mActions.add((AppContentActionEntity)((AppContentAction)localList.get(i)).freeze());
      i += 1;
    }
    localList = paramAppContentCard.zzua();
    k = localList.size();
    this.zzauM = new ArrayList(k);
    i = 0;
    while (i < k)
    {
      this.zzauM.add((AppContentAnnotationEntity)((AppContentAnnotation)localList.get(i)).freeze());
      i += 1;
    }
    paramAppContentCard = paramAppContentCard.zztP();
    k = paramAppContentCard.size();
    this.zzauC = new ArrayList(k);
    i = j;
    while (i < k)
    {
      this.zzauC.add((AppContentConditionEntity)((AppContentCondition)paramAppContentCard.get(i)).freeze());
      i += 1;
    }
  }
  
  static int zza(AppContentCard paramAppContentCard)
  {
    return zzw.hashCode(new Object[] { paramAppContentCard.getActions(), paramAppContentCard.zzua(), paramAppContentCard.zztP(), paramAppContentCard.zztQ(), Integer.valueOf(paramAppContentCard.zzub()), paramAppContentCard.getDescription(), paramAppContentCard.getExtras(), paramAppContentCard.getId(), paramAppContentCard.zzuc(), paramAppContentCard.getTitle(), Integer.valueOf(paramAppContentCard.zzud()), paramAppContentCard.getType() });
  }
  
  static boolean zza(AppContentCard paramAppContentCard, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentCard)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentCard == paramObject);
      paramObject = (AppContentCard)paramObject;
      if ((!zzw.equal(((AppContentCard)paramObject).getActions(), paramAppContentCard.getActions())) || (!zzw.equal(((AppContentCard)paramObject).zzua(), paramAppContentCard.zzua())) || (!zzw.equal(((AppContentCard)paramObject).zztP(), paramAppContentCard.zztP())) || (!zzw.equal(((AppContentCard)paramObject).zztQ(), paramAppContentCard.zztQ())) || (!zzw.equal(Integer.valueOf(((AppContentCard)paramObject).zzub()), Integer.valueOf(paramAppContentCard.zzub()))) || (!zzw.equal(((AppContentCard)paramObject).getDescription(), paramAppContentCard.getDescription())) || (!zzw.equal(((AppContentCard)paramObject).getExtras(), paramAppContentCard.getExtras())) || (!zzw.equal(((AppContentCard)paramObject).getId(), paramAppContentCard.getId())) || (!zzw.equal(((AppContentCard)paramObject).zzuc(), paramAppContentCard.zzuc())) || (!zzw.equal(((AppContentCard)paramObject).getTitle(), paramAppContentCard.getTitle())) || (!zzw.equal(Integer.valueOf(((AppContentCard)paramObject).zzud()), Integer.valueOf(paramAppContentCard.zzud())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentCard)paramObject).getType(), paramAppContentCard.getType()));
    return false;
  }
  
  static String zzb(AppContentCard paramAppContentCard)
  {
    return zzw.zzv(paramAppContentCard).zzg("Actions", paramAppContentCard.getActions()).zzg("Annotations", paramAppContentCard.zzua()).zzg("Conditions", paramAppContentCard.zztP()).zzg("ContentDescription", paramAppContentCard.zztQ()).zzg("CurrentSteps", Integer.valueOf(paramAppContentCard.zzub())).zzg("Description", paramAppContentCard.getDescription()).zzg("Extras", paramAppContentCard.getExtras()).zzg("Id", paramAppContentCard.getId()).zzg("Subtitle", paramAppContentCard.zzuc()).zzg("Title", paramAppContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(paramAppContentCard.zzud())).zzg("Type", paramAppContentCard.getType()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public List<AppContentAction> getActions()
  {
    return new ArrayList(this.mActions);
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public String getTitle()
  {
    return this.zzajf;
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
    AppContentCardEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public List<AppContentCondition> zztP()
  {
    return new ArrayList(this.zzauC);
  }
  
  public String zztQ()
  {
    return this.zzauD;
  }
  
  public List<AppContentAnnotation> zzua()
  {
    return new ArrayList(this.zzauM);
  }
  
  public int zzub()
  {
    return this.zzauN;
  }
  
  public String zzuc()
  {
    return this.zzauO;
  }
  
  public int zzud()
  {
    return this.zzauP;
  }
  
  public AppContentCard zzue()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentCardEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */