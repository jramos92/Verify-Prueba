package com.mob.tools;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public abstract class SSDKHandlerThread
  implements Handler.Callback
{
  private static final int MSG_START = -1;
  private static final int MSG_STOP = -2;
  protected final Handler handler;
  private String name;
  
  public SSDKHandlerThread(String paramString)
  {
    this.name = paramString;
    paramString = new HandlerThread(paramString);
    paramString.start();
    this.handler = new Handler(paramString.getLooper(), this);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      onMessage(paramMessage);
    }
    for (;;)
    {
      return false;
      onStart(paramMessage);
      continue;
      onStop(paramMessage);
    }
  }
  
  protected abstract void onMessage(Message paramMessage);
  
  protected void onStart(Message paramMessage) {}
  
  protected void onStop(Message paramMessage) {}
  
  public void startThread()
  {
    startThread(0, 0, null);
  }
  
  public void startThread(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = -1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramObject;
    this.handler.sendMessage(localMessage);
  }
  
  public void stopThread()
  {
    stopThread(0, 0, null);
  }
  
  public void stopThread(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = -2;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramObject;
    this.handler.sendMessage(localMessage);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\SSDKHandlerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */