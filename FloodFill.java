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
        imageHandler.prepareFramesFolder();
    }

    public void floodWithStack(int startX, int startY) throws Exception {
        int targetColor = image.getRGB(startX, startY);
        if (targetColor == newColorRgb) return;

        Stack stack = new Stack(width * height);
        stack.push(new Pixel(startX, startY));

        while (!stack.isEmpty()) {
            Pixel p = stack.pop();
            if (isValid(p.x, p.y, targetColor)) {
                image.setRGB(p.x, p.y, newColorRgb);
                pixelCounter++;

                if (pixelCounter % 200 == 0) {
                    frameCounter++;
                    imageHandler.saveStep(image, frameCounter);
                }

                stack.push(new Pixel(p.x + 1, p.y));
                stack.push(new Pixel(p.x - 1, p.y));
                stack.push(new Pixel(p.x, p.y + 1));
                stack.push(new Pixel(p.x, p.y - 1));
            }
        }

        // Salva imagem final
        imageHandler.save(image, "Silksong_result_stack.png");
    }

    public void floodWithQueue(int startX, int startY) throws Exception {
        int targetColor = image.getRGB(startX, startY);
        if (targetColor == newColorRgb) return;

        Queue queue = new Queue(width * height);
        queue.enqueue(new Pixel(startX, startY));

        while (!queue.isEmpty()) {
            Pixel p = queue.dequeue();
            if (isValid(p.x, p.y, targetColor)) {
                image.setRGB(p.x, p.y, newColorRgb);
                pixelCounter++;

                if (pixelCounter % 200 == 0) {
                    frameCounter++;
                    imageHandler.saveStep(image, frameCounter);
                }

                queue.enqueue(new Pixel(p.x + 1, p.y));
                queue.enqueue(new Pixel(p.x - 1, p.y));
                queue.enqueue(new Pixel(p.x, p.y + 1));
                queue.enqueue(new Pixel(p.x, p.y - 1));
            }
        }

        // Salva imagem final
        imageHandler.save(image, "Silksong_result_queue.png");
    }

    private boolean isValid(int x, int y, int targetColor) {
        return x >= 0 && y >= 0 && x < width && y < height && image.getRGB(x, y) == targetColor;
    }
}