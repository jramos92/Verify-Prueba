package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;

class c
  implements View.OnClickListener
{
  c(RegisterView paramRegisterView) {}
  
  public void onClick(View paramView)
  {
    try
    {
      int i = R.getStringRes(paramView.getContext(), "ssdk_website");
      Object localObject = null;
      if (i > 0) {
        localObject = paramView.getResources().getString(i);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
        paramView.getContext().startActivity((Intent)localObject);
      }
      return;
    }
    catch (Throwable paramView)
    {
      d.a().w(paramView);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */