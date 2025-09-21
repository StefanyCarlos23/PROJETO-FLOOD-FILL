public class Pilha {
    private Pixel[] dados;
    private int topo;

    public Pilha(int capacidade) {
        dados = new Pixel[capacidade];
        topo = -1;
    }

    public void empilhar(Pixel p) {
        if (topo < dados.length - 1) {
            dados[++topo] = p;
        }
    }

    public Pixel desempilhar() {
        if (!vazia()) {
            return dados[topo--];
        }
        return null;
    }

    public boolean vazia() {
        return topo == -1;
    }
}
