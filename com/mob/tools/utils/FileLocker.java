package com.mob.tools.utils;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class FileLocker
{
  private FileOutputStream fos;
  private FileLock lock;
  
  public boolean lock()
  {
    try
    {
      boolean bool = lock(false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean lock(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +9 -> 19
    //   13: iload_2
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: iload_1
    //   20: ifeq +33 -> 53
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   28: invokevirtual 27	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   31: invokevirtual 32	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   34: putfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   37: aload_0
    //   38: getfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   41: astore_3
    //   42: iload_2
    //   43: istore_1
    //   44: aload_3
    //   45: ifnull -30 -> 15
    //   48: iconst_1
    //   49: istore_1
    //   50: goto -35 -> 15
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   58: invokevirtual 27	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   61: invokevirtual 37	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   64: putfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   67: goto -30 -> 37
    //   70: astore_3
    //   71: aload_0
    //   72: getfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull -40 -> 37
    //   80: aload_0
    //   81: getfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   84: invokevirtual 42	java/nio/channels/FileLock:release	()V
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   92: goto -55 -> 37
    //   95: astore_3
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_3
    //   99: athrow
    //   100: astore_3
    //   101: goto -14 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	FileLocker
    //   0	104	1	paramBoolean	boolean
    //   1	42	2	bool	boolean
    //   8	37	3	localObject1	Object
    //   70	1	3	localThrowable1	Throwable
    //   75	2	3	localFileLock	FileLock
    //   95	4	3	localObject2	Object
    //   100	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   23	37	70	java/lang/Throwable
    //   53	67	70	java/lang/Throwable
    //   4	9	95	finally
    //   23	37	95	finally
    //   37	42	95	finally
    //   53	67	95	finally
    //   71	76	95	finally
    //   80	87	95	finally
    //   87	92	95	finally
    //   80	87	100	java/lang/Throwable
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 45	com/mob/tools/utils/FileLocker:unlock	()V
    //   18: aload_0
    //   19: getfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   22: invokevirtual 48	java/io/FileOutputStream:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   30: goto -19 -> 11
    //   33: astore_1
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	FileLocker
    //   6	2	1	localFileOutputStream	FileOutputStream
    //   33	1	1	localThrowable	Throwable
    //   37	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	30	33	java/lang/Throwable
    //   2	7	37	finally
    //   14	18	37	finally
    //   18	30	37	finally
  }
  
  /* Error */
  public void setLockFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new 23	java/io/FileOutputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 52	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: putfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull -10 -> 14
    //   27: aload_0
    //   28: getfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   31: invokevirtual 48	java/io/FileOutputStream:close	()V
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 21	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   39: goto -25 -> 14
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: goto -14 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	FileLocker
    //   0	51	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	17	java/lang/Throwable
    //   2	14	42	finally
    //   18	23	42	finally
    //   27	34	42	finally
    //   34	39	42	finally
    //   27	34	47	java/lang/Throwable
  }
  
  /* Error */
  public void unlock()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   18: invokevirtual 42	java/nio/channels/FileLock:release	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 34	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: goto -19 -> 11
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	FileLocker
    //   6	2	1	localFileLock	FileLock
    //   29	1	1	localThrowable	Throwable
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	26	29	java/lang/Throwable
    //   2	7	33	finally
    //   14	26	33	finally
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\FileLocker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */