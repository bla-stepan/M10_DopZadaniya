package M10_Z16;

public class Files {
    String fileName;
    String fileExpansion;
    int size;
    String volumeUnit;

    public Files (){};
    public Files(String fileName, String fileExpansion, int volume) {
        this.fileName = fileName;
        this.fileExpansion = fileExpansion;
        this.size = volume;
        //this.volumeUnit = volumeUnit;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExpansion() {
        return fileExpansion;
    }

    public void setFileExpansion(String fileExpansion) {
        this.fileExpansion = fileExpansion;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }
}
