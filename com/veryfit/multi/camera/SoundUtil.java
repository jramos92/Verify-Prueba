package com.veryfit.multi.camera;

import android.content.Context;
import android.media.SoundPool;

public class SoundUtil
{
  private Context context;
  private int musicId = this.spl.load(paramContext, 2131034113, 1);
  private SoundPool spl = new SoundPool(10, 1, 5);
  
  public SoundUtil(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void destory()
  {
    if (this.spl != null) {
      this.spl.release();
    }
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public void play()
  {
    if ((this.spl != null) && (this.musicId != 0)) {
      this.spl.play(this.musicId, 1.0F, 1.0F, 0, 0, 1.0F);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\SoundUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */