package com.mob.tools.virtualdisk;

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

public class FileDisk
  extends VirtualDisk
{
  private MappedByteBuffer bbNode;
  private int dataOffset;
  private RandomAccessFile raf;
  
  protected void addFileToDirectory(int paramInt1, String paramString, int paramInt2)
    throws Throwable
  {
    byte[] arrayOfByte = readDirectoryData(paramInt1);
    DataOutputStream localDataOutputStream = new DataOutputStream(new FDFileOutputStream(this, paramInt1));
    if (arrayOfByte == null) {
      localDataOutputStream.writeInt(1);
    }
    for (;;)
    {
      localDataOutputStream.writeUTF(paramString);
      localDataOutputStream.writeInt(paramInt2);
      localDataOutputStream.close();
      return;
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      localByteBuffer.putInt(0, localByteBuffer.getInt(0) + 1);
      localDataOutputStream.write(arrayOfByte);
    }
  }
  
  public void create(String paramString, int paramInt)
    throws Throwable
  {
    try
    {
      localObject = new File(paramString);
      if (((File)localObject).exists()) {
        throw new Throwable("file \"" + paramString + "\" already exists");
      }
    }
    finally {}
    if (!((File)localObject).getParentFile().exists()) {
      ((File)localObject).getParentFile().mkdirs();
    }
    ((File)localObject).createNewFile();
    this.raf = new RandomAccessFile(paramString, "rw");
    paramString = this.raf.getChannel();
    Object localObject = paramString.map(FileChannel.MapMode.READ_WRITE, 0L, 4L);
    ((MappedByteBuffer)localObject).order(ByteOrder.BIG_ENDIAN);
    ((MappedByteBuffer)localObject).putInt(0, paramInt);
    ((MappedByteBuffer)localObject).force();
    paramInt = (paramInt - 4) / 1032 * 8;
    this.dataOffset = (paramInt + 4);
    this.bbNode = paramString.map(FileChannel.MapMode.READ_WRITE, 4L, paramInt);
    this.bbNode.order(ByteOrder.BIG_ENDIAN);
  }
  
  /* Error */
  public boolean exists(String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   8: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpeq +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	FileDisk
    //   0	33	1	paramString	String
    //   11	4	2	i	int
    //   18	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  public void format()
    throws Throwable
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte = new byte[8];
      while (i < this.bbNode.limit())
      {
        this.bbNode.put(arrayOfByte);
        i += 8;
      }
      this.bbNode.put(0, (byte)1);
      this.bbNode.force();
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
    //   7: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
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
    //   27: aload_0
    //   28: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   31: iload_2
    //   32: bipush 8
    //   34: imul
    //   35: iconst_1
    //   36: iadd
    //   37: invokevirtual 186	java/nio/MappedByteBuffer:get	(I)B
    //   40: ifeq -19 -> 21
    //   43: new 8	com/mob/tools/virtualdisk/FileDisk$FDFileInputStream
    //   46: dup
    //   47: aload_0
    //   48: iload_2
    //   49: aconst_null
    //   50: invokespecial 189	com/mob/tools/virtualdisk/FileDisk$FDFileInputStream:<init>	(Lcom/mob/tools/virtualdisk/FileDisk;ILcom/mob/tools/virtualdisk/FileDisk$1;)V
    //   53: astore_1
    //   54: goto -33 -> 21
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	FileDisk
    //   0	62	1	paramString	String
    //   13	36	2	i	int
    //   1	25	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	57	finally
    //   27	54	57	finally
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
    //   7: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
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
    //   27: aload_0
    //   28: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   31: iload_2
    //   32: bipush 8
    //   34: imul
    //   35: iconst_1
    //   36: iadd
    //   37: invokevirtual 186	java/nio/MappedByteBuffer:get	(I)B
    //   40: ifeq -19 -> 21
    //   43: new 11	com/mob/tools/virtualdisk/FileDisk$FDFileOutputStream
    //   46: dup
    //   47: aload_0
    //   48: iload_2
    //   49: invokespecial 48	com/mob/tools/virtualdisk/FileDisk$FDFileOutputStream:<init>	(Lcom/mob/tools/virtualdisk/FileDisk;I)V
    //   52: astore_1
    //   53: goto -32 -> 21
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	FileDisk
    //   0	61	1	paramString	String
    //   13	36	2	i	int
    //   1	25	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	56	finally
    //   27	53	56	finally
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
    int i = this.bbNode.get(i * 8 + 1);
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
        int k = this.bbNode.get(i * 8 + 1);
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
          j = this.bbNode.getShort(i * 8 + 2);
          k = this.bbNode.getInt(i * 8 + 4);
          i = j;
          if (k == 0) {
            continue;
          }
          j += this.bbNode.getShort(k * 8 + 2);
          k = this.bbNode.getInt(k * 8 + 4);
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
    //   5: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   8: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
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
    //   32: aload_0
    //   33: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   36: iload_2
    //   37: bipush 8
    //   39: imul
    //   40: iconst_1
    //   41: iadd
    //   42: invokevirtual 186	java/nio/MappedByteBuffer:get	(I)B
    //   45: ifne -26 -> 19
    //   48: aload_0
    //   49: iload_2
    //   50: invokevirtual 43	com/mob/tools/virtualdisk/FileDisk:readDirectoryData	(I)[B
    //   53: astore 6
    //   55: aload 5
    //   57: astore_1
    //   58: aload 6
    //   60: ifnull -41 -> 19
    //   63: new 210	java/io/DataInputStream
    //   66: dup
    //   67: new 212	java/io/ByteArrayInputStream
    //   70: dup
    //   71: aload 6
    //   73: invokespecial 214	java/io/ByteArrayInputStream:<init>	([B)V
    //   76: invokespecial 217	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: astore 5
    //   81: aload 5
    //   83: invokevirtual 220	java/io/DataInputStream:readInt	()I
    //   86: istore_3
    //   87: aload 4
    //   89: astore_1
    //   90: iload_3
    //   91: ifle +41 -> 132
    //   94: iload_3
    //   95: anewarray 222	java/lang/String
    //   98: astore 4
    //   100: iconst_0
    //   101: istore_2
    //   102: aload 4
    //   104: astore_1
    //   105: iload_2
    //   106: iload_3
    //   107: if_icmpge +25 -> 132
    //   110: aload 4
    //   112: iload_2
    //   113: aload 5
    //   115: invokevirtual 225	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   118: aastore
    //   119: aload 5
    //   121: invokevirtual 220	java/io/DataInputStream:readInt	()I
    //   124: pop
    //   125: iload_2
    //   126: iconst_1
    //   127: iadd
    //   128: istore_2
    //   129: goto -27 -> 102
    //   132: aload 5
    //   134: invokevirtual 226	java/io/DataInputStream:close	()V
    //   137: goto -118 -> 19
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	FileDisk
    //   0	145	1	paramString	String
    //   11	118	2	i	int
    //   86	22	3	j	int
    //   24	87	4	arrayOfString	String[]
    //   27	106	5	localDataInputStream	DataInputStream
    //   53	19	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	12	140	finally
    //   32	55	140	finally
    //   63	87	140	finally
    //   94	100	140	finally
    //   110	125	140	finally
    //   132	137	140	finally
  }
  
  public boolean mkdir(String paramString)
    throws Throwable
  {
    int j;
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
              break label234;
            }
            this.bbNode.put(0, (byte)1);
            this.bbNode.put(1, (byte)0);
            this.bbNode.putShort(2, (short)0);
            this.bbNode.putInt(4, 0);
            break label234;
          }
          i = j;
          if (j == -1) {
            break label236;
          }
          i = nameToId(j, (String)localObject);
          if (i != -1) {
            break label252;
          }
          i = nextFreeId();
          if (i == -1) {
            break label247;
          }
          this.bbNode.put(i * 8, (byte)1);
          this.bbNode.put(i * 8 + 1, (byte)0);
          this.bbNode.putShort(i * 8 + 2, (short)0);
          this.bbNode.putInt(i * 8 + 4, 0);
          addFileToDirectory(j, (String)localObject, i);
          break label236;
        }
      }
      if (i != -1) {
        this.bbNode.force();
      }
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      i = 0;
    }
    finally {}
    label234:
    label236:
    label247:
    label252:
    for (;;)
    {
      k += 1;
      j = i;
      break;
      i = -1;
    }
  }
  
  public void mount(String paramString)
    throws Throwable
  {
    try
    {
      if (!new File(paramString).exists()) {
        throw new Throwable("file \"" + paramString + "\" does not exist");
      }
    }
    finally {}
    this.raf = new RandomAccessFile(paramString, "rw");
    paramString = this.raf.getChannel();
    MappedByteBuffer localMappedByteBuffer = paramString.map(FileChannel.MapMode.READ_WRITE, 0L, 4L);
    localMappedByteBuffer.order(ByteOrder.BIG_ENDIAN);
    int i = (localMappedByteBuffer.getInt(0) - 4) / 1032 * 8;
    this.dataOffset = (i + 4);
    this.bbNode = paramString.map(FileChannel.MapMode.READ_WRITE, 4L, i);
    this.bbNode.order(ByteOrder.BIG_ENDIAN);
  }
  
  /* Error */
  public void mount(String paramString, int paramInt)
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 95	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 101	java/io/File:exists	()Z
    //   13: ifeq +11 -> 24
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 250	com/mob/tools/virtualdisk/FileDisk:mount	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: iload_2
    //   27: invokevirtual 252	com/mob/tools/virtualdisk/FileDisk:create	(Ljava/lang/String;I)V
    //   30: goto -9 -> 21
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	FileDisk
    //   0	38	1	paramString	String
    //   0	38	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	21	33	finally
    //   24	30	33	finally
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
    //   4: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ldc -55
    //   11: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   31: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
    //   34: istore_3
    //   35: iload_3
    //   36: iconst_m1
    //   37: if_icmpne +9 -> 46
    //   40: iconst_0
    //   41: istore 6
    //   43: goto -19 -> 24
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: ldc -55
    //   55: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq +9 -> 67
    //   61: iconst_0
    //   62: istore 6
    //   64: goto -40 -> 24
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
    //   72: iconst_m1
    //   73: if_icmpeq +9 -> 82
    //   76: iconst_0
    //   77: istore 6
    //   79: goto -55 -> 24
    //   82: aload_2
    //   83: bipush 47
    //   85: invokevirtual 257	java/lang/String:lastIndexOf	(I)I
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
    //   109: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   112: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   115: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
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
    //   137: invokevirtual 264	java/lang/String:substring	(I)Ljava/lang/String;
    //   140: astore_2
    //   141: aload_1
    //   142: bipush 47
    //   144: invokevirtual 257	java/lang/String:lastIndexOf	(I)I
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
    //   169: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
    //   178: iload_3
    //   179: invokevirtual 268	com/mob/tools/virtualdisk/FileDisk:removeFileFromDirectory	(II)V
    //   182: aload_0
    //   183: iload 4
    //   185: aload_2
    //   186: iload_3
    //   187: invokevirtual 247	com/mob/tools/virtualdisk/FileDisk:addFileToDirectory	(ILjava/lang/String;I)V
    //   190: aload_0
    //   191: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   194: invokevirtual 160	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   197: pop
    //   198: iconst_1
    //   199: istore 6
    //   201: goto -177 -> 24
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	FileDisk
    //   0	209	1	paramString1	String
    //   0	209	2	paramString2	String
    //   34	153	3	i	int
    //   118	66	4	j	int
    //   88	81	5	k	int
    //   14	186	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	16	204	finally
    //   29	35	204	finally
    //   46	61	204	finally
    //   67	76	204	finally
    //   82	90	204	finally
    //   101	120	204	finally
    //   132	149	204	finally
    //   160	198	204	finally
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
    //   8: invokevirtual 257	java/lang/String:lastIndexOf	(I)I
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
    //   29: invokevirtual 264	java/lang/String:substring	(I)Ljava/lang/String;
    //   32: astore 6
    //   34: iload 5
    //   36: istore 4
    //   38: aload 6
    //   40: invokevirtual 271	java/lang/String:length	()I
    //   43: ifle -23 -> 20
    //   46: aload_0
    //   47: aload_1
    //   48: iconst_0
    //   49: iload_2
    //   50: iconst_1
    //   51: iadd
    //   52: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   55: invokevirtual 165	com/mob/tools/virtualdisk/FileDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_1
    //   59: iload 5
    //   61: istore 4
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 273	com/mob/tools/virtualdisk/FileDisk:mkdir	(Ljava/lang/String;)Z
    //   68: ifeq -48 -> 20
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 169	com/mob/tools/virtualdisk/FileDisk:pathToId	(Ljava/lang/String;)I
    //   76: istore_2
    //   77: iload 5
    //   79: istore 4
    //   81: aload_0
    //   82: iload_2
    //   83: aload 6
    //   85: invokevirtual 242	com/mob/tools/virtualdisk/FileDisk:nameToId	(ILjava/lang/String;)I
    //   88: iconst_m1
    //   89: if_icmpne -69 -> 20
    //   92: aload_0
    //   93: invokevirtual 245	com/mob/tools/virtualdisk/FileDisk:nextFreeId	()I
    //   96: istore_3
    //   97: iload 5
    //   99: istore 4
    //   101: iload_3
    //   102: iconst_m1
    //   103: if_icmpeq -83 -> 20
    //   106: aload_0
    //   107: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   110: iload_3
    //   111: bipush 8
    //   113: imul
    //   114: iconst_1
    //   115: invokevirtual 180	java/nio/MappedByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   118: pop
    //   119: aload_0
    //   120: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   123: iload_3
    //   124: bipush 8
    //   126: imul
    //   127: iconst_1
    //   128: iadd
    //   129: iconst_1
    //   130: invokevirtual 180	java/nio/MappedByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   133: pop
    //   134: aload_0
    //   135: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   138: iload_3
    //   139: bipush 8
    //   141: imul
    //   142: iconst_2
    //   143: iadd
    //   144: iconst_0
    //   145: invokevirtual 238	java/nio/MappedByteBuffer:putShort	(IS)Ljava/nio/ByteBuffer;
    //   148: pop
    //   149: aload_0
    //   150: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   153: iload_3
    //   154: bipush 8
    //   156: imul
    //   157: iconst_4
    //   158: iadd
    //   159: iconst_0
    //   160: invokevirtual 156	java/nio/MappedByteBuffer:putInt	(II)Ljava/nio/ByteBuffer;
    //   163: pop
    //   164: aload_0
    //   165: iload_2
    //   166: aload 6
    //   168: iload_3
    //   169: invokevirtual 247	com/mob/tools/virtualdisk/FileDisk:addFileToDirectory	(ILjava/lang/String;I)V
    //   172: aload_0
    //   173: getfield 31	com/mob/tools/virtualdisk/FileDisk:bbNode	Ljava/nio/MappedByteBuffer;
    //   176: invokevirtual 160	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   179: pop
    //   180: iconst_1
    //   181: istore 4
    //   183: goto -163 -> 20
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	FileDisk
    //   0	191	1	paramString	String
    //   11	155	2	i	int
    //   96	73	3	j	int
    //   18	164	4	bool1	boolean
    //   1	97	5	bool2	boolean
    //   32	135	6	str	String
    // Exception table:
    //   from	to	target	type
    //   5	12	186	finally
    //   25	34	186	finally
    //   38	59	186	finally
    //   63	77	186	finally
    //   81	97	186	finally
    //   106	180	186	finally
  }
  
  protected int nextFreeId()
  {
    int k = -1;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.bbNode.limit())
      {
        if (this.bbNode.get(i) == 0) {
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
    if (this.bbNode.get(i) == 0) {}
    while (this.bbNode.get(i + 1) != 0) {
      return null;
    }
    Object localObject1 = new FDFileInputStream(this, paramInt, null);
    Object localObject2 = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (paramInt = ((FDFileInputStream)localObject1).read(arrayOfByte); paramInt > 0; paramInt = ((FDFileInputStream)localObject1).read(arrayOfByte)) {
      ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, paramInt);
    }
    ((FDFileInputStream)localObject1).close();
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
    DataOutputStream localDataOutputStream = new DataOutputStream(new FDFileOutputStream(this, paramInt1));
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
    int j = pathToId(str);
    if (j == -1) {}
    int i;
    do
    {
      return;
      if (this.bbNode.get(j * 8 + 1) == 0)
      {
        Object localObject = readDirectoryData(j);
        if (localObject != null)
        {
          localObject = new DataInputStream(new ByteArrayInputStream((byte[])localObject));
          i = ((DataInputStream)localObject).readInt();
          ((DataInputStream)localObject).close();
          if (i > 0) {
            throw new Throwable("directory \"" + paramString + "\" is not empty");
          }
        }
      }
      i = this.bbNode.getInt(j * 8 + 4);
      this.bbNode.put(j * 8, (byte)0);
      this.bbNode.put(j * 8 + 1, (byte)0);
      this.bbNode.putShort(j * 8 + 2, (short)0);
      this.bbNode.putInt(j * 8 + 4, 0);
      while (i != 0)
      {
        i = this.bbNode.getInt(i * 8 + 4);
        this.bbNode.put(i * 8, (byte)0);
        this.bbNode.put(i * 8 + 1, (byte)0);
        this.bbNode.putShort(i * 8 + 2, (short)0);
        this.bbNode.putInt(i * 8 + 4, 0);
      }
      i = str.lastIndexOf('/');
    } while (i < 0);
    if (i == 0) {}
    for (paramString = "/";; paramString = str.substring(0, i))
    {
      i = pathToId(paramString);
      if (i == -1) {
        break;
      }
      removeFileFromDirectory(i, j);
      this.bbNode.force();
      break;
    }
  }
  
  public void unmount()
    throws Throwable
  {
    try
    {
      this.bbNode.force();
      this.raf.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static class FDFileInputStream
    extends InputStream
  {
    private ArrayList<ByteBuffer> bbs = new ArrayList();
    private int offset;
    
    private FDFileInputStream(FileDisk paramFileDisk, int paramInt)
      throws Throwable
    {
      FileChannel localFileChannel = paramFileDisk.raf.getChannel();
      int i = paramFileDisk.bbNode.getShort(paramInt * 8 + 2);
      MappedByteBuffer localMappedByteBuffer;
      if (i > 0)
      {
        localMappedByteBuffer = localFileChannel.map(FileChannel.MapMode.READ_WRITE, paramFileDisk.dataOffset + paramInt * 1024, i);
        localMappedByteBuffer.order(ByteOrder.BIG_ENDIAN);
        this.bbs.add(localMappedByteBuffer);
      }
      for (paramInt = paramFileDisk.bbNode.getInt(paramInt * 8 + 4); paramInt != 0; paramInt = paramFileDisk.bbNode.getInt(paramInt * 8 + 4))
      {
        i = paramFileDisk.bbNode.getShort(paramInt * 8 + 2);
        if (i > 0)
        {
          localMappedByteBuffer = localFileChannel.map(FileChannel.MapMode.READ_WRITE, paramFileDisk.dataOffset + paramInt * 1024, i);
          localMappedByteBuffer.order(ByteOrder.BIG_ENDIAN);
          this.bbs.add(localMappedByteBuffer);
        }
      }
    }
    
    public int read()
      throws IOException
    {
      if (this.bbs.isEmpty()) {
        return -1;
      }
      for (ByteBuffer localByteBuffer = (ByteBuffer)this.bbs.get(this.offset);; localByteBuffer = (ByteBuffer)this.bbs.get(this.offset))
      {
        if (localByteBuffer.hasRemaining()) {
          break label78;
        }
        if (this.offset == this.bbs.size() - 1) {
          break;
        }
        this.offset += 1;
      }
      label78:
      return localByteBuffer.get() & 0xFF;
    }
  }
  
  private static class FDFileOutputStream
    extends OutputStream
  {
    private MappedByteBuffer bb;
    private ArrayList<Integer> bbNextIds;
    private FileDisk disk;
    private int fid;
    
    public FDFileOutputStream(FileDisk paramFileDisk, int paramInt)
      throws Throwable
    {
      this.disk = paramFileDisk;
      this.fid = paramInt;
      this.bb = paramFileDisk.raf.getChannel().map(FileChannel.MapMode.READ_WRITE, paramFileDisk.dataOffset + paramInt * 1024, 1024L);
      this.bb.order(ByteOrder.BIG_ENDIAN);
      this.bbNextIds = new ArrayList();
      for (paramInt = paramFileDisk.bbNode.getInt(paramInt * 8 + 4); paramInt != 0; paramInt = paramFileDisk.bbNode.getInt(paramInt * 8 + 4)) {
        this.bbNextIds.add(Integer.valueOf(paramInt));
      }
    }
    
    public void flush()
      throws IOException
    {
      this.disk.bbNode.force();
      this.bb.force();
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
          this.disk.bbNode.put(localInteger.intValue() * 8, (byte)0);
          this.disk.bbNode.put(localInteger.intValue() * 8 + 1, (byte)0);
          this.disk.bbNode.putShort(localInteger.intValue() * 8 + 2, (short)0);
          this.disk.bbNode.putInt(localInteger.intValue() * 8 + 4, 0);
        }
        this.bbNextIds.clear();
        this.disk.bbNode.putShort(this.fid * 8 + 2, (short)0);
        this.disk.bbNode.putInt(this.fid * 8 + 4, 0);
      }
      if (!this.bb.hasRemaining())
      {
        int i = this.disk.nextFreeId();
        if (i == -1) {
          throw new IOException("Out of storage");
        }
        this.disk.bbNode.put(i * 8, (byte)1);
        this.disk.bbNode.putInt(this.fid * 8 + 4, i);
        this.disk.bbNode.force();
        this.bb.force();
        this.fid = i;
        this.bb = this.disk.raf.getChannel().map(FileChannel.MapMode.READ_WRITE, this.disk.dataOffset + this.fid * 1024, 1024L);
        this.bb.order(ByteOrder.BIG_ENDIAN);
      }
      this.bb.put((byte)paramInt);
      this.disk.bbNode.putShort(this.fid * 8 + 2, (short)this.bb.position());
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\virtualdisk\FileDisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */