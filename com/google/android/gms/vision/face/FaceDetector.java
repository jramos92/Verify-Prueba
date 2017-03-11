package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.zza;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public final class FaceDetector
  extends Detector<Face>
{
  public static final int ACCURATE_MODE = 1;
  public static final int ALL_CLASSIFICATIONS = 1;
  public static final int ALL_LANDMARKS = 1;
  public static final int FAST_MODE = 0;
  public static final int NO_CLASSIFICATIONS = 0;
  public static final int NO_LANDMARKS = 0;
  private final zza zzbbK = new zza();
  private final zzg zzbbL;
  private boolean zzbbM = true;
  private final Object zzpd = new Object();
  
  private FaceDetector()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  private FaceDetector(zzg paramzzg)
  {
    this.zzbbL = paramzzg;
  }
  
  public SparseArray<Face> detect(Frame paramFrame)
  {
    if (paramFrame == null) {
      throw new IllegalArgumentException("No frame supplied.");
    }
    Object localObject2 = paramFrame.getGrayscaleImageData();
    synchronized (this.zzpd)
    {
      if (!this.zzbbM) {
        throw new RuntimeException("Cannot use detector after release()");
      }
    }
    paramFrame = this.zzbbL.zzb((ByteBuffer)localObject2, FrameMetadataParcel.zzc(paramFrame));
    ??? = new HashSet();
    localObject2 = new SparseArray(paramFrame.length);
    int i1 = paramFrame.length;
    int j = 0;
    int i = 0;
    while (j < i1)
    {
      Object localObject3 = paramFrame[j];
      int m = ((Face)localObject3).getId();
      int n = Math.max(i, m);
      int k = m;
      i = n;
      if (((Set)???).contains(Integer.valueOf(m)))
      {
        k = n + 1;
        i = k;
      }
      ((Set)???).add(Integer.valueOf(k));
      ((SparseArray)localObject2).append(this.zzbbK.zzjE(k), localObject3);
      j += 1;
    }
    return (SparseArray<Face>)localObject2;
  }
  
  /* Error */
  protected void finalize()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/google/android/gms/vision/face/FaceDetector:zzpd	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 43	com/google/android/gms/vision/face/FaceDetector:zzbbM	Z
    //   11: ifeq +15 -> 26
    //   14: ldc -119
    //   16: ldc -117
    //   18: invokestatic 145	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   21: pop
    //   22: aload_0
    //   23: invokevirtual 148	com/google/android/gms/vision/face/FaceDetector:release	()V
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: invokespecial 150	java/lang/Object:finalize	()V
    //   32: return
    //   33: astore_2
    //   34: aload_1
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_1
    //   39: aload_0
    //   40: invokespecial 150	java/lang/Object:finalize	()V
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	FaceDetector
    //   38	6	1	localObject2	Object
    //   33	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	33	finally
    //   26	28	33	finally
    //   34	36	33	finally
    //   0	7	38	finally
    //   36	38	38	finally
  }
  
  public boolean isOperational()
  {
    return this.zzbbL.isOperational();
  }
  
  public void release()
  {
    synchronized (this.zzpd)
    {
      if (!this.zzbbM) {
        return;
      }
      this.zzbbL.zzEA();
      this.zzbbM = false;
      return;
    }
  }
  
  public boolean setFocus(int paramInt)
  {
    paramInt = this.zzbbK.zzjF(paramInt);
    synchronized (this.zzpd)
    {
      if (!this.zzbbM) {
        throw new RuntimeException("Cannot use detector after release()");
      }
    }
    boolean bool = this.zzbbL.zzjW(paramInt);
    return bool;
  }
  
  public static class Builder
  {
    private final Context mContext;
    private int zzaiz = 0;
    private int zzbbN = 0;
    private boolean zzbbO = false;
    private int zzbbP = 0;
    private boolean zzbbQ = true;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public FaceDetector build()
    {
      FaceSettingsParcel localFaceSettingsParcel = new FaceSettingsParcel();
      localFaceSettingsParcel.mode = this.zzaiz;
      localFaceSettingsParcel.zzbbX = this.zzbbN;
      localFaceSettingsParcel.zzbbY = this.zzbbP;
      localFaceSettingsParcel.zzbbZ = this.zzbbO;
      localFaceSettingsParcel.zzbca = this.zzbbQ;
      return new FaceDetector(new zzg(this.mContext, localFaceSettingsParcel), null);
    }
    
    public Builder setClassificationType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException("Invalid classification type: " + paramInt);
      }
      this.zzbbP = paramInt;
      return this;
    }
    
    public Builder setLandmarkType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException("Invalid landmark type: " + paramInt);
      }
      this.zzbbN = paramInt;
      return this;
    }
    
    public Builder setMode(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Invalid mode: " + paramInt);
      }
      this.zzaiz = paramInt;
      return this;
    }
    
    public Builder setProminentFaceOnly(boolean paramBoolean)
    {
      this.zzbbO = paramBoolean;
      return this;
    }
    
    public Builder setTrackingEnabled(boolean paramBoolean)
    {
      this.zzbbQ = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\face\FaceDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */