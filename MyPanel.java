package de.kalman.tibimeter;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

public class MyPanel extends JPanel implements ActionListener {

    private int letzterZustand = 0;

    int counter = 0;

    private int x = 0;
    private int y = 0;

    private boolean gameStarted = false;
    private Date startTime = new Date();
    private int trefferAnzahlInsgesamt = 0;
    private int sekunden = 0;

    MyMidiDevice myMidiDevice;

    //Settings nur für Gitarre normal mit E(40) start. C3 (48) als Beginn


    int abstandNotenlinien = 10;
    int breiteNotenlinien =600;

    final int yC3 = 400;
    final int xC3 = breiteNotenlinien;

    int  breiteNote= abstandNotenlinien+abstandNotenlinien/2;
    int hoeheNote= abstandNotenlinien;

    int xNoteTemp = -100; // fuer normale Noten und Kreuz
    int yNoteTemp = -100; // fuer normale Noten und Kreuz
    int yNoteTempB = -100; // fuer Note mit B (tiefer)
    int xNoteTempB = -100; // fuer Note mit B (tiefer)

    int xNoteTempPruefnote = -100;
    int yNoteTempPruefnote = -100;
    int yNoteTempBPruefnote = -100;
    int xNoteTempBPruefnote = -100;
    MidiNotes midiNotes = new MidiNotes();

    int yErsteNoteLinie = yC3;

    int xNachRechtsFuer2TeNote = 40;
    String kreuz = "#";
    int offsetKreuz = 10;
    String b = "b";
    int offsetB = xNachRechtsFuer2TeNote - offsetKreuz;

    public MyPanel() {
        this.letzterZustand = 40;
        initMyPanel();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    private void initMyPanel() {
        setBackground(Color.white);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());

        myMidiDevice = new MyMidiDevice(this);
    }

    public void myRepaintNote(MidiNote midiNote){
        Graphics2D g2d = (Graphics2D)this.getGraphics();
        //super.paintComponent(g2d);

        clearBackground(g2d);

        //int positionOffset = 16; guitar
        int positionOffset = 4; // bass guitar
        int positionYNeu = midiNote.getPositionY()-positionOffset;

        MidiNote midiNotePruefnote = midiNotes.getMidiNote((byte)letzterZustand);
        int positionYNeuPruefnote = midiNotePruefnote.getPositionY()- positionOffset;


        alteNotenUndTextLoeschen(g2d, true);
        //Pruefnoten loeschen
        alteNotenUndTextLoeschen(g2d, false);

        textInfoZeichnen(midiNote, g2d, positionYNeu);

        //violinSchluesselZeichnen(g2d);

        int xCNeu = xC3 - breiteNotenlinien / 2;
        int yCNeu = yC3 - (positionYNeu * abstandNotenlinien / 2 - abstandNotenlinien / 2);

        int offsetPruefnote = -200;
        int xCNeuPruefnote = xCNeu + offsetPruefnote;
        int yCNeuPruefnote = yC3 - (positionYNeuPruefnote * abstandNotenlinien / 2 - abstandNotenlinien / 2);


        //+ untere Hilfslinien löschen
        g2d.setColor(Color.white);
        for(int i = 1 ; i < 10 ; i++){
            //Spielnote
            g2d.drawLine(xCNeu-6, yErsteNoteLinie + abstandNotenlinien*i,  xCNeu + breiteNote +66, yErsteNoteLinie + abstandNotenlinien*i);
            //Pruefnote
            g2d.drawLine(xCNeuPruefnote-6, yErsteNoteLinie + abstandNotenlinien*i,  xCNeuPruefnote + breiteNote +66, yErsteNoteLinie + abstandNotenlinien*i);
        }
        g2d.setColor(Color.black);
        //- untere Hilfslinien löschen

        //+ obere Hilfslinien löschen
        g2d.setColor(Color.white);
        for(int i = 5 ; i < 12 ; i++){
            //Spielnote
            g2d.drawLine(xCNeu-6, yErsteNoteLinie - abstandNotenlinien*i,  xCNeu + breiteNote +66, yErsteNoteLinie - abstandNotenlinien*i);
            //Pruefnote
            g2d.drawLine(xCNeuPruefnote-6, yErsteNoteLinie - abstandNotenlinien*i,  xCNeuPruefnote + breiteNote +66, yErsteNoteLinie - abstandNotenlinien*i);
        }
        g2d.setColor(Color.black);
        //- obere Hilfslinien löschen

        // Notenlinien zeichnen
        for(int i = 0 ; i < 5 ; i ++){
            g2d.drawLine( 0, yC3-(abstandNotenlinien)*i, breiteNotenlinien, yC3-(abstandNotenlinien)*i);
        }
        System.out.println("yErsteNoteLinie: " + yErsteNoteLinie);


        //++++untere/OBERE Hilfslinien zeichnen
        boolean unterHilfslinienZeichnen = false;
        boolean obereHilfslinienZeichnen = false;
        if(positionYNeu <= 0) {
            unterHilfslinienZeichnen = true;
        } else if(positionYNeu >=11){ // eigentlich 11, aber auf 11 gibt es auch #b
            obereHilfslinienZeichnen = true;
        }
        System.out.println("unterHilfslinienZeichnen: " + unterHilfslinienZeichnen);
        System.out.println("obereHilfslinienZeichnen: " + obereHilfslinienZeichnen);
        //---untere/obere Hilfslinien zeichnen

        //++++untere/OBERE Hilfslinien zeichnen Pruefnote
        boolean unterHilfslinienZeichnenPruefnote = false;
        boolean obereHilfslinienZeichnenPruefnote = false;
        if(positionYNeuPruefnote <= 0) {
            unterHilfslinienZeichnenPruefnote = true;
        } else if(positionYNeuPruefnote >=11){ // eigentlich 11, aber auf 11 gibt es auch #b
            obereHilfslinienZeichnenPruefnote = true;
        }
        System.out.println("unterHilfslinienZeichnenPruefnote: " + unterHilfslinienZeichnenPruefnote);
        System.out.println("obereHilfslinienZeichnenPruefnote: " + obereHilfslinienZeichnenPruefnote);
        //---untere/obere Hilfslinien zeichnen


        //Spielnote zeichnen
        boolean istKreuzOderBSpiel = false;
        if( midiNote.getNoteNameEnglish1() != null &&  midiNote.getNoteNameEnglish1().contains("#")){
            istKreuzOderBSpiel = true;
        }

        g2d.setColor(Color.black);
        g2d.fillArc(xCNeu, yCNeu, breiteNote, hoeheNote, 0, 360);

        //# und b zeichnen fuer erste Note, falls noetig
        if(istKreuzOderBSpiel){
            g2d.drawString(kreuz, xCNeu - offsetKreuz ,yCNeu + abstandNotenlinien);
            g2d.drawString(b, xCNeu + offsetB ,yCNeu + abstandNotenlinien / 2 );
        }
        //----Spielnote zeichnen

        //Pruefnote zeichnen
        boolean istKreuzOderBPruefnote = false;
        if( midiNotePruefnote.getNoteNameEnglish1() != null &&  midiNotePruefnote.getNoteNameEnglish1().contains("#")){
            istKreuzOderBPruefnote = true;
        }
        g2d.setColor(Color.blue);
        g2d.fillArc(xCNeuPruefnote, yCNeuPruefnote, breiteNote, hoeheNote, 0, 360);
        //# und b zeichnen fuer erste Note, falls noetig
        if(istKreuzOderBPruefnote){
            g2d.drawString(kreuz, xCNeuPruefnote - offsetKreuz ,yCNeuPruefnote + abstandNotenlinien);
            g2d.drawString(b, xCNeuPruefnote + offsetB ,yCNeuPruefnote + abstandNotenlinien / 2 );
        }
        g2d.setColor(Color.black);
        //--- Pruefnote zeichnen

// hier weiter

        if(unterHilfslinienZeichnen){
            g2d.setColor(Color.red);
            if(positionYNeu == 0 || positionYNeu <= -1){
                g2d.drawLine(xCNeu-6, yErsteNoteLinie + abstandNotenlinien,  xCNeu + breiteNote +6, yErsteNoteLinie + abstandNotenlinien);
            }
            if(positionYNeu <= -2 || positionYNeu <= -3){
                g2d.drawLine(xCNeu-6, yErsteNoteLinie + abstandNotenlinien*2,  xCNeu + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*2);
            }
            if(positionYNeu <= -4 || positionYNeu <= -5){
                g2d.drawLine(xCNeu-6, yErsteNoteLinie + abstandNotenlinien*3,  xCNeu + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*3);
            }
            if(positionYNeu <= -6 || positionYNeu <= -7){
                g2d.drawLine(xCNeu-6, yErsteNoteLinie + abstandNotenlinien*4,  xCNeu + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*4);
            }
            if(positionYNeu <= -8 || positionYNeu <= -9){
                g2d.drawLine(xCNeu-6, yErsteNoteLinie + abstandNotenlinien*5,  xCNeu + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*5);
            }
            if(positionYNeu <= -10 || positionYNeu <= -11){
                g2d.drawLine(xCNeu-6, yErsteNoteLinie + abstandNotenlinien*6,  xCNeu + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*6);
            }

            g2d.setColor(Color.black);
        }

        if(unterHilfslinienZeichnenPruefnote){
            g2d.setColor(Color.gray);
            if(positionYNeuPruefnote == 0 || positionYNeuPruefnote <= -1){
                g2d.drawLine(xCNeuPruefnote-6, yErsteNoteLinie + abstandNotenlinien,  xCNeuPruefnote + breiteNote +6, yErsteNoteLinie + abstandNotenlinien);
            }
            if(positionYNeuPruefnote <= -2 || positionYNeuPruefnote <= -3){
                g2d.drawLine(xCNeuPruefnote-6, yErsteNoteLinie + abstandNotenlinien*2,  xCNeuPruefnote + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*2);
            }
            if(positionYNeuPruefnote <= -4 || positionYNeuPruefnote <= -5){
                g2d.drawLine(xCNeuPruefnote-6, yErsteNoteLinie + abstandNotenlinien*3,  xCNeuPruefnote + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*3);
            }
            if(positionYNeuPruefnote <= -6 || positionYNeuPruefnote <= -7){
                g2d.drawLine(xCNeuPruefnote-6, yErsteNoteLinie + abstandNotenlinien*4,  xCNeuPruefnote + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*4);
            }
            if(positionYNeuPruefnote <= -8 || positionYNeuPruefnote <= -9){
                g2d.drawLine(xCNeuPruefnote-6, yErsteNoteLinie + abstandNotenlinien*5,  xCNeuPruefnote + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*5);
            }
            if(positionYNeuPruefnote <= -10 || positionYNeuPruefnote <= -11){
                g2d.drawLine(xCNeuPruefnote-6, yErsteNoteLinie + abstandNotenlinien*6,  xCNeuPruefnote + breiteNote +6, yErsteNoteLinie + abstandNotenlinien*6);
            }
            g2d.setColor(Color.black);
        }


        if(obereHilfslinienZeichnen){
            g2d.setColor(Color.darkGray);
            if( positionYNeu >= 12 ){
                g2d.drawLine(xCNeu - 5, yErsteNoteLinie - abstandNotenlinien*5, xCNeu + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*5);
            }
            if( positionYNeu >= 14 ){
                g2d.drawLine(xCNeu - 5, yErsteNoteLinie - abstandNotenlinien*6, xCNeu + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*6);
            }
            if( positionYNeu >= 16 ){
                g2d.drawLine(xCNeu - 5, yErsteNoteLinie - abstandNotenlinien*7, xCNeu + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*7);
            }
            if( positionYNeu >= 18 ){
                g2d.drawLine(xCNeu - 5, yErsteNoteLinie - abstandNotenlinien*8, xCNeu + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*8);
            }
            if( positionYNeu >= 20 ){
                g2d.drawLine(xCNeu - 5, yErsteNoteLinie - abstandNotenlinien*9, xCNeu + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*9);
            }
            if( positionYNeu >= 22 ){
                g2d.drawLine(xCNeu - 5, yErsteNoteLinie - abstandNotenlinien*10, xCNeu + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*10);
            }
            if( positionYNeu >= 24 ){
                g2d.drawLine(xCNeu - 5, yErsteNoteLinie - abstandNotenlinien*11, xCNeu + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*11);
            }
            g2d.setColor(Color.black);
        }

        if(obereHilfslinienZeichnenPruefnote){
            g2d.setColor(Color.darkGray);
            if( positionYNeuPruefnote >= 12 ){
                g2d.drawLine(xCNeuPruefnote - 5, yErsteNoteLinie - abstandNotenlinien*5, xCNeuPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*5);
            }
            if( positionYNeuPruefnote >= 14 ){
                g2d.drawLine(xCNeuPruefnote - 5, yErsteNoteLinie - abstandNotenlinien*6, xCNeuPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*6);
            }
            if( positionYNeuPruefnote >= 16 ){
                g2d.drawLine(xCNeuPruefnote - 5, yErsteNoteLinie - abstandNotenlinien*7, xCNeuPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*7);
            }
            if( positionYNeuPruefnote >= 18 ){
                g2d.drawLine(xCNeuPruefnote - 5, yErsteNoteLinie - abstandNotenlinien*8, xCNeuPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*8);
            }
            if( positionYNeuPruefnote >= 20 ){
                g2d.drawLine(xCNeuPruefnote - 5, yErsteNoteLinie - abstandNotenlinien*9, xCNeuPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*9);
            }
            if( positionYNeuPruefnote >= 22 ){
                g2d.drawLine(xCNeuPruefnote - 5, yErsteNoteLinie - abstandNotenlinien*10, xCNeuPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*10);
            }
            if( positionYNeuPruefnote >= 24 ){
                g2d.drawLine(xCNeuPruefnote - 5, yErsteNoteLinie - abstandNotenlinien*11, xCNeuPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien*11);
            }
            g2d.setColor(Color.black);
        }

        xNoteTemp = xCNeu;
        yNoteTemp = yCNeu;

        xNoteTempPruefnote = xCNeuPruefnote;
        yNoteTempPruefnote = yCNeuPruefnote;

        if(istKreuzOderBSpiel) {
            int xCNeuB = xC3 - breiteNotenlinien / 2 + xNachRechtsFuer2TeNote;
            int yCNeuB = yC3 - ((positionYNeu + 1/*1hoch*/) * abstandNotenlinien / 2 - abstandNotenlinien / 2);
            g2d.fillArc(xCNeuB, yCNeuB, breiteNote, hoeheNote, 0, 360);


            //Hilfslinien für B-Note
            if (unterHilfslinienZeichnen) {
                g2d.setColor(Color.red);
                if (positionYNeu <= -1 || positionYNeu <= -2) {
                    g2d.drawLine(xCNeuB - 6, yErsteNoteLinie + abstandNotenlinien, xCNeuB + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien);
                }
                if (positionYNeu <= -3 || positionYNeu <= -4) {
                    g2d.drawLine(xCNeuB - 6, yErsteNoteLinie + abstandNotenlinien * 2, xCNeuB + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 2);
                }
                if (positionYNeu <= -5 || positionYNeu <= -6) {
                    g2d.drawLine(xCNeuB - 6, yErsteNoteLinie + abstandNotenlinien * 3, xCNeuB + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 3);
                }
                if (positionYNeu <= -7 || positionYNeu <= -8) {
                    g2d.drawLine(xCNeuB - 6, yErsteNoteLinie + abstandNotenlinien * 4, xCNeuB + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 4);
                }
                if (positionYNeu <= -8 || positionYNeu <= -9) {
                    g2d.drawLine(xCNeuB - 6, yErsteNoteLinie + abstandNotenlinien * 5, xCNeuB + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 5);
                }
                if (positionYNeu <= -10 || positionYNeu <= -11) {
                    g2d.drawLine(xCNeuB - 6, yErsteNoteLinie + abstandNotenlinien * 6, xCNeuB + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 6);
                }
                g2d.setColor(Color.black);
            }

            if (obereHilfslinienZeichnen) {
                g2d.setColor(Color.green);
                if (positionYNeu >= 11) {
                    g2d.drawLine(xCNeuB - 5, yErsteNoteLinie - abstandNotenlinien * 5, xCNeuB + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 5);
                }
                if (positionYNeu >= 13) {
                    g2d.drawLine(xCNeuB - 5, yErsteNoteLinie - abstandNotenlinien * 6, xCNeuB + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 6);
                }
                if (positionYNeu >= 15) {
                    g2d.drawLine(xCNeuB - 5, yErsteNoteLinie - abstandNotenlinien * 7, xCNeuB + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 7);
                }
                if (positionYNeu >= 17) {
                    g2d.drawLine(xCNeuB - 5, yErsteNoteLinie - abstandNotenlinien * 8, xCNeuB + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 8);
                }
                if (positionYNeu >= 19) {
                    g2d.drawLine(xCNeuB - 5, yErsteNoteLinie - abstandNotenlinien * 9, xCNeuB + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 9);
                }
                if (positionYNeu >= 21) {
                    g2d.drawLine(xCNeuB - 5, yErsteNoteLinie - abstandNotenlinien * 10, xCNeuB + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 10);
                }
                if (positionYNeu >= 23) {
                    g2d.drawLine(xCNeuB - 5, yErsteNoteLinie - abstandNotenlinien * 11, xCNeuB + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 11);
                }
                g2d.setColor(Color.black);
            }

            xNoteTempB = xCNeuB;
            yNoteTempB = yCNeuB;

        }


        if(istKreuzOderBPruefnote) {
            int xCNeuBPruefnote = xC3 - breiteNotenlinien / 2 + xNachRechtsFuer2TeNote + offsetPruefnote;
            int yCNeuBPruefnote = yC3 - ((positionYNeuPruefnote + 1/*1hoch*/) * abstandNotenlinien / 2 - abstandNotenlinien / 2);
            g2d.fillArc(xCNeuBPruefnote, yCNeuBPruefnote, breiteNote, hoeheNote, 0, 360);


            //Hilfslinien für B-Note
            if (unterHilfslinienZeichnenPruefnote) {
                g2d.setColor(Color.red);
                if (positionYNeuPruefnote <= -1 || positionYNeuPruefnote <= -2) {
                    g2d.drawLine(xCNeuBPruefnote - 6, yErsteNoteLinie + abstandNotenlinien, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien);
                }
                if (positionYNeuPruefnote <= -3 || positionYNeuPruefnote <= -4) {
                    g2d.drawLine(xCNeuBPruefnote - 6, yErsteNoteLinie + abstandNotenlinien * 2, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 2);
                }
                if (positionYNeuPruefnote <= -5 || positionYNeuPruefnote <= -6) {
                    g2d.drawLine(xCNeuBPruefnote - 6, yErsteNoteLinie + abstandNotenlinien * 3, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 3);
                }
                if (positionYNeuPruefnote <= -7 || positionYNeuPruefnote <= -8) {
                    g2d.drawLine(xCNeuBPruefnote - 6, yErsteNoteLinie + abstandNotenlinien * 4, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 4);
                }
                if (positionYNeuPruefnote <= -8 || positionYNeuPruefnote <= -9) {
                    g2d.drawLine(xCNeuBPruefnote - 6, yErsteNoteLinie + abstandNotenlinien * 5, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 5);
                }
                if (positionYNeuPruefnote <= -10 || positionYNeuPruefnote <= -11) {
                    g2d.drawLine(xCNeuBPruefnote - 6, yErsteNoteLinie + abstandNotenlinien * 6, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie + abstandNotenlinien * 6);
                }
                g2d.setColor(Color.black);
            }

            if (obereHilfslinienZeichnenPruefnote) {
                g2d.setColor(Color.green);
                if (positionYNeuPruefnote >= 11) {
                    g2d.drawLine(xCNeuBPruefnote - 5, yErsteNoteLinie - abstandNotenlinien * 5, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 5);
                }
                if (positionYNeuPruefnote >= 13) {
                    g2d.drawLine(xCNeuBPruefnote - 5, yErsteNoteLinie - abstandNotenlinien * 6, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 6);
                }
                if (positionYNeuPruefnote >= 15) {
                    g2d.drawLine(xCNeuBPruefnote - 5, yErsteNoteLinie - abstandNotenlinien * 7, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 7);
                }
                if (positionYNeuPruefnote >= 17) {
                    g2d.drawLine(xCNeuBPruefnote - 5, yErsteNoteLinie - abstandNotenlinien * 8, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 8);
                }
                if (positionYNeuPruefnote >= 19) {
                    g2d.drawLine(xCNeuBPruefnote - 5, yErsteNoteLinie - abstandNotenlinien * 9, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 9);
                }
                if (positionYNeuPruefnote >= 21) {
                    g2d.drawLine(xCNeuBPruefnote - 5, yErsteNoteLinie - abstandNotenlinien * 10, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 10);
                }
                if (positionYNeuPruefnote >= 23) {
                    g2d.drawLine(xCNeuBPruefnote - 5, yErsteNoteLinie - abstandNotenlinien * 11, xCNeuBPruefnote + breiteNote + 6, yErsteNoteLinie - abstandNotenlinien * 11);
                }
                g2d.setColor(Color.black);
            }

            xNoteTempBPruefnote = xCNeuBPruefnote;
            yNoteTempBPruefnote = yCNeuBPruefnote;

        }

        if(letzterZustand == midiNote.getMidiNoteNumber()){
            playMidiNote(letzterZustand);
            letzterZustand = generateRandomNote();
            trefferAnzahlInsgesamt++;
            sekunden = (int)(System.currentTimeMillis() - startTime.getTime())/1000;
        }

    }

    private void textInfoZeichnen(MidiNote midiNote, Graphics2D g2d, int positionYNeu) {
        String noteName;
        if(midiNote.getNoteNameGerman2() != null){
            noteName = midiNote.getNoteNameGerman1() + " / " + midiNote.getNoteNameGerman2();
        } else {
            noteName = midiNote.getNoteNameGerman1();
        }

        //Text loeschen
        g2d.setColor(Color.white);
        g2d.fillRect(0,0,800,40);

        g2d.setColor(Color.black);
        String s = "midi: " + midiNote.getMidiNoteNumber()
                + ", Note: " + noteName
                + " pY: " + midiNote.getPositionY()
                + " pYNeu: " + positionYNeu
                + " eng: " + midiNote.getNoteNameEnglish1()
                + " letz Zus. " + letzterZustand
                + " ti: " + trefferAnzahlInsgesamt + "/" +sekunden ;
        g2d.drawString(s, 20 ,20);
    }

    private void alteNotenUndTextLoeschen(Graphics2D g2d, boolean normal) {
        g2d.setColor(Color.white);
        if(normal) {
            //alte Noten löschen
            g2d.fillArc(xNoteTemp, yNoteTemp, breiteNote, hoeheNote, 0, 360);
            g2d.fillArc(xNoteTempB, yNoteTempB, breiteNote, hoeheNote, 0, 360);
            // alte Kreuz und b loeschen
            g2d.drawString(kreuz, xNoteTemp - offsetKreuz, yNoteTemp + abstandNotenlinien);
            g2d.drawString(b, xNoteTemp + offsetB, yNoteTemp + abstandNotenlinien / 2);
        } else {
            g2d.fillArc(xNoteTempPruefnote, yNoteTempPruefnote, breiteNote, hoeheNote, 0, 360);
            g2d.fillArc(xNoteTempBPruefnote, yNoteTempBPruefnote, breiteNote, hoeheNote, 0, 360);
            // alte Kreuz und b loeschen
            g2d.drawString(kreuz, xNoteTempPruefnote - offsetKreuz, yNoteTempPruefnote + abstandNotenlinien);
            g2d.drawString(b, xNoteTempPruefnote + offsetB, yNoteTempPruefnote + abstandNotenlinien / 2);
        }
    }

    private void clearBackground(Graphics2D g2d) {
        g2d.setBackground(Color.white);
        g2d.clearRect(0,0,1800,1800);
    }

    private void playMidiNote(int note){
        try{
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();

            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();

            Instrument instrument = instr[0];
            System.out.println("instrument.getName() " + instrument.getName());
            midiSynth.loadInstrument(instrument);//instrument


            mChannels[0].noteOn(note, 100);
            try { Thread.sleep(1000);
            } catch( InterruptedException e ) { }
            mChannels[0].noteOff(note);


        } catch (MidiUnavailableException e) {}

    }

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            System.out.println("keyPressed: " + key);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == Event.LEFT
                    || key == Event.UP
                    || key == Event.DOWN
                    || key == Event.RIGHT
                    ) {
                System.out.println("keyReleased: " + key);
            }
        }
    }

    private int generateRandomNote(){ //88=24 Buende, 86=22 Buende 18=82 20=84 12
        int n =  (int)(Math.random() * ((69 - 28) + 1)) + 28;
        System.out.println("randomNote " + n);
        return n;
    }
}
