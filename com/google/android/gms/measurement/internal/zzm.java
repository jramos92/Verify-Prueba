package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzm
  extends IInterface
{
  public abstract void zza(AppMetadata paramAppMetadata)
    throws RemoteException;
  
  public abstract void zza(EventParcel paramEventParcel, AppMetadata paramAppMetadata)
    throws RemoteException;
  
  public abstract void zza(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzm
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }
    
    public static zzm zzcZ(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
      if ((localIInterface != null) && ((localIInterface instanceof zzm))) {
        return (zzm)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject3 = null;
      Object localObject1 = null;
      Object localObject2 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = EventParcel.CREATOR.zzfz(paramParcel1);; localObject1 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject2 = AppMetadata.CREATOR.zzfx(paramParcel1);
          }
          zza((EventParcel)localObject1, (AppMetadata)localObject2);
          paramParcel2.writeNoException();
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = UserAttributeParcel.CREATOR.zzfA(paramParcel1);; localObject1 = null)
        {
          localObject2 = localObject3;
          if (paramParcel1.readInt() != 0) {
            localObject2 = AppMetadata.CREATOR.zzfx(paramParcel1);
          }
          zza((UserAttributeParcel)localObject1, (AppMetadata)localObject2);
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
      if (paramParcel1.readInt() != 0) {
        localObject1 = AppMetadata.CREATOR.zzfx(paramParcel1);
      }
      zza((AppMetadata)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzm
    {
      private IBinder zznJ;
      
      zza(IBinder paramIBinder)
      {
        this.zznJ = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.zznJ;
      }
      
      /* Error */
      public void zza(AppMetadata paramAppMetadata)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 46	com/google/android/gms/measurement/internal/AppMetadata:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/measurement/internal/zzm$zza$zza:zznJ	Landroid/os/IBinder;
        //   33: iconst_4
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 52 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 55	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 58	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 58	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 58	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 58	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	zza
        //   0	75	1	paramAppMetadata	AppMetadata
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      public void zza(EventParcel paramEventParcel, AppMetadata paramAppMetadata)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (paramEventParcel != null)
            {
              localParcel1.writeInt(1);
              paramEventParcel.writeToParcel(localParcel1, 0);
              if (paramAppMetadata != null)
              {
                localParcel1.writeInt(1);
                paramAppMetadata.writeToParcel(localParcel1, 0);
                this.zznJ.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void zza(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (paramUserAttributeParcel != null)
            {
              localParcel1.writeInt(1);
              paramUserAttributeParcel.writeToParcel(localParcel1, 0);
              if (paramAppMetadata != null)
              {
                localParcel1.writeInt(1);
                paramAppMetadata.writeToParcel(localParcel1, 0);
                this.zznJ.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
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
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */