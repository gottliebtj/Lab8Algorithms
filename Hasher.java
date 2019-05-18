import java.math.*;
import java.security.*;
public class Hasher {
    public static String hash(String input)
    {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                               + " for incorrect algorithm: " + e);

            return null;
        }

    }
  }

  //Adapted from https://www.geeksforgeeks.org/sha-256-hash-in-java/
