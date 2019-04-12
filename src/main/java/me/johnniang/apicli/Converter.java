package me.johnniang.apicli;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

/**
 * Project converter.
 *
 * @author johnniang
 * @date 11/4/19
 */
@Slf4j
public class Converter {

    public static void main(String[] args) throws IOException {
        String workDir = System.getProperty("user.dir");
        Path workPath = Paths.get(workDir);
        Path sourcePath = Paths.get(workDir, "src");
        // Get all java file and modify the package name

        log.debug("Work directory: [{}]", workPath);
        log.debug("Source directory: [{}]", sourcePath);

        log.debug("Walking work directory...");
        Files.walk(workPath).forEach(path -> log.debug(path.toString()));

        log.debug("Walking work directory tree...");
        Files.walkFileTree(workPath,
                new SimpleFileVisitor<Path>() {
                }).forEach(path -> log.debug(path.toString()));

        log.debug("Walking source directory...");
        Files.walk(sourcePath).forEach(path -> log.debug(path.toString()));
    }
}