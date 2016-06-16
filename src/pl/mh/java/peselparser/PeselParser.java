package pl.mh.java.peselparser;

public class PeselParser {
    private boolean valid = false;
    private byte[] pesel = new byte[11];

    public PeselParser(String input) {
        if (input.length() != 11) {
            valid = false;
            System.out.println("Wrong length, PESEL must be 11 characters long.");
        }
        else {
            for (int i = 0; i < 11; i++) {
                pesel[i] = Byte.parseByte(input.substring(i, i+1));
            }
            for (int x : pesel) {
                System.out.print(x);

            }
            //System.out.println(pesel[]);
            System.out.print(checkSum(pesel));
            System.out.print(valid);
        }
    }


    public boolean checkSum(byte[] input){

        int sum = 1*input[0] + 3*input[1] + 7*input[2] + 9*input[3] + 1*input[4] + 3*input[5] + 7*input[6] + 9*input[7] + 1*input[8] + 3*input[9];

        if ((10 - (sum % 10)) % 10 == input[10] ) {
            System.out.println("PESEL number status - correct");
            return valid = true;
        }
        else {
            System.out.println("PESEL number status - wrong, check spelling");
            return valid = false;
        }
    }


}
