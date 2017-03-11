package com.veryfit.multi.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.Random;

public class ValidateCode
{
  private static final int BASE_PADDING_LEFT = 10;
  private static final int BASE_PADDING_TOP = 15;
  private static final char[] CHARS = { 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
  private static final int RANGE_PADDING_LEFT = 7;
  private static final int RANGE_PADDING_TOP = 15;
  private static ValidateCode bmpCode;
  private int base_padding_left = 10;
  private int base_padding_top = 15;
  private String code;
  private int codeLength = 6;
  private int font_size = 20;
  private int height = 40;
  private int padding_left;
  private int padding_top;
  private Random random = new Random();
  private int range_padding_left = 7;
  private int range_padding_top = 15;
  private int width = 100;
  
  private String createCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i >= this.codeLength) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(CHARS[this.random.nextInt(CHARS.length)]);
      i += 1;
    }
  }
  
  public static ValidateCode getInstance()
  {
    if (bmpCode == null) {
      bmpCode = new ValidateCode();
    }
    return bmpCode;
  }
  
  private int randomColor()
  {
    return randomColor(1);
  }
  
  private int randomColor(int paramInt)
  {
    return Color.rgb(this.random.nextInt(256) / paramInt, this.random.nextInt(256) / paramInt, this.random.nextInt(256) / paramInt);
  }
  
  private void randomPadding()
  {
    this.padding_left += this.base_padding_left + this.random.nextInt(this.range_padding_left);
    this.padding_top = (this.base_padding_top + this.random.nextInt(this.range_padding_top));
  }
  
  private void randomTextStyle(Paint paramPaint)
  {
    paramPaint.setColor(randomColor());
    paramPaint.setFakeBoldText(this.random.nextBoolean());
    float f = this.random.nextInt(11) / 10;
    if (this.random.nextBoolean()) {}
    for (;;)
    {
      paramPaint.setTextSkewX(f);
      return;
      f = -f;
    }
  }
  
  public Bitmap createBitmap()
  {
    this.padding_left = 0;
    Bitmap localBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.code = createCode();
    localCanvas.drawColor(-1433037419);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(this.font_size);
    int i = 0;
    for (;;)
    {
      if (i >= this.code.length())
      {
        localCanvas.save(31);
        localCanvas.restore();
        return localBitmap;
      }
      randomTextStyle(localPaint);
      randomPadding();
      localCanvas.drawText(this.code.charAt(i), this.padding_left, this.padding_top, localPaint);
      i += 1;
    }
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\ValidateCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */