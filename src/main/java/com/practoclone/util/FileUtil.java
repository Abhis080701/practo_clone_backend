package com.practoclone.util;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileUtil {


    private static final List<String> ALLOWED_IMAGE_TYPES = List.of("image/jpeg", "image/png", "image/gif", "image/webp");

    public static MultipartFile convertPathToMultipart(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) return null;

        File file = new File(filePath);
        FileInputStream input = new FileInputStream(file);

        String mimeType = Files.probeContentType(file.toPath());

      
        if (mimeType == null || !ALLOWED_IMAGE_TYPES.contains(mimeType)) {
            throw new IOException("Invalid file type. Only images (JPG, PNG, GIF, WEBP) are allowed.");
        }

        return new MockMultipartFile(
                "imageFile",     // Field name
                file.getName(),  // Original file name
                mimeType,        // Validated MIME type
                input           // File content
        );
    }
}

