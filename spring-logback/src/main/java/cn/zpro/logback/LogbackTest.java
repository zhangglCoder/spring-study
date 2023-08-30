package cn.zpro.logback;


import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author guolong.zhang
 * @date 2023/08/08 11:31
 **/
public class LogbackTest {


    public static void main(String[] args)  {
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger)
                LoggerFactory.getLogger(LogbackTest.class);

        //TRACE < DEBUG < INFO <  WARN < ERROR
        //root = INFO
//        logger.info("info-3434213");
        logger.debug("debug-123123");
//        logger.trace("trace-123123");
//        logger.warn("warn-123123");
        logger.error("error-123123");


    }
}
