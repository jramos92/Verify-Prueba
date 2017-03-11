package com.veryfit.multi.ui.activity.device;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.AlarmNotify;
import com.project.library.database.AlarmNotifyDao;
import com.project.library.database.DaoSession;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.veryfit.multi.ui.activity.BaseNotifyBleActivity;
import com.veryfit.multi.ui.adapter.AlarmAdapter;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.view.swipemenulistview.SwipeMenu;
import com.veryfit.multi.view.swipemenulistview.SwipeMenuCreator;
import com.veryfit.multi.view.swipemenulistview.SwipeMenuItem;
import com.veryfit.multi.view.swipemenulistview.SwipeMenuListView;
import com.veryfit.multi.view.swipemenulistview.SwipeMenuListView.OnMenuItemClickListener;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AlarmListActivity
  extends BaseNotifyBleActivity
{
  private AlarmAdapter adapter;
  private AlarmNotifyDao alarmNotifyDao;
  private List<AlarmNotify> alarms;
  private int currentModifyIndex;
  private ConcurrentLinkedQueue<AlarmNotify> mAlarmList = new ConcurrentLinkedQueue();
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private View v;
  
  private void cancelAlarm(AlarmNotify paramAlarmNotify)
  {
    this.sendingData = writeData(SettingsCmd.getInstance().getAlarmClockSettingsCmd(paramAlarmNotify));
    this.adapter.notifyDataSetChanged();
    if (!this.sendingData) {
      onDataSendFailed();
    }
  }
  
  private int dp2px(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
  }
  
  private void sendOneAlarm(AlarmNotify paramAlarmNotify)
  {
    this.sendingData = writeData(SettingsCmd.getInstance().getAlarmClockSettingsCmd(paramAlarmNotify));
    this.adapter.sendingData = this.sendingData;
    this.adapter.notifyDataSetChanged();
    if (!this.sendingData) {
      onDataSendFailed();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == 1) && (paramIntent != null))
    {
      AlarmNotify.copy((AlarmNotify)paramIntent.getParcelableExtra("alarm"), (AlarmNotify)this.alarms.get(this.currentModifyIndex));
      this.adapter.notifyDataSetChanged();
      DebugLog.d("requestCode = " + paramInt1 + "****resultCode = " + paramInt2 + "alarm = " + ((AlarmNotify)this.alarms.get(this.currentModifyIndex)).toString());
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131230914: 
      do
      {
        return;
        AlarmNotify localAlarmNotify = this.adapter.addAlarm();
        if (localAlarmNotify != null)
        {
          localAlarmNotify.hasModify = true;
          this.alarmNotifyDao.insert(localAlarmNotify);
        }
      } while (this.alarms.size() < LibSharedPreferences.getInstance().getDeviceAlarmMaxCount());
      paramView.setVisibility(8);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903043);
    super.onCreate(paramBundle);
    paramBundle = (SwipeMenuListView)findViewById(2131230739);
    this.v = LayoutInflater.from(this).inflate(2130903074, null);
    this.v.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(2131165186)));
    paramBundle.addFooterView(this.v);
    this.alarmNotifyDao = DBTool.getInstance().getDaoSession().getAlarmNotifyDao();
    this.alarms = TempUtil.getAlarms();
    this.adapter = new AlarmAdapter(this.alarms, this);
    paramBundle.setAdapter(this.adapter);
    if (this.alarms.size() >= LibSharedPreferences.getInstance().getDeviceAlarmMaxCount()) {
      this.v.setVisibility(8);
    }
    paramBundle.setMenuCreator(new SwipeMenuCreator()
    {
      public void create(SwipeMenu paramAnonymousSwipeMenu)
      {
        SwipeMenuItem localSwipeMenuItem = new SwipeMenuItem(AlarmListActivity.this.getApplicationContext());
        localSwipeMenuItem.setBackground(2130837624);
        localSwipeMenuItem.setWidth(AlarmListActivity.this.dp2px(90));
        localSwipeMenuItem.setIcon(2130837586);
        paramAnonymousSwipeMenu.addMenuItem(localSwipeMenuItem);
      }
    });
    paramBundle.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(int paramAnonymousInt1, SwipeMenu paramAnonymousSwipeMenu, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt2)
        {
        default: 
          return false;
        }
        paramAnonymousSwipeMenu = (AlarmNotify)AlarmListActivity.this.alarms.get(paramAnonymousInt1);
        paramAnonymousSwipeMenu.setOpen(false);
        AlarmListActivity.this.cancelAlarm(paramAnonymousSwipeMenu);
        AlarmListActivity.this.alarmNotifyDao.deleteByKey(Long.valueOf(paramAnonymousSwipeMenu.getAlarmId()));
        AlarmListActivity.this.alarms.remove(paramAnonymousSwipeMenu);
        paramAnonymousSwipeMenu.setAlarmStatus(170);
        AlarmListActivity.this.mAlarmList.add(paramAnonymousSwipeMenu);
        AlarmListActivity.this.v.setVisibility(0);
        AlarmListActivity.this.adapter.notifyDataSetChanged();
        return false;
      }
    });
    paramBundle.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AlarmListActivity.this.currentModifyIndex = paramAnonymousInt;
        if (paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt) != null)
        {
          paramAnonymousAdapterView = (AlarmNotify)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          paramAnonymousView = new Intent(AlarmListActivity.this, AlarmSetActivity.class);
          paramAnonymousView.putExtra("alarm", paramAnonymousAdapterView);
          AlarmListActivity.this.startActivityForResult(paramAnonymousView, 1);
        }
      }
    });
  }
  
  protected void onDataSendFailed()
  {
    Util.showToast(this, 2131296398, 0);
    this.adapter.sendingData = false;
    showSureBtn();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onSettingsSuccess()
  {
    AlarmNotify localAlarmNotify = (AlarmNotify)this.mAlarmList.poll();
    if (localAlarmNotify != null)
    {
      localAlarmNotify.hasModify = false;
      this.adapter.notifyDataSetChanged();
    }
    localAlarmNotify = (AlarmNotify)this.mAlarmList.peek();
    if (localAlarmNotify == null)
    {
      DebugLog.e("全部闹钟设置成功。");
      this.sendingData = false;
      this.mAlarmList.clear();
      finish();
      return;
    }
    sendOneAlarm(localAlarmNotify);
  }
  
  protected void onThemeChanged() {}
  
  protected void saveDate()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.alarms.size())
      {
        if (this.mAlarmList.isEmpty()) {
          break;
        }
        showProgress();
        this.mCore.addListener(this.mAppListener);
        sendOneAlarm((AlarmNotify)this.mAlarmList.peek());
        return;
      }
      AlarmNotify localAlarmNotify = (AlarmNotify)this.alarms.get(i);
      if (localAlarmNotify.hasModify)
      {
        this.alarmNotifyDao.update(localAlarmNotify);
        this.mAlarmList.add(localAlarmNotify);
      }
      i += 1;
    }
    finish();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\AlarmListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */