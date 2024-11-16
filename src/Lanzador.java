import java.io.File;
import java.io.IOException;

public class Lanzador {
    public static void main(String[] args) {
        String classPath = System.getProperty("java.class.path");

        ProcessBuilder p1 = new ProcessBuilder("java", "-cp",classPath,"Principal","Pepe","Juan","Luis");
        p1.redirectOutput(new File("examen1.txt"));
        p1.redirectError(new File("error1.txt"));

        ProcessBuilder p2 = new ProcessBuilder("java", "-cp",classPath,"Principal","Rosa","Miguel","Pedro");
        p2.redirectOutput(new File("examen2.txt"));
        p2.redirectError(new File("error2.txt"));

        try {
            Process pro1 = p1.start();
            Process pro2 = p2.start();

            pro1.waitFor();
            pro2.waitFor();
        } catch (IOException e) {
            System.out.println("Error de IO");
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido!");
        }
    }
}
