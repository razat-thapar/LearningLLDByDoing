package automation_anywhere;

public class CustomException {
    public static void main(String[] args) {
        try{
            int a = 1/0;
        }catch(ArithmeticException e){
            throw new ArithmeticException("You are trying to divide by zero!");
        }
    }
}


