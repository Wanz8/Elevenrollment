package test.utils;

import com.google.common.io.Files;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import persistence.Utils.Main;

public class TestUtils {
    private static final File DB_SRC = new File("src/main/assets/db/SC.script");

    @NotNull
    public static File copyDB() throws IOException {
        final File target = File.createTempFile("temp-db", ".script");
        Files.copy(DB_SRC, target);
        Main.setDBPathName(target.getAbsolutePath().replace(".script", ""));
        return target;
    }
}
