package demel2;

import java.util.ArrayList;
import java.util.List;

//import java.util.Date;
public class zqp {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        if(list.contains(2))
            list.add(2,4);
        System.out.println(list);
      StringBuilder sb=new StringBuilder("abc");
      sb.append("def");
      sb.insert(3,"123");
      sb.delete(3,6);
      System.out.println(sb);

    }
}
