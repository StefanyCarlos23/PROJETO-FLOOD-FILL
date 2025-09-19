import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ImageHandler imageHandler = new ImageHandler();
        BufferedImage image = null;

        try {
            image = imageHandler.load("Silksong.png");
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem.");
            return;
        }

        int width = image.getWidth();
        int height = image.getHeight();

        // Escolhe ponto inicial
        int x = 0, y = 0;
        System.out.print("Digite a coordenada X inicial (0 a " + (width - 1) + "): ");
        x = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite a coordenada Y inicial (0 a " + (height - 1) + "): ");
        y = Integer.parseInt(scanner.nextLine());

        // Escolhe estrutura
        System.out.println("Escolha a estrutura:");
        System.out.println("1 - Pilha (Stack)");
        System.out.println("2 - Fila (Queue)");
        int opcao = Integer.parseInt(scanner.nextLine());

        // Cria nova instância do flood fill
        FloodFill floodFill = new FloodFill(image, Color.RED); // ou outra cor

        try {
            if (opcao == 1) {
                System.out.println("Executando Flood Fill com Pilha...");
                floodFill.floodWithStack(x, y);
            } else {
                System.out.println("Executando Flood Fill com Fila...");
                floodFill.floodWithQueue(x, y);
            }
        } catch (Exception e) {
            System.err.println("Erro ao executar o flood fill.");
            e.printStackTrace();
        }

        System.out.println("Concluído. Imagens salvas na pasta 'frames/'.");
    }
}