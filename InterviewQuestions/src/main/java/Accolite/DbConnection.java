package Accolite;

public class DbConnection {

    private static DbConnection instance = null;

    private DbConnection(){

    }

    public static DbConnection getInstance(){
        if(instance==null){
            synchronized (DbConnection.class){
                if(instance == null){
                    instance = new DbConnection();
                    return instance;
                }
            }
        }
        return instance;
    }

}
