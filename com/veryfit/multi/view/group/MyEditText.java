package com.veryfit.multi.view.group;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.veryfit.multi.R.styleable;

public class MyEditText
  extends LinearLayout
{
  private static final int GONE = 1;
  private static final int NUMBER = 2;
  private static final int PASSWORD = 1;
  private static final int TEXT = 0;
  private static final int VISIABLE = 0;
  private Bitmap bitmap;
  private int btnVisiblity = 0;
  private EditText editText;
  private String hint_et;
  private int inputType = 0;
  private ImageView leftImag;
  private OnRightBtnClickListener mListener;
  private Button rightBtn;
  private String text_btn;
  
  public MyEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    LayoutInflater.from(paramContext).inflate(2130903113, this, true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.MyEditText, paramInt, 0);
    this.bitmap = BitmapFactory.decodeResource(getResources(), paramContext.getResourceId(0, 0));
    this.hint_et = paramContext.getString(1);
    this.text_btn = paramContext.getString(2);
    this.btnVisiblity = paramContext.getInt(3, 1);
    this.inputType = paramContext.getInt(4, 0);
    paramContext.recycle();
  }
  
  public String getEditText()
  {
    String str = "";
    if (this.editText != null) {
      str = this.editText.getText().toString().trim();
    }
    return str;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.rightBtn = ((Button)findViewById(2131231078));
    this.leftImag = ((ImageView)findViewById(2131231076));
    this.editText = ((EditText)findViewById(2131231077));
    if ((this.leftImag != null) && (this.bitmap != null)) {
      this.leftImag.setImageBitmap(this.bitmap);
    }
    if (this.editText != null)
    {
      if (!TextUtils.isEmpty(this.hint_et)) {
        this.editText.setHint(this.hint_et);
      }
      switch (this.inputType)
      {
      }
    }
    while ((this.btnVisiblity == 0) && (this.rightBtn != null))
    {
      this.rightBtn.setVisibility(0);
      if ((this.text_btn != null) && (!this.text_btn.equals("")))
      {
        this.rightBtn.setText(this.text_btn);
        this.rightBtn.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (MyEditText.this.mListener != null) {
              MyEditText.this.mListener.onClick();
            }
          }
        });
      }
      return;
      this.editText.setInputType(1);
      continue;
      this.editText.setInputType(129);
      continue;
      this.editText.setInputType(2);
    }
    this.rightBtn.setVisibility(8);
  }
  
  public void setListener(OnRightBtnClickListener paramOnRightBtnClickListener)
  {
    this.mListener = paramOnRightBtnClickListener;
  }
  
  public void setText(String paramString)
  {
    if (this.editText != null) {
      this.editText.setText(paramString);
    }
  }
  
  public static abstract interface OnRightBtnClickListener
  {
    public abstract void onClick();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\MyEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */