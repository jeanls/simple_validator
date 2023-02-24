package io.github.jeanls.simplevalidator.filerules;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileRuleTest {

    private final FileRule<File> fileRule = new FileRule<>();
    private final String MESSAGE = "hello world";

    @Test
    void isNullOkTest() {
        boolean result = fileRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);

        result = fileRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = fileRule.isNull().getRules().get(0).getPredicate().test(getMockFile());
        assertFalse(result);

        result = fileRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(getMockFile());
        assertFalse(result);
    }

    @Test
    void notNullOkTest() {
        boolean result = fileRule.notNull().getRules().get(0).getPredicate().test(getMockFile());
        assertTrue(result);

        result = fileRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(getMockFile());
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = fileRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = fileRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void hasFileExtensionOkTest() {
        boolean result = fileRule.hasFileExtension("txt").getRules().get(0).getPredicate().test(getMockFile());
        assertTrue(result);

        result = fileRule.hasFileExtension("txt", MESSAGE).getRules().get(1).getPredicate().test(getMockFile());
        assertTrue(result);
    }

    @Test
    void hasFileExtensionFailTest() {
        boolean result = fileRule.hasFileExtension("png").getRules().get(0).getPredicate().test(getMockFile());
        assertFalse(result);

        result = fileRule.hasFileExtension("png", MESSAGE).getRules().get(1).getPredicate().test(getMockFile());
        assertFalse(result);
    }

//    @Test
//    void hasSizeOkTest() {
//        boolean result = fileRule.hasSize(15, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
//        assertTrue(result);
//
//        result = fileRule.hasSize(15, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
//        assertTrue(result);
//    }

    @Test
    void hasSizeFailTest() {
        boolean result = fileRule.hasSize(1, SizeUnit.MB).getRules().get(0).getPredicate().test(getFile());
        assertFalse(result);

        result = fileRule.hasSize(1, SizeUnit.MB, MESSAGE).getRules().get(1).getPredicate().test(getFile());
        assertFalse(result);
    }

    @Test
    void hasFileExtensionsOkTest() {
        boolean result = fileRule.hasFileExtensions(List.of("txt", "jpg")).getRules().get(0).getPredicate().test(getMockFile());
        assertTrue(result);

        result = fileRule.hasFileExtensions(List.of("txt", "jpg"), MESSAGE).getRules().get(1).getPredicate().test(getMockFile());
        assertTrue(result);
    }

    @Test
    void hasFileExtensionsFailTest() {
        boolean result = fileRule.hasFileExtensions(List.of("png", "jpg")).getRules().get(0).getPredicate().test(getMockFile());
        assertFalse(result);

        result = fileRule.hasFileExtensions(List.of("png", "jpg"), MESSAGE).getRules().get(1).getPredicate().test(getMockFile());
        assertFalse(result);
    }

    @Test
    void sizeLessThanOkTest() {
        boolean result = fileRule.sizeLessThan(16, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
        assertTrue(result);

        result = fileRule.sizeLessThan(16, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
        assertTrue(result);
    }

//    @Test
//    void sizeLessThanFailTest() {
//        boolean result = fileRule.sizeLessThan(15, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
//        assertFalse(result);
//
//        result = fileRule.sizeLessThan(15, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
//        assertFalse(result);
//    }

    @Test
    void sizeLessThanOrEqualsOkTest() {
        boolean result = fileRule.sizeLessThanOrEquals(15, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
        assertTrue(result);

        result = fileRule.sizeLessThanOrEquals(15, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
        assertTrue(result);
    }

//    @Test
//    void sizeLessThanOrEqualsFailTest() {
//        boolean result = fileRule.sizeLessThanOrEquals(14, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
//        assertFalse(result);
//
//        result = fileRule.sizeLessThanOrEquals(14, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
//        assertFalse(result);
//    }

//    @Test
//    void sizeGreaterThanOkTest() {
//        boolean result = fileRule.sizeGreaterThan(14, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
//        assertTrue(result);
//
//        result = fileRule.sizeGreaterThan(14, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
//        assertTrue(result);
//    }

    @Test
    void sizeGreaterThanFailTest() {
        boolean result = fileRule.sizeGreaterThan(15, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
        assertFalse(result);

        result = fileRule.sizeGreaterThan(15, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
        assertFalse(result);
    }

//    @Test
//    void sizeGreaterThanOrEqualsOkTest() {
//        boolean result = fileRule.sizeGreaterThanOrEquals(15, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
//        assertTrue(result);
//
//        result = fileRule.sizeGreaterThanOrEquals(15, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
//        assertTrue(result);
//    }

    @Test
    void sizeGreaterThanOrEqualsFailTest() {
        boolean result = fileRule.sizeGreaterThanOrEquals(16, SizeUnit.B).getRules().get(0).getPredicate().test(getFile());
        assertFalse(result);

        result = fileRule.sizeGreaterThanOrEquals(16, SizeUnit.B, MESSAGE).getRules().get(1).getPredicate().test(getFile());
        assertFalse(result);
    }

    private File getMockFile() {
        File file = Mockito.mock(File.class);
        Mockito.when(file.getName())
                .thenReturn("test.txt");
        return file;
    }

    private File getFile() {
        return new File("src/test/resources/test_file.txt");
    }
}
