
package hotelrmi;

/**
 *
 * @author Guilherme
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ServidorHotel {
    /** Creates a new instance of ServidorHotel */
    public ServidorHotel(int numQuartosHotel) {
        try{
            Hotel hotel = new ImplementaHotel(51);
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("RMIServer", hotel);     
        }catch(Exception e){
            System.out.println("Problema no servidor: " + e);
        }
    }
    public static void main(String[] args) {
           ServidorHotel a = new ServidorHotel(51);
        //}
    }
}
