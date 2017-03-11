package cn.sharesdk.system.email;

import java.util.HashMap;

public abstract interface ActionListener
{
  public abstract void onComplete(HashMap<String, Object> paramHashMap);
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onStart(HashMap<String, Object> paramHashMap);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\system\email\ActionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */