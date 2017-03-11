package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.exception.DfuException;
import no.nordicsemi.android.dfu.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.exception.UploadAbortedException;

public abstract class DfuBaseService
  extends IntentService
{
  public static final int ACTION_ABORT = 2;
  public static final int ACTION_PAUSE = 0;
  public static final int ACTION_RESUME = 1;
  public static final String BROADCAST_ACTION = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION";
  public static final String BROADCAST_ERROR = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR";
  public static final String BROADCAST_LOG = "no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG";
  public static final String BROADCAST_PROGRESS = "no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS";
  private static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
  private static final UUID DFU_CONTROL_POINT_UUID;
  private static final UUID DFU_PACKET_UUID;
  private static final UUID DFU_SERVICE_UUID;
  public static final int DFU_STATUS_CRC_ERROR = 5;
  public static final int DFU_STATUS_DATA_SIZE_EXCEEDS_LIMIT = 4;
  public static final int DFU_STATUS_INVALID_STATE = 2;
  public static final int DFU_STATUS_NOT_SUPPORTED = 3;
  public static final int DFU_STATUS_OPERATION_FAILED = 6;
  public static final int DFU_STATUS_SUCCESS = 1;
  private static final UUID DFU_VERSION;
  public static final int ERROR_BLUETOOTH_DISABLED = 4106;
  public static final int ERROR_CHARACTERISTICS_NOT_FOUND = 4103;
  public static final int ERROR_CONNECTION_MASK = 16384;
  public static final int ERROR_CONNECTION_STATE_MASK = 32768;
  public static final int ERROR_DEVICE_DISCONNECTED = 4096;
  public static final int ERROR_FILE_ERROR = 4098;
  public static final int ERROR_FILE_INVALID = 4099;
  public static final int ERROR_FILE_IO_EXCEPTION = 4100;
  public static final int ERROR_FILE_NOT_FOUND = 4097;
  public static final int ERROR_FILE_TYPE_UNSUPPORTED = 4105;
  public static final int ERROR_INVALID_RESPONSE = 4104;
  public static final int ERROR_MASK = 4096;
  public static final int ERROR_REMOTE_MASK = 8192;
  public static final int ERROR_SERVICE_DISCOVERY_NOT_STARTED = 4101;
  public static final int ERROR_SERVICE_NOT_FOUND = 4102;
  public static final int ERROR_TYPE_COMMUNICATION = 2;
  public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
  public static final int ERROR_TYPE_DFU_REMOTE = 3;
  public static final int ERROR_TYPE_OTHER = 0;
  public static final String EXTRA_ACTION = "no.nordicsemi.android.dfu.extra.EXTRA_ACTION";
  public static final String EXTRA_AVG_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS";
  public static final String EXTRA_DATA = "no.nordicsemi.android.dfu.extra.EXTRA_DATA";
  public static final String EXTRA_DEVICE_ADDRESS = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
  public static final String EXTRA_DEVICE_NAME = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
  public static final String EXTRA_ERROR_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE";
  public static final String EXTRA_FILE_MIME_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
  public static final String EXTRA_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
  public static final String EXTRA_FILE_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
  public static final String EXTRA_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
  public static final String EXTRA_INIT_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
  public static final String EXTRA_INIT_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
  public static final String EXTRA_KEEP_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
  public static final String EXTRA_LOG_LEVEL = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL";
  public static final String EXTRA_LOG_MESSAGE = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO";
  public static final String EXTRA_PARTS_TOTAL = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
  public static final String EXTRA_PART_CURRENT = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
  public static final String EXTRA_PROGRESS = "no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS";
  public static final String EXTRA_RESTORE_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
  public static final String EXTRA_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS";
  private static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID;
  private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
  private static final int INDICATIONS = 2;
  public static final int LOG_LEVEL_APPLICATION = 10;
  public static final int LOG_LEVEL_DEBUG = 0;
  public static final int LOG_LEVEL_ERROR = 20;
  public static final int LOG_LEVEL_INFO = 5;
  public static final int LOG_LEVEL_VERBOSE = 1;
  public static final int LOG_LEVEL_WARNING = 15;
  private static final int MAX_PACKET_SIZE = 20;
  public static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
  public static final String MIME_TYPE_ZIP = "application/zip";
  private static final int NOTIFICATIONS = 1;
  public static final int NOTIFICATION_ID = 283;
  private static final byte[] OP_CODE_ACTIVATE_AND_RESET;
  private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
  private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE;
  private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
  private static final byte[] OP_CODE_INIT_DFU_PARAMS_START;
  private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
  private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
  private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
  private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE;
  private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
  private static final byte[] OP_CODE_RESET;
  private static final int OP_CODE_RESET_KEY = 6;
  private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
  private static final byte[] OP_CODE_START_DFU;
  private static final int OP_CODE_START_DFU_KEY = 1;
  private static final byte[] OP_CODE_VALIDATE;
  private static final int OP_CODE_VALIDATE_KEY = 4;
  public static final int PROGRESS_ABORTED = -7;
  public static final int PROGRESS_COMPLETED = -6;
  public static final int PROGRESS_CONNECTING = -1;
  public static final int PROGRESS_DISCONNECTING = -5;
  public static final int PROGRESS_ENABLING_DFU_MODE = -3;
  public static final int PROGRESS_STARTING = -2;
  public static final int PROGRESS_VALIDATING = -4;
  private static final UUID SERVICE_CHANGED_UUID;
  private static final int STATE_CLOSED = -5;
  private static final int STATE_CONNECTED = -2;
  private static final int STATE_CONNECTED_AND_READY = -3;
  private static final int STATE_CONNECTING = -1;
  private static final int STATE_DISCONNECTED = 0;
  private static final int STATE_DISCONNECTING = -4;
  private static final String TAG = "DfuBaseService";
  public static final int TYPE_APPLICATION = 4;
  public static final int TYPE_AUTO = 0;
  public static final int TYPE_BOOTLOADER = 2;
  public static final int TYPE_SOFT_DEVICE = 1;
  public static byte[] mBuffer = new byte[20];
  private boolean mAborted;
  private BluetoothAdapter mBluetoothAdapter;
  private final BroadcastReceiver mBondStateBroadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context arg1, Intent paramAnonymousIntent)
    {
      if (!((BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.mDeviceAddress)) {}
      while (paramAnonymousIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1) == 11) {
        return;
      }
      DfuBaseService.this.mRequestCompleted = true;
      synchronized (DfuBaseService.this.mLock)
      {
        DfuBaseService.this.mLock.notifyAll();
        return;
      }
    }
  };
  private int mBytesConfirmed;
  private int mBytesSent;
  private int mConnectionState;
  private final BroadcastReceiver mConnectionStateBroadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context arg1, Intent paramAnonymousIntent)
    {
      if (!((BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
        return;
      }
      ??? = paramAnonymousIntent.getAction();
      DfuBaseService.this.logi("Action received: " + ???);
      DfuBaseService.this.mConnectionState = 0;
      synchronized (DfuBaseService.this.mLock)
      {
        DfuBaseService.this.mLock.notifyAll();
        return;
      }
    }
  };
  private String mDeviceAddress;
  private String mDeviceName;
  private final BroadcastReceiver mDfuActionReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context arg1, Intent paramAnonymousIntent)
    {
      switch (paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 0))
      {
      default: 
        return;
      case 0: 
        DfuBaseService.this.mPaused = true;
        return;
      case 1: 
        DfuBaseService.this.mPaused = false;
        synchronized (DfuBaseService.this.mLock)
        {
          DfuBaseService.this.mLock.notifyAll();
          return;
        }
      }
      DfuBaseService.this.mPaused = false;
      DfuBaseService.this.mAborted = true;
      synchronized (DfuBaseService.this.mLock)
      {
        DfuBaseService.this.mLock.notifyAll();
        return;
      }
    }
  };
  private int mError;
  private int mFileType;
  private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback()
  {
    private String parse(BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
    {
      paramAnonymousBluetoothGattCharacteristic = paramAnonymousBluetoothGattCharacteristic.getValue();
      if (paramAnonymousBluetoothGattCharacteristic == null) {
        return "";
      }
      int j = paramAnonymousBluetoothGattCharacteristic.length;
      if (j == 0) {
        return "";
      }
      char[] arrayOfChar = new char[j * 3 - 1];
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return new String(arrayOfChar);
        }
        int k = paramAnonymousBluetoothGattCharacteristic[i] & 0xFF;
        arrayOfChar[(i * 3)] = DfuBaseService.HEX_ARRAY[(k >>> 4)];
        arrayOfChar[(i * 3 + 1)] = DfuBaseService.HEX_ARRAY[(k & 0xF)];
        if (i != j - 1) {
          arrayOfChar[(i * 3 + 2)] = '-';
        }
        i += 1;
      }
    }
    
    public void onCharacteristicChanged(BluetoothGatt arg1, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
    {
      switch (paramAnonymousBluetoothGattCharacteristic.getIntValue(17, 0).intValue())
      {
      default: 
        if (!DfuBaseService.this.mRemoteErrorOccurred) {
          break;
        }
      }
      synchronized (DfuBaseService.this.mLock)
      {
        for (;;)
        {
          DfuBaseService.this.mLock.notifyAll();
          return;
          BluetoothGattCharacteristic localBluetoothGattCharacteristic = ???.getService(DfuBaseService.DFU_SERVICE_UUID).getCharacteristic(DfuBaseService.DFU_PACKET_UUID);
          try
          {
            DfuBaseService.this.mBytesConfirmed = paramAnonymousBluetoothGattCharacteristic.getIntValue(20, 1).intValue();
            DfuBaseService.this.mPacketsSentSinceNotification = 0;
            DfuBaseService.this.waitIfPaused();
            if ((DfuBaseService.this.mAborted) || (DfuBaseService.this.mError != 0) || (DfuBaseService.this.mRemoteErrorOccurred) || (DfuBaseService.this.mResetRequestSent)) {
              DfuBaseService.this.sendLogBroadcast(15, "Upload terminated");
            }
          }
          catch (HexFileValidationException ???)
          {
            DfuBaseService.this.loge("Invalid HEX file");
            DfuBaseService.this.mError = 4099;
            continue;
            paramAnonymousBluetoothGattCharacteristic = DfuBaseService.mBuffer;
            int i = DfuBaseService.this.mInputStream.read(paramAnonymousBluetoothGattCharacteristic);
            DfuBaseService.this.writePacket(???, localBluetoothGattCharacteristic, paramAnonymousBluetoothGattCharacteristic, i);
            DfuBaseService.this.updateProgressNotification();
            return;
          }
          catch (IOException ???)
          {
            DfuBaseService.this.loge("Error while reading the input stream", ???);
            DfuBaseService.this.mError = 4100;
          }
        }
        if (paramAnonymousBluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
          DfuBaseService.this.mRemoteErrorOccurred = true;
        }
        DfuBaseService.this.sendLogBroadcast(5, "Notification received from " + paramAnonymousBluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(paramAnonymousBluetoothGattCharacteristic));
        DfuBaseService.this.mReceivedData = paramAnonymousBluetoothGattCharacteristic.getValue();
      }
    }
    
    public void onCharacteristicRead(BluetoothGatt arg1, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0)
      {
        DfuBaseService.this.sendLogBroadcast(5, "Read Response received from " + paramAnonymousBluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(paramAnonymousBluetoothGattCharacteristic));
        DfuBaseService.this.mReceivedData = paramAnonymousBluetoothGattCharacteristic.getValue();
        DfuBaseService.this.mRequestCompleted = true;
      }
      synchronized (DfuBaseService.this.mLock)
      {
        DfuBaseService.this.mLock.notifyAll();
        return;
        DfuBaseService.this.loge("Characteristic read error: " + paramAnonymousInt);
        DfuBaseService.this.mError = (paramAnonymousInt | 0x4000);
      }
    }
    
    public void onCharacteristicWrite(BluetoothGatt arg1, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      Object localObject;
      if (paramAnonymousInt == 0) {
        if (DfuBaseService.DFU_PACKET_UUID.equals(paramAnonymousBluetoothGattCharacteristic.getUuid())) {
          if ((DfuBaseService.this.mImageSizeSent) && (DfuBaseService.this.mInitPacketSent))
          {
            localObject = DfuBaseService.this;
            ((DfuBaseService)localObject).mBytesSent += paramAnonymousBluetoothGattCharacteristic.getValue().length;
            localObject = DfuBaseService.this;
            ((DfuBaseService)localObject).mPacketsSentSinceNotification += 1;
            if ((DfuBaseService.this.mPacketsBeforeNotification > 0) && (DfuBaseService.this.mPacketsSentSinceNotification == DfuBaseService.this.mPacketsBeforeNotification))
            {
              paramAnonymousInt = 1;
              if (DfuBaseService.this.mBytesSent != DfuBaseService.this.mImageSizeInBytes) {
                break label141;
              }
            }
            label141:
            for (int i = 1;; i = 0)
            {
              if ((paramAnonymousInt == 0) && (i == 0)) {
                break label147;
              }
              return;
              paramAnonymousInt = 0;
              break;
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          label147:
          DfuBaseService.this.waitIfPaused();
          if ((DfuBaseService.this.mAborted) || (DfuBaseService.this.mError != 0) || (DfuBaseService.this.mRemoteErrorOccurred) || (DfuBaseService.this.mResetRequestSent)) {
            synchronized (DfuBaseService.this.mLock)
            {
              DfuBaseService.this.sendLogBroadcast(15, "Upload terminated");
              DfuBaseService.this.mLock.notifyAll();
              return;
            }
          }
          if (DfuBaseService.this.mImageSizeSent) {
            break label404;
          }
        }
        catch (HexFileValidationException ???)
        {
          DfuBaseService.this.loge("Invalid HEX file");
          DfuBaseService.this.mError = 4099;
          synchronized (DfuBaseService.this.mLock)
          {
            DfuBaseService.this.mLock.notifyAll();
            return;
          }
          localObject = DfuBaseService.mBuffer;
          paramAnonymousInt = DfuBaseService.this.mInputStream.read((byte[])localObject);
          DfuBaseService.this.writePacket(???, paramAnonymousBluetoothGattCharacteristic, (byte[])localObject, paramAnonymousInt);
          DfuBaseService.this.updateProgressNotification();
          return;
        }
        catch (IOException ???)
        {
          DfuBaseService.this.loge("Error while reading the input stream", ???);
          DfuBaseService.this.mError = 4100;
          continue;
        }
        DfuBaseService.this.sendLogBroadcast(5, "Data written to " + paramAnonymousBluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(paramAnonymousBluetoothGattCharacteristic));
        DfuBaseService.this.mImageSizeSent = true;
        continue;
        label404:
        DfuBaseService.this.sendLogBroadcast(5, "Data written to " + paramAnonymousBluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(paramAnonymousBluetoothGattCharacteristic));
        DfuBaseService.this.mInitPacketSent = true;
        continue;
        DfuBaseService.this.sendLogBroadcast(5, "Data written to " + paramAnonymousBluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(paramAnonymousBluetoothGattCharacteristic));
        DfuBaseService.this.mRequestCompleted = true;
        continue;
        if (DfuBaseService.this.mResetRequestSent)
        {
          DfuBaseService.this.mRequestCompleted = true;
        }
        else
        {
          DfuBaseService.this.loge("Characteristic write error: " + paramAnonymousInt);
          DfuBaseService.this.mError = (paramAnonymousInt | 0x4000);
        }
      }
    }
    
    /* Error */
    public void onConnectionStateChange(BluetoothGatt arg1, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      // Byte code:
      //   0: iload_2
      //   1: ifne +195 -> 196
      //   4: iload_3
      //   5: iconst_2
      //   6: if_icmpne +157 -> 163
      //   9: aload_0
      //   10: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   13: ldc -22
      //   15: invokestatic 237	no/nordicsemi/android/dfu/DfuBaseService:access$1	(Lno/nordicsemi/android/dfu/DfuBaseService;Ljava/lang/String;)V
      //   18: aload_0
      //   19: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   22: bipush -2
      //   24: invokestatic 240	no/nordicsemi/android/dfu/DfuBaseService:access$2	(Lno/nordicsemi/android/dfu/DfuBaseService;I)V
      //   27: aload_1
      //   28: invokevirtual 244	android/bluetooth/BluetoothGatt:getDevice	()Landroid/bluetooth/BluetoothDevice;
      //   31: invokevirtual 249	android/bluetooth/BluetoothDevice:getBondState	()I
      //   34: bipush 12
      //   36: if_icmpne +23 -> 59
      //   39: aload_0
      //   40: monitorenter
      //   41: aload_0
      //   42: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   45: ldc -5
      //   47: invokestatic 254	no/nordicsemi/android/dfu/DfuBaseService:access$7	(Lno/nordicsemi/android/dfu/DfuBaseService;Ljava/lang/String;)V
      //   50: aload_0
      //   51: ldc2_w 255
      //   54: invokevirtual 260	java/lang/Object:wait	(J)V
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_1
      //   60: invokevirtual 264	android/bluetooth/BluetoothGatt:discoverServices	()Z
      //   63: istore 4
      //   65: aload_0
      //   66: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   69: astore 5
      //   71: new 151	java/lang/StringBuilder
      //   74: dup
      //   75: ldc_w 266
      //   78: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   81: astore 6
      //   83: iload 4
      //   85: ifeq +71 -> 156
      //   88: ldc_w 268
      //   91: astore_1
      //   92: aload 5
      //   94: aload 6
      //   96: aload_1
      //   97: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   103: invokestatic 237	no/nordicsemi/android/dfu/DfuBaseService:access$1	(Lno/nordicsemi/android/dfu/DfuBaseService;Ljava/lang/String;)V
      //   106: iload 4
      //   108: ifne +35 -> 143
      //   111: aload_0
      //   112: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   115: sipush 4101
      //   118: invokestatic 118	no/nordicsemi/android/dfu/DfuBaseService:access$8	(Lno/nordicsemi/android/dfu/DfuBaseService;I)V
      //   121: aload_0
      //   122: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   125: invokestatic 59	no/nordicsemi/android/dfu/DfuBaseService:access$3	(Lno/nordicsemi/android/dfu/DfuBaseService;)Ljava/lang/Object;
      //   128: astore_1
      //   129: aload_1
      //   130: monitorenter
      //   131: aload_0
      //   132: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   135: invokestatic 59	no/nordicsemi/android/dfu/DfuBaseService:access$3	(Lno/nordicsemi/android/dfu/DfuBaseService;)Ljava/lang/Object;
      //   138: invokevirtual 64	java/lang/Object:notifyAll	()V
      //   141: aload_1
      //   142: monitorexit
      //   143: return
      //   144: astore 5
      //   146: aload_0
      //   147: monitorexit
      //   148: aload 5
      //   150: athrow
      //   151: astore 5
      //   153: goto -94 -> 59
      //   156: ldc_w 270
      //   159: astore_1
      //   160: goto -68 -> 92
      //   163: iload_3
      //   164: ifne -43 -> 121
      //   167: aload_0
      //   168: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   171: ldc_w 272
      //   174: invokestatic 237	no/nordicsemi/android/dfu/DfuBaseService:access$1	(Lno/nordicsemi/android/dfu/DfuBaseService;Ljava/lang/String;)V
      //   177: aload_0
      //   178: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   181: iconst_0
      //   182: invokestatic 275	no/nordicsemi/android/dfu/DfuBaseService:access$4	(Lno/nordicsemi/android/dfu/DfuBaseService;Z)V
      //   185: aload_0
      //   186: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   189: iconst_0
      //   190: invokestatic 240	no/nordicsemi/android/dfu/DfuBaseService:access$2	(Lno/nordicsemi/android/dfu/DfuBaseService;I)V
      //   193: goto -72 -> 121
      //   196: aload_0
      //   197: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   200: new 151	java/lang/StringBuilder
      //   203: dup
      //   204: ldc_w 277
      //   207: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   210: iload_2
      //   211: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   214: ldc_w 279
      //   217: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: iload_3
      //   221: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   224: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   227: invokestatic 115	no/nordicsemi/android/dfu/DfuBaseService:access$9	(Lno/nordicsemi/android/dfu/DfuBaseService;Ljava/lang/String;)V
      //   230: aload_0
      //   231: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   234: iconst_0
      //   235: invokestatic 275	no/nordicsemi/android/dfu/DfuBaseService:access$4	(Lno/nordicsemi/android/dfu/DfuBaseService;Z)V
      //   238: aload_0
      //   239: getfield 12	no/nordicsemi/android/dfu/DfuBaseService$4:this$0	Lno/nordicsemi/android/dfu/DfuBaseService;
      //   242: ldc_w 280
      //   245: iload_2
      //   246: ior
      //   247: invokestatic 118	no/nordicsemi/android/dfu/DfuBaseService:access$8	(Lno/nordicsemi/android/dfu/DfuBaseService;I)V
      //   250: goto -129 -> 121
      //   253: astore 5
      //   255: aload_1
      //   256: monitorexit
      //   257: aload 5
      //   259: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	260	0	this	4
      //   0	260	2	paramAnonymousInt1	int
      //   0	260	3	paramAnonymousInt2	int
      //   63	44	4	bool	boolean
      //   69	24	5	localDfuBaseService	DfuBaseService
      //   144	5	5	localObject1	Object
      //   151	1	5	localInterruptedException	InterruptedException
      //   253	5	5	localObject2	Object
      //   81	14	6	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   41	59	144	finally
      //   146	148	144	finally
      //   39	41	151	java/lang/InterruptedException
      //   148	151	151	java/lang/InterruptedException
      //   131	143	253	finally
      //   255	257	253	finally
    }
    
    public void onDescriptorRead(BluetoothGatt arg1, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
    {
      boolean bool = false;
      if (paramAnonymousInt == 0) {
        if ((DfuBaseService.CLIENT_CHARACTERISTIC_CONFIG.equals(paramAnonymousBluetoothGattDescriptor.getUuid())) && (DfuBaseService.SERVICE_CHANGED_UUID.equals(paramAnonymousBluetoothGattDescriptor.getCharacteristic().getUuid())))
        {
          ??? = DfuBaseService.this;
          if (paramAnonymousBluetoothGattDescriptor.getValue()[0] == 2) {
            bool = true;
          }
          ???.mServiceChangedIndicationsEnabled = bool;
          DfuBaseService.this.mRequestCompleted = true;
        }
      }
      synchronized (DfuBaseService.this.mLock)
      {
        DfuBaseService.this.mLock.notifyAll();
        return;
        DfuBaseService.this.loge("Descriptor read error: " + paramAnonymousInt);
        DfuBaseService.this.mError = (paramAnonymousInt | 0x4000);
      }
    }
    
    public void onDescriptorWrite(BluetoothGatt arg1, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      if (paramAnonymousInt == 0) {
        if (DfuBaseService.CLIENT_CHARACTERISTIC_CONFIG.equals(paramAnonymousBluetoothGattDescriptor.getUuid()))
        {
          if (!DfuBaseService.SERVICE_CHANGED_UUID.equals(paramAnonymousBluetoothGattDescriptor.getCharacteristic().getUuid())) {
            break label89;
          }
          ??? = DfuBaseService.this;
          if (paramAnonymousBluetoothGattDescriptor.getValue()[0] != 2) {
            break label83;
          }
        }
      }
      for (;;)
      {
        ???.mServiceChangedIndicationsEnabled = bool1;
        synchronized (DfuBaseService.this.mLock)
        {
          DfuBaseService.this.mLock.notifyAll();
          return;
          label83:
          bool1 = false;
          continue;
          label89:
          ??? = DfuBaseService.this;
          if (paramAnonymousBluetoothGattDescriptor.getValue()[0] == 1) {}
          for (bool1 = bool2;; bool1 = false)
          {
            ???.mNotificationsEnabled = bool1;
            break;
          }
          DfuBaseService.this.loge("Descriptor write error: " + paramAnonymousInt);
          DfuBaseService.this.mError = (paramAnonymousInt | 0x4000);
        }
      }
    }
    
    public void onServicesDiscovered(BluetoothGatt arg1, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0)
      {
        DfuBaseService.this.logi("Services discovered");
        DfuBaseService.this.mConnectionState = -3;
      }
      synchronized (DfuBaseService.this.mLock)
      {
        DfuBaseService.this.mLock.notifyAll();
        return;
        DfuBaseService.this.loge("Service discovery error: " + paramAnonymousInt);
        DfuBaseService.this.mError = (paramAnonymousInt | 0x4000);
      }
    }
  };
  private int mImageSizeInBytes;
  private boolean mImageSizeSent;
  private boolean mInitPacketSent;
  private InputStream mInputStream;
  private int mLastBytesSent;
  private int mLastProgress = -1;
  private long mLastProgressTime;
  private final Object mLock = new Object();
  private boolean mNotificationsEnabled;
  private int mPacketsBeforeNotification = 10;
  private int mPacketsSentSinceNotification;
  private int mPartCurrent;
  private int mPartsTotal;
  private boolean mPaused;
  private byte[] mReceivedData = null;
  private boolean mRemoteErrorOccurred;
  private boolean mRequestCompleted;
  private boolean mResetRequestSent;
  private boolean mServiceChangedIndicationsEnabled;
  private long mStartTime;
  
  static
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 1;
    OP_CODE_START_DFU = arrayOfByte;
    arrayOfByte = new byte[2];
    arrayOfByte[0] = 2;
    OP_CODE_INIT_DFU_PARAMS_START = arrayOfByte;
    OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[] { 2, 1 };
    OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[] { 3 };
    OP_CODE_VALIDATE = new byte[] { 4 };
    OP_CODE_ACTIVATE_AND_RESET = new byte[] { 5 };
    OP_CODE_RESET = new byte[] { 6 };
    arrayOfByte = new byte[3];
    arrayOfByte[0] = 8;
    OP_CODE_PACKET_RECEIPT_NOTIF_REQ = arrayOfByte;
    GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    DFU_SERVICE_UUID = new UUID(23296205844446L, 1523193452336828707L);
    DFU_CONTROL_POINT_UUID = new UUID(23300500811742L, 1523193452336828707L);
    DFU_PACKET_UUID = new UUID(23304795779038L, 1523193452336828707L);
    DFU_VERSION = new UUID(23313385713630L, 1523193452336828707L);
  }
  
  public DfuBaseService()
  {
    super("DfuBaseService");
  }
  
  private void close(BluetoothGatt paramBluetoothGatt)
  {
    logi("Cleaning up...");
    sendLogBroadcast(0, "gatt.close()");
    paramBluetoothGatt.close();
    this.mConnectionState = -5;
  }
  
  private BluetoothGatt connect(String paramString)
  {
    if (!this.mBluetoothAdapter.isEnabled()) {
      return null;
    }
    this.mConnectionState = -1;
    logi("Connecting to the device...");
    paramString = this.mBluetoothAdapter.getRemoteDevice(paramString).connectGatt(this, false, this.mGattCallback);
    for (;;)
    {
      try
      {
        synchronized (this.mLock)
        {
          if (((this.mConnectionState != -1) && (this.mConnectionState != -2)) || (((this.mError != 0) || (this.mAborted)) && (!this.mPaused))) {
            return paramString;
          }
        }
        this.mLock.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        loge("Sleeping interrupted", localInterruptedException);
        return paramString;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean createBond(BluetoothDevice arg1)
  {
    if (???.getBondState() == 12) {
      return true;
    }
    this.mRequestCompleted = false;
    sendLogBroadcast(1, "Starting pairing...");
    boolean bool;
    if (Build.VERSION.SDK_INT >= 19)
    {
      sendLogBroadcast(0, "gatt.getDevice().createBond()");
      bool = ???.createBond();
    }
    for (;;)
    {
      try
      {
        synchronized (this.mLock)
        {
          if ((!this.mRequestCompleted) && (!this.mAborted)) {
            break label95;
          }
          return bool;
        }
        bool = createBondApi18(???);
      }
      catch (InterruptedException ???)
      {
        loge("Sleeping interrupted", ???);
        return bool;
      }
      continue;
      label95:
      this.mLock.wait();
    }
  }
  
  private boolean createBondApi18(BluetoothDevice paramBluetoothDevice)
  {
    try
    {
      Method localMethod = paramBluetoothDevice.getClass().getMethod("createBond", new Class[0]);
      if (localMethod != null)
      {
        sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
        boolean bool = ((Boolean)localMethod.invoke(paramBluetoothDevice, new Object[0])).booleanValue();
        return bool;
      }
    }
    catch (Exception paramBluetoothDevice)
    {
      Log.w("DfuBaseService", "An exception occurred while creating bond", paramBluetoothDevice);
    }
    return false;
  }
  
  private void disconnect(BluetoothGatt paramBluetoothGatt)
  {
    if (this.mConnectionState == 0) {
      return;
    }
    this.mConnectionState = -4;
    logi("Disconnecting from the device...");
    paramBluetoothGatt.disconnect();
    waitUntilDisconnected();
  }
  
  private void enableCCCD(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    if (paramInt == 1) {}
    for (String str = "notifications"; this.mConnectionState != -3; str = "indications") {
      throw new DeviceDisconnectedException("Unable to set " + str + " state", this.mConnectionState);
    }
    this.mReceivedData = null;
    this.mError = 0;
    if (((paramInt == 1) && (this.mNotificationsEnabled)) || ((paramInt == 2) && (this.mServiceChangedIndicationsEnabled))) {}
    label223:
    label406:
    do
    {
      return;
      logi("Enabling " + str + "...");
      sendLogBroadcast(1, "Enabling " + str + " for " + paramBluetoothGattCharacteristic.getUuid());
      paramBluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, true);
      BluetoothGattDescriptor localBluetoothGattDescriptor = paramBluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
      if (paramInt == 1) {
        paramBluetoothGattCharacteristic = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
      }
      for (;;)
      {
        localBluetoothGattDescriptor.setValue(paramBluetoothGattCharacteristic);
        StringBuilder localStringBuilder = new StringBuilder("gatt.writeDescriptor(").append(localBluetoothGattDescriptor.getUuid());
        if (paramInt == 1)
        {
          paramBluetoothGattCharacteristic = ", value=0x01-00)";
          sendLogBroadcast(0, paramBluetoothGattCharacteristic);
          paramBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor);
        }
        for (;;)
        {
          try
          {
            paramBluetoothGatt = this.mLock;
            if (paramInt != 1) {}
          }
          catch (InterruptedException paramBluetoothGatt)
          {
            loge("Sleeping interrupted", paramBluetoothGatt);
            continue;
            if (this.mError == 0) {
              break label406;
            }
            throw new DfuException("Unable to set " + str + " state", this.mError);
          }
          try
          {
            if (((this.mNotificationsEnabled) && ((paramInt != 2) || (this.mServiceChangedIndicationsEnabled))) || (((this.mConnectionState != -3) || (this.mError != 0) || (this.mAborted)) && (!this.mPaused)))
            {
              if (!this.mAborted) {
                continue;
              }
              throw new UploadAbortedException();
              paramBluetoothGattCharacteristic = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
              break;
              paramBluetoothGattCharacteristic = ", value=0x02-00)";
              break label223;
            }
            this.mLock.wait();
          }
          finally {}
        }
      }
    } while (this.mConnectionState == -3);
    throw new DeviceDisconnectedException("Unable to set " + str + " state", this.mConnectionState);
  }
  
  private int getStatusCode(byte[] paramArrayOfByte, int paramInt)
    throws UnknownResponseException
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 3) || (paramArrayOfByte[0] != 16) || (paramArrayOfByte[1] != paramInt) || (paramArrayOfByte[2] < 1) || (paramArrayOfByte[2] > 6)) {
      throw new UnknownResponseException("Invalid response received", paramArrayOfByte, paramInt);
    }
    return paramArrayOfByte[2];
  }
  
  private boolean initialize()
  {
    BluetoothManager localBluetoothManager = (BluetoothManager)getSystemService("bluetooth");
    if (localBluetoothManager == null)
    {
      loge("Unable to initialize BluetoothManager.");
      return false;
    }
    this.mBluetoothAdapter = localBluetoothManager.getAdapter();
    if (this.mBluetoothAdapter == null)
    {
      loge("Unable to obtain a BluetoothAdapter.");
      return false;
    }
    return true;
  }
  
  /* Error */
  private boolean isServiceChangedCCCDEnabled(BluetoothGatt arg1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   4: bipush -3
    //   6: if_icmpeq +18 -> 24
    //   9: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   12: dup
    //   13: ldc_w 678
    //   16: aload_0
    //   17: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   20: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   23: athrow
    //   24: aload_2
    //   25: ifnonnull +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_2
    //   31: getstatic 310	no/nordicsemi/android/dfu/DfuBaseService:CLIENT_CHARACTERISTIC_CONFIG	Ljava/util/UUID;
    //   34: invokevirtual 622	android/bluetooth/BluetoothGattCharacteristic:getDescriptor	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattDescriptor;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull -11 -> 28
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 457	no/nordicsemi/android/dfu/DfuBaseService:mRequestCompleted	Z
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   52: aload_0
    //   53: ldc_w 680
    //   56: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: iconst_1
    //   61: ldc_w 680
    //   64: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual 683	android/bluetooth/BluetoothGatt:readDescriptor	(Landroid/bluetooth/BluetoothGattDescriptor;)Z
    //   72: pop
    //   73: aload_0
    //   74: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 457	no/nordicsemi/android/dfu/DfuBaseService:mRequestCompleted	Z
    //   84: ifne +26 -> 110
    //   87: aload_0
    //   88: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   91: bipush -3
    //   93: if_icmpne +17 -> 110
    //   96: aload_0
    //   97: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   100: ifne +10 -> 110
    //   103: aload_0
    //   104: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   107: ifeq +27 -> 134
    //   110: aload_0
    //   111: getfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   114: ifne +20 -> 134
    //   117: aload_1
    //   118: monitorexit
    //   119: aload_0
    //   120: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   123: ifeq +38 -> 161
    //   126: new 578	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   129: dup
    //   130: invokespecial 641	no/nordicsemi/android/dfu/exception/UploadAbortedException:<init>	()V
    //   133: athrow
    //   134: aload_0
    //   135: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   138: invokevirtual 504	java/lang/Object:wait	()V
    //   141: goto -61 -> 80
    //   144: astore_2
    //   145: aload_1
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: aload_0
    //   151: ldc_w 501
    //   154: aload_1
    //   155: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: goto -39 -> 119
    //   161: aload_0
    //   162: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   165: ifeq +18 -> 183
    //   168: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   171: dup
    //   172: ldc_w 678
    //   175: aload_0
    //   176: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   179: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   182: athrow
    //   183: aload_0
    //   184: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   187: bipush -3
    //   189: if_icmpeq +18 -> 207
    //   192: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   195: dup
    //   196: ldc_w 678
    //   199: aload_0
    //   200: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   203: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   206: athrow
    //   207: aload_0
    //   208: getfield 368	no/nordicsemi/android/dfu/DfuBaseService:mServiceChangedIndicationsEnabled	Z
    //   211: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	DfuBaseService
    //   0	212	2	paramBluetoothGattCharacteristic	BluetoothGattCharacteristic
    // Exception table:
    //   from	to	target	type
    //   80	110	144	finally
    //   110	119	144	finally
    //   134	141	144	finally
    //   145	147	144	finally
    //   73	80	149	java/lang/InterruptedException
    //   147	149	149	java/lang/InterruptedException
  }
  
  private void logd(String paramString)
  {
    Log.d("DfuBaseService", paramString);
  }
  
  private void loge(String paramString)
  {
    Log.e("DfuBaseService", paramString);
  }
  
  private void loge(String paramString, Throwable paramThrowable)
  {
    Log.e("DfuBaseService", paramString, paramThrowable);
  }
  
  private void logi(String paramString)
  {
    Log.i("DfuBaseService", paramString);
  }
  
  private void logw(String paramString)
  {
    Log.w("DfuBaseService", paramString);
  }
  
  private static IntentFilter makeDfuActionIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
    return localIntentFilter;
  }
  
  private InputStream openInputStream(Uri paramUri, String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    InputStream localInputStream = getContentResolver().openInputStream(paramUri);
    if ("application/zip".equals(paramString)) {
      return new ArchiveInputStream(localInputStream, paramInt1, paramInt2);
    }
    paramUri = getContentResolver().query(paramUri, new String[] { "_display_name" }, null, null, null);
    try
    {
      if ((paramUri.moveToNext()) && (paramUri.getString(0).toLowerCase(Locale.US).endsWith("hex")))
      {
        paramString = new HexInputStream(localInputStream, paramInt1);
        return paramString;
      }
    }
    finally
    {
      paramUri.close();
    }
    paramUri.close();
    return localInputStream;
  }
  
  private InputStream openInputStream(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString1);
    if ("application/zip".equals(paramString2)) {
      paramString2 = new ArchiveInputStream(localFileInputStream, paramInt1, paramInt2);
    }
    do
    {
      return paramString2;
      paramString2 = localFileInputStream;
    } while (!paramString1.toLowerCase(Locale.US).endsWith("hex"));
    return new HexInputStream(localFileInputStream, paramInt1);
  }
  
  private String parse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    int j = paramArrayOfByte.length;
    if (j == 0) {
      return "";
    }
    char[] arrayOfChar = new char[j * 3 - 1];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return new String(arrayOfChar);
      }
      int k = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 3)] = HEX_ARRAY[(k >>> 4)];
      arrayOfChar[(i * 3 + 1)] = HEX_ARRAY[(k & 0xF)];
      if (i != j - 1) {
        arrayOfChar[(i * 3 + 2)] = '-';
      }
      i += 1;
    }
  }
  
  /* Error */
  private byte[] readNotificationResponse()
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   5: aload_0
    //   6: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   9: astore_1
    //   10: aload_1
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   16: ifnonnull +26 -> 42
    //   19: aload_0
    //   20: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   23: bipush -3
    //   25: if_icmpne +17 -> 42
    //   28: aload_0
    //   29: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   32: ifne +10 -> 42
    //   35: aload_0
    //   36: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   39: ifeq +27 -> 66
    //   42: aload_0
    //   43: getfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   46: ifne +20 -> 66
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   55: ifeq +38 -> 93
    //   58: new 578	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   61: dup
    //   62: invokespecial 641	no/nordicsemi/android/dfu/exception/UploadAbortedException:<init>	()V
    //   65: athrow
    //   66: aload_0
    //   67: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   70: invokevirtual 504	java/lang/Object:wait	()V
    //   73: goto -61 -> 12
    //   76: astore_2
    //   77: aload_1
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: ldc_w 501
    //   86: aload_1
    //   87: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: goto -39 -> 51
    //   93: aload_0
    //   94: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   97: ifeq +18 -> 115
    //   100: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   103: dup
    //   104: ldc_w 780
    //   107: aload_0
    //   108: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   111: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   114: athrow
    //   115: aload_0
    //   116: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   119: bipush -3
    //   121: if_icmpeq +18 -> 139
    //   124: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   127: dup
    //   128: ldc_w 780
    //   131: aload_0
    //   132: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   135: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   138: athrow
    //   139: aload_0
    //   140: getfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   143: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	DfuBaseService
    //   81	6	1	localInterruptedException	InterruptedException
    //   76	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	42	76	finally
    //   42	51	76	finally
    //   66	73	76	finally
    //   77	79	76	finally
    //   5	12	81	java/lang/InterruptedException
    //   79	81	81	java/lang/InterruptedException
  }
  
  /* Error */
  private int readVersion(BluetoothGatt arg1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   4: bipush -3
    //   6: if_icmpeq +18 -> 24
    //   9: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   12: dup
    //   13: ldc_w 784
    //   16: aload_0
    //   17: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   20: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   23: athrow
    //   24: aload_2
    //   25: ifnonnull +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   40: aload_0
    //   41: ldc_w 786
    //   44: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: iconst_1
    //   49: ldc_w 786
    //   52: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   55: aload_1
    //   56: aload_2
    //   57: invokevirtual 790	android/bluetooth/BluetoothGatt:readCharacteristic	(Landroid/bluetooth/BluetoothGattCharacteristic;)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   65: astore_1
    //   66: aload_1
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield 457	no/nordicsemi/android/dfu/DfuBaseService:mRequestCompleted	Z
    //   72: ifne +26 -> 98
    //   75: aload_0
    //   76: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   79: bipush -3
    //   81: if_icmpne +17 -> 98
    //   84: aload_0
    //   85: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   88: ifne +10 -> 98
    //   91: aload_0
    //   92: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   95: ifeq +27 -> 122
    //   98: aload_0
    //   99: getfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   102: ifne +20 -> 122
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   111: ifeq +38 -> 149
    //   114: new 578	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   117: dup
    //   118: invokespecial 641	no/nordicsemi/android/dfu/exception/UploadAbortedException:<init>	()V
    //   121: athrow
    //   122: aload_0
    //   123: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   126: invokevirtual 504	java/lang/Object:wait	()V
    //   129: goto -61 -> 68
    //   132: astore_3
    //   133: aload_1
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: ldc_w 501
    //   142: aload_1
    //   143: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: goto -39 -> 107
    //   149: aload_0
    //   150: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   153: ifeq +18 -> 171
    //   156: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   159: dup
    //   160: ldc_w 784
    //   163: aload_0
    //   164: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   167: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   170: athrow
    //   171: aload_0
    //   172: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   175: bipush -3
    //   177: if_icmpeq +18 -> 195
    //   180: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   183: dup
    //   184: ldc_w 784
    //   187: aload_0
    //   188: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   191: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   194: athrow
    //   195: aload_2
    //   196: bipush 18
    //   198: iconst_0
    //   199: invokevirtual 794	android/bluetooth/BluetoothGattCharacteristic:getIntValue	(II)Ljava/lang/Integer;
    //   202: invokevirtual 799	java/lang/Integer:intValue	()I
    //   205: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	DfuBaseService
    //   0	206	2	paramBluetoothGattCharacteristic	BluetoothGattCharacteristic
    //   132	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	98	132	finally
    //   98	107	132	finally
    //   122	129	132	finally
    //   133	135	132	finally
    //   61	68	137	java/lang/InterruptedException
    //   135	137	137	java/lang/InterruptedException
  }
  
  private void refreshDeviceCache(BluetoothGatt paramBluetoothGatt, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramBluetoothGatt.getDevice().getBondState() == 10)) {
      sendLogBroadcast(0, "gatt.refresh()");
    }
    try
    {
      Method localMethod = paramBluetoothGatt.getClass().getMethod("refresh", new Class[0]);
      if (localMethod != null)
      {
        paramBoolean = ((Boolean)localMethod.invoke(paramBluetoothGatt, new Object[0])).booleanValue();
        logi("Refreshing result: " + paramBoolean);
      }
      return;
    }
    catch (Exception paramBluetoothGatt)
    {
      loge("An exception occurred while refreshing device", paramBluetoothGatt);
      sendLogBroadcast(15, "Refreshing failed");
    }
  }
  
  /* Error */
  private boolean removeBond(BluetoothDevice paramBluetoothDevice)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 513	android/bluetooth/BluetoothDevice:getBondState	()I
    //   4: bipush 10
    //   6: if_icmpne +5 -> 11
    //   9: iconst_1
    //   10: ireturn
    //   11: aload_0
    //   12: iconst_1
    //   13: ldc_w 821
    //   16: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   19: iconst_0
    //   20: istore_3
    //   21: iload_3
    //   22: istore_2
    //   23: aload_1
    //   24: invokevirtual 534	java/lang/Object:getClass	()Ljava/lang/Class;
    //   27: ldc_w 822
    //   30: iconst_0
    //   31: anewarray 537	java/lang/Class
    //   34: invokevirtual 541	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +115 -> 156
    //   44: iload_3
    //   45: istore_2
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 457	no/nordicsemi/android/dfu/DfuBaseService:mRequestCompleted	Z
    //   51: iload_3
    //   52: istore_2
    //   53: aload_0
    //   54: iconst_0
    //   55: ldc_w 824
    //   58: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   61: iload_3
    //   62: istore_2
    //   63: aload 4
    //   65: aload_1
    //   66: iconst_0
    //   67: anewarray 328	java/lang/Object
    //   70: invokevirtual 549	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 551	java/lang/Boolean
    //   76: invokevirtual 554	java/lang/Boolean:booleanValue	()Z
    //   79: istore_3
    //   80: iload_3
    //   81: istore_2
    //   82: aload_0
    //   83: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   86: astore_1
    //   87: iload_3
    //   88: istore_2
    //   89: aload_1
    //   90: monitorenter
    //   91: aload_0
    //   92: getfield 457	no/nordicsemi/android/dfu/DfuBaseService:mRequestCompleted	Z
    //   95: ifne +10 -> 105
    //   98: aload_0
    //   99: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   102: ifeq +8 -> 110
    //   105: aload_1
    //   106: monitorexit
    //   107: goto +49 -> 156
    //   110: aload_0
    //   111: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   114: invokevirtual 504	java/lang/Object:wait	()V
    //   117: goto -26 -> 91
    //   120: astore 4
    //   122: aload_1
    //   123: monitorexit
    //   124: iload_3
    //   125: istore_2
    //   126: aload 4
    //   128: athrow
    //   129: astore_1
    //   130: iload_3
    //   131: istore_2
    //   132: aload_0
    //   133: ldc_w 501
    //   136: aload_1
    //   137: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: goto +16 -> 156
    //   143: astore_1
    //   144: ldc -47
    //   146: ldc_w 826
    //   149: aload_1
    //   150: invokestatic 562	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   153: pop
    //   154: iload_2
    //   155: ireturn
    //   156: iconst_1
    //   157: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	DfuBaseService
    //   0	158	1	paramBluetoothDevice	BluetoothDevice
    //   22	133	2	bool1	boolean
    //   20	111	3	bool2	boolean
    //   37	27	4	localMethod	Method
    //   120	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   91	105	120	finally
    //   105	107	120	finally
    //   110	117	120	finally
    //   122	124	120	finally
    //   82	87	129	java/lang/InterruptedException
    //   89	91	129	java/lang/InterruptedException
    //   126	129	129	java/lang/InterruptedException
    //   23	39	143	java/lang/Exception
    //   46	51	143	java/lang/Exception
    //   53	61	143	java/lang/Exception
    //   63	80	143	java/lang/Exception
    //   82	87	143	java/lang/Exception
    //   89	91	143	java/lang/Exception
    //   126	129	143	java/lang/Exception
    //   132	140	143	java/lang/Exception
  }
  
  private void sendErrorBroadcast(int paramInt)
  {
    Intent localIntent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
    if ((paramInt & 0x4000) > 0)
    {
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", paramInt & 0xBFFF);
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 2);
    }
    for (;;)
    {
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.mDeviceAddress);
      LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
      return;
      if ((0x8000 & paramInt) > 0)
      {
        localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0xFFFF7FFF & paramInt);
        localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 1);
      }
      else if ((paramInt & 0x2000) > 0)
      {
        localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", paramInt);
        localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 3);
      }
      else
      {
        localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", paramInt);
        localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 0);
      }
    }
  }
  
  private void sendLogBroadcast(int paramInt, String paramString)
  {
    paramString = "[DFU] " + paramString;
    Intent localIntent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG");
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO", paramString);
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL", paramInt);
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.mDeviceAddress);
    LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
  }
  
  private void sendProgressBroadcast(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    float f1;
    if (l - this.mLastProgressTime != 0L)
    {
      f1 = (this.mBytesSent - this.mLastBytesSent) / (float)(l - this.mLastProgressTime);
      if (l - this.mStartTime == 0L) {
        break label168;
      }
    }
    label168:
    for (float f2 = this.mBytesSent / (float)(l - this.mStartTime);; f2 = 0.0F)
    {
      this.mLastProgressTime = l;
      this.mLastBytesSent = this.mBytesSent;
      Intent localIntent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", paramInt);
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.mDeviceAddress);
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", this.mPartCurrent);
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", this.mPartsTotal);
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS", f1);
      localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS", f2);
      LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private void setNumberOfPackets(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[1] = ((byte)(paramInt & 0xFF));
    paramArrayOfByte[2] = ((byte)(paramInt >> 8 & 0xFF));
  }
  
  private void terminateConnection(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    if (this.mConnectionState != 0)
    {
      updateProgressNotification(-5);
      disconnect(paramBluetoothGatt);
      sendLogBroadcast(5, "Disconnected");
    }
    refreshDeviceCache(paramBluetoothGatt, false);
    close(paramBluetoothGatt);
    updateProgressNotification(paramInt);
  }
  
  private void updateProgressNotification()
  {
    int i = (int)(100.0F * this.mBytesSent / this.mImageSizeInBytes);
    if (this.mLastProgress == i) {
      return;
    }
    this.mLastProgress = i;
    updateProgressNotification(i);
  }
  
  private void updateProgressNotification(int paramInt)
  {
    if (paramInt < 4096)
    {
      sendProgressBroadcast(paramInt);
      return;
    }
    sendErrorBroadcast(paramInt);
  }
  
  /* Error */
  private byte[] uploadFirmwareImage(BluetoothGatt arg1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, InputStream paramInputStream)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   10: getstatic 322	no/nordicsemi/android/dfu/DfuBaseService:mBuffer	[B
    //   13: astore 5
    //   15: aload_3
    //   16: aload 5
    //   18: invokevirtual 900	java/io/InputStream:read	([B)I
    //   21: istore 4
    //   23: aload_0
    //   24: iconst_1
    //   25: new 582	java/lang/StringBuilder
    //   28: dup
    //   29: ldc_w 902
    //   32: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_2
    //   36: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   39: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: ldc_w 604
    //   45: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   54: aload_0
    //   55: aload_1
    //   56: aload_2
    //   57: aload 5
    //   59: iload 4
    //   61: invokespecial 430	no/nordicsemi/android/dfu/DfuBaseService:writePacket	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[BI)V
    //   64: aload_0
    //   65: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   68: astore_1
    //   69: aload_1
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   75: ifnonnull +26 -> 101
    //   78: aload_0
    //   79: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   82: bipush -3
    //   84: if_icmpne +17 -> 101
    //   87: aload_0
    //   88: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   91: ifne +10 -> 101
    //   94: aload_0
    //   95: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   98: ifeq +57 -> 155
    //   101: aload_0
    //   102: getfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   105: ifne +50 -> 155
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   114: ifeq +68 -> 182
    //   117: new 578	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   120: dup
    //   121: invokespecial 641	no/nordicsemi/android/dfu/exception/UploadAbortedException:<init>	()V
    //   124: athrow
    //   125: astore_1
    //   126: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   129: dup
    //   130: ldc_w 904
    //   133: sipush 4099
    //   136: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   139: athrow
    //   140: astore_1
    //   141: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   144: dup
    //   145: ldc_w 906
    //   148: sipush 4100
    //   151: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   154: athrow
    //   155: aload_0
    //   156: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   159: invokevirtual 504	java/lang/Object:wait	()V
    //   162: goto -91 -> 71
    //   165: astore_2
    //   166: aload_1
    //   167: monitorexit
    //   168: aload_2
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: ldc_w 501
    //   175: aload_1
    //   176: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: goto -69 -> 110
    //   182: aload_0
    //   183: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   186: ifeq +18 -> 204
    //   189: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   192: dup
    //   193: ldc_w 908
    //   196: aload_0
    //   197: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   200: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   203: athrow
    //   204: aload_0
    //   205: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   208: bipush -3
    //   210: if_icmpeq +18 -> 228
    //   213: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   216: dup
    //   217: ldc_w 910
    //   220: aload_0
    //   221: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   224: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   227: athrow
    //   228: aload_0
    //   229: getfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   232: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	DfuBaseService
    //   0	233	2	paramBluetoothGattCharacteristic	BluetoothGattCharacteristic
    //   0	233	3	paramInputStream	InputStream
    //   21	39	4	i	int
    //   13	45	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	64	125	no/nordicsemi/android/dfu/exception/HexFileValidationException
    //   15	64	140	java/io/IOException
    //   71	101	165	finally
    //   101	110	165	finally
    //   155	162	165	finally
    //   166	168	165	finally
    //   64	71	170	java/lang/InterruptedException
    //   168	170	170	java/lang/InterruptedException
  }
  
  private void waitIfPaused()
  {
    synchronized (this.mLock)
    {
      try
      {
        boolean bool = this.mPaused;
        if (bool) {
          break label19;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          label19:
          loge("Sleeping interrupted", localInterruptedException);
        }
      }
      return;
      this.mLock.wait();
    }
  }
  
  private void waitUntilDisconnected()
  {
    try
    {
      synchronized (this.mLock)
      {
        if ((this.mConnectionState == 0) || (this.mError != 0)) {
          return;
        }
        this.mLock.wait();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      loge("Sleeping interrupted", localInterruptedException);
    }
  }
  
  /* Error */
  private void writeImageSize(BluetoothGatt arg1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 376	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeSent	Z
    //   15: aload_2
    //   16: iconst_1
    //   17: invokevirtual 914	android/bluetooth/BluetoothGattCharacteristic:setWriteType	(I)V
    //   20: aload_2
    //   21: iconst_4
    //   22: newarray <illegal type>
    //   24: invokevirtual 915	android/bluetooth/BluetoothGattCharacteristic:setValue	([B)Z
    //   27: pop
    //   28: aload_2
    //   29: iload_3
    //   30: bipush 20
    //   32: iconst_0
    //   33: invokevirtual 918	android/bluetooth/BluetoothGattCharacteristic:setValue	(III)Z
    //   36: pop
    //   37: aload_0
    //   38: iconst_1
    //   39: new 582	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 920
    //   46: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_2
    //   50: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   53: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   62: aload_0
    //   63: iconst_0
    //   64: new 582	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 922
    //   71: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   78: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: ldc_w 924
    //   84: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual 927	android/bluetooth/BluetoothGatt:writeCharacteristic	(Landroid/bluetooth/BluetoothGattCharacteristic;)Z
    //   98: pop
    //   99: aload_0
    //   100: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   103: astore_1
    //   104: aload_1
    //   105: monitorenter
    //   106: aload_0
    //   107: getfield 376	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeSent	Z
    //   110: ifne +26 -> 136
    //   113: aload_0
    //   114: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   117: bipush -3
    //   119: if_icmpne +17 -> 136
    //   122: aload_0
    //   123: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   126: ifne +10 -> 136
    //   129: aload_0
    //   130: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   133: ifeq +27 -> 160
    //   136: aload_0
    //   137: getfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   140: ifne +20 -> 160
    //   143: aload_1
    //   144: monitorexit
    //   145: aload_0
    //   146: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   149: ifeq +38 -> 187
    //   152: new 578	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   155: dup
    //   156: invokespecial 641	no/nordicsemi/android/dfu/exception/UploadAbortedException:<init>	()V
    //   159: athrow
    //   160: aload_0
    //   161: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   164: invokevirtual 504	java/lang/Object:wait	()V
    //   167: goto -61 -> 106
    //   170: astore_2
    //   171: aload_1
    //   172: monitorexit
    //   173: aload_2
    //   174: athrow
    //   175: astore_1
    //   176: aload_0
    //   177: ldc_w 501
    //   180: aload_1
    //   181: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -39 -> 145
    //   187: aload_0
    //   188: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   191: ifeq +18 -> 209
    //   194: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   197: dup
    //   198: ldc_w 929
    //   201: aload_0
    //   202: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   205: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   208: athrow
    //   209: aload_0
    //   210: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   213: bipush -3
    //   215: if_icmpeq +18 -> 233
    //   218: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   221: dup
    //   222: ldc_w 929
    //   225: aload_0
    //   226: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   229: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   232: athrow
    //   233: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	DfuBaseService
    //   0	234	2	paramBluetoothGattCharacteristic	BluetoothGattCharacteristic
    //   0	234	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   106	136	170	finally
    //   136	145	170	finally
    //   160	167	170	finally
    //   171	173	170	finally
    //   99	106	175	java/lang/InterruptedException
    //   173	175	175	java/lang/InterruptedException
  }
  
  /* Error */
  private void writeImageSize(BluetoothGatt arg1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt1, int paramInt2, int paramInt3)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 376	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeSent	Z
    //   15: aload_2
    //   16: iconst_1
    //   17: invokevirtual 914	android/bluetooth/BluetoothGattCharacteristic:setWriteType	(I)V
    //   20: aload_2
    //   21: bipush 12
    //   23: newarray <illegal type>
    //   25: invokevirtual 915	android/bluetooth/BluetoothGattCharacteristic:setValue	([B)Z
    //   28: pop
    //   29: aload_2
    //   30: iload_3
    //   31: bipush 20
    //   33: iconst_0
    //   34: invokevirtual 918	android/bluetooth/BluetoothGattCharacteristic:setValue	(III)Z
    //   37: pop
    //   38: aload_2
    //   39: iload 4
    //   41: bipush 20
    //   43: iconst_4
    //   44: invokevirtual 918	android/bluetooth/BluetoothGattCharacteristic:setValue	(III)Z
    //   47: pop
    //   48: aload_2
    //   49: iload 5
    //   51: bipush 20
    //   53: bipush 8
    //   55: invokevirtual 918	android/bluetooth/BluetoothGattCharacteristic:setValue	(III)Z
    //   58: pop
    //   59: aload_0
    //   60: iconst_1
    //   61: new 582	java/lang/StringBuilder
    //   64: dup
    //   65: ldc_w 920
    //   68: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: aload_2
    //   72: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   75: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   84: aload_0
    //   85: iconst_0
    //   86: new 582	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 922
    //   93: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_2
    //   97: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   100: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: ldc_w 924
    //   106: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   115: aload_1
    //   116: aload_2
    //   117: invokevirtual 927	android/bluetooth/BluetoothGatt:writeCharacteristic	(Landroid/bluetooth/BluetoothGattCharacteristic;)Z
    //   120: pop
    //   121: aload_0
    //   122: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   125: astore_1
    //   126: aload_1
    //   127: monitorenter
    //   128: aload_0
    //   129: getfield 376	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeSent	Z
    //   132: ifne +26 -> 158
    //   135: aload_0
    //   136: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   139: bipush -3
    //   141: if_icmpne +17 -> 158
    //   144: aload_0
    //   145: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   148: ifne +10 -> 158
    //   151: aload_0
    //   152: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   155: ifeq +27 -> 182
    //   158: aload_0
    //   159: getfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   162: ifne +20 -> 182
    //   165: aload_1
    //   166: monitorexit
    //   167: aload_0
    //   168: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   171: ifeq +38 -> 209
    //   174: new 578	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   177: dup
    //   178: invokespecial 641	no/nordicsemi/android/dfu/exception/UploadAbortedException:<init>	()V
    //   181: athrow
    //   182: aload_0
    //   183: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   186: invokevirtual 504	java/lang/Object:wait	()V
    //   189: goto -61 -> 128
    //   192: astore_2
    //   193: aload_1
    //   194: monitorexit
    //   195: aload_2
    //   196: athrow
    //   197: astore_1
    //   198: aload_0
    //   199: ldc_w 501
    //   202: aload_1
    //   203: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   206: goto -39 -> 167
    //   209: aload_0
    //   210: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   213: ifeq +18 -> 231
    //   216: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   219: dup
    //   220: ldc_w 932
    //   223: aload_0
    //   224: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   227: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   230: athrow
    //   231: aload_0
    //   232: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   235: bipush -3
    //   237: if_icmpeq +18 -> 255
    //   240: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   243: dup
    //   244: ldc_w 932
    //   247: aload_0
    //   248: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   251: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   254: athrow
    //   255: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	DfuBaseService
    //   0	256	2	paramBluetoothGattCharacteristic	BluetoothGattCharacteristic
    //   0	256	3	paramInt1	int
    //   0	256	4	paramInt2	int
    //   0	256	5	paramInt3	int
    // Exception table:
    //   from	to	target	type
    //   128	158	192	finally
    //   158	167	192	finally
    //   182	189	192	finally
    //   193	195	192	finally
    //   121	128	197	java/lang/InterruptedException
    //   195	197	197	java/lang/InterruptedException
  }
  
  /* Error */
  private void writeInitPacket(BluetoothGatt arg1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte, int paramInt)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 5
    //   3: aload_3
    //   4: arraylength
    //   5: iload 4
    //   7: if_icmpeq +19 -> 26
    //   10: iload 4
    //   12: newarray <illegal type>
    //   14: astore 5
    //   16: aload_3
    //   17: iconst_0
    //   18: aload 5
    //   20: iconst_0
    //   21: iload 4
    //   23: invokestatic 939	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 379	no/nordicsemi/android/dfu/DfuBaseService:mInitPacketSent	Z
    //   41: aload_2
    //   42: iconst_1
    //   43: invokevirtual 914	android/bluetooth/BluetoothGattCharacteristic:setWriteType	(I)V
    //   46: aload_2
    //   47: aload 5
    //   49: invokevirtual 915	android/bluetooth/BluetoothGattCharacteristic:setValue	([B)Z
    //   52: pop
    //   53: aload_0
    //   54: new 582	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 941
    //   61: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: aload 5
    //   67: invokespecial 943	no/nordicsemi/android/dfu/DfuBaseService:parse	([B)Ljava/lang/String;
    //   70: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 924
    //   76: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: iconst_1
    //   87: new 582	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 920
    //   94: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   101: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   110: aload_0
    //   111: iconst_0
    //   112: new 582	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 922
    //   119: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_2
    //   123: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   126: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: ldc_w 924
    //   132: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   141: aload_1
    //   142: aload_2
    //   143: invokevirtual 927	android/bluetooth/BluetoothGatt:writeCharacteristic	(Landroid/bluetooth/BluetoothGattCharacteristic;)Z
    //   146: pop
    //   147: aload_0
    //   148: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   151: astore_1
    //   152: aload_1
    //   153: monitorenter
    //   154: aload_0
    //   155: getfield 379	no/nordicsemi/android/dfu/DfuBaseService:mInitPacketSent	Z
    //   158: ifne +26 -> 184
    //   161: aload_0
    //   162: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   165: bipush -3
    //   167: if_icmpne +17 -> 184
    //   170: aload_0
    //   171: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   174: ifne +10 -> 184
    //   177: aload_0
    //   178: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   181: ifeq +27 -> 208
    //   184: aload_0
    //   185: getfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   188: ifne +20 -> 208
    //   191: aload_1
    //   192: monitorexit
    //   193: aload_0
    //   194: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   197: ifeq +38 -> 235
    //   200: new 578	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   203: dup
    //   204: invokespecial 641	no/nordicsemi/android/dfu/exception/UploadAbortedException:<init>	()V
    //   207: athrow
    //   208: aload_0
    //   209: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   212: invokevirtual 504	java/lang/Object:wait	()V
    //   215: goto -61 -> 154
    //   218: astore_2
    //   219: aload_1
    //   220: monitorexit
    //   221: aload_2
    //   222: athrow
    //   223: astore_1
    //   224: aload_0
    //   225: ldc_w 501
    //   228: aload_1
    //   229: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: goto -39 -> 193
    //   235: aload_0
    //   236: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   239: ifeq +18 -> 257
    //   242: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   245: dup
    //   246: ldc_w 945
    //   249: aload_0
    //   250: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   253: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   256: athrow
    //   257: aload_0
    //   258: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   261: bipush -3
    //   263: if_icmpeq +18 -> 281
    //   266: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   269: dup
    //   270: ldc_w 945
    //   273: aload_0
    //   274: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   277: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   280: athrow
    //   281: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	DfuBaseService
    //   0	282	2	paramBluetoothGattCharacteristic	BluetoothGattCharacteristic
    //   0	282	3	paramArrayOfByte	byte[]
    //   0	282	4	paramInt	int
    //   1	65	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   154	184	218	finally
    //   184	193	218	finally
    //   208	215	218	finally
    //   219	221	218	finally
    //   147	154	223	java/lang/InterruptedException
    //   221	223	223	java/lang/InterruptedException
  }
  
  private void writeOpCode(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    boolean bool = false;
    if ((paramArrayOfByte[0] != 6) && (paramArrayOfByte[0] != 5)) {}
    for (;;)
    {
      writeOpCode(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramArrayOfByte, bool);
      return;
      bool = true;
    }
  }
  
  /* Error */
  private void writeOpCode(BluetoothGatt arg1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte, boolean paramBoolean)
    throws DeviceDisconnectedException, DfuException, UploadAbortedException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 336	no/nordicsemi/android/dfu/DfuBaseService:mReceivedData	[B
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 457	no/nordicsemi/android/dfu/DfuBaseService:mRequestCompleted	Z
    //   15: aload_0
    //   16: iload 4
    //   18: putfield 412	no/nordicsemi/android/dfu/DfuBaseService:mResetRequestSent	Z
    //   21: aload_2
    //   22: aload_3
    //   23: invokevirtual 915	android/bluetooth/BluetoothGattCharacteristic:setValue	([B)Z
    //   26: pop
    //   27: aload_0
    //   28: iconst_1
    //   29: new 582	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 920
    //   36: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_2
    //   40: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   43: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   52: aload_0
    //   53: iconst_0
    //   54: new 582	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 922
    //   61: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_2
    //   65: invokevirtual 611	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   68: invokevirtual 614	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: ldc_w 924
    //   74: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   83: aload_1
    //   84: aload_2
    //   85: invokevirtual 927	android/bluetooth/BluetoothGatt:writeCharacteristic	(Landroid/bluetooth/BluetoothGattCharacteristic;)Z
    //   88: pop
    //   89: aload_0
    //   90: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   93: astore_1
    //   94: aload_1
    //   95: monitorenter
    //   96: aload_0
    //   97: getfield 457	no/nordicsemi/android/dfu/DfuBaseService:mRequestCompleted	Z
    //   100: ifne +26 -> 126
    //   103: aload_0
    //   104: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   107: bipush -3
    //   109: if_icmpne +17 -> 126
    //   112: aload_0
    //   113: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   116: ifne +10 -> 126
    //   119: aload_0
    //   120: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   123: ifeq +27 -> 150
    //   126: aload_0
    //   127: getfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   130: ifne +20 -> 150
    //   133: aload_1
    //   134: monitorexit
    //   135: aload_0
    //   136: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   139: ifeq +38 -> 177
    //   142: new 578	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   145: dup
    //   146: invokespecial 641	no/nordicsemi/android/dfu/exception/UploadAbortedException:<init>	()V
    //   149: athrow
    //   150: aload_0
    //   151: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   154: invokevirtual 504	java/lang/Object:wait	()V
    //   157: goto -61 -> 96
    //   160: astore_2
    //   161: aload_1
    //   162: monitorexit
    //   163: aload_2
    //   164: athrow
    //   165: astore_1
    //   166: aload_0
    //   167: ldc_w 501
    //   170: aload_1
    //   171: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -39 -> 135
    //   177: aload_0
    //   178: getfield 412	no/nordicsemi/android/dfu/DfuBaseService:mResetRequestSent	Z
    //   181: ifne +41 -> 222
    //   184: aload_0
    //   185: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   188: ifeq +34 -> 222
    //   191: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   194: dup
    //   195: new 582	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 952
    //   202: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: aload_3
    //   206: iconst_0
    //   207: baload
    //   208: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: aload_0
    //   215: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   218: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   221: athrow
    //   222: aload_0
    //   223: getfield 412	no/nordicsemi/android/dfu/DfuBaseService:mResetRequestSent	Z
    //   226: ifne +43 -> 269
    //   229: aload_0
    //   230: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   233: bipush -3
    //   235: if_icmpeq +34 -> 269
    //   238: new 574	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   241: dup
    //   242: new 582	java/lang/StringBuilder
    //   245: dup
    //   246: ldc_w 952
    //   249: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   252: aload_3
    //   253: iconst_0
    //   254: baload
    //   255: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: aload_0
    //   262: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   265: invokespecial 598	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:<init>	(Ljava/lang/String;I)V
    //   268: athrow
    //   269: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	DfuBaseService
    //   0	270	2	paramBluetoothGattCharacteristic	BluetoothGattCharacteristic
    //   0	270	3	paramArrayOfByte	byte[]
    //   0	270	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   96	126	160	finally
    //   126	135	160	finally
    //   150	157	160	finally
    //   161	163	160	finally
    //   89	96	165	java/lang/InterruptedException
    //   163	165	165	java/lang/InterruptedException
  }
  
  private void writePacket(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length != paramInt)
    {
      arrayOfByte = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    }
    paramBluetoothGattCharacteristic.setValue(arrayOfByte);
    paramBluetoothGatt.writeCharacteristic(paramBluetoothGattCharacteristic);
  }
  
  protected abstract Class<? extends Activity> getNotificationTarget();
  
  public void onCreate()
  {
    super.onCreate();
    initialize();
    Object localObject = LocalBroadcastManager.getInstance(this);
    IntentFilter localIntentFilter = makeDfuActionIntentFilter();
    ((LocalBroadcastManager)localObject).registerReceiver(this.mDfuActionReceiver, localIntentFilter);
    registerReceiver(this.mDfuActionReceiver, localIntentFilter);
    localObject = new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED");
    registerReceiver(this.mConnectionStateBroadcastReceiver, (IntentFilter)localObject);
    localObject = new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED");
    registerReceiver(this.mBondStateBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDfuActionReceiver);
    unregisterReceiver(this.mDfuActionReceiver);
    unregisterReceiver(this.mConnectionStateBroadcastReceiver);
    unregisterReceiver(this.mBondStateBroadcastReceiver);
  }
  
  /* Error */
  protected void onHandleIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 999	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: astore 15
    //   6: aload_1
    //   7: ldc 93
    //   9: invokevirtual 1003	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 24
    //   14: aload_1
    //   15: ldc 96
    //   17: invokevirtual 1003	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 16
    //   22: aload_1
    //   23: ldc 105
    //   25: invokevirtual 1003	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 27
    //   30: aload_1
    //   31: ldc 111
    //   33: invokevirtual 1007	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   36: checkcast 1009	android/net/Uri
    //   39: astore 28
    //   41: aload_1
    //   42: ldc 114
    //   44: invokevirtual 1003	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 25
    //   49: aload_1
    //   50: ldc 117
    //   52: invokevirtual 1007	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   55: checkcast 1009	android/net/Uri
    //   58: astore 26
    //   60: aload_1
    //   61: ldc 108
    //   63: iconst_0
    //   64: invokevirtual 1013	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   67: istore_2
    //   68: iload_2
    //   69: istore_3
    //   70: aload 27
    //   72: ifnull +28 -> 100
    //   75: iload_2
    //   76: istore_3
    //   77: iload_2
    //   78: ifne +22 -> 100
    //   81: aload 27
    //   83: getstatic 749	java/util/Locale:US	Ljava/util/Locale;
    //   86: invokevirtual 753	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   89: ldc_w 1015
    //   92: invokevirtual 759	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   95: ifeq +91 -> 186
    //   98: iconst_0
    //   99: istore_3
    //   100: aload_1
    //   101: ldc 102
    //   103: invokevirtual 1003	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 17
    //   108: aload 17
    //   110: ifnull +81 -> 191
    //   113: aload_0
    //   114: aload_1
    //   115: ldc -124
    //   117: iconst_1
    //   118: invokevirtual 1013	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   121: putfield 866	no/nordicsemi/android/dfu/DfuBaseService:mPartCurrent	I
    //   124: aload_0
    //   125: aload_1
    //   126: ldc -127
    //   128: iconst_1
    //   129: invokevirtual 1013	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   132: putfield 868	no/nordicsemi/android/dfu/DfuBaseService:mPartsTotal	I
    //   135: iload_3
    //   136: bipush -8
    //   138: iand
    //   139: ifgt +23 -> 162
    //   142: ldc -95
    //   144: aload 17
    //   146: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifne +60 -> 209
    //   152: ldc -98
    //   154: aload 17
    //   156: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   159: ifne +50 -> 209
    //   162: aload_0
    //   163: ldc_w 1017
    //   166: invokespecial 1019	no/nordicsemi/android/dfu/DfuBaseService:logw	(Ljava/lang/String;)V
    //   169: aload_0
    //   170: bipush 15
    //   172: ldc_w 1017
    //   175: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   178: aload_0
    //   179: sipush 4105
    //   182: invokespecial 890	no/nordicsemi/android/dfu/DfuBaseService:sendErrorBroadcast	(I)V
    //   185: return
    //   186: iconst_4
    //   187: istore_3
    //   188: goto -88 -> 100
    //   191: iload_3
    //   192: ifne +10 -> 202
    //   195: ldc -95
    //   197: astore 17
    //   199: goto -86 -> 113
    //   202: ldc -98
    //   204: astore 17
    //   206: goto -93 -> 113
    //   209: ldc -98
    //   211: aload 17
    //   213: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   216: ifeq +42 -> 258
    //   219: iload_3
    //   220: iconst_1
    //   221: if_icmpeq +37 -> 258
    //   224: iload_3
    //   225: iconst_2
    //   226: if_icmpeq +32 -> 258
    //   229: iload_3
    //   230: iconst_4
    //   231: if_icmpeq +27 -> 258
    //   234: aload_0
    //   235: ldc_w 1021
    //   238: invokespecial 1019	no/nordicsemi/android/dfu/DfuBaseService:logw	(Ljava/lang/String;)V
    //   241: aload_0
    //   242: bipush 15
    //   244: ldc_w 1021
    //   247: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   250: aload_0
    //   251: sipush 4105
    //   254: invokespecial 890	no/nordicsemi/android/dfu/DfuBaseService:sendErrorBroadcast	(I)V
    //   257: return
    //   258: aload_0
    //   259: aload 24
    //   261: putfield 356	no/nordicsemi/android/dfu/DfuBaseService:mDeviceAddress	Ljava/lang/String;
    //   264: aload_0
    //   265: aload 16
    //   267: putfield 1023	no/nordicsemi/android/dfu/DfuBaseService:mDeviceName	Ljava/lang/String;
    //   270: aload_0
    //   271: iconst_0
    //   272: putfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   275: aload_0
    //   276: iconst_0
    //   277: putfield 383	no/nordicsemi/android/dfu/DfuBaseService:mBytesSent	I
    //   280: aload_0
    //   281: iconst_0
    //   282: putfield 448	no/nordicsemi/android/dfu/DfuBaseService:mBytesConfirmed	I
    //   285: aload_0
    //   286: iconst_0
    //   287: putfield 388	no/nordicsemi/android/dfu/DfuBaseService:mPacketsSentSinceNotification	I
    //   290: aload_0
    //   291: iconst_0
    //   292: putfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   295: aload_0
    //   296: lconst_0
    //   297: putfield 860	no/nordicsemi/android/dfu/DfuBaseService:mLastProgressTime	J
    //   300: aload_0
    //   301: iconst_0
    //   302: putfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   305: aload_0
    //   306: iconst_0
    //   307: putfield 453	no/nordicsemi/android/dfu/DfuBaseService:mPaused	Z
    //   310: aload_0
    //   311: iconst_0
    //   312: putfield 371	no/nordicsemi/android/dfu/DfuBaseService:mNotificationsEnabled	Z
    //   315: aload_0
    //   316: iconst_0
    //   317: putfield 412	no/nordicsemi/android/dfu/DfuBaseService:mResetRequestSent	Z
    //   320: aload_0
    //   321: iconst_0
    //   322: putfield 457	no/nordicsemi/android/dfu/DfuBaseService:mRequestCompleted	Z
    //   325: aload_0
    //   326: iconst_0
    //   327: putfield 376	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeSent	Z
    //   330: aload_0
    //   331: iconst_0
    //   332: putfield 409	no/nordicsemi/android/dfu/DfuBaseService:mRemoteErrorOccurred	Z
    //   335: aload 15
    //   337: ldc_w 1025
    //   340: iconst_1
    //   341: invokeinterface 1031 3 0
    //   346: istore 9
    //   348: aload 15
    //   350: ldc_w 1033
    //   353: bipush 10
    //   355: invokestatic 1036	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   358: invokeinterface 1039 3 0
    //   363: astore 16
    //   365: aload 16
    //   367: invokestatic 1043	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   370: istore 4
    //   372: iload 4
    //   374: iflt +14 -> 388
    //   377: iload 4
    //   379: istore_2
    //   380: iload 4
    //   382: ldc_w 1044
    //   385: if_icmple +6 -> 391
    //   388: bipush 10
    //   390: istore_2
    //   391: iload 9
    //   393: ifne +5 -> 398
    //   396: iconst_0
    //   397: istore_2
    //   398: aload_0
    //   399: iload_2
    //   400: putfield 334	no/nordicsemi/android/dfu/DfuBaseService:mPacketsBeforeNotification	I
    //   403: aload 15
    //   405: ldc_w 1046
    //   408: sipush 4096
    //   411: invokestatic 1036	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   414: invokeinterface 1039 3 0
    //   419: astore 15
    //   421: aload 15
    //   423: invokestatic 1043	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   426: istore 4
    //   428: iload 4
    //   430: istore_2
    //   431: iload 4
    //   433: ifge +5 -> 438
    //   436: iconst_0
    //   437: istore_2
    //   438: aload_0
    //   439: iconst_1
    //   440: ldc_w 1048
    //   443: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   446: aconst_null
    //   447: astore 18
    //   449: aconst_null
    //   450: astore 22
    //   452: aconst_null
    //   453: astore 23
    //   455: aconst_null
    //   456: astore 15
    //   458: aload 15
    //   460: astore 19
    //   462: aload 18
    //   464: astore 20
    //   466: aload 22
    //   468: astore 21
    //   470: aload 23
    //   472: astore 16
    //   474: aload_0
    //   475: iconst_1
    //   476: ldc_w 1050
    //   479: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   482: aload 28
    //   484: ifnull +317 -> 801
    //   487: aload 15
    //   489: astore 19
    //   491: aload 18
    //   493: astore 20
    //   495: aload 22
    //   497: astore 21
    //   499: aload 23
    //   501: astore 16
    //   503: aload_0
    //   504: aload 28
    //   506: aload 17
    //   508: iload_2
    //   509: iload_3
    //   510: invokespecial 1052	no/nordicsemi/android/dfu/DfuBaseService:openInputStream	(Landroid/net/Uri;Ljava/lang/String;II)Ljava/io/InputStream;
    //   513: astore 15
    //   515: aload 26
    //   517: ifnull +315 -> 832
    //   520: aload 15
    //   522: astore 19
    //   524: aload 15
    //   526: astore 20
    //   528: aload 15
    //   530: astore 21
    //   532: aload 15
    //   534: astore 16
    //   536: aload_0
    //   537: invokevirtual 714	no/nordicsemi/android/dfu/DfuBaseService:getContentResolver	()Landroid/content/ContentResolver;
    //   540: aload 26
    //   542: invokevirtual 719	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   545: astore 18
    //   547: aload 18
    //   549: astore 16
    //   551: aload_0
    //   552: aload 15
    //   554: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   557: aload 15
    //   559: invokevirtual 1055	java/io/InputStream:available	()I
    //   562: istore 4
    //   564: aload_0
    //   565: iload 4
    //   567: putfield 396	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeInBytes	I
    //   570: iload_3
    //   571: istore_2
    //   572: iload_3
    //   573: ifne +24 -> 597
    //   576: iload_3
    //   577: istore_2
    //   578: ldc -95
    //   580: aload 17
    //   582: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   585: ifeq +12 -> 597
    //   588: aload 15
    //   590: checkcast 725	no/nordicsemi/android/dfu/ArchiveInputStream
    //   593: invokevirtual 1058	no/nordicsemi/android/dfu/ArchiveInputStream:getContentType	()I
    //   596: istore_2
    //   597: aload_0
    //   598: iload_2
    //   599: putfield 1060	no/nordicsemi/android/dfu/DfuBaseService:mFileType	I
    //   602: ldc -95
    //   604: aload 17
    //   606: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   609: ifeq +4717 -> 5326
    //   612: aload 15
    //   614: checkcast 725	no/nordicsemi/android/dfu/ArchiveInputStream
    //   617: astore 18
    //   619: iload_2
    //   620: iconst_4
    //   621: if_icmpne +250 -> 871
    //   624: aload 18
    //   626: invokevirtual 1063	no/nordicsemi/android/dfu/ArchiveInputStream:getApplicationInit	()[B
    //   629: ifnull +4697 -> 5326
    //   632: new 1065	java/io/ByteArrayInputStream
    //   635: dup
    //   636: aload 18
    //   638: invokevirtual 1063	no/nordicsemi/android/dfu/ArchiveInputStream:getApplicationInit	()[B
    //   641: invokespecial 1068	java/io/ByteArrayInputStream:<init>	([B)V
    //   644: astore 18
    //   646: aload 15
    //   648: astore 19
    //   650: aload 15
    //   652: astore 20
    //   654: aload 15
    //   656: astore 21
    //   658: aload 15
    //   660: astore 16
    //   662: aload_0
    //   663: iconst_5
    //   664: new 582	java/lang/StringBuilder
    //   667: dup
    //   668: ldc_w 1070
    //   671: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   674: aload_0
    //   675: getfield 396	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeInBytes	I
    //   678: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   681: ldc_w 1072
    //   684: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   693: aload 15
    //   695: astore 16
    //   697: aload_0
    //   698: iconst_1
    //   699: ldc_w 1074
    //   702: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   705: aload 15
    //   707: astore 16
    //   709: aload_0
    //   710: iconst_m1
    //   711: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   714: aload 15
    //   716: astore 16
    //   718: aload_0
    //   719: aload 24
    //   721: invokespecial 1076	no/nordicsemi/android/dfu/DfuBaseService:connect	(Ljava/lang/String;)Landroid/bluetooth/BluetoothGatt;
    //   724: astore 19
    //   726: aload 19
    //   728: ifnonnull +306 -> 1034
    //   731: aload 15
    //   733: astore 16
    //   735: aload_0
    //   736: ldc_w 1078
    //   739: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   742: aload 15
    //   744: astore 16
    //   746: aload_0
    //   747: bipush 20
    //   749: ldc_w 1078
    //   752: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   755: aload 15
    //   757: astore 16
    //   759: aload_0
    //   760: sipush 4106
    //   763: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   766: aload_0
    //   767: aconst_null
    //   768: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   771: aload 15
    //   773: ifnull -588 -> 185
    //   776: aload 15
    //   778: invokevirtual 1079	java/io/InputStream:close	()V
    //   781: return
    //   782: astore_1
    //   783: return
    //   784: astore 16
    //   786: bipush 10
    //   788: istore_2
    //   789: goto -398 -> 391
    //   792: astore 15
    //   794: sipush 4096
    //   797: istore_2
    //   798: goto -360 -> 438
    //   801: aload 15
    //   803: astore 19
    //   805: aload 18
    //   807: astore 20
    //   809: aload 22
    //   811: astore 21
    //   813: aload 23
    //   815: astore 16
    //   817: aload_0
    //   818: aload 27
    //   820: aload 17
    //   822: iload_2
    //   823: iload_3
    //   824: invokespecial 1081	no/nordicsemi/android/dfu/DfuBaseService:openInputStream	(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/InputStream;
    //   827: astore 15
    //   829: goto -314 -> 515
    //   832: aload 25
    //   834: ifnull +4499 -> 5333
    //   837: aload 15
    //   839: astore 19
    //   841: aload 15
    //   843: astore 20
    //   845: aload 15
    //   847: astore 21
    //   849: aload 15
    //   851: astore 16
    //   853: new 768	java/io/FileInputStream
    //   856: dup
    //   857: aload 25
    //   859: invokespecial 769	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   862: astore 18
    //   864: aload 18
    //   866: astore 16
    //   868: goto -317 -> 551
    //   871: aload 18
    //   873: invokevirtual 1084	no/nordicsemi/android/dfu/ArchiveInputStream:getSystemInit	()[B
    //   876: ifnull +4450 -> 5326
    //   879: new 1065	java/io/ByteArrayInputStream
    //   882: dup
    //   883: aload 18
    //   885: invokevirtual 1084	no/nordicsemi/android/dfu/ArchiveInputStream:getSystemInit	()[B
    //   888: invokespecial 1068	java/io/ByteArrayInputStream:<init>	([B)V
    //   891: astore 18
    //   893: goto -247 -> 646
    //   896: astore_1
    //   897: aload 19
    //   899: astore 15
    //   901: aload 15
    //   903: astore 16
    //   905: aload_0
    //   906: ldc_w 1086
    //   909: aload_1
    //   910: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   913: aload 15
    //   915: astore 16
    //   917: aload_0
    //   918: sipush 4097
    //   921: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   924: aload_0
    //   925: aconst_null
    //   926: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   929: aload 15
    //   931: ifnull -746 -> 185
    //   934: aload 15
    //   936: invokevirtual 1079	java/io/InputStream:close	()V
    //   939: return
    //   940: astore_1
    //   941: return
    //   942: astore_1
    //   943: aload 20
    //   945: astore 15
    //   947: aload 15
    //   949: astore 16
    //   951: aload_0
    //   952: ldc_w 1088
    //   955: aload_1
    //   956: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   959: aload 15
    //   961: astore 16
    //   963: aload_0
    //   964: sipush 4097
    //   967: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   970: aload_0
    //   971: aconst_null
    //   972: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   975: aload 15
    //   977: ifnull -792 -> 185
    //   980: aload 15
    //   982: invokevirtual 1079	java/io/InputStream:close	()V
    //   985: return
    //   986: astore_1
    //   987: return
    //   988: astore_1
    //   989: aload 21
    //   991: astore 15
    //   993: aload 15
    //   995: astore 16
    //   997: aload_0
    //   998: ldc_w 1090
    //   1001: aload_1
    //   1002: invokespecial 440	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1005: aload 15
    //   1007: astore 16
    //   1009: aload_0
    //   1010: sipush 4098
    //   1013: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   1016: aload_0
    //   1017: aconst_null
    //   1018: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   1021: aload 15
    //   1023: ifnull -838 -> 185
    //   1026: aload 15
    //   1028: invokevirtual 1079	java/io/InputStream:close	()V
    //   1031: return
    //   1032: astore_1
    //   1033: return
    //   1034: aload 15
    //   1036: astore 16
    //   1038: aload_0
    //   1039: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   1042: ifle +107 -> 1149
    //   1045: aload 15
    //   1047: astore 16
    //   1049: aload_0
    //   1050: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   1053: ldc_w 849
    //   1056: iand
    //   1057: istore_2
    //   1058: aload 15
    //   1060: astore 16
    //   1062: aload_0
    //   1063: new 582	java/lang/StringBuilder
    //   1066: dup
    //   1067: ldc_w 1092
    //   1070: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1073: iload_2
    //   1074: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   1083: aload 15
    //   1085: astore 16
    //   1087: aload_0
    //   1088: bipush 20
    //   1090: ldc_w 1094
    //   1093: iconst_2
    //   1094: anewarray 328	java/lang/Object
    //   1097: dup
    //   1098: iconst_0
    //   1099: iload_2
    //   1100: invokestatic 1097	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1103: aastore
    //   1104: dup
    //   1105: iconst_1
    //   1106: iload_2
    //   1107: invokestatic 1102	no/nordicsemi/android/error/GattError:parseConnectionError	(I)Ljava/lang/String;
    //   1110: aastore
    //   1111: invokestatic 1106	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1114: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1117: aload 15
    //   1119: astore 16
    //   1121: aload_0
    //   1122: aload 19
    //   1124: aload_0
    //   1125: getfield 406	no/nordicsemi/android/dfu/DfuBaseService:mError	I
    //   1128: invokespecial 1108	no/nordicsemi/android/dfu/DfuBaseService:terminateConnection	(Landroid/bluetooth/BluetoothGatt;I)V
    //   1131: aload_0
    //   1132: aconst_null
    //   1133: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   1136: aload 15
    //   1138: ifnull -953 -> 185
    //   1141: aload 15
    //   1143: invokevirtual 1079	java/io/InputStream:close	()V
    //   1146: return
    //   1147: astore_1
    //   1148: return
    //   1149: aload 15
    //   1151: astore 16
    //   1153: aload_0
    //   1154: getfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   1157: ifeq +57 -> 1214
    //   1160: aload 15
    //   1162: astore 16
    //   1164: aload_0
    //   1165: ldc_w 1110
    //   1168: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   1171: aload 15
    //   1173: astore 16
    //   1175: aload_0
    //   1176: bipush 15
    //   1178: ldc_w 1110
    //   1181: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1184: aload 15
    //   1186: astore 16
    //   1188: aload_0
    //   1189: aload 19
    //   1191: bipush -7
    //   1193: invokespecial 1108	no/nordicsemi/android/dfu/DfuBaseService:terminateConnection	(Landroid/bluetooth/BluetoothGatt;I)V
    //   1196: aload_0
    //   1197: aconst_null
    //   1198: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   1201: aload 15
    //   1203: ifnull -1018 -> 185
    //   1206: aload 15
    //   1208: invokevirtual 1079	java/io/InputStream:close	()V
    //   1211: return
    //   1212: astore_1
    //   1213: return
    //   1214: aload 15
    //   1216: astore 16
    //   1218: aload 19
    //   1220: getstatic 294	no/nordicsemi/android/dfu/DfuBaseService:DFU_SERVICE_UUID	Ljava/util/UUID;
    //   1223: invokevirtual 1114	android/bluetooth/BluetoothGatt:getService	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattService;
    //   1226: astore 22
    //   1228: aload 22
    //   1230: ifnonnull +58 -> 1288
    //   1233: aload 15
    //   1235: astore 16
    //   1237: aload_0
    //   1238: ldc_w 1116
    //   1241: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   1244: aload 15
    //   1246: astore 16
    //   1248: aload_0
    //   1249: bipush 15
    //   1251: ldc_w 1118
    //   1254: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1257: aload 15
    //   1259: astore 16
    //   1261: aload_0
    //   1262: aload 19
    //   1264: sipush 4102
    //   1267: invokespecial 1108	no/nordicsemi/android/dfu/DfuBaseService:terminateConnection	(Landroid/bluetooth/BluetoothGatt;I)V
    //   1270: aload_0
    //   1271: aconst_null
    //   1272: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   1275: aload 15
    //   1277: ifnull -1092 -> 185
    //   1280: aload 15
    //   1282: invokevirtual 1079	java/io/InputStream:close	()V
    //   1285: return
    //   1286: astore_1
    //   1287: return
    //   1288: aload 15
    //   1290: astore 16
    //   1292: aload 22
    //   1294: getstatic 298	no/nordicsemi/android/dfu/DfuBaseService:DFU_CONTROL_POINT_UUID	Ljava/util/UUID;
    //   1297: invokevirtual 1124	android/bluetooth/BluetoothGattService:getCharacteristic	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;
    //   1300: astore 20
    //   1302: aload 15
    //   1304: astore 16
    //   1306: aload 22
    //   1308: getstatic 302	no/nordicsemi/android/dfu/DfuBaseService:DFU_PACKET_UUID	Ljava/util/UUID;
    //   1311: invokevirtual 1124	android/bluetooth/BluetoothGattService:getCharacteristic	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;
    //   1314: astore 21
    //   1316: aload 20
    //   1318: ifnull +8 -> 1326
    //   1321: aload 21
    //   1323: ifnonnull +58 -> 1381
    //   1326: aload 15
    //   1328: astore 16
    //   1330: aload_0
    //   1331: ldc_w 1126
    //   1334: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   1337: aload 15
    //   1339: astore 16
    //   1341: aload_0
    //   1342: bipush 15
    //   1344: ldc_w 1128
    //   1347: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1350: aload 15
    //   1352: astore 16
    //   1354: aload_0
    //   1355: aload 19
    //   1357: sipush 4103
    //   1360: invokespecial 1108	no/nordicsemi/android/dfu/DfuBaseService:terminateConnection	(Landroid/bluetooth/BluetoothGatt;I)V
    //   1363: aload_0
    //   1364: aconst_null
    //   1365: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   1368: aload 15
    //   1370: ifnull -1185 -> 185
    //   1373: aload 15
    //   1375: invokevirtual 1079	java/io/InputStream:close	()V
    //   1378: return
    //   1379: astore_1
    //   1380: return
    //   1381: aload 15
    //   1383: astore 16
    //   1385: aload 22
    //   1387: getstatic 306	no/nordicsemi/android/dfu/DfuBaseService:DFU_VERSION	Ljava/util/UUID;
    //   1390: invokevirtual 1124	android/bluetooth/BluetoothGattService:getCharacteristic	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;
    //   1393: astore 22
    //   1395: aload 15
    //   1397: astore 16
    //   1399: aload_0
    //   1400: iconst_5
    //   1401: ldc_w 1130
    //   1404: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1407: aload 15
    //   1409: astore 16
    //   1411: aload_0
    //   1412: bipush -2
    //   1414: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   1417: iconst_0
    //   1418: istore 7
    //   1420: aload 22
    //   1422: ifnull +104 -> 1526
    //   1425: aload 15
    //   1427: astore 16
    //   1429: aload_0
    //   1430: aload 19
    //   1432: aload 22
    //   1434: invokespecial 1132	no/nordicsemi/android/dfu/DfuBaseService:readVersion	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;)I
    //   1437: istore 7
    //   1439: iload 7
    //   1441: bipush 15
    //   1443: iand
    //   1444: istore_3
    //   1445: iload 7
    //   1447: bipush 8
    //   1449: ishr
    //   1450: istore 5
    //   1452: aload 15
    //   1454: astore 16
    //   1456: aload_0
    //   1457: new 582	java/lang/StringBuilder
    //   1460: dup
    //   1461: ldc_w 1134
    //   1464: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1467: iload 5
    //   1469: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1472: ldc_w 1136
    //   1475: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: iload_3
    //   1479: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1482: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   1488: aload 15
    //   1490: astore 16
    //   1492: aload_0
    //   1493: bipush 10
    //   1495: new 582	java/lang/StringBuilder
    //   1498: dup
    //   1499: ldc_w 1134
    //   1502: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1505: iload 5
    //   1507: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1510: ldc_w 1136
    //   1513: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: iload_3
    //   1517: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1520: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1526: iload 7
    //   1528: iconst_1
    //   1529: if_icmpeq +26 -> 1555
    //   1532: iload 7
    //   1534: ifne +547 -> 2081
    //   1537: aload 15
    //   1539: astore 16
    //   1541: aload 19
    //   1543: invokevirtual 1140	android/bluetooth/BluetoothGatt:getServices	()Ljava/util/List;
    //   1546: invokeinterface 1145 1 0
    //   1551: iconst_3
    //   1552: if_icmple +529 -> 2081
    //   1555: aload 15
    //   1557: astore 16
    //   1559: aload_0
    //   1560: ldc_w 1147
    //   1563: invokespecial 1019	no/nordicsemi/android/dfu/DfuBaseService:logw	(Ljava/lang/String;)V
    //   1566: aload 15
    //   1568: astore 16
    //   1570: aload_0
    //   1571: bipush 15
    //   1573: ldc_w 1147
    //   1576: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1579: iconst_0
    //   1580: istore 4
    //   1582: iload 4
    //   1584: istore_3
    //   1585: aload 15
    //   1587: astore 16
    //   1589: aload 19
    //   1591: invokevirtual 805	android/bluetooth/BluetoothGatt:getDevice	()Landroid/bluetooth/BluetoothDevice;
    //   1594: invokevirtual 513	android/bluetooth/BluetoothDevice:getBondState	()I
    //   1597: bipush 12
    //   1599: if_icmpne +263 -> 1862
    //   1602: aload 15
    //   1604: astore 16
    //   1606: aload 19
    //   1608: getstatic 284	no/nordicsemi/android/dfu/DfuBaseService:GENERIC_ATTRIBUTE_SERVICE_UUID	Ljava/util/UUID;
    //   1611: invokevirtual 1114	android/bluetooth/BluetoothGatt:getService	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattService;
    //   1614: astore 17
    //   1616: iload 4
    //   1618: istore_3
    //   1619: aload 17
    //   1621: ifnull +241 -> 1862
    //   1624: aload 15
    //   1626: astore 16
    //   1628: aload 17
    //   1630: getstatic 288	no/nordicsemi/android/dfu/DfuBaseService:SERVICE_CHANGED_UUID	Ljava/util/UUID;
    //   1633: invokevirtual 1124	android/bluetooth/BluetoothGattService:getCharacteristic	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;
    //   1636: astore 17
    //   1638: iload 4
    //   1640: istore_3
    //   1641: aload 17
    //   1643: ifnull +219 -> 1862
    //   1646: aload 15
    //   1648: astore 16
    //   1650: aload_0
    //   1651: aload 19
    //   1653: aload 17
    //   1655: invokespecial 1149	no/nordicsemi/android/dfu/DfuBaseService:isServiceChangedCCCDEnabled	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;)Z
    //   1658: ifne +188 -> 1846
    //   1661: aload 15
    //   1663: astore 16
    //   1665: aload_0
    //   1666: aload 19
    //   1668: aload 17
    //   1670: iconst_2
    //   1671: invokespecial 1151	no/nordicsemi/android/dfu/DfuBaseService:enableCCCD	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V
    //   1674: aload 15
    //   1676: astore 16
    //   1678: aload_0
    //   1679: bipush 10
    //   1681: ldc_w 1153
    //   1684: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1687: aload 15
    //   1689: astore 16
    //   1691: aload_1
    //   1692: ldc 120
    //   1694: iconst_0
    //   1695: invokevirtual 1156	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1698: ifeq +3641 -> 5339
    //   1701: iload_2
    //   1702: iconst_1
    //   1703: iand
    //   1704: ifne +3635 -> 5339
    //   1707: aload 15
    //   1709: astore 16
    //   1711: aload_0
    //   1712: iconst_1
    //   1713: ldc_w 1158
    //   1716: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1719: aload 15
    //   1721: astore 16
    //   1723: aload_0
    //   1724: bipush -5
    //   1726: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   1729: aload 15
    //   1731: astore 16
    //   1733: aload_0
    //   1734: iconst_1
    //   1735: ldc_w 1160
    //   1738: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1741: aload 15
    //   1743: astore 16
    //   1745: aload 19
    //   1747: invokevirtual 567	android/bluetooth/BluetoothGatt:disconnect	()V
    //   1750: aload 15
    //   1752: astore 16
    //   1754: aload_0
    //   1755: invokespecial 570	no/nordicsemi/android/dfu/DfuBaseService:waitUntilDisconnected	()V
    //   1758: aload 15
    //   1760: astore 16
    //   1762: aload_0
    //   1763: iconst_5
    //   1764: ldc_w 881
    //   1767: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1770: aload 15
    //   1772: astore 16
    //   1774: aload_0
    //   1775: aload 19
    //   1777: invokespecial 885	no/nordicsemi/android/dfu/DfuBaseService:close	(Landroid/bluetooth/BluetoothGatt;)V
    //   1780: aload 15
    //   1782: astore 16
    //   1784: aload_0
    //   1785: ldc_w 1162
    //   1788: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   1791: aload 15
    //   1793: astore 16
    //   1795: new 830	android/content/Intent
    //   1798: dup
    //   1799: invokespecial 1163	android/content/Intent:<init>	()V
    //   1802: astore 17
    //   1804: aload 15
    //   1806: astore 16
    //   1808: aload 17
    //   1810: aload_1
    //   1811: bipush 24
    //   1813: invokevirtual 1167	android/content/Intent:fillIn	(Landroid/content/Intent;I)I
    //   1816: pop
    //   1817: aload 15
    //   1819: astore 16
    //   1821: aload_0
    //   1822: aload 17
    //   1824: invokevirtual 1171	no/nordicsemi/android/dfu/DfuBaseService:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   1827: pop
    //   1828: aload_0
    //   1829: aconst_null
    //   1830: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   1833: aload 15
    //   1835: ifnull -1650 -> 185
    //   1838: aload 15
    //   1840: invokevirtual 1079	java/io/InputStream:close	()V
    //   1843: return
    //   1844: astore_1
    //   1845: return
    //   1846: aload 15
    //   1848: astore 16
    //   1850: aload_0
    //   1851: bipush 10
    //   1853: ldc_w 1153
    //   1856: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1859: goto +3480 -> 5339
    //   1862: aload 15
    //   1864: astore 16
    //   1866: aload_0
    //   1867: iconst_1
    //   1868: ldc_w 1173
    //   1871: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1874: aload 15
    //   1876: astore 16
    //   1878: aload_0
    //   1879: aload 19
    //   1881: aload 20
    //   1883: iconst_1
    //   1884: invokespecial 1151	no/nordicsemi/android/dfu/DfuBaseService:enableCCCD	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V
    //   1887: aload 15
    //   1889: astore 16
    //   1891: aload_0
    //   1892: bipush 10
    //   1894: ldc_w 1175
    //   1897: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1900: aload 15
    //   1902: astore 16
    //   1904: aload_0
    //   1905: bipush -3
    //   1907: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   1910: aload 15
    //   1912: astore 16
    //   1914: getstatic 258	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_START_DFU	[B
    //   1917: iconst_1
    //   1918: iconst_4
    //   1919: bastore
    //   1920: aload 15
    //   1922: astore 16
    //   1924: aload_0
    //   1925: ldc_w 1177
    //   1928: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   1931: aload 15
    //   1933: astore 16
    //   1935: aload_0
    //   1936: aload 19
    //   1938: aload 20
    //   1940: getstatic 258	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_START_DFU	[B
    //   1943: iconst_1
    //   1944: invokespecial 950	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[BZ)V
    //   1947: aload 15
    //   1949: astore 16
    //   1951: aload_0
    //   1952: bipush 10
    //   1954: ldc_w 1179
    //   1957: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1960: aload 15
    //   1962: astore 16
    //   1964: aload_0
    //   1965: invokespecial 570	no/nordicsemi/android/dfu/DfuBaseService:waitUntilDisconnected	()V
    //   1968: aload 15
    //   1970: astore 16
    //   1972: aload_0
    //   1973: iconst_5
    //   1974: ldc_w 1181
    //   1977: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   1980: iload_3
    //   1981: ifeq +94 -> 2075
    //   1984: iconst_0
    //   1985: istore 9
    //   1987: aload 15
    //   1989: astore 16
    //   1991: aload_0
    //   1992: aload 19
    //   1994: iload 9
    //   1996: invokespecial 883	no/nordicsemi/android/dfu/DfuBaseService:refreshDeviceCache	(Landroid/bluetooth/BluetoothGatt;Z)V
    //   1999: aload 15
    //   2001: astore 16
    //   2003: aload_0
    //   2004: aload 19
    //   2006: invokespecial 885	no/nordicsemi/android/dfu/DfuBaseService:close	(Landroid/bluetooth/BluetoothGatt;)V
    //   2009: aload 15
    //   2011: astore 16
    //   2013: aload_0
    //   2014: ldc_w 1183
    //   2017: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   2020: aload 15
    //   2022: astore 16
    //   2024: new 830	android/content/Intent
    //   2027: dup
    //   2028: invokespecial 1163	android/content/Intent:<init>	()V
    //   2031: astore 17
    //   2033: aload 15
    //   2035: astore 16
    //   2037: aload 17
    //   2039: aload_1
    //   2040: bipush 24
    //   2042: invokevirtual 1167	android/content/Intent:fillIn	(Landroid/content/Intent;I)I
    //   2045: pop
    //   2046: aload 15
    //   2048: astore 16
    //   2050: aload_0
    //   2051: aload 17
    //   2053: invokevirtual 1171	no/nordicsemi/android/dfu/DfuBaseService:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   2056: pop
    //   2057: aload_0
    //   2058: aconst_null
    //   2059: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   2062: aload 15
    //   2064: ifnull -1879 -> 185
    //   2067: aload 15
    //   2069: invokevirtual 1079	java/io/InputStream:close	()V
    //   2072: return
    //   2073: astore_1
    //   2074: return
    //   2075: iconst_1
    //   2076: istore 9
    //   2078: goto -91 -> 1987
    //   2081: aload 15
    //   2083: astore 16
    //   2085: aload_0
    //   2086: aload 19
    //   2088: aload 20
    //   2090: iconst_1
    //   2091: invokespecial 1151	no/nordicsemi/android/dfu/DfuBaseService:enableCCCD	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V
    //   2094: aload 15
    //   2096: astore 16
    //   2098: aload_0
    //   2099: bipush 10
    //   2101: ldc_w 1175
    //   2104: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2107: iload_2
    //   2108: iconst_1
    //   2109: iand
    //   2110: ifle +545 -> 2655
    //   2113: iload 4
    //   2115: istore_3
    //   2116: iload_2
    //   2117: iconst_2
    //   2118: iand
    //   2119: ifle +541 -> 2660
    //   2122: iload 4
    //   2124: istore 5
    //   2126: iload_2
    //   2127: iconst_4
    //   2128: iand
    //   2129: ifle +537 -> 2666
    //   2132: iload 4
    //   2134: istore 6
    //   2136: iload_3
    //   2137: istore 8
    //   2139: aload 15
    //   2141: astore 16
    //   2143: ldc -95
    //   2145: aload 17
    //   2147: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2150: ifeq +47 -> 2197
    //   2153: aload 15
    //   2155: astore 16
    //   2157: aload 15
    //   2159: checkcast 725	no/nordicsemi/android/dfu/ArchiveInputStream
    //   2162: astore 17
    //   2164: aload 15
    //   2166: astore 16
    //   2168: aload 17
    //   2170: invokevirtual 1186	no/nordicsemi/android/dfu/ArchiveInputStream:softDeviceImageSize	()I
    //   2173: istore 8
    //   2175: aload 15
    //   2177: astore 16
    //   2179: aload 17
    //   2181: invokevirtual 1189	no/nordicsemi/android/dfu/ArchiveInputStream:bootloaderImageSize	()I
    //   2184: istore 5
    //   2186: aload 15
    //   2188: astore 16
    //   2190: aload 17
    //   2192: invokevirtual 1192	no/nordicsemi/android/dfu/ArchiveInputStream:applicationImageSize	()I
    //   2195: istore 6
    //   2197: aload 15
    //   2199: astore 16
    //   2201: getstatic 258	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_START_DFU	[B
    //   2204: iconst_1
    //   2205: iload_2
    //   2206: i2b
    //   2207: bastore
    //   2208: aload 15
    //   2210: astore 16
    //   2212: aload_0
    //   2213: new 582	java/lang/StringBuilder
    //   2216: dup
    //   2217: ldc_w 1194
    //   2220: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2223: iload_2
    //   2224: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2227: ldc_w 924
    //   2230: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2236: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   2239: aload 15
    //   2241: astore 16
    //   2243: aload_0
    //   2244: aload 19
    //   2246: aload 20
    //   2248: getstatic 258	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_START_DFU	[B
    //   2251: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   2254: aload 15
    //   2256: astore 16
    //   2258: aload_0
    //   2259: bipush 10
    //   2261: new 582	java/lang/StringBuilder
    //   2264: dup
    //   2265: ldc_w 1198
    //   2268: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2271: iload_2
    //   2272: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2275: ldc_w 924
    //   2278: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2281: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2284: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2287: aload 15
    //   2289: astore 16
    //   2291: aload_0
    //   2292: new 582	java/lang/StringBuilder
    //   2295: dup
    //   2296: ldc_w 1200
    //   2299: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2302: iload 8
    //   2304: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2307: ldc_w 1202
    //   2310: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2313: iload 5
    //   2315: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2318: ldc_w 1202
    //   2321: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2324: iload 6
    //   2326: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2329: ldc_w 1204
    //   2332: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2335: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2338: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   2341: aload 15
    //   2343: astore 16
    //   2345: aload_0
    //   2346: aload 19
    //   2348: aload 21
    //   2350: iload 8
    //   2352: iload 5
    //   2354: iload 6
    //   2356: invokespecial 1206	no/nordicsemi/android/dfu/DfuBaseService:writeImageSize	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;III)V
    //   2359: aload 15
    //   2361: astore 16
    //   2363: aload_0
    //   2364: bipush 10
    //   2366: new 582	java/lang/StringBuilder
    //   2369: dup
    //   2370: ldc_w 1208
    //   2373: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2376: iload 8
    //   2378: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2381: ldc_w 1202
    //   2384: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2387: iload 5
    //   2389: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2392: ldc_w 1202
    //   2395: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: iload 6
    //   2400: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2403: ldc_w 1204
    //   2406: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2409: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2412: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2415: aload 15
    //   2417: astore 16
    //   2419: aload_0
    //   2420: invokespecial 1210	no/nordicsemi/android/dfu/DfuBaseService:readNotificationResponse	()[B
    //   2423: astore 17
    //   2425: aload 15
    //   2427: astore 16
    //   2429: aload_0
    //   2430: aload 17
    //   2432: iconst_1
    //   2433: invokespecial 1212	no/nordicsemi/android/dfu/DfuBaseService:getStatusCode	([BI)I
    //   2436: istore 6
    //   2438: aload 15
    //   2440: astore 16
    //   2442: aload_0
    //   2443: bipush 10
    //   2445: new 582	java/lang/StringBuilder
    //   2448: dup
    //   2449: ldc_w 1214
    //   2452: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2455: aload 17
    //   2457: iconst_1
    //   2458: baload
    //   2459: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2462: ldc_w 1216
    //   2465: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: iload 6
    //   2470: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2473: ldc_w 924
    //   2476: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2479: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2482: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2485: iload_2
    //   2486: istore_3
    //   2487: iload 6
    //   2489: iconst_1
    //   2490: if_icmpeq +1334 -> 3824
    //   2493: aload 15
    //   2495: astore 16
    //   2497: new 993	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2500: dup
    //   2501: ldc_w 1218
    //   2504: iload 6
    //   2506: invokespecial 1219	no/nordicsemi/android/dfu/exception/RemoteDfuException:<init>	(Ljava/lang/String;I)V
    //   2509: athrow
    //   2510: astore 17
    //   2512: iload_2
    //   2513: istore_3
    //   2514: aload 15
    //   2516: astore 16
    //   2518: aload 17
    //   2520: invokevirtual 1222	no/nordicsemi/android/dfu/exception/RemoteDfuException:getErrorNumber	()I
    //   2523: iconst_3
    //   2524: if_icmpeq +148 -> 2672
    //   2527: iload_2
    //   2528: istore_3
    //   2529: aload 15
    //   2531: astore 16
    //   2533: aload 17
    //   2535: athrow
    //   2536: astore 17
    //   2538: aload 15
    //   2540: astore 16
    //   2542: aload 17
    //   2544: invokevirtual 1222	no/nordicsemi/android/dfu/exception/RemoteDfuException:getErrorNumber	()I
    //   2547: iconst_3
    //   2548: if_icmpeq +763 -> 3311
    //   2551: aload 15
    //   2553: astore 16
    //   2555: aload 17
    //   2557: athrow
    //   2558: astore_1
    //   2559: aload 15
    //   2561: astore 16
    //   2563: aload_0
    //   2564: aload_1
    //   2565: invokevirtual 1225	no/nordicsemi/android/dfu/exception/UnknownResponseException:getMessage	()Ljava/lang/String;
    //   2568: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   2571: aload 15
    //   2573: astore 16
    //   2575: aload_0
    //   2576: bipush 20
    //   2578: aload_1
    //   2579: invokevirtual 1225	no/nordicsemi/android/dfu/exception/UnknownResponseException:getMessage	()Ljava/lang/String;
    //   2582: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2585: aload 15
    //   2587: astore 16
    //   2589: aload_0
    //   2590: ldc_w 1227
    //   2593: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   2596: aload 15
    //   2598: astore 16
    //   2600: aload_0
    //   2601: aload 19
    //   2603: aload 20
    //   2605: getstatic 270	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_RESET	[B
    //   2608: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   2611: aload 15
    //   2613: astore 16
    //   2615: aload_0
    //   2616: bipush 10
    //   2618: ldc_w 1229
    //   2621: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2624: aload 15
    //   2626: astore 16
    //   2628: aload_0
    //   2629: aload 19
    //   2631: sipush 4104
    //   2634: invokespecial 1108	no/nordicsemi/android/dfu/DfuBaseService:terminateConnection	(Landroid/bluetooth/BluetoothGatt;I)V
    //   2637: aload_0
    //   2638: aconst_null
    //   2639: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   2642: aload 15
    //   2644: ifnull -2459 -> 185
    //   2647: aload 15
    //   2649: invokevirtual 1079	java/io/InputStream:close	()V
    //   2652: return
    //   2653: astore_1
    //   2654: return
    //   2655: iconst_0
    //   2656: istore_3
    //   2657: goto -541 -> 2116
    //   2660: iconst_0
    //   2661: istore 5
    //   2663: goto -537 -> 2126
    //   2666: iconst_0
    //   2667: istore 6
    //   2669: goto -533 -> 2136
    //   2672: iload_2
    //   2673: iconst_4
    //   2674: iand
    //   2675: ifle +577 -> 3252
    //   2678: iload_2
    //   2679: iconst_3
    //   2680: iand
    //   2681: ifle +571 -> 3252
    //   2684: iload_2
    //   2685: istore_3
    //   2686: aload 15
    //   2688: astore 16
    //   2690: aload_0
    //   2691: iconst_0
    //   2692: putfield 409	no/nordicsemi/android/dfu/DfuBaseService:mRemoteErrorOccurred	Z
    //   2695: iload_2
    //   2696: istore_3
    //   2697: aload 15
    //   2699: astore 16
    //   2701: aload_0
    //   2702: ldc_w 1231
    //   2705: invokespecial 1019	no/nordicsemi/android/dfu/DfuBaseService:logw	(Ljava/lang/String;)V
    //   2708: iload_2
    //   2709: istore_3
    //   2710: aload 15
    //   2712: astore 16
    //   2714: aload_0
    //   2715: bipush 15
    //   2717: ldc_w 1231
    //   2720: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2723: iload_2
    //   2724: bipush -5
    //   2726: iand
    //   2727: istore_2
    //   2728: iload_2
    //   2729: istore_3
    //   2730: aload 15
    //   2732: astore 16
    //   2734: aload_0
    //   2735: iload_2
    //   2736: putfield 1060	no/nordicsemi/android/dfu/DfuBaseService:mFileType	I
    //   2739: iload_2
    //   2740: istore_3
    //   2741: aload 15
    //   2743: astore 16
    //   2745: getstatic 258	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_START_DFU	[B
    //   2748: iconst_1
    //   2749: iload_2
    //   2750: i2b
    //   2751: bastore
    //   2752: iload_2
    //   2753: istore_3
    //   2754: aload 15
    //   2756: astore 16
    //   2758: aload_0
    //   2759: iconst_2
    //   2760: putfield 868	no/nordicsemi/android/dfu/DfuBaseService:mPartsTotal	I
    //   2763: iload_2
    //   2764: istore_3
    //   2765: aload 15
    //   2767: astore 16
    //   2769: aload 15
    //   2771: checkcast 725	no/nordicsemi/android/dfu/ArchiveInputStream
    //   2774: iload_2
    //   2775: invokevirtual 1235	no/nordicsemi/android/dfu/ArchiveInputStream:setContentType	(I)I
    //   2778: pop
    //   2779: iload_2
    //   2780: istore_3
    //   2781: aload 15
    //   2783: astore 16
    //   2785: aload_0
    //   2786: aload 15
    //   2788: invokevirtual 1055	java/io/InputStream:available	()I
    //   2791: putfield 396	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeInBytes	I
    //   2794: iload_2
    //   2795: istore_3
    //   2796: aload 15
    //   2798: astore 16
    //   2800: aload_0
    //   2801: iconst_1
    //   2802: ldc_w 1237
    //   2805: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2808: iload_2
    //   2809: istore_3
    //   2810: aload 15
    //   2812: astore 16
    //   2814: aload_0
    //   2815: new 582	java/lang/StringBuilder
    //   2818: dup
    //   2819: ldc_w 1239
    //   2822: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2825: iload_2
    //   2826: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2829: ldc_w 924
    //   2832: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2835: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2838: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   2841: iload_2
    //   2842: istore_3
    //   2843: aload 15
    //   2845: astore 16
    //   2847: aload_0
    //   2848: aload 19
    //   2850: aload 20
    //   2852: getstatic 258	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_START_DFU	[B
    //   2855: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   2858: iload_2
    //   2859: istore_3
    //   2860: aload 15
    //   2862: astore 16
    //   2864: aload_0
    //   2865: bipush 10
    //   2867: new 582	java/lang/StringBuilder
    //   2870: dup
    //   2871: ldc_w 1198
    //   2874: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2877: iload_2
    //   2878: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2881: ldc_w 924
    //   2884: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2887: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2890: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   2893: iload_2
    //   2894: istore_3
    //   2895: aload 15
    //   2897: astore 16
    //   2899: aload_0
    //   2900: new 582	java/lang/StringBuilder
    //   2903: dup
    //   2904: ldc_w 1241
    //   2907: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2910: iload 8
    //   2912: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2915: ldc_w 1202
    //   2918: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2921: iload 5
    //   2923: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2926: ldc_w 1202
    //   2929: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2932: iconst_0
    //   2933: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2936: ldc_w 1243
    //   2939: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2945: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   2948: iload_2
    //   2949: istore_3
    //   2950: aload 15
    //   2952: astore 16
    //   2954: aload_0
    //   2955: aload 19
    //   2957: aload 21
    //   2959: iload 8
    //   2961: iload 5
    //   2963: iconst_0
    //   2964: invokespecial 1206	no/nordicsemi/android/dfu/DfuBaseService:writeImageSize	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;III)V
    //   2967: iload_2
    //   2968: istore_3
    //   2969: aload 15
    //   2971: astore 16
    //   2973: aload_0
    //   2974: bipush 10
    //   2976: new 582	java/lang/StringBuilder
    //   2979: dup
    //   2980: ldc_w 1245
    //   2983: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2986: iload 8
    //   2988: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2991: ldc_w 1202
    //   2994: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2997: iload 5
    //   2999: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3002: ldc_w 1202
    //   3005: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3008: iconst_0
    //   3009: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3012: ldc_w 1243
    //   3015: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3018: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3021: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3024: iload_2
    //   3025: istore_3
    //   3026: aload 15
    //   3028: astore 16
    //   3030: aload_0
    //   3031: invokespecial 1210	no/nordicsemi/android/dfu/DfuBaseService:readNotificationResponse	()[B
    //   3034: astore 17
    //   3036: iload_2
    //   3037: istore_3
    //   3038: aload 15
    //   3040: astore 16
    //   3042: aload_0
    //   3043: aload 17
    //   3045: iconst_1
    //   3046: invokespecial 1212	no/nordicsemi/android/dfu/DfuBaseService:getStatusCode	([BI)I
    //   3049: istore 5
    //   3051: iload_2
    //   3052: istore_3
    //   3053: aload 15
    //   3055: astore 16
    //   3057: aload_0
    //   3058: bipush 10
    //   3060: new 582	java/lang/StringBuilder
    //   3063: dup
    //   3064: ldc_w 1214
    //   3067: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3070: aload 17
    //   3072: iconst_1
    //   3073: baload
    //   3074: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3077: ldc_w 1216
    //   3080: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3083: iload 5
    //   3085: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3088: ldc_w 924
    //   3091: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3094: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3097: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3100: iload_2
    //   3101: istore_3
    //   3102: iload 5
    //   3104: iconst_1
    //   3105: if_icmpeq +719 -> 3824
    //   3108: iload_2
    //   3109: istore_3
    //   3110: aload 15
    //   3112: astore 16
    //   3114: new 993	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3117: dup
    //   3118: ldc_w 1218
    //   3121: iload 5
    //   3123: invokespecial 1219	no/nordicsemi/android/dfu/exception/RemoteDfuException:<init>	(Ljava/lang/String;I)V
    //   3126: athrow
    //   3127: astore_1
    //   3128: aload 15
    //   3130: astore 16
    //   3132: aload_0
    //   3133: ldc_w 1110
    //   3136: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   3139: aload 15
    //   3141: astore 16
    //   3143: aload_0
    //   3144: bipush 15
    //   3146: ldc_w 1110
    //   3149: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3152: aload 15
    //   3154: astore 16
    //   3156: aload_0
    //   3157: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   3160: istore_2
    //   3161: iload_2
    //   3162: bipush -3
    //   3164: if_icmpne +51 -> 3215
    //   3167: aload 15
    //   3169: astore 16
    //   3171: aload_0
    //   3172: iconst_0
    //   3173: putfield 403	no/nordicsemi/android/dfu/DfuBaseService:mAborted	Z
    //   3176: aload 15
    //   3178: astore 16
    //   3180: aload_0
    //   3181: ldc_w 1227
    //   3184: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   3187: aload 15
    //   3189: astore 16
    //   3191: aload_0
    //   3192: aload 19
    //   3194: aload 20
    //   3196: getstatic 270	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_RESET	[B
    //   3199: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   3202: aload 15
    //   3204: astore 16
    //   3206: aload_0
    //   3207: bipush 10
    //   3209: ldc_w 1229
    //   3212: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3215: aload 15
    //   3217: astore 16
    //   3219: aload_0
    //   3220: aload 19
    //   3222: bipush -7
    //   3224: invokespecial 1108	no/nordicsemi/android/dfu/DfuBaseService:terminateConnection	(Landroid/bluetooth/BluetoothGatt;I)V
    //   3227: goto -590 -> 2637
    //   3230: astore_1
    //   3231: aload 16
    //   3233: astore 15
    //   3235: aload_0
    //   3236: aconst_null
    //   3237: putfield 422	no/nordicsemi/android/dfu/DfuBaseService:mInputStream	Ljava/io/InputStream;
    //   3240: aload 15
    //   3242: ifnull +8 -> 3250
    //   3245: aload 15
    //   3247: invokevirtual 1079	java/io/InputStream:close	()V
    //   3250: aload_1
    //   3251: athrow
    //   3252: iload_2
    //   3253: istore_3
    //   3254: aload 15
    //   3256: astore 16
    //   3258: aload 17
    //   3260: athrow
    //   3261: astore_1
    //   3262: aload 15
    //   3264: astore 16
    //   3266: aload_0
    //   3267: bipush 20
    //   3269: ldc_w 1247
    //   3272: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3275: aload 15
    //   3277: astore 16
    //   3279: aload_0
    //   3280: aload_1
    //   3281: invokevirtual 1248	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException:getMessage	()Ljava/lang/String;
    //   3284: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   3287: aload 15
    //   3289: astore 16
    //   3291: aload_0
    //   3292: aload 19
    //   3294: invokespecial 885	no/nordicsemi/android/dfu/DfuBaseService:close	(Landroid/bluetooth/BluetoothGatt;)V
    //   3297: aload 15
    //   3299: astore 16
    //   3301: aload_0
    //   3302: sipush 4096
    //   3305: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   3308: goto -671 -> 2637
    //   3311: iload_3
    //   3312: iconst_4
    //   3313: if_icmpne +504 -> 3817
    //   3316: aload 15
    //   3318: astore 16
    //   3320: aload_0
    //   3321: iconst_0
    //   3322: putfield 409	no/nordicsemi/android/dfu/DfuBaseService:mRemoteErrorOccurred	Z
    //   3325: aload 15
    //   3327: astore 16
    //   3329: aload_0
    //   3330: ldc_w 1250
    //   3333: invokespecial 1019	no/nordicsemi/android/dfu/DfuBaseService:logw	(Ljava/lang/String;)V
    //   3336: aload 15
    //   3338: astore 16
    //   3340: aload_0
    //   3341: bipush 15
    //   3343: ldc_w 1250
    //   3346: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3349: aload 15
    //   3351: astore 16
    //   3353: aload_0
    //   3354: iconst_1
    //   3355: ldc_w 1252
    //   3358: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3361: aload 15
    //   3363: astore 16
    //   3365: aload_0
    //   3366: ldc_w 1254
    //   3369: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   3372: aload 15
    //   3374: astore 16
    //   3376: aload_0
    //   3377: aload 19
    //   3379: aload 20
    //   3381: getstatic 258	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_START_DFU	[B
    //   3384: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   3387: aload 15
    //   3389: astore 16
    //   3391: aload_0
    //   3392: bipush 10
    //   3394: ldc_w 1256
    //   3397: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3400: aload 15
    //   3402: astore 16
    //   3404: aload_0
    //   3405: new 582	java/lang/StringBuilder
    //   3408: dup
    //   3409: ldc_w 1258
    //   3412: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3415: iload 4
    //   3417: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3420: ldc_w 1260
    //   3423: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3426: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3429: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   3432: aload 15
    //   3434: astore 16
    //   3436: aload_0
    //   3437: aload 19
    //   3439: aload 21
    //   3441: aload_0
    //   3442: getfield 396	no/nordicsemi/android/dfu/DfuBaseService:mImageSizeInBytes	I
    //   3445: invokespecial 1262	no/nordicsemi/android/dfu/DfuBaseService:writeImageSize	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V
    //   3448: aload 15
    //   3450: astore 16
    //   3452: aload_0
    //   3453: bipush 10
    //   3455: new 582	java/lang/StringBuilder
    //   3458: dup
    //   3459: ldc_w 1208
    //   3462: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3465: iload 4
    //   3467: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3470: ldc_w 1264
    //   3473: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3476: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3479: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3482: aload 15
    //   3484: astore 16
    //   3486: aload_0
    //   3487: invokespecial 1210	no/nordicsemi/android/dfu/DfuBaseService:readNotificationResponse	()[B
    //   3490: astore 17
    //   3492: aload 15
    //   3494: astore 16
    //   3496: aload_0
    //   3497: aload 17
    //   3499: iconst_1
    //   3500: invokespecial 1212	no/nordicsemi/android/dfu/DfuBaseService:getStatusCode	([BI)I
    //   3503: istore_2
    //   3504: aload 15
    //   3506: astore 16
    //   3508: aload_0
    //   3509: bipush 10
    //   3511: new 582	java/lang/StringBuilder
    //   3514: dup
    //   3515: ldc_w 1214
    //   3518: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3521: aload 17
    //   3523: iconst_1
    //   3524: baload
    //   3525: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3528: ldc_w 1266
    //   3531: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3534: iload_2
    //   3535: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3538: ldc_w 924
    //   3541: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3544: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3547: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3550: iload_2
    //   3551: iconst_1
    //   3552: if_icmpeq +272 -> 3824
    //   3555: aload 15
    //   3557: astore 16
    //   3559: new 993	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3562: dup
    //   3563: ldc_w 1218
    //   3566: iload_2
    //   3567: invokespecial 1219	no/nordicsemi/android/dfu/exception/RemoteDfuException:<init>	(Ljava/lang/String;I)V
    //   3570: athrow
    //   3571: astore_1
    //   3572: aload 15
    //   3574: astore 16
    //   3576: aload_1
    //   3577: invokevirtual 1222	no/nordicsemi/android/dfu/exception/RemoteDfuException:getErrorNumber	()I
    //   3580: sipush 8192
    //   3583: ior
    //   3584: istore_2
    //   3585: aload 15
    //   3587: astore 16
    //   3589: aload_0
    //   3590: aload_1
    //   3591: invokevirtual 1267	no/nordicsemi/android/dfu/exception/RemoteDfuException:getMessage	()Ljava/lang/String;
    //   3594: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   3597: aload 15
    //   3599: astore 16
    //   3601: aload_0
    //   3602: bipush 20
    //   3604: ldc_w 1269
    //   3607: iconst_1
    //   3608: anewarray 328	java/lang/Object
    //   3611: dup
    //   3612: iconst_0
    //   3613: iload_2
    //   3614: invokestatic 1271	no/nordicsemi/android/error/GattError:parse	(I)Ljava/lang/String;
    //   3617: aastore
    //   3618: invokestatic 1106	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3621: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3624: aload 15
    //   3626: astore 16
    //   3628: aload_0
    //   3629: ldc_w 1227
    //   3632: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   3635: aload 15
    //   3637: astore 16
    //   3639: aload_0
    //   3640: aload 19
    //   3642: aload 20
    //   3644: getstatic 270	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_RESET	[B
    //   3647: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   3650: aload 15
    //   3652: astore 16
    //   3654: aload_0
    //   3655: bipush 10
    //   3657: ldc_w 1229
    //   3660: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3663: aload 15
    //   3665: astore 16
    //   3667: aload_0
    //   3668: aload 19
    //   3670: iload_2
    //   3671: invokespecial 1108	no/nordicsemi/android/dfu/DfuBaseService:terminateConnection	(Landroid/bluetooth/BluetoothGatt;I)V
    //   3674: goto -1037 -> 2637
    //   3677: astore_1
    //   3678: aload 15
    //   3680: astore 16
    //   3682: aload_1
    //   3683: invokevirtual 1272	no/nordicsemi/android/dfu/exception/DfuException:getErrorNumber	()I
    //   3686: istore_2
    //   3687: ldc 56
    //   3689: iload_2
    //   3690: iand
    //   3691: ifle +1547 -> 5238
    //   3694: iload_2
    //   3695: ldc_w 849
    //   3698: iand
    //   3699: istore_2
    //   3700: aload 15
    //   3702: astore 16
    //   3704: aload_0
    //   3705: bipush 20
    //   3707: ldc_w 1274
    //   3710: iconst_2
    //   3711: anewarray 328	java/lang/Object
    //   3714: dup
    //   3715: iconst_0
    //   3716: iload_2
    //   3717: invokestatic 1097	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3720: aastore
    //   3721: dup
    //   3722: iconst_1
    //   3723: iload_2
    //   3724: invokestatic 1102	no/nordicsemi/android/error/GattError:parseConnectionError	(I)Ljava/lang/String;
    //   3727: aastore
    //   3728: invokestatic 1106	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3731: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3734: aload 15
    //   3736: astore 16
    //   3738: aload_0
    //   3739: aload_1
    //   3740: invokevirtual 1275	no/nordicsemi/android/dfu/exception/DfuException:getMessage	()Ljava/lang/String;
    //   3743: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   3746: aload 15
    //   3748: astore 16
    //   3750: aload_0
    //   3751: getfield 391	no/nordicsemi/android/dfu/DfuBaseService:mConnectionState	I
    //   3754: istore_2
    //   3755: iload_2
    //   3756: bipush -3
    //   3758: if_icmpne +42 -> 3800
    //   3761: aload 15
    //   3763: astore 16
    //   3765: aload_0
    //   3766: ldc_w 1227
    //   3769: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   3772: aload 15
    //   3774: astore 16
    //   3776: aload_0
    //   3777: aload 19
    //   3779: aload 20
    //   3781: getstatic 270	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_RESET	[B
    //   3784: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   3787: aload 15
    //   3789: astore 16
    //   3791: aload_0
    //   3792: bipush 10
    //   3794: ldc_w 1229
    //   3797: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3800: aload 15
    //   3802: astore 16
    //   3804: aload_0
    //   3805: aload 19
    //   3807: aload_1
    //   3808: invokevirtual 1272	no/nordicsemi/android/dfu/exception/DfuException:getErrorNumber	()I
    //   3811: invokespecial 1108	no/nordicsemi/android/dfu/DfuBaseService:terminateConnection	(Landroid/bluetooth/BluetoothGatt;I)V
    //   3814: goto -1177 -> 2637
    //   3817: aload 15
    //   3819: astore 16
    //   3821: aload 17
    //   3823: athrow
    //   3824: aload 18
    //   3826: ifnull +249 -> 4075
    //   3829: aload 15
    //   3831: astore 16
    //   3833: aload_0
    //   3834: bipush 10
    //   3836: ldc_w 1277
    //   3839: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3842: aload 15
    //   3844: astore 16
    //   3846: aload_0
    //   3847: ldc_w 1279
    //   3850: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   3853: aload 15
    //   3855: astore 16
    //   3857: aload_0
    //   3858: aload 19
    //   3860: aload 20
    //   3862: getstatic 260	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_INIT_DFU_PARAMS_START	[B
    //   3865: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   3868: aload 15
    //   3870: astore 16
    //   3872: bipush 20
    //   3874: newarray <illegal type>
    //   3876: astore 17
    //   3878: aload 15
    //   3880: astore 16
    //   3882: aload 18
    //   3884: aload 17
    //   3886: iconst_0
    //   3887: aload 17
    //   3889: arraylength
    //   3890: invokevirtual 1282	java/io/InputStream:read	([BII)I
    //   3893: istore_2
    //   3894: iload_2
    //   3895: iconst_m1
    //   3896: if_icmpne +131 -> 4027
    //   3899: aload 15
    //   3901: astore 16
    //   3903: aload_0
    //   3904: ldc_w 1284
    //   3907: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   3910: aload 15
    //   3912: astore 16
    //   3914: aload_0
    //   3915: aload 19
    //   3917: aload 20
    //   3919: getstatic 262	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_INIT_DFU_PARAMS_COMPLETE	[B
    //   3922: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   3925: aload 15
    //   3927: astore 16
    //   3929: aload_0
    //   3930: bipush 10
    //   3932: ldc_w 1286
    //   3935: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   3938: aload 15
    //   3940: astore 16
    //   3942: aload_0
    //   3943: invokespecial 1210	no/nordicsemi/android/dfu/DfuBaseService:readNotificationResponse	()[B
    //   3946: astore 17
    //   3948: aload 15
    //   3950: astore 16
    //   3952: aload_0
    //   3953: aload 17
    //   3955: iconst_2
    //   3956: invokespecial 1212	no/nordicsemi/android/dfu/DfuBaseService:getStatusCode	([BI)I
    //   3959: istore_2
    //   3960: aload 15
    //   3962: astore 16
    //   3964: aload_0
    //   3965: bipush 10
    //   3967: new 582	java/lang/StringBuilder
    //   3970: dup
    //   3971: ldc_w 1214
    //   3974: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3977: aload 17
    //   3979: iconst_1
    //   3980: baload
    //   3981: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3984: ldc_w 1266
    //   3987: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3990: iload_2
    //   3991: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3994: ldc_w 924
    //   3997: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4000: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4003: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4006: iload_2
    //   4007: iconst_1
    //   4008: if_icmpeq +76 -> 4084
    //   4011: aload 15
    //   4013: astore 16
    //   4015: new 993	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4018: dup
    //   4019: ldc_w 1288
    //   4022: iload_2
    //   4023: invokespecial 1219	no/nordicsemi/android/dfu/exception/RemoteDfuException:<init>	(Ljava/lang/String;I)V
    //   4026: athrow
    //   4027: aload 15
    //   4029: astore 16
    //   4031: aload_0
    //   4032: aload 19
    //   4034: aload 21
    //   4036: aload 17
    //   4038: iload_2
    //   4039: invokespecial 1290	no/nordicsemi/android/dfu/DfuBaseService:writeInitPacket	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[BI)V
    //   4042: goto -164 -> 3878
    //   4045: astore_1
    //   4046: aload 15
    //   4048: astore 16
    //   4050: aload_0
    //   4051: ldc_w 1292
    //   4054: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   4057: aload 15
    //   4059: astore 16
    //   4061: new 576	no/nordicsemi/android/dfu/exception/DfuException
    //   4064: dup
    //   4065: ldc_w 1292
    //   4068: sipush 4098
    //   4071: invokespecial 647	no/nordicsemi/android/dfu/exception/DfuException:<init>	(Ljava/lang/String;I)V
    //   4074: athrow
    //   4075: aload 15
    //   4077: astore 16
    //   4079: aload_0
    //   4080: iconst_1
    //   4081: putfield 379	no/nordicsemi/android/dfu/DfuBaseService:mInitPacketSent	Z
    //   4084: aload 15
    //   4086: astore 16
    //   4088: aload_0
    //   4089: getfield 334	no/nordicsemi/android/dfu/DfuBaseService:mPacketsBeforeNotification	I
    //   4092: istore_2
    //   4093: iload_2
    //   4094: ifle +94 -> 4188
    //   4097: aload 15
    //   4099: astore 16
    //   4101: aload_0
    //   4102: new 582	java/lang/StringBuilder
    //   4105: dup
    //   4106: ldc_w 1294
    //   4109: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4112: iload_2
    //   4113: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4116: ldc_w 924
    //   4119: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4122: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4125: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   4128: aload 15
    //   4130: astore 16
    //   4132: aload_0
    //   4133: getstatic 272	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_PACKET_RECEIPT_NOTIF_REQ	[B
    //   4136: iload_2
    //   4137: invokespecial 1296	no/nordicsemi/android/dfu/DfuBaseService:setNumberOfPackets	([BI)V
    //   4140: aload 15
    //   4142: astore 16
    //   4144: aload_0
    //   4145: aload 19
    //   4147: aload 20
    //   4149: getstatic 272	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_PACKET_RECEIPT_NOTIF_REQ	[B
    //   4152: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   4155: aload 15
    //   4157: astore 16
    //   4159: aload_0
    //   4160: bipush 10
    //   4162: new 582	java/lang/StringBuilder
    //   4165: dup
    //   4166: ldc_w 1298
    //   4169: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4172: iload_2
    //   4173: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4176: ldc_w 924
    //   4179: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4182: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4185: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4188: aload 15
    //   4190: astore 16
    //   4192: aload_0
    //   4193: ldc_w 1300
    //   4196: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   4199: aload 15
    //   4201: astore 16
    //   4203: aload_0
    //   4204: aload 19
    //   4206: aload 20
    //   4208: getstatic 264	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_RECEIVE_FIRMWARE_IMAGE	[B
    //   4211: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   4214: aload 15
    //   4216: astore 16
    //   4218: aload_0
    //   4219: bipush 10
    //   4221: ldc_w 1302
    //   4224: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4227: aload 15
    //   4229: astore 16
    //   4231: invokestatic 858	android/os/SystemClock:elapsedRealtime	()J
    //   4234: lstore 11
    //   4236: aload 15
    //   4238: astore 16
    //   4240: aload_0
    //   4241: lload 11
    //   4243: putfield 864	no/nordicsemi/android/dfu/DfuBaseService:mStartTime	J
    //   4246: aload 15
    //   4248: astore 16
    //   4250: aload_0
    //   4251: lload 11
    //   4253: putfield 860	no/nordicsemi/android/dfu/DfuBaseService:mLastProgressTime	J
    //   4256: aload 15
    //   4258: astore 16
    //   4260: aload_0
    //   4261: invokespecial 434	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	()V
    //   4264: aload 15
    //   4266: astore 16
    //   4268: aload_0
    //   4269: ldc_w 1304
    //   4272: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   4275: aload 15
    //   4277: astore 16
    //   4279: aload_0
    //   4280: bipush 10
    //   4282: ldc_w 1304
    //   4285: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4288: aload 15
    //   4290: astore 16
    //   4292: aload_0
    //   4293: aload 19
    //   4295: aload 21
    //   4297: aload 15
    //   4299: invokespecial 1306	no/nordicsemi/android/dfu/DfuBaseService:uploadFirmwareImage	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;Ljava/io/InputStream;)[B
    //   4302: astore 17
    //   4304: aload 15
    //   4306: astore 16
    //   4308: invokestatic 858	android/os/SystemClock:elapsedRealtime	()J
    //   4311: lstore 13
    //   4313: aload 15
    //   4315: astore 16
    //   4317: aload_0
    //   4318: aload 17
    //   4320: iconst_3
    //   4321: invokespecial 1212	no/nordicsemi/android/dfu/DfuBaseService:getStatusCode	([BI)I
    //   4324: istore_2
    //   4325: aload 15
    //   4327: astore 16
    //   4329: aload_0
    //   4330: new 582	java/lang/StringBuilder
    //   4333: dup
    //   4334: ldc_w 1308
    //   4337: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4340: aload 17
    //   4342: iconst_0
    //   4343: baload
    //   4344: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4347: ldc_w 1310
    //   4350: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4353: aload 17
    //   4355: iconst_1
    //   4356: baload
    //   4357: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4360: ldc_w 1266
    //   4363: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4366: aload 17
    //   4368: iconst_2
    //   4369: baload
    //   4370: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4373: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4376: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   4379: aload 15
    //   4381: astore 16
    //   4383: aload_0
    //   4384: bipush 10
    //   4386: new 582	java/lang/StringBuilder
    //   4389: dup
    //   4390: ldc_w 1214
    //   4393: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4396: aload 17
    //   4398: iconst_1
    //   4399: baload
    //   4400: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4403: ldc_w 1266
    //   4406: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4409: iload_2
    //   4410: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4413: ldc_w 924
    //   4416: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4419: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4422: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4425: iload_2
    //   4426: iconst_1
    //   4427: if_icmpeq +37 -> 4464
    //   4430: aload 15
    //   4432: astore 16
    //   4434: new 993	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4437: dup
    //   4438: ldc_w 1312
    //   4441: iload_2
    //   4442: invokespecial 1219	no/nordicsemi/android/dfu/exception/RemoteDfuException:<init>	(Ljava/lang/String;I)V
    //   4445: athrow
    //   4446: astore_1
    //   4447: aload 15
    //   4449: astore 16
    //   4451: aload_0
    //   4452: ldc_w 1314
    //   4455: invokespecial 465	no/nordicsemi/android/dfu/DfuBaseService:loge	(Ljava/lang/String;)V
    //   4458: aload 15
    //   4460: astore 16
    //   4462: aload_1
    //   4463: athrow
    //   4464: aload 15
    //   4466: astore 16
    //   4468: aload_0
    //   4469: new 582	java/lang/StringBuilder
    //   4472: dup
    //   4473: ldc_w 1316
    //   4476: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4479: aload_0
    //   4480: getfield 383	no/nordicsemi/android/dfu/DfuBaseService:mBytesSent	I
    //   4483: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4486: ldc_w 1318
    //   4489: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4492: lload 13
    //   4494: lload 11
    //   4496: lsub
    //   4497: invokevirtual 1321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4500: ldc_w 1323
    //   4503: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4506: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4509: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   4512: aload 15
    //   4514: astore 16
    //   4516: aload_0
    //   4517: bipush 10
    //   4519: new 582	java/lang/StringBuilder
    //   4522: dup
    //   4523: ldc_w 1325
    //   4526: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4529: lload 13
    //   4531: lload 11
    //   4533: lsub
    //   4534: invokevirtual 1321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4537: ldc_w 1323
    //   4540: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4543: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4546: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4549: aload 15
    //   4551: astore 16
    //   4553: aload_0
    //   4554: ldc_w 1327
    //   4557: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   4560: aload 15
    //   4562: astore 16
    //   4564: aload_0
    //   4565: aload 19
    //   4567: aload 20
    //   4569: getstatic 266	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_VALIDATE	[B
    //   4572: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   4575: aload 15
    //   4577: astore 16
    //   4579: aload_0
    //   4580: bipush 10
    //   4582: ldc_w 1329
    //   4585: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4588: aload 15
    //   4590: astore 16
    //   4592: aload_0
    //   4593: invokespecial 1210	no/nordicsemi/android/dfu/DfuBaseService:readNotificationResponse	()[B
    //   4596: astore 17
    //   4598: aload 15
    //   4600: astore 16
    //   4602: aload_0
    //   4603: aload 17
    //   4605: iconst_4
    //   4606: invokespecial 1212	no/nordicsemi/android/dfu/DfuBaseService:getStatusCode	([BI)I
    //   4609: istore_2
    //   4610: aload 15
    //   4612: astore 16
    //   4614: aload_0
    //   4615: new 582	java/lang/StringBuilder
    //   4618: dup
    //   4619: ldc_w 1308
    //   4622: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4625: aload 17
    //   4627: iconst_0
    //   4628: baload
    //   4629: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4632: ldc_w 1310
    //   4635: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4638: aload 17
    //   4640: iconst_1
    //   4641: baload
    //   4642: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4645: ldc_w 1266
    //   4648: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4651: aload 17
    //   4653: iconst_2
    //   4654: baload
    //   4655: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4658: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4661: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   4664: aload 15
    //   4666: astore 16
    //   4668: aload_0
    //   4669: bipush 10
    //   4671: new 582	java/lang/StringBuilder
    //   4674: dup
    //   4675: ldc_w 1214
    //   4678: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4681: aload 17
    //   4683: iconst_1
    //   4684: baload
    //   4685: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4688: ldc_w 1266
    //   4691: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4694: iload_2
    //   4695: invokevirtual 955	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4698: ldc_w 924
    //   4701: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4704: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4707: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4710: iload_2
    //   4711: iconst_1
    //   4712: if_icmpeq +19 -> 4731
    //   4715: aload 15
    //   4717: astore 16
    //   4719: new 993	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4722: dup
    //   4723: ldc_w 1331
    //   4726: iload_2
    //   4727: invokespecial 1219	no/nordicsemi/android/dfu/exception/RemoteDfuException:<init>	(Ljava/lang/String;I)V
    //   4730: athrow
    //   4731: aload 15
    //   4733: astore 16
    //   4735: aload_0
    //   4736: bipush -5
    //   4738: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   4741: aload 15
    //   4743: astore 16
    //   4745: aload_0
    //   4746: ldc_w 1333
    //   4749: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   4752: aload 15
    //   4754: astore 16
    //   4756: aload_0
    //   4757: aload 19
    //   4759: aload 20
    //   4761: getstatic 268	no/nordicsemi/android/dfu/DfuBaseService:OP_CODE_ACTIVATE_AND_RESET	[B
    //   4764: invokespecial 1196	no/nordicsemi/android/dfu/DfuBaseService:writeOpCode	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   4767: aload 15
    //   4769: astore 16
    //   4771: aload_0
    //   4772: bipush 10
    //   4774: ldc_w 1335
    //   4777: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4780: aload 15
    //   4782: astore 16
    //   4784: aload_0
    //   4785: invokespecial 570	no/nordicsemi/android/dfu/DfuBaseService:waitUntilDisconnected	()V
    //   4788: aload 15
    //   4790: astore 16
    //   4792: aload_0
    //   4793: iconst_5
    //   4794: ldc_w 1181
    //   4797: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   4800: aload 15
    //   4802: astore 16
    //   4804: aload_1
    //   4805: ldc 120
    //   4807: iconst_0
    //   4808: invokevirtual 1156	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   4811: istore 10
    //   4813: iload 7
    //   4815: iconst_5
    //   4816: if_icmpeq +188 -> 5004
    //   4819: iload 10
    //   4821: ifeq +183 -> 5004
    //   4824: iconst_0
    //   4825: istore 9
    //   4827: aload 15
    //   4829: astore 16
    //   4831: aload_0
    //   4832: aload 19
    //   4834: iload 9
    //   4836: invokespecial 883	no/nordicsemi/android/dfu/DfuBaseService:refreshDeviceCache	(Landroid/bluetooth/BluetoothGatt;Z)V
    //   4839: aload 15
    //   4841: astore 16
    //   4843: aload_0
    //   4844: aload 19
    //   4846: invokespecial 885	no/nordicsemi/android/dfu/DfuBaseService:close	(Landroid/bluetooth/BluetoothGatt;)V
    //   4849: aload 15
    //   4851: astore 16
    //   4853: aload 19
    //   4855: invokevirtual 805	android/bluetooth/BluetoothGatt:getDevice	()Landroid/bluetooth/BluetoothDevice;
    //   4858: invokevirtual 513	android/bluetooth/BluetoothDevice:getBondState	()I
    //   4861: bipush 12
    //   4863: if_icmpne +86 -> 4949
    //   4866: aload 15
    //   4868: astore 16
    //   4870: aload_1
    //   4871: ldc -118
    //   4873: iconst_0
    //   4874: invokevirtual 1156	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   4877: istore 9
    //   4879: iload 9
    //   4881: ifne +14 -> 4895
    //   4884: iload 10
    //   4886: ifeq +9 -> 4895
    //   4889: iload_3
    //   4890: iconst_1
    //   4891: iand
    //   4892: ifle +32 -> 4924
    //   4895: aload 15
    //   4897: astore 16
    //   4899: aload_0
    //   4900: aload 19
    //   4902: invokevirtual 805	android/bluetooth/BluetoothGatt:getDevice	()Landroid/bluetooth/BluetoothDevice;
    //   4905: invokespecial 1337	no/nordicsemi/android/dfu/DfuBaseService:removeBond	(Landroid/bluetooth/BluetoothDevice;)Z
    //   4908: pop
    //   4909: aload 15
    //   4911: astore 16
    //   4913: aload_0
    //   4914: monitorenter
    //   4915: aload_0
    //   4916: ldc2_w 1338
    //   4919: invokevirtual 1342	java/lang/Object:wait	(J)V
    //   4922: aload_0
    //   4923: monitorexit
    //   4924: iload 9
    //   4926: ifeq +23 -> 4949
    //   4929: iload_3
    //   4930: iconst_4
    //   4931: iand
    //   4932: ifle +17 -> 4949
    //   4935: aload 15
    //   4937: astore 16
    //   4939: aload_0
    //   4940: aload 19
    //   4942: invokevirtual 805	android/bluetooth/BluetoothGatt:getDevice	()Landroid/bluetooth/BluetoothDevice;
    //   4945: invokespecial 1344	no/nordicsemi/android/dfu/DfuBaseService:createBond	(Landroid/bluetooth/BluetoothDevice;)Z
    //   4948: pop
    //   4949: aload 15
    //   4951: astore 16
    //   4953: aload_0
    //   4954: getfield 866	no/nordicsemi/android/dfu/DfuBaseService:mPartCurrent	I
    //   4957: aload_0
    //   4958: getfield 868	no/nordicsemi/android/dfu/DfuBaseService:mPartsTotal	I
    //   4961: if_icmpne +69 -> 5030
    //   4964: aload 15
    //   4966: astore 16
    //   4968: aload_0
    //   4969: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   4972: astore_1
    //   4973: aload 15
    //   4975: astore 16
    //   4977: aload_1
    //   4978: monitorenter
    //   4979: aload_0
    //   4980: getfield 332	no/nordicsemi/android/dfu/DfuBaseService:mLock	Ljava/lang/Object;
    //   4983: ldc2_w 1345
    //   4986: invokevirtual 1342	java/lang/Object:wait	(J)V
    //   4989: aload_1
    //   4990: monitorexit
    //   4991: aload 15
    //   4993: astore 16
    //   4995: aload_0
    //   4996: bipush -6
    //   4998: invokespecial 877	no/nordicsemi/android/dfu/DfuBaseService:updateProgressNotification	(I)V
    //   5001: goto -2364 -> 2637
    //   5004: iconst_1
    //   5005: istore 9
    //   5007: goto -180 -> 4827
    //   5010: astore_1
    //   5011: aload_0
    //   5012: monitorexit
    //   5013: aload 15
    //   5015: astore 16
    //   5017: aload_1
    //   5018: athrow
    //   5019: astore 17
    //   5021: aload_1
    //   5022: monitorexit
    //   5023: aload 15
    //   5025: astore 16
    //   5027: aload 17
    //   5029: athrow
    //   5030: aload 15
    //   5032: astore 16
    //   5034: aload_0
    //   5035: iconst_1
    //   5036: ldc_w 1348
    //   5039: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   5042: aload 15
    //   5044: astore 16
    //   5046: invokestatic 1354	no/nordicsemi/android/dfu/scanner/BootloaderScannerFactory:getScanner	()Lno/nordicsemi/android/dfu/scanner/BootloaderScanner;
    //   5049: aload_0
    //   5050: getfield 356	no/nordicsemi/android/dfu/DfuBaseService:mDeviceAddress	Ljava/lang/String;
    //   5053: invokeinterface 1359 2 0
    //   5058: astore 17
    //   5060: aload 17
    //   5062: ifnull +161 -> 5223
    //   5065: aload 15
    //   5067: astore 16
    //   5069: aload_0
    //   5070: iconst_5
    //   5071: new 582	java/lang/StringBuilder
    //   5074: dup
    //   5075: ldc_w 1361
    //   5078: invokespecial 585	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5081: aload 17
    //   5083: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5086: invokevirtual 595	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5089: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   5092: aload 15
    //   5094: astore 16
    //   5096: aload_0
    //   5097: ldc_w 1363
    //   5100: invokespecial 361	no/nordicsemi/android/dfu/DfuBaseService:logi	(Ljava/lang/String;)V
    //   5103: aload 15
    //   5105: astore 16
    //   5107: new 830	android/content/Intent
    //   5110: dup
    //   5111: invokespecial 1163	android/content/Intent:<init>	()V
    //   5114: astore 18
    //   5116: aload 15
    //   5118: astore 16
    //   5120: aload 18
    //   5122: aload_1
    //   5123: bipush 24
    //   5125: invokevirtual 1167	android/content/Intent:fillIn	(Landroid/content/Intent;I)I
    //   5128: pop
    //   5129: aload 15
    //   5131: astore 16
    //   5133: aload 18
    //   5135: ldc 102
    //   5137: ldc -95
    //   5139: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5142: pop
    //   5143: aload 15
    //   5145: astore 16
    //   5147: aload 18
    //   5149: ldc 108
    //   5151: iconst_4
    //   5152: invokevirtual 835	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5155: pop
    //   5156: aload 17
    //   5158: ifnull +17 -> 5175
    //   5161: aload 15
    //   5163: astore 16
    //   5165: aload 18
    //   5167: ldc 93
    //   5169: aload 17
    //   5171: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5174: pop
    //   5175: aload 15
    //   5177: astore 16
    //   5179: aload 18
    //   5181: ldc -124
    //   5183: aload_0
    //   5184: getfield 866	no/nordicsemi/android/dfu/DfuBaseService:mPartCurrent	I
    //   5187: iconst_1
    //   5188: iadd
    //   5189: invokevirtual 835	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5192: pop
    //   5193: aload 15
    //   5195: astore 16
    //   5197: aload 18
    //   5199: ldc -127
    //   5201: aload_0
    //   5202: getfield 868	no/nordicsemi/android/dfu/DfuBaseService:mPartsTotal	I
    //   5205: invokevirtual 835	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5208: pop
    //   5209: aload 15
    //   5211: astore 16
    //   5213: aload_0
    //   5214: aload 18
    //   5216: invokevirtual 1171	no/nordicsemi/android/dfu/DfuBaseService:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   5219: pop
    //   5220: goto -2583 -> 2637
    //   5223: aload 15
    //   5225: astore 16
    //   5227: aload_0
    //   5228: iconst_5
    //   5229: ldc_w 1365
    //   5232: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   5235: goto -143 -> 5092
    //   5238: iload_2
    //   5239: sipush 49151
    //   5242: iand
    //   5243: istore_2
    //   5244: aload 15
    //   5246: astore 16
    //   5248: aload_0
    //   5249: bipush 20
    //   5251: ldc_w 1274
    //   5254: iconst_2
    //   5255: anewarray 328	java/lang/Object
    //   5258: dup
    //   5259: iconst_0
    //   5260: iload_2
    //   5261: invokestatic 1097	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5264: aastore
    //   5265: dup
    //   5266: iconst_1
    //   5267: iload_2
    //   5268: invokestatic 1271	no/nordicsemi/android/error/GattError:parse	(I)Ljava/lang/String;
    //   5271: aastore
    //   5272: invokestatic 1106	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5275: invokespecial 418	no/nordicsemi/android/dfu/DfuBaseService:sendLogBroadcast	(ILjava/lang/String;)V
    //   5278: goto -1544 -> 3734
    //   5281: astore 16
    //   5283: goto -361 -> 4922
    //   5286: astore 15
    //   5288: goto -2038 -> 3250
    //   5291: astore_1
    //   5292: goto -2057 -> 3235
    //   5295: astore 16
    //   5297: goto -1497 -> 3800
    //   5300: astore_1
    //   5301: goto -2086 -> 3215
    //   5304: astore 16
    //   5306: goto -317 -> 4989
    //   5309: astore 16
    //   5311: goto -2517 -> 2794
    //   5314: astore_1
    //   5315: goto -4322 -> 993
    //   5318: astore_1
    //   5319: goto -4372 -> 947
    //   5322: astore_1
    //   5323: goto -4422 -> 901
    //   5326: aload 16
    //   5328: astore 18
    //   5330: goto -4684 -> 646
    //   5333: aconst_null
    //   5334: astore 16
    //   5336: goto -4785 -> 551
    //   5339: iconst_1
    //   5340: istore_3
    //   5341: goto -3479 -> 1862
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5344	0	this	DfuBaseService
    //   0	5344	1	paramIntent	Intent
    //   67	5201	2	i	int
    //   69	5272	3	j	int
    //   370	3096	4	k	int
    //   1450	1672	5	m	int
    //   2134	534	6	n	int
    //   1418	3399	7	i1	int
    //   2137	850	8	i2	int
    //   346	4660	9	bool1	boolean
    //   4811	74	10	bool2	boolean
    //   4234	298	11	l1	long
    //   4311	219	13	l2	long
    //   4	773	15	localObject1	Object
    //   792	10	15	localNumberFormatException1	NumberFormatException
    //   827	4418	15	localObject2	Object
    //   5286	1	15	localIOException1	IOException
    //   20	738	16	localObject3	Object
    //   784	1	16	localNumberFormatException2	NumberFormatException
    //   815	4432	16	localObject4	Object
    //   5281	1	16	localInterruptedException1	InterruptedException
    //   5295	1	16	localException	Exception
    //   5304	1	16	localInterruptedException2	InterruptedException
    //   5309	18	16	localIOException2	IOException
    //   5334	1	16	localObject5	Object
    //   106	2350	17	localObject6	Object
    //   2510	24	17	localRemoteDfuException1	no.nordicsemi.android.dfu.exception.RemoteDfuException
    //   2536	20	17	localRemoteDfuException2	no.nordicsemi.android.dfu.exception.RemoteDfuException
    //   3034	1648	17	arrayOfByte	byte[]
    //   5019	9	17	localObject7	Object
    //   5058	112	17	str1	String
    //   447	4882	18	localObject8	Object
    //   460	4481	19	localObject9	Object
    //   464	4296	20	localObject10	Object
    //   468	3828	21	localObject11	Object
    //   450	983	22	localObject12	Object
    //   453	361	23	localObject13	Object
    //   12	708	24	str2	String
    //   47	811	25	str3	String
    //   58	483	26	localUri1	Uri
    //   28	791	27	str4	String
    //   39	466	28	localUri2	Uri
    // Exception table:
    //   from	to	target	type
    //   766	771	782	java/io/IOException
    //   776	781	782	java/io/IOException
    //   365	372	784	java/lang/NumberFormatException
    //   421	428	792	java/lang/NumberFormatException
    //   474	482	896	java/lang/SecurityException
    //   503	515	896	java/lang/SecurityException
    //   536	547	896	java/lang/SecurityException
    //   662	693	896	java/lang/SecurityException
    //   817	829	896	java/lang/SecurityException
    //   853	864	896	java/lang/SecurityException
    //   924	929	940	java/io/IOException
    //   934	939	940	java/io/IOException
    //   474	482	942	java/io/FileNotFoundException
    //   503	515	942	java/io/FileNotFoundException
    //   536	547	942	java/io/FileNotFoundException
    //   662	693	942	java/io/FileNotFoundException
    //   817	829	942	java/io/FileNotFoundException
    //   853	864	942	java/io/FileNotFoundException
    //   970	975	986	java/io/IOException
    //   980	985	986	java/io/IOException
    //   474	482	988	java/io/IOException
    //   503	515	988	java/io/IOException
    //   536	547	988	java/io/IOException
    //   662	693	988	java/io/IOException
    //   817	829	988	java/io/IOException
    //   853	864	988	java/io/IOException
    //   1016	1021	1032	java/io/IOException
    //   1026	1031	1032	java/io/IOException
    //   1131	1136	1147	java/io/IOException
    //   1141	1146	1147	java/io/IOException
    //   1196	1201	1212	java/io/IOException
    //   1206	1211	1212	java/io/IOException
    //   1270	1275	1286	java/io/IOException
    //   1280	1285	1286	java/io/IOException
    //   1363	1368	1379	java/io/IOException
    //   1373	1378	1379	java/io/IOException
    //   1828	1833	1844	java/io/IOException
    //   1838	1843	1844	java/io/IOException
    //   2057	2062	2073	java/io/IOException
    //   2067	2072	2073	java/io/IOException
    //   2201	2208	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2212	2239	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2243	2254	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2258	2287	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2291	2341	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2345	2359	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2363	2415	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2419	2425	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2429	2438	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2442	2485	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2497	2510	2510	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2518	2527	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2533	2536	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2690	2695	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2701	2708	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2714	2723	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2734	2739	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2745	2752	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2758	2763	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2769	2779	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2785	2794	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2800	2808	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2814	2841	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2847	2858	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2864	2893	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2899	2948	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2954	2967	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2973	3024	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3030	3036	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3042	3051	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3057	3100	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3114	3127	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3258	3261	2536	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2143	2153	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2157	2164	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2168	2175	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2179	2186	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2190	2197	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2201	2208	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2212	2239	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2243	2254	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2258	2287	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2291	2341	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2345	2359	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2363	2415	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2419	2425	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2429	2438	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2442	2485	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2497	2510	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2518	2527	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2533	2536	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2542	2551	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2555	2558	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2690	2695	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2701	2708	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2714	2723	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2734	2739	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2745	2752	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2758	2763	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2769	2779	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2785	2794	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2800	2808	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2814	2841	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2847	2858	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2864	2893	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2899	2948	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2954	2967	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2973	3024	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3030	3036	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3042	3051	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3057	3100	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3114	3127	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3258	3261	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3320	3325	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3329	3336	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3340	3349	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3353	3361	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3365	3372	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3376	3387	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3391	3400	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3404	3432	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3436	3448	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3452	3482	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3486	3492	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3496	3504	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3508	3550	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3559	3571	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3821	3824	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3833	3842	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3846	3853	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3857	3868	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3872	3878	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3882	3894	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3903	3910	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3914	3925	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3929	3938	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3942	3948	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3952	3960	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   3964	4006	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4015	4027	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4031	4042	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4050	4057	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4061	4075	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4079	4084	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4088	4093	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4101	4128	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4132	4140	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4144	4155	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4159	4188	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4192	4199	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4203	4214	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4218	4227	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4231	4236	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4240	4246	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4250	4256	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4260	4264	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4268	4275	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4279	4288	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4292	4304	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4308	4313	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4317	4325	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4329	4379	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4383	4425	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4434	4446	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4451	4458	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4462	4464	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4468	4512	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4516	4549	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4553	4560	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4564	4575	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4579	4588	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4592	4598	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4602	4610	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4614	4664	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4668	4710	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4719	4731	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4735	4741	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4745	4752	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4756	4767	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4771	4780	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4784	4788	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4792	4800	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4804	4813	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4831	4839	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4843	4849	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4853	4866	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4870	4879	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4899	4909	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4913	4915	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4939	4949	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4953	4964	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4968	4973	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4977	4979	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   4995	5001	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5017	5019	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5027	5030	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5034	5042	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5046	5060	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5069	5092	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5096	5103	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5107	5116	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5120	5129	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5133	5143	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5147	5156	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5165	5175	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5179	5193	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5197	5209	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5213	5220	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   5227	5235	2558	no/nordicsemi/android/dfu/exception/UnknownResponseException
    //   2637	2642	2653	java/io/IOException
    //   2647	2652	2653	java/io/IOException
    //   1411	1417	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1429	1439	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1456	1488	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1492	1526	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1541	1555	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1559	1566	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1570	1579	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1589	1602	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1606	1616	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1628	1638	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1650	1661	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1665	1674	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1678	1687	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1691	1701	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1711	1719	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1723	1729	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1733	1741	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1745	1750	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1754	1758	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1762	1770	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1774	1780	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1784	1791	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1795	1804	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1808	1817	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1821	1828	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1850	1859	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1866	1874	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1878	1887	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1891	1900	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1904	1910	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1914	1920	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1924	1931	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1935	1947	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1951	1960	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1964	1968	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1972	1980	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   1991	1999	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2003	2009	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2013	2020	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2024	2033	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2037	2046	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2050	2057	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2085	2094	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2098	2107	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2143	2153	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2157	2164	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2168	2175	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2179	2186	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2190	2197	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2201	2208	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2212	2239	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2243	2254	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2258	2287	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2291	2341	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2345	2359	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2363	2415	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2419	2425	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2429	2438	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2442	2485	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2497	2510	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2518	2527	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2533	2536	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2542	2551	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2555	2558	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2563	2571	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2575	2585	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2589	2596	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2600	2611	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2615	2624	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2628	2637	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2690	2695	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2701	2708	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2714	2723	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2734	2739	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2745	2752	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2758	2763	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2769	2779	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2785	2794	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2800	2808	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2814	2841	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2847	2858	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2864	2893	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2899	2948	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2954	2967	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   2973	3024	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3030	3036	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3042	3051	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3057	3100	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3114	3127	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3258	3261	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3320	3325	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3329	3336	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3340	3349	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3353	3361	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3365	3372	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3376	3387	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3391	3400	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3404	3432	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3436	3448	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3452	3482	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3486	3492	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3496	3504	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3508	3550	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3559	3571	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3576	3585	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3589	3597	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3601	3624	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3628	3635	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3639	3650	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3654	3663	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3667	3674	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3821	3824	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3833	3842	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3846	3853	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3857	3868	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3872	3878	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3882	3894	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3903	3910	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3914	3925	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3929	3938	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3942	3948	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3952	3960	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   3964	4006	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4015	4027	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4031	4042	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4050	4057	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4061	4075	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4079	4084	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4088	4093	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4101	4128	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4132	4140	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4144	4155	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4159	4188	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4192	4199	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4203	4214	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4218	4227	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4231	4236	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4240	4246	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4250	4256	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4260	4264	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4268	4275	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4279	4288	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4292	4304	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4308	4313	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4317	4325	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4329	4379	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4383	4425	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4434	4446	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4451	4458	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4462	4464	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4468	4512	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4516	4549	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4553	4560	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4564	4575	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4579	4588	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4592	4598	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4602	4610	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4614	4664	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4668	4710	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4719	4731	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4735	4741	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4745	4752	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4756	4767	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4771	4780	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4784	4788	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4792	4800	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4804	4813	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4831	4839	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4843	4849	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4853	4866	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4870	4879	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4899	4909	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4913	4915	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4939	4949	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4953	4964	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4968	4973	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4977	4979	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   4995	5001	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5017	5019	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5027	5030	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5034	5042	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5046	5060	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5069	5092	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5096	5103	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5107	5116	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5120	5129	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5133	5143	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5147	5156	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5165	5175	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5179	5193	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5197	5209	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5213	5220	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   5227	5235	3127	no/nordicsemi/android/dfu/exception/UploadAbortedException
    //   474	482	3230	finally
    //   503	515	3230	finally
    //   536	547	3230	finally
    //   662	693	3230	finally
    //   697	705	3230	finally
    //   709	714	3230	finally
    //   718	726	3230	finally
    //   735	742	3230	finally
    //   746	755	3230	finally
    //   759	766	3230	finally
    //   817	829	3230	finally
    //   853	864	3230	finally
    //   905	913	3230	finally
    //   917	924	3230	finally
    //   951	959	3230	finally
    //   963	970	3230	finally
    //   997	1005	3230	finally
    //   1009	1016	3230	finally
    //   1038	1045	3230	finally
    //   1049	1058	3230	finally
    //   1062	1083	3230	finally
    //   1087	1117	3230	finally
    //   1121	1131	3230	finally
    //   1153	1160	3230	finally
    //   1164	1171	3230	finally
    //   1175	1184	3230	finally
    //   1188	1196	3230	finally
    //   1218	1228	3230	finally
    //   1237	1244	3230	finally
    //   1248	1257	3230	finally
    //   1261	1270	3230	finally
    //   1292	1302	3230	finally
    //   1306	1316	3230	finally
    //   1330	1337	3230	finally
    //   1341	1350	3230	finally
    //   1354	1363	3230	finally
    //   1385	1395	3230	finally
    //   1399	1407	3230	finally
    //   1411	1417	3230	finally
    //   1429	1439	3230	finally
    //   1456	1488	3230	finally
    //   1492	1526	3230	finally
    //   1541	1555	3230	finally
    //   1559	1566	3230	finally
    //   1570	1579	3230	finally
    //   1589	1602	3230	finally
    //   1606	1616	3230	finally
    //   1628	1638	3230	finally
    //   1650	1661	3230	finally
    //   1665	1674	3230	finally
    //   1678	1687	3230	finally
    //   1691	1701	3230	finally
    //   1711	1719	3230	finally
    //   1723	1729	3230	finally
    //   1733	1741	3230	finally
    //   1745	1750	3230	finally
    //   1754	1758	3230	finally
    //   1762	1770	3230	finally
    //   1774	1780	3230	finally
    //   1784	1791	3230	finally
    //   1795	1804	3230	finally
    //   1808	1817	3230	finally
    //   1821	1828	3230	finally
    //   1850	1859	3230	finally
    //   1866	1874	3230	finally
    //   1878	1887	3230	finally
    //   1891	1900	3230	finally
    //   1904	1910	3230	finally
    //   1914	1920	3230	finally
    //   1924	1931	3230	finally
    //   1935	1947	3230	finally
    //   1951	1960	3230	finally
    //   1964	1968	3230	finally
    //   1972	1980	3230	finally
    //   1991	1999	3230	finally
    //   2003	2009	3230	finally
    //   2013	2020	3230	finally
    //   2024	2033	3230	finally
    //   2037	2046	3230	finally
    //   2050	2057	3230	finally
    //   2085	2094	3230	finally
    //   2098	2107	3230	finally
    //   2143	2153	3230	finally
    //   2157	2164	3230	finally
    //   2168	2175	3230	finally
    //   2179	2186	3230	finally
    //   2190	2197	3230	finally
    //   2201	2208	3230	finally
    //   2212	2239	3230	finally
    //   2243	2254	3230	finally
    //   2258	2287	3230	finally
    //   2291	2341	3230	finally
    //   2345	2359	3230	finally
    //   2363	2415	3230	finally
    //   2419	2425	3230	finally
    //   2429	2438	3230	finally
    //   2442	2485	3230	finally
    //   2497	2510	3230	finally
    //   2518	2527	3230	finally
    //   2533	2536	3230	finally
    //   2542	2551	3230	finally
    //   2555	2558	3230	finally
    //   2563	2571	3230	finally
    //   2575	2585	3230	finally
    //   2589	2596	3230	finally
    //   2600	2611	3230	finally
    //   2615	2624	3230	finally
    //   2628	2637	3230	finally
    //   2690	2695	3230	finally
    //   2701	2708	3230	finally
    //   2714	2723	3230	finally
    //   2734	2739	3230	finally
    //   2745	2752	3230	finally
    //   2758	2763	3230	finally
    //   2769	2779	3230	finally
    //   2785	2794	3230	finally
    //   2800	2808	3230	finally
    //   2814	2841	3230	finally
    //   2847	2858	3230	finally
    //   2864	2893	3230	finally
    //   2899	2948	3230	finally
    //   2954	2967	3230	finally
    //   2973	3024	3230	finally
    //   3030	3036	3230	finally
    //   3042	3051	3230	finally
    //   3057	3100	3230	finally
    //   3114	3127	3230	finally
    //   3132	3139	3230	finally
    //   3143	3152	3230	finally
    //   3156	3161	3230	finally
    //   3171	3176	3230	finally
    //   3180	3187	3230	finally
    //   3191	3202	3230	finally
    //   3206	3215	3230	finally
    //   3219	3227	3230	finally
    //   3258	3261	3230	finally
    //   3266	3275	3230	finally
    //   3279	3287	3230	finally
    //   3291	3297	3230	finally
    //   3301	3308	3230	finally
    //   3320	3325	3230	finally
    //   3329	3336	3230	finally
    //   3340	3349	3230	finally
    //   3353	3361	3230	finally
    //   3365	3372	3230	finally
    //   3376	3387	3230	finally
    //   3391	3400	3230	finally
    //   3404	3432	3230	finally
    //   3436	3448	3230	finally
    //   3452	3482	3230	finally
    //   3486	3492	3230	finally
    //   3496	3504	3230	finally
    //   3508	3550	3230	finally
    //   3559	3571	3230	finally
    //   3576	3585	3230	finally
    //   3589	3597	3230	finally
    //   3601	3624	3230	finally
    //   3628	3635	3230	finally
    //   3639	3650	3230	finally
    //   3654	3663	3230	finally
    //   3667	3674	3230	finally
    //   3682	3687	3230	finally
    //   3704	3734	3230	finally
    //   3738	3746	3230	finally
    //   3750	3755	3230	finally
    //   3765	3772	3230	finally
    //   3776	3787	3230	finally
    //   3791	3800	3230	finally
    //   3804	3814	3230	finally
    //   3821	3824	3230	finally
    //   3833	3842	3230	finally
    //   3846	3853	3230	finally
    //   3857	3868	3230	finally
    //   3872	3878	3230	finally
    //   3882	3894	3230	finally
    //   3903	3910	3230	finally
    //   3914	3925	3230	finally
    //   3929	3938	3230	finally
    //   3942	3948	3230	finally
    //   3952	3960	3230	finally
    //   3964	4006	3230	finally
    //   4015	4027	3230	finally
    //   4031	4042	3230	finally
    //   4050	4057	3230	finally
    //   4061	4075	3230	finally
    //   4079	4084	3230	finally
    //   4088	4093	3230	finally
    //   4101	4128	3230	finally
    //   4132	4140	3230	finally
    //   4144	4155	3230	finally
    //   4159	4188	3230	finally
    //   4192	4199	3230	finally
    //   4203	4214	3230	finally
    //   4218	4227	3230	finally
    //   4231	4236	3230	finally
    //   4240	4246	3230	finally
    //   4250	4256	3230	finally
    //   4260	4264	3230	finally
    //   4268	4275	3230	finally
    //   4279	4288	3230	finally
    //   4292	4304	3230	finally
    //   4308	4313	3230	finally
    //   4317	4325	3230	finally
    //   4329	4379	3230	finally
    //   4383	4425	3230	finally
    //   4434	4446	3230	finally
    //   4451	4458	3230	finally
    //   4462	4464	3230	finally
    //   4468	4512	3230	finally
    //   4516	4549	3230	finally
    //   4553	4560	3230	finally
    //   4564	4575	3230	finally
    //   4579	4588	3230	finally
    //   4592	4598	3230	finally
    //   4602	4610	3230	finally
    //   4614	4664	3230	finally
    //   4668	4710	3230	finally
    //   4719	4731	3230	finally
    //   4735	4741	3230	finally
    //   4745	4752	3230	finally
    //   4756	4767	3230	finally
    //   4771	4780	3230	finally
    //   4784	4788	3230	finally
    //   4792	4800	3230	finally
    //   4804	4813	3230	finally
    //   4831	4839	3230	finally
    //   4843	4849	3230	finally
    //   4853	4866	3230	finally
    //   4870	4879	3230	finally
    //   4899	4909	3230	finally
    //   4913	4915	3230	finally
    //   4939	4949	3230	finally
    //   4953	4964	3230	finally
    //   4968	4973	3230	finally
    //   4977	4979	3230	finally
    //   4995	5001	3230	finally
    //   5017	5019	3230	finally
    //   5027	5030	3230	finally
    //   5034	5042	3230	finally
    //   5046	5060	3230	finally
    //   5069	5092	3230	finally
    //   5096	5103	3230	finally
    //   5107	5116	3230	finally
    //   5120	5129	3230	finally
    //   5133	5143	3230	finally
    //   5147	5156	3230	finally
    //   5165	5175	3230	finally
    //   5179	5193	3230	finally
    //   5197	5209	3230	finally
    //   5213	5220	3230	finally
    //   5227	5235	3230	finally
    //   5248	5278	3230	finally
    //   1411	1417	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1429	1439	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1456	1488	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1492	1526	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1541	1555	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1559	1566	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1570	1579	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1589	1602	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1606	1616	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1628	1638	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1650	1661	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1665	1674	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1678	1687	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1691	1701	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1711	1719	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1723	1729	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1733	1741	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1745	1750	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1754	1758	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1762	1770	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1774	1780	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1784	1791	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1795	1804	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1808	1817	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1821	1828	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1850	1859	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1866	1874	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1878	1887	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1891	1900	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1904	1910	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1914	1920	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1924	1931	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1935	1947	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1951	1960	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1964	1968	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1972	1980	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   1991	1999	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2003	2009	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2013	2020	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2024	2033	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2037	2046	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2050	2057	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2085	2094	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2098	2107	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2143	2153	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2157	2164	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2168	2175	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2179	2186	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2190	2197	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2201	2208	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2212	2239	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2243	2254	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2258	2287	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2291	2341	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2345	2359	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2363	2415	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2419	2425	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2429	2438	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2442	2485	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2497	2510	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2518	2527	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2533	2536	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2542	2551	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2555	2558	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2563	2571	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2575	2585	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2589	2596	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2600	2611	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2615	2624	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2628	2637	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2690	2695	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2701	2708	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2714	2723	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2734	2739	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2745	2752	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2758	2763	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2769	2779	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2785	2794	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2800	2808	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2814	2841	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2847	2858	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2864	2893	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2899	2948	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2954	2967	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2973	3024	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3030	3036	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3042	3051	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3057	3100	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3114	3127	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3258	3261	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3320	3325	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3329	3336	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3340	3349	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3353	3361	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3365	3372	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3376	3387	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3391	3400	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3404	3432	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3436	3448	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3452	3482	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3486	3492	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3496	3504	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3508	3550	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3559	3571	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3576	3585	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3589	3597	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3601	3624	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3628	3635	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3639	3650	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3654	3663	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3667	3674	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3821	3824	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3833	3842	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3846	3853	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3857	3868	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3872	3878	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3882	3894	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3903	3910	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3914	3925	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3929	3938	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3942	3948	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3952	3960	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   3964	4006	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4015	4027	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4031	4042	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4050	4057	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4061	4075	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4079	4084	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4088	4093	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4101	4128	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4132	4140	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4144	4155	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4159	4188	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4192	4199	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4203	4214	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4218	4227	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4231	4236	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4240	4246	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4250	4256	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4260	4264	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4308	4313	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4317	4325	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4329	4379	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4383	4425	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4434	4446	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4451	4458	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4462	4464	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4468	4512	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4516	4549	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4553	4560	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4564	4575	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4579	4588	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4592	4598	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4602	4610	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4614	4664	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4668	4710	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4719	4731	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4735	4741	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4745	4752	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4756	4767	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4771	4780	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4784	4788	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4792	4800	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4804	4813	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4831	4839	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4843	4849	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4853	4866	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4870	4879	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4899	4909	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4913	4915	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4939	4949	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4953	4964	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4968	4973	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4977	4979	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4995	5001	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5017	5019	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5027	5030	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5034	5042	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5046	5060	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5069	5092	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5096	5103	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5107	5116	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5120	5129	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5133	5143	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5147	5156	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5165	5175	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5179	5193	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5197	5209	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5213	5220	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   5227	5235	3261	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   2143	2153	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2157	2164	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2168	2175	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2179	2186	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2190	2197	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2542	2551	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   2555	2558	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3320	3325	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3329	3336	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3340	3349	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3353	3361	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3365	3372	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3376	3387	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3391	3400	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3404	3432	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3436	3448	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3452	3482	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3486	3492	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3496	3504	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3508	3550	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3559	3571	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3821	3824	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3833	3842	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3846	3853	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3857	3868	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3872	3878	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3882	3894	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3903	3910	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3914	3925	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3929	3938	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3942	3948	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3952	3960	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   3964	4006	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4015	4027	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4031	4042	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4050	4057	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4061	4075	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4079	4084	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4088	4093	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4101	4128	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4132	4140	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4144	4155	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4159	4188	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4192	4199	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4203	4214	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4218	4227	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4231	4236	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4240	4246	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4250	4256	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4260	4264	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4268	4275	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4279	4288	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4292	4304	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4308	4313	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4317	4325	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4329	4379	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4383	4425	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4434	4446	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4451	4458	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4462	4464	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4468	4512	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4516	4549	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4553	4560	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4564	4575	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4579	4588	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4592	4598	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4602	4610	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4614	4664	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4668	4710	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4719	4731	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4735	4741	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4745	4752	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4756	4767	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4771	4780	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4784	4788	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4792	4800	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4804	4813	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4831	4839	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4843	4849	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4853	4866	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4870	4879	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4899	4909	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4913	4915	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4939	4949	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4953	4964	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4968	4973	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4977	4979	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   4995	5001	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5017	5019	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5027	5030	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5034	5042	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5046	5060	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5069	5092	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5096	5103	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5107	5116	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5120	5129	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5133	5143	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5147	5156	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5165	5175	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5179	5193	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5197	5209	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5213	5220	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   5227	5235	3571	no/nordicsemi/android/dfu/exception/RemoteDfuException
    //   1411	1417	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1429	1439	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1456	1488	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1492	1526	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1541	1555	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1559	1566	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1570	1579	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1589	1602	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1606	1616	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1628	1638	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1650	1661	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1665	1674	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1678	1687	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1691	1701	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1711	1719	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1723	1729	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1733	1741	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1745	1750	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1754	1758	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1762	1770	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1774	1780	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1784	1791	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1795	1804	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1808	1817	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1821	1828	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1850	1859	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1866	1874	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1878	1887	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1891	1900	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1904	1910	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1914	1920	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1924	1931	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1935	1947	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1951	1960	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1964	1968	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1972	1980	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   1991	1999	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2003	2009	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2013	2020	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2024	2033	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2037	2046	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2050	2057	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2085	2094	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2098	2107	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2143	2153	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2157	2164	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2168	2175	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2179	2186	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2190	2197	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2201	2208	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2212	2239	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2243	2254	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2258	2287	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2291	2341	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2345	2359	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2363	2415	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2419	2425	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2429	2438	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2442	2485	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2497	2510	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2518	2527	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2533	2536	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2542	2551	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2555	2558	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2563	2571	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2575	2585	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2589	2596	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2600	2611	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2615	2624	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2628	2637	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2690	2695	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2701	2708	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2714	2723	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2734	2739	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2745	2752	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2758	2763	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2769	2779	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2785	2794	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2800	2808	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2814	2841	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2847	2858	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2864	2893	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2899	2948	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2954	2967	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   2973	3024	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3030	3036	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3042	3051	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3057	3100	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3114	3127	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3258	3261	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3320	3325	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3329	3336	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3340	3349	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3353	3361	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3365	3372	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3376	3387	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3391	3400	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3404	3432	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3436	3448	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3452	3482	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3486	3492	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3496	3504	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3508	3550	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3559	3571	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3576	3585	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3589	3597	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3601	3624	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3628	3635	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3639	3650	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3654	3663	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3667	3674	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3821	3824	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3833	3842	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3846	3853	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3857	3868	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3872	3878	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3882	3894	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3903	3910	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3914	3925	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3929	3938	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3942	3948	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3952	3960	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3964	4006	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4015	4027	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4031	4042	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4050	4057	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4061	4075	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4079	4084	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4088	4093	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4101	4128	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4132	4140	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4144	4155	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4159	4188	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4192	4199	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4203	4214	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4218	4227	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4231	4236	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4240	4246	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4250	4256	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4260	4264	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4268	4275	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4279	4288	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4292	4304	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4308	4313	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4317	4325	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4329	4379	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4383	4425	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4434	4446	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4451	4458	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4462	4464	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4468	4512	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4516	4549	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4553	4560	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4564	4575	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4579	4588	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4592	4598	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4602	4610	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4614	4664	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4668	4710	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4719	4731	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4735	4741	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4745	4752	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4756	4767	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4771	4780	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4784	4788	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4792	4800	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4804	4813	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4831	4839	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4843	4849	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4853	4866	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4870	4879	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4899	4909	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4913	4915	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4939	4949	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4953	4964	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4968	4973	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4977	4979	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   4995	5001	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5017	5019	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5027	5030	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5034	5042	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5046	5060	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5069	5092	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5096	5103	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5107	5116	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5120	5129	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5133	5143	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5147	5156	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5165	5175	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5179	5193	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5197	5209	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5213	5220	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   5227	5235	3677	no/nordicsemi/android/dfu/exception/DfuException
    //   3872	3878	4045	java/io/IOException
    //   3882	3894	4045	java/io/IOException
    //   4031	4042	4045	java/io/IOException
    //   4268	4275	4446	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4279	4288	4446	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4292	4304	4446	no/nordicsemi/android/dfu/exception/DeviceDisconnectedException
    //   4915	4922	5010	finally
    //   4922	4924	5010	finally
    //   5011	5013	5010	finally
    //   4979	4989	5019	finally
    //   4989	4991	5019	finally
    //   5021	5023	5019	finally
    //   4915	4922	5281	java/lang/InterruptedException
    //   3235	3240	5286	java/io/IOException
    //   3245	3250	5286	java/io/IOException
    //   551	570	5291	finally
    //   578	597	5291	finally
    //   597	619	5291	finally
    //   624	646	5291	finally
    //   871	893	5291	finally
    //   3765	3772	5295	java/lang/Exception
    //   3776	3787	5295	java/lang/Exception
    //   3791	3800	5295	java/lang/Exception
    //   3171	3176	5300	java/lang/Exception
    //   3180	3187	5300	java/lang/Exception
    //   3191	3202	5300	java/lang/Exception
    //   3206	3215	5300	java/lang/Exception
    //   4979	4989	5304	java/lang/InterruptedException
    //   2785	2794	5309	java/io/IOException
    //   551	570	5314	java/io/IOException
    //   578	597	5314	java/io/IOException
    //   597	619	5314	java/io/IOException
    //   624	646	5314	java/io/IOException
    //   871	893	5314	java/io/IOException
    //   551	570	5318	java/io/FileNotFoundException
    //   578	597	5318	java/io/FileNotFoundException
    //   597	619	5318	java/io/FileNotFoundException
    //   624	646	5318	java/io/FileNotFoundException
    //   871	893	5318	java/io/FileNotFoundException
    //   551	570	5322	java/lang/SecurityException
    //   578	597	5322	java/lang/SecurityException
    //   597	619	5322	java/lang/SecurityException
    //   624	646	5322	java/lang/SecurityException
    //   871	893	5322	java/lang/SecurityException
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\DfuBaseService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */