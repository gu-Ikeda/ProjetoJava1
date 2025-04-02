import java.util.Scanner;

public class Main
{
    public static String[] verificador(char[] junto){
        char[] veri = junto;
        int operadores = 0;
        int parenteses = 0;
        int seguido = 0;
        for(int i = 0;i<veri.length;i++)
        {
            if(veri[i] == '+' || veri[i] == '-' || veri[i] == '*' || veri[i] == '/' || veri[i] == '^')
            {
                operadores++;
            }
            else if(veri[i] == '(' || veri[i] == ')')
            {
                parenteses++;
            }
            else if(i < veri.length - 1 && veri[i] >= 'A' && veri[i] <= 'Z' && veri[i + 1] >= 'A' && veri[i + 1] <= 'Z')
            {
                seguido++;
            }
        }
        if(operadores == 0){
            return new String[]{"Erro: Comando invalido", "false"};
        }
        else if(parenteses%2 != 0){
            return new String[]{"Erro: Expressao invalida","false"};
        }
        else if(seguido > 0){
            return new String[]{"Erro: Expressao invalida","false"};
        }
        return new String[]{"","true"};
    }
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pilha pilha = new Pilha();
        char resp = 'S';
        boolean teste = true; // trocar
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
                String[] verifica = verificador(junto);
                teste = Boolean.valueOf(verifica[1]);
                if(teste == false)
                {
                    System.out.println(verifica[0]);
                    junto = new char[20];
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
}
