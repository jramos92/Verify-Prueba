package de.greenrobot.dao;

import android.database.SQLException;

public class DaoException
  extends SQLException
{
  private static final long serialVersionUID = -5877937327907457779L;
  
  public DaoException() {}
  
  public DaoException(String paramString)
  {
    super(paramString);
  }
  
  public DaoException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    safeInitCause(paramThrowable);
  }
  
  public DaoException(Throwable paramThrowable)
  {
    safeInitCause(paramThrowable);
  }
  
  protected void safeInitCause(Throwable paramThrowable)
  {
    try
    {
      initCause(paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      DaoLog.e("Could not set initial cause", localThrowable);
      DaoLog.e("Initial cause is:", paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\DaoException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */