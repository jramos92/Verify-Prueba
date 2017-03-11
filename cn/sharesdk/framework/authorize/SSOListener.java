package cn.sharesdk.framework.authorize;

import android.os.Bundle;

public abstract interface SSOListener
{
  public abstract void onCancel();
  
  public abstract void onComplete(Bundle paramBundle);
  
  public abstract void onFailed(Throwable paramThrowable);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\SSOListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */