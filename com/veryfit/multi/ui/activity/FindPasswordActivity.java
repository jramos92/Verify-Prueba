package com.veryfit.multi.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.camera.GsonUtil;
import com.veryfit.multi.model.User;
import com.veryfit.multi.net.AVolleyResponse;
import com.veryfit.multi.net.ErrorCodeMap;
import com.veryfit.multi.net.GsonRequest;
import com.veryfit.multi.net.ResponseEntity;
import com.veryfit.multi.net.VolleyUtil;
import com.veryfit.multi.util.ActivityCollector;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.util.ValidateCode;

public class FindPasswordActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Button btn_back;
  private Button btn_comfirm;
  private String emailStr;
  private EditText et_code;
  private EditText et_email;
  private boolean isSending = false;
  private ImageView iv_code;
  private ValidateCode mCode = ValidateCode.getInstance();
  private ProgressDialog progressDialog;
  private GsonRequest<ResponseEntity> request;
  private Resources res;
  
  private boolean checkInput()
  {
    this.emailStr = this.et_email.getText().toString().trim();
    if (TextUtils.isEmpty(this.emailStr))
    {
      Toast.makeText(this, 2131296713, 0).show();
      return false;
    }
    if (!Util.isEmail(this.emailStr))
    {
      Toast.makeText(this, 2131296725, 0).show();
      return false;
    }
    String str = this.et_code.getText().toString().trim();
    if (TextUtils.isEmpty(str))
    {
      Toast.makeText(this, 2131296730, 0).show();
      return false;
    }
    if (!str.equalsIgnoreCase(this.mCode.getCode()))
    {
      Toast.makeText(this, 2131296731, 0).show();
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
  
  private void doEmialRequest()
  {
    if (!checkInput()) {}
    while (this.isSending) {
      return;
    }
    this.isSending = true;
    showProgress(this.res.getString(2131296724));
    User localUser = new User();
    localUser.setEmail(this.emailStr);
    this.request = VolleyUtil.getInstance().loadPostGson("http://192.168.2.29:8081/ido/user/forgetPassword", "URL_USER_FORGETPASSWORD", ResponseEntity.class, GsonUtil.obj2JsonString(localUser), new AVolleyResponse(this)
    {
      public void onError(VolleyError paramAnonymousVolleyError, String paramAnonymousString)
      {
        FindPasswordActivity.this.isSending = false;
        FindPasswordActivity.this.dismissProgress();
        FindPasswordActivity.this.setValidateCode();
        paramAnonymousVolleyError = paramAnonymousString;
        if (paramAnonymousString == null) {
          paramAnonymousVolleyError = ErrorCodeMap.getErrorMsg(FindPasswordActivity.this, FindPasswordActivity.this.request.getErrorCode());
        }
        Toast.makeText(FindPasswordActivity.this, paramAnonymousVolleyError, 0).show();
      }
      
      public void onSuccess(ResponseEntity paramAnonymousResponseEntity)
      {
        FindPasswordActivity.this.isSending = false;
        FindPasswordActivity.this.dismissProgress();
        if (FindPasswordActivity.this.request.getState() != 0)
        {
          FindPasswordActivity.this.setValidateCode();
          Toast.makeText(FindPasswordActivity.this, ErrorCodeMap.getErrorMsg(FindPasswordActivity.this, FindPasswordActivity.this.request.getErrorCode()), 0).show();
          return;
        }
        Toast.makeText(FindPasswordActivity.this, FindPasswordActivity.this.res.getString(2131296698, new Object[] { FindPasswordActivity.this.emailStr }), 0).show();
        FindPasswordActivity.this.finish();
      }
    });
  }
  
  private void setValidateCode()
  {
    this.iv_code.setImageBitmap(this.mCode.getRoundedCornerBitmap(this.mCode.createBitmap(), 5.0F));
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
  
  protected void initEvent()
  {
    super.initEvent();
    this.btn_back.setOnClickListener(this);
    this.iv_code.setOnClickListener(this);
    this.btn_comfirm.setOnClickListener(this);
  }
  
  protected void initView()
  {
    super.initView();
    this.res = getResources();
    this.btn_back = ((Button)findViewById(2131230763));
    this.et_email = ((EditText)findViewById(2131230766));
    this.et_code = ((EditText)findViewById(2131230767));
    this.iv_code = ((ImageView)findViewById(2131230768));
    this.btn_comfirm = ((Button)findViewById(2131230769));
    setValidateCode();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230763: 
      finish();
      return;
    case 2131230768: 
      setValidateCode();
      return;
    }
    doEmialRequest();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903050);
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\FindPasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */