package toolbox;

import java.io.File;
import java.io.FileNotFoundException;

public class FilesInDirectoryCalculator {
	
	public int calculateFilesNumber(String drirectoryPath) throws Exception
	{
		
		    File file = new File (drirectoryPath);
		    
		    if (!file.exists())
		        throw new FileNotFoundException ();
		    return file.list().length;
		    
	}

}
