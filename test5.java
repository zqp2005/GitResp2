package demel2;

import java.util.TreeSet;

public class test5 {
    public static void main(String[] args)
    {
Student s=new Student("张三", 18, 90);
Student  s1=new Student("李四", 19, 90);
        System.out.println(s);
        System.out.println(s.getAge()-s1.getAge());
        //TreeSet<Integer> set=new TreeSet<>()(( Integer o1,Integer o2)->Integer.compare(o1,o2));
        //TreeSet<Integer> set1 = new TreeSet<>((Integer o1, Integer o2) ->  Integer.compare(o2, o1));
//        TreeSet<Integer> set1 = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o2, o1);
//            }
//        });
        TreeSet<Student> set=new TreeSet<>((o1, o2)->Integer.compare(o1.getAge(),o2.getAge()));
        set.add(s);
        set.add(s1);
        System.out.println(set);
    }
}
