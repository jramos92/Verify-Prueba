package com.veryfit.multi.view.group;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.veryfit.multi.view.ValueStateTextView;
import com.veryfit.multi.vo.Alarm;

public class WeekDayCheck
  extends LinearLayout
{
  private OnWeekCheckedChange onChange;
  private int repetitions;
  private View.OnClickListener toggle = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ValueStateTextView localValueStateTextView = (ValueStateTextView)paramAnonymousView;
      if (localValueStateTextView.isOpen()) {}
      for (boolean bool = false;; bool = true)
      {
        localValueStateTextView.setOpen(bool);
        WeekDayCheck.this.repetitions = Alarm.updateRepeat(WeekDayCheck.this.repetitions, ((Integer)paramAnonymousView.getTag()).intValue(), localValueStateTextView.isOpen());
        if (WeekDayCheck.this.onChange != null) {
          WeekDayCheck.this.onChange.onChange(WeekDayCheck.this.repetitions);
        }
        return;
      }
    }
  };
  
  public WeekDayCheck(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130903132, this);
  }
  
  public int getRepetition()
  {
    return this.repetitions;
  }
  
  public void initAndSetDefault(int paramInt)
  {
    this.repetitions = paramInt;
    int i = 0;
    if (i >= getChildCount()) {
      return;
    }
    ValueStateTextView localValueStateTextView = (ValueStateTextView)getChildAt(i);
    if ((paramInt >> i + 1 & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localValueStateTextView.setOpen(bool);
      localValueStateTextView.setOnClickListener(this.toggle);
      localValueStateTextView.setTag(Integer.valueOf(i + 1));
      i += 1;
      break;
    }
  }
  
  public void setOnChangeLinstener(OnWeekCheckedChange paramOnWeekCheckedChange)
  {
    this.onChange = paramOnWeekCheckedChange;
  }
  
  public static abstract interface OnWeekCheckedChange
  {
    public abstract void onChange(int paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\WeekDayCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */