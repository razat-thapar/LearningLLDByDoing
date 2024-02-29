package Wissen; /******************************************************************************
 Welcome to GDB Online.
 Code, Compile, Run and Debug online from anywhere in world.
 *******************************************************************************/
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };

        Integer[] flattenedArray = flatten(array);

        System.out.println(Arrays.toString(flattenedArray));
    }

    public static Integer[] flatten(Object[] inputArray) throws Exception {
        // depth m :  max n length.
        //n times , m function calls.   O(M*N)  or TC: O(no of integer elements ) SC: O(depth)
        List<Integer> ans = new ArrayList<>();
        //Object obj = 1;
        //System.out.println(obj.class);
        flattenArray(inputArray,ans);
        //convert it.
        Integer[] result = new Integer[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        return result;
    }

    public static void flattenArray(Object[] inputArray, List<Integer> ans){
        //assumption: given inputArray of objects and need to flatten it and update ans.
        int n  = inputArray.length;
        for(int i=0;i<n;i++){
            //check if integer
            try{
                ans.add((Integer)inputArray[i]);
            }catch (Exception e){
                flattenArray((Object[]) inputArray[i],ans);
            }
        }
    }


}

