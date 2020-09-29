import java.io.File;
import java.nio.file.Path;

public class FilesExtractor{

    private File _routeToFiles;

    public FilesExtractor(String listeningPath){

        _routeToFiles = new File(listeningPath);

    }

    public String[] returnFiles()
    {
        return _routeToFiles.list();

    }

}
