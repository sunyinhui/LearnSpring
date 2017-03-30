import com.springinaction.aop.MindReader;
import com.springinaction.aop.Thinker;
import com.springinaction.aop.Volunteer;
import com.springinaction.bean.Instrument;
import com.springinaction.bean.PerformanceException;
import com.springinaction.bean.Performer;
import com.springinaction.knights.BraveKnight;
import com.springinaction.knights.Knight;
import com.springinaction.knights.Quest;
import com.springinaction.knights.SlayDragonQuest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sunyinhui on 2017/3/23.
 */

public class KnightMain {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext context = new ClassPathXmlApplicationContext("configbean.xml");
        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();

        /**
         *通常的写法
         */
//        Quest quest = new SlayDragonQuest();
//        Knight knight1 = new BraveKnight(quest);
//        knight1.embarkOnQuest();
//
//        // 杂技师
//        Performer performer = (Performer) context.getBean("duke");
//        performer.perform();
//
//        // 会朗读的杂技师
//        Performer poeticJuggler = (Performer) context.getBean("poeticDuke");
//        poeticJuggler.perform();

        Performer instrumentList = (Performer) context.getBean("eddie");
        instrumentList.perform();


        Thinker volunteer = (Thinker) context.getBean("volunteer");
        volunteer.thinkOfSomething("i am thinking ! ");

        MindReader mindReader = (MindReader) context.getBean("magician");
        mindReader.getThoughts();

    }
}
