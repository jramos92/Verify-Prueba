package com.veryfit.multi.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

@SuppressLint({"HandlerLeak"})
public class BufferDialog
{
  private Dialog mDialog;
  private ProgressBar progressBar;
  private TextView titleView;
  
  public BufferDialog(Activity paramActivity, String paramString)
  {
    this.mDialog = new Dialog(paramActivity, 2131427342);
    this.mDialog.setContentView(2130903080);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setCancelable(false);
    this.titleView = ((TextView)this.mDialog.findViewById(2131230930));
    this.progressBar = ((ProgressBar)this.mDialog.findViewById(2131230929));
    this.titleView.setText(paramString);
  }
  
  public BufferDialog(Context paramContext)
  {
    this.mDialog = new Dialog(paramContext, 2131427342);
    this.mDialog.setContentView(2130903080);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setCancelable(false);
    this.titleView = ((TextView)this.mDialog.findViewById(2131230930));
    this.progressBar = ((ProgressBar)this.mDialog.findViewById(2131230929));
  }
  
  public void dismiss()
  {
    this.mDialog.dismiss();
  }
  
  public boolean isShow()
  {
    return this.mDialog.isShowing();
  }
  
  public void setTitle(String paramString)
  {
    this.titleView.setText(paramString);
  }
  
  public void setVisibility()
  {
    this.progressBar.setVisibility(8);
  }
  
  public void show()
  {
    try
    {
      this.mDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void show1()
  {
    try
    {
      this.mDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\BufferDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */