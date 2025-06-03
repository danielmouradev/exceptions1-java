package application;

import exceptions.DomainException;
import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {


            System.out.print("Entre com o número do quarto: ");
            Integer numQuarto = sc.nextInt();
            System.out.print("Entre com a data de entrada: ");
            Date entrada = sdf.parse(sc.next());
            System.out.print("Entre com a data de saída: ");
            Date saida = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numQuarto, entrada, saida);
            System.out.println("Reserva: " + reserva);


            System.out.println();
            System.out.println("ENTRE COM A DATA PARA ATUALIZAR A RESERVA");

            System.out.print("Entre com a data de entrada: ");
            entrada = sdf.parse(sc.next());
            System.out.print("Entre com a data de saída: ");
            saida = sdf.parse(sc.next());

            reserva.atualizar(entrada, saida);
            System.out.println("Reserva: " + reserva);

        }catch (ParseException e){
            System.out.println("Formato de data inválido!");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e) { //Para erros genéricos co, RunTimeEException
            System.out.println("Erro inesperado");
        }

        sc.close();
    }
}
