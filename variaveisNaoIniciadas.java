public class Main {
    public static void main(String[] args) {
        char[] V = {};
        char[] E = {'A', '+', 'B'};
        int cont = 0;

        for (int i = 0; i < E.length; i++) {
            boolean encontrado = false; // Flag para verificar se o caractere está em V

            for (int j = 0; j < V.length; j++) {
                if (V[j] == E[i]) {
                    cont++;
                    encontrado = true; // Marcamos que o caractere foi encontrado
                    break; // Não precisa continuar verificando
                }
            }

            // Se não foi encontrado e não é um operador, exibir erro
            if (!encontrado && E[i] != '+' && E[i] != '-' && E[i] != '*' && 
                E[i] != '/' && E[i] != '^' && E[i] != '(' && E[i] != ')') {
                System.out.println("Variável " + E[i] + " não iniciada");
            }
        }

        System.out.println("Contador: " + cont);
    }
}
