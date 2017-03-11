package com.veryfit.multi.util;

public abstract interface Crypter
{
  public abstract String decrypt(String paramString);
  
  public abstract String encrypt(String paramString);
  
  public abstract void setKey(String paramString);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\Crypter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */