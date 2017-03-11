package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.internal.client.BarcodeDetectorOptions;
import com.google.android.gms.vision.barcode.internal.client.zzd;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

public final class BarcodeDetector
  extends Detector<Barcode>
{
  private final zzd zzbby;
  
  private BarcodeDetector()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  private BarcodeDetector(zzd paramzzd)
  {
    this.zzbby = paramzzd;
  }
  
  public SparseArray<Barcode> detect(Frame paramFrame)
  {
    if (paramFrame == null) {
      throw new IllegalArgumentException("No frame supplied.");
    }
    paramFrame.getMetadata();
    Object localObject1 = FrameMetadataParcel.zzc(paramFrame);
    if (paramFrame.getBitmap() != null) {}
    for (paramFrame = this.zzbby.zza(paramFrame.getBitmap(), (FrameMetadataParcel)localObject1);; paramFrame = this.zzbby.zza(paramFrame, (FrameMetadataParcel)localObject1))
    {
      localObject1 = new SparseArray(paramFrame.length);
      int j = paramFrame.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramFrame[i];
        ((SparseArray)localObject1).append(((Barcode)localObject2).rawValue.hashCode(), localObject2);
        i += 1;
      }
      paramFrame = paramFrame.getGrayscaleImageData();
    }
    return (SparseArray<Barcode>)localObject1;
  }
  
  public boolean isOperational()
  {
    return this.zzbby.isOperational();
  }
  
  public static class Builder
  {
    private Context mContext;
    private BarcodeDetectorOptions zzbbz;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.zzbbz = new BarcodeDetectorOptions();
    }
    
    public BarcodeDetector build()
    {
      return new BarcodeDetector(new zzd(this.mContext, this.zzbbz), null);
    }
    
    public Builder setBarcodeFormats(int paramInt)
    {
      this.zzbbz.zzbbA = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\barcode\BarcodeDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */