package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;
import java.lang.reflect.Method;

public class RegisterView
  extends ResizeLayout
{
  private TitleLayout a;
  private RelativeLayout b;
  private WebView c;
  private TextView d;
  
  public RegisterView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RegisterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(-1);
    setOrientation(1);
    int i = b(paramContext);
    this.a = new TitleLayout(paramContext);
    try
    {
      j = R.getBitmapRes(paramContext, "ssdk_auth_title_back");
      if (j > 0) {
        this.a.setBackgroundResource(j);
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        int j;
        Object localObject;
        Method localMethod = this.c.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.c, new Object[] { "searchBoxJavaBridge_" });
        this.c.setWebChromeClient(paramContext);
        ((LinearLayout)localObject).addView(this.c);
        this.c.requestFocus();
        return;
        localThrowable1 = localThrowable1;
        cn.sharesdk.framework.utils.d.a().w(localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.d.a().d(localThrowable2);
        }
      }
    }
    this.a.getBtnRight().setVisibility(8);
    j = R.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter");
    if (j > 0) {
      this.a.getTvTitle().setText(j);
    }
    addView(this.a);
    localObject = new ImageView(paramContext);
    j = R.getBitmapRes(paramContext, "ssdk_logo");
    if (j > 0) {
      ((ImageView)localObject).setImageResource(j);
    }
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject).setPadding(0, 0, R.dipToPx(paramContext, 10), 0);
    ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    ((ImageView)localObject).setOnClickListener(new c(this));
    this.a.addView((View)localObject);
    this.b = new RelativeLayout(paramContext);
    localObject = new LinearLayout.LayoutParams(-1, 0);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.b);
    localObject = new LinearLayout(paramContext);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.b.addView((View)localObject);
    this.d = new TextView(paramContext);
    this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
    this.d.setBackgroundColor(-12929302);
    ((LinearLayout)localObject).addView(this.d);
    this.d.setVisibility(8);
    this.c = new WebView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    paramContext.weight = 1.0F;
    this.c.setLayoutParams(paramContext);
    paramContext = new d(this, i);
    if ((Build.VERSION.SDK_INT <= 10) || (Build.VERSION.SDK_INT >= 17)) {}
  }
  
  private int b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (!(paramContext instanceof Activity)) {}
    do
    {
      return 0;
      paramContext = ((Activity)paramContext).getWindowManager();
    } while (paramContext == null);
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public View a()
  {
    return this.a.getBtnBack();
  }
  
  public void a(boolean paramBoolean)
  {
    TitleLayout localTitleLayout = this.a;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localTitleLayout.setVisibility(i);
      return;
    }
  }
  
  public WebView b()
  {
    return this.c;
  }
  
  public TitleLayout c()
  {
    return this.a;
  }
  
  public RelativeLayout d()
  {
    return this.b;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\RegisterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */