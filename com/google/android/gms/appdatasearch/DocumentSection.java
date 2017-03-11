package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  public static final int zzQh = Integer.parseInt("-1");
  private static final RegisterSectionInfo zzQi = new RegisterSectionInfo.zza("SsbContext").zzM(true).zzbA("blob").zzlt();
  final int mVersionCode;
  public final String zzQj;
  final RegisterSectionInfo zzQk;
  public final int zzQl;
  public final byte[] zzQm;
  
  DocumentSection(int paramInt1, String paramString, RegisterSectionInfo paramRegisterSectionInfo, int paramInt2, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == zzQh) || (zzh.zzak(paramInt2) != null)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Invalid section type " + paramInt2);
      this.mVersionCode = paramInt1;
      this.zzQj = paramString;
      this.zzQk = paramRegisterSectionInfo;
      this.zzQl = paramInt2;
      this.zzQm = paramArrayOfByte;
      paramString = zzlq();
      if (paramString == null) {
        break;
      }
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public DocumentSection(String paramString, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, paramString, paramRegisterSectionInfo, zzQh, null);
  }
  
  public DocumentSection(String paramString1, RegisterSectionInfo paramRegisterSectionInfo, String paramString2)
  {
    this(1, paramString1, paramRegisterSectionInfo, zzh.zzbz(paramString2), null);
  }
  
  public DocumentSection(byte[] paramArrayOfByte, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, null, paramRegisterSectionInfo, zzQh, paramArrayOfByte);
  }
  
  public static DocumentSection zzh(byte[] paramArrayOfByte)
  {
    return new DocumentSection(paramArrayOfByte, zzQi);
  }
  
  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public RegisterSectionInfo zzlp()
  {
    return this.zzQk;
  }
  
  public String zzlq()
  {
    if ((this.zzQl != zzQh) && (zzh.zzak(this.zzQl) == null)) {
      return "Invalid section type " + this.zzQl;
    }
    if ((this.zzQj != null) && (this.zzQm != null)) {
      return "Both content and blobContent set";
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\DocumentSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */