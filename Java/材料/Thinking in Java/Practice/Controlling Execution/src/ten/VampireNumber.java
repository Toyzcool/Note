package ten;

import java.util.*;

public class VampireNumber {
    static List<Integer> VampireJudge(){
        List<Integer> VampireArray = new ArrayList<Integer>();
        int point = 0;
        for (int i = 10 ; i < 100 ; i++ ){
            for (int k = 10 ; k < 100 ; k++){
                int sum = i * k;
                // 判断是否为四位数
                if ( sum < 1000 || sum > 9999 ){
                    continue;
                }
                point++;
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
        System.out.println("程序运行次数： "+point+"次");
        return VampireArrayAter;
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        List<Integer> VampireArrayAter = VampireJudge();
        for (Integer x : VampireArrayAter){
            System.out.println(x);
        }
        // 测试代码执行时间
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");
    }
}
