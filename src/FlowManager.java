public class FlowManager {

    private FilesExtractor _filesExtractor;
    private FileSender _fileSender;

    public FlowManager()
    {
        String src = "C:\\Users\\lahav\\OneDrive\\Desktop\\Development\\Java files project\\src";
        _filesExtractor = new FilesExtractor(src);
        _fileSender = new FileSender(src);
    }

    public void runFlow(){


        String[] files = _filesExtractor.returnFiles();
        String fileExt;


        for(int i=0;i<files.length;i++)
        {
            fileExt = ExtensionGetter.getFileExtension(files[i]);
            _fileSender.send(files[i] , fileExt);
        }

    }






}
