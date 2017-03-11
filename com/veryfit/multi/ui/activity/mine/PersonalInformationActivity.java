package com.veryfit.multi.ui.activity.mine;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.device.cmd.settings.Units;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.BaseNotifyBleActivity;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.UnitFormat;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.view.CircleImageView;
import com.veryfit.multi.view.DialogUtil;
import com.veryfit.multi.view.DialogUtil.OnBirthdaySelectListener;
import com.veryfit.multi.view.DialogUtil.OnRemoveImgListener;
import com.veryfit.multi.view.DialogUtil.OnWheelSelectorListener;
import com.veryfit.multi.vo.UserInfo;
import java.io.File;
import java.io.PrintStream;

public class PersonalInformationActivity
  extends BaseNotifyBleActivity
  implements View.OnClickListener
{
  private EditText ed_username;
  private UserInfo info = new UserInfo();
  private RelativeLayout iv_birthday;
  private CircleImageView iv_header;
  private RelativeLayout iv_height;
  private RelativeLayout iv_sex;
  private RelativeLayout iv_weight;
  protected APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousByte == 17) {
        if (paramAnonymousBoolean)
        {
          DebugLog.i(">>设置单位成功");
          PersonalInformationActivity.this.showSureBtn();
          PersonalInformationActivity.this.finish();
        }
      }
      while (paramAnonymousByte != 16) {
        return;
      }
      if (paramAnonymousBoolean)
      {
        DebugLog.i("个人信息设置成功。");
        PersonalInformationActivity.this.sendUnitSet();
        return;
      }
      PersonalInformationActivity.this.onDataSendFailed();
    }
  };
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  private String photoFile;
  private String[] sex;
  private TextView tv_birthday;
  private TextView tv_cancel;
  private TextView tv_height;
  private TextView tv_sex;
  private TextView tv_sure;
  private TextView tv_username;
  private TextView tv_weight;
  
  private void sendUnitSet()
  {
    DebugLog.i(">>设置单位");
    Units localUnits = new Units();
    if (this.mAppSharedPreferences.getUserSex()) {}
    for (localUnits.stride = ((int)(this.mAppSharedPreferences.getUserHeight() * 0.415D));; localUnits.stride = ((int)(this.mAppSharedPreferences.getUserHeight() * 0.413D)))
    {
      this.mCore.write(SettingsCmd.getInstance().getUnitSettingsCmd(localUnits));
      return;
    }
  }
  
  protected void initData()
  {
    super.initData();
    this.info.init();
    this.ed_username.setText(this.info.name);
    this.tv_birthday.setText(getString(2131296469, new Object[] { Integer.valueOf(this.info.year), Integer.valueOf(this.info.month), Integer.valueOf(this.info.day) }));
    this.tv_sex.setText(this.sex[this.info.gender]);
    if (AppSharedPreferences.getInstance().getUnitType() == 1)
    {
      if (this.info.height > 250) {
        this.info.height = 250;
      }
      if (this.info.height < 30) {
        this.info.height = 30;
      }
      if (this.info.weight > 205) {
        this.info.weight = 205;
      }
      if (this.info.weight < 25) {
        this.info.weight = 25;
      }
      this.tv_height.setText(this.info.height + getString(2131296424));
      this.tv_weight.setText(this.info.weight + getString(2131296422));
      return;
    }
    int j = UnitFormat.cm2inchs(this.info.height);
    int k = UnitFormat.kg2lb(this.info.weight);
    int i = j;
    if (j > 98) {
      i = 98;
    }
    j = i;
    if (i < 12) {
      j = 12;
    }
    i = k;
    if (k > 451) {
      i = 451;
    }
    k = i;
    if (i < 55) {
      k = 55;
    }
    DebugLog.d("............height:" + j);
    this.tv_height.setText(j / 12 + "'" + j % 12 + "\"");
    this.tv_weight.setText(k + getString(2131296423));
  }
  
  protected void initEvent()
  {
    this.iv_sex.setOnClickListener(this);
    this.iv_height.setOnClickListener(this);
    this.iv_weight.setOnClickListener(this);
    this.iv_birthday.setOnClickListener(this);
    this.tv_cancel.setOnClickListener(this);
    this.iv_header.setOnClickListener(this);
    this.ed_username.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        PersonalInformationActivity.this.tv_username.setText(PersonalInformationActivity.this.ed_username.getText().toString());
      }
    });
  }
  
  protected void initFirst()
  {
    super.initFirst();
  }
  
  protected void initView()
  {
    super.initView();
    this.iv_header = ((CircleImageView)findViewById(2131230731));
    this.iv_sex = ((RelativeLayout)findViewById(2131230842));
    this.iv_height = ((RelativeLayout)findViewById(2131230845));
    this.iv_weight = ((RelativeLayout)findViewById(2131230848));
    this.iv_birthday = ((RelativeLayout)findViewById(2131230839));
    this.tv_cancel = ((TextView)findViewById(2131230729));
    this.tv_username = ((TextView)findViewById(2131230836));
    this.tv_sex = ((TextView)findViewById(2131230844));
    this.tv_height = ((TextView)findViewById(2131230847));
    this.tv_weight = ((TextView)findViewById(2131230850));
    this.tv_birthday = ((TextView)findViewById(2131230841));
    this.ed_username = ((EditText)findViewById(2131230838));
    this.ed_username.setSelection(this.ed_username.getText().toString().length());
    if (!new File(Constant.PIC_PATH + DialogUtil.photoPath).exists()) {
      this.iv_header.setImageBitmap(BitmapFactory.decodeResource(getResources(), 2130837537));
    }
    for (;;)
    {
      this.sex = getResources().getStringArray(2131361792);
      return;
      Bitmap localBitmap = BitmapFactory.decodeFile(Constant.PIC_PATH + DialogUtil.photoPath);
      if (localBitmap != null) {
        this.iv_header.setImageBitmap(localBitmap);
      } else {
        this.iv_header.setImageBitmap(BitmapFactory.decodeResource(getResources(), 2130837537));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 123) {
        System.out.println("1111111111111");
      }
      paramIntent = DialogUtil.chooseFace(paramInt1, paramInt2, paramIntent, this, null);
      if (paramIntent != null)
      {
        this.photoFile = (Constant.PIC_PATH + DialogUtil.photoPath);
        this.iv_header.setImageBitmap(paramIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i;
    int j;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230842: 
      DialogUtil.showWheelSexDialog(this, this.info.gender, new DialogUtil.OnWheelSelectorListener()
      {
        public void onWheelSelect(Object paramAnonymousObject)
        {
          PersonalInformationActivity.this.info.gender = ((Integer)paramAnonymousObject).intValue();
          PersonalInformationActivity.this.tv_sex.setText(PersonalInformationActivity.this.sex[PersonalInformationActivity.this.info.gender]);
        }
      });
      return;
    case 2131230845: 
      i = this.info.height;
      if (AppSharedPreferences.getInstance().getUnitType() == 2)
      {
        j = UnitFormat.cm2inchs(i);
        DebugLog.d("height:" + j + ",height:" + i);
        DialogUtil.showWheelHeightDialog2(this, j, new DialogUtil.OnWheelSelectorListener()
        {
          public void onWheelSelect(Object paramAnonymousObject)
          {
            paramAnonymousObject = ((String)paramAnonymousObject).split(",");
            int i = Integer.parseInt(paramAnonymousObject[0].substring(0, 1)) * 12 + Integer.parseInt(paramAnonymousObject[1].substring(0, 1));
            PersonalInformationActivity.this.info.height = UnitFormat.inchs2cm(i);
            DebugLog.d("h3:" + i + ",height:" + PersonalInformationActivity.this.info.height);
            PersonalInformationActivity.this.tv_height.setText(paramAnonymousObject[0] + paramAnonymousObject[1]);
          }
        });
        return;
      }
      DialogUtil.showWheelHeightDialog(this, i, new DialogUtil.OnWheelSelectorListener()
      {
        public void onWheelSelect(Object paramAnonymousObject)
        {
          PersonalInformationActivity.this.info.height = (((Integer)paramAnonymousObject).intValue() + 30);
          PersonalInformationActivity.this.tv_height.setText(PersonalInformationActivity.this.info.height + PersonalInformationActivity.this.getString(2131296424));
        }
      });
      return;
    case 2131230848: 
      j = this.info.weight;
      i = j;
      if (AppSharedPreferences.getInstance().getUnitType() == 2) {
        i = UnitFormat.kg2lb(j);
      }
      DialogUtil.showWheelWeightDialog(this, i, new DialogUtil.OnWheelSelectorListener()
      {
        public void onWheelSelect(Object paramAnonymousObject)
        {
          PersonalInformationActivity.this.info.weight = ((Integer)paramAnonymousObject).intValue();
          if (AppSharedPreferences.getInstance().getUnitType() == 2)
          {
            PersonalInformationActivity.this.info.weight = UnitFormat.lb2kg(((Integer)paramAnonymousObject).intValue());
            PersonalInformationActivity.this.tv_weight.setText((Integer)paramAnonymousObject + PersonalInformationActivity.this.getString(2131296423));
            return;
          }
          PersonalInformationActivity.this.tv_weight.setText(PersonalInformationActivity.this.info.weight + PersonalInformationActivity.this.getString(2131296422));
        }
      });
      return;
    case 2131230839: 
      i = this.info.year;
      j = this.info.month;
      int k = this.info.day;
      paramView = new DialogUtil.OnBirthdaySelectListener()
      {
        public void onBirthdaySelect(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          PersonalInformationActivity.this.info.day = paramAnonymousInt3;
          PersonalInformationActivity.this.info.year = paramAnonymousInt1;
          PersonalInformationActivity.this.info.month = paramAnonymousInt2;
          PersonalInformationActivity.this.tv_birthday.setText(PersonalInformationActivity.this.getString(2131296469, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) }));
        }
      };
      DialogUtil.showWheelBirthDayDialog(this, new int[] { i, j, k }, paramView);
      return;
    }
    DialogUtil.showPhotosDaiglog(this, null, new DialogUtil.OnRemoveImgListener()
    {
      public void onRemoveImg()
      {
        File localFile = new File(Constant.PIC_PATH + DialogUtil.photoPath);
        if (localFile.exists()) {
          localFile.delete();
        }
        PersonalInformationActivity.this.iv_header.setImageBitmap(BitmapFactory.decodeResource(PersonalInformationActivity.this.getResources(), 2130837537));
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903061);
    super.onCreate(paramBundle);
  }
  
  protected void onDataSendFailed()
  {
    Util.showToast(this, 2131296398, 0);
    showSureBtn();
  }
  
  protected void onSettingsSuccess() {}
  
  protected void onThemeChanged() {}
  
  protected void saveDate()
  {
    this.info.name = this.ed_username.getText().toString();
    this.info.save();
    this.mCore.addListener(this.mAppListener);
    if (writeData(SettingsCmd.getInstance().getUserinfosSettingsCmd(this.info)))
    {
      showProgress();
      return;
    }
    onDataSendFailed();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\PersonalInformationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */