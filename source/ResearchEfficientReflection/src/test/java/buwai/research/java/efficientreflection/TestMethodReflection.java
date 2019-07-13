package buwai.research.java.efficientreflection;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 测试方法反射
 *
 * @author 不歪
 * @version 创建时间：2019-04-29 15:22
 */
@Slf4j
public class TestMethodReflection extends BaseTest {

    /**
     * 通过反射获取方法
     *
     * @throws Exception 可能抛出异常
     */
    @Test
    public void testDeclaredMethod() throws Exception {
        TestEntity testEntity = new TestEntity();
        Class<TestEntity> clazz = TestEntity.class;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            clazz.getDeclaredMethod("getName");
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

    /**
     * 正常调用方法
     */
    @Test
    public void testNormalInvoke() {
        TestEntity testEntity = new TestEntity();
        String name;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            name = testEntity.getName();
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

    /**
     * 通过反射调用方法
     *
     * @throws Exception 可能抛出异常
     */
    @Test
    public void testInvoke() throws Exception {
        TestEntity testEntity = new TestEntity();
        Class<TestEntity> clazz = TestEntity.class;
        Method method = clazz.getDeclaredMethod("getName");
        Object object;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            object = method.invoke(testEntity);
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

    /**
     * 通过反射调用方法
     *
     * @throws Exception 可能抛出异常
     */
    @Test
    public void testInvokeWithAccessible() throws Exception {
        TestEntity testEntity = new TestEntity();
        Class<TestEntity> clazz = TestEntity.class;
        Method method = clazz.getDeclaredMethod("getName");
        method.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            method.invoke(testEntity);
        }
        long end = System.currentTimeMillis();
        long sum = end - start;
        log.info("总耗时：{}ms", sum);
    }

}
