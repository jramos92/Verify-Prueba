package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class AppContentAnnotationEntity
  implements SafeParcelable, AppContentAnnotation
{
  public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
  private final int mVersionCode;
  private final String zzajf;
  private final String zzaqZ;
  private final Uri zzauG;
  private final String zzauH;
  private final String zzauI;
  private final int zzauJ;
  private final int zzauK;
  private final Bundle zzauL;
  private final String zzwN;
  
  AppContentAnnotationEntity(int paramInt1, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    this.mVersionCode = paramInt1;
    this.zzaqZ = paramString1;
    this.zzwN = paramString3;
    this.zzauI = paramString5;
    this.zzauJ = paramInt2;
    this.zzauG = paramUri;
    this.zzauK = paramInt3;
    this.zzauH = paramString4;
    this.zzauL = paramBundle;
    this.zzajf = paramString2;
  }
  
  public AppContentAnnotationEntity(AppContentAnnotation paramAppContentAnnotation)
  {
    this.mVersionCode = 4;
    this.zzaqZ = paramAppContentAnnotation.getDescription();
    this.zzwN = paramAppContentAnnotation.getId();
    this.zzauI = paramAppContentAnnotation.zztT();
    this.zzauJ = paramAppContentAnnotation.zztU();
    this.zzauG = paramAppContentAnnotation.zztV();
    this.zzauK = paramAppContentAnnotation.zztX();
    this.zzauH = paramAppContentAnnotation.zztY();
    this.zzauL = paramAppContentAnnotation.zztW();
    this.zzajf = paramAppContentAnnotation.getTitle();
  }
  
  static int zza(AppContentAnnotation paramAppContentAnnotation)
  {
    return zzw.hashCode(new Object[] { paramAppContentAnnotation.getDescription(), paramAppContentAnnotation.getId(), paramAppContentAnnotation.zztT(), Integer.valueOf(paramAppContentAnnotation.zztU()), paramAppContentAnnotation.zztV(), Integer.valueOf(paramAppContentAnnotation.zztX()), paramAppContentAnnotation.zztY(), paramAppContentAnnotation.zztW(), paramAppContentAnnotation.getTitle() });
  }
  
  static boolean zza(AppContentAnnotation paramAppContentAnnotation, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentAnnotation)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentAnnotation == paramObject);
      paramObject = (AppContentAnnotation)paramObject;
      if ((!zzw.equal(((AppContentAnnotation)paramObject).getDescription(), paramAppContentAnnotation.getDescription())) || (!zzw.equal(((AppContentAnnotation)paramObject).getId(), paramAppContentAnnotation.getId())) || (!zzw.equal(((AppContentAnnotation)paramObject).zztT(), paramAppContentAnnotation.zztT())) || (!zzw.equal(Integer.valueOf(((AppContentAnnotation)paramObject).zztU()), Integer.valueOf(paramAppContentAnnotation.zztU()))) || (!zzw.equal(((AppContentAnnotation)paramObject).zztV(), paramAppContentAnnotation.zztV())) || (!zzw.equal(Integer.valueOf(((AppContentAnnotation)paramObject).zztX()), Integer.valueOf(paramAppContentAnnotation.zztX()))) || (!zzw.equal(((AppContentAnnotation)paramObject).zztY(), paramAppContentAnnotation.zztY())) || (!zzw.equal(((AppContentAnnotation)paramObject).zztW(), paramAppContentAnnotation.zztW()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentAnnotation)paramObject).getTitle(), paramAppContentAnnotation.getTitle()));
    return false;
  }
  
  static String zzb(AppContentAnnotation paramAppContentAnnotation)
  {
    return zzw.zzv(paramAppContentAnnotation).zzg("Description", paramAppContentAnnotation.getDescription()).zzg("Id", paramAppContentAnnotation.getId()).zzg("ImageDefaultId", paramAppContentAnnotation.zztT()).zzg("ImageHeight", Integer.valueOf(paramAppContentAnnotation.zztU())).zzg("ImageUri", paramAppContentAnnotation.zztV()).zzg("ImageWidth", Integer.valueOf(paramAppContentAnnotation.zztX())).zzg("LayoutSlot", paramAppContentAnnotation.zztY()).zzg("Modifiers", paramAppContentAnnotation.zztW()).zzg("Title", paramAppContentAnnotation.getTitle()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public String getTitle()
  {
    return this.zzajf;
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
    AppContentAnnotationEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zztT()
  {
    return this.zzauI;
  }
  
  public int zztU()
  {
    return this.zzauJ;
  }
  
  public Uri zztV()
  {
    return this.zzauG;
  }
  
  public Bundle zztW()
  {
    return this.zzauL;
  }
  
  public int zztX()
  {
    return this.zzauK;
  }
  
  public String zztY()
  {
    return this.zzauH;
  }
  
  public AppContentAnnotation zztZ()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentAnnotationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */