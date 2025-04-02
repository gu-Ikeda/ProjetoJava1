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
                if(i < veri .length - 1 &&(veri[i + 1] == '+' || veri[i + 1] == '-' || veri[i + 1] == '*' || veri[i + 1] == '/' || veri[i + 1] == '^'))
                {
                    seguido++;
                }
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

    public static boolean vazio(char[] vari){
        for(int i = 0;i<vari.length;i++){
            if(vari[i] != '\0')
            {
                return true;
            }
        }
        return false;
    }
    public static boolean diferente(char[] vari, char[] junto){
        for(int i = 0;i<junto.length;i++)
        {
            boolean encontrado = false;
            for(int j = 0;j <vari.length;j++)
            {
                if(junto[i] == vari[j])
                {
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado && junto[i] >= 'A' && junto[i] <= 'Z')
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pilha pilha = new Pilha();
        boolean teste ; // trocar
        boolean teste2; //trocar
        boolean teste3;
        boolean resp = true;
        char[] junto = new char[20];
        char[] vari = new char[10];
        int[] valor = new int[10];
        char[] posfixa = new char[20];
        int convertido;
        int tracker = 0, reach = 0, aux = 0;
        while(resp){
            String entrada = scan.nextLine();
            entrada = entrada.replaceAll("\\s", ""); //remove os espacos
            junto = entrada.toCharArray(); // converte para um array de char
            if(junto.length >= 3 && junto[1] == '=')
            {
                vari[tracker] = junto[0];
                convertido = Integer.parseInt(String.valueOf(junto[2]));
                valor[tracker] = convertido;

                System.out.println(vari[tracker]+" = "+valor[tracker]);
                tracker++;
            }
            else if (junto.length == 1) {
                boolean encontrado = false;
                for (int j = 0; j < tracker; j++) {
                    if (junto[0] == vari[j]) {
                        System.out.println(valor[j]);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Variável" +junto[0]+ " não inciada.");
                }
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
                resp = false;
            }
            else
            {
                String[] verifica = verificador(junto);
                teste = Boolean.valueOf(verifica[1]);
                teste2 = vazio(vari);
                teste3 = diferente(vari,junto);
                if(teste == false){
                    System.out.println(verifica[0]);
                    junto = new char[20];
                }
                if(teste2 == false || teste3 == false)
                {
                    for(int d = 0;d< junto.length;d++){
                        if(junto[d] >= 'A' && junto[d] <= 'Z'){
                            System.out.println("Variavel "+junto[d]+" nao inciada");
                        }
                    }
                    junto = new char[20];
                }
                else if(teste == true && teste2 == true && teste3 == true)
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
                    junto = new char[20];
                    aux = 0;
                }
            }
        }
    }
}
