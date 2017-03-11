package no.nordicsemi.android.dfu.manifest;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class InitPacketData
{
  @SerializedName("application_version")
  protected long applicationVersion;
  @SerializedName("compression_type")
  protected int compressionType;
  @SerializedName("device_revision")
  protected int deviceRevision;
  @SerializedName("device_type")
  protected int deviceType;
  @SerializedName("firmware_crc16")
  protected int firmwareCRC16;
  @SerializedName("firmware_hash")
  protected String firmwareHash;
  @SerializedName("packet_version")
  protected int packetVersion;
  @SerializedName("softdevice_req")
  protected List<Integer> softdeviceReq;
  
  public long getApplicationVersion()
  {
    return this.applicationVersion;
  }
  
  public int getCompressionType()
  {
    return this.compressionType;
  }
  
  public int getDeviceRevision()
  {
    return this.deviceRevision;
  }
  
  public int getDeviceType()
  {
    return this.deviceType;
  }
  
  public int getFirmwareCRC16()
  {
    return this.firmwareCRC16;
  }
  
  public String getFirmwareHash()
  {
    return this.firmwareHash;
  }
  
  public int getPacketVersion()
  {
    return this.packetVersion;
  }
  
  public List<Integer> getSoftdeviceReq()
  {
    return this.softdeviceReq;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\manifest\InitPacketData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */