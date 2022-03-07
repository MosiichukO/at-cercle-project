package admin;

import org.apache.commons.lang.RandomStringUtils;


public class TestData extends Credentials {

    String random_string_30 = RandomStringUtils.randomAlphanumeric( 1 + (int) (Math.random() * 30));
    String [] spec_symbols = {"!", "@", "#", "$", "%", "^", "&", "'",
            "(", ")", "_", "+", "-", "=", "[", "]", "{", "}", ";", ":", "|", "<", ">", "?"};
    public String random_spec_symbol = spec_symbols[1 + (int) (Math.random() * (spec_symbols.length - 1))];

    // Messages (Error / Success)

    public final String NON_REGISTERED_CREDENTIALS_ERROR = "Invalid email or password.";
    public final String AUTHORIZATION_SUCCESS_MESSAGE = "Logged in successfully";
    public final String LOGOUT_SUCCESS_MESSAGE = "Signed out successfully.";
    public final String NAME_BLANK_ERROR_EDIT_DC = "Can not update Dry Cleaner: Name can't be blank.";
    public final String ADDRESS_BLANK_ERROR_EDIT_DC = "Can not update Dry Cleaner: Address can't be blank.";
    public final String NAME_ADDRESS_BLANK_ERROR_EDIT_DC = "Can not update Dry Cleaner: Name can't be blank, Address can't be blank.";
    public final String NAME_BLANK_ERROR_CREATE_DC = "Can not create Dry Cleaner: Validation failed: Name can't be blank.";
    public final String ADDRESS_BLANK_ERROR_CREATE_DC = "Can not create Dry Cleaner: Validation failed: Address can't be blank.";
    public final String NAME_ADDRESS_BLANK_ERROR_CREATE_DC = "Can not create Dry Cleaner: Validation failed: Name can't be blank, Address can't be blank.";
    public final String DRY_CLEANER_CREATED_SUCCESS_MESSAGE = "Dry Cleaner was successfully created.";
    public final String DRY_CLEANER_UPDATE_SUCCESS_MESSAGE = "Dry Cleaner was successfully updated.";
    public final String EMAIL_BLANK_ERROR_CREATE_USER = "Email can't be blank";
    public final String PASSWORD_BLANK_ERROR_CREATE_USER = "Password can't be blank";
    public final String PASSWORD_INVALID_LENGTH_ERROR_CREATE_USER = "Password is too short (minimum is 6 characters)";
    public final String DIFFERENT_PASSWORD_AND_CONFIRMATION_ERROR = "Password Confirmation doesn't match Password";
    public final String EMAIL_ALREADY_TAKEN_ERROR = "Email has already been taken";
    public final String EMAIL_WITHOUT_AMPERSAND_ERROR = "Please include an '@' in the email address. '%s' is missing an '@'.";
    public final String EMAIL_WITHOUT_PART_BEFORE_AMPERSAND_ERROR = "Please enter a part followed by '@'. '%s' is incomplete.";
    public final String EMAIL_WITHOUT_PART_AFTER_AMPERSAND_ERROR = "Please enter a part following '@'. '%s' is incomplete.";
    public final String EMAIL_DOT_RIGHT_AFTER_AMPERSAND_ERROR = "'.' is used at a wrong position in '%s'.";
    public final String EMAIL_SPEC_SYMBOL_AFTER_AMPERSAND_ERROR = "A part following '@' should not contain the symbol '%s'.";
    public final String BLANK_FORM_ERROR = "can't be blank";
    public final String TOO_SHORT_FORM_6_SYMBOLS_ERROR = "is too short (minimum is 6 characters)";
    public final String ALREADY_TAKEN_FORM_ERROR = "has already been taken";
    public final String PASSWORD_DO_NOT_MATCH_CONFIRMATION_FORM_ERROR = "doesn't match Password";

    // Page's titles

    public final String DRY_CLEANERS_PAGE_TITLE = "Dry Cleaners";
    public final String NEW_USER_PAGE_TITLE = "New User - Users";
    public final String USERS_PAGE_TITLE = "Users";
    public final String EDIT_USER_PAGE_TITLE = "%s - Users";

    // Dropdowns' options

    public final String STATUS_DROPDOWN_FIRST_OPTION = "Active";
    public final String STATUS_DROPDOWN_SECOND_OPTION = "Non active";

    // Validation

    public final int PASSWORD_MIN_LENGTH = 6;
    public final String RANDOM_VALID_EMAIL = random_string_30 + "@" + random_string_30 + "." + random_string_30;
    public final String RANDOM_EMAIL_WITHOUT_AMPERSAND = RandomStringUtils.randomAlphanumeric(1 + (int) (Math.random() * 30));
    public final String RANDOM_EMAIL_WITHOUT_PART_BEFORE_AMPERSAND = "@" + random_string_30;
    public final String RANDOM_EMAIL_WITHOUT_PART_AFTER_AMPERSAND = random_string_30 + "@";
    public final String RANDOM_EMAIL_WITH_DOT_RIGHT_AFTER_AMPERSAND = random_string_30 + "@." + random_string_30;
    public final String RANDOM_EMAIL_WITH_SPEC_SYMBOL_AFTER_AMPERSAND = random_string_30 + "@" + random_string_30 + random_spec_symbol + random_string_30;
    public final String RANDOM_PASSWORD_VALID_LENGTH = RandomStringUtils.randomAscii(PASSWORD_MIN_LENGTH + (int) (Math.random() * 30));
    public final String RANDOM_PASSWORD_INVALID_LENGTH = RandomStringUtils.randomAscii(1 + (int) (Math.random() * (PASSWORD_MIN_LENGTH - 1)));
    public final String ERROR_FIELD_BORDER_COLOR = "rgb(206, 69, 42)";

    // Test user's data

    public final String NON_REGISTERED_EMAIL = "qa@invalid.com";
    public final String NON_REGISTERED_PASSWORD = "invalid12";
    public final String TEST_VALID_EMAIL_DC = "qa@auto.dc";
    public final String TEST_VALID_EMAIL_SUPPORT = "qa@auto.support";
    public final String TEST_VALID_EMAIL_ADMIN = "qa@auto.admin";
    public final String TEST_VALID_PASSWORD = "qa_auto_password";
    public final String DRY_CLEANER_ADDRESS = "qa_auto_address";
    public final String DRY_CLEANER_NAME = "1-qa_auto_name";
    public final String DRY_CLEANER_ADDRESS_UPDATED = "qa_auto_address_updated";
    public final String DRY_CLEANER_NAME_UPDATED = "1-qa_auto_name_updated";
    public final String MEMBER_SINCE_START_DATE = "2022-02-17";
    public final String PART_OF_EMAIL_FOR_FILTERING = "@support";

}
