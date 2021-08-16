package com.company;

import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordTableReporter extends WordAbstractReporter {

    protected void implementUpdateReport(XWPFDocument document, FileDetails fileDetails) {


        if (document.getTables().size() == 0) {

            //create first table
            XWPFTable table = document.createTable();
            XWPFTableRow tableRowOne = table.getRow(0);

            XWPFParagraph paragraph = tableRowOne.getCell(0).addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    24, "CC00FF", "File name",true,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            paragraph = tableRowOne.addNewTableCell().addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    24, "CC00FF", "Action",true,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            paragraph = tableRowOne.addNewTableCell().addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    24, "CC00FF", "Color",true,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);
        }

        if(fileDetails.getSuspiciousLevel() == SuspiciousLevel.virus)
        {
            // COLOR RED

            //create table
            XWPFTable table = document.createTable();
            XWPFTableRow tableRowOne = table.getRow(0);

            XWPFParagraph paragraph = tableRowOne.getCell(0).addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    11, "FF0000", fileDetails.getFirst(),false,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            paragraph = tableRowOne.addNewTableCell().addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    11, "FF0000", fileDetails.getSecond(),false,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            paragraph = tableRowOne.addNewTableCell().addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    11, "FF0000", fileDetails.getThird(),false,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);

        }
        else if(fileDetails.getSuspiciousLevel() == SuspiciousLevel.suspicious)
        {
            // COLOR YELLOW

            //create table
            XWPFTable table = document.createTable();
            XWPFTableRow tableRowOne = table.getRow(0);

            XWPFParagraph paragraph = tableRowOne.getCell(0).addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    11, "FFFF00", fileDetails.getFirst(),false,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            paragraph = tableRowOne.addNewTableCell().addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    11, "FFFF00", fileDetails.getSecond(),false,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            paragraph = tableRowOne.addNewTableCell().addParagraph();
            setRun(paragraph.createRun(),"Arial",
                    11, "FFFF00", fileDetails.getThird(),false,false );
            paragraph.setAlignment(ParagraphAlignment.CENTER);
        }
        else
        {
            //create table
            XWPFTable table = document.createTable();
            XWPFTableRow tableRowOne = table.getRow(0);
            tableRowOne.getCell(0).setText(fileDetails.getFirst());
            tableRowOne.addNewTableCell().setText(fileDetails.getSecond());
            tableRowOne.addNewTableCell().setText(fileDetails.getThird());
        }


    }

    private static void setRun (XWPFRun run , String fontFamily , int fontSize , String colorRGB , String text , boolean bold , boolean addBreak) {
        run.setFontFamily(fontFamily);
        run.setFontSize(fontSize);
        run.setColor(colorRGB);
        run.setText(text);
        run.setBold(bold);
        if (addBreak) run.addBreak();
    }

}
