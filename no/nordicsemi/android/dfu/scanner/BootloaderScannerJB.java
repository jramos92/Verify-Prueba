package no.nordicsemi.android.dfu.scanner;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;

public class BootloaderScannerJB
  implements BootloaderScanner, BluetoothAdapter.LeScanCallback
{
  private String mBootloaderAddress;
  private String mDeviceAddress;
  private String mDeviceAddressIncremented;
  private boolean mFound;
  private final Object mLock = new Object();
  
  public void onLeScan(BluetoothDevice arg1, int paramInt, byte[] paramArrayOfByte)
  {
    ??? = ???.getAddress();
    if ((this.mDeviceAddress.equals(???)) || (this.mDeviceAddressIncremented.equals(???)))
    {
      this.mBootloaderAddress = ???;
      this.mFound = true;
      synchronized (this.mLock)
      {
        this.mLock.notifyAll();
        return;
      }
    }
  }
  
  /* Error */
  public String searchFor(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: bipush 15
    //   4: invokevirtual 66	java/lang/String:substring	(II)Ljava/lang/String;
    //   7: astore_2
    //   8: ldc 68
    //   10: iconst_1
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: bipush 15
    //   19: invokevirtual 71	java/lang/String:substring	(I)Ljava/lang/String;
    //   22: bipush 16
    //   24: invokestatic 77	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   27: invokevirtual 81	java/lang/Integer:intValue	()I
    //   30: iconst_1
    //   31: iadd
    //   32: sipush 255
    //   35: iand
    //   36: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   43: astore_3
    //   44: aload_0
    //   45: aload_1
    //   46: putfield 47	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB:mDeviceAddress	Ljava/lang/String;
    //   49: aload_0
    //   50: new 90	java/lang/StringBuilder
    //   53: dup
    //   54: aload_2
    //   55: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_3
    //   62: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: putfield 55	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB:mDeviceAddressIncremented	Ljava/lang/String;
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 33	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB:mBootloaderAddress	Ljava/lang/String;
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 29	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB:mFound	Z
    //   81: new 105	java/lang/Thread
    //   84: dup
    //   85: new 10	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB$1
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 108	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB$1:<init>	(Lno/nordicsemi/android/dfu/scanner/BootloaderScannerJB;)V
    //   93: ldc 110
    //   95: invokespecial 113	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   98: invokevirtual 116	java/lang/Thread:start	()V
    //   101: invokestatic 122	android/bluetooth/BluetoothAdapter:getDefaultAdapter	()Landroid/bluetooth/BluetoothAdapter;
    //   104: astore_1
    //   105: aload_1
    //   106: aload_0
    //   107: invokevirtual 126	android/bluetooth/BluetoothAdapter:startLeScan	(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z
    //   110: pop
    //   111: aload_0
    //   112: getfield 24	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB:mLock	Ljava/lang/Object;
    //   115: astore_2
    //   116: aload_2
    //   117: monitorenter
    //   118: aload_0
    //   119: getfield 29	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB:mFound	Z
    //   122: ifeq +15 -> 137
    //   125: aload_2
    //   126: monitorexit
    //   127: aload_1
    //   128: aload_0
    //   129: invokevirtual 130	android/bluetooth/BluetoothAdapter:stopLeScan	(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)V
    //   132: aload_0
    //   133: getfield 33	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB:mBootloaderAddress	Ljava/lang/String;
    //   136: areturn
    //   137: aload_0
    //   138: getfield 24	no/nordicsemi/android/dfu/scanner/BootloaderScannerJB:mLock	Ljava/lang/Object;
    //   141: invokevirtual 133	java/lang/Object:wait	()V
    //   144: goto -26 -> 118
    //   147: astore_3
    //   148: aload_2
    //   149: monitorexit
    //   150: aload_3
    //   151: athrow
    //   152: astore_2
    //   153: goto -26 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	BootloaderScannerJB
    //   0	156	1	paramString	String
    //   152	1	2	localInterruptedException	InterruptedException
    //   43	19	3	str	String
    //   147	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   118	127	147	finally
    //   137	144	147	finally
    //   148	150	147	finally
    //   111	118	152	java/lang/InterruptedException
    //   150	152	152	java/lang/InterruptedException
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\scanner\BootloaderScannerJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */