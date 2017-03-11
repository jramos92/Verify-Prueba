package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzd
{
  private final Context mContext;
  private zzb zzbbB = null;
  private final BarcodeDetectorOptions zzbbz;
  private final Object zzpd = new Object();
  
  public zzd(Context paramContext, BarcodeDetectorOptions paramBarcodeDetectorOptions)
  {
    this.mContext = paramContext;
    this.zzbbz = paramBarcodeDetectorOptions;
    zzEz();
  }
  
  private zzb zzEz()
  {
    synchronized (this.zzpd)
    {
      if (this.zzbbB == null) {
        this.zzbbB = zza.zza(this.mContext, this.zzbbz);
      }
      zzb localzzb = this.zzbbB;
      return localzzb;
    }
  }
  
  public boolean isOperational()
  {
    return zzEz() != null;
  }
  
  public Barcode[] zza(Bitmap paramBitmap, FrameMetadataParcel paramFrameMetadataParcel)
  {
    zzb localzzb = zzEz();
    if (localzzb == null) {
      return new Barcode[0];
    }
    try
    {
      paramBitmap = localzzb.zzb(zze.zzy(paramBitmap), paramFrameMetadataParcel);
      return paramBitmap;
    }
    catch (RemoteException paramBitmap)
    {
      Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", paramBitmap);
    }
    return new Barcode[0];
  }
  
  public Barcode[] zza(ByteBuffer paramByteBuffer, FrameMetadataParcel paramFrameMetadataParcel)
  {
    zzb localzzb = zzEz();
    if (localzzb == null) {
      return new Barcode[0];
    }
    try
    {
      paramByteBuffer = localzzb.zza(zze.zzy(paramByteBuffer), paramFrameMetadataParcel);
      return paramByteBuffer;
    }
    catch (RemoteException paramByteBuffer)
    {
      Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", paramByteBuffer);
    }
    return new Barcode[0];
  }
  
  static class zza
    extends zzg<zzc>
  {
    private static zza zzbbC;
    
    zza()
    {
      super();
    }
    
    static zzb zza(Context paramContext, BarcodeDetectorOptions paramBarcodeDetectorOptions)
    {
      if (zzbbC == null) {
        zzbbC = new zza();
      }
      return zzbbC.zzb(paramContext, paramBarcodeDetectorOptions);
    }
    
    private zzb zzb(Context paramContext, BarcodeDetectorOptions paramBarcodeDetectorOptions)
    {
      try
      {
        com.google.android.gms.dynamic.zzd localzzd = zze.zzy(paramContext);
        paramContext = ((zzc)zzas(paramContext)).zza(localzzd, paramBarcodeDetectorOptions);
        return paramContext;
      }
      catch (RemoteException paramContext)
      {
        Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", paramContext);
        return null;
      }
      catch (zzg.zza paramContext)
      {
        for (;;)
        {
          Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", paramContext);
        }
      }
    }
    
    protected zzc zzdR(IBinder paramIBinder)
    {
      return zzc.zza.zzdQ(paramIBinder);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\barcode\internal\client\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */