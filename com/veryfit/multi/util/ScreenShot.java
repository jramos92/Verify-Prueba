package com.veryfit.multi.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ScreenShot
{
  private static void savePic(Bitmap paramBitmap, String paramString)
  {
    try
    {
      paramString = new FileOutputStream(paramString);
      if (paramString != null) {}
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 90, paramString);
        paramString.flush();
        paramString.close();
        return;
      }
      catch (IOException paramBitmap)
      {
        for (;;) {}
      }
      catch (FileNotFoundException paramBitmap)
      {
        for (;;) {}
      }
      paramBitmap = paramBitmap;
      paramBitmap.printStackTrace();
      return;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
      return;
    }
  }
  
  public static void shoot(Activity paramActivity)
  {
    savePic(takeScreenShot(paramActivity), Environment.getExternalStorageDirectory() + "/s_ido.png");
  }
  
  public static Bitmap takeScreenShot(Activity paramActivity)
  {
    View localView = paramActivity.getWindow().getDecorView();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    Bitmap localBitmap = localView.getDrawingCache();
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    System.out.println(i);
    int j = paramActivity.getWindowManager().getDefaultDisplay().getWidth();
    int k = paramActivity.getWindowManager().getDefaultDisplay().getHeight();
    if (Build.BRAND.equals("Meizu")) {}
    for (paramActivity = Bitmap.createBitmap(localBitmap, 0, i, j, k - i * 5);; paramActivity = Bitmap.createBitmap(localBitmap, 0, i, j, k - i))
    {
      localView.destroyDrawingCache();
      return paramActivity;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\ScreenShot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */