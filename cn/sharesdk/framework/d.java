package cn.sharesdk.framework;

import android.graphics.Bitmap;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public abstract class d
{
  protected static final String ADDRESS = "address";
  protected static final String AUTHOR = "author";
  protected static final String COMMENT = "comment";
  protected static final String CONTENT_TYPE = "contentType";
  protected static final String CUSTOM_FLAG = "customFlag";
  protected static final String EXECUTE_URL = "executeUrl";
  protected static final String EXT_INFO = "extInfo";
  protected static final String FILE_PATH = "filePath";
  protected static final String GROPU_ID = "gropuId";
  protected static final String HIDDEN = "hidden";
  protected static final String IMAGE_ARRAY = "imageArray";
  protected static final String IMAGE_DATA = "imageData";
  protected static final String IMAGE_PATH = "imagePath";
  protected static final String IMAGE_URL = "imageUrl";
  protected static final String INSTALL_URL = "installUrl";
  protected static final String IS_FAMILY = "isFamily";
  protected static final String IS_FRIEND = "isFriend";
  protected static final String IS_PUBLIC = "isPublic";
  protected static final String IS_SHARE_TENCENT_WEIBO = "isShareTencentWeibo";
  protected static final String LATITUDE = "latitude";
  protected static final String LONGITUDE = "longitude";
  protected static final String MUSIC_URL = "musicUrl";
  protected static final String NOTEBOOK = "notebook";
  protected static final String SAFETY_LEVEL = "safetyLevel";
  protected static final String SCENCE = "scene";
  protected static final String SHARE_TYPE = "shareType";
  protected static final String SITE = "site";
  protected static final String SITE_URL = "siteUrl";
  protected static final String STACK = "stack";
  protected static final String TAGS = "tags";
  protected static final String TEXT = "text";
  protected static final String TITLE = "title";
  protected static final String TITLE_URL = "titleUrl";
  protected static final String URL = "url";
  protected static final String VENUE_DESCRIPTION = "venueDescription";
  protected static final String VENUE_NAME = "venueName";
  private HashMap<String, Object> params = new HashMap();
  
  public d() {}
  
  public d(String paramString)
  {
    this(new Hashon().fromJson(paramString));
  }
  
  public d(HashMap<String, Object> paramHashMap)
  {
    this();
    if (paramHashMap != null) {
      this.params.putAll(paramHashMap);
    }
  }
  
  public <T> T get(String paramString, Class<T> paramClass)
  {
    paramString = this.params.get(paramString);
    if (paramString != null) {
      return (T)paramClass.cast(paramString);
    }
    if ((Byte.class.equals(paramClass)) || (Byte.TYPE.equals(paramClass))) {
      return (T)paramClass.cast(new Byte((byte)0));
    }
    if ((Short.class.equals(paramClass)) || (Short.TYPE.equals(paramClass))) {
      return (T)paramClass.cast(new Short((short)0));
    }
    if ((Integer.class.equals(paramClass)) || (Integer.TYPE.equals(paramClass))) {
      return (T)paramClass.cast(new Integer(0));
    }
    if ((Long.class.equals(paramClass)) || (Long.TYPE.equals(paramClass))) {
      return (T)paramClass.cast(new Long(0L));
    }
    if ((Float.class.equals(paramClass)) || (Float.TYPE.equals(paramClass))) {
      return (T)paramClass.cast(new Float(0.0F));
    }
    if ((Double.class.equals(paramClass)) || (Double.TYPE.equals(paramClass))) {
      return (T)paramClass.cast(new Double(0.0D));
    }
    if ((Boolean.class.equals(paramClass)) || (Boolean.TYPE.equals(paramClass))) {
      return (T)paramClass.cast(Boolean.valueOf(false));
    }
    return null;
  }
  
  public String getAddress()
  {
    return (String)get("address", String.class);
  }
  
  public String getAuthor()
  {
    return (String)get("author", String.class);
  }
  
  public String getComment()
  {
    return (String)get("comment", String.class);
  }
  
  public int getContentType()
  {
    return ((Integer)get("contentType", Integer.class)).intValue();
  }
  
  public String[] getCustomFlag()
  {
    return (String[])get("customFlag", String[].class);
  }
  
  public String getExecuteUrl()
  {
    return (String)get("executeUrl", String.class);
  }
  
  public String getExtInfo()
  {
    return (String)get("extInfo", String.class);
  }
  
  public String getFilePath()
  {
    return (String)get("filePath", String.class);
  }
  
  public String getGroupId()
  {
    return (String)get("gropuId", String.class);
  }
  
  public int getHidden()
  {
    return ((Integer)get("hidden", Integer.class)).intValue();
  }
  
  public String[] getImageArray()
  {
    return (String[])get("imageArray", String[].class);
  }
  
  public Bitmap getImageData()
  {
    return (Bitmap)get("imageData", Bitmap.class);
  }
  
  public String getImagePath()
  {
    return (String)get("imagePath", String.class);
  }
  
  public String getImageUrl()
  {
    return (String)get("imageUrl", String.class);
  }
  
  public String getInstallUrl()
  {
    return (String)get("installUrl", String.class);
  }
  
  public float getLatitude()
  {
    return ((Float)get("latitude", Float.class)).floatValue();
  }
  
  public float getLongitude()
  {
    return ((Float)get("longitude", Float.class)).floatValue();
  }
  
  public String getMusicUrl()
  {
    return (String)get("musicUrl", String.class);
  }
  
  public String getNotebook()
  {
    return (String)get("notebook", String.class);
  }
  
  public int getSafetyLevel()
  {
    return ((Integer)get("safetyLevel", Integer.class)).intValue();
  }
  
  public int getScence()
  {
    return ((Integer)get("scene", Integer.class)).intValue();
  }
  
  public int getShareType()
  {
    return ((Integer)get("shareType", Integer.class)).intValue();
  }
  
  public String getSite()
  {
    return (String)get("site", String.class);
  }
  
  public String getSiteUrl()
  {
    return (String)get("siteUrl", String.class);
  }
  
  public String getStack()
  {
    return (String)get("stack", String.class);
  }
  
  public String[] getTags()
  {
    return (String[])get("tags", String[].class);
  }
  
  public String getText()
  {
    return (String)get("text", String.class);
  }
  
  public String getTitle()
  {
    return (String)get("title", String.class);
  }
  
  public String getTitleUrl()
  {
    return (String)get("titleUrl", String.class);
  }
  
  public String getUrl()
  {
    return (String)get("url", String.class);
  }
  
  public String getVenueDescription()
  {
    return (String)get("venueDescription", String.class);
  }
  
  public String getVenueName()
  {
    return (String)get("venueName", String.class);
  }
  
  public boolean isFamily()
  {
    return ((Boolean)get("isFamily", Boolean.class)).booleanValue();
  }
  
  public boolean isFriend()
  {
    return ((Boolean)get("isFriend", Boolean.class)).booleanValue();
  }
  
  public boolean isPublic()
  {
    return ((Boolean)get("isPublic", Boolean.class)).booleanValue();
  }
  
  public boolean isShareTencentWeibo()
  {
    return ((Boolean)get("isShareTencentWeibo", Boolean.class)).booleanValue();
  }
  
  public void set(String paramString, Object paramObject)
  {
    this.params.put(paramString, paramObject);
  }
  
  public void setAddress(String paramString)
  {
    set("address", paramString);
  }
  
  public void setAuthor(String paramString)
  {
    set("author", paramString);
  }
  
  public void setComment(String paramString)
  {
    set("comment", paramString);
  }
  
  public void setContentType(int paramInt)
  {
    set("contentType", Integer.valueOf(paramInt));
  }
  
  public void setCustomFlag(String[] paramArrayOfString)
  {
    set("customFlag", paramArrayOfString);
  }
  
  public void setExecuteUrl()
  {
    set("executeUrl", String.class);
  }
  
  public void setExtInfo(String paramString)
  {
    set("extInfo", paramString);
  }
  
  public void setFamily(boolean paramBoolean)
  {
    set("isFamily", Boolean.valueOf(paramBoolean));
  }
  
  public void setFilePath(String paramString)
  {
    set("filePath", paramString);
  }
  
  public void setFriend(boolean paramBoolean)
  {
    set("isFriend", Boolean.valueOf(paramBoolean));
  }
  
  public void setGroupId(String paramString)
  {
    set("gropuId", paramString);
  }
  
  public void setHidden(int paramInt)
  {
    set("hidden", Integer.valueOf(paramInt));
  }
  
  public void setImageArray(String[] paramArrayOfString)
  {
    set("imageArray", paramArrayOfString);
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    set("imageData", paramBitmap);
  }
  
  public void setImagePath(String paramString)
  {
    set("imagePath", paramString);
  }
  
  public void setImageUrl(String paramString)
  {
    set("imageUrl", paramString);
  }
  
  public void setInstallUrl()
  {
    set("installUrl", String.class);
  }
  
  public void setLatitude(float paramFloat)
  {
    set("latitude", Float.valueOf(paramFloat));
  }
  
  public void setLongitude(float paramFloat)
  {
    set("longitude", Float.valueOf(paramFloat));
  }
  
  public void setMusicUrl(String paramString)
  {
    set("musicUrl", paramString);
  }
  
  public void setNotebook(String paramString)
  {
    set("notebook", paramString);
  }
  
  public void setPublic(boolean paramBoolean)
  {
    set("isPublic", Boolean.valueOf(paramBoolean));
  }
  
  public void setSafetyLevel(int paramInt)
  {
    set("safetyLevel", Integer.valueOf(paramInt));
  }
  
  public void setScence(int paramInt)
  {
    set("scene", Integer.valueOf(paramInt));
  }
  
  public void setShareTencentWeibo(boolean paramBoolean)
  {
    set("isShareTencentWeibo", Boolean.valueOf(paramBoolean));
  }
  
  public void setShareType(int paramInt)
  {
    set("shareType", Integer.valueOf(paramInt));
  }
  
  public void setSite(String paramString)
  {
    set("site", paramString);
  }
  
  public void setSiteUrl(String paramString)
  {
    set("siteUrl", paramString);
  }
  
  public void setStack(String paramString)
  {
    set("stack", paramString);
  }
  
  public void setTags(String[] paramArrayOfString)
  {
    set("tags", paramArrayOfString);
  }
  
  public void setText(String paramString)
  {
    set("text", paramString);
  }
  
  public void setTitle(String paramString)
  {
    set("title", paramString);
  }
  
  public void setTitleUrl(String paramString)
  {
    set("titleUrl", paramString);
  }
  
  public void setUrl(String paramString)
  {
    set("url", paramString);
  }
  
  public void setVenueDescription(String paramString)
  {
    set("venueDescription", paramString);
  }
  
  public void setVenueName(String paramString)
  {
    set("venueName", paramString);
  }
  
  public HashMap<String, Object> toMap()
  {
    if (this.params == null) {
      return new HashMap();
    }
    return this.params;
  }
  
  public String toString()
  {
    try
    {
      String str = new Hashon().fromHashMap(this.params);
      return str;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */