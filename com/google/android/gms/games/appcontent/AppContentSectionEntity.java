package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity
  implements SafeParcelable, AppContentSection
{
  public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
  private final ArrayList<AppContentActionEntity> mActions;
  private final Bundle mExtras;
  private final int mVersionCode;
  private final String zzGq;
  private final String zzajf;
  private final String zzauD;
  private final ArrayList<AppContentAnnotationEntity> zzauM;
  private final String zzauO;
  private final ArrayList<AppContentCardEntity> zzauV;
  private final String zzauW;
  private final String zzwN;
  
  AppContentSectionEntity(int paramInt, ArrayList<AppContentActionEntity> paramArrayList, ArrayList<AppContentCardEntity> paramArrayList1, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList<AppContentAnnotationEntity> paramArrayList2)
  {
    this.mVersionCode = paramInt;
    this.mActions = paramArrayList;
    this.zzauM = paramArrayList2;
    this.zzauV = paramArrayList1;
    this.zzauW = paramString6;
    this.zzauD = paramString1;
    this.mExtras = paramBundle;
    this.zzwN = paramString5;
    this.zzauO = paramString2;
    this.zzajf = paramString3;
    this.zzGq = paramString4;
  }
  
  public AppContentSectionEntity(AppContentSection paramAppContentSection)
  {
    this.mVersionCode = 5;
    this.zzauW = paramAppContentSection.zzul();
    this.zzauD = paramAppContentSection.zztQ();
    this.mExtras = paramAppContentSection.getExtras();
    this.zzwN = paramAppContentSection.getId();
    this.zzauO = paramAppContentSection.zzuc();
    this.zzajf = paramAppContentSection.getTitle();
    this.zzGq = paramAppContentSection.getType();
    List localList = paramAppContentSection.getActions();
    int k = localList.size();
    this.mActions = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      this.mActions.add((AppContentActionEntity)((AppContentAction)localList.get(i)).freeze());
      i += 1;
    }
    localList = paramAppContentSection.zzuk();
    k = localList.size();
    this.zzauV = new ArrayList(k);
    i = 0;
    while (i < k)
    {
      this.zzauV.add((AppContentCardEntity)((AppContentCard)localList.get(i)).freeze());
      i += 1;
    }
    paramAppContentSection = paramAppContentSection.zzua();
    k = paramAppContentSection.size();
    this.zzauM = new ArrayList(k);
    i = j;
    while (i < k)
    {
      this.zzauM.add((AppContentAnnotationEntity)((AppContentAnnotation)paramAppContentSection.get(i)).freeze());
      i += 1;
    }
  }
  
  static int zza(AppContentSection paramAppContentSection)
  {
    return zzw.hashCode(new Object[] { paramAppContentSection.getActions(), paramAppContentSection.zzua(), paramAppContentSection.zzuk(), paramAppContentSection.zzul(), paramAppContentSection.zztQ(), paramAppContentSection.getExtras(), paramAppContentSection.getId(), paramAppContentSection.zzuc(), paramAppContentSection.getTitle(), paramAppContentSection.getType() });
  }
  
  static boolean zza(AppContentSection paramAppContentSection, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentSection)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentSection == paramObject);
      paramObject = (AppContentSection)paramObject;
      if ((!zzw.equal(((AppContentSection)paramObject).getActions(), paramAppContentSection.getActions())) || (!zzw.equal(((AppContentSection)paramObject).zzua(), paramAppContentSection.zzua())) || (!zzw.equal(((AppContentSection)paramObject).zzuk(), paramAppContentSection.zzuk())) || (!zzw.equal(((AppContentSection)paramObject).zzul(), paramAppContentSection.zzul())) || (!zzw.equal(((AppContentSection)paramObject).zztQ(), paramAppContentSection.zztQ())) || (!zzw.equal(((AppContentSection)paramObject).getExtras(), paramAppContentSection.getExtras())) || (!zzw.equal(((AppContentSection)paramObject).getId(), paramAppContentSection.getId())) || (!zzw.equal(((AppContentSection)paramObject).zzuc(), paramAppContentSection.zzuc())) || (!zzw.equal(((AppContentSection)paramObject).getTitle(), paramAppContentSection.getTitle()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentSection)paramObject).getType(), paramAppContentSection.getType()));
    return false;
  }
  
  static String zzb(AppContentSection paramAppContentSection)
  {
    return zzw.zzv(paramAppContentSection).zzg("Actions", paramAppContentSection.getActions()).zzg("Annotations", paramAppContentSection.zzua()).zzg("Cards", paramAppContentSection.zzuk()).zzg("CardType", paramAppContentSection.zzul()).zzg("ContentDescription", paramAppContentSection.zztQ()).zzg("Extras", paramAppContentSection.getExtras()).zzg("Id", paramAppContentSection.getId()).zzg("Subtitle", paramAppContentSection.zzuc()).zzg("Title", paramAppContentSection.getTitle()).zzg("Type", paramAppContentSection.getType()).toString();
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
    AppContentSectionEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zztQ()
  {
    return this.zzauD;
  }
  
  public List<AppContentAnnotation> zzua()
  {
    return new ArrayList(this.zzauM);
  }
  
  public String zzuc()
  {
    return this.zzauO;
  }
  
  public List<AppContentCard> zzuk()
  {
    return new ArrayList(this.zzauV);
  }
  
  public String zzul()
  {
    return this.zzauW;
  }
  
  public AppContentSection zzum()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentSectionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */