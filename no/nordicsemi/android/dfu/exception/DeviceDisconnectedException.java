package no.nordicsemi.android.dfu.exception;

public class DeviceDisconnectedException
  extends Exception
{
  private static final long serialVersionUID = -6901728550661937942L;
  private final int mState;
  
  public DeviceDisconnectedException(String paramString, int paramInt)
  {
    super(paramString);
    this.mState = paramInt;
  }
  
  public int getConnectionState()
  {
    return this.mState;
  }
  
  public String getMessage()
  {
    return super.getMessage() + " (connection state: " + this.mState + ")";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\exception\DeviceDisconnectedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */