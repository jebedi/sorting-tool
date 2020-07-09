class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        double number = 0;
        try {
            number = Double.parseDouble(input);
        } catch (Exception ignored) {
        }
        return number;
    }
}