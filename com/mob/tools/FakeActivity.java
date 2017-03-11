package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;
import com.mob.tools.utils.UIHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FakeActivity
{
  private static Class<? extends Activity> shellClass;
  protected Activity activity;
  private View contentView;
  private HashMap<String, Object> result;
  private FakeActivity resultReceiver;
  
  public static void registerExecutor(String paramString, Object paramObject)
  {
    if (shellClass != null) {
      try
      {
        Method localMethod = shellClass.getMethod("registerExecutor", new Class[] { String.class, Object.class });
        localMethod.setAccessible(true);
        localMethod.invoke(null, new Object[] { paramString, paramObject });
        return;
      }
      catch (Throwable paramString)
      {
        MobLog.getInstance().w(paramString);
        return;
      }
    }
    MobUIShell.registerExecutor(paramString, paramObject);
  }
  
  public static void setShell(Class<? extends Activity> paramClass)
  {
    shellClass = paramClass;
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    if (this.activity == null) {
      return null;
    }
    return this.activity.findViewById(paramInt);
  }
  
  public <T extends View> T findViewByResName(View paramView, String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return null;
      i = R.getIdRes(this.activity, paramString);
    } while (i <= 0);
    return paramView.findViewById(i);
  }
  
  public <T extends View> T findViewByResName(String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return null;
      i = R.getIdRes(this.activity, paramString);
    } while (i <= 0);
    return findViewById(i);
  }
  
  public final void finish()
  {
    if (this.activity != null) {
      this.activity.finish();
    }
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public Context getContext()
  {
    return this.activity;
  }
  
  public int getOrientation()
  {
    return this.activity.getResources().getConfiguration().orientation;
  }
  
  public FakeActivity getParent()
  {
    return this.resultReceiver;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public boolean onFinish()
  {
    return false;
  }
  
  public boolean onKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onRestart() {}
  
  public void onResult(HashMap<String, Object> paramHashMap) {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void requestFullScreen(boolean paramBoolean)
  {
    if (this.activity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.activity.getWindow().addFlags(1024);
      this.activity.getWindow().clearFlags(2048);
    }
    for (;;)
    {
      this.activity.getWindow().getDecorView().requestLayout();
      return;
      this.activity.getWindow().addFlags(2048);
      this.activity.getWindow().clearFlags(1024);
    }
  }
  
  public void requestLandscapeOrientation()
  {
    setRequestedOrientation(0);
  }
  
  public void requestPortraitOrientation()
  {
    setRequestedOrientation(1);
  }
  
  public void runOnUIThread(final Runnable paramRunnable)
  {
    UIHandler.sendEmptyMessage(0, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        paramRunnable.run();
        return false;
      }
    });
  }
  
  public void runOnUIThread(final Runnable paramRunnable, long paramLong)
  {
    UIHandler.sendEmptyMessageDelayed(0, paramLong, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        paramRunnable.run();
        return false;
      }
    });
  }
  
  public void sendResult()
  {
    if (this.resultReceiver != null) {
      this.resultReceiver.onResult(this.result);
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public void setContentViewLayoutResName(String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return;
      i = R.getLayoutRes(this.activity, paramString);
    } while (i <= 0);
    this.activity.setContentView(i);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (this.activity == null) {
      return;
    }
    this.activity.setRequestedOrientation(paramInt);
  }
  
  public final void setResult(HashMap<String, Object> paramHashMap)
  {
    this.result = paramHashMap;
  }
  
  public void show(Context paramContext, Intent paramIntent)
  {
    showForResult(paramContext, paramIntent, null);
  }
  
  public void showForResult(Context paramContext, Intent paramIntent, FakeActivity paramFakeActivity)
  {
    this.resultReceiver = paramFakeActivity;
    Message localMessage = new Message();
    paramFakeActivity = null;
    Intent localIntent;
    if (shellClass != null) {
      localIntent = new Intent(paramContext, shellClass);
    }
    for (;;)
    {
      try
      {
        Object localObject = shellClass.getMethod("registerExecutor", new Class[] { Object.class });
        ((Method)localObject).setAccessible(true);
        localObject = (String)((Method)localObject).invoke(null, new Object[] { this });
        paramFakeActivity = (FakeActivity)localObject;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
        continue;
      }
      localIntent.putExtra("launch_time", paramFakeActivity);
      localIntent.putExtra("executor_name", getClass().getName());
      if (paramIntent != null) {
        localIntent.putExtras(paramIntent);
      }
      localMessage.obj = new Object[] { paramContext, localIntent };
      UIHandler.sendMessage(localMessage, new Handler.Callback()
      {
        public boolean handleMessage(Message paramAnonymousMessage)
        {
          Object localObject = (Object[])paramAnonymousMessage.obj;
          paramAnonymousMessage = (Context)localObject[0];
          localObject = (Intent)localObject[1];
          if (!(paramAnonymousMessage instanceof Activity)) {
            ((Intent)localObject).addFlags(268435456);
          }
          paramAnonymousMessage.startActivity((Intent)localObject);
          return false;
        }
      });
      return;
      localIntent = new Intent(paramContext, MobUIShell.class);
      paramFakeActivity = MobUIShell.registerExecutor(this);
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivityForResult(paramIntent, -1);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.activity == null) {
      return;
    }
    this.activity.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\FakeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */