package com.company;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;

public class WordParagraphReporter extends WordAbstractReporter{

    @Override
    protected void implementUpdateReport(XWPFDocument document, FileDetails fileDetails) {

        // create a paragraph
        XWPFParagraph paragraph = document.createParagraph();
        // set bold , size etc...
        XWPFRun run = paragraph.createRun();
        // insert the text.
        run.setText(fileDetails.getFirst() + fileDetails.getSecond() + fileDetails.getThird());
    }

}