package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzox.zza;
import com.google.android.gms.internal.zzox.zza.zza;
import com.google.android.gms.internal.zzse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo
  implements SafeParcelable
{
  public static final zzj CREATOR = new zzj();
  final int mVersionCode;
  final DocumentId zzQU;
  final long zzQV;
  int zzQW;
  final DocumentContents zzQX;
  final boolean zzQY;
  int zzQZ;
  int zzRa;
  public final String zzub;
  
  UsageInfo(int paramInt1, DocumentId paramDocumentId, long paramLong, int paramInt2, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzQU = paramDocumentId;
    this.zzQV = paramLong;
    this.zzQW = paramInt2;
    this.zzub = paramString;
    this.zzQX = paramDocumentContents;
    this.zzQY = paramBoolean;
    this.zzQZ = paramInt3;
    this.zzRa = paramInt4;
  }
  
  private UsageInfo(DocumentId paramDocumentId, long paramLong, int paramInt1, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this(1, paramDocumentId, paramLong, paramInt1, paramString, paramDocumentContents, paramBoolean, paramInt2, paramInt3);
  }
  
  public UsageInfo(String paramString1, Intent paramIntent, String paramString2, Uri paramUri, String paramString3, List<AppIndexApi.AppIndexingLink> paramList, int paramInt)
  {
    this(1, zza(paramString1, paramIntent), System.currentTimeMillis(), 0, null, zza(paramIntent, paramString2, paramUri, paramString3, paramList).zzlo(), false, -1, paramInt);
  }
  
  public static DocumentContents.zza zza(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    DocumentContents.zza localzza = new DocumentContents.zza();
    localzza.zza(zzbC(paramString1));
    if (paramUri != null) {
      localzza.zza(zzi(paramUri));
    }
    if (paramList != null) {
      localzza.zza(zzo(paramList));
    }
    paramString1 = paramIntent.getAction();
    if (paramString1 != null) {
      localzza.zza(zzq("intent_action", paramString1));
    }
    paramString1 = paramIntent.getDataString();
    if (paramString1 != null) {
      localzza.zza(zzq("intent_data", paramString1));
    }
    paramString1 = paramIntent.getComponent();
    if (paramString1 != null) {
      localzza.zza(zzq("intent_activity", paramString1.getClassName()));
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getString("intent_extra_data_key");
      if (paramIntent != null) {
        localzza.zza(zzq("intent_extra_data", paramIntent));
      }
    }
    return localzza.zzbx(paramString2).zzK(true);
  }
  
  public static DocumentId zza(String paramString, Intent paramIntent)
  {
    return zzp(paramString, zzg(paramIntent));
  }
  
  private static DocumentSection zzbC(String paramString)
  {
    return new DocumentSection(paramString, new RegisterSectionInfo.zza("title").zzal(1).zzN(true).zzbB("name").zzlt(), "text1");
  }
  
  private static String zzg(Intent paramIntent)
  {
    paramIntent = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(paramIntent.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      throw new IllegalStateException(paramIntent);
    }
  }
  
  private static DocumentSection zzi(Uri paramUri)
  {
    return new DocumentSection(paramUri.toString(), new RegisterSectionInfo.zza("web_url").zzal(4).zzM(true).zzbB("url").zzlt());
  }
  
  private static DocumentSection zzo(List<AppIndexApi.AppIndexingLink> paramList)
  {
    zzox.zza localzza = new zzox.zza();
    zzox.zza.zza[] arrayOfzza = new zzox.zza.zza[paramList.size()];
    int i = 0;
    while (i < arrayOfzza.length)
    {
      arrayOfzza[i] = new zzox.zza.zza();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfzza[i].zzaCW = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfzza[i].viewId = localAppIndexingLink.viewId;
      if (localAppIndexingLink.webUrl != null) {
        arrayOfzza[i].zzaCX = localAppIndexingLink.webUrl.toString();
      }
      i += 1;
    }
    localzza.zzaCU = arrayOfzza;
    return new DocumentSection(zzse.zzf(localzza), new RegisterSectionInfo.zza("outlinks").zzM(true).zzbB(".private:outLinks").zzbA("blob").zzlt());
  }
  
  private static DocumentId zzp(String paramString1, String paramString2)
  {
    return new DocumentId(paramString1, "", paramString2);
  }
  
  private static DocumentSection zzq(String paramString1, String paramString2)
  {
    return new DocumentSection(paramString2, new RegisterSectionInfo.zza(paramString1).zzM(true).zzlt(), paramString1);
  }
  
  public int describeContents()
  {
    zzj localzzj = CREATOR;
    return 0;
  }
  
  public String toString()
  {
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[] { this.zzQU, Long.valueOf(this.zzQV), Integer.valueOf(this.zzQW), Integer.valueOf(this.zzRa) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj localzzj = CREATOR;
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public DocumentContents zzlu()
  {
    return this.zzQX;
  }
  
  public static final class zza
  {
    private String zzLe;
    private DocumentId zzQU;
    private long zzQV = -1L;
    private int zzQW = -1;
    private DocumentContents zzQX;
    private boolean zzQY = false;
    private int zzQZ = -1;
    private int zzRa = 0;
    
    public zza zzO(boolean paramBoolean)
    {
      this.zzQY = paramBoolean;
      return this;
    }
    
    public zza zza(DocumentContents paramDocumentContents)
    {
      this.zzQX = paramDocumentContents;
      return this;
    }
    
    public zza zza(DocumentId paramDocumentId)
    {
      this.zzQU = paramDocumentId;
      return this;
    }
    
    public zza zzan(int paramInt)
    {
      this.zzQW = paramInt;
      return this;
    }
    
    public zza zzao(int paramInt)
    {
      this.zzRa = paramInt;
      return this;
    }
    
    public UsageInfo zzlv()
    {
      return new UsageInfo(this.zzQU, this.zzQV, this.zzQW, this.zzLe, this.zzQX, this.zzQY, this.zzQZ, this.zzRa, null);
    }
    
    public zza zzw(long paramLong)
    {
      this.zzQV = paramLong;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\UsageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */