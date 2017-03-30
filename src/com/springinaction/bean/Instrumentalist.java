package com.springinaction.bean;

import com.springinaction.qualifier.StringedInstrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("eddie")
public class Instrumentalist implements Performer {
    @Autowired(required = false)
//    @Qualifier("stringed") // Qualifier 显示的把Autowired根据byType转换成byName装配
    @StringedInstrument // 使用自定义注解， Spring 会把所有可选择的乐器Bean缩小到只有被@StringedInstrument注解所标注的bean
    private Instrument instrument;
    @Value("Eruption")
    private String song;

    public Instrumentalist() {
    }

    public void perform() throws PerformanceException {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }

    // set方式注入
    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public String screamSong() {
        return song;
    }

//    // 注解，按照byType装配, 不仅对方法还可以对属性
//    @Autowired
//    public void setInstrument(Instrument instrument) {
//        this.instrument = instrument;
//    }

    public Instrument getInstrument() {
        return instrument;
    }
    public void hersYourInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
