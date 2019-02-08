 

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        
        for (int i = 0; i < array.length; i++){
            if (array[i].equals(value)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        int length = array.length;
        String[] revArr = new String[length];
        
        for (int i = 0; i < length; i++){
            revArr[length - 1 - i] = array[i];
        }
        return revArr;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] revArr = reverse(array);
        for (int i = 0; i < array.length; i++){
            if (revArr[i] != array[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};
            boolean belongs = false;
    
        for (int i = 0; i < 26; i++){
            belongs = false;
            for (int j = 0; j < array.length; j++){
               if (belongs == false){
                for(int k = 0; k < array[j].length(); k++){
                    if (alphabet[i] == Character.toLowerCase(array[j].charAt(k))){
                        belongs = true;
                    }
                }
            }
        }
        if (belongs == false){
            return false;
        }
    }
     return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i].equals(value)){
                count++;
            }
        }
        return count;
   
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] answer = new String[array.length - getNumberOfOccurrences(array, valueToRemove)];
        int answerIndex = 0;
        
        for(int i = 0; i < array.length; i++){
            if (array[i].equals(valueToRemove) == false){
                answer[answerIndex] = array[i];
                answerIndex++;
            }
        }
        return answer;
        
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        
        int answerLength = 1;
        
        for (int i = 1; i < array.length; i++){
            if (array[i].equals(array[i - 1]) == false){
                answerLength++;
            }
        }
        
        String[] answer = new String[answerLength];
        int answerIndex = 1;
        answer[0] = array[0];
        
        for (int i = 1; i < array.length ; i++){
            if (array[i].equals(array[i - 1]) == false){
                answer[answerIndex] = array[i];
                answerIndex++;
            }
        }
        return answer;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        
        int answerSize = 1;
        int answerIndex = 0;
        
        for (int i = 1; i < array.length; i++){
            if (array[i].equals(array[i - 1]) == false){
                answerSize++;
            }
        }
        
        String[] answer = new String[answerSize];
        String curr = "";
        
        for (int i = 0; i < array.length; i++){
            if (i == 0 || (array[i].equals(array[i - 1]))){
                curr = curr + array[i];
            }
            else{
                answer[answerIndex] = curr;
                answerIndex++;
                curr = array[i];
            }
        }
        answer[answerIndex] = curr;
        return answer;
    }


}
