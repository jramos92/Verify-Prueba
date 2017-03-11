package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzd
  extends IInterface
{
  public abstract zzc zza(com.google.android.gms.dynamic.zzd paramzzd, FaceSettingsParcel paramFaceSettingsParcel)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzd
  {
    public static zzd zzdT(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
      if ((localIInterface != null) && ((localIInterface instanceof zzd))) {
        return (zzd)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
      Object localObject2 = com.google.android.gms.dynamic.zzd.zza.zzbk(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = FaceSettingsParcel.CREATOR.zzgT(paramParcel1);; paramParcel1 = null)
      {
        localObject2 = zza((com.google.android.gms.dynamic.zzd)localObject2, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel1 = (Parcel)localObject1;
        if (localObject2 != null) {
          paramParcel1 = ((zzc)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    
    private static class zza
      implements zzd
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
      public zzc zza(com.google.android.gms.dynamic.zzd paramzzd, FaceSettingsParcel paramFaceSettingsParcel)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +70 -> 86
        //   19: aload_1
        //   20: invokeinterface 40 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_2
        //   32: ifnull +59 -> 91
        //   35: aload_3
        //   36: iconst_1
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokevirtual 53	com/google/android/gms/vision/face/internal/client/FaceSettingsParcel:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/vision/face/internal/client/zzd$zza$zza:zznJ	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload_3
        //   52: aload 4
        //   54: iconst_0
        //   55: invokeinterface 59 5 0
        //   60: pop
        //   61: aload 4
        //   63: invokevirtual 62	android/os/Parcel:readException	()V
        //   66: aload 4
        //   68: invokevirtual 65	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   71: invokestatic 71	com/google/android/gms/vision/face/internal/client/zzc$zza:zzdS	(Landroid/os/IBinder;)Lcom/google/android/gms/vision/face/internal/client/zzc;
        //   74: astore_1
        //   75: aload 4
        //   77: invokevirtual 74	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 74	android/os/Parcel:recycle	()V
        //   84: aload_1
        //   85: areturn
        //   86: aconst_null
        //   87: astore_1
        //   88: goto -62 -> 26
        //   91: aload_3
        //   92: iconst_0
        //   93: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   96: goto -50 -> 46
        //   99: astore_1
        //   100: aload 4
        //   102: invokevirtual 74	android/os/Parcel:recycle	()V
        //   105: aload_3
        //   106: invokevirtual 74	android/os/Parcel:recycle	()V
        //   109: aload_1
        //   110: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	111	0	this	zza
        //   0	111	1	paramzzd	com.google.android.gms.dynamic.zzd
        //   0	111	2	paramFaceSettingsParcel	FaceSettingsParcel
        //   3	103	3	localParcel1	Parcel
        //   7	94	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	99	finally
        //   19	26	99	finally
        //   26	31	99	finally
        //   35	46	99	finally
        //   46	75	99	finally
        //   91	96	99	finally
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */