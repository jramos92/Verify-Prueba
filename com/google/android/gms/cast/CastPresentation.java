package com.google.android.gms.cast;

import android.app.Presentation;
import android.content.Context;
import android.view.Display;
import android.view.Window;

public abstract class CastPresentation
  extends Presentation
{
  public CastPresentation(Context paramContext, Display paramDisplay)
  {
    super(paramContext, paramDisplay);
    zzmk();
  }
  
  public CastPresentation(Context paramContext, Display paramDisplay, int paramInt)
  {
    super(paramContext, paramDisplay, paramInt);
    zzmk();
  }
  
  private void zzmk()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.setType(2030);
      localWindow.addFlags(268435456);
      localWindow.addFlags(16777216);
      localWindow.addFlags(1024);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\CastPresentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */