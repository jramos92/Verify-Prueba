package com.project.library.util;

import android.os.Handler;
import android.os.Looper;

public class PendingHandler
  extends Handler
{
  private boolean mPending = false;
  
  public PendingHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void pending(boolean paramBoolean)
  {
    try
    {
      this.mPending = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean pending()
  {
    try
    {
      boolean bool = this.mPending;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean postF(final Runnable paramRunnable)
  {
    try
    {
      removeCallbacksAndMessages(null);
      boolean bool = post(new Runnable()
      {
        public void run()
        {
          paramRunnable.run();
          PendingHandler.this.pending(false);
        }
      });
      if (bool) {
        this.mPending = true;
      }
      return bool;
    }
    finally {}
  }
  
  public boolean postT(final Runnable paramRunnable)
  {
    boolean bool1 = false;
    try
    {
      if (!this.mPending)
      {
        boolean bool2 = post(new Runnable()
        {
          public void run()
          {
            paramRunnable.run();
            PendingHandler.this.pending(false);
          }
        });
        bool1 = bool2;
        if (bool2)
        {
          this.mPending = true;
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\PendingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */