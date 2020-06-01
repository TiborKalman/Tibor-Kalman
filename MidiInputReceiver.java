package de.kalman.tibimeter;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

public class MidiInputReceiver implements Receiver {

    private String name;
    private MidiNotes midiNotes;
    private MyPanel myPanel;

    public MidiInputReceiver(String name, MyPanel myPanel) {
        this.name = name;
        this.midiNotes = new MidiNotes();
        this.myPanel = myPanel;
        System.out.println("MidiInputReceiver mypanel: " + myPanel);

        System.out.println("Constructor called...");
    }
    public void send(MidiMessage msg, long timeStamp) {



        byte[] aMsg = msg.getMessage();

        for(int i=0;i<msg.getLength();i++){

            if(i == 1 && aMsg[i] > 20){ // 1 = Note im Array
                MidiNote midiNote = midiNotes.getMidiNote(aMsg[i]);
                if(midiNote !=null) {

                    String noteName = null;
                    if(midiNote.getNoteNameGerman2() != null){
                        noteName = midiNote.getNoteNameGerman1() + " / " + midiNote.getNoteNameGerman2();
                    } else {
                        noteName = midiNote.getNoteNameGerman1();
                    }
                    System.out.println("midiNote: " + midiNote.getMidiNoteNumber() + ", Name1: " + noteName);

                    myPanel.myRepaintNote(midiNote);
                }
           }
        }
    }
    public void close() {
        System.out.println("closed");
    }

}
