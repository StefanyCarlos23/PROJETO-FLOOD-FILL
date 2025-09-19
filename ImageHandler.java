import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {

    public BufferedImage load(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public void save(BufferedImage image, String path) throws IOException {
        ImageIO.write(image, "png", new File(path));
    }

    public void saveStep(BufferedImage image, int frameNumber) throws IOException {
        String path = String.format("frames/frame_%04d.png", frameNumber);
        save(image, path);
    }

    public void prepareFramesFolder() {
        File folder = new File("frames");
        if (!folder.exists()) {
            folder.mkdir();
        }
    }
}