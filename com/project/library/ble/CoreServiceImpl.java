package com.project.library.ble;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.project.library.core.ICoreService.Stub;
import com.project.library.core.ICoreServiceCallback;
import com.project.library.database.SportDataDay;
import com.project.library.protocol.AppBleNotifyListener;
import com.project.library.protocol.BleProxy;
import com.project.library.util.DebugLog;
import com.project.library.util.PendingHandler;
import com.project.library.util.UartLogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class CoreServiceImpl
  extends ICoreService.Stub
{
  private static final String BLE_CONNECTED_METHOD = "onBLEConnected";
  private static final String BLE_CONNECTING_METHOD = "onBLEConnecting";
  private static final String BLE_CONNECT_TIMEOUT_METHOD = "onBLEConnectTimeOut";
  private static final String BLE_DISCONNECTED_METHOD = "onBLEDisConnected";
  private static final String BLUE_TOOTH_ERROR_METHOD = "onBlueToothError";
  private static final Class<?>[] BYTE_ARRAY_SIGNATURE = { byte[].class };
  private static final Class<?>[] BYTE_BOOLEAN_SIGNATURE = { Byte.TYPE, Boolean.TYPE };
  private static final Class<?>[] BYTE_DOUBLE;
  private static final Class<?>[] BYTE_SIGNATURE;
  private static final String DATA_CHANGED_METHOD = "onDataChanged";
  private static final String DATA_RECEIVE_METHOD = "onDataReceived";
  private static final String DATA_SEND_TIMEOUT_METHOD = "onDataSendTimeOut";
  private static final Class<?>[] INT_SIGNATURE;
  private static final Class<?>[] LIST_SIGNATURE = { List.class };
  private static final String ON_APPCONTROL_SUCCESS = "onAppControlSuccess";
  private static final String ON_BIND_UNBIND_METHOD = "onBindUnbind";
  private static final String ON_BLECONTROL_RECEIVE = "onBleControlReceive";
  private static final String ON_GET_INFO = "onGetInfo";
  private static final String ON_OTHER_DATA_RECEIVE = "onOtherDataReceive";
  private static final String ON_SETTINGS_SUCCESS = "onSettingsSuccess";
  private static final String ON_SYNC_DATA = "onSyncData";
  private static final String ON_WARE_UPDATE_METHOD = "onWareUpdate";
  private static final Class<?>[] STRING_SIGNATURE;
  private static final Class<?>[] VIOD_SIGNATURE = new Class[0];
  private boolean isClose = false;
  private AppBleNotifyListener mAppBleNotifyListener = new AppBleNotifyListener()
  {
    public void onAppControlSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      CoreServiceImpl.this.broadcast("onAppControlSuccess", CoreServiceImpl.BYTE_BOOLEAN_SIGNATURE, new Object[] { Byte.valueOf(paramAnonymousByte), Boolean.valueOf(paramAnonymousBoolean) });
    }
    
    public void onBLEConnectTimeOut()
    {
      CoreServiceImpl.this.broadcast("onBLEConnectTimeOut", CoreServiceImpl.VIOD_SIGNATURE, new Object[0]);
      CoreServiceImpl.this.isClose = true;
    }
    
    public void onBLEConnected()
    {
      CoreServiceImpl.this.isClose = false;
      CoreServiceImpl.this.broadcast("onBLEConnected", CoreServiceImpl.VIOD_SIGNATURE, new Object[0]);
    }
    
    public void onBLEConnecting()
    {
      CoreServiceImpl.this.broadcast("onBLEConnecting", CoreServiceImpl.VIOD_SIGNATURE, new Object[0]);
    }
    
    public void onBLEDisConnected(String paramAnonymousString)
    {
      CoreServiceImpl.this.broadcast("onBLEDisConnected", CoreServiceImpl.STRING_SIGNATURE, new Object[] { paramAnonymousString });
      CoreServiceImpl.this.isClose = true;
    }
    
    public void onBindUnbind(byte paramAnonymousByte)
    {
      CoreServiceImpl.this.broadcast("onBindUnbind", CoreServiceImpl.BYTE_SIGNATURE, new Object[] { Byte.valueOf(paramAnonymousByte) });
    }
    
    public void onBleControlReceive(byte paramAnonymousByte1, byte paramAnonymousByte2)
    {
      CoreServiceImpl.this.broadcast("onBleControlReceive", CoreServiceImpl.BYTE_DOUBLE, new Object[] { Byte.valueOf(paramAnonymousByte1), Byte.valueOf(paramAnonymousByte2) });
    }
    
    public void onBlueToothError(int paramAnonymousInt)
    {
      CoreServiceImpl.this.broadcast("onBlueToothError", CoreServiceImpl.INT_SIGNATURE, new Object[] { Integer.valueOf(paramAnonymousInt) });
    }
    
    public void onDataChanged(List<SportDataDay> paramAnonymousList)
    {
      CoreServiceImpl.this.broadcast("onDataChanged", CoreServiceImpl.LIST_SIGNATURE, new Object[] { paramAnonymousList });
    }
    
    public boolean onDataReceived(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
    {
      CoreServiceImpl.this.broadcast("onDataReceived", CoreServiceImpl.BYTE_ARRAY_SIGNATURE, new Object[] { paramAnonymousArrayOfByte2 });
      return true;
    }
    
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte)
    {
      CoreServiceImpl.this.broadcast("onDataSendTimeOut", CoreServiceImpl.BYTE_ARRAY_SIGNATURE, new Object[] { paramAnonymousArrayOfByte });
    }
    
    public void onGetInfo(byte paramAnonymousByte)
    {
      CoreServiceImpl.this.broadcast("onGetInfo", CoreServiceImpl.BYTE_SIGNATURE, new Object[] { Byte.valueOf(paramAnonymousByte) });
    }
    
    public void onOtherDataReceive(byte[] paramAnonymousArrayOfByte)
    {
      CoreServiceImpl.this.broadcast("onOtherDataReceive", CoreServiceImpl.BYTE_ARRAY_SIGNATURE, new Object[] { paramAnonymousArrayOfByte });
    }
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      CoreServiceImpl.this.broadcast("onSettingsSuccess", CoreServiceImpl.BYTE_BOOLEAN_SIGNATURE, new Object[] { Byte.valueOf(paramAnonymousByte), Boolean.valueOf(paramAnonymousBoolean) });
    }
    
    public void onSyncData(int paramAnonymousInt)
    {
      CoreServiceImpl.this.broadcast("onSyncData", CoreServiceImpl.INT_SIGNATURE, new Object[] { Integer.valueOf(paramAnonymousInt) });
    }
    
    public void onWareUpdate(byte paramAnonymousByte)
    {
      CoreServiceImpl.this.broadcast("onWareUpdate", CoreServiceImpl.BYTE_SIGNATURE, new Object[] { Byte.valueOf(paramAnonymousByte) });
    }
  };
  private RemoteCallbackList<ICoreServiceCallback> mCallbacks;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private Handler mOperationHandler;
  private HandlerThread mOperationHandlerThread;
  private BleProxy mProxy;
  private PendingHandler mWriteHandler;
  private StringBuilder sb = new StringBuilder();
  private SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss", Locale.CHINESE);
  
  static
  {
    INT_SIGNATURE = new Class[] { Integer.TYPE };
    STRING_SIGNATURE = new Class[] { String.class };
    BYTE_SIGNATURE = new Class[] { Byte.TYPE };
    BYTE_DOUBLE = new Class[] { Byte.TYPE, Byte.TYPE };
  }
  
  public CoreServiceImpl(Context paramContext)
  {
    this.mContext = paramContext;
    this.mHandlerThread = new HandlerThread("BLECore_PendingHandler");
    this.mHandlerThread.start();
    this.mWriteHandler = new PendingHandler(this.mHandlerThread.getLooper());
    this.mOperationHandlerThread = new HandlerThread("OperationHandlerThread");
    this.mOperationHandlerThread.start();
    this.mOperationHandler = new Handler(this.mOperationHandlerThread.getLooper());
    this.mProxy = new BleProxy(this.mContext, this.mAppBleNotifyListener);
    this.mCallbacks = new RemoteCallbackList();
  }
  
  private void broadcast(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (this.isClose) {
      return;
    }
    Object localObject;
    synchronized (this.mCallbacks)
    {
      DebugLog.e("broadcast [" + paramString + "] begin.");
      localObject = null;
    }
    try
    {
      paramString = ICoreServiceCallback.class.getMethod(paramString, paramArrayOfClass);
      int j = this.mCallbacks.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i >= j)
        {
          this.mCallbacks.finishBroadcast();
          DebugLog.e("broadcast end.");
          return;
          paramString = finally;
          throw paramString;
        }
        try
        {
          paramString.invoke(this.mCallbacks.getBroadcastItem(i), paramVarArgs);
          i += 1;
        }
        catch (InvocationTargetException paramArrayOfClass)
        {
          for (;;) {}
        }
        catch (IllegalAccessException paramArrayOfClass)
        {
          for (;;) {}
        }
        catch (IllegalArgumentException paramArrayOfClass)
        {
          for (;;) {}
        }
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
    catch (SecurityException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
  }
  
  public void autoConnect(final boolean paramBoolean)
  {
    this.mOperationHandler.post(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          CoreServiceImpl.this.mProxy.scanAndAutoConnect();
          DebugLog.e("自动连接设备扫描。。。");
          return;
        }
        CoreServiceImpl.this.mProxy.delayConnect();
        DebugLog.e("自动连接设备延时。。。");
      }
    });
  }
  
  public void close()
  {
    DebugLog.e("closed.");
    this.isClose = true;
    this.mHandlerThread.quit();
    this.mOperationHandlerThread.quit();
    this.mCallbacks.kill();
    this.mProxy.close();
  }
  
  public boolean connect(final String paramString)
    throws RemoteException
  {
    try
    {
      this.mOperationHandler.post(new Runnable()
      {
        public void run()
        {
          UartLogUtil.recordWrite("连接蓝牙", new byte[1]);
          CoreServiceImpl.this.mProxy.connect(paramString);
        }
      });
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean disconnect()
    throws RemoteException
  {
    try
    {
      this.mOperationHandler.post(new Runnable()
      {
        public void run()
        {
          UartLogUtil.recordWrite("关闭蓝牙", new byte[1]);
          CoreServiceImpl.this.mProxy.close();
        }
      });
      return true;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean initBLE(byte paramByte)
    throws RemoteException
  {
    if (this.mProxy.initBLE(paramByte)) {
      UartLogUtil.recordWrite("蓝牙初始化成功", new byte[] { 1 });
    }
    for (;;)
    {
      return this.mProxy.initBLE(paramByte);
      UartLogUtil.recordWrite("蓝牙初始化失败", new byte[1]);
    }
  }
  
  public boolean isDeviceConnected()
    throws RemoteException
  {
    return this.mProxy.isDeviceConnected();
  }
  
  public void notifyBluetoothStateChanged(boolean paramBoolean)
  {
    this.mProxy.notifyBluetoothStateChanged(paramBoolean);
    Class[] arrayOfClass = INT_SIGNATURE;
    if (paramBoolean) {}
    for (int i = -66;; i = -55)
    {
      broadcast("onBlueToothError", arrayOfClass, new Object[] { Integer.valueOf(i) });
      return;
    }
  }
  
  public void registerCallback(ICoreServiceCallback paramICoreServiceCallback)
    throws RemoteException
  {
    this.mCallbacks.register(paramICoreServiceCallback);
  }
  
  public void unregisterCallback(ICoreServiceCallback paramICoreServiceCallback)
    throws RemoteException
  {
    this.mCallbacks.unregister(paramICoreServiceCallback);
  }
  
  /* Error */
  public boolean write(final byte[] paramArrayOfByte)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 142	com/project/library/ble/CoreServiceImpl:isClose	Z
    //   6: ifne +25 -> 31
    //   9: aload_0
    //   10: getfield 208	com/project/library/ble/CoreServiceImpl:mProxy	Lcom/project/library/protocol/BleProxy;
    //   13: aload_1
    //   14: invokevirtual 358	com/project/library/protocol/BleProxy:isDeviceConnectedWritten	([B)Z
    //   17: ifeq +14 -> 31
    //   20: aload_0
    //   21: getfield 208	com/project/library/ble/CoreServiceImpl:mProxy	Lcom/project/library/protocol/BleProxy;
    //   24: aload_1
    //   25: invokevirtual 361	com/project/library/protocol/BleProxy:canWriteNext	([B)Z
    //   28: ifne +15 -> 43
    //   31: ldc_w 363
    //   34: invokestatic 260	com/project/library/util/DebugLog:e	(Ljava/lang/String;)V
    //   37: iconst_0
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_2
    //   45: aload_0
    //   46: getfield 192	com/project/library/ble/CoreServiceImpl:mWriteHandler	Lcom/project/library/util/PendingHandler;
    //   49: invokevirtual 366	com/project/library/util/PendingHandler:pending	()Z
    //   52: ifne +23 -> 75
    //   55: aload_0
    //   56: getfield 192	com/project/library/ble/CoreServiceImpl:mWriteHandler	Lcom/project/library/util/PendingHandler;
    //   59: new 14	com/project/library/ble/CoreServiceImpl$5
    //   62: dup
    //   63: aload_0
    //   64: aload_1
    //   65: invokespecial 369	com/project/library/ble/CoreServiceImpl$5:<init>	(Lcom/project/library/ble/CoreServiceImpl;[B)V
    //   68: invokevirtual 372	com/project/library/util/PendingHandler:postT	(Ljava/lang/Runnable;)Z
    //   71: istore_2
    //   72: goto -33 -> 39
    //   75: ldc_w 374
    //   78: invokestatic 260	com/project/library/util/DebugLog:e	(Ljava/lang/String;)V
    //   81: goto -42 -> 39
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	CoreServiceImpl
    //   0	89	1	paramArrayOfByte	byte[]
    //   38	34	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	31	84	finally
    //   31	37	84	finally
    //   45	72	84	finally
    //   75	81	84	finally
  }
  
  /* Error */
  public boolean writeForce(final byte[] paramArrayOfByte)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 142	com/project/library/ble/CoreServiceImpl:isClose	Z
    //   6: ifne +14 -> 20
    //   9: aload_0
    //   10: getfield 208	com/project/library/ble/CoreServiceImpl:mProxy	Lcom/project/library/protocol/BleProxy;
    //   13: aload_1
    //   14: invokevirtual 358	com/project/library/protocol/BleProxy:isDeviceConnectedWritten	([B)Z
    //   17: ifne +15 -> 32
    //   20: ldc_w 377
    //   23: invokestatic 260	com/project/library/util/DebugLog:e	(Ljava/lang/String;)V
    //   26: iconst_0
    //   27: istore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_2
    //   31: ireturn
    //   32: aload_0
    //   33: getfield 192	com/project/library/ble/CoreServiceImpl:mWriteHandler	Lcom/project/library/util/PendingHandler;
    //   36: new 16	com/project/library/ble/CoreServiceImpl$6
    //   39: dup
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 378	com/project/library/ble/CoreServiceImpl$6:<init>	(Lcom/project/library/ble/CoreServiceImpl;[B)V
    //   45: invokevirtual 381	com/project/library/util/PendingHandler:postF	(Ljava/lang/Runnable;)Z
    //   48: istore_2
    //   49: goto -21 -> 28
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	CoreServiceImpl
    //   0	57	1	paramArrayOfByte	byte[]
    //   27	22	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	52	finally
    //   20	26	52	finally
    //   32	49	52	finally
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\ble\CoreServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */