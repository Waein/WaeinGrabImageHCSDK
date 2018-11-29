package com.waein.client.main.java.com.waein.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: ImageUtils, v 0.1
 * @CreateDate 2018/11/23
 * @CreateTime 13:11
 * @GitHub https://github.com/Waein
 * ===================================
 */
public class ImageUtils {
    public static boolean saveToFile(BufferedImage bufferedImage, String path, String fileName, String imageType) throws IOException {
        if (bufferedImage == null || path == null) {
            return false;
        }
        if (!path.endsWith("/")) {
            path += "/";
        }
        File file = new File(path + fileName + "." + imageType);
        ImageIO.write(bufferedImage, imageType, file);
        return true;
    }

    /**
     * @param bufferedImage
     * @return
     * @author WangRupeng
     */
    public static byte[] decodeToPixels(BufferedImage bufferedImage) {
        if (bufferedImage == null)
            return null;
        return ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
    }
}
