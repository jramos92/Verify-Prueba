package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ItemScopeEntity
  extends FastSafeParcelableJsonResponse
  implements ItemScope
{
  public static final zza CREATOR = new zza();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaSS = new HashMap();
  String mName;
  final int mVersionCode;
  String zzF;
  String zzGq;
  double zzaEl;
  double zzaEm;
  final Set<Integer> zzaST;
  ItemScopeEntity zzaSU;
  List<String> zzaSV;
  ItemScopeEntity zzaSW;
  String zzaSX;
  String zzaSY;
  String zzaSZ;
  List<ItemScopeEntity> zzaTA;
  String zzaTB;
  String zzaTC;
  String zzaTD;
  String zzaTE;
  ItemScopeEntity zzaTF;
  String zzaTG;
  String zzaTH;
  String zzaTI;
  ItemScopeEntity zzaTJ;
  String zzaTK;
  String zzaTL;
  String zzaTM;
  String zzaTN;
  List<ItemScopeEntity> zzaTa;
  int zzaTb;
  List<ItemScopeEntity> zzaTc;
  ItemScopeEntity zzaTd;
  List<ItemScopeEntity> zzaTe;
  String zzaTf;
  String zzaTg;
  ItemScopeEntity zzaTh;
  String zzaTi;
  String zzaTj;
  List<ItemScopeEntity> zzaTk;
  String zzaTl;
  String zzaTm;
  String zzaTn;
  String zzaTo;
  String zzaTp;
  String zzaTq;
  String zzaTr;
  String zzaTs;
  ItemScopeEntity zzaTt;
  String zzaTu;
  String zzaTv;
  String zzaTw;
  ItemScopeEntity zzaTx;
  ItemScopeEntity zzaTy;
  ItemScopeEntity zzaTz;
  String zzaqZ;
  String zzsX;
  String zzwN;
  
  static
  {
    zzaSS.put("about", FastJsonResponse.Field.zza("about", 2, ItemScopeEntity.class));
    zzaSS.put("additionalName", FastJsonResponse.Field.zzn("additionalName", 3));
    zzaSS.put("address", FastJsonResponse.Field.zza("address", 4, ItemScopeEntity.class));
    zzaSS.put("addressCountry", FastJsonResponse.Field.zzm("addressCountry", 5));
    zzaSS.put("addressLocality", FastJsonResponse.Field.zzm("addressLocality", 6));
    zzaSS.put("addressRegion", FastJsonResponse.Field.zzm("addressRegion", 7));
    zzaSS.put("associated_media", FastJsonResponse.Field.zzb("associated_media", 8, ItemScopeEntity.class));
    zzaSS.put("attendeeCount", FastJsonResponse.Field.zzj("attendeeCount", 9));
    zzaSS.put("attendees", FastJsonResponse.Field.zzb("attendees", 10, ItemScopeEntity.class));
    zzaSS.put("audio", FastJsonResponse.Field.zza("audio", 11, ItemScopeEntity.class));
    zzaSS.put("author", FastJsonResponse.Field.zzb("author", 12, ItemScopeEntity.class));
    zzaSS.put("bestRating", FastJsonResponse.Field.zzm("bestRating", 13));
    zzaSS.put("birthDate", FastJsonResponse.Field.zzm("birthDate", 14));
    zzaSS.put("byArtist", FastJsonResponse.Field.zza("byArtist", 15, ItemScopeEntity.class));
    zzaSS.put("caption", FastJsonResponse.Field.zzm("caption", 16));
    zzaSS.put("contentSize", FastJsonResponse.Field.zzm("contentSize", 17));
    zzaSS.put("contentUrl", FastJsonResponse.Field.zzm("contentUrl", 18));
    zzaSS.put("contributor", FastJsonResponse.Field.zzb("contributor", 19, ItemScopeEntity.class));
    zzaSS.put("dateCreated", FastJsonResponse.Field.zzm("dateCreated", 20));
    zzaSS.put("dateModified", FastJsonResponse.Field.zzm("dateModified", 21));
    zzaSS.put("datePublished", FastJsonResponse.Field.zzm("datePublished", 22));
    zzaSS.put("description", FastJsonResponse.Field.zzm("description", 23));
    zzaSS.put("duration", FastJsonResponse.Field.zzm("duration", 24));
    zzaSS.put("embedUrl", FastJsonResponse.Field.zzm("embedUrl", 25));
    zzaSS.put("endDate", FastJsonResponse.Field.zzm("endDate", 26));
    zzaSS.put("familyName", FastJsonResponse.Field.zzm("familyName", 27));
    zzaSS.put("gender", FastJsonResponse.Field.zzm("gender", 28));
    zzaSS.put("geo", FastJsonResponse.Field.zza("geo", 29, ItemScopeEntity.class));
    zzaSS.put("givenName", FastJsonResponse.Field.zzm("givenName", 30));
    zzaSS.put("height", FastJsonResponse.Field.zzm("height", 31));
    zzaSS.put("id", FastJsonResponse.Field.zzm("id", 32));
    zzaSS.put("image", FastJsonResponse.Field.zzm("image", 33));
    zzaSS.put("inAlbum", FastJsonResponse.Field.zza("inAlbum", 34, ItemScopeEntity.class));
    zzaSS.put("latitude", FastJsonResponse.Field.zzk("latitude", 36));
    zzaSS.put("location", FastJsonResponse.Field.zza("location", 37, ItemScopeEntity.class));
    zzaSS.put("longitude", FastJsonResponse.Field.zzk("longitude", 38));
    zzaSS.put("name", FastJsonResponse.Field.zzm("name", 39));
    zzaSS.put("partOfTVSeries", FastJsonResponse.Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
    zzaSS.put("performers", FastJsonResponse.Field.zzb("performers", 41, ItemScopeEntity.class));
    zzaSS.put("playerType", FastJsonResponse.Field.zzm("playerType", 42));
    zzaSS.put("postOfficeBoxNumber", FastJsonResponse.Field.zzm("postOfficeBoxNumber", 43));
    zzaSS.put("postalCode", FastJsonResponse.Field.zzm("postalCode", 44));
    zzaSS.put("ratingValue", FastJsonResponse.Field.zzm("ratingValue", 45));
    zzaSS.put("reviewRating", FastJsonResponse.Field.zza("reviewRating", 46, ItemScopeEntity.class));
    zzaSS.put("startDate", FastJsonResponse.Field.zzm("startDate", 47));
    zzaSS.put("streetAddress", FastJsonResponse.Field.zzm("streetAddress", 48));
    zzaSS.put("text", FastJsonResponse.Field.zzm("text", 49));
    zzaSS.put("thumbnail", FastJsonResponse.Field.zza("thumbnail", 50, ItemScopeEntity.class));
    zzaSS.put("thumbnailUrl", FastJsonResponse.Field.zzm("thumbnailUrl", 51));
    zzaSS.put("tickerSymbol", FastJsonResponse.Field.zzm("tickerSymbol", 52));
    zzaSS.put("type", FastJsonResponse.Field.zzm("type", 53));
    zzaSS.put("url", FastJsonResponse.Field.zzm("url", 54));
    zzaSS.put("width", FastJsonResponse.Field.zzm("width", 55));
    zzaSS.put("worstRating", FastJsonResponse.Field.zzm("worstRating", 56));
  }
  
  public ItemScopeEntity()
  {
    this.mVersionCode = 1;
    this.zzaST = new HashSet();
  }
  
  ItemScopeEntity(Set<Integer> paramSet, int paramInt1, ItemScopeEntity paramItemScopeEntity1, List<String> paramList, ItemScopeEntity paramItemScopeEntity2, String paramString1, String paramString2, String paramString3, List<ItemScopeEntity> paramList1, int paramInt2, List<ItemScopeEntity> paramList2, ItemScopeEntity paramItemScopeEntity3, List<ItemScopeEntity> paramList3, String paramString4, String paramString5, ItemScopeEntity paramItemScopeEntity4, String paramString6, String paramString7, String paramString8, List<ItemScopeEntity> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ItemScopeEntity paramItemScopeEntity5, String paramString18, String paramString19, String paramString20, String paramString21, ItemScopeEntity paramItemScopeEntity6, double paramDouble1, ItemScopeEntity paramItemScopeEntity7, double paramDouble2, String paramString22, ItemScopeEntity paramItemScopeEntity8, List<ItemScopeEntity> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ItemScopeEntity paramItemScopeEntity9, String paramString27, String paramString28, String paramString29, ItemScopeEntity paramItemScopeEntity10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.zzaST = paramSet;
    this.mVersionCode = paramInt1;
    this.zzaSU = paramItemScopeEntity1;
    this.zzaSV = paramList;
    this.zzaSW = paramItemScopeEntity2;
    this.zzaSX = paramString1;
    this.zzaSY = paramString2;
    this.zzaSZ = paramString3;
    this.zzaTa = paramList1;
    this.zzaTb = paramInt2;
    this.zzaTc = paramList2;
    this.zzaTd = paramItemScopeEntity3;
    this.zzaTe = paramList3;
    this.zzaTf = paramString4;
    this.zzaTg = paramString5;
    this.zzaTh = paramItemScopeEntity4;
    this.zzaTi = paramString6;
    this.zzaTj = paramString7;
    this.zzsX = paramString8;
    this.zzaTk = paramList4;
    this.zzaTl = paramString9;
    this.zzaTm = paramString10;
    this.zzaTn = paramString11;
    this.zzaqZ = paramString12;
    this.zzaTo = paramString13;
    this.zzaTp = paramString14;
    this.zzaTq = paramString15;
    this.zzaTr = paramString16;
    this.zzaTs = paramString17;
    this.zzaTt = paramItemScopeEntity5;
    this.zzaTu = paramString18;
    this.zzaTv = paramString19;
    this.zzwN = paramString20;
    this.zzaTw = paramString21;
    this.zzaTx = paramItemScopeEntity6;
    this.zzaEl = paramDouble1;
    this.zzaTy = paramItemScopeEntity7;
    this.zzaEm = paramDouble2;
    this.mName = paramString22;
    this.zzaTz = paramItemScopeEntity8;
    this.zzaTA = paramList5;
    this.zzaTB = paramString23;
    this.zzaTC = paramString24;
    this.zzaTD = paramString25;
    this.zzaTE = paramString26;
    this.zzaTF = paramItemScopeEntity9;
    this.zzaTG = paramString27;
    this.zzaTH = paramString28;
    this.zzaTI = paramString29;
    this.zzaTJ = paramItemScopeEntity10;
    this.zzaTK = paramString30;
    this.zzaTL = paramString31;
    this.zzGq = paramString32;
    this.zzF = paramString33;
    this.zzaTM = paramString34;
    this.zzaTN = paramString35;
  }
  
  public ItemScopeEntity(Set<Integer> paramSet, ItemScopeEntity paramItemScopeEntity1, List<String> paramList, ItemScopeEntity paramItemScopeEntity2, String paramString1, String paramString2, String paramString3, List<ItemScopeEntity> paramList1, int paramInt, List<ItemScopeEntity> paramList2, ItemScopeEntity paramItemScopeEntity3, List<ItemScopeEntity> paramList3, String paramString4, String paramString5, ItemScopeEntity paramItemScopeEntity4, String paramString6, String paramString7, String paramString8, List<ItemScopeEntity> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ItemScopeEntity paramItemScopeEntity5, String paramString18, String paramString19, String paramString20, String paramString21, ItemScopeEntity paramItemScopeEntity6, double paramDouble1, ItemScopeEntity paramItemScopeEntity7, double paramDouble2, String paramString22, ItemScopeEntity paramItemScopeEntity8, List<ItemScopeEntity> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ItemScopeEntity paramItemScopeEntity9, String paramString27, String paramString28, String paramString29, ItemScopeEntity paramItemScopeEntity10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.zzaST = paramSet;
    this.mVersionCode = 1;
    this.zzaSU = paramItemScopeEntity1;
    this.zzaSV = paramList;
    this.zzaSW = paramItemScopeEntity2;
    this.zzaSX = paramString1;
    this.zzaSY = paramString2;
    this.zzaSZ = paramString3;
    this.zzaTa = paramList1;
    this.zzaTb = paramInt;
    this.zzaTc = paramList2;
    this.zzaTd = paramItemScopeEntity3;
    this.zzaTe = paramList3;
    this.zzaTf = paramString4;
    this.zzaTg = paramString5;
    this.zzaTh = paramItemScopeEntity4;
    this.zzaTi = paramString6;
    this.zzaTj = paramString7;
    this.zzsX = paramString8;
    this.zzaTk = paramList4;
    this.zzaTl = paramString9;
    this.zzaTm = paramString10;
    this.zzaTn = paramString11;
    this.zzaqZ = paramString12;
    this.zzaTo = paramString13;
    this.zzaTp = paramString14;
    this.zzaTq = paramString15;
    this.zzaTr = paramString16;
    this.zzaTs = paramString17;
    this.zzaTt = paramItemScopeEntity5;
    this.zzaTu = paramString18;
    this.zzaTv = paramString19;
    this.zzwN = paramString20;
    this.zzaTw = paramString21;
    this.zzaTx = paramItemScopeEntity6;
    this.zzaEl = paramDouble1;
    this.zzaTy = paramItemScopeEntity7;
    this.zzaEm = paramDouble2;
    this.mName = paramString22;
    this.zzaTz = paramItemScopeEntity8;
    this.zzaTA = paramList5;
    this.zzaTB = paramString23;
    this.zzaTC = paramString24;
    this.zzaTD = paramString25;
    this.zzaTE = paramString26;
    this.zzaTF = paramItemScopeEntity9;
    this.zzaTG = paramString27;
    this.zzaTH = paramString28;
    this.zzaTI = paramString29;
    this.zzaTJ = paramItemScopeEntity10;
    this.zzaTK = paramString30;
    this.zzaTL = paramString31;
    this.zzGq = paramString32;
    this.zzF = paramString33;
    this.zzaTM = paramString34;
    this.zzaTN = paramString35;
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ItemScopeEntity)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ItemScopeEntity)paramObject;
    Iterator localIterator = zzaSS.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (zza(localField))
      {
        if (((ItemScopeEntity)paramObject).zza(localField))
        {
          if (!zzb(localField).equals(((ItemScopeEntity)paramObject).zzb(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ItemScopeEntity)paramObject).zza(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public ItemScope getAbout()
  {
    return this.zzaSU;
  }
  
  public List<String> getAdditionalName()
  {
    return this.zzaSV;
  }
  
  public ItemScope getAddress()
  {
    return this.zzaSW;
  }
  
  public String getAddressCountry()
  {
    return this.zzaSX;
  }
  
  public String getAddressLocality()
  {
    return this.zzaSY;
  }
  
  public String getAddressRegion()
  {
    return this.zzaSZ;
  }
  
  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.zzaTa;
  }
  
  public int getAttendeeCount()
  {
    return this.zzaTb;
  }
  
  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.zzaTc;
  }
  
  public ItemScope getAudio()
  {
    return this.zzaTd;
  }
  
  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.zzaTe;
  }
  
  public String getBestRating()
  {
    return this.zzaTf;
  }
  
  public String getBirthDate()
  {
    return this.zzaTg;
  }
  
  public ItemScope getByArtist()
  {
    return this.zzaTh;
  }
  
  public String getCaption()
  {
    return this.zzaTi;
  }
  
  public String getContentSize()
  {
    return this.zzaTj;
  }
  
  public String getContentUrl()
  {
    return this.zzsX;
  }
  
  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.zzaTk;
  }
  
  public String getDateCreated()
  {
    return this.zzaTl;
  }
  
  public String getDateModified()
  {
    return this.zzaTm;
  }
  
  public String getDatePublished()
  {
    return this.zzaTn;
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public String getDuration()
  {
    return this.zzaTo;
  }
  
  public String getEmbedUrl()
  {
    return this.zzaTp;
  }
  
  public String getEndDate()
  {
    return this.zzaTq;
  }
  
  public String getFamilyName()
  {
    return this.zzaTr;
  }
  
  public String getGender()
  {
    return this.zzaTs;
  }
  
  public ItemScope getGeo()
  {
    return this.zzaTt;
  }
  
  public String getGivenName()
  {
    return this.zzaTu;
  }
  
  public String getHeight()
  {
    return this.zzaTv;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public String getImage()
  {
    return this.zzaTw;
  }
  
  public ItemScope getInAlbum()
  {
    return this.zzaTx;
  }
  
  public double getLatitude()
  {
    return this.zzaEl;
  }
  
  public ItemScope getLocation()
  {
    return this.zzaTy;
  }
  
  public double getLongitude()
  {
    return this.zzaEm;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ItemScope getPartOfTVSeries()
  {
    return this.zzaTz;
  }
  
  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.zzaTA;
  }
  
  public String getPlayerType()
  {
    return this.zzaTB;
  }
  
  public String getPostOfficeBoxNumber()
  {
    return this.zzaTC;
  }
  
  public String getPostalCode()
  {
    return this.zzaTD;
  }
  
  public String getRatingValue()
  {
    return this.zzaTE;
  }
  
  public ItemScope getReviewRating()
  {
    return this.zzaTF;
  }
  
  public String getStartDate()
  {
    return this.zzaTG;
  }
  
  public String getStreetAddress()
  {
    return this.zzaTH;
  }
  
  public String getText()
  {
    return this.zzaTI;
  }
  
  public ItemScope getThumbnail()
  {
    return this.zzaTJ;
  }
  
  public String getThumbnailUrl()
  {
    return this.zzaTK;
  }
  
  public String getTickerSymbol()
  {
    return this.zzaTL;
  }
  
  public String getType()
  {
    return this.zzGq;
  }
  
  public String getUrl()
  {
    return this.zzF;
  }
  
  public String getWidth()
  {
    return this.zzaTM;
  }
  
  public String getWorstRating()
  {
    return this.zzaTN;
  }
  
  public boolean hasAbout()
  {
    return this.zzaST.contains(Integer.valueOf(2));
  }
  
  public boolean hasAdditionalName()
  {
    return this.zzaST.contains(Integer.valueOf(3));
  }
  
  public boolean hasAddress()
  {
    return this.zzaST.contains(Integer.valueOf(4));
  }
  
  public boolean hasAddressCountry()
  {
    return this.zzaST.contains(Integer.valueOf(5));
  }
  
  public boolean hasAddressLocality()
  {
    return this.zzaST.contains(Integer.valueOf(6));
  }
  
  public boolean hasAddressRegion()
  {
    return this.zzaST.contains(Integer.valueOf(7));
  }
  
  public boolean hasAssociated_media()
  {
    return this.zzaST.contains(Integer.valueOf(8));
  }
  
  public boolean hasAttendeeCount()
  {
    return this.zzaST.contains(Integer.valueOf(9));
  }
  
  public boolean hasAttendees()
  {
    return this.zzaST.contains(Integer.valueOf(10));
  }
  
  public boolean hasAudio()
  {
    return this.zzaST.contains(Integer.valueOf(11));
  }
  
  public boolean hasAuthor()
  {
    return this.zzaST.contains(Integer.valueOf(12));
  }
  
  public boolean hasBestRating()
  {
    return this.zzaST.contains(Integer.valueOf(13));
  }
  
  public boolean hasBirthDate()
  {
    return this.zzaST.contains(Integer.valueOf(14));
  }
  
  public boolean hasByArtist()
  {
    return this.zzaST.contains(Integer.valueOf(15));
  }
  
  public boolean hasCaption()
  {
    return this.zzaST.contains(Integer.valueOf(16));
  }
  
  public boolean hasContentSize()
  {
    return this.zzaST.contains(Integer.valueOf(17));
  }
  
  public boolean hasContentUrl()
  {
    return this.zzaST.contains(Integer.valueOf(18));
  }
  
  public boolean hasContributor()
  {
    return this.zzaST.contains(Integer.valueOf(19));
  }
  
  public boolean hasDateCreated()
  {
    return this.zzaST.contains(Integer.valueOf(20));
  }
  
  public boolean hasDateModified()
  {
    return this.zzaST.contains(Integer.valueOf(21));
  }
  
  public boolean hasDatePublished()
  {
    return this.zzaST.contains(Integer.valueOf(22));
  }
  
  public boolean hasDescription()
  {
    return this.zzaST.contains(Integer.valueOf(23));
  }
  
  public boolean hasDuration()
  {
    return this.zzaST.contains(Integer.valueOf(24));
  }
  
  public boolean hasEmbedUrl()
  {
    return this.zzaST.contains(Integer.valueOf(25));
  }
  
  public boolean hasEndDate()
  {
    return this.zzaST.contains(Integer.valueOf(26));
  }
  
  public boolean hasFamilyName()
  {
    return this.zzaST.contains(Integer.valueOf(27));
  }
  
  public boolean hasGender()
  {
    return this.zzaST.contains(Integer.valueOf(28));
  }
  
  public boolean hasGeo()
  {
    return this.zzaST.contains(Integer.valueOf(29));
  }
  
  public boolean hasGivenName()
  {
    return this.zzaST.contains(Integer.valueOf(30));
  }
  
  public boolean hasHeight()
  {
    return this.zzaST.contains(Integer.valueOf(31));
  }
  
  public boolean hasId()
  {
    return this.zzaST.contains(Integer.valueOf(32));
  }
  
  public boolean hasImage()
  {
    return this.zzaST.contains(Integer.valueOf(33));
  }
  
  public boolean hasInAlbum()
  {
    return this.zzaST.contains(Integer.valueOf(34));
  }
  
  public boolean hasLatitude()
  {
    return this.zzaST.contains(Integer.valueOf(36));
  }
  
  public boolean hasLocation()
  {
    return this.zzaST.contains(Integer.valueOf(37));
  }
  
  public boolean hasLongitude()
  {
    return this.zzaST.contains(Integer.valueOf(38));
  }
  
  public boolean hasName()
  {
    return this.zzaST.contains(Integer.valueOf(39));
  }
  
  public boolean hasPartOfTVSeries()
  {
    return this.zzaST.contains(Integer.valueOf(40));
  }
  
  public boolean hasPerformers()
  {
    return this.zzaST.contains(Integer.valueOf(41));
  }
  
  public boolean hasPlayerType()
  {
    return this.zzaST.contains(Integer.valueOf(42));
  }
  
  public boolean hasPostOfficeBoxNumber()
  {
    return this.zzaST.contains(Integer.valueOf(43));
  }
  
  public boolean hasPostalCode()
  {
    return this.zzaST.contains(Integer.valueOf(44));
  }
  
  public boolean hasRatingValue()
  {
    return this.zzaST.contains(Integer.valueOf(45));
  }
  
  public boolean hasReviewRating()
  {
    return this.zzaST.contains(Integer.valueOf(46));
  }
  
  public boolean hasStartDate()
  {
    return this.zzaST.contains(Integer.valueOf(47));
  }
  
  public boolean hasStreetAddress()
  {
    return this.zzaST.contains(Integer.valueOf(48));
  }
  
  public boolean hasText()
  {
    return this.zzaST.contains(Integer.valueOf(49));
  }
  
  public boolean hasThumbnail()
  {
    return this.zzaST.contains(Integer.valueOf(50));
  }
  
  public boolean hasThumbnailUrl()
  {
    return this.zzaST.contains(Integer.valueOf(51));
  }
  
  public boolean hasTickerSymbol()
  {
    return this.zzaST.contains(Integer.valueOf(52));
  }
  
  public boolean hasType()
  {
    return this.zzaST.contains(Integer.valueOf(53));
  }
  
  public boolean hasUrl()
  {
    return this.zzaST.contains(Integer.valueOf(54));
  }
  
  public boolean hasWidth()
  {
    return this.zzaST.contains(Integer.valueOf(55));
  }
  
  public boolean hasWorstRating()
  {
    return this.zzaST.contains(Integer.valueOf(56));
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
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
  
  public HashMap<String, FastJsonResponse.Field<?, ?>> zzBK()
  {
    return zzaSS;
  }
  
  public ItemScopeEntity zzBL()
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
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzpK());
    case 2: 
      return this.zzaSU;
    case 3: 
      return this.zzaSV;
    case 4: 
      return this.zzaSW;
    case 5: 
      return this.zzaSX;
    case 6: 
      return this.zzaSY;
    case 7: 
      return this.zzaSZ;
    case 8: 
      return this.zzaTa;
    case 9: 
      return Integer.valueOf(this.zzaTb);
    case 10: 
      return this.zzaTc;
    case 11: 
      return this.zzaTd;
    case 12: 
      return this.zzaTe;
    case 13: 
      return this.zzaTf;
    case 14: 
      return this.zzaTg;
    case 15: 
      return this.zzaTh;
    case 16: 
      return this.zzaTi;
    case 17: 
      return this.zzaTj;
    case 18: 
      return this.zzsX;
    case 19: 
      return this.zzaTk;
    case 20: 
      return this.zzaTl;
    case 21: 
      return this.zzaTm;
    case 22: 
      return this.zzaTn;
    case 23: 
      return this.zzaqZ;
    case 24: 
      return this.zzaTo;
    case 25: 
      return this.zzaTp;
    case 26: 
      return this.zzaTq;
    case 27: 
      return this.zzaTr;
    case 28: 
      return this.zzaTs;
    case 29: 
      return this.zzaTt;
    case 30: 
      return this.zzaTu;
    case 31: 
      return this.zzaTv;
    case 32: 
      return this.zzwN;
    case 33: 
      return this.zzaTw;
    case 34: 
      return this.zzaTx;
    case 36: 
      return Double.valueOf(this.zzaEl);
    case 37: 
      return this.zzaTy;
    case 38: 
      return Double.valueOf(this.zzaEm);
    case 39: 
      return this.mName;
    case 40: 
      return this.zzaTz;
    case 41: 
      return this.zzaTA;
    case 42: 
      return this.zzaTB;
    case 43: 
      return this.zzaTC;
    case 44: 
      return this.zzaTD;
    case 45: 
      return this.zzaTE;
    case 46: 
      return this.zzaTF;
    case 47: 
      return this.zzaTG;
    case 48: 
      return this.zzaTH;
    case 49: 
      return this.zzaTI;
    case 50: 
      return this.zzaTJ;
    case 51: 
      return this.zzaTK;
    case 52: 
      return this.zzaTL;
    case 53: 
      return this.zzGq;
    case 54: 
      return this.zzF;
    case 55: 
      return this.zzaTM;
    }
    return this.zzaTN;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\model\moments\ItemScopeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */