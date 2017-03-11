package cn.sharesdk.wechat.utils;

import android.os.Handler.Callback;
import android.os.Message;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

class l
  implements Handler.Callback
{
  int a = 0;
  
  l(WechatHelper paramWechatHelper, DeviceHelper paramDeviceHelper, String paramString, PlatformActionListener paramPlatformActionListener, Platform paramPlatform, HashMap paramHashMap) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = this.b.getTopTaskPackageName();
    if (!this.c.equals(paramMessage)) {
      if (this.d != null) {
        this.d.onComplete(this.e, 9, this.f);
      }
    }
    for (;;)
    {
      return true;
      if (this.a < 5)
      {
        this.a += 1;
        UIHandler.sendEmptyMessageDelayed(0, 500L, this);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */