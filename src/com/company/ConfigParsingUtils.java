package com.company;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ConfigParsingUtils {

    public static ConfigObject getConfig() throws IOException {
/*
XML FILES:

        File file = new File("C:\\Users\\lahav\\IdeaProjects\\FilesMediatorNew\\src\\com\\company\\config.txt");
        XmlMapper xmlMapper = new XmlMapper(); // Can change String -> Java Object OR Java Object -> String
        String xml = inputStreamToString(new FileInputStream(file));
        ConfigObject value = xmlMapper.readValue(xml, ConfigObject.class);
*/

        ConfigObject value = readJSON();

        return value;
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        line = br.readLine();

        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }

        br.close();
        return sb.toString();
    }

    public static void serialize() throws IOException {

        ConfigObject configObject = new ConfigObject("a","a",0,"");

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("C:\\Users\\lahav\\IdeaProjects\\FilesMediatorNew\\src\\com" +
                "\\company\\config.txt"), configObject);

    }

    public static void writeJSON(ConfigObject confingObject) throws JsonGenerationException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("C:\\Users\\lahav\\IdeaProjects\\" +
                "FilesMediatorNew\\src\\com\\company\\config.txt"), confingObject);
    }

    private static ConfigObject readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        ConfigObject configObject = mapper.readValue(new File("C:\\Users\\lahav\\IdeaProjects\\FilesMediatorNew\\src\\com\\company" +
                "\\config.txt"), ConfigObject.class);
        return configObject;
    }

}
