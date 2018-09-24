package pers.caijx.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 二维码解析
 * Created by caijx on 2018/9/24/024.
 */
public class ReadQRCode {

    public static void main(String[] args) {

        try {
            MultiFormatReader formatReader = new MultiFormatReader();
            File file = new File("D:" + File.separator + "code" + File.separator + "img.png");
            BufferedImage image = null;
            image = ImageIO.read(file);
            BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
            Result result = formatReader.decode(binaryBitmap,hints);
            System.out.println("解析结果：" + result.toString());
            System.out.println("二维码格式类型：" + result.getBarcodeFormat());
            System.out.println("二维码文本内容：" + result.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

    }
}
