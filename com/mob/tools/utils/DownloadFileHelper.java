package com.mob.tools.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;

public class DownloadFileHelper
{
  private static final int DOWNLOADING = 12;
  private static final int DOWNLOAD_COMPLETE = 13;
  private static final int DOWNLOAD_PAUSE = 11;
  private static final String FILE_NAME = "MOB_DOWNLOAD";
  private static final int FILE_VERSION = 1;
  private int completeSize = 0;
  private Context context;
  private String downloadFileName;
  private HashMap<String, Object> downloadInfo;
  private DownloadListener downloadListener;
  private String filePath;
  private int fileSize = 0;
  private String fileUrl;
  private SharePrefrenceHelper sharePrefrence;
  private boolean startDownload = false;
  private int state = 11;
  
  public DownloadFileHelper(Context paramContext, String paramString1, String paramString2, DownloadListener paramDownloadListener)
  {
    this.fileUrl = paramString1;
    this.context = paramContext;
    this.downloadFileName = paramString2;
    this.downloadListener = paramDownloadListener;
    this.sharePrefrence = new SharePrefrenceHelper(this.context);
    this.sharePrefrence.open("MOB_DOWNLOAD", 1);
  }
  
  private void downloadFile()
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 8
        //   3: aconst_null
        //   4: astore 5
        //   6: aconst_null
        //   7: astore 14
        //   9: aconst_null
        //   10: astore 10
        //   12: aconst_null
        //   13: astore 11
        //   15: aconst_null
        //   16: astore 9
        //   18: aconst_null
        //   19: astore 12
        //   21: aconst_null
        //   22: astore 13
        //   24: aload 9
        //   26: astore 6
        //   28: aload 14
        //   30: astore 7
        //   32: new 25	java/net/URL
        //   35: dup
        //   36: aload_0
        //   37: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   40: invokestatic 29	com/mob/tools/utils/DownloadFileHelper:access$000	(Lcom/mob/tools/utils/DownloadFileHelper;)Ljava/lang/String;
        //   43: invokespecial 32	java/net/URL:<init>	(Ljava/lang/String;)V
        //   46: invokevirtual 36	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   49: checkcast 38	java/net/HttpURLConnection
        //   52: astore 4
        //   54: aload 4
        //   56: astore 5
        //   58: aload 9
        //   60: astore 6
        //   62: aload 14
        //   64: astore 7
        //   66: aload 4
        //   68: astore 8
        //   70: aload 4
        //   72: sipush 5000
        //   75: invokevirtual 42	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   78: aload 4
        //   80: astore 5
        //   82: aload 9
        //   84: astore 6
        //   86: aload 14
        //   88: astore 7
        //   90: aload 4
        //   92: astore 8
        //   94: aload 4
        //   96: ldc 44
        //   98: invokevirtual 47	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   101: aload 4
        //   103: astore 5
        //   105: aload 9
        //   107: astore 6
        //   109: aload 14
        //   111: astore 7
        //   113: aload 4
        //   115: astore 8
        //   117: new 49	java/io/RandomAccessFile
        //   120: dup
        //   121: aload_0
        //   122: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   125: invokestatic 52	com/mob/tools/utils/DownloadFileHelper:access$100	(Lcom/mob/tools/utils/DownloadFileHelper;)Ljava/lang/String;
        //   128: ldc 54
        //   130: invokespecial 57	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   133: astore 9
        //   135: aload 13
        //   137: astore 5
        //   139: aload 12
        //   141: astore 6
        //   143: aload_0
        //   144: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   147: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   150: ifle +314 -> 464
        //   153: aload 13
        //   155: astore 5
        //   157: aload 12
        //   159: astore 6
        //   161: aload 4
        //   163: ldc 63
        //   165: new 65	java/lang/StringBuilder
        //   168: dup
        //   169: invokespecial 66	java/lang/StringBuilder:<init>	()V
        //   172: ldc 68
        //   174: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   177: aload_0
        //   178: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   181: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   184: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   187: ldc 77
        //   189: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   192: aload_0
        //   193: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   196: invokestatic 80	com/mob/tools/utils/DownloadFileHelper:access$300	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   199: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   202: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   205: invokevirtual 87	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   208: aload 13
        //   210: astore 5
        //   212: aload 12
        //   214: astore 6
        //   216: aload 9
        //   218: aload_0
        //   219: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   222: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   225: i2l
        //   226: invokevirtual 91	java/io/RandomAccessFile:seek	(J)V
        //   229: aload 13
        //   231: astore 5
        //   233: aload 12
        //   235: astore 6
        //   237: aload 4
        //   239: invokevirtual 95	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   242: astore 7
        //   244: aload 7
        //   246: astore 5
        //   248: aload 7
        //   250: astore 6
        //   252: sipush 4096
        //   255: newarray <illegal type>
        //   257: astore 8
        //   259: aload 7
        //   261: astore 5
        //   263: aload 7
        //   265: astore 6
        //   267: aload 7
        //   269: aload 8
        //   271: invokevirtual 101	java/io/InputStream:read	([B)I
        //   274: istore_3
        //   275: iconst_0
        //   276: istore_2
        //   277: iload_3
        //   278: iconst_m1
        //   279: if_icmpeq +568 -> 847
        //   282: aload 7
        //   284: astore 5
        //   286: aload 7
        //   288: astore 6
        //   290: aload 9
        //   292: aload 8
        //   294: iconst_0
        //   295: iload_3
        //   296: invokevirtual 105	java/io/RandomAccessFile:write	([BII)V
        //   299: aload 7
        //   301: astore 5
        //   303: aload 7
        //   305: astore 6
        //   307: aload_0
        //   308: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   311: iload_3
        //   312: invokestatic 109	com/mob/tools/utils/DownloadFileHelper:access$212	(Lcom/mob/tools/utils/DownloadFileHelper;I)I
        //   315: pop
        //   316: aload 7
        //   318: astore 5
        //   320: aload 7
        //   322: astore 6
        //   324: aload_0
        //   325: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   328: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   331: i2f
        //   332: aload_0
        //   333: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   336: invokestatic 80	com/mob/tools/utils/DownloadFileHelper:access$300	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   339: i2f
        //   340: fdiv
        //   341: ldc 110
        //   343: fmul
        //   344: f2i
        //   345: istore_3
        //   346: iload_2
        //   347: istore_1
        //   348: iload_3
        //   349: iload_2
        //   350: if_icmple +26 -> 376
        //   353: iload_3
        //   354: istore_1
        //   355: aload 7
        //   357: astore 5
        //   359: aload 7
        //   361: astore 6
        //   363: aload_0
        //   364: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   367: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   370: iload_1
        //   371: invokeinterface 119 2 0
        //   376: iload_1
        //   377: bipush 100
        //   379: if_icmplt +369 -> 748
        //   382: aload 7
        //   384: astore 5
        //   386: aload 7
        //   388: astore 6
        //   390: aload_0
        //   391: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   394: bipush 13
        //   396: invokestatic 122	com/mob/tools/utils/DownloadFileHelper:access$602	(Lcom/mob/tools/utils/DownloadFileHelper;I)I
        //   399: pop
        //   400: aload 7
        //   402: astore 5
        //   404: aload 7
        //   406: astore 6
        //   408: aload_0
        //   409: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   412: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   415: aload_0
        //   416: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   419: invokestatic 52	com/mob/tools/utils/DownloadFileHelper:access$100	(Lcom/mob/tools/utils/DownloadFileHelper;)Ljava/lang/String;
        //   422: invokeinterface 125 2 0
        //   427: aload_0
        //   428: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   431: aload_0
        //   432: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   435: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   438: invokestatic 129	com/mob/tools/utils/DownloadFileHelper:access$700	(Lcom/mob/tools/utils/DownloadFileHelper;I)V
        //   441: aload_0
        //   442: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   445: invokestatic 132	com/mob/tools/utils/DownloadFileHelper:access$800	(Lcom/mob/tools/utils/DownloadFileHelper;)V
        //   448: aload 7
        //   450: invokevirtual 135	java/io/InputStream:close	()V
        //   453: aload 9
        //   455: invokevirtual 136	java/io/RandomAccessFile:close	()V
        //   458: aload 4
        //   460: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
        //   463: return
        //   464: aload 13
        //   466: astore 5
        //   468: aload 12
        //   470: astore 6
        //   472: aload_0
        //   473: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   476: aload 4
        //   478: invokevirtual 143	java/net/HttpURLConnection:getContentLength	()I
        //   481: invokestatic 146	com/mob/tools/utils/DownloadFileHelper:access$302	(Lcom/mob/tools/utils/DownloadFileHelper;I)I
        //   484: pop
        //   485: aload 13
        //   487: astore 5
        //   489: aload 12
        //   491: astore 6
        //   493: aload_0
        //   494: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   497: invokestatic 80	com/mob/tools/utils/DownloadFileHelper:access$300	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   500: istore_1
        //   501: iload_1
        //   502: ifgt +52 -> 554
        //   505: aload_0
        //   506: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   509: aload_0
        //   510: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   513: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   516: invokestatic 129	com/mob/tools/utils/DownloadFileHelper:access$700	(Lcom/mob/tools/utils/DownloadFileHelper;I)V
        //   519: aload_0
        //   520: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   523: invokestatic 132	com/mob/tools/utils/DownloadFileHelper:access$800	(Lcom/mob/tools/utils/DownloadFileHelper;)V
        //   526: new 148	java/lang/NullPointerException
        //   529: dup
        //   530: invokespecial 149	java/lang/NullPointerException:<init>	()V
        //   533: athrow
        //   534: return
        //   535: astore 4
        //   537: aload_0
        //   538: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   541: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   544: aload 4
        //   546: invokeinterface 153 2 0
        //   551: goto -17 -> 534
        //   554: aload 13
        //   556: astore 5
        //   558: aload 12
        //   560: astore 6
        //   562: aload_0
        //   563: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   566: aload_0
        //   567: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   570: invokestatic 80	com/mob/tools/utils/DownloadFileHelper:access$300	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   573: invokestatic 156	com/mob/tools/utils/DownloadFileHelper:access$400	(Lcom/mob/tools/utils/DownloadFileHelper;I)V
        //   576: aload 13
        //   578: astore 5
        //   580: aload 12
        //   582: astore 6
        //   584: aload 9
        //   586: aload_0
        //   587: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   590: invokestatic 80	com/mob/tools/utils/DownloadFileHelper:access$300	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   593: i2l
        //   594: invokevirtual 159	java/io/RandomAccessFile:setLength	(J)V
        //   597: goto -368 -> 229
        //   600: astore 10
        //   602: aload 5
        //   604: astore 8
        //   606: aload 4
        //   608: astore 5
        //   610: aload 8
        //   612: astore 6
        //   614: aload 9
        //   616: astore 7
        //   618: aload_0
        //   619: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   622: iconst_0
        //   623: invokestatic 162	com/mob/tools/utils/DownloadFileHelper:access$202	(Lcom/mob/tools/utils/DownloadFileHelper;I)I
        //   626: pop
        //   627: aload 4
        //   629: astore 5
        //   631: aload 8
        //   633: astore 6
        //   635: aload 9
        //   637: astore 7
        //   639: aload_0
        //   640: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   643: bipush 11
        //   645: invokestatic 122	com/mob/tools/utils/DownloadFileHelper:access$602	(Lcom/mob/tools/utils/DownloadFileHelper;I)I
        //   648: pop
        //   649: aload 4
        //   651: astore 5
        //   653: aload 8
        //   655: astore 6
        //   657: aload 9
        //   659: astore 7
        //   661: aload_0
        //   662: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   665: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   668: aload 10
        //   670: invokeinterface 153 2 0
        //   675: aload_0
        //   676: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   679: aload_0
        //   680: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   683: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   686: invokestatic 129	com/mob/tools/utils/DownloadFileHelper:access$700	(Lcom/mob/tools/utils/DownloadFileHelper;I)V
        //   689: aload_0
        //   690: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   693: invokestatic 132	com/mob/tools/utils/DownloadFileHelper:access$800	(Lcom/mob/tools/utils/DownloadFileHelper;)V
        //   696: aload 8
        //   698: invokevirtual 135	java/io/InputStream:close	()V
        //   701: aload 9
        //   703: invokevirtual 136	java/io/RandomAccessFile:close	()V
        //   706: aload 4
        //   708: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
        //   711: return
        //   712: astore 4
        //   714: aload_0
        //   715: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   718: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   721: aload 4
        //   723: invokeinterface 153 2 0
        //   728: return
        //   729: astore 4
        //   731: aload_0
        //   732: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   735: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   738: aload 4
        //   740: invokeinterface 153 2 0
        //   745: goto -282 -> 463
        //   748: aload 7
        //   750: astore 5
        //   752: aload 7
        //   754: astore 6
        //   756: aload_0
        //   757: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   760: invokestatic 165	com/mob/tools/utils/DownloadFileHelper:access$600	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   763: istore_2
        //   764: iload_2
        //   765: bipush 11
        //   767: if_icmpne +59 -> 826
        //   770: aload_0
        //   771: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   774: aload_0
        //   775: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   778: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   781: invokestatic 129	com/mob/tools/utils/DownloadFileHelper:access$700	(Lcom/mob/tools/utils/DownloadFileHelper;I)V
        //   784: aload_0
        //   785: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   788: invokestatic 132	com/mob/tools/utils/DownloadFileHelper:access$800	(Lcom/mob/tools/utils/DownloadFileHelper;)V
        //   791: aload 7
        //   793: invokevirtual 135	java/io/InputStream:close	()V
        //   796: aload 9
        //   798: invokevirtual 136	java/io/RandomAccessFile:close	()V
        //   801: aload 4
        //   803: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
        //   806: return
        //   807: astore 4
        //   809: aload_0
        //   810: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   813: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   816: aload 4
        //   818: invokeinterface 153 2 0
        //   823: goto -17 -> 806
        //   826: aload 7
        //   828: astore 5
        //   830: aload 7
        //   832: astore 6
        //   834: aload 7
        //   836: aload 8
        //   838: invokevirtual 101	java/io/InputStream:read	([B)I
        //   841: istore_3
        //   842: iload_1
        //   843: istore_2
        //   844: goto -567 -> 277
        //   847: aload_0
        //   848: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   851: aload_0
        //   852: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   855: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   858: invokestatic 129	com/mob/tools/utils/DownloadFileHelper:access$700	(Lcom/mob/tools/utils/DownloadFileHelper;I)V
        //   861: aload_0
        //   862: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   865: invokestatic 132	com/mob/tools/utils/DownloadFileHelper:access$800	(Lcom/mob/tools/utils/DownloadFileHelper;)V
        //   868: aload 7
        //   870: invokevirtual 135	java/io/InputStream:close	()V
        //   873: aload 9
        //   875: invokevirtual 136	java/io/RandomAccessFile:close	()V
        //   878: aload 4
        //   880: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
        //   883: return
        //   884: astore 4
        //   886: aload_0
        //   887: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   890: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   893: aload 4
        //   895: invokeinterface 153 2 0
        //   900: return
        //   901: astore 4
        //   903: aload_0
        //   904: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   907: aload_0
        //   908: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   911: invokestatic 61	com/mob/tools/utils/DownloadFileHelper:access$200	(Lcom/mob/tools/utils/DownloadFileHelper;)I
        //   914: invokestatic 129	com/mob/tools/utils/DownloadFileHelper:access$700	(Lcom/mob/tools/utils/DownloadFileHelper;I)V
        //   917: aload_0
        //   918: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   921: invokestatic 132	com/mob/tools/utils/DownloadFileHelper:access$800	(Lcom/mob/tools/utils/DownloadFileHelper;)V
        //   924: aload 6
        //   926: invokevirtual 135	java/io/InputStream:close	()V
        //   929: aload 7
        //   931: invokevirtual 136	java/io/RandomAccessFile:close	()V
        //   934: aload 5
        //   936: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
        //   939: aload 4
        //   941: athrow
        //   942: astore 5
        //   944: aload_0
        //   945: getfield 17	com/mob/tools/utils/DownloadFileHelper$1:this$0	Lcom/mob/tools/utils/DownloadFileHelper;
        //   948: invokestatic 114	com/mob/tools/utils/DownloadFileHelper:access$500	(Lcom/mob/tools/utils/DownloadFileHelper;)Lcom/mob/tools/utils/DownloadFileHelper$DownloadListener;
        //   951: aload 5
        //   953: invokeinterface 153 2 0
        //   958: goto -19 -> 939
        //   961: astore 8
        //   963: aload 9
        //   965: astore 7
        //   967: aload 4
        //   969: astore 5
        //   971: aload 8
        //   973: astore 4
        //   975: goto -72 -> 903
        //   978: astore 5
        //   980: aload 8
        //   982: astore 4
        //   984: aload 11
        //   986: astore 8
        //   988: aload 10
        //   990: astore 9
        //   992: aload 5
        //   994: astore 10
        //   996: goto -390 -> 606
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	999	0	this	1
        //   347	496	1	i	int
        //   276	568	2	j	int
        //   274	568	3	k	int
        //   52	425	4	localHttpURLConnection	java.net.HttpURLConnection
        //   535	172	4	localThrowable1	Throwable
        //   712	10	4	localThrowable2	Throwable
        //   729	73	4	localThrowable3	Throwable
        //   807	72	4	localThrowable4	Throwable
        //   884	10	4	localThrowable5	Throwable
        //   901	67	4	localObject1	Object
        //   973	10	4	localObject2	Object
        //   4	931	5	localObject3	Object
        //   942	10	5	localThrowable6	Throwable
        //   969	1	5	localObject4	Object
        //   978	15	5	localThrowable7	Throwable
        //   26	899	6	localObject5	Object
        //   30	936	7	localObject6	Object
        //   1	836	8	localObject7	Object
        //   961	20	8	localObject8	Object
        //   986	1	8	localObject9	Object
        //   16	975	9	localObject10	Object
        //   10	1	10	localObject11	Object
        //   600	389	10	localThrowable8	Throwable
        //   994	1	10	localThrowable9	Throwable
        //   13	972	11	localObject12	Object
        //   19	562	12	localObject13	Object
        //   22	555	13	localObject14	Object
        //   7	103	14	localObject15	Object
        // Exception table:
        //   from	to	target	type
        //   505	534	535	java/lang/Throwable
        //   143	153	600	java/lang/Throwable
        //   161	208	600	java/lang/Throwable
        //   216	229	600	java/lang/Throwable
        //   237	244	600	java/lang/Throwable
        //   252	259	600	java/lang/Throwable
        //   267	275	600	java/lang/Throwable
        //   290	299	600	java/lang/Throwable
        //   307	316	600	java/lang/Throwable
        //   324	346	600	java/lang/Throwable
        //   363	376	600	java/lang/Throwable
        //   390	400	600	java/lang/Throwable
        //   408	427	600	java/lang/Throwable
        //   472	485	600	java/lang/Throwable
        //   493	501	600	java/lang/Throwable
        //   562	576	600	java/lang/Throwable
        //   584	597	600	java/lang/Throwable
        //   756	764	600	java/lang/Throwable
        //   834	842	600	java/lang/Throwable
        //   675	711	712	java/lang/Throwable
        //   427	463	729	java/lang/Throwable
        //   770	806	807	java/lang/Throwable
        //   847	883	884	java/lang/Throwable
        //   32	54	901	finally
        //   70	78	901	finally
        //   94	101	901	finally
        //   117	135	901	finally
        //   618	627	901	finally
        //   639	649	901	finally
        //   661	675	901	finally
        //   903	939	942	java/lang/Throwable
        //   143	153	961	finally
        //   161	208	961	finally
        //   216	229	961	finally
        //   237	244	961	finally
        //   252	259	961	finally
        //   267	275	961	finally
        //   290	299	961	finally
        //   307	316	961	finally
        //   324	346	961	finally
        //   363	376	961	finally
        //   390	400	961	finally
        //   408	427	961	finally
        //   472	485	961	finally
        //   493	501	961	finally
        //   562	576	961	finally
        //   584	597	961	finally
        //   756	764	961	finally
        //   834	842	961	finally
        //   32	54	978	java/lang/Throwable
        //   70	78	978	java/lang/Throwable
        //   94	101	978	java/lang/Throwable
        //   117	135	978	java/lang/Throwable
      }
    }).start();
  }
  
  private int getCompleteSize()
  {
    int j = 0;
    int i = j;
    if (this.downloadInfo != null)
    {
      i = j;
      if (this.downloadInfo.containsKey("completeSize")) {
        i = ((Integer)this.downloadInfo.get("completeSize")).intValue();
      }
    }
    return i;
  }
  
  private void getDownloadInfo(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.sharePrefrence != null)) {
      this.downloadInfo = ((HashMap)this.sharePrefrence.get(Data.MD5(paramString)));
    }
    if (this.downloadInfo == null) {
      this.downloadInfo = new HashMap();
    }
  }
  
  private int getFileSize()
  {
    int j = 0;
    int i = j;
    if (this.downloadInfo != null)
    {
      i = j;
      if (this.downloadInfo.containsKey("fileSize")) {
        i = ((Integer)this.downloadInfo.get("fileSize")).intValue();
      }
    }
    return i;
  }
  
  private void init()
  {
    try
    {
      if ((TextUtils.isEmpty(this.fileUrl)) || (this.downloadListener == null))
      {
        if (this.downloadListener != null) {
          this.downloadListener.onError(new Throwable("The download-url and download-listener must not be null!"));
        }
      }
      else
      {
        getDownloadInfo(this.fileUrl);
        this.fileSize = getFileSize();
        this.completeSize = getCompleteSize();
        Object localObject = R.getCachePath(this.context, "download");
        if (TextUtils.isEmpty(this.downloadFileName)) {
          this.downloadFileName = (Data.MD5(this.fileUrl) + ".apk");
        }
        localObject = new File((String)localObject, this.downloadFileName);
        if (!((File)localObject).exists())
        {
          this.fileSize = 0;
          this.completeSize = 0;
          setCompleteSize(this.completeSize);
          ((File)localObject).createNewFile();
        }
        this.filePath = ((File)localObject).getAbsolutePath();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (this.downloadListener != null) {
        this.downloadListener.onError(localThrowable);
      }
    }
  }
  
  private void setCompleteSize(int paramInt)
  {
    if (this.downloadInfo != null) {
      this.downloadInfo.put("completeSize", Integer.valueOf(paramInt));
    }
  }
  
  private void setDownloadInfo()
  {
    if (this.sharePrefrence != null) {
      this.sharePrefrence.put(Data.MD5(this.fileUrl), this.downloadInfo);
    }
  }
  
  private void setFileSize(int paramInt)
  {
    if (this.downloadInfo != null) {
      this.downloadInfo.put("fileSize", Integer.valueOf(paramInt));
    }
  }
  
  public String getDownloadFilePath()
  {
    return this.filePath;
  }
  
  public void pause()
  {
    if (this.downloadListener != null)
    {
      this.state = 11;
      this.downloadListener.onPause();
    }
  }
  
  public void start()
    throws Throwable
  {
    if ((TextUtils.isEmpty(this.fileUrl)) || (this.downloadListener == null)) {
      if (this.downloadListener != null) {
        this.downloadListener.onError(new Throwable("The url of download file is null"));
      }
    }
    for (;;)
    {
      return;
      if (this.state == 12) {
        continue;
      }
      init();
      if (!this.startDownload)
      {
        this.startDownload = true;
        this.downloadListener.onStart();
      }
      File localFile = new File(this.filePath);
      if (localFile.exists())
      {
        if ((this.completeSize <= 0) || (this.completeSize != this.fileSize)) {
          break label138;
        }
        this.downloadListener.onComplete(this.filePath);
      }
      try
      {
        this.completeSize = 0;
        localFile.createNewFile();
        label138:
        if (this.state != 11) {
          continue;
        }
        this.state = 12;
        downloadFile();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
  
  public static abstract interface DownloadListener
  {
    public abstract void onComplete(String paramString);
    
    public abstract void onDownloading(int paramInt);
    
    public abstract void onError(Throwable paramThrowable);
    
    public abstract void onPause();
    
    public abstract void onStart();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\DownloadFileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */