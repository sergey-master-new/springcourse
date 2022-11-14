package org.example.springcourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private Music music;
    private Music music2;

    public MusicPlayer(@Qualifier("classicalMusic") Music music,
                       @Qualifier("rockMusic")Music music2){
        this.music = music;
        this.music2 = music2;
    }

    public String playMusic(){
        return "Playing: " + music.getSong() + ", " + music2.getSong();
    }
}
