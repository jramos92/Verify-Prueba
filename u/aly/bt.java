package u.aly;

import android.os.AsyncTask;

public class bt
  extends bw
{
  private static final String a = bt.class.getName();
  
  public bv.a a(bu parambu)
  {
    parambu = (bv)a(parambu, bv.class);
    if (parambu == null) {
      return bv.a.b;
    }
    return parambu.a;
  }
  
  public void a(bu parambu, a parama)
  {
    try
    {
      new b(parambu, parama).execute(new Integer[0]);
      return;
    }
    catch (Exception parambu)
    {
      do
      {
        br.b(a, "", parambu);
      } while (parama == null);
      parama.a(bv.a.b);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(bv.a parama);
  }
  
  private class b
    extends AsyncTask<Integer, Integer, bv.a>
  {
    private bu b;
    private bt.a c;
    
    public b(bu parambu, bt.a parama)
    {
      this.b = parambu;
      this.c = parama;
    }
    
    protected bv.a a(Integer... paramVarArgs)
    {
      return bt.this.a(this.b);
    }
    
    protected void a(bv.a parama)
    {
      if (this.c != null) {
        this.c.a(parama);
      }
    }
    
    protected void onPreExecute()
    {
      if (this.c != null) {
        this.c.a();
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */