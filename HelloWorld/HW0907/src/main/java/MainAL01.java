import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/09/07 20:11
 */

public class MainAL01 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] l1 = in.nextLine().split(",");
//        String[] l2 = in.nextLine().split(",");
//        int x = in.nextInt();
//
//        System.out.println("yes,0");
//        in.close();
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(getResult(nums));
        in.close();
    }

    private static int getResult(int[] nums) {
        int result = 0;

        if (isRight(nums, 0, nums.length)){
            return 1;
        }

        int s = 0,l = 3;
        for (int i = l; i < nums.length - 3; i++) {
            for (int j = 0; j < nums.length - 3; j++) {
                if (isRight(nums, j, i)){

                }
            }
        }

        return result;

    }

    private static boolean isRight(int[] nums, int s, int l) {
        int mid = 0;
        // j表示当前位置的前一个位置
        for (int i = 1; i < l; i++) {
            int cur = s + i, pre = cur - 1;
            if (i == 1){
                mid = nums[cur] - nums[pre];
            } else {
                if (nums[cur] - nums[pre] != mid){
                    break;
                } else if (i + 1 == l){
                    return true;
                }
            }
        }

        for (int i = 1; i < l; i++) {
            int cur = s + i, pre = cur - 1, next = cur + 1;
            if (nums[cur] * nums[cur] != nums[pre] * nums[next]){
                return false;
            }
        }
        return true;
    }

}
