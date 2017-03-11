package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zza();
  String mName;
  private final int mVersionCode;
  String zzUM;
  List<String> zzUN;
  String zzUO;
  Uri zzUP;
  List<WebImage> zzwp;
  
  private ApplicationMetadata()
  {
    this.mVersionCode = 1;
    this.zzwp = new ArrayList();
    this.zzUN = new ArrayList();
  }
  
  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri)
  {
    this.mVersionCode = paramInt;
    this.zzUM = paramString1;
    this.mName = paramString2;
    this.zzwp = paramList;
    this.zzUN = paramList1;
    this.zzUO = paramString3;
    this.zzUP = paramUri;
  }
  
  public boolean areNamespacesSupported(List<String> paramList)
  {
    return (this.zzUN != null) && (this.zzUN.containsAll(paramList));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ApplicationMetadata)) {
        return false;
      }
      paramObject = (ApplicationMetadata)paramObject;
    } while ((zzf.zza(this.zzUM, ((ApplicationMetadata)paramObject).zzUM)) && (zzf.zza(this.zzwp, ((ApplicationMetadata)paramObject).zzwp)) && (zzf.zza(this.mName, ((ApplicationMetadata)paramObject).mName)) && (zzf.zza(this.zzUN, ((ApplicationMetadata)paramObject).zzUN)) && (zzf.zza(this.zzUO, ((ApplicationMetadata)paramObject).zzUO)) && (zzf.zza(this.zzUP, ((ApplicationMetadata)paramObject).zzUP)));
    return false;
  }
  
  public String getApplicationId()
  {
    return this.zzUM;
  }
  
  public List<WebImage> getImages()
  {
    return this.zzwp;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSenderAppIdentifier()
  {
    return this.zzUO;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.zzUM, this.mName, this.zzwp, this.zzUN, this.zzUO, this.zzUP });
  }
  
  public boolean isNamespaceSupported(String paramString)
  {
    return (this.zzUN != null) && (this.zzUN.contains(paramString));
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("applicationId: ").append(this.zzUM).append(", name: ").append(this.mName).append(", images.count: ");
    if (this.zzwp == null)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append(", namespaces.count: ");
      if (this.zzUN != null) {
        break label114;
      }
    }
    label114:
    for (int i = j;; i = this.zzUN.size())
    {
      return i + ", senderAppIdentifier: " + this.zzUO + ", senderAppLaunchUrl: " + this.zzUP;
      i = this.zzwp.size();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public Uri zzmj()
  {
    return this.zzUP;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\ApplicationMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */