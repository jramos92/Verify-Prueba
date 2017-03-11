package com.project.library.device.cmd.notify;

import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.util.ByteDataConvertUtil;

public class NotifyCmd
  extends DeviceBaseCommand
{
  public static final byte FACEBOOK = 6;
  public static final byte INSTAGRAM = 10;
  public static final byte KEY_INCOMING_CALLING = 1;
  public static final byte KEY_INCOMING_CALLING_STATUS = 2;
  public static final byte KEY_INCOMING_MESSAGE = 3;
  public static final byte KEY_MISS_MESSAGE = 4;
  public static final byte LINKEDIN = 11;
  public static final byte MESSENGER = 9;
  public static final byte QQ = 4;
  public static final byte TWITTER = 7;
  public static final byte WECHAT = 3;
  public static final byte WHATSAPP = 8;
  private static NotifyCmd mInstance = null;
  
  public static NotifyCmd getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new NotifyCmd();
      }
      NotifyCmd localNotifyCmd = mInstance;
      return localNotifyCmd;
    }
    finally {}
  }
  
  public byte[] getIncomingCallCmd()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    return createCmd((byte)5, (byte)1, arrayOfByte);
  }
  
  public byte[] getIncomingCallCmd(IncomingCall paramIncomingCall)
  {
    byte[] arrayOfByte = new byte[18];
    int i = 0 + 1;
    arrayOfByte[0] = ByteDataConvertUtil.Int2Byte(paramIncomingCall.totalPacket);
    int j = i + 1;
    arrayOfByte[i] = ByteDataConvertUtil.Int2Byte(paramIncomingCall.serial);
    i = j;
    int k;
    if (paramIncomingCall.serial == 1)
    {
      k = j + 1;
      arrayOfByte[j] = ByteDataConvertUtil.Int2Byte(paramIncomingCall.numberLength);
      i = k + 1;
      arrayOfByte[k] = ByteDataConvertUtil.Int2Byte(paramIncomingCall.contactLength);
    }
    if (paramIncomingCall.nameContent != null)
    {
      paramIncomingCall = paramIncomingCall.nameContent;
      k = paramIncomingCall.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= k) {
        return createCmd((byte)5, (byte)1, arrayOfByte);
      }
      arrayOfByte[i] = paramIncomingCall[j];
      j += 1;
      i += 1;
    }
  }
  
  public byte[] getIncomingCallStatusCmd(byte paramByte)
  {
    return createCmd((byte)5, (byte)2, paramByte);
  }
  
  public byte[] getIncomingMessageCmd()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    return createCmd((byte)5, (byte)3, arrayOfByte);
  }
  
  public byte[] getIncomingMessageCmd(IncomingMessage paramIncomingMessage)
  {
    byte[] arrayOfByte = new byte[18];
    int i = 0 + 1;
    arrayOfByte[0] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.totalPacket);
    int j = i + 1;
    arrayOfByte[i] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.serial);
    i = j;
    int k;
    if (paramIncomingMessage.serial == 1)
    {
      i = j + 1;
      arrayOfByte[j] = 1;
      j = i + 1;
      arrayOfByte[i] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.contentLength);
      k = j + 1;
      arrayOfByte[j] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.numberLength);
      i = k + 1;
      arrayOfByte[k] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.contactLength);
    }
    if (paramIncomingMessage.smsContent != null)
    {
      paramIncomingMessage = paramIncomingMessage.smsContent;
      k = paramIncomingMessage.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= k) {
        return createCmd((byte)5, (byte)3, arrayOfByte);
      }
      arrayOfByte[i] = paramIncomingMessage[j];
      j += 1;
      i += 1;
    }
  }
  
  public byte[] getIncomingMessageCmd(IncomingMessage paramIncomingMessage, int paramInt)
  {
    byte[] arrayOfByte = new byte[18];
    int j = 0 + 1;
    arrayOfByte[0] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.totalPacket);
    int i = j + 1;
    arrayOfByte[j] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.serial);
    int k = i + 1;
    arrayOfByte[i] = 1;
    arrayOfByte[k] = ByteDataConvertUtil.Int2Byte(paramInt);
    if ((paramIncomingMessage.smsContent != null) && (paramIncomingMessage.smsContent.length > 0))
    {
      paramIncomingMessage = paramIncomingMessage.smsContent;
      j = paramIncomingMessage.length;
      i = 0;
      paramInt = k + 1;
    }
    for (;;)
    {
      if (i >= j) {
        return createCmd((byte)5, (byte)3, arrayOfByte);
      }
      arrayOfByte[paramInt] = paramIncomingMessage[i];
      i += 1;
      paramInt += 1;
    }
  }
  
  public byte[] getMessageCmd(IncomingMessage paramIncomingMessage)
  {
    byte[] arrayOfByte = new byte[18];
    int i = 0 + 1;
    arrayOfByte[0] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.totalPacket);
    int j = i + 1;
    arrayOfByte[i] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.serial);
    i = j;
    int k;
    if (paramIncomingMessage.serial == 1)
    {
      i = j + 1;
      arrayOfByte[j] = paramIncomingMessage.type;
      j = i + 1;
      arrayOfByte[i] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.contentLength);
      k = j + 1;
      arrayOfByte[j] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.numberLength);
      i = k + 1;
      arrayOfByte[k] = ByteDataConvertUtil.Int2Byte(paramIncomingMessage.contactLength);
    }
    if (paramIncomingMessage.smsContent != null)
    {
      paramIncomingMessage = paramIncomingMessage.smsContent;
      k = paramIncomingMessage.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= k) {
        return createCmd((byte)5, (byte)3, arrayOfByte);
      }
      arrayOfByte[i] = paramIncomingMessage[j];
      j += 1;
      i += 1;
    }
  }
  
  public byte[] getMissCallCmd(int paramInt)
  {
    return createCmd((byte)5, (byte)4, new byte[] { 8, ByteDataConvertUtil.Int2Byte(paramInt) });
  }
  
  public byte[] getMissSmsCmd(int paramInt)
  {
    return createCmd((byte)5, (byte)4, new byte[] { 1, ByteDataConvertUtil.Int2Byte(paramInt) });
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\notify\NotifyCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */