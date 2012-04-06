package test.hash;

import java.util.ArrayList;

/**
* 此方法的作用是证明 java.lang.Object的hashcode 不是代表 对象所在内存地址。
* 我产生了10000个对象，这10000个对象在内存中是不同的地址，但是实际上这10000个对象
* 的hashcode的是完全可能相同的
*/
public class HashCodeMeaning {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        int numberExist=0;
        
        System.out.println("______________证明hashcode的值不是内存地址________________");
        //证明hashcode的值不是内存地址
        for (int i = 0; i < 10000; i++) {
            Object obj=new Object();//obj是内存地址
            if (list.contains(obj.hashCode())) {//获得对象的hashCode
                System.out.println(obj.hashCode() +" exists in the list. "+ i);
                numberExist++;
            }
            else {
                list.add(obj.hashCode());
            }
        }
        
        System.out.println("repetition number:"+numberExist);//和重复的hashCode，说明它不是内存地址
        System.out.println("list size:"+list.size());
        
        
        System.out.println("____________证明内存地址是不同的_______________");
        //证明内存地址是不同的。
        numberExist=0;
        list.clear();
        for (int i = 0; i < 10000; i++) {
            Object obj=new Object();//获得的是对象的内存地址
            if (list.contains(obj)) {//直接加入内存地址
                System.out.println(obj +" exists in the list. "+ i);
                numberExist++;
            }
            else {
                list.add(obj);
            }
        }
        
        //内存地址没重复
        System.out.println("repetition number:"+numberExist);
        System.out.println("list size:"+list.size());
    }
}