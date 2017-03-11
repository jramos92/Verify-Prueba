package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.util.Xml;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class j
{
  public HashMap<String, Object> a(String paramString)
  {
    a locala = new a();
    Xml.parse(paramString, locala);
    return locala.a();
  }
  
  private static class a
    extends DefaultHandler
  {
    private HashMap<String, Object> a = new HashMap();
    private HashMap<String, Object> b;
    
    public HashMap<String, Object> a()
    {
      return this.a;
    }
    
    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      paramArrayOfChar = String.valueOf(paramArrayOfChar, paramInt1, paramInt2).trim();
      if (TextUtils.isEmpty(paramArrayOfChar)) {}
      while (this.b == null) {
        return;
      }
      this.b.put("value", paramArrayOfChar);
    }
    
    public void endElement(String paramString1, String paramString2, String paramString3)
    {
      this.b = null;
    }
    
    public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    {
      if (this.b != null)
      {
        paramString1 = new HashMap();
        this.b.put(paramString2, paramString1);
        this.b = paramString1;
      }
      for (;;)
      {
        int j = paramAttributes.getLength();
        int i = 0;
        while (i < j)
        {
          this.b.put(paramAttributes.getLocalName(i), paramAttributes.getValue(i));
          i += 1;
        }
        this.b = new HashMap();
        this.a.put(paramString2, this.b);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */