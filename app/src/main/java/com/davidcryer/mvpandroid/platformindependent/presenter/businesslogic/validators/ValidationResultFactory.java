package com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators;

public interface ValidationResultFactory {
    ValidationResult okayResult();
    ValidationResult errorResult(final String error);
}
