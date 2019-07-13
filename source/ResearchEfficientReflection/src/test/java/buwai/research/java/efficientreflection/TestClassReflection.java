package buwai.research.java.efficientreflection;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * 测试类反射
 *
 * @author 不歪
 * @version 创建时间：2019-04-29 14:52
 */
@Slf4j
public class TestClassReflection extends BaseTest {

    /**
     * 测试获取类
     */
    @Test
    public void testClassGet() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            Class<TestEntity> clazz = TestEntity.class;
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

    /**
     * 测试Class.forName
     *
     * @throws ClassNotFoundException 可能抛出该异常
     */
    @Test
    public void testClassForName() throws ClassNotFoundException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            Class clazz = Class.forName(Constants.CLASS_NAME);
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

}
