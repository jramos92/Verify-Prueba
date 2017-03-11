package com.google.android.gms.internal;

import java.io.IOException;

public class zzsd
  extends IOException
{
  public zzsd(String paramString)
  {
    super(paramString);
  }
  
  static zzsd zzFJ()
  {
    return new zzsd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static zzsd zzFK()
  {
    return new zzsd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static zzsd zzFL()
  {
    return new zzsd("CodedInputStream encountered a malformed varint.");
  }
  
  static zzsd zzFM()
  {
    return new zzsd("Protocol message contained an invalid tag (zero).");
  }
  
  static zzsd zzFN()
  {
    return new zzsd("Protocol message end-group tag did not match expected tag.");
  }
  
  static zzsd zzFO()
  {
    return new zzsd("Protocol message tag had invalid wire type.");
  }
  
  static zzsd zzFP()
  {
    return new zzsd("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzsd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */