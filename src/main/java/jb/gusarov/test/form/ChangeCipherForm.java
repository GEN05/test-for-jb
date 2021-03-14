package jb.gusarov.test.form;

import javax.validation.constraints.NotNull;

public class ChangeCipherForm {
    @NotNull
    private long cipher;

    @NotNull
    private long newCipher;

    public long getCipher() {
        return cipher;
    }

    public void setCipher(long cipher) {
        this.cipher = cipher;
    }

    public long getNewCipher() {
        return newCipher;
    }

    public void setNewCipher(long newCipher) {
        this.newCipher = newCipher;
    }
}
