package demel2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test4 {
    public static void main(String[] args)
    {
       List<String> list=new ArrayList<>();
       list.add("1");
       list.add("2");
       list.add("3");
        System.out.println(list);
        Iterator<String> it=list.iterator();
//        while(it.hasNext())
//        {
//            String str=it.next();
//            System.out.println(str);
//            if(str.equals("2"))
//            {
//                //list.add("56");//不对,需用listIterator.add
//            }
//        }
        //System.out.println(list);
        for(String str:list)
        {
            if(str.equals("2"))
                list.add("3");
        }
       // list.remove("1");
        System.out.println(list);
    }
}
