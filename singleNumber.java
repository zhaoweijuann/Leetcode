import java.util.HashMap;
import java.util.Map;
/**a^a=0；自己和自己异或等于0
 a^0=a；任何数字和0异或还等于他自己
 a^b^c=a^c^b；异或运算具有交换律*/
public class singleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int res = singleN(nums);
        System.out.println(res);
    }
    public static int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int i: map.keySet()){
            if(map.get(i) == 1){
                return i;
            }
        }
        return 0;
    }
    public static int singleN(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
