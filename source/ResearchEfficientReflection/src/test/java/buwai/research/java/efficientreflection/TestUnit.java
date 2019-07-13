package buwai.research.java.efficientreflection;

import lombok.extern.slf4j.Slf4j;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 *
 * @author 不歪
 * @version 创建时间：2019-04-29 16:29
 */
@Slf4j
public class TestUnit {

    private static final List<TestConfig> TEST_CONFIG_LIST = new ArrayList<>();
    public volatile static TestConfig currentTestConfig;

    static {
        TEST_CONFIG_LIST.add(new TestConfig(5000000));
        TEST_CONFIG_LIST.add(new TestConfig(10000000));
        TEST_CONFIG_LIST.add(new TestConfig(50000000));
//        TEST_CONFIG_LIST.add(new TestConfig(10));
//        TEST_CONFIG_LIST.add(new TestConfig(20));
        currentTestConfig = TEST_CONFIG_LIST.get(0);
    }

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        Class[] classes = {TestClassReflection.class, TestFieldReflection.class, TestMethodReflection.class, TestNewInstanceReflection.class};
        testNG.setTestClasses(classes);
        for (TestConfig testConfig : TEST_CONFIG_LIST) {
            currentTestConfig = testConfig;
            testNG.run();
        }
    }

}
