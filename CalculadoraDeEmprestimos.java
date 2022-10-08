import java.util.Scanner;
public class CalculadoraDeEmprestimos {
    public static void main(String[] args) {
        Scanner readInt = new Scanner(System.in);
        double prodValue; int quant;
        System.out.printf("Bem-vindo à loja do Sr. Jubileu! =)\nEntre com valor de produto: R$");
        prodValue = readInt.nextDouble();
        System.out.printf("Entre com quantidade de produtos: ");
        quant = readInt.nextInt();
        System.out.println("O valor sem desconto foi: " + "R$" + (prodValue * quant));
        if (quant >= 5 && quant <= 19) {
            System.out.println("O valor com desconto foi: " + "R$" + ((prodValue * quant) - (prodValue * quant) * 3 / 100) + " (desconto 3%");
        } else if (quant >= 20 && quant <= 99){
            System.out.println("O valor com desconto foi: " + "R$" + ((prodValue * quant) - (prodValue * quant) * 6 / 100) + " (desconto 6%)");
        } else if (quant >= 100){
            System.out.println("O valor com desconto foi: " + "R$" + ((prodValue * quant) - (prodValue * quant) * 10 / 100) + " (desconto 10%)");
        } else
            System.out.println("O valor com desconto foi: " + "R$" + (prodValue * quant) + " (desconto 0%)");
    }
}