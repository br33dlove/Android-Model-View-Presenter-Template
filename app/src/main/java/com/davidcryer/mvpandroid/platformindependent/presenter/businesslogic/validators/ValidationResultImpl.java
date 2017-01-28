package com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators;

public class ValidationResultImpl implements ValidationResult {
    private final boolean passed;
    private final String error;

    private ValidationResultImpl(boolean passed, String error) {
        this.passed = passed;
        this.error = error;
    }

    public static ValidationResult newInstance(boolean passed, String error) {
        return new ValidationResultImpl(passed, error);
    }

    @Override
    public boolean passed() {
        return passed;
    }

    @Override
    public String error() {
        return error;
    }
}
