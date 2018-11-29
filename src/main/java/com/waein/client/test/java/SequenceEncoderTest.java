package com.waein.client.test.java;

import org.jcodec.api.awt.SequenceEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SequenceEncoderTest {

    List<BufferedImage> images = new ArrayList<BufferedImage>();

    public SequenceEncoderTest() {
        String path = "/Users/SeungRi/Work/workspace/GrabImageHCDK/data/img";
        File file = new File(path);
        try {
            for (File f : file.listFiles()) {
                BufferedImage image = ImageIO.read(f);
                this.images.add(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void encodeToVideoFile() {
        try {
            SequenceEncoder enc = new SequenceEncoder(new File("/Users/SeungRi/Work/workspace/GrabImageHCDK/data/temp.h264"));
            // GOP size will be supported in 0.2
            // enc.getEncoder().setKeyInterval(25);
            for (BufferedImage image : images) {
                //BufferedImage image = ... // Obtain an image to encode
                enc.encodeImage(image);
                //Picture picture = new Picture();
                //enc.encodeNativeFrame();
            }
            enc.finish();
        } catch (Exception e) {

        }
    }
}
