package com.veryfit.multi.vo.json;

import java.io.Serializable;

public class DeviceUpdateInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int device_id;
  public String file;
  public String info_ch;
  public String info_en;
  public int version;
  
  public String toString()
  {
    return "[id = " + this.device_id + ",version = " + this.version + ",file = " + this.file + ",info_ch = " + this.info_ch + ",info_en = " + this.info_en + "]";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vo\json\DeviceUpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */