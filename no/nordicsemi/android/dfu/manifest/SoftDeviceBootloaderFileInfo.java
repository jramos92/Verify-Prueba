package no.nordicsemi.android.dfu.manifest;

import com.google.gson.annotations.SerializedName;

public class SoftDeviceBootloaderFileInfo
  extends FileInfo
{
  @SerializedName("bl_size")
  protected int bootloaderSize;
  @SerializedName("sd_size")
  protected int softdeviceSize;
  
  public int getBootloaderSize()
  {
    return this.bootloaderSize;
  }
  
  public int getSoftdeviceSize()
  {
    return this.softdeviceSize;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\manifest\SoftDeviceBootloaderFileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */