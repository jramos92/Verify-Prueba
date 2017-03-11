package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
  private final int mVersionCode;
  List<DetectedActivity> zzaEb;
  long zzaEc;
  long zzaEd;
  int zzaEe;
  
  public ActivityRecognitionResult(int paramInt1, List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzaEb = paramList;
    this.zzaEc = paramLong1;
    this.zzaEd = paramLong2;
    this.zzaEe = paramInt2;
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(paramDetectedActivity, paramLong1, paramLong2, 0);
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2, int paramInt)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2, paramInt);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    this(paramList, paramLong1, paramLong2, 0);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = true;
      zzx.zzb(bool1, "Must have at least 1 detected activity");
      if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Must set times");
      this.mVersionCode = 2;
      this.zzaEb = paramList;
      this.zzaEc = paramLong1;
      this.zzaEd = paramLong2;
      this.zzaEe = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    paramIntent = paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    if ((paramIntent instanceof byte[]))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall((byte[])paramIntent, 0, ((byte[])paramIntent).length);
      localParcel.setDataPosition(0);
      return CREATOR.createFromParcel(localParcel);
    }
    if ((paramIntent instanceof ActivityRecognitionResult)) {
      return (ActivityRecognitionResult)paramIntent;
    }
    return null;
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ActivityRecognitionResult)paramObject;
    } while ((this.zzaEc == ((ActivityRecognitionResult)paramObject).zzaEc) && (this.zzaEd == ((ActivityRecognitionResult)paramObject).zzaEd) && (this.zzaEe == ((ActivityRecognitionResult)paramObject).zzaEe) && (zzw.equal(this.zzaEb, ((ActivityRecognitionResult)paramObject).zzaEb)));
    return false;
  }
  
  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = this.zzaEb.iterator();
    while (localIterator.hasNext())
    {
      DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
      if (localDetectedActivity.getType() == paramInt) {
        return localDetectedActivity.getConfidence();
      }
    }
    return 0;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return this.zzaEd;
  }
  
  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)this.zzaEb.get(0);
  }
  
  public List<DetectedActivity> getProbableActivities()
  {
    return this.zzaEb;
  }
  
  public long getTime()
  {
    return this.zzaEc;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzaEc), Long.valueOf(this.zzaEd), Integer.valueOf(this.zzaEe), this.zzaEb });
  }
  
  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + this.zzaEb + ", timeMillis=" + this.zzaEc + ", elapsedRealtimeMillis=" + this.zzaEd + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ActivityRecognitionResultCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\ActivityRecognitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */