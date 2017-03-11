package com.veryfit.multi.ui.activity.device;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.vo.RingtoneInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingtoneActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView bar_left;
  private String curName;
  private int curPosition;
  private String curUri;
  private ListView lv_ring;
  private RingtoneAdapter mAdapter;
  private MediaPlayer mMediaPlayer;
  private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      RingtoneActivity.this.curPosition = paramAnonymousInt;
      RingtoneActivity.this.curName = ((RingtoneInfo)RingtoneActivity.this.mAdapter.getItem(paramAnonymousInt)).name;
      RingtoneActivity.this.curUri = ((RingtoneInfo)RingtoneActivity.this.mAdapter.getItem(paramAnonymousInt)).uri;
      new RingtoneActivity.ViewHolder(paramAnonymousAdapterView).iv.setClickable(false);
      RingtoneActivity.this.mAdapter.map.clear();
      RingtoneActivity.this.mAdapter.map.put(Integer.valueOf(paramAnonymousInt), Boolean.valueOf(true));
      RingtoneActivity.this.mAdapter.notifyDataSetChanged();
      try
      {
        paramAnonymousAdapterView = new RingtoneManager(RingtoneActivity.this);
        paramAnonymousAdapterView.setStopPreviousRingtone(true);
        paramAnonymousAdapterView.setType(2);
        paramAnonymousAdapterView.getCursor();
        paramAnonymousAdapterView.getRingtone(paramAnonymousInt).play();
        return;
      }
      catch (Exception paramAnonymousAdapterView)
      {
        paramAnonymousAdapterView.printStackTrace();
      }
    }
  };
  private RingtoneManager rm;
  private AppSharedPreferences share = AppSharedPreferences.getInstance();
  private TextView tittle_right;
  private TextView tv_none;
  
  protected void initView()
  {
    this.bar_left = ((ImageView)findViewById(2131230729));
    this.bar_left.setOnClickListener(this);
    this.lv_ring = ((ListView)findViewById(2131230873));
    this.tittle_right = ((TextView)findViewById(2131230737));
    this.tittle_right.setOnClickListener(this);
    this.tv_none = ((TextView)findViewById(2131230872));
    this.tv_none.setOnClickListener(this);
    this.mAdapter = new RingtoneAdapter(this, this.share.getRingtoneIndex());
    this.lv_ring.setAdapter(this.mAdapter);
    this.lv_ring.setOnItemClickListener(this.mOnItemClickListener);
    super.initView();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230729: 
      finish();
      return;
    case 2131230737: 
      this.share.setRingtoneIndex(this.curPosition);
      this.share.setRingtoneName(this.curName);
      this.share.setRingtoneUrl(this.curUri);
      finish();
      return;
    }
    this.share.setRingtoneIndex(-1);
    this.share.setRingtoneName(getResources().getString(2131296645));
    this.share.setRingtoneUrl("");
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903068);
    super.onCreate(paramBundle);
  }
  
  protected void onThemeChanged() {}
  
  public class RingtoneAdapter
    extends BaseAdapter
  {
    public boolean firstItemState = true;
    private int index;
    Context mContext;
    public Map<Integer, Boolean> map = new HashMap();
    private List<RingtoneInfo> ringList;
    
    public RingtoneAdapter(Context paramContext, int paramInt)
    {
      this.mContext = paramContext;
      this.index = paramInt;
      if (this.firstItemState)
      {
        this.firstItemState = false;
        this.map.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
      }
      getRing();
    }
    
    public int getCount()
    {
      return this.ringList.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.ringList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public void getRing()
    {
      this.ringList = new ArrayList();
      RingtoneActivity.this.rm = new RingtoneManager(this.mContext);
      RingtoneActivity.this.rm.setType(2);
      Cursor localCursor = RingtoneActivity.this.rm.getCursor();
      if (localCursor.moveToFirst()) {
        do
        {
          RingtoneInfo localRingtoneInfo = new RingtoneInfo(localCursor.getInt(0), localCursor.getString(1), localCursor.getString(2) + "/" + localCursor.getInt(0));
          this.ringList.add(localRingtoneInfo);
        } while (localCursor.moveToNext());
      }
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ImageView localImageView;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(2130903111, null);
        paramViewGroup = new RingtoneActivity.ViewHolder(paramView);
        paramView.setTag(paramViewGroup);
        localImageView = paramViewGroup.iv;
        if (this.map.get(Integer.valueOf(paramInt)) != null) {
          break label101;
        }
      }
      label101:
      for (int i = 8;; i = 0)
      {
        localImageView.setVisibility(i);
        paramViewGroup.ringtone_name.setText(((RingtoneInfo)this.ringList.get(paramInt)).name);
        return paramView;
        paramViewGroup = (RingtoneActivity.ViewHolder)paramView.getTag();
        break;
      }
    }
  }
  
  public static class ViewHolder
  {
    ImageView iv;
    TextView ringtone_name;
    TextView ringtone_time;
    
    public ViewHolder(View paramView)
    {
      this.ringtone_name = ((TextView)paramView.findViewById(2131231073));
      this.ringtone_time = ((TextView)paramView.findViewById(2131231074));
      this.iv = ((ImageView)paramView.findViewById(2131231075));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\RingtoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */