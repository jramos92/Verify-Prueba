package com.veryfit.multi.view;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.fragment.main.DeviceFragment;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.wheel.ArrayWheelAdapter;
import com.veryfit.multi.view.wheel.NumericWheelAdapter;
import com.veryfit.multi.view.wheel.OnWheelChangedListener;
import com.veryfit.multi.view.wheel.WheelView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class DialogUtil
{
  public static final int CAMERA = 1;
  private static int END_HEIGHT = 0;
  private static int END_WEIGHT = 0;
  private static int END_YEAR = 0;
  private static final int NONE = 0;
  public static final int PHOTORESOULT = 3;
  public static final int PHOTOZOOM = 2;
  private static int START_HEIGHT;
  private static int START_WEIGHT;
  private static int START_YEAR = 1920;
  public static String photoPath = "/avatar.jpg";
  public static String photoTemp;
  
  static
  {
    END_YEAR = 2090;
    START_HEIGHT = 30;
    END_HEIGHT = 250;
    START_WEIGHT = 25;
    END_WEIGHT = 205;
    photoTemp = "/temp.png";
  }
  
  public static Bitmap chooseFace(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity, Fragment paramFragment)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramInt2 == 0) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (Bitmap)localObject1;
      if (paramInt1 == 1) {
        startPhotoZoom(Uri.fromFile(new File(Constant.PIC_PATH + photoTemp)), paramActivity, paramFragment);
      }
      localObject1 = localObject2;
      if (paramIntent == null) {
        continue;
      }
      if (paramInt1 == 2)
      {
        photoTemp = paramIntent.getData().toString().substring(paramIntent.getData().toString().lastIndexOf("/") + 1);
        startPhotoZoom(paramIntent.getData(), paramActivity, paramFragment);
      }
      localObject1 = localObject2;
      if (paramInt1 != 3) {
        continue;
      }
      paramIntent = paramIntent.getExtras();
      localObject1 = localObject2;
      if (paramIntent == null) {
        continue;
      }
      paramIntent = (Bitmap)paramIntent.getParcelable("data");
      paramActivity = new File(Constant.PIC_PATH + photoPath);
      try
      {
        paramActivity.createNewFile();
        paramFragment = new FileOutputStream(paramActivity);
        if (paramIntent.compress(Bitmap.CompressFormat.JPEG, 100, paramFragment))
        {
          paramFragment.flush();
          paramFragment.close();
        }
        localObject1 = paramIntent;
        if (!paramActivity.exists()) {
          continue;
        }
        paramActivity = new File(Constant.PIC_PATH + photoTemp);
        localObject1 = paramIntent;
        if (!paramActivity.exists()) {
          continue;
        }
        paramActivity.delete();
        return paramIntent;
      }
      catch (FileNotFoundException paramFragment)
      {
        for (;;)
        {
          paramFragment.printStackTrace();
        }
      }
      catch (IOException paramFragment)
      {
        for (;;)
        {
          paramFragment.printStackTrace();
        }
      }
      catch (Exception paramFragment)
      {
        for (;;)
        {
          paramFragment.printStackTrace();
        }
      }
    }
  }
  
  private static void initTimePicker(Context paramContext, int[] paramArrayOfInt, final WheelView paramWheelView1, final WheelView paramWheelView2, final WheelView paramWheelView3)
  {
    paramContext = Calendar.getInstance();
    int i = paramContext.get(1);
    int j = paramContext.get(2);
    paramContext.get(5);
    paramContext = Arrays.asList(new String[] { "1", "3", "5", "7", "8", "10", "12" });
    final List localList = Arrays.asList(new String[] { "4", "6", "9", "11" });
    paramWheelView1.setAdapter(new NumericWheelAdapter(START_YEAR, END_YEAR));
    paramWheelView1.setCyclic(true);
    paramWheelView1.setCurrentItem(paramArrayOfInt[0] - START_YEAR);
    paramWheelView1.setVisibleItems(3);
    paramWheelView2.setAdapter(new NumericWheelAdapter(1, 12));
    paramWheelView2.setCyclic(true);
    paramWheelView2.setCurrentItem(paramArrayOfInt[1] - 1);
    paramWheelView2.setVisibleItems(3);
    paramWheelView3.setCyclic(true);
    paramWheelView3.setVisibleItems(3);
    if (paramContext.contains(String.valueOf(j + 1))) {
      paramWheelView3.setAdapter(new NumericWheelAdapter(1, 31));
    }
    for (;;)
    {
      paramWheelView3.setCurrentItem(paramArrayOfInt[2] - 1);
      paramArrayOfInt = new OnWheelChangedListener()
      {
        public void onChanged(WheelView paramAnonymousWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAnonymousInt1 = paramAnonymousInt2 + DialogUtil.START_YEAR;
          if (DialogUtil.this.contains(String.valueOf(paramWheelView2.getCurrentItem() + 1)))
          {
            paramWheelView3.setAdapter(new NumericWheelAdapter(1, 31));
            return;
          }
          if (localList.contains(String.valueOf(paramWheelView2.getCurrentItem() + 1)))
          {
            paramWheelView3.setAdapter(new NumericWheelAdapter(1, 30));
            return;
          }
          if (((paramAnonymousInt1 % 4 == 0) && (paramAnonymousInt1 % 100 != 0)) || (paramAnonymousInt1 % 400 == 0))
          {
            paramWheelView3.setAdapter(new NumericWheelAdapter(1, 29));
            return;
          }
          paramWheelView3.setAdapter(new NumericWheelAdapter(1, 28));
        }
      };
      paramContext = new OnWheelChangedListener()
      {
        public void onChanged(WheelView paramAnonymousWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAnonymousInt1 = paramAnonymousInt2 + 1;
          if (DialogUtil.this.contains(String.valueOf(paramAnonymousInt1)))
          {
            paramWheelView3.setAdapter(new NumericWheelAdapter(1, 31));
            return;
          }
          if (localList.contains(String.valueOf(paramAnonymousInt1)))
          {
            paramWheelView3.setAdapter(new NumericWheelAdapter(1, 30));
            return;
          }
          if ((((paramWheelView1.getCurrentItem() + DialogUtil.START_YEAR) % 4 == 0) && ((paramWheelView1.getCurrentItem() + DialogUtil.START_YEAR) % 100 != 0)) || ((paramWheelView1.getCurrentItem() + DialogUtil.START_YEAR) % 400 == 0))
          {
            paramWheelView3.setAdapter(new NumericWheelAdapter(1, 29));
            return;
          }
          paramWheelView3.setAdapter(new NumericWheelAdapter(1, 28));
        }
      };
      paramWheelView1.addChangingListener(paramArrayOfInt);
      paramWheelView2.addChangingListener(paramContext);
      return;
      if (localList.contains(String.valueOf(j + 1))) {
        paramWheelView3.setAdapter(new NumericWheelAdapter(1, 30));
      } else if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
        paramWheelView3.setAdapter(new NumericWheelAdapter(1, 29));
      } else {
        paramWheelView3.setAdapter(new NumericWheelAdapter(1, 28));
      }
    }
  }
  
  public static Dialog showBleEnableDialog(final Context paramContext)
  {
    Dialog localDialog = new Dialog(paramContext, 2131427337);
    localDialog.setContentView(2130903079);
    localDialog.getWindow().setGravity(17);
    localDialog.setCancelable(false);
    Button localButton1 = (Button)localDialog.findViewById(2131230927);
    Button localButton2 = (Button)localDialog.findViewById(2131230928);
    final BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
        if (localBluetoothAdapter == null) {
          Toast.makeText(paramContext, 2131296523, 1).show();
        }
        while (localBluetoothAdapter.isEnabled()) {
          return;
        }
        localBluetoothAdapter.enable();
      }
    });
    localDialog.show();
    return localDialog;
  }
  
  public static Dialog showCircleProgressDialog(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    Dialog localDialog = new Dialog(paramActivity, 2131427337);
    localDialog.setContentView(2130903081);
    localDialog.getWindow().setGravity(17);
    localDialog.setCancelable(false);
    localDialog.getWindow().getAttributes().width = ((int)(paramActivity.getWindowManager().getDefaultDisplay().getWidth() * 0.9F));
    TextView localTextView = (TextView)localDialog.findViewById(2131230932);
    if (paramInt <= 0) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      paramActivity = (ProgressBar)localDialog.findViewById(2131230931);
      if (paramBoolean) {
        paramActivity.setVisibility(0);
      }
      localDialog.show();
      return localDialog;
      localTextView.setText(paramActivity.getResources().getString(paramInt));
    }
  }
  
  public static void showForceUnbindDialog(final Activity paramActivity, DeviceFragment paramDeviceFragment)
  {
    paramActivity = new Dialog(paramActivity, 2131427337);
    paramActivity.setContentView(2130903082);
    paramActivity.getWindow().setGravity(17);
    paramActivity.setCancelable(true);
    paramActivity.findViewById(2131230934).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppSharedPreferences.getInstance().setBindDeviceAddr("");
        DialogUtil.this.updateBindTextInfo();
        TempUtil.clearDataAfterUnbind();
        paramActivity.dismiss();
      }
    });
    paramActivity.findViewById(2131230935).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    paramActivity.show();
  }
  
  public static void showHeightFormatDialog(final Context paramContext, OnHeightFormatSelectListener paramOnHeightFormatSelectListener)
  {
    paramContext = new Dialog(paramContext, 2131427337);
    paramContext.setContentView(2130903084);
    paramContext.getWindow().setGravity(17);
    paramContext.setCancelable(false);
    final RadioGroup localRadioGroup = (RadioGroup)paramContext.findViewById(2131230940);
    TextView localTextView = (TextView)paramContext.findViewById(2131230943);
    localRadioGroup.check(2131230941);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (DialogUtil.this == null) {
          return;
        }
        if (localRadioGroup.getCheckedRadioButtonId() == 2131230941) {
          DialogUtil.this.onHeightFormat(1);
        }
        if (localRadioGroup.getCheckedRadioButtonId() == 2131230942) {
          DialogUtil.this.onHeightFormat(2);
        }
        paramContext.dismiss();
      }
    });
    paramContext.show();
  }
  
  public static Dialog showMsgDialog(final Context paramContext, int paramInt, OnDialogClickListener paramOnDialogClickListener)
  {
    paramContext = new Dialog(paramContext, 2131427337);
    paramContext.setContentView(2130903085);
    paramContext.getWindow().setGravity(17);
    paramContext.setCancelable(false);
    ((TextView)paramContext.findViewById(2131230944)).setText(paramInt);
    Button localButton1 = (Button)paramContext.findViewById(2131230945);
    Button localButton2 = (Button)paramContext.findViewById(2131230946);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.onDialogCancel();
        paramContext.dismiss();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.onDialogShare();
        paramContext.dismiss();
      }
    });
    paramContext.show();
    return paramContext;
  }
  
  public static void showNoPowerDialog(Activity paramActivity)
  {
    paramActivity = new Dialog(paramActivity, 2131427337);
    paramActivity.setContentView(2130903086);
    paramActivity.getWindow().setGravity(17);
    paramActivity.setCancelable(true);
    paramActivity.findViewById(2131230934).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    paramActivity.show();
  }
  
  public static void showPhotosDaiglog(final Activity paramActivity, Fragment paramFragment, OnRemoveImgListener paramOnRemoveImgListener)
  {
    final Dialog localDialog = new Dialog(paramActivity, 2131427345);
    localDialog.setContentView(2130903088);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((int)(paramActivity.getWindowManager().getDefaultDisplay().getWidth() * 0.95F));
    File localFile = new File(Constant.PIC_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localDialog.findViewById(2131230959).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (DialogUtil.this != null) {
          DialogUtil.this.onRemoveImg();
        }
      }
    });
    localDialog.findViewById(2131230960).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent("android.intent.action.PICK", null);
        paramAnonymousView.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        if (DialogUtil.this != null) {
          DialogUtil.this.startActivityForResult(paramAnonymousView, 2);
        }
        for (;;)
        {
          localDialog.dismiss();
          return;
          paramActivity.startActivityForResult(paramAnonymousView, 2);
        }
      }
    });
    localDialog.findViewById(2131230961).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent("android.media.action.IMAGE_CAPTURE");
        paramAnonymousView.putExtra("output", Uri.fromFile(new File(Constant.PIC_PATH + DialogUtil.photoTemp)));
        Log.v("showPhotosDaiglog", "filePath = " + Constant.PIC_PATH + DialogUtil.photoTemp);
        if (DialogUtil.this != null) {
          DialogUtil.this.startActivityForResult(paramAnonymousView, 1);
        }
        for (;;)
        {
          localDialog.dismiss();
          return;
          paramActivity.startActivityForResult(paramAnonymousView, 1);
        }
      }
    });
    localDialog.findViewById(2131230962).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    localDialog.show();
  }
  
  public static void showShareDialog(Activity paramActivity, final OnShareSelectListener paramOnShareSelectListener)
  {
    final Dialog localDialog = new Dialog(paramActivity, 2131427346);
    localDialog.setContentView(2130903087);
    localDialog.setCancelable(false);
    localDialog.getWindow().setGravity(80);
    RadioGroup localRadioGroup1 = (RadioGroup)localDialog.findViewById(2131230947);
    RadioGroup localRadioGroup2 = (RadioGroup)localDialog.findViewById(2131230953);
    localDialog.getWindow().getAttributes().width = paramActivity.getWindowManager().getDefaultDisplay().getWidth();
    localRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        if (DialogUtil.this == null) {
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          localDialog.dismiss();
          return;
          DialogUtil.this.onShareSelect(3);
          continue;
          DialogUtil.this.onShareSelect(2);
          continue;
          DialogUtil.this.onShareSelect(5);
          continue;
          DialogUtil.this.onShareSelect(1);
          continue;
          DialogUtil.this.onShareSelect(6);
        }
      }
    });
    localRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        if (DialogUtil.this == null) {
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          localDialog.dismiss();
          return;
          DialogUtil.this.onShareSelect(7);
          continue;
          DialogUtil.this.onShareSelect(9);
          continue;
          DialogUtil.this.onShareSelect(8);
          continue;
          DialogUtil.this.onShareSelect(10);
          continue;
          DialogUtil.this.onShareSelect(11);
        }
      }
    });
    localDialog.findViewById(2131230935).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
        if (paramOnShareSelectListener == null) {
          return;
        }
        paramOnShareSelectListener.onCancel();
      }
    });
    localDialog.show();
  }
  
  public static Dialog showSugestDialog(final Context paramContext, SpannableString paramSpannableString, OnDialogClickListener paramOnDialogClickListener)
  {
    paramContext = new Dialog(paramContext, 2131427337);
    paramContext.setContentView(2130903085);
    paramContext.getWindow().setGravity(17);
    paramContext.setCancelable(false);
    ((TextView)paramContext.findViewById(2131230944)).setText(paramSpannableString);
    paramSpannableString = (Button)paramContext.findViewById(2131230945);
    Button localButton = (Button)paramContext.findViewById(2131230946);
    paramSpannableString.setText(2131296686);
    localButton.setText(2131296687);
    paramSpannableString.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.onDialogShare();
        paramContext.dismiss();
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.onDialogCancel();
        paramContext.dismiss();
      }
    });
    paramContext.show();
    return paramContext;
  }
  
  public static Dialog showUnbindDialog(Activity paramActivity, OnUnBoundDeviceListener paramOnUnBoundDeviceListener)
  {
    final Dialog localDialog = new Dialog(paramActivity, 2131427345);
    localDialog.setContentView(2130903090);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((int)(paramActivity.getWindowManager().getDefaultDisplay().getWidth() * 0.95F));
    localDialog.findViewById(2131230966).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (DialogUtil.this != null) {
          DialogUtil.this.onUnBoundDevice();
        }
        localDialog.dismiss();
      }
    });
    localDialog.findViewById(2131230967).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    localDialog.show();
    return localDialog;
  }
  
  public static void showUnitSetDialog(final Context paramContext, int paramInt, OnWheelSelectorListener paramOnWheelSelectorListener)
  {
    final Dialog localDialog = new Dialog(paramContext, 2131427345);
    localDialog.setContentView(2130903093);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
    final WheelView localWheelView = (WheelView)localDialog.findViewById(2131230938);
    localWheelView.setVisibility(0);
    localWheelView.setVisibleItems(3);
    localWheelView.setCyclic(false);
    paramContext = paramContext.getResources().getStringArray(2131361793);
    localWheelView.setAdapter(new ArrayWheelAdapter(paramContext, 25));
    localDialog.findViewById(2131230936).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    localDialog.findViewById(2131230937).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (DialogUtil.this != null) {
          DialogUtil.this.onWheelSelect(paramContext[localWheelView.getCurrentItem()]);
        }
        localDialog.dismiss();
      }
    });
    localWheelView.setCurrentItem(paramInt);
    localDialog.show();
  }
  
  public static void showWheelBirthDayDialog(Context paramContext, int[] paramArrayOfInt, OnBirthdaySelectListener paramOnBirthdaySelectListener)
  {
    final Dialog localDialog = new Dialog(paramContext, 2131427345);
    localDialog.setContentView(2130903093);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
    final WheelView localWheelView1 = (WheelView)localDialog.findViewById(2131230938);
    final WheelView localWheelView2 = (WheelView)localDialog.findViewById(2131230939);
    final WheelView localWheelView3 = (WheelView)localDialog.findViewById(2131230968);
    localWheelView1.setVisibility(0);
    localWheelView2.setVisibility(0);
    localWheelView3.setVisibility(0);
    initTimePicker(paramContext, paramArrayOfInt, localWheelView1, localWheelView2, localWheelView3);
    localDialog.findViewById(2131230936).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    localDialog.findViewById(2131230937).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (DialogUtil.this != null)
        {
          int i = localWheelView1.getCurrentItem();
          int j = DialogUtil.START_YEAR;
          int k = localWheelView2.getCurrentItem();
          int m = localWheelView3.getCurrentItem();
          DialogUtil.this.onBirthdaySelect(i + j, k + 1, m + 1);
        }
        localDialog.dismiss();
      }
    });
    localDialog.show();
  }
  
  public static void showWheelHeightDialog(Context paramContext, int paramInt, OnWheelSelectorListener paramOnWheelSelectorListener)
  {
    final Dialog localDialog = new Dialog(paramContext, 2131427345);
    localDialog.setContentView(2130903093);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
    final WheelView localWheelView1 = (WheelView)localDialog.findViewById(2131230938);
    final WheelView localWheelView2 = (WheelView)localDialog.findViewById(2131230939);
    localWheelView1.setVisibility(0);
    localWheelView1.setVisibleItems(3);
    int j = START_HEIGHT;
    int k = END_HEIGHT;
    DebugLog.d("height:" + paramInt);
    int i;
    if (AppSharedPreferences.getInstance().getUnitType() == 2)
    {
      j = paramInt / 12;
      DebugLog.d("current1:" + j);
      localWheelView1.setAdapter(new ArrayWheelAdapter(new String[] { "1'", "2'", "3'", "4'", "5'", "6'", "7'", "8'" }));
      if (j - 1 < 0)
      {
        i = 0;
        localWheelView1.setCurrentItem(i);
        localWheelView1.addChangingListener(new OnWheelChangedListener()
        {
          public void onChanged(WheelView paramAnonymousWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            DebugLog.d("..............oldValue:" + paramAnonymousInt1 + ",newValue:" + paramAnonymousInt2);
            paramAnonymousInt1 = 98 - (paramAnonymousInt2 + 1) * 12;
            if (paramAnonymousInt1 < 11)
            {
              paramAnonymousWheelView = new String[paramAnonymousInt1 + 1];
              paramAnonymousInt1 = 0;
              for (;;)
              {
                if (paramAnonymousInt1 >= paramAnonymousWheelView.length)
                {
                  paramAnonymousWheelView = new ArrayWheelAdapter(paramAnonymousWheelView);
                  DialogUtil.this.setAdapter(paramAnonymousWheelView);
                  return;
                }
                paramAnonymousWheelView[paramAnonymousInt1] = (paramAnonymousInt1 + "\"");
                paramAnonymousInt1 += 1;
              }
            }
            String[] arrayOfString = new String[12];
            paramAnonymousInt1 = 0;
            for (;;)
            {
              paramAnonymousWheelView = arrayOfString;
              if (paramAnonymousInt1 >= arrayOfString.length) {
                break;
              }
              arrayOfString[paramAnonymousInt1] = (paramAnonymousInt1 + "\"");
              paramAnonymousInt1 += 1;
            }
          }
        });
        i = paramInt % 12;
        DebugLog.d("current2:" + i);
        localWheelView2.setVisibility(0);
        localWheelView2.setVisibleItems(3);
        if (j != 8) {
          break label429;
        }
        paramContext = new String[3];
        paramInt = 0;
        label315:
        if (paramInt < paramContext.length) {
          break label399;
        }
        localWheelView2.setAdapter(new ArrayWheelAdapter(paramContext));
        localWheelView2.setCurrentItem(i);
      }
    }
    for (;;)
    {
      localDialog.findViewById(2131230936).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DialogUtil.this.dismiss();
        }
      });
      localDialog.findViewById(2131230937).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (DialogUtil.this != null)
          {
            if (AppSharedPreferences.getInstance().getUnitType() != 2) {
              break label71;
            }
            DialogUtil.this.onWheelSelect(localWheelView1.getCurrentItem() + 1 + "," + localWheelView2.getCurrentItem());
          }
          for (;;)
          {
            localDialog.dismiss();
            return;
            label71:
            DialogUtil.this.onWheelSelect(Integer.valueOf(localWheelView1.getCurrentItem()));
          }
        }
      });
      localDialog.show();
      return;
      i = j - 1;
      break;
      label399:
      paramContext[paramInt] = (paramInt + "\"");
      paramInt += 1;
      break label315;
      label429:
      String[] arrayOfString = new String[12];
      paramInt = 0;
      for (;;)
      {
        paramContext = arrayOfString;
        if (paramInt >= arrayOfString.length) {
          break;
        }
        arrayOfString[paramInt] = (paramInt + "\"");
        paramInt += 1;
      }
      i = paramInt;
      if (paramInt > k) {
        i = k;
      }
      paramInt = i;
      if (i < j) {
        paramInt = j;
      }
      localWheelView1.setAdapter(new NumericWheelAdapter(j, k));
      localWheelView1.setCurrentItem(paramInt - j);
    }
  }
  
  public static void showWheelHeightDialog2(Context paramContext, int paramInt, OnWheelSelectorListener paramOnWheelSelectorListener)
  {
    final Dialog localDialog = new Dialog(paramContext, 2131427345);
    localDialog.setContentView(2130903083);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
    final WheelViewLu localWheelViewLu1 = (WheelViewLu)localDialog.findViewById(2131230938);
    final WheelViewLu localWheelViewLu2 = (WheelViewLu)localDialog.findViewById(2131230939);
    localWheelViewLu1.setVisibility(0);
    localWheelViewLu1.setOffset(1);
    int j = START_HEIGHT;
    int k = END_HEIGHT;
    DebugLog.d("height:" + paramInt);
    if (AppSharedPreferences.getInstance().getUnitType() == 2)
    {
      j = paramInt / 12;
      DebugLog.d("current1:" + j);
      paramContext = new String[8];
      paramContext[0] = "1'";
      paramContext[1] = "2'";
      paramContext[2] = "3'";
      paramContext[3] = "4'";
      paramContext[4] = "5'";
      paramContext[5] = "6'";
      paramContext[6] = "7'";
      paramContext[7] = "8'";
      new ArrayWheelAdapter(paramContext);
      localWheelViewLu1.setItems(Arrays.asList(paramContext));
      if (j - 1 < 0)
      {
        i = 0;
        localWheelViewLu1.setSeletion(i);
        localWheelViewLu1.setOnWheelViewListener(new WheelViewLu.OnWheelViewListener()
        {
          public void onSelected(int paramAnonymousInt, String paramAnonymousString)
          {
            DebugLog.d("..............selectedIndex:" + paramAnonymousInt + ",item:" + paramAnonymousString);
            if (paramAnonymousInt == 8)
            {
              paramAnonymousString = new String[3];
              paramAnonymousInt = 0;
              for (;;)
              {
                if (paramAnonymousInt >= paramAnonymousString.length)
                {
                  DialogUtil.this.setItems(Arrays.asList(paramAnonymousString));
                  DialogUtil.this.setSeletion(0);
                  return;
                }
                paramAnonymousString[paramAnonymousInt] = (paramAnonymousInt + "\"");
                paramAnonymousInt += 1;
              }
            }
            String[] arrayOfString = new String[12];
            paramAnonymousInt = 0;
            for (;;)
            {
              paramAnonymousString = arrayOfString;
              if (paramAnonymousInt >= arrayOfString.length) {
                break;
              }
              arrayOfString[paramAnonymousInt] = (paramAnonymousInt + "\"");
              paramAnonymousInt += 1;
            }
          }
        });
        i = paramInt % 12;
        DebugLog.d("current2:" + i);
        localWheelViewLu2.setVisibility(0);
        localWheelViewLu2.setOffset(1);
        if (j == 8)
        {
          paramContext = new String[3];
          paramInt = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (paramInt >= paramContext.length)
          {
            localWheelViewLu2.setItems(Arrays.asList(paramContext));
            localWheelViewLu2.setSeletion(i);
            localDialog.findViewById(2131230936).setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymousView)
              {
                DialogUtil.this.dismiss();
              }
            });
            localDialog.findViewById(2131230937).setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymousView)
              {
                if (DialogUtil.this != null)
                {
                  if (AppSharedPreferences.getInstance().getUnitType() != 2) {
                    break label69;
                  }
                  DialogUtil.this.onWheelSelect(localWheelViewLu1.getSeletedItem() + "," + localWheelViewLu2.getSeletedItem());
                }
                for (;;)
                {
                  localDialog.dismiss();
                  return;
                  label69:
                  DialogUtil.this.onWheelSelect(localWheelViewLu1.getSeletedItem());
                }
              }
            });
            localDialog.show();
            return;
            i = j - 1;
            break;
          }
          paramContext[paramInt] = (paramInt + "\"");
          paramInt += 1;
        }
      }
      String[] arrayOfString = new String[12];
      paramInt = 0;
      for (;;)
      {
        paramContext = arrayOfString;
        if (paramInt >= arrayOfString.length) {
          break;
        }
        arrayOfString[paramInt] = (paramInt + "\"");
        paramInt += 1;
      }
    }
    localWheelViewLu2.setVisibility(8);
    int i = paramInt;
    if (paramInt > k) {
      i = k;
    }
    paramInt = i;
    if (i < j) {
      paramInt = j;
    }
    paramContext = new ArrayList();
    i = j;
    for (;;)
    {
      if (i > k)
      {
        localWheelViewLu1.setItems(paramContext);
        localWheelViewLu1.setSeletion(paramInt - j);
        break;
      }
      paramContext.add(i);
      i += 1;
    }
  }
  
  public static void showWheelSexDialog(Context paramContext, int paramInt, OnWheelSelectorListener paramOnWheelSelectorListener)
  {
    final Dialog localDialog = new Dialog(paramContext, 2131427345);
    localDialog.setContentView(2130903093);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
    final WheelView localWheelView = (WheelView)localDialog.findViewById(2131230938);
    localWheelView.setVisibility(0);
    localWheelView.setVisibleItems(3);
    localWheelView.setCyclic(false);
    localWheelView.setAdapter(new ArrayWheelAdapter(paramContext.getResources().getStringArray(2131361792), 25));
    localWheelView.setCurrentItem(paramInt);
    localDialog.findViewById(2131230936).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    localDialog.findViewById(2131230937).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (DialogUtil.this != null) {
          DialogUtil.this.onWheelSelect(Integer.valueOf(localWheelView.getCurrentItem()));
        }
        localDialog.dismiss();
      }
    });
    localDialog.show();
  }
  
  public static void showWheelTimeDialog(Context paramContext, int paramInt1, int paramInt2, OnTimePickerSelectListener paramOnTimePickerSelectListener)
  {
    final Dialog localDialog = new Dialog(paramContext, 2131427345);
    localDialog.setContentView(2130903093);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
    final WheelView localWheelView1 = (WheelView)localDialog.findViewById(2131230938);
    final WheelView localWheelView2 = (WheelView)localDialog.findViewById(2131230939);
    localWheelView1.setVisibility(0);
    localWheelView2.setVisibility(0);
    String str = paramContext.getResources().getString(2131296408);
    paramContext = paramContext.getResources().getString(2131296409);
    localWheelView1.setAdapter(new NumericWheelAdapter(0, 23, "%02d"));
    localWheelView1.setCyclic(true);
    localWheelView1.setCurrentItem(paramInt1);
    localWheelView1.setVisibleItems(3);
    localWheelView1.setLabel(str);
    localWheelView2.setAdapter(new NumericWheelAdapter(0, 59, "%02d"));
    localWheelView2.setCyclic(true);
    localWheelView2.setCurrentItem(paramInt2);
    localWheelView2.setVisibleItems(3);
    localWheelView2.setLabel(paramContext);
    localDialog.findViewById(2131230936).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    localDialog.findViewById(2131230937).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (DialogUtil.this != null)
        {
          int i = localWheelView1.getCurrentItem();
          int j = localWheelView2.getCurrentItem();
          DialogUtil.this.OnTimePickerSelect(i, j);
        }
        localDialog.dismiss();
      }
    });
    localDialog.show();
  }
  
  public static void showWheelWeightDialog(final Context paramContext, int paramInt, OnWheelSelectorListener paramOnWheelSelectorListener)
  {
    final Dialog localDialog = new Dialog(paramContext, 2131427345);
    localDialog.setContentView(2130903093);
    localDialog.getWindow().setGravity(80);
    localDialog.setCancelable(true);
    localDialog.getWindow().getAttributes().width = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
    paramContext = (WheelView)localDialog.findViewById(2131230938);
    paramContext.setVisibility(0);
    paramContext.setVisibleItems(3);
    final int j = START_WEIGHT;
    int i = END_WEIGHT;
    if (AppSharedPreferences.getInstance().getUnitType() == 2)
    {
      j = 55;
      i = 451;
    }
    int k = paramInt;
    if (paramInt > i) {
      k = i;
    }
    paramInt = k;
    if (k < j) {
      paramInt = j;
    }
    paramContext.setAdapter(new NumericWheelAdapter(j, i));
    paramContext.setCurrentItem(paramInt - j);
    localDialog.findViewById(2131230936).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DialogUtil.this.dismiss();
      }
    });
    localDialog.findViewById(2131230937).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (DialogUtil.this != null) {
          DialogUtil.this.onWheelSelect(Integer.valueOf(paramContext.getCurrentItem() + j));
        }
        localDialog.dismiss();
      }
    });
    localDialog.show();
  }
  
  public static void startPhotoZoom(Uri paramUri, Activity paramActivity, Fragment paramFragment)
  {
    Intent localIntent = new Intent("com.android.camera.action.CROP");
    localIntent.setDataAndType(paramUri, "image/*");
    localIntent.putExtra("crop", "true");
    localIntent.putExtra("aspectX", 1);
    localIntent.putExtra("aspectY", 1);
    localIntent.putExtra("outputX", 200);
    localIntent.putExtra("outputY", 200);
    localIntent.putExtra("return-data", true);
    Log.d("DialogUtil", "----startPhotoZoom");
    if (paramFragment != null)
    {
      paramFragment.startActivityForResult(localIntent, 3);
      return;
    }
    paramActivity.startActivityForResult(localIntent, 3);
  }
  
  public static abstract interface OnBirthdaySelectListener
  {
    public abstract void onBirthdaySelect(int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static abstract interface OnDialogButtonClick
  {
    public abstract void onCancleClick();
    
    public abstract void onSureClick();
  }
  
  public static abstract interface OnDialogClickListener
  {
    public abstract void onDialogCancel();
    
    public abstract void onDialogShare();
  }
  
  public static abstract interface OnHeightFormatSelectListener
  {
    public abstract void onHeightFormat(int paramInt);
  }
  
  public static abstract interface OnRemoveImgListener
  {
    public abstract void onRemoveImg();
  }
  
  public static abstract interface OnShareSelectListener
  {
    public abstract void onCancel();
    
    public abstract void onShareSelect(int paramInt);
  }
  
  public static abstract interface OnTimePickerSelectListener
  {
    public abstract void OnTimePickerSelect(int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnUnBoundDeviceListener
  {
    public abstract void onUnBoundDevice();
  }
  
  public static abstract interface OnWheelSelectorListener
  {
    public abstract void onWheelSelect(Object paramObject);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\DialogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */