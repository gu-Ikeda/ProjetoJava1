public class PilhaNum {
    private int Tam_Default = 100;
    private int topoPilha;
    private int pilhanum[];

    public PilhaNum(){
        this.pilhanum = new int[Tam_Default];
        this.topoPilha = -1;
    }

    public boolean isEmpty(){
        return this.topoPilha == -1;
    }
    public int peek(){
        return this.pilhanum[this.topoPilha];
    }

    public void push(int i){
        this.pilhanum[++this.topoPilha] = i;
    }

    public int pop(){
        return this.pilhanum[this.topoPilha--];
    }
}
