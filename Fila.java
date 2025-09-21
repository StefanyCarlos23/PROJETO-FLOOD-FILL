public class Fila {
    private Pixel[] dados;
    private int frente, tras, tamanho;

    public Fila(int capacidade) {
        dados = new Pixel[capacidade];
        frente = 0;
        tras = -1;
        tamanho = 0;
    }

    public void enfileirar(Pixel p) {
        if (tamanho < dados.length) {
            tras = (tras + 1) % dados.length;
            dados[tras] = p;
            tamanho++;
        }
    }

    public Pixel desenfileirar() {
        if (vazia()) return null;
        Pixel p = dados[frente];
        frente = (frente + 1) % dados.length;
        tamanho--;
        return p;
    }

    public boolean vazia() {
        return tamanho == 0;
    }
}
