package cn.sharesdk.instagram;

import android.os.Message;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.UIHandler;

class g
  extends Thread
{
  g(f paramf) {}
  
  public void run()
  {
    Message localMessage = new Message();
    try
    {
      localMessage.arg1 = 1;
      localMessage.obj = BitmapHelper.downloadBitmap(f.a(this.a), f.b(this.a));
      UIHandler.sendMessage(localMessage, this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localMessage.obj = localThrowable;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\instagram\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */