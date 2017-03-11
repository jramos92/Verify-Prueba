package com.veryfit.multi.camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.List;

public class CameraInterface
{
  private static final String TAG = "CameraInterface";
  private static CameraInterface mCameraInterface;
  private final int TIMER_HANDLER = 11;
  private Handler autoFocusHandler = new Handler();
  private boolean isPreviewing = false;
  private Camera mCamera;
  private int mCameraId = 0;
  private Context mContext;
  private int mCounter = 1;
  private Handler mHandler;
  private Handler.Callback mHandlerCallback = new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 11)
      {
        String str = null;
        Object localObject = (byte[])paramAnonymousMessage.obj;
        paramAnonymousMessage = str;
        if (localObject != null) {
          paramAnonymousMessage = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        }
        if (paramAnonymousMessage != null)
        {
          float f = 90.0F;
          if (CameraInterface.this.mCameraId != 0) {
            f = -90.0F;
          }
          localObject = ImageUtil.getRotateBitmap(paramAnonymousMessage, f);
          str = FileUtil.saveBitmap(CameraInterface.this.mContext, (Bitmap)localObject);
          ((Bitmap)localObject).recycle();
          paramAnonymousMessage.recycle();
          if (CameraInterface.this.mContext != null)
          {
            paramAnonymousMessage = new Intent("com.guodoo.multi.takepicture_receiver");
            paramAnonymousMessage.putExtra("fileName", str);
            CameraInterface.this.mContext.sendBroadcast(paramAnonymousMessage);
          }
        }
      }
      return true;
    }
  };
  private long mInterval = 0L;
  private Camera.PictureCallback mJpegPictureCallback = new Camera.PictureCallback()
  {
    public void onPictureTaken(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
    {
      CameraInterface.this.mHandler.sendMessage(CameraInterface.this.mHandler.obtainMessage(11, paramAnonymousArrayOfByte));
      CameraInterface.this.mCamera.startPreview();
      CameraInterface.this.isPreviewing = true;
      paramAnonymousArrayOfByte = CameraInterface.this;
      paramAnonymousArrayOfByte.mCounter -= 1;
      if (CameraInterface.this.mCounter > 0)
      {
        CameraInterface.this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            CameraInterface.this.doTakePicture(CameraInterface.this.mCounter, CameraInterface.this.mInterval);
          }
        }, CameraInterface.this.mInterval);
        return;
      }
      CameraInterface.this.takingPhoto = false;
      Log.e("CameraInterface", "连拍完成.");
    }
  };
  private Camera.Parameters mParams;
  private Camera.ShutterCallback mShutterCallback = new Camera.ShutterCallback()
  {
    public void onShutter()
    {
      if (CameraInterface.this.mSoundUtil != null) {
        CameraInterface.this.mSoundUtil.play();
      }
    }
  };
  private SoundUtil mSoundUtil;
  private boolean previewing = true;
  private int takePictureType = 0;
  private boolean takingPhoto = false;
  
  private CameraInterface()
  {
    HandlerThread localHandlerThread = new HandlerThread("CameraInterface");
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper(), this.mHandlerCallback);
  }
  
  private String convertFlashValueToMode(String paramString)
  {
    if (paramString.equals("flash_auto")) {
      return "auto";
    }
    if (paramString.equals("flash_on")) {
      return "on";
    }
    if (paramString.equals("flash_off")) {
      return "off";
    }
    return "auto";
  }
  
  public static CameraInterface getInstance()
  {
    try
    {
      if (mCameraInterface == null) {
        mCameraInterface = new CameraInterface();
      }
      CameraInterface localCameraInterface = mCameraInterface;
      return localCameraInterface;
    }
    finally {}
  }
  
  private void setFlash(String paramString)
  {
    Camera.Parameters localParameters = this.mCamera.getParameters();
    if ((paramString.length() > 0) && (!paramString.equals(localParameters.getFlashMode())))
    {
      localParameters.setFlashMode(paramString);
      this.mCamera.setParameters(localParameters);
    }
  }
  
  public void doOpenCamera(final CamOpenOverCallback paramCamOpenOverCallback, final int paramInt)
  {
    if ((this.mCamera == null) && (paramInt != -1))
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Log.i("CameraInterface", "Camera open....");
          try
          {
            CameraInterface.this.mCamera = Camera.open(paramInt);
            CameraInterface.this.mCameraId = paramInt;
            Log.i("CameraInterface", "Camera open over....");
            paramCamOpenOverCallback.cameraHasOpened();
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      });
    }
  }
  
  public void doStartPreview(SurfaceHolder paramSurfaceHolder, float paramFloat)
  {
    Log.i("CameraInterface", "doStartPreview...");
    if (this.isPreviewing) {
      this.mCamera.stopPreview();
    }
    while (this.mCamera == null) {
      return;
    }
    this.mParams = this.mCamera.getParameters();
    this.mParams.setPictureFormat(256);
    this.mParams.setJpegQuality(80);
    CamParaUtil.getInstance().printSupportPictureSize(this.mParams);
    CamParaUtil.getInstance().printSupportPreviewSize(this.mParams);
    Camera.Size localSize = CamParaUtil.getInstance().getPropPictureSize(this.mParams.getSupportedPictureSizes(), paramFloat, 800);
    this.mParams.setPictureSize(localSize.width, localSize.height);
    localSize = CamParaUtil.getInstance().getPropPreviewSize(this.mParams.getSupportedPreviewSizes(), paramFloat, 800);
    this.mParams.setPreviewSize(localSize.width, localSize.height);
    this.mCamera.setDisplayOrientation(90);
    CamParaUtil.getInstance().printSupportFocusMode(this.mParams);
    if (this.mParams.getSupportedFocusModes().contains("continuous-video")) {
      this.mParams.setFocusMode("continuous-video");
    }
    this.mCamera.setParameters(this.mParams);
    try
    {
      this.mCamera.setPreviewDisplay(paramSurfaceHolder);
      this.mCamera.startPreview();
      this.isPreviewing = true;
      this.mParams = this.mCamera.getParameters();
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      for (;;)
      {
        paramSurfaceHolder.printStackTrace();
      }
    }
  }
  
  public void doStopCamera()
  {
    if (this.mCamera != null)
    {
      this.mCamera.setPreviewCallbackWithBuffer(null);
      this.mCamera.stopPreview();
      this.isPreviewing = false;
      this.takingPhoto = false;
      this.mCamera.release();
      this.mCamera = null;
    }
  }
  
  public void doTakePicture(int paramInt, long paramLong)
  {
    this.mCounter = paramInt;
    this.mInterval = paramLong;
    if ((this.isPreviewing) && (this.mCamera != null) && (this.mCounter > 0))
    {
      this.takingPhoto = true;
      this.mCamera.takePicture(this.mShutterCallback, null, this.mJpegPictureCallback);
    }
  }
  
  public int getDefaultCameraId(int paramInt)
  {
    int j = -1;
    int k = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      if (i >= k) {}
      for (paramInt = j;; paramInt = i)
      {
        i = paramInt;
        if (-1 == paramInt)
        {
          i = paramInt;
          if (k > 0) {
            i = 0;
          }
        }
        return i;
        Camera.getCameraInfo(i, localCameraInfo);
        if (localCameraInfo.facing != paramInt) {
          break;
        }
      }
      i += 1;
    }
  }
  
  public void initSoundPool(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mSoundUtil == null) {
      this.mSoundUtil = new SoundUtil(paramContext);
    }
    while (paramContext.equals(this.mSoundUtil.getContext())) {
      return;
    }
    this.mSoundUtil.destory();
    this.mSoundUtil = new SoundUtil(paramContext);
  }
  
  public boolean isTakingPhoto()
  {
    return this.takingPhoto;
  }
  
  public void updateFlashMode(String paramString)
  {
    if (this.mCamera == null) {}
    List localList;
    do
    {
      do
      {
        return;
        localList = this.mCamera.getParameters().getSupportedFlashModes();
      } while (localList == null);
      paramString = convertFlashValueToMode(paramString);
    } while (localList.indexOf(paramString) == -1);
    setFlash(paramString);
  }
  
  public static abstract interface CamOpenOverCallback
  {
    public abstract void cameraHasOpened();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\CameraInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */