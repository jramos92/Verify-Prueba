package com.veryfit.multi.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.umeng.analytics.MobclickAgent;
import com.veryfit.multi.util.ActivityCollector;

public class LanguageChangeBroadcast
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.LOCALE_CHANGED"))
    {
      ActivityCollector.finishAll();
      MobclickAgent.onKillProcess(paramContext);
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\broadcast\LanguageChangeBroadcast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */