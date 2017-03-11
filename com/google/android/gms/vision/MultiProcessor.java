package com.google.android.gms.vision;

import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MultiProcessor<T>
  implements Detector.Processor<T>
{
  private Factory<T> zzbbs;
  private SparseArray<MultiProcessor<T>.zza> zzbbt = new SparseArray();
  private int zzbbu = 3;
  
  private void zza(Detector.Detections<T> paramDetections)
  {
    paramDetections = paramDetections.getDetectedItems();
    int i = 0;
    while (i < paramDetections.size())
    {
      int j = paramDetections.keyAt(i);
      Object localObject = paramDetections.valueAt(i);
      if (this.zzbbt.get(j) == null)
      {
        zza localzza = new zza(null);
        zza.zza(localzza, this.zzbbs.create(localObject));
        zza.zza(localzza).onNewItem(j, localObject);
        this.zzbbt.append(j, localzza);
      }
      i += 1;
    }
  }
  
  private void zzb(Detector.Detections<T> paramDetections)
  {
    Object localObject = paramDetections.getDetectedItems();
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < this.zzbbt.size())
    {
      int j = this.zzbbt.keyAt(i);
      zza localzza;
      if (((SparseArray)localObject).get(j) == null)
      {
        localzza = (zza)this.zzbbt.valueAt(i);
        zza.zzb(localzza);
        if (zza.zzc(localzza) < this.zzbbu) {
          break label104;
        }
        zza.zza(localzza).onDone();
        localHashSet.add(Integer.valueOf(j));
      }
      for (;;)
      {
        i += 1;
        break;
        label104:
        zza.zza(localzza).onMissing(paramDetections);
      }
    }
    paramDetections = localHashSet.iterator();
    while (paramDetections.hasNext())
    {
      localObject = (Integer)paramDetections.next();
      this.zzbbt.delete(((Integer)localObject).intValue());
    }
  }
  
  private void zzc(Detector.Detections<T> paramDetections)
  {
    SparseArray localSparseArray = paramDetections.getDetectedItems();
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      Object localObject = localSparseArray.valueAt(i);
      zza localzza = (zza)this.zzbbt.get(j);
      zza.zza(localzza, 0);
      zza.zza(localzza).onUpdate(paramDetections, localObject);
      i += 1;
    }
  }
  
  public void receiveDetections(Detector.Detections<T> paramDetections)
  {
    zza(paramDetections);
    zzb(paramDetections);
    zzc(paramDetections);
  }
  
  public void release()
  {
    int i = 0;
    while (i < this.zzbbt.size())
    {
      zza.zza((zza)this.zzbbt.valueAt(i)).onDone();
      i += 1;
    }
    this.zzbbt.clear();
  }
  
  public static class Builder<T>
  {
    private MultiProcessor<T> zzbbv = new MultiProcessor(null);
    
    public Builder(MultiProcessor.Factory<T> paramFactory)
    {
      if (paramFactory == null) {
        throw new IllegalArgumentException("No factory supplied.");
      }
      MultiProcessor.zza(this.zzbbv, paramFactory);
    }
    
    public MultiProcessor<T> build()
    {
      return this.zzbbv;
    }
    
    public Builder<T> setMaxGapFrames(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("Invalid max gap: " + paramInt);
      }
      MultiProcessor.zza(this.zzbbv, paramInt);
      return this;
    }
  }
  
  public static abstract interface Factory<T>
  {
    public abstract Tracker<T> create(T paramT);
  }
  
  private class zza
  {
    private Tracker<T> zzbbh;
    private int zzbbw = 0;
    
    private zza() {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\MultiProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */