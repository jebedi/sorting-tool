class Problem {

    public static void main(String[] args) {
        String operation = args[0];
        int result = 0;
        switch (operation) {

            case "MAX":
                result = Integer.MIN_VALUE;
                for (int i = 1; i < args.length; i++) {
                    int testedNumber = Integer.parseInt(args[i]);
                    if (testedNumber > result) {
                        result = testedNumber;
                    }
                }
                break;
            case "MIN":
                result = Integer.MAX_VALUE;
                for (int i = 1; i < args.length; i++) {
                    int testedNumber = Integer.parseInt(args[i]);
                    if (testedNumber < result) {
                        result = testedNumber;
                    }
                }
                break;
            case "SUM":
                result = 0;
                for (int i = 1; i < args.length; i++) {
                    result += Integer.parseInt(args[i]);
                }
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }

        System.out.println(result);
    }
}