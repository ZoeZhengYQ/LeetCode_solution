class Solution {
    // recursively check last three digits
    private String[] UNDER_20 = {"", "One", "Two", "Three", "Four", "Five", 
                             "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", 
                             "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
                             "Eighteen", "Nineteen"};
    private String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", 
                                 "Seventy", "Eighty", "Ninety"};
    private String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String words = "";
        int rest = 0;
        int i = 0;
        while (num > 0) {
            rest = num % 1000;
            num /= 1000;
            if (rest != 0) {
                // If dont check
                // 1,000,000 would be one million thousand
                words = checkThreeDigit(rest) + " " + THOUSANDS[i] + " " + words;   
            }
            i++;
        }
        return words.trim().replaceAll(" +", " ");
    }
    
    private String checkThreeDigit(int num) {
        if (num < 20) { return UNDER_20[num]; }
        if (num < 100) {
            return TENS[num/10] + " " + UNDER_20[num%10];
        }
        return UNDER_20[num/100] + " Hundred " + checkThreeDigit(num%100);
    }
}