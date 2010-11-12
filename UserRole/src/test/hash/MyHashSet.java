package test.hash;

class Node {// 节点数据结构
	private Object value;// 节点的值
	private Node next;// 链表中指向下一结点的引用

	/* 提供了常见的操作 */
	public Node(Object value) {
		this.value = value;
	};

	public Object getValue() {
		return value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

public class MyHashSet {// Hash数据结构
	private Node[] array;// 存储数据链表的数组
	private int size = 0;// 表示集合中存放的对象的数目

	public MyHashSet(int length) {
		array = new Node[length];// 创建数组
	}

	public int size() {
		return size;
	}

	private static int hash(Object o) { // 根据对象的哈希码得到一个优化的哈希码，
		// 算法参照java.util.HashMap的hash()方法
		int h = o.hashCode();
		h += ~(h << 9);
		h ^= (h >>> 14);
		h += (h << 4);
		h ^= (h >>> 10);
		return h;
	}

	private int indexFor(int hashCode) { // 根据Hash码得到其索引位置
		// 算法参照java.util.HashMap的indexFor()方法
		return hashCode & (array.length - 1);
	}

	public void add(Object value) {// 把对象加入集合，不允许加入重复的元素
		int index = indexFor(hash(value));// 先根据value得到index
		System.out.println("index:" + index + " value:" + value);
		Node newNode = new Node(value);// 由value创建一个新节点newNode
		Node node = array[index];// 由index得到一个节点node
		if (node == null) {// 若这个由index得到的节点是空，则将新节点放入其中
			array[index] = newNode;
			size++;
		} else {// 若不为空则遍历这个点上的链表（下一个节点要等于空或者该节点不等于新节点的值--不允许重复）
			Node nextNode;
			while (!node.getValue().equals(value)
					&& (nextNode = node.getNext()) != null) {
				node = nextNode;
			}
			if (!node.getValue().equals(value)) {// 若值不相等则加入新节点
				node.setNext(newNode);
				size++;
			}
		}
	}

	public boolean contains(Object value) {
		int index = indexFor(hash(value));
		Node node = array[index];
		while (node != null && !node.getValue().equals(value)) {
			node = node.getNext();
		}// 横向查找
		if (node != null && node.getValue().equals(value)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(Object value) {
		int index = indexFor(hash(value));
		Node node = array[index];
		if (node != null && node.getValue().equals(value)) {// 若是第一个节点就是要remove的
			array[index] = node.getNext();
			size--;
			return true;
		}
		Node lastNode = null;
		while (node != null && !node.getValue().equals(value)) {// 若不是第一个节点就横向查找
			lastNode = node;// 记录上一个节点
			node = node.getNext();
		}
		if (node != null && node.getValue().equals(value)) {
			lastNode.setNext(node.getNext());
			size--;
			return true;
		} else {
			return false;
		}
	}

	public Object[] getAll() {
		Object[] values = new Object[size];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			Node node = array[i];
			while (node != null) {
				values[index++] = node.getValue();
				node = node.getNext();
			}
		}
		return values;
	}

	public static void main(String[] args) {
		MyHashSet set = new MyHashSet(6);
		Object[] values = { "Tom", "Mike", "Mike", "Jack", "Mary", "Linda",
				"Rose", "Jone" };
		for (int i = 0; i < values.length; i++) {
			set.add(values[i]);
		}
		set.remove("Mary");
		System.out.println("size=" + set.size());
		values = set.getAll();
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
		System.out.println(set.contains("Jack"));
		System.out.println(set.contains("Linda"));
		System.out.println(set.contains("Jane"));
	}
}
