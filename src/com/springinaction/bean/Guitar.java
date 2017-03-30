package com.springinaction.bean;

import com.springinaction.qualifier.StringedInstrument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Qualifier("stringed")
@StringedInstrument
@Component
public class Guitar implements Instrument {
  public void play() {
    System.out.println("Guitar : stringed Strum strum strum");
  }
}
