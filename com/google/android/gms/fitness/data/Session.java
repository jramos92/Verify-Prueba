package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.concurrent.TimeUnit;

public class Session
  implements SafeParcelable
{
  public static final Parcelable.Creator<Session> CREATOR = new zzp();
  public static final String EXTRA_SESSION = "vnd.google.fitness.session";
  public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
  private final String mName;
  private final int mVersionCode;
  private final long zzNY;
  private final long zzapN;
  private final int zzapX;
  private final String zzaqY;
  private final String zzaqZ;
  private final Application zzaqk;
  private final Long zzara;
  
  Session(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt2, Application paramApplication, Long paramLong)
  {
    this.mVersionCode = paramInt1;
    this.zzNY = paramLong1;
    this.zzapN = paramLong2;
    this.mName = paramString1;
    this.zzaqY = paramString2;
    this.zzaqZ = paramString3;
    this.zzapX = paramInt2;
    this.zzaqk = paramApplication;
    this.zzara = paramLong;
  }
  
  public Session(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt, Application paramApplication, Long paramLong)
  {
    this(3, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramInt, paramApplication, paramLong);
  }
  
  private Session(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder));
  }
  
  public static Session extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (Session)zzc.zza(paramIntent, "vnd.google.fitness.session", CREATOR);
  }
  
  public static String getMimeType(String paramString)
  {
    return "vnd.google.fitness.session/" + paramString;
  }
  
  private boolean zza(Session paramSession)
  {
    return (this.zzNY == paramSession.zzNY) && (this.zzapN == paramSession.zzapN) && (zzw.equal(this.mName, paramSession.mName)) && (zzw.equal(this.zzaqY, paramSession.zzaqY)) && (zzw.equal(this.zzaqZ, paramSession.zzaqZ)) && (zzw.equal(this.zzaqk, paramSession.zzaqk)) && (this.zzapX == paramSession.zzapX);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Session)) && (zza((Session)paramObject)));
  }
  
  public long getActiveTime(TimeUnit paramTimeUnit)
  {
    if (this.zzara != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Active time is not set");
      return paramTimeUnit.convert(this.zzara.longValue(), TimeUnit.MILLISECONDS);
    }
  }
  
  public String getActivity()
  {
    return FitnessActivities.getName(this.zzapX);
  }
  
  public String getAppPackageName()
  {
    if (this.zzaqk == null) {
      return null;
    }
    return this.zzaqk.getPackageName();
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzapN, TimeUnit.MILLISECONDS);
  }
  
  public String getIdentifier()
  {
    return this.zzaqY;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzNY, TimeUnit.MILLISECONDS);
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasActiveTime()
  {
    return this.zzara != null;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzNY), Long.valueOf(this.zzapN), this.zzaqY });
  }
  
  public boolean isOngoing()
  {
    return this.zzapN == 0L;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("startTime", Long.valueOf(this.zzNY)).zzg("endTime", Long.valueOf(this.zzapN)).zzg("name", this.mName).zzg("identifier", this.zzaqY).zzg("description", this.zzaqZ).zzg("activity", Integer.valueOf(this.zzapX)).zzg("application", this.zzaqk).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
  
  public long zzkX()
  {
    return this.zzNY;
  }
  
  public int zzsg()
  {
    return this.zzapX;
  }
  
  public long zzsi()
  {
    return this.zzapN;
  }
  
  public Application zzsr()
  {
    return this.zzaqk;
  }
  
  public Long zzsz()
  {
    return this.zzara;
  }
  
  public static class Builder
  {
    private String mName = null;
    private long zzNY = 0L;
    private long zzapN = 0L;
    private int zzapX = 4;
    private String zzaqY;
    private String zzaqZ;
    private Application zzaqk;
    private Long zzara;
    
    public Session build()
    {
      boolean bool2 = false;
      boolean bool1;
      StringBuilder localStringBuilder;
      if (this.zzNY > 0L)
      {
        bool1 = true;
        zzx.zza(bool1, "Start time should be specified.");
        if (this.zzapN != 0L)
        {
          bool1 = bool2;
          if (this.zzapN <= this.zzNY) {}
        }
        else
        {
          bool1 = true;
        }
        zzx.zza(bool1, "End time should be later than start time.");
        if (this.zzaqY == null)
        {
          localStringBuilder = new StringBuilder();
          if (this.mName != null) {
            break label111;
          }
        }
      }
      label111:
      for (String str = "";; str = this.mName)
      {
        this.zzaqY = (str + this.zzNY);
        return new Session(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setActiveTime(long paramLong, TimeUnit paramTimeUnit)
    {
      this.zzara = Long.valueOf(paramTimeUnit.toMillis(paramLong));
      return this;
    }
    
    public Builder setActivity(String paramString)
    {
      return zzeH(FitnessActivities.zzcO(paramString));
    }
    
    public Builder setDescription(String paramString)
    {
      if (paramString.length() <= 1000) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Session description cannot exceed %d characters", new Object[] { Integer.valueOf(1000) });
        this.zzaqZ = paramString;
        return this;
      }
    }
    
    public Builder setEndTime(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "End time should be positive.");
        this.zzapN = paramTimeUnit.toMillis(paramLong);
        return this;
      }
    }
    
    public Builder setIdentifier(String paramString)
    {
      if ((paramString != null) && (TextUtils.getTrimmedLength(paramString) > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzaa(bool);
        this.zzaqY = paramString;
        return this;
      }
    }
    
    public Builder setName(String paramString)
    {
      if (paramString.length() <= 100) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Session name cannot exceed %d characters", new Object[] { Integer.valueOf(100) });
        this.mName = paramString;
        return this;
      }
    }
    
    public Builder setStartTime(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Start time should be positive.");
        this.zzNY = paramTimeUnit.toMillis(paramLong);
        return this;
      }
    }
    
    public Builder zzeH(int paramInt)
    {
      this.zzapX = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */