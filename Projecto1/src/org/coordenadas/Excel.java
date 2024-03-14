package org.coordenadas;

import java.io.*;

public class Excel {
    public static void main(String[] args) {

        boolean terminar = true;

        Console cns1 = System.console();
        while (terminar) {
            String excelCoordinate = cns1.readLine("Indique as coordenadas: ");
            if (excelCoordinate.equals("sair")) {
                System.out.println("Fim do programa");
                break;
            }
            String trimmedExcelCoordinate = excelCoordinate.replace(" ", "");

            int[] indices = excelCoordinateToIndices(trimmedExcelCoordinate);

            if (indices != null) {
                int row = indices[0];
                int column = indices[1];
                System.out.println("Linha: " + row);
                System.out.println("Coluna: " + column);
            } else {
                System.out.println("Coordinada Excel Invalida.");
            }
        }

    }

    public static int[] excelCoordinateToIndices(String excelCoordinate) {
        int column = 0;
        int row = 0;
        String rowString = "";

        for (int i = 0; i < excelCoordinate.length(); i++) {
            char c = excelCoordinate.charAt(i);
            if (Character.isLetter(c)) {
                column = column * 26 + (Character.toUpperCase(c) - 'A' + 1);
            } else if (Character.isDigit(c)) {
                rowString = rowString + Character.toString(c);
                row = Integer.parseInt(rowString);
            } else {
                return null;
            }
        }

        return new int[] { row - 1, column - 1 };
    }
}

