package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame
{
  public static final int ROTATION_0 = 0;
  public static final int ROTATION_180 = 2;
  public static final int ROTATION_270 = 3;
  public static final int ROTATION_90 = 1;
  private Bitmap mBitmap = null;
  private Metadata zzbbk = new Metadata();
  private ByteBuffer zzbbl = null;
  
  private ByteBuffer zzEx()
  {
    int i = 0;
    int j = this.mBitmap.getWidth();
    int k = this.mBitmap.getHeight();
    int[] arrayOfInt = new int[j * k];
    this.mBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
    byte[] arrayOfByte = new byte[j * k];
    while (i < arrayOfInt.length)
    {
      arrayOfByte[i] = ((byte)(int)(Color.red(arrayOfInt[i]) * 0.299F + Color.green(arrayOfInt[i]) * 0.587F + Color.blue(arrayOfInt[i]) * 0.114F));
      i += 1;
    }
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public ByteBuffer getGrayscaleImageData()
  {
    if (this.mBitmap != null) {
      return zzEx();
    }
    return this.zzbbl;
  }
  
  public Metadata getMetadata()
  {
    return this.zzbbk;
  }
  
  public static class Builder
  {
    private Frame zzbbm = new Frame(null);
    
    public Frame build()
    {
      if ((Frame.zza(this.zzbbm) == null) && (Frame.zzb(this.zzbbm) == null)) {
        throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
      }
      return this.zzbbm;
    }
    
    public Builder setBitmap(Bitmap paramBitmap)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Frame.zza(this.zzbbm, paramBitmap);
      paramBitmap = this.zzbbm.getMetadata();
      Frame.Metadata.zza(paramBitmap, i);
      Frame.Metadata.zzb(paramBitmap, j);
      return this;
    }
    
    public Builder setId(int paramInt)
    {
      Frame.Metadata.zzc(this.zzbbm.getMetadata(), paramInt);
      return this;
    }
    
    public Builder setImageData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramByteBuffer == null) {
        throw new IllegalArgumentException("Null image data supplied.");
      }
      if (paramByteBuffer.capacity() < paramInt1 * paramInt2) {
        throw new IllegalArgumentException("Invalid image data size.");
      }
      switch (paramInt3)
      {
      default: 
        throw new IllegalArgumentException("Unsupported image format: " + paramInt3);
      }
      Frame.zza(this.zzbbm, paramByteBuffer);
      paramByteBuffer = this.zzbbm.getMetadata();
      Frame.Metadata.zza(paramByteBuffer, paramInt1);
      Frame.Metadata.zzb(paramByteBuffer, paramInt2);
      return this;
    }
    
    public Builder setRotation(int paramInt)
    {
      Frame.Metadata.zzd(this.zzbbm.getMetadata(), paramInt);
      return this;
    }
    
    public Builder setTimestampMillis(long paramLong)
    {
      Frame.Metadata.zza(this.zzbbm.getMetadata(), paramLong);
      return this;
    }
  }
  
  public static class Metadata
  {
    private int mId;
    private int zzAF;
    private long zzaAc;
    private int zznQ;
    private int zznR;
    
    public Metadata() {}
    
    public Metadata(Metadata paramMetadata)
    {
      this.zznQ = paramMetadata.getWidth();
      this.zznR = paramMetadata.getHeight();
      this.mId = paramMetadata.getId();
      this.zzaAc = paramMetadata.getTimestampMillis();
      this.zzAF = paramMetadata.getRotation();
    }
    
    public int getHeight()
    {
      return this.zznR;
    }
    
    public int getId()
    {
      return this.mId;
    }
    
    public int getRotation()
    {
      return this.zzAF;
    }
    
    public long getTimestampMillis()
    {
      return this.zzaAc;
    }
    
    public int getWidth()
    {
      return this.zznQ;
    }
    
    public void zzEy()
    {
      if (this.zzAF % 2 != 0)
      {
        int i = this.zznQ;
        this.zznQ = this.zznR;
        this.zznR = i;
      }
      this.zzAF = 0;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */