package com.project.library.core;

import com.project.library.database.SportDataDay;
import java.util.List;

public abstract interface CoreServiceListener
{
  public abstract void onAppControlSuccess(byte paramByte, boolean paramBoolean);
  
  public abstract void onBLEConnectTimeOut();
  
  public abstract void onBLEConnected();
  
  public abstract void onBLEConnecting();
  
  public abstract void onBLEDisConnected(String paramString);
  
  public abstract void onBindUnbind(byte paramByte);
  
  public abstract void onBleControlReceive(byte paramByte1, byte paramByte2);
  
  public abstract void onBlueToothError(int paramInt);
  
  public abstract void onCoreServiceConnected();
  
  public abstract void onCoreServiceDisconnected();
  
  public abstract void onDataChanged(List<SportDataDay> paramList);
  
  public abstract void onDataReceived(byte[] paramArrayOfByte);
  
  public abstract void onDataSendTimeOut(byte[] paramArrayOfByte);
  
  public abstract void onGetInfo(byte paramByte);
  
  public abstract void onOtherDataReceive(byte[] paramArrayOfByte);
  
  public abstract void onSettingsSuccess(byte paramByte, boolean paramBoolean);
  
  public abstract void onSyncData(int paramInt);
  
  public abstract void onWareUpdate(byte paramByte);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\core\CoreServiceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */