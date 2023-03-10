public class isPalindrome {
    /**如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。

     字母和数字都属于字母数字字符。

     给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
    */
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(is_palindrome(s));

    }
    public static boolean is_palindrome(String s){
        StringBuffer s_b = new StringBuffer();
        int length = s.length();
        s = s.toLowerCase();
        for (int i = 0; i < length; i++){
            if (Character.isLetterOrDigit(s.charAt(i))){
                s_b.append(s.charAt(i));
            }
        }
        StringBuffer s_f = new StringBuffer(s_b).reverse();
        if (s_b.toString().equals(s_f.toString())){
            return true;
        }else {
            return false;
        }
    }
}
