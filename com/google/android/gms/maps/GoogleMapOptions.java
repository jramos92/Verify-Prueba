package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  private Boolean zzaIA;
  private Boolean zzaIB;
  private int zzaIC = -1;
  private CameraPosition zzaID;
  private Boolean zzaIE;
  private Boolean zzaIF;
  private Boolean zzaIG;
  private Boolean zzaIH;
  private Boolean zzaII;
  private Boolean zzaIJ;
  private Boolean zzaIK;
  private Boolean zzaIL;
  private Boolean zzaIM;
  
  public GoogleMapOptions()
  {
    this.mVersionCode = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, byte paramByte10, byte paramByte11)
  {
    this.mVersionCode = paramInt1;
    this.zzaIA = com.google.android.gms.maps.internal.zza.zza(paramByte1);
    this.zzaIB = com.google.android.gms.maps.internal.zza.zza(paramByte2);
    this.zzaIC = paramInt2;
    this.zzaID = paramCameraPosition;
    this.zzaIE = com.google.android.gms.maps.internal.zza.zza(paramByte3);
    this.zzaIF = com.google.android.gms.maps.internal.zza.zza(paramByte4);
    this.zzaIG = com.google.android.gms.maps.internal.zza.zza(paramByte5);
    this.zzaIH = com.google.android.gms.maps.internal.zza.zza(paramByte6);
    this.zzaII = com.google.android.gms.maps.internal.zza.zza(paramByte7);
    this.zzaIJ = com.google.android.gms.maps.internal.zza.zza(paramByte8);
    this.zzaIK = com.google.android.gms.maps.internal.zza.zza(paramByte9);
    this.zzaIL = com.google.android.gms.maps.internal.zza.zza(paramByte10);
    this.zzaIM = com.google.android.gms.maps.internal.zza.zza(paramByte11);
  }
  
  public static GoogleMapOptions createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
    if (localTypedArray.hasValue(R.styleable.MapAttrs_mapType)) {
      localGoogleMapOptions.mapType(localTypedArray.getInt(R.styleable.MapAttrs_mapType, -1));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
      localGoogleMapOptions.zOrderOnTop(localTypedArray.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
      localGoogleMapOptions.useViewLifecycleInFragment(localTypedArray.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiCompass)) {
      localGoogleMapOptions.compassEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiCompass, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
      localGoogleMapOptions.rotateGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
      localGoogleMapOptions.scrollGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
      localGoogleMapOptions.tiltGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
      localGoogleMapOptions.zoomGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
      localGoogleMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_liteMode)) {
      localGoogleMapOptions.liteMode(localTypedArray.getBoolean(R.styleable.MapAttrs_liteMode, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
      localGoogleMapOptions.mapToolbarEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
      localGoogleMapOptions.ambientEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
    }
    localGoogleMapOptions.camera(CameraPosition.createFromAttributes(paramContext, paramAttributeSet));
    localTypedArray.recycle();
    return localGoogleMapOptions;
  }
  
  public GoogleMapOptions ambientEnabled(boolean paramBoolean)
  {
    this.zzaIM = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions camera(CameraPosition paramCameraPosition)
  {
    this.zzaID = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions compassEnabled(boolean paramBoolean)
  {
    this.zzaIF = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Boolean getAmbientEnabled()
  {
    return this.zzaIM;
  }
  
  public CameraPosition getCamera()
  {
    return this.zzaID;
  }
  
  public Boolean getCompassEnabled()
  {
    return this.zzaIF;
  }
  
  public Boolean getLiteMode()
  {
    return this.zzaIK;
  }
  
  public Boolean getMapToolbarEnabled()
  {
    return this.zzaIL;
  }
  
  public int getMapType()
  {
    return this.zzaIC;
  }
  
  public Boolean getRotateGesturesEnabled()
  {
    return this.zzaIJ;
  }
  
  public Boolean getScrollGesturesEnabled()
  {
    return this.zzaIG;
  }
  
  public Boolean getTiltGesturesEnabled()
  {
    return this.zzaII;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.zzaIB;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public Boolean getZOrderOnTop()
  {
    return this.zzaIA;
  }
  
  public Boolean getZoomControlsEnabled()
  {
    return this.zzaIE;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.zzaIH;
  }
  
  public GoogleMapOptions liteMode(boolean paramBoolean)
  {
    this.zzaIK = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions mapToolbarEnabled(boolean paramBoolean)
  {
    this.zzaIL = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions mapType(int paramInt)
  {
    this.zzaIC = paramInt;
    return this;
  }
  
  public GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.zzaIJ = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.zzaIG = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.zzaII = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.zzaIB = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public GoogleMapOptions zOrderOnTop(boolean paramBoolean)
  {
    this.zzaIA = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.zzaIE = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.zzaIH = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  byte zzxA()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIB);
  }
  
  byte zzxB()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIE);
  }
  
  byte zzxC()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIF);
  }
  
  byte zzxD()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIG);
  }
  
  byte zzxE()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIH);
  }
  
  byte zzxF()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaII);
  }
  
  byte zzxG()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIJ);
  }
  
  byte zzxH()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIK);
  }
  
  byte zzxI()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIL);
  }
  
  byte zzxJ()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIM);
  }
  
  byte zzxz()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaIA);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\GoogleMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */