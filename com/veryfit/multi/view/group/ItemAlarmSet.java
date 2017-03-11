package com.veryfit.multi.view.group;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DebugLog;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.view.ValueStateTextView;
import com.veryfit.multi.view.wheel.ArrayWheelAdapter;
import com.veryfit.multi.view.wheel.NumericWheelAdapter;
import com.veryfit.multi.view.wheel.OnWheelChangedListener;
import com.veryfit.multi.view.wheel.WheelView;
import com.veryfit.multi.vo.Alarm;

public class ItemAlarmSet
  extends RelativeLayout
{
  public static final int TYPE_ALARM_NAME = 4;
  public static final int TYPE_ALARM_REMIND = 1;
  public static final int TYPE_ALARM_REPEAT = 2;
  public static final int TYPE_ALARM_TIME = 3;
  private String[] alarmTypes;
  private ViewStub editView;
  private String lable;
  private TextView lableView;
  private Object[] params;
  public int type;
  private ValueStateTextView valueView;
  private View view;
  
  public ItemAlarmSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130903108, this, true);
    setBackgroundColor(getResources().getColor(2131099653));
    this.lableView = ((TextView)findViewById(2131231063));
    this.valueView = ((ValueStateTextView)findViewById(2131231064));
    setAlarmTypes();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ItemLableValue);
    this.lable = paramContext.getString(2);
    boolean bool1 = paramContext.getBoolean(7, false);
    boolean bool2 = paramContext.getBoolean(0, true);
    int i = paramContext.getColor(1, 0);
    paramAttributeSet = paramContext.getDrawable(4);
    paramContext.recycle();
    if (paramAttributeSet != null)
    {
      paramAttributeSet.setBounds(0, 0, paramAttributeSet.getIntrinsicWidth(), paramAttributeSet.getIntrinsicHeight());
      this.valueView.setCompoundDrawables(null, null, paramAttributeSet, null);
    }
    if (i != 0) {
      this.valueView.setTextColor(i);
    }
    this.lableView.setText(this.lable);
    this.valueView.setOpen(bool1);
    this.valueView.setEnabled(bool2);
    this.valueView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (ViewGroup)ItemAlarmSet.this.getParent();
        int i = 0;
        if (i >= paramAnonymousView.getChildCount())
        {
          ItemAlarmSet.this.startExpandAnim();
          paramAnonymousView = ItemAlarmSet.this.valueView;
          if (!ItemAlarmSet.this.valueView.isOpen()) {
            break label106;
          }
        }
        label106:
        for (boolean bool = false;; bool = true)
        {
          paramAnonymousView.setOpen(bool);
          return;
          ItemAlarmSet localItemAlarmSet = (ItemAlarmSet)paramAnonymousView.getChildAt(i);
          if ((!localItemAlarmSet.equals(ItemAlarmSet.this)) && (localItemAlarmSet.valueView.isOpen())) {
            localItemAlarmSet.valueView.performClick();
          }
          i += 1;
          break;
        }
      }
    });
  }
  
  private void initNameStub(String paramString)
  {
    this.editView = ((ViewStub)findViewById(2131231068));
    this.view = this.editView.inflate();
  }
  
  private void initRemindStub(int paramInt)
  {
    this.editView = ((ViewStub)findViewById(2131231065));
    this.view = this.editView.inflate();
    WheelView localWheelView = (WheelView)this.view.findViewById(2131231108);
    localWheelView.setAdapter(new ArrayWheelAdapter(this.alarmTypes, 30));
    localWheelView.setCurrentItem(paramInt);
    localWheelView.setCyclic(false);
    localWheelView.addChangingListener(new OnWheelChangedListener()
    {
      public void onChanged(WheelView paramAnonymousWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ItemAlarmSet.this.valueView.setText(ItemAlarmSet.this.alarmTypes[paramAnonymousInt2]);
        ItemAlarmSet.this.params[0] = Integer.valueOf(paramAnonymousInt2);
      }
    });
  }
  
  private void initRepeatStub(Integer paramInteger)
  {
    this.editView = ((ViewStub)findViewById(2131231067));
    this.view = this.editView.inflate();
    WeekDayCheckRepeat localWeekDayCheckRepeat = (WeekDayCheckRepeat)this.view.findViewById(2131231101);
    localWeekDayCheckRepeat.initAndSetDefault(paramInteger.intValue());
    localWeekDayCheckRepeat.setOnChangeLinstener(new WeekDayCheckRepeat.OnWeekCheckedChange()
    {
      public void onChange(int paramAnonymousInt)
      {
        ItemAlarmSet.this.params[0] = Integer.valueOf(paramAnonymousInt);
        String[] arrayOfString1 = new String[7];
        String[] arrayOfString2 = ItemAlarmSet.this.getResources().getStringArray(2131361794);
        arrayOfString1[6] = arrayOfString2[0];
        paramAnonymousInt = 1;
        for (;;)
        {
          if (paramAnonymousInt >= arrayOfString2.length)
          {
            ItemAlarmSet.this.valueView.setText(Alarm.getCycle(arrayOfString1, ((Integer)ItemAlarmSet.this.params[0]).intValue()));
            return;
          }
          arrayOfString1[(paramAnonymousInt - 1)] = arrayOfString2[paramAnonymousInt];
          paramAnonymousInt += 1;
        }
      }
    });
  }
  
  private void initStubView(int paramInt, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      initNameStub((String)paramArrayOfObject[0]);
      return;
    case 2: 
      initRepeatStub((Integer)paramArrayOfObject[0]);
      return;
    case 1: 
      initRemindStub(((Integer)paramArrayOfObject[0]).intValue());
      return;
    }
    initTimeStub((Integer)paramArrayOfObject[0], (Integer)paramArrayOfObject[1]);
  }
  
  private void initTimeStub(Integer paramInteger1, Integer paramInteger2)
  {
    this.editView = ((ViewStub)findViewById(2131231066));
    this.view = this.editView.inflate();
    showTime12(paramInteger1, paramInteger2, AppSharedPreferences.getInstance().is24TimeMode());
  }
  
  private void setAlarmTypes()
  {
    Object localObject2 = "";
    String[] arrayOfString = getResources().getStringArray(2131361795);
    int i3 = LibSharedPreferences.getInstance().getDeviceFunAlarmNotify();
    int i;
    int j;
    label47:
    int k;
    label59:
    int m;
    label73:
    int n;
    label87:
    int i1;
    label101:
    int i2;
    if ((i3 & 0x1) == 1)
    {
      i = 1;
      if ((i3 & 0x2) >> 1 != 1) {
        break label469;
      }
      j = 1;
      if ((i3 & 0x4) >> 2 != 1) {
        break label474;
      }
      k = 1;
      if ((i3 & 0x8) >> 3 != 1) {
        break label479;
      }
      m = 1;
      if ((i3 & 0x10) >> 4 != 1) {
        break label485;
      }
      n = 1;
      if ((i3 & 0x20) >> 5 != 1) {
        break label491;
      }
      i1 = 1;
      if ((i3 & 0x40) >> 6 != 1) {
        break label497;
      }
      i2 = 1;
      label116:
      if ((i3 & 0x80) >> 7 != 1) {
        break label503;
      }
    }
    label469:
    label474:
    label479:
    label485:
    label491:
    label497:
    label503:
    for (i3 = 1;; i3 = 0)
    {
      if (i != 0) {
        localObject2 = "" + arrayOfString[0] + ",";
      }
      Object localObject1 = localObject2;
      if (j != 0) {
        localObject1 = localObject2 + arrayOfString[1] + ",";
      }
      localObject2 = localObject1;
      if (k != 0) {
        localObject2 = localObject1 + arrayOfString[2] + ",";
      }
      localObject1 = localObject2;
      if (m != 0) {
        localObject1 = localObject2 + arrayOfString[3] + ",";
      }
      localObject2 = localObject1;
      if (n != 0) {
        localObject2 = localObject1 + arrayOfString[4] + ",";
      }
      localObject1 = localObject2;
      if (i1 != 0) {
        localObject1 = localObject2 + arrayOfString[5] + ",";
      }
      localObject2 = localObject1;
      if (i2 != 0) {
        localObject2 = localObject1 + arrayOfString[6] + ",";
      }
      localObject1 = localObject2;
      if (i3 != 0) {
        localObject1 = localObject2 + arrayOfString[7] + ",";
      }
      this.alarmTypes = ((String)localObject1).substring(0, ((String)localObject1).length() - 1).split(",");
      return;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label59;
      m = 0;
      break label73;
      n = 0;
      break label87;
      i1 = 0;
      break label101;
      i2 = 0;
      break label116;
    }
  }
  
  public Object[] getValue()
  {
    return this.params;
  }
  
  public void setStubType(int paramInt, Object... paramVarArgs)
  {
    this.type = paramInt;
    this.params = paramVarArgs;
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      this.valueView.setText(paramVarArgs[0]);
      return;
    case 2: 
      String[] arrayOfString1 = new String[7];
      String[] arrayOfString2 = getResources().getStringArray(2131361794);
      arrayOfString1[6] = arrayOfString2[0];
      paramInt = 1;
      for (;;)
      {
        if (paramInt >= arrayOfString2.length)
        {
          this.valueView.setText(Alarm.getCycle(arrayOfString1, ((Integer)paramVarArgs[0]).intValue()));
          return;
        }
        arrayOfString1[(paramInt - 1)] = arrayOfString2[paramInt];
        paramInt += 1;
      }
    case 1: 
      if (this.alarmTypes.length <= 1)
      {
        this.valueView.setClickable(false);
        this.valueView.setVisibility(8);
        return;
      }
      this.valueView.setText(this.alarmTypes[((Integer)paramVarArgs[0]).intValue()]);
      return;
    }
    int i = ((Integer)paramVarArgs[0]).intValue();
    int j = ((Integer)paramVarArgs[1]).intValue();
    if (AppSharedPreferences.getInstance().is24TimeMode())
    {
      this.valueView.setText(Util.formatTime(i, j));
      this.editView = ((ViewStub)findViewById(2131231065));
      return;
    }
    paramVarArgs = getResources().getStringArray(2131361796);
    if (Util.isAM(i)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramVarArgs = new StringBuilder(String.valueOf(paramVarArgs[paramInt])).append(" ").toString() + Util.formatTime(Util.format24To12(i), j);
      this.valueView.setText(paramVarArgs);
      break;
    }
  }
  
  public void showTime12(final Integer paramInteger1, Integer paramInteger2, boolean paramBoolean)
  {
    if (this.view == null) {
      return;
    }
    final WheelView localWheelView1 = (WheelView)this.view.findViewById(2131231109);
    final String[] arrayOfString = getResources().getStringArray(2131361796);
    final WheelView localWheelView2;
    if (paramBoolean)
    {
      this.view.findViewById(2131231110).setVisibility(0);
      localWheelView1.setVisibility(8);
      localWheelView2 = (WheelView)this.view.findViewById(2131230964);
      if (!paramBoolean) {
        break label274;
      }
      localWheelView2.setAdapter(new NumericWheelAdapter(0, 23));
      label94:
      if (!paramBoolean) {
        break label292;
      }
    }
    label274:
    label292:
    for (int i = paramInteger1.intValue();; i = Util.format24To12(paramInteger1.intValue()) - 1)
    {
      localWheelView2.setCurrentItem(i);
      paramInteger1 = (WheelView)this.view.findViewById(2131230965);
      paramInteger1.setAdapter(new NumericWheelAdapter(0, 59));
      paramInteger1.setCurrentItem(paramInteger2.intValue());
      localWheelView1.addChangingListener(new OnWheelChangedListener()
      {
        public void onChanged(WheelView paramAnonymousWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int i = paramInteger1.getCurrentItem();
          paramAnonymousInt1 = localWheelView2.getCurrentItem();
          if (AppSharedPreferences.getInstance().is24TimeMode())
          {
            ItemAlarmSet.this.valueView.setText(Util.formatTime(paramAnonymousInt1, i));
            ItemAlarmSet.this.params[0] = Integer.valueOf(paramAnonymousInt1);
            DebugLog.d("hour = " + paramAnonymousInt1);
            ItemAlarmSet.this.params[1] = Integer.valueOf(i);
            return;
          }
          paramAnonymousWheelView = arrayOfString[paramAnonymousInt2];
          paramAnonymousInt1 += 1;
          ItemAlarmSet.this.valueView.setText(paramAnonymousWheelView + " " + paramAnonymousInt1 + ":" + i);
          paramAnonymousWheelView = ItemAlarmSet.this.params;
          if (paramAnonymousInt2 == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousWheelView[0] = Integer.valueOf(Util.format12To24(paramAnonymousInt1, bool));
            break;
          }
        }
      });
      localWheelView2.addChangingListener(new OnWheelChangedListener()
      {
        public void onChanged(WheelView paramAnonymousWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAnonymousInt1 = paramInteger1.getCurrentItem();
          if (AppSharedPreferences.getInstance().is24TimeMode())
          {
            ItemAlarmSet.this.valueView.setText(Util.formatTime(paramAnonymousInt2, paramAnonymousInt1));
            ItemAlarmSet.this.params[0] = Integer.valueOf(paramAnonymousInt2);
            DebugLog.d("hour = " + paramAnonymousInt2);
            ItemAlarmSet.this.params[1] = Integer.valueOf(paramAnonymousInt1);
            return;
          }
          paramAnonymousWheelView = arrayOfString[localWheelView1.getCurrentItem()];
          paramAnonymousInt2 += 1;
          ItemAlarmSet.this.valueView.setText(paramAnonymousWheelView + " " + paramAnonymousInt2 + ":" + paramAnonymousInt1);
          paramAnonymousWheelView = ItemAlarmSet.this.params;
          if (localWheelView1.getCurrentItem() == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousWheelView[0] = Integer.valueOf(Util.format12To24(paramAnonymousInt2, bool));
            break;
          }
        }
      });
      paramInteger1.addChangingListener(new OnWheelChangedListener()
      {
        public void onChanged(WheelView paramAnonymousWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAnonymousInt1 = localWheelView2.getCurrentItem();
          if (AppSharedPreferences.getInstance().is24TimeMode())
          {
            ItemAlarmSet.this.valueView.setText(Util.formatTime(paramAnonymousInt1, paramAnonymousInt2));
            ItemAlarmSet.this.params[0] = Integer.valueOf(paramAnonymousInt1);
            DebugLog.d("hour = " + paramAnonymousInt1);
            ItemAlarmSet.this.params[1] = Integer.valueOf(paramAnonymousInt2);
            return;
          }
          paramAnonymousWheelView = arrayOfString[localWheelView1.getCurrentItem()];
          paramAnonymousInt1 += 1;
          ItemAlarmSet.this.valueView.setText(paramAnonymousWheelView + " " + paramAnonymousInt1 + ":" + paramAnonymousInt2);
          paramAnonymousWheelView = ItemAlarmSet.this.params;
          if (localWheelView1.getCurrentItem() == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousWheelView[0] = Integer.valueOf(Util.format12To24(paramAnonymousInt1, bool));
            break;
          }
        }
      });
      return;
      localWheelView1.setAdapter(new ArrayWheelAdapter(arrayOfString, 30));
      if (Util.isAM(paramInteger1.intValue())) {}
      for (i = 0;; i = 1)
      {
        localWheelView1.setCurrentItem(i);
        localWheelView1.setCyclic(false);
        localWheelView1.setVisibility(0);
        this.view.findViewById(2131231110).setVisibility(8);
        break;
      }
      localWheelView2.setAdapter(new NumericWheelAdapter(1, 12));
      break label94;
    }
  }
  
  protected void startExpandAnim()
  {
    if (this.view == null) {
      initStubView(this.type, this.params);
    }
    if (this.valueView.isOpen())
    {
      this.view.setVisibility(8);
      return;
    }
    this.view.setVisibility(0);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\ItemAlarmSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */