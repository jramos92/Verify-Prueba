package com.veryfit.multi.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.veryfit.multi.share.AppSharedPreferences;

public class CameraPreView
  extends SurfaceView
  implements SurfaceHolder.Callback, CameraInterface.CamOpenOverCallback
{
  private int mCameraId = 0;
  private Context mContext;
  private SurfaceHolder mSurfaceHolder;
  private float previewRate;
  
  public CameraPreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.previewRate = (AppSharedPreferences.getInstance().getScreenRawHeight() / DisplayUtil.getScreenMetrics(this.mContext).x);
    this.mSurfaceHolder = getHolder();
    this.mSurfaceHolder.setFormat(-2);
    this.mSurfaceHolder.addCallback(this);
  }
  
  public void cameraHasOpened()
  {
    CameraInterface.getInstance().doStartPreview(this.mSurfaceHolder, this.previewRate);
  }
  
  public SurfaceHolder getSurfaceHolder()
  {
    return this.mSurfaceHolder;
  }
  
  public void onPause()
  {
    CameraInterface.getInstance().doStopCamera();
  }
  
  public void onResume()
  {
    CameraInterface.getInstance().doOpenCamera(this, this.mCameraId);
    CameraInterface.getInstance().initSoundPool(this.mContext);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    CameraInterface.getInstance().doOpenCamera(this, this.mCameraId);
    CameraInterface.getInstance().initSoundPool(this.mContext);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    CameraInterface.getInstance().doStopCamera();
  }
  
  public void switchCamera()
  {
    if (this.mCameraId == 0) {}
    for (this.mCameraId = CameraInterface.getInstance().getDefaultCameraId(1);; this.mCameraId = CameraInterface.getInstance().getDefaultCameraId(0))
    {
      CameraInterface.getInstance().doStopCamera();
      CameraInterface.getInstance().doOpenCamera(this, this.mCameraId);
      return;
    }
  }
  
  public void takePicturePressed()
  {
    if (CameraInterface.getInstance().isTakingPhoto()) {
      return;
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mContext);
    int i = Integer.parseInt(localSharedPreferences.getString("preference_burst_mode", "1"));
    float f = Float.parseFloat(localSharedPreferences.getString("preference_burst_interval", "0"));
    CameraInterface.getInstance().doTakePicture(i, (1000.0F * f));
  }
  
  public void updateFlash(String paramString)
  {
    CameraInterface.getInstance().updateFlashMode(paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\CameraPreView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */