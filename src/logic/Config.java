package logic;

public class Config {
    private int timeJump;
    private int genNumber;
    private String inFile;
    private String outFile;

    public Config (int timeJump, int genNumber, String inFile, String outFile){
        this.timeJump = timeJump;
        this.genNumber = genNumber;
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public Config () {}

    public int getGenNumber(){
        return genNumber;
    }

    public String getInFile() {
        return inFile;
    }

    public String getOutFile(){
        return outFile;
    }

    public void settimejump (int i) {timeJump = i;}

    public void setgennumber (int i) {genNumber = i;}

    public void setinfile (String i) {inFile = i;}
    public void setoutfile (String i) {outFile = i;}

}
