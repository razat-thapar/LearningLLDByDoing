package automation_anywhere;

import java.io.Serial;

public class MySingletonClass {
    private static MySingletonClass instance = null;
    //double check locking
    private MySingletonClass(){

    }
    public static MySingletonClass getInstance(){
        if(instance==null){
            synchronized(MySingletonClass.class){
                if(instance==null){
                    instance = new MySingletonClass();
                }
            }
        }
        return instance;
    }
    @Serial
    public Object readResolve(){
        return instance;
    }
}
