package com.project.library.device.cmd.notify;

public class IncomingCall
{
  public static final byte INCOMING_CALL_STATUS_ACCEPT = 1;
  public static final byte INCOMING_CALL_STATUS_REFUSE = 2;
  public int contactLength;
  public String contactName;
  public byte[] nameContent;
  public int numberLength;
  public String phoneNumber;
  public int serial;
  public int totalPacket;
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\notify\IncomingCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */