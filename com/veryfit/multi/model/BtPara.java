package com.veryfit.multi.model;

import java.io.Serializable;

public class BtPara
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long endDate;
  private String mac;
  private Long startDate;
  private String userName;
  
  public Long getEndDate()
  {
    return this.endDate;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public Long getStartDate()
  {
    return this.startDate;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setEndDate(Long paramLong)
  {
    this.endDate = paramLong;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setStartDate(Long paramLong)
  {
    this.startDate = paramLong;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtPara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */