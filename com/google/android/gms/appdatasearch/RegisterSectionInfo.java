package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  final int mVersionCode;
  public final String name;
  public final int weight;
  public final String zzQF;
  public final boolean zzQG;
  public final boolean zzQH;
  public final String zzQI;
  public final Feature[] zzQJ;
  final int[] zzQK;
  public final String zzQL;
  
  RegisterSectionInfo(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    this.mVersionCode = paramInt1;
    this.name = paramString1;
    this.zzQF = paramString2;
    this.zzQG = paramBoolean1;
    this.weight = paramInt2;
    this.zzQH = paramBoolean2;
    this.zzQI = paramString3;
    this.zzQJ = paramArrayOfFeature;
    this.zzQK = paramArrayOfInt;
    this.zzQL = paramString4;
  }
  
  RegisterSectionInfo(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOfFeature, paramArrayOfInt, paramString4);
  }
  
  public int describeContents()
  {
    zzi localzzi = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi localzzi = CREATOR;
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public static final class zza
  {
    private final String mName;
    private String zzQM;
    private boolean zzQN;
    private int zzQO;
    private boolean zzQP;
    private String zzQQ;
    private final List<Feature> zzQR;
    private BitSet zzQS;
    private String zzQT;
    
    public zza(String paramString)
    {
      this.mName = paramString;
      this.zzQO = 1;
      this.zzQR = new ArrayList();
    }
    
    public zza zzM(boolean paramBoolean)
    {
      this.zzQN = paramBoolean;
      return this;
    }
    
    public zza zzN(boolean paramBoolean)
    {
      this.zzQP = paramBoolean;
      return this;
    }
    
    public zza zzal(int paramInt)
    {
      if (this.zzQS == null) {
        this.zzQS = new BitSet();
      }
      this.zzQS.set(paramInt);
      return this;
    }
    
    public zza zzbA(String paramString)
    {
      this.zzQM = paramString;
      return this;
    }
    
    public zza zzbB(String paramString)
    {
      this.zzQT = paramString;
      return this;
    }
    
    public RegisterSectionInfo zzlt()
    {
      int i = 0;
      Object localObject = null;
      if (this.zzQS != null)
      {
        int[] arrayOfInt = new int[this.zzQS.cardinality()];
        int j = this.zzQS.nextSetBit(0);
        for (;;)
        {
          localObject = arrayOfInt;
          if (j < 0) {
            break;
          }
          arrayOfInt[i] = j;
          j = this.zzQS.nextSetBit(j + 1);
          i += 1;
        }
      }
      return new RegisterSectionInfo(this.mName, this.zzQM, this.zzQN, this.zzQO, this.zzQP, this.zzQQ, (Feature[])this.zzQR.toArray(new Feature[this.zzQR.size()]), (int[])localObject, this.zzQT);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\RegisterSectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */