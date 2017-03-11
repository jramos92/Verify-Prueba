package com.project.library.util;

import android.util.Log;

public class DFUServiceParser
{
  private static DFUServiceParser mParserInstance;
  private final String DFU_SERVICE_UUID = "2148";
  private final int SERVICE_CLASS_128BIT_UUID = 6;
  private final String TAG = "DFUServiceParser";
  private boolean isValidDFUSensor = false;
  private int packetLength = 0;
  
  private void decodeService128BitUUID(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws Exception
  {
    Log.e("DFUServiceParser", "StartPosition: " + paramInt1 + " Data length: " + paramInt2);
    if ((Byte.toString(paramArrayOfByte[(paramInt1 + paramInt2 - 3)]) + Byte.toString(paramArrayOfByte[(paramInt1 + paramInt2 - 4)])).equals("2148")) {
      this.isValidDFUSensor = true;
    }
  }
  
  public static DFUServiceParser getDFUParser()
  {
    try
    {
      if (mParserInstance == null) {
        mParserInstance = new DFUServiceParser();
      }
      DFUServiceParser localDFUServiceParser = mParserInstance;
      return localDFUServiceParser;
    }
    finally {}
  }
  
  public void decodeDFUAdvData(byte[] paramArrayOfByte)
    throws Exception
  {
    this.isValidDFUSensor = false;
    if (paramArrayOfByte != null)
    {
      this.packetLength = paramArrayOfByte.length;
      int i = 0;
      if (i >= this.packetLength) {}
      int j;
      do
      {
        return;
        j = paramArrayOfByte[i];
      } while (j == 0);
      i += 1;
      if (paramArrayOfByte[i] == 6)
      {
        decodeService128BitUUID(paramArrayOfByte, i + 1, j - 1);
        i += j - 1;
      }
      for (;;)
      {
        i += 1;
        break;
        i += j - 1;
      }
    }
    Log.e("DFUServiceParser", "data is null!");
  }
  
  public boolean isValidDFUSensor()
  {
    return this.isValidDFUSensor;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\DFUServiceParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */