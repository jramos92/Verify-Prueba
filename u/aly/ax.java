package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ax
  implements Serializable, Cloneable, ch<ax, e>
{
  public static final Map<e, ct> e;
  private static final dl f = new dl("IdJournal");
  private static final db g = new db("domain", (byte)11, (short)1);
  private static final db h = new db("old_id", (byte)11, (short)2);
  private static final db i = new db("new_id", (byte)11, (short)3);
  private static final db j = new db("ts", (byte)10, (short)4);
  private static final Map<Class<? extends do>, dp> k = new HashMap();
  private static final int l = 0;
  public String a;
  public String b;
  public String c;
  public long d;
  private byte m = 0;
  private e[] n = { e.b };
  
  static
  {
    k.put(dq.class, new b(null));
    k.put(dr.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new ct("domain", (byte)1, new cu((byte)11)));
    localEnumMap.put(e.b, new ct("old_id", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.c, new ct("new_id", (byte)1, new cu((byte)11)));
    localEnumMap.put(e.d, new ct("ts", (byte)1, new cu((byte)10)));
    e = Collections.unmodifiableMap(localEnumMap);
    ct.a(ax.class, e);
  }
  
  public ax() {}
  
  public ax(String paramString1, String paramString2, long paramLong)
  {
    this();
    this.a = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    d(true);
  }
  
  public ax(ax paramax)
  {
    this.m = paramax.m;
    if (paramax.e()) {
      this.a = paramax.a;
    }
    if (paramax.i()) {
      this.b = paramax.b;
    }
    if (paramax.l()) {
      this.c = paramax.c;
    }
    this.d = paramax.d;
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.m = 0;
      a(new da(new ds(paramObjectInputStream)));
      return;
    }
    catch (cn paramObjectInputStream)
    {
      throw new IOException(paramObjectInputStream.getMessage());
    }
  }
  
  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    try
    {
      b(new da(new ds(paramObjectOutputStream)));
      return;
    }
    catch (cn paramObjectOutputStream)
    {
      throw new IOException(paramObjectOutputStream.getMessage());
    }
  }
  
  public e a(int paramInt)
  {
    return e.a(paramInt);
  }
  
  public ax a()
  {
    return new ax(this);
  }
  
  public ax a(long paramLong)
  {
    this.d = paramLong;
    d(true);
    return this;
  }
  
  public ax a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(dg paramdg)
    throws cn
  {
    ((dp)k.get(paramdg.D())).b().b(paramdg, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public ax b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    d(false);
    this.d = 0L;
  }
  
  public void b(dg paramdg)
    throws cn
  {
    ((dp)k.get(paramdg.D())).b().a(paramdg, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public String c()
  {
    return this.a;
  }
  
  public ax c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public void d()
  {
    this.a = null;
  }
  
  public void d(boolean paramBoolean)
  {
    this.m = ce.a(this.m, 0, paramBoolean);
  }
  
  public boolean e()
  {
    return this.a != null;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public void h()
  {
    this.b = null;
  }
  
  public boolean i()
  {
    return this.b != null;
  }
  
  public String j()
  {
    return this.c;
  }
  
  public void k()
  {
    this.c = null;
  }
  
  public boolean l()
  {
    return this.c != null;
  }
  
  public long m()
  {
    return this.d;
  }
  
  public void n()
  {
    this.m = ce.b(this.m, 0);
  }
  
  public boolean o()
  {
    return ce.a(this.m, 0);
  }
  
  public void p()
    throws cn
  {
    if (this.a == null) {
      throw new dh("Required field 'domain' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new dh("Required field 'new_id' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdJournal(");
    localStringBuilder.append("domain:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("old_id:");
        if (this.b != null) {
          break label153;
        }
        localStringBuilder.append("null");
      }
      label72:
      localStringBuilder.append(", ");
      localStringBuilder.append("new_id:");
      if (this.c != null) {
        break label165;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label153:
      localStringBuilder.append(this.b);
      break label72;
      label165:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends dq<ax>
  {
    public void a(dg paramdg, ax paramax)
      throws cn
    {
      paramdg.j();
      db localdb = paramdg.l();
      if (localdb.b == 0)
      {
        paramdg.k();
        if (!paramax.o()) {
          throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }
      }
      else
      {
        switch (localdb.c)
        {
        default: 
          dj.a(paramdg, localdb.b);
        }
        for (;;)
        {
          paramdg.m();
          break;
          if (localdb.b == 11)
          {
            paramax.a = paramdg.z();
            paramax.a(true);
          }
          else
          {
            dj.a(paramdg, localdb.b);
            continue;
            if (localdb.b == 11)
            {
              paramax.b = paramdg.z();
              paramax.b(true);
            }
            else
            {
              dj.a(paramdg, localdb.b);
              continue;
              if (localdb.b == 11)
              {
                paramax.c = paramdg.z();
                paramax.c(true);
              }
              else
              {
                dj.a(paramdg, localdb.b);
                continue;
                if (localdb.b == 10)
                {
                  paramax.d = paramdg.x();
                  paramax.d(true);
                }
                else
                {
                  dj.a(paramdg, localdb.b);
                }
              }
            }
          }
        }
      }
      paramax.p();
    }
    
    public void b(dg paramdg, ax paramax)
      throws cn
    {
      paramax.p();
      paramdg.a(ax.q());
      if (paramax.a != null)
      {
        paramdg.a(ax.r());
        paramdg.a(paramax.a);
        paramdg.c();
      }
      if ((paramax.b != null) && (paramax.i()))
      {
        paramdg.a(ax.s());
        paramdg.a(paramax.b);
        paramdg.c();
      }
      if (paramax.c != null)
      {
        paramdg.a(ax.t());
        paramdg.a(paramax.c);
        paramdg.c();
      }
      paramdg.a(ax.u());
      paramdg.a(paramax.d);
      paramdg.c();
      paramdg.d();
      paramdg.b();
    }
  }
  
  private static class b
    implements dp
  {
    public ax.a a()
    {
      return new ax.a(null);
    }
  }
  
  private static class c
    extends dr<ax>
  {
    public void a(dg paramdg, ax paramax)
      throws cn
    {
      paramdg = (dm)paramdg;
      paramdg.a(paramax.a);
      paramdg.a(paramax.c);
      paramdg.a(paramax.d);
      BitSet localBitSet = new BitSet();
      if (paramax.i()) {
        localBitSet.set(0);
      }
      paramdg.a(localBitSet, 1);
      if (paramax.i()) {
        paramdg.a(paramax.b);
      }
    }
    
    public void b(dg paramdg, ax paramax)
      throws cn
    {
      paramdg = (dm)paramdg;
      paramax.a = paramdg.z();
      paramax.a(true);
      paramax.c = paramdg.z();
      paramax.c(true);
      paramax.d = paramdg.x();
      paramax.d(true);
      if (paramdg.b(1).get(0))
      {
        paramax.b = paramdg.z();
        paramax.b(true);
      }
    }
  }
  
  private static class d
    implements dp
  {
    public ax.c a()
    {
      return new ax.c(null);
    }
  }
  
  public static enum e
    implements co
  {
    private static final Map<String, e> e;
    private final short f;
    private final String g;
    
    static
    {
      e = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        e.put(locale.b(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.f = paramShort;
      this.g = paramString;
    }
    
    public static e a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return a;
      case 2: 
        return b;
      case 3: 
        return c;
      }
      return d;
    }
    
    public static e a(String paramString)
    {
      return (e)e.get(paramString);
    }
    
    public static e b(int paramInt)
    {
      e locale = a(paramInt);
      if (locale == null) {
        throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
      }
      return locale;
    }
    
    public short a()
    {
      return this.f;
    }
    
    public String b()
    {
      return this.g;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */