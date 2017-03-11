package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlv.zza;
import java.lang.ref.WeakReference;

public abstract class zza
{
  final zza zzadV;
  protected int zzadW = 0;
  protected int zzadX = 0;
  protected boolean zzadY = false;
  protected ImageManager.OnImageLoadedListener zzadZ;
  private boolean zzaea = true;
  private boolean zzaeb = false;
  private boolean zzaec = true;
  protected int zzaed;
  
  public zza(Uri paramUri, int paramInt)
  {
    this.zzadV = new zza(paramUri);
    this.zzadX = paramInt;
  }
  
  private Drawable zza(Context paramContext, zzlv paramzzlv, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (this.zzaed > 0)
    {
      zzlv.zza localzza = new zzlv.zza(paramInt, this.zzaed);
      Drawable localDrawable = (Drawable)paramzzlv.get(localzza);
      paramContext = localDrawable;
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        paramContext = localDrawable;
        if ((this.zzaed & 0x1) != 0) {
          paramContext = zza(localResources, localDrawable);
        }
        paramzzlv.put(localzza, paramContext);
      }
      return paramContext;
    }
    return localResources.getDrawable(paramInt);
  }
  
  protected Drawable zza(Resources paramResources, Drawable paramDrawable)
  {
    return zzlt.zza(paramResources, paramDrawable);
  }
  
  protected zzls zza(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof zzls)) {}
    }
    for (Drawable localDrawable = ((zzls)paramDrawable1).zzoF();; localDrawable = null) {
      return new zzls(localDrawable, paramDrawable2);
    }
  }
  
  void zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    zzb.zzs(paramBitmap);
    Bitmap localBitmap = paramBitmap;
    if ((this.zzaed & 0x1) != 0) {
      localBitmap = zzlt.zza(paramBitmap);
    }
    paramContext = new BitmapDrawable(paramContext.getResources(), localBitmap);
    if (this.zzadZ != null) {
      this.zzadZ.onImageLoaded(this.zzadV.uri, paramContext, true);
    }
    zza(paramContext, paramBoolean, false, true);
  }
  
  void zza(Context paramContext, zzlv paramzzlv)
  {
    if (this.zzaec)
    {
      Drawable localDrawable = null;
      if (this.zzadW != 0) {
        localDrawable = zza(paramContext, paramzzlv, this.zzadW);
      }
      zza(localDrawable, false, true, false);
    }
  }
  
  void zza(Context paramContext, zzlv paramzzlv, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.zzadX != 0) {
      localDrawable = zza(paramContext, paramzzlv, this.zzadX);
    }
    if (this.zzadZ != null) {
      this.zzadZ.onImageLoaded(this.zzadV.uri, localDrawable, false);
    }
    zza(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  protected boolean zzb(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.zzaea) && (!paramBoolean2) && ((!paramBoolean1) || (this.zzaeb));
  }
  
  public void zzby(int paramInt)
  {
    this.zzadX = paramInt;
  }
  
  static final class zza
  {
    public final Uri uri;
    
    public zza(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      return zzw.equal(((zza)paramObject).uri, this.uri);
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { this.uri });
    }
  }
  
  public static final class zzb
    extends zza
  {
    private WeakReference<ImageView> zzaee;
    
    public zzb(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      zzb.zzs(paramImageView);
      this.zzaee = new WeakReference(paramImageView);
    }
    
    public zzb(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      zzb.zzs(paramImageView);
      this.zzaee = new WeakReference(paramImageView);
    }
    
    private void zza(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((!paramBoolean2) && (!paramBoolean3)) {}
      for (int i = 1; (i != 0) && ((paramImageView instanceof zzlu)); i = 0)
      {
        int j = ((zzlu)paramImageView).zzoH();
        if ((this.zzadX == 0) || (j != this.zzadX)) {
          break;
        }
        return;
      }
      paramBoolean1 = zzb(paramBoolean1, paramBoolean2);
      if ((this.zzadY) && (paramDrawable != null)) {
        paramDrawable = paramDrawable.getConstantState().newDrawable();
      }
      for (;;)
      {
        Object localObject = paramDrawable;
        if (paramBoolean1) {
          localObject = zza(paramImageView.getDrawable(), paramDrawable);
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        if ((paramImageView instanceof zzlu))
        {
          paramDrawable = (zzlu)paramImageView;
          if (!paramBoolean3) {
            break label171;
          }
          paramImageView = this.zzadV.uri;
          label133:
          paramDrawable.zzj(paramImageView);
          if (i == 0) {
            break label176;
          }
        }
        label171:
        label176:
        for (i = this.zzadX;; i = 0)
        {
          paramDrawable.zzbA(i);
          if (!paramBoolean1) {
            break;
          }
          ((zzls)localObject).startTransition(250);
          return;
          paramImageView = null;
          break label133;
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      Object localObject = (zzb)paramObject;
      paramObject = (ImageView)this.zzaee.get();
      localObject = (ImageView)((zzb)localObject).zzaee.get();
      if ((localObject != null) && (paramObject != null) && (zzw.equal(localObject, paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.zzaee.get();
      if (localImageView != null) {
        zza(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  public static final class zzc
    extends zza
  {
    private WeakReference<ImageManager.OnImageLoadedListener> zzaef;
    
    public zzc(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      zzb.zzs(paramOnImageLoadedListener);
      this.zzaef = new WeakReference(paramOnImageLoadedListener);
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzc)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzc)paramObject;
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.zzaef.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)((zzc)paramObject).zzaef.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (zzw.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (zzw.equal(((zzc)paramObject).zzadV, this.zzadV))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { this.zzadV });
    }
    
    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zzaef.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.zzadV.uri, paramDrawable, paramBoolean3);
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\images\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */