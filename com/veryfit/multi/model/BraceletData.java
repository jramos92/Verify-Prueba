package com.veryfit.multi.model;

import java.io.Serializable;
import java.util.List;

public class BraceletData
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List<BtAlarm> alarmList;
  private Bracelet bracelet;
  private Device device;
  String mac;
  private List<BtTarget> targetList;
  String userName;
  
  public List<BtAlarm> getAlarmList()
  {
    return this.alarmList;
  }
  
  public Bracelet getBracelet()
  {
    return this.bracelet;
  }
  
  public Device getDevice()
  {
    return this.device;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public List<BtTarget> getTargetList()
  {
    return this.targetList;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setAlarmList(List<BtAlarm> paramList)
  {
    this.alarmList = paramList;
  }
  
  public void setBracelet(Bracelet paramBracelet)
  {
    this.bracelet = paramBracelet;
  }
  
  public void setDevice(Device paramDevice)
  {
    this.device = paramDevice;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setTargetList(List<BtTarget> paramList)
  {
    this.targetList = paramList;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BraceletData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */