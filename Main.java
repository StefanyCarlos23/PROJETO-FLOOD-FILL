import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ImageHandler imageHandler = new ImageHandler();
        BufferedImage image = null;

        try {
            image = imageHandler.carregar("Silksong.png");
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem.");
            return;
        }

        int width = image.getWidth();
        int height = image.getHeight();

        System.out.print("Digite X inicial (0 a " + (width-1) + "): ");
        int x = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite Y inicial (0 a " + (height-1) + "): ");
        int y = Integer.parseInt(scanner.nextLine());

        System.out.println("Escolha estrutura (1 - Pilha, 2 - Fila): ");
        int opcao = Integer.parseInt(scanner.nextLine());

        FloodFill flood = new FloodFill(image, Color.RED);

        try {
            if (opcao == 1) {
                System.out.println("Ok, vamos usar a pilha...");
                flood.floodComPilha(x, y);
            } else {
                System.out.println("Beleza, vamos usar a fila...");
                flood.floodComFila(x, y);
            }
        } catch (Exception e) {
            System.err.println("Deu ruim ao executar flood fill.");
            e.printStackTrace();
        }

        System.out.println("Concluído. Imagens salvas na pasta 'frames/'.");
    }
}
