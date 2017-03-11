package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent
  extends zzf
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
  final int mVersionCode;
  private final long zzahn;
  private int zzaho;
  private final String zzahp;
  private final String zzahq;
  private final String zzahr;
  private final String zzahs;
  private final String zzaht;
  private final String zzahu;
  private final long zzahv;
  private final long zzahw;
  private long zzahx;
  
  ConnectionEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this.mVersionCode = paramInt1;
    this.zzahn = paramLong1;
    this.zzaho = paramInt2;
    this.zzahp = paramString1;
    this.zzahq = paramString2;
    this.zzahr = paramString3;
    this.zzahs = paramString4;
    this.zzahx = -1L;
    this.zzaht = paramString5;
    this.zzahu = paramString6;
    this.zzahv = paramLong2;
    this.zzahw = paramLong3;
  }
  
  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEventType()
  {
    return this.zzaho;
  }
  
  public long getTimeMillis()
  {
    return this.zzahn;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzpX()
  {
    return this.zzahp;
  }
  
  public String zzpY()
  {
    return this.zzahq;
  }
  
  public String zzpZ()
  {
    return this.zzahr;
  }
  
  public String zzqa()
  {
    return this.zzahs;
  }
  
  public String zzqb()
  {
    return this.zzaht;
  }
  
  public String zzqc()
  {
    return this.zzahu;
  }
  
  public long zzqd()
  {
    return this.zzahx;
  }
  
  public long zzqe()
  {
    return this.zzahw;
  }
  
  public long zzqf()
  {
    return this.zzahv;
  }
  
  public String zzqg()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("\t").append(zzpX()).append("/").append(zzpY()).append("\t").append(zzpZ()).append("/").append(zzqa()).append("\t");
    if (this.zzaht == null) {}
    for (String str = "";; str = this.zzaht) {
      return str + "\t" + zzqe();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\stats\ConnectionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */