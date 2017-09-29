package reporting;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

public class CustomAssert extends Assertion {
	
	private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();

    public int getErrorsCount() {
        return m_errors.size();
    }

    @Override
    protected void doAssert(IAssert<?> a) {
        onBeforeAssert(a);
        try {
            a.doAssert();
            onAssertSuccess(a);
        } catch (AssertionError ex) {
            onAssertFailure(a, ex);
            //Attachments.attachScreenshot(a.getMessage());
            m_errors.put(ex, a);
        } finally {
            onAfterAssert(a);
        }
    }

    public void assertAll() {
        if (!m_errors.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:");
            boolean first = true;
            for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(";");
                }
                sb.append("\n\t");
                sb.append(ae.getKey().getMessage());
            }
            throw new AssertionError(sb.toString());
        }
    }

    public void softAssertTrue(final boolean condition, final String userMessage) {
        final String message = userMessage + getStackInfo(Thread.currentThread().getStackTrace()[2]);
        doAssert(new SimpleAssert<Boolean>(condition, Boolean.TRUE, message) {
            @Override
            public void doAssert() {
                hardAssertTrue(condition, message);
            }
        });
    }
    public void softAssertEqualExpectedActual(final String expected, final String actual, final String userMessage) {
        boolean condition = String.valueOf(expected).equals(String.valueOf(actual));
        final String message = "Expected '" + expected + "' but got '" + actual + "' (" + userMessage + ")"
                + getStackInfo(Thread.currentThread().getStackTrace()[2]);
        doAssert(new SimpleAssert<Boolean>(condition, Boolean.TRUE, message) {
            @Override
            public void doAssert() {
                hardAssertTrue(condition, message);
            }
        });
    }

    public void softAssertContains(final String expected, final String actual, final String userMessage) {
        boolean condition = expected.contains(actual);
        final String message = "Expected: '" + expected + "' to contain '" + actual + "' (" + userMessage + ")"
                + getStackInfo(Thread.currentThread().getStackTrace()[2]);
        doAssert(new SimpleAssert<Boolean>(condition, Boolean.TRUE, message) {
            @Override
            public void doAssert() {
                hardAssertTrue(condition, message);
            }
        });
    }
    public static void hardAssertTrue(boolean condition, String message) {
        if (!condition) {
            org.testng.Assert.fail(message);
        }
    }

    public static void hardAssertFalse(boolean condition, String message) {
        if (condition) {
            org.testng.Assert.fail(message);
        }
    }

    abstract private static class SimpleAssert<T> implements IAssert<T> {
        private final T actual;
        private final T expected;
        private final String m_message;

        public SimpleAssert(T actual, T expected, String message) {
            this.actual = actual;
            this.expected = expected;
            m_message = message;
        }

        @Override
        public String getMessage() {
            return m_message;
        }

        @Override
        public T getActual() {
            return actual;
        }

        @Override
        public T getExpected() {
            return expected;
        }

        @Override
        abstract public void doAssert();
    }

    private String getStackInfo(StackTraceElement stack) {
        return " [" + stack.getFileName() + ":" + stack.getLineNumber() + "]";
    }

}
