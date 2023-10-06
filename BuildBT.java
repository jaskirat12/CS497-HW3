import java.util.HashMap;

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

public class BuildBT {
	
	public static NT root;
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int p = 0;
	
	public static NT buildBTR(int[] io, int[] po, int a, int b) {
		if(a>b)
			return null;
		int c = po[p];
		p++;
		NT n = new NT(c);
		if(a==b)
			return n;
		int i = map.get(c);
		n.left = buildBTR(io, po, a, i-1);
		n.right = buildBTR(io, po, i+1, b);
		return n;
	}
	
	public static NT buildBT(int[] io, int[] po, int l) {
		for(int i=0; i<l; i++)
			map.put(io[i], i);
		return buildBTR(io, po, 0, l-1);
	}
	
	static void printT(NT root) {
		if(root == null) {
			return;
		}
		printT(root.left);
		System.out.print(root.data + ", ");
		printT(root.right);
	}

	public static void main(String[] args) {
		int[] po = {3, 9, 20, 15, 7};
		int[] io = {9, 3, 15, 20, 7};
		int l = po.length;
		BuildBT.root = buildBT(io, po, l);
		System.out.print("[");
		printT(root);
		System.out.print("]\n");
	}

}
