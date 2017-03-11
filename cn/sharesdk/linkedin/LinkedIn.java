package cn.sharesdk.linkedin;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class LinkedIn
  extends Platform
{
  public static final String NAME = LinkedIn.class.getSimpleName();
  private String a;
  private String b;
  private String c;
  
  public LinkedIn(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if (isAuthValid())
    {
      paramObject = b.a(this);
      ((b)paramObject).a(this.a, this.b);
      ((b)paramObject).a(this.c);
      ((b)paramObject).c(this.db.getToken());
      return true;
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    b localb = b.a(this);
    localb.a(this.a, this.b);
    localb.a(this.c);
    localb.a(paramArrayOfString);
    localb.a(new a(this, localb));
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    try
    {
      b localb = b.a(this);
      String str2 = paramShareParams.getText();
      String str3 = paramShareParams.getTitle();
      String str4 = paramShareParams.getTitleUrl();
      String str1 = paramShareParams.getImageUrl();
      String str5 = paramShareParams.getImagePath();
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (!TextUtils.isEmpty(str5))
        {
          localObject = str1;
          if (new File(str5).exists())
          {
            localObject = uploadImageToFileServer(str5);
            paramShareParams.setImageUrl((String)localObject);
          }
        }
      }
      str1 = paramShareParams.getComment();
      localObject = localb.a(str3, getShortLintk(str2, false), str4, (String)localObject, str1, "anyone");
      if (localObject == null)
      {
        if (this.listener != null) {
          this.listener.onError(this, 9, new Throwable("response is null"));
        }
      }
      else if (((HashMap)localObject).containsKey("errorCode"))
      {
        if (this.listener == null) {
          return;
        }
        paramShareParams = new Hashon().fromHashMap((HashMap)localObject);
        this.listener.onError(this, 9, new Throwable(paramShareParams));
      }
    }
    catch (Throwable paramShareParams)
    {
      Object localObject;
      if (this.listener != null)
      {
        this.listener.onError(this, 9, paramShareParams);
        return;
        ((HashMap)localObject).put("ShareParams", paramShareParams);
        if (this.listener != null) {
          this.listener.onComplete(this, 9, (HashMap)localObject);
        }
      }
    }
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    locala.d.add(paramShareParams.getImageUrl());
    if (paramHashMap != null)
    {
      locala.a = String.valueOf(paramHashMap.get("updateKey"));
      locala.g = paramHashMap;
    }
    return locala;
  }
  
  protected void follow(String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 6);
    }
  }
  
  protected HashMap<String, Object> getBilaterals(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected HashMap<String, Object> getFollowers(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected HashMap<String, Object> getFollowings(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 2);
    }
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public int getPlatformId()
  {
    return 16;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean hasShareCallback()
  {
    return true;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("ApiKey");
    this.b = getDevinfo("SecretKey");
    this.c = getDevinfo("RedirectUrl");
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("api_key", "ApiKey");
    this.b = getNetworkDevinfo("secret_key", "SecretKey");
    this.c = getNetworkDevinfo("redirect_url", "RedirectUrl");
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    Object localObject1 = b.a(this);
    try
    {
      localObject1 = ((b)localObject1).d(paramString);
      if (localObject1 == null)
      {
        if (this.listener != null) {
          this.listener.onError(this, 8, new Throwable("response is null"));
        }
      }
      else if (((HashMap)localObject1).containsKey("errorCode"))
      {
        if (this.listener == null) {
          return;
        }
        paramString = new Hashon().fromHashMap((HashMap)localObject1);
        this.listener.onError(this, 8, new Throwable(paramString));
      }
    }
    catch (Throwable paramString)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, 8, paramString);
        return;
        if (paramString == null)
        {
          this.db.putUserId(String.valueOf(((HashMap)localObject1).get("id")));
          this.db.put("nickname", String.valueOf(((HashMap)localObject1).get("formattedName")));
          this.db.put("icon", String.valueOf(((HashMap)localObject1).get("pictureUrl")));
          this.db.put("gender", "2");
          this.db.put("snsUserUrl", String.valueOf(((HashMap)localObject1).get("publicProfileUrl")));
          this.db.put("resume", String.valueOf(((HashMap)localObject1).get("summary")));
          this.db.put("secretType", "-1");
          paramString = (HashMap)((HashMap)localObject1).get("dateOfBirth");
          int i;
          if (paramString != null) {
            i = 1970;
          }
          try
          {
            int j = R.parseInt(String.valueOf(paramString.get("year")));
            i = j;
            int k;
            Object localObject2;
            int m;
            HashMap localHashMap2;
            HashMap localHashMap1;
            Object localObject3;
            HashMap localHashMap3;
            HashMap localHashMap4;
            if (this.listener == null) {
              return;
            }
          }
          catch (Throwable localThrowable8)
          {
            try
            {
              j = R.parseInt(String.valueOf(paramString.get("month")));
              j -= 1;
            }
            catch (Throwable localThrowable8)
            {
              try
              {
                k = R.parseInt(String.valueOf(paramString.get("day")));
                paramString = Calendar.getInstance();
                paramString.set(1, i);
                paramString.set(2, j);
                paramString.set(5, k);
                this.db.put("birthday", String.valueOf(paramString.getTimeInMillis()));
                paramString = (HashMap)((HashMap)localObject1).get("following");
                if (paramString != null) {
                  localObject2 = (HashMap)paramString.get("industries");
                }
              }
              catch (Throwable localThrowable8)
              {
                try
                {
                  j = R.parseInt(String.valueOf(((HashMap)localObject2).get("_total")));
                  localObject2 = (HashMap)paramString.get("people");
                }
                catch (Throwable localThrowable8)
                {
                  try
                  {
                    k = R.parseInt(String.valueOf(((HashMap)localObject2).get("_total")));
                    localObject2 = (HashMap)paramString.get("companies");
                  }
                  catch (Throwable localThrowable8)
                  {
                    try
                    {
                      i = R.parseInt(String.valueOf(((HashMap)localObject2).get("_total")));
                      paramString = (HashMap)paramString.get("specialEditions");
                    }
                    catch (Throwable localThrowable8)
                    {
                      try
                      {
                        m = R.parseInt(String.valueOf(paramString.get("_total")));
                        i = m;
                        this.db.put("favouriteCount", String.valueOf(i + (j + k) + 0));
                        paramString = (HashMap)((HashMap)localObject1).get("educations");
                        if (paramString != null)
                        {
                          localObject2 = (ArrayList)paramString.get("values");
                          if (localObject2 != null)
                          {
                            paramString = new ArrayList();
                            localObject2 = ((ArrayList)localObject2).iterator();
                            if (((Iterator)localObject2).hasNext())
                            {
                              localHashMap2 = (HashMap)((Iterator)localObject2).next();
                              localHashMap1 = new HashMap();
                              localHashMap1.put("school_type", Integer.valueOf(0));
                              localHashMap1.put("school", String.valueOf(localHashMap2.get("schoolName")));
                            }
                          }
                        }
                      }
                      catch (Throwable paramString)
                      {
                        try
                        {
                          for (;;)
                          {
                            localHashMap1.put("year", Integer.valueOf(R.parseInt(String.valueOf(((HashMap)localHashMap2.get("startDate")).get("year")))));
                            localHashMap1.put("background", Integer.valueOf(0));
                            paramString.add(localHashMap1);
                            continue;
                            localThrowable1 = localThrowable1;
                            d.a().w(localThrowable1);
                            continue;
                            localThrowable2 = localThrowable2;
                            d.a().w(localThrowable2);
                            j = 0;
                            continue;
                            paramString = paramString;
                            d.a().w(paramString);
                            k = 1;
                            continue;
                            localThrowable3 = localThrowable3;
                            d.a().w(localThrowable3);
                            j = 0;
                            continue;
                            localThrowable4 = localThrowable4;
                            d.a().w(localThrowable4);
                            k = 0;
                            continue;
                            localThrowable5 = localThrowable5;
                            d.a().w(localThrowable5);
                            i = 0;
                          }
                          paramString = paramString;
                          d.a().w(paramString);
                        }
                        catch (Throwable localThrowable6)
                        {
                          for (;;)
                          {
                            d.a().w(localThrowable6);
                          }
                        }
                        localObject3 = new HashMap();
                        ((HashMap)localObject3).put("list", paramString);
                        paramString = new Hashon().fromHashMap((HashMap)localObject3);
                        this.db.put("educationJSONArrayStr", paramString.substring(8, paramString.length() - 1));
                        paramString = (HashMap)((HashMap)localObject1).get("positions");
                        if (paramString != null)
                        {
                          localObject3 = (ArrayList)paramString.get("values");
                          if (localObject3 != null)
                          {
                            paramString = new ArrayList();
                            localObject3 = ((ArrayList)localObject3).iterator();
                            for (;;)
                            {
                              if (((Iterator)localObject3).hasNext())
                              {
                                localHashMap3 = (HashMap)((Iterator)localObject3).next();
                                localHashMap1 = new HashMap();
                                localHashMap4 = (HashMap)localHashMap3.get("company");
                                if (localHashMap4 != null)
                                {
                                  localHashMap1.put("company", String.valueOf(localHashMap4.get("name")));
                                  localHashMap1.put("industry", String.valueOf(localHashMap4.get("industry")));
                                }
                                localHashMap1.put("position", String.valueOf(localHashMap3.get("title")));
                                localHashMap4 = (HashMap)localHashMap3.get("startDate");
                                if (localHashMap4 != null) {}
                                try
                                {
                                  i = R.parseInt(String.valueOf(localHashMap4.get("year")));
                                  localHashMap1.put("start_date", Integer.valueOf(R.parseInt(String.valueOf(localHashMap4.get("month"))) + i * 100));
                                  localHashMap3 = (HashMap)localHashMap3.get("endDate");
                                  if (localHashMap3 == null) {}
                                }
                                catch (Throwable localThrowable8)
                                {
                                  for (;;)
                                  {
                                    try
                                    {
                                      i = R.parseInt(String.valueOf(localHashMap3.get("year")));
                                      localHashMap1.put("end_date", Integer.valueOf(R.parseInt(String.valueOf(localHashMap3.get("month"))) + i * 100));
                                      paramString.add(localHashMap1);
                                      break;
                                      localThrowable8 = localThrowable8;
                                      d.a().w(localThrowable8);
                                      localHashMap1.put("start_date", Integer.valueOf(0));
                                    }
                                    catch (Throwable localThrowable7)
                                    {
                                      d.a().w(localThrowable7);
                                      localHashMap1.put("end_date", Integer.valueOf(0));
                                      continue;
                                    }
                                    localHashMap1.put("end_date", Integer.valueOf(0));
                                  }
                                }
                              }
                            }
                            localObject3 = new HashMap();
                            ((HashMap)localObject3).put("list", paramString);
                            paramString = new Hashon().fromHashMap((HashMap)localObject3);
                            this.db.put("workJSONArrayStr", paramString.substring(8, paramString.length() - 1));
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
        else
        {
          this.listener.onComplete(this, 8, (HashMap)localObject1);
        }
      }
    }
  }
  
  public static class ShareParams
    extends Platform.ShareParams
  {
    @Deprecated
    public String comment;
    @Deprecated
    public String imageUrl;
    @Deprecated
    public String title;
    @Deprecated
    public String titleUrl;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\linkedin\LinkedIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */