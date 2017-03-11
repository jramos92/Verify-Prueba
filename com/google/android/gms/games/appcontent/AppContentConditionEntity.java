package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class AppContentConditionEntity
  implements SafeParcelable, AppContentCondition
{
  public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
  private final int mVersionCode;
  private final String zzauQ;
  private final String zzauR;
  private final String zzauS;
  private final Bundle zzauT;
  
  AppContentConditionEntity(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    this.mVersionCode = paramInt;
    this.zzauQ = paramString1;
    this.zzauR = paramString2;
    this.zzauS = paramString3;
    this.zzauT = paramBundle;
  }
  
  public AppContentConditionEntity(AppContentCondition paramAppContentCondition)
  {
    this.mVersionCode = 1;
    this.zzauQ = paramAppContentCondition.zzuf();
    this.zzauR = paramAppContentCondition.zzug();
    this.zzauS = paramAppContentCondition.zzuh();
    this.zzauT = paramAppContentCondition.zzui();
  }
  
  static int zza(AppContentCondition paramAppContentCondition)
  {
    return zzw.hashCode(new Object[] { paramAppContentCondition.zzuf(), paramAppContentCondition.zzug(), paramAppContentCondition.zzuh(), paramAppContentCondition.zzui() });
  }
  
  static boolean zza(AppContentCondition paramAppContentCondition, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentCondition)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentCondition == paramObject);
      paramObject = (AppContentCondition)paramObject;
      if ((!zzw.equal(((AppContentCondition)paramObject).zzuf(), paramAppContentCondition.zzuf())) || (!zzw.equal(((AppContentCondition)paramObject).zzug(), paramAppContentCondition.zzug())) || (!zzw.equal(((AppContentCondition)paramObject).zzuh(), paramAppContentCondition.zzuh()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentCondition)paramObject).zzui(), paramAppContentCondition.zzui()));
    return false;
  }
  
  static String zzb(AppContentCondition paramAppContentCondition)
  {
    return zzw.zzv(paramAppContentCondition).zzg("DefaultValue", paramAppContentCondition.zzuf()).zzg("ExpectedValue", paramAppContentCondition.zzug()).zzg("Predicate", paramAppContentCondition.zzuh()).zzg("PredicateParameters", paramAppContentCondition.zzui()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
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
    AppContentConditionEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zzuf()
  {
    return this.zzauQ;
  }
  
  public String zzug()
  {
    return this.zzauR;
  }
  
  public String zzuh()
  {
    return this.zzauS;
  }
  
  public Bundle zzui()
  {
    return this.zzauT;
  }
  
  public AppContentCondition zzuj()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentConditionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */