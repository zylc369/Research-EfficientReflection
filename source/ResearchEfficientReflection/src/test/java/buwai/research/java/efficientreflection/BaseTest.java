package buwai.research.java.efficientreflection;

import org.slf4j.MDC;
import org.testng.annotations.BeforeTest;

/**
 * 测试基类
 *
 * @author 不歪
 * @version 创建时间：2019-04-29 16:32
 */
public abstract class BaseTest {

    protected int loopCount;

    @BeforeTest
    public void before() {
        this.loopCount = TestUnit.currentTestConfig.getLoopCount();
        MDC.put(Constants.KEY_LOOP_COUNT, String.valueOf(this.loopCount));
    }

}
