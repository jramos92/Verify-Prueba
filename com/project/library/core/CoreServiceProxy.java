package com.project.library.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.project.library.ble.BleConnectService;
import com.project.library.database.SportDataDay;
import com.project.library.util.DebugLog;
import com.project.library.util.UartLogUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CoreServiceProxy
{
  private static CoreServiceProxy sInstance = null;
  private final ICoreServiceCallback.Stub mCallback = new ICoreServiceCallback.Stub()
  {
    public void onAppControlSuccess(final byte paramAnonymousByte, final boolean paramAnonymousBoolean)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onAppControlSuccess.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onAppControlSuccess(paramAnonymousByte, paramAnonymousBoolean);
          }
        }
      });
    }
    
    public void onBLEConnectTimeOut()
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onBLEConnectTimeOut.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onBLEConnectTimeOut();
          }
        }
      });
    }
    
    public void onBLEConnected()
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onBLEConnected.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onBLEConnected();
          }
        }
      });
    }
    
    public void onBLEConnecting()
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onBLEConnecting.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onBLEConnecting();
          }
        }
      });
    }
    
    public void onBLEDisConnected(final String paramAnonymousString)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onBLEDisConnected.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onBLEDisConnected(paramAnonymousString);
          }
        }
      });
    }
    
    public void onBindUnbind(final byte paramAnonymousByte)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onBindUnbind.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onBindUnbind(paramAnonymousByte);
          }
        }
      });
    }
    
    public void onBleControlReceive(final byte paramAnonymousByte1, final byte paramAnonymousByte2)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onBleControlReceive.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onBleControlReceive(paramAnonymousByte1, paramAnonymousByte2);
          }
        }
      });
    }
    
    public void onBlueToothError(final int paramAnonymousInt)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onBlueToothError.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onBlueToothError(paramAnonymousInt);
          }
        }
      });
    }
    
    public void onDataChanged(final List<SportDataDay> paramAnonymousList)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onDataChanged.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onDataChanged(paramAnonymousList);
          }
        }
      });
    }
    
    public void onDataReceived(final byte[] paramAnonymousArrayOfByte)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onDataReceived.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onDataReceived(paramAnonymousArrayOfByte);
          }
        }
      });
    }
    
    public void onDataSendTimeOut(final byte[] paramAnonymousArrayOfByte)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onDataSendTimeOut.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onDataSendTimeOut(paramAnonymousArrayOfByte);
          }
        }
      });
    }
    
    public void onGetInfo(final byte paramAnonymousByte)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onGetInfo.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onGetInfo(paramAnonymousByte);
          }
        }
      });
    }
    
    public void onOtherDataReceive(final byte[] paramAnonymousArrayOfByte)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onOtherDataReceive.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onOtherDataReceive(paramAnonymousArrayOfByte);
          }
        }
      });
    }
    
    public void onSettingsSuccess(final byte paramAnonymousByte, final boolean paramAnonymousBoolean)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onSettingsSuccess.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onSettingsSuccess(paramAnonymousByte, paramAnonymousBoolean);
          }
        }
      });
    }
    
    public void onSyncData(final int paramAnonymousInt)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onSyncData." + paramAnonymousInt);
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onSyncData(paramAnonymousInt);
          }
        }
      });
    }
    
    public void onWareUpdate(final byte paramAnonymousByte)
      throws RemoteException
    {
      CoreServiceProxy.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          DebugLog.e("onWareUpdate.");
          Iterator localIterator = CoreServiceProxy.this.mListeners.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return;
            }
            ((CoreServiceListener)localIterator.next()).onWareUpdate(paramAnonymousByte);
          }
        }
      });
    }
  };
  private final ServiceConnection mConnection = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      DebugLog.e("service connected.");
      CoreServiceProxy.this.mCoreService = ICoreService.Stub.asInterface(paramAnonymousIBinder);
      try
      {
        CoreServiceProxy.this.mCoreService.registerCallback(CoreServiceProxy.this.mCallback);
        paramAnonymousComponentName = CoreServiceProxy.this.mListeners.iterator();
        if (!paramAnonymousComponentName.hasNext()) {
          return;
        }
      }
      catch (RemoteException paramAnonymousComponentName)
      {
        for (;;)
        {
          DebugLog.e("remote call failed. (registerCallback)");
          continue;
          ((CoreServiceListener)paramAnonymousComponentName.next()).onCoreServiceConnected();
        }
      }
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      DebugLog.e("service disconnected.");
      paramAnonymousComponentName = CoreServiceProxy.this.mListeners.iterator();
      for (;;)
      {
        if (!paramAnonymousComponentName.hasNext())
        {
          CoreServiceProxy.this.mCoreService = null;
          return;
        }
        ((CoreServiceListener)paramAnonymousComponentName.next()).onCoreServiceDisconnected();
      }
    }
  };
  private final Context mContext;
  private ICoreService mCoreService;
  private final Handler mHandler;
  private CopyOnWriteArrayList<CoreServiceListener> mListeners = new CopyOnWriteArrayList();
  
  private CoreServiceProxy(Context paramContext)
  {
    DebugLog.e("construction.");
    this.mContext = paramContext;
    this.mHandler = new Handler();
    this.mCoreService = null;
    paramContext = new Intent(this.mContext, BleConnectService.class);
    paramContext.setAction("com.project.library.ble.ConnectService");
    if (this.mContext.bindService(paramContext, this.mConnection, 1))
    {
      DebugLog.e("bind core service success.");
      return;
    }
    DebugLog.e("bind core service failed.");
  }
  
  private void clearListener()
  {
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      CoreServiceListener localCoreServiceListener = (CoreServiceListener)localIterator.next();
      this.mListeners.remove(localCoreServiceListener);
    }
  }
  
  private void close()
  {
    DebugLog.e("proxy closed.");
    clearListener();
    this.mContext.unbindService(this.mConnection);
  }
  
  public static void fini()
  {
    if (sInstance != null)
    {
      sInstance.close();
      sInstance = null;
    }
  }
  
  public static CoreServiceProxy getInstance()
  {
    return sInstance;
  }
  
  public static void init(Context paramContext)
  {
    sInstance = new CoreServiceProxy(paramContext);
  }
  
  public void addListener(CoreServiceListener paramCoreServiceListener)
  {
    if ((paramCoreServiceListener != null) && (!this.mListeners.contains(paramCoreServiceListener))) {
      this.mListeners.add(paramCoreServiceListener);
    }
  }
  
  public boolean connect(String paramString)
  {
    if (!isAvailable())
    {
      DebugLog.e("Service is unAvailable");
      UartLogUtil.recordWrite("Service is unAvailable", new byte[1]);
      return false;
    }
    try
    {
      boolean bool = this.mCoreService.connect(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      DebugLog.e("remote call failed. (connect)");
      UartLogUtil.recordWrite("remote call failed. (connect)", new byte[1]);
    }
    return false;
  }
  
  public boolean disconnect()
  {
    if (!isAvailable())
    {
      DebugLog.e("Service is unAvailable");
      return false;
    }
    try
    {
      boolean bool = this.mCoreService.disconnect();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      DebugLog.e("remote call failed. (disconnect)");
    }
    return false;
  }
  
  public boolean initBLE(byte paramByte)
  {
    if (!isAvailable())
    {
      DebugLog.e("Service is unAvailable");
      return false;
    }
    try
    {
      boolean bool = this.mCoreService.initBLE(paramByte);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      DebugLog.e("remote call failed. (initBLE)");
    }
    return false;
  }
  
  public boolean isAvailable()
  {
    return this.mCoreService != null;
  }
  
  public boolean isDeviceConnected()
  {
    if (!isAvailable())
    {
      DebugLog.e("Service is unAvailable");
      return false;
    }
    try
    {
      boolean bool = this.mCoreService.isDeviceConnected();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      DebugLog.e("remote call failed. (isDeviceConnected)");
    }
    return false;
  }
  
  public void removeListener(CoreServiceListener paramCoreServiceListener)
  {
    if ((paramCoreServiceListener != null) && (!this.mListeners.isEmpty())) {
      this.mListeners.remove(paramCoreServiceListener);
    }
  }
  
  public boolean write(byte[] paramArrayOfByte)
  {
    if (!isAvailable())
    {
      DebugLog.e("Service is unAvailable");
      return false;
    }
    try
    {
      boolean bool = this.mCoreService.write(paramArrayOfByte);
      return bool;
    }
    catch (RemoteException paramArrayOfByte)
    {
      DebugLog.e("remote call failed. (write)");
    }
    return false;
  }
  
  public boolean writeForce(byte[] paramArrayOfByte)
  {
    if (!isAvailable())
    {
      DebugLog.e("Service is unAvailable");
      return false;
    }
    try
    {
      boolean bool = this.mCoreService.writeForce(paramArrayOfByte);
      return bool;
    }
    catch (RemoteException paramArrayOfByte)
    {
      DebugLog.e("remote call failed. (writeForce)");
    }
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\core\CoreServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */