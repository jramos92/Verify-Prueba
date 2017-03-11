package no.nordicsemi.android.error;

public class GattError
{
  public static String parse(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if ((paramInt & 0x2000) > 0) {}
      switch (paramInt & 0xDFFF)
      {
      default: 
        return "UNKNOWN (" + paramInt + ")";
      }
    case 1: 
      return "GATT INVALID HANDLE";
    case 2: 
      return "GATT READ NOT PERMIT";
    case 3: 
      return "GATT WRITE NOT PERMIT";
    case 4: 
      return "GATT INVALID PDU";
    case 5: 
      return "GATT INSUF AUTHENTICATION";
    case 6: 
      return "GATT REQ NOT SUPPORTED";
    case 7: 
      return "GATT INVALID OFFSET";
    case 8: 
      return "GATT INSUF AUTHORIZATION";
    case 9: 
      return "GATT PREPARE Q FULL";
    case 10: 
      return "GATT NOT FOUND";
    case 11: 
      return "GATT NOT LONG";
    case 12: 
      return "GATT INSUF KEY SIZE";
    case 13: 
      return "GATT INVALID ATTR LEN";
    case 14: 
      return "GATT ERR UNLIKELY";
    case 15: 
      return "GATT INSUF ENCRYPTION";
    case 16: 
      return "GATT UNSUPPORT GRP TYPE";
    case 17: 
      return "GATT INSUF RESOURCE";
    case 135: 
      return "GATT ILLEGAL PARAMETER";
    case 128: 
      return "GATT NO RESOURCES";
    case 129: 
      return "GATT INTERNAL ERROR";
    case 130: 
      return "GATT WRONG STATE";
    case 131: 
      return "GATT DB FULL";
    case 132: 
      return "GATT BUSY";
    case 133: 
      return "GATT ERROR";
    case 134: 
      return "GATT CMD STARTED";
    case 136: 
      return "GATT PENDING";
    case 137: 
      return "GATT AUTH FAIL";
    case 138: 
      return "GATT MORE";
    case 139: 
      return "GATT INVALID CFG";
    case 140: 
      return "GATT SERVICE STARTED";
    case 141: 
      return "GATT ENCRYPTED NO MITM";
    case 142: 
      return "GATT NOT ENCRYPTED";
    case 143: 
      return "GATT CONGESTED";
    case 253: 
      return "GATT CCCD CFG ERROR";
    case 254: 
      return "GATT PROCEDURE IN PROGRESS";
    case 255: 
      return "GATT VALUE OUT OF RANGE";
    case 257: 
      return "TOO MANY OPEN CONNECTIONS";
    case 4096: 
      return "DFU DEVICE DISCONNECTED";
    case 4098: 
      return "DFU FILE ERROR";
    case 4099: 
      return "DFU NOT A VALID HEX FILE";
    case 4100: 
      return "DFU IO EXCEPTION";
    case 4097: 
      return "DFU FILE NOT FOUND";
    case 4101: 
      return "DFU SERVICE DISCOVERY NOT STARTED";
    case 4102: 
      return "DFU SERVICE NOT FOUND";
    case 4103: 
      return "DFU CHARACTERISTICS NOT FOUND";
    case 4105: 
      return "DFU FILE TYPE NOT SUPPORTED";
    }
    return "BLUETOOTH ADAPTER DISABLED";
    return "REMOTE DFU INVALID STATE";
    return "REMOTE DFU NOT SUPPORTED";
    return "REMOTE DFU DATA SIZE EXCEEDS LIMIT";
    return "REMOTE DFU INVALID CRC ERROR";
    return "REMOTE DFU OPERATION FAILED";
  }
  
  public static String parseConnectionError(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN (" + paramInt + ")";
    case 0: 
      return "SUCCESS";
    case 1: 
      return "GATT CONN L2C FAILURE";
    case 8: 
      return "GATT CONN TIMEOUT";
    case 19: 
      return "GATT CONN TERMINATE PEER USER";
    case 22: 
      return "GATT CONN TERMINATE LOCAL HOST";
    case 62: 
      return "GATT CONN FAIL ESTABLISH";
    case 34: 
      return "GATT CONN LMP TIMEOUT";
    case 256: 
      return "GATT CONN CANCEL ";
    }
    return "GATT ERROR";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\error\GattError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */