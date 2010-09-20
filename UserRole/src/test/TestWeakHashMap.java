package test;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class TestWeakHashMap {
//	public static void main(String args[]) {
//		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
//
//		for (int i = 0; i < 1000; i++) {
//			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
//			d.put(new byte[1000][1000], new byte[1000][1000]);
//			maps.add(d);
//			System.gc();
//			System.err.println(i);
//		}	
//	}
	
//	public static void main(String[] args) throws Exception {   
//		  
//        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();   
//  
//        for (int i = 0; i < 1000; i++) {   
//            WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();   
//            d.put(new byte[1000][1000], new byte[1000][1000]);   
//            maps.add(d);   
//            System.gc();   
//            System.err.println(i);   
//  
//            for (int j = 0; j < i; j++) {   
//                System.err.println(j+  " size" + maps.get(j).size());   
//            }   
//        }   
//    }  
	
//	public static void main(String[] args) throws Exception {     
//        
//        List<WeakHashMap<Object, byte[][]>> maps = new ArrayList<WeakHashMap<Object, byte[][]>>();     
//        Object o = new Object();   
//        for (int i = 0; i < 1000; i++) {     
//            WeakHashMap<Object, byte[][]> d = new WeakHashMap<Object, byte[][]>();     
//            d.put(o, new byte[1000][1000]);     
//            maps.add(d);     
//            System.gc();     
//            System.err.println(i);     
//         
//            for (int j = 0; j < i; j++) {     
//                System.err.println(j+  " size  " + maps.get(j).size());     
//            }     
//        }     
//         
//    }  
	
	public static void main(String[] args) throws Exception {     
		WeakHashMap<Object,String> d = new WeakHashMap<Object, String>();
		Object I = new Object();
//        for (int i = 0; i < 100000; i++) {     
		d.put(I, String.valueOf(I)); 
		d.put(new Object(), "1"); 
        System.out.println("--->"+d.size());     
//        }
        Thread.currentThread().sleep(5000);
        System.out.println(d.get(I));
        System.out.println(new Object());
        System.out.println(d.size()); 
    }  
}
