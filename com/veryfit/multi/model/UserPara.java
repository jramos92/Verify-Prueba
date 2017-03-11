package com.veryfit.multi.model;

import java.io.Serializable;

public class UserPara
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String newpwd;
  private String oldpwd;
  private String userName;
  
  public Integer getId()
  {
    return this.id;
  }
  
  public String getNewpwd()
  {
    return this.newpwd;
  }
  
  public String getOldpwd()
  {
    return this.oldpwd;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }
  
  public void setNewpwd(String paramString)
  {
    this.newpwd = paramString;
  }
  
  public void setOldpwd(String paramString)
  {
    this.oldpwd = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\UserPara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */