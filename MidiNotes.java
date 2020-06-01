package de.kalman.tibimeter;

import java.util.ArrayList;
import java.util.List;

public class MidiNotes {

    private List<MidiNote> midiNotes = new ArrayList<>();

    public MidiNotes() {
        setAllMidiNotes();
    }

    public List<MidiNote> getMidiNotes() {
        return midiNotes;
    }

    public MidiNote getMidiNote(byte b){

        MidiNote midiNote = null;
        for(MidiNote midiNoteTemp : this.midiNotes) {
            if(midiNoteTemp.getMidiNoteNumber() == b){
                midiNote = midiNoteTemp;
                break;
            }
        }
        return midiNote;
    }

    private void setAllMidiNotes(){
        MidiNote midiNote0 = new MidiNote((byte)0,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                8.18,
                0);
        this.midiNotes.add(midiNote0);

        MidiNote midiNote1 = new MidiNote((byte)1,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                8.66,
                0);
        this.midiNotes.add(midiNote1);

        //2
        MidiNote midiNote2 = new MidiNote((byte)2,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                9.18,
                0);
        this.midiNotes.add(midiNote2);

        MidiNote midiNote3 = new MidiNote((byte)3,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                9.72,
                0);
        this.midiNotes.add(midiNote3);

        MidiNote midiNote4 = new MidiNote((byte)4,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                10.30,
                0);
        this.midiNotes.add(midiNote4);

        MidiNote midiNote5 = new MidiNote((byte)5,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                10.91,
                0);
        this.midiNotes.add(midiNote5);

        MidiNote midiNote6 = new MidiNote((byte)6,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                11.56,
                0);
        this.midiNotes.add(midiNote6);

        MidiNote midiNote7 = new MidiNote((byte)7,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                12.25,
                0);
        this.midiNotes.add(midiNote7);

        MidiNote midiNote8 = new MidiNote((byte)8,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                12.98,
                0);
        this.midiNotes.add(midiNote8);

        MidiNote midiNote9 = new MidiNote((byte)9,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                13.75,
                0);
        this.midiNotes.add(midiNote9);

        MidiNote midiNote10 = new MidiNote((byte)10,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                14.57,
                0);
        this.midiNotes.add(midiNote10);

        MidiNote midiNote11 = new MidiNote((byte)11,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                15.43,
                0);
        this.midiNotes.add(midiNote11);

        MidiNote midiNote12 = new MidiNote((byte)12,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                16.35,
                0);
        this.midiNotes.add(midiNote12);

        MidiNote midiNote13 = new MidiNote((byte)13,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                17.32,
                0);
        this.midiNotes.add(midiNote13);

        MidiNote midiNote14 = new MidiNote((byte)14,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                18.35,
                0);
        this.midiNotes.add(midiNote14);

        MidiNote midiNote15 = new MidiNote((byte)15,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                19.45,
                0);
        this.midiNotes.add(midiNote15);

        MidiNote midiNote16 = new MidiNote((byte)16,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                20.60,
                0);
        this.midiNotes.add(midiNote16);

        MidiNote midiNote17 = new MidiNote((byte)17,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                21.83,
                0);
        this.midiNotes.add(midiNote17);

        MidiNote midiNote18 = new MidiNote((byte)18,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                23.12,
                0);
        this.midiNotes.add(midiNote18);

        MidiNote midiNote19 = new MidiNote((byte)19,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                24.50,
                0);
        this.midiNotes.add(midiNote19);

        MidiNote midiNote20 = new MidiNote((byte)20,
                0,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                25.96,
                0);
        this.midiNotes.add(midiNote20);

        MidiNote midiNote21 = new MidiNote((byte)21,0,1,"A0",null,"A2",null,null,null,27.50, 0);
        this.midiNotes.add(midiNote21);

        MidiNote midiNote22 = new MidiNote((byte)22, 0,2,"A#0","Bb0","Ais2","B2","roman1","roman2",29.14, 0);
        this.midiNotes.add(midiNote22);

        // E-Bass tiefe H-Saite
        MidiNote midiNote23 = new MidiNote((byte)23, 0,3,"B0",null,"H2",null,"roman1","roman2",30.87,1);
        this.midiNotes.add(midiNote23);

        MidiNote midiNote24 = new MidiNote((byte)24, 0,4,"C1",null,"C1",null,"roman1","roman2",32.70, 2);
        this.midiNotes.add(midiNote24);

        MidiNote midiNote25 = new MidiNote((byte)25, 0,5,"C#1","Db1","Cis1","Des1","roman1","roman2",34.65, 2);
        this.midiNotes.add(midiNote25);

        MidiNote midiNote26 = new MidiNote((byte)26, 0,6,"D1",null,"D1",null,"roman1","roman2",36.71, 3);
        this.midiNotes.add(midiNote26);

        MidiNote midiNote27 = new MidiNote((byte)27, 0,7,"D#1","Eb1","Dis1","Es1","roman1","roman2",38.89, 3);
        this.midiNotes.add(midiNote27);

        //E-Bass tiefe E-Saite
        MidiNote midiNote28 = new MidiNote((byte)28, 0,8,"E1",null,"E1",null,"roman1","roman2",41.20, 4);
        this.midiNotes.add(midiNote28);

        MidiNote midiNote29 = new MidiNote((byte)29, 0,9,"F1",null,"F1",null,"roman1","roman2",43.65, 5);
        this.midiNotes.add(midiNote29);

        MidiNote midiNote30 = new MidiNote((byte)30, 0,10,"F#1","Gb1","Fis1","Ges1","roman1","roman2",46.25, 5);
        this.midiNotes.add(midiNote30);

        MidiNote midiNote31 = new MidiNote((byte)31, 0,11,"G1",null,"G1",null,"roman1","roman2",49.00, 6);
        this.midiNotes.add(midiNote31);

        MidiNote midiNote32 = new MidiNote((byte)32, 0,12,"G#1","Ab1","Gis1","As1","roman1","roman2",51.91, 6);
        this.midiNotes.add(midiNote32);

        MidiNote midiNote33 = new MidiNote((byte)33, 0,13,"A1",null,"A1",null,"roman1","roman2",55.00, 7);
        this.midiNotes.add(midiNote33);

        MidiNote midiNote34 = new MidiNote((byte)34, 0,14,"A#1","Bb1","Ais1","b1","roman1","roman2",58.27, 7);
        this.midiNotes.add(midiNote34);

        MidiNote midiNote35 = new MidiNote((byte)35, 0,15,"B1",null,"H1",null,"roman1","roman2",61.74,8);
        this.midiNotes.add(midiNote35);

        MidiNote midiNote36 = new MidiNote((byte)36, 1,16,"C2",null,"C",null,"roman1","roman2",65.41, 9);
        this.midiNotes.add(midiNote36);

        MidiNote midiNote37 = new MidiNote((byte)37, 2,17,"C#2","Db2","Cis","Des","roman1","roman2",69.30,9);
        this.midiNotes.add(midiNote37);

        MidiNote midiNote38 = new MidiNote((byte)38, 3,18,"D2",null,"D",null,"roman1","roman2",73.42, 10);
        this.midiNotes.add(midiNote38);

        MidiNote midiNote39 = new MidiNote((byte)39, 4,19,"D#2","Eb2","Dis","Es","roman1","roman2",77.78, 10);
        this.midiNotes.add(midiNote39);

        //Beginn E-Gitarre 6 (Tiefste Saite)
        MidiNote midiNote40 = new MidiNote((byte)40, 5,20,"E2",null,"E",null,"roman1","roman2",82.41, 11);
        this.midiNotes.add(midiNote40);

        MidiNote midiNote41 = new MidiNote((byte)41, 6,21,"F2",null,"F",null,"roman1","roman2",87.31, 12);
        this.midiNotes.add(midiNote41);

        MidiNote midiNote42 = new MidiNote((byte)42, 7,22,"F#2","Gb2","Fis","Ges","roman1","roman2",92.50,12);
        this.midiNotes.add(midiNote42);

        MidiNote midiNote43 = new MidiNote((byte)43, 8,23,"G2",null,"G",null,"roman1","roman2",98.00,13);
        this.midiNotes.add(midiNote43);

        MidiNote midiNote44 = new MidiNote((byte)44, 9,24,"G#2","Ab2","Gis","As","roman1","roman2",103.83,13);
        this.midiNotes.add(midiNote44);

        MidiNote midiNote45 = new MidiNote((byte)45, 10,25,"A2",null,"A",null,"roman1","roman2",110.00,14);
        this.midiNotes.add(midiNote45);

        MidiNote midiNote46 = new MidiNote((byte)46, 11,26,"A#2","Bb2","Ais","B","roman1","roman2",116.54,14);
        this.midiNotes.add(midiNote46);

        MidiNote midiNote47 = new MidiNote((byte)47, 12,27,"B2",null,"H",null,"roman1","roman2",123.47,15);
        this.midiNotes.add(midiNote47);

        //c für Gitarre erste Hilfslinie
        MidiNote midiNote48 = new MidiNote((byte)48, 13,28,"C3",null,"c",null,"roman1","roman2", 130.81,16);
        this.midiNotes.add(midiNote48);

        MidiNote midiNote49 = new MidiNote((byte)49, 14,29,"C#3","Db3","cis","des","roman1","roman2", 138.59,16);
        this.midiNotes.add(midiNote49);

        MidiNote midiNote50 = new MidiNote((byte)50, 15,30,"D3",null,"d",null,"roman1","roman2", 146.83,17);
        this.midiNotes.add(midiNote50);

        MidiNote midiNote51 = new MidiNote((byte)51, 16,31,"D#3","Eb3","dis","es","roman1","roman2", 155.56,17);
        this.midiNotes.add(midiNote51);

        MidiNote midiNote52 = new MidiNote((byte)52, 17,32,"E3",null,"e",null,"roman1","roman2", 164.81,18);
        this.midiNotes.add(midiNote52);

        MidiNote midiNote53 = new MidiNote((byte)53, 18,33,"F3",null,"f",null,"roman1","roman2", 174.61,19);
        this.midiNotes.add(midiNote53);

        MidiNote midiNote54 = new MidiNote((byte)54, 19,34,"F#3","Gb3","fis","ges","roman1","roman2", 185.00,19);
        this.midiNotes.add(midiNote54);

        MidiNote midiNote55 = new MidiNote((byte)55, 20,35,"G3",null,"g",null,"roman1","roman2", 196.00,20);
        this.midiNotes.add(midiNote55);

        MidiNote midiNote56 = new MidiNote((byte)56, 21,36,"G#3","Ab3","gis","as","roman1","roman2", 207.65,20);
        this.midiNotes.add(midiNote56);

        MidiNote midiNote57 = new MidiNote((byte)57, 22,37,"A3",null,"a",null,"roman1","roman2", 220.00,21);
        this.midiNotes.add(midiNote57);

        MidiNote midiNote58 = new MidiNote((byte)58, 23,38,"A#3","Bb3","ais","b","roman1","roman2", 233.08, 21);
        this.midiNotes.add(midiNote58);

        MidiNote midiNote59 = new MidiNote((byte)59, 24,39,"B3",null,"h",null,"roman1","roman2", 246.94, 22);
        this.midiNotes.add(midiNote59);

        MidiNote midiNote60 = new MidiNote((byte)60, 25,40,"C4 (middle C)",null,"c’ (Schloss-C)",null,"roman1","roman2", 261.63,23);
        this.midiNotes.add(midiNote60);

        MidiNote midiNote61 = new MidiNote((byte)61, 26,41,"C#4","Db4","cis’","des’","roman1","roman2", 277.18, 23);
        this.midiNotes.add(midiNote61);

        MidiNote midiNote62 = new MidiNote((byte)62, 27,42,"D4",null,"d’",null,"roman1","roman2", 293.66,24);
        this.midiNotes.add(midiNote62);

        MidiNote midiNote63 = new MidiNote((byte)63, 28,43,"D#4","Eb4","dis’","es’","roman1","roman2", 311.13,24);
        this.midiNotes.add(midiNote63);

        //1 (Höchste Saite Gitarre, leer angeschlagen) 	e' 	329,63 Hz 	E4
        MidiNote midiNote64 = new MidiNote((byte)64, 29,44,"E4",null,"e’",null,"roman1","roman2", 329.63,25);
        this.midiNotes.add(midiNote64);

        MidiNote midiNote65 = new MidiNote((byte)65, 30,45,"F4",null,"f’",null,"roman1","roman2", 349.23,26);
        this.midiNotes.add(midiNote65);

        MidiNote midiNote66 = new MidiNote((byte)66, 31,46,"F#4","Gb4","fis’","ges’","roman1","roman2", 369.99,26);
        this.midiNotes.add(midiNote66);

        MidiNote midiNote67 = new MidiNote((byte)67, 32,47,"G4",null,"g’",null,"roman1","roman2", 392.00,27);
        this.midiNotes.add(midiNote67);

        MidiNote midiNote68 = new MidiNote((byte)68, 33,48,"G#4","Ab4","gis’","as’","roman1","roman2", 415.30, 27);
        this.midiNotes.add(midiNote68);

        MidiNote midiNote69 = new MidiNote((byte)69, 34,49,"A4 concert pitch",null,"a’ Kammerton",null,"roman1","roman2", 440.00, 28);
        this.midiNotes.add(midiNote69);

        MidiNote midiNote70 = new MidiNote((byte)70, 35,50,"A#4","Bb4","ais’","b’","roman1","roman2", 466.16,28);
        this.midiNotes.add(midiNote70);

        MidiNote midiNote71 = new MidiNote((byte)71, 36,51,"B4",null,"h’",null,"roman1","roman2", 493.88,29);
        this.midiNotes.add(midiNote71);

        MidiNote midiNote72 = new MidiNote((byte)72, 37,52,"C5",null,"c’’",null,"roman1","roman2", 523.25,30); //C5
        this.midiNotes.add(midiNote72);

        MidiNote midiNote73 = new MidiNote((byte)73, 38,53,"C#5","Db5","cis’’","des’’","roman1","roman2", 554.37,30);
        this.midiNotes.add(midiNote73);

        MidiNote midiNote74 = new MidiNote((byte)74, 39,54,"D5",null,"d’’",null,"roman1","roman2", 587.33, 31);
        this.midiNotes.add(midiNote74);

        MidiNote midiNote75 = new MidiNote((byte)75, 40,55,"D#5","Eb5","dis’’","es’’","roman1","roman2", 622.25, 31);
        this.midiNotes.add(midiNote75);

        // 12 Bund E-Gitarre hohe e-Saite 659,3 Hz
        MidiNote midiNote76 = new MidiNote((byte)76, 41,56,"E5",null,"e’’",null,"roman1","roman2", 659.26, 32);
        this.midiNotes.add(midiNote76);

        MidiNote midiNote77 = new MidiNote((byte)77, 42,57,"F5",null,"f’’",null,"roman1","roman2", 698.46, 33);
        this.midiNotes.add(midiNote77);

        MidiNote midiNote78 = new MidiNote((byte)78, 43,58,"F#5","Gb5","fis’’","ges’’","roman1","roman2", 739.99, 33);
        this.midiNotes.add(midiNote78);

        MidiNote midiNote79 = new MidiNote((byte)79, 44,59,"G5",null,"g’’",null,"roman1","roman2", 783.99,34);
        this.midiNotes.add(midiNote79);

        MidiNote midiNote80 = new MidiNote((byte)80, 45,60,"G#5","Ab5","gis’’","as’’","roman1","roman2", 830.61,34);
        this.midiNotes.add(midiNote80);

        MidiNote midiNote81 = new MidiNote((byte)81, 46,61,"A5",null,"a’’",null,"roman1","roman2", 880.00,35);
        this.midiNotes.add(midiNote81);

        MidiNote midiNote82 = new MidiNote((byte)82, 47,62,"A#5","Bb5","ais’’","b’’","roman1","roman2", 932.33,35);
        this.midiNotes.add(midiNote82);

        MidiNote midiNote83 = new MidiNote((byte)83, 48,63,"B5",null,"h’’",null,"roman1","roman2", 987.77,36);
        this.midiNotes.add(midiNote83);

        MidiNote midiNote84 = new MidiNote((byte)84, 49,64,"C6",null,"c’’’",null,"roman1","roman2", 1046.50,37);
        this.midiNotes.add(midiNote84);

        MidiNote midiNote85 = new MidiNote((byte)85, 50,65,"C#6","Db6","cis’’’","des’’’","roman1","roman2", 1108.73,37);
        this.midiNotes.add(midiNote85);

        // Ende e-Gitarre 22 Buende 1175 Hz
        MidiNote midiNote86 = new MidiNote((byte)86, 51,66,"D6",null,"d’’’",null,"roman1","roman2", 1174.66, 38);
        this.midiNotes.add(midiNote86);

        MidiNote midiNote87 = new MidiNote((byte)87, 52,67,"D#6","Eb6","dis’’’","es’’’","roman1","roman2", 1244.51,38);
        this.midiNotes.add(midiNote87);

        //das E einer Gitarre mit 24 Bünden bei 1319 Hz.
        MidiNote midiNote88 = new MidiNote((byte)88, 53,68,"E6",null,"e’’’",null,"roman1","roman2", 1318.51,39);
        this.midiNotes.add(midiNote88);

        MidiNote midiNote89 = new MidiNote((byte)89, 54,69,"F6",null,"f’’’",null,"roman1","roman2", 1396.91, 40);
        this.midiNotes.add(midiNote89);

        MidiNote midiNote90 = new MidiNote((byte)90, 55,70,"F#6","Gb6","fis’’’","ges’’’","roman1","roman2", 1479.98, 40);
        this.midiNotes.add(midiNote90);

        MidiNote midiNote91 = new MidiNote((byte)91, 56,71,"G6",null,"g’’’",null,"roman1","roman2", 1567.98,41);
        this.midiNotes.add(midiNote91);

        MidiNote midiNote92 = new MidiNote((byte)92, 57,72,"G#6","Ab6","gis’’’","as’’’","roman1","roman2", 1661.22,41);
        this.midiNotes.add(midiNote92);

        MidiNote midiNote93 = new MidiNote((byte)93, 58,73,"A6",null,"a’’’",null,"roman1","roman2", 1760.00,42);
        this.midiNotes.add(midiNote93);

        MidiNote midiNote94 = new MidiNote((byte)94, 59,74,"A#6","Bb6","ais’’’","b’’’","roman1","roman2", 1864.66,42);
        this.midiNotes.add(midiNote94);

        MidiNote midiNote95 = new MidiNote((byte)95, 60,75,"B6",null,"h’’’",null,"roman1","roman2", 1975.53,43);
        this.midiNotes.add(midiNote95);

        MidiNote midiNote96 = new MidiNote((byte)96, 61,76,"C7",null,"c’’’’",null,"roman1","roman2", 2093.00,44);
        this.midiNotes.add(midiNote96);

        MidiNote midiNote97 = new MidiNote((byte)97, 0,77,"C#7","Db7","cis’’’’","des’’’’","roman1","roman2", 2217.46, 44);
        this.midiNotes.add(midiNote97);

        MidiNote midiNote98 = new MidiNote((byte)98, 0,78,"D7",null,"d’’’’",null,"roman1","roman2", 2349.32, 45);
        this.midiNotes.add(midiNote98);

        MidiNote midiNote99 = new MidiNote((byte)99, 0,79,"D#7","Eb7","dis’’’’","es’’’’","roman1","roman2", 2489.02,45);
        this.midiNotes.add(midiNote99);

        // Maybe E Start of E-Bass with E
        MidiNote midiNote100 = new MidiNote((byte)100, 0,80,"E7",null,"e’’’’",null,"roman1","roman2", 2637.02,46);
        this.midiNotes.add(midiNote100);

        MidiNote midiNote101 = new MidiNote((byte)101, 0,81,"F7",null,"f’’’’",null,"roman1","roman2", 2793.83,47);
        this.midiNotes.add(midiNote101);

        MidiNote midiNote102 = new MidiNote((byte)102, 0,82,"F#7","Gb7","fis’’’’","ges’’’’","roman1","roman2", 2959.96,47);
        this.midiNotes.add(midiNote102);

        MidiNote midiNote103 = new MidiNote((byte)103, 0,83,"G7",null,"g’’’’",null,"roman1","roman2", 3135.96, 48);
        this.midiNotes.add(midiNote103);

        MidiNote midiNote104 = new MidiNote((byte)104, 0,84,"G#7","Ab7","gis’’’’","ges’’’’","roman1","roman2", 3322.44, 48);
        this.midiNotes.add(midiNote104);

        MidiNote midiNote105 = new MidiNote((byte)105, 0,85,"A7",null,"a’’’’",null,"roman1","roman2", 3520.00, 49);
        this.midiNotes.add(midiNote105);

        MidiNote midiNote106 = new MidiNote((byte)106, 0,86,"A#7","Bb7","ais’’’’","b’’’’","roman1","roman2", 3729.31, 49);
        this.midiNotes.add(midiNote106);

        // Start of Bass with H
        MidiNote midiNote107 = new MidiNote((byte)107, 0,87,"B7",null,"h’’’’",null,"roman1","roman2",3951.07, 50);
        this.midiNotes.add(midiNote107);

        //Ende Midi
        MidiNote midiNote108 = new MidiNote((byte)108, 0,0,"C8",null,"c’’’’’",null,"roman1","roman2", 4186.01, 51);
        this.midiNotes.add(midiNote108);
    }
}

