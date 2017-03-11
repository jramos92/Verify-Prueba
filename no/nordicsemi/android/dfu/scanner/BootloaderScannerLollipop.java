package no.nordicsemi.android.dfu.scanner;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;

@TargetApi(21)
public class BootloaderScannerLollipop
  extends ScanCallback
  implements BootloaderScanner
{
  private String mBootloaderAddress;
  private String mDeviceAddress;
  private String mDeviceAddressIncremented;
  private boolean mFound;
  private final Object mLock = new Object();
  
  public void onScanResult(int paramInt, ScanResult arg2)
  {
    ??? = ???.getDevice().getAddress();
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
    //   4: invokevirtual 76	java/lang/String:substring	(II)Ljava/lang/String;
    //   7: astore_2
    //   8: ldc 78
    //   10: iconst_1
    //   11: anewarray 25	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: bipush 15
    //   19: invokevirtual 81	java/lang/String:substring	(I)Ljava/lang/String;
    //   22: bipush 16
    //   24: invokestatic 87	java/lang/Integer:valueOf	(Ljava/lang/String;I)Ljava/lang/Integer;
    //   27: invokevirtual 91	java/lang/Integer:intValue	()I
    //   30: iconst_1
    //   31: iadd
    //   32: sipush 255
    //   35: iand
    //   36: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: invokestatic 98	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   43: astore_3
    //   44: aload_0
    //   45: aload_1
    //   46: putfield 57	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop:mDeviceAddress	Ljava/lang/String;
    //   49: aload_0
    //   50: new 100	java/lang/StringBuilder
    //   53: dup
    //   54: aload_2
    //   55: invokestatic 103	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_3
    //   62: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: putfield 65	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop:mDeviceAddressIncremented	Ljava/lang/String;
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 37	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop:mBootloaderAddress	Ljava/lang/String;
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 33	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop:mFound	Z
    //   81: new 115	java/lang/Thread
    //   84: dup
    //   85: new 8	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop$1
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 118	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop$1:<init>	(Lno/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop;)V
    //   93: ldc 120
    //   95: invokespecial 123	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   98: invokevirtual 126	java/lang/Thread:start	()V
    //   101: invokestatic 132	android/bluetooth/BluetoothAdapter:getDefaultAdapter	()Landroid/bluetooth/BluetoothAdapter;
    //   104: invokevirtual 136	android/bluetooth/BluetoothAdapter:getBluetoothLeScanner	()Landroid/bluetooth/le/BluetoothLeScanner;
    //   107: astore_1
    //   108: aload_1
    //   109: aconst_null
    //   110: new 138	android/bluetooth/le/ScanSettings$Builder
    //   113: dup
    //   114: invokespecial 139	android/bluetooth/le/ScanSettings$Builder:<init>	()V
    //   117: iconst_2
    //   118: invokevirtual 143	android/bluetooth/le/ScanSettings$Builder:setScanMode	(I)Landroid/bluetooth/le/ScanSettings$Builder;
    //   121: invokevirtual 147	android/bluetooth/le/ScanSettings$Builder:build	()Landroid/bluetooth/le/ScanSettings;
    //   124: aload_0
    //   125: invokevirtual 153	android/bluetooth/le/BluetoothLeScanner:startScan	(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V
    //   128: aload_0
    //   129: getfield 28	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop:mLock	Ljava/lang/Object;
    //   132: astore_2
    //   133: aload_2
    //   134: monitorenter
    //   135: aload_0
    //   136: getfield 33	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop:mFound	Z
    //   139: ifeq +15 -> 154
    //   142: aload_2
    //   143: monitorexit
    //   144: aload_1
    //   145: aload_0
    //   146: invokevirtual 157	android/bluetooth/le/BluetoothLeScanner:stopScan	(Landroid/bluetooth/le/ScanCallback;)V
    //   149: aload_0
    //   150: getfield 37	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop:mBootloaderAddress	Ljava/lang/String;
    //   153: areturn
    //   154: aload_0
    //   155: getfield 28	no/nordicsemi/android/dfu/scanner/BootloaderScannerLollipop:mLock	Ljava/lang/Object;
    //   158: invokevirtual 160	java/lang/Object:wait	()V
    //   161: goto -26 -> 135
    //   164: astore_3
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_3
    //   168: athrow
    //   169: astore_2
    //   170: goto -26 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	BootloaderScannerLollipop
    //   0	173	1	paramString	String
    //   169	1	2	localInterruptedException	InterruptedException
    //   43	19	3	str	String
    //   164	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   135	144	164	finally
    //   154	161	164	finally
    //   165	167	164	finally
    //   128	135	169	java/lang/InterruptedException
    //   167	169	169	java/lang/InterruptedException
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\scanner\BootloaderScannerLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */