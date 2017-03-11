package com.veryfit.multi.ui.activity.device;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.util.DebugLog;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;

public class HeartRateAutoDetectActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener, View.OnClickListener
{
  private Activity activity;
  private AutoDetectAdapter adapter = null;
  private ListView auto_detect_lv;
  private LinearLayout auto_detect_progress_circle;
  private RelativeLayout auto_detect_rl;
  private int auto_or_minual_cmd = 3;
  private View bar_left;
  private boolean isChecked = false;
  private String[] lists;
  protected APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    int waitTime = 0;
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      DebugLog.e("发送指令：" + paramAnonymousByte);
      if ((paramAnonymousByte == 37) && (paramAnonymousBoolean))
      {
        this.waitTime = 1000;
        HeartRateAutoDetectActivity.this.tittle_right.setVisibility(8);
        HeartRateAutoDetectActivity.this.auto_detect_progress_circle.setVisibility(0);
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            HeartRateAutoDetectActivity.this.activity.finish();
          }
        }, this.waitTime);
      }
    }
  };
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private View tittle_right;
  
  protected void initData()
  {
    this.mCore.addListener(this.mAppListener);
    this.lists = getResources().getStringArray(2131361802);
    this.adapter = new AutoDetectAdapter(this.activity, this.lists);
    this.adapter.equalStr = this.lists[AppSharedPreferences.getInstance().getDeviceHeartRateAutoDetectValue()];
    DebugLog.e("保存的心率检测值为：" + AppSharedPreferences.getInstance().getDeviceHeartRateAutoDetectValue());
    if (!this.adapter.equalStr.equals("")) {
      this.isChecked = true;
    }
    this.auto_detect_lv.setAdapter(this.adapter);
  }
  
  protected void initEvent()
  {
    this.auto_detect_lv.setOnItemClickListener(this);
  }
  
  protected void initView()
  {
    setContentView(2130903045);
    this.activity = this;
    this.auto_detect_rl = ((RelativeLayout)findViewById(2131230746));
    this.auto_detect_lv = ((ListView)findViewById(2131230747));
    this.bar_left = findViewById(2131230729);
    this.bar_left.setOnClickListener(this);
    this.tittle_right = findViewById(2131230737);
    this.tittle_right.setOnClickListener(this);
    this.auto_detect_progress_circle = ((LinearLayout)findViewById(2131230738));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      this.activity.finish();
      return;
    } while (!this.mCore.isDeviceConnected());
    this.mCore.writeForce(SettingsCmd.getInstance().getHeartModeCmd(this.auto_or_minual_cmd));
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.tittle_right.setVisibility(0);
    this.isChecked = true;
    switch (paramInt)
    {
    default: 
      DebugLog.e("equalStr:" + this.adapter.equalStr);
      paramAdapterView = AppSharedPreferences.getInstance();
      if (this.adapter.equalStr != this.lists[0]) {
        break;
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      paramAdapterView.setDeviceHeartRateAutoDetectValue(paramInt);
      this.adapter.notifyDataSetChanged();
      return;
      this.adapter.equalStr = ((String)paramAdapterView.getItemAtPosition(paramInt));
      this.auto_or_minual_cmd = 3;
      break;
      this.adapter.equalStr = ((String)paramAdapterView.getItemAtPosition(paramInt));
      this.auto_or_minual_cmd = 1;
      break;
    }
  }
  
  protected void onThemeChanged() {}
  
  class AutoDetectAdapter
    extends BaseAdapter
  {
    private Context context;
    private String equalStr = "";
    private String[] lists;
    
    public AutoDetectAdapter(Context paramContext, String[] paramArrayOfString)
    {
      this.context = paramContext;
      this.lists = paramArrayOfString;
    }
    
    public int getCount()
    {
      if (this.lists == null) {
        return 0;
      }
      return this.lists.length;
    }
    
    public Object getItem(int paramInt)
    {
      return this.lists[paramInt];
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2130903075, null);
        paramViewGroup = (TextView)paramView.findViewById(2131230915);
        localObject = (ImageView)paramView.findViewById(2131230916);
        paramView.setTag(new HeartRateAutoDetectActivity.ViewHolder(HeartRateAutoDetectActivity.this, paramViewGroup, (ImageView)localObject));
      }
      for (;;)
      {
        String str = (String)getItem(paramInt);
        paramViewGroup.setText(str);
        DebugLog.e("equalStr:" + this.equalStr + ",str:" + str);
        ((ImageView)localObject).setVisibility(8);
        if ((this.equalStr.equals(str)) && (HeartRateAutoDetectActivity.this.isChecked)) {
          ((ImageView)localObject).setVisibility(0);
        }
        return paramView;
        localObject = (HeartRateAutoDetectActivity.ViewHolder)paramView.getTag();
        paramViewGroup = ((HeartRateAutoDetectActivity.ViewHolder)localObject).auto_str;
        localObject = ((HeartRateAutoDetectActivity.ViewHolder)localObject).check;
      }
    }
  }
  
  class ViewHolder
  {
    TextView auto_str;
    ImageView check;
    
    public ViewHolder(TextView paramTextView, ImageView paramImageView)
    {
      this.check = paramImageView;
      this.auto_str = paramTextView;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\HeartRateAutoDetectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */