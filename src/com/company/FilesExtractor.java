package com.company;

import java.io.File;
import java.nio.file.Path;

public class FilesExtractor implements IFilesExtractor{

    private File _routeToFiles;

    public FilesExtractor(String listeningPath){

        _routeToFiles = new File(listeningPath);

    }

    @Override
    public String[] returnFiles() {

        return _routeToFiles.list();

    }
}
