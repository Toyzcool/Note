package ten;

import java.util.*;

public class VampireNumber {
    //
    static List<Integer> VampireJudge(){
        List<Integer> VampireArray = new ArrayList<Integer>();
        outer: for (int i = 10 ; i < 100 ; i++ ){
            for (int k = 10 ; k < 100 ; k++){
                int sum = i * k;
                // 判断是否为四位数
                if ( sum/1000 < 1 || sum/1000 >= 10 ){
                    continue;
                }
                // 判断是否以两个零结尾
                if (sum %100 == 0 ){
                    continue;
                }
                // 判断是否为吸血鬼数字
                    // 将数字转换成字符
                    String iString = String.valueOf(i);
                    String kString = String.valueOf(k);
                    String ikString = iString+kString;
                    // 将字符赋值给数组，同时赋值给List类型
                    char[] ikCharArray = ikString.toCharArray();
                    List<Character> ikList = new ArrayList<Character>();
                    for (char x : ikCharArray){
                        ikList.add(x);
                    }
                    String sumString = String.valueOf(sum);
                    char[] sumCharList = sumString.toCharArray();
                    List<Character> sumList = new ArrayList<Character>();
                    for (char x : sumCharList){
                        sumList.add(x);
                    }
                    Collections.sort(ikList);
                    Collections.sort(sumList);
                    // 判断是否为吸血鬼数字
                    if (ikList.equals(sumList)){
                        VampireArray.add(sum);
                    }
            }
        }
        // 去重
        Set<Integer> VampireArrayHashSet = new HashSet<Integer>(VampireArray);
        List<Integer> VampireArrayAter = new ArrayList<Integer>(VampireArrayHashSet);
        Collections.sort(VampireArrayAter);
        return VampireArrayAter;
    }
    public static void main(String[] args) {
        List<Integer> VampireArrayAter = VampireJudge();
        for (Integer x : VampireArrayAter){
            System.out.println(x);
        }
    }
}
