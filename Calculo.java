import java.util.Stack;

public class Main
{
	public static void main(String[] args) {
	    Stack<Integer> pilha = new Stack<>();
	    int res = 0;
		char[] lista1 = {'X','Y'};
		int[] lista2 = {2,3};
		char[] lista3 = {'X','Y','+'};
		for(int i = 0; i<lista3.length;i++)
		{
		    for(int j = 0;j<lista1.length;j++)
		    {
		        if(lista1[i] ==  lista3[j])
		        {
		            pilha.push(lista2[j]);
		        }
		        else if(lista3[i] == '+')
		        {
		            res = pilha.pop();
		            res = pilha.pop();
		        }
		        
		    }
		}
		System.out.println(res);
	}
}

/*
import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        int res = 0;
        char[] lista1 = {'X', 'Y'};
        int[] lista2 = {2, 3};
        char[] lista3 = {'X', 'Y', '+'};  // Esta lista tem os elementos a serem processados

        for (int i = 0; i < lista3.length; i++) {
            if (lista3[i] == '+') {
                // Se encontrar um '+', soma os dois últimos elementos da pilha
                int num2 = pilha.pop();  // Pega o primeiro elemento
                int num1 = pilha.pop();  // Pega o segundo elemento
                res = num1 + num2;  // Soma os dois
            } else {
                // Se o caractere não for '+', verifica se corresponde a 'X' ou 'Y'
                for (int j = 0; j < lista1.length; j++) {
                    if (lista1[j] == lista3[i]) {
                        pilha.push(lista2[j]);  // Empilha o número correspondente
                    }
                }
            }
        }

        System.out.println(res);  // Exibe o resultado
    }
}
*/
