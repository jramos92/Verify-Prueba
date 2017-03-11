package com.veryfit.multi.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.device.cmd.appcontrol.AppControlCmd;
import com.project.library.util.DebugLog;
import com.veryfit.multi.photowall.ImageDetailsActivity;
import com.veryfit.multi.photowall.Images;
import java.util.List;

public class PhotoFragment
  extends Fragment
  implements View.OnTouchListener
{
  public static final String ACTION = "com.guodoo.multi.takepicture_receiver";
  private static final byte MODE_CAMERA = 3;
  private static final byte MODE_EXIT = 1;
  private static final byte MODE_IDLE = 2;
  private static final byte MODE_OPEN = 0;
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onAppControlSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousByte == 2)
      {
        if (paramAnonymousBoolean) {
          break label17;
        }
        PhotoFragment.this.failedOpenCameraMode();
      }
      label17:
      do
      {
        return;
        if (PhotoFragment.this.mode == 1)
        {
          PhotoFragment.this.mode = 2;
          PhotoFragment.this.getActivity().finish();
          return;
        }
      } while (PhotoFragment.this.mode != 0);
      PhotoFragment.this.mode = 3;
    }
    
    public void onBLEConnected()
    {
      if (PhotoFragment.this.mode == 3) {
        PhotoFragment.this.mCore.writeForce(AppControlCmd.getInstance().getCameraCmd((byte)0));
      }
    }
    
    public void onBLEDisConnected(String paramAnonymousString) {}
    
    public void onBleControlReceive(byte paramAnonymousByte1, byte paramAnonymousByte2)
    {
      DebugLog.d("onBleControlReceive====接收拍照命令");
      PhotoFragment.this.mReceiveCmdTime = System.currentTimeMillis();
      if ((paramAnonymousByte1 == 1) && (com.project.library.device.cmd.blecontrol.BleControlCmd.EVENT_TYPE[5] == paramAnonymousByte2) && (PhotoFragment.this.getActivity() != null)) {
        PhotoFragment.this.getActivity().runOnUiThread(new Runnable()
        {
          public void run()
          {
            PhotoFragment.this.clickedTakePhoto();
          }
        });
      }
    }
    
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte)
    {
      if ((DeviceBaseCommand.getCmdId(paramAnonymousArrayOfByte) == 6) && (DeviceBaseCommand.getCmdKey(paramAnonymousArrayOfByte) == 2)) {
        PhotoFragment.this.failedOpenCameraMode();
      }
    }
  };
  private Button mCloseFlashBtn;
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private SeekBar mCountSeekBar;
  private Button mDefaultFlashBtn;
  private FlashState mFlashState = FlashState.FLASH_AUTO;
  private View mFlashView;
  private ImageView mGalleryBtn;
  private Handler mHandler = new Handler();
  private ImageView mIvFocus;
  private Button mOpenFlashBtn;
  private Button mPhotoCloseBtn;
  private TextView mPhotoCount;
  private TextView mPhotoTime;
  private CameraPreView mPreView = null;
  private long mReceiveCmdTime = 0L;
  private View mRootView;
  private View mSettingView;
  private SharedPreferences mSharedPreferences = null;
  private Button mTakePhotoBtn;
  private SeekBar mTimeSeekBar;
  private byte mode = 2;
  private BroadcastReceiver takePictureReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("com.guodoo.multi.takepicture_receiver"))
      {
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("fileName");
        PhotoFragment.this.setDefaultIcon(paramAnonymousContext);
      }
    }
  };
  
  private void failedOpenCameraMode()
  {
    this.mode = 1;
    this.mCore.writeForce(AppControlCmd.getInstance().getCameraCmd((byte)1));
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(PhotoFragment.this.getActivity(), 2131296617, 0).show();
        PhotoFragment.this.getActivity().finish();
      }
    });
  }
  
  private void initBle()
  {
    this.mode = 2;
    if (this.mCore.isAvailable())
    {
      this.mCore.addListener(this.mAppListener);
      if (!this.mCore.isDeviceConnected()) {
        break label73;
      }
      if (!this.mCore.writeForce(AppControlCmd.getInstance().getCameraCmd((byte)0))) {
        Toast.makeText(getActivity(), 2131296616, 0).show();
      }
    }
    else
    {
      return;
    }
    this.mode = 0;
    return;
    label73:
    Toast.makeText(getActivity(), 2131296616, 0).show();
  }
  
  private void initFlashControl()
  {
    this.mFlashView = this.mRootView.findViewById(2131231039);
    this.mDefaultFlashBtn = ((Button)this.mRootView.findViewById(2131231038));
    this.mCloseFlashBtn = ((Button)this.mRootView.findViewById(2131231040));
    this.mOpenFlashBtn = ((Button)this.mRootView.findViewById(2131231041));
    this.mFlashView.setVisibility(8);
    this.mDefaultFlashBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        switch (PhotoFragment.this.mFlashState)
        {
        default: 
          PhotoFragment.this.mFlashState = PhotoFragment.FlashState.FLASH_ON;
          PhotoFragment.this.mPreView.updateFlash("flash_on");
          PhotoFragment.this.mDefaultFlashBtn.setBackgroundResource(2130837563);
          return;
        case FLASH_ON: 
          PhotoFragment.this.mFlashState = PhotoFragment.FlashState.FLASH_OFF;
          PhotoFragment.this.mPreView.updateFlash("flash_off");
          PhotoFragment.this.mDefaultFlashBtn.setBackgroundResource(2130837562);
          return;
        }
        PhotoFragment.this.mFlashState = PhotoFragment.FlashState.FLASH_AUTO;
        PhotoFragment.this.mPreView.updateFlash("flash_auto");
        PhotoFragment.this.mDefaultFlashBtn.setBackgroundResource(2130837561);
      }
    });
  }
  
  private void initSetting()
  {
    this.mSettingView = this.mRootView.findViewById(2131231043);
    this.mSettingView.setVisibility(8);
    this.mPhotoCount = ((TextView)this.mRootView.findViewById(2131231045));
    this.mPhotoTime = ((TextView)this.mRootView.findViewById(2131231047));
    this.mCountSeekBar = ((SeekBar)this.mRootView.findViewById(2131231044));
    this.mCountSeekBar.setMax(15);
    this.mTimeSeekBar = ((SeekBar)this.mRootView.findViewById(2131231046));
    this.mTimeSeekBar.setMax(100);
    int i = Integer.parseInt(this.mSharedPreferences.getString("preference_burst_mode", "1"));
    float f = Float.parseFloat(this.mSharedPreferences.getString("preference_burst_interval", "0"));
    this.mCountSeekBar.setProgress(i);
    this.mTimeSeekBar.setProgress((int)(10.0F * f));
    if (i == 1)
    {
      str = getResources().getString(2131296612);
      this.mPhotoCount.setText(i + " " + str);
      if (f / 1.0F != 1.0F) {
        break label331;
      }
    }
    label331:
    for (String str = getResources().getString(2131296410);; str = getResources().getString(2131296610))
    {
      this.mPhotoTime.setText(f / 1.0F + " " + str);
      this.mCountSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousInt == 1) {}
          for (paramAnonymousSeekBar = PhotoFragment.this.getResources().getString(2131296612);; paramAnonymousSeekBar = PhotoFragment.this.getResources().getString(2131296613))
          {
            PhotoFragment.this.mPhotoCount.setText(paramAnonymousInt + " " + paramAnonymousSeekBar);
            PhotoFragment.this.mSharedPreferences.edit().putString("preference_burst_mode", paramAnonymousInt).commit();
            return;
          }
        }
        
        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
        
        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      });
      this.mTimeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousInt / 10.0F == 1.0F) {}
          for (paramAnonymousSeekBar = PhotoFragment.this.getResources().getString(2131296410);; paramAnonymousSeekBar = PhotoFragment.this.getResources().getString(2131296610))
          {
            PhotoFragment.this.mPhotoTime.setText(paramAnonymousInt / 10.0F + " " + paramAnonymousSeekBar);
            PhotoFragment.this.mSharedPreferences.edit().putString("preference_burst_interval", paramAnonymousInt / 10.0F).commit();
            return;
          }
        }
        
        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
        
        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      });
      this.mRootView.findViewById(2131231048).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PhotoFragment.this.clickedOkTextView();
        }
      });
      return;
      str = getResources().getString(2131296613);
      break;
    }
  }
  
  private void setAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(3.0F, 1.5F, 3.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
    localAlphaAnimation.setDuration(2000L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.mIvFocus.startAnimation(localAnimationSet);
    this.mIvFocus.setVisibility(4);
  }
  
  private void setDefaultIcon(String paramString)
  {
    if (paramString == null)
    {
      this.mGalleryBtn.setImageDrawable(getResources().getDrawable(2130837507));
      return;
    }
    paramString = ThumbnailUtils.extractThumbnail(SDCardImageLoader.getInstance().compressBitmap(paramString), 55, 55);
    this.mGalleryBtn.setImageBitmap(paramString);
  }
  
  public void clickedGallery()
  {
    Intent localIntent = new Intent("android.intent.action.PICK", null);
    localIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
    startActivityForResult(localIntent, 100);
  }
  
  public void clickedOkTextView()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(getActivity(), 2130968596);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        PhotoFragment.this.mSettingView.setVisibility(8);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.mSettingView.startAnimation(localAnimation);
  }
  
  public void clickedSetting()
  {
    if (this.mSettingView.getVisibility() == 8)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(getActivity(), 2130968595);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          PhotoFragment.this.mSettingView.setVisibility(0);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.mSettingView.startAnimation(localAnimation);
      this.mSettingView.setVisibility(0);
    }
  }
  
  public void clickedSwitchCamera()
  {
    this.mPreView.switchCamera();
  }
  
  public void clickedTakePhoto()
  {
    if (this.mPreView != null) {
      this.mPreView.takePicturePressed();
    }
  }
  
  public void initView()
  {
    ScreenUtils.initScreen(getActivity());
    this.mPreView = ((CameraPreView)this.mRootView.findViewById(2131231032));
    ViewGroup.LayoutParams localLayoutParams = this.mPreView.getLayoutParams();
    Point localPoint = DisplayUtil.getScreenMetrics(getActivity());
    this.mIvFocus = ((ImageView)this.mRootView.findViewById(2131231033));
    localLayoutParams.width = localPoint.x;
    localLayoutParams.height = localPoint.y;
    this.mPreView.setLayoutParams(localLayoutParams);
    this.mTakePhotoBtn = ((Button)this.mRootView.findViewById(2131231036));
    this.mTakePhotoBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (PhotoFragment.this != null) {
          PhotoFragment.this.clickedTakePhoto();
        }
      }
    });
    this.mGalleryBtn = ((ImageView)this.mRootView.findViewById(2131231037));
    this.mGalleryBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PhotoFragment.this.getActivity().startActivity(new Intent(PhotoFragment.this.getActivity(), ImageDetailsActivity.class));
      }
    });
    this.mRootView.findViewById(2131231042).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PhotoFragment.this.clickedSwitchCamera();
      }
    });
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        PhotoFragment.this.mPhotoCloseBtn.setVisibility(0);
        PhotoFragment.this.mRootView.findViewById(2131231037).setVisibility(0);
      }
    }, 1000L);
    this.mPhotoCloseBtn = ((Button)this.mRootView.findViewById(2131231035));
    this.mPhotoCloseBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((CameraInterface.getInstance().isTakingPhoto()) || (System.currentTimeMillis() - PhotoFragment.this.mReceiveCmdTime < 1200L)) {
          return;
        }
        PhotoFragment.this.onBackKeyDown();
      }
    });
    initFlashControl();
    setAnimation();
    this.mPreView.setOnTouchListener(this);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().addFlags(128);
  }
  
  public void onBackKeyDown()
  {
    if ((this.mode == 3) && (this.mCore.isDeviceConnected()))
    {
      if (!this.mCore.write(AppControlCmd.getInstance().getCameraCmd((byte)1)))
      {
        this.mode = 1;
        this.mCore.writeForce(AppControlCmd.getInstance().getCameraCmd((byte)1));
        return;
      }
      this.mode = 1;
      return;
    }
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mRootView != null)
    {
      paramLayoutInflater = (ViewGroup)this.mRootView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.mRootView);
      }
    }
    for (;;)
    {
      paramLayoutInflater = new IntentFilter("com.guodoo.multi.takepicture_receiver");
      getActivity().registerReceiver(this.takePictureReceiver, paramLayoutInflater);
      return this.mRootView;
      this.mRootView = paramLayoutInflater.inflate(2130903104, paramViewGroup, false);
      this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
      initView();
      initBle();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.takePictureReceiver);
    this.mCore.removeListener(this.mAppListener);
  }
  
  public void onPause()
  {
    this.mPreView.onPause();
    CameraInterface.getInstance().doStopCamera();
    super.onPause();
  }
  
  public void onResume()
  {
    List localList = Images.getImages();
    if ((localList == null) || (localList.size() <= 0)) {
      this.mGalleryBtn.setImageDrawable(getResources().getDrawable(2130837507));
    }
    for (;;)
    {
      this.mPreView.cameraHasOpened();
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          PhotoFragment.this.mPreView.onResume();
        }
      }, 1000L);
      super.onResume();
      return;
      setDefaultIcon((String)localList.get(0));
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    }
    float f2 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.mIvFocus.measure(i, j);
    int k = this.mIvFocus.getHeight();
    int m = this.mIvFocus.getWidth();
    float f1 = f2;
    if (f2 < m / 2) {
      f1 = m / 2;
    }
    f2 = f1;
    if (f1 > DisplayUtil.getScreenMetrics(getActivity()).x - m / 2) {
      f2 = DisplayUtil.getScreenMetrics(getActivity()).x - m / 2;
    }
    f1 = f3;
    if (f3 < k / 2) {
      f1 = k / 2;
    }
    f3 = f1;
    if (f1 > DisplayUtil.getScreenMetrics(getActivity()).y - k / 2) {
      f3 = DisplayUtil.getScreenMetrics(getActivity()).y - k / 2;
    }
    i = (int)(f2 - m / 2);
    j = (int)(f3 - k / 2);
    m = (int)(m / 2 + f2);
    k = (int)(k / 2 + f3);
    this.mIvFocus.layout(i, j, m, k);
    setAnimation();
    return false;
  }
  
  static enum FlashState
  {
    FLASH_AUTO,  FLASH_OFF,  FLASH_ON;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\PhotoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */