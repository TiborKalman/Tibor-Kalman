package de.kalman.tibimeter;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;
import java.util.List;

public class MyMidiDevice {

    public MyMidiDevice(MyPanel myPanel) {
        init(myPanel);
    }

    private void init(MyPanel myPanel) {
        MidiDevice device;
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (int i = 0; i < infos.length; i++) {
            try {
                device = MidiSystem.getMidiDevice(infos[i]);
                List<Transmitter> transmitters = device.getTransmitters();
                for (int j = 0; j < transmitters.size(); j++) {
                    transmitters.get(j).setReceiver(
                            new MidiInputReceiver(device.getDeviceInfo().toString(), myPanel)
                    );
                }
                Transmitter trans = device.getTransmitter();
                trans.setReceiver(new MidiInputReceiver(device.getDeviceInfo().toString(), myPanel));
                device.open();
            } catch (MidiUnavailableException e) {
                System.out.println(" exception e " + e.getMessage());
            }
        }
    }
}

