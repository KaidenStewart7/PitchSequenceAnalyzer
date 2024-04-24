package components.pitchsequenceanalyzer;

import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code PitchSequenceAnalyzer1} Represented as twelve maps, one for each count, a linked list to track the order of pitches and the last 5 pitches thrown and three maps to track the frequency of 3, 4 and 5 pitch sequences.
 *
 * @convention <pre>
 * $this.zeroZero is a map of the frequency of each pitch with count 0-0
 * $this.zeroOne is a map of the frequency of each pitch with count 0-1
 * $this.zeroTwo is a map of the frequency of each pitch with count 0-2
 * $this.oneZero is a map of the frequency of each pitch with count 1-0
 * $this.oneOne is a map of the frequency of each pitch with count 1-1
 * $this.oneTwo is a map of the frequency of each pitch with count 1-2
 * $this.twoZero is a map of the frequency of each pitch with count 2-0
 * $this.twoOne is a map of the frequency of each pitch with count 2-1
 * $this.twoTwo is a map of the frequency of each pitch with count 2-2
 * $this.threeZero is a map of the frequency of each pitch with count 3-0
 * $this.threeOne is a map of the frequency of each pitch with count 3-1
 * $this.threeTwo is a map of the frequency of each pitch with count 3-2
 * $firstPitch is the first pitch thrown.
 * $this.onePitchAgo is the pitch that was thrown one pitch ago.
 * $this.twoPitchesAgo is the pitch that was thrown two pitches ago.
 * $this.threePitchesAgo is the pitch that was thrown three pitches ago.
 * $this.fourPitchesAgo is the pitch that was thrown four pitches ago.
 * $this.fivePitchesAgo is the pitch that was thrown five pitches ago.
 * $this.listLength is the length of the linked list.
 * $this.threePitchSequences is a map of the frequency of each 3 pitch sequence.
 * $this.fourPitchSequences is a map of the frequency of each 4 pitch sequence.
 * $this.fivePitchSequences is a map of the frequency of each 5 pitch sequence.
 * <pre>
 * @correspondence <pre>
 * this = ($this.zeroZero, $this.zeroOne, $this.zeroTwo, $this.oneZero, $this.oneOne, $this.oneTwo, $this.twoZero, $this.twoOne, $this.twoTwo, $this.threeZero, $this.threeOne, $this.threeTwo, $this.firstPitch, $this.onePitchAgo, $this.twoPitchesAgo, $this.threePitchesAgo, $this.fourPitchesAgo, $this.fivePitchesAgo, $this.listLength, $this.threePitchSequences, $this.fourPitchSequences, $this.fivePitchSequences)
 * <pre>
 */
public class PitchSequenceAnalyzer1 extends PitchSequenceAnalyzerSecondary {

    /**
     * Node class for singly linked list.
     */
    private final class Node {

        /**
         * count of node
         */
        private String count;

        /**
         * pitchType of node
         */
        private String pitchType;

        /**
         * Next node in singly linked list
         */
        private Node next;

    }

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Represents the frequency of each pitch with count 0-0.
     */
    private Map<String, Integer> zeroZero;

    /**
     * Represents the frequency of each pitch with count 0-1.
     */
    private Map<String, Integer> zeroOne;

    /**
     * Represents the frequency of each pitch with count 0-2.
     */
    private Map<String, Integer> zeroTwo;

    /**
     * Represents the frequency of each pitch with count 1-0.
     */
    private Map<String, Integer> oneZero;

    /**
     * Represents the frequency of each pitch with count 1-1.
     */
    private Map<String, Integer> oneOne;

    /**
     * Represents the frequency of each pitch with count 1-2.
     */
    private Map<String, Integer> oneTwo;

    /**
     * Represents the frequency of each pitch with count 2-0.
     */
    private Map<String, Integer> twoZero;

    /**
     * Represents the frequency of each pitch with count 2-1.
     */
    private Map<String, Integer> twoOne;

    /**
     * Represents the frequency of each pitch with count 2-2.
     */
    private Map<String, Integer> twoTwo;

    /**
     * Represents the frequency of each pitch with count 3-0.
     */
    private Map<String, Integer> threeZero;

    /**
     * Represents the frequency of each pitch with count 3-1.
     */
    private Map<String, Integer> threeOne;

    /**
     * Represents the frequency of each pitch with count 3-2.
     */
    private Map<String, Integer> threeTwo;

    /**
     * Represents the first pitch thrown.
     */
    private Node firstPitch;

    /**
     * Represents the pitch that was thrown one pitch ago.
     */
    private Node onePitchAgo;

    /**
     * Represents the pitch that was thrown two pitches ago.
     */
    private Node twoPitchesAgo;

    /**
     * Represents the pitch that was thrown three pitches ago.
     */
    private Node threePitchesAgo;

    /**
     * Represents the pitch that was thrown four pitches ago.
     */
    private Node fourPitchesAgo;

    /**
     * Represents the pitch that was thrown five pitches ago.
     */
    private Node fivePitchesAgo;

    /**
     * Represents the length of the linked list.
     */
    private int listLength;

    /**
     * Represents the frequency of each 3 pitch sequence.
     */
    private Map<Sequence<String>, Integer> threePitchSequences;

    /**
     * Represents the frequency of each 4 pitch sequence.
     */
    private Map<Sequence<String>, Integer> fourPitchSequences;

    /**
     * Represents the frequency of each 5 pitch sequence.
     */
    private Map<Sequence<String>, Integer> fivePitchSequences;


    /**
     * Creator of initial representation.
     */
    public void createNewRep(){
        this.zeroZero = new Map1L<>();
        this.zeroOne = new Map1L<>();
        this.zeroTwo = new Map1L<>();
        this.oneZero = new Map1L<>();
        this.oneOne = new Map1L<>();
        this.oneTwo = new Map1L<>();
        this.twoZero = new Map1L<>();
        this.twoOne = new Map1L<>();
        this.twoTwo = new Map1L<>();
        this.threeZero = new Map1L<>();
        this.threeOne = new Map1L<>();
        this.threeTwo = new Map1L<>();
        this.firstPitch = null;
        this.onePitchAgo = null;
        this.twoPitchesAgo = null;
        this.threePitchesAgo = null;
        this.fourPitchesAgo = null;
        this.fivePitchesAgo = null;
        this.listLength = 0;
        this.threePitchSequences = new Map1L<>();
        this.fourPitchSequences = new Map1L<>();
        this.fivePitchSequences = new Map1L<>();

    }

    /**
     * Constructor for the PitchSequenceAnalyzer1.
     */
    public PitchSequenceAnalyzer1(){
        this.createNewRep();
    }

    /**
     * Standard methods --------------------------------------------------------
     */

    @SuppressWarnings("unchecked")
    @Override
    public final PitchSequenceAnalyzer newInstance(){
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear(){
        this.createNewRep();
    }

    @Override
    public final void transferFrom(PitchSequenceAnalyzer source){
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof PitchSequenceAnalyzer1 : ""
                + "Violation of: source is of dynamic type PitchSequenceAnalyzer1";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        PitchSequenceAnalyzer1 localSource = (PitchSequenceAnalyzer1) source;
        this.zeroZero = localSource.zeroZero;
        this.zeroOne = localSource.zeroOne;
        this.zeroTwo = localSource.zeroTwo;
        this.oneZero = localSource.oneZero;
        this.oneOne = localSource.oneOne;
        this.oneTwo = localSource.oneTwo;
        this.twoZero = localSource.twoZero;
        this.twoOne = localSource.twoOne;
        this.twoTwo = localSource.twoTwo;
        this.threeZero = localSource.threeZero;
        this.threeOne = localSource.threeOne;
        this.threeTwo = localSource.threeTwo;
        this.firstPitch = localSource.firstPitch;
        this.onePitchAgo = localSource.onePitchAgo;
        this.twoPitchesAgo = localSource.twoPitchesAgo;
        this.threePitchesAgo = localSource.threePitchesAgo;
        this.fourPitchesAgo = localSource.fourPitchesAgo;
        this.fivePitchesAgo = localSource.fivePitchesAgo;
        this.listLength = localSource.listLength;
        this.threePitchSequences = localSource.threePitchSequences;
        this.fourPitchSequences = localSource.fourPitchSequences;
        this.fivePitchSequences = localSource.fivePitchSequences;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ----------------------------------------------------------
     */

    @Override
    public void addToFrequency(String count, String pitch){
        assert count != null : "Violation of: count is not null";
        assert pitch != null : "Violation of: pitch is not null";

        // Updates frequency
        if (count.equals("0-0")){
            if (this.zeroZero.hasKey(pitch)){
                this.zeroZero.replaceValue(pitch, this.zeroZero.value(pitch) + 1);
            } else {
                this.zeroZero.add(pitch, 1);
            }
        } else if (count.equals("0-1")){
            if (this.zeroOne.hasKey(pitch)){
                this.zeroOne.replaceValue(pitch, this.zeroOne.value(pitch) + 1);
            } else {
                this.zeroOne.add(pitch, 1);
            }
        } else if (count.equals("0-2")){
            if (this.zeroTwo.hasKey(pitch)){
                this.zeroTwo.replaceValue(pitch, this.zeroTwo.value(pitch) + 1);
            } else {
                this.zeroTwo.add(pitch, 1);
            }
        } else if (count.equals("1-0")){
            if (this.oneZero.hasKey(pitch)){
                this.oneZero.replaceValue(pitch, this.oneZero.value(pitch) + 1);
            } else {
                this.oneZero.add(pitch, 1);
            }
        } else if (count.equals("1-1")){
            if (this.oneOne.hasKey(pitch)){
                this.oneOne.replaceValue(pitch, this.oneOne.value(pitch) + 1);
            } else {
                this.oneOne.add(pitch, 1);
            }
        } else if (count.equals("1-2")){
            if (this.oneTwo.hasKey(pitch)){
                this.oneTwo.replaceValue(pitch, this.oneTwo.value(pitch) + 1);
            } else {
                this.oneTwo.add(pitch, 1);
            }
        } else if (count.equals("2-0")){
            if (this.twoZero.hasKey(pitch)){
                this.twoZero.replaceValue(pitch, this.twoZero.value(pitch) + 1);
            } else {
                this.twoZero.add(pitch, 1);
            }
        } else if (count.equals("2-1")){
            if (this.twoOne.hasKey(pitch)){
                this.twoOne.replaceValue(pitch, this.twoOne.value(pitch) + 1);
            } else {
                this.twoOne.add(pitch, 1);
            }
        } else if (count.equals("2-2")){
            if (this.twoTwo.hasKey(pitch)){
                this.twoTwo.replaceValue(pitch, this.twoTwo.value(pitch) + 1);
            } else {
                this.twoTwo.add(pitch, 1);
            }
        } else if (count.equals("3-0")){
            if (this.threeZero.hasKey(pitch)){
                this.threeZero.replaceValue(pitch, this.threeZero.value(pitch) + 1);
            } else {
                this.threeZero.add(pitch, 1);
            }
        } else if (count.equals("3-1")){
            if (this.threeOne.hasKey(pitch)){
                this.threeOne.replaceValue(pitch, this.threeOne.value(pitch) + 1);
            } else {
                this.threeOne.add(pitch, 1);
            }
        } else if (count.equals("3-2")){
            if (this.threeTwo.hasKey(pitch)){
                this.threeTwo.replaceValue(pitch, this.threeTwo.value(pitch) + 1);
            } else {
                this.threeTwo.add(pitch, 1);
            }
        }
    }

    @Override
    public void addToListOfPitchesAndUpdateSequences(String count, String pitch){
        assert count != null : "Violation of: count is not null";
        assert pitch != null : "Violation of: pitch is not null";

        // Updates pitch list
        if (this.listLength == 0){
            Node newPitch = new Node();
            newPitch.count = count;
            newPitch.pitchType = pitch;
            newPitch.next = null;
            this.firstPitch = newPitch;
            this.onePitchAgo = newPitch;
            this.listLength++;
        } else if (this.listLength == 1){
            Node newPitch = new Node();
            newPitch.count = count;
            newPitch.pitchType = pitch;
            newPitch.next = null;
            this.onePitchAgo.next = newPitch;
            this.twoPitchesAgo = this.onePitchAgo;
            this.onePitchAgo = newPitch;
            this.listLength++;
        } else if (this.listLength == 2){
            Node newPitch = new Node();
            newPitch.count = count;
            newPitch.pitchType = pitch;
            newPitch.next = null;
            this.onePitchAgo.next = newPitch;
            this.threePitchesAgo = this.twoPitchesAgo;
            this.twoPitchesAgo = this.onePitchAgo;
            this.onePitchAgo = newPitch;
            this.listLength++;
        } else if (this.listLength == 3){
            Node newPitch = new Node();
            newPitch.count = count;
            newPitch.pitchType = pitch;
            newPitch.next = null;
            this.onePitchAgo.next = newPitch;
            this.fourPitchesAgo = this.threePitchesAgo;
            this.threePitchesAgo = this.twoPitchesAgo;
            this.twoPitchesAgo = this.onePitchAgo;
            this.onePitchAgo = newPitch;
            this.listLength++;
        } else{
            Node newPitch = new Node();
            newPitch.count = count;
            newPitch.pitchType = pitch;
            newPitch.next = null;
            this.onePitchAgo.next = newPitch;
            this.fivePitchesAgo = this.fourPitchesAgo;
            this.fourPitchesAgo = this.threePitchesAgo;
            this.threePitchesAgo = this.twoPitchesAgo;
            this.twoPitchesAgo = this.onePitchAgo;
            this.onePitchAgo = newPitch;
            this.listLength++;
        }

        if (this.listLength > 4){
            //Updates 3 pitch sequence frequency
            Sequence<String> threePitchSequence = new Sequence1L<>();
            threePitchSequence.add(0, this.threePitchesAgo.pitchType);
            threePitchSequence.add(1, this.twoPitchesAgo.pitchType);
            threePitchSequence.add(2, this.onePitchAgo.pitchType);

            if (this.threePitchSequences.hasKey(threePitchSequence)){
                this.threePitchSequences.replaceValue(threePitchSequence, this.threePitchSequences.value(threePitchSequence) + 1);
            } else {
                this.threePitchSequences.add(threePitchSequence, 1);
            }

            //Updates 4 pitch sequence frequency
            Sequence<String> fourPitchSequence = new Sequence1L<>();
            fourPitchSequence.add(0, this.fourPitchesAgo.pitchType);
            fourPitchSequence.add(1, this.threePitchesAgo.pitchType);
            fourPitchSequence.add(2, this.twoPitchesAgo.pitchType);
            fourPitchSequence.add(3, this.onePitchAgo.pitchType);

            if (this.fourPitchSequences.hasKey(fourPitchSequence)){
                this.fourPitchSequences.replaceValue(fourPitchSequence, this.fourPitchSequences.value(fourPitchSequence) + 1);
            } else {
                this.fourPitchSequences.add(fourPitchSequence, 1);
            }

            //Updates 5 pitch sequence frequency
            Sequence<String> fivePitchSequence = new Sequence1L<>();
            fivePitchSequence.add(0, this.fivePitchesAgo.pitchType);
            fivePitchSequence.add(1, this.fourPitchesAgo.pitchType);
            fivePitchSequence.add(2, this.threePitchesAgo.pitchType);
            fivePitchSequence.add(3, this.twoPitchesAgo.pitchType);
            fivePitchSequence.add(4, this.onePitchAgo.pitchType);

            if (this.fivePitchSequences.hasKey(fivePitchSequence)){
                this.fivePitchSequences.replaceValue(fivePitchSequence, this.fivePitchSequences.value(fivePitchSequence) + 1);
            } else {
                this.fivePitchSequences.add(fivePitchSequence, 1);
            }

        } else if (this.listLength > 3){
            //Updates 3 pitch sequence frequency
            Sequence<String> threePitchSequence = new Sequence1L<>();
            threePitchSequence.add(0, this.threePitchesAgo.pitchType);
            threePitchSequence.add(1, this.twoPitchesAgo.pitchType);
            threePitchSequence.add(2, this.onePitchAgo.pitchType);

            if (this.threePitchSequences.hasKey(threePitchSequence)){
                this.threePitchSequences.replaceValue(threePitchSequence, this.threePitchSequences.value(threePitchSequence) + 1);
            } else {
                this.threePitchSequences.add(threePitchSequence, 1);
            }

            //Updates 4 pitch sequence frequency
            Sequence<String> fourPitchSequence = new Sequence1L<>();
            fourPitchSequence.add(0, this.fourPitchesAgo.pitchType);
            fourPitchSequence.add(1, this.threePitchesAgo.pitchType);
            fourPitchSequence.add(2, this.twoPitchesAgo.pitchType);
            fourPitchSequence.add(3, this.onePitchAgo.pitchType);

            if (this.fourPitchSequences.hasKey(fourPitchSequence)){
                this.fourPitchSequences.replaceValue(fourPitchSequence, this.fourPitchSequences.value(fourPitchSequence) + 1);
            } else {
                this.fourPitchSequences.add(fourPitchSequence, 1);
            }
        } else if (this.listLength > 2){
            //Updates 3 pitch sequence frequency
            Sequence<String> threePitchSequence = new Sequence1L<>();
            threePitchSequence.add(0, this.threePitchesAgo.pitchType);
            threePitchSequence.add(1, this.twoPitchesAgo.pitchType);
            threePitchSequence.add(2, this.onePitchAgo.pitchType);

            if (this.threePitchSequences.hasKey(threePitchSequence)){
                this.threePitchSequences.replaceValue(threePitchSequence, this.threePitchSequences.value(threePitchSequence) + 1);
            } else {
                this.threePitchSequences.add(threePitchSequence, 1);
            }
        }
    }

    @Override
    public String getCountFrequency(String count){
        assert count != null : "Violation of: count is not null";

        String result = "";
        if (count.equals("0-0")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.zeroZero){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 0-0";
            } else{
                for (Map.Pair<String, Integer> pair : this.zeroZero){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("0-1")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.zeroOne){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 0-1";
            } else{
                for (Map.Pair<String, Integer> pair : this.zeroOne){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("0-2")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.zeroTwo){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 0-2";
            } else{
                for (Map.Pair<String, Integer> pair : this.zeroTwo){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("1-0")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.oneZero){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 1-0";
            } else{
                for (Map.Pair<String, Integer> pair : this.oneZero){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("1-1")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.oneOne){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 1-1";
            } else{
                for (Map.Pair<String, Integer> pair : this.oneOne){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("1-2")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.oneTwo){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 1-2";
            } else{
                for (Map.Pair<String, Integer> pair : this.oneTwo){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("2-0")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.twoZero){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 2-0";
            } else{
                for (Map.Pair<String, Integer> pair : this.twoZero){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("2-1")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.twoOne){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 2-1";
            } else{
                for (Map.Pair<String, Integer> pair : this.twoOne){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("2-2")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.twoTwo){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 2-2";
            } else{
                for (Map.Pair<String, Integer> pair : this.twoTwo){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("3-0")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.threeZero){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 3-0";
            } else{
                for (Map.Pair<String, Integer> pair : this.threeZero){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("3-1")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.threeOne){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 3-1";
            } else{
                for (Map.Pair<String, Integer> pair : this.threeOne){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        } else if (count.equals("3-2")){
            int totalPitches = 0;
            for (Map.Pair<String, Integer> pair : this.threeTwo){
                totalPitches += pair.value();
            }
            if (totalPitches == 0){
                result = "No pitches thrown with count 3-2";
            } else{
                for (Map.Pair<String, Integer> pair : this.threeTwo){
                    result += pair.key() + ": " + ((double)pair.value()/totalPitches) + " ";
                }
            }
        }

        return result;
    }

    @Override
    public String getThreePitchSequenceFrequency(){
        String result = "Three pitch sequences frequencies: ";
        if (this.threePitchSequences.size() == 0){
            result = "No three pitch sequences thrown";
        } else{

            if (this.listLength >= 2){
                String pitchOne = this.twoPitchesAgo.pitchType;
                String pitchTwo = this.onePitchAgo.pitchType;
                int numberOfInterestingSequences = 0;
                for (Map.Pair<Sequence<String>, Integer> pair : this.threePitchSequences){
                    Sequence<String> current = pair.key();
                    if (current.entry(0).equals(pitchOne) && current.entry(1).equals(pitchTwo)){
                        numberOfInterestingSequences += pair.value();
                    }
                }

                if (numberOfInterestingSequences == 0){
                    result = "No three pitch sequences found with the last two pitches";
                } else{
                    for (Map.Pair<Sequence<String>, Integer> pair : this.threePitchSequences){
                        Sequence<String> current = pair.key();
                        if (current.entry(0).equals(pitchOne) && current.entry(1).equals(pitchTwo)){
                            result += current.entry(2) + ": " + ((double)pair.value()/numberOfInterestingSequences) + " ";
                        }
                    }
                }

                result += " n =  " + numberOfInterestingSequences;
            } else{
                result = "Not enough pitches thrown to calculate three pitch sequences";
            }

        }

        return result;
    }

    @Override
    public String getFourPitchSequenceFrequency(){
        String result = "Four pitch sequences frequencies: ";
        if (this.fourPitchSequences.size() == 0){
            result = "No four pitch sequences thrown";
        } else{
            if (this.listLength >= 3){
                String pitchOne = this.threePitchesAgo.pitchType;
                String pitchTwo = this.twoPitchesAgo.pitchType;
                String pitchThree = this.onePitchAgo.pitchType;
                int numberOfInterestingSequences = 0;
                for (Map.Pair<Sequence<String>, Integer> pair : this.fourPitchSequences){
                    Sequence<String> current = pair.key();
                    if (current.entry(0).equals(pitchOne) && current.entry(1).equals(pitchTwo) && current.entry(2).equals(pitchThree)){
                        numberOfInterestingSequences += pair.value();
                    }
                }

                if (numberOfInterestingSequences == 0){
                    result = "No four pitch sequences found with the last three pitches";
                } else{
                    for (Map.Pair<Sequence<String>, Integer> pair : this.fourPitchSequences){
                        Sequence<String> current = pair.key();
                        if (current.entry(0).equals(pitchOne) && current.entry(1).equals(pitchTwo) && current.entry(2).equals(pitchThree)){
                            result += current.entry(3) + ": " + ((double)pair.value()/numberOfInterestingSequences) + " ";
                        }
                    }
                }

                result += " n =  " + numberOfInterestingSequences;
            } else{
                result = "Not enough pitches thrown to calculate four pitch sequences";
            }
        }

        return result;
    }

    @Override
    public String getFivePitchSequenceFrequency(){
        String result = "Five pitch sequences frequencies: ";
        if (this.fivePitchSequences.size() == 0){
            result = "No five pitch sequences thrown";
        } else{
            if (this.listLength >= 4){
                String pitchOne = this.fourPitchesAgo.pitchType;
                String pitchTwo = this.threePitchesAgo.pitchType;
                String pitchThree = this.twoPitchesAgo.pitchType;
                String pitchFour = this.onePitchAgo.pitchType;
                int numberOfInterestingSequences = 0;
                for (Map.Pair<Sequence<String>, Integer> pair : this.fivePitchSequences){
                    Sequence<String> current = pair.key();
                    if (current.entry(0).equals(pitchOne) && current.entry(1).equals(pitchTwo) && current.entry(2).equals(pitchThree) && current.entry(3).equals(pitchFour)){
                        numberOfInterestingSequences += pair.value();
                    }
                }

                if (numberOfInterestingSequences == 0){
                    result = "No five pitch sequences found with the last four pitches";
                } else{
                    for (Map.Pair<Sequence<String>, Integer> pair : this.fivePitchSequences){
                        Sequence<String> current = pair.key();
                        if (current.entry(0).equals(pitchOne) && current.entry(1).equals(pitchTwo) && current.entry(2).equals(pitchThree) && current.entry(3).equals(pitchFour)){
                            result += current.entry(4) + ": " + ((double)pair.value()/numberOfInterestingSequences) + " ";
                        }
                    }
                }

                result += " n =  " + numberOfInterestingSequences;
            } else{
                result = "Not enough pitches thrown to calculate five pitch sequences";
            }
        }

        return result;
    }

    @Override
    public String returnCountsAndPitches(){
        assert this.listLength > 0 : "Violation of: listLength > 0";

        String result = "";
        Node current = this.firstPitch;
        boolean status = true;
        while (status){
            result += current.count + " " + current.pitchType + "\n";
            if (current.next == null){
                status = false;
            } else{
                current = current.next;
            }
        }

        return result;
    }

    @Override
    public void resetList(){
        this.firstPitch = null;
        this.onePitchAgo = null;
        this.twoPitchesAgo = null;
        this.threePitchesAgo = null;
        this.fourPitchesAgo = null;
        this.fivePitchesAgo = null;
        this.listLength = 0;
    }


}
