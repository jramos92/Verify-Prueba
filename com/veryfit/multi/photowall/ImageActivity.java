package com.veryfit.multi.photowall;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.veryfit.multi.camera.GalleryUtil;
import com.veryfit.multi.camera.PhotoWallAdapter;
import com.veryfit.multi.camera.ScreenUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageActivity
  extends Activity
{
  public static boolean[] barray;
  public static boolean isMulChoice = false;
  public static boolean visiblecheck = false;
  private PhotoWallAdapter adapter;
  private List<String> list;
  private GridView mPhotoWall;
  private Resources res;
  private RelativeLayout rl_title;
  private TextView tittle_left;
  private TextView tittle_right;
  private TextView tv_delete;
  
  private ArrayList<String> getSelectImagePaths()
  {
    Object localObject;
    if ((this.list == null) || (this.list.size() <= 0))
    {
      localObject = null;
      return (ArrayList<String>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= this.list.size()) {
        break;
      }
      if (barray[i] != 0) {
        localArrayList.add((String)this.list.get(i));
      }
      i += 1;
    }
  }
  
  private void noSelectAll()
  {
    if ((this.list == null) || (this.list.size() <= 0)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= barray.length)
      {
        this.adapter.notifyDataSetChanged();
        return;
      }
      barray[i] = false;
      i += 1;
    }
  }
  
  private void selectAll()
  {
    if ((this.list == null) || (this.list.size() <= 0)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= barray.length)
      {
        this.adapter.notifyDataSetChanged();
        return;
      }
      barray[i] = true;
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903063);
    this.res = getResources();
    ScreenUtils.initScreen(this);
    this.tittle_left = ((TextView)findViewById(2131230741));
    this.tittle_right = ((TextView)findViewById(2131230737));
    this.rl_title = ((RelativeLayout)findViewById(2131230762));
    this.tv_delete = ((TextView)findViewById(2131230856));
    this.mPhotoWall = ((GridView)findViewById(2131230855));
    this.list = Images.getImages();
    int i;
    if ((this.list != null) && (this.list.size() != 0))
    {
      barray = new boolean[this.list.size()];
      i = 0;
    }
    for (;;)
    {
      if (i >= this.list.size())
      {
        this.adapter = new PhotoWallAdapter(this, this.list, barray);
        this.mPhotoWall.setAdapter(this.adapter);
        this.tv_delete.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = ImageActivity.this.getSelectImagePaths();
            if ((paramAnonymousView == null) || (paramAnonymousView.size() <= 0)) {
              return;
            }
            Iterator localIterator = paramAnonymousView.iterator();
            for (;;)
            {
              if (!localIterator.hasNext())
              {
                ImageActivity.this.list.removeAll(paramAnonymousView);
                ImageActivity.this.noSelectAll();
                ImageActivity.this.adapter.updateUI(ImageActivity.this.list);
                ImageActivity.isMulChoice = false;
                ImageActivity.visiblecheck = false;
                ImageActivity.this.tv_delete.setVisibility(8);
                ImageActivity.this.tittle_left.setText(2131296622);
                return;
              }
              String str = (String)localIterator.next();
              if (ImageActivity.this.list.contains(str)) {
                GalleryUtil.deleteImage(ImageActivity.this, str);
              }
            }
          }
        });
        this.mPhotoWall.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (!ImageActivity.isMulChoice)
            {
              paramAnonymousAdapterView = new Intent(ImageActivity.this, ImageDetailsActivity.class);
              paramAnonymousAdapterView.putExtra("image_position", paramAnonymousInt);
              ImageActivity.this.startActivity(paramAnonymousAdapterView);
            }
          }
        });
        this.mPhotoWall.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            ImageActivity.this.tittle_left.setText(2131296394);
            if (ImageActivity.isMulChoice) {
              return true;
            }
            ImageActivity.isMulChoice = true;
            if (ImageActivity.isMulChoice)
            {
              ImageActivity.barray[paramAnonymousInt] = true;
              ImageActivity.this.rl_title.setVisibility(0);
              ImageActivity.this.tv_delete.setVisibility(0);
              ImageActivity.visiblecheck = true;
              ImageActivity.this.adapter.notifyDataSetChanged();
              return true;
            }
            ImageActivity.this.rl_title.setVisibility(8);
            ImageActivity.this.tv_delete.setVisibility(8);
            ImageActivity.visiblecheck = false;
            ImageActivity.isMulChoice = false;
            paramAnonymousInt = 0;
            for (;;)
            {
              if (paramAnonymousInt >= ImageActivity.this.list.size())
              {
                ImageActivity.this.adapter.notifyDataSetChanged();
                return true;
              }
              ImageActivity.barray[paramAnonymousInt] = false;
              paramAnonymousInt += 1;
            }
          }
        });
        this.tittle_left.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (ImageActivity.isMulChoice)
            {
              ImageActivity.visiblecheck = false;
              ImageActivity.isMulChoice = false;
              i = 0;
              for (;;)
              {
                if (i >= ImageActivity.this.list.size())
                {
                  ImageActivity.this.adapter.notifyDataSetChanged();
                  ImageActivity.this.tittle_left.setText(2131296622);
                  ImageActivity.this.tv_delete.setVisibility(8);
                  return;
                }
                ImageActivity.barray[i] = false;
                i += 1;
              }
            }
            int i = 0;
            for (;;)
            {
              if (i >= ImageActivity.this.list.size())
              {
                ImageActivity.this.finish();
                return;
              }
              ImageActivity.barray[i] = false;
              i += 1;
            }
          }
        });
        this.tittle_right.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (ImageActivity.this.tittle_right.getText().toString().trim().equals(ImageActivity.this.res.getString(2131296623)))
            {
              ImageActivity.visiblecheck = true;
              ImageActivity.isMulChoice = true;
              ImageActivity.this.selectAll();
              ImageActivity.this.tittle_right.setText(ImageActivity.this.res.getString(2131296624));
              ImageActivity.this.tv_delete.setVisibility(0);
              return;
            }
            ImageActivity.visiblecheck = false;
            ImageActivity.isMulChoice = false;
            ImageActivity.this.noSelectAll();
            ImageActivity.this.tittle_right.setText(ImageActivity.this.res.getString(2131296623));
            ImageActivity.this.tv_delete.setVisibility(8);
          }
        });
        return;
      }
      barray[i] = false;
      i += 1;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    visiblecheck = false;
    isMulChoice = false;
  }
  
  protected void onPause()
  {
    super.onPause();
    noSelectAll();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.list = Images.getImages();
    if ((this.list == null) || (this.list.size() <= 0))
    {
      Toast.makeText(this, 2131296621, 0).show();
      this.tittle_right.setVisibility(8);
      this.mPhotoWall.setVisibility(4);
      return;
    }
    this.adapter.updateUI(this.list);
    this.tittle_right.setVisibility(0);
    this.mPhotoWall.setVisibility(0);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\photowall\ImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */