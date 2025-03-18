import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
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


        PilhaNum pilhanum = new PilhaNum();
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        char[] lista1 = {'A','B','C','D','E'};
        int[] lista2 = {7,3,6,4,9};

        for (int u = 0; u < saida.length; u++)
        {
            if (saida[u] == '+')
            {

                num2 = pilhanum.pop();
                num1 = pilhanum.pop();
                res = num1 + num2;
                pilhanum.push(res);
            }
            else if (saida[u] == '-')
            {
                num2 = pilhanum.pop();
                num1 = pilhanum.pop();
                res = num1 - num2;
                pilhanum.push(res);
            }
            else if(saida[u] == '*')
            {
                num2 = pilhanum.pop();
                num1 = pilhanum.pop();
                res = num1 * num2;
                pilhanum.push(res);
            }
            else if(saida[u] == '/')
            {
                num2 = pilhanum.pop();
                num1 = pilhanum.pop();
                res = num1/num2;
                pilhanum.push(res);
            }
            else if(saida[u] == '^')
            {
                num2 = pilha.pop();
                num1 = pilha.pop();
                for(int p = 0;p<num2;p++)
                {
                    res *= num1;
                }
                pilhanum.push(res);
            }
            else
            {
                for (int o = 0; o < lista1.length; o++)
                {
                    if (lista1[o] == saida[u])
                    {
                        pilhanum.push(lista2[o]);
                    }
                }
            }
        }

        System.out.println(res);
    }
}
