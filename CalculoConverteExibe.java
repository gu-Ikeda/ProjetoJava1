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
