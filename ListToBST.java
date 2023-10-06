import java.util.ArrayList;

class NL {
	NL next;
	int data;
	
	NL (int data) {
		this.next = null;
		this.data = data;
	}
}

class NT {
	NT left;
	NT right;
	int data;
	
	NT(int data) {
		this.left = null;
		this.right = null;
		this.data = data;
	}
}
public class ListToBST {
	
	static NT listToBSTR(ArrayList<Integer> v, int a, int b) {
		if(a > b) 
			return null;
		int m = a+(b-a)/2;
		if((b-a)%2 == 1)
			m++;
		NT root = new NT(v.get(m));
		root.right = listToBSTR(v, m+1, b);
		root.left = listToBSTR(v, a, m-1);
		return root;
	}
	
	static NT listToBST(NL head) {
		ArrayList<Integer> v = new ArrayList<Integer>();
		NL t = head;
		while(t!=null) {
			v.add(t.data);
			t = t.next;
		}
		return listToBSTR(v, 0, v.size()-1);
	}
	
	static void printT(NT root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + ", ");
		printT(root.left);
		printT(root.right);
	}

	public static void main(String[] args) {
		NL head = new NL(-10);
		head.next = new NL(-3);
		head.next.next = new NL(0);
		head.next.next.next = new NL(5);
		head.next.next.next.next = new NL(9);
		System.out.print("[");
		printT(listToBST(head));
		System.out.print("]\n");
		head = null;
		System.out.print("[");
		printT(listToBST(head));
		System.out.print("]\n");
	}

}
