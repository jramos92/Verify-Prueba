package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public static final PasswordSpecification zzSt = new zza().zzg(12, 16).zzbD("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zzf("abcdefghijkmnopqrstxyz", 1).zzf("ABCDEFGHJKLMNPQRSTXY", 1).zzf("3456789", 1).zzlK();
  public static final PasswordSpecification zzSu = new zza().zzg(12, 16).zzbD("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zzf("abcdefghijklmnopqrstuvwxyz", 1).zzf("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zzf("1234567890", 1).zzlK();
  final int mVersionCode;
  private final int[] zzSA;
  final String zzSv;
  final List<String> zzSw;
  final List<Integer> zzSx;
  final int zzSy;
  final int zzSz;
  private final Random zzts;
  
  PasswordSpecification(int paramInt1, String paramString, List<String> paramList, List<Integer> paramList1, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzSv = paramString;
    this.zzSw = Collections.unmodifiableList(paramList);
    this.zzSx = Collections.unmodifiableList(paramList1);
    this.zzSy = paramInt2;
    this.zzSz = paramInt3;
    this.zzSA = zzlJ();
    this.zzts = new SecureRandom();
  }
  
  private int zza(char paramChar)
  {
    return paramChar - ' ';
  }
  
  private static String zzb(Collection<Character> paramCollection)
  {
    char[] arrayOfChar = new char[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfChar[i] = ((Character)paramCollection.next()).charValue();
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static boolean zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 < paramInt2) || (paramInt1 > paramInt3);
  }
  
  private int[] zzlJ()
  {
    int[] arrayOfInt = new int[95];
    Arrays.fill(arrayOfInt, -1);
    Iterator localIterator = this.zzSw.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
      int k = arrayOfChar.length;
      int j = 0;
      while (j < k)
      {
        arrayOfInt[zza(arrayOfChar[j])] = i;
        j += 1;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public static class zza
  {
    private final TreeSet<Character> zzSB = new TreeSet();
    private final List<String> zzSw = new ArrayList();
    private final List<Integer> zzSx = new ArrayList();
    private int zzSy = 12;
    private int zzSz = 16;
    
    private void zzlL()
    {
      Iterator localIterator = this.zzSx.iterator();
      for (int i = 0; localIterator.hasNext(); i = ((Integer)localIterator.next()).intValue() + i) {}
      if (i > this.zzSz) {
        throw new PasswordSpecification.zzb("required character count cannot be greater than the max password size");
      }
    }
    
    private void zzlM()
    {
      boolean[] arrayOfBoolean = new boolean[95];
      Iterator localIterator = this.zzSw.iterator();
      while (localIterator.hasNext())
      {
        char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
        int j = arrayOfChar.length;
        int i = 0;
        while (i < j)
        {
          char c = arrayOfChar[i];
          if (arrayOfBoolean[(c - ' ')] != 0) {
            throw new PasswordSpecification.zzb("character " + c + " occurs in more than one required character set");
          }
          arrayOfBoolean[(c - ' ')] = true;
          i += 1;
        }
      }
    }
    
    private TreeSet<Character> zzr(String paramString1, String paramString2)
    {
      if (TextUtils.isEmpty(paramString1)) {
        throw new PasswordSpecification.zzb(paramString2 + " cannot be null or empty");
      }
      TreeSet localTreeSet = new TreeSet();
      paramString1 = paramString1.toCharArray();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        char c = paramString1[i];
        if (PasswordSpecification.zzc(c, 32, 126)) {
          throw new PasswordSpecification.zzb(paramString2 + " must only contain ASCII printable characters");
        }
        localTreeSet.add(Character.valueOf(c));
        i += 1;
      }
      return localTreeSet;
    }
    
    public zza zzbD(String paramString)
    {
      this.zzSB.addAll(zzr(paramString, "allowedChars"));
      return this;
    }
    
    public zza zzf(String paramString, int paramInt)
    {
      if (paramInt < 1) {
        throw new PasswordSpecification.zzb("count must be at least 1");
      }
      paramString = zzr(paramString, "requiredChars");
      this.zzSw.add(PasswordSpecification.zzc(paramString));
      this.zzSx.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public zza zzg(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 1) {
        throw new PasswordSpecification.zzb("minimumSize must be at least 1");
      }
      if (paramInt1 > paramInt2) {
        throw new PasswordSpecification.zzb("maximumSize must be greater than or equal to minimumSize");
      }
      this.zzSy = paramInt1;
      this.zzSz = paramInt2;
      return this;
    }
    
    public PasswordSpecification zzlK()
    {
      if (this.zzSB.isEmpty()) {
        throw new PasswordSpecification.zzb("no allowed characters specified");
      }
      zzlL();
      zzlM();
      return new PasswordSpecification(1, PasswordSpecification.zzc(this.zzSB), this.zzSw, this.zzSx, this.zzSy, this.zzSz);
    }
  }
  
  public static class zzb
    extends Error
  {
    public zzb(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\credentials\PasswordSpecification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */