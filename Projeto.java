import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pilha pilha = new Pilha();
        char resp = 'S';
        char[] junto = new char[20];
        char[] vari = new char[10];
        int[] valor = new int[10];
        char[] posfixa = new char[20];
        int convertido;
        int tracker = 0, reach = 0, aux = 0;
        while(resp == 'S'){
            String entrada = scan.nextLine();
            entrada = entrada.replaceAll("\\s", ""); //remove os espacos
            junto = entrada.toCharArray(); // converte para um array de char
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
            else if(entrada.equals("VARS"))
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
            else if(entrada.equals("RESET"))
            {
                vari = new char[10];
                valor = new int[10];
                tracker = 0;
                System.out.println("Variaveis reiniciadas");
            }
            else if(entrada.equals("EXIT"))
            {
                resp = 'N';
            }
            else
            {
                while(reach < junto.length)
                {
                    char val = junto[reach];
                    if(val == '+' || val == '-' || val == '(')
                    {
                        pilha.push(val);
                    }
                    else if(val == '*' || val == '/' || val == '^')
                    {
                        while(!pilha.isEmpty() && (pilha.peek() == '*' || pilha.peek() == '/' || pilha.peek() == '^'))
                        {
                            posfixa[aux++] = pilha.pop();
                        }
                        pilha.push(val);
                    }
                    else if(val == ')')
                    {
                        while (!pilha.isEmpty() && pilha.peek() != '(')
                        {
                            posfixa[aux++] = pilha.pop();
                        }
                        pilha.pop();
                    }
                    else
                    {
                        posfixa[aux++] = val;
                    }
                    reach++;
                }
                while(!pilha.isEmpty())
                {
                    posfixa[aux++] = pilha.pop();
                }
                System.out.println("Expressao pos-fixa:");//Imprimi a expressao na forma pos-fixa
                for (int l = 0; l < aux; l++)
                {
                    System.out.print(posfixa[l] + " ");
                }
                System.out.println("");
                //posfixa = new char[20];
                reach = 0;
                //aux = 0;
                
                PilhaNum pilhanum = new PilhaNum();
                int res = 0;
                int num1 = 0;
                int num2 = 0;
                
                for(int u = 0; u < aux;u++){
                    if(posfixa[u] == '+')
                    {
                        num2 = pilhanum.pop();
                        num1 = pilhanum.pop();
                        res = num1 + num2;
                        pilhanum.push(res);
                    }
                    else if(posfixa[u] == '-')
                    {
                        num2 = pilhanum.pop();
                        num1 = pilhanum.pop();
                        res = num1 - num2;
                        pilhanum.push(res);
                    }
                    else if(posfixa[u] == '*')
                    {
                        num2 = pilhanum.pop();
                        num1 = pilhanum.pop();
                        res = num1 * num2;
                        pilhanum.push(res);
                    }
                    else if(posfixa[u] == '/')
                    {
                        num2 = pilhanum.pop();
                        num1 = pilhanum.pop();
                        res = num1 / num2;
                        pilhanum.push(res);
                    }
                    else if(posfixa[u] == '^')
                    {
                        num2 = pilhanum.pop();
                        num1 = pilhanum.pop();
                        for (int p = 0; p < num2; p++) {
                            res *= num1;
                        }
                        pilhanum.push(res);
                    }
                    else
                    {
                        for (int o = 0; o < vari.length; o++)
                        {
                            if (vari[o] == posfixa[u])
                            {
                                pilhanum.push(valor[o]);
                            }
                        }
                    }
                }
                System.out.println(res);
                posfixa = new char[20];
                aux = 0;
            }
        }
    }
}
