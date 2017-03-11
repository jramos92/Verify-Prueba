package no.nordicsemi.android.dfu.scanner;

import android.os.Build.VERSION;

public class BootloaderScannerFactory
{
  public static BootloaderScanner getScanner()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new BootloaderScannerLollipop();
    }
    return new BootloaderScannerJB();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\scanner\BootloaderScannerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */