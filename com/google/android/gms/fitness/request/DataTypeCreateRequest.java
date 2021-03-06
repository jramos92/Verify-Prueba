package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zznw.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzi();
  private final String mName;
  private final int mVersionCode;
  private final List<Field> zzaqw;
  private final zznw zzasy;
  
  DataTypeCreateRequest(int paramInt, String paramString, List<Field> paramList, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.mName = paramString;
    this.zzaqw = Collections.unmodifiableList(paramList);
    this.zzasy = zznw.zza.zzbw(paramIBinder);
  }
  
  private DataTypeCreateRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), null);
  }
  
  public DataTypeCreateRequest(DataTypeCreateRequest paramDataTypeCreateRequest, zznw paramzznw)
  {
    this(paramDataTypeCreateRequest.mName, paramDataTypeCreateRequest.zzaqw, paramzznw);
  }
  
  public DataTypeCreateRequest(String paramString, List<Field> paramList, zznw paramzznw)
  {
    this.mVersionCode = 3;
    this.mName = paramString;
    this.zzaqw = Collections.unmodifiableList(paramList);
    this.zzasy = paramzznw;
  }
  
  private boolean zzb(DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    return (zzw.equal(this.mName, paramDataTypeCreateRequest.mName)) && (zzw.equal(this.zzaqw, paramDataTypeCreateRequest.zzaqw));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataTypeCreateRequest)) && (zzb((DataTypeCreateRequest)paramObject)));
  }
  
  public List<Field> getFields()
  {
    return this.zzaqw;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mName, this.zzaqw });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("name", this.mName).zzg("fields", this.zzaqw).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasy == null) {
      return null;
    }
    return this.zzasy.asBinder();
  }
  
  public static class Builder
  {
    private String mName;
    private List<Field> zzaqw = new ArrayList();
    
    public Builder addField(Field paramField)
    {
      if (!this.zzaqw.contains(paramField)) {
        this.zzaqw.add(paramField);
      }
      return this;
    }
    
    public Builder addField(String paramString, int paramInt)
    {
      if ((paramString != null) && (!paramString.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid name specified");
        return addField(Field.zzo(paramString, paramInt));
      }
    }
    
    public DataTypeCreateRequest build()
    {
      boolean bool2 = true;
      if (this.mName != null)
      {
        bool1 = true;
        zzx.zza(bool1, "Must set the name");
        if (this.zzaqw.isEmpty()) {
          break label52;
        }
      }
      label52:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must specify the data fields");
        return new DataTypeCreateRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DataTypeCreateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */