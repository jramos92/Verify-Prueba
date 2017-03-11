package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePrediction.Substring;
import java.util.Collections;
import java.util.List;

public class AutocompletePredictionEntity
  implements SafeParcelable, AutocompletePrediction
{
  public static final Parcelable.Creator<AutocompletePredictionEntity> CREATOR = new zza();
  private static final List<SubstringEntity> zzaGN = Collections.emptyList();
  final int mVersionCode;
  final List<Integer> zzaFT;
  final String zzaGO;
  final List<SubstringEntity> zzaGP;
  final int zzaGQ;
  final String zzaGR;
  final List<SubstringEntity> zzaGS;
  final String zzaGT;
  final List<SubstringEntity> zzaGU;
  final String zzaGt;
  
  AutocompletePredictionEntity(int paramInt1, String paramString1, List<Integer> paramList, int paramInt2, String paramString2, List<SubstringEntity> paramList1, String paramString3, List<SubstringEntity> paramList2, String paramString4, List<SubstringEntity> paramList3)
  {
    this.mVersionCode = paramInt1;
    this.zzaGt = paramString1;
    this.zzaFT = paramList;
    this.zzaGQ = paramInt2;
    this.zzaGO = paramString2;
    this.zzaGP = paramList1;
    this.zzaGR = paramString3;
    this.zzaGS = paramList2;
    this.zzaGT = paramString4;
    this.zzaGU = paramList3;
  }
  
  public static AutocompletePredictionEntity zza(String paramString1, List<Integer> paramList, int paramInt, String paramString2, List<SubstringEntity> paramList1, String paramString3, List<SubstringEntity> paramList2, String paramString4, List<SubstringEntity> paramList3)
  {
    return new AutocompletePredictionEntity(0, paramString1, paramList, paramInt, (String)zzx.zzw(paramString2), paramList1, paramString3, paramList2, paramString4, paramList3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AutocompletePredictionEntity)) {
        return false;
      }
      paramObject = (AutocompletePredictionEntity)paramObject;
    } while ((zzw.equal(this.zzaGt, ((AutocompletePredictionEntity)paramObject).zzaGt)) && (zzw.equal(this.zzaFT, ((AutocompletePredictionEntity)paramObject).zzaFT)) && (zzw.equal(Integer.valueOf(this.zzaGQ), Integer.valueOf(((AutocompletePredictionEntity)paramObject).zzaGQ))) && (zzw.equal(this.zzaGO, ((AutocompletePredictionEntity)paramObject).zzaGO)) && (zzw.equal(this.zzaGP, ((AutocompletePredictionEntity)paramObject).zzaGP)) && (zzw.equal(this.zzaGR, ((AutocompletePredictionEntity)paramObject).zzaGR)) && (zzw.equal(this.zzaGS, ((AutocompletePredictionEntity)paramObject).zzaGS)) && (zzw.equal(this.zzaGT, ((AutocompletePredictionEntity)paramObject).zzaGT)) && (zzw.equal(this.zzaGU, ((AutocompletePredictionEntity)paramObject).zzaGU)));
    return false;
  }
  
  public String getDescription()
  {
    return this.zzaGO;
  }
  
  public CharSequence getFullText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(this.zzaGO, this.zzaGP, paramCharacterStyle);
  }
  
  public List<? extends AutocompletePrediction.Substring> getMatchedSubstrings()
  {
    return this.zzaGP;
  }
  
  public String getPlaceId()
  {
    return this.zzaGt;
  }
  
  public List<Integer> getPlaceTypes()
  {
    return this.zzaFT;
  }
  
  public CharSequence getPrimaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(this.zzaGR, this.zzaGS, paramCharacterStyle);
  }
  
  public CharSequence getSecondaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(this.zzaGT, this.zzaGU, paramCharacterStyle);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaGt, this.zzaFT, Integer.valueOf(this.zzaGQ), this.zzaGO, this.zzaGP, this.zzaGR, this.zzaGS, this.zzaGT, this.zzaGU });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("placeId", this.zzaGt).zzg("placeTypes", this.zzaFT).zzg("fullText", this.zzaGO).zzg("fullTextMatchedSubstrings", this.zzaGP).zzg("primaryText", this.zzaGR).zzg("primaryTextMatchedSubstrings", this.zzaGS).zzg("secondaryText", this.zzaGT).zzg("secondaryTextMatchedSubstrings", this.zzaGU).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public AutocompletePrediction zzwV()
  {
    return this;
  }
  
  public static class SubstringEntity
    implements SafeParcelable, AutocompletePrediction.Substring
  {
    public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzv();
    final int mLength;
    final int mOffset;
    final int mVersionCode;
    
    public SubstringEntity(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mVersionCode = paramInt1;
      this.mOffset = paramInt2;
      this.mLength = paramInt3;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof SubstringEntity)) {
          return false;
        }
        paramObject = (SubstringEntity)paramObject;
      } while ((zzw.equal(Integer.valueOf(this.mOffset), Integer.valueOf(((SubstringEntity)paramObject).mOffset))) && (zzw.equal(Integer.valueOf(this.mLength), Integer.valueOf(((SubstringEntity)paramObject).mLength))));
      return false;
    }
    
    public int getLength()
    {
      return this.mLength;
    }
    
    public int getOffset()
    {
      return this.mOffset;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength) });
    }
    
    public String toString()
    {
      return zzw.zzv(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzv.zza(this, paramParcel, paramInt);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\AutocompletePredictionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */