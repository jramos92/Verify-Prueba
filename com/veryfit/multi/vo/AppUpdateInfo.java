package com.veryfit.multi.vo;

import java.io.Serializable;

public class AppUpdateInfo
  implements Serializable
{
  private static final long serialVersionUID = 1074991111407173719L;
  private String updateInfo_cn;
  private String updateInfo_en;
  private String url;
  private int versionCode;
  private String versionName;
  
  public String getUpdateInfo_cn()
  {
    return this.updateInfo_cn;
  }
  
  public String getUpdateInfo_en()
  {
    return this.updateInfo_en;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public String getVersionName()
  {
    return this.versionName;
  }
  
  public void setUpdateInfo_cn(String paramString)
  {
    this.updateInfo_cn = paramString;
  }
  
  public void setUpdateInfo_en(String paramString)
  {
    this.updateInfo_en = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
  
  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vo\AppUpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */