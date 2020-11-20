package com.company;

public class FileEmailSender implements IFileSender {

    private String _fileSrc;

    public FileEmailSender(String src)
    {
        _fileSrc = src;
    }

    @Override
    public void send(String fileName, String extension) {
        System.out.println("Sending Email");
    }
}
