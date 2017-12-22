
package hotelrmi;

/**
 *
 * @author Guilherme
 */
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class ClienteHotel {
    

    public ClienteHotel() {
        System.out.println("Iniciando Sistema.");
    }
    public static void main (String args[]) throws RemoteException, NotBoundException{
        
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099);
            Hotel hotel = (Hotel) reg.lookup("RMIServer");
         String lido,hospede;
         int numero,tipo;
            do{
                System.out.println("Escolha sua opcao:"+
                        "\n1 - Reservar quarto" +
                        "\n2 - Desfazer reserva" +
                        "\n3 - Numero de quartos disponiveis" +
                        "\n4 - Consultar quarto" +
                        "\n5 - Numero de quartos do hotel"+
                        "\n6 - Listar Hospedes"+
                        "\n0 - Finalizar");
                Scanner in = new Scanner(System.in);
                Scanner on = new Scanner(System.in);
                
                lido = in.nextLine();
                switch (lido) {
                    case "1":
                        System.out.println("Entre com o seu nome,numero do quarto e tipo do quarto:");
                        hospede= on.nextLine();
                        numero=Integer.parseInt(on.nextLine());
                        tipo=Integer.parseInt(on.nextLine());
                        System.out.println("Reservando Quarto");
                        System.out.println(hotel.reservar(numero,hospede,tipo));
                        break;
                    case "2":
                        System.out.println("Entre com o seu nome e o numero do quarto:");
                        hospede= on.nextLine();
                        numero=Integer.parseInt(on.nextLine());
                        System.out.println("Desfazendo Reserva");
                        System.out.println( hotel.desfazerReserva(numero,hospede));
                        break;
                    case "3":
                        System.out.println("Quartos Disponiveis");
                        System.out.println(hotel.quartosDisponiveis());
                        break;
                    case "4":
                        System.out.println("Entre com numero do quarto:");
                        numero=Integer.parseInt(on.nextLine());
                        System.out.println("Consultar Quarto");
                        System.out.println(hotel.informaQuarto(numero));
                        break;
                        case "5":
                        System.out.println("Numero de quartos");
                        System.out.println(+hotel.numeroQuartos());
                        break;
                        case "6":
                        System.out.println("Hospedes:");
                        System.out.println(hotel.listarHospedes());
                        break;
                    default:
                        break;
                }
            }while (!lido.equals("0"));
            System.out.println("Finalizando Sistema.");
           
    }
}
