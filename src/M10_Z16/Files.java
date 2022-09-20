package M10_Z16;

public class Files {
    String fileName;
    String fileExpansion;
    int volume;
    String volumeUnit;

    public Files (){};
    public Files(String fileName, String fileExpansion, int volume) {
        this.fileName = fileName;
        this.fileExpansion = fileExpansion;
        this.volume = volume;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }
}
