import java.util.HashMap;
import java.util.Map;
/**以这个字符串为例：abcabcbb，当i等于3时，也就是指向了第二个a, 此时我就需要查之前有没有出现过a,
 * 如果出现了是在哪一个位置出现的。然后通过last[index] 查到等于1, 也就是说，
 * 如果start 依然等于0的话，那么当前窗口就有两个a了，也就是字符串重复了，所以我们需要移动当前窗口的start指针，
 * 移动到什么地方呢？移动到什么地方，窗口内就没有重复元素了呢？
 * 对了，就是a上一次出现的位置的下一个位置，就是1 + 1 = 2。
 * 当start == 2, 当前窗口就没有了重复元素，那么以当前字符为结尾的最长无重复子串就是bca,
 * 然后再和之前的res取最大值。然后i指向后面的位置，按照同样思路计算。*/
/**for (int i = 0; i < n; i++){
 l = location[s.charAt(i)];
 start = Math.max(start,l+1);
 last = Math.max(last,i-start+1);
 }*/
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcdbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
        length = l(s);
        System.out.println(length);

    }
    public static  int length(String s){
        int[] location = new int[128];
        for (int i = 0; i < location.length; i++){
            location[i] = -1;
        }
        int n = s.length();
        int l = 0;
        int start = 0;
        int last = 0;
        for (int i = 0; i < n; i++){
            l = location[s.charAt(i)];
            start = Math.max(start,l+1);
            last = Math.max(last,i-start+1);
        }

        for (int i = 0; i < n; i++){
            l = location[s.charAt(i)];
            start = Math.max(start,l+1);
            last = Math.max(last,i-start+1);
        }
        return last;
    }
public static int l(String s){
    // 记录字符上一次出现的位置
    int[] last = new int[128];
    for(int i = 0; i < 128; i++) {
        last[i] = -1;
    }
    int n = s.length();

    int res = 0;
    int start = 0; // 窗口开始位置
    for(int i = 0; i < n; i++) {
        int index = s.charAt(i);
        start = Math.max(start, last[index] + 1);
        res   = Math.max(res, i - start + 1);
        last[index] = i;
    }

    return res;
}

        public static int lengthOfLongestSubstring(String s) {
            Map[] str = new HashMap[s.length()];
            for(int i = 0; i < s.length(); i++){
                Map map = new HashMap();
                map.put(s.charAt(i),null);
                for(int j = i+1; j < s.length(); j++){
                    char c = s.charAt(j);
                    if(map.containsKey(c)){
                        break;
                    }else{
                        map.put(s.charAt(j),null);
                    }
                }
                str[i] = map;
            }
            int length = 0;
            for(int i = 0; i < str.length; i++){
                if(str[i]!=null && str[i].size() > length){
                    length = str[i].size();
                }
            }
            return length;
        }

}
