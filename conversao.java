import java.util.Stack;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Stack <String> pilha = new Stack<>();
        String[] infixa = new String[10];
        String[] saida = new String[10];
        char resp = 'S';
        int i = 0, j = 0, k =0;
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

        while(j<i){
            String val = infixa[j];
            if (val.equals("+") || val.equals("-") || val.equals("("))
            {
                pilha.push(val);
            }
            else if(val.equals("*") || val.equals("/") || val.equals("^"))
            {
                while(!pilha.isEmpty() && (pilha.peek().equals("*") || pilha.peek().equals("/") || pilha.peek().equals("^")))
                {
                    saida[k++] = pilha.pop();
                }
                pilha.push(val);
            }
            else if(val.equals(")"))
            {
                while(!pilha.peek().equals("("))
                {
                    saida[k++] = pilha.pop();
                }
                pilha.pop();
            }
            else
            {
                saida[k++] = val;
            }
            j++;
        }
        while(!pilha.isEmpty()){
            saida[k++] = pilha.pop();
        }

        System.out.println("Expressao pos fixa");
        for(String s : saida)
        {
            if(s != null)
            {
                System.out.println(s + " ");
            }
        }
        scan.close();
    }
}
