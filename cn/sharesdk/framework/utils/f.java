package cn.sharesdk.framework.utils;

import android.content.Context;
import android.os.Process;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class f
{
  public static void a(Context paramContext)
  {
    try
    {
      paramContext = new File(R.getCachePath(paramContext, paramContext.getPackageName()), ".lock");
      if (!paramContext.getParentFile().exists()) {
        paramContext.getParentFile().mkdirs();
      }
      paramContext = new RandomAccessFile(paramContext, "rw");
      MappedByteBuffer localMappedByteBuffer = paramContext.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 1024L);
      localMappedByteBuffer.position(0);
      localMappedByteBuffer.putInt(Process.myPid());
      paramContext.close();
      return;
    }
    catch (Throwable paramContext)
    {
      d.a().w(paramContext);
    }
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      paramContext = new File(R.getCachePath(paramContext, paramContext.getPackageName()), ".lock");
      if (!paramContext.getParentFile().exists()) {
        paramContext.getParentFile().mkdirs();
      }
      paramContext = new RandomAccessFile(paramContext, "r");
      MappedByteBuffer localMappedByteBuffer = paramContext.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, 1024L);
      localMappedByteBuffer.position(0);
      i = localMappedByteBuffer.getInt();
      d.a().w(paramContext);
    }
    catch (Throwable paramContext)
    {
      try
      {
        paramContext.close();
        return i;
      }
      catch (Throwable paramContext)
      {
        int i;
        for (;;) {}
      }
      paramContext = paramContext;
      i = 0;
    }
    return i;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */