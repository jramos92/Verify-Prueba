package com.veryfit.multi.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.project.library.database.AlarmNotify;
import com.project.library.database.AlarmNotifyDao;
import com.project.library.database.DaoSession;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.view.CustomToggleButton;
import com.veryfit.multi.view.CustomToggleButton.OnSwitchListener;
import java.util.Collections;
import java.util.List;

public class AlarmAdapter
  extends BaseAdapter
{
  private AlarmNotifyDao alarmNotifyDao;
  private String[] alarmTypeId;
  private String[] alarmTypes;
  private List<AlarmNotify> datas;
  private LayoutInflater inflater;
  public boolean sendingData;
  
  public AlarmAdapter(List<AlarmNotify> paramList, Context paramContext)
  {
    this.datas = paramList;
    this.inflater = LayoutInflater.from(paramContext);
    setAlarmTypes(paramContext);
    this.alarmNotifyDao = DBTool.getInstance().getDaoSession().getAlarmNotifyDao();
  }
  
  private int getImageIdByType(int paramInt)
  {
    switch (Integer.parseInt(this.alarmTypeId[paramInt]))
    {
    default: 
      return 0;
    case 0: 
      return 2130837553;
    case 1: 
      return 2130837550;
    case 2: 
      return 2130837551;
    case 3: 
      return 2130837549;
    case 4: 
      return 2130837547;
    case 5: 
      return 2130837552;
    case 6: 
      return 2130837548;
    }
    return 2130837546;
  }
  
  private void setAlarmTypes(Context paramContext)
  {
    Object localObject3 = "";
    Object localObject1 = "";
    String[] arrayOfString = paramContext.getResources().getStringArray(2131361795);
    int i3 = LibSharedPreferences.getInstance().getDeviceFunAlarmNotify();
    int i;
    int j;
    label49:
    int k;
    label62:
    int m;
    label76:
    int n;
    label90:
    int i1;
    label104:
    int i2;
    if ((i3 & 0x1) == 1)
    {
      i = 1;
      if ((i3 & 0x2) >> 1 != 1) {
        break label673;
      }
      j = 1;
      if ((i3 & 0x4) >> 2 != 1) {
        break label678;
      }
      k = 1;
      if ((i3 & 0x8) >> 3 != 1) {
        break label684;
      }
      m = 1;
      if ((i3 & 0x10) >> 4 != 1) {
        break label690;
      }
      n = 1;
      if ((i3 & 0x20) >> 5 != 1) {
        break label696;
      }
      i1 = 1;
      if ((i3 & 0x40) >> 6 != 1) {
        break label702;
      }
      i2 = 1;
      label119:
      if ((i3 & 0x80) >> 7 != 1) {
        break label708;
      }
    }
    label673:
    label678:
    label684:
    label690:
    label696:
    label702:
    label708:
    for (i3 = 1;; i3 = 0)
    {
      if (i != 0)
      {
        localObject3 = "" + arrayOfString[0] + ",";
        localObject1 = "" + "0,";
      }
      Object localObject2 = localObject3;
      paramContext = (Context)localObject1;
      if (j != 0)
      {
        localObject2 = localObject3 + arrayOfString[1] + ",";
        paramContext = localObject1 + "1,";
      }
      localObject3 = localObject2;
      localObject1 = paramContext;
      if (k != 0)
      {
        localObject3 = localObject2 + arrayOfString[2] + ",";
        localObject1 = paramContext + "2,";
      }
      localObject2 = localObject3;
      paramContext = (Context)localObject1;
      if (m != 0)
      {
        localObject2 = localObject3 + arrayOfString[3] + ",";
        paramContext = localObject1 + "3,";
      }
      localObject3 = localObject2;
      localObject1 = paramContext;
      if (n != 0)
      {
        localObject3 = localObject2 + arrayOfString[4] + ",";
        localObject1 = paramContext + "4,";
      }
      localObject2 = localObject3;
      paramContext = (Context)localObject1;
      if (i1 != 0)
      {
        localObject2 = localObject3 + arrayOfString[5] + ",";
        paramContext = localObject1 + "5,";
      }
      localObject3 = localObject2;
      localObject1 = paramContext;
      if (i2 != 0)
      {
        localObject3 = localObject2 + arrayOfString[6] + ",";
        localObject1 = paramContext + "6,";
      }
      localObject2 = localObject3;
      paramContext = (Context)localObject1;
      if (i3 != 0)
      {
        localObject2 = localObject3 + arrayOfString[7] + ",";
        paramContext = localObject1 + "7,";
      }
      this.alarmTypes = ((String)localObject2).substring(0, ((String)localObject2).length() - 1).split(",");
      this.alarmTypeId = paramContext.substring(0, paramContext.length() - 1).split(",");
      return;
      i = 0;
      break;
      j = 0;
      break label49;
      k = 0;
      break label62;
      m = 0;
      break label76;
      n = 0;
      break label90;
      i1 = 0;
      break label104;
      i2 = 0;
      break label119;
    }
  }
  
  public AlarmNotify addAlarm()
  {
    if (this.datas.size() < LibSharedPreferences.getInstance().getDeviceAlarmMaxCount())
    {
      AlarmNotify localAlarmNotify = new AlarmNotify();
      localAlarmNotify.setAlarmHour(7);
      localAlarmNotify.setAlarmMinute(30);
      localAlarmNotify.setAlarmRepetitions(62);
      localAlarmNotify.setAlarmId(getAlarmId());
      localAlarmNotify.setOpen(true);
      this.datas.add(localAlarmNotify);
      notifyDataSetChanged();
      return localAlarmNotify;
    }
    return null;
  }
  
  public int getAlarmId()
  {
    Collections.sort(this.datas);
    int i = 0;
    for (;;)
    {
      if (i >= this.datas.size()) {
        return i + 1;
      }
      if (((AlarmNotify)this.datas.get(i)).getAlarmId() != i + 1) {
        return i + 1;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.datas.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.datas.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final AlarmNotify localAlarmNotify;
    String[] arrayOfString1;
    String[] arrayOfString2;
    if (paramView == null)
    {
      paramViewGroup = new ViewHolder();
      paramView = this.inflater.inflate(2130903107, null);
      paramViewGroup.icon = ((ImageView)paramView.findViewById(2131231058));
      paramViewGroup.time = ((TextView)paramView.findViewById(2131230744));
      paramViewGroup.cycle = ((TextView)paramView.findViewById(2131231059));
      paramViewGroup.toggleBtn = ((CustomToggleButton)paramView.findViewById(2131231061));
      paramViewGroup.type = ((TextView)paramView.findViewById(2131231062));
      paramViewGroup.progress = ((ProgressBar)paramView.findViewById(2131230738));
      paramViewGroup.view = paramView.findViewById(2131231060);
      paramView.setTag(paramViewGroup);
      localAlarmNotify = (AlarmNotify)this.datas.get(paramInt);
      paramViewGroup.time.setText(Util.timeFormatter(localAlarmNotify.getAlarmHour() * 60 + localAlarmNotify.getAlarmMinute(), AppSharedPreferences.getInstance().is24TimeMode()));
      arrayOfString1 = new String[7];
      arrayOfString2 = paramView.getResources().getStringArray(2131361794);
      arrayOfString1[6] = arrayOfString2[0];
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt >= arrayOfString2.length)
      {
        paramViewGroup.cycle.setText(localAlarmNotify.getRepeat(arrayOfString2));
        paramViewGroup.toggleBtn.setSwitchState(localAlarmNotify.isOpen());
        paramViewGroup.icon.setImageResource(getImageIdByType(localAlarmNotify.getAlarmType()));
        paramViewGroup.view.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView) {}
        });
        paramViewGroup.toggleBtn.setOnSwitchListener(new CustomToggleButton.OnSwitchListener()
        {
          public void onSwitched(boolean paramAnonymousBoolean)
          {
            DebugLog.d("isSwitchOn = " + paramAnonymousBoolean);
            localAlarmNotify.setOpen(paramAnonymousBoolean);
            localAlarmNotify.hasModify = true;
            AlarmAdapter.this.alarmNotifyDao.update(localAlarmNotify);
          }
        });
        if (this.alarmTypes.length > 1) {
          paramViewGroup.type.setText(this.alarmTypes[localAlarmNotify.getAlarmType()]);
        }
        paramViewGroup.type.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView) {}
        });
        if ((!this.sendingData) || (!localAlarmNotify.hasModify)) {
          paramViewGroup.progress.setVisibility(8);
        }
        return paramView;
        paramViewGroup = (ViewHolder)paramView.getTag();
        break;
      }
      arrayOfString1[(paramInt - 1)] = arrayOfString2[paramInt];
      paramInt += 1;
    }
  }
  
  class ViewHolder
  {
    TextView cycle;
    ImageView icon;
    ProgressBar progress;
    TextView time;
    CustomToggleButton toggleBtn;
    TextView type;
    View view;
    
    ViewHolder() {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\adapter\AlarmAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */