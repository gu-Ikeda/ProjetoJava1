import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        char[] infixa = new char[20];
        char[] saida = new char[20];
        char resp = 'S';
        int i = 0, j = 0, k = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite as variaveis: ");
        char respo = 'S';
        char[] junto;
        char[] var = new char[10];
        int[] valor = new int[10];
        int convertido;
        int tracker = 0;
        while (respo == 'S') {
            System.out.println("Digite: ");
            String teste = scan.nextLine();
            teste = teste.replaceAll("\\s", ""); //remove os espacos
            junto = teste.toCharArray(); // converte para um array de char
            for (int t = 0; t < junto.length; t++) {
                var[tracker] = junto[0];
                convertido = Integer.parseInt(String.valueOf(junto[2]));
                valor[tracker] = convertido;
            }
            tracker++;
            System.out.println("Deseja continuar?");
            respo = scan.nextLine().charAt(0);
        }




            while (resp == 'S') {
                System.out.println("Insira um valor da expressao: ");
                String expressao = scan.nextLine();
                expressao = expressao.replaceAll("\\s", "");
                infixa = expressao.toCharArray();
                System.out.println("Deseja continuar? ");
                resp = scan.nextLine().charAt(0);

                /*System.out.println("Insira um valor da expressao: ");
                char val = scan.nextLine().charAt(0);
                infixa[i++] = val;
                System.out.println("Deseja continuar? ");
                resp = scan.nextLine().charAt(0);*/
            }

            while (j < infixa.length) {
                char val = infixa[j];
                if (val == '+' || val == '-' || val == '(') {
                    pilha.push(val);
                } else if (val == '*' || val == '/' || val == '^') {
                    while (!pilha.isEmpty() && (pilha.peek() == '*' || pilha.peek() == '/' || pilha.peek() == '^')) {
                        saida[k++] = pilha.pop();
                    }
                    pilha.push(val);
                } else if (val == ')') {
                    while (!pilha.isEmpty() && pilha.peek() != '(') {
                        saida[k++] = pilha.pop();
                    }
                    pilha.pop();
                } else {
                    saida[k++] = val;
                }
                j++;
            }
            while (!pilha.isEmpty()) {
                saida[k++] = pilha.pop();
            }

            System.out.println("Expressao pos-fixa:");
            for (int l = 0; l < k; l++)
            {
                System.out.print(saida[l] + " ");
            }


            PilhaNum pilhanum = new PilhaNum();
            int res = 0;
            int num1 = 0;
            int num2 = 0;
            /*char[] lista1 = {'A', 'B'}; //var
            int[] lista2 = {7, 3};
            saida = {A,B,+}*/ //valor

            for (int u = 0; u < k; u++) { // k era saida.length
                if (saida[u] == '+') {
                    num2 = pilhanum.pop();
                    num1 = pilhanum.pop();
                    res = num1 + num2;
                    pilhanum.push(res);
                } else if (saida[u] == '-') {
                    num2 = pilhanum.pop();
                    num1 = pilhanum.pop();
                    res = num1 - num2;
                    pilhanum.push(res);
                } else if (saida[u] == '*') {
                    num2 = pilhanum.pop();
                    num1 = pilhanum.pop();
                    res = num1 * num2;
                    pilhanum.push(res);
                } else if (saida[u] == '/') {
                    num2 = pilhanum.pop();
                    num1 = pilhanum.pop();
                    res = num1 / num2;
                    pilhanum.push(res);
                } else if (saida[u] == '^') {
                    num2 = pilha.pop();
                    num1 = pilha.pop();
                    for (int p = 0; p < num2; p++) {
                        res *= num1;
                    }
                    pilhanum.push(res);
                } else {
                    for (int o = 0; o < var.length; o++) {
                        if (var[o] == saida[u]) {
                            pilhanum.push(valor[o]);
                        }
                    }
                }
            }

            System.out.println(res);
        }
    
