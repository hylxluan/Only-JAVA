import java.util.InputMismatchException;
import java.util.Scanner;
public class CalculadoraDeEmprestimosV2 {
    public static void main(String[] args) {
        Scanner readInt = new Scanner(System.in);
        double prodValue;
        int quant;
        do {
                try {
                    System.out.print("Bem-vindo à loja do Sr. Jubileu! =)\nEntre com valor de produto: R$");
                    while (! readInt.hasNextDouble() && ! readInt.hasNextInt()) {
                        readInt.nextLine();
                        throw new InputMismatchException();
                    }
                    prodValue = readInt.nextDouble();
                    System.out.print("\nEntre com quantidade de produtos: ");
                    quant = readInt.nextInt();
                    System.out.println("O valor sem desconto foi: " + "R$" + (prodValue * quant));
                if (quant >= 5 && quant <= 19) {
                    System.out.println("O valor com desconto foi: " + "R$" + ((prodValue * quant) - (prodValue * quant) * 3 / 100) + " (desconto 3%");
                } else if (quant >= 20 && quant <= 99) {
                    System.out.println("O valor com desconto foi: " + "R$" + ((prodValue * quant) - (prodValue * quant) * 6 / 100) + " (desconto 6%)");
                } else if (quant >= 100) {
                    System.out.println("O valor com desconto foi: " + "R$" + ((prodValue * quant) - (prodValue * quant) * 10 / 100) + " (desconto 10%)");
                } else
                    System.out.println("O valor com desconto foi: " + "R$" + (prodValue * quant) + " (desconto 0%)");
            } catch (InputMismatchException EX) {
                System.out.println("Campo inválido!");
                prodValue = 0;
                quant = 0;
            }
        } while (prodValue == 0 && quant == 0);
    }
}