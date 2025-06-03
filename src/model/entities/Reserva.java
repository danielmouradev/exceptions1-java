package model.entities;

import exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQuarto;
    private Date entrada;
    private Date saida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date entrada, Date saida) throws DomainException {
        if (!saida.after(entrada)) {
            throw new DomainException("A data de saída precisa ser posterior a da entrada!");
        }
        this.numeroQuarto = numeroQuarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }


    public Date getSaida() {
        return saida;
    }

    public long duracao (){
        long dif = saida.getTime() - entrada.getTime(); //Pega a diferença entre  as duas datas em milissegundos
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS); //Convertendo milissegundos em dias
    }

    public void atualizar(Date entrada, Date saida) throws DomainException{
        Date now = new Date();
        if (entrada.before(now) && saida.before(now)) {
            throw new DomainException("A DATA DE ATUALIZAÇÃO PRECISA SER FUTURA!");
        } if (!saida.after(entrada)) {
           throw new DomainException("A data de saída precisa ser posterior a da entrada!");
        }
        this.entrada = entrada;
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Quarto " +
                numeroQuarto +
                ", entrada " +
                sdf.format(entrada) +
                ", saída " +
                sdf.format(saida) +
                ", " +
                duracao() +
                " noites";
    }
}
