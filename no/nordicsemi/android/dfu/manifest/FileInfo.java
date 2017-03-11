package no.nordicsemi.android.dfu.manifest;

import com.google.gson.annotations.SerializedName;

public class FileInfo
{
  @SerializedName("bin_file")
  protected String binFile;
  @SerializedName("dat_file")
  protected String datFile;
  @SerializedName("init_packet_data")
  protected InitPacketData initPacketData;
  
  public String getBinFileName()
  {
    return this.binFile;
  }
  
  public String getDatFileName()
  {
    return this.datFile;
  }
  
  public InitPacketData getInitPacketData()
  {
    return this.initPacketData;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\manifest\FileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */