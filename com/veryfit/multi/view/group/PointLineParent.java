package com.veryfit.multi.view.group;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.view.PointLineView;
import com.veryfit.multi.view.PointLineView.onDateScrolling;
import java.util.List;

public class PointLineParent
  extends LinearLayout
{
  public static final int TYPE_SLEEP = 1;
  public static final int TYPE_SPORT = 0;
  private TextView checkedData;
  private List<Integer> datas;
  private TextView gotoTheDay;
  private PointLineView pointLineView;
  private PointLineView.onDateScrolling selectLinstener;
  private int tempIndex;
  private int type = 0;
  
  public PointLineParent(final Context paramContext, final AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130903119, this, true);
    setOrientation(1);
    setBackgroundResource(2130837525);
    this.checkedData = ((TextView)findViewById(2131231088));
    this.gotoTheDay = ((TextView)findViewById(2131231090));
    this.pointLineView = ((PointLineView)findViewById(2131231089));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PointLine);
    int j = getResources().getColor(2131099648);
    int i = paramContext.getColor(1, j);
    j = paramContext.getColor(2, j);
    paramContext.recycle();
    this.checkedData.setTextColor(i);
    this.gotoTheDay.setTextColor(i);
    this.pointLineView.setGraphColor(j);
    paramContext = getResources().getString(2131296411);
    paramAttributeSet = getResources().getString(2131296414);
    final String str = getResources().getString(2131296415);
    this.pointLineView.setDateScrollingLinstener(new PointLineView.onDateScrolling()
    {
      public void onScrolling(int paramAnonymousInt)
      {
        int i = paramAnonymousInt;
        if (PointLineParent.this.datas != null)
        {
          paramAnonymousInt = Math.max(0, Math.min(PointLineParent.this.datas.size() - 1, paramAnonymousInt));
          if (PointLineParent.this.type != 0) {
            break label127;
          }
          PointLineParent.this.checkedData.setText(PointLineParent.this.datas.get(paramAnonymousInt) + " " + paramContext);
          i = paramAnonymousInt;
        }
        for (;;)
        {
          PointLineParent.this.tempIndex = i;
          if (PointLineParent.this.selectLinstener != null) {
            PointLineParent.this.selectLinstener.onScrolling(i);
          }
          return;
          label127:
          i = paramAnonymousInt;
          if (PointLineParent.this.type == 1)
          {
            i = ((Integer)PointLineParent.this.datas.get(paramAnonymousInt)).intValue();
            PointLineParent.this.checkedData.setText(i / 60 + paramAttributeSet + i % 60 + str);
            i = paramAnonymousInt;
          }
        }
      }
    });
  }
  
  public TextView getGoToTheDayView()
  {
    return this.gotoTheDay;
  }
  
  public int getShowingOffset()
  {
    return this.tempIndex;
  }
  
  public void setDatas(List<Integer> paramList)
  {
    this.datas = paramList;
    this.pointLineView.setDatas(paramList);
  }
  
  public void setOnDateScrollingLinstener(PointLineView.onDateScrolling paramonDateScrolling)
  {
    this.selectLinstener = paramonDateScrolling;
  }
  
  public void setShowingOffset(int paramInt)
  {
    this.tempIndex = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void toggle(int paramInt)
  {
    if (getVisibility() == 0)
    {
      setVisibility(8);
      this.pointLineView.setCurrentItem(paramInt);
      return;
    }
    setVisibility(0);
    this.pointLineView.setCurrentItem(paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\PointLineParent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */