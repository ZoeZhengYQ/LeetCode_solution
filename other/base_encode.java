// 美国知乎第二题
// 给一个n，有对应的规律，根据规律返回n对应的binary，类似于binary
// 当base是2的时候
// 0:  ""
// 1: 0
// 2: 1
// 3: 00
// 4: 01
// 5: 10
// 6: 11
// 7: 000
// 8: 001
// ....

// 对于base 3
// 0: ""
// 1: 0
// 2: 1
// 3: 2
// 4: 00
// 5: 01
// 6: 02
// 7: 10
// 8: 11
// 9: 12
// 10: 20
// 11: 21
// 12: 22
// 13: 000
// .....

import java.util.*;
public class Solution{
     public static void main(String []args){
        System.out.println(encode(0, 10));
     }
     
     // Edge cases: base == 0?
     public static String encode(int base, int target) {
         if (target == 0) return "";
         StringBuilder sb = new StringBuilder();
         // base == 0
         if (base == 0) {
             for (int i = 0; i < target; ++i) {
                 sb.append(0);
             }
             return sb.toString();
         }
         
         int digits = 0;
         int sub = 1;
         int remain = target;
         // count digits with substraction
         while (remain >= sub) {
             remain -= sub;
             digits++;
             sub *= base;
         }
         sub /= base;
         
         // address the remain part
         for (int i = 0; i < digits; ++i) {
             int divide = remain / sub;
             if (divide > 0) {
                 sb.append(divide);
                 remain %= sub;
             } else {
                sb.append(0);
                
             }
             sub /= base;
         }
         return sb.toString();
     }
}