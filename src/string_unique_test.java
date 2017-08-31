/**
 * Created by jiayicheng on 17/6/12.
 */
public class string_unique_test {
    public static void main(String[] args) {
        //目的：检测一个序列里是否有同样的字母，要求不用别的数据结构
        //时间复杂度：笨方法TC为 N＊N，SC为1，最简单的方法理应为N

        String str = "abcda";
        if(isUniqueChars(str)==false);
        System.out.print("false");


    }


    static boolean isUniqueChars(String str) {     //1. 分清楚到底是Unicode还是ASCII码
        if (str.length() > 128) {                  //2. 如果是ASCII码，那么一定会重合的
            return false;                          //TC：N    SC：1
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);               //返回特定位置的ASCII码
            if (char_set[val]) {                   //先看这个位置有没有字母，有就玩完
                return false;
            }
            char_set[val] = true;                  //没有那就告诉你你没事
        }
        return true;
    }


    static boolean inUniqueChars(String str) {    //如果不用别的数据结构，那么可以排序找临近相同的字母，TC为N＊LOGN
        int checker = 0;                          //但是排序需要多余的 Extra space
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);

        }
        return false;
    }
}





