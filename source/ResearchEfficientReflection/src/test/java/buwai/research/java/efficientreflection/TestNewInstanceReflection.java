package buwai.research.java.efficientreflection;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * 测试反射创建对象
 *
 * @author 不歪
 * @version 创建时间：2019-04-29 15:27
 */
@Slf4j
public class TestNewInstanceReflection extends BaseTest {

    /**
     * 测试 new object
     */
    @Test
    public void testNew() {
        TestEntity testEntity;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            testEntity = new TestEntity();
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

    /**
     * 测试Class.forName().newInstance()
     *
     * @throws Exception 可能抛出异常
     */
    @Test
    public void testNewInstance1() throws Exception {
        Object object;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            object = Class.forName(Constants.CLASS_NAME).newInstance();
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

    /**
     * 测试newInstance()
     *
     * @throws Exception 可能抛出异常
     */
    @Test
    public void testNewInstance2() throws Exception {
        Class<TestEntity> clazz = (Class<TestEntity>) Class.forName(Constants.CLASS_NAME);
        TestEntity testEntity;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            testEntity = clazz.newInstance();
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

}
