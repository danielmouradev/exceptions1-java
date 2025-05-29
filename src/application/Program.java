package application;

import model.entities.Reserva;

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
        System.out.print("Entre com a data de saída: ");
        Date saida = sdf.parse(sc.next());

        if (!saida.after(entrada)) {
            System.out.println("Erro na reserva. A data de saída precisa ser posterior a da entrada!");
        }else {
            Reserva reserva = new Reserva(numQuarto, entrada, saida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("ENTRE COM A DATA PARA ATUALIZAR A RESERVA");

            System.out.print("Entre com a data de entrada: ");
            entrada = sdf.parse(sc.next());
            System.out.print("Entre com a data de saída: ");
            saida = sdf.parse(sc.next());
            reserva.atualizar(entrada, saida);

            Date now = new Date();

            if (entrada.before(now) || saida.before(now)) {
                System.out.println("ERRO NA RESERVA. A DATA DE ATUALIZAÇÕES PRECISA SER FUTURA!");
            } else if (!saida.after(entrada)) {
                System.out.println("Erro na reserva. A data de saída precisa ser posterior a da entrada!");
            } else {
                reserva.atualizar(entrada, saida);
                System.out.println("Reserva: " + reserva);

            }
        }



        sc.close();
    }
}
