package com.veryfit.multi.ui.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import com.android.volley.VolleyError;
import com.nostra13.universalimageloader.utils.L;
import com.project.library.util.DebugLog;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.camera.GsonUtil;
import com.veryfit.multi.model.User;
import com.veryfit.multi.net.AVolleyResponse;
import com.veryfit.multi.net.ErrorCodeMap;
import com.veryfit.multi.net.GsonRequest;
import com.veryfit.multi.net.ResponseEntity;
import com.veryfit.multi.net.VolleyUtil;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.ActivityCollector;
import com.veryfit.multi.util.BlowfishCrypter;
import com.veryfit.multi.util.NetUtils;
import com.veryfit.multi.util.Util;
import java.util.HashMap;

public class LoginActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final int LOGIN_CANCLE = 6;
  private static final int LOGIN_ERROR = 7;
  private static final int LOGIN_FACEBOOK = 5;
  private static final int LOGIN_GENERAL = 1;
  private static final int LOGIN_QQ = 2;
  private static final int LOGIN_SINA = 4;
  private static final int LOGIN_WECHAT = 3;
  private static final String TAG = "LoginActivity";
  private BlowfishCrypter bf = new BlowfishCrypter();
  private Button btn_back;
  private Button btn_forget_pwd;
  private Button btn_login;
  private ImageButton btn_qq_login;
  private Button btn_register;
  private Button btn_remeber_pwd;
  private ImageButton btn_wechat_login;
  private ImageButton btn_weibo_login;
  private String channelId;
  private EditText et_password;
  private EditText et_username;
  private String imei;
  private InputMethodManager imm;
  private String imsi;
  private boolean isLogining = false;
  private boolean isRegistering = false;
  private boolean isSavePwd = true;
  private LinearLayout ll_login_content;
  private LinearLayout ll_register_content;
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  private HashMap<String, Object> mData;
  @SuppressLint({"HandlerLeak"})
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 4: 
      default: 
        return;
      case 2: 
        LoginActivity.this.doLogin(2, LoginActivity.this.mPatform.getDb().getUserId(), LoginActivity.this.mData.get("nickname").toString(), LoginActivity.this.mData.get("figureurl_qq_2").toString());
        return;
      case 3: 
        LoginActivity.this.doLogin(3, LoginActivity.this.mPatform.getDb().getUserId(), LoginActivity.this.mPatform.getDb().getUserName(), LoginActivity.this.mPatform.getDb().getUserIcon());
        return;
      case 5: 
        LoginActivity.this.doLogin(5, LoginActivity.this.mPatform.getDb().getUserId(), LoginActivity.this.mPatform.getDb().getUserName(), LoginActivity.this.mPatform.getDb().getUserIcon());
        return;
      case 6: 
        LoginActivity.this.isLogining = false;
        LoginActivity.this.dismissProgress();
        Toast.makeText(LoginActivity.this, 2131296719, 0).show();
        return;
      }
      LoginActivity.this.isLogining = false;
      LoginActivity.this.dismissProgress();
      Toast.makeText(LoginActivity.this, 2131296718, 0).show();
    }
  };
  private Platform mPatform;
  private String password;
  private ProgressDialog progressDialog;
  private String regEmail;
  private String regPass;
  private GsonRequest<ResponseEntity> regRequest;
  private EditText register_email;
  private EditText register_password;
  private GsonRequest<ResponseEntity> request;
  private Resources res;
  private RadioGroup rg_tab;
  private String userName;
  
  private boolean checkInput()
  {
    this.userName = this.et_username.getText().toString().trim();
    this.password = this.et_password.getText().toString().trim();
    if (TextUtils.isEmpty(this.userName))
    {
      Toast.makeText(this, 2131296711, 0).show();
      return false;
    }
    if ((this.userName.length() < 2) || (this.userName.length() > 20))
    {
      Toast.makeText(this, 2131296714, 0).show();
      return false;
    }
    if (!Util.isEmail(this.userName))
    {
      Toast.makeText(this, 2131296725, 0).show();
      return false;
    }
    if (TextUtils.isEmpty(this.password))
    {
      Toast.makeText(this, 2131296712, 0).show();
      return false;
    }
    if ((this.password.length() < 6) || (this.password.length() > 20))
    {
      Toast.makeText(this, 2131296715, 0).show();
      return false;
    }
    return true;
  }
  
  private boolean checkRegisterInput()
  {
    this.regEmail = this.register_email.getText().toString().trim();
    this.regPass = this.register_password.getText().toString().trim();
    if (TextUtils.isEmpty(this.regEmail))
    {
      Toast.makeText(this, 2131296713, 0).show();
      return false;
    }
    if (!Util.isEmail(this.regEmail))
    {
      Toast.makeText(this, 2131296725, 0).show();
      return false;
    }
    if (TextUtils.isEmpty(this.regPass))
    {
      Toast.makeText(this, 2131296712, 0).show();
      return false;
    }
    if ((this.regPass.length() < 6) || (this.regPass.length() > 20))
    {
      Toast.makeText(this, 2131296715, 0).show();
      return false;
    }
    return true;
  }
  
  private void dismissProgress()
  {
    if ((this.progressDialog != null) && (this.progressDialog.isShowing()))
    {
      this.progressDialog.dismiss();
      this.progressDialog = null;
    }
  }
  
  private void doLogin()
  {
    if (!checkInput()) {}
    while (this.isLogining) {
      return;
    }
    this.imm.hideSoftInputFromWindow(this.btn_login.getWindowToken(), 0);
    this.isLogining = true;
    showProgress(this.res.getString(2131296716));
    User localUser = new User();
    localUser.setUserName(this.userName);
    localUser.setPassword(this.password);
    localUser.setLogintype(Integer.valueOf(1));
    this.request = VolleyUtil.getInstance().loadPostGson("http://192.168.2.29:8081/ido/user/login", "USER_LOGIN", ResponseEntity.class, GsonUtil.obj2JsonString(localUser), new AVolleyResponse(this)
    {
      public void onError(VolleyError paramAnonymousVolleyError, String paramAnonymousString)
      {
        LoginActivity.this.isLogining = false;
        LoginActivity.this.dismissProgress();
        paramAnonymousVolleyError = paramAnonymousString;
        if (paramAnonymousString == null) {
          paramAnonymousVolleyError = ErrorCodeMap.getErrorMsg(LoginActivity.this, LoginActivity.this.request.getErrorCode());
        }
        Toast.makeText(LoginActivity.this, paramAnonymousVolleyError, 0).show();
      }
      
      public void onSuccess(ResponseEntity paramAnonymousResponseEntity)
      {
        LoginActivity.this.isLogining = false;
        LoginActivity.this.dismissProgress();
        if (LoginActivity.this.request.getState() != 0)
        {
          LoginActivity.this.et_password.setText("");
          Toast.makeText(LoginActivity.this, ErrorCodeMap.getErrorMsg(LoginActivity.this, LoginActivity.this.request.getErrorCode()), 0).show();
          return;
        }
        LoginActivity.this.mAppSharedPreferences.setLoginName(LoginActivity.this.userName);
        if (LoginActivity.this.isSavePwd) {
          LoginActivity.this.mAppSharedPreferences.setUserPassword(LoginActivity.this.bf.encrypt(LoginActivity.this.password));
        }
        for (;;)
        {
          LoginActivity.this.mAppSharedPreferences.setUserLoginType(1);
          LoginActivity.this.mAppSharedPreferences.setLoginState(true);
          LoginActivity.this.startActivity(new Intent(LoginActivity.this, FirstStartActivity.class));
          LoginActivity.this.finish();
          return;
          LoginActivity.this.mAppSharedPreferences.setUserPassword("");
        }
      }
    });
  }
  
  private void doLogin(final int paramInt, final String paramString1, String paramString2, String paramString3)
  {
    DebugLog.e("--------userId:" + paramString1 + "  nickName:" + paramString2 + "  avatar:" + paramString3);
    if (this.isLogining) {
      return;
    }
    this.isLogining = true;
    showProgress(this.res.getString(2131296716));
    paramString2 = new User();
    paramString2.setUserName(paramString1);
    paramString2.setLogintype(Integer.valueOf(paramInt));
    paramString2.setImei(this.imei);
    paramString2.setImsi(this.imsi);
    paramString2.setChannelId(this.channelId);
    this.request = VolleyUtil.getInstance().loadPostGson("http://192.168.2.29:8081/ido/user/login", "USER_LOGIN", ResponseEntity.class, GsonUtil.obj2JsonString(paramString2), new AVolleyResponse(this)
    {
      public void onError(VolleyError paramAnonymousVolleyError, String paramAnonymousString)
      {
        LoginActivity.this.isLogining = false;
        LoginActivity.this.dismissProgress();
        paramAnonymousVolleyError = paramAnonymousString;
        if (paramAnonymousString == null) {
          paramAnonymousVolleyError = ErrorCodeMap.getErrorMsg(LoginActivity.this, LoginActivity.this.request.getErrorCode());
        }
        Toast.makeText(LoginActivity.this, paramAnonymousVolleyError, 0).show();
      }
      
      public void onSuccess(ResponseEntity paramAnonymousResponseEntity)
      {
        LoginActivity.this.isLogining = false;
        LoginActivity.this.dismissProgress();
        if (LoginActivity.this.request.getState() != 0)
        {
          Toast.makeText(LoginActivity.this, ErrorCodeMap.getErrorMsg(LoginActivity.this, LoginActivity.this.request.getErrorCode()), 0).show();
          return;
        }
        L.i("LoginActivity", new Object[] { "response.data = " + paramAnonymousResponseEntity.getData() });
        LoginActivity.this.mAppSharedPreferences.setLoginName(paramString1);
        LoginActivity.this.mAppSharedPreferences.setUserPassword("");
        LoginActivity.this.mAppSharedPreferences.setUserLoginType(paramInt);
        LoginActivity.this.mAppSharedPreferences.setLoginState(true);
        LoginActivity.this.startActivity(new Intent(LoginActivity.this, FirstStartActivity.class));
        LoginActivity.this.finish();
      }
    });
  }
  
  private void doRegister()
  {
    if (!checkRegisterInput()) {}
    while (this.isRegistering) {
      return;
    }
    this.imm.hideSoftInputFromWindow(this.et_password.getWindowToken(), 0);
    this.isRegistering = true;
    showProgress(this.res.getString(2131296717));
    User localUser = new User();
    localUser.setEmail(this.regEmail);
    localUser.setPassword(this.regPass);
    localUser.setLogintype(Integer.valueOf(1));
    localUser.setImei(this.imei);
    localUser.setImsi(this.imsi);
    localUser.setChannelId(this.channelId);
    this.regRequest = VolleyUtil.getInstance().loadPostGson("http://192.168.2.29:8081/ido/user/register", "URL_USER_REGISTER", ResponseEntity.class, GsonUtil.obj2JsonString(localUser), new AVolleyResponse(this)
    {
      public void onError(VolleyError paramAnonymousVolleyError, String paramAnonymousString)
      {
        LoginActivity.this.isRegistering = false;
        LoginActivity.this.dismissProgress();
        paramAnonymousVolleyError = paramAnonymousString;
        if (paramAnonymousString == null) {
          paramAnonymousVolleyError = ErrorCodeMap.getErrorMsg(LoginActivity.this, LoginActivity.this.regRequest.getErrorCode());
        }
        Toast.makeText(LoginActivity.this, paramAnonymousVolleyError, 0).show();
      }
      
      public void onSuccess(ResponseEntity paramAnonymousResponseEntity)
      {
        LoginActivity.this.isRegistering = false;
        LoginActivity.this.dismissProgress();
        if (LoginActivity.this.regRequest.getState() != 0)
        {
          Toast.makeText(LoginActivity.this, ErrorCodeMap.getErrorMsg(LoginActivity.this, LoginActivity.this.regRequest.getErrorCode()), 0).show();
          return;
        }
        Toast.makeText(LoginActivity.this, 2131296727, 0).show();
        LoginActivity.this.mAppSharedPreferences.setLoginName(LoginActivity.this.regEmail);
        if (LoginActivity.this.isSavePwd) {
          LoginActivity.this.mAppSharedPreferences.setUserPassword(LoginActivity.this.bf.encrypt(LoginActivity.this.regPass));
        }
        LoginActivity.this.mAppSharedPreferences.setUserName("");
        LoginActivity.this.mAppSharedPreferences.setUserLoginType(1);
        LoginActivity.this.mAppSharedPreferences.setLoginState(true);
        LoginActivity.this.startActivity(new Intent(LoginActivity.this, FirstStartActivity.class));
        LoginActivity.this.finish();
      }
    });
  }
  
  private String getApplicationMetaData(Context paramContext, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("key can't be null");
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getString(paramString);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private void loginByOAuth(String paramString, final int paramInt)
  {
    if (!NetUtils.isConnected(this))
    {
      Toast.makeText(this, 2131296632, 0).show();
      return;
    }
    showProgress(this.res.getString(2131296720));
    paramString = ShareSDK.getPlatform(this, paramString);
    paramString.setPlatformActionListener(new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        LoginActivity.this.mHandler.sendEmptyMessage(6);
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        LoginActivity.this.mPatform = paramAnonymousPlatform;
        LoginActivity.this.mData = paramAnonymousHashMap;
        LoginActivity.this.mHandler.sendEmptyMessage(paramInt);
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        LoginActivity.this.mHandler.sendEmptyMessage(7);
      }
    });
    paramString.SSOSetting(false);
    paramString.showUser(null);
  }
  
  private void showProgress(String paramString)
  {
    if (this.progressDialog == null)
    {
      this.progressDialog = new ProgressDialog(this);
      this.progressDialog.setProgressStyle(0);
      this.progressDialog.setIndeterminate(true);
      this.progressDialog.setCancelable(false);
    }
    this.progressDialog.setMessage(paramString);
    this.progressDialog.show();
  }
  
  protected void initData()
  {
    super.initData();
    TelephonyManager localTelephonyManager = (TelephonyManager)getSystemService("phone");
    this.imsi = localTelephonyManager.getSubscriberId();
    this.imei = localTelephonyManager.getDeviceId();
    this.channelId = getApplicationMetaData(this, "UMENG_CHANNEL");
    DebugLog.e("imei = " + this.imei + " ,imsi = " + this.imsi + " ,channelId = " + this.channelId);
    this.isSavePwd = this.mAppSharedPreferences.isRememberPwd();
    this.btn_remeber_pwd.setSelected(this.isSavePwd);
    if (this.mAppSharedPreferences.getUserLoginType() == 1)
    {
      this.et_username.setText(this.mAppSharedPreferences.getLoginName());
      if (this.isSavePwd) {
        this.et_password.setText(this.bf.decrypt(this.mAppSharedPreferences.getUserPassword()));
      }
    }
  }
  
  protected void initEvent()
  {
    super.initEvent();
    this.btn_back.setOnClickListener(this);
    this.btn_login.setOnClickListener(this);
    this.btn_register.setOnClickListener(this);
    this.btn_remeber_pwd.setOnClickListener(this);
    this.btn_forget_pwd.setOnClickListener(this);
    this.btn_weibo_login.setOnClickListener(this);
    this.btn_wechat_login.setOnClickListener(this);
    this.btn_qq_login.setOnClickListener(this);
    this.rg_tab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 2131230810: 
          LoginActivity.this.ll_login_content.setVisibility(0);
          LoginActivity.this.register_email.setText("");
          LoginActivity.this.register_password.setText("");
          LoginActivity.this.ll_register_content.setVisibility(8);
          LoginActivity.this.btn_register.setVisibility(8);
          return;
        }
        LoginActivity.this.ll_register_content.setVisibility(0);
        LoginActivity.this.btn_register.setVisibility(0);
        LoginActivity.this.ll_login_content.setVisibility(8);
      }
    });
  }
  
  protected void initView()
  {
    super.initView();
    this.res = getResources();
    this.btn_back = ((Button)findViewById(2131230763));
    this.rg_tab = ((RadioGroup)findViewById(2131230809));
    this.ll_login_content = ((LinearLayout)findViewById(2131230812));
    this.et_username = ((EditText)findViewById(2131230813));
    this.et_password = ((EditText)findViewById(2131230814));
    this.btn_remeber_pwd = ((Button)findViewById(2131230815));
    this.btn_forget_pwd = ((Button)findViewById(2131230816));
    this.btn_login = ((Button)findViewById(2131230818));
    this.btn_weibo_login = ((ImageButton)findViewById(2131230823));
    this.btn_wechat_login = ((ImageButton)findViewById(2131230821));
    this.btn_qq_login = ((ImageButton)findViewById(2131230822));
    this.ll_register_content = ((LinearLayout)findViewById(2131230824));
    this.register_email = ((EditText)findViewById(2131230825));
    this.register_password = ((EditText)findViewById(2131230826));
    this.btn_register = ((Button)findViewById(2131230827));
    this.imm = ((InputMethodManager)getSystemService("input_method"));
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131230821: 
    default: 
      return;
    case 2131230763: 
      finish();
      return;
    case 2131230818: 
      doLogin();
      return;
    case 2131230822: 
      loginByOAuth(QQ.NAME, 2);
      return;
    case 2131230823: 
      loginByOAuth(Facebook.NAME, 5);
      return;
    case 2131230815: 
      if (this.isSavePwd) {}
      for (boolean bool = false;; bool = true)
      {
        this.isSavePwd = bool;
        this.btn_remeber_pwd.setSelected(this.isSavePwd);
        this.mAppSharedPreferences.setRememberPwd(this.isSavePwd);
        return;
      }
    case 2131230816: 
      this.et_password.setText("");
      startActivity(new Intent(this, FindPasswordActivity.class));
      return;
    }
    doRegister();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903057);
    super.onCreate(paramBundle);
    ActivityCollector.addActivity(this);
  }
  
  protected void onDestroy()
  {
    ActivityCollector.removeActivity(this);
    super.onDestroy();
  }
  
  protected void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */