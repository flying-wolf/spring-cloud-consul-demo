package com.meacial;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {


        Stu stu1 = new Stu();
        stu1.setAge(1);
        stu1.setName("meacial");
        stu1.setMan(false);


        Stu stu2 = new Stu();
        stu2.setAge(1);
        stu2.setName("meacial");
        stu2.setMan(true);

        System.out.println(stu1.equals(stu2));


        Set<Stu> stus = new HashSet<>();

        stus.add(stu1);
        stus.add(stu2);


        System.out.println(stus);
    }

}
