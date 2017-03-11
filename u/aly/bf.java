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

public class bf
  implements Serializable, Cloneable, ch<bf, e>
{
  private static final int A = 3;
  public static final Map<e, ct> k;
  private static final dl l = new dl("MiscInfo");
  private static final db m = new db("time_zone", (byte)8, (short)1);
  private static final db n = new db("language", (byte)11, (short)2);
  private static final db o = new db("country", (byte)11, (short)3);
  private static final db p = new db("latitude", (byte)4, (short)4);
  private static final db q = new db("longitude", (byte)4, (short)5);
  private static final db r = new db("carrier", (byte)11, (short)6);
  private static final db s = new db("latency", (byte)8, (short)7);
  private static final db t = new db("display_name", (byte)11, (short)8);
  private static final db u = new db("access_type", (byte)8, (short)9);
  private static final db v = new db("access_subtype", (byte)11, (short)10);
  private static final Map<Class<? extends do>, dp> w = new HashMap();
  private static final int x = 0;
  private static final int y = 1;
  private static final int z = 2;
  private byte B = 0;
  private e[] C = { e.a, e.b, e.c, e.d, e.e, e.f, e.g, e.h, e.i, e.j };
  public int a;
  public String b;
  public String c;
  public double d;
  public double e;
  public String f;
  public int g;
  public String h;
  public al i;
  public String j;
  
  static
  {
    w.put(dq.class, new b(null));
    w.put(dr.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new ct("time_zone", (byte)2, new cu((byte)8)));
    localEnumMap.put(e.b, new ct("language", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.c, new ct("country", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.d, new ct("latitude", (byte)2, new cu((byte)4)));
    localEnumMap.put(e.e, new ct("longitude", (byte)2, new cu((byte)4)));
    localEnumMap.put(e.f, new ct("carrier", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.g, new ct("latency", (byte)2, new cu((byte)8)));
    localEnumMap.put(e.h, new ct("display_name", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.i, new ct("access_type", (byte)2, new cs((byte)16, al.class)));
    localEnumMap.put(e.j, new ct("access_subtype", (byte)2, new cu((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    ct.a(bf.class, k);
  }
  
  public bf() {}
  
  public bf(bf parambf)
  {
    this.B = parambf.B;
    this.a = parambf.a;
    if (parambf.i()) {
      this.b = parambf.b;
    }
    if (parambf.l()) {
      this.c = parambf.c;
    }
    this.d = parambf.d;
    this.e = parambf.e;
    if (parambf.u()) {
      this.f = parambf.f;
    }
    this.g = parambf.g;
    if (parambf.A()) {
      this.h = parambf.h;
    }
    if (parambf.D()) {
      this.i = parambf.i;
    }
    if (parambf.G()) {
      this.j = parambf.j;
    }
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.B = 0;
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
  
  public boolean A()
  {
    return this.h != null;
  }
  
  public al B()
  {
    return this.i;
  }
  
  public void C()
  {
    this.i = null;
  }
  
  public boolean D()
  {
    return this.i != null;
  }
  
  public String E()
  {
    return this.j;
  }
  
  public void F()
  {
    this.j = null;
  }
  
  public boolean G()
  {
    return this.j != null;
  }
  
  public void H()
    throws cn
  {}
  
  public bf a()
  {
    return new bf(this);
  }
  
  public bf a(double paramDouble)
  {
    this.d = paramDouble;
    d(true);
    return this;
  }
  
  public bf a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
  }
  
  public bf a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public bf a(al paramal)
  {
    this.i = paramal;
    return this;
  }
  
  public void a(dg paramdg)
    throws cn
  {
    ((dp)w.get(paramdg.D())).b().b(paramdg, this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.B = ce.a(this.B, 0, paramBoolean);
  }
  
  public bf b(double paramDouble)
  {
    this.e = paramDouble;
    e(true);
    return this;
  }
  
  public bf b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void b()
  {
    a(false);
    this.a = 0;
    this.b = null;
    this.c = null;
    d(false);
    this.d = 0.0D;
    e(false);
    this.e = 0.0D;
    this.f = null;
    g(false);
    this.g = 0;
    this.h = null;
    this.i = null;
    this.j = null;
  }
  
  public void b(dg paramdg)
    throws cn
  {
    ((dp)w.get(paramdg.D())).b().a(paramdg, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public int c()
  {
    return this.a;
  }
  
  public bf c(int paramInt)
  {
    this.g = paramInt;
    g(true);
    return this;
  }
  
  public bf c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public e d(int paramInt)
  {
    return e.a(paramInt);
  }
  
  public bf d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void d()
  {
    this.B = ce.b(this.B, 0);
  }
  
  public void d(boolean paramBoolean)
  {
    this.B = ce.a(this.B, 1, paramBoolean);
  }
  
  public bf e(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public void e(boolean paramBoolean)
  {
    this.B = ce.a(this.B, 2, paramBoolean);
  }
  
  public boolean e()
  {
    return ce.a(this.B, 0);
  }
  
  public String f()
  {
    return this.b;
  }
  
  public void f(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.f = null;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.B = ce.a(this.B, 3, paramBoolean);
  }
  
  public void h()
  {
    this.b = null;
  }
  
  public void h(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.h = null;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.i = null;
    }
  }
  
  public boolean i()
  {
    return this.b != null;
  }
  
  public String j()
  {
    return this.c;
  }
  
  public void j(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.j = null;
    }
  }
  
  public void k()
  {
    this.c = null;
  }
  
  public boolean l()
  {
    return this.c != null;
  }
  
  public double m()
  {
    return this.d;
  }
  
  public void n()
  {
    this.B = ce.b(this.B, 1);
  }
  
  public boolean o()
  {
    return ce.a(this.B, 1);
  }
  
  public double p()
  {
    return this.e;
  }
  
  public void q()
  {
    this.B = ce.b(this.B, 2);
  }
  
  public boolean r()
  {
    return ce.a(this.B, 2);
  }
  
  public String s()
  {
    return this.f;
  }
  
  public void t()
  {
    this.f = null;
  }
  
  public String toString()
  {
    int i3 = 0;
    StringBuilder localStringBuilder = new StringBuilder("MiscInfo(");
    int i2 = 1;
    if (e())
    {
      localStringBuilder.append("time_zone:");
      localStringBuilder.append(this.a);
      i2 = 0;
    }
    int i1 = i2;
    if (i())
    {
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("language:");
      if (this.b == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      i2 = i1;
      if (l())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("country:");
        if (this.c != null) {
          break label489;
        }
        localStringBuilder.append("null");
        label140:
        i2 = 0;
      }
      i1 = i2;
      if (o())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("latitude:");
        localStringBuilder.append(this.d);
        i1 = 0;
      }
      i2 = i1;
      if (r())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("longitude:");
        localStringBuilder.append(this.e);
        i2 = 0;
      }
      i1 = i2;
      if (u())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("carrier:");
        if (this.f != null) {
          break label502;
        }
        localStringBuilder.append("null");
        label275:
        i1 = 0;
      }
      i2 = i1;
      if (x())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("latency:");
        localStringBuilder.append(this.g);
        i2 = 0;
      }
      i1 = i2;
      if (A())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("display_name:");
        if (this.h != null) {
          break label515;
        }
        localStringBuilder.append("null");
        label367:
        i1 = 0;
      }
      if (!D()) {
        break label556;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("access_type:");
      if (this.i != null) {
        break label528;
      }
      localStringBuilder.append("null");
      i1 = i3;
    }
    label416:
    label489:
    label502:
    label515:
    label528:
    label543:
    label556:
    for (;;)
    {
      if (G())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("access_subtype:");
        if (this.j != null) {
          break label543;
        }
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.b);
        break;
        localStringBuilder.append(this.c);
        break label140;
        localStringBuilder.append(this.f);
        break label275;
        localStringBuilder.append(this.h);
        break label367;
        localStringBuilder.append(this.i);
        i1 = i3;
        break label416;
        localStringBuilder.append(this.j);
      }
    }
  }
  
  public boolean u()
  {
    return this.f != null;
  }
  
  public int v()
  {
    return this.g;
  }
  
  public void w()
  {
    this.B = ce.b(this.B, 3);
  }
  
  public boolean x()
  {
    return ce.a(this.B, 3);
  }
  
  public String y()
  {
    return this.h;
  }
  
  public void z()
  {
    this.h = null;
  }
  
  private static class a
    extends dq<bf>
  {
    public void a(dg paramdg, bf parambf)
      throws cn
    {
      paramdg.j();
      db localdb = paramdg.l();
      if (localdb.b == 0)
      {
        paramdg.k();
        parambf.H();
        return;
      }
      switch (localdb.c)
      {
      default: 
        dj.a(paramdg, localdb.b);
      }
      for (;;)
      {
        paramdg.m();
        break;
        if (localdb.b == 8)
        {
          parambf.a = paramdg.w();
          parambf.a(true);
        }
        else
        {
          dj.a(paramdg, localdb.b);
          continue;
          if (localdb.b == 11)
          {
            parambf.b = paramdg.z();
            parambf.b(true);
          }
          else
          {
            dj.a(paramdg, localdb.b);
            continue;
            if (localdb.b == 11)
            {
              parambf.c = paramdg.z();
              parambf.c(true);
            }
            else
            {
              dj.a(paramdg, localdb.b);
              continue;
              if (localdb.b == 4)
              {
                parambf.d = paramdg.y();
                parambf.d(true);
              }
              else
              {
                dj.a(paramdg, localdb.b);
                continue;
                if (localdb.b == 4)
                {
                  parambf.e = paramdg.y();
                  parambf.e(true);
                }
                else
                {
                  dj.a(paramdg, localdb.b);
                  continue;
                  if (localdb.b == 11)
                  {
                    parambf.f = paramdg.z();
                    parambf.f(true);
                  }
                  else
                  {
                    dj.a(paramdg, localdb.b);
                    continue;
                    if (localdb.b == 8)
                    {
                      parambf.g = paramdg.w();
                      parambf.g(true);
                    }
                    else
                    {
                      dj.a(paramdg, localdb.b);
                      continue;
                      if (localdb.b == 11)
                      {
                        parambf.h = paramdg.z();
                        parambf.h(true);
                      }
                      else
                      {
                        dj.a(paramdg, localdb.b);
                        continue;
                        if (localdb.b == 8)
                        {
                          parambf.i = al.a(paramdg.w());
                          parambf.i(true);
                        }
                        else
                        {
                          dj.a(paramdg, localdb.b);
                          continue;
                          if (localdb.b == 11)
                          {
                            parambf.j = paramdg.z();
                            parambf.j(true);
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
              }
            }
          }
        }
      }
    }
    
    public void b(dg paramdg, bf parambf)
      throws cn
    {
      parambf.H();
      paramdg.a(bf.I());
      if (parambf.e())
      {
        paramdg.a(bf.J());
        paramdg.a(parambf.a);
        paramdg.c();
      }
      if ((parambf.b != null) && (parambf.i()))
      {
        paramdg.a(bf.K());
        paramdg.a(parambf.b);
        paramdg.c();
      }
      if ((parambf.c != null) && (parambf.l()))
      {
        paramdg.a(bf.L());
        paramdg.a(parambf.c);
        paramdg.c();
      }
      if (parambf.o())
      {
        paramdg.a(bf.M());
        paramdg.a(parambf.d);
        paramdg.c();
      }
      if (parambf.r())
      {
        paramdg.a(bf.N());
        paramdg.a(parambf.e);
        paramdg.c();
      }
      if ((parambf.f != null) && (parambf.u()))
      {
        paramdg.a(bf.O());
        paramdg.a(parambf.f);
        paramdg.c();
      }
      if (parambf.x())
      {
        paramdg.a(bf.P());
        paramdg.a(parambf.g);
        paramdg.c();
      }
      if ((parambf.h != null) && (parambf.A()))
      {
        paramdg.a(bf.Q());
        paramdg.a(parambf.h);
        paramdg.c();
      }
      if ((parambf.i != null) && (parambf.D()))
      {
        paramdg.a(bf.R());
        paramdg.a(parambf.i.a());
        paramdg.c();
      }
      if ((parambf.j != null) && (parambf.G()))
      {
        paramdg.a(bf.S());
        paramdg.a(parambf.j);
        paramdg.c();
      }
      paramdg.d();
      paramdg.b();
    }
  }
  
  private static class b
    implements dp
  {
    public bf.a a()
    {
      return new bf.a(null);
    }
  }
  
  private static class c
    extends dr<bf>
  {
    public void a(dg paramdg, bf parambf)
      throws cn
    {
      paramdg = (dm)paramdg;
      BitSet localBitSet = new BitSet();
      if (parambf.e()) {
        localBitSet.set(0);
      }
      if (parambf.i()) {
        localBitSet.set(1);
      }
      if (parambf.l()) {
        localBitSet.set(2);
      }
      if (parambf.o()) {
        localBitSet.set(3);
      }
      if (parambf.r()) {
        localBitSet.set(4);
      }
      if (parambf.u()) {
        localBitSet.set(5);
      }
      if (parambf.x()) {
        localBitSet.set(6);
      }
      if (parambf.A()) {
        localBitSet.set(7);
      }
      if (parambf.D()) {
        localBitSet.set(8);
      }
      if (parambf.G()) {
        localBitSet.set(9);
      }
      paramdg.a(localBitSet, 10);
      if (parambf.e()) {
        paramdg.a(parambf.a);
      }
      if (parambf.i()) {
        paramdg.a(parambf.b);
      }
      if (parambf.l()) {
        paramdg.a(parambf.c);
      }
      if (parambf.o()) {
        paramdg.a(parambf.d);
      }
      if (parambf.r()) {
        paramdg.a(parambf.e);
      }
      if (parambf.u()) {
        paramdg.a(parambf.f);
      }
      if (parambf.x()) {
        paramdg.a(parambf.g);
      }
      if (parambf.A()) {
        paramdg.a(parambf.h);
      }
      if (parambf.D()) {
        paramdg.a(parambf.i.a());
      }
      if (parambf.G()) {
        paramdg.a(parambf.j);
      }
    }
    
    public void b(dg paramdg, bf parambf)
      throws cn
    {
      paramdg = (dm)paramdg;
      BitSet localBitSet = paramdg.b(10);
      if (localBitSet.get(0))
      {
        parambf.a = paramdg.w();
        parambf.a(true);
      }
      if (localBitSet.get(1))
      {
        parambf.b = paramdg.z();
        parambf.b(true);
      }
      if (localBitSet.get(2))
      {
        parambf.c = paramdg.z();
        parambf.c(true);
      }
      if (localBitSet.get(3))
      {
        parambf.d = paramdg.y();
        parambf.d(true);
      }
      if (localBitSet.get(4))
      {
        parambf.e = paramdg.y();
        parambf.e(true);
      }
      if (localBitSet.get(5))
      {
        parambf.f = paramdg.z();
        parambf.f(true);
      }
      if (localBitSet.get(6))
      {
        parambf.g = paramdg.w();
        parambf.g(true);
      }
      if (localBitSet.get(7))
      {
        parambf.h = paramdg.z();
        parambf.h(true);
      }
      if (localBitSet.get(8))
      {
        parambf.i = al.a(paramdg.w());
        parambf.i(true);
      }
      if (localBitSet.get(9))
      {
        parambf.j = paramdg.z();
        parambf.j(true);
      }
    }
  }
  
  private static class d
    implements dp
  {
    public bf.c a()
    {
      return new bf.c(null);
    }
  }
  
  public static enum e
    implements co
  {
    private static final Map<String, e> k;
    private final short l;
    private final String m;
    
    static
    {
      k = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        k.put(locale.b(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.l = paramShort;
      this.m = paramString;
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
      case 4: 
        return d;
      case 5: 
        return e;
      case 6: 
        return f;
      case 7: 
        return g;
      case 8: 
        return h;
      case 9: 
        return i;
      }
      return j;
    }
    
    public static e a(String paramString)
    {
      return (e)k.get(paramString);
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
      return this.l;
    }
    
    public String b()
    {
      return this.m;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */