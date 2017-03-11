package com.project.library.util;

import android.os.Handler;
import java.lang.ref.WeakReference;

public abstract class WeakHandler<T>
  extends Handler
{
  private WeakReference<T> mOwner;
  
  public WeakHandler(T paramT)
  {
    this.mOwner = new WeakReference(paramT);
  }
  
  public T getOwner()
  {
    return (T)this.mOwner.get();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\WeakHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */