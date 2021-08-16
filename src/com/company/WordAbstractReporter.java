package com.company;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class WordAbstractReporter implements IReporter{

    public void updateReport(FileDetails fileDetails) throws IOException
    {
        // in = how we read a file
        FileInputStream in = new FileInputStream(new File("report.docx"));
        // document = representation of an exsisting word doc.
        XWPFDocument document = new XWPFDocument(in);
        // in.close = close the file that was opened earlier.
        in.close();

        implementUpdateReport(document, fileDetails);

        // representation of report.docx
        FileOutputStream out = new FileOutputStream(new File("report.docx"));
        // writes to report.docx
        document.write(out);
        // close the file after writing.
        out.close();
    }

    protected abstract void implementUpdateReport(XWPFDocument document, FileDetails fileDetails);

    public void createEmptyReport() throws IOException
    {
        XWPFDocument document = new XWPFDocument(); // word representation

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("report.docx"));

        document.write(out);
        out.close();
    }


}
