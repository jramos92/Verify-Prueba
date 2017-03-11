package com.mob.tools.virtualdisk;

import android.os.MemoryFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Iterator;

public class MemDisk
  extends VirtualDisk
{
  private static final int BLOCK_SIZE = 1024;
  private static final int NODE_SIZE = 8;
  private byte[] buff;
  private int dataOffset;
  private MemoryFile mf;
  
  protected void addFileToDirectory(int paramInt1, String paramString, int paramInt2)
    throws Throwable
  {
    byte[] arrayOfByte = readDirectoryData(paramInt1);
    DataOutputStream localDataOutputStream = new DataOutputStream(new MDFileOutputStream(this, paramInt1));
    if (arrayOfByte == null) {
      localDataOutputStream.writeInt(1);
    }
    for (;;)
    {
      localDataOutputStream.writeUTF(paramString);
      localDataOutputStream.writeInt(paramInt2);
      localDataOutputStream.close();
      return;
      DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte));
      paramInt1 = localDataInputStream.readInt();
      localDataInputStream.close();
      localDataOutputStream.writeInt(paramInt1 + 1);
      localDataOutputStream.write(arrayOfByte, 4, arrayOfByte.length - 4);
    }
  }
  
  public void close()
    throws Throwable
  {
    try
    {
      this.mf.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void create(int paramInt)
    throws Throwable
  {
    try
    {
      this.mf = new MemoryFile(System.currentTimeMillis() + ".md", paramInt);
      this.dataOffset = (paramInt / 1032 * 8);
      this.buff = new byte['Ѐ'];
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void dumpToFile(String paramString)
    throws Throwable
  {
    try
    {
      dumpToFile(paramString, false);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void dumpToFile(String paramString, boolean paramBoolean)
    throws Throwable
  {
    for (;;)
    {
      Object localObject;
      MappedByteBuffer localMappedByteBuffer;
      int j;
      try
      {
        localObject = new File(paramString);
        if (((File)localObject).exists())
        {
          if (paramBoolean) {
            ((File)localObject).delete();
          }
        }
        else
        {
          if (!((File)localObject).getParentFile().exists()) {
            ((File)localObject).getParentFile().mkdirs();
          }
          ((File)localObject).createNewFile();
          paramString = new RandomAccessFile(paramString, "rw");
          localObject = paramString.getChannel();
          localMappedByteBuffer = ((FileChannel)localObject).map(FileChannel.MapMode.READ_WRITE, 0L, 4L);
          localMappedByteBuffer.order(ByteOrder.BIG_ENDIAN);
          localMappedByteBuffer.putInt(this.mf.length());
          localMappedByteBuffer.force();
          localMappedByteBuffer = ((FileChannel)localObject).map(FileChannel.MapMode.READ_WRITE, 4L, this.dataOffset);
          byte[] arrayOfByte = new byte[this.dataOffset];
          IOUtils.readRaw(0, this.mf, arrayOfByte);
          localMappedByteBuffer.put(arrayOfByte);
          localMappedByteBuffer.force();
          j = 0;
          i = 0;
          if (i >= this.dataOffset) {
            break label236;
          }
          if (IOUtils.readByte(i, this.mf, this.buff) == 0) {
            break label328;
          }
          j = i;
          break label328;
        }
        throw new Throwable("file \"" + paramString + "\" already exists");
      }
      finally {}
      label236:
      int i = 0;
      j /= 8;
      while (i <= j)
      {
        localMappedByteBuffer = ((FileChannel)localObject).map(FileChannel.MapMode.READ_WRITE, this.dataOffset + 4 + i * 1024, 1024L);
        IOUtils.readRaw(this.dataOffset + i * 1024, this.mf, this.buff);
        localMappedByteBuffer.put(this.buff);
        localMappedByteBuffer.force();
        i += 1;
      }
      paramString.close();
      return;
      label328:
      i += 8;
    }
  }
  
  public void format()
    throws Throwable
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte = new byte[8];
      while (i < this.dataOffset)
      {
        IOUtils.writeRaw(i, arrayOfByte, 0, arrayOfByte.length, this.mf);
        i += 8;
      }
      IOUtils.writeByte(0, (byte)1, this.mf, this.buff);
      return;
    }
    finally {}
  }
  
  /* Error */
  public InputStream getInputStream(String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 226	com/mob/tools/virtualdisk/MemDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokevirtual 230	com/mob/tools/virtualdisk/MemDisk:pathToId	(Ljava/lang/String;)I
    //   13: istore_2
    //   14: iload_2
    //   15: iconst_m1
    //   16: if_icmpne +9 -> 25
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_3
    //   26: astore_1
    //   27: iload_2
    //   28: bipush 8
    //   30: imul
    //   31: iconst_1
    //   32: iadd
    //   33: aload_0
    //   34: getfield 34	com/mob/tools/virtualdisk/MemDisk:mf	Landroid/os/MemoryFile;
    //   37: aload_0
    //   38: getfield 38	com/mob/tools/virtualdisk/MemDisk:buff	[B
    //   41: invokestatic 203	com/mob/tools/virtualdisk/MemDisk$IOUtils:readByte	(ILandroid/os/MemoryFile;[B)B
    //   44: ifeq -23 -> 21
    //   47: new 11	com/mob/tools/virtualdisk/MemDisk$MDFileInputStream
    //   50: dup
    //   51: aload_0
    //   52: iload_2
    //   53: aconst_null
    //   54: invokespecial 233	com/mob/tools/virtualdisk/MemDisk$MDFileInputStream:<init>	(Lcom/mob/tools/virtualdisk/MemDisk;ILcom/mob/tools/virtualdisk/MemDisk$1;)V
    //   57: astore_1
    //   58: goto -37 -> 21
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	MemDisk
    //   0	66	1	paramString	String
    //   13	40	2	i	int
    //   1	25	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	61	finally
    //   27	58	61	finally
  }
  
  /* Error */
  public OutputStream getOutputStream(String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 226	com/mob/tools/virtualdisk/MemDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokevirtual 230	com/mob/tools/virtualdisk/MemDisk:pathToId	(Ljava/lang/String;)I
    //   13: istore_2
    //   14: iload_2
    //   15: iconst_m1
    //   16: if_icmpne +9 -> 25
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_3
    //   26: astore_1
    //   27: iload_2
    //   28: bipush 8
    //   30: imul
    //   31: iconst_1
    //   32: iadd
    //   33: aload_0
    //   34: getfield 34	com/mob/tools/virtualdisk/MemDisk:mf	Landroid/os/MemoryFile;
    //   37: aload_0
    //   38: getfield 38	com/mob/tools/virtualdisk/MemDisk:buff	[B
    //   41: invokestatic 203	com/mob/tools/virtualdisk/MemDisk$IOUtils:readByte	(ILandroid/os/MemoryFile;[B)B
    //   44: ifeq -23 -> 21
    //   47: new 14	com/mob/tools/virtualdisk/MemDisk$MDFileOutputStream
    //   50: dup
    //   51: aload_0
    //   52: iload_2
    //   53: invokespecial 55	com/mob/tools/virtualdisk/MemDisk$MDFileOutputStream:<init>	(Lcom/mob/tools/virtualdisk/MemDisk;I)V
    //   56: astore_1
    //   57: goto -36 -> 21
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	MemDisk
    //   0	65	1	paramString	String
    //   13	40	2	i	int
    //   1	25	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	60	finally
    //   27	57	60	finally
  }
  
  public boolean isFile(String paramString)
    throws Throwable
  {
    try
    {
      paramString = fixSlashes(paramString);
      i = pathToId(paramString);
      if (i == -1) {
        throw new Throwable("file \"" + paramString + "\" does not exist");
      }
    }
    finally {}
    int i = IOUtils.readByte(i * 8 + 1, this.mf, this.buff);
    if (i != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int length(String paramString)
    throws Throwable
  {
    for (;;)
    {
      try
      {
        paramString = fixSlashes(paramString);
        int i = pathToId(paramString);
        if (i == -1)
        {
          i = 0;
          return i;
        }
        int k = IOUtils.readByte(i * 8 + 1, this.mf, this.buff);
        int j = 0;
        if (k == 0)
        {
          String[] arrayOfString = list(paramString);
          if ((arrayOfString != null) && (arrayOfString.length != 0))
          {
            int m = arrayOfString.length;
            k = 0;
            i = j;
            if (k >= m) {
              continue;
            }
            String str = arrayOfString[k];
            j += length(paramString + "/" + str);
            k += 1;
            continue;
          }
        }
        else
        {
          j = IOUtils.readShort(i * 8 + 2, this.mf, this.buff);
          k = IOUtils.readInt(i * 8 + 4, this.mf, this.buff);
          i = j;
          if (k == 0) {
            continue;
          }
          j += IOUtils.readShort(k * 8 + 2, this.mf, this.buff);
          k = IOUtils.readInt(k * 8 + 4, this.mf, this.buff);
          continue;
        }
        i = 0;
      }
      finally {}
    }
  }
  
  /* Error */
  public String[] list(String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 226	com/mob/tools/virtualdisk/MemDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   8: invokevirtual 230	com/mob/tools/virtualdisk/MemDisk:pathToId	(Ljava/lang/String;)I
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpne +9 -> 23
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: aconst_null
    //   24: astore 4
    //   26: aconst_null
    //   27: astore 5
    //   29: aload 5
    //   31: astore_1
    //   32: iload_2
    //   33: bipush 8
    //   35: imul
    //   36: iconst_1
    //   37: iadd
    //   38: aload_0
    //   39: getfield 34	com/mob/tools/virtualdisk/MemDisk:mf	Landroid/os/MemoryFile;
    //   42: aload_0
    //   43: getfield 38	com/mob/tools/virtualdisk/MemDisk:buff	[B
    //   46: invokestatic 203	com/mob/tools/virtualdisk/MemDisk$IOUtils:readByte	(ILandroid/os/MemoryFile;[B)B
    //   49: ifne -30 -> 19
    //   52: aload_0
    //   53: iload_2
    //   54: invokevirtual 50	com/mob/tools/virtualdisk/MemDisk:readDirectoryData	(I)[B
    //   57: astore 6
    //   59: aload 5
    //   61: astore_1
    //   62: aload 6
    //   64: ifnull -45 -> 19
    //   67: new 71	java/io/DataInputStream
    //   70: dup
    //   71: new 73	java/io/ByteArrayInputStream
    //   74: dup
    //   75: aload 6
    //   77: invokespecial 76	java/io/ByteArrayInputStream:<init>	([B)V
    //   80: invokespecial 79	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore 5
    //   85: aload 5
    //   87: invokevirtual 83	java/io/DataInputStream:readInt	()I
    //   90: istore_3
    //   91: aload 4
    //   93: astore_1
    //   94: iload_3
    //   95: ifle +41 -> 136
    //   98: iload_3
    //   99: anewarray 256	java/lang/String
    //   102: astore 4
    //   104: iconst_0
    //   105: istore_2
    //   106: aload 4
    //   108: astore_1
    //   109: iload_2
    //   110: iload_3
    //   111: if_icmpge +25 -> 136
    //   114: aload 4
    //   116: iload_2
    //   117: aload 5
    //   119: invokevirtual 259	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   122: aastore
    //   123: aload 5
    //   125: invokevirtual 83	java/io/DataInputStream:readInt	()I
    //   128: pop
    //   129: iload_2
    //   130: iconst_1
    //   131: iadd
    //   132: istore_2
    //   133: goto -27 -> 106
    //   136: aload 5
    //   138: invokevirtual 84	java/io/DataInputStream:close	()V
    //   141: goto -122 -> 19
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	MemDisk
    //   0	149	1	paramString	String
    //   11	122	2	i	int
    //   90	22	3	j	int
    //   24	91	4	arrayOfString	String[]
    //   27	110	5	localDataInputStream	DataInputStream
    //   57	19	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	12	144	finally
    //   32	59	144	finally
    //   67	91	144	finally
    //   98	104	144	finally
    //   114	129	144	finally
    //   136	141	144	finally
  }
  
  public void loadFromFile(String paramString)
    throws Throwable
  {
    try
    {
      if (!new File(paramString).exists()) {
        throw new Throwable("file \"" + paramString + "\" does not exist");
      }
    }
    finally {}
    paramString = new RandomAccessFile(paramString, "rw");
    Object localObject = paramString.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, 4L);
    ((ByteBuffer)localObject).order(ByteOrder.BIG_ENDIAN);
    int i = ((ByteBuffer)localObject).getInt(0);
    this.mf = new MemoryFile(System.currentTimeMillis() + ".md", i);
    this.dataOffset = (i / 1032 * 8);
    this.buff = new byte['Ѐ'];
    localObject = new byte[this.dataOffset];
    paramString.seek(4L);
    paramString.readFully((byte[])localObject);
    IOUtils.writeRaw(0, (byte[])localObject, 0, this.dataOffset, this.mf);
    i = 0;
    for (;;)
    {
      if (i < this.dataOffset)
      {
        if (IOUtils.readByte(i, this.mf, this.buff) != 0)
        {
          int j = i / 8;
          paramString.seek(this.dataOffset + 4 + j * 1024);
          paramString.readFully(this.buff);
          IOUtils.writeRaw(this.dataOffset + j * 1024, this.buff, 0, 1024, this.mf);
        }
      }
      else
      {
        paramString.close();
        return;
      }
      i += 8;
    }
  }
  
  public boolean mkdir(String paramString)
    throws Throwable
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        paramString = splitPath(fixSlashes(paramString));
        j = -1;
        i = j;
        if (paramString != null)
        {
          int m = paramString.length;
          k = 0;
          i = j;
          if (k < m)
          {
            Object localObject = paramString[k];
            if ("/".equals(localObject))
            {
              if (readDirectoryData(0) != null) {
                break label258;
              }
              IOUtils.writeByte(0, (byte)1, this.mf, this.buff);
              IOUtils.writeByte(1, (byte)0, this.mf, this.buff);
              IOUtils.writeShort(2, (short)0, this.mf, this.buff);
              IOUtils.writeInt(4, 0, this.mf, this.buff);
              break label258;
            }
            i = j;
            if (j == -1) {
              break label260;
            }
            i = nameToId(j, (String)localObject);
            if (i == -1)
            {
              i = nextFreeId();
              if (i != -1)
              {
                IOUtils.writeByte(i * 8, (byte)1, this.mf, this.buff);
                IOUtils.writeByte(i * 8 + 1, (byte)0, this.mf, this.buff);
                IOUtils.writeShort(i * 8 + 2, (short)0, this.mf, this.buff);
                IOUtils.writeInt(i * 8 + 4, 0, this.mf, this.buff);
                addFileToDirectory(j, (String)localObject, i);
              }
              else
              {
                i = -1;
              }
            }
            break label260;
          }
        }
        if (i != -1)
        {
          bool = true;
          return bool;
        }
        boolean bool = false;
        continue;
        i = 0;
      }
      finally {}
      label258:
      label260:
      k += 1;
      int j = i;
    }
  }
  
  /* Error */
  public boolean mv(String paramString1, String paramString2)
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 226	com/mob/tools/virtualdisk/MemDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ldc -11
    //   11: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: istore 6
    //   16: iload 6
    //   18: ifeq +11 -> 29
    //   21: iconst_0
    //   22: istore 6
    //   24: aload_0
    //   25: monitorexit
    //   26: iload 6
    //   28: ireturn
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 230	com/mob/tools/virtualdisk/MemDisk:pathToId	(Ljava/lang/String;)I
    //   34: istore_3
    //   35: iload_3
    //   36: iconst_m1
    //   37: if_icmpne +9 -> 46
    //   40: iconst_0
    //   41: istore 6
    //   43: goto -19 -> 24
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 226	com/mob/tools/virtualdisk/MemDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: ldc -11
    //   55: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq +9 -> 67
    //   61: iconst_0
    //   62: istore 6
    //   64: goto -40 -> 24
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 230	com/mob/tools/virtualdisk/MemDisk:pathToId	(Ljava/lang/String;)I
    //   72: iconst_m1
    //   73: if_icmpeq +9 -> 82
    //   76: iconst_0
    //   77: istore 6
    //   79: goto -55 -> 24
    //   82: aload_2
    //   83: bipush 47
    //   85: invokevirtual 306	java/lang/String:lastIndexOf	(I)I
    //   88: istore 5
    //   90: iload 5
    //   92: ifge +9 -> 101
    //   95: iconst_0
    //   96: istore 6
    //   98: goto -74 -> 24
    //   101: aload_0
    //   102: aload_0
    //   103: aload_2
    //   104: iconst_0
    //   105: iload 5
    //   107: iconst_1
    //   108: iadd
    //   109: invokevirtual 310	java/lang/String:substring	(II)Ljava/lang/String;
    //   112: invokevirtual 226	com/mob/tools/virtualdisk/MemDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   115: invokevirtual 230	com/mob/tools/virtualdisk/MemDisk:pathToId	(Ljava/lang/String;)I
    //   118: istore 4
    //   120: iload 4
    //   122: iconst_m1
    //   123: if_icmpne +9 -> 132
    //   126: iconst_0
    //   127: istore 6
    //   129: goto -105 -> 24
    //   132: aload_2
    //   133: iload 5
    //   135: iconst_1
    //   136: iadd
    //   137: invokevirtual 313	java/lang/String:substring	(I)Ljava/lang/String;
    //   140: astore_2
    //   141: aload_1
    //   142: bipush 47
    //   144: invokevirtual 306	java/lang/String:lastIndexOf	(I)I
    //   147: istore 5
    //   149: iload 5
    //   151: ifge +9 -> 160
    //   154: iconst_0
    //   155: istore 6
    //   157: goto -133 -> 24
    //   160: aload_0
    //   161: aload_0
    //   162: aload_0
    //   163: aload_1
    //   164: iconst_0
    //   165: iload 5
    //   167: iconst_1
    //   168: iadd
    //   169: invokevirtual 310	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 226	com/mob/tools/virtualdisk/MemDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 230	com/mob/tools/virtualdisk/MemDisk:pathToId	(Ljava/lang/String;)I
    //   178: iload_3
    //   179: invokevirtual 317	com/mob/tools/virtualdisk/MemDisk:removeFileFromDirectory	(II)V
    //   182: aload_0
    //   183: iload 4
    //   185: aload_2
    //   186: iload_3
    //   187: invokevirtual 301	com/mob/tools/virtualdisk/MemDisk:addFileToDirectory	(ILjava/lang/String;I)V
    //   190: iconst_1
    //   191: istore 6
    //   193: goto -169 -> 24
    //   196: astore_1
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	MemDisk
    //   0	201	1	paramString1	String
    //   0	201	2	paramString2	String
    //   34	153	3	i	int
    //   118	66	4	j	int
    //   88	81	5	k	int
    //   14	178	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	16	196	finally
    //   29	35	196	finally
    //   46	61	196	finally
    //   67	76	196	finally
    //   82	90	196	finally
    //   101	120	196	finally
    //   132	149	196	finally
    //   160	190	196	finally
  }
  
  /* Error */
  public boolean newFile(String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: bipush 47
    //   8: invokevirtual 306	java/lang/String:lastIndexOf	(I)I
    //   11: istore_2
    //   12: iload_2
    //   13: ifge +12 -> 25
    //   16: iload 5
    //   18: istore 4
    //   20: aload_0
    //   21: monitorexit
    //   22: iload 4
    //   24: ireturn
    //   25: aload_1
    //   26: iload_2
    //   27: iconst_1
    //   28: iadd
    //   29: invokevirtual 313	java/lang/String:substring	(I)Ljava/lang/String;
    //   32: astore 6
    //   34: iload 5
    //   36: istore 4
    //   38: aload 6
    //   40: invokevirtual 319	java/lang/String:length	()I
    //   43: ifle -23 -> 20
    //   46: aload_0
    //   47: aload_1
    //   48: iconst_0
    //   49: iload_2
    //   50: iconst_1
    //   51: iadd
    //   52: invokevirtual 310	java/lang/String:substring	(II)Ljava/lang/String;
    //   55: invokevirtual 226	com/mob/tools/virtualdisk/MemDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_1
    //   59: iload 5
    //   61: istore 4
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 321	com/mob/tools/virtualdisk/MemDisk:mkdir	(Ljava/lang/String;)Z
    //   68: ifeq -48 -> 20
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 230	com/mob/tools/virtualdisk/MemDisk:pathToId	(Ljava/lang/String;)I
    //   76: istore_2
    //   77: iload 5
    //   79: istore 4
    //   81: aload_0
    //   82: iload_2
    //   83: aload 6
    //   85: invokevirtual 296	com/mob/tools/virtualdisk/MemDisk:nameToId	(ILjava/lang/String;)I
    //   88: iconst_m1
    //   89: if_icmpne -69 -> 20
    //   92: aload_0
    //   93: invokevirtual 299	com/mob/tools/virtualdisk/MemDisk:nextFreeId	()I
    //   96: istore_3
    //   97: iload 5
    //   99: istore 4
    //   101: iload_3
    //   102: iconst_m1
    //   103: if_icmpeq -83 -> 20
    //   106: iload_3
    //   107: bipush 8
    //   109: imul
    //   110: iconst_1
    //   111: aload_0
    //   112: getfield 34	com/mob/tools/virtualdisk/MemDisk:mf	Landroid/os/MemoryFile;
    //   115: aload_0
    //   116: getfield 38	com/mob/tools/virtualdisk/MemDisk:buff	[B
    //   119: invokestatic 220	com/mob/tools/virtualdisk/MemDisk$IOUtils:writeByte	(IBLandroid/os/MemoryFile;[B)V
    //   122: iload_3
    //   123: bipush 8
    //   125: imul
    //   126: iconst_1
    //   127: iadd
    //   128: iconst_1
    //   129: aload_0
    //   130: getfield 34	com/mob/tools/virtualdisk/MemDisk:mf	Landroid/os/MemoryFile;
    //   133: aload_0
    //   134: getfield 38	com/mob/tools/virtualdisk/MemDisk:buff	[B
    //   137: invokestatic 220	com/mob/tools/virtualdisk/MemDisk$IOUtils:writeByte	(IBLandroid/os/MemoryFile;[B)V
    //   140: iload_3
    //   141: bipush 8
    //   143: imul
    //   144: iconst_2
    //   145: iadd
    //   146: iconst_0
    //   147: aload_0
    //   148: getfield 34	com/mob/tools/virtualdisk/MemDisk:mf	Landroid/os/MemoryFile;
    //   151: aload_0
    //   152: getfield 38	com/mob/tools/virtualdisk/MemDisk:buff	[B
    //   155: invokestatic 289	com/mob/tools/virtualdisk/MemDisk$IOUtils:writeShort	(ISLandroid/os/MemoryFile;[B)V
    //   158: iload_3
    //   159: bipush 8
    //   161: imul
    //   162: iconst_4
    //   163: iadd
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield 34	com/mob/tools/virtualdisk/MemDisk:mf	Landroid/os/MemoryFile;
    //   169: aload_0
    //   170: getfield 38	com/mob/tools/virtualdisk/MemDisk:buff	[B
    //   173: invokestatic 292	com/mob/tools/virtualdisk/MemDisk$IOUtils:writeInt	(IILandroid/os/MemoryFile;[B)V
    //   176: aload_0
    //   177: iload_2
    //   178: aload 6
    //   180: iload_3
    //   181: invokevirtual 301	com/mob/tools/virtualdisk/MemDisk:addFileToDirectory	(ILjava/lang/String;I)V
    //   184: iconst_1
    //   185: istore 4
    //   187: goto -167 -> 20
    //   190: astore_1
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_1
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	MemDisk
    //   0	195	1	paramString	String
    //   11	167	2	i	int
    //   96	85	3	j	int
    //   18	168	4	bool1	boolean
    //   1	97	5	bool2	boolean
    //   32	147	6	str	String
    // Exception table:
    //   from	to	target	type
    //   5	12	190	finally
    //   25	34	190	finally
    //   38	59	190	finally
    //   63	77	190	finally
    //   81	97	190	finally
    //   106	184	190	finally
  }
  
  protected int nextFreeId()
    throws IOException
  {
    int k = -1;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.dataOffset)
      {
        if (IOUtils.readByte(i, this.mf, this.buff) == 0) {
          j = i / 8;
        }
      }
      else {
        return j;
      }
      i += 8;
    }
  }
  
  protected byte[] readDirectoryData(int paramInt)
    throws Throwable
  {
    int i = paramInt * 8;
    if (IOUtils.readByte(i, this.mf, this.buff) == 0) {}
    while (IOUtils.readByte(i + 1, this.mf, this.buff) != 0) {
      return null;
    }
    Object localObject1 = new MDFileInputStream(this, paramInt, null);
    Object localObject2 = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (paramInt = ((MDFileInputStream)localObject1).read(arrayOfByte); paramInt > 0; paramInt = ((MDFileInputStream)localObject1).read(arrayOfByte)) {
      ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, paramInt);
    }
    ((MDFileInputStream)localObject1).close();
    ((ByteArrayOutputStream)localObject2).close();
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    localObject1 = localObject2;
    if (localObject2.length == 0) {
      localObject1 = null;
    }
    return (byte[])localObject1;
  }
  
  protected void removeFileFromDirectory(int paramInt1, int paramInt2)
    throws Throwable
  {
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(readDirectoryData(paramInt1)));
    DataOutputStream localDataOutputStream = new DataOutputStream(new MDFileOutputStream(this, paramInt1));
    int i = localDataInputStream.readInt();
    localDataOutputStream.writeInt(i - 1);
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      String str = localDataInputStream.readUTF();
      int j = localDataInputStream.readInt();
      if (j != paramInt2)
      {
        localDataOutputStream.writeUTF(str);
        localDataOutputStream.writeInt(j);
      }
      paramInt1 += 1;
    }
    localDataInputStream.close();
    localDataOutputStream.close();
  }
  
  public void rm(String paramString)
    throws Throwable
  {
    String str;
    try
    {
      str = fixSlashes(paramString);
      if ("/".equals(str)) {
        throw new Throwable("can not remove directory \"/\"");
      }
    }
    finally {}
    int i = pathToId(str);
    if (i == -1) {}
    int j;
    do
    {
      return;
      if (IOUtils.readByte(i * 8 + 1, this.mf, this.buff) == 0)
      {
        Object localObject = readDirectoryData(i);
        if (localObject != null)
        {
          localObject = new DataInputStream(new ByteArrayInputStream((byte[])localObject));
          j = ((DataInputStream)localObject).readInt();
          ((DataInputStream)localObject).close();
          if (j > 0) {
            throw new Throwable("directory \"" + paramString + "\" is not empty");
          }
        }
      }
      j = IOUtils.readInt(i * 8 + 4, this.mf, this.buff);
      IOUtils.writeByte(i * 8, (byte)0, this.mf, this.buff);
      IOUtils.writeByte(i * 8 + 1, (byte)0, this.mf, this.buff);
      IOUtils.writeShort(i * 8 + 2, (short)0, this.mf, this.buff);
      IOUtils.writeInt(i * 8 + 4, 0, this.mf, this.buff);
      while (j != 0)
      {
        IOUtils.readInt(j * 8 + 4, this.mf, this.buff);
        IOUtils.writeByte(j * 8, (byte)0, this.mf, this.buff);
        IOUtils.writeByte(j * 8 + 1, (byte)0, this.mf, this.buff);
        IOUtils.writeShort(j * 8 + 2, (short)0, this.mf, this.buff);
        IOUtils.writeInt(j * 8 + 4, 0, this.mf, this.buff);
      }
      j = str.lastIndexOf('/');
    } while (j < 0);
    if (j == 0) {}
    for (paramString = "/";; paramString = str.substring(0, j))
    {
      j = pathToId(paramString);
      if (j == -1) {
        break;
      }
      removeFileFromDirectory(j, i);
      break;
    }
  }
  
  private static class IOUtils
  {
    public static byte readByte(int paramInt, MemoryFile paramMemoryFile, byte[] paramArrayOfByte)
      throws IOException
    {
      paramMemoryFile.readBytes(paramArrayOfByte, paramInt, 0, 1);
      return paramArrayOfByte[0];
    }
    
    public static int readInt(int paramInt, MemoryFile paramMemoryFile, byte[] paramArrayOfByte)
      throws IOException
    {
      paramMemoryFile.readBytes(paramArrayOfByte, paramInt, 0, 4);
      return (paramArrayOfByte[0] & 0xFF) << 24 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[2] & 0xFF) << 8 | paramArrayOfByte[3] & 0xFF;
    }
    
    public static void readRaw(int paramInt, MemoryFile paramMemoryFile, byte[] paramArrayOfByte)
      throws IOException
    {
      paramMemoryFile.readBytes(paramArrayOfByte, paramInt, 0, paramArrayOfByte.length);
    }
    
    public static short readShort(int paramInt, MemoryFile paramMemoryFile, byte[] paramArrayOfByte)
      throws IOException
    {
      paramMemoryFile.readBytes(paramArrayOfByte, paramInt, 0, 2);
      return (short)((paramArrayOfByte[0] & 0xFF) << 8 | paramArrayOfByte[1] & 0xFF);
    }
    
    public static void writeByte(int paramInt, byte paramByte, MemoryFile paramMemoryFile, byte[] paramArrayOfByte)
      throws IOException
    {
      paramArrayOfByte[0] = paramByte;
      paramMemoryFile.writeBytes(paramArrayOfByte, 0, paramInt, 1);
    }
    
    public static void writeInt(int paramInt1, int paramInt2, MemoryFile paramMemoryFile, byte[] paramArrayOfByte)
      throws IOException
    {
      paramArrayOfByte[0] = ((byte)(paramInt2 >> 24));
      paramArrayOfByte[1] = ((byte)(paramInt2 >> 16));
      paramArrayOfByte[2] = ((byte)(paramInt2 >> 8));
      paramArrayOfByte[3] = ((byte)paramInt2);
      paramMemoryFile.writeBytes(paramArrayOfByte, 0, paramInt1, 4);
    }
    
    public static void writeRaw(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, MemoryFile paramMemoryFile)
      throws IOException
    {
      paramMemoryFile.writeBytes(paramArrayOfByte, paramInt2, paramInt1, paramInt3);
    }
    
    public static void writeShort(int paramInt, short paramShort, MemoryFile paramMemoryFile, byte[] paramArrayOfByte)
      throws IOException
    {
      paramArrayOfByte[0] = ((byte)(paramShort >> 8));
      paramArrayOfByte[1] = ((byte)paramShort);
      paramMemoryFile.writeBytes(paramArrayOfByte, 0, paramInt, 2);
    }
  }
  
  private static class MDFileInputStream
    extends InputStream
  {
    private ArrayList<int[]> bbs;
    private MemDisk disk;
    private int offset;
    
    private MDFileInputStream(MemDisk paramMemDisk, int paramInt)
      throws Throwable
    {
      this.disk = paramMemDisk;
      this.bbs = new ArrayList();
      int i = MemDisk.IOUtils.readShort(paramInt * 8 + 2, paramMemDisk.mf, paramMemDisk.buff);
      int j;
      if (i > 0)
      {
        j = paramMemDisk.dataOffset;
        this.bbs.add(new int[] { j + paramInt * 1024, i, 0 });
      }
      for (paramInt = MemDisk.IOUtils.readInt(paramInt * 8 + 4, paramMemDisk.mf, paramMemDisk.buff); paramInt != 0; paramInt = MemDisk.IOUtils.readInt(paramInt * 8 + 4, paramMemDisk.mf, paramMemDisk.buff))
      {
        i = MemDisk.IOUtils.readShort(paramInt * 8 + 2, paramMemDisk.mf, paramMemDisk.buff);
        if (i > 0)
        {
          j = paramMemDisk.dataOffset;
          this.bbs.add(new int[] { j + paramInt * 1024, i, 0 });
        }
      }
    }
    
    public int read()
      throws IOException
    {
      if (this.bbs.isEmpty()) {
        return -1;
      }
      for (int[] arrayOfInt = (int[])this.bbs.get(this.offset);; arrayOfInt = (int[])this.bbs.get(this.offset))
      {
        if (arrayOfInt[2] < arrayOfInt[1]) {
          break label80;
        }
        if (this.offset == this.bbs.size() - 1) {
          break;
        }
        this.offset += 1;
      }
      label80:
      int i = MemDisk.IOUtils.readByte(arrayOfInt[0] + arrayOfInt[2], this.disk.mf, this.disk.buff);
      arrayOfInt[2] += 1;
      return i & 0xFF;
    }
  }
  
  private static class MDFileOutputStream
    extends OutputStream
  {
    private ArrayList<Integer> bbNextIds;
    private MemDisk disk;
    private int fid;
    private int pos;
    
    public MDFileOutputStream(MemDisk paramMemDisk, int paramInt)
      throws Throwable
    {
      this.disk = paramMemDisk;
      this.fid = paramInt;
      this.bbNextIds = new ArrayList();
      for (paramInt = MemDisk.IOUtils.readInt(paramInt * 8 + 4, paramMemDisk.mf, paramMemDisk.buff); paramInt != 0; paramInt = MemDisk.IOUtils.readInt(paramInt * 8 + 4, paramMemDisk.mf, paramMemDisk.buff)) {
        this.bbNextIds.add(Integer.valueOf(paramInt));
      }
    }
    
    public void write(int paramInt)
      throws IOException
    {
      if (!this.bbNextIds.isEmpty())
      {
        Iterator localIterator = this.bbNextIds.iterator();
        while (localIterator.hasNext())
        {
          Integer localInteger = (Integer)localIterator.next();
          MemDisk.IOUtils.writeByte(localInteger.intValue() * 8, (byte)0, this.disk.mf, this.disk.buff);
          MemDisk.IOUtils.writeByte(localInteger.intValue() * 8 + 1, (byte)0, this.disk.mf, this.disk.buff);
          MemDisk.IOUtils.writeShort(localInteger.intValue() * 8 + 2, (short)0, this.disk.mf, this.disk.buff);
          MemDisk.IOUtils.writeInt(localInteger.intValue() * 8 + 4, 0, this.disk.mf, this.disk.buff);
        }
        this.bbNextIds.clear();
        MemDisk.IOUtils.writeShort(this.fid * 8 + 2, (short)0, this.disk.mf, this.disk.buff);
        MemDisk.IOUtils.writeInt(this.fid * 8 + 4, 0, this.disk.mf, this.disk.buff);
      }
      if (this.pos >= 1024)
      {
        int i = this.disk.nextFreeId();
        if (i == -1) {
          throw new IOException("Out of storage");
        }
        MemDisk.IOUtils.writeByte(i * 8, (byte)1, this.disk.mf, this.disk.buff);
        MemDisk.IOUtils.writeInt(this.fid * 8 + 4, i, this.disk.mf, this.disk.buff);
        this.fid = i;
        this.pos = 0;
      }
      MemDisk.IOUtils.writeByte(this.disk.dataOffset + this.fid * 1024 + this.pos, (byte)paramInt, this.disk.mf, this.disk.buff);
      this.pos += 1;
      MemDisk.IOUtils.writeShort(this.fid * 8 + 2, (short)this.pos, this.disk.mf, this.disk.buff);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\virtualdisk\MemDisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */