package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Bitmap {
    private String Inputf,OutPutf;
    public String TransformerMethod;


    public Bitmap(String inputf, String outPutf, String transformerMethod,int rotationDegree_OR_pixelSize)  {
        Inputf = inputf;
        this.OutPutf = outPutf;
        TransformerMethod = transformerMethod;
switch (transformerMethod){
    case "BlackAndWhite":
        BlackAndWhite();break;
    case "PixiLate" :
        PixiLate(rotationDegree_OR_pixelSize);
        ;break;
    case "Rotate" :
        Rotate(rotationDegree_OR_pixelSize);break;
default:
    System.out.println("The Method is not exists");

}
    }


    public Bitmap(String inputf, String outPutf, String transformerMethod) {
        Inputf = inputf;
        OutPutf = outPutf;
        TransformerMethod = transformerMethod;
        switch (transformerMethod){
            case "BlackAndWhite":
                BlackAndWhite();break;
            case "PixiLate" :
                PixiLate(10);
                ;break;
            case "Rotate" :
                Rotate(180);break;
            default:
                System.out.println("The Method is not exists");

        }
    }

    public int BlackAndWhite(){

        try{
            File file = new File(Inputf);
            BufferedImage bufferedImage = ImageIO.read(file);
            BufferedImage output = new BufferedImage(bufferedImage.getWidth(),bufferedImage.getHeight(),BufferedImage.TYPE_BYTE_BINARY);
            Graphics2D graphics = output.createGraphics();
            graphics.drawImage(bufferedImage,0,0,bufferedImage.getWidth(),bufferedImage.getHeight(),null);
            File out= new File(OutPutf);
            ImageIO.write(output,"bmp",out);

            System.out.println("done");
            return 1;
        }catch (IOException e ){
            System.out.println( "Some error found " +e);
        }
return 0;
    }


    public int Rotate(double rotationDegree){
         double toRadius = Math.toRadians(rotationDegree);
        try{
            File file = new File(Inputf);
            BufferedImage bufferedImage = ImageIO.read(file);
            BufferedImage output = new BufferedImage(bufferedImage.getWidth(),bufferedImage.getHeight(), bufferedImage.getType());
            Graphics2D graphics = output.createGraphics();
           graphics.rotate(toRadius,bufferedImage.getWidth()/2,bufferedImage.getHeight()/2);
           graphics.drawImage(bufferedImage,0,0,null);
            File out= new File(OutPutf);
            ImageIO.write(output,"bmp",out);
            System.out.println("done");
            return 1;
        }catch (IOException e ){
            System.out.println( "Some error found " +e);
        }
        return 0;

    }

    public int PixiLate(int pixelSize){

        try{
            File file = new File(Inputf);
            BufferedImage bufferedImage = ImageIO.read(file);
            BufferedImage output = new BufferedImage(bufferedImage.getWidth(),bufferedImage.getHeight(), bufferedImage.getType());
            Graphics2D graphics = output.createGraphics();
            for(int w = 0 ; w < bufferedImage.getWidth() ; w+=pixelSize)
            {
                for(int h = 0 ; h < bufferedImage.getHeight() ; h+=pixelSize)
                {
                    Color pixelColor = new Color(bufferedImage.getRGB(w, h));
                    graphics.setColor(pixelColor);
                    graphics.fillRect(w, h, pixelSize, pixelSize);
                }
            }
     File out= new File(OutPutf);
            ImageIO.write(output,"bmp",out);
            System.out.println("done");
            return 1;
        }catch (IOException e ){
            System.out.println( "Some error found " +e);
        }

return 0;
    }


}
