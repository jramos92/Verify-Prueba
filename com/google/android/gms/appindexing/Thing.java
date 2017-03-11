package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

public class Thing
{
  final Bundle zzRi;
  
  Thing(Bundle paramBundle)
  {
    this.zzRi = paramBundle;
  }
  
  public Bundle zzlx()
  {
    return this.zzRi;
  }
  
  public static class Builder
  {
    final Bundle zzRj = new Bundle();
    
    public Thing build()
    {
      return new Thing(this.zzRj);
    }
    
    public Builder put(String paramString, Thing paramThing)
    {
      zzx.zzw(paramString);
      if (paramThing != null) {
        this.zzRj.putParcelable(paramString, paramThing.zzRi);
      }
      return this;
    }
    
    public Builder put(String paramString1, String paramString2)
    {
      zzx.zzw(paramString1);
      if (paramString2 != null) {
        this.zzRj.putString(paramString1, paramString2);
      }
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      put("description", paramString);
      return this;
    }
    
    public Builder setId(String paramString)
    {
      if (paramString != null) {
        put("id", paramString);
      }
      return this;
    }
    
    public Builder setName(String paramString)
    {
      zzx.zzw(paramString);
      put("name", paramString);
      return this;
    }
    
    public Builder setType(String paramString)
    {
      put("type", paramString);
      return this;
    }
    
    public Builder setUrl(Uri paramUri)
    {
      zzx.zzw(paramUri);
      put("url", paramUri.toString());
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appindexing\Thing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */