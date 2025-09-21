import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {

    public BufferedImage carregar(String caminho) throws IOException {
        return ImageIO.read(new File(caminho));
    }

    public void salvar(BufferedImage img, String caminho) throws IOException {
        ImageIO.write(img, "png", new File(caminho));
    }

    public void salvarPasso(BufferedImage img, int numeroFrame) throws IOException {
        String caminho = "frames/frame_" + numeroFrame + ".png";
        salvar(img, caminho);
    }

    public void prepararPastaFrames() {
        File pasta = new File("frames");
        if (!pasta.exists()) {
            pasta.mkdir();
        }
    }
}
