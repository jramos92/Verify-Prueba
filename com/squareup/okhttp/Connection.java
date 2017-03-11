package com.squareup.okhttp;

import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import okio.BufferedSink;
import okio.BufferedSource;

public final class Connection
{
  private boolean connected = false;
  private Handshake handshake;
  private HttpConnection httpConnection;
  private long idleStartTimeNs;
  private Object owner;
  private final ConnectionPool pool;
  private Protocol protocol = Protocol.HTTP_1_1;
  private int recycleCount;
  private final Route route;
  private Socket socket;
  private SpdyConnection spdyConnection;
  
  public Connection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    this.pool = paramConnectionPool;
    this.route = paramRoute;
  }
  
  boolean clearOwner()
  {
    synchronized (this.pool)
    {
      if (this.owner == null) {
        return false;
      }
      this.owner = null;
      return true;
    }
  }
  
  void closeIfOwnedBy(Object paramObject)
    throws IOException
  {
    if (isSpdy()) {
      throw new IllegalStateException();
    }
    synchronized (this.pool)
    {
      if (this.owner != paramObject) {
        return;
      }
      this.owner = null;
      this.socket.close();
      return;
    }
  }
  
  /* Error */
  void connect(int paramInt1, int paramInt2, int paramInt3, Request paramRequest, List<ConnectionSpec> paramList, boolean paramBoolean)
    throws RouteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/squareup/okhttp/Connection:connected	Z
    //   4: ifeq +13 -> 17
    //   7: new 58	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 73
    //   13: invokespecial 76	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 78	com/squareup/okhttp/internal/http/SocketConnector
    //   20: dup
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 42	com/squareup/okhttp/Connection:pool	Lcom/squareup/okhttp/ConnectionPool;
    //   26: invokespecial 81	com/squareup/okhttp/internal/http/SocketConnector:<init>	(Lcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/ConnectionPool;)V
    //   29: astore 7
    //   31: aload_0
    //   32: getfield 44	com/squareup/okhttp/Connection:route	Lcom/squareup/okhttp/Route;
    //   35: getfield 87	com/squareup/okhttp/Route:address	Lcom/squareup/okhttp/Address;
    //   38: invokevirtual 93	com/squareup/okhttp/Address:getSslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   41: ifnull +137 -> 178
    //   44: aload 7
    //   46: iload_1
    //   47: iload_2
    //   48: iload_3
    //   49: aload 4
    //   51: aload_0
    //   52: getfield 44	com/squareup/okhttp/Connection:route	Lcom/squareup/okhttp/Route;
    //   55: aload 5
    //   57: iload 6
    //   59: invokevirtual 97	com/squareup/okhttp/internal/http/SocketConnector:connectTls	(IIILcom/squareup/okhttp/Request;Lcom/squareup/okhttp/Route;Ljava/util/List;Z)Lcom/squareup/okhttp/internal/http/SocketConnector$ConnectedSocket;
    //   62: astore 4
    //   64: aload_0
    //   65: aload 4
    //   67: getfield 100	com/squareup/okhttp/internal/http/SocketConnector$ConnectedSocket:socket	Ljava/net/Socket;
    //   70: putfield 61	com/squareup/okhttp/Connection:socket	Ljava/net/Socket;
    //   73: aload_0
    //   74: aload 4
    //   76: getfield 102	com/squareup/okhttp/internal/http/SocketConnector$ConnectedSocket:handshake	Lcom/squareup/okhttp/Handshake;
    //   79: putfield 103	com/squareup/okhttp/Connection:handshake	Lcom/squareup/okhttp/Handshake;
    //   82: aload 4
    //   84: getfield 106	com/squareup/okhttp/internal/http/SocketConnector$ConnectedSocket:alpnProtocol	Lcom/squareup/okhttp/Protocol;
    //   87: ifnonnull +155 -> 242
    //   90: getstatic 38	com/squareup/okhttp/Protocol:HTTP_1_1	Lcom/squareup/okhttp/Protocol;
    //   93: astore 4
    //   95: aload_0
    //   96: aload 4
    //   98: putfield 40	com/squareup/okhttp/Connection:protocol	Lcom/squareup/okhttp/Protocol;
    //   101: aload_0
    //   102: getfield 40	com/squareup/okhttp/Connection:protocol	Lcom/squareup/okhttp/Protocol;
    //   105: getstatic 109	com/squareup/okhttp/Protocol:SPDY_3	Lcom/squareup/okhttp/Protocol;
    //   108: if_acmpeq +13 -> 121
    //   111: aload_0
    //   112: getfield 40	com/squareup/okhttp/Connection:protocol	Lcom/squareup/okhttp/Protocol;
    //   115: getstatic 112	com/squareup/okhttp/Protocol:HTTP_2	Lcom/squareup/okhttp/Protocol;
    //   118: if_acmpne +134 -> 252
    //   121: aload_0
    //   122: getfield 61	com/squareup/okhttp/Connection:socket	Ljava/net/Socket;
    //   125: iconst_0
    //   126: invokevirtual 116	java/net/Socket:setSoTimeout	(I)V
    //   129: aload_0
    //   130: new 118	com/squareup/okhttp/internal/spdy/SpdyConnection$Builder
    //   133: dup
    //   134: aload_0
    //   135: getfield 44	com/squareup/okhttp/Connection:route	Lcom/squareup/okhttp/Route;
    //   138: getfield 87	com/squareup/okhttp/Route:address	Lcom/squareup/okhttp/Address;
    //   141: getfield 122	com/squareup/okhttp/Address:uriHost	Ljava/lang/String;
    //   144: iconst_1
    //   145: aload_0
    //   146: getfield 61	com/squareup/okhttp/Connection:socket	Ljava/net/Socket;
    //   149: invokespecial 125	com/squareup/okhttp/internal/spdy/SpdyConnection$Builder:<init>	(Ljava/lang/String;ZLjava/net/Socket;)V
    //   152: aload_0
    //   153: getfield 40	com/squareup/okhttp/Connection:protocol	Lcom/squareup/okhttp/Protocol;
    //   156: invokevirtual 128	com/squareup/okhttp/internal/spdy/SpdyConnection$Builder:protocol	(Lcom/squareup/okhttp/Protocol;)Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;
    //   159: invokevirtual 132	com/squareup/okhttp/internal/spdy/SpdyConnection$Builder:build	()Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
    //   162: putfield 134	com/squareup/okhttp/Connection:spdyConnection	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
    //   165: aload_0
    //   166: getfield 134	com/squareup/okhttp/Connection:spdyConnection	Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
    //   169: invokevirtual 139	com/squareup/okhttp/internal/spdy/SpdyConnection:sendConnectionPreface	()V
    //   172: aload_0
    //   173: iconst_1
    //   174: putfield 33	com/squareup/okhttp/Connection:connected	Z
    //   177: return
    //   178: aload 5
    //   180: getstatic 145	com/squareup/okhttp/ConnectionSpec:CLEARTEXT	Lcom/squareup/okhttp/ConnectionSpec;
    //   183: invokeinterface 151 2 0
    //   188: ifne +38 -> 226
    //   191: new 71	com/squareup/okhttp/internal/http/RouteException
    //   194: dup
    //   195: new 153	java/net/UnknownServiceException
    //   198: dup
    //   199: new 155	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   206: ldc -98
    //   208: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 5
    //   213: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 170	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   222: invokespecial 173	com/squareup/okhttp/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   225: athrow
    //   226: aload 7
    //   228: iload_1
    //   229: iload_2
    //   230: aload_0
    //   231: getfield 44	com/squareup/okhttp/Connection:route	Lcom/squareup/okhttp/Route;
    //   234: invokevirtual 177	com/squareup/okhttp/internal/http/SocketConnector:connectCleartext	(IILcom/squareup/okhttp/Route;)Lcom/squareup/okhttp/internal/http/SocketConnector$ConnectedSocket;
    //   237: astore 4
    //   239: goto -175 -> 64
    //   242: aload 4
    //   244: getfield 106	com/squareup/okhttp/internal/http/SocketConnector$ConnectedSocket:alpnProtocol	Lcom/squareup/okhttp/Protocol;
    //   247: astore 4
    //   249: goto -154 -> 95
    //   252: aload_0
    //   253: new 179	com/squareup/okhttp/internal/http/HttpConnection
    //   256: dup
    //   257: aload_0
    //   258: getfield 42	com/squareup/okhttp/Connection:pool	Lcom/squareup/okhttp/ConnectionPool;
    //   261: aload_0
    //   262: aload_0
    //   263: getfield 61	com/squareup/okhttp/Connection:socket	Ljava/net/Socket;
    //   266: invokespecial 182	com/squareup/okhttp/internal/http/HttpConnection:<init>	(Lcom/squareup/okhttp/ConnectionPool;Lcom/squareup/okhttp/Connection;Ljava/net/Socket;)V
    //   269: putfield 184	com/squareup/okhttp/Connection:httpConnection	Lcom/squareup/okhttp/internal/http/HttpConnection;
    //   272: goto -100 -> 172
    //   275: astore 4
    //   277: new 71	com/squareup/okhttp/internal/http/RouteException
    //   280: dup
    //   281: aload 4
    //   283: invokespecial 173	com/squareup/okhttp/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   286: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	Connection
    //   0	287	1	paramInt1	int
    //   0	287	2	paramInt2	int
    //   0	287	3	paramInt3	int
    //   0	287	4	paramRequest	Request
    //   0	287	5	paramList	List<ConnectionSpec>
    //   0	287	6	paramBoolean	boolean
    //   29	198	7	localSocketConnector	com.squareup.okhttp.internal.http.SocketConnector
    // Exception table:
    //   from	to	target	type
    //   101	121	275	java/io/IOException
    //   121	172	275	java/io/IOException
    //   252	272	275	java/io/IOException
  }
  
  void connectAndSetOwner(OkHttpClient paramOkHttpClient, Object paramObject, Request paramRequest)
    throws RouteException
  {
    setOwner(paramObject);
    if (!isConnected())
    {
      paramObject = this.route.address.getConnectionSpecs();
      connect(paramOkHttpClient.getConnectTimeout(), paramOkHttpClient.getReadTimeout(), paramOkHttpClient.getWriteTimeout(), paramRequest, (List)paramObject, paramOkHttpClient.getRetryOnConnectionFailure());
      if (isSpdy()) {
        paramOkHttpClient.getConnectionPool().share(this);
      }
      paramOkHttpClient.routeDatabase().connected(getRoute());
    }
    setTimeouts(paramOkHttpClient.getReadTimeout(), paramOkHttpClient.getWriteTimeout());
  }
  
  public Handshake getHandshake()
  {
    return this.handshake;
  }
  
  long getIdleStartTimeNs()
  {
    if (this.spdyConnection == null) {
      return this.idleStartTimeNs;
    }
    return this.spdyConnection.getIdleStartTimeNs();
  }
  
  Object getOwner()
  {
    synchronized (this.pool)
    {
      Object localObject1 = this.owner;
      return localObject1;
    }
  }
  
  public Protocol getProtocol()
  {
    return this.protocol;
  }
  
  public Route getRoute()
  {
    return this.route;
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  void incrementRecycleCount()
  {
    this.recycleCount += 1;
  }
  
  boolean isAlive()
  {
    return (!this.socket.isClosed()) && (!this.socket.isInputShutdown()) && (!this.socket.isOutputShutdown());
  }
  
  boolean isConnected()
  {
    return this.connected;
  }
  
  boolean isIdle()
  {
    return (this.spdyConnection == null) || (this.spdyConnection.isIdle());
  }
  
  boolean isReadable()
  {
    if (this.httpConnection != null) {
      return this.httpConnection.isReadable();
    }
    return true;
  }
  
  boolean isSpdy()
  {
    return this.spdyConnection != null;
  }
  
  Transport newTransport(HttpEngine paramHttpEngine)
    throws IOException
  {
    if (this.spdyConnection != null) {
      return new SpdyTransport(paramHttpEngine, this.spdyConnection);
    }
    return new HttpTransport(paramHttpEngine, this.httpConnection);
  }
  
  BufferedSink rawSink()
  {
    if (this.httpConnection == null) {
      throw new UnsupportedOperationException();
    }
    return this.httpConnection.rawSink();
  }
  
  BufferedSource rawSource()
  {
    if (this.httpConnection == null) {
      throw new UnsupportedOperationException();
    }
    return this.httpConnection.rawSource();
  }
  
  int recycleCount()
  {
    return this.recycleCount;
  }
  
  void resetIdleStartTime()
  {
    if (this.spdyConnection != null) {
      throw new IllegalStateException("spdyConnection != null");
    }
    this.idleStartTimeNs = System.nanoTime();
  }
  
  void setOwner(Object paramObject)
  {
    if (isSpdy()) {
      return;
    }
    synchronized (this.pool)
    {
      if (this.owner != null) {
        throw new IllegalStateException("Connection already has an owner!");
      }
    }
    this.owner = paramObject;
  }
  
  void setProtocol(Protocol paramProtocol)
  {
    if (paramProtocol == null) {
      throw new IllegalArgumentException("protocol == null");
    }
    this.protocol = paramProtocol;
  }
  
  void setTimeouts(int paramInt1, int paramInt2)
    throws RouteException
  {
    if (!this.connected) {
      throw new IllegalStateException("setTimeouts - not connected");
    }
    if (this.httpConnection != null) {}
    try
    {
      this.socket.setSoTimeout(paramInt1);
      this.httpConnection.setTimeouts(paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      throw new RouteException(localIOException);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.route.address.uriHost).append(":").append(this.route.address.uriPort).append(", proxy=").append(this.route.proxy).append(" hostAddress=").append(this.route.inetSocketAddress.getAddress().getHostAddress()).append(" cipherSuite=");
    if (this.handshake != null) {}
    for (String str = this.handshake.cipherSuite();; str = "none") {
      return str + " protocol=" + this.protocol + '}';
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\squareup\okhttp\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */