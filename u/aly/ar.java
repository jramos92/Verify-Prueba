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

public class ar
  implements Serializable, Cloneable, ch<ar, e>
{
  private static final db A;
  private static final db B;
  private static final db C;
  private static final db D;
  private static final db E;
  private static final db F;
  private static final db G;
  private static final db H;
  private static final db I;
  private static final db J;
  private static final Map<Class<? extends do>, dp> K;
  private static final int L = 0;
  private static final int M = 1;
  private static final int N = 2;
  public static final Map<e, ct> r;
  private static final dl s = new dl("DeviceInfo");
  private static final db t = new db("device_id", (byte)11, (short)1);
  private static final db u = new db("idmd5", (byte)11, (short)2);
  private static final db v = new db("mac_address", (byte)11, (short)3);
  private static final db w = new db("open_udid", (byte)11, (short)4);
  private static final db x = new db("model", (byte)11, (short)5);
  private static final db y = new db("cpu", (byte)11, (short)6);
  private static final db z = new db("os", (byte)11, (short)7);
  private byte O = 0;
  private e[] P = { e.a, e.b, e.c, e.d, e.e, e.f, e.g, e.h, e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, e.q };
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public bi i;
  public boolean j;
  public boolean k;
  public String l;
  public String m;
  public long n;
  public String o;
  public String p;
  public String q;
  
  static
  {
    A = new db("os_version", (byte)11, (short)8);
    B = new db("resolution", (byte)12, (short)9);
    C = new db("is_jailbroken", (byte)2, (short)10);
    D = new db("is_pirated", (byte)2, (short)11);
    E = new db("device_board", (byte)11, (short)12);
    F = new db("device_brand", (byte)11, (short)13);
    G = new db("device_manutime", (byte)10, (short)14);
    H = new db("device_manufacturer", (byte)11, (short)15);
    I = new db("device_manuid", (byte)11, (short)16);
    J = new db("device_name", (byte)11, (short)17);
    K = new HashMap();
    K.put(dq.class, new b(null));
    K.put(dr.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new ct("device_id", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.b, new ct("idmd5", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.c, new ct("mac_address", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.d, new ct("open_udid", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.e, new ct("model", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.f, new ct("cpu", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.g, new ct("os", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.h, new ct("os_version", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.i, new ct("resolution", (byte)2, new cy((byte)12, bi.class)));
    localEnumMap.put(e.j, new ct("is_jailbroken", (byte)2, new cu((byte)2)));
    localEnumMap.put(e.k, new ct("is_pirated", (byte)2, new cu((byte)2)));
    localEnumMap.put(e.l, new ct("device_board", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.m, new ct("device_brand", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.n, new ct("device_manutime", (byte)2, new cu((byte)10)));
    localEnumMap.put(e.o, new ct("device_manufacturer", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.p, new ct("device_manuid", (byte)2, new cu((byte)11)));
    localEnumMap.put(e.q, new ct("device_name", (byte)2, new cu((byte)11)));
    r = Collections.unmodifiableMap(localEnumMap);
    ct.a(ar.class, r);
  }
  
  public ar() {}
  
  public ar(ar paramar)
  {
    this.O = paramar.O;
    if (paramar.e()) {
      this.a = paramar.a;
    }
    if (paramar.i()) {
      this.b = paramar.b;
    }
    if (paramar.l()) {
      this.c = paramar.c;
    }
    if (paramar.o()) {
      this.d = paramar.d;
    }
    if (paramar.r()) {
      this.e = paramar.e;
    }
    if (paramar.u()) {
      this.f = paramar.f;
    }
    if (paramar.x()) {
      this.g = paramar.g;
    }
    if (paramar.A()) {
      this.h = paramar.h;
    }
    if (paramar.D()) {
      this.i = new bi(paramar.i);
    }
    this.j = paramar.j;
    this.k = paramar.k;
    if (paramar.M()) {
      this.l = paramar.l;
    }
    if (paramar.P()) {
      this.m = paramar.m;
    }
    this.n = paramar.n;
    if (paramar.V()) {
      this.o = paramar.o;
    }
    if (paramar.Y()) {
      this.p = paramar.p;
    }
    if (paramar.ab()) {
      this.q = paramar.q;
    }
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.O = 0;
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
  
  public bi B()
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
  
  public boolean E()
  {
    return this.j;
  }
  
  public void F()
  {
    this.O = ce.b(this.O, 0);
  }
  
  public boolean G()
  {
    return ce.a(this.O, 0);
  }
  
  public boolean H()
  {
    return this.k;
  }
  
  public void I()
  {
    this.O = ce.b(this.O, 1);
  }
  
  public boolean J()
  {
    return ce.a(this.O, 1);
  }
  
  public String K()
  {
    return this.l;
  }
  
  public void L()
  {
    this.l = null;
  }
  
  public boolean M()
  {
    return this.l != null;
  }
  
  public String N()
  {
    return this.m;
  }
  
  public void O()
  {
    this.m = null;
  }
  
  public boolean P()
  {
    return this.m != null;
  }
  
  public long Q()
  {
    return this.n;
  }
  
  public void R()
  {
    this.O = ce.b(this.O, 2);
  }
  
  public boolean S()
  {
    return ce.a(this.O, 2);
  }
  
  public String T()
  {
    return this.o;
  }
  
  public void U()
  {
    this.o = null;
  }
  
  public boolean V()
  {
    return this.o != null;
  }
  
  public String W()
  {
    return this.p;
  }
  
  public void X()
  {
    this.p = null;
  }
  
  public boolean Y()
  {
    return this.p != null;
  }
  
  public String Z()
  {
    return this.q;
  }
  
  public e a(int paramInt)
  {
    return e.a(paramInt);
  }
  
  public ar a()
  {
    return new ar(this);
  }
  
  public ar a(long paramLong)
  {
    this.n = paramLong;
    p(true);
    return this;
  }
  
  public ar a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ar a(bi parambi)
  {
    this.i = parambi;
    return this;
  }
  
  public void a(dg paramdg)
    throws cn
  {
    ((dp)K.get(paramdg.D())).b().b(paramdg, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public void aa()
  {
    this.q = null;
  }
  
  public boolean ab()
  {
    return this.q != null;
  }
  
  public void ac()
    throws cn
  {
    if (this.i != null) {
      this.i.j();
    }
  }
  
  public ar b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    k(false);
    this.j = false;
    m(false);
    this.k = false;
    this.l = null;
    this.m = null;
    p(false);
    this.n = 0L;
    this.o = null;
    this.p = null;
    this.q = null;
  }
  
  public void b(dg paramdg)
    throws cn
  {
    ((dp)K.get(paramdg.D())).b().a(paramdg, this);
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
  
  public ar c(String paramString)
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
  
  public ar d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void d()
  {
    this.a = null;
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.d = null;
    }
  }
  
  public ar e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.e = null;
    }
  }
  
  public boolean e()
  {
    return this.a != null;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public ar f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public void f(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.f = null;
    }
  }
  
  public ar g(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public void g(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.g = null;
    }
  }
  
  public ar h(String paramString)
  {
    this.h = paramString;
    return this;
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
  
  public ar i(String paramString)
  {
    this.l = paramString;
    return this;
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
  
  public ar j(String paramString)
  {
    this.m = paramString;
    return this;
  }
  
  public ar j(boolean paramBoolean)
  {
    this.j = paramBoolean;
    k(true);
    return this;
  }
  
  public ar k(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public void k()
  {
    this.c = null;
  }
  
  public void k(boolean paramBoolean)
  {
    this.O = ce.a(this.O, 0, paramBoolean);
  }
  
  public ar l(String paramString)
  {
    this.p = paramString;
    return this;
  }
  
  public ar l(boolean paramBoolean)
  {
    this.k = paramBoolean;
    m(true);
    return this;
  }
  
  public boolean l()
  {
    return this.c != null;
  }
  
  public String m()
  {
    return this.d;
  }
  
  public ar m(String paramString)
  {
    this.q = paramString;
    return this;
  }
  
  public void m(boolean paramBoolean)
  {
    this.O = ce.a(this.O, 1, paramBoolean);
  }
  
  public void n()
  {
    this.d = null;
  }
  
  public void n(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.l = null;
    }
  }
  
  public void o(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.m = null;
    }
  }
  
  public boolean o()
  {
    return this.d != null;
  }
  
  public String p()
  {
    return this.e;
  }
  
  public void p(boolean paramBoolean)
  {
    this.O = ce.a(this.O, 2, paramBoolean);
  }
  
  public void q()
  {
    this.e = null;
  }
  
  public void q(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.o = null;
    }
  }
  
  public void r(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.p = null;
    }
  }
  
  public boolean r()
  {
    return this.e != null;
  }
  
  public String s()
  {
    return this.f;
  }
  
  public void s(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.q = null;
    }
  }
  
  public void t()
  {
    this.f = null;
  }
  
  public String toString()
  {
    int i3 = 0;
    StringBuilder localStringBuilder = new StringBuilder("DeviceInfo(");
    int i2 = 1;
    int i1;
    if (e())
    {
      localStringBuilder.append("device_id:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      i1 = i2;
      if (i())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("idmd5:");
        if (this.b != null) {
          break label838;
        }
        localStringBuilder.append("null");
        label97:
        i1 = 0;
      }
      i2 = i1;
      if (l())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("mac_address:");
        if (this.c != null) {
          break label851;
        }
        localStringBuilder.append("null");
        label146:
        i2 = 0;
      }
      i1 = i2;
      if (o())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("open_udid:");
        if (this.d != null) {
          break label864;
        }
        localStringBuilder.append("null");
        label195:
        i1 = 0;
      }
      i2 = i1;
      if (r())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("model:");
        if (this.e != null) {
          break label877;
        }
        localStringBuilder.append("null");
        label244:
        i2 = 0;
      }
      i1 = i2;
      if (u())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("cpu:");
        if (this.f != null) {
          break label890;
        }
        localStringBuilder.append("null");
        label293:
        i1 = 0;
      }
      i2 = i1;
      if (x())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("os:");
        if (this.g != null) {
          break label903;
        }
        localStringBuilder.append("null");
        label342:
        i2 = 0;
      }
      i1 = i2;
      if (A())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("os_version:");
        if (this.h != null) {
          break label916;
        }
        localStringBuilder.append("null");
        label391:
        i1 = 0;
      }
      i2 = i1;
      if (D())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("resolution:");
        if (this.i != null) {
          break label929;
        }
        localStringBuilder.append("null");
        label440:
        i2 = 0;
      }
      i1 = i2;
      if (G())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("is_jailbroken:");
        localStringBuilder.append(this.j);
        i1 = 0;
      }
      i2 = i1;
      if (J())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("is_pirated:");
        localStringBuilder.append(this.k);
        i2 = 0;
      }
      i1 = i2;
      if (M())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_board:");
        if (this.l != null) {
          break label942;
        }
        localStringBuilder.append("null");
        label575:
        i1 = 0;
      }
      i2 = i1;
      if (P())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_brand:");
        if (this.m != null) {
          break label955;
        }
        localStringBuilder.append("null");
        label624:
        i2 = 0;
      }
      i1 = i2;
      if (S())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_manutime:");
        localStringBuilder.append(this.n);
        i1 = 0;
      }
      i2 = i1;
      if (V())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_manufacturer:");
        if (this.o != null) {
          break label968;
        }
        localStringBuilder.append("null");
        label716:
        i2 = 0;
      }
      if (!Y()) {
        break label1009;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("device_manuid:");
      if (this.p != null) {
        break label981;
      }
      localStringBuilder.append("null");
      i1 = i3;
    }
    for (;;)
    {
      label765:
      if (ab())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_name:");
        if (this.q != null) {
          break label996;
        }
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label838:
        localStringBuilder.append(this.b);
        break label97;
        label851:
        localStringBuilder.append(this.c);
        break label146;
        label864:
        localStringBuilder.append(this.d);
        break label195;
        label877:
        localStringBuilder.append(this.e);
        break label244;
        label890:
        localStringBuilder.append(this.f);
        break label293;
        label903:
        localStringBuilder.append(this.g);
        break label342;
        label916:
        localStringBuilder.append(this.h);
        break label391;
        label929:
        localStringBuilder.append(this.i);
        break label440;
        label942:
        localStringBuilder.append(this.l);
        break label575;
        label955:
        localStringBuilder.append(this.m);
        break label624;
        label968:
        localStringBuilder.append(this.o);
        break label716;
        label981:
        localStringBuilder.append(this.p);
        i1 = i3;
        break label765;
        label996:
        localStringBuilder.append(this.q);
      }
      label1009:
      i1 = i2;
    }
  }
  
  public boolean u()
  {
    return this.f != null;
  }
  
  public String v()
  {
    return this.g;
  }
  
  public void w()
  {
    this.g = null;
  }
  
  public boolean x()
  {
    return this.g != null;
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
    extends dq<ar>
  {
    public void a(dg paramdg, ar paramar)
      throws cn
    {
      paramdg.j();
      db localdb = paramdg.l();
      if (localdb.b == 0)
      {
        paramdg.k();
        paramar.ac();
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
        if (localdb.b == 11)
        {
          paramar.a = paramdg.z();
          paramar.a(true);
        }
        else
        {
          dj.a(paramdg, localdb.b);
          continue;
          if (localdb.b == 11)
          {
            paramar.b = paramdg.z();
            paramar.b(true);
          }
          else
          {
            dj.a(paramdg, localdb.b);
            continue;
            if (localdb.b == 11)
            {
              paramar.c = paramdg.z();
              paramar.c(true);
            }
            else
            {
              dj.a(paramdg, localdb.b);
              continue;
              if (localdb.b == 11)
              {
                paramar.d = paramdg.z();
                paramar.d(true);
              }
              else
              {
                dj.a(paramdg, localdb.b);
                continue;
                if (localdb.b == 11)
                {
                  paramar.e = paramdg.z();
                  paramar.e(true);
                }
                else
                {
                  dj.a(paramdg, localdb.b);
                  continue;
                  if (localdb.b == 11)
                  {
                    paramar.f = paramdg.z();
                    paramar.f(true);
                  }
                  else
                  {
                    dj.a(paramdg, localdb.b);
                    continue;
                    if (localdb.b == 11)
                    {
                      paramar.g = paramdg.z();
                      paramar.g(true);
                    }
                    else
                    {
                      dj.a(paramdg, localdb.b);
                      continue;
                      if (localdb.b == 11)
                      {
                        paramar.h = paramdg.z();
                        paramar.h(true);
                      }
                      else
                      {
                        dj.a(paramdg, localdb.b);
                        continue;
                        if (localdb.b == 12)
                        {
                          paramar.i = new bi();
                          paramar.i.a(paramdg);
                          paramar.i(true);
                        }
                        else
                        {
                          dj.a(paramdg, localdb.b);
                          continue;
                          if (localdb.b == 2)
                          {
                            paramar.j = paramdg.t();
                            paramar.k(true);
                          }
                          else
                          {
                            dj.a(paramdg, localdb.b);
                            continue;
                            if (localdb.b == 2)
                            {
                              paramar.k = paramdg.t();
                              paramar.m(true);
                            }
                            else
                            {
                              dj.a(paramdg, localdb.b);
                              continue;
                              if (localdb.b == 11)
                              {
                                paramar.l = paramdg.z();
                                paramar.n(true);
                              }
                              else
                              {
                                dj.a(paramdg, localdb.b);
                                continue;
                                if (localdb.b == 11)
                                {
                                  paramar.m = paramdg.z();
                                  paramar.o(true);
                                }
                                else
                                {
                                  dj.a(paramdg, localdb.b);
                                  continue;
                                  if (localdb.b == 10)
                                  {
                                    paramar.n = paramdg.x();
                                    paramar.p(true);
                                  }
                                  else
                                  {
                                    dj.a(paramdg, localdb.b);
                                    continue;
                                    if (localdb.b == 11)
                                    {
                                      paramar.o = paramdg.z();
                                      paramar.q(true);
                                    }
                                    else
                                    {
                                      dj.a(paramdg, localdb.b);
                                      continue;
                                      if (localdb.b == 11)
                                      {
                                        paramar.p = paramdg.z();
                                        paramar.r(true);
                                      }
                                      else
                                      {
                                        dj.a(paramdg, localdb.b);
                                        continue;
                                        if (localdb.b == 11)
                                        {
                                          paramar.q = paramdg.z();
                                          paramar.s(true);
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
                }
              }
            }
          }
        }
      }
    }
    
    public void b(dg paramdg, ar paramar)
      throws cn
    {
      paramar.ac();
      paramdg.a(ar.ad());
      if ((paramar.a != null) && (paramar.e()))
      {
        paramdg.a(ar.ae());
        paramdg.a(paramar.a);
        paramdg.c();
      }
      if ((paramar.b != null) && (paramar.i()))
      {
        paramdg.a(ar.af());
        paramdg.a(paramar.b);
        paramdg.c();
      }
      if ((paramar.c != null) && (paramar.l()))
      {
        paramdg.a(ar.ag());
        paramdg.a(paramar.c);
        paramdg.c();
      }
      if ((paramar.d != null) && (paramar.o()))
      {
        paramdg.a(ar.ah());
        paramdg.a(paramar.d);
        paramdg.c();
      }
      if ((paramar.e != null) && (paramar.r()))
      {
        paramdg.a(ar.ai());
        paramdg.a(paramar.e);
        paramdg.c();
      }
      if ((paramar.f != null) && (paramar.u()))
      {
        paramdg.a(ar.aj());
        paramdg.a(paramar.f);
        paramdg.c();
      }
      if ((paramar.g != null) && (paramar.x()))
      {
        paramdg.a(ar.ak());
        paramdg.a(paramar.g);
        paramdg.c();
      }
      if ((paramar.h != null) && (paramar.A()))
      {
        paramdg.a(ar.al());
        paramdg.a(paramar.h);
        paramdg.c();
      }
      if ((paramar.i != null) && (paramar.D()))
      {
        paramdg.a(ar.am());
        paramar.i.b(paramdg);
        paramdg.c();
      }
      if (paramar.G())
      {
        paramdg.a(ar.an());
        paramdg.a(paramar.j);
        paramdg.c();
      }
      if (paramar.J())
      {
        paramdg.a(ar.ao());
        paramdg.a(paramar.k);
        paramdg.c();
      }
      if ((paramar.l != null) && (paramar.M()))
      {
        paramdg.a(ar.ap());
        paramdg.a(paramar.l);
        paramdg.c();
      }
      if ((paramar.m != null) && (paramar.P()))
      {
        paramdg.a(ar.aq());
        paramdg.a(paramar.m);
        paramdg.c();
      }
      if (paramar.S())
      {
        paramdg.a(ar.ar());
        paramdg.a(paramar.n);
        paramdg.c();
      }
      if ((paramar.o != null) && (paramar.V()))
      {
        paramdg.a(ar.as());
        paramdg.a(paramar.o);
        paramdg.c();
      }
      if ((paramar.p != null) && (paramar.Y()))
      {
        paramdg.a(ar.at());
        paramdg.a(paramar.p);
        paramdg.c();
      }
      if ((paramar.q != null) && (paramar.ab()))
      {
        paramdg.a(ar.au());
        paramdg.a(paramar.q);
        paramdg.c();
      }
      paramdg.d();
      paramdg.b();
    }
  }
  
  private static class b
    implements dp
  {
    public ar.a a()
    {
      return new ar.a(null);
    }
  }
  
  private static class c
    extends dr<ar>
  {
    public void a(dg paramdg, ar paramar)
      throws cn
    {
      paramdg = (dm)paramdg;
      BitSet localBitSet = new BitSet();
      if (paramar.e()) {
        localBitSet.set(0);
      }
      if (paramar.i()) {
        localBitSet.set(1);
      }
      if (paramar.l()) {
        localBitSet.set(2);
      }
      if (paramar.o()) {
        localBitSet.set(3);
      }
      if (paramar.r()) {
        localBitSet.set(4);
      }
      if (paramar.u()) {
        localBitSet.set(5);
      }
      if (paramar.x()) {
        localBitSet.set(6);
      }
      if (paramar.A()) {
        localBitSet.set(7);
      }
      if (paramar.D()) {
        localBitSet.set(8);
      }
      if (paramar.G()) {
        localBitSet.set(9);
      }
      if (paramar.J()) {
        localBitSet.set(10);
      }
      if (paramar.M()) {
        localBitSet.set(11);
      }
      if (paramar.P()) {
        localBitSet.set(12);
      }
      if (paramar.S()) {
        localBitSet.set(13);
      }
      if (paramar.V()) {
        localBitSet.set(14);
      }
      if (paramar.Y()) {
        localBitSet.set(15);
      }
      if (paramar.ab()) {
        localBitSet.set(16);
      }
      paramdg.a(localBitSet, 17);
      if (paramar.e()) {
        paramdg.a(paramar.a);
      }
      if (paramar.i()) {
        paramdg.a(paramar.b);
      }
      if (paramar.l()) {
        paramdg.a(paramar.c);
      }
      if (paramar.o()) {
        paramdg.a(paramar.d);
      }
      if (paramar.r()) {
        paramdg.a(paramar.e);
      }
      if (paramar.u()) {
        paramdg.a(paramar.f);
      }
      if (paramar.x()) {
        paramdg.a(paramar.g);
      }
      if (paramar.A()) {
        paramdg.a(paramar.h);
      }
      if (paramar.D()) {
        paramar.i.b(paramdg);
      }
      if (paramar.G()) {
        paramdg.a(paramar.j);
      }
      if (paramar.J()) {
        paramdg.a(paramar.k);
      }
      if (paramar.M()) {
        paramdg.a(paramar.l);
      }
      if (paramar.P()) {
        paramdg.a(paramar.m);
      }
      if (paramar.S()) {
        paramdg.a(paramar.n);
      }
      if (paramar.V()) {
        paramdg.a(paramar.o);
      }
      if (paramar.Y()) {
        paramdg.a(paramar.p);
      }
      if (paramar.ab()) {
        paramdg.a(paramar.q);
      }
    }
    
    public void b(dg paramdg, ar paramar)
      throws cn
    {
      paramdg = (dm)paramdg;
      BitSet localBitSet = paramdg.b(17);
      if (localBitSet.get(0))
      {
        paramar.a = paramdg.z();
        paramar.a(true);
      }
      if (localBitSet.get(1))
      {
        paramar.b = paramdg.z();
        paramar.b(true);
      }
      if (localBitSet.get(2))
      {
        paramar.c = paramdg.z();
        paramar.c(true);
      }
      if (localBitSet.get(3))
      {
        paramar.d = paramdg.z();
        paramar.d(true);
      }
      if (localBitSet.get(4))
      {
        paramar.e = paramdg.z();
        paramar.e(true);
      }
      if (localBitSet.get(5))
      {
        paramar.f = paramdg.z();
        paramar.f(true);
      }
      if (localBitSet.get(6))
      {
        paramar.g = paramdg.z();
        paramar.g(true);
      }
      if (localBitSet.get(7))
      {
        paramar.h = paramdg.z();
        paramar.h(true);
      }
      if (localBitSet.get(8))
      {
        paramar.i = new bi();
        paramar.i.a(paramdg);
        paramar.i(true);
      }
      if (localBitSet.get(9))
      {
        paramar.j = paramdg.t();
        paramar.k(true);
      }
      if (localBitSet.get(10))
      {
        paramar.k = paramdg.t();
        paramar.m(true);
      }
      if (localBitSet.get(11))
      {
        paramar.l = paramdg.z();
        paramar.n(true);
      }
      if (localBitSet.get(12))
      {
        paramar.m = paramdg.z();
        paramar.o(true);
      }
      if (localBitSet.get(13))
      {
        paramar.n = paramdg.x();
        paramar.p(true);
      }
      if (localBitSet.get(14))
      {
        paramar.o = paramdg.z();
        paramar.q(true);
      }
      if (localBitSet.get(15))
      {
        paramar.p = paramdg.z();
        paramar.r(true);
      }
      if (localBitSet.get(16))
      {
        paramar.q = paramdg.z();
        paramar.s(true);
      }
    }
  }
  
  private static class d
    implements dp
  {
    public ar.c a()
    {
      return new ar.c(null);
    }
  }
  
  public static enum e
    implements co
  {
    private static final Map<String, e> r;
    private final short s;
    private final String t;
    
    static
    {
      r = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        r.put(locale.b(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.s = paramShort;
      this.t = paramString;
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
      case 10: 
        return j;
      case 11: 
        return k;
      case 12: 
        return l;
      case 13: 
        return m;
      case 14: 
        return n;
      case 15: 
        return o;
      case 16: 
        return p;
      }
      return q;
    }
    
    public static e a(String paramString)
    {
      return (e)r.get(paramString);
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
      return this.s;
    }
    
    public String b()
    {
      return this.t;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */