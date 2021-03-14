package jb.gusarov.test.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserCredentials {
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    @Pattern(regexp = "[a-z]+", message = "Expected lowercase Latin letters")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    @Pattern(regexp = "[a-z]+", message = "Expected lowercase Latin letters")
    private String surname;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 60)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
