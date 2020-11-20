package com.company;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;

public class WordReporter implements IReporter{

    public void updateReport(String message) throws IOException {

        // in = how we read a file
        FileInputStream in = new FileInputStream(new File("report.docx"));
        // document = representation of an exsisting word doc.
        XWPFDocument document = new XWPFDocument(in);
        // in.close = close the file that was opened earlier.
        in.close();

        // create a paragraph
        XWPFParagraph paragraph = document.createParagraph();
        // set bold , size etc...
        XWPFRun run = paragraph.createRun();
        // insert the text.
        run.setText(message);

        // representation of report.docx
        FileOutputStream out = new FileOutputStream(new File("report.docx"));
        // writes to report.docx
        document.write(out);
        // close the file after writing.
        out.close();

    }

    public void createEmptyReport() throws IOException
    {
        XWPFDocument document = new XWPFDocument(); // word representation

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("report.docx"));

        document.write(out);
        out.close();
    }

}
