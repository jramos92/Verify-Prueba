package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;

public abstract interface zzql
  extends IInterface
{
  public abstract void zza(Status paramStatus, AttestationData paramAttestationData)
    throws RemoteException;
  
  public abstract void zza(Status paramStatus, SafeBrowsingData paramSafeBrowsingData)
    throws RemoteException;
  
  public abstract void zzes(String paramString)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzql
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }
    
    public static zzql zzdG(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzql))) {
        return (zzql)localIInterface;
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
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label121;
          }
        }
        for (paramParcel1 = (AttestationData)AttestationData.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      case 2: 
        label121:
        paramParcel1.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        zzes(paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label201;
        }
      }
      label201:
      for (paramParcel1 = (SafeBrowsingData)SafeBrowsingData.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramParcel2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    }
    
    private static class zza
      implements zzql
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
      
      public void zza(Status paramStatus, AttestationData paramAttestationData)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            if (paramStatus != null)
            {
              localParcel.writeInt(1);
              paramStatus.writeToParcel(localParcel, 0);
              if (paramAttestationData != null)
              {
                localParcel.writeInt(1);
                paramAttestationData.writeToParcel(localParcel, 0);
                this.zznJ.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void zza(Status paramStatus, SafeBrowsingData paramSafeBrowsingData)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            if (paramStatus != null)
            {
              localParcel.writeInt(1);
              paramStatus.writeToParcel(localParcel, 0);
              if (paramSafeBrowsingData != null)
              {
                localParcel.writeInt(1);
                paramSafeBrowsingData.writeToParcel(localParcel, 0);
                this.zznJ.transact(3, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void zzes(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
          localParcel.writeString(paramString);
          this.zznJ.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */