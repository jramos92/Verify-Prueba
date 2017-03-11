package no.nordicsemi.android.dfu.scanner;

public abstract interface BootloaderScanner
{
  public static final int ADDRESS_DIFF = 1;
  public static final long TIMEOUT = 5000L;
  
  public abstract String searchFor(String paramString);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\scanner\BootloaderScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */