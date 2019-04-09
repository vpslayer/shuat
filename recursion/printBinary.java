public class printBinary {
    public static void print(int a) {
        // base case: a=0, nothing to display
        if(a > 0) {
            print(a/2);
            System.out.print(a%2);
        }
    }
        public static void main(String[] args) {
            print(16);
            System.out.println();
        }
    }