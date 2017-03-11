package com.veryfit.multi.util;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.facebook.Facebook.ShareParams;
import cn.sharesdk.flickr.Flickr;
import cn.sharesdk.flickr.Flickr.ShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.instagram.Instagram;
import cn.sharesdk.instagram.Instagram.ShareParams;
import cn.sharesdk.linkedin.LinkedIn;
import cn.sharesdk.linkedin.LinkedIn.ShareParams;
import cn.sharesdk.system.email.Email;
import cn.sharesdk.system.email.Email.ShareParams;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qq.QQ.ShareParams;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.twitter.Twitter.ShareParams;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.friends.Wechat.ShareParams;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.sharesdk.wechat.moments.WechatMoments.ShareParams;
import cn.sharesdk.whatsapp.WhatsApp;
import cn.sharesdk.whatsapp.WhatsApp.ShareParams;
import java.io.File;
import java.util.HashMap;

public class ShareCtrl
{
  private static final String SHARE_TEXT = "Veryfit 2.0";
  private static final String SHARE_TITLE = "Veryfit 2.0";
  private static final String SHARE_TITLE_URL = "http://idokeji.cn.china.cn/";
  public static final int SHARE_TYEP_EMAIL = 10;
  public static final int SHARE_TYEP_FACEBOOK = 5;
  public static final int SHARE_TYEP_FIRENDS = 3;
  public static final int SHARE_TYEP_FLICKR = 11;
  public static final int SHARE_TYEP_INSTAGRAM = 7;
  public static final int SHARE_TYEP_LINKEDIN = 8;
  public static final int SHARE_TYEP_QQ = 1;
  public static final int SHARE_TYEP_SINA = 4;
  public static final int SHARE_TYEP_TWITTER = 6;
  public static final int SHARE_TYEP_WECHAT = 2;
  public static final int SHARE_TYEP_WHATSAPP = 9;
  public static final String TAG = "ShareCtrl";
  
  public static void shareToEmail(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    ScreenShot.shoot(paramActivity);
    paramActivity = new Email.ShareParams();
    paramActivity.setAddress("gao290112881@qq.com");
    paramActivity.setText("Veryfit 2.0");
    paramActivity.setTitle("Veryfit 2.0");
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(Email.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shareToEmail--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(10);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shareToEmail--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(10);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shareToEmail--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(10);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static void shareToFacebook(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    ScreenShot.shoot(paramActivity);
    paramActivity = new Facebook.ShareParams();
    paramActivity.setText("");
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(Facebook.NAME);
    if (localPlatform != null) {
      localPlatform.setPlatformActionListener(new PlatformActionListener()
      {
        public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
        {
          Log.d("ShareCtrl", "shareToFacebook--------------------onCancel");
          if (ShareCtrl.this != null) {
            ShareCtrl.this.onCancel(5);
          }
        }
        
        public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
        {
          Log.d("ShareCtrl", "shareToFacebook--------------------onComplete");
          if (ShareCtrl.this != null) {
            ShareCtrl.this.onComplete(5);
          }
        }
        
        public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
        {
          Log.d("ShareCtrl", "shareToFacebook--------------------onError");
          if (ShareCtrl.this != null) {
            ShareCtrl.this.onError(5);
          }
        }
      });
    }
    localPlatform.share(paramActivity);
  }
  
  public static void shareToFlickr(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    ScreenShot.shoot(paramActivity);
    paramActivity = new Flickr.ShareParams();
    paramActivity.setShareType(2);
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(Flickr.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shareToFlickr--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(11);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shareToFlickr--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(11);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shareToFlickr--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(11);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static void shareToInstagram(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    ScreenShot.shoot(paramActivity);
    paramActivity = new Instagram.ShareParams();
    paramActivity.setShareType(4);
    paramActivity.setText("Veryfit 2.0");
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(Instagram.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shareToinstagram--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(7);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shareToinstagram--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(7);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shareToinstagram--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(7);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static void shareToLinkedin(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    ScreenShot.shoot(paramActivity);
    paramActivity = new LinkedIn.ShareParams();
    paramActivity.setShareType(2);
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(LinkedIn.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shartToLinkedin--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(8);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shartToLinkedin--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(8);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shartToLinkedin--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(8);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static void shareToMoments(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    new File(Environment.getExternalStorageDirectory() + "/s_ido.png").delete();
    ScreenShot.shoot(paramActivity);
    paramActivity = new WechatMoments.ShareParams();
    paramActivity.setShareType(4);
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(WechatMoments.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shareToMoments--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(3);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shareToMoments--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(3);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shareToMoments--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(3);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static void shareToQQ(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    new File(Environment.getExternalStorageDirectory() + "/s_ido.png").delete();
    ScreenShot.shoot(paramActivity);
    paramActivity = new QQ.ShareParams();
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(QQ.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shareToQQ--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(1);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shareToQQ--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(1);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shareToQQ--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(1);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static void shareToTwitter(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    ScreenShot.shoot(paramActivity);
    paramActivity = new Twitter.ShareParams();
    paramActivity.setShareType(4);
    paramActivity.setShareType(4);
    paramActivity.setText("Veryfit 2.0");
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(Twitter.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shareToTwitter--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(6);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shareToTwitter--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(6);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shareToTwitter--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(6);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static void shareToWeChat(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    new File(Environment.getExternalStorageDirectory() + "/s_ido.png").delete();
    ScreenShot.shoot(paramActivity);
    paramActivity = new Wechat.ShareParams();
    paramActivity.setShareType(2);
    paramActivity.setTitle("dddd");
    paramActivity.setText("ddd");
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(Wechat.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shareToWeChat--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(2);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shareToWeChat--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(2);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shareToWeChat--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(2);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static void shareToWhatsApp(Activity paramActivity, OnShareListener paramOnShareListener)
  {
    ScreenShot.shoot(paramActivity);
    paramActivity = new WhatsApp.ShareParams();
    paramActivity.setShareType(2);
    paramActivity.setImagePath(Environment.getExternalStorageDirectory() + "/s_ido.png");
    Platform localPlatform = ShareSDK.getPlatform(WhatsApp.NAME);
    localPlatform.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        Log.d("ShareCtrl", "shartToWhatsApp--------------------onCancel");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onCancel(9);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        Log.d("ShareCtrl", "shartToWhatsApp--------------------onComplete");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onComplete(9);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        Log.d("ShareCtrl", "shartToWhatsApp--------------------onError");
        if (ShareCtrl.this != null) {
          ShareCtrl.this.onError(9);
        }
      }
    });
    localPlatform.share(paramActivity);
  }
  
  public static abstract interface OnShareListener
  {
    public abstract void onCancel(int paramInt);
    
    public abstract void onComplete(int paramInt);
    
    public abstract void onError(int paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\ShareCtrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */