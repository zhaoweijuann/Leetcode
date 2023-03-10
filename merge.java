public class merge {
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        int m = 1;
        int n = 1;
        merge(nums1,m,nums2,n);

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if ( m == 0)
            for (int i = 0; i < nums1.length; i++){
                nums1[i] = nums2[i];
            }
        else if (n == 0){

        }else {
            int mm = nums1.length-1;
            while(m > 0 && n > 0){
                if (nums1[m-1] <= nums2[n-1]){
                    nums1[mm] = nums2[n-1];
                    n--;
                }else {
                    nums1[mm] = nums1[m-1];
                    nums1[m-1] = 0;
                    m--;
                }
                mm--;
            }
            if (n > 0){
                while (n > 0){
                    nums1[mm] = nums2[n-1];
                    n--;
                    mm--;
                }
            }
        }
    }
}
