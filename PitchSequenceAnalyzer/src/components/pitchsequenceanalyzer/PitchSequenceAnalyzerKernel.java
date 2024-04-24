package components.pitchsequenceanalyzer;

import components.standard.Standard;

/**
 *  (Note: by package-wide convention, all referenceces are non null.)
 */
public interface PitchSequenceAnalyzerKernel extends Standard<PitchSequenceAnalyzer>{

    /**
     * Method to update the frequency after a pitch is throw.
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
     * @requires count is a valid count and not null and pitch is not null.
     * @ensures The frequencey is updated with the new pitch.
     */
    void addToFrequency(String count, String pitch);

    /**
     * Method to add to the list of pitches when the pitch is thrown.
     *
     * @param count
     *             the count when the pitch was thrown
     * @param pitch
     *             the pitch type
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
     * @requires count is a valid count and not null and pitch is not null.
     * @ensures The pitch and count is added to the list of pitches and the sequences are added to the sets of sequences..
     */
    void addToListOfPitchesAndUpdateSequences(String count, String pitch);

    /**
     * Method to get the frequency of a given count.
     *
     * @param count
     *            the count to get the frequency of
     * @return
     *          the frequency of each pitch with the given count
     * @requires count is a valid count and not null.
     * @ensures The frequency of each pitch with the given count is returned.
     */
    String getCountFrequency(String count);

    /**
     * Method to get the frequency of an upcoming pitch based of the previous two pitches.
     *
     * @ensures The frequency of the upcoming pitch based of the previous two pitches is returned.
     */
    String getThreePitchSequenceFrequency();

    /**
     * Method to get the frequency of an upcoming pitch based of the previous three pitches.
     *
     * @ensures The frequency of the upcoming pitch based of the previous three pitches is returned.
     */
    String getFourPitchSequenceFrequency();

    /**
     * Method to get the frequency of an upcoming pitch based of the previous four pitches.
     *
     * @ensures The frequency of the upcoming pitch based of the previous four pitches is returned.
     */
    String getFivePitchSequenceFrequency();

    /**
     * Method to return the counts and pitches.
     *
     * @return the counts and pitches
     * @requires this.listLength > 0
     * @ensures the counts and pitches are returned
     */
    String returnCountsAndPitches();

    /**
     * Method to reset the list of pitches and counts.
     *
     * @clears this.firstPitch
     * @clears this.onePitchAgo
     * @clears this.twoPitchesAgo
     * @clears this.threePitchesAgo
     * @clears this.fourPitchesAgo
     * @clears this.fivePitchesAgo
     * @clears this.listLength
     * @ensures the list of pitches and counts is reset to be able to account for data points spanning multiple games.
     */
    void resetList();
}
