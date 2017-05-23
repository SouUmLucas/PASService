package model;

/**
 * Created by lucas on 22/05/2017.
 */
public abstract class File extends Entity {
    private String filename;
    private String filepath;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }
}
