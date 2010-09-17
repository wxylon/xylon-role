package org.role.util;

import java.util.Iterator;
import java.util.List;

public class TestList {
	/**    
     * List集合性能测试类    
     * Usage: java com.test.collection.TestList ListClassName MAX_TIMES    
     * 例：java com.test.collection.TestList LinkedList 100000    
     */
	private static int MAX = 100000;
    public static void main(String[] args) {      
              
        if (args != null && args.length == 2) {      
            testList(args[0], Integer.parseInt(args[1]));      
        } else {      
            testList("LinkedList", MAX);      
            testList("ArrayList", MAX);
            testList("Vector", MAX);
            testList("Stack", MAX);
        }      
    }      
          
    private static void testList(String listName, int maxElements) {      
        List list = null;      
        try {      
            list = (List) Class.forName("java.util." + listName).newInstance();      
        } catch (Exception e) {      
            e.printStackTrace();      
        }      
              
        addElement2List(list, maxElements);      
        deleteElement2List(list);      
        insertElement2List(list, maxElements);      
        getListElementByIndex(list);      
        getListElementByIterator(list);
        long start = System.currentTimeMillis();      
        list.clear();
        printTime(list, System.currentTimeMillis()-start, " [clear] ");     
        list = null;
        System.gc();
    }      
          
    //add elements to List      
    private static void addElement2List(List list, int maxElements) {      
        long start = System.currentTimeMillis();      
      
        for (int i = 1; i < maxElements; i++) {      
            list.add(new Integer(i));      
        }      
      
        long end = System.currentTimeMillis();      
              
              
        printTime(list, end-start, " [add] ");      
    }      
          
          
    //remove elements from List      
    private static void deleteElement2List(List list) {      
        long start = System.currentTimeMillis();      
      
        while (!list.isEmpty()) {      
            list.remove(0);      
        }      
      
        long end = System.currentTimeMillis();      
              
              
        printTime(list, end-start, " [delete] ");      
    }      
          
          
    //insert elements to List      
    private static void insertElement2List(List list, int maxElements) {      
        long start = System.currentTimeMillis();      
      
        for (int i = 1; i < maxElements; i++) {      
            list.add(0, new Integer(i));      
        }      
      
        long end = System.currentTimeMillis();      
              
              
        printTime(list, end-start, " [insert] ");      
    }      
          
    private static void getListElementByIndex(List list) {      
        long start = System.currentTimeMillis();      
      
        for (int i = 1; i < list.size(); i++) {      
            Integer ele = (Integer)list.get(i);      
        }      
      
        long end = System.currentTimeMillis();      
              
              
        printTime(list, end-start, " [index] ");      
    }      
          
    private static void getListElementByIterator(List list) {      
        long start = System.currentTimeMillis();      
      
        Iterator ite = list.iterator();      
        while (ite.hasNext()) {      
            Integer ele = (Integer)ite.next();      
        }      
      
        long end = System.currentTimeMillis();      
              
              
        printTime(list, end-start, " [iterator] ");      
    }      
          
    private static void printTime(List list, long time, String operation) {      
        String out = list.getClass().getSimpleName();      
              
        out += " " + operation + ": " + time;      
              
        System.out.println(out);      
    }      
}
