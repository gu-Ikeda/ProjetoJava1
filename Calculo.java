import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        char[] lista1 = {'A','B','C','D','E'};
        int[] lista2 = {7,3,6,4,9};
        char[] lista3 = {'A','B','+','C','D','-','/','E','*'}; 
        
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
            else if(lista3[i] == '*')
            {
                num2 = pilha.pop();
                num1 = pilha.pop();
                res = num1 * num2;
                pilha.push(res);
            }
            else if(lista3[i] == '/')
            {
                num2 = pilha.pop();
                num1 = pilha.pop();
                res = num1/num2;
                pilha.push(res);
            }
            else if(lista3[i] == '^')
            {
                num2 = pilha.pop();
                num1 = pilha.pop();
                for(int k = 0;k<num2;k++)
                {
                    res *= num1;
                }   
                pilha.push(res);
            }
            else
            {
                for (int j = 0; j < lista1.length; j++) 
                {
                    if (lista1[j] == lista3[i]) 
                    {
                        pilha.push(lista2[j]);  
                    }
                }
            }
        }

        System.out.println(res); 
        System.out.println(pilha.pop());
    }
}
