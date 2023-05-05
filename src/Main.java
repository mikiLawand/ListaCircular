public class Main {
    public static void main(String[] args) {
        
        ListaCircular<String> minhListaCircular = new ListaCircular<>();

        minhListaCircular.add("P1");
        System.out.println(minhListaCircular);

        minhListaCircular.remove(0);
        System.out.println(minhListaCircular);

        minhListaCircular.add("P2");
        System.out.println(minhListaCircular);

        minhListaCircular.add("P3");
        System.out.println(minhListaCircular);

        System.err.println(minhListaCircular.get(2));
    }
}
