/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelrmi;

/**
 *
 * @author Guilherme
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class ImplementaHotel extends UnicastRemoteObject implements Hotel{
    private ImplementaQuarto[] quartos;
    /** Creates a new instance of ImplementaHotel */
    public ImplementaHotel(int numQuartos) throws RemoteException{
        super();
        this.quartos = new ImplementaQuarto[numQuartos];
        for(int i = 0; i < numQuartos; i++)
            quartos[i] = new ImplementaQuarto(i);
        for(int i = 0; i < numQuartos; i++){
         if(i<10){
            quartos[i].setPreco(55.00);quartos[i].setNumero(0);}
         if(i>=10 &&(i<20)){
            quartos[i].setPreco(75.00);quartos[i].setNumero(1);}
         if(i>=20 && i<30){
            quartos[i].setPreco(80.00);quartos[i].setNumero(2);}
         if(i>=30 && i<40){
            quartos[i].setPreco(150.00);quartos[i].setNumero(3);}
         if(i>=40 && i<50){
            quartos[i].setPreco(230.00);quartos[i].setNumero(4);}}
        System.out.println("Iniciado o servico do hotel !");
    }
    public String informaQuarto (int numQuarto) throws RemoteException{
        String retorno = new String();
        if((this.quartos.length <= numQuarto) || (numQuarto < 0)){
            retorno = "Quarto nao encontrado";
        }else{
            retorno = "Tipo: " + quartos[numQuarto].getNumero()+
                    "\nPreco: " + quartos[numQuarto].getPreco()+
                    "\nReservado: " + quartos[numQuarto].getReservado()+
                    "\nReservado para: " + quartos[numQuarto].getHospede();
                    
                    
        }
        return retorno;
    }
    public String reservar (int numQuarto,String nome,int numero) throws RemoteException{
        String retorno = new String();
        retorno="Quarto não encontrado ou não disponivel";
        if(this.quartos[numQuarto].getReservado()!=true){
         
        if((this.quartos.length <= numQuarto) || (numQuarto < 0)){
           //if(numQuarto<=10 && numero!=0||((numQuarto>10 &&numQuarto<=20)&&numero!=1)||((numQuarto>20 && numQuarto<=30)&&numero!=2)||((numQuarto>30 && numQuarto<=40)&&numero!=3)||((numQuarto>40 && numQuarto<=50)&&numero!=4))
           retorno = "Quarto nao encontrado";
           }
           
        else{
            this.quartos[numQuarto].setReservado(true);
            this.quartos[numQuarto].setHospede(nome);
            retorno = "Quarto " + numQuarto + " do tipo " + numero + " reservado."+
                    "Valor: R$ " + quartos[numQuarto].getPreco();
        }
        }
        return retorno;
    }
    public String desfazerReserva (int numQuarto,String nome) throws RemoteException{
        String retorno = new String();
        if((this.quartos.length <= numQuarto) || (numQuarto < 0)){
            retorno = "Quarto nao encontrado";
        }else if(this.quartos[numQuarto].getReservado() && this.quartos[numQuarto].getHospede().equals(nome)){
            this.quartos[numQuarto].setReservado(false);
            this.quartos[numQuarto].setHospede("");
            retorno = "Reserva desfeita para o quarto " + numQuarto;
        }else 
            retorno = "O quarto nao estava reservado";
        return retorno;
    }
    public String quartosDisponiveis () throws RemoteException{
        int quartosDisponiveis0 = 0;
        int quartosDisponiveis1 = 0;
        int quartosDisponiveis2 = 0;
        int quartosDisponiveis3 = 0;
        int quartosDisponiveis4 = 0;
        for(int i = 0; i < quartos.length; i++)
            if(!quartos[i].getReservado())
            {
                if(quartos[i].getNumero()==0){
                   quartosDisponiveis0++;}
                if(quartos[i].getNumero()==1){
                   quartosDisponiveis1++; }
                 if(quartos[i].getNumero()==2){
                   quartosDisponiveis2++; }
                  if(quartos[i].getNumero()==3){
                   quartosDisponiveis3++; }
                 if(quartos[i].getNumero()==4){
                   quartosDisponiveis4++; }
               }
                
        String retorno= "Existem "+quartosDisponiveis0+" do tipo 0 e preço de R$ 55,\n" +quartosDisponiveis1+" do tipo 1 e preço de R$ 75,\n"
                +quartosDisponiveis2+" do tipo 2 e preço de R$ 80,\n"+quartosDisponiveis3+" do tipo 3 e preço de R$ 150,\n"+quartosDisponiveis4+" do tipo 4 e preço de R$ 230";
        return retorno;
    }
    public String listarHospedes () throws RemoteException{
        String retorno="";
        for(int i = 0; i < quartos.length; i++)
            if(quartos[i].getReservado())
            {
                retorno= retorno+"\n"+quartos[i].getHospede();
            }
        return retorno;
    }
            
    public int numeroQuartos () throws RemoteException{
        return this.quartos.length;
    }
     
}
