package com.google.android.gms.vision;

import android.util.SparseArray;

public abstract class Detector<T>
{
  private Object zzbbc = new Object();
  private Processor<T> zzbbd;
  
  public abstract SparseArray<T> detect(Frame paramFrame);
  
  public boolean isOperational()
  {
    return true;
  }
  
  public void receiveFrame(Frame paramFrame)
  {
    synchronized (this.zzbbc)
    {
      if (this.zzbbd == null) {
        throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
      }
    }
    Frame.Metadata localMetadata = new Frame.Metadata(paramFrame.getMetadata());
    localMetadata.zzEy();
    paramFrame = new Detections(detect(paramFrame), localMetadata, isOperational());
    this.zzbbd.receiveDetections(paramFrame);
  }
  
  public void release()
  {
    synchronized (this.zzbbc)
    {
      if (this.zzbbd != null)
      {
        this.zzbbd.release();
        this.zzbbd = null;
      }
      return;
    }
  }
  
  public boolean setFocus(int paramInt)
  {
    return true;
  }
  
  public void setProcessor(Processor<T> paramProcessor)
  {
    this.zzbbd = paramProcessor;
  }
  
  public static class Detections<T>
  {
    private SparseArray<T> zzbbe;
    private Frame.Metadata zzbbf;
    private boolean zzbbg;
    
    public Detections(SparseArray<T> paramSparseArray, Frame.Metadata paramMetadata, boolean paramBoolean)
    {
      this.zzbbe = paramSparseArray;
      this.zzbbf = paramMetadata;
      this.zzbbg = paramBoolean;
    }
    
    public boolean detectorIsOperational()
    {
      return this.zzbbg;
    }
    
    public SparseArray<T> getDetectedItems()
    {
      return this.zzbbe;
    }
    
    public Frame.Metadata getFrameMetadata()
    {
      return this.zzbbf;
    }
  }
  
  public static abstract interface Processor<T>
  {
    public abstract void receiveDetections(Detector.Detections<T> paramDetections);
    
    public abstract void release();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */