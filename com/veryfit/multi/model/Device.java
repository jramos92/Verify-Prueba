package com.veryfit.multi.model;

import java.io.Serializable;

public class Device
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer dtype;
  private Integer id;
  private String mac;
  private String name;
  private Integer uid;
  
  public Integer getDtype()
  {
    return this.dtype;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Integer getUid()
  {
    return this.uid;
  }
  
  public void setDtype(Integer paramInteger)
  {
    this.dtype = paramInteger;
  }
  
  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setUid(Integer paramInteger)
  {
    this.uid = paramInteger;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */