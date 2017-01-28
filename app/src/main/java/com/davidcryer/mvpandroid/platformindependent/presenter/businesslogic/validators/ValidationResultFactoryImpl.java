package com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators;

public class ValidationResultFactoryImpl implements ValidationResultFactory {

    private ValidationResultFactoryImpl() {

    }

    public static ValidationResultFactory newInstance() {
        return new ValidationResultFactoryImpl();
    }

    @Override
    public ValidationResult okayResult() {
        return ValidationResultImpl.newInstance(true, "");
    }

    @Override
    public ValidationResult errorResult(String error) {
        return ValidationResultImpl.newInstance(false, error);
    }
}
