package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzau;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new zze();
  public static final int RESOURCE_TYPE_FILE = 0;
  public static final int RESOURCE_TYPE_FOLDER = 1;
  public static final int RESOURCE_TYPE_UNKNOWN = -1;
  final int mVersionCode;
  final String zzaiM;
  final long zzaiN;
  final int zzaiO;
  private volatile String zzaiP = null;
  final long zzaiv;
  private volatile String zzaix = null;
  
  DriveId(int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzaiM = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzx.zzaa(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      zzx.zzaa(bool1);
      this.zzaiN = paramLong1;
      this.zzaiv = paramLong2;
      this.zzaiO = paramInt2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    this(1, paramString, paramLong1, paramLong2, paramInt);
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    zzx.zzb(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
    return zzk(Base64.decode(paramString.substring("DriveId:".length()), 10));
  }
  
  public static DriveId zzcB(String paramString)
  {
    zzx.zzw(paramString);
    return new DriveId(paramString, -1L, -1L, -1);
  }
  
  static DriveId zzk(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      zzat localzzat;
      try
      {
        localzzat = zzat.zzl(paramArrayOfByte);
        if ("".equals(localzzat.zzalQ))
        {
          paramArrayOfByte = null;
          return new DriveId(localzzat.versionCode, paramArrayOfByte, localzzat.zzalR, localzzat.zzalO, localzzat.zzalS);
        }
      }
      catch (zzsd paramArrayOfByte)
      {
        throw new IllegalArgumentException();
      }
      paramArrayOfByte = localzzat.zzalQ;
    }
  }
  
  private byte[] zzqR()
  {
    zzau localzzau = new zzau();
    localzzau.zzalR = this.zzaiN;
    localzzau.zzalO = this.zzaiv;
    return zzse.zzf(localzzau);
  }
  
  public DriveFile asDriveFile()
  {
    if (this.zzaiO == 1) {
      throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }
    return new zzw(this);
  }
  
  public DriveFolder asDriveFolder()
  {
    if (this.zzaiO == 0) {
      throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }
    return new zzy(this);
  }
  
  public DriveResource asDriveResource()
  {
    if (this.zzaiO == 1) {
      return asDriveFolder();
    }
    if (this.zzaiO == 0) {
      return asDriveFile();
    }
    return new zzab(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.zzaix == null)
    {
      String str = Base64.encodeToString(zzqL(), 10);
      this.zzaix = ("DriveId:" + str);
    }
    return this.zzaix;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      return false;
      paramObject = (DriveId)paramObject;
      if (((DriveId)paramObject).zzaiv != this.zzaiv)
      {
        zzz.zzy("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((((DriveId)paramObject).zzaiN == -1L) && (this.zzaiN == -1L)) {
        return ((DriveId)paramObject).zzaiM.equals(this.zzaiM);
      }
      if ((this.zzaiM == null) || (((DriveId)paramObject).zzaiM == null))
      {
        if (((DriveId)paramObject).zzaiN == this.zzaiN) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    } while (((DriveId)paramObject).zzaiN != this.zzaiN);
    if (((DriveId)paramObject).zzaiM.equals(this.zzaiM)) {
      return true;
    }
    zzz.zzy("DriveId", "Unexpected unequal resourceId for same DriveId object.");
    return false;
  }
  
  public String getResourceId()
  {
    return this.zzaiM;
  }
  
  public int getResourceType()
  {
    return this.zzaiO;
  }
  
  public int hashCode()
  {
    if (this.zzaiN == -1L) {
      return this.zzaiM.hashCode();
    }
    return (String.valueOf(this.zzaiv) + String.valueOf(this.zzaiN)).hashCode();
  }
  
  public final String toInvariantString()
  {
    if (this.zzaiP == null) {
      this.zzaiP = Base64.encodeToString(zzqR(), 10);
    }
    return this.zzaiP;
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  final byte[] zzqL()
  {
    zzat localzzat = new zzat();
    localzzat.versionCode = this.mVersionCode;
    if (this.zzaiM == null) {}
    for (String str = "";; str = this.zzaiM)
    {
      localzzat.zzalQ = str;
      localzzat.zzalR = this.zzaiN;
      localzzat.zzalO = this.zzaiv;
      localzzat.zzalS = this.zzaiO;
      return zzse.zzf(localzzat);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */