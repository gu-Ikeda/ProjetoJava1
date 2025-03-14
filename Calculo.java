import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        char[] lista1 = {'X', 'Y','Z'};
        int[] lista2 = {2, 3,1};
        char[] lista3 = {'X', 'Y','Z', '-','+'}; 
        
        for (int i = 0; i < lista3.length; i++)
        {
            if (lista3[i] == '+')
            {
                
                num2 = pilha.pop();  
                num1 = pilha.pop();  
                res = num1 + num2;
                pilha.push(res);
            }
            else if (lista3[i] == '-')
            {
                num2 = pilha.pop();
                num1 = pilha.pop();
                res = num1 - num2;
                pilha.push(res);
            }
            else
            {
                for (int j = 0; j < lista1.length; j++) {
                    if (lista1[j] == lista3[i]) {
                        pilha.push(lista2[j]);  
                    }
                }
            }
        }

        System.out.println(res); 
        System.out.println(pilha.pop());
    }
}
