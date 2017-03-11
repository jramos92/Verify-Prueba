package com.veryfit.multi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.project.library.entity.BleDevice;
import java.util.ArrayList;

public class DeviceAdapter
  extends BaseAdapter
{
  public boolean binding;
  public BleDevice checkDevice;
  LayoutInflater inflater;
  ArrayList<BleDevice> mDeviceList;
  
  public DeviceAdapter(ArrayList<BleDevice> paramArrayList, Context paramContext)
  {
    this.mDeviceList = paramArrayList;
    this.inflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.mDeviceList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mDeviceList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.inflater.inflate(2130903109, null);
      paramViewGroup = new ViewHolder();
      paramViewGroup.icon = ((ImageView)paramView.findViewById(2131231069));
      paramViewGroup.check = ((ImageView)paramView.findViewById(2131230879));
      paramViewGroup.address = ((TextView)paramView.findViewById(2131231071));
      paramViewGroup.name = ((TextView)paramView.findViewById(2131231070));
      paramViewGroup.progress = ((ProgressBar)paramView.findViewById(2131230878));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      BleDevice localBleDevice = (BleDevice)this.mDeviceList.get(paramInt);
      paramViewGroup.name.setText(localBleDevice.mDeviceName);
      paramViewGroup.address.setText(localBleDevice.mDeviceAddress + "---" + localBleDevice.mRssi);
      paramViewGroup.progress.setVisibility(8);
      paramViewGroup.check.setVisibility(8);
      if (localBleDevice.equals(this.checkDevice))
      {
        if (!this.binding) {
          break;
        }
        paramViewGroup.progress.setVisibility(0);
      }
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
    paramViewGroup.check.setVisibility(0);
    return paramView;
  }
  
  class ViewHolder
  {
    TextView address;
    ImageView check;
    ImageView icon;
    TextView name;
    ProgressBar progress;
    
    ViewHolder() {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\adapter\DeviceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */