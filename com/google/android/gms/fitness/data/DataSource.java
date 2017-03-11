package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;

public class DataSource
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSource> CREATOR = new zzf();
  public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
  public static final int TYPE_DERIVED = 1;
  public static final int TYPE_RAW = 0;
  private final String mName;
  private final int mVersionCode;
  private final int zzWJ;
  private final DataType zzapL;
  private final Device zzaqj;
  private final Application zzaqk;
  private final String zzaql;
  private final String zzaqm;
  
  DataSource(int paramInt1, DataType paramDataType, String paramString1, int paramInt2, Device paramDevice, Application paramApplication, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.zzapL = paramDataType;
    this.zzWJ = paramInt2;
    this.mName = paramString1;
    this.zzaqj = paramDevice;
    this.zzaqk = paramApplication;
    this.zzaql = paramString2;
    this.zzaqm = zzss();
  }
  
  private DataSource(Builder paramBuilder)
  {
    this.mVersionCode = 3;
    this.zzapL = Builder.zza(paramBuilder);
    this.zzWJ = Builder.zzb(paramBuilder);
    this.mName = Builder.zzc(paramBuilder);
    this.zzaqj = Builder.zzd(paramBuilder);
    this.zzaqk = Builder.zze(paramBuilder);
    this.zzaql = Builder.zzf(paramBuilder);
    this.zzaqm = zzss();
  }
  
  public static DataSource extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataSource)zzc.zza(paramIntent, "vnd.google.fitness.data_source", CREATOR);
  }
  
  private String getTypeString()
  {
    switch (this.zzWJ)
    {
    default: 
      throw new IllegalArgumentException("invalid type value");
    case 0: 
      return "raw";
    }
    return "derived";
  }
  
  private boolean zza(DataSource paramDataSource)
  {
    return this.zzaqm.equals(paramDataSource.zzaqm);
  }
  
  private String zzss()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTypeString());
    localStringBuilder.append(":").append(this.zzapL.getName());
    if (this.zzaqk != null) {
      localStringBuilder.append(":").append(this.zzaqk.getPackageName());
    }
    if (this.zzaqj != null) {
      localStringBuilder.append(":").append(this.zzaqj.getStreamIdentifier());
    }
    if (this.zzaql != null) {
      localStringBuilder.append(":").append(this.zzaql);
    }
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataSource)) && (zza((DataSource)paramObject)));
  }
  
  public String getAppPackageName()
  {
    if (this.zzaqk == null) {
      return null;
    }
    return this.zzaqk.getPackageName();
  }
  
  public DataType getDataType()
  {
    return this.zzapL;
  }
  
  public Device getDevice()
  {
    return this.zzaqj;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getStreamIdentifier()
  {
    return this.zzaqm;
  }
  
  public String getStreamName()
  {
    return this.zzaql;
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return this.zzaqm.hashCode();
  }
  
  public String toDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.zzWJ == 0)
    {
      str = "r";
      localStringBuilder = localStringBuilder.append(str).append(":").append(this.zzapL.zzst());
      if (this.zzaqk != null) {
        break label154;
      }
      str = "";
      label49:
      localStringBuilder = localStringBuilder.append(str);
      if (this.zzaqj == null) {
        break label202;
      }
      str = ":" + this.zzaqj.getModel() + ":" + this.zzaqj.getUid();
      label103:
      localStringBuilder = localStringBuilder.append(str);
      if (this.zzaql == null) {
        break label208;
      }
    }
    label154:
    label202:
    label208:
    for (String str = ":" + this.zzaql;; str = "")
    {
      return str;
      str = "d";
      break;
      if (this.zzaqk.equals(Application.zzapS))
      {
        str = ":gms";
        break label49;
      }
      str = ":" + this.zzaqk.getPackageName();
      break label49;
      str = "";
      break label103;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DataSource{");
    localStringBuilder.append(getTypeString());
    if (this.mName != null) {
      localStringBuilder.append(":").append(this.mName);
    }
    if (this.zzaqk != null) {
      localStringBuilder.append(":").append(this.zzaqk);
    }
    if (this.zzaqj != null) {
      localStringBuilder.append(":").append(this.zzaqj);
    }
    if (this.zzaql != null) {
      localStringBuilder.append(":").append(this.zzaql);
    }
    localStringBuilder.append(":").append(this.zzapL);
    return "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public Application zzsr()
  {
    return this.zzaqk;
  }
  
  public static final class Builder
  {
    private String mName;
    private int zzWJ = -1;
    private DataType zzapL;
    private Device zzaqj;
    private Application zzaqk;
    private String zzaql = "";
    
    public DataSource build()
    {
      boolean bool2 = true;
      if (this.zzapL != null)
      {
        bool1 = true;
        zzx.zza(bool1, "Must set data type");
        if (this.zzWJ < 0) {
          break label47;
        }
      }
      label47:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must set data source type");
        return new DataSource(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setAppPackageName(Context paramContext)
    {
      return setAppPackageName(paramContext.getPackageName());
    }
    
    public Builder setAppPackageName(String paramString)
    {
      this.zzaqk = Application.zzcP(paramString);
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.zzapL = paramDataType;
      return this;
    }
    
    public Builder setDevice(Device paramDevice)
    {
      this.zzaqj = paramDevice;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setStreamName(String paramString)
    {
      if (paramString != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid stream name");
        this.zzaql = paramString;
        return this;
      }
    }
    
    public Builder setType(int paramInt)
    {
      this.zzWJ = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\DataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */