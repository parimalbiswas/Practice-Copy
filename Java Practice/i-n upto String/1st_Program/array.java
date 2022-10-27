public class array {
    public static void main(String[] args) {
        int nums[] = new int[6];

        nums[0] = 5;
        nums[1] = 5;
        nums[2] = 5;
        nums[3] = 5;
        nums[4] = 5;
        nums[5] = 5;

        for (var i = 0; i < nums.length; i++) {
        System.out.println(nums[i]);
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
