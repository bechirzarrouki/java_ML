package org.example;

import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import org.opencv.core.Core;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // Set the OpenCV library path programmatically
            System.setProperty("java.library.path", "C:\\Users\\godsliker\\IdeaProjects\\JAVA_ML2\\src\\opencv\\build\\java\\x64");

            // Load the OpenCV native library
            System.loadLibrary("opencv_java490");

            // Check if OpenCV was loaded successfully
            if (Core.getBuildInformation() != null) {
                System.out.println("OpenCV version: " + Core.VERSION);
            } else {
                System.err.println("Failed to load OpenCV.");
                return;
            }

            // Specify the path to your image
            String imagePath = "src/bechir.jpg"; // Replace with the correct image path
            System.out.println("Loading image from path: " + Paths.get(imagePath).toAbsolutePath());

            // Try loading the image
            Image img = ImageFactory.getInstance().fromFile(Paths.get(imagePath));

            // If the image is loaded successfully
            System.out.println("Image loaded successfully");

        } catch (Exception e) {
            // If there is an error during image loading
            e.printStackTrace(); // This will provide more detailed error information
            System.err.println("Error loading image: " + e.getMessage());
        }
    }
}
