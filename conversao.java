import java.util.Stack;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Stack <String> pilha = new Stack<>();
		String[] infixa = new String[10];
		char resp = 'S';
		int i = 0;
		Scanner scan = new Scanner(System.in);
		while(resp == 'S')
		{
		    System.out.println("Insira um valor da expressao: ");
		    String val = scan.nextLine();
		    infixa[i] = val;
		    i++;
		    System.out.println("Deseja continuar? ");
		    resp = scan.nextLine().charAt(0);
		}
		System.out.println("Os valores inseridos na expressao são:");
        for (int j = 0; j < i; j++) {
            System.out.println(infixa[j]);
        }
        
        for(int j = 0;j<i;j++){
            if (infixa[j].equals("+"))
            {
                pilha.push(infixa[j]);
            }
            else if(infixa[j].equals("-"));
            {
                pilha.push(infixa[j]);
            }
        }
        while(!pilha.isEmpty())
        {
            System.out.println(pilha.pop());
        }
	}
}
