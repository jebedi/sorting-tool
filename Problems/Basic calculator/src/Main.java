class Problem {

    public static void main(String[] args) {
        String operation = args[0];
        int first = Integer.parseInt(args[1]);
        int second = Integer.parseInt(args[2]);

        switch (operation) {
            case "+":
                System.out.println(first + second);
                break;
            case "-":
                System.out.println(first - second);
                break;
            case "*":
                System.out.println(first * second);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}