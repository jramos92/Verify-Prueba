package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class SearchAdRequestParcel
  implements SafeParcelable
{
  public static final zzae CREATOR = new zzae();
  public final int backgroundColor;
  public final int versionCode;
  public final int zztP;
  public final int zztQ;
  public final int zztR;
  public final int zztS;
  public final int zztT;
  public final int zztU;
  public final int zztV;
  public final String zztW;
  public final int zztX;
  public final String zztY;
  public final int zztZ;
  public final int zzua;
  public final String zzub;
  
  SearchAdRequestParcel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.versionCode = paramInt1;
    this.zztP = paramInt2;
    this.backgroundColor = paramInt3;
    this.zztQ = paramInt4;
    this.zztR = paramInt5;
    this.zztS = paramInt6;
    this.zztT = paramInt7;
    this.zztU = paramInt8;
    this.zztV = paramInt9;
    this.zztW = paramString1;
    this.zztX = paramInt10;
    this.zztY = paramString2;
    this.zztZ = paramInt11;
    this.zzua = paramInt12;
    this.zzub = paramString3;
  }
  
  public SearchAdRequestParcel(SearchAdRequest paramSearchAdRequest)
  {
    this.versionCode = 1;
    this.zztP = paramSearchAdRequest.getAnchorTextColor();
    this.backgroundColor = paramSearchAdRequest.getBackgroundColor();
    this.zztQ = paramSearchAdRequest.getBackgroundGradientBottom();
    this.zztR = paramSearchAdRequest.getBackgroundGradientTop();
    this.zztS = paramSearchAdRequest.getBorderColor();
    this.zztT = paramSearchAdRequest.getBorderThickness();
    this.zztU = paramSearchAdRequest.getBorderType();
    this.zztV = paramSearchAdRequest.getCallButtonColor();
    this.zztW = paramSearchAdRequest.getCustomChannels();
    this.zztX = paramSearchAdRequest.getDescriptionTextColor();
    this.zztY = paramSearchAdRequest.getFontFace();
    this.zztZ = paramSearchAdRequest.getHeaderTextColor();
    this.zzua = paramSearchAdRequest.getHeaderTextSize();
    this.zzub = paramSearchAdRequest.getQuery();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\SearchAdRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */