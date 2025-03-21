import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char resp = 'S';
        char[] junto = new char[10];
        char[] vari = new char[10];
        int[] valor = new int[10];
        int convertido;
        int tracker = 0;
        while(resp == 'S'){
            String teste = scan.nextLine();
            teste = teste.replaceAll("\\s", ""); //remove os espacos
            junto = teste.toCharArray(); // converte para um array de char
            if(junto[1] == '=')
            {
                for(int i = 0;i<junto.length;i++)
                {
                    vari[tracker] = junto[0];
                    convertido = Integer.parseInt(String.valueOf(junto[2]));
                    valor[tracker] = convertido;
                }
                System.out.println(vari[tracker]+" = "+valor[tracker]);
                tracker++;
            }
            else if(teste.equals("VARS"))
            {
                if(tracker == 0)
                {
                    System.out.println("Nenhuma variavel iniciada");
                }
                else
                {
                    for(int j = 0;j<tracker;j++)
                    {
                        System.out.println(vari[j]+" = "+valor[j]);
                    }
                }
            }
            else if(teste.equals("RESET"))
            {
                vari = new char[10];
                valor = new int[10];
                System.out.println("Variaveis reiniciadas");
                tracker = 0;
            }
            else if(teste.equals("EXIT"))
            {
                resp = 'N';
            }
        }
    }
}
