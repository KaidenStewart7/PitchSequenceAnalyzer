package components.pitchsequenceanalyzer;

/**
 * {@code PitchSequenceAnalyzer} enhanced with secondary methods.
 */
public interface PitchSequenceAnalyzer extends PitchSequenceAnalyzerKernel{

    /**
     * Method to add the pitch
     *
     * @param count
     *             the count when the pitch was thrown
     * @param pitch
     *             the pitch type
     * @updates this.zeroZero
     * @updates this.zeroOne
     * @updates this.zeroTwo
     * @updates this.oneZero
     * @updates this.oneOne
     * @updates this.oneTwo
     * @updates this.twoZero
     * @updates this.twoOne
     * @updates this.twoTwo
     * @updates this.threeZero
     * @updates this.threeOne
     * @updates this.threeTwo
     * @updates this.firstPitch
     * @updates this.onePitchAgo
     * @updates this.twoPitchesAgo
     * @updates this.threePitchesAgo
     * @updates this.fourPitchesAgo
     * @updates this.fivePitchesAgo
     * @updates this.listLength
     * @updates this.threePitchSequences
     * @updates this.fourPitchSequences
     * @updates this.fivePitchSequences
     *
     * @requires count is a valid count and not null and pitch is not null.
     * @ensures The frequencey is updated with the new pitch and the pitch is added to the list of pitches and the sequences are added to the sets of sequences.
     */
    void addPitch(String count, String pitch);

    /**
     * Method to get the report of the frequencies given count and given the recent pitches.
     * @param count
     *              the count to get the frequencies of
     * @return the report of the frequencies given count and given the recent pitches.
     * @requires count is a valid count and not null.
     * @ensures The report of the frequencies given count and given the recent pitches is returned.
     */
    String getReport(String count);

}
