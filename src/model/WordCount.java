package model;

public class WordCount extends Entity {
    private String word;
    private int count;
    private boolean isUpdatable;

    public WordCount() {
        this.isUpdatable = false;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setUpdateble(boolean isUpdatable) {
        this.isUpdatable = isUpdatable;
    }

    public boolean getUpdatable() {
        return isUpdatable;
    }

}
