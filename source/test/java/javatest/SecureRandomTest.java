package javatest;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/*
 * References:
 *
 * - https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html
 * - https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SecureRandomTest {
    @BeforeClass
    public static void setup() {
        printSystemProperty("os.name");
        printSystemProperty("os.arch");
        printSystemProperty("os.version");
        printSystemProperty("java.version");
        printSystemProperty("java.runtime.version");
        printSystemProperty("java.vm.name");
        printSystemProperty("java.vm.version");
    }

    private static void printSystemProperty(String aPropertyName) {
        System.out.printf("%s=%s%n", aPropertyName, System.getProperty(aPropertyName));
    }

    private void test00(String anAlgorithmName) {
        String aConstructionMethod = "SecureRandom.getInstance(\"" + anAlgorithmName + "\")";
        try {
            test0(aConstructionMethod, SecureRandom.getInstance(anAlgorithmName));
        } catch(NoSuchAlgorithmException e) {
            System.out.printf("method = `%s` => algorithm = %s; failed to construct, cause = %s%n", aConstructionMethod, anAlgorithmName, e.toString());
        }
    }

    private void test0(String aConstructionMethod, SecureRandom aSecureRandom) {
        long s = System.currentTimeMillis();
        aSecureRandom.nextInt();
        long e = System.currentTimeMillis();
        long d = e - s;
        System.out.printf("method = `%s` => algorithm = %s, duration of `nextInt` = %d (ms)%n", aConstructionMethod, aSecureRandom.getAlgorithm(), d);
    }

    @Test
    public void test1_default() {
        test0("new SecureRandom()", new SecureRandom());
    }


    @Test
    public void test2_strong() {
        String aConstructionMethod = "SecureRandom.getInstanceStrong()";
        try {
            test0(aConstructionMethod, SecureRandom.getInstanceStrong());
        } catch (NoSuchAlgorithmException e) {
            System.out.printf("method = `%s` => failed to construct, cause = %s%n", aConstructionMethod, e.toString());
        }
    }

    @Test
    public void test3_NativePRNG() {
        test00("NativePRNG");
    }

    @Test
    public void test4_NativePRNGNonBlocking() {
        test00("NativePRNGNonBlocking");
    }

    @Test
    public void test5_Windows_PRNG() {
        test00("Windows-PRNG");
    }
}
