package com.veryfit.multi.camera;

public class GalleryEntity
{
  private int count;
  private int gallery_id;
  private String gallery_name;
  private int id;
  private String path;
  
  public GalleryEntity() {}
  
  public GalleryEntity(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    this.id = paramInt1;
    this.path = paramString1;
    this.gallery_id = paramInt2;
    this.gallery_name = paramString2;
    this.count = paramInt3;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public int getGallery_id()
  {
    return this.gallery_id;
  }
  
  public String getGallery_name()
  {
    return this.gallery_name;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setGallery_id(int paramInt)
  {
    this.gallery_id = paramInt;
  }
  
  public void setGallery_name(String paramString)
  {
    this.gallery_name = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public String toString()
  {
    return "GalleryEntity [id=" + this.id + ", path=" + this.path + ", gallery_id=" + this.gallery_id + ", gallery_name=" + this.gallery_name + ", count=" + this.count + "]";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\GalleryEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */