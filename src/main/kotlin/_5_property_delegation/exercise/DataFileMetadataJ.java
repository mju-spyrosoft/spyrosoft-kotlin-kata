package _5_property_delegation.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class DataFileMetadataJ {

    private final File file;
    private String contents;

    public DataFileMetadataJ(File file) {
        this.file = file;
    }

    private void loadContents() {
        try {
            contents = loadFromFile();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private String loadFromFile() throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    public String getContents() {
        if(contents == null){
            System.out.println("loading contents");
            loadContents();
        }
        return contents;

    }

    public static void main(String[] args) throws IOException {
        File newFile = new File("FileMetadata.txt");
        newFile.createNewFile();
        DataFileMetadataJ dataFileMetadataJ = new DataFileMetadataJ(newFile);
        dataFileMetadataJ.getContents();
        dataFileMetadataJ.getContents();
        dataFileMetadataJ.getContents();
    }
}
