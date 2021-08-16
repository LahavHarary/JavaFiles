package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;


public class FilesPractice {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        ConfigObject config = ConfigParsingUtils.getConfig();
        IFileSender fileSender = new FileSender(config.get_listeningPath(), config.get_destPath());
        IFilesExtractor filesExtractor = new FilesExtractor(config.get_listeningPath());
        IImageFilter imageFilter = new ImageFilter(config.get_listeningPath());
        IReporter reporter = new WordTableReporter();

        FlowManager flowManager = new FlowManager(fileSender, filesExtractor,
                config.get_sleepTime(),imageFilter, config.get_color(),reporter,config.get_checkFileForVirus());


        flowManager.start();
        int stop = input.nextInt();
        flowManager.stop();

    }

}

