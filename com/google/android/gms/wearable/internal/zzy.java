package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class zzy
  implements DataEvent
{
  private int zzWJ;
  private DataItem zzbgv;
  
  public zzy(DataEvent paramDataEvent)
  {
    this.zzWJ = paramDataEvent.getType();
    this.zzbgv = ((DataItem)paramDataEvent.getDataItem().freeze());
  }
  
  public DataItem getDataItem()
  {
    return this.zzbgv;
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    String str;
    if (getType() == 1) {
      str = "changed";
    }
    for (;;)
    {
      return "DataEventEntity{ type=" + str + ", dataitem=" + getDataItem() + " }";
      if (getType() == 2) {
        str = "deleted";
      } else {
        str = "unknown";
      }
    }
  }
  
  public DataEvent zzEZ()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */