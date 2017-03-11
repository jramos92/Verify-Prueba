package com.mob.tools.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

public class R
{
  private static float density;
  private static int deviceWidth;
  private static Object rp;
  
  public static void clearCache(Context paramContext)
    throws Throwable
  {
    deleteFileAndFolder(new File(getCachePath(paramContext, null)));
  }
  
  public static String contentUriToPath(Context paramContext, Uri paramUri)
  {
    if (paramUri == null) {}
    for (;;)
    {
      return null;
      if (new File(paramUri.getPath()).exists()) {
        return paramUri.getPath();
      }
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      try
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          Class localClass = Class.forName("android.provider.DocumentsContract");
          Method localMethod = localClass.getMethod("isDocumentUri", new Class[] { Context.class, Uri.class });
          localMethod.setAccessible(true);
          localObject1 = localObject2;
          if (Boolean.TRUE.equals(localMethod.invoke(null, new Object[] { paramContext, paramUri })))
          {
            localObject1 = localClass.getMethod("getDocumentId", new Class[] { Uri.class });
            ((Method)localObject1).setAccessible(true);
            localObject1 = String.valueOf(localObject1.invoke(null, new Object[] { paramUri })).split(":")[1];
            localObject1 = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_data" }, "_id=?", new String[] { localObject1 }, null);
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = paramContext.getContentResolver().query(paramUri, null, null, null, null);
        }
        if (localObject2 != null)
        {
          paramContext = (Context)localObject3;
          if (((Cursor)localObject2).moveToFirst()) {
            paramContext = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("_data"));
          }
          ((Cursor)localObject2).close();
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        MobLog.getInstance().w(paramContext);
      }
    }
    return null;
  }
  
  public static void copyFile(FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream)
    throws Throwable
  {
    byte[] arrayOfByte = new byte[65536];
    for (int i = paramFileInputStream.read(arrayOfByte); i > 0; i = paramFileInputStream.read(arrayOfByte)) {
      paramFileOutputStream.write(arrayOfByte, 0, i);
    }
    paramFileInputStream.close();
    paramFileOutputStream.close();
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (!new File(paramString1).exists()) {
      return false;
    }
    try
    {
      copyFile(new FileInputStream(paramString1), new FileOutputStream(paramString2));
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static int[] covertTimeInYears(long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    if (paramLong <= 0L) {
      return new int[] { 0, 0 };
    }
    paramLong /= 1000L;
    if (paramLong < 60L) {
      return new int[] { (int)paramLong, 0 };
    }
    paramLong /= 60L;
    if (paramLong < 60L) {
      return new int[] { (int)paramLong, 1 };
    }
    paramLong /= 60L;
    if (paramLong < 24L) {
      return new int[] { (int)paramLong, 2 };
    }
    paramLong /= 24L;
    if (paramLong < 30L) {
      return new int[] { (int)paramLong, 3 };
    }
    paramLong /= 30L;
    if (paramLong < 12L) {
      return new int[] { (int)paramLong, 4 };
    }
    return new int[] { (int)(paramLong / 12L), 5 };
  }
  
  public static long dateStrToLong(String paramString)
  {
    return new SimpleDateFormat("yyyy-MM-dd").parse(paramString, new ParsePosition(0)).getTime();
  }
  
  public static long dateToLong(String paramString)
  {
    try
    {
      paramString = new Date(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      long l = localCalendar.getTimeInMillis();
      return l;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return 0L;
  }
  
  public static Bundle decodeUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString.length < 2) || (arrayOfString[1] == null)) {
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), "");
        }
        for (;;)
        {
          i += 1;
          break;
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
        }
      }
    }
    return localBundle;
  }
  
  public static void deleteFileAndFolder(File paramFile)
    throws Throwable
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    String[] arrayOfString = paramFile.list();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      File localFile = new File(paramFile, arrayOfString[i]);
      if (localFile.isDirectory()) {
        deleteFileAndFolder(localFile);
      }
      for (;;)
      {
        i += 1;
        break;
        localFile.delete();
      }
    }
    paramFile.delete();
  }
  
  public static void deleteFilesInFolder(File paramFile)
    throws Throwable
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    String[] arrayOfString;
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      arrayOfString = paramFile.list();
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    int j = arrayOfString.length;
    int i = 0;
    label44:
    File localFile;
    if (i < j)
    {
      localFile = new File(paramFile, arrayOfString[i]);
      if (!localFile.isDirectory()) {
        break label82;
      }
      deleteFilesInFolder(localFile);
    }
    for (;;)
    {
      i += 1;
      break label44;
      break;
      label82:
      localFile.delete();
    }
  }
  
  public static int designToDevice(Context paramContext, float paramFloat, int paramInt)
  {
    if (density <= 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt * density / paramFloat + 0.5F);
  }
  
  public static int designToDevice(Context paramContext, int paramInt1, int paramInt2)
  {
    if (deviceWidth == 0)
    {
      paramContext = getScreenSize(paramContext);
      if (paramContext[0] >= paramContext[1]) {
        break label44;
      }
    }
    label44:
    for (int i = paramContext[0];; i = paramContext[1])
    {
      deviceWidth = i;
      return (int)(paramInt2 * deviceWidth / paramInt1 + 0.5F);
    }
  }
  
  private static int digit(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 2) || (paramInt2 > 36))
    {
      paramInt1 = -1;
      return paramInt1;
    }
    int j = -1;
    int i;
    if ((48 <= paramInt1) && (paramInt1 <= 57)) {
      i = paramInt1 - 48;
    }
    for (;;)
    {
      paramInt1 = i;
      if (i < paramInt2) {
        break;
      }
      return -1;
      if ((97 <= paramInt1) && (paramInt1 <= 122))
      {
        i = paramInt1 - 97 + 10;
      }
      else
      {
        i = j;
        if (65 <= paramInt1)
        {
          i = j;
          if (paramInt1 <= 90) {
            i = paramInt1 - 65 + 10;
          }
        }
      }
    }
  }
  
  public static int dipToPx(Context paramContext, int paramInt)
  {
    if (density <= 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt * density + 0.5F);
  }
  
  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramBundle.get(str);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(Data.urlEncode(str) + "=" + Data.urlEncode(String.valueOf(localObject1)));
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String encodeUrl(ArrayList<KVPair<String>> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      paramArrayList = (KVPair)localIterator.next();
      if (i > 0) {
        localStringBuilder.append('&');
      }
      String str2 = paramArrayList.name;
      String str1 = (String)paramArrayList.value;
      if (str2 != null)
      {
        paramArrayList = str1;
        if (str1 == null) {
          paramArrayList = "";
        }
        localStringBuilder.append(Data.urlEncode(str2) + "=" + Data.urlEncode(paramArrayList));
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static int getAnimRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "anim", paramString);
  }
  
  public static int getBitmapRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "drawable", paramString);
  }
  
  public static String getCachePath(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getFilesDir().getAbsolutePath() + "/Mob/cache/";
    DeviceHelper localDeviceHelper = DeviceHelper.getInstance(paramContext);
    paramContext = (Context)localObject;
    if (localDeviceHelper.getSdcardState()) {
      paramContext = localDeviceHelper.getSdcardPath() + "/Mob/" + localDeviceHelper.getPackageName() + "/cache/";
    }
    localObject = paramContext;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramContext + paramString + "/";
    }
    paramContext = new File((String)localObject);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return (String)localObject;
  }
  
  public static String getCacheRoot(Context paramContext)
  {
    Object localObject = paramContext.getFilesDir().getAbsolutePath() + "/Mob/";
    DeviceHelper localDeviceHelper = DeviceHelper.getInstance(paramContext);
    paramContext = (Context)localObject;
    if (localDeviceHelper.getSdcardState()) {
      paramContext = localDeviceHelper.getSdcardPath() + "/Mob/";
    }
    localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramContext;
  }
  
  public static int getColorRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "color", paramString);
  }
  
  public static long getFileSize(File paramFile)
    throws Throwable
  {
    if (!paramFile.exists()) {
      return 0L;
    }
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int j = 0;
      int i = 0;
      while (i < arrayOfString.length)
      {
        File localFile = new File(paramFile, arrayOfString[i]);
        j = (int)(j + getFileSize(localFile));
        i += 1;
      }
      return j;
    }
    return paramFile.length();
  }
  
  public static long getFileSize(String paramString)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    return getFileSize(new File(paramString));
  }
  
  public static int getIdRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "id", paramString);
  }
  
  public static String getImageCachePath(Context paramContext)
  {
    return getCachePath(paramContext, "images");
  }
  
  public static int getLayoutRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "layout", paramString);
  }
  
  public static int getPluralsRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "plurals", paramString);
  }
  
  public static int getRawRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "raw", paramString);
  }
  
  public static int getResId(Context paramContext, String paramString1, String paramString2)
  {
    int j = 0;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    int i = j;
    if (rp != null) {}
    int k;
    try
    {
      Object localObject = rp.getClass().getMethod("getResId", new Class[] { Context.class, String.class, String.class });
      ((Method)localObject).setAccessible(true);
      i = ((Integer)((Method)localObject).invoke(rp, new Object[] { paramContext, paramString1, paramString2 })).intValue();
      k = i;
      if (i <= 0)
      {
        localObject = paramContext.getPackageName();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().d(localThrowable);
        i = j;
      }
      j = i;
      if (i <= 0)
      {
        i = paramContext.getResources().getIdentifier(paramString2, paramString1, localThrowable);
        j = i;
        if (i <= 0) {
          j = paramContext.getResources().getIdentifier(paramString2.toLowerCase(), paramString1, localThrowable);
        }
      }
      k = j;
      if (j <= 0)
      {
        System.err.println("failed to parse " + paramString1 + " resource \"" + paramString2 + "\"");
        k = j;
      }
    }
    return k;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return getScreenSize(paramContext)[1];
  }
  
  public static int[] getScreenSize(Context paramContext)
  {
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      if (paramContext == null) {
        return new int[] { 0, 0 };
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        MobLog.getInstance().w(paramContext);
        paramContext = null;
      }
      paramContext = paramContext.getDefaultDisplay();
      Object localObject;
      if (Build.VERSION.SDK_INT < 13)
      {
        localObject = new DisplayMetrics();
        paramContext.getMetrics((DisplayMetrics)localObject);
        return new int[] { ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels };
      }
      try
      {
        localObject = new Point();
        Method localMethod = paramContext.getClass().getMethod("getRealSize", new Class[] { Point.class });
        localMethod.setAccessible(true);
        localMethod.invoke(paramContext, new Object[] { localObject });
        int i = ((Point)localObject).x;
        int j = ((Point)localObject).y;
        return new int[] { i, j };
      }
      catch (Throwable paramContext)
      {
        MobLog.getInstance().w(paramContext);
      }
    }
    return tmp176_172;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return getScreenSize(paramContext)[0];
  }
  
  public static int getStringArrayRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "array", paramString);
  }
  
  public static int getStringRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "string", paramString);
  }
  
  public static int getStyleRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "style", paramString);
  }
  
  public static int getTextLengthInWord(String paramString)
  {
    int j;
    int i;
    if (paramString == null)
    {
      paramString = new char[0];
      j = 0;
      i = 0;
      label12:
      if (i >= paramString.length) {
        return j;
      }
      if (paramString[i] >= 'Ā') {
        break label48;
      }
    }
    label48:
    for (int k = 1;; k = 2)
    {
      j += k;
      i += 1;
      break label12;
      paramString = paramString.toCharArray();
      break;
    }
    return j;
  }
  
  private static Throwable invalidInt(String paramString)
    throws Throwable
  {
    throw new Throwable("Invalid int: \"" + paramString + "\"");
  }
  
  public static Date longToDate(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.getTime();
  }
  
  public static String longToTime(long paramLong, int paramInt)
  {
    String str = "yyyy-MM-dd kk:mm:ss";
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new SimpleDateFormat(str).format(Long.valueOf(paramLong));
      str = "yyyy-MM-dd kk:mm";
      continue;
      str = "yyyy-MM-dd kk";
      continue;
      str = "yyyy-MM-dd";
      continue;
      str = "yyyy-MM";
      continue;
      str = "yyyy";
    }
  }
  
  public static int parseInt(String paramString)
    throws Throwable
  {
    return parseInt(paramString, 10);
  }
  
  public static int parseInt(String paramString, int paramInt)
    throws Throwable
  {
    if ((paramInt < 2) || (paramInt > 36)) {
      throw new Throwable("Invalid radix: " + paramInt);
    }
    if (paramString == null) {
      throw invalidInt(paramString);
    }
    int k = paramString.length();
    int i = 0;
    if (k == 0) {
      throw invalidInt(paramString);
    }
    if (paramString.charAt(0) == '-') {}
    for (boolean bool = true; bool; bool = false)
    {
      int j = 0 + 1;
      i = j;
      if (j != k) {
        break;
      }
      throw invalidInt(paramString);
    }
    return parseInt(paramString, i, paramInt, bool);
  }
  
  private static int parseInt(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    throws Throwable
  {
    int k = Integer.MIN_VALUE / paramInt2;
    int j = 0;
    int m = paramString.length();
    int i = paramInt1;
    paramInt1 = j;
    while (i < m)
    {
      j = digit(paramString.charAt(i), paramInt2);
      if (j == -1) {
        throw invalidInt(paramString);
      }
      if (k > paramInt1) {
        throw invalidInt(paramString);
      }
      j = paramInt1 * paramInt2 - j;
      if (j > paramInt1) {
        throw invalidInt(paramString);
      }
      paramInt1 = j;
      i += 1;
    }
    paramInt2 = paramInt1;
    if (!paramBoolean)
    {
      paramInt1 = -paramInt1;
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        throw invalidInt(paramString);
      }
    }
    return paramInt2;
  }
  
  public static long parseLong(String paramString)
    throws Throwable
  {
    return parseLong(paramString, 10);
  }
  
  public static long parseLong(String paramString, int paramInt)
    throws Throwable
  {
    if ((paramInt < 2) || (paramInt > 36)) {
      throw new Throwable("Invalid radix: " + paramInt);
    }
    if (paramString == null) {
      throw new Throwable("Invalid long: \"" + paramString + "\"");
    }
    int k = paramString.length();
    int i = 0;
    if (k == 0) {
      throw new Throwable("Invalid long: \"" + paramString + "\"");
    }
    if (paramString.charAt(0) == '-') {}
    for (boolean bool = true; bool; bool = false)
    {
      int j = 0 + 1;
      i = j;
      if (j != k) {
        break;
      }
      throw new Throwable("Invalid long: \"" + paramString + "\"");
    }
    return parseLong(paramString, i, paramInt, bool);
  }
  
  private static long parseLong(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    throws Throwable
  {
    long l3 = Long.MIN_VALUE / paramInt2;
    long l1 = 0L;
    long l4 = paramString.length();
    while (paramInt1 < l4)
    {
      int i = digit(paramString.charAt(paramInt1), paramInt2);
      if (i == -1) {
        throw new Throwable("Invalid long: \"" + paramString + "\"");
      }
      if (l3 > l1) {
        throw new Throwable("Invalid long: \"" + paramString + "\"");
      }
      l2 = paramInt2 * l1 - i;
      if (l2 > l1) {
        throw new Throwable("Invalid long: \"" + paramString + "\"");
      }
      l1 = l2;
      paramInt1 += 1;
    }
    long l2 = l1;
    if (!paramBoolean)
    {
      l1 = -l1;
      l2 = l1;
      if (l1 < 0L) {
        throw new Throwable("Invalid long: \"" + paramString + "\"");
      }
    }
    return l2;
  }
  
  public static Uri pathToContentUri(Context paramContext, String paramString)
  {
    Object localObject = null;
    Cursor localCursor = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=? ", new String[] { paramString }, null);
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      i = localCursor.getInt(localCursor.getColumnIndex("_id"));
      localObject = Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i);
    }
    while (!new File(paramString).exists())
    {
      int i;
      return (Uri)localObject;
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("_data", paramString);
    paramString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    return paramContext.getContentResolver().insert(paramString, (ContentValues)localObject);
  }
  
  public static int pxToDip(Context paramContext, int paramInt)
  {
    if (density <= 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt / density + 0.5F);
  }
  
  /* Error */
  public static Object readObjectFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +76 -> 80
    //   7: new 21	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 45	java/io/File:exists	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifne +64 -> 86
    //   25: aconst_null
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +52 -> 80
    //   31: new 618	java/io/ObjectInputStream
    //   34: dup
    //   35: new 620	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: new 153	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 622	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 625	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: invokespecial 626	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 629	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   58: astore_2
    //   59: aload_0
    //   60: invokevirtual 630	java/io/ObjectInputStream:close	()V
    //   63: aload_2
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 633	java/lang/Throwable:printStackTrace	()V
    //   70: aconst_null
    //   71: astore_0
    //   72: goto -45 -> 27
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 633	java/lang/Throwable:printStackTrace	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: goto -17 -> 66
    //   86: goto -59 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramString	String
    //   20	2	1	bool	boolean
    //   58	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	65	java/lang/Throwable
    //   31	63	75	java/lang/Throwable
    //   16	21	82	java/lang/Throwable
  }
  
  public static boolean saveObjectToFile(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          paramString = new File(paramString);
          paramString.printStackTrace();
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            try
            {
              if (paramString.exists()) {
                paramString.delete();
              }
              if (!paramString.getParentFile().exists()) {
                paramString.getParentFile().mkdirs();
              }
              paramString.createNewFile();
              if (paramString == null) {
                continue;
              }
            }
            catch (Throwable paramString)
            {
              continue;
            }
            try
            {
              paramString = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(paramString)));
              paramString.writeObject(paramObject);
              paramString.flush();
              paramString.close();
              return true;
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
            }
          }
          paramString = paramString;
        }
        paramString = null;
      }
    }
    return false;
  }
  
  @Deprecated
  public static void setCacheRoot(String paramString) {}
  
  public static void setResourceProvider(Object paramObject)
  {
    try
    {
      if (paramObject.getClass().getMethod("getResId", new Class[] { Context.class, String.class, String.class }) != null) {
        rp = paramObject;
      }
      return;
    }
    catch (Throwable paramObject)
    {
      MobLog.getInstance().d((Throwable)paramObject);
    }
  }
  
  public static long strToDate(String paramString)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString, new ParsePosition(0)).getTime();
  }
  
  public static String toString(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return paramObject.toString();
  }
  
  public static String toWordText(String paramString, int paramInt)
  {
    paramString = paramString.toCharArray();
    int i = paramInt * 2;
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length;
    paramInt = 0;
    while (paramInt < k)
    {
      char c = paramString[paramInt];
      if (c < 'Ā') {}
      for (int j = 1;; j = 2)
      {
        i -= j;
        if (i >= 0) {
          break;
        }
        return localStringBuilder.toString();
      }
      localStringBuilder.append(c);
      paramInt += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Bundle urlToBundle(String paramString)
  {
    int i = paramString.indexOf("://");
    if (i >= 0) {}
    for (paramString = "http://" + paramString.substring(i + 1);; paramString = "http://" + paramString) {
      try
      {
        paramString = new URL(paramString);
        Bundle localBundle = decodeUrl(paramString.getQuery());
        localBundle.putAll(decodeUrl(paramString.getRef()));
        return localBundle;
      }
      catch (Throwable paramString)
      {
        MobLog.getInstance().w(paramString);
      }
    }
    return new Bundle();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\R.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */