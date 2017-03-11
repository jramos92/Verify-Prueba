package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract interface ItemScope
  extends Freezable<ItemScope>
{
  public abstract ItemScope getAbout();
  
  public abstract List<String> getAdditionalName();
  
  public abstract ItemScope getAddress();
  
  public abstract String getAddressCountry();
  
  public abstract String getAddressLocality();
  
  public abstract String getAddressRegion();
  
  public abstract List<ItemScope> getAssociated_media();
  
  public abstract int getAttendeeCount();
  
  public abstract List<ItemScope> getAttendees();
  
  public abstract ItemScope getAudio();
  
  public abstract List<ItemScope> getAuthor();
  
  public abstract String getBestRating();
  
  public abstract String getBirthDate();
  
  public abstract ItemScope getByArtist();
  
  public abstract String getCaption();
  
  public abstract String getContentSize();
  
  public abstract String getContentUrl();
  
  public abstract List<ItemScope> getContributor();
  
  public abstract String getDateCreated();
  
  public abstract String getDateModified();
  
  public abstract String getDatePublished();
  
  public abstract String getDescription();
  
  public abstract String getDuration();
  
  public abstract String getEmbedUrl();
  
  public abstract String getEndDate();
  
  public abstract String getFamilyName();
  
  public abstract String getGender();
  
  public abstract ItemScope getGeo();
  
  public abstract String getGivenName();
  
  public abstract String getHeight();
  
  public abstract String getId();
  
  public abstract String getImage();
  
  public abstract ItemScope getInAlbum();
  
  public abstract double getLatitude();
  
  public abstract ItemScope getLocation();
  
  public abstract double getLongitude();
  
  public abstract String getName();
  
  public abstract ItemScope getPartOfTVSeries();
  
  public abstract List<ItemScope> getPerformers();
  
  public abstract String getPlayerType();
  
  public abstract String getPostOfficeBoxNumber();
  
  public abstract String getPostalCode();
  
  public abstract String getRatingValue();
  
  public abstract ItemScope getReviewRating();
  
  public abstract String getStartDate();
  
  public abstract String getStreetAddress();
  
  public abstract String getText();
  
  public abstract ItemScope getThumbnail();
  
  public abstract String getThumbnailUrl();
  
  public abstract String getTickerSymbol();
  
  public abstract String getType();
  
  public abstract String getUrl();
  
  public abstract String getWidth();
  
  public abstract String getWorstRating();
  
  public abstract boolean hasAbout();
  
  public abstract boolean hasAdditionalName();
  
  public abstract boolean hasAddress();
  
  public abstract boolean hasAddressCountry();
  
  public abstract boolean hasAddressLocality();
  
  public abstract boolean hasAddressRegion();
  
  public abstract boolean hasAssociated_media();
  
  public abstract boolean hasAttendeeCount();
  
  public abstract boolean hasAttendees();
  
  public abstract boolean hasAudio();
  
  public abstract boolean hasAuthor();
  
  public abstract boolean hasBestRating();
  
  public abstract boolean hasBirthDate();
  
  public abstract boolean hasByArtist();
  
  public abstract boolean hasCaption();
  
  public abstract boolean hasContentSize();
  
  public abstract boolean hasContentUrl();
  
  public abstract boolean hasContributor();
  
  public abstract boolean hasDateCreated();
  
  public abstract boolean hasDateModified();
  
  public abstract boolean hasDatePublished();
  
  public abstract boolean hasDescription();
  
  public abstract boolean hasDuration();
  
  public abstract boolean hasEmbedUrl();
  
  public abstract boolean hasEndDate();
  
  public abstract boolean hasFamilyName();
  
  public abstract boolean hasGender();
  
  public abstract boolean hasGeo();
  
  public abstract boolean hasGivenName();
  
  public abstract boolean hasHeight();
  
  public abstract boolean hasId();
  
  public abstract boolean hasImage();
  
  public abstract boolean hasInAlbum();
  
  public abstract boolean hasLatitude();
  
  public abstract boolean hasLocation();
  
  public abstract boolean hasLongitude();
  
  public abstract boolean hasName();
  
  public abstract boolean hasPartOfTVSeries();
  
  public abstract boolean hasPerformers();
  
  public abstract boolean hasPlayerType();
  
  public abstract boolean hasPostOfficeBoxNumber();
  
  public abstract boolean hasPostalCode();
  
  public abstract boolean hasRatingValue();
  
  public abstract boolean hasReviewRating();
  
  public abstract boolean hasStartDate();
  
  public abstract boolean hasStreetAddress();
  
  public abstract boolean hasText();
  
  public abstract boolean hasThumbnail();
  
  public abstract boolean hasThumbnailUrl();
  
  public abstract boolean hasTickerSymbol();
  
  public abstract boolean hasType();
  
  public abstract boolean hasUrl();
  
  public abstract boolean hasWidth();
  
  public abstract boolean hasWorstRating();
  
  public static class Builder
  {
    private String mName;
    private String zzF;
    private String zzGq;
    private double zzaEl;
    private double zzaEm;
    private final Set<Integer> zzaST = new HashSet();
    private ItemScopeEntity zzaSU;
    private List<String> zzaSV;
    private ItemScopeEntity zzaSW;
    private String zzaSX;
    private String zzaSY;
    private String zzaSZ;
    private List<ItemScopeEntity> zzaTA;
    private String zzaTB;
    private String zzaTC;
    private String zzaTD;
    private String zzaTE;
    private ItemScopeEntity zzaTF;
    private String zzaTG;
    private String zzaTH;
    private String zzaTI;
    private ItemScopeEntity zzaTJ;
    private String zzaTK;
    private String zzaTL;
    private String zzaTM;
    private String zzaTN;
    private List<ItemScopeEntity> zzaTa;
    private int zzaTb;
    private List<ItemScopeEntity> zzaTc;
    private ItemScopeEntity zzaTd;
    private List<ItemScopeEntity> zzaTe;
    private String zzaTf;
    private String zzaTg;
    private ItemScopeEntity zzaTh;
    private String zzaTi;
    private String zzaTj;
    private List<ItemScopeEntity> zzaTk;
    private String zzaTl;
    private String zzaTm;
    private String zzaTn;
    private String zzaTo;
    private String zzaTp;
    private String zzaTq;
    private String zzaTr;
    private String zzaTs;
    private ItemScopeEntity zzaTt;
    private String zzaTu;
    private String zzaTv;
    private String zzaTw;
    private ItemScopeEntity zzaTx;
    private ItemScopeEntity zzaTy;
    private ItemScopeEntity zzaTz;
    private String zzaqZ;
    private String zzsX;
    private String zzwN;
    
    public ItemScope build()
    {
      return new ItemScopeEntity(this.zzaST, this.zzaSU, this.zzaSV, this.zzaSW, this.zzaSX, this.zzaSY, this.zzaSZ, this.zzaTa, this.zzaTb, this.zzaTc, this.zzaTd, this.zzaTe, this.zzaTf, this.zzaTg, this.zzaTh, this.zzaTi, this.zzaTj, this.zzsX, this.zzaTk, this.zzaTl, this.zzaTm, this.zzaTn, this.zzaqZ, this.zzaTo, this.zzaTp, this.zzaTq, this.zzaTr, this.zzaTs, this.zzaTt, this.zzaTu, this.zzaTv, this.zzwN, this.zzaTw, this.zzaTx, this.zzaEl, this.zzaTy, this.zzaEm, this.mName, this.zzaTz, this.zzaTA, this.zzaTB, this.zzaTC, this.zzaTD, this.zzaTE, this.zzaTF, this.zzaTG, this.zzaTH, this.zzaTI, this.zzaTJ, this.zzaTK, this.zzaTL, this.zzGq, this.zzF, this.zzaTM, this.zzaTN);
    }
    
    public Builder setAbout(ItemScope paramItemScope)
    {
      this.zzaSU = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setAdditionalName(List<String> paramList)
    {
      this.zzaSV = paramList;
      this.zzaST.add(Integer.valueOf(3));
      return this;
    }
    
    public Builder setAddress(ItemScope paramItemScope)
    {
      this.zzaSW = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setAddressCountry(String paramString)
    {
      this.zzaSX = paramString;
      this.zzaST.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setAddressLocality(String paramString)
    {
      this.zzaSY = paramString;
      this.zzaST.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setAddressRegion(String paramString)
    {
      this.zzaSZ = paramString;
      this.zzaST.add(Integer.valueOf(7));
      return this;
    }
    
    public Builder setAssociated_media(List<ItemScope> paramList)
    {
      this.zzaTa = paramList;
      this.zzaST.add(Integer.valueOf(8));
      return this;
    }
    
    public Builder setAttendeeCount(int paramInt)
    {
      this.zzaTb = paramInt;
      this.zzaST.add(Integer.valueOf(9));
      return this;
    }
    
    public Builder setAttendees(List<ItemScope> paramList)
    {
      this.zzaTc = paramList;
      this.zzaST.add(Integer.valueOf(10));
      return this;
    }
    
    public Builder setAudio(ItemScope paramItemScope)
    {
      this.zzaTd = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(11));
      return this;
    }
    
    public Builder setAuthor(List<ItemScope> paramList)
    {
      this.zzaTe = paramList;
      this.zzaST.add(Integer.valueOf(12));
      return this;
    }
    
    public Builder setBestRating(String paramString)
    {
      this.zzaTf = paramString;
      this.zzaST.add(Integer.valueOf(13));
      return this;
    }
    
    public Builder setBirthDate(String paramString)
    {
      this.zzaTg = paramString;
      this.zzaST.add(Integer.valueOf(14));
      return this;
    }
    
    public Builder setByArtist(ItemScope paramItemScope)
    {
      this.zzaTh = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(15));
      return this;
    }
    
    public Builder setCaption(String paramString)
    {
      this.zzaTi = paramString;
      this.zzaST.add(Integer.valueOf(16));
      return this;
    }
    
    public Builder setContentSize(String paramString)
    {
      this.zzaTj = paramString;
      this.zzaST.add(Integer.valueOf(17));
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      this.zzsX = paramString;
      this.zzaST.add(Integer.valueOf(18));
      return this;
    }
    
    public Builder setContributor(List<ItemScope> paramList)
    {
      this.zzaTk = paramList;
      this.zzaST.add(Integer.valueOf(19));
      return this;
    }
    
    public Builder setDateCreated(String paramString)
    {
      this.zzaTl = paramString;
      this.zzaST.add(Integer.valueOf(20));
      return this;
    }
    
    public Builder setDateModified(String paramString)
    {
      this.zzaTm = paramString;
      this.zzaST.add(Integer.valueOf(21));
      return this;
    }
    
    public Builder setDatePublished(String paramString)
    {
      this.zzaTn = paramString;
      this.zzaST.add(Integer.valueOf(22));
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.zzaqZ = paramString;
      this.zzaST.add(Integer.valueOf(23));
      return this;
    }
    
    public Builder setDuration(String paramString)
    {
      this.zzaTo = paramString;
      this.zzaST.add(Integer.valueOf(24));
      return this;
    }
    
    public Builder setEmbedUrl(String paramString)
    {
      this.zzaTp = paramString;
      this.zzaST.add(Integer.valueOf(25));
      return this;
    }
    
    public Builder setEndDate(String paramString)
    {
      this.zzaTq = paramString;
      this.zzaST.add(Integer.valueOf(26));
      return this;
    }
    
    public Builder setFamilyName(String paramString)
    {
      this.zzaTr = paramString;
      this.zzaST.add(Integer.valueOf(27));
      return this;
    }
    
    public Builder setGender(String paramString)
    {
      this.zzaTs = paramString;
      this.zzaST.add(Integer.valueOf(28));
      return this;
    }
    
    public Builder setGeo(ItemScope paramItemScope)
    {
      this.zzaTt = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(29));
      return this;
    }
    
    public Builder setGivenName(String paramString)
    {
      this.zzaTu = paramString;
      this.zzaST.add(Integer.valueOf(30));
      return this;
    }
    
    public Builder setHeight(String paramString)
    {
      this.zzaTv = paramString;
      this.zzaST.add(Integer.valueOf(31));
      return this;
    }
    
    public Builder setId(String paramString)
    {
      this.zzwN = paramString;
      this.zzaST.add(Integer.valueOf(32));
      return this;
    }
    
    public Builder setImage(String paramString)
    {
      this.zzaTw = paramString;
      this.zzaST.add(Integer.valueOf(33));
      return this;
    }
    
    public Builder setInAlbum(ItemScope paramItemScope)
    {
      this.zzaTx = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(34));
      return this;
    }
    
    public Builder setLatitude(double paramDouble)
    {
      this.zzaEl = paramDouble;
      this.zzaST.add(Integer.valueOf(36));
      return this;
    }
    
    public Builder setLocation(ItemScope paramItemScope)
    {
      this.zzaTy = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(37));
      return this;
    }
    
    public Builder setLongitude(double paramDouble)
    {
      this.zzaEm = paramDouble;
      this.zzaST.add(Integer.valueOf(38));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      this.zzaST.add(Integer.valueOf(39));
      return this;
    }
    
    public Builder setPartOfTVSeries(ItemScope paramItemScope)
    {
      this.zzaTz = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(40));
      return this;
    }
    
    public Builder setPerformers(List<ItemScope> paramList)
    {
      this.zzaTA = paramList;
      this.zzaST.add(Integer.valueOf(41));
      return this;
    }
    
    public Builder setPlayerType(String paramString)
    {
      this.zzaTB = paramString;
      this.zzaST.add(Integer.valueOf(42));
      return this;
    }
    
    public Builder setPostOfficeBoxNumber(String paramString)
    {
      this.zzaTC = paramString;
      this.zzaST.add(Integer.valueOf(43));
      return this;
    }
    
    public Builder setPostalCode(String paramString)
    {
      this.zzaTD = paramString;
      this.zzaST.add(Integer.valueOf(44));
      return this;
    }
    
    public Builder setRatingValue(String paramString)
    {
      this.zzaTE = paramString;
      this.zzaST.add(Integer.valueOf(45));
      return this;
    }
    
    public Builder setReviewRating(ItemScope paramItemScope)
    {
      this.zzaTF = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(46));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.zzaTG = paramString;
      this.zzaST.add(Integer.valueOf(47));
      return this;
    }
    
    public Builder setStreetAddress(String paramString)
    {
      this.zzaTH = paramString;
      this.zzaST.add(Integer.valueOf(48));
      return this;
    }
    
    public Builder setText(String paramString)
    {
      this.zzaTI = paramString;
      this.zzaST.add(Integer.valueOf(49));
      return this;
    }
    
    public Builder setThumbnail(ItemScope paramItemScope)
    {
      this.zzaTJ = ((ItemScopeEntity)paramItemScope);
      this.zzaST.add(Integer.valueOf(50));
      return this;
    }
    
    public Builder setThumbnailUrl(String paramString)
    {
      this.zzaTK = paramString;
      this.zzaST.add(Integer.valueOf(51));
      return this;
    }
    
    public Builder setTickerSymbol(String paramString)
    {
      this.zzaTL = paramString;
      this.zzaST.add(Integer.valueOf(52));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.zzGq = paramString;
      this.zzaST.add(Integer.valueOf(53));
      return this;
    }
    
    public Builder setUrl(String paramString)
    {
      this.zzF = paramString;
      this.zzaST.add(Integer.valueOf(54));
      return this;
    }
    
    public Builder setWidth(String paramString)
    {
      this.zzaTM = paramString;
      this.zzaST.add(Integer.valueOf(55));
      return this;
    }
    
    public Builder setWorstRating(String paramString)
    {
      this.zzaTN = paramString;
      this.zzaST.add(Integer.valueOf(56));
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\model\moments\ItemScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */