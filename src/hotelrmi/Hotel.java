
package hotelrmi;

/**
 *
 * @author Guilherme
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Hotel extends Remote{
    public class ImplementaQuarto{
        private int numero;
        private double preco;
        private boolean reservado;
        private String hospede;
        public ImplementaQuarto (int numero){
            this.numero = numero;
            this.preco = 0.0;
            this.reservado = false;
            this.hospede= "";
        }
        public void setPreco (double preco){
            this.preco = preco;
        }
        public double getPreco (){
            return this.preco;
        }
        public void setNumero (int numero){
             this.numero= numero;
        }
        public int getNumero (){
            return this.numero;
        }
        public void setHospede (String hospede){
            this.hospede = hospede;
        }
        public String getHospede (){
            return this.hospede;
        }
        public void setReservado (boolean reservado){
            this.reservado = reservado;
            
        }
        public boolean getReservado (){
            return this.reservado;
        }
    }
    /**Reserva o quarto indicado pelo parametro*/
    public String reservar (int numQuarto,String hospede,int tipo) throws RemoteException;
    /**Desfaz reserva do quarto indicado pelo parametro*/
    public String desfazerReserva (int numQuarto,String hospede) throws RemoteException;
    /**Retorna a quantidade de quartos disponíveis*/
    public String quartosDisponiveis () throws RemoteException;
    /**Retorna as informações de um determinado quarto*/
    public String informaQuarto (int numQuarto) throws RemoteException;
    /**Retorna a quantidade de quartos no hotel*/
    public int numeroQuartos () throws RemoteException;
    /**Retorna a lista de hospedes do hotel*/
    public String listarHospedes () throws RemoteException;
    
}