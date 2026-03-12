package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's gamertag in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidGamertag(String)}
 */
public class Gamertag {

    public static final String MESSAGE_CONSTRAINTS =
            "Gamertags should only contain, letters, numbers and underscore, and be at most 50 characters.";
    public static final String VALIDATION_REGEX = "[A-Za-z0-9_]{1,50}";

    public final String value;

    /**
     * Constructs a {@code Gamertag}.
     *
     * @param gamertag A valid gamertag.
     */
    public Gamertag(String gamertag) {
        requireNonNull(gamertag);
        checkArgument(isValidGamertag(gamertag), MESSAGE_CONSTRAINTS);
        value = gamertag;
    }

    /**
     * Returns true if a given string is a valid gamertag.
     */
    public static boolean isValidGamertag(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Gamertag)) {
            return false;
        }

        Gamertag otherGamertag = (Gamertag) other;
        return value.equals(otherGamertag.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
