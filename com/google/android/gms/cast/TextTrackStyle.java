package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmx;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle
{
  public static final int COLOR_UNSPECIFIED = 0;
  public static final float DEFAULT_FONT_SCALE = 1.0F;
  public static final int EDGE_TYPE_DEPRESSED = 4;
  public static final int EDGE_TYPE_DROP_SHADOW = 2;
  public static final int EDGE_TYPE_NONE = 0;
  public static final int EDGE_TYPE_OUTLINE = 1;
  public static final int EDGE_TYPE_RAISED = 3;
  public static final int EDGE_TYPE_UNSPECIFIED = -1;
  public static final int FONT_FAMILY_CASUAL = 4;
  public static final int FONT_FAMILY_CURSIVE = 5;
  public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
  public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
  public static final int FONT_FAMILY_SANS_SERIF = 0;
  public static final int FONT_FAMILY_SERIF = 2;
  public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
  public static final int FONT_FAMILY_UNSPECIFIED = -1;
  public static final int FONT_STYLE_BOLD = 1;
  public static final int FONT_STYLE_BOLD_ITALIC = 3;
  public static final int FONT_STYLE_ITALIC = 2;
  public static final int FONT_STYLE_NORMAL = 0;
  public static final int FONT_STYLE_UNSPECIFIED = -1;
  public static final int WINDOW_TYPE_NONE = 0;
  public static final int WINDOW_TYPE_NORMAL = 1;
  public static final int WINDOW_TYPE_ROUNDED = 2;
  public static final int WINDOW_TYPE_UNSPECIFIED = -1;
  private JSONObject zzWc;
  private int zzXA;
  private int zzXB;
  private int zzXC;
  private String zzXD;
  private int zzXE;
  private int zzXF;
  private float zzXw;
  private int zzXx;
  private int zzXy;
  private int zzXz;
  private int zzwg;
  
  public TextTrackStyle()
  {
    clear();
  }
  
  private void clear()
  {
    this.zzXw = 1.0F;
    this.zzXx = 0;
    this.zzwg = 0;
    this.zzXy = -1;
    this.zzXz = 0;
    this.zzXA = -1;
    this.zzXB = 0;
    this.zzXC = 0;
    this.zzXD = null;
    this.zzXE = -1;
    this.zzXF = -1;
    this.zzWc = null;
  }
  
  public static TextTrackStyle fromSystemSettings(Context paramContext)
  {
    TextTrackStyle localTextTrackStyle = new TextTrackStyle();
    if (!zzmx.zzqB()) {
      return localTextTrackStyle;
    }
    paramContext = (CaptioningManager)paramContext.getSystemService("captioning");
    localTextTrackStyle.setFontScale(paramContext.getFontScale());
    paramContext = paramContext.getUserStyle();
    localTextTrackStyle.setBackgroundColor(paramContext.backgroundColor);
    localTextTrackStyle.setForegroundColor(paramContext.foregroundColor);
    label117:
    boolean bool1;
    boolean bool2;
    switch (paramContext.edgeType)
    {
    default: 
      localTextTrackStyle.setEdgeType(0);
      localTextTrackStyle.setEdgeColor(paramContext.edgeColor);
      paramContext = paramContext.getTypeface();
      if (paramContext != null)
      {
        if (!Typeface.MONOSPACE.equals(paramContext)) {
          break label158;
        }
        localTextTrackStyle.setFontGenericFamily(1);
        bool1 = paramContext.isBold();
        bool2 = paramContext.isItalic();
        if ((!bool1) || (!bool2)) {
          break label202;
        }
        localTextTrackStyle.setFontStyle(3);
      }
      break;
    }
    for (;;)
    {
      return localTextTrackStyle;
      localTextTrackStyle.setEdgeType(1);
      break;
      localTextTrackStyle.setEdgeType(2);
      break;
      label158:
      if (Typeface.SANS_SERIF.equals(paramContext))
      {
        localTextTrackStyle.setFontGenericFamily(0);
        break label117;
      }
      if (Typeface.SERIF.equals(paramContext))
      {
        localTextTrackStyle.setFontGenericFamily(2);
        break label117;
      }
      localTextTrackStyle.setFontGenericFamily(0);
      break label117;
      label202:
      if (bool1) {
        localTextTrackStyle.setFontStyle(1);
      } else if (bool2) {
        localTextTrackStyle.setFontStyle(2);
      } else {
        localTextTrackStyle.setFontStyle(0);
      }
    }
  }
  
  private String zzI(int paramInt)
  {
    return String.format("#%02X%02X%02X%02X", new Object[] { Integer.valueOf(Color.red(paramInt)), Integer.valueOf(Color.green(paramInt)), Integer.valueOf(Color.blue(paramInt)), Integer.valueOf(Color.alpha(paramInt)) });
  }
  
  private int zzbI(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() == 9)
      {
        i = j;
        if (paramString.charAt(0) != '#') {}
      }
    }
    try
    {
      i = Integer.parseInt(paramString.substring(1, 3), 16);
      j = Integer.parseInt(paramString.substring(3, 5), 16);
      int k = Integer.parseInt(paramString.substring(5, 7), 16);
      i = Color.argb(Integer.parseInt(paramString.substring(7, 9), 16), i, j, k);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    int i;
    int j;
    label51:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof TextTrackStyle));
        paramObject = (TextTrackStyle)paramObject;
        if (this.zzWc != null) {
          break;
        }
        i = 1;
        if (((TextTrackStyle)paramObject).zzWc != null) {
          break label218;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.zzWc == null) || (((TextTrackStyle)paramObject).zzWc == null)) {
        break;
      }
      bool1 = bool3;
    } while (!zzmu.zzd(this.zzWc, ((TextTrackStyle)paramObject).zzWc));
    if ((this.zzXw == ((TextTrackStyle)paramObject).zzXw) && (this.zzXx == ((TextTrackStyle)paramObject).zzXx) && (this.zzwg == ((TextTrackStyle)paramObject).zzwg) && (this.zzXy == ((TextTrackStyle)paramObject).zzXy) && (this.zzXz == ((TextTrackStyle)paramObject).zzXz) && (this.zzXA == ((TextTrackStyle)paramObject).zzXA) && (this.zzXC == ((TextTrackStyle)paramObject).zzXC) && (zzf.zza(this.zzXD, ((TextTrackStyle)paramObject).zzXD)) && (this.zzXE == ((TextTrackStyle)paramObject).zzXE) && (this.zzXF == ((TextTrackStyle)paramObject).zzXF)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label218:
      j = 0;
      break label51;
    }
  }
  
  public int getBackgroundColor()
  {
    return this.zzwg;
  }
  
  public JSONObject getCustomData()
  {
    return this.zzWc;
  }
  
  public int getEdgeColor()
  {
    return this.zzXz;
  }
  
  public int getEdgeType()
  {
    return this.zzXy;
  }
  
  public String getFontFamily()
  {
    return this.zzXD;
  }
  
  public int getFontGenericFamily()
  {
    return this.zzXE;
  }
  
  public float getFontScale()
  {
    return this.zzXw;
  }
  
  public int getFontStyle()
  {
    return this.zzXF;
  }
  
  public int getForegroundColor()
  {
    return this.zzXx;
  }
  
  public int getWindowColor()
  {
    return this.zzXB;
  }
  
  public int getWindowCornerRadius()
  {
    return this.zzXC;
  }
  
  public int getWindowType()
  {
    return this.zzXA;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Float.valueOf(this.zzXw), Integer.valueOf(this.zzXx), Integer.valueOf(this.zzwg), Integer.valueOf(this.zzXy), Integer.valueOf(this.zzXz), Integer.valueOf(this.zzXA), Integer.valueOf(this.zzXB), Integer.valueOf(this.zzXC), this.zzXD, Integer.valueOf(this.zzXE), Integer.valueOf(this.zzXF), this.zzWc });
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.zzwg = paramInt;
  }
  
  public void setCustomData(JSONObject paramJSONObject)
  {
    this.zzWc = paramJSONObject;
  }
  
  public void setEdgeColor(int paramInt)
  {
    this.zzXz = paramInt;
  }
  
  public void setEdgeType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      throw new IllegalArgumentException("invalid edgeType");
    }
    this.zzXy = paramInt;
  }
  
  public void setFontFamily(String paramString)
  {
    this.zzXD = paramString;
  }
  
  public void setFontGenericFamily(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid fontGenericFamily");
    }
    this.zzXE = paramInt;
  }
  
  public void setFontScale(float paramFloat)
  {
    this.zzXw = paramFloat;
  }
  
  public void setFontStyle(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid fontStyle");
    }
    this.zzXF = paramInt;
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.zzXx = paramInt;
  }
  
  public void setWindowColor(int paramInt)
  {
    this.zzXB = paramInt;
  }
  
  public void setWindowCornerRadius(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invalid windowCornerRadius");
    }
    this.zzXC = paramInt;
  }
  
  public void setWindowType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid windowType");
    }
    this.zzXA = paramInt;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fontScale", this.zzXw);
      if (this.zzXx != 0) {
        localJSONObject.put("foregroundColor", zzI(this.zzXx));
      }
      if (this.zzwg != 0) {
        localJSONObject.put("backgroundColor", zzI(this.zzwg));
      }
      switch (this.zzXy)
      {
      case 0: 
        if (this.zzXz != 0) {
          localJSONObject.put("edgeColor", zzI(this.zzXz));
        }
        switch (this.zzXA)
        {
        case 0: 
          label156:
          if (this.zzXB != 0) {
            localJSONObject.put("windowColor", zzI(this.zzXB));
          }
          if (this.zzXA == 2) {
            localJSONObject.put("windowRoundedCornerRadius", this.zzXC);
          }
          if (this.zzXD != null) {
            localJSONObject.put("fontFamily", this.zzXD);
          }
          switch (this.zzXE)
          {
          case 0: 
            label264:
            switch (this.zzXF)
            {
            }
            break;
          }
          break;
        }
        break;
      }
      for (;;)
      {
        if (this.zzWc == null) {
          break label599;
        }
        localJSONObject.put("customData", this.zzWc);
        return localJSONObject;
        localJSONObject.put("edgeType", "NONE");
        break;
        localJSONObject.put("edgeType", "OUTLINE");
        break;
        localJSONObject.put("edgeType", "DROP_SHADOW");
        break;
        localJSONObject.put("edgeType", "RAISED");
        break;
        localJSONObject.put("edgeType", "DEPRESSED");
        break;
        localJSONObject.put("windowType", "NONE");
        break label156;
        localJSONObject.put("windowType", "NORMAL");
        break label156;
        localJSONObject.put("windowType", "ROUNDED_CORNERS");
        break label156;
        localJSONObject.put("fontGenericFamily", "SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "CASUAL");
        break label264;
        localJSONObject.put("fontGenericFamily", "CURSIVE");
        break label264;
        localJSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
        break label264;
        localJSONObject.put("fontStyle", "NORMAL");
        continue;
        localJSONObject.put("fontStyle", "BOLD");
        continue;
        localJSONObject.put("fontStyle", "ITALIC");
        continue;
        localJSONObject.put("fontStyle", "BOLD_ITALIC");
        continue;
        break;
        break label156;
        break label264;
      }
      label599:
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public void zzf(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.zzXw = ((float)paramJSONObject.optDouble("fontScale", 1.0D));
    this.zzXx = zzbI(paramJSONObject.optString("foregroundColor"));
    this.zzwg = zzbI(paramJSONObject.optString("backgroundColor"));
    String str;
    if (paramJSONObject.has("edgeType"))
    {
      str = paramJSONObject.getString("edgeType");
      if ("NONE".equals(str)) {
        this.zzXy = 0;
      }
    }
    else
    {
      this.zzXz = zzbI(paramJSONObject.optString("edgeColor"));
      if (paramJSONObject.has("windowType"))
      {
        str = paramJSONObject.getString("windowType");
        if (!"NONE".equals(str)) {
          break label325;
        }
        this.zzXA = 0;
      }
      label128:
      this.zzXB = zzbI(paramJSONObject.optString("windowColor"));
      if (this.zzXA == 2) {
        this.zzXC = paramJSONObject.optInt("windowRoundedCornerRadius", 0);
      }
      this.zzXD = paramJSONObject.optString("fontFamily", null);
      if (paramJSONObject.has("fontGenericFamily"))
      {
        str = paramJSONObject.getString("fontGenericFamily");
        if (!"SANS_SERIF".equals(str)) {
          break label361;
        }
        this.zzXE = 0;
      }
      label208:
      if (paramJSONObject.has("fontStyle"))
      {
        str = paramJSONObject.getString("fontStyle");
        if (!"NORMAL".equals(str)) {
          break label470;
        }
        this.zzXF = 0;
      }
    }
    for (;;)
    {
      this.zzWc = paramJSONObject.optJSONObject("customData");
      return;
      if ("OUTLINE".equals(str))
      {
        this.zzXy = 1;
        break;
      }
      if ("DROP_SHADOW".equals(str))
      {
        this.zzXy = 2;
        break;
      }
      if ("RAISED".equals(str))
      {
        this.zzXy = 3;
        break;
      }
      if (!"DEPRESSED".equals(str)) {
        break;
      }
      this.zzXy = 4;
      break;
      label325:
      if ("NORMAL".equals(str))
      {
        this.zzXA = 1;
        break label128;
      }
      if (!"ROUNDED_CORNERS".equals(str)) {
        break label128;
      }
      this.zzXA = 2;
      break label128;
      label361:
      if ("MONOSPACED_SANS_SERIF".equals(str))
      {
        this.zzXE = 1;
        break label208;
      }
      if ("SERIF".equals(str))
      {
        this.zzXE = 2;
        break label208;
      }
      if ("MONOSPACED_SERIF".equals(str))
      {
        this.zzXE = 3;
        break label208;
      }
      if ("CASUAL".equals(str))
      {
        this.zzXE = 4;
        break label208;
      }
      if ("CURSIVE".equals(str))
      {
        this.zzXE = 5;
        break label208;
      }
      if (!"SMALL_CAPITALS".equals(str)) {
        break label208;
      }
      this.zzXE = 6;
      break label208;
      label470:
      if ("BOLD".equals(str)) {
        this.zzXF = 1;
      } else if ("ITALIC".equals(str)) {
        this.zzXF = 2;
      } else if ("BOLD_ITALIC".equals(str)) {
        this.zzXF = 3;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\TextTrackStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */