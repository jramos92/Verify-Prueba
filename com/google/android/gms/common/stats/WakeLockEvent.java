package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent
  extends zzf
  implements SafeParcelable
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzh();
  private final long mTimeout;
  final int mVersionCode;
  private final long zzahn;
  private int zzaho;
  private final long zzahv;
  private long zzahx;
  private final String zzaia;
  private final int zzaib;
  private final List<String> zzaic;
  private final String zzaid;
  private int zzaie;
  private final String zzaif;
  private final String zzaig;
  private final float zzaih;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3)
  {
    this.mVersionCode = paramInt1;
    this.zzahn = paramLong1;
    this.zzaho = paramInt2;
    this.zzaia = paramString1;
    this.zzaif = paramString3;
    this.zzaib = paramInt3;
    this.zzahx = -1L;
    this.zzaic = paramList;
    this.zzaid = paramString2;
    this.zzahv = paramLong2;
    this.zzaie = paramInt4;
    this.zzaig = paramString4;
    this.zzaih = paramFloat;
    this.mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3)
  {
    this(1, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3);
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
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzqc()
  {
    return this.zzaid;
  }
  
  public long zzqd()
  {
    return this.zzahx;
  }
  
  public long zzqf()
  {
    return this.zzahv;
  }
  
  public String zzqg()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("\t").append(zzqj()).append("\t").append(zzql()).append("\t");
    if (zzqm() == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str).append("\t").append(zzqn()).append("\t");
      if (zzqk() != null) {
        break label135;
      }
      str = "";
      label80:
      localStringBuilder = localStringBuilder.append(str).append("\t");
      if (zzqo() != null) {
        break label143;
      }
    }
    label135:
    label143:
    for (String str = "";; str = zzqo())
    {
      return str + "\t" + zzqp();
      str = TextUtils.join(",", zzqm());
      break;
      str = zzqk();
      break label80;
    }
  }
  
  public String zzqj()
  {
    return this.zzaia;
  }
  
  public String zzqk()
  {
    return this.zzaif;
  }
  
  public int zzql()
  {
    return this.zzaib;
  }
  
  public List<String> zzqm()
  {
    return this.zzaic;
  }
  
  public int zzqn()
  {
    return this.zzaie;
  }
  
  public String zzqo()
  {
    return this.zzaig;
  }
  
  public float zzqp()
  {
    return this.zzaih;
  }
  
  public long zzqq()
  {
    return this.mTimeout;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\stats\WakeLockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */