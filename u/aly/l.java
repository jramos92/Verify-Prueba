package u.aly;

import android.content.Context;
import com.umeng.analytics.f;
import com.umeng.analytics.g;
import com.umeng.analytics.onlineconfig.a;
import com.umeng.analytics.onlineconfig.c;

public final class l
  implements p
{
  private static l c;
  private p a;
  private Context b;
  
  private l(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new k(this.b);
  }
  
  public static l a(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new l(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public void a()
  {
    f.b(new g()
    {
      public void a()
      {
        l.a(l.this).a();
      }
    });
  }
  
  public void a(a parama)
  {
    if ((parama != null) && (this.a != null)) {
      parama.a((c)this.a);
    }
  }
  
  public void a(p paramp)
  {
    this.a = paramp;
  }
  
  public void a(final q paramq)
  {
    f.b(new g()
    {
      public void a()
      {
        l.a(l.this).a(paramq);
      }
    });
  }
  
  public void b()
  {
    f.b(new g()
    {
      public void a()
      {
        l.a(l.this).b();
      }
    });
  }
  
  public void b(q paramq)
  {
    this.a.b(paramq);
  }
  
  public void c()
  {
    f.c(new g()
    {
      public void a()
      {
        l.a(l.this).c();
      }
    });
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */