class Solution {
    // Override Comparator
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int idxA = a.indexOf(' ');
                int idxB = b.indexOf(' ');
                char chA = a.charAt(idxA + 1);
                char chB = b.charAt(idxB + 1);
                
                if (chA >= '0' && chA <= '9') {
                    if (chB >= '0' && chB <= '9') return 0;
                    return 1;
                }
                
                if (chB >= '0' && chB <= '9') return -1;
                
                String subA = a.substring(idxA + 1);
                String subB = b.substring(idxB + 1);
                int dataComp = subA.compareTo(subB);
                return dataComp != 0 ? dataComp : a.substring(0, idxA).compareTo(b.substring(0, idxB));
            }
        };
        
        Arrays.sort(logs, comp);
        return logs;
    }
}