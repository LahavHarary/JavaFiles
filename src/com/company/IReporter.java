package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IReporter {

    public void updateReport(String message) throws IOException;

    public void createEmptyReport() throws IOException;

}
