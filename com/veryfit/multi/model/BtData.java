package com.veryfit.multi.model;

import java.io.Serializable;
import java.util.List;

public class BtData
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List<BtHealthDataMax> btHealthDataMaxList;
  private List<BtHeartRate> btHeartRateList;
  private List<BtHeartRateThreshold> btHeartRateThresholdList;
  private List<BtSleepDataDay> btSleepDataDayList;
  private List<BtSleepDataItem> btSleepDataItemList;
  private List<BtSportDataDay> btSportDataDayList;
  private List<BtSportDataItem> btSportDataItemList;
  private String mac;
  private String userName;
  
  public List<BtHealthDataMax> getBtHealthDataMaxList()
  {
    return this.btHealthDataMaxList;
  }
  
  public List<BtHeartRate> getBtHeartRateList()
  {
    return this.btHeartRateList;
  }
  
  public List<BtHeartRateThreshold> getBtHeartRateThresholdList()
  {
    return this.btHeartRateThresholdList;
  }
  
  public List<BtSleepDataDay> getBtSleepDataDayList()
  {
    return this.btSleepDataDayList;
  }
  
  public List<BtSleepDataItem> getBtSleepDataItemList()
  {
    return this.btSleepDataItemList;
  }
  
  public List<BtSportDataDay> getBtSportDataDayList()
  {
    return this.btSportDataDayList;
  }
  
  public List<BtSportDataItem> getBtSportDataItemList()
  {
    return this.btSportDataItemList;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setBtHealthDataMaxList(List<BtHealthDataMax> paramList)
  {
    this.btHealthDataMaxList = paramList;
  }
  
  public void setBtHeartRateList(List<BtHeartRate> paramList)
  {
    this.btHeartRateList = paramList;
  }
  
  public void setBtHeartRateThresholdList(List<BtHeartRateThreshold> paramList)
  {
    this.btHeartRateThresholdList = paramList;
  }
  
  public void setBtSleepDataDayList(List<BtSleepDataDay> paramList)
  {
    this.btSleepDataDayList = paramList;
  }
  
  public void setBtSleepDataItemList(List<BtSleepDataItem> paramList)
  {
    this.btSleepDataItemList = paramList;
  }
  
  public void setBtSportDataDayList(List<BtSportDataDay> paramList)
  {
    this.btSportDataDayList = paramList;
  }
  
  public void setBtSportDataItemList(List<BtSportDataItem> paramList)
  {
    this.btSportDataItemList = paramList;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */