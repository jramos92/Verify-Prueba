package com.veryfit.multi.model;

import java.io.Serializable;

public class BtTarget
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private int deviceId;
  private String mac;
  private int moveTarget;
  private int sleepTarget;
  private long tdate;
  private int uId;
  private String userName;
  
  public int getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public int getMoveTarget()
  {
    return this.moveTarget;
  }
  
  public int getSleepTarget()
  {
    return this.sleepTarget;
  }
  
  public long getTdate()
  {
    return this.tdate;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public int getuId()
  {
    return this.uId;
  }
  
  public void setDeviceId(int paramInt)
  {
    this.deviceId = paramInt;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setMoveTarget(int paramInt)
  {
    this.moveTarget = paramInt;
  }
  
  public void setSleepTarget(int paramInt)
  {
    this.sleepTarget = paramInt;
  }
  
  public void setTdate(long paramLong)
  {
    this.tdate = paramLong;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public void setuId(int paramInt)
  {
    this.uId = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */