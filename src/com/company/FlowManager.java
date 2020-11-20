package com.company;

import java.io.IOException;
import java.util.Scanner;

public class FlowManager implements Runnable {

    private IFilesExtractor _filesExtractor;
    private IFileSender _fileSender;
    private long _sleepTime;
    private volatile boolean _go;
    private Thread _thread;
    private IImageFilter _imageFilter;
    private String _color;
    private IReporter _reporter;

    public FlowManager(IFileSender fileSender, IFilesExtractor filesExtractor,
                       long sleepTime, IImageFilter imageFilter, String color, IReporter reporter) {
        _filesExtractor = filesExtractor;
        _fileSender = fileSender;
        _sleepTime = sleepTime;
        _go = true;
        _thread = new Thread(this);
        _imageFilter = imageFilter;
        _color = color;
        _reporter = reporter;
    }

    public void start() {
        _thread.start();
    }

    public void stop() {
        _thread.interrupt();
        _go = false;
    }

    @Override
    public void run() {

        try {
            _reporter.createEmptyReport();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (_go) {

            String[] files = _filesExtractor.returnFiles();
            String fileExt;

            for (int i = 0; i < files.length; i++) {

                fileExt = ExtensionUtils.getFileExtension(files[i]);

                if (ExtensionUtils.isImg(fileExt))
                {

                    _imageFilter.filterImage(files[i], _color);
                    _fileSender.send(files[i], fileExt);
                    try {
                        _reporter.updateReport(files[i] + " was painted by color: " + _color);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                else
                {
                    _fileSender.send(files[i], fileExt);
                    try {
                        _reporter.updateReport(files[i] + " was sent");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(_sleepTime);
            } catch (InterruptedException e) {

            }

        }
    }
}
