package cn.sharesdk.system.email;

import android.os.Handler.Callback;
import android.os.Message;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

class c
  implements Handler.Callback
{
  int a = 0;
  
  c(b paramb, DeviceHelper paramDeviceHelper, String paramString, boolean paramBoolean, ActionListener paramActionListener) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = this.b.getTopTaskPackageName();
    if (!this.c.equals(paramMessage)) {
      if ((this.d) && (this.e != null)) {
        this.e.onComplete(new HashMap());
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\system\email\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */