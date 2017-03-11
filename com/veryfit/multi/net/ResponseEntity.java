package com.veryfit.multi.net;

import java.io.Serializable;

public class ResponseEntity<T>
  implements Serializable
{
  private static final long serialVersionUID = -1L;
  private T data;
  private int errorCode;
  private String errorMessage;
  private int state;
  
  public ResponseEntity(int paramInt)
  {
    this(0, paramInt, null);
  }
  
  public ResponseEntity(int paramInt1, int paramInt2, String paramString)
  {
    this.errorCode = paramInt1;
    this.state = paramInt2;
    this.errorMessage = paramString;
  }
  
  public ResponseEntity(int paramInt, String paramString)
  {
    this(0, paramInt, paramString);
  }
  
  public T getData()
  {
    return (T)this.data;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setData(T paramT)
  {
    this.data = paramT;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorMessage(String paramString)
  {
    this.errorMessage = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public String toString()
  {
    return "ResponseEntity{state=" + this.state + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + '}';
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\ResponseEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */