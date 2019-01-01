class Solution {
public:
    // brief solution
    // range 1 to 3999
    
    string intToRoman(int num) {
        string THOUS[] = {"", "M", "MM", "MMM"};
        string HUNDS[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        string TENS[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        string ONES[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return THOUS[num / 1000] + HUNDS[(num % 1000) / 100] + TENS[(num % 100) / 10] + ONES[(num % 10)];
    }
    
    // naive solution
    /*
    string intToRoman(int num) {
        std::string rom;
        while (num >= 1000) {
            rom += "M";
            num -= 1000;
        }
        
        if (num >= 900) {
            rom += "CM";
            num -= 900;
        }
        else if (num >= 500) {
            rom += "D";
            num -= 500;
        }
        else if (num >= 400) {
            rom += "CD";
            num -= 400;
        }
        
        while (num >= 100) {
            rom += "C";
            num -= 100;
        }
        
        if (num >= 90) {
            rom += "XC";
            num -= 90;
        }
        else if (num >= 50) {
            rom += "L";
            num -= 50;
        }
        else if (num >= 40) {
            rom += "XL";
            num -= 40;
        }
        
        while (num >= 10) {
            rom += "X";
            num -= 10;
        }
        
        if (num >= 9) {
            rom += "IX";
            num -= 9;
        }
        else if (num >= 5) {
            rom += "V";
            num -= 5;
        }
        else if (num >= 4) {
            rom += "IV";
            num -= 4;
        }
        
        while (num >= 1) {
            rom += "I";
            num -= 1;
        }
        
        return rom;
    }
    */
};
