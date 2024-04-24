package components.pitchsequenceanalyzer;

/**
 * Layered implementatinos of secondary methods for {@code PitchSequenceAnalyzer}.
 */
public abstract class PitchSequenceAnalyzerSecondary implements PitchSequenceAnalyzer {
    /*
     * Common methods (from Object) ---------------------------------------------------
     */

    /*
     * The Object versions of hashCode and equals are not overridden as there is not much use for them in this context.
     */

     // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        return returnCountsAndPitches();
    }



    /*
     * Other non-kernel methods -----------------------------------------------------
     */

     @Override
     public void addPitch(String count, String pitch) {
         addToFrequency(count, pitch);
         addToListOfPitchesAndUpdateSequences(count, pitch);
     }

    @Override
    public String getReport(String count) {
        String result = "";
        result += "Pitch frequencies for "+ count + ": " + getCountFrequency(count) + "\n";
        result += "3 pitch sequence frequecies: " + getThreePitchSequenceFrequency() + "\n";
        result += "4 pitch sequence frequecies: " + getFourPitchSequenceFrequency() + "\n";
        result += "5 pitch sequence frequecies: " + getFivePitchSequenceFrequency() + "\n";

        return result;
    }





}

