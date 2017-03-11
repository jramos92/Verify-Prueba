package cn.sharesdk.facebook;

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

public class Facebook
  extends Platform
{
  public static final String NAME = Facebook.class.getSimpleName();
  private String a;
  private String b;
  
  public Facebook(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if (isAuthValid())
    {
      e locale = e.a(this);
      locale.a(this.a);
      String str1 = this.db.getToken();
      String str2 = String.valueOf(this.db.getExpiresIn());
      if ((str1 != null) && (str2 != null))
      {
        locale.a(str1, str2);
        if (locale.a()) {
          return true;
        }
      }
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    e locale = e.a(this);
    locale.a(this.a);
    locale.d(this.b);
    locale.a(paramArrayOfString);
    locale.a(new a(this, locale), isSSODisable());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    e locale = e.a(this);
    try
    {
      paramString1 = locale.a(paramString1, paramString2, paramHashMap, paramHashMap1);
      if ((paramString1 == null) || (paramString1.size() <= 0))
      {
        if (this.listener != null) {
          this.listener.onError(this, paramInt, new Throwable("response is null"));
        }
      }
      else if ((paramString1.containsKey("error_code")) || (paramString1.containsKey("error")))
      {
        if (this.listener == null) {
          return;
        }
        paramString1 = new Hashon().fromHashMap(paramString1);
        this.listener.onError(this, paramInt, new Throwable(paramString1));
      }
    }
    catch (Throwable paramString1)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, paramInt, paramString1);
        return;
        if (this.listener != null) {
          this.listener.onComplete(this, paramInt, paramString1);
        }
      }
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    Object localObject = e.a(this);
    try
    {
      String str1 = getShortLintk(paramShareParams.getText(), false);
      String str2 = paramShareParams.getImagePath();
      String str3 = paramShareParams.getImageUrl();
      if (!TextUtils.isEmpty(str3)) {
        localObject = ((e)localObject).b(str1, str3);
      }
      while ((localObject == null) || (((HashMap)localObject).size() <= 0))
      {
        if (this.listener == null) {
          return;
        }
        this.listener.onError(this, 9, new Throwable("response is null"));
        return;
        if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists())) {
          localObject = ((e)localObject).b(str1, str2);
        } else {
          localObject = ((e)localObject).b(str1);
        }
      }
      if ((((HashMap)localObject).containsKey("error_code")) || (((HashMap)localObject).containsKey("error")))
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
      if (this.listener != null)
      {
        this.listener.onError(this, 9, paramShareParams);
        return;
        if (this.listener != null)
        {
          ((HashMap)localObject).put("ShareParams", paramShareParams);
          this.listener.onComplete(this, 9, (HashMap)localObject);
        }
      }
    }
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    Object localObject1 = paramHashMap.get("data");
    if (localObject1 == null) {
      return null;
    }
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("type", "FOLLOWING");
    localHashMap1.put("snsplat", Integer.valueOf(getPlatformId()));
    localHashMap1.put("snsuid", this.db.getUserId());
    paramInt = ((Integer)paramHashMap.get("current_cursor")).intValue();
    int i = ((Integer)paramHashMap.get("current_limit")).intValue();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = (ArrayList)localObject1;
    if (paramHashMap.size() <= 0) {
      return null;
    }
    localObject1 = paramHashMap.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (HashMap)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("snsuid", String.valueOf(((HashMap)localObject2).get("id")));
        localHashMap2.put("nickname", String.valueOf(((HashMap)localObject2).get("name")));
        if ("male".equals(String.valueOf(((HashMap)localObject2).get("gender")))) {
          paramHashMap = "0";
        }
        for (;;)
        {
          localHashMap2.put("gender", paramHashMap);
          if ("true".equals(String.valueOf(((HashMap)localObject2).get("verified"))))
          {
            paramHashMap = "1";
            label247:
            localHashMap2.put("secretType", paramHashMap);
            localHashMap2.put("snsUserUrl", String.valueOf(((HashMap)localObject2).get("link")));
            localHashMap2.put("resume", String.valueOf(((HashMap)localObject2).get("link")));
            if (!((HashMap)localObject2).containsKey("picture")) {
              break label647;
            }
            paramHashMap = (HashMap)((HashMap)localObject2).get("picture");
            label320:
            if (paramHashMap != null)
            {
              if (!paramHashMap.containsKey("data")) {
                break label652;
              }
              paramHashMap = (HashMap)paramHashMap.get("data");
              label343:
              if (paramHashMap != null) {
                localHashMap2.put("icon", String.valueOf(paramHashMap.get("url")));
              }
            }
          }
          try
          {
            if (((HashMap)localObject2).containsKey("birthday"))
            {
              paramHashMap = String.valueOf(((HashMap)localObject2).get("birthday")).split("/");
              localObject3 = Calendar.getInstance();
              ((Calendar)localObject3).set(1, R.parseInt(paramHashMap[2]));
              ((Calendar)localObject3).set(2, R.parseInt(paramHashMap[0]) - 1);
              ((Calendar)localObject3).set(5, R.parseInt(paramHashMap[1]));
              localHashMap2.put("birthday", String.valueOf(((Calendar)localObject3).getTimeInMillis()));
            }
            if (((HashMap)localObject2).containsKey("education"))
            {
              paramHashMap = (ArrayList)((HashMap)localObject2).get("education");
              if (paramHashMap == null) {
                break label739;
              }
              localObject3 = new ArrayList();
              paramHashMap = paramHashMap.iterator();
              if (!paramHashMap.hasNext()) {
                break label688;
              }
              localHashMap3 = (HashMap)paramHashMap.next();
              localObject4 = new HashMap();
              ((HashMap)localObject4).put("school_type", Integer.valueOf(0));
              HashMap localHashMap4 = (HashMap)localHashMap3.get("school");
              if (localHashMap4 != null) {
                ((HashMap)localObject4).put("school", String.valueOf(localHashMap4.get("name")));
              }
            }
          }
          catch (Throwable paramHashMap)
          {
            Object localObject3;
            Object localObject4;
            try
            {
              for (;;)
              {
                HashMap localHashMap3;
                ((HashMap)localObject4).put("year", Integer.valueOf(R.parseInt(String.valueOf(((HashMap)localHashMap3.get("year")).get("name")))));
                ((HashMap)localObject4).put("background", Integer.valueOf(0));
                ((ArrayList)localObject3).add(localObject4);
                continue;
                paramHashMap = "1";
                break;
                paramHashMap = "0";
                break label247;
                label647:
                paramHashMap = null;
                break label320;
                label652:
                paramHashMap = null;
                break label343;
                paramHashMap = paramHashMap;
                d.a().d(paramHashMap);
              }
              paramHashMap = null;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                d.a().d(localThrowable2);
              }
            }
            label688:
            paramHashMap = new HashMap();
            paramHashMap.put("list", localObject3);
            paramHashMap = new Hashon().fromHashMap(paramHashMap);
            localHashMap2.put("educationJSONArrayStr", paramHashMap.substring(8, paramHashMap.length() - 1));
            label739:
            if (((HashMap)localObject2).containsKey("work")) {
              paramHashMap = (ArrayList)((HashMap)localObject2).get("work");
            }
            for (;;)
            {
              if (paramHashMap == null) {
                break label1097;
              }
              localObject2 = new ArrayList();
              paramHashMap = paramHashMap.iterator();
              label780:
              if (paramHashMap.hasNext())
              {
                localObject4 = (HashMap)paramHashMap.next();
                localObject3 = new HashMap();
                Object localObject5 = (HashMap)((HashMap)localObject4).get("employer");
                if (localObject5 != null) {
                  ((HashMap)localObject3).put("company", String.valueOf(((HashMap)localObject5).get("name")));
                }
                localObject5 = (HashMap)((HashMap)localObject4).get("position");
                if (localObject5 != null) {
                  ((HashMap)localObject3).put("position", String.valueOf(((HashMap)localObject5).get("name")));
                }
                try
                {
                  localObject5 = String.valueOf(((HashMap)localObject4).get("start_date")).split("-");
                  j = R.parseInt(localObject5[0]);
                  ((HashMap)localObject3).put("start_date", Integer.valueOf(R.parseInt(localObject5[1]) + j * 100));
                }
                catch (Throwable localThrowable3)
                {
                  try
                  {
                    for (;;)
                    {
                      localObject4 = String.valueOf(((HashMap)localObject4).get("end_date")).split("-");
                      int j = R.parseInt(localObject4[0]);
                      ((HashMap)localObject3).put("end_date", Integer.valueOf(R.parseInt(localObject4[1]) + j * 100));
                      ((ArrayList)localObject2).add(localObject3);
                      break label780;
                      paramHashMap = null;
                      break;
                      localThrowable3 = localThrowable3;
                      d.a().d(localThrowable3);
                    }
                  }
                  catch (Throwable localThrowable1)
                  {
                    for (;;)
                    {
                      d.a().d(localThrowable1);
                      ((HashMap)localObject3).put("end_date", Integer.valueOf(0));
                    }
                  }
                }
              }
            }
            paramHashMap = new HashMap();
            paramHashMap.put("list", localObject2);
            paramHashMap = new Hashon().fromHashMap(paramHashMap);
            localHashMap2.put("workJSONArrayStr", paramHashMap.substring(8, paramHashMap.length() - 1));
            label1097:
            localArrayList.add(localHashMap2);
          }
        }
      }
    }
    if ((localArrayList == null) || (localArrayList.size() <= 0)) {
      return null;
    }
    paramHashMap = "_false";
    if (i >= localArrayList.size()) {
      paramHashMap = "_true";
    }
    localHashMap1.put("nextCursor", localArrayList.size() + paramInt + paramHashMap);
    localHashMap1.put("list", localArrayList);
    return localHashMap1;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    if (paramHashMap != null)
    {
      locala.d.add(String.valueOf(paramHashMap.get("source")));
      paramShareParams = paramHashMap.get("post_id");
      if (paramShareParams != null) {
        break label64;
      }
    }
    label64:
    for (paramShareParams = null;; paramShareParams = String.valueOf(paramShareParams))
    {
      locala.a = paramShareParams;
      locala.g = paramHashMap;
      return locala;
    }
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
    e locale = e.a(this);
    try
    {
      paramString = locale.a(paramInt1, paramInt2, paramString);
      if (paramString != null)
      {
        if (paramString.size() <= 0) {
          return null;
        }
        if ((!paramString.containsKey("error_code")) && (!paramString.containsKey("error")))
        {
          paramString.put("current_limit", Integer.valueOf(paramInt1));
          paramString.put("current_cursor", Integer.valueOf(paramInt2));
          paramString = filterFriendshipInfo(2, paramString);
          return paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      d.a().d(paramString);
    }
    return null;
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString)
  {
    e locale = e.a(this);
    try
    {
      paramString = locale.a(paramInt1, paramInt2 * paramInt1, paramString);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        if (this.listener != null) {
          this.listener.onError(this, 2, new Throwable("response is null"));
        }
      }
      else if ((paramString.containsKey("error_code")) || (paramString.containsKey("error")))
      {
        if (this.listener == null) {
          return;
        }
        paramString = new Hashon().fromHashMap(paramString);
        this.listener.onError(this, 2, new Throwable(paramString));
      }
    }
    catch (Throwable paramString)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, 2, paramString);
        return;
        if (this.listener != null) {
          this.listener.onComplete(this, 2, paramString);
        }
      }
    }
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public int getPlatformId()
  {
    return 10;
  }
  
  public int getVersion()
  {
    return 2;
  }
  
  public boolean hasShareCallback()
  {
    return true;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("ConsumerKey");
    this.b = getDevinfo("RedirectUrl");
  }
  
  public boolean isClientValid()
  {
    e locale = e.a(this);
    locale.a(this.a);
    return locale.b();
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("api_key", "ConsumerKey");
    this.b = getNetworkDevinfo("redirect_uri", "RedirectUrl");
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    Object localObject1 = e.a(this);
    try
    {
      localObject1 = ((e)localObject1).c(paramString);
      if ((localObject1 == null) || (((HashMap)localObject1).size() <= 0))
      {
        if (this.listener == null) {
          break label1093;
        }
        this.listener.onError(this, 8, new Throwable("response is null"));
        return;
      }
      if ((!((HashMap)localObject1).containsKey("error_code")) && (!((HashMap)localObject1).containsKey("error"))) {
        break label131;
      }
      if (this.listener == null) {
        break label1093;
      }
      paramString = new Hashon().fromHashMap((HashMap)localObject1);
      this.listener.onError(this, 8, new Throwable(paramString));
      return;
    }
    catch (Throwable paramString)
    {
      if (this.listener == null) {
        break label1093;
      }
    }
    this.listener.onError(this, 8, paramString);
    return;
    label131:
    Object localObject2;
    label245:
    label400:
    label470:
    Object localObject3;
    Object localObject5;
    Object localObject4;
    if (paramString == null)
    {
      this.db.putUserId(String.valueOf(((HashMap)localObject1).get("id")));
      this.db.put("nickname", String.valueOf(((HashMap)localObject1).get("name")));
      localObject2 = this.db;
      if (!"male".equals(String.valueOf(((HashMap)localObject1).get("gender")))) {
        break label1094;
      }
      paramString = "0";
      ((PlatformDb)localObject2).put("gender", paramString);
      this.db.put("token_for_business", (String)((HashMap)localObject1).get("token_for_business"));
      if (!((HashMap)localObject1).containsKey("picture")) {
        break label1101;
      }
      paramString = (HashMap)((HashMap)localObject1).get("picture");
      if (paramString != null)
      {
        paramString = (HashMap)paramString.get("data");
        if (paramString != null) {
          this.db.put("icon", String.valueOf(paramString.get("url")));
        }
      }
      try
      {
        if (((HashMap)localObject1).containsKey("birthday"))
        {
          paramString = String.valueOf(((HashMap)localObject1).get("birthday")).split("/");
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).set(1, R.parseInt(paramString[2]));
          ((Calendar)localObject2).set(2, R.parseInt(paramString[0]) - 1);
          ((Calendar)localObject2).set(5, R.parseInt(paramString[1]));
          this.db.put("birthday", String.valueOf(((Calendar)localObject2).getTimeInMillis()));
        }
        localObject2 = this.db;
        if (!"true".equals(String.valueOf(((HashMap)localObject1).get("verified")))) {
          break label1106;
        }
        paramString = "1";
        ((PlatformDb)localObject2).put("secretType", paramString);
        this.db.put("snsUserUrl", String.valueOf(((HashMap)localObject1).get("link")));
        this.db.put("resume", String.valueOf(((HashMap)localObject1).get("link")));
        if (!((HashMap)localObject1).containsKey("education")) {
          break label1113;
        }
        paramString = (ArrayList)((HashMap)localObject1).get("education");
        if (paramString != null)
        {
          localObject2 = new ArrayList();
          localObject3 = paramString.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (HashMap)((Iterator)localObject3).next();
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("school_type", Integer.valueOf(0));
            if (!((HashMap)localObject5).containsKey("school")) {
              break label1118;
            }
            paramString = (HashMap)((HashMap)localObject5).get("school");
            label556:
            if (paramString != null) {
              ((HashMap)localObject4).put("school", String.valueOf(paramString.get("name")));
            }
            try
            {
              if (!((HashMap)localObject5).containsKey("year")) {
                break label1123;
              }
              paramString = (HashMap)((HashMap)localObject5).get("year");
              label601:
              ((HashMap)localObject4).put("year", Integer.valueOf(R.parseInt(String.valueOf(paramString.get("name")))));
            }
            catch (Throwable paramString)
            {
              for (;;)
              {
                d.a().d(paramString);
              }
            }
            ((HashMap)localObject4).put("background", Integer.valueOf(0));
            ((ArrayList)localObject2).add(localObject4);
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          d.a().d(paramString);
        }
        paramString = new HashMap();
        paramString.put("list", localObject2);
        paramString = new Hashon().fromHashMap(paramString);
        this.db.put("educationJSONArrayStr", paramString.substring(8, paramString.length() - 1));
      }
      if (!((HashMap)localObject1).containsKey("work")) {
        break label1128;
      }
    }
    label1093:
    label1094:
    label1101:
    label1106:
    label1113:
    label1118:
    label1123:
    label1128:
    for (paramString = (ArrayList)((HashMap)localObject1).get("work");; paramString = null)
    {
      if (paramString != null)
      {
        localObject2 = new ArrayList();
        paramString = paramString.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            localObject4 = (HashMap)paramString.next();
            localObject3 = new HashMap();
            localObject5 = (HashMap)((HashMap)localObject4).get("employer");
            if (localObject5 != null) {
              ((HashMap)localObject3).put("company", String.valueOf(((HashMap)localObject5).get("name")));
            }
            localObject5 = (HashMap)((HashMap)localObject4).get("position");
            if (localObject5 != null) {
              ((HashMap)localObject3).put("position", String.valueOf(((HashMap)localObject5).get("name")));
            }
            try
            {
              localObject5 = String.valueOf(((HashMap)localObject4).get("start_date")).split("-");
              i = R.parseInt(localObject5[0]);
              ((HashMap)localObject3).put("start_date", Integer.valueOf(R.parseInt(localObject5[1]) + i * 100));
            }
            catch (Throwable localThrowable2)
            {
              try
              {
                for (;;)
                {
                  localObject4 = String.valueOf(((HashMap)localObject4).get("end_date")).split("-");
                  int i = R.parseInt(localObject4[0]);
                  ((HashMap)localObject3).put("end_date", Integer.valueOf(R.parseInt(localObject4[1]) + i * 100));
                  ((ArrayList)localObject2).add(localObject3);
                  break;
                  localThrowable2 = localThrowable2;
                  d.a().d(localThrowable2);
                }
              }
              catch (Throwable localThrowable1)
              {
                for (;;)
                {
                  d.a().d(localThrowable1);
                  ((HashMap)localObject3).put("end_date", Integer.valueOf(0));
                }
              }
            }
          }
        }
        paramString = new HashMap();
        paramString.put("list", localObject2);
        paramString = new Hashon().fromHashMap(paramString);
        this.db.put("workJSONArrayStr", paramString.substring(8, paramString.length() - 1));
      }
      if (this.listener != null) {
        this.listener.onComplete(this, 8, (HashMap)localObject1);
      }
      return;
      paramString = "1";
      break;
      paramString = null;
      break label245;
      paramString = "0";
      break label400;
      paramString = null;
      break label470;
      paramString = null;
      break label556;
      paramString = null;
      break label601;
    }
  }
  
  public static class ShareParams
    extends Platform.ShareParams
  {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\facebook\Facebook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */