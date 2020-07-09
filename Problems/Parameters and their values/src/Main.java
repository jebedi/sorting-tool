class Problem {

    public static void main(String[] args) {
        int length = args.length;

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                System.out.print(args[i] + "=");
            } else {
                System.out.println(args[i]);
            }
        }
    }
}