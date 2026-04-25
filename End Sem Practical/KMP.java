import java.util.*;
public class KMP {
    static int[] buildLPS(String pattern) {
        int m=pattern.length();
        int[] lps=new int[m];
        int len=0;
        int i=1;
        while (i<m){
            if (pattern.charAt(i)==pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    static List<Integer> kmpSearchAll(String text, String pattern) {
        int n=text.length();
        int m=pattern.length();
        int[] lps=buildLPS(pattern);
        List<Integer> result=new ArrayList<>();
        int i=0,j=0;
        while (i<n) {
            if (text.charAt(i)==pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j==m) {
                result.add(i-j);   
                j = lps[j-1];      
            } 
            else if(i<n&&text.charAt(i)!=pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String S="abcab";
        String P="ab";
        List<Integer> ans=kmpSearchAll(S, P);
        System.out.println(ans);  
    }
}