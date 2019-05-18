class Solution {
    
    // Naive version
    // 17ms, 74.19%
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        
        Map<String, Integer> count = new HashMap<>();
        
        for (String email : emails) {
            int atIdx = email.indexOf("@");
            int plusIdx = email.indexOf("+");
            
            String localName = email.substring(0, plusIdx == -1 ? atIdx : plusIdx);
            // Note the difference between replace() and replaceAll()
            localName = localName.replace(".", "");
            String hostName = email.substring(atIdx+1, email.length());
            String receiver = localName+"@"+hostName;
            count.put(receiver, count.getOrDefault(receiver, 0)+1);
        }
        return count.size();
        
    }
    
    /*
    public int numUniqueEmails(String[] emails) {
        // used to save simplified email address, cost O(n) space.
        Set<String> normalized = new HashSet<>(); 
        for (String email : emails) {
            String[] parts = email.split("@"); // split into local and domain parts.
            String[] local = parts[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.        
        }
        return normalized.size();
    }
    */
}