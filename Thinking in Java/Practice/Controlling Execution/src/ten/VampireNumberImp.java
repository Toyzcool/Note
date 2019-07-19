package ten;

import java.util.*;

public class VampireNumberImp {
    static int VampireJudgeImp(){
        List<Integer> VampireArray = new ArrayList<Integer>();
        List<Character> ikList = new ArrayList<Character>();
        List<Character> sumList = new ArrayList<Character>();
        int point = 0;
        for (int i = 11 ; i < 100 ; i++ ){
            for (int k = i ; k < 100 ; k++){

                int sum = i * k;
                // 判断是否为四位数,判断是否为两个零结尾
                if ( sum < 1000 || sum > 9999 || sum % 100 == 0 || VampireArray.contains(sum)){
                    continue;
                }
                point++;
                // 判断是否为吸血鬼数字
                    // 将数字添加进list
                    ikList.add((char) (i / 10));
                    ikList.add((char) (i % 10));
                    ikList.add((char) (k / 10));
                    ikList.add((char) (k % 10));
                    sumList.add((char) (sum / 1000));
                    sumList.add((char) (sum % 1000 / 100));
                    sumList.add((char) (sum % 1000 % 100 / 10));
                    sumList.add((char) (sum % 10));
                    // 数字排序
                    Collections.sort(ikList);
                    Collections.sort(sumList);
                    // 判断是否为吸血鬼数字
                    if (ikList.equals(sumList)){
                        VampireArray.add(sum);
                        System.out.println(sum);
                    }
                ikList.clear();
                sumList.clear();
            }
        }
        return point;
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        int point = VampireJudgeImp();
        // 测试代码执行时间
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");
        System.out.println("程序运行次数： "+point+"次");
    }
}
