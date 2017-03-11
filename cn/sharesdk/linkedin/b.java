package cn.sharesdk.linkedin;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.e;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

public class b
  extends e
{
  private static final String[] b = { "r_basicprofile", "r_emailaddress", "rw_company_admin", "w_share" };
  private static b c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String[] h;
  
  private b(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static b a(Platform paramPlatform)
  {
    if (c == null) {
      c = new b(paramPlatform);
    }
    return c;
  }
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = (HttpURLConnection)new URL(paramString1).openConnection();
    ((HttpURLConnection)localObject).setRequestMethod("POST");
    ((HttpURLConnection)localObject).setDoOutput(true);
    ((HttpURLConnection)localObject).setRequestProperty("Content-Type", "application/xml");
    paramString1 = new PrintWriter(new OutputStreamWriter(((HttpURLConnection)localObject).getOutputStream(), "UTF-8"));
    paramString1.print(paramString2);
    paramString1.flush();
    paramString1.close();
    ((HttpURLConnection)localObject).connect();
    if (((HttpURLConnection)localObject).getResponseCode() != paramInt) {}
    for (paramString1 = ((HttpURLConnection)localObject).getErrorStream();; paramString1 = ((HttpURLConnection)localObject).getInputStream())
    {
      paramString2 = paramString1;
      if ("gzip".equalsIgnoreCase(((HttpURLConnection)localObject).getContentEncoding())) {
        paramString2 = new GZIPInputStream(paramString1);
      }
      paramString2 = new BufferedReader(new InputStreamReader(paramString2, "UTF-8"));
      localObject = new StringBuilder();
      for (paramString1 = paramString2.readLine(); paramString1 != null; paramString1 = paramString2.readLine()) {
        ((StringBuilder)localObject).append(paramString1).append("\n");
      }
    }
    paramString2.close();
    return ((StringBuilder)localObject).toString();
  }
  
  private String e(String paramString)
  {
    return paramString + "?format=json&oauth2_access_token=" + this.g;
  }
  
  public String a()
  {
    return "dO21p12N1kD1J2w3nA";
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<share>");
    localStringBuilder.append("<comment>").append(paramString5).append("</comment>");
    localStringBuilder.append("<content>");
    localStringBuilder.append("<title>").append(paramString1).append("</title>");
    localStringBuilder.append("<description>").append(paramString2).append("</description>");
    localStringBuilder.append("<submitted-url>").append(paramString3).append("</submitted-url>");
    if (paramString4 != null) {
      localStringBuilder.append("<submitted-image-url>").append(paramString4).append("</submitted-image-url>");
    }
    localStringBuilder.append("</content>");
    localStringBuilder.append("<visibility>");
    localStringBuilder.append("<code>").append(paramString6).append("</code>");
    localStringBuilder.append("</visibility>");
    localStringBuilder.append("</share>");
    ShareSDK.logApiEvent("/v1/people/~/shares", c());
    paramString1 = a(e("https://api.linkedin.com/v1/people/~/shares"), localStringBuilder.toString(), 201);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      return new Hashon().fromJson(paramString1);
    }
    return null;
  }
  
  public void a(AuthorizeListener paramAuthorizeListener)
  {
    b(paramAuthorizeListener);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.h = paramArrayOfString;
  }
  
  public String b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("grant_type", "authorization_code"));
    localArrayList.add(new KVPair("code", paramString));
    localArrayList.add(new KVPair("redirect_uri", this.f));
    localArrayList.add(new KVPair("client_id", this.d));
    localArrayList.add(new KVPair("client_secret", this.e));
    return a.a().b("https://www.linkedin.com/uas/oauth2/accessToken", localArrayList, "/uas/oauth2/accessToken", c());
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public HashMap<String, Object> d(String paramString)
  {
    String str = "~";
    if (paramString != null)
    {
      str = "id=" + paramString;
      if (paramString.startsWith("http")) {
        if (!paramString.endsWith("/")) {
          break label168;
        }
      }
    }
    label168:
    for (str = "url=" + Data.urlEncode(paramString.substring(0, paramString.length() - 1), "utf-8");; str = "url=" + Data.urlEncode(paramString, "utf-8"))
    {
      paramString = e("https://api.linkedin.com/v1/people/" + str + ":(" + "id,first-name,last-name,maiden-name,formatted-name,phonetic-first-name,phonetic-last-name,formatted-phonetic-name,headline,location:(name,country:(code)),industry,distance,relation-to-viewer:(distance),current-share,num-connections,num-connections-capped,summary,specialties,positions,picture-url,site-standard-profile-request,api-standard-profile-request:(url,headers),public-profile-url,educations,email-address,following,date-of-birth" + ")");
      paramString = a.a().a(paramString, null, "/v1/people/", c());
      if ((paramString == null) || (paramString.length() <= 0)) {
        break;
      }
      return new Hashon().fromJson(paramString);
    }
    return null;
  }
  
  public String getAuthorizeUrl()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("client_id", this.d));
    if (this.h == null) {}
    StringBuilder localStringBuilder;
    for (Object localObject = b;; localObject = this.h)
    {
      localStringBuilder = new StringBuilder();
      int k = localObject.length;
      int j = 0;
      while (i < k)
      {
        String str = localObject[i];
        if (j > 0) {
          localStringBuilder.append("%20");
        }
        localStringBuilder.append(str);
        j += 1;
        i += 1;
      }
    }
    localArrayList.add(new KVPair("state", a()));
    localArrayList.add(new KVPair("redirect_uri", this.f));
    localArrayList.add(new KVPair("response_type", "code"));
    ShareSDK.logApiEvent("/uas/oauth2/authorization", c());
    localObject = R.encodeUrl(localArrayList);
    return "https://www.linkedin.com/uas/oauth2/authorization?" + (String)localObject + "&scope=" + localStringBuilder.toString();
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(g paramg)
  {
    return new c(paramg);
  }
  
  public String getRedirectUri()
  {
    return this.f;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\linkedin\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */