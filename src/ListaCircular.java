public class ListaCircular<T> {
    
    private No<T> cabeça;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cabeça = null;
        this.cauda = null;
        this.tamanhoLista = 0;
        //inicializando a lista circular 
    }

    //adiciona elementos a lista
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo); //inicializa o novo no na lista conteudo
        if(tamanhoLista == 0){
        //se a lista estiver vazia
            this.cabeça = novoNo; //o novo no se torna a cabeça
            this.cauda = this.cabeça; //e a cabeça também se torna a cauda
            this.cabeça.setNoProximo(this.cauda); //e a cabeça seta o proximo elemento 
        } else {
        //se já existirem elementos na lista
            novoNo.setNoProximo(this.cauda); //o novo no é adicinado pela cauda
            this.cabeça.setNoProximo(novoNo);//e a cabeça aponta para o prox no
            this.cauda = novoNo; //o novo no se torna a cauda 
        }
        this.tamanhoLista++; //o tamanho da lista é imcrementado
    }

    //remove elementos da lista
    public void remove(int index){
        if(index >= this.tamanhoLista)
           throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista ");

           No<T> noAuxiliar = cauda; //seta o no auxilar como a cauda
           if(index == 0){ 
           //se o index for 0 
            this.cauda = this.cauda.getNoProximo(); //o primeiro elemento da lista é removido
            this.cabeça.setNoProximo(cauda); //e a cabeça faz uma referencia a cauda 
           }else if(index == 1){
            //caso,o index for 1 
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
            //o segundo elemento é removido da lista 
           }else{ 
            //em qualquer outro caso,
            for(int i = 0; i < index-1; i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            //a lista é percorrida de trás para frente
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
           }
           this.tamanhoLista--; //o tamanho da lista é decrementado
    }

    //retorna o conteudo armazenado atraves de sua posição na lista
    public T get(int index){
        return getNo(index).getConteudo();
    }

    
    private No<T> getNo(int index){
        if(isEmpty())
        throw new IndexOutOfBoundsException("A lista está vazia");
        //se o index estiver vazio uma exceção é lançada

        if(index == 0){
            return this.cauda;
        //se o index for 0, a lista retorna a cauda da lista 
        }

        No<T> noAuxiliar = this.cauda; //seta o no auxilar como a cauda
        for(int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        //incremento para percorrer a lista 
        }
        return noAuxiliar;
    }

    //verifica se a lista está vazia 
    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }

    //retorna o tamanho da lista 
    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for(int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() +"}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += size() != 0 ? "(Retorna ao início)" : "[]";
        return strRetorno;
    }
}
