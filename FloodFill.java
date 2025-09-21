import java.awt.image.BufferedImage;
import java.awt.Color;

public class FloodFill {
    private BufferedImage image;
    private int width, height;
    private int newColorRgb;
    private int frameCounter = 0;
    private int pixelCounter = 0;
    private ImageHandler imageHandler;

    public FloodFill(BufferedImage img, Color newColor) {
        this.image = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.newColorRgb = newColor.getRGB();
        this.imageHandler = new ImageHandler();
        imageHandler.prepararPastaFrames();
    }

    public void floodComPilha(int xInicial, int yInicial) throws Exception {
        int corAlvo = image.getRGB(xInicial, yInicial);
        if (corAlvo == newColorRgb) return;

        Pilha pilha = new Pilha(width * height);
        pilha.empilhar(new Pixel(xInicial, yInicial));

        while (!pilha.vazia()) {
            Pixel p = pilha.desempilhar();
            if (estaValido(p.x, p.y, corAlvo)) {
                image.setRGB(p.x, p.y, newColorRgb);
                pixelCounter++;

                if (pixelCounter % 250 == 0) {
                    frameCounter++;
                    imageHandler.salvarPasso(image, frameCounter);
                }

                pilha.empilhar(new Pixel(p.x + 1, p.y));
                pilha.empilhar(new Pixel(p.x - 1, p.y));
                pilha.empilhar(new Pixel(p.x, p.y + 1));
                pilha.empilhar(new Pixel(p.x, p.y - 1));
            }
        }

        imageHandler.salvar(image, "resultado_pilha.png");
    }

    public void floodComFila(int xInicial, int yInicial) throws Exception {
        int corAlvo = image.getRGB(xInicial, yInicial);
        if (corAlvo == newColorRgb) return;

        Fila fila = new Fila(width * height);
        fila.enfileirar(new Pixel(xInicial, yInicial));

        while (!fila.vazia()) {
            Pixel p = fila.desenfileirar();
            if (estaValido(p.x, p.y, corAlvo)) {
                image.setRGB(p.x, p.y, newColorRgb);
                pixelCounter++;

                if (pixelCounter % 250 == 0) {
                    frameCounter++;
                    imageHandler.salvarPasso(image, frameCounter);
                }

                fila.enfileirar(new Pixel(p.x + 1, p.y));
                fila.enfileirar(new Pixel(p.x - 1, p.y));
                fila.enfileirar(new Pixel(p.x, p.y + 1));
                fila.enfileirar(new Pixel(p.x, p.y - 1));
            }
        }

        imageHandler.salvar(image, "resultado_fila.png");
    }

    private boolean estaValido(int x, int y, int corAlvo) {
        return x >= 0 && y >= 0 && x < width && y < height && image.getRGB(x, y) == corAlvo;
    }
}
