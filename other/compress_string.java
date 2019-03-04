/* compress string: aacbbbc -> a2c1b3c1 */
// using String
public static void main(String[] args) {
    String a = "aaabbccaaaddj";

    for(int i = 0;i < a.length(); i++){
        int c = i + 1;
        int duplicateCharCount = 1;
        while(c < a.length() && a.charAt(c) == a.charAt(i)){
            ++c;
            ++duplicateCharCount;
        }

        a = a.substring(0, i + 1) + duplicateCharCount + a.substring(i + duplicateCharCount);
        i++;
    }
    System.out.println(a);
}

// using StringBuilder
public static String compress(String str) {
    StringBuilder result = new StringBuilder();
    int i;
    int count = 0;
    for(i=0; i< str.length() - 1;i++,count++) {
        if (str.charAt(i) != str.charAt(i + 1)) {
            result.append(str.charAt(i)).append(count);
            count = 0;
        }
    }

    result.append(str.charAt(i)).append(count);
    return result.toString();
}