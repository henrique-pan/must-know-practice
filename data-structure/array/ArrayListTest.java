import java.util.*;

class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<> ();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(null);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);

		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}

		//list.get(10); ERROR!

		list = new ArrayList<> ();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		
		int index = 4;
		System.out.println("Before Remove: " + list.get(index));
		list.remove(index);
		System.out.println("After Remove: " + list.get(index));

		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
	}
}