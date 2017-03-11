package cn.sharesdk.tencent.qq;

import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;

class j
  extends Thread
{
  j(i parami, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    try
    {
      str = BitmapHelper.downloadBitmap(i.a(this.h), this.a);
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          String str;
          i.a(this.h, this.b, this.c, this.d, this.a, str, this.e, this.f, this.g);
          return;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject;
          d.a().w(localThrowable2);
        }
        localThrowable1 = localThrowable1;
        d.a().w(localThrowable1);
        localObject = null;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */