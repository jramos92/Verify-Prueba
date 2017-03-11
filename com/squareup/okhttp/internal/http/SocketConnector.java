package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Source;

public class SocketConnector
{
  private final Connection connection;
  private final ConnectionPool connectionPool;
  
  public SocketConnector(Connection paramConnection, ConnectionPool paramConnectionPool)
  {
    this.connection = paramConnection;
    this.connectionPool = paramConnectionPool;
  }
  
  /* Error */
  private Socket connectRawSocket(int paramInt1, int paramInt2, Route paramRoute)
    throws RouteException
  {
    // Byte code:
    //   0: invokestatic 33	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   3: astore 5
    //   5: aload_3
    //   6: invokevirtual 39	com/squareup/okhttp/Route:getProxy	()Ljava/net/Proxy;
    //   9: astore 4
    //   11: aload_3
    //   12: invokevirtual 43	com/squareup/okhttp/Route:getAddress	()Lcom/squareup/okhttp/Address;
    //   15: astore 6
    //   17: aload 4
    //   19: invokevirtual 49	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   22: getstatic 55	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   25: if_acmpeq +14 -> 39
    //   28: aload 4
    //   30: invokevirtual 49	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   33: getstatic 58	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   36: if_acmpne +34 -> 70
    //   39: aload 6
    //   41: invokevirtual 64	com/squareup/okhttp/Address:getSocketFactory	()Ljavax/net/SocketFactory;
    //   44: invokevirtual 70	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   47: astore 4
    //   49: aload 4
    //   51: iload_1
    //   52: invokevirtual 76	java/net/Socket:setSoTimeout	(I)V
    //   55: aload 5
    //   57: aload 4
    //   59: aload_3
    //   60: invokevirtual 80	com/squareup/okhttp/Route:getSocketAddress	()Ljava/net/InetSocketAddress;
    //   63: iload_2
    //   64: invokevirtual 84	com/squareup/okhttp/internal/Platform:connectSocket	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   67: aload 4
    //   69: areturn
    //   70: new 72	java/net/Socket
    //   73: dup
    //   74: aload 4
    //   76: invokespecial 87	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   79: astore 4
    //   81: goto -32 -> 49
    //   84: astore_3
    //   85: new 25	com/squareup/okhttp/internal/http/RouteException
    //   88: dup
    //   89: aload_3
    //   90: invokespecial 90	com/squareup/okhttp/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	SocketConnector
    //   0	94	1	paramInt1	int
    //   0	94	2	paramInt2	int
    //   0	94	3	paramRoute	Route
    //   9	71	4	localObject	Object
    //   3	53	5	localPlatform	Platform
    //   15	25	6	localAddress	Address
    // Exception table:
    //   from	to	target	type
    //   5	39	84	java/io/IOException
    //   39	49	84	java/io/IOException
    //   49	67	84	java/io/IOException
    //   70	81	84	java/io/IOException
  }
  
  private void createTunnel(int paramInt1, int paramInt2, Request paramRequest, Route paramRoute, Socket paramSocket)
    throws RouteException
  {
    for (;;)
    {
      HttpConnection localHttpConnection;
      try
      {
        paramRequest = createTunnelRequest(paramRequest);
        localHttpConnection = new HttpConnection(this.connectionPool, this.connection, paramSocket);
        localHttpConnection.setTimeouts(paramInt1, paramInt2);
        paramSocket = paramRequest.url();
        String str = "CONNECT " + paramSocket.getHost() + ":" + Util.getEffectivePort(paramSocket) + " HTTP/1.1";
        localHttpConnection.writeRequest(paramRequest.headers(), str);
        localHttpConnection.flush();
        paramRequest = localHttpConnection.readResponse().request(paramRequest).build();
        long l2 = OkHeaders.contentLength(paramRequest);
        long l1 = l2;
        if (l2 == -1L) {
          l1 = 0L;
        }
        paramSocket = localHttpConnection.newFixedLengthSource(l1);
        Util.skipAll(paramSocket, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        paramSocket.close();
        switch (paramRequest.code())
        {
        case 200: 
          throw new IOException("Unexpected response code for CONNECT: " + paramRequest.code());
        }
      }
      catch (IOException paramRequest)
      {
        throw new RouteException(paramRequest);
      }
      if (localHttpConnection.bufferSize() > 0L)
      {
        throw new IOException("TLS tunnel buffered too many bytes!");
        paramSocket = OkHeaders.processAuthHeader(paramRoute.getAddress().getAuthenticator(), paramRequest, paramRoute.getProxy());
        paramRequest = paramSocket;
        if (paramSocket == null) {
          throw new IOException("Failed to authenticate with proxy");
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private Request createTunnelRequest(Request paramRequest)
    throws IOException
  {
    String str = paramRequest.url().getHost();
    int i = Util.getEffectivePort(paramRequest.url());
    if (i == Util.getDefaultPort("https")) {}
    for (Object localObject = str;; localObject = str + ":" + i)
    {
      localObject = new Request.Builder().url(new URL("https", str, i, "/")).header("Host", (String)localObject).header("Proxy-Connection", "Keep-Alive");
      str = paramRequest.header("User-Agent");
      if (str != null) {
        ((Request.Builder)localObject).header("User-Agent", str);
      }
      paramRequest = paramRequest.header("Proxy-Authorization");
      if (paramRequest != null) {
        ((Request.Builder)localObject).header("Proxy-Authorization", paramRequest);
      }
      return ((Request.Builder)localObject).build();
    }
  }
  
  public ConnectedSocket connectCleartext(int paramInt1, int paramInt2, Route paramRoute)
    throws RouteException
  {
    return new ConnectedSocket(paramRoute, connectRawSocket(paramInt2, paramInt1, paramRoute));
  }
  
  public ConnectedSocket connectTls(int paramInt1, int paramInt2, int paramInt3, Request paramRequest, Route paramRoute, List<ConnectionSpec> paramList, boolean paramBoolean)
    throws RouteException
  {
    Address localAddress = paramRoute.getAddress();
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector(paramList);
    paramList = null;
    Socket localSocket = connectRawSocket(paramInt2, paramInt1, paramRoute);
    if (paramRoute.requiresTunnel()) {
      createTunnel(paramInt2, paramInt3, paramRequest, paramRoute, localSocket);
    }
    Object localObject1 = null;
    SSLSocket localSSLSocket;
    Handshake localHandshake;
    try
    {
      localSSLSocket = (SSLSocket)localAddress.getSslSocketFactory().createSocket(localSocket, localAddress.getUriHost(), localAddress.getUriPort(), true);
      localObject1 = localSSLSocket;
      Object localObject3 = localConnectionSpecSelector.configureSecureSocket(localSSLSocket);
      localObject1 = localSSLSocket;
      localPlatform = Platform.get();
      localObject1 = null;
      Object localObject2;
      if (!localConnectionSpecSelector.connectionFailed(localIOException)) {
        break label454;
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        if (((ConnectionSpec)localObject3).supportsTlsExtensions()) {
          localPlatform.configureTlsExtensions(localSSLSocket, localAddress.getUriHost(), localAddress.getProtocols());
        }
        localSSLSocket.startHandshake();
        localHandshake = Handshake.get(localSSLSocket.getSession());
        localObject2 = localObject1;
        if (((ConnectionSpec)localObject3).supportsTlsExtensions())
        {
          localObject3 = localPlatform.getSelectedProtocol(localSSLSocket);
          localObject2 = localObject1;
          if (localObject3 != null) {
            localObject2 = Protocol.get((String)localObject3);
          }
        }
        localObject1 = localSSLSocket;
        localPlatform.afterHandshake(localSSLSocket);
        localObject1 = localSSLSocket;
        if (localAddress.getHostnameVerifier().verify(localAddress.getUriHost(), localSSLSocket.getSession())) {
          break label408;
        }
        localObject1 = localSSLSocket;
        localObject2 = (X509Certificate)localSSLSocket.getSession().getPeerCertificates()[0];
        localObject1 = localSSLSocket;
        throw new SSLPeerUnverifiedException("Hostname " + localAddress.getUriHost() + " not verified:" + "\n    certificate: " + CertificatePinner.pin((Certificate)localObject2) + "\n    DN: " + ((X509Certificate)localObject2).getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames((X509Certificate)localObject2));
      }
      finally
      {
        Platform localPlatform;
        localObject1 = localSSLSocket;
        localPlatform.afterHandshake(localSSLSocket);
        localObject1 = localSSLSocket;
      }
      localIOException = localIOException;
      if (!paramBoolean) {
        break label454;
      }
    }
    int i = 1;
    label350:
    Util.closeQuietly((Socket)localObject1);
    Util.closeQuietly(localSocket);
    if (paramList == null) {}
    for (localObject1 = new RouteException(localIOException);; localObject1 = paramList)
    {
      paramList = (List<ConnectionSpec>)localObject1;
      if (i != 0) {
        break;
      }
      throw ((Throwable)localObject1);
      label408:
      localObject1 = localSSLSocket;
      localAddress.getCertificatePinner().check(localAddress.getUriHost(), localHandshake.peerCertificates());
      localObject1 = localSSLSocket;
      ConnectedSocket localConnectedSocket = new ConnectedSocket(paramRoute, localSSLSocket, localProtocol, localHandshake);
      return localConnectedSocket;
      label454:
      i = 0;
      break label350;
      paramList.addConnectException(localConnectedSocket);
    }
  }
  
  public static class ConnectedSocket
  {
    public final Protocol alpnProtocol;
    public final Handshake handshake;
    public final Route route;
    public final Socket socket;
    
    public ConnectedSocket(Route paramRoute, Socket paramSocket)
    {
      this.route = paramRoute;
      this.socket = paramSocket;
      this.alpnProtocol = null;
      this.handshake = null;
    }
    
    public ConnectedSocket(Route paramRoute, SSLSocket paramSSLSocket, Protocol paramProtocol, Handshake paramHandshake)
    {
      this.route = paramRoute;
      this.socket = paramSSLSocket;
      this.alpnProtocol = paramProtocol;
      this.handshake = paramHandshake;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\squareup\okhttp\internal\http\SocketConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */