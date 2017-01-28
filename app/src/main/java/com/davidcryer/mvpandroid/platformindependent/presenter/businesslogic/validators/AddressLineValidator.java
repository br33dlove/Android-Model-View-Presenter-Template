package com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators;

public interface AddressLineValidator {
    ValidationResult isValid(final String addressLine, final boolean canBeEmpty);
}
