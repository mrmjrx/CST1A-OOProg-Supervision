package uk.ac.cam.mr2083.sect9;

public class RetValTest {
    public static String sEmail = "";

    public static String extractCamEmail(String sentence) {
        if (sentence == null || sentence.isEmpty()) throw new EmptyString("sentence (\"" + sentence + "\") is empty");

        for (String token : sentence.split(" ")) {
            if (token.endsWith("@cam.ac.uk")) {
                return token;
            }

        }
        throw new InvalidFormatException("No cam email found in sentence");
    }

    public static void main(String[] args) {
        try {
            String camEmail = RetValTest.extractCamEmail("My email is rkh423@cam.ac.uk") ;
            System.out.println("Success: " + camEmail);
        } catch (InvalidFormatException e) {
            System.out.println("No @cam address in supplied string");
        } catch (EmptyString e) {
            System.out.println("Supplied string empty");
        }
    }
}
