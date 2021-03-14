package jb.gusarov.test.form;

import javax.validation.constraints.NotNull;

public class UserBookForm {
    @NotNull
    private long cipher;

    public long getCipher() {
        return cipher;
    }

    public void setCipher(long cipher) {
        this.cipher = cipher;
    }
}
