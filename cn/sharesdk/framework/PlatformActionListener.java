package cn.sharesdk.framework;

import java.util.HashMap;

public abstract interface PlatformActionListener
{
  public abstract void onCancel(Platform paramPlatform, int paramInt);
  
  public abstract void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap);
  
  public abstract void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\PlatformActionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */