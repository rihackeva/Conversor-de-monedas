package conversor.monedas;
import java.io.IOException;
import java.util.Scanner;
import static conversor.monedas.ConversorDivisas.*;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirUSDToARS(scanner);
                    break;
                case 2:
                    convertirARSToUSD(scanner);
                    break;
                case 3:
                    convertirUSDToBRL(scanner);
                    break;
                case 4:
                    convertirBRLToUSD(scanner);
                    break;
                case 5:
                    convertirUSDToCOP(scanner);
                    break;
                case 6:
                    convertirCOPToUSD(scanner);
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestro Conversor de Monedas,¡Proceso Finalizado!");
                    System.exit(0);
                default:
                    System.out.println("Opción no disponible. Inténtalo otra vez");
            }
        }
    }
}