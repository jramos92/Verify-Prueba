package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzg
{
  private final Context mContext;
  private final FaceSettingsParcel zzbcc;
  private zzc zzbcd = null;
  private boolean zzbce = false;
  private final Object zzpd = new Object();
  
  public zzg(Context paramContext, FaceSettingsParcel paramFaceSettingsParcel)
  {
    this.mContext = paramContext;
    this.zzbcc = paramFaceSettingsParcel;
    zzEB();
  }
  
  private zzc zzEB()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        zzc localzzc;
        if (this.zzbcd != null)
        {
          localzzc = this.zzbcd;
          return localzzc;
        }
        this.zzbcd = zzf.zza(this.mContext, this.zzbcc);
        if ((!this.zzbce) && (this.zzbcd == null))
        {
          Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
          this.zzbce = true;
          localzzc = this.zzbcd;
          return localzzc;
        }
      }
      if ((this.zzbce) && (this.zzbcd != null)) {
        Log.w("FaceDetectorHandle", "Native face detector is now available.");
      }
    }
  }
  
  private Face zza(FaceParcel paramFaceParcel)
  {
    return new Face(paramFaceParcel.id, new PointF(paramFaceParcel.centerX, paramFaceParcel.centerY), paramFaceParcel.width, paramFaceParcel.height, paramFaceParcel.zzbbR, paramFaceParcel.zzbbS, zzb(paramFaceParcel), paramFaceParcel.zzbbU, paramFaceParcel.zzbbV, paramFaceParcel.zzbbW);
  }
  
  private Landmark zza(LandmarkParcel paramLandmarkParcel)
  {
    return new Landmark(new PointF(paramLandmarkParcel.x, paramLandmarkParcel.y), paramLandmarkParcel.type);
  }
  
  private Landmark[] zzb(FaceParcel paramFaceParcel)
  {
    int i = 0;
    paramFaceParcel = paramFaceParcel.zzbbT;
    if (paramFaceParcel == null) {
      return new Landmark[0];
    }
    Landmark[] arrayOfLandmark = new Landmark[paramFaceParcel.length];
    while (i < paramFaceParcel.length)
    {
      arrayOfLandmark[i] = zza(paramFaceParcel[i]);
      i += 1;
    }
    return arrayOfLandmark;
  }
  
  public boolean isOperational()
  {
    return zzEB() != null;
  }
  
  public void zzEA()
  {
    synchronized (this.zzpd)
    {
      if (this.zzbcd == null) {
        return;
      }
    }
    try
    {
      this.zzbcd.zzEA();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("FaceDetectorHandle", "Could not finalize native face detector", localRemoteException);
      }
    }
  }
  
  public Face[] zzb(ByteBuffer paramByteBuffer, FrameMetadataParcel paramFrameMetadataParcel)
  {
    int i = 0;
    zzc localzzc = zzEB();
    if (localzzc == null) {
      return new Face[0];
    }
    try
    {
      paramByteBuffer = localzzc.zzc(zze.zzy(paramByteBuffer), paramFrameMetadataParcel);
      paramFrameMetadataParcel = new Face[paramByteBuffer.length];
      while (i < paramByteBuffer.length)
      {
        paramFrameMetadataParcel[i] = zza(paramByteBuffer[i]);
        i += 1;
      }
      return paramFrameMetadataParcel;
    }
    catch (RemoteException paramByteBuffer)
    {
      Log.e("FaceDetectorHandle", "Could not call native face detector", paramByteBuffer);
      return new Face[0];
    }
  }
  
  public boolean zzjW(int paramInt)
  {
    zzc localzzc = zzEB();
    if (localzzc == null) {
      return false;
    }
    try
    {
      boolean bool = localzzc.zzjW(paramInt);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("FaceDetectorHandle", "Could not call native face detector", localRemoteException);
    }
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */