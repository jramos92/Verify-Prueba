package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzlu
  extends ImageView
{
  private int zzaeA;
  private zza zzaeB;
  private int zzaeC;
  private float zzaeD;
  private Uri zzaey;
  private int zzaez;
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.zzaeB != null) {
      paramCanvas.clipPath(this.zzaeB.zzk(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (this.zzaeA != 0) {
      paramCanvas.drawColor(this.zzaeA);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    switch (this.zzaeC)
    {
    default: 
      return;
    case 1: 
      paramInt1 = getMeasuredHeight();
      paramInt2 = (int)(paramInt1 * this.zzaeD);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = getMeasuredWidth();
      paramInt1 = (int)(paramInt2 / this.zzaeD);
    }
  }
  
  public void zzbA(int paramInt)
  {
    this.zzaez = paramInt;
  }
  
  public void zzj(Uri paramUri)
  {
    this.zzaey = paramUri;
  }
  
  public int zzoH()
  {
    return this.zzaez;
  }
  
  public static abstract interface zza
  {
    public abstract Path zzk(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzlu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */