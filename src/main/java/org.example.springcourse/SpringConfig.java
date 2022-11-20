package org.example.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
// вместо <context:property-placeholder location="classpath:musicPlayer.properties"/>
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public JazzMusic jazzMusic(){
        return new JazzMusic();
    }

    @Bean
    public List<Music> musics(){
        List<Music> musicList = new ArrayList<>();
        musicList.add(classicalMusic());
        musicList.add(rockMusic());
        musicList.add(jazzMusic());
        return musicList;
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musics());
    }

    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }


}
