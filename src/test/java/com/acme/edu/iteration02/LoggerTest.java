package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        Logger.resetBuffer();
        resetOut();
        captureSysout();
        Logger.isDecorated = false;
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    private String ls = System.lineSeparator();
    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws Exception {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        //endregion
        Logger.flush();
        //region then
        assertSysoutEquals(
                "str 1" + ls
                        + "3" + ls
                        + "str 2" + ls
                        + "0" + ls
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws Exception {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion
        Logger.flush();
        //region then
        assertSysoutEquals(
                "str 1" + ls
                        + "10" + ls
                        + Integer.MAX_VALUE + ls +
                        "str 2" + ls
                        + "0" + ls
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws Exception {
        //region when
        Logger.log("str 1");
        Logger.log((byte) 10);
        Logger.log((byte) Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion
        Logger.flush();
        //region then
        assertSysoutEquals(
                "str 1" + ls
                        + "10" + ls
                        + Byte.MAX_VALUE + ls +
                        "str 2" + ls
                        + "0" + ls
        );
        //endregion
    }
/*
    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)\n"
        );
        //endregion
    }

    */
}