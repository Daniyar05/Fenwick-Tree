import java.util.Scanner;

public class FenwickTree {
    long[] tree;
    int CAPASITY;
    public FenwickTree(int CAPASITY) {
        tree = new long[CAPASITY+1];
        this.CAPASITY = CAPASITY+1;
    }
    
    public void update(int index, long value){
        if (index == 0) {
            tree[0] = value;
            return;
        }
        for (int i = index; i < CAPASITY; i += F(i)) {            
            tree[i] += value;
        }
    }  

    public long get(int index){
        long res = 0;
        for (int i = index; i > 0; i -= F(i)) {
            res += tree[i];            
        }
        return res;
    }
    public long F(long x){
        return (x & -(x));
    }
    private long sum(int index){
        long res = 0;
        for (int i = index; i > 0; i -= F(i))
            res += tree[i];
        return res;
    }

    public long sum(int l, int r){
        return sum(r) - sum(l-1);
    }

    public void add(int index, long a){
        update(index, a);
    }  
    public void printTree(){
        for (int i = 0; i < CAPASITY; i++) {
            System.out.print(tree[i]+" ");
        }System.out.println();
    }

    public static void main(String[] args) {
        // FenwickTree tree = new FenwickTree(2);
        // tree.add(1, 5);
        // tree.add(2, 6);
        // System.out.prlongln(tree.sum(2, 2));
        // tree.prlongTree();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x,l,r;
        long y;
        FenwickTree tree = new FenwickTree(n);
        for (long i = 0; i < m; i++) {
            if (scanner.next().equals("add")){
                x = scanner.nextInt();
                y = scanner.nextLong();
                tree.add(x, y);
            }else{
                l = scanner.nextInt();
                r = scanner.nextInt();
                System.out.println(tree.sum(l, r));
            }
        }
        scanner.close();
        
    }
}