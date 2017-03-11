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

public class RamDisk
  extends VirtualDisk
{
  private byte[][] bbBlocks;
  private ByteBuffer bbNode;
  private int size;
  
  protected void addFileToDirectory(int paramInt1, String paramString, int paramInt2)
    throws Throwable
  {
    byte[] arrayOfByte = readDirectoryData(paramInt1);
    DataOutputStream localDataOutputStream = new DataOutputStream(new RDFileOutputStream(this, paramInt1));
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
  
  public void create(int paramInt)
    throws Throwable
  {
    try
    {
      this.size = paramInt;
      paramInt = (paramInt - 4) / 1032;
      this.bbNode = ByteBuffer.allocate(paramInt * 8);
      this.bbNode.order(ByteOrder.BIG_ENDIAN);
      this.bbBlocks = new byte[paramInt][];
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
      int k;
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
          localMappedByteBuffer.putInt(this.size);
          localMappedByteBuffer.force();
          k = this.bbNode.limit();
          localMappedByteBuffer = ((FileChannel)localObject).map(FileChannel.MapMode.READ_WRITE, 4L, k);
          localMappedByteBuffer.put(this.bbNode.array());
          localMappedByteBuffer.force();
          j = 0;
          i = 0;
          if (i >= this.bbNode.limit()) {
            break label226;
          }
          if (this.bbNode.get(i) == 0) {
            break label306;
          }
          j = i;
          break label306;
        }
        throw new Throwable("file \"" + paramString + "\" already exists");
      }
      finally {}
      label226:
      int i = 0;
      j /= 8;
      while (i <= j)
      {
        localMappedByteBuffer = ((FileChannel)localObject).map(FileChannel.MapMode.READ_WRITE, i * 1024 + (k + 4), 1024L);
        if (this.bbBlocks[i] != null) {
          localMappedByteBuffer.put(this.bbBlocks[i]);
        }
        localMappedByteBuffer.force();
        i += 1;
      }
      paramString.close();
      return;
      label306:
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
      while (i < this.bbNode.limit())
      {
        this.bbNode.put(arrayOfByte);
        i += 8;
      }
      this.bbNode.put(0, (byte)1);
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
    //   7: invokevirtual 200	com/mob/tools/virtualdisk/RamDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokevirtual 204	com/mob/tools/virtualdisk/RamDisk:pathToId	(Ljava/lang/String;)I
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
    //   28: getfield 27	com/mob/tools/virtualdisk/RamDisk:bbNode	Ljava/nio/ByteBuffer;
    //   31: iload_2
    //   32: bipush 8
    //   34: imul
    //   35: iconst_1
    //   36: iadd
    //   37: invokevirtual 170	java/nio/ByteBuffer:get	(I)B
    //   40: ifeq -19 -> 21
    //   43: new 8	com/mob/tools/virtualdisk/RamDisk$RDFileInputStream
    //   46: dup
    //   47: aload_0
    //   48: iload_2
    //   49: aconst_null
    //   50: invokespecial 207	com/mob/tools/virtualdisk/RamDisk$RDFileInputStream:<init>	(Lcom/mob/tools/virtualdisk/RamDisk;ILcom/mob/tools/virtualdisk/RamDisk$1;)V
    //   53: astore_1
    //   54: goto -33 -> 21
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	RamDisk
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
    //   7: invokevirtual 200	com/mob/tools/virtualdisk/RamDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokevirtual 204	com/mob/tools/virtualdisk/RamDisk:pathToId	(Ljava/lang/String;)I
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
    //   28: getfield 27	com/mob/tools/virtualdisk/RamDisk:bbNode	Ljava/nio/ByteBuffer;
    //   31: iload_2
    //   32: bipush 8
    //   34: imul
    //   35: iconst_1
    //   36: iadd
    //   37: invokevirtual 170	java/nio/ByteBuffer:get	(I)B
    //   40: ifeq -19 -> 21
    //   43: new 11	com/mob/tools/virtualdisk/RamDisk$RDFileOutputStream
    //   46: dup
    //   47: aload_0
    //   48: iload_2
    //   49: invokespecial 44	com/mob/tools/virtualdisk/RamDisk$RDFileOutputStream:<init>	(Lcom/mob/tools/virtualdisk/RamDisk;I)V
    //   52: astore_1
    //   53: goto -32 -> 21
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	RamDisk
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
    //   5: invokevirtual 200	com/mob/tools/virtualdisk/RamDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   8: invokevirtual 204	com/mob/tools/virtualdisk/RamDisk:pathToId	(Ljava/lang/String;)I
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
    //   33: getfield 27	com/mob/tools/virtualdisk/RamDisk:bbNode	Ljava/nio/ByteBuffer;
    //   36: iload_2
    //   37: bipush 8
    //   39: imul
    //   40: iconst_1
    //   41: iadd
    //   42: invokevirtual 170	java/nio/ByteBuffer:get	(I)B
    //   45: ifne -26 -> 19
    //   48: aload_0
    //   49: iload_2
    //   50: invokevirtual 39	com/mob/tools/virtualdisk/RamDisk:readDirectoryData	(I)[B
    //   53: astore 6
    //   55: aload 5
    //   57: astore_1
    //   58: aload 6
    //   60: ifnull -41 -> 19
    //   63: new 228	java/io/DataInputStream
    //   66: dup
    //   67: new 230	java/io/ByteArrayInputStream
    //   70: dup
    //   71: aload 6
    //   73: invokespecial 232	java/io/ByteArrayInputStream:<init>	([B)V
    //   76: invokespecial 235	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: astore 5
    //   81: aload 5
    //   83: invokevirtual 238	java/io/DataInputStream:readInt	()I
    //   86: istore_3
    //   87: aload 4
    //   89: astore_1
    //   90: iload_3
    //   91: ifle +41 -> 132
    //   94: iload_3
    //   95: anewarray 240	java/lang/String
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
    //   115: invokevirtual 243	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   118: aastore
    //   119: aload 5
    //   121: invokevirtual 238	java/io/DataInputStream:readInt	()I
    //   124: pop
    //   125: iload_2
    //   126: iconst_1
    //   127: iadd
    //   128: istore_2
    //   129: goto -27 -> 102
    //   132: aload 5
    //   134: invokevirtual 244	java/io/DataInputStream:close	()V
    //   137: goto -118 -> 19
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	RamDisk
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
    int i = (((ByteBuffer)localObject).getInt(0) - 4) / 1032;
    int j = i * 8;
    localObject = new byte[j];
    paramString.seek(4L);
    paramString.readFully((byte[])localObject);
    this.bbNode = ByteBuffer.wrap((byte[])localObject);
    this.bbBlocks = new byte[i][];
    i = 0;
    for (;;)
    {
      if (i < this.bbNode.limit())
      {
        if (this.bbNode.get(i) != 0)
        {
          int k = i / 8;
          this.bbBlocks[k] = new byte['Ѐ'];
          paramString.seek(k * 1024 + (j + 4));
          paramString.readFully(this.bbBlocks[k]);
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
            if (i == -1)
            {
              i = nextFreeId();
              if (i != -1)
              {
                this.bbNode.put(i * 8, (byte)1);
                this.bbNode.put(i * 8 + 1, (byte)0);
                this.bbNode.putShort(i * 8 + 2, (short)0);
                this.bbNode.putInt(i * 8 + 4, 0);
                addFileToDirectory(j, (String)localObject, i);
              }
              else
              {
                i = -1;
              }
            }
            break label236;
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
      label234:
      label236:
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
    //   4: invokevirtual 200	com/mob/tools/virtualdisk/RamDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ldc -36
    //   11: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   31: invokevirtual 204	com/mob/tools/virtualdisk/RamDisk:pathToId	(Ljava/lang/String;)I
    //   34: istore_3
    //   35: iload_3
    //   36: iconst_m1
    //   37: if_icmpne +9 -> 46
    //   40: iconst_0
    //   41: istore 6
    //   43: goto -19 -> 24
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 200	com/mob/tools/virtualdisk/RamDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: ldc -36
    //   55: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq +9 -> 67
    //   61: iconst_0
    //   62: istore 6
    //   64: goto -40 -> 24
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 204	com/mob/tools/virtualdisk/RamDisk:pathToId	(Ljava/lang/String;)I
    //   72: iconst_m1
    //   73: if_icmpeq +9 -> 82
    //   76: iconst_0
    //   77: istore 6
    //   79: goto -55 -> 24
    //   82: aload_2
    //   83: bipush 47
    //   85: invokevirtual 281	java/lang/String:lastIndexOf	(I)I
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
    //   109: invokevirtual 285	java/lang/String:substring	(II)Ljava/lang/String;
    //   112: invokevirtual 200	com/mob/tools/virtualdisk/RamDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   115: invokevirtual 204	com/mob/tools/virtualdisk/RamDisk:pathToId	(Ljava/lang/String;)I
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
    //   137: invokevirtual 288	java/lang/String:substring	(I)Ljava/lang/String;
    //   140: astore_2
    //   141: aload_1
    //   142: bipush 47
    //   144: invokevirtual 281	java/lang/String:lastIndexOf	(I)I
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
    //   169: invokevirtual 285	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 200	com/mob/tools/virtualdisk/RamDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 204	com/mob/tools/virtualdisk/RamDisk:pathToId	(Ljava/lang/String;)I
    //   178: iload_3
    //   179: invokevirtual 292	com/mob/tools/virtualdisk/RamDisk:removeFileFromDirectory	(II)V
    //   182: aload_0
    //   183: iload 4
    //   185: aload_2
    //   186: iload_3
    //   187: invokevirtual 276	com/mob/tools/virtualdisk/RamDisk:addFileToDirectory	(ILjava/lang/String;I)V
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
    //   0	201	0	this	RamDisk
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
    //   8: invokevirtual 281	java/lang/String:lastIndexOf	(I)I
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
    //   29: invokevirtual 288	java/lang/String:substring	(I)Ljava/lang/String;
    //   32: astore 6
    //   34: iload 5
    //   36: istore 4
    //   38: aload 6
    //   40: invokevirtual 295	java/lang/String:length	()I
    //   43: ifle -23 -> 20
    //   46: aload_0
    //   47: aload_1
    //   48: iconst_0
    //   49: iload_2
    //   50: iconst_1
    //   51: iadd
    //   52: invokevirtual 285	java/lang/String:substring	(II)Ljava/lang/String;
    //   55: invokevirtual 200	com/mob/tools/virtualdisk/RamDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_1
    //   59: iload 5
    //   61: istore 4
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 297	com/mob/tools/virtualdisk/RamDisk:mkdir	(Ljava/lang/String;)Z
    //   68: ifeq -48 -> 20
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 204	com/mob/tools/virtualdisk/RamDisk:pathToId	(Ljava/lang/String;)I
    //   76: istore_2
    //   77: iload 5
    //   79: istore 4
    //   81: aload_0
    //   82: iload_2
    //   83: aload 6
    //   85: invokevirtual 271	com/mob/tools/virtualdisk/RamDisk:nameToId	(ILjava/lang/String;)I
    //   88: iconst_m1
    //   89: if_icmpne -69 -> 20
    //   92: aload_0
    //   93: invokevirtual 274	com/mob/tools/virtualdisk/RamDisk:nextFreeId	()I
    //   96: istore_3
    //   97: iload 5
    //   99: istore 4
    //   101: iload_3
    //   102: iconst_m1
    //   103: if_icmpeq -83 -> 20
    //   106: aload_0
    //   107: getfield 27	com/mob/tools/virtualdisk/RamDisk:bbNode	Ljava/nio/ByteBuffer;
    //   110: iload_3
    //   111: bipush 8
    //   113: imul
    //   114: iconst_1
    //   115: invokevirtual 194	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   118: pop
    //   119: aload_0
    //   120: getfield 27	com/mob/tools/virtualdisk/RamDisk:bbNode	Ljava/nio/ByteBuffer;
    //   123: iload_3
    //   124: bipush 8
    //   126: imul
    //   127: iconst_1
    //   128: iadd
    //   129: iconst_1
    //   130: invokevirtual 194	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   133: pop
    //   134: aload_0
    //   135: getfield 27	com/mob/tools/virtualdisk/RamDisk:bbNode	Ljava/nio/ByteBuffer;
    //   138: iload_3
    //   139: bipush 8
    //   141: imul
    //   142: iconst_2
    //   143: iadd
    //   144: iconst_0
    //   145: invokevirtual 267	java/nio/ByteBuffer:putShort	(IS)Ljava/nio/ByteBuffer;
    //   148: pop
    //   149: aload_0
    //   150: getfield 27	com/mob/tools/virtualdisk/RamDisk:bbNode	Ljava/nio/ByteBuffer;
    //   153: iload_3
    //   154: bipush 8
    //   156: imul
    //   157: iconst_4
    //   158: iadd
    //   159: iconst_0
    //   160: invokevirtual 82	java/nio/ByteBuffer:putInt	(II)Ljava/nio/ByteBuffer;
    //   163: pop
    //   164: aload_0
    //   165: iload_2
    //   166: aload 6
    //   168: iload_3
    //   169: invokevirtual 276	com/mob/tools/virtualdisk/RamDisk:addFileToDirectory	(ILjava/lang/String;I)V
    //   172: iconst_1
    //   173: istore 4
    //   175: goto -155 -> 20
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	RamDisk
    //   0	183	1	paramString	String
    //   11	155	2	i	int
    //   96	73	3	j	int
    //   18	156	4	bool1	boolean
    //   1	97	5	bool2	boolean
    //   32	135	6	str	String
    // Exception table:
    //   from	to	target	type
    //   5	12	178	finally
    //   25	34	178	finally
    //   38	59	178	finally
    //   63	77	178	finally
    //   81	97	178	finally
    //   106	172	178	finally
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
    Object localObject1 = new RDFileInputStream(this, paramInt, null);
    Object localObject2 = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (paramInt = ((RDFileInputStream)localObject1).read(arrayOfByte); paramInt > 0; paramInt = ((RDFileInputStream)localObject1).read(arrayOfByte)) {
      ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, paramInt);
    }
    ((RDFileInputStream)localObject1).close();
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
    DataOutputStream localDataOutputStream = new DataOutputStream(new RDFileOutputStream(this, paramInt1));
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
      break;
    }
  }
  
  private static class RDFileInputStream
    extends InputStream
  {
    private ArrayList<ByteBuffer> bbs = new ArrayList();
    private int offset;
    
    private RDFileInputStream(RamDisk paramRamDisk, int paramInt)
      throws Throwable
    {
      int i = paramRamDisk.bbNode.getShort(paramInt * 8 + 2);
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = ByteBuffer.wrap(paramRamDisk.bbBlocks[paramInt], 0, i);
        localByteBuffer.order(ByteOrder.BIG_ENDIAN);
        this.bbs.add(localByteBuffer);
      }
      for (paramInt = paramRamDisk.bbNode.getInt(paramInt * 8 + 4); paramInt != 0; paramInt = paramRamDisk.bbNode.getInt(paramInt * 8 + 4))
      {
        i = paramRamDisk.bbNode.getShort(paramInt * 8 + 2);
        if (i > 0)
        {
          localByteBuffer = ByteBuffer.wrap(paramRamDisk.bbBlocks[paramInt], 0, i);
          localByteBuffer.order(ByteOrder.BIG_ENDIAN);
          this.bbs.add(localByteBuffer);
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
  
  private static class RDFileOutputStream
    extends OutputStream
  {
    private ByteBuffer bb;
    private ArrayList<Integer> bbNextIds;
    private RamDisk disk;
    private int fid;
    
    public RDFileOutputStream(RamDisk paramRamDisk, int paramInt)
      throws Throwable
    {
      this.disk = paramRamDisk;
      this.fid = paramInt;
      if (paramRamDisk.bbBlocks[paramInt] == null) {
        paramRamDisk.bbBlocks[paramInt] = new byte['Ѐ'];
      }
      this.bb = ByteBuffer.wrap(paramRamDisk.bbBlocks[paramInt]);
      this.bb.order(ByteOrder.BIG_ENDIAN);
      this.bbNextIds = new ArrayList();
      for (paramInt = paramRamDisk.bbNode.getInt(paramInt * 8 + 4); paramInt != 0; paramInt = paramRamDisk.bbNode.getInt(paramInt * 8 + 4)) {
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
        this.fid = i;
        if (this.disk.bbBlocks[this.fid] == null) {
          this.disk.bbBlocks[this.fid] = new byte['Ѐ'];
        }
        this.bb = ByteBuffer.wrap(this.disk.bbBlocks[this.fid]);
        this.bb.order(ByteOrder.BIG_ENDIAN);
      }
      this.bb.put((byte)paramInt);
      this.disk.bbNode.putShort(this.fid * 8 + 2, (short)this.bb.position());
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\virtualdisk\RamDisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */