package de.greenrobot.dao.async;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.query.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class AsyncOperationExecutor
  implements Runnable, Handler.Callback
{
  private static ExecutorService executorService = ;
  private int countOperationsCompleted;
  private int countOperationsEnqueued;
  private volatile boolean executorRunning;
  private Handler handlerMainThread;
  private int lastSequenceNumber;
  private volatile AsyncOperationListener listener;
  private volatile AsyncOperationListener listenerMainThread;
  private volatile int maxOperationCountToMerge = 50;
  private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue();
  private volatile int waitForMergeMillis = 50;
  
  private void executeOperation(AsyncOperation paramAsyncOperation)
  {
    paramAsyncOperation.timeStarted = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        switch (paramAsyncOperation.type)
        {
        case ???: 
          throw new DaoException("Unsupported operation: " + paramAsyncOperation.type);
        }
      }
      catch (Throwable localThrowable)
      {
        paramAsyncOperation.throwable = localThrowable;
        paramAsyncOperation.timeCompleted = System.currentTimeMillis();
        return;
      }
      paramAsyncOperation.dao.delete(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.deleteInTx((Iterable)paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.deleteInTx((Object[])paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insert(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertInTx((Iterable)paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertInTx((Object[])paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertOrReplace(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertOrReplaceInTx((Iterable)paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertOrReplaceInTx((Object[])paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.update(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.updateInTx((Iterable)paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.updateInTx((Object[])paramAsyncOperation.parameter);
      continue;
      executeTransactionRunnable(paramAsyncOperation);
      continue;
      executeTransactionCallable(paramAsyncOperation);
      continue;
      paramAsyncOperation.result = ((Query)paramAsyncOperation.parameter).list();
      continue;
      paramAsyncOperation.result = ((Query)paramAsyncOperation.parameter).unique();
      continue;
      paramAsyncOperation.dao.deleteByKey(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.deleteAll();
      continue;
      paramAsyncOperation.result = paramAsyncOperation.dao.load(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.result = paramAsyncOperation.dao.loadAll();
      continue;
      paramAsyncOperation.result = Long.valueOf(paramAsyncOperation.dao.count());
      continue;
      paramAsyncOperation.dao.refresh(paramAsyncOperation.parameter);
    }
  }
  
  private void executeOperationAndPostCompleted(AsyncOperation paramAsyncOperation)
  {
    executeOperation(paramAsyncOperation);
    handleOperationCompleted(paramAsyncOperation);
  }
  
  private void executeTransactionCallable(AsyncOperation paramAsyncOperation)
    throws Exception
  {
    SQLiteDatabase localSQLiteDatabase = paramAsyncOperation.getDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramAsyncOperation.result = ((Callable)paramAsyncOperation.parameter).call();
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  private void executeTransactionRunnable(AsyncOperation paramAsyncOperation)
  {
    SQLiteDatabase localSQLiteDatabase = paramAsyncOperation.getDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ((Runnable)paramAsyncOperation.parameter).run();
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  private void handleOperationCompleted(AsyncOperation paramAsyncOperation)
  {
    paramAsyncOperation.setCompleted();
    AsyncOperationListener localAsyncOperationListener = this.listener;
    if (localAsyncOperationListener != null) {
      localAsyncOperationListener.onAsyncOperationCompleted(paramAsyncOperation);
    }
    if (this.listenerMainThread != null)
    {
      if (this.handlerMainThread == null) {
        this.handlerMainThread = new Handler(Looper.getMainLooper(), this);
      }
      paramAsyncOperation = this.handlerMainThread.obtainMessage(1, paramAsyncOperation);
      this.handlerMainThread.sendMessage(paramAsyncOperation);
    }
    try
    {
      this.countOperationsCompleted += 1;
      if (this.countOperationsCompleted == this.countOperationsEnqueued) {
        notifyAll();
      }
      return;
    }
    finally {}
  }
  
  private void mergeTxAndExecute(AsyncOperation paramAsyncOperation1, AsyncOperation paramAsyncOperation2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAsyncOperation1);
    localArrayList.add(paramAsyncOperation2);
    paramAsyncOperation1 = paramAsyncOperation1.getDatabase();
    paramAsyncOperation1.beginTransaction();
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      AsyncOperation localAsyncOperation;
      try
      {
        if (i < localArrayList.size())
        {
          localAsyncOperation = (AsyncOperation)localArrayList.get(i);
          executeOperation(localAsyncOperation);
          boolean bool = localAsyncOperation.isFailed();
          if (bool) {
            j = 1;
          }
        }
        else
        {
          paramAsyncOperation1.endTransaction();
          if (j == 0) {
            break label232;
          }
          DaoLog.i("Revered merged transaction because one of the operations failed. Executing operations one by one instead...");
          paramAsyncOperation1 = localArrayList.iterator();
          while (paramAsyncOperation1.hasNext())
          {
            paramAsyncOperation2 = (AsyncOperation)paramAsyncOperation1.next();
            paramAsyncOperation2.reset();
            executeOperationAndPostCompleted(paramAsyncOperation2);
          }
        }
        if (i != localArrayList.size() - 1) {
          break label277;
        }
        paramAsyncOperation2 = (AsyncOperation)this.queue.peek();
        if ((i >= this.maxOperationCountToMerge) || (!localAsyncOperation.isMergeableWith(paramAsyncOperation2))) {
          break label225;
        }
        localAsyncOperation = (AsyncOperation)this.queue.remove();
        if (localAsyncOperation != paramAsyncOperation2) {
          throw new DaoException("Internal error: peeked op did not match removed op");
        }
      }
      finally
      {
        paramAsyncOperation1.endTransaction();
      }
      localArrayList.add(localAsyncOperation);
      break label277;
      label225:
      paramAsyncOperation1.setTransactionSuccessful();
      break label277;
      label232:
      i = localArrayList.size();
      paramAsyncOperation1 = localArrayList.iterator();
      while (paramAsyncOperation1.hasNext())
      {
        paramAsyncOperation2 = (AsyncOperation)paramAsyncOperation1.next();
        paramAsyncOperation2.mergedOperationsCount = i;
        handleOperationCompleted(paramAsyncOperation2);
      }
      return;
      label277:
      i += 1;
    }
  }
  
  public void enqueue(AsyncOperation paramAsyncOperation)
  {
    try
    {
      int i = this.lastSequenceNumber + 1;
      this.lastSequenceNumber = i;
      paramAsyncOperation.sequenceNumber = i;
      this.queue.add(paramAsyncOperation);
      this.countOperationsEnqueued += 1;
      if (!this.executorRunning)
      {
        this.executorRunning = true;
        executorService.execute(this);
      }
      return;
    }
    finally {}
  }
  
  public AsyncOperationListener getListener()
  {
    return this.listener;
  }
  
  public AsyncOperationListener getListenerMainThread()
  {
    return this.listenerMainThread;
  }
  
  public int getMaxOperationCountToMerge()
  {
    return this.maxOperationCountToMerge;
  }
  
  public int getWaitForMergeMillis()
  {
    return this.waitForMergeMillis;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AsyncOperationListener localAsyncOperationListener = this.listenerMainThread;
    if (localAsyncOperationListener != null) {
      localAsyncOperationListener.onAsyncOperationCompleted((AsyncOperation)paramMessage.obj);
    }
    return false;
  }
  
  /* Error */
  public boolean isCompleted()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 272	de/greenrobot/dao/async/AsyncOperationExecutor:countOperationsEnqueued	I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 270	de/greenrobot/dao/async/AsyncOperationExecutor:countOperationsCompleted	I
    //   11: istore_2
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpne +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	AsyncOperationExecutor
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   18	7	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  public void run()
  {
    for (;;)
    {
      AsyncOperation localAsyncOperation3;
      try
      {
        localAsyncOperation3 = (AsyncOperation)this.queue.poll(1L, TimeUnit.SECONDS);
        localAsyncOperation1 = localAsyncOperation3;
        if (localAsyncOperation3 != null) {}
      }
      catch (InterruptedException localInterruptedException)
      {
        AsyncOperation localAsyncOperation1;
        localInterruptedException = localInterruptedException;
        DaoLog.w(Thread.currentThread().getName() + " was interruppted", localInterruptedException);
        return;
      }
      finally
      {
        this.executorRunning = false;
      }
      executeOperationAndPostCompleted(localAsyncOperation2);
      executeOperationAndPostCompleted(localAsyncOperation3);
      continue;
      executeOperationAndPostCompleted(localAsyncOperation2);
    }
  }
  
  public void setListener(AsyncOperationListener paramAsyncOperationListener)
  {
    this.listener = paramAsyncOperationListener;
  }
  
  public void setListenerMainThread(AsyncOperationListener paramAsyncOperationListener)
  {
    this.listenerMainThread = paramAsyncOperationListener;
  }
  
  public void setMaxOperationCountToMerge(int paramInt)
  {
    this.maxOperationCountToMerge = paramInt;
  }
  
  public void setWaitForMergeMillis(int paramInt)
  {
    this.waitForMergeMillis = paramInt;
  }
  
  public void waitForCompletion()
  {
    try
    {
      for (;;)
      {
        boolean bool = isCompleted();
        if (!bool) {
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new DaoException("Interrupted while waiting for all operations to complete", localInterruptedException);
          }
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public boolean waitForCompletion(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 410	de/greenrobot/dao/async/AsyncOperationExecutor:isCompleted	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +11 -> 19
    //   11: iload_1
    //   12: i2l
    //   13: lstore_3
    //   14: aload_0
    //   15: lload_3
    //   16: invokevirtual 422	java/lang/Object:wait	(J)V
    //   19: aload_0
    //   20: invokevirtual 410	de/greenrobot/dao/async/AsyncOperationExecutor:isCompleted	()Z
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: astore 5
    //   30: new 83	de/greenrobot/dao/DaoException
    //   33: dup
    //   34: ldc_w 415
    //   37: aload 5
    //   39: invokespecial 418	de/greenrobot/dao/DaoException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   42: athrow
    //   43: astore 5
    //   45: aload_0
    //   46: monitorexit
    //   47: aload 5
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	AsyncOperationExecutor
    //   0	50	1	paramInt	int
    //   6	21	2	bool	boolean
    //   13	3	3	l	long
    //   28	10	5	localInterruptedException	InterruptedException
    //   43	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	19	28	java/lang/InterruptedException
    //   2	7	43	finally
    //   14	19	43	finally
    //   19	24	43	finally
    //   30	43	43	finally
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\async\AsyncOperationExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */