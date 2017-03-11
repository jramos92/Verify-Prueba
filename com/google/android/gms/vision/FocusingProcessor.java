package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;

public abstract class FocusingProcessor<T>
  implements Detector.Processor<T>
{
  private Detector<T> zzbaR;
  private Tracker<T> zzbbh;
  private boolean zzbbi = false;
  private int zzbbj;
  
  public FocusingProcessor(Detector<T> paramDetector, Tracker<T> paramTracker)
  {
    this.zzbaR = paramDetector;
    this.zzbbh = paramTracker;
  }
  
  public void receiveDetections(Detector.Detections<T> paramDetections)
  {
    Object localObject1 = paramDetections.getDetectedItems();
    if (((SparseArray)localObject1).size() == 0)
    {
      this.zzbbh.onMissing(paramDetections);
      return;
    }
    if (this.zzbbi)
    {
      Object localObject2 = ((SparseArray)localObject1).get(this.zzbbj);
      if (localObject2 != null)
      {
        this.zzbbh.onUpdate(paramDetections, localObject2);
        return;
      }
      this.zzbbh.onDone();
      this.zzbbi = false;
    }
    int i = selectFocus(paramDetections);
    localObject1 = ((SparseArray)localObject1).get(i);
    if (localObject1 == null)
    {
      Log.w("FocusingProcessor", "Invalid focus selected: " + i);
      return;
    }
    this.zzbbi = true;
    this.zzbbj = i;
    this.zzbaR.setFocus(this.zzbbj);
    this.zzbbh.onNewItem(this.zzbbj, localObject1);
    this.zzbbh.onUpdate(paramDetections, localObject1);
  }
  
  public void release()
  {
    this.zzbbh.onDone();
  }
  
  public abstract int selectFocus(Detector.Detections<T> paramDetections);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\FocusingProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */