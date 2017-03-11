package de.greenrobot.dao.async;

import de.greenrobot.dao.DaoException;

public class AsyncDaoException
  extends DaoException
{
  private static final long serialVersionUID = 5872157552005102382L;
  private final AsyncOperation failedOperation;
  
  public AsyncDaoException(AsyncOperation paramAsyncOperation, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.failedOperation = paramAsyncOperation;
  }
  
  public AsyncOperation getFailedOperation()
  {
    return this.failedOperation;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\async\AsyncDaoException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */