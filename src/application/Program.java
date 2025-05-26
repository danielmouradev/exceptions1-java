package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o número do quarto: ");
        Integer numQuarto = sc.nextInt();
        System.out.print("Entre com a data de entrada: ");
        Date entrada = sdf.parse(sc.next());




        sc.close();
    }
}
