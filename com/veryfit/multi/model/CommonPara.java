package com.veryfit.multi.model;

import java.io.Serializable;

public class CommonPara
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String mac;
  private Integer uId;
  private String userName;
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public Integer getuId()
  {
    return this.uId;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public void setuId(Integer paramInteger)
  {
    this.uId = paramInteger;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\CommonPara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */