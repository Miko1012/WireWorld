public class Config {
    private int timeJump;
    private int genNumber;
    private String inFile;
    private String outFile;

    public Config(int timeJump, int genNumber, String inFile, String outFile){
        this.timeJump = timeJump;
        this.genNumber = genNumber;
        this.inFile = inFile;
        this.outFile = outFile;
    }



    public int getGenNumber(){
        return genNumber;
    }

    public String getInFile() {
        return inFile;
    }

}
