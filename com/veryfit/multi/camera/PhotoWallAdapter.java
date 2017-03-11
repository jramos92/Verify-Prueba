package com.veryfit.multi.camera;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.veryfit.multi.photowall.ImageActivity;
import java.util.List;

public class PhotoWallAdapter
  extends BaseAdapter
{
  private boolean[] array;
  private Context context;
  private List<String> imagePathList = null;
  private SDCardImageLoader loader;
  
  public PhotoWallAdapter(Context paramContext, List<String> paramList, boolean[] paramArrayOfBoolean)
  {
    this.context = paramContext;
    this.imagePathList = paramList;
    this.array = paramArrayOfBoolean;
    this.loader = SDCardImageLoader.getInstance();
  }
  
  public int getCount()
  {
    if (this.imagePathList == null) {
      return 0;
    }
    return this.imagePathList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.imagePathList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)this.imagePathList.get(paramInt);
    if (paramView == null)
    {
      ViewHolder localViewHolder = new ViewHolder(null);
      paramView = LayoutInflater.from(this.context).inflate(2130903118, paramViewGroup, false);
      localViewHolder.imageView = ((ImageView)paramView.findViewById(2131231086));
      localViewHolder.checkBox = ((CheckBox)paramView.findViewById(2131231087));
      paramView.setTag(localViewHolder);
      paramViewGroup = localViewHolder;
      if (!ImageActivity.visiblecheck) {
        break label185;
      }
      paramViewGroup.checkBox.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.checkBox.setTag(2131230720, Integer.valueOf(paramInt));
      paramViewGroup.checkBox.setTag(2131230721, paramViewGroup.imageView);
      paramViewGroup.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          Integer localInteger = (Integer)paramAnonymousCompoundButton.getTag(2131230720);
          paramAnonymousCompoundButton = (ImageView)paramAnonymousCompoundButton.getTag(2131230721);
          PhotoWallAdapter.this.array[localInteger.intValue()] = paramAnonymousBoolean;
          if (paramAnonymousBoolean)
          {
            paramAnonymousCompoundButton.setColorFilter(PhotoWallAdapter.this.context.getResources().getColor(2131099700));
            return;
          }
          paramAnonymousCompoundButton.setColorFilter(null);
        }
      });
      paramViewGroup.imageView.setTag(str);
      this.loader.loadImage(4, str, paramViewGroup.imageView);
      paramViewGroup.checkBox.setChecked(this.array[paramInt]);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
      label185:
      paramViewGroup.checkBox.setVisibility(8);
    }
  }
  
  public void updateUI(List<String> paramList)
  {
    this.imagePathList = paramList;
    notifyDataSetChanged();
  }
  
  private static class ViewHolder
  {
    CheckBox checkBox;
    ImageView imageView;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\PhotoWallAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */