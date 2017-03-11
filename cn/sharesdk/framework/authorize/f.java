package cn.sharesdk.framework.authorize;

import android.content.Intent;

public abstract class f
{
  protected e a;
  protected int b;
  protected SSOListener c;
  
  public f(e parame)
  {
    this.a = parame;
    this.c = parame.a().getSSOListener();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Intent paramIntent) {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */