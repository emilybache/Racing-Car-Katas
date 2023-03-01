package tddmicroexercises.telemetrysystem;

public class CustomException {

    public static void checkException(String string) {
        if (string == null || "".equals(string))
        {
            throw new IllegalArgumentException();
        }
    }
}
