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
		/*System.out.println("Os valores inseridos na expressao são:");
        for (int j = 0; j < i; j++) {
            System.out.println(infixa[j]);
        }*/
        
        for(int j = 0;j<i;j++){
            String val = infixa[j];
            if (val.equals("+") || val.equals("-"))
            {
                pilha.push(val);
            }
            else if(val.equals("*"))
            {
                if(!pilha.isEmpty() && (pilha.peek().equals("*") || pilha.peek().equals("/") || pilha.peek().equals("^")))
                {
                    pilha.pop();
                }
                pilha.push(val);
            }
        }
        while(!pilha.isEmpty())
        {
            System.out.println(pilha.pop());
        }
	}
}
