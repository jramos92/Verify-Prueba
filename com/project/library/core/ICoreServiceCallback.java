package com.project.library.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.project.library.database.SportDataDay;
import java.util.List;

public abstract interface ICoreServiceCallback
  extends IInterface
{
  public abstract void onAppControlSuccess(byte paramByte, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void onBLEConnectTimeOut()
    throws RemoteException;
  
  public abstract void onBLEConnected()
    throws RemoteException;
  
  public abstract void onBLEConnecting()
    throws RemoteException;
  
  public abstract void onBLEDisConnected(String paramString)
    throws RemoteException;
  
  public abstract void onBindUnbind(byte paramByte)
    throws RemoteException;
  
  public abstract void onBleControlReceive(byte paramByte1, byte paramByte2)
    throws RemoteException;
  
  public abstract void onBlueToothError(int paramInt)
    throws RemoteException;
  
  public abstract void onDataChanged(List<SportDataDay> paramList)
    throws RemoteException;
  
  public abstract void onDataReceived(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void onDataSendTimeOut(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void onGetInfo(byte paramByte)
    throws RemoteException;
  
  public abstract void onOtherDataReceive(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void onSettingsSuccess(byte paramByte, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void onSyncData(int paramInt)
    throws RemoteException;
  
  public abstract void onWareUpdate(byte paramByte)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ICoreServiceCallback
  {
    private static final String DESCRIPTOR = "com.project.library.core.ICoreServiceCallback";
    static final int TRANSACTION_onAppControlSuccess = 12;
    static final int TRANSACTION_onBLEConnectTimeOut = 5;
    static final int TRANSACTION_onBLEConnected = 3;
    static final int TRANSACTION_onBLEConnecting = 2;
    static final int TRANSACTION_onBLEDisConnected = 4;
    static final int TRANSACTION_onBindUnbind = 10;
    static final int TRANSACTION_onBleControlReceive = 13;
    static final int TRANSACTION_onBlueToothError = 1;
    static final int TRANSACTION_onDataChanged = 8;
    static final int TRANSACTION_onDataReceived = 7;
    static final int TRANSACTION_onDataSendTimeOut = 6;
    static final int TRANSACTION_onGetInfo = 14;
    static final int TRANSACTION_onOtherDataReceive = 16;
    static final int TRANSACTION_onSettingsSuccess = 11;
    static final int TRANSACTION_onSyncData = 15;
    static final int TRANSACTION_onWareUpdate = 9;
    
    public Stub()
    {
      attachInterface(this, "com.project.library.core.ICoreServiceCallback");
    }
    
    public static ICoreServiceCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.project.library.core.ICoreServiceCallback");
      if ((localIInterface != null) && ((localIInterface instanceof ICoreServiceCallback))) {
        return (ICoreServiceCallback)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool2 = false;
      boolean bool1 = false;
      byte b;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.project.library.core.ICoreServiceCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onBlueToothError(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onBLEConnecting();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onBLEConnected();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onBLEDisConnected(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onBLEConnectTimeOut();
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onDataSendTimeOut(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onDataReceived(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onDataChanged(paramParcel1.createTypedArrayList(SportDataDay.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onWareUpdate(paramParcel1.readByte());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onBindUnbind(paramParcel1.readByte());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        b = paramParcel1.readByte();
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        onSettingsSuccess(b, bool1);
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        b = paramParcel1.readByte();
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        onAppControlSuccess(b, bool1);
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onBleControlReceive(paramParcel1.readByte(), paramParcel1.readByte());
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onGetInfo(paramParcel1.readByte());
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
        onSyncData(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.project.library.core.ICoreServiceCallback");
      onOtherDataReceive(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements ICoreServiceCallback
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.project.library.core.ICoreServiceCallback";
      }
      
      public void onAppControlSuccess(byte paramByte, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByte(paramByte);
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onBLEConnectTimeOut()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onBLEConnected()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onBLEConnecting()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onBLEDisConnected(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeString(paramString);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onBindUnbind(byte paramByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByte(paramByte);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onBleControlReceive(byte paramByte1, byte paramByte2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByte(paramByte1);
          localParcel1.writeByte(paramByte2);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onBlueToothError(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDataChanged(List<SportDataDay> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeTypedList(paramList);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDataReceived(byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDataSendTimeOut(byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onGetInfo(byte paramByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByte(paramByte);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onOtherDataReceive(byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onSettingsSuccess(byte paramByte, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByte(paramByte);
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onSyncData(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onWareUpdate(byte paramByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.project.library.core.ICoreServiceCallback");
          localParcel1.writeByte(paramByte);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\core\ICoreServiceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */