public class LinuxCommand{
    public static void main(String args[]){
        String cmd = "tar -zcvf test.tar.gz HadoopTest";

        try{
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}