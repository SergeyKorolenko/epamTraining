package by.epam.task4.validator;

import java.io.File;

public class FileValidator {

    public boolean isFile(File file) {
        if(file != null && file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }
}
