import java.util.Scanner;


public class HexAndBinaryDecoder {

    public static long hexStringDecode(String hex)
    {
        //converts a hex string to a character and returns the hex to decimal value
        char[] cString = hex.toCharArray();
        char hexChar;
        long dec = 0;
        double decChar;
        for (int ii = 0; ii < cString.length; ii++)
        {

            hexChar = cString[ii];
            double hexLength = hex.length();
            //gets the decimal value of a hex character and multiplies it by 16^(L-ii-1) based off of its position
            decChar = hexCharDecode(hexChar) * Math.pow(16,hexLength - ii - 1);
            dec += decChar;
        }
        return dec;
    }

    public static short hexCharDecode(char hexChar) {
        //converts a hex character to a decimal number
        short decChar;
            //receives a Hex character as an input and converts it to its decimal equivalent
            if (hexChar == '1')
                decChar = 1;
            else if (hexChar == '2')
                decChar = 2;
            else if (hexChar == '3')
                decChar = 3;
            else if (hexChar == '4')
                decChar = 4;
            else if (hexChar == '5')
                decChar = 5;
            else if (hexChar == '6')
                decChar = 6;
            else if (hexChar == '7')
                decChar = 7;
            else if (hexChar == '8')
                decChar = 8;
            else if (hexChar == '9')
                decChar = 9;
            else if (hexChar == 'A' || hexChar == 'a')
                decChar = 10;
            else if (hexChar == 'B' || hexChar == 'b')
                decChar = 11;
            else if (hexChar == 'C' || hexChar == 'c')
                decChar = 12;
            else if (hexChar == 'D' || hexChar == 'd')
                decChar = 13;
            else if (hexChar == 'E' || hexChar == 'e')
                decChar = 14;
            else if (hexChar == 'F' || hexChar == 'f')
                decChar = 15;
            else
                decChar = 0;

            return decChar;
    }


    public static long binaryStringDecode(String bin)
    {
        //converting a string of binary numbers into a decimal
        char[] charString = bin.toCharArray();
        char binChar;
        int dec = 0;
        double decChar;
        for (int ii = 0; ii < charString.length; ii++)
        {

            binChar = charString[ii];
            double binLength = bin.length();
            if(binChar == '1') {
               decChar = Math.pow(2, binLength - ii - 1);
            }
            else
                decChar = 0;
            dec += decChar;
        }
        return dec;
    }

    public static String binaryToHex(String bin)
    {
        //converting a binary string to a hex string
        char[] charString = bin.toCharArray();
        char[] hexChar = new char[bin.length()];
        String hexString;
        long dec = binaryStringDecode(bin);
        int power = 0;
        double placeHolder = Math.pow(16, power + 1);

        while (dec > 0)
        {
            int counter = 0;
            while(placeHolder < dec )
            {
                power++;
                placeHolder = Math.pow(16, power + 1);
            }

            int coeff = 0;
            while((((coeff + 1) * placeHolder) / 16) < dec )
            {
                coeff++;
            }
            //convert the coeff into a character then add the character to a string

            if (coeff == 1)
                hexChar[counter] = '1';
            else if (coeff == 2)
                hexChar[counter] = '2';
            else if (coeff == 3)
                hexChar[counter] = '3';
            else if (coeff == 4)
                hexChar[counter] = '4';
            else if (coeff == 5)
                hexChar[counter] = '5';
            else if (coeff == 6)
                hexChar[counter] = '6';
            else if (coeff == 7)
                hexChar[counter] = '7';
            else if (coeff == 8)
                hexChar[counter] = '8';
            else if (coeff == 9)
                hexChar[counter] = '9';
            else if (coeff == 10)
                hexChar[counter] = 'A';
            else if (coeff == 11)
                hexChar[counter] = 'B';
            else if (coeff == 12)
                hexChar[counter] = 'C';
            else if (coeff == 13)
                hexChar[counter] = 'D';
            else if (coeff == 14)
                hexChar[counter] = 'E';
            else if (coeff == 15)
                hexChar[counter] = 'F';
            else
                hexChar[counter] = 0;

            dec -= (coeff * placeHolder) / 16;
            counter++;

        }
            hexString = new String(hexChar);
            return hexString;




    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        while (true) {

            System.out.println("Choose an option: ");
            System.out.println("1. Decode a hex string.");
            System.out.println("2. Decode a binary string.");
            System.out.println("3. Convert binary to hex.");
            System.out.println("4. Quit.");

            int input = scnr.nextInt();


            if(input == 4) {
                System.out.println("Quitting program.");
                return;
            }
            else if (input == 1)
            {
                System.out.println("Please enter the hex string: ");
              String string = scnr.next();
              long dec = hexStringDecode(string);
                System.out.println("Result: " + dec);
            }
            else if (input == 2)
            {
                System.out.println("Please enter the binary string: ");
                String string = scnr.next();
                long dec = binaryStringDecode(string);
                System.out.println("Result: " + dec);
            }
            else if (input == 3)
            {
                System.out.println("Please enter the binary string: ");
                String string = scnr.next();
                String hex = binaryToHex(string);
                System.out.println("Result: " + hex);
            }
        }
    }
}