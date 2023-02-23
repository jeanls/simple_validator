package io.github.jeanls.simplevalidator.filerules;

public enum SizeUnit {

    MB(1048576L), KB(1024L), GB(1073741824L), B(1L);

    private final long valueInBytes;

    SizeUnit(long valueInBytes) {
        this.valueInBytes = valueInBytes;
    }

    public long getValueInBytes() {
        return valueInBytes;
    }
}
