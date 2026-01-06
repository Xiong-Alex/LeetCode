class Solution {
    public int thirdMax(int[] nums) {

        Integer first = null;
        Integer second = null;
        Integer third = null;

        // Find first max
        for (int n : nums) {
            if (first == null || n > first) {
                first = n;
            }
        }

        // Find second max (not equal to first)
        for (int n : nums) {
            if (n != first && (second == null || n > second)) {
                second = n;
            }
        }

        // Find third max (not equal to first or second)
        for (int n : nums) {
            if (n != first && n != second &&
                (third == null || n > third)) {
                third = n;
            }
        }

        // If third doesn't exist, return first
        return third == null ? first : third;
    }
}
