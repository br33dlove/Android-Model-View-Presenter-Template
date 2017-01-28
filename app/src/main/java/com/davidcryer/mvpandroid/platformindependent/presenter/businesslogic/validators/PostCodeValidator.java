package com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators;

public interface PostCodeValidator {
    ValidationResult isValid(final String postCode, final boolean canBeEmpty);
}
