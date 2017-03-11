package no.nordicsemi.android.dfu.exception;

public class UnknownResponseException
  extends Exception
{
  private static final char[] HEX_ARRAY = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final long serialVersionUID = -8716125467309979289L;
  private final int mExpectedOpCode;
  private final byte[] mResponse;
  
  public UnknownResponseException(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramString);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      this.mResponse = paramArrayOfByte;
      this.mExpectedOpCode = paramInt;
      return;
      paramArrayOfByte = new byte[0];
    }
  }
  
  public static String bytesToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= paramInt1) || (paramInt2 <= 0)) {
      return "";
    }
    int i = Math.min(paramInt2, paramArrayOfByte.length - paramInt1);
    char[] arrayOfChar = new char[i * 2];
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 >= i) {
        return "0x" + new String(arrayOfChar);
      }
      int j = paramArrayOfByte[(paramInt1 + paramInt2)] & 0xFF;
      arrayOfChar[(paramInt2 * 2)] = HEX_ARRAY[(j >>> 4)];
      arrayOfChar[(paramInt2 * 2 + 1)] = HEX_ARRAY[(j & 0xF)];
      paramInt2 += 1;
    }
  }
  
  public String getMessage()
  {
    return String.format("%s (response: %s, expected: 0x10%02X..)", new Object[] { super.getMessage(), bytesToHex(this.mResponse, 0, this.mResponse.length), Integer.valueOf(this.mExpectedOpCode) });
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\exception\UnknownResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */