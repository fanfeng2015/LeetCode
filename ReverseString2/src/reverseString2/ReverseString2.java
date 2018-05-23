package reverseString2;

// LeetCode #541 (Reverse String II).

// Given a string and an integer k, you need to reverse the first k characters for every 2k 
// characters counting from the start of the string. 

// If there are less than k characters left, reverse all of them. If there are less than 2k
// but greater than or equal to k characters, then reverse the first k characters and left 
// the other as original.


public class ReverseString2 {

    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int start = 0;
        while (start < array.length) {
            reverse(array, start, Math.min(start + k - 1, array.length - 1));
            start += 2 * k;
        }
        return new String(array);
    }
    
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    
    // Time complexity is O(n).
    // Space complexity is O(n).
}
