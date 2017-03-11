package com.veryfit.multi.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.util.DebugLog;
import com.veryfit.multi.R.styleable;

public class SportPieView
  extends RelativeLayout
{
  private static final float PIE_RADIUS_SCALE = 0.4347826F;
  private static final float SPACE_SCALE = 0.006521739F;
  private int[] SWEEP_COLOR = { 16078401, -698815, 16078401 };
  private int bg_color;
  Paint fullPaint;
  private int goal = 12000;
  private TextView goalView;
  private SweepGradient gradient;
  private int h;
  private ImageView imageview;
  private Paint paint;
  private TextView percentView;
  private int pie_color;
  private float pie_radius;
  private int progress;
  private RectF rectF;
  private Paint redPaint;
  private Paint ringPaint;
  private float ring_width;
  private float space;
  private TextView stepView;
  private int steps;
  private int w;
  
  public SportPieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130903123, this);
    setWillNotDraw(false);
    this.stepView = ((TextView)findViewById(2131231088));
    this.goalView = ((TextView)findViewById(2131231098));
    this.percentView = ((TextView)findViewById(2131231099));
    this.imageview = ((ImageView)findViewById(2131231097));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SportPieView);
    this.pie_color = paramContext.getColor(1, -698815);
    this.bg_color = paramContext.getColor(0, 570425344);
    this.SWEEP_COLOR[1] = this.pie_color;
    paramContext.recycle();
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.FILL);
    this.rectF = new RectF();
    this.ringPaint = new Paint(1);
    this.ringPaint.setStyle(Paint.Style.STROKE);
    this.ringPaint.setStrokeCap(Paint.Cap.BUTT);
    this.redPaint = new Paint(1);
    this.redPaint.setStyle(Paint.Style.STROKE);
    this.redPaint.setColor(this.pie_color);
    this.redPaint.setStrokeCap(Paint.Cap.ROUND);
    setWillNotDraw(false);
    this.fullPaint = new Paint(1);
    this.fullPaint.setStyle(Paint.Style.STROKE);
    this.fullPaint.setColor(this.pie_color);
    this.fullPaint.setStrokeCap(Paint.Cap.BUTT);
  }
  
  private void setShader(int paramInt)
  {
    this.gradient = new SweepGradient(this.w / 2, this.h / 2, this.SWEEP_COLOR, new float[] { 0.0F, paramInt / 100.0F, 1.0F });
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-90.0F, this.w / 2, this.h / 2);
    this.gradient.setLocalMatrix(localMatrix);
    this.ringPaint.setShader(this.gradient);
  }
  
  private void setSteps2View(int paramInt)
  {
    String str = paramInt + getResources().getString(2131296411);
    SpannableString localSpannableString = new SpannableString(str);
    int i = str.indexOf(paramInt);
    paramInt = paramInt.length();
    localSpannableString.setSpan(new RelativeSizeSpan(1.6666666F), i, i + paramInt, 33);
    this.stepView.setText(localSpannableString);
  }
  
  private void updateProgress(boolean paramBoolean)
  {
    if (this.goal == 0) {}
    for (double d = 0.0D;; d = Math.floor(this.steps * 100.0F / this.goal))
    {
      this.progress = ((int)d);
      this.percentView.setText(getResources().getString(2131296578, new Object[] { Integer.valueOf(this.progress) }));
      if (!paramBoolean) {
        break;
      }
      startAnim(this.progress);
      return;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    DebugLog.d("onDraw....progress:" + this.progress);
    this.paint.setColor(this.bg_color);
    paramCanvas.drawCircle(this.w / 2, this.h / 2, this.w / 2, this.paint);
    this.paint.setColor(this.pie_color);
    paramCanvas.drawCircle(this.w / 2, this.h / 2, this.pie_radius, this.paint);
    if ((this.progress > 0) && (this.progress < 100))
    {
      paramCanvas.drawArc(this.rectF, -90.0F, this.progress / 100.0F * 360.0F - 1.0F, false, this.ringPaint);
      paramCanvas.drawArc(this.rectF, this.progress / 100.0F * 360.0F - 2.0F - 90.0F, 0.5F, false, this.redPaint);
    }
    while (this.progress < 100) {
      return;
    }
    paramCanvas.drawArc(this.rectF, -90.0F, 360.0F, false, this.fullPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.w = paramInt1;
    this.h = paramInt2;
    setShader(this.progress);
    this.space = (paramInt1 * 0.006521739F);
    this.pie_radius = (paramInt1 * 0.4347826F);
    this.ring_width = (paramInt1 / 2 - this.space * 2.0F - this.pie_radius);
    this.ringPaint.setStrokeWidth(this.ring_width);
    this.redPaint.setStrokeWidth(this.ring_width);
    this.fullPaint.setStrokeWidth(this.ring_width);
    float f = this.space + this.ring_width / 2.0F;
    this.rectF.set(f, f, paramInt1 - f, paramInt2 - f);
  }
  
  public void setGoal(int paramInt)
  {
    this.goal = paramInt;
    this.goalView.setText(getResources().getString(2131296577, new Object[] { Integer.valueOf(paramInt) }));
    updateProgress(false);
  }
  
  public void setProgress(int paramInt)
  {
    paramInt = Math.min(100, Math.max(0, paramInt));
    if (this.progress != paramInt)
    {
      this.progress = paramInt;
      DebugLog.d("this.progress:" + this.progress);
      setShader(paramInt);
      invalidate();
    }
  }
  
  public void setSteps(int paramInt, boolean paramBoolean)
  {
    this.steps = paramInt;
    setSteps2View(paramInt);
    updateProgress(paramBoolean);
  }
  
  public void startAnim(int paramInt)
  {
    if (paramInt == -1) {}
    for (paramInt = this.progress;; paramInt = Math.min(100, paramInt))
    {
      int i = Math.max(0, Math.min(paramInt * 20, 1500));
      ObjectAnimator.ofInt(this, "progress", new int[] { 0, paramInt }).setDuration(i).start();
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\SportPieView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */