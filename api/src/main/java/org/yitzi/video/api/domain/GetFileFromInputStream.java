package org.yitzi.video.api.domain;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GetFileFromInputStream {

    private final static String TEMP_FILE_BASE_PATH = "/var/videouploader/temp/";

    public File getFileFromInputStream(InputStream file, String fileName) {
        File scratchFile = createScratchFile(fileName);
        try {
            FileUtils.copyInputStreamToFile(file, scratchFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                file.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return scratchFile;
    }

    private File createScratchFile(String fileName) {
        File scratchFile;
        try {
            scratchFile = File.createTempFile("upload", getFileSuffix(fileName), null);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
        return scratchFile;
    }

    private String getFileSuffix(String filename) {
        if (filename != null) {
            int a = filename.lastIndexOf('.');
            if (a > 0)
                return filename.substring(a).toLowerCase();
        }
        return null;
    }
}
