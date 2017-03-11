package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class DocumentContents
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final Account account;
  final int mVersionCode;
  final DocumentSection[] zzPX;
  public final String zzPY;
  public final boolean zzPZ;
  
  DocumentContents(int paramInt, DocumentSection[] paramArrayOfDocumentSection, String paramString, boolean paramBoolean, Account paramAccount)
  {
    this.mVersionCode = paramInt;
    this.zzPX = paramArrayOfDocumentSection;
    this.zzPY = paramString;
    this.zzPZ = paramBoolean;
    this.account = paramAccount;
  }
  
  DocumentContents(String paramString, boolean paramBoolean, Account paramAccount, DocumentSection... paramVarArgs)
  {
    this(1, paramVarArgs, paramString, paramBoolean, paramAccount);
    paramString = new BitSet(zzh.zzls());
    int i = 0;
    while (i < paramVarArgs.length)
    {
      int j = paramVarArgs[i].zzQl;
      if (j != -1)
      {
        if (paramString.get(j)) {
          throw new IllegalArgumentException("Duplicate global search section type " + zzh.zzak(j));
        }
        paramString.set(j);
      }
      i += 1;
    }
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public DocumentSection zzbw(String paramString)
  {
    zzx.zzcr(paramString);
    if (this.zzPX == null) {}
    for (;;)
    {
      return null;
      DocumentSection[] arrayOfDocumentSection = this.zzPX;
      int j = arrayOfDocumentSection.length;
      int i = 0;
      while (i < j)
      {
        DocumentSection localDocumentSection = arrayOfDocumentSection[i];
        if (paramString.equals(localDocumentSection.zzlp().name)) {
          return localDocumentSection;
        }
        i += 1;
      }
    }
  }
  
  public String zzln()
  {
    DocumentSection localDocumentSection = zzbw("web_url");
    if (localDocumentSection != null) {
      return localDocumentSection.zzQj;
    }
    return null;
  }
  
  public static class zza
  {
    private List<DocumentSection> zzQa;
    private String zzQb;
    private boolean zzQc;
    private Account zzQd;
    
    public zza zzK(boolean paramBoolean)
    {
      this.zzQc = paramBoolean;
      return this;
    }
    
    public zza zza(DocumentSection paramDocumentSection)
    {
      if (this.zzQa == null) {
        this.zzQa = new ArrayList();
      }
      this.zzQa.add(paramDocumentSection);
      return this;
    }
    
    public zza zzb(Account paramAccount)
    {
      this.zzQd = paramAccount;
      return this;
    }
    
    public zza zzbx(String paramString)
    {
      this.zzQb = paramString;
      return this;
    }
    
    public DocumentContents zzlo()
    {
      String str = this.zzQb;
      boolean bool = this.zzQc;
      Account localAccount = this.zzQd;
      if (this.zzQa != null) {}
      for (DocumentSection[] arrayOfDocumentSection = (DocumentSection[])this.zzQa.toArray(new DocumentSection[this.zzQa.size()]);; arrayOfDocumentSection = null) {
        return new DocumentContents(str, bool, localAccount, arrayOfDocumentSection);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\DocumentContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */