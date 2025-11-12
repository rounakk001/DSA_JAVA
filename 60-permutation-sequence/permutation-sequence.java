public class Solution {

    static int count = 0;
    static String result = "";

    public static String getPermutation(int n, int k) {
        count = 0;
        result = "";
        StringBuilder numbers = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            numbers.append(i);
        }
        findPermutation(numbers.toString(), "", k);
        return result;
    }

    public static void findPermutation(String str, String ans, int k) {
        if (str.length() == 0) {
            count++;
            if (count == k) {
                result = ans;
            }
            return;
        }

        char[] arr = str.toCharArray();
        java.util.Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];
String newStr = str.substring(0, str.indexOf(curr)) + str.substring(str.indexOf(curr) + 1);
            findPermutation(newStr, ans + curr, k);
            if (!result.equals("")) 
            return;
        }
    }

}
