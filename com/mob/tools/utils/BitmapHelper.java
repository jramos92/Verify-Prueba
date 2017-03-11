package com.mob.tools.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;

public class BitmapHelper
{
  public static Bitmap blur(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramInt1 = (int)(paramInt1 / paramInt2 + 0.5F);
    Bitmap localBitmap = Bitmap.createBitmap((int)(i / paramInt2 + 0.5F), (int)(j / paramInt2 + 0.5F), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(1.0F / paramInt2, 1.0F / paramInt2);
    Paint localPaint = new Paint();
    localPaint.setFlags(2);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    blur(localBitmap, paramInt1, true);
    return localBitmap;
  }
  
  private static Bitmap blur(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (paramInt < 1)
    {
      return null;
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    }
    int i10 = paramBitmap.getWidth();
    int i11 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i10 * i11];
    paramBitmap.getPixels(arrayOfInt1, 0, i10, 0, 0, i10, i11);
    int i15 = i10 - 1;
    int i12 = i11 - 1;
    int i = i10 * i11;
    int i13 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i10, i11)];
    i = i13 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int i7 = 0;
    int i5 = 0;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i13, 3 });
    int i14 = paramInt + 1;
    int i6 = 0;
    int i1;
    int i3;
    int i4;
    int n;
    int i2;
    int k;
    int m;
    int i8;
    int i9;
    int[] arrayOfInt7;
    int i17;
    int i16;
    while (i6 < i11)
    {
      i1 = 0;
      i3 = 0;
      i4 = 0;
      j = 0;
      n = 0;
      i2 = 0;
      i = 0;
      k = 0;
      m = 0;
      i8 = -paramInt;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i15, Math.max(i8, 0)) + i7)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i14 - Math.abs(i8);
        i4 += arrayOfInt7[0] * i9;
        i3 += arrayOfInt7[1] * i9;
        i1 += arrayOfInt7[2] * i9;
        if (i8 > 0)
        {
          m += arrayOfInt7[0];
          k += arrayOfInt7[1];
          i += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i2 += arrayOfInt7[0];
          n += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
      }
      i9 = paramInt;
      i8 = 0;
      while (i8 < i10)
      {
        arrayOfInt2[i7] = arrayOfInt6[i4];
        arrayOfInt3[i7] = arrayOfInt6[i3];
        arrayOfInt4[i7] = arrayOfInt6[i1];
        arrayOfInt7 = arrayOfInt[((i9 - paramInt + i13) % i13)];
        int i18 = arrayOfInt7[0];
        i17 = arrayOfInt7[1];
        i16 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[i8] = Math.min(i8 + paramInt + 1, i15);
        }
        int i19 = arrayOfInt1[(arrayOfInt5[i8] + i5)];
        arrayOfInt7[0] = ((0xFF0000 & i19) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i19) >> 8);
        arrayOfInt7[2] = (i19 & 0xFF);
        m += arrayOfInt7[0];
        k += arrayOfInt7[1];
        i += arrayOfInt7[2];
        i4 = i4 - i2 + m;
        i3 = i3 - n + k;
        i1 = i1 - j + i;
        i9 = (i9 + 1) % i13;
        arrayOfInt7 = arrayOfInt[(i9 % i13)];
        i2 = i2 - i18 + arrayOfInt7[0];
        n = n - i17 + arrayOfInt7[1];
        j = j - i16 + arrayOfInt7[2];
        m -= arrayOfInt7[0];
        k -= arrayOfInt7[1];
        i -= arrayOfInt7[2];
        i7 += 1;
        i8 += 1;
      }
      i5 += i10;
      i6 += 1;
    }
    i = 0;
    while (i < i10)
    {
      i2 = 0;
      i4 = 0;
      i5 = 0;
      k = 0;
      i1 = 0;
      i3 = 0;
      j = 0;
      m = 0;
      n = 0;
      i6 = -paramInt * i10;
      i7 = -paramInt;
      if (i7 <= paramInt)
      {
        i8 = Math.max(0, i6) + i;
        arrayOfInt7 = arrayOfInt[(i7 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i8];
        arrayOfInt7[1] = arrayOfInt3[i8];
        arrayOfInt7[2] = arrayOfInt4[i8];
        i9 = i14 - Math.abs(i7);
        i5 += arrayOfInt2[i8] * i9;
        i4 += arrayOfInt3[i8] * i9;
        i2 += arrayOfInt4[i8] * i9;
        if (i7 > 0)
        {
          n += arrayOfInt7[0];
          m += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 = i6;
          if (i7 < i12) {
            i8 = i6 + i10;
          }
          i7 += 1;
          i6 = i8;
          break;
          i3 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          k += arrayOfInt7[2];
        }
      }
      i7 = i;
      i8 = paramInt;
      i6 = 0;
      while (i6 < i11)
      {
        arrayOfInt1[i7] = (0xFF000000 & arrayOfInt1[i7] | arrayOfInt6[i5] << 16 | arrayOfInt6[i4] << 8 | arrayOfInt6[i2]);
        arrayOfInt7 = arrayOfInt[((i8 - paramInt + i13) % i13)];
        i16 = arrayOfInt7[0];
        i15 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[i6] = (Math.min(i6 + i14, i12) * i10);
        }
        i17 = i + arrayOfInt5[i6];
        arrayOfInt7[0] = arrayOfInt2[i17];
        arrayOfInt7[1] = arrayOfInt3[i17];
        arrayOfInt7[2] = arrayOfInt4[i17];
        n += arrayOfInt7[0];
        m += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i5 = i5 - i3 + n;
        i4 = i4 - i1 + m;
        i2 = i2 - k + j;
        i8 = (i8 + 1) % i13;
        arrayOfInt7 = arrayOfInt[i8];
        i3 = i3 - i16 + arrayOfInt7[0];
        i1 = i1 - i15 + arrayOfInt7[1];
        k = k - i9 + arrayOfInt7[2];
        n -= arrayOfInt7[0];
        m -= arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i7 += i10;
        i6 += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i10, 0, 0, i10, i11);
    return paramBitmap;
  }
  
  private static boolean bytesStartWith(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == paramArrayOfByte2) {}
    for (;;)
    {
      return true;
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
        return false;
      }
      if (paramArrayOfByte1.length < paramArrayOfByte2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static Bitmap captureView(View paramView, int paramInt1, int paramInt2)
    throws Throwable
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  public static Bitmap cropBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws Throwable
  {
    paramInt3 = paramBitmap.getWidth() - paramInt1 - paramInt3;
    paramInt4 = paramBitmap.getHeight() - paramInt2 - paramInt4;
    if ((paramInt3 == paramBitmap.getWidth()) && (paramInt4 == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localCanvas.drawBitmap(paramBitmap, -paramInt1, -paramInt2, localPaint);
    return localBitmap;
  }
  
  public static String downloadBitmap(Context paramContext, String paramString)
    throws Throwable
  {
    return new NetworkHelper().downloadCache(paramContext, paramString, "images", true, null);
  }
  
  public static int[] fixRect(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramArrayOfInt1[0] / paramArrayOfInt1[1] > paramArrayOfInt2[0] / paramArrayOfInt2[1])
    {
      arrayOfInt[0] = paramArrayOfInt2[0];
      arrayOfInt[1] = ((int)(paramArrayOfInt1[1] * paramArrayOfInt2[0] / paramArrayOfInt1[0] + 0.5F));
      return arrayOfInt;
    }
    arrayOfInt[1] = paramArrayOfInt2[1];
    arrayOfInt[0] = ((int)(paramArrayOfInt1[0] * paramArrayOfInt2[1] / paramArrayOfInt1[1] + 0.5F));
    return arrayOfInt;
  }
  
  public static int[] fixRect_2(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramArrayOfInt1[0] / paramArrayOfInt1[1] > paramArrayOfInt2[0] / paramArrayOfInt2[1])
    {
      arrayOfInt[1] = paramArrayOfInt2[1];
      arrayOfInt[0] = ((int)(paramArrayOfInt1[0] * paramArrayOfInt2[1] / paramArrayOfInt1[1] + 0.5F));
      return arrayOfInt;
    }
    arrayOfInt[0] = paramArrayOfInt2[0];
    arrayOfInt[1] = ((int)(paramArrayOfInt1[1] * paramArrayOfInt2[0] / paramArrayOfInt1[0] + 0.5F));
    return arrayOfInt;
  }
  
  public static Bitmap getBitmap(Context paramContext, String paramString)
    throws Throwable
  {
    return getBitmap(downloadBitmap(paramContext, paramString));
  }
  
  public static Bitmap getBitmap(File paramFile, int paramInt)
    throws Throwable
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return null;
    }
    paramFile = new FileInputStream(paramFile);
    Bitmap localBitmap = getBitmap(paramFile, paramInt);
    paramFile.close();
    return localBitmap;
  }
  
  public static Bitmap getBitmap(InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
  }
  
  public static Bitmap getBitmap(String paramString)
    throws Throwable
  {
    return getBitmap(paramString, 1);
  }
  
  public static Bitmap getBitmap(String paramString, int paramInt)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return getBitmap(new File(paramString), paramInt);
  }
  
  public static Bitmap.CompressFormat getBmpFormat(String paramString)
  {
    String str = paramString.toLowerCase();
    if ((str.endsWith("png")) || (str.endsWith("gif"))) {
      return Bitmap.CompressFormat.PNG;
    }
    if ((str.endsWith("jpg")) || (str.endsWith("jpeg")) || (str.endsWith("bmp")) || (str.endsWith("tif"))) {
      return Bitmap.CompressFormat.JPEG;
    }
    paramString = getMime(paramString);
    if ((paramString.endsWith("png")) || (paramString.endsWith("gif"))) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  public static Bitmap.CompressFormat getBmpFormat(byte[] paramArrayOfByte)
  {
    String str = getMime(paramArrayOfByte);
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG;
    paramArrayOfByte = localCompressFormat;
    if (str != null) {
      if (!str.endsWith("png"))
      {
        paramArrayOfByte = localCompressFormat;
        if (!str.endsWith("gif")) {}
      }
      else
      {
        paramArrayOfByte = Bitmap.CompressFormat.PNG;
      }
    }
    return paramArrayOfByte;
  }
  
  private static String getMime(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[8];
      paramString.read(arrayOfByte);
      paramString.close();
      paramString = getMime(arrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  private static String getMime(byte[] paramArrayOfByte)
  {
    if (!bytesStartWith(paramArrayOfByte, new byte[] { -1, -40, -1, -32 }))
    {
      if (!bytesStartWith(paramArrayOfByte, new byte[] { -1, -40, -1, -31 })) {}
    }
    else {
      return "jpg";
    }
    if (bytesStartWith(paramArrayOfByte, new byte[] { -119, 80, 78, 71 })) {
      return "png";
    }
    if (bytesStartWith(paramArrayOfByte, "GIF".getBytes())) {
      return "gif";
    }
    if (bytesStartWith(paramArrayOfByte, "BM".getBytes())) {
      return "bmp";
    }
    if (!bytesStartWith(paramArrayOfByte, new byte[] { 73, 73, 42 }))
    {
      if (!bytesStartWith(paramArrayOfByte, new byte[] { 77, 77, 42 })) {}
    }
    else {
      return "tif";
    }
    return null;
  }
  
  public static boolean isBlackBitmap(Bitmap paramBitmap)
    throws Throwable
  {
    boolean bool = false;
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      bool = true;
      return bool;
    }
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < arrayOfInt.length)
      {
        if ((arrayOfInt[i] & 0xFFFFFF) != 0) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        return true;
      }
      i += 1;
    }
  }
  
  public static int mixAlpha(int paramInt1, int paramInt2)
  {
    int i = paramInt1 >>> 24;
    return 0xFF000000 | (i * ((0xFF0000 & paramInt1) >>> 16) + (255 - i) * ((0xFF0000 & paramInt2) >>> 16)) / 255 << 16 | (i * ((0xFF00 & paramInt1) >>> 8) + (255 - i) * ((0xFF00 & paramInt2) >>> 8)) / 255 << 8 | (i * (paramInt1 & 0xFF) + (255 - i) * (paramInt2 & 0xFF)) / 255;
  }
  
  public static Bitmap roundBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    throws Throwable
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Rect localRect1 = new Rect(0, 0, i, j);
    if ((i != paramInt1) || (j != paramInt2)) {}
    for (Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);; localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      Object localObject = new float[8];
      localObject[0] = paramFloat1;
      localObject[1] = paramFloat1;
      localObject[2] = paramFloat2;
      localObject[3] = paramFloat2;
      localObject[4] = paramFloat3;
      localObject[5] = paramFloat3;
      localObject[6] = paramFloat4;
      localObject[7] = paramFloat4;
      localObject = new ShapeDrawable(new RoundRectShape((float[])localObject, new RectF(0.0F, 0.0F, 0.0F, 0.0F), (float[])localObject));
      ((ShapeDrawable)localObject).setBounds(localRect2);
      ((ShapeDrawable)localObject).draw(localCanvas);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
  }
  
  public static String saveBitmap(Context paramContext, Bitmap paramBitmap)
    throws Throwable
  {
    return saveBitmap(paramContext, paramBitmap, Bitmap.CompressFormat.JPEG, 80);
  }
  
  public static String saveBitmap(Context paramContext, Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
    throws Throwable
  {
    Object localObject = R.getCachePath(paramContext, "images");
    paramContext = ".jpg";
    if (paramCompressFormat == Bitmap.CompressFormat.PNG) {
      paramContext = ".png";
    }
    paramContext = new File((String)localObject, String.valueOf(System.currentTimeMillis()) + paramContext);
    localObject = new FileOutputStream(paramContext);
    paramBitmap.compress(paramCompressFormat, paramInt, (OutputStream)localObject);
    ((FileOutputStream)localObject).flush();
    ((FileOutputStream)localObject).close();
    return paramContext.getAbsolutePath();
  }
  
  public static String saveViewToImage(View paramView)
    throws Throwable
  {
    if (paramView == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramView.getWidth();
      j = paramView.getHeight();
    } while ((i <= 0) || (j <= 0));
    return saveViewToImage(paramView, i, j);
  }
  
  public static String saveViewToImage(View paramView, int paramInt1, int paramInt2)
    throws Throwable
  {
    Bitmap localBitmap = captureView(paramView, paramInt1, paramInt2);
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
      return null;
    }
    paramView = new File(R.getCachePath(paramView.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
    FileOutputStream localFileOutputStream = new FileOutputStream(paramView);
    localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    return paramView.getAbsolutePath();
  }
  
  public static Bitmap scaleBitmapByHeight(Context paramContext, int paramInt1, int paramInt2)
    throws Throwable
  {
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt1);
    if (paramInt2 != paramContext.getHeight()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Bitmap localBitmap = scaleBitmapByHeight(paramContext, paramInt2);
      if (paramInt1 != 0) {
        paramContext.recycle();
      }
      return localBitmap;
    }
  }
  
  public static Bitmap scaleBitmapByHeight(Bitmap paramBitmap, int paramInt)
    throws Throwable
  {
    return Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() * paramInt / paramBitmap.getHeight(), paramInt, true);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\BitmapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */