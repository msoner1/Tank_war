package Manager;

import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.util.HashMap;

/**
 * @author : ForeignGuyMike
 * @version : 1.0.0
 * @since : ?
 *
 * Oyun içi ses efektleri ve müzikleri yöneten sýnýftýr.
 */

public class JukeBox {

    private static HashMap<String, Clip> clips;
    private static int gap;

    // Creates new clips HashMap.
    public static void init() {
        clips = new HashMap<String, Clip>();
        gap = 0;
    }

    // Loads up audio located at path "s" and stores
    // it in the HashMap with key "n".
    public static void load(String s, String n) {
        if(clips.get(n) != null) return;
        Clip clip;
        try {
            AudioInputStream ais =
                    AudioSystem.getAudioInputStream(new FileInputStream(s));
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
            clips.put(n, clip);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void play(String s) {
        play(s, gap);
    }

    public static void play(String s, int i) {
        Clip c = clips.get(s);
        if(c == null) return;
        c.setFramePosition(i);
        c.start();
    }

    public static void stop(String s) {
        if(clips.get(s) == null) return;
        if(clips.get(s).isRunning()){
            clips.get(s).stop();
        }
    }

    public static void loop(String s) {
        loop(s, gap, gap, clips.get(s).getFrameLength() - 1);
    }
    public static void loop(String s, int frame, int start, int end) {
        Clip c = clips.get(s);
        if(c == null) return;
        if(c.isRunning()) c.stop();
        c.setLoopPoints(start, end);
        c.setFramePosition(frame);
        c.loop(Clip.LOOP_CONTINUOUSLY);
    }


    public static void setVolume(String s, float f) {
        Clip c = clips.get(s);
        if(c == null) return;
        FloatControl vol = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
        vol.setValue(f);
    }

    public static boolean isPlaying(String s) {
        Clip c = clips.get(s);
        if(c == null) return false;
        return c.isRunning();
    }
}
