package com.veryfit.multi.view.swipemenulistview;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

public class SwipeMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private SwipeMenuLayout mLayout;
  private SwipeMenuListView mListView;
  private SwipeMenu mMenu;
  private OnSwipeItemClickListener onItemClickListener;
  private int position;
  
  public SwipeMenuView(SwipeMenu paramSwipeMenu, SwipeMenuListView paramSwipeMenuListView)
  {
    super(paramSwipeMenu.getContext());
    this.mListView = paramSwipeMenuListView;
    this.mMenu = paramSwipeMenu;
    paramSwipeMenu = paramSwipeMenu.getMenuItems();
    int i = 0;
    paramSwipeMenu = paramSwipeMenu.iterator();
    for (;;)
    {
      if (!paramSwipeMenu.hasNext()) {
        return;
      }
      addItem((SwipeMenuItem)paramSwipeMenu.next(), i);
      i += 1;
    }
  }
  
  private void addItem(SwipeMenuItem paramSwipeMenuItem, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramSwipeMenuItem.getWidth(), -1);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setId(paramInt);
    localLinearLayout.setGravity(17);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(paramSwipeMenuItem.getBackground());
    localLinearLayout.setOnClickListener(this);
    addView(localLinearLayout);
    if (paramSwipeMenuItem.getIcon() != null) {
      localLinearLayout.addView(createIcon(paramSwipeMenuItem));
    }
    if (!TextUtils.isEmpty(paramSwipeMenuItem.getTitle())) {
      localLinearLayout.addView(createTitle(paramSwipeMenuItem));
    }
  }
  
  private ImageView createIcon(SwipeMenuItem paramSwipeMenuItem)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(paramSwipeMenuItem.getIcon());
    return localImageView;
  }
  
  private TextView createTitle(SwipeMenuItem paramSwipeMenuItem)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramSwipeMenuItem.getTitle());
    localTextView.setGravity(17);
    localTextView.setTextSize(paramSwipeMenuItem.getTitleSize());
    localTextView.setTextColor(paramSwipeMenuItem.getTitleColor());
    return localTextView;
  }
  
  public OnSwipeItemClickListener getOnSwipeItemClickListener()
  {
    return this.onItemClickListener;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void onClick(View paramView)
  {
    if ((this.onItemClickListener != null) && (this.mLayout.isOpen())) {
      this.onItemClickListener.onItemClick(this, this.mMenu, paramView.getId());
    }
  }
  
  public void setLayout(SwipeMenuLayout paramSwipeMenuLayout)
  {
    this.mLayout = paramSwipeMenuLayout;
  }
  
  public void setOnSwipeItemClickListener(OnSwipeItemClickListener paramOnSwipeItemClickListener)
  {
    this.onItemClickListener = paramOnSwipeItemClickListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public static abstract interface OnSwipeItemClickListener
  {
    public abstract void onItemClick(SwipeMenuView paramSwipeMenuView, SwipeMenu paramSwipeMenu, int paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\swipemenulistview\SwipeMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */