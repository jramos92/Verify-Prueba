package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class PersonEntity
  extends FastSafeParcelableJsonResponse
  implements Person
{
  public static final zza CREATOR = new zza();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
  final int mVersionCode;
  String zzF;
  String zzTa;
  String zzVT;
  final Set<Integer> zzaST;
  String zzaTR;
  AgeRangeEntity zzaTS;
  String zzaTT;
  String zzaTU;
  int zzaTV;
  CoverEntity zzaTW;
  String zzaTX;
  ImageEntity zzaTY;
  boolean zzaTZ;
  NameEntity zzaUa;
  String zzaUb;
  int zzaUc;
  List<OrganizationsEntity> zzaUd;
  List<PlacesLivedEntity> zzaUe;
  int zzaUf;
  int zzaUg;
  String zzaUh;
  List<UrlsEntity> zzaUi;
  boolean zzaUj;
  int zzsR;
  String zzwN;
  
  static
  {
    zzaSS.put("aboutMe", FastJsonResponse.Field.zzm("aboutMe", 2));
    zzaSS.put("ageRange", FastJsonResponse.Field.zza("ageRange", 3, AgeRangeEntity.class));
    zzaSS.put("birthday", FastJsonResponse.Field.zzm("birthday", 4));
    zzaSS.put("braggingRights", FastJsonResponse.Field.zzm("braggingRights", 5));
    zzaSS.put("circledByCount", FastJsonResponse.Field.zzj("circledByCount", 6));
    zzaSS.put("cover", FastJsonResponse.Field.zza("cover", 7, CoverEntity.class));
    zzaSS.put("currentLocation", FastJsonResponse.Field.zzm("currentLocation", 8));
    zzaSS.put("displayName", FastJsonResponse.Field.zzm("displayName", 9));
    zzaSS.put("gender", FastJsonResponse.Field.zza("gender", 12, new StringToIntConverter().zzi("male", 0).zzi("female", 1).zzi("other", 2), false));
    zzaSS.put("id", FastJsonResponse.Field.zzm("id", 14));
    zzaSS.put("image", FastJsonResponse.Field.zza("image", 15, ImageEntity.class));
    zzaSS.put("isPlusUser", FastJsonResponse.Field.zzl("isPlusUser", 16));
    zzaSS.put("language", FastJsonResponse.Field.zzm("language", 18));
    zzaSS.put("name", FastJsonResponse.Field.zza("name", 19, NameEntity.class));
    zzaSS.put("nickname", FastJsonResponse.Field.zzm("nickname", 20));
    zzaSS.put("objectType", FastJsonResponse.Field.zza("objectType", 21, new StringToIntConverter().zzi("person", 0).zzi("page", 1), false));
    zzaSS.put("organizations", FastJsonResponse.Field.zzb("organizations", 22, OrganizationsEntity.class));
    zzaSS.put("placesLived", FastJsonResponse.Field.zzb("placesLived", 23, PlacesLivedEntity.class));
    zzaSS.put("plusOneCount", FastJsonResponse.Field.zzj("plusOneCount", 24));
    zzaSS.put("relationshipStatus", FastJsonResponse.Field.zza("relationshipStatus", 25, new StringToIntConverter().zzi("single", 0).zzi("in_a_relationship", 1).zzi("engaged", 2).zzi("married", 3).zzi("its_complicated", 4).zzi("open_relationship", 5).zzi("widowed", 6).zzi("in_domestic_partnership", 7).zzi("in_civil_union", 8), false));
    zzaSS.put("tagline", FastJsonResponse.Field.zzm("tagline", 26));
    zzaSS.put("url", FastJsonResponse.Field.zzm("url", 27));
    zzaSS.put("urls", FastJsonResponse.Field.zzb("urls", 28, UrlsEntity.class));
    zzaSS.put("verified", FastJsonResponse.Field.zzl("verified", 29));
  }
  
  public PersonEntity()
  {
    this.mVersionCode = 1;
    this.zzaST = new HashSet();
  }
  
  public PersonEntity(String paramString1, String paramString2, ImageEntity paramImageEntity, int paramInt, String paramString3)
  {
    this.mVersionCode = 1;
    this.zzaST = new HashSet();
    this.zzTa = paramString1;
    this.zzaST.add(Integer.valueOf(9));
    this.zzwN = paramString2;
    this.zzaST.add(Integer.valueOf(14));
    this.zzaTY = paramImageEntity;
    this.zzaST.add(Integer.valueOf(15));
    this.zzaUc = paramInt;
    this.zzaST.add(Integer.valueOf(21));
    this.zzF = paramString3;
    this.zzaST.add(Integer.valueOf(27));
  }
  
  PersonEntity(Set<Integer> paramSet, int paramInt1, String paramString1, AgeRangeEntity paramAgeRangeEntity, String paramString2, String paramString3, int paramInt2, CoverEntity paramCoverEntity, String paramString4, String paramString5, int paramInt3, String paramString6, ImageEntity paramImageEntity, boolean paramBoolean1, String paramString7, NameEntity paramNameEntity, String paramString8, int paramInt4, List<OrganizationsEntity> paramList, List<PlacesLivedEntity> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<UrlsEntity> paramList2, boolean paramBoolean2)
  {
    this.zzaST = paramSet;
    this.mVersionCode = paramInt1;
    this.zzaTR = paramString1;
    this.zzaTS = paramAgeRangeEntity;
    this.zzaTT = paramString2;
    this.zzaTU = paramString3;
    this.zzaTV = paramInt2;
    this.zzaTW = paramCoverEntity;
    this.zzaTX = paramString4;
    this.zzTa = paramString5;
    this.zzsR = paramInt3;
    this.zzwN = paramString6;
    this.zzaTY = paramImageEntity;
    this.zzaTZ = paramBoolean1;
    this.zzVT = paramString7;
    this.zzaUa = paramNameEntity;
    this.zzaUb = paramString8;
    this.zzaUc = paramInt4;
    this.zzaUd = paramList;
    this.zzaUe = paramList1;
    this.zzaUf = paramInt5;
    this.zzaUg = paramInt6;
    this.zzaUh = paramString9;
    this.zzF = paramString10;
    this.zzaUi = paramList2;
    this.zzaUj = paramBoolean2;
  }
  
  public static PersonEntity zzt(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.zzgo(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PersonEntity)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (PersonEntity)paramObject;
    Iterator localIterator = zzaSS.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (zza(localField))
      {
        if (((PersonEntity)paramObject).zza(localField))
        {
          if (!zzb(localField).equals(((PersonEntity)paramObject).zzb(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((PersonEntity)paramObject).zza(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public String getAboutMe()
  {
    return this.zzaTR;
  }
  
  public Person.AgeRange getAgeRange()
  {
    return this.zzaTS;
  }
  
  public String getBirthday()
  {
    return this.zzaTT;
  }
  
  public String getBraggingRights()
  {
    return this.zzaTU;
  }
  
  public int getCircledByCount()
  {
    return this.zzaTV;
  }
  
  public Person.Cover getCover()
  {
    return this.zzaTW;
  }
  
  public String getCurrentLocation()
  {
    return this.zzaTX;
  }
  
  public String getDisplayName()
  {
    return this.zzTa;
  }
  
  public int getGender()
  {
    return this.zzsR;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public Person.Image getImage()
  {
    return this.zzaTY;
  }
  
  public String getLanguage()
  {
    return this.zzVT;
  }
  
  public Person.Name getName()
  {
    return this.zzaUa;
  }
  
  public String getNickname()
  {
    return this.zzaUb;
  }
  
  public int getObjectType()
  {
    return this.zzaUc;
  }
  
  public List<Person.Organizations> getOrganizations()
  {
    return (ArrayList)this.zzaUd;
  }
  
  public List<Person.PlacesLived> getPlacesLived()
  {
    return (ArrayList)this.zzaUe;
  }
  
  public int getPlusOneCount()
  {
    return this.zzaUf;
  }
  
  public int getRelationshipStatus()
  {
    return this.zzaUg;
  }
  
  public String getTagline()
  {
    return this.zzaUh;
  }
  
  public String getUrl()
  {
    return this.zzF;
  }
  
  public List<Person.Urls> getUrls()
  {
    return (ArrayList)this.zzaUi;
  }
  
  public boolean hasAboutMe()
  {
    return this.zzaST.contains(Integer.valueOf(2));
  }
  
  public boolean hasAgeRange()
  {
    return this.zzaST.contains(Integer.valueOf(3));
  }
  
  public boolean hasBirthday()
  {
    return this.zzaST.contains(Integer.valueOf(4));
  }
  
  public boolean hasBraggingRights()
  {
    return this.zzaST.contains(Integer.valueOf(5));
  }
  
  public boolean hasCircledByCount()
  {
    return this.zzaST.contains(Integer.valueOf(6));
  }
  
  public boolean hasCover()
  {
    return this.zzaST.contains(Integer.valueOf(7));
  }
  
  public boolean hasCurrentLocation()
  {
    return this.zzaST.contains(Integer.valueOf(8));
  }
  
  public boolean hasDisplayName()
  {
    return this.zzaST.contains(Integer.valueOf(9));
  }
  
  public boolean hasGender()
  {
    return this.zzaST.contains(Integer.valueOf(12));
  }
  
  public boolean hasId()
  {
    return this.zzaST.contains(Integer.valueOf(14));
  }
  
  public boolean hasImage()
  {
    return this.zzaST.contains(Integer.valueOf(15));
  }
  
  public boolean hasIsPlusUser()
  {
    return this.zzaST.contains(Integer.valueOf(16));
  }
  
  public boolean hasLanguage()
  {
    return this.zzaST.contains(Integer.valueOf(18));
  }
  
  public boolean hasName()
  {
    return this.zzaST.contains(Integer.valueOf(19));
  }
  
  public boolean hasNickname()
  {
    return this.zzaST.contains(Integer.valueOf(20));
  }
  
  public boolean hasObjectType()
  {
    return this.zzaST.contains(Integer.valueOf(21));
  }
  
  public boolean hasOrganizations()
  {
    return this.zzaST.contains(Integer.valueOf(22));
  }
  
  public boolean hasPlacesLived()
  {
    return this.zzaST.contains(Integer.valueOf(23));
  }
  
  public boolean hasPlusOneCount()
  {
    return this.zzaST.contains(Integer.valueOf(24));
  }
  
  public boolean hasRelationshipStatus()
  {
    return this.zzaST.contains(Integer.valueOf(25));
  }
  
  public boolean hasTagline()
  {
    return this.zzaST.contains(Integer.valueOf(26));
  }
  
  public boolean hasUrl()
  {
    return this.zzaST.contains(Integer.valueOf(27));
  }
  
  public boolean hasUrls()
  {
    return this.zzaST.contains(Integer.valueOf(28));
  }
  
  public boolean hasVerified()
  {
    return this.zzaST.contains(Integer.valueOf(29));
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
  
  public boolean isPlusUser()
  {
    return this.zzaTZ;
  }
  
  public boolean isVerified()
  {
    return this.zzaUj;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
  
  public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
  {
    return zzaSS;
  }
  
  public PersonEntity zzBO()
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
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
    case 2: 
      return this.zzaTR;
    case 3: 
      return this.zzaTS;
    case 4: 
      return this.zzaTT;
    case 5: 
      return this.zzaTU;
    case 6: 
      return Integer.valueOf(this.zzaTV);
    case 7: 
      return this.zzaTW;
    case 8: 
      return this.zzaTX;
    case 9: 
      return this.zzTa;
    case 12: 
      return Integer.valueOf(this.zzsR);
    case 14: 
      return this.zzwN;
    case 15: 
      return this.zzaTY;
    case 16: 
      return Boolean.valueOf(this.zzaTZ);
    case 18: 
      return this.zzVT;
    case 19: 
      return this.zzaUa;
    case 20: 
      return this.zzaUb;
    case 21: 
      return Integer.valueOf(this.zzaUc);
    case 22: 
      return this.zzaUd;
    case 23: 
      return this.zzaUe;
    case 24: 
      return Integer.valueOf(this.zzaUf);
    case 25: 
      return Integer.valueOf(this.zzaUg);
    case 26: 
      return this.zzaUh;
    case 27: 
      return this.zzF;
    case 28: 
      return this.zzaUi;
    }
    return Boolean.valueOf(this.zzaUj);
  }
  
  public static final class AgeRangeEntity
    extends FastSafeParcelableJsonResponse
    implements Person.AgeRange
  {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
    final int mVersionCode;
    final Set<Integer> zzaST;
    int zzaUk;
    int zzaUl;
    
    static
    {
      zzaSS.put("max", FastJsonResponse.Field.zzj("max", 2));
      zzaSS.put("min", FastJsonResponse.Field.zzj("min", 3));
    }
    
    public AgeRangeEntity()
    {
      this.mVersionCode = 1;
      this.zzaST = new HashSet();
    }
    
    AgeRangeEntity(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
    {
      this.zzaST = paramSet;
      this.mVersionCode = paramInt1;
      this.zzaUk = paramInt2;
      this.zzaUl = paramInt3;
    }
    
    public int describeContents()
    {
      zzb localzzb = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof AgeRangeEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (AgeRangeEntity)paramObject;
      Iterator localIterator = zzaSS.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((AgeRangeEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((AgeRangeEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((AgeRangeEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public int getMax()
    {
      return this.zzaUk;
    }
    
    public int getMin()
    {
      return this.zzaUl;
    }
    
    public boolean hasMax()
    {
      return this.zzaST.contains(Integer.valueOf(2));
    }
    
    public boolean hasMin()
    {
      return this.zzaST.contains(Integer.valueOf(3));
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
    
    public AgeRangeEntity zzBP()
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
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
      case 2: 
        return Integer.valueOf(this.zzaUk);
      }
      return Integer.valueOf(this.zzaUl);
    }
  }
  
  public static final class CoverEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Cover
  {
    public static final zzc CREATOR = new zzc();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
    final int mVersionCode;
    final Set<Integer> zzaST;
    CoverInfoEntity zzaUm;
    CoverPhotoEntity zzaUn;
    int zzaUo;
    
    static
    {
      zzaSS.put("coverInfo", FastJsonResponse.Field.zza("coverInfo", 2, CoverInfoEntity.class));
      zzaSS.put("coverPhoto", FastJsonResponse.Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
      zzaSS.put("layout", FastJsonResponse.Field.zza("layout", 4, new StringToIntConverter().zzi("banner", 0), false));
    }
    
    public CoverEntity()
    {
      this.mVersionCode = 1;
      this.zzaST = new HashSet();
    }
    
    CoverEntity(Set<Integer> paramSet, int paramInt1, CoverInfoEntity paramCoverInfoEntity, CoverPhotoEntity paramCoverPhotoEntity, int paramInt2)
    {
      this.zzaST = paramSet;
      this.mVersionCode = paramInt1;
      this.zzaUm = paramCoverInfoEntity;
      this.zzaUn = paramCoverPhotoEntity;
      this.zzaUo = paramInt2;
    }
    
    public int describeContents()
    {
      zzc localzzc = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof CoverEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (CoverEntity)paramObject;
      Iterator localIterator = zzaSS.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((CoverEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((CoverEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((CoverEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public Person.Cover.CoverInfo getCoverInfo()
    {
      return this.zzaUm;
    }
    
    public Person.Cover.CoverPhoto getCoverPhoto()
    {
      return this.zzaUn;
    }
    
    public int getLayout()
    {
      return this.zzaUo;
    }
    
    public boolean hasCoverInfo()
    {
      return this.zzaST.contains(Integer.valueOf(2));
    }
    
    public boolean hasCoverPhoto()
    {
      return this.zzaST.contains(Integer.valueOf(3));
    }
    
    public boolean hasLayout()
    {
      return this.zzaST.contains(Integer.valueOf(4));
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
      zzc localzzc = CREATOR;
      zzc.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
    {
      return zzaSS;
    }
    
    public CoverEntity zzBQ()
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
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
      case 2: 
        return this.zzaUm;
      case 3: 
        return this.zzaUn;
      }
      return Integer.valueOf(this.zzaUo);
    }
    
    public static final class CoverInfoEntity
      extends FastSafeParcelableJsonResponse
      implements Person.Cover.CoverInfo
    {
      public static final zzd CREATOR = new zzd();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
      final int mVersionCode;
      final Set<Integer> zzaST;
      int zzaUp;
      int zzaUq;
      
      static
      {
        zzaSS.put("leftImageOffset", FastJsonResponse.Field.zzj("leftImageOffset", 2));
        zzaSS.put("topImageOffset", FastJsonResponse.Field.zzj("topImageOffset", 3));
      }
      
      public CoverInfoEntity()
      {
        this.mVersionCode = 1;
        this.zzaST = new HashSet();
      }
      
      CoverInfoEntity(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
      {
        this.zzaST = paramSet;
        this.mVersionCode = paramInt1;
        this.zzaUp = paramInt2;
        this.zzaUq = paramInt3;
      }
      
      public int describeContents()
      {
        zzd localzzd = CREATOR;
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof CoverInfoEntity)) {
          return false;
        }
        if (this == paramObject) {
          return true;
        }
        paramObject = (CoverInfoEntity)paramObject;
        Iterator localIterator = zzaSS.values().iterator();
        while (localIterator.hasNext())
        {
          FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
          if (zza(localField))
          {
            if (((CoverInfoEntity)paramObject).zza(localField))
            {
              if (!zzb(localField).equals(((CoverInfoEntity)paramObject).zzb(localField))) {
                return false;
              }
            }
            else {
              return false;
            }
          }
          else if (((CoverInfoEntity)paramObject).zza(localField)) {
            return false;
          }
        }
        return true;
      }
      
      public int getLeftImageOffset()
      {
        return this.zzaUp;
      }
      
      public int getTopImageOffset()
      {
        return this.zzaUq;
      }
      
      public boolean hasLeftImageOffset()
      {
        return this.zzaST.contains(Integer.valueOf(2));
      }
      
      public boolean hasTopImageOffset()
      {
        return this.zzaST.contains(Integer.valueOf(3));
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
        zzd localzzd = CREATOR;
        zzd.zza(this, paramParcel, paramInt);
      }
      
      public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
      {
        return zzaSS;
      }
      
      public CoverInfoEntity zzBR()
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
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
        case 2: 
          return Integer.valueOf(this.zzaUp);
        }
        return Integer.valueOf(this.zzaUq);
      }
    }
    
    public static final class CoverPhotoEntity
      extends FastSafeParcelableJsonResponse
      implements Person.Cover.CoverPhoto
    {
      public static final zze CREATOR = new zze();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
      final int mVersionCode;
      String zzF;
      final Set<Integer> zzaST;
      int zznQ;
      int zznR;
      
      static
      {
        zzaSS.put("height", FastJsonResponse.Field.zzj("height", 2));
        zzaSS.put("url", FastJsonResponse.Field.zzm("url", 3));
        zzaSS.put("width", FastJsonResponse.Field.zzj("width", 4));
      }
      
      public CoverPhotoEntity()
      {
        this.mVersionCode = 1;
        this.zzaST = new HashSet();
      }
      
      CoverPhotoEntity(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        this.zzaST = paramSet;
        this.mVersionCode = paramInt1;
        this.zznR = paramInt2;
        this.zzF = paramString;
        this.zznQ = paramInt3;
      }
      
      public int describeContents()
      {
        zze localzze = CREATOR;
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof CoverPhotoEntity)) {
          return false;
        }
        if (this == paramObject) {
          return true;
        }
        paramObject = (CoverPhotoEntity)paramObject;
        Iterator localIterator = zzaSS.values().iterator();
        while (localIterator.hasNext())
        {
          FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
          if (zza(localField))
          {
            if (((CoverPhotoEntity)paramObject).zza(localField))
            {
              if (!zzb(localField).equals(((CoverPhotoEntity)paramObject).zzb(localField))) {
                return false;
              }
            }
            else {
              return false;
            }
          }
          else if (((CoverPhotoEntity)paramObject).zza(localField)) {
            return false;
          }
        }
        return true;
      }
      
      public int getHeight()
      {
        return this.zznR;
      }
      
      public String getUrl()
      {
        return this.zzF;
      }
      
      public int getWidth()
      {
        return this.zznQ;
      }
      
      public boolean hasHeight()
      {
        return this.zzaST.contains(Integer.valueOf(2));
      }
      
      public boolean hasUrl()
      {
        return this.zzaST.contains(Integer.valueOf(3));
      }
      
      public boolean hasWidth()
      {
        return this.zzaST.contains(Integer.valueOf(4));
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
        zze localzze = CREATOR;
        zze.zza(this, paramParcel, paramInt);
      }
      
      public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
      {
        return zzaSS;
      }
      
      public CoverPhotoEntity zzBS()
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
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
        case 2: 
          return Integer.valueOf(this.zznR);
        case 3: 
          return this.zzF;
        }
        return Integer.valueOf(this.zznQ);
      }
    }
  }
  
  public static final class ImageEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Image
  {
    public static final zzf CREATOR = new zzf();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
    final int mVersionCode;
    String zzF;
    final Set<Integer> zzaST;
    
    static
    {
      zzaSS.put("url", FastJsonResponse.Field.zzm("url", 2));
    }
    
    public ImageEntity()
    {
      this.mVersionCode = 1;
      this.zzaST = new HashSet();
    }
    
    public ImageEntity(String paramString)
    {
      this.zzaST = new HashSet();
      this.mVersionCode = 1;
      this.zzF = paramString;
      this.zzaST.add(Integer.valueOf(2));
    }
    
    ImageEntity(Set<Integer> paramSet, int paramInt, String paramString)
    {
      this.zzaST = paramSet;
      this.mVersionCode = paramInt;
      this.zzF = paramString;
    }
    
    public int describeContents()
    {
      zzf localzzf = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof ImageEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (ImageEntity)paramObject;
      Iterator localIterator = zzaSS.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((ImageEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((ImageEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((ImageEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getUrl()
    {
      return this.zzF;
    }
    
    public boolean hasUrl()
    {
      return this.zzaST.contains(Integer.valueOf(2));
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
      zzf localzzf = CREATOR;
      zzf.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
    {
      return zzaSS;
    }
    
    public ImageEntity zzBT()
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
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
      }
      return this.zzF;
    }
  }
  
  public static final class NameEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Name
  {
    public static final zzg CREATOR = new zzg();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
    final int mVersionCode;
    final Set<Integer> zzaST;
    String zzaTr;
    String zzaTu;
    String zzaUr;
    String zzaUs;
    String zzaUt;
    String zzaUu;
    
    static
    {
      zzaSS.put("familyName", FastJsonResponse.Field.zzm("familyName", 2));
      zzaSS.put("formatted", FastJsonResponse.Field.zzm("formatted", 3));
      zzaSS.put("givenName", FastJsonResponse.Field.zzm("givenName", 4));
      zzaSS.put("honorificPrefix", FastJsonResponse.Field.zzm("honorificPrefix", 5));
      zzaSS.put("honorificSuffix", FastJsonResponse.Field.zzm("honorificSuffix", 6));
      zzaSS.put("middleName", FastJsonResponse.Field.zzm("middleName", 7));
    }
    
    public NameEntity()
    {
      this.mVersionCode = 1;
      this.zzaST = new HashSet();
    }
    
    NameEntity(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.zzaST = paramSet;
      this.mVersionCode = paramInt;
      this.zzaTr = paramString1;
      this.zzaUr = paramString2;
      this.zzaTu = paramString3;
      this.zzaUs = paramString4;
      this.zzaUt = paramString5;
      this.zzaUu = paramString6;
    }
    
    public int describeContents()
    {
      zzg localzzg = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof NameEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (NameEntity)paramObject;
      Iterator localIterator = zzaSS.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((NameEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((NameEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((NameEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getFamilyName()
    {
      return this.zzaTr;
    }
    
    public String getFormatted()
    {
      return this.zzaUr;
    }
    
    public String getGivenName()
    {
      return this.zzaTu;
    }
    
    public String getHonorificPrefix()
    {
      return this.zzaUs;
    }
    
    public String getHonorificSuffix()
    {
      return this.zzaUt;
    }
    
    public String getMiddleName()
    {
      return this.zzaUu;
    }
    
    public boolean hasFamilyName()
    {
      return this.zzaST.contains(Integer.valueOf(2));
    }
    
    public boolean hasFormatted()
    {
      return this.zzaST.contains(Integer.valueOf(3));
    }
    
    public boolean hasGivenName()
    {
      return this.zzaST.contains(Integer.valueOf(4));
    }
    
    public boolean hasHonorificPrefix()
    {
      return this.zzaST.contains(Integer.valueOf(5));
    }
    
    public boolean hasHonorificSuffix()
    {
      return this.zzaST.contains(Integer.valueOf(6));
    }
    
    public boolean hasMiddleName()
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
      zzg localzzg = CREATOR;
      zzg.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
    {
      return zzaSS;
    }
    
    public NameEntity zzBU()
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
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
      case 2: 
        return this.zzaTr;
      case 3: 
        return this.zzaUr;
      case 4: 
        return this.zzaTu;
      case 5: 
        return this.zzaUs;
      case 6: 
        return this.zzaUt;
      }
      return this.zzaUu;
    }
  }
  
  public static final class OrganizationsEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Organizations
  {
    public static final zzh CREATOR = new zzh();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
    String mName;
    final int mVersionCode;
    int zzWJ;
    final Set<Integer> zzaST;
    String zzaTG;
    String zzaTq;
    String zzaUv;
    String zzaUw;
    boolean zzaUx;
    String zzajf;
    String zzaqZ;
    
    static
    {
      zzaSS.put("department", FastJsonResponse.Field.zzm("department", 2));
      zzaSS.put("description", FastJsonResponse.Field.zzm("description", 3));
      zzaSS.put("endDate", FastJsonResponse.Field.zzm("endDate", 4));
      zzaSS.put("location", FastJsonResponse.Field.zzm("location", 5));
      zzaSS.put("name", FastJsonResponse.Field.zzm("name", 6));
      zzaSS.put("primary", FastJsonResponse.Field.zzl("primary", 7));
      zzaSS.put("startDate", FastJsonResponse.Field.zzm("startDate", 8));
      zzaSS.put("title", FastJsonResponse.Field.zzm("title", 9));
      zzaSS.put("type", FastJsonResponse.Field.zza("type", 10, new StringToIntConverter().zzi("work", 0).zzi("school", 1), false));
    }
    
    public OrganizationsEntity()
    {
      this.mVersionCode = 1;
      this.zzaST = new HashSet();
    }
    
    OrganizationsEntity(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
    {
      this.zzaST = paramSet;
      this.mVersionCode = paramInt1;
      this.zzaUv = paramString1;
      this.zzaqZ = paramString2;
      this.zzaTq = paramString3;
      this.zzaUw = paramString4;
      this.mName = paramString5;
      this.zzaUx = paramBoolean;
      this.zzaTG = paramString6;
      this.zzajf = paramString7;
      this.zzWJ = paramInt2;
    }
    
    public int describeContents()
    {
      zzh localzzh = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof OrganizationsEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (OrganizationsEntity)paramObject;
      Iterator localIterator = zzaSS.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((OrganizationsEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((OrganizationsEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((OrganizationsEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getDepartment()
    {
      return this.zzaUv;
    }
    
    public String getDescription()
    {
      return this.zzaqZ;
    }
    
    public String getEndDate()
    {
      return this.zzaTq;
    }
    
    public String getLocation()
    {
      return this.zzaUw;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getStartDate()
    {
      return this.zzaTG;
    }
    
    public String getTitle()
    {
      return this.zzajf;
    }
    
    public int getType()
    {
      return this.zzWJ;
    }
    
    public boolean hasDepartment()
    {
      return this.zzaST.contains(Integer.valueOf(2));
    }
    
    public boolean hasDescription()
    {
      return this.zzaST.contains(Integer.valueOf(3));
    }
    
    public boolean hasEndDate()
    {
      return this.zzaST.contains(Integer.valueOf(4));
    }
    
    public boolean hasLocation()
    {
      return this.zzaST.contains(Integer.valueOf(5));
    }
    
    public boolean hasName()
    {
      return this.zzaST.contains(Integer.valueOf(6));
    }
    
    public boolean hasPrimary()
    {
      return this.zzaST.contains(Integer.valueOf(7));
    }
    
    public boolean hasStartDate()
    {
      return this.zzaST.contains(Integer.valueOf(8));
    }
    
    public boolean hasTitle()
    {
      return this.zzaST.contains(Integer.valueOf(9));
    }
    
    public boolean hasType()
    {
      return this.zzaST.contains(Integer.valueOf(10));
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
    
    public boolean isPrimary()
    {
      return this.zzaUx;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzh localzzh = CREATOR;
      zzh.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
    {
      return zzaSS;
    }
    
    public OrganizationsEntity zzBV()
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
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
      case 2: 
        return this.zzaUv;
      case 3: 
        return this.zzaqZ;
      case 4: 
        return this.zzaTq;
      case 5: 
        return this.zzaUw;
      case 6: 
        return this.mName;
      case 7: 
        return Boolean.valueOf(this.zzaUx);
      case 8: 
        return this.zzaTG;
      case 9: 
        return this.zzajf;
      }
      return Integer.valueOf(this.zzWJ);
    }
  }
  
  public static final class PlacesLivedEntity
    extends FastSafeParcelableJsonResponse
    implements Person.PlacesLived
  {
    public static final zzi CREATOR = new zzi();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
    String mValue;
    final int mVersionCode;
    final Set<Integer> zzaST;
    boolean zzaUx;
    
    static
    {
      zzaSS.put("primary", FastJsonResponse.Field.zzl("primary", 2));
      zzaSS.put("value", FastJsonResponse.Field.zzm("value", 3));
    }
    
    public PlacesLivedEntity()
    {
      this.mVersionCode = 1;
      this.zzaST = new HashSet();
    }
    
    PlacesLivedEntity(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
    {
      this.zzaST = paramSet;
      this.mVersionCode = paramInt;
      this.zzaUx = paramBoolean;
      this.mValue = paramString;
    }
    
    public int describeContents()
    {
      zzi localzzi = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof PlacesLivedEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (PlacesLivedEntity)paramObject;
      Iterator localIterator = zzaSS.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((PlacesLivedEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((PlacesLivedEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((PlacesLivedEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public boolean hasPrimary()
    {
      return this.zzaST.contains(Integer.valueOf(2));
    }
    
    public boolean hasValue()
    {
      return this.zzaST.contains(Integer.valueOf(3));
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
    
    public boolean isPrimary()
    {
      return this.zzaUx;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzi localzzi = CREATOR;
      zzi.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
    {
      return zzaSS;
    }
    
    public PlacesLivedEntity zzBW()
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
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
      case 2: 
        return Boolean.valueOf(this.zzaUx);
      }
      return this.mValue;
    }
  }
  
  public static final class UrlsEntity
    extends FastSafeParcelableJsonResponse
    implements Person.Urls
  {
    public static final zzj CREATOR = new zzj();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
    String mValue;
    final int mVersionCode;
    int zzWJ;
    String zzaLw;
    final Set<Integer> zzaST;
    private final int zzaUy = 4;
    
    static
    {
      zzaSS.put("label", FastJsonResponse.Field.zzm("label", 5));
      zzaSS.put("type", FastJsonResponse.Field.zza("type", 6, new StringToIntConverter().zzi("home", 0).zzi("work", 1).zzi("blog", 2).zzi("profile", 3).zzi("other", 4).zzi("otherProfile", 5).zzi("contributor", 6).zzi("website", 7), false));
      zzaSS.put("value", FastJsonResponse.Field.zzm("value", 4));
    }
    
    public UrlsEntity()
    {
      this.mVersionCode = 1;
      this.zzaST = new HashSet();
    }
    
    UrlsEntity(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
    {
      this.zzaST = paramSet;
      this.mVersionCode = paramInt1;
      this.zzaLw = paramString1;
      this.zzWJ = paramInt2;
      this.mValue = paramString2;
    }
    
    public int describeContents()
    {
      zzj localzzj = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof UrlsEntity)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (UrlsEntity)paramObject;
      Iterator localIterator = zzaSS.values().iterator();
      while (localIterator.hasNext())
      {
        FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
        if (zza(localField))
        {
          if (((UrlsEntity)paramObject).zza(localField))
          {
            if (!zzb(localField).equals(((UrlsEntity)paramObject).zzb(localField))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((UrlsEntity)paramObject).zza(localField)) {
          return false;
        }
      }
      return true;
    }
    
    public String getLabel()
    {
      return this.zzaLw;
    }
    
    public int getType()
    {
      return this.zzWJ;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public boolean hasLabel()
    {
      return this.zzaST.contains(Integer.valueOf(5));
    }
    
    public boolean hasType()
    {
      return this.zzaST.contains(Integer.valueOf(6));
    }
    
    public boolean hasValue()
    {
      return this.zzaST.contains(Integer.valueOf(4));
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
      zzj localzzj = CREATOR;
      zzj.zza(this, paramParcel, paramInt);
    }
    
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
    {
      return zzaSS;
    }
    
    @Deprecated
    public int zzBX()
    {
      return 4;
    }
    
    public UrlsEntity zzBY()
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
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
      case 5: 
        return this.zzaLw;
      case 6: 
        return Integer.valueOf(this.zzWJ);
      }
      return this.mValue;
    }
  }
  
  public static class zza
  {
    public static int zzer(String paramString)
    {
      if (paramString.equals("person")) {
        return 0;
      }
      if (paramString.equals("page")) {
        return 1;
      }
      throw new IllegalArgumentException("Unknown objectType string: " + paramString);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\model\people\PersonEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */