import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		String entrada;
		char[] vari = {'A'};
		int[] valor = {2};
		Scanner scan = new Scanner(System.in);
		entrada = scan.nextLine();
		if(entrada.length() == 1)
		{
		     char[] teste = entrada.toCharArray();
		    for(int i = 0;i<vari.length;i++)
		    {
		        if(teste[0] == vari[i])
		        {
		            System.out.println(valor[i]);
		        }
		        else
		        {
		            System.out.println("Erro: variavel "+ teste[0]+" não definida.");
		        }
		    }
		}
	}
}
