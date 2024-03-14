package org.efeitos;

public class Efeitos {
    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            args = new String[] { "jose", "mourinho" };
        }

        efeito1(args);

        efeito2(args);

        efeito3(args);

        efeito4(args);

        efeito5(args);

        efeito6(args);
    }

    private static void efeito1(String[] strings) {
        System.out.println("Efeito 1:");
        int j = 0;
        for (String str : strings) {
            for (int i = 0; i < str.length(); i++) {
                for (int spacesCount = 0; spacesCount < j; spacesCount++) {
                    System.out.print(" ");
                }
                System.out.println(str.toUpperCase().charAt(i));
                j++;
            }
            System.out.println();
            j++;
        }
    }

    private static void efeito2(String[] strings) {
        System.out.println("Efeito 2:");
        int j = 0;
        for (int k = strings.length - 1; k >= 0; k--) {
            String str = strings[k];
            for (int i = str.length() - 1; i >= 0; i--) {
                for (int spacesCount = 0; spacesCount < j; spacesCount++) {
                    System.out.print(" ");
                }
                System.out.println(str.toUpperCase().charAt(i));
                j++;
            }
            System.out.println();
            j++;
        }
    }

    private static void efeito3(String[] strings) {
        System.out.println("Efeito 3:");
        String s = String.join(" ", strings).toUpperCase();
        int lengthOfString = s.length();

        for (int i = 0; i < lengthOfString; i++) {
            for (int j = 0; j < lengthOfString; j++) {
                if ((i == j) || (i + j == lengthOfString - 1)) {
                    System.out.print(s.charAt(i));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    private static void efeito4(String[] strings) {
        System.out.println("Efeito 4:");
        int j = String.join(" ", strings).length() - 1;
        for (int k = strings.length - 1; k >= 0; k--) {
            String str = strings[k];
            for (int i = 0; i < str.length(); i++) {
                for (int spacesCount = j; spacesCount > 0; spacesCount--) {
                    System.out.print(" ");
                }
                System.out.println(str.toUpperCase().charAt(i));
                j--;
            }
            System.out.println();
            j--;
        }
    }

    private static void efeito5(String[] strings) {
        System.out.println("Efeito 5:");
        String str = String.join(" ", strings);
        int j = 0;
        int x = str.length() * 2 - 1;
        for (int i = 0; i < str.length(); i++) {
            for (int spacesCount = 0; spacesCount < str.length() * 2; spacesCount++) {
                if ((j == spacesCount) || (x == spacesCount))
                    System.out.print(str.toUpperCase().charAt(i));
                else
                    System.out.print(" ");
            }
            System.out.println();
            j++;
            x--;
        }
    }

    private static void efeito6(String[] strings) throws InterruptedException {
        int word_length = 40;
        String s = String.join(" ", strings).toUpperCase();

        // Adiciona espaços no fim
        if (word_length - s.length() > 0) {
            String whitespaceString = new String(new char[word_length - s.length()]).replace('\0', ' ');
            s = s + whitespaceString;
        }

        char[] myCharArray;
        myCharArray = s.toCharArray();

        while (true) {
            System.out.println(myCharArray);
            myCharArray = changeName(myCharArray, word_length);

            try {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static char[] changeName(char[] myCharArray, int length) {
        char first = myCharArray[0];
        for (int i = 1; i < myCharArray.length; i++) {
            myCharArray[i - 1] = myCharArray[i];
        }
        myCharArray[myCharArray.length - 1] = first;
        return myCharArray;
    }
}
