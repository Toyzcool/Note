package Test.One;

import static util.SimPrint.*;

public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        print("sb:"+sb);
        print("sb地址:"+sb.hashCode());
        print("------新增后------");
        sb.append("degf");
        print("sb:"+sb);
        print("sb地址:"+sb.hashCode());
    }
}
