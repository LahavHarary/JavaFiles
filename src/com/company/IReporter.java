package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IReporter {

    public void updateReport(FileDetails fileDetails) throws IOException;

    public void createEmptyReport() throws IOException;

}
