package JUC;

public class SingletonDoubleCheckLock {
    private SingletonDoubleCheckLock(){
    }

    private volatile static SingletonDoubleCheckLock instance;

    public SingletonDoubleCheckLock getInstance(){
        if (null == instance){
            synchronized (SingletonDoubleCheckLock.class){
                if (null == instance) {
                    instance = new SingletonDoubleCheckLock();
                }
            }
        }
        return instance;
    }
}




