import components.pitchsequenceanalyzer.PitchSequenceAnalyzer;
import components.pitchsequenceanalyzer.PitchSequenceAnalyzer1;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to analyze pitch sequences and frequencies.
 */
public class Analysis{
    /**
     * Main method to implement the PitchSequenceAnalyzer component to analyze pitch sequences and frequencies.
     * @param args
     *           the command line arguments; unused here.
     */
    public static void main(String[] args){
        //Creates a new PitchSequenceAnalyzer object
        PitchSequenceAnalyzer analyzer = new PitchSequenceAnalyzer1();

        //Gets data from a file if necessary
        String filename = "doc/OHSAA/Wooster/AshtonStill/4-23-24.txt";
        if (!filename.equals("NA")){
            SimpleReader in = new SimpleReader1L(filename);
            while(!in.atEOS()){
                String line = in.nextLine();
                if (line.equals("")){
                    analyzer.resetList();
                } else{
                    String count = line.substring(0, line.indexOf(" "));
                    String pitch = line.substring(line.indexOf(" ") + 1);
                    analyzer.addPitch(count, pitch);
                }
            }
            in.close();
        }


        //Gets count from user
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.println();
        out.print("Enter a count: ");
        String count = in.nextLine();

        //Prints the report
        out.println();
        out.println(analyzer.getReport(count));

        out.close();
        in.close();
    }
}