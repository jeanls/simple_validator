package io.github.jeanls.simplevalidator.filerules;

import io.github.jeanls.simplevalidator.RulePredicate;
import io.github.jeanls.simplevalidator.commonrules.Rule;
import io.github.jeanls.simplevalidator.utils.Bundle;
import io.github.jeanls.simplevalidator.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class FileRule<T extends File> extends Rule<T> {

    public FileRule<T> isNull(final String message) {
        final Predicate<T> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public FileRule<T> isNull() {
        final Predicate<T> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", null)));
        return this;
    }

    public FileRule<T> notNull(final String message) {
        final Predicate<T> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public FileRule<T> notNull() {
        final Predicate<T> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }

    public FileRule<T> hasFileExtension(final String fileExtension) {
        final Predicate<T> predicate = file -> {
            final Optional<String> extension = getExtension(file.getName());
            return extension.map(s -> s.equals(fileExtension)).orElse(false);
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasFileExtension", null, fileExtension)));
        return this;
    }

    public FileRule<T> hasFileExtensions(final List<String> fileExtensions) {
        final Predicate<T> predicate = file -> {
            final Optional<String> extension = getExtension(file.getName());
            return extension.filter(fileExtensions::contains).isPresent();
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasFileExtensions", null, Utils.listCharToMsg(fileExtensions))));
        return this;
    }

    public FileRule<T> hasSize(double value, final SizeUnit sizeUnit) {
        final Predicate<T> predicate = file -> {
            final long sizeInMb = getFileSizeInMb(file);
            return isOkFileSize(sizeInMb) && sizeInMb == convertFileSizeToBytes(sizeUnit, value);
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasSize", null, value)));
        return this;
    }

    public FileRule<T> sizeLessThan(double value, final SizeUnit sizeUnit) {
        final Predicate<T> predicate = file -> {
            final long sizeInMb = getFileSizeInMb(file);
            return isOkFileSize(sizeInMb) && sizeInMb < convertFileSizeToBytes(sizeUnit, value);
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("sizeLessThan", null, value)));
        return this;
    }

    public FileRule<T> sizeLessThanOrEquals(double value, final SizeUnit sizeUnit) {
        final Predicate<T> predicate = file -> {
            final long sizeInMb = getFileSizeInMb(file);
            return isOkFileSize(sizeInMb) && sizeInMb <= convertFileSizeToBytes(sizeUnit, value);
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("sizeLessThanOrEquals", null, value)));
        return this;
    }

    public FileRule<T> sizeGreaterThan(double value, final SizeUnit sizeUnit) {
        final Predicate<T> predicate = file -> {
            final long sizeInMb = getFileSizeInMb(file);
            return isOkFileSize(sizeInMb) && sizeInMb > convertFileSizeToBytes(sizeUnit, value);
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("sizeGreaterThan", null, value)));
        return this;
    }

    public FileRule<T> sizeGreaterThanOrEquals(double value, final SizeUnit sizeUnit) {
        final Predicate<T> predicate = file -> {
            final long sizeInMb = getFileSizeInMb(file);
            return isOkFileSize(sizeInMb) && sizeInMb >= convertFileSizeToBytes(sizeUnit, value);
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("sizeGreaterThanOrEquals", null, value)));
        return this;
    }


    private Optional<String> getExtension(final String fileName) {
        if (Objects.isNull(fileName)) {
            return Optional.empty();
        }

        final String[] split = fileName.split("\\.");

        if (split.length == 0) {
            return Optional.empty();
        }

        return Optional.ofNullable(split[split.length - 1]);
    }

    private boolean isOkFileSize(long fileSize) {
        return fileSize != -1;
    }

    private long getFileSizeInMb(final File file) {
        try {
            return Files.size(file.toPath());
        } catch (IOException e) {
            return -1;
        }
    }

    private long convertFileSizeToBytes(SizeUnit sizeUnit, double value) {
        return (long) (sizeUnit.getValueInBytes() * value);
    }
}
