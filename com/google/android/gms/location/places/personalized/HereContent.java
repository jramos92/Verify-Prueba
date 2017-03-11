package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.List;

public class HereContent
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int mVersionCode;
  private final String zzaHW;
  private final List<Action> zzaHX;
  
  HereContent(int paramInt, String paramString, List<Action> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzaHW = paramString;
    this.zzaHX = paramList;
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof HereContent)) {
        return false;
      }
      paramObject = (HereContent)paramObject;
    } while ((zzw.equal(this.zzaHW, ((HereContent)paramObject).zzaHW)) && (zzw.equal(this.zzaHX, ((HereContent)paramObject).zzaHX)));
    return false;
  }
  
  public List<Action> getActions()
  {
    return this.zzaHX;
  }
  
  public String getData()
  {
    return this.zzaHW;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaHW, this.zzaHX });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("data", this.zzaHW).zzg("actions", this.zzaHX).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static final class Action
    implements SafeParcelable
  {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    private final String zzQg;
    private final String zzajf;
    
    Action(int paramInt, String paramString1, String paramString2)
    {
      this.mVersionCode = paramInt;
      this.zzajf = paramString1;
      this.zzQg = paramString2;
    }
    
    public int describeContents()
    {
      zza localzza = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof Action)) {
          return false;
        }
        paramObject = (Action)paramObject;
      } while ((zzw.equal(this.zzajf, ((Action)paramObject).zzajf)) && (zzw.equal(this.zzQg, ((Action)paramObject).zzQg)));
      return false;
    }
    
    public String getTitle()
    {
      return this.zzajf;
    }
    
    public String getUri()
    {
      return this.zzQg;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { this.zzajf, this.zzQg });
    }
    
    public String toString()
    {
      return zzw.zzv(this).zzg("title", this.zzajf).zzg("uri", this.zzQg).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zza localzza = CREATOR;
      zza.zza(this, paramParcel, paramInt);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\personalized\HereContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */