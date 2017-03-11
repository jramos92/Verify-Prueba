package android.support.v4.print;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  private final Object mLock = new Object();
  int mOrientation = 1;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f = paramRectF.width() / paramInt1;
    if (paramInt3 == 2) {}
    for (f = Math.max(f, paramRectF.height() / paramInt2);; f = Math.min(f, paramRectF.height() / paramInt2))
    {
      localMatrix.postScale(f, f);
      localMatrix.postTranslate((paramRectF.width() - paramInt1 * f) / 2.0F, (paramRectF.height() - paramInt2 * f) / 2.0F);
      return localMatrix;
    }
  }
  
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    if ((paramUri == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to loadBitmap");
    }
    localUri = null;
    try
    {
      paramUri = this.mContext.getContentResolver().openInputStream(paramUri);
      localUri = paramUri;
      paramOptions = BitmapFactory.decodeStream(paramUri, null, paramOptions);
      if (paramUri != null) {}
      try
      {
        paramUri.close();
        return paramOptions;
      }
      catch (IOException paramUri)
      {
        Log.w("PrintHelperKitkat", "close fail ", paramUri);
        return paramOptions;
      }
      try
      {
        localUri.close();
        throw paramUri;
      }
      catch (IOException paramOptions)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", paramOptions);
        }
      }
    }
    finally
    {
      if (localUri == null) {}
    }
  }
  
  private Bitmap loadConstrainedBitmap(Uri arg1, int paramInt)
    throws FileNotFoundException
  {
    if ((paramInt <= 0) || (??? == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }
    ??? = new BitmapFactory.Options();
    ((BitmapFactory.Options)???).inJustDecodeBounds = true;
    loadBitmap(???, (BitmapFactory.Options)???);
    int k = ((BitmapFactory.Options)???).outWidth;
    int m = ((BitmapFactory.Options)???).outHeight;
    if ((k <= 0) || (m <= 0)) {}
    int i;
    do
    {
      return null;
      int j = Math.max(k, m);
      i = 1;
      while (j > paramInt)
      {
        j >>>= 1;
        i <<= 1;
      }
    } while ((i <= 0) || (Math.min(k, m) / i <= 0));
    BitmapFactory.Options localOptions;
    synchronized (this.mLock)
    {
      this.mDecodeOptions = new BitmapFactory.Options();
      this.mDecodeOptions.inMutable = true;
      this.mDecodeOptions.inSampleSize = i;
      localOptions = this.mDecodeOptions;
    }
    try
    {
      ??? = loadBitmap(???, localOptions);
      synchronized (this.mLock)
      {
        this.mDecodeOptions = null;
        return (Bitmap)???;
      }
      ??? = finally;
      throw ???;
    }
    finally {}
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(final String paramString, final Bitmap paramBitmap, final OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    if (paramBitmap == null) {
      return;
    }
    final int i = this.mScaleMode;
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    Object localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
      localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
    }
    localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
    localPrintManager.print(paramString, new PrintDocumentAdapter()
    {
      private PrintAttributes mAttributes;
      
      public void onFinish()
      {
        if (paramOnPrintFinishCallback != null) {
          paramOnPrintFinishCallback.onFinish();
        }
      }
      
      public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        boolean bool = true;
        this.mAttributes = paramAnonymousPrintAttributes2;
        paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
        if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
        for (;;)
        {
          paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
          return;
          bool = false;
        }
      }
      
      /* Error */
      public void onWrite(android.print.PageRange[] paramAnonymousArrayOfPageRange, android.os.ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        // Byte code:
        //   0: new 80	android/print/pdf/PrintedPdfDocument
        //   3: dup
        //   4: aload_0
        //   5: getfield 25	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   8: getfield 84	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
        //   11: aload_0
        //   12: getfield 46	android/support/v4/print/PrintHelperKitkat$1:mAttributes	Landroid/print/PrintAttributes;
        //   15: invokespecial 87	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
        //   18: astore_1
        //   19: aload_1
        //   20: iconst_1
        //   21: invokevirtual 91	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
        //   24: astore_3
        //   25: new 93	android/graphics/RectF
        //   28: dup
        //   29: aload_3
        //   30: invokevirtual 99	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
        //   33: invokevirtual 105	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
        //   36: invokespecial 108	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
        //   39: astore 5
        //   41: aload_0
        //   42: getfield 25	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   45: aload_0
        //   46: getfield 29	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   49: invokevirtual 114	android/graphics/Bitmap:getWidth	()I
        //   52: aload_0
        //   53: getfield 29	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   56: invokevirtual 117	android/graphics/Bitmap:getHeight	()I
        //   59: aload 5
        //   61: aload_0
        //   62: getfield 31	android/support/v4/print/PrintHelperKitkat$1:val$fittingMode	I
        //   65: invokestatic 121	android/support/v4/print/PrintHelperKitkat:access$000	(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
        //   68: astore 5
        //   70: aload_3
        //   71: invokevirtual 125	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
        //   74: aload_0
        //   75: getfield 29	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   78: aload 5
        //   80: aconst_null
        //   81: invokevirtual 131	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
        //   84: aload_1
        //   85: aload_3
        //   86: invokevirtual 135	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
        //   89: aload_1
        //   90: new 137	java/io/FileOutputStream
        //   93: dup
        //   94: aload_2
        //   95: invokevirtual 143	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
        //   98: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
        //   101: invokevirtual 150	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
        //   104: aload 4
        //   106: iconst_1
        //   107: anewarray 152	android/print/PageRange
        //   110: dup
        //   111: iconst_0
        //   112: getstatic 156	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
        //   115: aastore
        //   116: invokevirtual 162	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
        //   119: aload_1
        //   120: ifnull +7 -> 127
        //   123: aload_1
        //   124: invokevirtual 165	android/print/pdf/PrintedPdfDocument:close	()V
        //   127: aload_2
        //   128: ifnull +7 -> 135
        //   131: aload_2
        //   132: invokevirtual 166	android/os/ParcelFileDescriptor:close	()V
        //   135: return
        //   136: astore_3
        //   137: ldc -88
        //   139: ldc -86
        //   141: aload_3
        //   142: invokestatic 176	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   145: pop
        //   146: aload 4
        //   148: aconst_null
        //   149: invokevirtual 180	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
        //   152: goto -33 -> 119
        //   155: astore_3
        //   156: aload_1
        //   157: ifnull +7 -> 164
        //   160: aload_1
        //   161: invokevirtual 165	android/print/pdf/PrintedPdfDocument:close	()V
        //   164: aload_2
        //   165: ifnull +7 -> 172
        //   168: aload_2
        //   169: invokevirtual 166	android/os/ParcelFileDescriptor:close	()V
        //   172: aload_3
        //   173: athrow
        //   174: astore_1
        //   175: return
        //   176: astore_1
        //   177: goto -5 -> 172
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	180	0	this	1
        //   0	180	1	paramAnonymousArrayOfPageRange	android.print.PageRange[]
        //   0	180	2	paramAnonymousParcelFileDescriptor	android.os.ParcelFileDescriptor
        //   0	180	3	paramAnonymousCancellationSignal	CancellationSignal
        //   0	180	4	paramAnonymousWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
        //   39	40	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   89	119	136	java/io/IOException
        //   19	89	155	finally
        //   89	119	155	finally
        //   137	152	155	finally
        //   131	135	174	java/io/IOException
        //   168	172	176	java/io/IOException
      }
    }, (PrintAttributes)localObject);
  }
  
  public void printBitmap(final String paramString, final Uri paramUri, final OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    paramUri = new PrintDocumentAdapter()
    {
      AsyncTask<Uri, Boolean, Bitmap> loadBitmap;
      private PrintAttributes mAttributes;
      Bitmap mBitmap = null;
      
      private void cancelLoad()
      {
        synchronized (PrintHelperKitkat.this.mLock)
        {
          if (PrintHelperKitkat.this.mDecodeOptions != null)
          {
            PrintHelperKitkat.this.mDecodeOptions.requestCancelDecode();
            PrintHelperKitkat.this.mDecodeOptions = null;
          }
          return;
        }
      }
      
      public void onFinish()
      {
        super.onFinish();
        cancelLoad();
        this.loadBitmap.cancel(true);
        if (paramOnPrintFinishCallback != null) {
          paramOnPrintFinishCallback.onFinish();
        }
      }
      
      public void onLayout(final PrintAttributes paramAnonymousPrintAttributes1, final PrintAttributes paramAnonymousPrintAttributes2, final CancellationSignal paramAnonymousCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        boolean bool = true;
        if (paramAnonymousCancellationSignal.isCanceled())
        {
          paramAnonymousLayoutResultCallback.onLayoutCancelled();
          this.mAttributes = paramAnonymousPrintAttributes2;
          return;
        }
        if (this.mBitmap != null)
        {
          paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
          if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
          for (;;)
          {
            paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
            return;
            bool = false;
          }
        }
        this.loadBitmap = new AsyncTask()
        {
          protected Bitmap doInBackground(Uri... paramAnonymous2VarArgs)
          {
            try
            {
              paramAnonymous2VarArgs = PrintHelperKitkat.this.loadConstrainedBitmap(PrintHelperKitkat.2.this.val$imageFile, 3500);
              return paramAnonymous2VarArgs;
            }
            catch (FileNotFoundException paramAnonymous2VarArgs) {}
            return null;
          }
          
          protected void onCancelled(Bitmap paramAnonymous2Bitmap)
          {
            paramAnonymousLayoutResultCallback.onLayoutCancelled();
          }
          
          protected void onPostExecute(Bitmap paramAnonymous2Bitmap)
          {
            boolean bool = true;
            super.onPostExecute(paramAnonymous2Bitmap);
            PrintHelperKitkat.2.this.mBitmap = paramAnonymous2Bitmap;
            if (paramAnonymous2Bitmap != null)
            {
              paramAnonymous2Bitmap = new PrintDocumentInfo.Builder(PrintHelperKitkat.2.this.val$jobName).setContentType(1).setPageCount(1).build();
              if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
              for (;;)
              {
                paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymous2Bitmap, bool);
                return;
                bool = false;
              }
            }
            paramAnonymousLayoutResultCallback.onLayoutFailed(null);
          }
          
          protected void onPreExecute()
          {
            paramAnonymousCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
            {
              public void onCancel()
              {
                PrintHelperKitkat.2.this.cancelLoad();
                PrintHelperKitkat.2.1.this.cancel(false);
              }
            });
          }
        };
        this.loadBitmap.execute(new Uri[0]);
        this.mAttributes = paramAnonymousPrintAttributes2;
      }
      
      /* Error */
      public void onWrite(android.print.PageRange[] paramAnonymousArrayOfPageRange, android.os.ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        // Byte code:
        //   0: new 136	android/print/pdf/PrintedPdfDocument
        //   3: dup
        //   4: aload_0
        //   5: getfield 34	android/support/v4/print/PrintHelperKitkat$2:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   8: getfield 140	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
        //   11: aload_0
        //   12: getfield 95	android/support/v4/print/PrintHelperKitkat$2:mAttributes	Landroid/print/PrintAttributes;
        //   15: invokespecial 143	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
        //   18: astore_1
        //   19: aload_1
        //   20: iconst_1
        //   21: invokevirtual 147	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
        //   24: astore_3
        //   25: new 149	android/graphics/RectF
        //   28: dup
        //   29: aload_3
        //   30: invokevirtual 155	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
        //   33: invokevirtual 161	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
        //   36: invokespecial 164	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
        //   39: astore 5
        //   41: aload_0
        //   42: getfield 34	android/support/v4/print/PrintHelperKitkat$2:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   45: aload_0
        //   46: getfield 47	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   49: invokevirtual 170	android/graphics/Bitmap:getWidth	()I
        //   52: aload_0
        //   53: getfield 47	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   56: invokevirtual 173	android/graphics/Bitmap:getHeight	()I
        //   59: aload 5
        //   61: aload_0
        //   62: getfield 42	android/support/v4/print/PrintHelperKitkat$2:val$fittingMode	I
        //   65: invokestatic 177	android/support/v4/print/PrintHelperKitkat:access$000	(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
        //   68: astore 5
        //   70: aload_3
        //   71: invokevirtual 181	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
        //   74: aload_0
        //   75: getfield 47	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   78: aload 5
        //   80: aconst_null
        //   81: invokevirtual 187	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
        //   84: aload_1
        //   85: aload_3
        //   86: invokevirtual 191	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
        //   89: aload_1
        //   90: new 193	java/io/FileOutputStream
        //   93: dup
        //   94: aload_2
        //   95: invokevirtual 199	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
        //   98: invokespecial 202	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
        //   101: invokevirtual 206	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
        //   104: aload 4
        //   106: iconst_1
        //   107: anewarray 208	android/print/PageRange
        //   110: dup
        //   111: iconst_0
        //   112: getstatic 212	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
        //   115: aastore
        //   116: invokevirtual 218	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
        //   119: aload_1
        //   120: ifnull +7 -> 127
        //   123: aload_1
        //   124: invokevirtual 221	android/print/pdf/PrintedPdfDocument:close	()V
        //   127: aload_2
        //   128: ifnull +7 -> 135
        //   131: aload_2
        //   132: invokevirtual 222	android/os/ParcelFileDescriptor:close	()V
        //   135: return
        //   136: astore_3
        //   137: ldc -32
        //   139: ldc -30
        //   141: aload_3
        //   142: invokestatic 232	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   145: pop
        //   146: aload 4
        //   148: aconst_null
        //   149: invokevirtual 236	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
        //   152: goto -33 -> 119
        //   155: astore_3
        //   156: aload_1
        //   157: ifnull +7 -> 164
        //   160: aload_1
        //   161: invokevirtual 221	android/print/pdf/PrintedPdfDocument:close	()V
        //   164: aload_2
        //   165: ifnull +7 -> 172
        //   168: aload_2
        //   169: invokevirtual 222	android/os/ParcelFileDescriptor:close	()V
        //   172: aload_3
        //   173: athrow
        //   174: astore_1
        //   175: return
        //   176: astore_1
        //   177: goto -5 -> 172
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	180	0	this	2
        //   0	180	1	paramAnonymousArrayOfPageRange	android.print.PageRange[]
        //   0	180	2	paramAnonymousParcelFileDescriptor	android.os.ParcelFileDescriptor
        //   0	180	3	paramAnonymousCancellationSignal	CancellationSignal
        //   0	180	4	paramAnonymousWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
        //   39	40	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   89	119	136	java/io/IOException
        //   19	89	155	finally
        //   89	119	155	finally
        //   137	152	155	finally
        //   131	135	174	java/io/IOException
        //   168	172	176	java/io/IOException
      }
    };
    paramOnPrintFinishCallback = (PrintManager)this.mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(this.mColorMode);
    if (this.mOrientation == 1) {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    for (;;)
    {
      paramOnPrintFinishCallback.print(paramString, paramUri, localBuilder.build());
      return;
      if (this.mOrientation == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
  
  public static abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\android\support\v4\print\PrintHelperKitkat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */