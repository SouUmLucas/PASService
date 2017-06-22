package com.pas.domain;

/**
 * Created by lucas on 22/05/2017.
 */
public abstract class File extends Entity {
    private String filename;
    private String filepath;
    private String filecontent;

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

    public String getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(String filecontent) {
        this.filecontent = filecontent;
    }
}
