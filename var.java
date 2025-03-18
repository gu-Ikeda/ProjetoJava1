import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Digite as variaveis: ");
        Scanner scan = new Scanner(System.in);
        char resp = 'S';
        char[] junto = new char[100];
        char[] var = new char[100];
        int[] valor = new int[100];
        int convertido;
        int tracker = 0;
        while(resp == 'S'){
            System.out.println("Digite: ");
            String teste = scan.nextLine();
            teste = teste.replaceAll("\\s", ""); //remove os espacos
            junto = teste.toCharArray(); // converte para um array de char
            for(int i = 0;i< junto.length;i++){
                var[tracker] = junto[0];
                convertido = Integer.parseInt(String.valueOf(junto[2]));
                valor[tracker] = convertido;
            }
            tracker++;
            System.out.println("Deseja continuar?");
            resp = scan.nextLine().charAt(0);
        }
        System.out.println(var[0]);
        System.out.println(valor[0]);
        System.out.println(var[1]);
        System.out.println(valor[1]);
    }
}
