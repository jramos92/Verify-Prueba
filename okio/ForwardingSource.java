package okio;

import java.io.IOException;

public abstract class ForwardingSource
  implements Source
{
  private final Source delegate;
  
  public ForwardingSource(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.delegate = paramSource;
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public final Source delegate()
  {
    return this.delegate;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    return this.delegate.read(paramBuffer, paramLong);
  }
  
  public Timeout timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\okio\ForwardingSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */