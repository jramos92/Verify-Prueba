package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SessionReadResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SessionReadResult> CREATOR = new zzj();
  private final int mVersionCode;
  private final Status zzSC;
  private final List<Session> zzase;
  private final List<SessionDataSet> zzatm;
  
  SessionReadResult(int paramInt, List<Session> paramList, List<SessionDataSet> paramList1, Status paramStatus)
  {
    this.mVersionCode = paramInt;
    this.zzase = paramList;
    this.zzatm = Collections.unmodifiableList(paramList1);
    this.zzSC = paramStatus;
  }
  
  public SessionReadResult(List<Session> paramList, List<SessionDataSet> paramList1, Status paramStatus)
  {
    this.mVersionCode = 3;
    this.zzase = paramList;
    this.zzatm = Collections.unmodifiableList(paramList1);
    this.zzSC = paramStatus;
  }
  
  public static SessionReadResult zzT(Status paramStatus)
  {
    return new SessionReadResult(new ArrayList(), new ArrayList(), paramStatus);
  }
  
  private boolean zzb(SessionReadResult paramSessionReadResult)
  {
    return (this.zzSC.equals(paramSessionReadResult.zzSC)) && (zzw.equal(this.zzase, paramSessionReadResult.zzase)) && (zzw.equal(this.zzatm, paramSessionReadResult.zzatm));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionReadResult)) && (zzb((SessionReadResult)paramObject)));
  }
  
  public List<DataSet> getDataSet(Session paramSession)
  {
    zzx.zzb(this.zzase.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzatm.iterator();
    while (localIterator.hasNext())
    {
      SessionDataSet localSessionDataSet = (SessionDataSet)localIterator.next();
      if (zzw.equal(paramSession, localSessionDataSet.getSession())) {
        localArrayList.add(localSessionDataSet.zzsA());
      }
    }
    return localArrayList;
  }
  
  public List<DataSet> getDataSet(Session paramSession, DataType paramDataType)
  {
    zzx.zzb(this.zzase.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzatm.iterator();
    while (localIterator.hasNext())
    {
      SessionDataSet localSessionDataSet = (SessionDataSet)localIterator.next();
      if ((zzw.equal(paramSession, localSessionDataSet.getSession())) && (paramDataType.equals(localSessionDataSet.zzsA().getDataType()))) {
        localArrayList.add(localSessionDataSet.zzsA());
      }
    }
    return localArrayList;
  }
  
  public List<Session> getSessions()
  {
    return this.zzase;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzSC, this.zzase, this.zzatm });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", this.zzSC).zzg("sessions", this.zzase).zzg("sessionDataSets", this.zzatm).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public List<SessionDataSet> zztt()
  {
    return this.zzatm;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\SessionReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */