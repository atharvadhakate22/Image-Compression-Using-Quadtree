import java.io.IOException;
import java.util.Scanner;
import util.CompressImage;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter local image path: ");
        String path = sc.nextLine();
        System.out.print("Enter threshold: ");
        float threshold = sc.nextFloat();
        System.out.println();

        try {
            System.out.println("Reading local image...");
            CompressImage cimg = new CompressImage(path, threshold);
            System.out.println("Done.");

            System.out.println("Compressing image...");
            cimg.build();
            System.out.println("Done.");

            System.out.print("Enter output path: ");
            sc.nextLine();
            String outputPath = sc.nextLine();

            try {
                System.out.println("Saving compressed image...");
                cimg.saveCompressed(outputPath);
                System.out.println("Done.");

                // Display compression info
                System.out.println("\nCompression Information:");
                cimg.displayCompressionInfo();
            } catch (Exception e) {
                System.out.println("\nError when saving image. Ensure that entered path exists or is correct!");
            }

        } catch (Exception e) {
            System.out.println("\nError when reading image. Ensure that entered path exists or is correct!");
        }
        sc.close();
    }
}
