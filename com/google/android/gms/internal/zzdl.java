package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzdl
  implements zzdk
{
  private final Context mContext;
  private final VersionInfoParcel zzpb;
  
  public zzdl(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    this.mContext = paramContext;
    this.zzpb = paramVersionInfoParcel;
  }
  
  /* Error */
  public JSONObject zzX(String paramString)
  {
    // Byte code:
    //   0: new 45	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 48	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 45	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 49	org/json/JSONObject:<init>	()V
    //   17: astore_3
    //   18: ldc 51
    //   20: astore_1
    //   21: aload 4
    //   23: ldc 53
    //   25: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_0
    //   32: aload_0
    //   33: aload 4
    //   35: invokevirtual 60	com/google/android/gms/internal/zzdl:zzb	(Lorg/json/JSONObject;)Lcom/google/android/gms/internal/zzdl$zzb;
    //   38: invokevirtual 63	com/google/android/gms/internal/zzdl:zza	(Lcom/google/android/gms/internal/zzdl$zzb;)Lcom/google/android/gms/internal/zzdl$zzc;
    //   41: astore 4
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: invokevirtual 67	com/google/android/gms/internal/zzdl$zzc:isSuccess	()Z
    //   50: ifeq +64 -> 114
    //   53: aload_2
    //   54: astore_1
    //   55: aload_3
    //   56: ldc 69
    //   58: aload_0
    //   59: aload 4
    //   61: invokevirtual 73	com/google/android/gms/internal/zzdl$zzc:zzdI	()Lcom/google/android/gms/internal/zzdl$zzd;
    //   64: invokevirtual 76	com/google/android/gms/internal/zzdl:zza	(Lcom/google/android/gms/internal/zzdl$zzd;)Lorg/json/JSONObject;
    //   67: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   70: pop
    //   71: aload_2
    //   72: astore_1
    //   73: aload_3
    //   74: ldc 82
    //   76: iconst_1
    //   77: invokevirtual 85	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   80: pop
    //   81: aload_3
    //   82: areturn
    //   83: astore_1
    //   84: ldc 87
    //   86: invokestatic 92	com/google/android/gms/ads/internal/util/client/zzb:e	(Ljava/lang/String;)V
    //   89: new 45	org/json/JSONObject
    //   92: dup
    //   93: invokespecial 49	org/json/JSONObject:<init>	()V
    //   96: ldc 82
    //   98: iconst_0
    //   99: invokevirtual 85	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   102: astore_1
    //   103: aload_1
    //   104: areturn
    //   105: astore_1
    //   106: new 45	org/json/JSONObject
    //   109: dup
    //   110: invokespecial 49	org/json/JSONObject:<init>	()V
    //   113: areturn
    //   114: aload_2
    //   115: astore_1
    //   116: aload_3
    //   117: ldc 69
    //   119: new 45	org/json/JSONObject
    //   122: dup
    //   123: invokespecial 49	org/json/JSONObject:<init>	()V
    //   126: ldc 53
    //   128: aload_2
    //   129: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   132: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_2
    //   137: astore_1
    //   138: aload_3
    //   139: ldc 82
    //   141: iconst_0
    //   142: invokevirtual 85	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   145: pop
    //   146: aload_2
    //   147: astore_1
    //   148: aload_3
    //   149: ldc 94
    //   151: aload 4
    //   153: invokevirtual 98	com/google/android/gms/internal/zzdl$zzc:getReason	()Ljava/lang/String;
    //   156: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload_3
    //   161: areturn
    //   162: astore_2
    //   163: aload_3
    //   164: ldc 69
    //   166: new 45	org/json/JSONObject
    //   169: dup
    //   170: invokespecial 49	org/json/JSONObject:<init>	()V
    //   173: ldc 53
    //   175: aload_1
    //   176: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   179: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload_3
    //   184: ldc 82
    //   186: iconst_0
    //   187: invokevirtual 85	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_3
    //   192: ldc 94
    //   194: aload_2
    //   195: invokevirtual 101	java/lang/Exception:toString	()Ljava/lang/String;
    //   198: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload_3
    //   203: areturn
    //   204: astore_1
    //   205: aload_3
    //   206: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	zzdl
    //   0	207	1	paramString	String
    //   28	119	2	str	String
    //   162	33	2	localException	Exception
    //   17	189	3	localJSONObject	JSONObject
    //   8	144	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	83	org/json/JSONException
    //   89	103	105	org/json/JSONException
    //   21	29	162	java/lang/Exception
    //   31	43	162	java/lang/Exception
    //   45	53	162	java/lang/Exception
    //   55	71	162	java/lang/Exception
    //   73	81	162	java/lang/Exception
    //   116	136	162	java/lang/Exception
    //   138	146	162	java/lang/Exception
    //   148	160	162	java/lang/Exception
    //   163	202	204	org/json/JSONException
  }
  
  protected zzc zza(zzb paramzzb)
  {
    HttpURLConnection localHttpURLConnection;
    try
    {
      localHttpURLConnection = (HttpURLConnection)paramzzb.zzdF().openConnection();
      zzp.zzbv().zza(this.mContext, this.zzpb.zzJu, false, localHttpURLConnection);
      localObject1 = paramzzb.zzdG().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zza)((Iterator)localObject1).next();
        localHttpURLConnection.addRequestProperty(((zza)localObject2).getKey(), ((zza)localObject2).getValue());
      }
      if (TextUtils.isEmpty(paramzzb.zzdH())) {
        break label144;
      }
    }
    catch (Exception paramzzb)
    {
      return new zzc(false, null, paramzzb.toString());
    }
    localHttpURLConnection.setDoOutput(true);
    Object localObject1 = paramzzb.zzdH().getBytes();
    localHttpURLConnection.setFixedLengthStreamingMode(localObject1.length);
    Object localObject2 = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
    ((BufferedOutputStream)localObject2).write((byte[])localObject1);
    ((BufferedOutputStream)localObject2).close();
    label144:
    localObject1 = new ArrayList();
    if (localHttpURLConnection.getHeaderFields() != null)
    {
      localObject2 = localHttpURLConnection.getHeaderFields().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        Iterator localIterator = ((List)localEntry.getValue()).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((ArrayList)localObject1).add(new zza((String)localEntry.getKey(), str));
        }
      }
    }
    paramzzb = new zzc(true, new zzd(paramzzb.zzdE(), localHttpURLConnection.getResponseCode(), (List)localObject1, zzp.zzbv().zza(new InputStreamReader(localHttpURLConnection.getInputStream()))), null);
    return paramzzb;
  }
  
  protected JSONObject zza(zzd paramzzd)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("http_request_id", paramzzd.zzdE());
      if (paramzzd.getBody() != null) {
        localJSONObject.put("body", paramzzd.getBody());
      }
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramzzd.zzdJ().iterator();
      while (localIterator.hasNext())
      {
        zza localzza = (zza)localIterator.next();
        localJSONArray.put(new JSONObject().put("key", localzza.getKey()).put("value", localzza.getValue()));
      }
      localJSONObject.put("headers", localJSONArray);
    }
    catch (JSONException paramzzd)
    {
      zzb.zzb("Error constructing JSON for http response.", paramzzd);
      return localJSONObject;
    }
    localJSONObject.put("response_code", paramzzd.getResponseCode());
    return localJSONObject;
  }
  
  public void zza(final zziz paramzziz, final Map<String, String> paramMap)
  {
    zzic.zza(new Runnable()
    {
      public void run()
      {
        zzb.zzaF("Received Http request.");
        final Object localObject = (String)paramMap.get("http_request");
        localObject = zzdl.this.zzX((String)localObject);
        if (localObject == null)
        {
          zzb.e("Response should not be null.");
          return;
        }
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zzdl.1.this.zzxB.zzb("fetchHttpRequestCompleted", localObject);
            zzb.zzaF("Dispatched http response.");
          }
        });
      }
    });
  }
  
  protected zzb zzb(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("http_request_id");
    Object localObject1 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("post_body", null);
    try
    {
      localObject1 = new URL((String)localObject1);
      localArrayList = new ArrayList();
      localObject2 = paramJSONObject.optJSONArray("headers");
      paramJSONObject = (JSONObject)localObject2;
      if (localObject2 == null) {
        paramJSONObject = new JSONArray();
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramJSONObject.length()) {
          break label143;
        }
        localObject2 = paramJSONObject.optJSONObject(i);
        if (localObject2 != null) {
          break;
        }
        i += 1;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      ArrayList localArrayList;
      URL localURL;
      for (;;)
      {
        Object localObject2;
        zzb.zzb("Error constructing http request.", localMalformedURLException);
        localURL = null;
        continue;
        localArrayList.add(new zza(((JSONObject)localObject2).optString("key"), ((JSONObject)localObject2).optString("value")));
      }
      label143:
      return new zzb(str1, localURL, localArrayList, str2);
    }
  }
  
  @zzgr
  static class zza
  {
    private final String mValue;
    private final String zzue;
    
    public zza(String paramString1, String paramString2)
    {
      this.zzue = paramString1;
      this.mValue = paramString2;
    }
    
    public String getKey()
    {
      return this.zzue;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
  }
  
  @zzgr
  static class zzb
  {
    private final String zzxF;
    private final URL zzxG;
    private final ArrayList<zzdl.zza> zzxH;
    private final String zzxI;
    
    public zzb(String paramString1, URL paramURL, ArrayList<zzdl.zza> paramArrayList, String paramString2)
    {
      this.zzxF = paramString1;
      this.zzxG = paramURL;
      if (paramArrayList == null) {}
      for (this.zzxH = new ArrayList();; this.zzxH = paramArrayList)
      {
        this.zzxI = paramString2;
        return;
      }
    }
    
    public String zzdE()
    {
      return this.zzxF;
    }
    
    public URL zzdF()
    {
      return this.zzxG;
    }
    
    public ArrayList<zzdl.zza> zzdG()
    {
      return this.zzxH;
    }
    
    public String zzdH()
    {
      return this.zzxI;
    }
  }
  
  @zzgr
  class zzc
  {
    private final zzdl.zzd zzxJ;
    private final boolean zzxK;
    private final String zzxL;
    
    public zzc(boolean paramBoolean, zzdl.zzd paramzzd, String paramString)
    {
      this.zzxK = paramBoolean;
      this.zzxJ = paramzzd;
      this.zzxL = paramString;
    }
    
    public String getReason()
    {
      return this.zzxL;
    }
    
    public boolean isSuccess()
    {
      return this.zzxK;
    }
    
    public zzdl.zzd zzdI()
    {
      return this.zzxJ;
    }
  }
  
  @zzgr
  static class zzd
  {
    private final String zzwq;
    private final String zzxF;
    private final int zzxM;
    private final List<zzdl.zza> zzxN;
    
    public zzd(String paramString1, int paramInt, List<zzdl.zza> paramList, String paramString2)
    {
      this.zzxF = paramString1;
      this.zzxM = paramInt;
      if (paramList == null) {}
      for (this.zzxN = new ArrayList();; this.zzxN = paramList)
      {
        this.zzwq = paramString2;
        return;
      }
    }
    
    public String getBody()
    {
      return this.zzwq;
    }
    
    public int getResponseCode()
    {
      return this.zzxM;
    }
    
    public String zzdE()
    {
      return this.zzxF;
    }
    
    public Iterable<zzdl.zza> zzdJ()
    {
      return this.zzxN;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */