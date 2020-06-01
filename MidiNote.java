package de.kalman.tibimeter;

public class MidiNote {

    public MidiNote(byte midiNoteNumber,
                    int keyNumberOrgan,
                    int keyNumberPiano,
                    String noteNameEnglish1,
                    String noteNameEnglish2,
                    String noteNameGerman1,
                    String noteNameGerman2,
                    String noteNameRoman1,
                    String noteNameRoman2,
                    double frequencyInHertz,
                    int positionY) {
        this.midiNoteNumber = midiNoteNumber;
        this.keyNumberOrgan = keyNumberOrgan;
        this.keyNumberPiano = keyNumberPiano;
        this.noteNameEnglish1 = noteNameEnglish1;
        this.noteNameEnglish2 = noteNameEnglish2;
        this.noteNameGerman1 = noteNameGerman1;
        this.noteNameGerman2 = noteNameGerman2;
        this.noteNameRoman1 = noteNameRoman1;
        this.noteNameRoman2 = noteNameRoman2;
        this.frequencyInHertz = frequencyInHertz;
        this.positionY = positionY;
    }

    private byte midiNoteNumber;

    private int keyNumberOrgan;
    private int keyNumberPiano;

    private String noteNameEnglish1;
    private String noteNameEnglish2;

    private String noteNameGerman1;
    private String noteNameGerman2;

    private String noteNameRoman1;
    private String noteNameRoman2;

    private double frequencyInHertz;

    private int positionY;


    public byte getMidiNoteNumber() {
        return midiNoteNumber;
    }

    public void setMidiNoteNumber(byte midiNoteNumber) {
        this.midiNoteNumber = midiNoteNumber;
    }

    public int getKeyNumberOrgan() {
        return keyNumberOrgan;
    }

    public void setKeyNumberOrgan(int keyNumberOrgan) {
        this.keyNumberOrgan = keyNumberOrgan;
    }

    public int getKeyNumberPiano() {
        return keyNumberPiano;
    }

    public void setKeyNumberPiano(int keyNumberPiano) {
        this.keyNumberPiano = keyNumberPiano;
    }

    public String getNoteNameEnglish1() {
        return noteNameEnglish1;
    }

    public void setNoteNameEnglish1(String noteNameEnglish1) {
        this.noteNameEnglish1 = noteNameEnglish1;
    }

    public String getNoteNameEnglish2() {
        return noteNameEnglish2;
    }

    public void setNoteNameEnglish2(String noteNameEnglish2) {
        this.noteNameEnglish2 = noteNameEnglish2;
    }

    public String getNoteNameGerman1() {
        return noteNameGerman1;
    }

    public void setNoteNameGerman1(String noteNameGerman1) {
        this.noteNameGerman1 = noteNameGerman1;
    }

    public String getNoteNameGerman2() {
        return noteNameGerman2;
    }

    public void setNoteNameGerman2(String noteNameGerman2) {
        this.noteNameGerman2 = noteNameGerman2;
    }

    public String getNoteNameRoman1() {
        return noteNameRoman1;
    }

    public void setNoteNameRoman1(String noteNameRoman1) {
        this.noteNameRoman1 = noteNameRoman1;
    }

    public String getNoteNameRoman2() {
        return noteNameRoman2;
    }

    public void setNoteNameRoman2(String noteNameRoman2) {
        this.noteNameRoman2 = noteNameRoman2;
    }

    public double getFrequencyInHertz() {
        return frequencyInHertz;
    }

    public void setFrequencyInHertz(double frequencyInHertz) {
        this.frequencyInHertz = frequencyInHertz;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
