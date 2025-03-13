import java.util.Stack;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Stack <Character> pilha = new Stack<>();
        char[] infixa = new char[20];
        char[] saida = new char[20];
        char resp = 'S';
        int i = 0, j = 0, k =0;
        Scanner scan = new Scanner(System.in);

        while(resp == 'S')
        {
            System.out.println("Insira um valor da expressao: ");
            char val = scan.nextLine().charAt(0);
            infixa[i++] = val;
            System.out.println("Deseja continuar? ");
            resp = scan.nextLine().charAt(0);
        }

        while(j<i){
            char val = infixa[j];
            if (val == '+' || val == '-' || val == '(')
            {
                pilha.push(val);
            }
            else if(val == '*' || val == '/' || val == '^')
            {
                while(!pilha.isEmpty() && (pilha.peek() == '*' || pilha.peek() == '/' || pilha.peek() == '^'))
                {
                    saida[k++] = pilha.pop();
                }
                pilha.push(val);
            }
            else if(val == ')')
            {
                while(!pilha.isEmpty() && pilha.peek() != '(')
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

        System.out.println("Expressao pos-fixa:");
        for (int l = 0; l < k; l++) {
            System.out.print(saida[l] + " ");
        }
        scan.close();
    }
}
