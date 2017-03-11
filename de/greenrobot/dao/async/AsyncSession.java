package de.greenrobot.dao.async;

import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.query.Query;
import java.util.concurrent.Callable;

public class AsyncSession
{
  private final AbstractDaoSession daoSession;
  private final AsyncOperationExecutor executor;
  
  public AsyncSession(AbstractDaoSession paramAbstractDaoSession)
  {
    this.daoSession = paramAbstractDaoSession;
    this.executor = new AsyncOperationExecutor();
  }
  
  private <E> AsyncOperation enqueEntityOperation(AsyncOperation.OperationType paramOperationType, Class<E> paramClass, Object paramObject, int paramInt)
  {
    paramOperationType = new AsyncOperation(paramOperationType, this.daoSession.getDao(paramClass), paramObject, paramInt);
    this.executor.enqueue(paramOperationType);
    return paramOperationType;
  }
  
  private AsyncOperation enqueueDatabaseOperation(AsyncOperation.OperationType paramOperationType, Object paramObject, int paramInt)
  {
    paramOperationType = new AsyncOperation(paramOperationType, this.daoSession.getDatabase(), paramObject, paramInt);
    this.executor.enqueue(paramOperationType);
    return paramOperationType;
  }
  
  private AsyncOperation enqueueEntityOperation(AsyncOperation.OperationType paramOperationType, Object paramObject, int paramInt)
  {
    return enqueEntityOperation(paramOperationType, paramObject.getClass(), paramObject, paramInt);
  }
  
  public AsyncOperation callInTx(Callable<?> paramCallable)
  {
    return callInTx(paramCallable, 0);
  }
  
  public AsyncOperation callInTx(Callable<?> paramCallable, int paramInt)
  {
    return enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionCallable, paramCallable, paramInt);
  }
  
  public AsyncOperation count(Class<?> paramClass)
  {
    return count(paramClass, 0);
  }
  
  public AsyncOperation count(Class<?> paramClass, int paramInt)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.Count, paramClass, null, paramInt);
  }
  
  public AsyncOperation delete(Object paramObject)
  {
    return delete(paramObject, 0);
  }
  
  public AsyncOperation delete(Object paramObject, int paramInt)
  {
    return enqueueEntityOperation(AsyncOperation.OperationType.Delete, paramObject, paramInt);
  }
  
  public <E> AsyncOperation deleteAll(Class<E> paramClass)
  {
    return deleteAll(paramClass, 0);
  }
  
  public <E> AsyncOperation deleteAll(Class<E> paramClass, int paramInt)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.DeleteAll, paramClass, null, paramInt);
  }
  
  public AsyncOperation deleteByKey(Object paramObject)
  {
    return deleteByKey(paramObject, 0);
  }
  
  public AsyncOperation deleteByKey(Object paramObject, int paramInt)
  {
    return enqueueEntityOperation(AsyncOperation.OperationType.DeleteByKey, paramObject, paramInt);
  }
  
  public <E> AsyncOperation deleteInTx(Class<E> paramClass, int paramInt, E... paramVarArgs)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.DeleteInTxArray, paramClass, paramVarArgs, paramInt);
  }
  
  public <E> AsyncOperation deleteInTx(Class<E> paramClass, Iterable<E> paramIterable)
  {
    return deleteInTx(paramClass, paramIterable, 0);
  }
  
  public <E> AsyncOperation deleteInTx(Class<E> paramClass, Iterable<E> paramIterable, int paramInt)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.DeleteInTxIterable, paramClass, paramIterable, paramInt);
  }
  
  public <E> AsyncOperation deleteInTx(Class<E> paramClass, E... paramVarArgs)
  {
    return deleteInTx(paramClass, 0, paramVarArgs);
  }
  
  public AsyncOperationListener getListener()
  {
    return this.executor.getListener();
  }
  
  public AsyncOperationListener getListenerMainThread()
  {
    return this.executor.getListenerMainThread();
  }
  
  public int getMaxOperationCountToMerge()
  {
    return this.executor.getMaxOperationCountToMerge();
  }
  
  public int getWaitForMergeMillis()
  {
    return this.executor.getWaitForMergeMillis();
  }
  
  public AsyncOperation insert(Object paramObject)
  {
    return insert(paramObject, 0);
  }
  
  public AsyncOperation insert(Object paramObject, int paramInt)
  {
    return enqueueEntityOperation(AsyncOperation.OperationType.Insert, paramObject, paramInt);
  }
  
  public <E> AsyncOperation insertInTx(Class<E> paramClass, int paramInt, E... paramVarArgs)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.InsertInTxArray, paramClass, paramVarArgs, paramInt);
  }
  
  public <E> AsyncOperation insertInTx(Class<E> paramClass, Iterable<E> paramIterable)
  {
    return insertInTx(paramClass, paramIterable, 0);
  }
  
  public <E> AsyncOperation insertInTx(Class<E> paramClass, Iterable<E> paramIterable, int paramInt)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.InsertInTxIterable, paramClass, paramIterable, paramInt);
  }
  
  public <E> AsyncOperation insertInTx(Class<E> paramClass, E... paramVarArgs)
  {
    return insertInTx(paramClass, 0, paramVarArgs);
  }
  
  public AsyncOperation insertOrReplace(Object paramObject)
  {
    return insertOrReplace(paramObject, 0);
  }
  
  public AsyncOperation insertOrReplace(Object paramObject, int paramInt)
  {
    return enqueueEntityOperation(AsyncOperation.OperationType.InsertOrReplace, paramObject, paramInt);
  }
  
  public <E> AsyncOperation insertOrReplaceInTx(Class<E> paramClass, int paramInt, E... paramVarArgs)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.InsertOrReplaceInTxArray, paramClass, paramVarArgs, paramInt);
  }
  
  public <E> AsyncOperation insertOrReplaceInTx(Class<E> paramClass, Iterable<E> paramIterable)
  {
    return insertOrReplaceInTx(paramClass, paramIterable, 0);
  }
  
  public <E> AsyncOperation insertOrReplaceInTx(Class<E> paramClass, Iterable<E> paramIterable, int paramInt)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.InsertOrReplaceInTxIterable, paramClass, paramIterable, paramInt);
  }
  
  public <E> AsyncOperation insertOrReplaceInTx(Class<E> paramClass, E... paramVarArgs)
  {
    return insertOrReplaceInTx(paramClass, 0, paramVarArgs);
  }
  
  public boolean isCompleted()
  {
    return this.executor.isCompleted();
  }
  
  public AsyncOperation load(Class<?> paramClass, Object paramObject)
  {
    return load(paramClass, paramObject, 0);
  }
  
  public AsyncOperation load(Class<?> paramClass, Object paramObject, int paramInt)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.Load, paramClass, paramObject, paramInt);
  }
  
  public AsyncOperation loadAll(Class<?> paramClass)
  {
    return loadAll(paramClass, 0);
  }
  
  public AsyncOperation loadAll(Class<?> paramClass, int paramInt)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.LoadAll, paramClass, null, paramInt);
  }
  
  public AsyncOperation queryList(Query<?> paramQuery)
  {
    return queryList(paramQuery, 0);
  }
  
  public AsyncOperation queryList(Query<?> paramQuery, int paramInt)
  {
    return enqueueDatabaseOperation(AsyncOperation.OperationType.QueryList, paramQuery, paramInt);
  }
  
  public AsyncOperation queryUnique(Query<?> paramQuery)
  {
    return queryUnique(paramQuery, 0);
  }
  
  public AsyncOperation queryUnique(Query<?> paramQuery, int paramInt)
  {
    return enqueueDatabaseOperation(AsyncOperation.OperationType.QueryUnique, paramQuery, paramInt);
  }
  
  public AsyncOperation refresh(Object paramObject)
  {
    return refresh(paramObject, 0);
  }
  
  public AsyncOperation refresh(Object paramObject, int paramInt)
  {
    return enqueueEntityOperation(AsyncOperation.OperationType.Refresh, paramObject, paramInt);
  }
  
  public AsyncOperation runInTx(Runnable paramRunnable)
  {
    return runInTx(paramRunnable, 0);
  }
  
  public AsyncOperation runInTx(Runnable paramRunnable, int paramInt)
  {
    return enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionRunnable, paramRunnable, paramInt);
  }
  
  public void setListener(AsyncOperationListener paramAsyncOperationListener)
  {
    this.executor.setListener(paramAsyncOperationListener);
  }
  
  public void setListenerMainThread(AsyncOperationListener paramAsyncOperationListener)
  {
    this.executor.setListenerMainThread(paramAsyncOperationListener);
  }
  
  public void setMaxOperationCountToMerge(int paramInt)
  {
    this.executor.setMaxOperationCountToMerge(paramInt);
  }
  
  public void setWaitForMergeMillis(int paramInt)
  {
    this.executor.setWaitForMergeMillis(paramInt);
  }
  
  public AsyncOperation update(Object paramObject)
  {
    return update(paramObject, 0);
  }
  
  public AsyncOperation update(Object paramObject, int paramInt)
  {
    return enqueueEntityOperation(AsyncOperation.OperationType.Update, paramObject, paramInt);
  }
  
  public <E> AsyncOperation updateInTx(Class<E> paramClass, int paramInt, E... paramVarArgs)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.UpdateInTxArray, paramClass, paramVarArgs, paramInt);
  }
  
  public <E> AsyncOperation updateInTx(Class<E> paramClass, Iterable<E> paramIterable)
  {
    return updateInTx(paramClass, paramIterable, 0);
  }
  
  public <E> AsyncOperation updateInTx(Class<E> paramClass, Iterable<E> paramIterable, int paramInt)
  {
    return enqueEntityOperation(AsyncOperation.OperationType.UpdateInTxIterable, paramClass, paramIterable, paramInt);
  }
  
  public <E> AsyncOperation updateInTx(Class<E> paramClass, E... paramVarArgs)
  {
    return updateInTx(paramClass, 0, paramVarArgs);
  }
  
  public void waitForCompletion()
  {
    this.executor.waitForCompletion();
  }
  
  public boolean waitForCompletion(int paramInt)
  {
    return this.executor.waitForCompletion(paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\async\AsyncSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */