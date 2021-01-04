import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Main {
    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите информацию QR-кода:");
        String qrCodeText = scanner.nextLine();
        System.out.println("Введите название файла:");
        String filePath = "E:/Java study/qr/" + scanner.nextLine() + ".png";
        scanner.close();


        File qrFile = new File(filePath);
        boolean mkdirs = qrFile.mkdirs();
        if (mkdirs) {
            generateQRCodeImage(qrCodeText, qrFile);
            System.out.println("Готово");
        } else System.out.println("Ошибка создания директории");
    }

    public static void generateQRCodeImage(String barcodeText, File qrFile) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        ImageIO.write(image, "png", qrFile);
    }

}
