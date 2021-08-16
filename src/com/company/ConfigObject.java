package com.company;

public class ConfigObject {
    private String _listeningPath;
    private String _destPath;
    private long _sleepTime;
    private String _color;
    private Colors _enumColors;
    private String _checkFileForVirus;

    public ConfigObject() {

    }

    public ConfigObject(String listeningPath, String destPath, long sleepTime, String color) {
        _listeningPath = listeningPath;
        _destPath = destPath;
        _sleepTime = sleepTime;
        _color = color;
    }
    public String get_destPath() {
        return _destPath;
    }
    public String get_listeningPath() {
        return _listeningPath;
    }
    public long get_sleepTime() {
        return _sleepTime;
    }
    public String get_color() {
        return _color;
    }
    public Colors get_enumColors(){
        setEnumColors();
        return _enumColors;
    }
    public String get_checkFileForVirus(){return _checkFileForVirus;}


    public void set_listeningPath(String listeningPath) {
        _listeningPath = listeningPath;
    }
    public void set_destPath(String destPath) {
        _destPath = destPath;
    }
    public void set_sleepTime(long sleepTime) {
        _sleepTime = sleepTime;
    }
    public void set_color(String color) {
        _color = color;
        setEnumColors();
    }
    private void setEnumColors()
    {
        try {
            _enumColors = Colors.valueOf(_color);
        }
        catch(Exception e)
        {
            _enumColors = Colors.gray;
        }

    }
    public void set_checkFileForVirus(String checkFileForVirus){_checkFileForVirus = checkFileForVirus;}

}
