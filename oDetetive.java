/*
Objetivo: utilizando listas, elabore um programa que faça 5 perguntas para uma pessoa sobre o crime, as perguntas são:

1- "Telefonou para a vítima?"
2- "Esteve no local do crime?"
3- "Mora perto da vítima?"
4- "Devia para a vítima?"
5- "Já trabalhou com a vítima?"

Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como "Cúmplice"
e 5 como "Assassina". Caso contrário, será declarada como "Inocente".*/
import java.util.*;
public class oDetetive {
    public static void main(String[] args) {
        List<String> answer = new ArrayList<>();
        Scanner rdAnswr = new Scanner(System.in);
        do
        {
            try
            {
                System.out.print("Telefonou para a vítima[y/n]?");
                answer.add(rdAnswr.next());
                System.out.print("Esteve no local do crime[y/n]?");
                answer.add(rdAnswr.next());
                System.out.print("Mora perto da vítima[y/n]?");
                answer.add(rdAnswr.next());
                System.out.print("Devia para a vítima[y/n]?");
                answer.add(rdAnswr.next());
                System.out.print("Já trabalhou com a vítima[y/n]?");
                answer.add(rdAnswr.next());
                if (! hasAnsw(answer)) {
                    throw new InputMismatchException();
                }
                short count = 0;
                for (int i = 0; i < answer.size(); ++i) {
                    if (answer.get(i).equals("y")) {
                        count += 1;
                    }
                }
                if (count == 2) {System.out.println("Suspeito!");}
                else if (count > 2 && count < 5) {System.out.println("Cúmplice!");}
                else if (count == 5) {System.out.println("Assassino!!");}
                else
                    System.out.println("Inocente!");
            }
            catch (InputMismatchException EXCEP)
            {
                System.out.println("Apenas [y/n] será permitido!");
                answer.clear();
            }
        } while (answer.isEmpty());
    }
    private static boolean hasAnsw(List<String> pattern) throws InputMismatchException
    {
        for (int i = 0; i < pattern.size(); ++i)
        {
            if (!pattern.get(i).startsWith("y") && !pattern.get(i).startsWith("n")) {
                return false;}
            else if (pattern.get(i).length() > 1) {
                return false;}
        }
        return true;
    }
}