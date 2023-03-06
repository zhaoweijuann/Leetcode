import java.util.HashMap;
import java.util.Map;
/**可以使用摩尔投票算法（Boyer-Moore Voting Algorithm）来解决此问题，
 该算法时间复杂度为 O(n)，空间复杂度为 O(1)。
 具体实现步骤如下：
 初始化候选众数为 nums[0]，票数为 1。
 遍历数组 nums，若当前数字等于候选众数，则票数加一，否则票数减一。
 若票数为 0，则将当前数字设为候选众数，票数设为 1。
 遍历结束后，候选众数即为所求的多数元素。*/
public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int res = majorityE(nums);

        System.out.println(res);
    }
    public static int majorityElement(int[] nums){
        int res = 0;
        if (nums.length == 1)
            return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if (map.get(nums[i])>nums.length/2){
                    res = nums[i];
                    break;
                }
            }else {
                map.put(nums[i],1);
            }
        }
        return res;
    }
    public static int majorityE(int[] nums){
        int candidate =  nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == candidate){
                count++;
            }else {
                count--;
                if (count == 0){
                    candidate = nums[i];
                    count = 1;
                }
            }

        }
        return candidate;
    }
}
