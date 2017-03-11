package no.nordicsemi.android.dfu.manifest;

import com.google.gson.annotations.SerializedName;

public class Manifest
{
  protected FileInfo application;
  protected FileInfo bootloader;
  protected FileInfo softdevice;
  @SerializedName("softdevice_bootloader")
  protected SoftDeviceBootloaderFileInfo softdeviceBootloader;
  
  public FileInfo getApplicationInfo()
  {
    return this.application;
  }
  
  public FileInfo getBootloaderInfo()
  {
    return this.bootloader;
  }
  
  public SoftDeviceBootloaderFileInfo getSoftdeviceBootloaderInfo()
  {
    return this.softdeviceBootloader;
  }
  
  public FileInfo getSoftdeviceInfo()
  {
    return this.softdevice;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\manifest\Manifest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */