package com.google.android.gms.vision;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraSource
{
  public static final int CAMERA_FACING_BACK = 0;
  public static final int CAMERA_FACING_FRONT = 1;
  private Context mContext;
  private int zzAF;
  private final Object zzbaE = new Object();
  private Camera zzbaF;
  private int zzbaG = 0;
  private Size zzbaH;
  private float zzbaI = 30.0F;
  private int zzbaJ = 1024;
  private int zzbaK = 768;
  private SurfaceView zzbaL;
  private SurfaceTexture zzbaM;
  private boolean zzbaN;
  private Thread zzbaO;
  private zzb zzbaP;
  private Map<byte[], ByteBuffer> zzbaQ = new HashMap();
  
  private Camera zzEu()
  {
    int i = zzjD(this.zzbaG);
    if (i == -1) {
      throw new RuntimeException("Could not find requested camera.");
    }
    Camera localCamera = Camera.open(i);
    Object localObject = zza(localCamera, this.zzbaJ, this.zzbaK);
    if (localObject == null) {
      throw new RuntimeException("Could not find suitable preview size.");
    }
    Size localSize = ((zze)localObject).zzEw();
    this.zzbaH = ((zze)localObject).zzEv();
    localObject = zza(localCamera, this.zzbaI);
    if (localObject == null) {
      throw new RuntimeException("Could not find suitable preview frames per second range.");
    }
    Camera.Parameters localParameters = localCamera.getParameters();
    localParameters.setPictureSize(localSize.getWidth(), localSize.getHeight());
    localParameters.setPreviewSize(this.zzbaH.getWidth(), this.zzbaH.getHeight());
    localParameters.setPreviewFpsRange(localObject[0], localObject[1]);
    localParameters.setPreviewFormat(17);
    zza(localCamera, localParameters, i);
    localCamera.setParameters(localParameters);
    localCamera.setPreviewCallbackWithBuffer(new zza(null));
    localCamera.addCallbackBuffer(zza(this.zzbaH));
    localCamera.addCallbackBuffer(zza(this.zzbaH));
    localCamera.addCallbackBuffer(zza(this.zzbaH));
    localCamera.addCallbackBuffer(zza(this.zzbaH));
    return localCamera;
  }
  
  private static zze zza(Camera paramCamera, int paramInt1, int paramInt2)
  {
    Object localObject = zza(paramCamera);
    paramCamera = null;
    int i = Integer.MAX_VALUE;
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = (zze)localIterator.next();
      Size localSize = ((zze)localObject).zzEv();
      int j = Math.abs(localSize.getWidth() - paramInt1);
      j = Math.abs(localSize.getHeight() - paramInt2) + j;
      if (j >= i) {
        break label93;
      }
      paramCamera = (Camera)localObject;
      i = j;
    }
    label93:
    for (;;)
    {
      break;
      return paramCamera;
    }
  }
  
  private static List<zze> zza(Camera paramCamera)
  {
    Object localObject = paramCamera.getParameters();
    paramCamera = ((Camera.Parameters)localObject).getSupportedPreviewSizes();
    List localList = ((Camera.Parameters)localObject).getSupportedPictureSizes();
    localObject = new ArrayList();
    Iterator localIterator = paramCamera.iterator();
    label145:
    while (localIterator.hasNext())
    {
      Camera.Size localSize1 = (Camera.Size)localIterator.next();
      float f = localSize1.width / localSize1.height;
      int i = localList.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label145;
        }
        Camera.Size localSize2 = (Camera.Size)localList.get(i);
        if (Math.abs(f - localSize2.width / localSize2.height) < 0.01F)
        {
          ((List)localObject).add(new zze(localSize1, localSize2));
          break;
        }
        i -= 1;
      }
    }
    if (((List)localObject).size() == 0)
    {
      Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
      paramCamera = paramCamera.iterator();
      while (paramCamera.hasNext()) {
        ((List)localObject).add(new zze((Camera.Size)paramCamera.next(), null));
      }
    }
    return (List<zze>)localObject;
  }
  
  private void zza(Camera paramCamera, Camera.Parameters paramParameters, int paramInt)
  {
    int i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
    Camera.CameraInfo localCameraInfo;
    switch (i)
    {
    default: 
      Log.e("CameraSource", "Bad rotation value: " + i);
      i = 0;
      localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt, localCameraInfo);
      if (localCameraInfo.facing == 1)
      {
        i = (i + localCameraInfo.orientation) % 360;
        paramInt = (360 - i) % 360;
      }
      break;
    }
    for (;;)
    {
      this.zzAF = (i / 90);
      paramCamera.setDisplayOrientation(paramInt);
      paramParameters.setRotation(i);
      return;
      i = 0;
      break;
      i = 90;
      break;
      i = 180;
      break;
      i = 270;
      break;
      paramInt = (localCameraInfo.orientation - i + 360) % 360;
      i = paramInt;
    }
  }
  
  private byte[] zza(Size paramSize)
  {
    paramSize = new byte[(int)Math.ceil(ImageFormat.getBitsPerPixel(17) * (paramSize.getHeight() * paramSize.getWidth()) / 8.0D) + 1];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramSize);
    if ((!localByteBuffer.hasArray()) || (localByteBuffer.array() != paramSize)) {
      throw new IllegalStateException("Failed to create valid buffer for camera source.");
    }
    this.zzbaQ.put(paramSize, localByteBuffer);
    return paramSize;
  }
  
  private int[] zza(Camera paramCamera, float paramFloat)
  {
    int k = (int)(1000.0F * paramFloat);
    int[] arrayOfInt = null;
    int i = Integer.MAX_VALUE;
    Iterator localIterator = paramCamera.getParameters().getSupportedPreviewFpsRange().iterator();
    paramCamera = arrayOfInt;
    if (localIterator.hasNext())
    {
      arrayOfInt = (int[])localIterator.next();
      int j = arrayOfInt[0];
      int m = arrayOfInt[1];
      j = Math.abs(k - j) + Math.abs(k - m);
      if (j >= i) {
        break label101;
      }
      paramCamera = arrayOfInt;
      i = j;
    }
    label101:
    for (;;)
    {
      break;
      return paramCamera;
    }
  }
  
  private static int zzjD(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    while (i < Camera.getNumberOfCameras())
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getCameraFacing()
  {
    return this.zzbaG;
  }
  
  public Size getPreviewSize()
  {
    return this.zzbaH;
  }
  
  public void release()
  {
    synchronized (this.zzbaE)
    {
      stop();
      this.zzbaP.release();
      return;
    }
  }
  
  public CameraSource start()
    throws IOException
  {
    for (;;)
    {
      synchronized (this.zzbaE)
      {
        if (this.zzbaF != null) {
          return this;
        }
        this.zzbaF = zzEu();
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.zzbaM = new SurfaceTexture(100);
          this.zzbaF.setPreviewTexture(this.zzbaM);
          this.zzbaN = true;
          this.zzbaF.startPreview();
          this.zzbaO = new Thread(this.zzbaP);
          this.zzbaP.setActive(true);
          this.zzbaO.start();
          return this;
        }
      }
      this.zzbaL = new SurfaceView(this.mContext);
      this.zzbaF.setPreviewDisplay(this.zzbaL.getHolder());
      this.zzbaN = false;
    }
  }
  
  public CameraSource start(SurfaceHolder paramSurfaceHolder)
    throws IOException
  {
    synchronized (this.zzbaE)
    {
      if (this.zzbaF != null) {
        return this;
      }
      this.zzbaF = zzEu();
      this.zzbaF.setPreviewDisplay(paramSurfaceHolder);
      this.zzbaF.startPreview();
      this.zzbaO = new Thread(this.zzbaP);
      this.zzbaP.setActive(true);
      this.zzbaO.start();
      this.zzbaN = false;
      return this;
    }
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/google/android/gms/vision/CameraSource:zzbaE	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 181	com/google/android/gms/vision/CameraSource:zzbaP	Lcom/google/android/gms/vision/CameraSource$zzb;
    //   11: iconst_0
    //   12: invokevirtual 413	com/google/android/gms/vision/CameraSource$zzb:setActive	(Z)V
    //   15: aload_0
    //   16: getfield 362	com/google/android/gms/vision/CameraSource:zzbaO	Ljava/lang/Thread;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +15 -> 36
    //   24: aload_0
    //   25: getfield 362	com/google/android/gms/vision/CameraSource:zzbaO	Ljava/lang/Thread;
    //   28: invokevirtual 439	java/lang/Thread:join	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 362	com/google/android/gms/vision/CameraSource:zzbaO	Ljava/lang/Thread;
    //   36: aload_0
    //   37: getfield 358	com/google/android/gms/vision/CameraSource:zzbaF	Landroid/hardware/Camera;
    //   40: ifnull +45 -> 85
    //   43: aload_0
    //   44: getfield 358	com/google/android/gms/vision/CameraSource:zzbaF	Landroid/hardware/Camera;
    //   47: invokevirtual 442	android/hardware/Camera:stopPreview	()V
    //   50: aload_0
    //   51: getfield 358	com/google/android/gms/vision/CameraSource:zzbaF	Landroid/hardware/Camera;
    //   54: aconst_null
    //   55: invokevirtual 166	android/hardware/Camera:setPreviewCallbackWithBuffer	(Landroid/hardware/Camera$PreviewCallback;)V
    //   58: aload_0
    //   59: getfield 401	com/google/android/gms/vision/CameraSource:zzbaN	Z
    //   62: ifeq +44 -> 106
    //   65: aload_0
    //   66: getfield 358	com/google/android/gms/vision/CameraSource:zzbaF	Landroid/hardware/Camera;
    //   69: aconst_null
    //   70: invokevirtual 399	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   73: aload_0
    //   74: getfield 358	com/google/android/gms/vision/CameraSource:zzbaF	Landroid/hardware/Camera;
    //   77: invokevirtual 443	android/hardware/Camera:release	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 358	com/google/android/gms/vision/CameraSource:zzbaF	Landroid/hardware/Camera;
    //   85: aload_1
    //   86: monitorexit
    //   87: return
    //   88: astore_2
    //   89: ldc -11
    //   91: ldc_w 445
    //   94: invokestatic 448	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: goto -67 -> 31
    //   101: astore_2
    //   102: aload_1
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    //   106: aload_0
    //   107: getfield 358	com/google/android/gms/vision/CameraSource:zzbaF	Landroid/hardware/Camera;
    //   110: aconst_null
    //   111: invokevirtual 430	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   114: goto -41 -> 73
    //   117: astore_2
    //   118: ldc -11
    //   120: new 276	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 450
    //   130: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_2
    //   134: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 293	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   143: pop
    //   144: goto -71 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	CameraSource
    //   4	99	1	localObject1	Object
    //   19	2	2	localThread	Thread
    //   88	1	2	localInterruptedException	InterruptedException
    //   101	4	2	localObject2	Object
    //   117	17	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   24	31	88	java/lang/InterruptedException
    //   7	20	101	finally
    //   24	31	101	finally
    //   31	36	101	finally
    //   36	58	101	finally
    //   58	73	101	finally
    //   73	85	101	finally
    //   85	87	101	finally
    //   89	98	101	finally
    //   102	104	101	finally
    //   106	114	101	finally
    //   118	144	101	finally
    //   58	73	117	java/lang/Exception
    //   106	114	117	java/lang/Exception
  }
  
  public void takePicture(ShutterCallback paramShutterCallback, PictureCallback paramPictureCallback)
  {
    synchronized (this.zzbaE)
    {
      if (this.zzbaF != null)
      {
        zzd localzzd = new zzd(null);
        zzd.zza(localzzd, paramShutterCallback);
        paramShutterCallback = new zzc(null);
        zzc.zza(paramShutterCallback, paramPictureCallback);
        this.zzbaF.takePicture(localzzd, null, null, paramShutterCallback);
      }
      return;
    }
  }
  
  public static class Builder
  {
    private final Detector<?> zzbaR;
    private CameraSource zzbaS = new CameraSource(null);
    
    public Builder(Context paramContext, Detector<?> paramDetector)
    {
      if (paramContext == null) {
        throw new IllegalArgumentException("No context supplied.");
      }
      if (paramDetector == null) {
        throw new IllegalArgumentException("No detector supplied.");
      }
      this.zzbaR = paramDetector;
      CameraSource.zza(this.zzbaS, paramContext);
    }
    
    public CameraSource build()
    {
      CameraSource localCameraSource1 = this.zzbaS;
      CameraSource localCameraSource2 = this.zzbaS;
      localCameraSource2.getClass();
      CameraSource.zza(localCameraSource1, new CameraSource.zzb(localCameraSource2, this.zzbaR));
      return this.zzbaS;
    }
    
    public Builder setFacing(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException("Invalid camera: " + paramInt);
      }
      CameraSource.zzc(this.zzbaS, paramInt);
      return this;
    }
    
    public Builder setRequestedFps(float paramFloat)
    {
      if (paramFloat <= 0.0F) {
        throw new IllegalArgumentException("Invalid fps: " + paramFloat);
      }
      CameraSource.zza(this.zzbaS, paramFloat);
      return this;
    }
    
    public Builder setRequestedPreviewSize(int paramInt1, int paramInt2)
    {
      if ((paramInt1 <= 0) || (paramInt1 > 1000000) || (paramInt2 <= 0) || (paramInt2 > 1000000)) {
        throw new IllegalArgumentException("Invalid preview size: " + paramInt1 + "x" + paramInt2);
      }
      CameraSource.zza(this.zzbaS, paramInt1);
      CameraSource.zzb(this.zzbaS, paramInt2);
      return this;
    }
  }
  
  public static abstract interface PictureCallback
  {
    public abstract void onPictureTaken(byte[] paramArrayOfByte);
  }
  
  public static abstract interface ShutterCallback
  {
    public abstract void onShutter();
  }
  
  private class zza
    implements Camera.PreviewCallback
  {
    private zza() {}
    
    public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      CameraSource.zzc(CameraSource.this).zza(paramArrayOfByte, paramCamera);
    }
  }
  
  private class zzb
    implements Runnable
  {
    private long zzNY = SystemClock.elapsedRealtime();
    private Detector<?> zzbaR;
    private boolean zzbaU = true;
    private long zzbaV;
    private int zzbaW = 0;
    private ByteBuffer zzbaX;
    private final Object zzpd = new Object();
    
    static
    {
      if (!CameraSource.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    zzb()
    {
      Detector localDetector;
      this.zzbaR = localDetector;
    }
    
    void release()
    {
      assert (CameraSource.zzd(CameraSource.this).getState() == Thread.State.TERMINATED);
      this.zzbaR.release();
      this.zzbaR = null;
    }
    
    public void run()
    {
      for (;;)
      {
        synchronized (this.zzpd)
        {
          if (this.zzbaU)
          {
            ByteBuffer localByteBuffer1 = this.zzbaX;
            if (localByteBuffer1 != null) {}
          }
          try
          {
            this.zzpd.wait();
            if (!this.zzbaU) {
              return;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.d("CameraSource", "Frame processing loop terminated.", localInterruptedException);
            return;
          }
        }
        Frame localFrame = new Frame.Builder().setImageData(this.zzbaX, CameraSource.zzg(CameraSource.this).getWidth(), CameraSource.zzg(CameraSource.this).getHeight(), 17).setId(this.zzbaW).setTimestampMillis(this.zzbaV).setRotation(CameraSource.zzf(CameraSource.this)).build();
        ByteBuffer localByteBuffer2 = this.zzbaX;
        this.zzbaX = null;
        try
        {
          this.zzbaR.receiveFrame(localFrame);
          CameraSource.zzb(CameraSource.this).addCallbackBuffer(localByteBuffer2.array());
        }
        catch (Throwable localThrowable)
        {
          Log.e("CameraSource", "Exception thrown from receiver.", localThrowable);
          CameraSource.zzb(CameraSource.this).addCallbackBuffer(localByteBuffer2.array());
        }
        finally
        {
          CameraSource.zzb(CameraSource.this).addCallbackBuffer(localByteBuffer2.array());
        }
      }
    }
    
    void setActive(boolean paramBoolean)
    {
      synchronized (this.zzpd)
      {
        this.zzbaU = paramBoolean;
        this.zzpd.notifyAll();
        return;
      }
    }
    
    void zza(byte[] paramArrayOfByte, Camera paramCamera)
    {
      synchronized (this.zzpd)
      {
        if (this.zzbaX != null)
        {
          paramCamera.addCallbackBuffer(this.zzbaX.array());
          this.zzbaX = null;
        }
        this.zzbaV = (SystemClock.elapsedRealtime() - this.zzNY);
        this.zzbaW += 1;
        this.zzbaX = ((ByteBuffer)CameraSource.zze(CameraSource.this).get(paramArrayOfByte));
        this.zzpd.notifyAll();
        return;
      }
    }
  }
  
  private class zzc
    implements Camera.PictureCallback
  {
    private CameraSource.PictureCallback zzbaY;
    
    private zzc() {}
    
    public void onPictureTaken(byte[] arg1, Camera paramCamera)
    {
      if (this.zzbaY != null) {
        this.zzbaY.onPictureTaken(???);
      }
      synchronized (CameraSource.zza(CameraSource.this))
      {
        if (CameraSource.zzb(CameraSource.this) != null) {
          CameraSource.zzb(CameraSource.this).startPreview();
        }
        return;
      }
    }
  }
  
  private class zzd
    implements Camera.ShutterCallback
  {
    private CameraSource.ShutterCallback zzbaZ;
    
    private zzd() {}
    
    public void onShutter()
    {
      if (this.zzbaZ != null) {
        this.zzbaZ.onShutter();
      }
    }
  }
  
  private static class zze
  {
    private Size zzbba;
    private Size zzbbb;
    
    public zze(Camera.Size paramSize1, Camera.Size paramSize2)
    {
      this.zzbba = new Size(paramSize1.width, paramSize1.height);
      this.zzbbb = new Size(paramSize2.width, paramSize2.height);
    }
    
    public Size zzEv()
    {
      return this.zzbba;
    }
    
    public Size zzEw()
    {
      return this.zzbbb;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\CameraSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */