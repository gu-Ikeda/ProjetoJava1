public class Pilha{
    private int Tam_Default = 100;
    private int topoPilha;
    private char pilha[];

    public Pilha(){
        this.pilha = new char[Tam_Default];
        this.topoPilha = -1;
    }

    public boolean isEmpty(){
        return this.topoPilha == -1;
    }
    public char peek(){
        return this.pilha[this.topoPilha];
    }

    public void push(char i){
        this.pilha[++this.topoPilha] = i;
    }

    public char pop(){
        return this.pilha[this.topoPilha--];
    }
}
