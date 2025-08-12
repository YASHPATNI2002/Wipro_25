package com.wipro.menudemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {
    public static void main(String[] args) {
        String imagePath = "C:\\Users\\User\\Downloads\\board_certificate.pdf";
        String copyimgPath = "C:\\Users\\User\\Downloads\\boardcertificate_copy.pdf";

        try (
            FileInputStream fis = new FileInputStream(imagePath);
            FileOutputStream fos = new FileOutputStream(copyimgPath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied ");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
