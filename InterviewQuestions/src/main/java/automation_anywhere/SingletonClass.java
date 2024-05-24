package automation_anywhere;

public class SingletonClass {
    private static SingletonClass instance;
    //double check locking.
    //eager initialization.
    private SingletonClass(){

    }
    public static SingletonClass getInstance(){
        if(instance == null){
            synchronized (SingletonClass.class){
                if(instance == null){
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
